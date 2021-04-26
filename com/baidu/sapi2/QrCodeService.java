package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.http.PassHttpClientRequest;
import com.baidu.pass.http.ReqPriority;
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
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.facebook.common.util.UriUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QrCodeService extends AbstractService implements NoProguard {

    /* renamed from: c  reason: collision with root package name */
    public static QrCodeService f10544c;

    /* renamed from: a  reason: collision with root package name */
    public HttpClientWrap f10545a;

    /* renamed from: b  reason: collision with root package name */
    public PassHttpClientRequest f10546b;

    /* loaded from: classes2.dex */
    public class a extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f10547a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetQrCodeImageResult f10548b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f10549c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            this.f10547a = sapiCallback;
            this.f10548b = getQrCodeImageResult;
            this.f10549c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f10548b.setResultCode(i2);
            this.f10547a.onFailure(this.f10548b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f10547a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f10547a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.f10548b.setResultCode(parseInt);
                this.f10548b.setResultMsg(optString);
                if (parseInt != 0) {
                    this.f10547a.onFailure(this.f10548b);
                    return;
                }
                GetQrCodeImageResult getQrCodeImageResult = this.f10548b;
                getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                this.f10548b.prompt = jSONObject.optString("prompt");
                this.f10548b.channelId = jSONObject.optString("sign");
                if (this.f10549c) {
                    this.f10548b.contentUrl = jSONObject.optString("qrcontent_url");
                }
                this.f10547a.onSuccess(this.f10548b);
            } catch (Throwable th) {
                this.f10547a.onFailure(this.f10548b);
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f10551a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckCallback f10552b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f10553c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrLoginStstusCheckDTO f10554d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, boolean z, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
            super(looper);
            this.f10551a = z;
            this.f10552b = qrLoginStatusCheckCallback;
            this.f10553c = qrLoginStatusCheckResult;
            this.f10554d = qrLoginStstusCheckDTO;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f10553c.setResultCode(i2);
            this.f10552b.onFailure(this.f10553c);
            this.f10552b.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            if (this.f10551a) {
                this.f10552b.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.f10553c.setResultCode(parseInt);
                this.f10553c.setResultMsg(optString);
                if (parseInt != 0) {
                    if (parseInt != 1) {
                        this.f10552b.onFailure(this.f10553c);
                        this.f10552b.onFinish();
                        return;
                    }
                    QrCodeService.this.qrLoginStatusCheck(this.f10552b, this.f10554d, false);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                int optInt = jSONObject2.optInt("status");
                this.f10553c.status = optInt;
                if (optInt == 1) {
                    this.f10552b.onScanQrCodeDone(this.f10553c);
                    QrCodeService.this.qrLoginStatusCheck(this.f10552b, this.f10554d, false);
                } else if (optInt == 0) {
                    QrCodeService.this.getQrLoginResult(this.f10552b, this.f10553c, jSONObject2.optString("v"), this.f10554d.hostDeviceId, this.f10554d.isJoinCodeLogin);
                } else if (optInt == 2) {
                    this.f10553c.setResultCode(optInt);
                    this.f10553c.setResultMsg("您已取消操作");
                    this.f10552b.onFailure(this.f10553c);
                    this.f10552b.onFinish();
                } else {
                    QrCodeService.this.qrLoginStatusCheck(this.f10552b, this.f10554d, false);
                }
            } catch (Throwable th) {
                this.f10552b.onFailure(this.f10553c);
                this.f10552b.onFinish();
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckCallback f10556a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f10557b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f10558c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, boolean z) {
            super(looper);
            this.f10556a = qrLoginStatusCheckCallback;
            this.f10557b = qrLoginStatusCheckResult;
            this.f10558c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f10557b.setResultCode(i2);
            this.f10556a.onFailure(this.f10557b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f10556a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            JSONObject optJSONObject;
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.f10557b.setResultCode(parseInt);
                this.f10557b.setResultMsg(optString);
                if (parseInt != 0 && parseInt != 110000) {
                    this.f10556a.onFailure(this.f10557b);
                    return;
                }
                if (this.f10558c) {
                    optJSONObject = jSONObject.optJSONObject("data");
                } else {
                    optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                }
                SapiAccount parseAccount = QrCodeService.this.parseAccount(optJSONObject);
                parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).tplStokenMap);
                ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                this.f10556a.onSuccess(this.f10557b);
            } catch (Throwable th) {
                this.f10556a.onFailure(this.f10557b);
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f10560a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrAppLoginResult f10561b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Looper looper, SapiCallback sapiCallback, QrAppLoginResult qrAppLoginResult) {
            super(looper);
            this.f10560a = sapiCallback;
            this.f10561b = qrAppLoginResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f10561b.setResultCode(i2);
            this.f10560a.onFailure(this.f10561b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f10560a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f10560a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                this.f10561b.setResultCode(parseInt);
                if (parseInt != 0) {
                    this.f10560a.onFailure(this.f10561b);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("local");
                if (optJSONObject != null) {
                    this.f10561b.country = optJSONObject.optString("country");
                    this.f10561b.province = optJSONObject.optString("provice");
                    this.f10561b.city = optJSONObject.optString("city");
                }
                this.f10560a.onSuccess(this.f10561b);
            } catch (Throwable th) {
                this.f10560a.onFailure(this.f10561b);
                Log.e(th);
            }
        }
    }

    public QrCodeService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    public static synchronized QrCodeService getInstance(SapiConfiguration sapiConfiguration, String str) {
        QrCodeService qrCodeService;
        synchronized (QrCodeService.class) {
            if (f10544c == null) {
                f10544c = new QrCodeService(sapiConfiguration, str);
            }
            qrCodeService = f10544c;
        }
        return qrCodeService;
    }

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
        new HttpClientWrap().get(SapiEnv.GET_QR_CODE_IMAGE_URI, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), new a(Looper.getMainLooper(), sapiCallback, getQrCodeImageResult, z));
    }

    public void getQrLoginResult(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, String str, String str2, boolean z) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("display", "pcsdk");
        httpHashMapWrap.put("qrcode", "1");
        httpHashMapWrap.put("bduss", str);
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("hostDeviceId", str2);
        String str3 = z ? SapiEnv.GET_QR_JOIN_LOGIN_RESULT : SapiEnv.GET_QR_LOGIN_RESULT;
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        this.f10545a = httpClientWrap;
        httpClientWrap.get(str3, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), new c(Looper.getMainLooper(), qrLoginStatusCheckCallback, qrLoginStatusCheckResult, z));
    }

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
            httpHashMapWrap.put(SapiAccount.SAPI_ACCOUNT_PTOKEN, currentAccount.ptoken);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/v2/sapi/qrlogin?lp=");
        sb.append(TextUtils.isEmpty(urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP)) ? "app" : urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP));
        new HttpClientWrap().post(sb.toString(), httpHashMapWrap, null, getUaInfo(), new d(Looper.getMainLooper(), sapiCallback, qrAppLoginResult));
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO, boolean z) {
        SapiUtils.notNull(qrLoginStatusCheckCallback, SapiCallback.class.getSimpleName() + " can't be null");
        QrLoginStatusCheckResult qrLoginStatusCheckResult = new QrLoginStatusCheckResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("apiver", "v3");
        httpHashMapWrap.put("callback", "cb");
        httpHashMapWrap.put("channel_id", qrLoginStstusCheckDTO.channelId);
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        this.f10545a = httpClientWrap;
        this.f10546b = httpClientWrap.get(SapiEnv.GET_QR_LOGIN_STATUS_CHECK, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), 40000, new b(Looper.getMainLooper(), z, qrLoginStatusCheckCallback, qrLoginStatusCheckResult, qrLoginStstusCheckDTO));
    }

    public void stopLoginStatusCheck() {
        PassHttpClientRequest passHttpClientRequest = this.f10546b;
        if (passHttpClientRequest != null) {
            passHttpClientRequest.cancel();
        }
        if (this.f10545a != null) {
            this.f10545a = null;
        }
    }
}
