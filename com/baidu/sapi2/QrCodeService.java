package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class QrCodeService extends AbstractService implements NoProguard {
    private static QrCodeService b;
    private HttpClientWrap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends HttpHandlerWrap {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ GetQrCodeImageResult b;
        final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            this.a = sapiCallback;
            this.b = getQrCodeImageResult;
            this.c = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.b.setResultCode(i);
            this.a.onFailure(this.b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString(BaseJsonData.TAG_ERRNO));
                String optString = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                this.b.setResultCode(parseInt);
                this.b.setResultMsg(optString);
                if (parseInt != 0) {
                    this.a.onFailure(this.b);
                    return;
                }
                this.b.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + jSONObject.optString("imgurl");
                this.b.prompt = jSONObject.optString("prompt");
                this.b.channelId = jSONObject.optString("sign");
                if (this.c) {
                    this.b.contentUrl = jSONObject.optString("qrcontent_url");
                }
                this.a.onSuccess(this.b);
            } catch (Throwable th) {
                this.a.onFailure(this.b);
                Log.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class b extends HttpHandlerWrap {
        final /* synthetic */ boolean a;
        final /* synthetic */ QrLoginStatusCheckCallback b;
        final /* synthetic */ QrLoginStatusCheckResult c;
        final /* synthetic */ QrLoginStstusCheckDTO d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Looper looper, boolean z, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
            super(looper);
            this.a = z;
            this.b = qrLoginStatusCheckCallback;
            this.c = qrLoginStatusCheckResult;
            this.d = qrLoginStstusCheckDTO;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.c.setResultCode(i);
            this.b.onFailure(this.c);
            this.b.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            if (this.a) {
                this.b.onStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
                int parseInt = Integer.parseInt(jSONObject.optString(BaseJsonData.TAG_ERRNO));
                String optString = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                this.c.setResultCode(parseInt);
                this.c.setResultMsg(optString);
                if (parseInt == 0) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                    int optInt = jSONObject2.optInt("status");
                    this.c.status = optInt;
                    if (optInt == 1) {
                        this.b.onScanQrCodeDone(this.c);
                        QrCodeService.this.qrLoginStatusCheck(this.b, this.d, false);
                    } else if (optInt == 0) {
                        QrCodeService.this.getQrLoginResult(this.b, this.c, jSONObject2.optString("v"), this.d.hostDeviceId, this.d.isJoinCodeLogin);
                    } else if (optInt == 2) {
                        this.c.setResultCode(optInt);
                        this.c.setResultMsg("您已取消操作");
                        this.b.onFailure(this.c);
                        this.b.onFinish();
                    } else {
                        QrCodeService.this.qrLoginStatusCheck(this.b, this.d, false);
                    }
                } else if (parseInt != 1) {
                    this.b.onFailure(this.c);
                    this.b.onFinish();
                } else {
                    QrCodeService.this.qrLoginStatusCheck(this.b, this.d, false);
                }
            } catch (Throwable th) {
                this.b.onFailure(this.c);
                this.b.onFinish();
                Log.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class c extends HttpHandlerWrap {
        final /* synthetic */ QrLoginStatusCheckCallback a;
        final /* synthetic */ QrLoginStatusCheckResult b;
        final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Looper looper, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, boolean z) {
            super(looper);
            this.a = qrLoginStatusCheckCallback;
            this.b = qrLoginStatusCheckResult;
            this.c = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.b.setResultCode(i);
            this.a.onFailure(this.b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            JSONObject optJSONObject;
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString(BaseJsonData.TAG_ERRNO));
                String optString = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                this.b.setResultCode(parseInt);
                this.b.setResultMsg(optString);
                if (parseInt != 0 && parseInt != 110000) {
                    this.a.onFailure(this.b);
                    return;
                }
                if (this.c) {
                    optJSONObject = jSONObject.optJSONObject("data");
                } else {
                    optJSONObject = jSONObject.optJSONObject("res");
                }
                SapiAccount parseAccount = QrCodeService.this.parseAccount(optJSONObject);
                parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).tplStokenMap);
                ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                this.a.onSuccess(this.b);
            } catch (Throwable th) {
                this.a.onFailure(this.b);
                Log.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class d extends HttpHandlerWrap {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ QrAppLoginResult b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Looper looper, SapiCallback sapiCallback, QrAppLoginResult qrAppLoginResult) {
            super(looper);
            this.a = sapiCallback;
            this.b = qrAppLoginResult;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.b.setResultCode(i);
            this.a.onFailure(this.b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString(BaseJsonData.TAG_ERRNO));
                this.b.setResultCode(parseInt);
                if (parseInt != 0) {
                    this.a.onFailure(this.b);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("local");
                if (optJSONObject != null) {
                    this.b.country = optJSONObject.optString("country");
                    this.b.province = optJSONObject.optString("provice");
                    this.b.city = optJSONObject.optString("city");
                }
                this.a.onSuccess(this.b);
            } catch (Throwable th) {
                this.a.onFailure(this.b);
                Log.e(th);
            }
        }
    }

    private QrCodeService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

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

    /* JADX INFO: Access modifiers changed from: protected */
    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        if (getQrCodeImageDTO == null) {
            getQrCodeImageDTO = new GetQrCodeImageDTO();
        }
        boolean z = getQrCodeImageDTO.needQrCodeContent;
        GetQrCodeImageResult getQrCodeImageResult = new GetQrCodeImageResult();
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
        new HttpClientWrap().get(com.baidu.sapi2.utils.e.j, httpHashMapWrap, null, getUaInfo(), new a(Looper.getMainLooper(), sapiCallback, getQrCodeImageResult, z));
    }

    protected void getQrLoginResult(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, String str, String str2, boolean z) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("display", "pcsdk");
        httpHashMapWrap.put("qrcode", "1");
        httpHashMapWrap.put("bduss", str);
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("hostDeviceId", str2);
        String str3 = z ? com.baidu.sapi2.utils.e.m : com.baidu.sapi2.utils.e.l;
        this.a = new HttpClientWrap();
        this.a.get(str3, httpHashMapWrap, null, getUaInfo(), new c(Looper.getMainLooper(), qrLoginStatusCheckCallback, qrLoginStatusCheckResult, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str2, "cmd can't be empty");
        QrAppLoginResult qrAppLoginResult = new QrAppLoginResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(str);
        httpHashMapWrap.put("sign", urlParamsToMap.get("sign"));
        httpHashMapWrap.put("cmd", str2);
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            httpHashMapWrap.put("bduss", currentAccount.bduss);
            httpHashMapWrap.put("stoken", currentAccount.stoken);
            httpHashMapWrap.put("ptoken", currentAccount.ptoken);
        }
        new HttpClientWrap().post("/v2/sapi/qrlogin?lp=" + (TextUtils.isEmpty(urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP)) ? "app" : urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP)), httpHashMapWrap, null, getUaInfo(), new d(Looper.getMainLooper(), sapiCallback, qrAppLoginResult));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO, boolean z) {
        SapiUtils.notNull(qrLoginStatusCheckCallback, SapiCallback.class.getSimpleName() + " can't be null");
        QrLoginStatusCheckResult qrLoginStatusCheckResult = new QrLoginStatusCheckResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("apiver", "v3");
        httpHashMapWrap.put(BuyTBeanActivityConfig.CALLBACK, "cb");
        httpHashMapWrap.put(SharedPrefConfig.CHANNEL_ID, qrLoginStstusCheckDTO.channelId);
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        this.a = new HttpClientWrap();
        this.a.get(com.baidu.sapi2.utils.e.k, httpHashMapWrap, null, getUaInfo(), 40000, new b(Looper.getMainLooper(), z, qrLoginStatusCheckCallback, qrLoginStatusCheckResult, qrLoginStstusCheckDTO));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopLoginStatusCheck() {
        HttpClientWrap httpClientWrap = this.a;
        if (httpClientWrap != null) {
            httpClientWrap.cancelRequest();
            this.a = null;
        }
    }
}
