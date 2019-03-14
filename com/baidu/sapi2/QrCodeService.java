package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrLoginStatusCheckResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.net.HttpCookie;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

    public void getQrCodeContent(SapiCallback<GetQrCodeImageResult> sapiCallback, String str) {
        a(sapiCallback, str, "pc", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getQrCodeUrl(SapiCallback<GetQrCodeImageResult> sapiCallback) {
        a(sapiCallback, null, "app", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, String str) {
        a(sapiCallback, str, "pc", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SapiCallback<GetQrCodeImageResult> sapiCallback, final String str, final String str2, final boolean z) {
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
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("tpl", this.configuration.tpl);
        httpHashMapWrap.put("appid", this.configuration.appId);
        httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_LP, TextUtils.isEmpty(str2) ? "pc" : str2);
        httpHashMapWrap.put("client", "android");
        httpHashMapWrap.put("apiver", "v3");
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("cuid", this.configuration.clientId);
        if (!TextUtils.isEmpty(str)) {
            httpHashMapWrap.put("openPlatformId", str);
        }
        httpHashMapWrap.put("needQrCodeContent", z ? "1" : "0");
        httpHashMapWrap.put("sig", SapiUtils.calculateSig(httpHashMapWrap.getMap(), this.configuration.appSignKey));
        new HttpClientWrap().get(this.domainRetry.getDomain() + SapiEnv.GET_QR_CODE_IMAGE_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.START);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
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
                            getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                            getQrCodeImageResult.prompt = jSONObject.optString("prompt");
                            getQrCodeImageResult.channelId = jSONObject.optString("sign");
                            if (z) {
                                getQrCodeImageResult.contentUrl = jSONObject.optString("qrcontent_url");
                            }
                            sapiCallback.onSuccess(getQrCodeImageResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.SUCCESS);
                            return;
                        default:
                            sapiCallback.onFailure(getQrCodeImageResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
                    }
                } catch (Throwable th) {
                    sapiCallback.onFailure(getQrCodeImageResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_CODE_IMAGE, IEventCenterService.EventResult.PHASE.FAILURE);
                    Log.e(th);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
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
                QrCodeService.this.a(sapiCallback, str, str2, z);
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
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("tpl", this.configuration.tpl);
            httpHashMapWrap.put("appid", this.configuration.appId);
            httpHashMapWrap.put("client", "android");
            httpHashMapWrap.put("apiver", "v3");
            httpHashMapWrap.put("callback", "cb");
            httpHashMapWrap.put("channel_id", qrLoginStstusCheckDTO.channelId);
            httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
            httpHashMapWrap.put("sig", SapiUtils.calculateSig(httpHashMapWrap.getMap(), this.configuration.appSignKey));
            new HttpClientWrap().get(this.domainRetry.getDomain() + SapiEnv.GET_QR_LOGIN_STATUS_CHECK, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), 40000, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    qrLoginStatusCheckCallback.onStart();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_LOGIN_STATUS_CHECK, IEventCenterService.EventResult.PHASE.START);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    qrLoginStatusCheckCallback.onFinish();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_LOGIN_STATUS_CHECK, IEventCenterService.EventResult.PHASE.FINISH);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
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
                                int optInt = jSONObject2.optInt("status");
                                qrLoginStatusCheckResult.status = optInt;
                                if (optInt == 1) {
                                    qrLoginStatusCheckCallback.onScanQrCodeDone(qrLoginStatusCheckResult);
                                    QrCodeService.this.qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO);
                                } else if (optInt == 0) {
                                    QrCodeService.this.getQrLoginResult(qrLoginStatusCheckCallback, qrLoginStatusCheckResult, jSONObject2.optString("v"), qrLoginStstusCheckDTO.isJoinCodeLogin);
                                } else {
                                    qrLoginStatusCheckResult.setResultCode(optInt);
                                    qrLoginStatusCheckResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
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
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
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
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("tpl", this.configuration.tpl);
        httpHashMapWrap.put("appid", this.configuration.appId);
        httpHashMapWrap.put("display", "pcsdk");
        httpHashMapWrap.put("qrcode", "1");
        httpHashMapWrap.put("bduss", str);
        httpHashMapWrap.put("client", "android");
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("sig", SapiUtils.calculateSig(httpHashMapWrap.getMap(), this.configuration.appSignKey));
        new HttpClientWrap().get(z ? this.domainRetry.getDomain() + SapiEnv.GET_QR_JOIN_LOGIN_RESULT : this.domainRetry.getDomain() + SapiEnv.GET_QR_LOGIN_RESULT, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                qrLoginStatusCheckCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.START);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                qrLoginStatusCheckCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_QR_LOGIN_RESULT, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
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
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
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
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(str);
        httpHashMapWrap.put("sign", urlParamsToMap.get("sign"));
        httpHashMapWrap.put(IntentConfig.CMD, str2);
        if (!TextUtils.isEmpty(this.configuration.clientId)) {
            httpHashMapWrap.put("clientid", this.configuration.clientId);
        }
        if (!TextUtils.isEmpty(this.configuration.clientIp)) {
            httpHashMapWrap.put("clientip", this.configuration.clientIp);
        }
        httpHashMapWrap.put("tpl", this.configuration.tpl);
        httpHashMapWrap.put("appid", this.configuration.appId);
        SapiAccount session = ServiceManager.getInstance().getIsAccountManager().getSession();
        if (session != null) {
            httpHashMapWrap.put("bduss", session.bduss);
            httpHashMapWrap.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, session.stoken);
            httpHashMapWrap.put(ISapiAccount.SAPI_ACCOUNT_PTOKEN, session.ptoken);
        }
        httpHashMapWrap.put("sig", SapiUtils.calculateSig(httpHashMapWrap.getMap(), this.configuration.appSignKey));
        new HttpClientWrap().post(this.domainRetry.getDomain() + SapiEnv.QR_APP_LOGIN_URI + "?lp=" + (TextUtils.isEmpty(urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP)) ? "app" : urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP)), httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.START);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_QR_APP_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
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
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
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
