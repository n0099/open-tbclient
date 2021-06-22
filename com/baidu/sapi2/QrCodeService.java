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
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.facebook.common.util.UriUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QrCodeService extends AbstractService implements NoProguard {

    /* renamed from: c  reason: collision with root package name */
    public static QrCodeService f9549c;

    /* renamed from: a  reason: collision with root package name */
    public HttpClientWrap f9550a;

    /* renamed from: b  reason: collision with root package name */
    public PassHttpClientRequest f9551b;

    /* loaded from: classes2.dex */
    public class a extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f9552a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetQrCodeImageResult f9553b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f9554c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            this.f9552a = sapiCallback;
            this.f9553b = getQrCodeImageResult;
            this.f9554c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f9553b.setResultCode(i2);
            this.f9552a.onFailure(this.f9553b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f9552a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f9552a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.f9553b.setResultCode(parseInt);
                this.f9553b.setResultMsg(optString);
                if (parseInt != 0) {
                    this.f9552a.onFailure(this.f9553b);
                    return;
                }
                GetQrCodeImageResult getQrCodeImageResult = this.f9553b;
                getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                this.f9553b.prompt = jSONObject.optString("prompt");
                this.f9553b.channelId = jSONObject.optString("sign");
                if (this.f9554c) {
                    this.f9553b.contentUrl = jSONObject.optString("qrcontent_url");
                }
                this.f9552a.onSuccess(this.f9553b);
            } catch (Throwable th) {
                this.f9552a.onFailure(this.f9553b);
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f9556a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetQrCodeImageResult f9557b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f9558c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            this.f9556a = sapiCallback;
            this.f9557b = getQrCodeImageResult;
            this.f9558c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f9557b.setResultCode(i2);
            this.f9556a.onFailure(this.f9557b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f9556a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f9556a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.f9557b.setResultCode(parseInt);
                this.f9557b.setResultMsg(optString);
                if (parseInt != 0) {
                    this.f9556a.onFailure(this.f9557b);
                    return;
                }
                GetQrCodeImageResult getQrCodeImageResult = this.f9557b;
                getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                this.f9557b.prompt = jSONObject.optString("prompt");
                this.f9557b.channelId = jSONObject.optString("sign");
                if (this.f9558c) {
                    this.f9557b.contentUrl = jSONObject.optString("qrcontent_url");
                }
                this.f9556a.onSuccess(this.f9557b);
            } catch (Throwable th) {
                this.f9556a.onFailure(this.f9557b);
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f9560a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckCallback f9561b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f9562c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrLoginStstusCheckDTO f9563d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, boolean z, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
            super(looper);
            this.f9560a = z;
            this.f9561b = qrLoginStatusCheckCallback;
            this.f9562c = qrLoginStatusCheckResult;
            this.f9563d = qrLoginStstusCheckDTO;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f9562c.setResultCode(i2);
            this.f9561b.onFailure(this.f9562c);
            this.f9561b.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            if (this.f9560a) {
                this.f9561b.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.f9562c.setResultCode(parseInt);
                this.f9562c.setResultMsg(optString);
                if (parseInt != 0) {
                    if (parseInt != 1) {
                        this.f9561b.onFailure(this.f9562c);
                        this.f9561b.onFinish();
                        return;
                    }
                    QrCodeService.this.qrLoginStatusCheck(this.f9561b, this.f9563d, false);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                int optInt = jSONObject2.optInt("status");
                this.f9562c.status = optInt;
                if (optInt == 1) {
                    this.f9561b.onScanQrCodeDone(this.f9562c);
                    QrCodeService.this.qrLoginStatusCheck(this.f9561b, this.f9563d, false);
                } else if (optInt == 0) {
                    QrCodeService.this.getQrLoginResult(this.f9561b, this.f9562c, jSONObject2.optString("v"), this.f9563d.hostDeviceId, this.f9563d.isJoinCodeLogin);
                } else if (optInt == 2) {
                    this.f9562c.setResultCode(optInt);
                    this.f9562c.setResultMsg("您已取消操作");
                    this.f9561b.onFailure(this.f9562c);
                    this.f9561b.onFinish();
                } else {
                    QrCodeService.this.qrLoginStatusCheck(this.f9561b, this.f9563d, false);
                }
            } catch (Throwable th) {
                this.f9561b.onFailure(this.f9562c);
                this.f9561b.onFinish();
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckCallback f9565a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f9566b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f9567c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Looper looper, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, boolean z) {
            super(looper);
            this.f9565a = qrLoginStatusCheckCallback;
            this.f9566b = qrLoginStatusCheckResult;
            this.f9567c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f9566b.setResultCode(i2);
            this.f9565a.onFailure(this.f9566b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f9565a.onFinish();
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
                this.f9566b.setResultCode(parseInt);
                this.f9566b.setResultMsg(optString);
                if (parseInt != 0 && parseInt != 110000) {
                    this.f9565a.onFailure(this.f9566b);
                    return;
                }
                if (this.f9567c) {
                    optJSONObject = jSONObject.optJSONObject("data");
                } else {
                    optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                }
                SapiAccount parseAccount = QrCodeService.this.parseAccount(optJSONObject);
                parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).tplStokenMap);
                ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                this.f9565a.onSuccess(this.f9566b);
            } catch (Throwable th) {
                this.f9565a.onFailure(this.f9566b);
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f9569a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrAppLoginResult f9570b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Looper looper, SapiCallback sapiCallback, QrAppLoginResult qrAppLoginResult) {
            super(looper);
            this.f9569a = sapiCallback;
            this.f9570b = qrAppLoginResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f9570b.setResultCode(i2);
            this.f9569a.onFailure(this.f9570b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f9569a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f9569a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                this.f9570b.setResultCode(parseInt);
                if (parseInt != 0) {
                    this.f9569a.onFailure(this.f9570b);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("local");
                if (optJSONObject != null) {
                    this.f9570b.country = optJSONObject.optString("country");
                    this.f9570b.province = optJSONObject.optString("provice");
                    this.f9570b.city = optJSONObject.optString("city");
                }
                this.f9569a.onSuccess(this.f9570b);
            } catch (Throwable th) {
                this.f9569a.onFailure(this.f9570b);
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
            if (f9549c == null) {
                f9549c = new QrCodeService(sapiConfiguration, str);
            }
            qrCodeService = f9549c;
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
        if (!TextUtils.isEmpty(getQrCodeImageDTO.encuid)) {
            httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_ENCUID, getQrCodeImageDTO.encuid);
        }
        httpHashMapWrap.put("needQrCodeContent", getQrCodeImageDTO.needQrCodeContent ? "1" : "0");
        httpHashMapWrap.put("hostDeviceId", getQrCodeImageDTO.hostDeviceId);
        new HttpClientWrap().get(SapiEnv.GET_QR_CODE_IMAGE_URI, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), new a(Looper.getMainLooper(), sapiCallback, getQrCodeImageResult, z));
    }

    public void getQrCodeLoginWithEnuidImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO, String str, String str2) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        GetQrCodeImageDTO getQrCodeImageDTO2 = getQrCodeImageDTO == null ? new GetQrCodeImageDTO() : getQrCodeImageDTO;
        boolean z = getQrCodeImageDTO2.needQrCodeContent;
        GetQrCodeImageResult getQrCodeImageResult = new GetQrCodeImageResult();
        stopLoginStatusCheck();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_LP, TextUtils.isEmpty(getQrCodeImageDTO2.lp) ? "pc" : getQrCodeImageDTO2.lp);
        httpHashMapWrap.put("apiver", "v3");
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(getQrCodeImageDTO2.openPlatformId)) {
            httpHashMapWrap.put("openPlatformId", getQrCodeImageDTO2.openPlatformId);
        }
        if (!TextUtils.isEmpty(getQrCodeImageDTO2.encuid)) {
            httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_ENCUID, getQrCodeImageDTO2.encuid);
        }
        ArrayList arrayList = new ArrayList();
        String url = ServiceManager.getInstance().getIsAccountManager().getConfignation().environment.getURL();
        arrayList.add(ParamsUtil.buidCookie(HttpRequest.BDUSS, str, url));
        arrayList.add(ParamsUtil.buidCookie("STOKEN", str2, url));
        httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_ENCUID, "1");
        httpHashMapWrap.put("hostDeviceId", getQrCodeImageDTO2.hostDeviceId);
        new HttpClientWrap().get(SapiEnv.GET_QR_CODE_IMAGE_URI, ReqPriority.IMMEDIATE, httpHashMapWrap, arrayList, getUaInfo(), new b(Looper.getMainLooper(), sapiCallback, getQrCodeImageResult, z));
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
        this.f9550a = httpClientWrap;
        httpClientWrap.get(str3, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), new d(Looper.getMainLooper(), qrLoginStatusCheckCallback, qrLoginStatusCheckResult, z));
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
        new HttpClientWrap().post(sb.toString(), httpHashMapWrap, null, getUaInfo(), new e(Looper.getMainLooper(), sapiCallback, qrAppLoginResult));
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
        this.f9550a = httpClientWrap;
        this.f9551b = httpClientWrap.get(SapiEnv.GET_QR_LOGIN_STATUS_CHECK, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), 40000, new c(Looper.getMainLooper(), z, qrLoginStatusCheckCallback, qrLoginStatusCheckResult, qrLoginStstusCheckDTO));
    }

    public void stopLoginStatusCheck() {
        PassHttpClientRequest passHttpClientRequest = this.f9551b;
        if (passHttpClientRequest != null) {
            passHttpClientRequest.cancel();
        }
        if (this.f9550a != null) {
            this.f9550a = null;
        }
    }
}
