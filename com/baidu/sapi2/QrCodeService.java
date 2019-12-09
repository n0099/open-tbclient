package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.dto.GetQrCodeImageDTO;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrLoginStatusCheckResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QrCodeService extends AbstractService {
    private static QrCodeService a;
    private HttpClientWrap b;

    private QrCodeService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    public static synchronized QrCodeService getInstance(SapiConfiguration sapiConfiguration, String str) {
        QrCodeService qrCodeService;
        synchronized (QrCodeService.class) {
            if (a == null) {
                a = new QrCodeService(sapiConfiguration, str);
            }
            qrCodeService = a;
        }
        return qrCodeService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getQrCodeImage(final SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        if (getQrCodeImageDTO == null) {
            getQrCodeImageDTO = new GetQrCodeImageDTO();
        }
        final boolean z = getQrCodeImageDTO.needQrCodeContent;
        final GetQrCodeImageResult getQrCodeImageResult = new GetQrCodeImageResult();
        stopLoginStatusCheck();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_LP, TextUtils.isEmpty(getQrCodeImageDTO.lp) ? "pc" : getQrCodeImageDTO.lp);
        httpHashMapWrap.put("apiver", "v3");
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(getQrCodeImageDTO.openPlatformId)) {
            httpHashMapWrap.put("openPlatformId", getQrCodeImageDTO.openPlatformId);
        }
        httpHashMapWrap.put("needQrCodeContent", getQrCodeImageDTO.needQrCodeContent ? "1" : "0");
        httpHashMapWrap.put("hostDeviceId", getQrCodeImageDTO.hostDeviceId);
        new HttpClientWrap().get(com.baidu.sapi2.utils.f.j, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                getQrCodeImageResult.setResultCode(i);
                sapiCallback.onFailure(getQrCodeImageResult);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    getQrCodeImageResult.setResultCode(parseInt);
                    getQrCodeImageResult.setResultMsg(optString);
                    if (parseInt != 0) {
                        sapiCallback.onFailure(getQrCodeImageResult);
                        return;
                    }
                    getQrCodeImageResult.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + jSONObject.optString("imgurl");
                    getQrCodeImageResult.prompt = jSONObject.optString("prompt");
                    getQrCodeImageResult.channelId = jSONObject.optString("sign");
                    if (z) {
                        getQrCodeImageResult.contentUrl = jSONObject.optString("qrcontent_url");
                    }
                    sapiCallback.onSuccess(getQrCodeImageResult);
                } catch (Throwable th) {
                    sapiCallback.onFailure(getQrCodeImageResult);
                    Log.e(th);
                }
            }
        });
    }

    protected void getQrLoginResult(final QrLoginStatusCheckCallback qrLoginStatusCheckCallback, final QrLoginStatusCheckResult qrLoginStatusCheckResult, String str, String str2, final boolean z) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put(LogConfig.KEY_DISPLAY, "pcsdk");
        httpHashMapWrap.put("qrcode", "1");
        httpHashMapWrap.put("bduss", str);
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("hostDeviceId", str2);
        String str3 = z ? com.baidu.sapi2.utils.f.m : com.baidu.sapi2.utils.f.l;
        this.b = new HttpClientWrap();
        this.b.get(str3, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str4) {
                qrLoginStatusCheckResult.setResultCode(i);
                qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                qrLoginStatusCheckCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str4) {
                JSONObject optJSONObject;
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    qrLoginStatusCheckResult.setResultCode(parseInt);
                    qrLoginStatusCheckResult.setResultMsg(optString);
                    if (parseInt != 0 && parseInt != 110000) {
                        qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                        return;
                    }
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
                } catch (Throwable th) {
                    qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                    Log.e(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qrAppLogin(final SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str2, "cmd can't be empty");
        final QrAppLoginResult qrAppLoginResult = new QrAppLoginResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(str);
        httpHashMapWrap.put("sign", urlParamsToMap.get("sign"));
        httpHashMapWrap.put("cmd", str2);
        SapiAccount currentAccount = SapiContext.getInstance(this.configuration.context).getCurrentAccount();
        if (currentAccount != null) {
            httpHashMapWrap.put("bduss", currentAccount.bduss);
            httpHashMapWrap.put("stoken", currentAccount.stoken);
            httpHashMapWrap.put("ptoken", currentAccount.ptoken);
        }
        new HttpClientWrap().post("/v2/sapi/qrlogin?lp=" + (TextUtils.isEmpty(urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP)) ? "app" : urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP)), httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                qrAppLoginResult.setResultCode(i);
                sapiCallback.onFailure(qrAppLoginResult);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str3) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    qrAppLoginResult.setResultCode(parseInt);
                    if (parseInt != 0) {
                        sapiCallback.onFailure(qrAppLoginResult);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(RecentlyVisitedForumModel.LOCAL_ACCOUNT);
                    if (optJSONObject != null) {
                        qrAppLoginResult.country = optJSONObject.optString("country");
                        qrAppLoginResult.province = optJSONObject.optString("provice");
                        qrAppLoginResult.city = optJSONObject.optString("city");
                    }
                    sapiCallback.onSuccess(qrAppLoginResult);
                } catch (Throwable th) {
                    sapiCallback.onFailure(qrAppLoginResult);
                    Log.e(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qrLoginStatusCheck(final QrLoginStatusCheckCallback qrLoginStatusCheckCallback, final QrLoginStstusCheckDTO qrLoginStstusCheckDTO, final boolean z) {
        SapiUtils.notNull(qrLoginStatusCheckCallback, SapiCallback.class.getSimpleName() + " can't be null");
        final QrLoginStatusCheckResult qrLoginStatusCheckResult = new QrLoginStatusCheckResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("apiver", "v3");
        httpHashMapWrap.put(BuyTBeanActivityConfig.CALLBACK, "cb");
        httpHashMapWrap.put("channel_id", qrLoginStstusCheckDTO.channelId);
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        this.b = new HttpClientWrap();
        this.b.get(com.baidu.sapi2.utils.f.k, httpHashMapWrap, null, getUaInfo(), 40000, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.QrCodeService.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                qrLoginStatusCheckResult.setResultCode(i);
                qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                qrLoginStatusCheckCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                if (z) {
                    qrLoginStatusCheckCallback.onStart();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    qrLoginStatusCheckResult.setResultCode(parseInt);
                    qrLoginStatusCheckResult.setResultMsg(optString);
                    if (parseInt == 0) {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                        int optInt = jSONObject2.optInt("status");
                        qrLoginStatusCheckResult.status = optInt;
                        if (optInt == 1) {
                            qrLoginStatusCheckCallback.onScanQrCodeDone(qrLoginStatusCheckResult);
                            QrCodeService.this.qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, false);
                        } else if (optInt == 0) {
                            QrCodeService.this.getQrLoginResult(qrLoginStatusCheckCallback, qrLoginStatusCheckResult, jSONObject2.optString("v"), qrLoginStstusCheckDTO.hostDeviceId, qrLoginStstusCheckDTO.isJoinCodeLogin);
                        } else if (optInt == 2) {
                            qrLoginStatusCheckResult.setResultCode(optInt);
                            qrLoginStatusCheckResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                            qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                            qrLoginStatusCheckCallback.onFinish();
                        } else {
                            QrCodeService.this.qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, false);
                        }
                    } else if (parseInt != 1) {
                        qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                        qrLoginStatusCheckCallback.onFinish();
                    } else {
                        QrCodeService.this.qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, false);
                    }
                } catch (Throwable th) {
                    qrLoginStatusCheckCallback.onFailure(qrLoginStatusCheckResult);
                    qrLoginStatusCheckCallback.onFinish();
                    Log.e(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopLoginStatusCheck() {
        HttpClientWrap httpClientWrap = this.b;
        if (httpClientWrap != null) {
            httpClientWrap.cancelRequest();
            this.b = null;
        }
    }
}
