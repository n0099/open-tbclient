package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
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
import com.baidu.sapi2.utils.g;
import com.facebook.common.util.UriUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QrCodeService extends AbstractService implements NoProguard {

    /* renamed from: b  reason: collision with root package name */
    public static QrCodeService f10166b;

    /* renamed from: a  reason: collision with root package name */
    public HttpClientWrap f10167a;

    /* loaded from: classes2.dex */
    public class a extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f10168a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetQrCodeImageResult f10169b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f10170c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            this.f10168a = sapiCallback;
            this.f10169b = getQrCodeImageResult;
            this.f10170c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f10169b.setResultCode(i);
            this.f10168a.onFailure(this.f10169b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f10168a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f10168a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.f10169b.setResultCode(parseInt);
                this.f10169b.setResultMsg(optString);
                if (parseInt != 0) {
                    this.f10168a.onFailure(this.f10169b);
                    return;
                }
                GetQrCodeImageResult getQrCodeImageResult = this.f10169b;
                getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                this.f10169b.prompt = jSONObject.optString("prompt");
                this.f10169b.channelId = jSONObject.optString("sign");
                if (this.f10170c) {
                    this.f10169b.contentUrl = jSONObject.optString("qrcontent_url");
                }
                this.f10168a.onSuccess(this.f10169b);
            } catch (Throwable th) {
                this.f10168a.onFailure(this.f10169b);
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f10172a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckCallback f10173b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f10174c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrLoginStstusCheckDTO f10175d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, boolean z, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
            super(looper);
            this.f10172a = z;
            this.f10173b = qrLoginStatusCheckCallback;
            this.f10174c = qrLoginStatusCheckResult;
            this.f10175d = qrLoginStstusCheckDTO;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f10174c.setResultCode(i);
            this.f10173b.onFailure(this.f10174c);
            this.f10173b.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            if (this.f10172a) {
                this.f10173b.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.f10174c.setResultCode(parseInt);
                this.f10174c.setResultMsg(optString);
                if (parseInt != 0) {
                    if (parseInt != 1) {
                        this.f10173b.onFailure(this.f10174c);
                        this.f10173b.onFinish();
                        return;
                    }
                    QrCodeService.this.qrLoginStatusCheck(this.f10173b, this.f10175d, false);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                int optInt = jSONObject2.optInt("status");
                this.f10174c.status = optInt;
                if (optInt == 1) {
                    this.f10173b.onScanQrCodeDone(this.f10174c);
                    QrCodeService.this.qrLoginStatusCheck(this.f10173b, this.f10175d, false);
                } else if (optInt == 0) {
                    QrCodeService.this.getQrLoginResult(this.f10173b, this.f10174c, jSONObject2.optString("v"), this.f10175d.hostDeviceId, this.f10175d.isJoinCodeLogin);
                } else if (optInt == 2) {
                    this.f10174c.setResultCode(optInt);
                    this.f10174c.setResultMsg("您已取消操作");
                    this.f10173b.onFailure(this.f10174c);
                    this.f10173b.onFinish();
                } else {
                    QrCodeService.this.qrLoginStatusCheck(this.f10173b, this.f10175d, false);
                }
            } catch (Throwable th) {
                this.f10173b.onFailure(this.f10174c);
                this.f10173b.onFinish();
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckCallback f10177a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f10178b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f10179c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, boolean z) {
            super(looper);
            this.f10177a = qrLoginStatusCheckCallback;
            this.f10178b = qrLoginStatusCheckResult;
            this.f10179c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f10178b.setResultCode(i);
            this.f10177a.onFailure(this.f10178b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f10177a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            JSONObject optJSONObject;
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.f10178b.setResultCode(parseInt);
                this.f10178b.setResultMsg(optString);
                if (parseInt != 0 && parseInt != 110000) {
                    this.f10177a.onFailure(this.f10178b);
                    return;
                }
                if (this.f10179c) {
                    optJSONObject = jSONObject.optJSONObject("data");
                } else {
                    optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                }
                SapiAccount parseAccount = QrCodeService.this.parseAccount(optJSONObject);
                parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).tplStokenMap);
                ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                this.f10177a.onSuccess(this.f10178b);
            } catch (Throwable th) {
                this.f10177a.onFailure(this.f10178b);
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f10181a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrAppLoginResult f10182b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Looper looper, SapiCallback sapiCallback, QrAppLoginResult qrAppLoginResult) {
            super(looper);
            this.f10181a = sapiCallback;
            this.f10182b = qrAppLoginResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f10182b.setResultCode(i);
            this.f10181a.onFailure(this.f10182b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f10181a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f10181a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                this.f10182b.setResultCode(parseInt);
                if (parseInt != 0) {
                    this.f10181a.onFailure(this.f10182b);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("local");
                if (optJSONObject != null) {
                    this.f10182b.country = optJSONObject.optString("country");
                    this.f10182b.province = optJSONObject.optString("provice");
                    this.f10182b.city = optJSONObject.optString("city");
                }
                this.f10181a.onSuccess(this.f10182b);
            } catch (Throwable th) {
                this.f10181a.onFailure(this.f10182b);
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
            if (f10166b == null) {
                f10166b = new QrCodeService(sapiConfiguration, str);
            }
            qrCodeService = f10166b;
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
        new HttpClientWrap().get(g.j, httpHashMapWrap, null, getUaInfo(), new a(Looper.getMainLooper(), sapiCallback, getQrCodeImageResult, z));
    }

    public void getQrLoginResult(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, String str, String str2, boolean z) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("display", "pcsdk");
        httpHashMapWrap.put("qrcode", "1");
        httpHashMapWrap.put("bduss", str);
        httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("hostDeviceId", str2);
        String str3 = z ? g.m : g.l;
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        this.f10167a = httpClientWrap;
        httpClientWrap.get(str3, httpHashMapWrap, null, getUaInfo(), new c(Looper.getMainLooper(), qrLoginStatusCheckCallback, qrLoginStatusCheckResult, z));
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
            httpHashMapWrap.put(SapiAccount.f10190h, currentAccount.ptoken);
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
        this.f10167a = httpClientWrap;
        httpClientWrap.get(g.k, httpHashMapWrap, null, getUaInfo(), 40000, new b(Looper.getMainLooper(), z, qrLoginStatusCheckCallback, qrLoginStatusCheckResult, qrLoginStstusCheckDTO));
    }

    public void stopLoginStatusCheck() {
        HttpClientWrap httpClientWrap = this.f10167a;
        if (httpClientWrap != null) {
            httpClientWrap.cancelRequest();
            this.f10167a = null;
        }
    }
}
