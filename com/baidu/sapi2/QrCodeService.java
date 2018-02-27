package com.baidu.sapi2;

import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import com.baidu.ar.util.Constants;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.QrLoginStatusCheckResult;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.Collections;
import java.util.HashMap;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    public void getQrCodeImage(final SapiCallback<GetQrCodeImageResult> sapiCallback) {
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
        hashMap.put(SapiUtils.KEY_QR_LOGIN_LP, SapiUtils.QR_LOGIN_LP_PC);
        hashMap.put("client", Constants.OS_TYPE_VALUE);
        hashMap.put("apiver", "v3");
        hashMap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        hashMap.put("sig", calculateSig(hashMap, this.configuration.appSignKey));
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
            public void onFailure(Throwable th, String str) {
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
            hashMap.put("client", Constants.OS_TYPE_VALUE);
            hashMap.put("apiver", "v3");
            hashMap.put("callback", "cb");
            hashMap.put("channel_id", qrLoginStstusCheckDTO.channelId);
            hashMap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
            hashMap.put("sig", calculateSig(hashMap, this.configuration.appSignKey));
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

    protected void getQrLoginResult(final QrLoginStatusCheckCallback qrLoginStatusCheckCallback, final QrLoginStatusCheckResult qrLoginStatusCheckResult, final String str) {
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("tpl", this.configuration.tpl);
        hashMap.put("appid", this.configuration.appId);
        hashMap.put("display", "pcsdk");
        hashMap.put("qrcode", "1");
        hashMap.put("bduss", str);
        hashMap.put("client", Constants.OS_TYPE_VALUE);
        hashMap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        hashMap.put("sig", calculateSig(hashMap, this.configuration.appSignKey));
        this.asyncHttpClient.get(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.GET_QR_LOGIN_RESULT, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.3
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
                    qrLoginStatusCheckResult.setResultCode(-202);
                    qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                QrCodeService.this.domainRetry.retry();
                QrCodeService.this.getQrLoginResult(qrLoginStatusCheckCallback, qrLoginStatusCheckResult, str);
            }
        });
    }
}
