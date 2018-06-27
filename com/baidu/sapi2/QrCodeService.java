package com.baidu.sapi2;

import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrLoginStatusCheckResult;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.Collections;
import java.util.HashMap;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
    public void getQrCodeUrl(SapiCallback<GetQrCodeImageResult> sapiCallback) {
        a(sapiCallback, null, "app");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, String str) {
        a(sapiCallback, str, SapiUtils.QR_LOGIN_LP_PC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SapiCallback<GetQrCodeImageResult> sapiCallback, final String str, final String str2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        final GetQrCodeImageResult getQrCodeImageResult = new GetQrCodeImageResult();
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            getQrCodeImageResult.setResultCode(-201);
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
        hashMap.put(SapiUtils.KEY_QR_LOGIN_LP, TextUtils.isEmpty(str2) ? SapiUtils.QR_LOGIN_LP_PC : str2);
        hashMap.put("client", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("apiver", "v3");
        hashMap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        hashMap.put("cuid", this.configuration.clientId);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("openPlatformId", str);
        }
        hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.configuration.appSignKey));
        this.asyncHttpClient.get(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.GET_QR_CODE_IMAGE_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.1
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
            public void onSuccess(int i, String str3) {
                QrCodeService.this.domainRetry.reset();
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    getQrCodeImageResult.setResultCode(parseInt);
                    getQrCodeImageResult.setResultMsg(optString);
                    switch (parseInt) {
                        case 0:
                            getQrCodeImageResult.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + jSONObject.optString("imgurl");
                            getQrCodeImageResult.prompt = jSONObject.optString("prompt");
                            getQrCodeImageResult.channelId = jSONObject.optString("sign");
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
            public void onFailure(Throwable th, String str3) {
                if (!QrCodeService.this.domainRetry.isShouldRetry()) {
                    QrCodeService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getQrCodeImageResult.setResultCode(-203);
                        sapiCallback.onFailure(getQrCodeImageResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FAILURE);
                    }
                    getQrCodeImageResult.setResultCode(-202);
                    sapiCallback.onFailure(getQrCodeImageResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                QrCodeService.this.domainRetry.retry();
                QrCodeService.this.a(sapiCallback, str, str2);
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
                qrLoginStatusCheckResult.setResultCode(-201);
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
            hashMap.put("client", HttpConstants.OS_TYPE_VALUE);
            hashMap.put("apiver", "v3");
            hashMap.put("callback", "cb");
            hashMap.put("channel_id", qrLoginStstusCheckDTO.channelId);
            hashMap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
            hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.configuration.appSignKey));
            this.asyncHttpClient.get(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.GET_QR_LOGIN_STATUS_CHECK, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.2
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
                                    QrCodeService.this.getQrLoginResult(qrLoginStatusCheckCallback, qrLoginStatusCheckResult, jSONObject2.optString(NotifyType.VIBRATE), qrLoginStstusCheckDTO.isJoinCodeLogin);
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
                        qrLoginStatusCheckResult.setResultCode(-202);
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

    protected void getQrLoginResult(final QrLoginStatusCheckCallback qrLoginStatusCheckCallback, final QrLoginStatusCheckResult qrLoginStatusCheckResult, final String str, final boolean z) {
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("tpl", this.configuration.tpl);
        hashMap.put("appid", this.configuration.appId);
        hashMap.put(LivenessRecogActivity.f.a, "pcsdk");
        hashMap.put("qrcode", "1");
        hashMap.put("bduss", str);
        hashMap.put("client", HttpConstants.OS_TYPE_VALUE);
        hashMap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.configuration.appSignKey));
        this.asyncHttpClient.get(this.configuration.context, z ? this.domainRetry.getDomain() + SapiEnv.GET_QR_JOIN_LOGIN_RESULT : this.domainRetry.getDomain() + SapiEnv.GET_QR_LOGIN_RESULT, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.3
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
                JSONObject optJSONObject;
                QrCodeService.this.domainRetry.reset();
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    qrLoginStatusCheckResult.setResultCode(parseInt);
                    qrLoginStatusCheckResult.setResultMsg(optString);
                    switch (parseInt) {
                        case 0:
                        case 110000:
                            if (z) {
                                optJSONObject = jSONObject.optJSONObject("data");
                            } else {
                                optJSONObject = jSONObject.optJSONObject("res");
                            }
                            SapiAccount parseAccount = QrCodeService.this.parseAccount(optJSONObject);
                            parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).tplStokenMap);
                            ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                            qrLoginStatusCheckCallback.onSuccess(qrLoginStatusCheckResult);
                            SapiUtils.reportGid(10002);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.SUCCESS);
                            return;
                        default:
                            qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
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
                    qrLoginStatusCheckResult.setResultCode(-202);
                    qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                QrCodeService.this.domainRetry.retry();
                QrCodeService.this.getQrLoginResult(qrLoginStatusCheckCallback, qrLoginStatusCheckResult, str, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qrAppLogin(final SapiCallback<QrAppLoginResult> sapiCallback, final String str, final String str2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("cmd can't be empty");
        }
        final QrAppLoginResult qrAppLoginResult = new QrAppLoginResult();
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            qrAppLoginResult.setResultCode(-201);
            sapiCallback.onFailure(qrAppLoginResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
            return;
        }
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("sign", SapiUtils.urlParamsToMap(str).get("sign"));
        hashMap.put(IntentConfig.CMD, str2);
        if (!TextUtils.isEmpty(this.configuration.clientId)) {
            hashMap.put("clientid", this.configuration.clientId);
        }
        if (!TextUtils.isEmpty(this.configuration.clientIp)) {
            hashMap.put("clientip", this.configuration.clientIp);
        }
        hashMap.put("tpl", this.configuration.tpl);
        hashMap.put("appid", this.configuration.appId);
        SapiAccount session = ServiceManager.getInstance().getIsAccountManager().getSession();
        if (session != null) {
            hashMap.put("bduss", session.bduss);
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, session.stoken);
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PTOKEN, session.ptoken);
        }
        hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.configuration.appSignKey));
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
                    qrAppLoginResult.setResultCode(-202);
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
                            JSONObject optJSONObject = jSONObject.optJSONObject(RecentlyVisitedForumModel.LOCAL_ACCOUNT);
                            if (optJSONObject != null) {
                                qrAppLoginResult.country = optJSONObject.optString("country");
                                qrAppLoginResult.province = optJSONObject.optString("provice");
                                qrAppLoginResult.city = optJSONObject.optString("city");
                            }
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
}
