package com.baidu.sapi2;

import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.QrPcLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrLoginStatusCheckResult;
import com.baidu.sapi2.result.QrPcLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.callback.QrAppLoginCallBack;
import com.baidu.sapi2.shell.callback.QrPCLoginCallBack;
import com.baidu.sapi2.shell.response.QrAppLoginResponse;
import com.baidu.sapi2.shell.response.QrPCLoginResponse;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.Collections;
import java.util.HashMap;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class QrCodeService extends AbstractService {
    private static QrCodeService b;
    private boolean a;

    public static synchronized QrCodeService getInstance(SapiConfiguration sapiConfiguration, String str) {
        QrCodeService qrCodeService;
        synchronized (QrCodeService.class) {
            if (b == null) {
                b = new QrCodeService(sapiConfiguration, str);
            }
            qrCodeService = b;
        }
        return qrCodeService;
    }

    private QrCodeService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
        this.a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qrPCLogin(final QrPCLoginCallBack qrPCLoginCallBack, final String str, final String str2, final String str3, final String str4, final String str5) {
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            if (qrPCLoginCallBack != null) {
                qrPCLoginCallBack.onFinish();
                qrPCLoginCallBack.onNetworkFailed();
            }
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (qrPCLoginCallBack != null) {
                qrPCLoginCallBack.onFinish();
                qrPCLoginCallBack.onQrCodeInvalid();
            }
        } else if (TextUtils.isEmpty(str3) && QrLoginAction.LOGIN.getName().equals(str2)) {
            if (qrPCLoginCallBack != null) {
                qrPCLoginCallBack.onFinish();
                qrPCLoginCallBack.onBdussInvalid();
            }
        } else {
            this.asyncHttpClient = new AsyncHttpClient();
            this.asyncHttpClient.setUserAgent(getUaInfo());
            HashMap hashMap = new HashMap();
            hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
            hashMap.put(IntentConfig.CMD, str2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("bduss", str3);
            }
            if (!TextUtils.isEmpty(str5)) {
                hashMap.put(ISapiAccount.SAPI_ACCOUNT_PTOKEN, str5);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, str4);
            }
            if (!TextUtils.isEmpty(this.configuration.clientId)) {
                hashMap.put("clientid", this.configuration.clientId);
            }
            if (!TextUtils.isEmpty(this.configuration.clientIp)) {
                hashMap.put("clientip", this.configuration.clientIp);
            }
            hashMap.put("tpl", this.configuration.tpl);
            hashMap.put("appid", this.configuration.appId);
            hashMap.put("sig", calculateSig(hashMap, this.configuration.appSignKey));
            this.asyncHttpClient.post(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.QR_PC_LOGIN_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.1
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str6) {
                    super.onSuccess(i, str6);
                    QrCodeService.this.domainRetry.reset();
                    QrCodeService.this.a(qrPCLoginCallBack, str6);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str6) {
                    super.onFailure(th, str6);
                    if (!QrCodeService.this.domainRetry.isShouldRetry()) {
                        QrCodeService.this.domainRetry.reset();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            qrPCLoginCallBack.onSystemError(-203);
                            return;
                        }
                        QrCodeService.this.a(qrPCLoginCallBack, str6);
                        return;
                    }
                    QrCodeService.this.domainRetry.retry();
                    QrCodeService.this.qrPCLogin(qrPCLoginCallBack, str, str2, str3, str4, str5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qrPcLogin(final QrPcLoginCallback qrPcLoginCallback, final String str, final String str2, final String str3) {
        if (qrPcLoginCallback == null) {
            throw new IllegalArgumentException(QrPcLoginCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("sign can't be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("cmd can't be empty");
        }
        if (TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        final QrPcLoginResult qrPcLoginResult = new QrPcLoginResult();
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            qrPcLoginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            qrPcLoginCallback.onFailure(qrPcLoginResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_PC_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
            return;
        }
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
        hashMap.put(IntentConfig.CMD, str2);
        hashMap.put("bduss", str3);
        if (!TextUtils.isEmpty(this.configuration.clientId)) {
            hashMap.put("clientid", this.configuration.clientId);
        }
        if (!TextUtils.isEmpty(this.configuration.clientIp)) {
            hashMap.put("clientip", this.configuration.clientIp);
        }
        hashMap.put("tpl", this.configuration.tpl);
        hashMap.put("appid", this.configuration.appId);
        hashMap.put("sig", calculateSig(hashMap, this.configuration.appSignKey));
        this.asyncHttpClient.post(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.QR_PC_LOGIN_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.2
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                qrPcLoginCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_PC_LOGIN, IEventCenterService.EventResult.PHASE.START);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                qrPcLoginCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_PC_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str4) {
                if (!QrCodeService.this.domainRetry.isShouldRetry()) {
                    QrCodeService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        qrPcLoginResult.setResultCode(-203);
                        qrPcLoginCallback.onFailure(qrPcLoginResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_PC_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    qrPcLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    qrPcLoginCallback.onFailure(qrPcLoginResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_PC_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                QrCodeService.this.domainRetry.retry();
                QrCodeService.this.qrPcLogin(qrPcLoginCallback, str, str2, str3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str4) {
                QrCodeService.this.domainRetry.reset();
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    qrPcLoginResult.setResultCode(Integer.parseInt(jSONObject.optString("errno")));
                    switch (qrPcLoginResult.getResultCode()) {
                        case 0:
                            JSONObject optJSONObject = jSONObject.optJSONObject("local");
                            if (optJSONObject != null) {
                                qrPcLoginResult.country = optJSONObject.optString("country");
                                qrPcLoginResult.province = optJSONObject.optString("provice");
                                qrPcLoginResult.city = optJSONObject.optString("city");
                            }
                            qrPcLoginCallback.onSuccess(qrPcLoginResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_PC_LOGIN, IEventCenterService.EventResult.PHASE.SUCCESS);
                            return;
                        case 2:
                        case 160102:
                            qrPcLoginCallback.onBdussExpired(qrPcLoginResult);
                            return;
                        case 3:
                            qrPcLoginCallback.onIncompleteUser(qrPcLoginResult);
                            return;
                        default:
                            qrPcLoginCallback.onFailure(qrPcLoginResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_PC_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
                    }
                } catch (Throwable th) {
                    qrPcLoginCallback.onFailure(qrPcLoginResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_PC_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                    Log.e(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qrAppLogin(final QrAppLoginCallBack qrAppLoginCallBack, final String str, final String str2) {
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            if (qrAppLoginCallBack != null) {
                qrAppLoginCallBack.onFinish();
                qrAppLoginCallBack.onNetworkFailed();
            }
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (qrAppLoginCallBack != null) {
                qrAppLoginCallBack.onFinish();
                qrAppLoginCallBack.onQrCodeInvalid();
            }
        } else {
            this.asyncHttpClient = new AsyncHttpClient();
            this.asyncHttpClient.setUserAgent(getUaInfo());
            HashMap hashMap = new HashMap();
            hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
            hashMap.put(IntentConfig.CMD, str2);
            if (!TextUtils.isEmpty(this.configuration.clientId)) {
                hashMap.put("clientid", this.configuration.clientId);
            }
            if (!TextUtils.isEmpty(this.configuration.clientIp)) {
                hashMap.put("clientip", this.configuration.clientIp);
            }
            hashMap.put("tpl", this.configuration.tpl);
            hashMap.put("appid", this.configuration.appId);
            hashMap.put("sig", calculateSig(hashMap, this.configuration.appSignKey));
            this.asyncHttpClient.post(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.QR_APP_LOGIN_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.3
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str3) {
                    super.onSuccess(i, str3);
                    QrCodeService.this.domainRetry.reset();
                    QrCodeService.this.a(i, qrAppLoginCallBack, str3);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str3) {
                    super.onFailure(th, str3);
                    if (!QrCodeService.this.domainRetry.isShouldRetry()) {
                        QrCodeService.this.domainRetry.reset();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            qrAppLoginCallBack.onSystemError(-203);
                            return;
                        }
                        QrCodeService.this.a(QrCodeService.this.a(str3), qrAppLoginCallBack, str3);
                        return;
                    }
                    QrCodeService.this.domainRetry.retry();
                    QrCodeService.this.qrAppLogin(qrAppLoginCallBack, str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qrAppLogin(final SapiCallback<QrAppLoginResult> sapiCallback, final String str, final String str2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("sign can't be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("cmd can't be empty");
        }
        final QrAppLoginResult qrAppLoginResult = new QrAppLoginResult();
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            qrAppLoginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(qrAppLoginResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
            return;
        }
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
        hashMap.put(IntentConfig.CMD, str2);
        if (!TextUtils.isEmpty(this.configuration.clientId)) {
            hashMap.put("clientid", this.configuration.clientId);
        }
        if (!TextUtils.isEmpty(this.configuration.clientIp)) {
            hashMap.put("clientip", this.configuration.clientIp);
        }
        hashMap.put("tpl", this.configuration.tpl);
        hashMap.put("appid", this.configuration.appId);
        hashMap.put("sig", calculateSig(hashMap, this.configuration.appSignKey));
        this.asyncHttpClient.post(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.QR_APP_LOGIN_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.4
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                sapiCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.START);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                sapiCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                if (!QrCodeService.this.domainRetry.isShouldRetry()) {
                    QrCodeService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        qrAppLoginResult.setResultCode(-203);
                        sapiCallback.onFailure(qrAppLoginResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                    }
                    qrAppLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sapiCallback.onFailure(qrAppLoginResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                QrCodeService.this.domainRetry.retry();
                QrCodeService.this.qrAppLogin(sapiCallback, str, str2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str3) {
                QrCodeService.this.domainRetry.reset();
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    qrAppLoginResult.setResultCode(parseInt);
                    switch (parseInt) {
                        case 0:
                            JSONObject optJSONObject = jSONObject.optJSONObject("local");
                            if (optJSONObject != null) {
                                qrAppLoginResult.country = optJSONObject.optString("country");
                                qrAppLoginResult.province = optJSONObject.optString("provice");
                                qrAppLoginResult.city = optJSONObject.optString("city");
                            }
                            SapiAccount parseAccount = QrCodeService.this.parseAccount(jSONObject);
                            parseAccount.extra = SapiAccount.DispersionCertification.fromJSONObject(jSONObject).toJSONObject().toString();
                            ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                            sapiCallback.onSuccess(qrAppLoginResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.SUCCESS);
                            return;
                        default:
                            sapiCallback.onFailure(qrAppLoginResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
                    }
                } catch (Throwable th) {
                    sapiCallback.onFailure(qrAppLoginResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                    Log.e(th);
                }
            }
        });
    }

    void a(int i, QrAppLoginCallBack qrAppLoginCallBack, String str) {
        if (qrAppLoginCallBack != null) {
            qrAppLoginCallBack.onFinish();
        }
        if (str != null) {
            QrAppLoginResponse qrAppLoginResponse = new QrAppLoginResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                qrAppLoginResponse.errorCode = parseInt;
                JSONObject optJSONObject = jSONObject.optJSONObject("local");
                if (optJSONObject != null) {
                    qrAppLoginResponse.country = optJSONObject.optString("country");
                    qrAppLoginResponse.province = optJSONObject.optString("provice");
                    qrAppLoginResponse.city = optJSONObject.optString("city");
                }
                if (!TextUtils.isEmpty(jSONObject.optString("errno")) && jSONObject.optString("errno").equals("0")) {
                    SapiAccount parseAccount = parseAccount(jSONObject);
                    parseAccount.extra = SapiAccount.DispersionCertification.fromJSONObject(jSONObject).toJSONObject().toString();
                    ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                }
                if (qrAppLoginCallBack != null) {
                    switch (parseInt) {
                        case -103:
                        case 1:
                            qrAppLoginCallBack.onQrCodeInvalid();
                            return;
                        case 0:
                            qrAppLoginCallBack.onSuccess(qrAppLoginResponse);
                            return;
                        case 2:
                        case 160102:
                            qrAppLoginCallBack.onBdussInvalid();
                            return;
                        case 3:
                            qrAppLoginCallBack.onUserNotNormalized();
                            return;
                        default:
                            qrAppLoginCallBack.onSystemError(parseInt);
                            return;
                    }
                }
            } catch (Exception e) {
                if (qrAppLoginCallBack != null) {
                    qrAppLoginCallBack.onSystemError(-100);
                }
            }
        } else if (qrAppLoginCallBack != null) {
            qrAppLoginCallBack.onSystemError(i);
        }
    }

    void a(QrPCLoginCallBack qrPCLoginCallBack, String str) {
        qrPCLoginCallBack.onFinish();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            switch (parseInt) {
                case -103:
                case 1:
                    qrPCLoginCallBack.onQrCodeInvalid();
                    return;
                case 0:
                    QrPCLoginResponse qrPCLoginResponse = new QrPCLoginResponse();
                    qrPCLoginResponse.errorCode = parseInt;
                    JSONObject optJSONObject = jSONObject.optJSONObject("local");
                    if (optJSONObject != null) {
                        qrPCLoginResponse.country = optJSONObject.optString("country");
                        qrPCLoginResponse.province = optJSONObject.optString("provice");
                        qrPCLoginResponse.city = optJSONObject.optString("city");
                    }
                    qrPCLoginCallBack.onSuccess(qrPCLoginResponse);
                    return;
                case 2:
                case 160102:
                    qrPCLoginCallBack.onBdussInvalid();
                    return;
                case 3:
                    qrPCLoginCallBack.onUserNotNormalized();
                    return;
                default:
                    qrPCLoginCallBack.onSystemError(parseInt);
                    return;
            }
        } catch (Exception e) {
            qrPCLoginCallBack.onSystemError(-100);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getQrCodeImage(final SapiCallback<GetQrCodeImageResult> sapiCallback) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        final GetQrCodeImageResult getQrCodeImageResult = new GetQrCodeImageResult();
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            getQrCodeImageResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(getQrCodeImageResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FAILURE);
            return;
        }
        this.a = false;
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("tpl", this.configuration.tpl);
        hashMap.put("appid", this.configuration.appId);
        hashMap.put(SapiUtils.KEY_QR_LOGIN_LP, SapiUtils.QR_LOGIN_LP_PC);
        hashMap.put("client", "android");
        hashMap.put("apiver", "v3");
        hashMap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        hashMap.put("sig", calculateSig(hashMap, this.configuration.appSignKey));
        this.asyncHttpClient.get(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.GET_QR_CODE_IMAGE_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.5
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                sapiCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.START);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                sapiCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                QrCodeService.this.domainRetry.reset();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    getQrCodeImageResult.setResultCode(parseInt);
                    getQrCodeImageResult.setResultMsg(optString);
                    switch (parseInt) {
                        case 0:
                            getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                            getQrCodeImageResult.channelId = jSONObject.optString(SapiUtils.KEY_QR_LOGIN_SIGN);
                            sapiCallback.onSuccess(getQrCodeImageResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.SUCCESS);
                            break;
                        default:
                            sapiCallback.onFailure(getQrCodeImageResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FAILURE);
                            break;
                    }
                } catch (Throwable th) {
                    sapiCallback.onFailure(getQrCodeImageResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FAILURE);
                    Log.e(th);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!QrCodeService.this.domainRetry.isShouldRetry()) {
                    QrCodeService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getQrCodeImageResult.setResultCode(-203);
                        sapiCallback.onFailure(getQrCodeImageResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FAILURE);
                    }
                    getQrCodeImageResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sapiCallback.onFailure(getQrCodeImageResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                QrCodeService.this.domainRetry.retry();
                QrCodeService.this.getQrCodeImage(sapiCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopLoginStatusCheck() {
        this.a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qrLoginStatusCheck(final QrLoginStatusCheckCallback qrLoginStatusCheckCallback, final QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        if (qrLoginStatusCheckCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (!this.a) {
            final QrLoginStatusCheckResult qrLoginStatusCheckResult = new QrLoginStatusCheckResult();
            if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
                qrLoginStatusCheckResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
                qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_LOGIN_STATUS_CHECK, IEventCenterService.EventResult.PHASE.FAILURE);
                return;
            }
            this.asyncHttpClient = new AsyncHttpClient();
            this.asyncHttpClient.setUserAgent(getUaInfo());
            this.asyncHttpClient.setTimeout(40000);
            HashMap hashMap = new HashMap();
            hashMap.put("tpl", this.configuration.tpl);
            hashMap.put("appid", this.configuration.appId);
            hashMap.put("client", "android");
            hashMap.put("apiver", "v3");
            hashMap.put("callback", "cb");
            hashMap.put("channel_id", qrLoginStstusCheckDTO.channelId);
            hashMap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
            hashMap.put("sig", calculateSig(hashMap, this.configuration.appSignKey));
            this.asyncHttpClient.get(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.GET_QR_LOGIN_STATUS_CHECK, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.6
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    qrLoginStatusCheckCallback.onStart();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_LOGIN_STATUS_CHECK, IEventCenterService.EventResult.PHASE.START);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    qrLoginStatusCheckCallback.onFinish();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_LOGIN_STATUS_CHECK, IEventCenterService.EventResult.PHASE.FINISH);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str) {
                    QrCodeService.this.domainRetry.reset();
                    try {
                        JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
                        int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                        String optString = jSONObject.optString("errmsg");
                        qrLoginStatusCheckResult.setResultCode(parseInt);
                        qrLoginStatusCheckResult.setResultMsg(optString);
                        switch (parseInt) {
                            case 0:
                                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                                int optInt = jSONObject2.optInt(NotificationCompat.CATEGORY_STATUS);
                                qrLoginStatusCheckResult.status = optInt;
                                if (optInt == 1) {
                                    qrLoginStatusCheckCallback.onScanQrCodeDone(qrLoginStatusCheckResult);
                                    QrCodeService.this.qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO);
                                } else if (optInt == 0) {
                                    QrCodeService.this.getQrLoginResult(qrLoginStatusCheckCallback, qrLoginStatusCheckResult, jSONObject2.optString(NotifyType.VIBRATE));
                                } else {
                                    QrCodeService.this.qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO);
                                    qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                                }
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_LOGIN_STATUS_CHECK, IEventCenterService.EventResult.PHASE.SUCCESS);
                                return;
                            case 1:
                                QrCodeService.this.qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO);
                                return;
                            default:
                                qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_LOGIN_STATUS_CHECK, IEventCenterService.EventResult.PHASE.FAILURE);
                                return;
                        }
                    } catch (Throwable th) {
                        qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_LOGIN_STATUS_CHECK, IEventCenterService.EventResult.PHASE.FAILURE);
                        Log.e(th);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str) {
                    if (!QrCodeService.this.domainRetry.isShouldRetry()) {
                        QrCodeService.this.domainRetry.reset();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            qrLoginStatusCheckResult.setResultCode(-203);
                            qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_LOGIN_STATUS_CHECK, IEventCenterService.EventResult.PHASE.FAILURE);
                        }
                        qrLoginStatusCheckResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_LOGIN_STATUS_CHECK, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    QrCodeService.this.domainRetry.retry();
                    QrCodeService.this.qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO);
                }
            });
        }
    }

    protected void getQrLoginResult(final QrLoginStatusCheckCallback qrLoginStatusCheckCallback, final QrLoginStatusCheckResult qrLoginStatusCheckResult, final String str) {
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("tpl", this.configuration.tpl);
        hashMap.put("appid", this.configuration.appId);
        hashMap.put("display", "pcsdk");
        hashMap.put("qrcode", "1");
        hashMap.put("bduss", str);
        hashMap.put("client", "android");
        hashMap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        hashMap.put("sig", calculateSig(hashMap, this.configuration.appSignKey));
        this.asyncHttpClient.get(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.GET_QR_LOGIN_RESULT, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.7
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                qrLoginStatusCheckCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.START);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                qrLoginStatusCheckCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str2) {
                QrCodeService.this.domainRetry.reset();
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    qrLoginStatusCheckResult.setResultCode(parseInt);
                    qrLoginStatusCheckResult.setResultMsg(optString);
                    switch (parseInt) {
                        case 0:
                            JSONObject optJSONObject = jSONObject.optJSONObject("res");
                            SapiAccount parseAccount = QrCodeService.this.parseAccount(optJSONObject);
                            parseAccount.extra = SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).toJSONObject().toString();
                            ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                            qrLoginStatusCheckCallback.onSuccess(qrLoginStatusCheckResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.SUCCESS);
                            break;
                        default:
                            qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.FAILURE);
                            break;
                    }
                } catch (Throwable th) {
                    qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.FAILURE);
                    Log.e(th);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                if (!QrCodeService.this.domainRetry.isShouldRetry()) {
                    QrCodeService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        qrLoginStatusCheckResult.setResultCode(-203);
                        qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.FAILURE);
                    }
                    qrLoginStatusCheckResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                QrCodeService.this.domainRetry.retry();
                QrCodeService.this.getQrLoginResult(qrLoginStatusCheckCallback, qrLoginStatusCheckResult, str);
            }
        });
    }

    int a(String str) {
        int errorCode = getErrorCode(str);
        if (errorCode == 110000) {
            return 0;
        }
        return errorCode;
    }
}
