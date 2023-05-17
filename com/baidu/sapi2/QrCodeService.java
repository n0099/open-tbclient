package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import androidx.media2.session.SessionCommand;
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
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.webkit.sdk.WebChromeClient;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class QrCodeService extends AbstractService implements NoProguard {
    public static QrCodeService c;
    public HttpClientWrap a;
    public PassHttpClientRequest b;

    /* loaded from: classes3.dex */
    public class a extends HttpHandlerWrap {
        public final /* synthetic */ SapiCallback a;
        public final /* synthetic */ GetQrCodeImageResult b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            this.a = sapiCallback;
            this.b = getQrCodeImageResult;
            this.c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            String message;
            this.b.setResultCode(i);
            GetQrCodeImageResult getQrCodeImageResult = this.b;
            if (th == null) {
                message = "";
            } else {
                message = th.getMessage();
            }
            getQrCodeImageResult.setResultMsg(message);
            this.a.onFailure(this.b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.b.setResultCode(parseInt);
                this.b.setResultMsg(optString);
                if (parseInt != 0) {
                    this.a.onFailure(this.b);
                    return;
                }
                GetQrCodeImageResult getQrCodeImageResult = this.b;
                getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
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

    /* loaded from: classes3.dex */
    public class b extends HttpHandlerWrap {
        public final /* synthetic */ SapiCallback a;
        public final /* synthetic */ GetQrCodeImageResult b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            this.a = sapiCallback;
            this.b = getQrCodeImageResult;
            this.c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.b.setResultCode(i);
            this.a.onFailure(this.b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.b.setResultCode(parseInt);
                this.b.setResultMsg(optString);
                if (parseInt != 0) {
                    this.a.onFailure(this.b);
                    return;
                }
                GetQrCodeImageResult getQrCodeImageResult = this.b;
                getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
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

    /* loaded from: classes3.dex */
    public class c extends HttpHandlerWrap {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ QrLoginStatusCheckCallback b;
        public final /* synthetic */ QrLoginStatusCheckResult c;
        public final /* synthetic */ QrLoginStstusCheckDTO d;

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, boolean z, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
            super(looper);
            this.a = z;
            this.b = qrLoginStatusCheckCallback;
            this.c = qrLoginStatusCheckResult;
            this.d = qrLoginStstusCheckDTO;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.c.setResultCode(i);
            this.b.onFailure(this.c);
            this.b.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            if (this.a) {
                this.b.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.c.setResultCode(parseInt);
                this.c.setResultMsg(optString);
                if (parseInt != 0) {
                    if (parseInt != 1) {
                        this.b.onFailure(this.c);
                        this.b.onFinish();
                        return;
                    }
                    QrCodeService.this.qrLoginStatusCheck(this.b, this.d, false);
                    return;
                }
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
            } catch (Throwable th) {
                this.b.onFailure(this.c);
                this.b.onFinish();
                Log.e(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends HttpHandlerWrap {
        public final /* synthetic */ QrLoginStatusCheckCallback a;
        public final /* synthetic */ QrLoginStatusCheckResult b;
        public final /* synthetic */ boolean c;

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Looper looper, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, boolean z) {
            super(looper);
            this.a = qrLoginStatusCheckCallback;
            this.b = qrLoginStatusCheckResult;
            this.c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.b.setResultCode(i);
            this.a.onFailure(this.b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            JSONObject optJSONObject;
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                String optString = jSONObject.optString("errmsg");
                this.b.setResultCode(parseInt);
                this.b.setResultMsg(optString);
                if (parseInt != 0 && parseInt != 110000) {
                    this.a.onFailure(this.b);
                    return;
                }
                if (this.c) {
                    optJSONObject = jSONObject.optJSONObject("data");
                } else {
                    optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                }
                SapiAccount parseAccount = QrCodeService.this.parseAccount(optJSONObject);
                parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).tplStokenMap);
                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.QR.getName());
                ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                this.a.onSuccess(this.b);
            } catch (Throwable th) {
                this.a.onFailure(this.b);
                Log.e(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends HttpHandlerWrap {
        public final /* synthetic */ SapiCallback a;
        public final /* synthetic */ QrAppLoginResult b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Looper looper, SapiCallback sapiCallback, QrAppLoginResult qrAppLoginResult) {
            super(looper);
            this.a = sapiCallback;
            this.b = qrAppLoginResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.b.setResultCode(i);
            this.a.onFailure(this.b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
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

    public QrCodeService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    public static synchronized QrCodeService getInstance(SapiConfiguration sapiConfiguration, String str) {
        QrCodeService qrCodeService;
        synchronized (QrCodeService.class) {
            if (c == null) {
                c = new QrCodeService(sapiConfiguration, str);
            }
            qrCodeService = c;
        }
        return qrCodeService;
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        String str;
        String str2;
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        if (getQrCodeImageDTO == null) {
            getQrCodeImageDTO = new GetQrCodeImageDTO();
        }
        boolean z = getQrCodeImageDTO.needQrCodeContent;
        GetQrCodeImageResult getQrCodeImageResult = new GetQrCodeImageResult();
        stopLoginStatusCheck();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        if (TextUtils.isEmpty(getQrCodeImageDTO.lp)) {
            str = "pc";
        } else {
            str = getQrCodeImageDTO.lp;
        }
        httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_LP, str);
        httpHashMapWrap.put("apiver", "v3");
        httpHashMapWrap.put("tt", String.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(getQrCodeImageDTO.openPlatformId)) {
            httpHashMapWrap.put("openPlatformId", getQrCodeImageDTO.openPlatformId);
        }
        if (!TextUtils.isEmpty(getQrCodeImageDTO.encuid)) {
            httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_ENCUID, getQrCodeImageDTO.encuid);
        }
        if (getQrCodeImageDTO.needQrCodeContent) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        httpHashMapWrap.put("needQrCodeContent", str2);
        httpHashMapWrap.put("hostDeviceId", getQrCodeImageDTO.hostDeviceId);
        new HttpClientWrap().get(SapiEnv.GET_QR_CODE_IMAGE_URI, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), new a(Looper.getMainLooper(), sapiCallback, getQrCodeImageResult, z));
    }

    public void getQrCodeLoginWithEnuidImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO, String str, String str2) {
        GetQrCodeImageDTO getQrCodeImageDTO2;
        String str3;
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        if (getQrCodeImageDTO == null) {
            getQrCodeImageDTO2 = new GetQrCodeImageDTO();
        } else {
            getQrCodeImageDTO2 = getQrCodeImageDTO;
        }
        boolean z = getQrCodeImageDTO2.needQrCodeContent;
        GetQrCodeImageResult getQrCodeImageResult = new GetQrCodeImageResult();
        stopLoginStatusCheck();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        if (TextUtils.isEmpty(getQrCodeImageDTO2.lp)) {
            str3 = "pc";
        } else {
            str3 = getQrCodeImageDTO2.lp;
        }
        httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_LP, str3);
        httpHashMapWrap.put("apiver", "v3");
        httpHashMapWrap.put("tt", String.valueOf(System.currentTimeMillis()));
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
        String str3;
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put(CriusAttrConstants.DISPLAY, "pcsdk");
        httpHashMapWrap.put("qrcode", "1");
        httpHashMapWrap.put("bduss", str);
        httpHashMapWrap.put("tt", String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("hostDeviceId", str2);
        if (z) {
            str3 = SapiEnv.GET_QR_JOIN_LOGIN_RESULT;
        } else {
            str3 = SapiEnv.GET_QR_LOGIN_RESULT;
        }
        String str4 = str3;
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        this.a = httpClientWrap;
        httpClientWrap.get(str4, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), new d(Looper.getMainLooper(), qrLoginStatusCheckCallback, qrLoginStatusCheckResult, z));
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        String str3;
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
        StringBuilder sb = new StringBuilder();
        sb.append("/v2/sapi/qrlogin?lp=");
        if (TextUtils.isEmpty(urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP))) {
            str3 = "app";
        } else {
            str3 = urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP);
        }
        sb.append(str3);
        new HttpClientWrap().post(sb.toString(), httpHashMapWrap, null, getUaInfo(), new e(Looper.getMainLooper(), sapiCallback, qrAppLoginResult));
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO, boolean z) {
        SapiUtils.notNull(qrLoginStatusCheckCallback, SapiCallback.class.getSimpleName() + " can't be null");
        QrLoginStatusCheckResult qrLoginStatusCheckResult = new QrLoginStatusCheckResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("apiver", "v3");
        httpHashMapWrap.put(WebChromeClient.KEY_ARG_CALLBACK, "cb");
        httpHashMapWrap.put("channel_id", qrLoginStstusCheckDTO.channelId);
        httpHashMapWrap.put("tt", String.valueOf(System.currentTimeMillis()));
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        this.a = httpClientWrap;
        this.b = httpClientWrap.get(SapiEnv.GET_QR_LOGIN_STATUS_CHECK, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, new c(Looper.getMainLooper(), z, qrLoginStatusCheckCallback, qrLoginStatusCheckResult, qrLoginStstusCheckDTO));
    }

    public void stopLoginStatusCheck() {
        PassHttpClientRequest passHttpClientRequest = this.b;
        if (passHttpClientRequest != null) {
            passHttpClientRequest.cancel();
        }
        if (this.a != null) {
            this.a = null;
        }
    }
}
