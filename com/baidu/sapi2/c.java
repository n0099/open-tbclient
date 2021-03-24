package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static final String f11117b = "c";

    /* renamed from: c  reason: collision with root package name */
    public static final int f11118c = 6;

    /* renamed from: d  reason: collision with root package name */
    public static final String f11119d = "3";

    /* renamed from: a  reason: collision with root package name */
    public SapiConfiguration f11120a = SapiAccountManager.getInstance().getSapiConfiguration();

    /* loaded from: classes2.dex */
    public class a extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IqiyiLoginCallback f11121a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IqiyiLoginResult f11122b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginResult iqiyiLoginResult) {
            super(looper);
            this.f11121a = iqiyiLoginCallback;
            this.f11122b = iqiyiLoginResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f11122b.setResultCode(i);
            this.f11121a.onFailure(this.f11122b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f11121a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            if (c.this.b(str) != 302) {
                SocialResponse b2 = SapiWebView.b(str, c.this.f11120a.context);
                if (b2 == null) {
                    this.f11122b.setResultCode(-100);
                    this.f11122b.setResultMsg("登录失败");
                    this.f11121a.onFailure(this.f11122b);
                    return;
                } else if (b2.errorCode != -100) {
                    this.f11122b.setResultCode(-100);
                    this.f11122b.setResultMsg("登录失败");
                    this.f11121a.onFailure(this.f11122b);
                    return;
                } else {
                    SapiAccount a2 = c.this.a(b2);
                    a2.addSocialInfo(b2.socialType, b2.socialPortraitUrl);
                    a2.putExtra("account_type", Integer.valueOf(b2.accountType.getType()));
                    a2.addDispersionCertification(b2.tplStokenMap);
                    a2.addIsGuestAccount(b2.isGuestAccount);
                    a2.putExtra("tpl", c.this.f11120a.tpl);
                    SapiAccountManager.getInstance().validate(a2);
                    this.f11121a.onSuccess(this.f11122b);
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f11122b.nextUrl = jSONObject.optString("next_url");
                this.f11121a.onBindWebview(this.f11122b);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f11124a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CheckUserFaceIdResult f11125b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, SapiCallback sapiCallback, CheckUserFaceIdResult checkUserFaceIdResult) {
            super(looper);
            this.f11124a = sapiCallback;
            this.f11125b = checkUserFaceIdResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f11125b.setResultCode(i);
            this.f11124a.onFailure(this.f11125b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f11124a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f11124a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                this.f11125b.setResultCode(parseInt);
                this.f11125b.setResultMsg(jSONObject.optString("errmsg"));
                if (parseInt == 0) {
                    this.f11125b.status = jSONObject.optInt("status");
                    this.f11125b.livingUname = jSONObject.optString("livinguname");
                    this.f11125b.authsid = jSONObject.optString("authsid");
                    this.f11125b.authWidgetURL = jSONObject.optString("authurl");
                    this.f11125b.action = jSONObject.optString("action");
                    this.f11124a.onSuccess(this.f11125b);
                } else {
                    this.f11124a.onFailure(this.f11125b);
                }
            } catch (Throwable unused) {
                this.f11125b.setResultCode(-202);
                this.f11124a.onFailure(this.f11125b);
            }
        }
    }

    /* renamed from: com.baidu.sapi2.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0139c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f11127a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FaceLoginStatusResult f11128b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0139c(Looper looper, SapiCallback sapiCallback, FaceLoginStatusResult faceLoginStatusResult) {
            super(looper);
            this.f11127a = sapiCallback;
            this.f11128b = faceLoginStatusResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f11128b.setResultCode(i);
            this.f11127a.onFailure(this.f11128b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f11127a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f11127a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                this.f11128b.setResultCode(parseInt);
                this.f11128b.setResultMsg(jSONObject.optString("errmsg"));
                if (parseInt == 0) {
                    this.f11128b.status = jSONObject.optInt("status");
                    this.f11128b.livingUname = jSONObject.optString("livinguname");
                    this.f11128b.authsid = jSONObject.optString("authsid");
                    this.f11128b.authWidgetURL = jSONObject.optString("authurl");
                    FaceLoginStatusResult faceLoginStatusResult = this.f11128b;
                    boolean z = true;
                    if (jSONObject.optInt("faceLoginEnabled") != 1) {
                        z = false;
                    }
                    faceLoginStatusResult.faceLoginSwitch = z;
                    this.f11127a.onSuccess(this.f11128b);
                } else {
                    this.f11127a.onFailure(this.f11128b);
                }
            } catch (Throwable unused) {
                this.f11128b.setResultCode(-202);
                this.f11127a.onFailure(this.f11128b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f11130a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CheckUserFaceIdResult f11131b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f11132c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Looper looper, SapiCallback sapiCallback, CheckUserFaceIdResult checkUserFaceIdResult, boolean z) {
            super(looper);
            this.f11130a = sapiCallback;
            this.f11131b = checkUserFaceIdResult;
            this.f11132c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f11131b.setResultCode(i);
            this.f11130a.onFailure(this.f11131b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f11130a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f11130a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                this.f11131b.setResultCode(parseInt);
                this.f11131b.setResultMsg(jSONObject.optString("errmsg"));
                if (parseInt == 0) {
                    if (this.f11132c) {
                        String optString = jSONObject.optString("livinguname");
                        if (!TextUtils.isEmpty(optString)) {
                            new FaceLoginService().syncFaceLoginUID(c.this.f11120a.context, optString);
                        }
                    }
                    this.f11130a.onSuccess(this.f11131b);
                    return;
                }
                this.f11130a.onFailure(this.f11131b);
            } catch (Throwable unused) {
                this.f11131b.setResultCode(-202);
                this.f11130a.onFailure(this.f11131b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f11138a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SapiResult f11139b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Looper looper, SapiCallback sapiCallback, SapiResult sapiResult) {
            super(looper);
            this.f11138a = sapiCallback;
            this.f11139b = sapiResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f11139b.setResultCode(i);
            this.f11139b.setResultMsg(str);
            this.f11138a.onFailure(this.f11139b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f11138a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f11138a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f11139b.setResultCode(jSONObject.optInt("errno"));
                this.f11139b.setResultMsg(jSONObject.optString("errmsg"));
            } catch (JSONException e2) {
                Log.e(e2);
            }
            if (this.f11139b.getResultCode() == 0) {
                this.f11138a.onSuccess(this.f11139b);
            } else {
                this.f11138a.onFailure(this.f11139b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11141a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OneKeyLoginCallback f11142b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Looper looper, String str, OneKeyLoginCallback oneKeyLoginCallback) {
            super(looper);
            this.f11141a = str;
            this.f11142b = oneKeyLoginCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            String str2 = c.f11117b;
            Log.d(str2, "onFailure, error = " + th + ", errorCode = " + i + ", responseBody = " + str);
            SapiStatUtil.statOneKeyCheckAbility(i, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_NET_ERROR, false, OneKeyLoginSdkCall.getInstance().getOperatorType());
            new OneKeyLoginSdkCall().preGetPhoneFail(this.f11142b, i, null);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            c.this.a(i, str, this.f11141a, this.f11142b);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements com.baidu.sapi2.callback.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OneKeyLoginCallback f11148a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.baidu.sapi2.callback.a.c f11149b;

        /* loaded from: classes2.dex */
        public class a extends HttpHandlerWrap {
            public a(Looper looper) {
                super(looper);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                String str2 = c.f11117b;
                Log.d(str2, "onFailure, error = " + th + ", errorCode = " + i + ", responseBody = " + str);
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(i.this.f11148a, -100, null);
                SapiStatUtil.statOneKeyLoginPassAction(0, "-114", "net error");
            }

            /* JADX WARN: Removed duplicated region for block: B:42:0x0104 A[Catch: Exception -> 0x012a, TryCatch #0 {Exception -> 0x012a, blocks: (B:3:0x0029, B:6:0x004d, B:8:0x005a, B:9:0x0071, B:11:0x007e, B:14:0x0088, B:16:0x0090, B:19:0x0099, B:21:0x00a1, B:24:0x00aa, B:26:0x00b2, B:28:0x00b8, B:30:0x00c0, B:40:0x00fe, B:42:0x0104, B:43:0x011d, B:31:0x00d1, B:33:0x00e2, B:35:0x00e8, B:36:0x00ef, B:38:0x00f5), top: B:48:0x0029 }] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x011d A[Catch: Exception -> 0x012a, TRY_LEAVE, TryCatch #0 {Exception -> 0x012a, blocks: (B:3:0x0029, B:6:0x004d, B:8:0x005a, B:9:0x0071, B:11:0x007e, B:14:0x0088, B:16:0x0090, B:19:0x0099, B:21:0x00a1, B:24:0x00aa, B:26:0x00b2, B:28:0x00b8, B:30:0x00c0, B:40:0x00fe, B:42:0x0104, B:43:0x011d, B:31:0x00d1, B:33:0x00e2, B:35:0x00e8, B:36:0x00ef, B:38:0x00f5), top: B:48:0x0029 }] */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
                String optString;
                Log.d(c.f11117b, "onSuccess, statusCode = " + i + ", response = " + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("errInfo");
                    String optString2 = optJSONObject.optString("no");
                    String optString3 = optJSONObject.optString("msg");
                    SapiStatUtil.statOneKeyLoginPassAction(0, optString2, optString3);
                    if ("0".equals(optString2)) {
                        c.this.a(hashMap);
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                        if (optJSONObject2 != null) {
                            SapiAccountManager.getInstance().getAccountService().handleOneKeyLoginResult(i.this.f11148a, optJSONObject2.optString("xml"));
                            return;
                        } else {
                            new OneKeyLoginSdkCall().loadOneKeyLoginFail(i.this.f11148a, -100, null);
                            return;
                        }
                    }
                    if (!"400101".equals(optString2) && !"400031".equals(optString2) && !"400023".equals(optString2)) {
                        if (!"400704".equals(optString2) && !"400706".equals(optString2)) {
                            if ("400801".equals(optString2)) {
                                JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
                                new OneKeyLoginSdkCall().transMobile(i.this.f11148a, Integer.parseInt(optString2), optJSONObject3 != null ? optJSONObject3.optString("mobile") : "");
                                optString = null;
                                if (!TextUtils.isEmpty(optString)) {
                                    OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
                                    oneKeyLoginResult.setResultCode(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
                                    i.this.f11148a.onGuideProcess(oneKeyLoginResult);
                                    i.this.f11149b.a("", optString);
                                    return;
                                }
                                new OneKeyLoginSdkCall().loadOneKeyLoginFail(i.this.f11148a, -100, null);
                                return;
                            }
                            new OneKeyLoginSdkCall().loadOneKeyLoginFail(i.this.f11148a, Integer.parseInt(optString2), optString3);
                            return;
                        }
                        JSONObject optJSONObject4 = jSONObject.optJSONObject("data");
                        if (optJSONObject4 != null) {
                            optString = optJSONObject4.optString("ppDatau");
                            if (!TextUtils.isEmpty(optString)) {
                            }
                        }
                        optString = null;
                        if (!TextUtils.isEmpty(optString)) {
                        }
                    }
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("data");
                    if (optJSONObject5 != null) {
                        optString = optJSONObject5.optString("verifyUrl");
                        if (!TextUtils.isEmpty(optString)) {
                        }
                    }
                    optString = null;
                    if (!TextUtils.isEmpty(optString)) {
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                    new OneKeyLoginSdkCall().loadOneKeyLoginFail(i.this.f11148a, -100, null);
                    SapiStatUtil.statOneKeyLoginPassAction(0, "-113", "json error");
                }
            }
        }

        public i(OneKeyLoginCallback oneKeyLoginCallback, com.baidu.sapi2.callback.a.c cVar) {
            this.f11148a = oneKeyLoginCallback;
            this.f11149b = cVar;
        }

        @Override // com.baidu.sapi2.callback.a.a
        public void a(String str) {
            JSONObject jSONObject = null;
            if (TextUtils.isEmpty(str)) {
                Log.e(c.f11117b, "oneKeyLogin execute JavaScript failed, it only support after KitKat version");
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.f11148a, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_EXECUTE_JS_FAIL, null);
                SapiStatUtil.statOneKeyLoginPassAction(-1, "-100", "js execute fail");
                return;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            HttpHashMap httpHashMap = new HttpHashMap();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    httpHashMap.put(next, jSONObject.optString(next));
                }
            }
            httpHashMap.put("oneKeySdkVersion", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
            String l = c.this.l();
            new HttpClientWrap().post(l, httpHashMap, ParamsUtil.buildNaCookie(l, c.this.f11120a), c.this.x(), new a(Looper.getMainLooper()));
        }
    }

    /* loaded from: classes2.dex */
    public class j extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11152a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v f11153b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Looper looper, String str, v vVar) {
            super(looper);
            this.f11152a = str;
            this.f11153b = vVar;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            v vVar = this.f11153b;
            if (vVar != null) {
                vVar.a(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, "");
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            String md5 = SecurityUtil.md5(str.getBytes(), false);
            String str2 = this.f11152a;
            if (str2 != null && str2.equals(md5)) {
                SapiContext.getInstance().setOneKeyLoginJSCode(str);
                SapiContext.getInstance().setOnekeyLoginJsMd5(this.f11152a);
                v vVar = this.f11153b;
                if (vVar != null) {
                    vVar.a();
                    return;
                }
                return;
            }
            v vVar2 = this.f11153b;
            if (vVar2 != null) {
                vVar2.a(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL, "");
            }
            Log.d(c.f11117b, "oneKeyLogin check javsScript MD5 failed");
        }
    }

    /* loaded from: classes2.dex */
    public class k extends GetUserInfoCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Web2NativeLoginResult f11155a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Web2NativeLoginCallback f11156b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f11157c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f11158d;

        public k(Web2NativeLoginResult web2NativeLoginResult, Web2NativeLoginCallback web2NativeLoginCallback, String str, String str2) {
            this.f11155a = web2NativeLoginResult;
            this.f11156b = web2NativeLoginCallback;
            this.f11157c = str;
            this.f11158d = str2;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            this.f11156b.onFinish();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            this.f11156b.onStart();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            this.f11155a.setResultCode(400021);
            this.f11156b.onBdussExpired(this.f11155a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            this.f11155a.setResultCode(-202);
            this.f11156b.onFailure(this.f11155a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = getUserInfoResult.uid;
            sapiAccount.username = getUserInfoResult.username;
            sapiAccount.displayname = getUserInfoResult.displayname;
            sapiAccount.bduss = this.f11157c;
            if (!TextUtils.isEmpty(this.f11158d)) {
                sapiAccount.ptoken = this.f11158d;
            }
            sapiAccount.app = SapiUtils.getAppName(c.this.f11120a.context);
            SapiAccountManager.getInstance().validate(sapiAccount);
            this.f11155a.setResultCode(0);
            this.f11156b.onSuccess(this.f11155a);
            new com.baidu.sapi2.utils.c().a(com.baidu.sapi2.utils.c.f11447g);
        }
    }

    /* loaded from: classes2.dex */
    public class l extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.sapi2.callback.a.b f11160a;

        public l(com.baidu.sapi2.callback.a.b bVar) {
            this.f11160a = bVar;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Log.d(com.baidu.sapi2.share.d.f11376a, "requestShareV3AppFromCloud fail responseBody=" + str);
            this.f11160a.onFailure();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            JSONObject jSONObject;
            JSONObject optJSONObject;
            Log.d(com.baidu.sapi2.share.d.f11376a, "requestShareV3AppFromCloud success response=" + str);
            JSONArray jSONArray = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                Log.e(c.f11117b, e2.getMessage());
                jSONObject = null;
            }
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                jSONArray = optJSONObject.optJSONArray("list");
            }
            if (jSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    ShareStorage.StorageModel fromJSON = ShareStorage.StorageModel.fromJSON(jSONArray.optJSONObject(i2));
                    if (fromJSON != null) {
                        arrayList.add(fromJSON);
                    }
                }
                SapiContext.getInstance().put(SapiContext.KEY_SHARE_MODELS_FROM_CLOUD_CACHE, jSONArray.toString());
                this.f11160a.a(arrayList);
                return;
            }
            this.f11160a.onFailure();
        }
    }

    /* loaded from: classes2.dex */
    public class m extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f11162a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Looper looper, int i) {
            super(looper);
            this.f11162a = i;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            SapiStatUtil.statSetCloudShareAccount(this.f11162a, 2);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Log.d(c.f11117b, "set clound share account start");
            SapiStatUtil.statSetCloudShareAccount(this.f11162a, 0);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                if (new JSONObject(str).optInt("code") == 110000) {
                    SapiStatUtil.statSetCloudShareAccount(this.f11162a, 1);
                    return;
                }
            } catch (Exception e2) {
                Log.e(e2);
            }
            SapiStatUtil.statSetCloudShareAccount(this.f11162a, 2);
        }
    }

    /* loaded from: classes2.dex */
    public class n extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallBack f11164a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f11165b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SapiDataEncryptor f11166c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f11167d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11168e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Looper looper, SapiCallBack sapiCallBack, boolean z, SapiDataEncryptor sapiDataEncryptor, String str, String str2) {
            super(looper);
            this.f11164a = sapiCallBack;
            this.f11165b = z;
            this.f11166c = sapiDataEncryptor;
            this.f11167d = str;
            this.f11168e = str2;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            if (i == -201) {
                this.f11164a.onNetworkFailed();
            } else {
                this.f11164a.onSystemError(i);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            if (!TextUtils.isEmpty(str)) {
                c.this.a(-100, this.f11164a, str, this.f11165b, this.f11166c);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                c.this.a(this.f11164a, jSONObject.optString("cert"), jSONObject.optString("cert_id"), this.f11167d, this.f11168e, this.f11165b, this.f11166c);
            } catch (Exception e2) {
                c.this.a(-100, this.f11164a, str, this.f11165b, this.f11166c);
                Log.e(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallBack f11170a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f11171b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SapiDataEncryptor f11172c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Looper looper, SapiCallBack sapiCallBack, boolean z, SapiDataEncryptor sapiDataEncryptor) {
            super(looper);
            this.f11170a = sapiCallBack;
            this.f11171b = z;
            this.f11172c = sapiDataEncryptor;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            if (i == -201) {
                this.f11170a.onNetworkFailed();
            } else {
                this.f11170a.onSystemError(i);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            c cVar = c.this;
            cVar.a(cVar.b(str), this.f11170a, str, this.f11171b, this.f11172c);
        }
    }

    /* loaded from: classes2.dex */
    public class p extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetUserInfoCallback f11174a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetUserInfoResult f11175b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Looper looper, GetUserInfoCallback getUserInfoCallback, GetUserInfoResult getUserInfoResult) {
            super(looper);
            this.f11174a = getUserInfoCallback;
            this.f11175b = getUserInfoResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f11175b.setResultCode(i);
            this.f11174a.onFailure(this.f11175b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f11174a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f11174a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            int b2 = c.this.b(str);
            this.f11175b.setResultCode(b2);
            if (b2 != 0) {
                if (b2 != 400021) {
                    this.f11174a.onFailure(this.f11175b);
                    return;
                } else {
                    this.f11174a.onBdussExpired(this.f11175b);
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f11175b.portraitSign = jSONObject.optString("portrait_tag");
                this.f11175b.isInitialPortrait = "0".equals(this.f11175b.portraitSign);
                String optString = jSONObject.optString("portrait");
                if (!TextUtils.isEmpty(optString)) {
                    this.f11175b.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.f11175b.portraitSign);
                    this.f11175b.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.f11175b.portraitSign);
                }
                this.f11175b.username = jSONObject.optString("username");
                this.f11175b.uid = jSONObject.optString(DpStatConstants.KEY_USER_ID);
                this.f11175b.displayname = jSONObject.optString("displayname");
                this.f11175b.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                this.f11175b.secureMobile = jSONObject.optString("securemobil");
                this.f11175b.secureEmail = jSONObject.optString("secureemail");
                this.f11175b.havePwd = "1".equals(jSONObject.optString("have_psw"));
                this.f11175b.carSdkFace = jSONObject.optInt("carSdkFace");
                this.f11175b.faceLoginSwitch = jSONObject.optInt("faceLoginSwitch");
                this.f11174a.onSuccess(this.f11175b);
            } catch (Exception unused) {
                this.f11174a.onFailure(this.f11175b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class q extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FillUsernameCallback f11177a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FillUsernameResult f11178b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SapiDataEncryptor f11179c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(Looper looper, FillUsernameCallback fillUsernameCallback, FillUsernameResult fillUsernameResult, SapiDataEncryptor sapiDataEncryptor) {
            super(looper);
            this.f11177a = fillUsernameCallback;
            this.f11178b = fillUsernameResult;
            this.f11179c = sapiDataEncryptor;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f11178b.setResultCode(i);
            this.f11177a.onFailure(this.f11178b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f11177a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f11177a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            int b2 = c.this.b(str);
            this.f11178b.setResultCode(b2);
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f11178b.setResultMsg(jSONObject.optString("errmsg"));
                JSONObject jSONObject2 = new JSONObject(this.f11179c.decrypt(jSONObject.optString(TableDefine.DB_TABLE_USERINFO)));
                if (b2 != 0 && b2 != 110000) {
                    if (b2 == 160103) {
                        this.f11177a.onBdussExpired(this.f11178b);
                        return;
                    } else if (b2 != 160104) {
                        this.f11177a.onFailure(this.f11178b);
                        return;
                    } else {
                        this.f11177a.onUserHaveUsername(this.f11178b);
                        return;
                    }
                }
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.bduss = jSONObject2.optString("bduss");
                sapiAccount.ptoken = jSONObject2.optString(SapiAccount.f10605h);
                sapiAccount.stoken = jSONObject2.optString("stoken");
                sapiAccount.displayname = jSONObject2.optString("displayname");
                sapiAccount.username = jSONObject2.optString("uname");
                sapiAccount.uid = jSONObject2.optString("uid");
                sapiAccount.app = SapiUtils.getAppName(c.this.f11120a.context);
                sapiAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject2).tplStokenMap);
                sapiAccount.putExtra("tpl", c.this.f11120a.tpl);
                SapiAccountManager.getInstance().validate(sapiAccount);
                this.f11178b.session = sapiAccount;
                this.f11177a.onSuccess(this.f11178b);
                new com.baidu.sapi2.utils.c().a(com.baidu.sapi2.utils.c.f11446f);
            } catch (Throwable th) {
                this.f11177a.onFailure(this.f11178b);
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class r extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetTplStokenCallback f11181a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetTplStokenResult f11182b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SapiAccount f11183c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f11184d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11185e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11186f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Looper looper, GetTplStokenCallback getTplStokenCallback, GetTplStokenResult getTplStokenResult, SapiAccount sapiAccount, List list, boolean z, String str) {
            super(looper);
            this.f11181a = getTplStokenCallback;
            this.f11182b = getTplStokenResult;
            this.f11183c = sapiAccount;
            this.f11184d = list;
            this.f11185e = z;
            this.f11186f = str;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            if (TextUtils.isEmpty(this.f11186f)) {
                return;
            }
            this.f11182b.setResultCode(i);
            this.f11181a.onFailure(this.f11182b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f11181a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f11181a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                this.f11182b.setResultCode(parseInt);
                if (parseInt == 0) {
                    Map<String, String> tplStokenMap = SapiAccount.DispersionCertification.getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
                    this.f11182b.tplStokenMap = tplStokenMap;
                    SapiAccount.ExtraProperty extraProperty = new SapiAccount.ExtraProperty();
                    if (!TextUtils.isEmpty(this.f11183c.extra)) {
                        extraProperty = SapiAccount.ExtraProperty.fromJSONObject(new JSONObject(this.f11183c.extra));
                    }
                    extraProperty.dispersionCertification.tplStokenMap.putAll(tplStokenMap);
                    this.f11183c.extra = extraProperty.toJSONObject().toString();
                    if (this.f11184d.size() == tplStokenMap.size()) {
                        if (this.f11185e) {
                            SapiAccountManager.getInstance().validate(this.f11183c);
                        } else {
                            SapiContext.getInstance().setCurrentAccount(this.f11183c);
                            SapiContext.getInstance().addLoginAccount(this.f11183c);
                            new com.baidu.sapi2.share.a().a(5);
                        }
                        this.f11181a.onSuccess(this.f11182b);
                        return;
                    }
                    this.f11182b.setResultCode(-306);
                    this.f11181a.onFailure(this.f11182b);
                } else if (parseInt != 8) {
                    if (TextUtils.isEmpty(this.f11186f)) {
                        return;
                    }
                    this.f11182b.setResultMsg(jSONObject.optString("errmsg"));
                    this.f11181a.onFailure(this.f11182b);
                } else if (TextUtils.isEmpty(this.f11186f)) {
                } else {
                    String optString = jSONObject.optString("ssnerror");
                    if (TextUtils.isEmpty(optString)) {
                        optString = "0";
                    }
                    int parseInt2 = Integer.parseInt(optString);
                    if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH.ordinal()) {
                        this.f11182b.failureType = GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH;
                    } else if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_EXPIRED.ordinal()) {
                        this.f11182b.failureType = GetTplStokenResult.FailureType.BDUSS_EXPIRED;
                    }
                    this.f11182b.setResultMsg(jSONObject.optString("errmsg"));
                    this.f11181a.onFailure(this.f11182b);
                }
            } catch (Exception e2) {
                Log.e(e2);
                if (TextUtils.isEmpty(this.f11186f)) {
                    return;
                }
                this.f11182b.setResultCode(-205);
                this.f11181a.onFailure(this.f11182b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class s extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f11188a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11189b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f11190c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(Looper looper, SapiCallback sapiCallback, String str, String str2) {
            super(looper);
            this.f11188a = sapiCallback;
            this.f11189b = str;
            this.f11190c = str2;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            String str2 = c.f11117b;
            Log.d(str2, "oauth failure: code=" + i + " body=" + str);
            OAuthResult oAuthResult = new OAuthResult();
            oAuthResult.setResultCode(i);
            this.f11188a.onFailure(oAuthResult);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f11188a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f11188a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            JSONObject jSONObject;
            String str2 = c.f11117b;
            Log.d(str2, "oauth success: " + str);
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                String str3 = c.f11117b;
                Log.e(str3, "formatOauthResult: " + e2.getMessage());
                jSONObject = null;
            }
            if (jSONObject != null) {
                try {
                    jSONObject.put("extra", str);
                    jSONObject.put("cachedTimeSecond", System.currentTimeMillis() / 1000);
                } catch (JSONException e3) {
                    String str4 = c.f11117b;
                    Log.e(str4, "" + e3.getMessage());
                }
            }
            OAuthResult a2 = c.this.a(jSONObject);
            if (jSONObject != null && a2 != null) {
                if (a2.getResultCode() == 0) {
                    SapiContext.getInstance().put(c.this.a(this.f11189b, this.f11190c), jSONObject.toString());
                    this.f11188a.onSuccess(a2);
                    return;
                }
                this.f11188a.onFailure(a2);
                return;
            }
            OAuthResult oAuthResult = new OAuthResult();
            oAuthResult.setResultCode(-202);
            this.f11188a.onFailure(oAuthResult);
        }
    }

    /* loaded from: classes2.dex */
    public class t extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallBack f11192a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(Looper looper, SapiCallBack sapiCallBack) {
            super(looper);
            this.f11192a = sapiCallBack;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            if (i == -203) {
                this.f11192a.onSystemError(i);
            } else {
                c.this.b(this.f11192a, str);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            c.this.b(this.f11192a, str);
        }
    }

    /* loaded from: classes2.dex */
    public class u extends GetUserInfoCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IqiyiLoginCallback f11194a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IqiyiLoginDTO f11195b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IqiyiLoginResult f11196c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f11197d;

        public u(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, IqiyiLoginResult iqiyiLoginResult, String str) {
            this.f11194a = iqiyiLoginCallback;
            this.f11195b = iqiyiLoginDTO;
            this.f11196c = iqiyiLoginResult;
            this.f11197d = str;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            c.this.a(this.f11194a, this.f11195b, this.f11196c);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            this.f11196c.setResultCode(getUserInfoResult.getResultCode());
            this.f11196c.setResultMsg(getUserInfoResult.getResultMsg());
            this.f11194a.onFailure(this.f11196c);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            String str = getUserInfoResult.secureMobile;
            boolean z = getUserInfoResult.incompleteUser;
            if (!TextUtils.isEmpty(str)) {
                this.f11194a.onSuccess(this.f11196c);
            } else if (z) {
                c.this.a(this.f11194a, this.f11195b, this.f11196c);
            } else if (!TextUtils.isEmpty(this.f11197d)) {
                c.this.a(this.f11194a, this.f11195b, this.f11196c);
            } else {
                this.f11194a.onSuccess(this.f11196c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface v {
        void a();

        void a(int i, String str);
    }

    private Domain v() {
        return this.f11120a.environment;
    }

    private String w() {
        return "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String x() {
        return "tpl:" + this.f11120a.tpl + ";android_sapi_v9.2.9.8";
    }

    public void a() {
    }

    public void c(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        OAuthResult b2 = b(str, str2);
        if (b2 != null) {
            sapiCallback.onSuccess(b2);
        } else {
            b(sapiCallback, str, str2);
        }
    }

    public String d() {
        return v().getWap() + "/wp/v3/ucenter/realnameverify";
    }

    public String e() {
        return v().getWap() + "/v6/shippingAddress";
    }

    public String f() {
        return v().getURL() + com.baidu.sapi2.utils.g.f11506g;
    }

    public String g() {
        return v().getURL() + com.baidu.sapi2.utils.g.f11507h;
    }

    public String h() {
        return v().getURL() + "/phoenix/account/ssologin";
    }

    public String i() {
        return v().getURL() + "/phoenix/account/ssologin";
    }

    public String j() {
        return v().getWap() + com.baidu.sapi2.utils.g.G;
    }

    public String k() {
        return v().getWap() + "/v6/invoiceManage";
    }

    public String l() {
        return v().getWap() + com.baidu.sapi2.utils.g.E;
    }

    public String m() {
        return v().getURL() + com.baidu.sapi2.utils.g.u;
    }

    public String n() {
        return v().getWap() + com.baidu.sapi2.utils.g.D;
    }

    public String o() {
        return v().getURL() + com.baidu.sapi2.utils.g.I;
    }

    public String p() {
        return v().getWap() + com.baidu.sapi2.utils.g.F;
    }

    public String q() {
        return v().getWap() + "/wp/unitewidget";
    }

    public String r() {
        return v().getWap() + "/passport/getpass";
    }

    public String s() {
        return v().getWap() + "/passport/login";
    }

    public String t() {
        return v().getWap() + "/v3/login/api/login";
    }

    /* loaded from: classes2.dex */
    public class h implements v {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11144a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OneKeyLoginCallback f11145b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ OneKeyLoginResult f11146c;

        public h(String str, OneKeyLoginCallback oneKeyLoginCallback, OneKeyLoginResult oneKeyLoginResult) {
            this.f11144a = str;
            this.f11145b = oneKeyLoginCallback;
            this.f11146c = oneKeyLoginResult;
        }

        @Override // com.baidu.sapi2.c.v
        public void a() {
            OneKeyLoginResult.secondJsCode = this.f11144a;
            this.f11145b.available(this.f11146c);
        }

        @Override // com.baidu.sapi2.c.v
        public void a(int i, String str) {
            new OneKeyLoginSdkCall().preGetPhoneFail(this.f11145b, i, str);
        }
    }

    public void b(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("openPlatformId", str2);
        }
        httpHashMapWrap.put("bduss", str);
        new HttpClientWrap().post(com.baidu.sapi2.utils.g.r, httpHashMapWrap, null, x(), new s(Looper.getMainLooper(), sapiCallback, str, str2));
    }

    public String c() {
        return v().getWap() + "/v6/safetyInspection";
    }

    /* loaded from: classes2.dex */
    public class e extends AsyncTask<String, Void, Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11134a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11135b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SsoHashCallback f11136c;

        public e(String str, String str2, SsoHashCallback ssoHashCallback) {
            this.f11134a = str;
            this.f11135b = str2;
            this.f11136c = ssoHashCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Long doInBackground(String... strArr) {
            try {
                URLConnection openConnection = new URL(strArr[0]).openConnection();
                openConnection.setConnectTimeout(3000);
                openConnection.connect();
                return Long.valueOf(openConnection.getDate() / 1000);
            } catch (Exception e2) {
                Log.e(e2);
                return 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Long l) {
            SsoHashResult ssoHashResult = new SsoHashResult();
            ssoHashResult.ssoHash = new com.baidu.sapi2.utils.j().a(l, this.f11134a, this.f11135b);
            ssoHashResult.setResultCode(0);
            this.f11136c.onSuccess(ssoHashResult);
        }
    }

    public void a(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        String str;
        SapiUtils.notNull(web2NativeLoginCallback, Web2NativeLoginCallback.class.getSimpleName() + " can't be null");
        Web2NativeLoginResult web2NativeLoginResult = new Web2NativeLoginResult();
        String cookieBduss = SapiUtils.getCookieBduss();
        String cookiePtoken = SapiUtils.getCookiePtoken();
        if (TextUtils.isEmpty(cookieBduss)) {
            web2NativeLoginResult.setResultCode(-101);
            web2NativeLoginCallback.onBdussEmpty(web2NativeLoginResult);
            return;
        }
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        String str2 = "";
        if (currentAccount != null) {
            str2 = currentAccount.bduss;
            str = currentAccount.ptoken;
        } else {
            str = "";
        }
        if (cookieBduss.equals(str2) && !TextUtils.isEmpty(cookiePtoken) && cookiePtoken.equals(str)) {
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        } else if (SapiAccountManager.getInstance().isLogin() && !z) {
            SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
            if (!cookieBduss.equals(currentAccount2.bduss)) {
                SapiAccountManager.getInstance().getAccountService().webLogin(this.f11120a.context, currentAccount2.bduss);
            }
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        } else {
            a((GetUserInfoCallback) new k(web2NativeLoginResult, web2NativeLoginCallback, cookieBduss, cookiePtoken), cookieBduss);
        }
    }

    private OAuthResult b(String str, String str2) {
        JSONObject jSONObject;
        String string = SapiContext.getInstance().getString(a(str, str2));
        try {
            jSONObject = new JSONObject(string);
        } catch (JSONException e2) {
            String str3 = f11117b;
            Log.e(str3, "formatOauthResult: " + e2.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            OAuthResult a2 = a(jSONObject);
            if (System.currentTimeMillis() / 1000 < jSONObject.optLong("cachedTimeSecond", 0L) + a2.expiresIn) {
                String str4 = f11117b;
                Log.d(str4, "getCachedOauthResult result: " + string);
                return a2;
            }
        }
        return null;
    }

    public void b(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        try {
            int parseInt = Integer.parseInt(new JSONObject(str).optString("errno"));
            if (parseInt != 0) {
                sapiCallBack.onSystemError(parseInt);
            } else {
                SapiResponse sapiResponse = new SapiResponse();
                sapiResponse.errorCode = parseInt;
                sapiResponse.errorMsg = "短信验证码发送成功";
                sapiCallBack.onSuccess(sapiResponse);
            }
        } catch (Exception unused) {
            sapiCallBack.onSystemError(-100);
        }
    }

    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, boolean z) {
        SapiConfiguration sapiConfiguration = this.f11120a;
        if (sapiConfiguration == null || sapiConfiguration.context == null) {
            return false;
        }
        SapiUtils.notNull(sapiCallBack, SapiCallBack.class.getSimpleName() + " can't be null");
        new HttpClientWrap().get(w(), null, null, x(), new n(Looper.getMainLooper(), sapiCallBack, z, new SapiDataEncryptor(), str, str2));
        return true;
    }

    public int b(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e2) {
            Log.e(e2);
            return -100;
        }
    }

    public String b() {
        return v().getWap() + "/wp/v3/ucenter/index";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, boolean z, SapiDataEncryptor sapiDataEncryptor) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("crypttype", "6");
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(com.baidu.sapi2.utils.g.f11500a);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("cert_id", str2);
        httpHashMapWrap.put("isdpass", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", "1");
        jSONObject.put("password", str4);
        jSONObject.put("login_type", "3");
        jSONObject.put("key", sapiDataEncryptor.getAESKey());
        jSONObject.put("sdk_version", "2");
        jSONObject.put("pinfo", com.baidu.sapi2.utils.f.a());
        httpHashMapWrap.put(TableDefine.DB_TABLE_USERINFO, sapiDataEncryptor.encrypt(str, jSONObject.toString()));
        new HttpClientWrap().post(com.baidu.sapi2.utils.g.f11500a, httpHashMapWrap, null, x(), new o(Looper.getMainLooper(), sapiCallBack, z, sapiDataEncryptor));
    }

    public void a(int i2, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z, SapiDataEncryptor sapiDataEncryptor) {
        if (str == null) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(i2);
                return;
            }
            return;
        }
        SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
        try {
            String optString = new JSONObject(str).optString(TableDefine.DB_TABLE_USERINFO);
            JSONObject jSONObject = null;
            if (!TextUtils.isEmpty(optString)) {
                jSONObject = new JSONObject(sapiDataEncryptor.decrypt(optString));
                sapiAccountResponse.displayname = jSONObject.optString("displayname");
                sapiAccountResponse.username = jSONObject.optString("uname");
                sapiAccountResponse.uid = jSONObject.optString("uid");
                sapiAccountResponse.email = jSONObject.optString("email");
                sapiAccountResponse.bduss = jSONObject.optString("bduss");
                sapiAccountResponse.ptoken = jSONObject.optString(SapiAccount.f10605h);
                sapiAccountResponse.stoken = jSONObject.optString("stoken");
                sapiAccountResponse.authSid = jSONObject.optString("authsid");
            }
            if (sapiCallBack != null) {
                if (i2 != 0) {
                    sapiCallBack.onSystemError(i2);
                    return;
                }
                if (z) {
                    SapiAccount a2 = a(sapiAccountResponse);
                    a2.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                    a2.putExtra("tpl", this.f11120a.tpl);
                    SapiAccountManager.getInstance().validate(a2);
                }
                sapiCallBack.onSuccess(sapiAccountResponse);
            }
        } catch (Exception e2) {
            Log.e(e2);
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(-100);
            }
        }
    }

    public void a(GetUserInfoCallback getUserInfoCallback, String str) {
        SapiUtils.notNull(getUserInfoCallback, GetUserInfoCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
        if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
            httpHashMapWrap.put(SapiAccount.f10605h, accountFromBduss.ptoken);
        }
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(com.baidu.sapi2.utils.g.f11501b);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        new HttpClientWrap().post(com.baidu.sapi2.utils.g.f11501b, httpHashMapWrap, null, x(), new p(Looper.getMainLooper(), getUserInfoCallback, getUserInfoResult));
    }

    public void a(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        SapiUtils.notNull(fillUsernameCallback, FillUsernameCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        SapiUtils.notEmpty(str2, "username can't be empty");
        FillUsernameResult fillUsernameResult = new FillUsernameResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("cert_id", String.valueOf(1));
        httpHashMapWrap.put("crypttype", String.valueOf(6));
        JSONObject jSONObject = new JSONObject();
        SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        try {
            jSONObject.put("bduss", str);
            String clientId = SapiUtils.getClientId(this.f11120a.context);
            if (!TextUtils.isEmpty(clientId)) {
                jSONObject.put("clientid", clientId);
            }
            if (!TextUtils.isEmpty(this.f11120a.clientIp)) {
                jSONObject.put("clientip", this.f11120a.clientIp);
            }
            jSONObject.put("username", str2);
            jSONObject.put("key", sapiDataEncryptor.getAESKey());
            httpHashMapWrap.put(TableDefine.DB_TABLE_USERINFO, sapiDataEncryptor.encrypt("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", jSONObject.toString()));
            new HttpClientWrap().post(com.baidu.sapi2.utils.g.n, httpHashMapWrap, null, x(), new q(Looper.getMainLooper(), fillUsernameCallback, fillUsernameResult, sapiDataEncryptor));
        } catch (Throwable th) {
            fillUsernameResult.setResultCode(-202);
            fillUsernameCallback.onFailure(fillUsernameResult);
            Log.e(th);
        }
    }

    public boolean a(String str, List<String> list) {
        SapiUtils.notEmpty(str, "bduss can't be empty");
        if (list != null && !list.isEmpty()) {
            return a(SapiContext.getInstance().getAccountFromBduss(str), list);
        }
        throw new IllegalArgumentException("targetTplList can't be null or empty");
    }

    public boolean a(SapiAccount sapiAccount, List<String> list) {
        if (sapiAccount != null && !TextUtils.isEmpty(sapiAccount.extra)) {
            try {
                SapiAccount.DispersionCertification fromJSONObject = SapiAccount.DispersionCertification.fromJSONObject(new JSONObject(sapiAccount.extra));
                for (String str : list) {
                    if (!fromJSONObject.tplStokenMap.containsKey(str)) {
                        return false;
                    }
                }
                return true;
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        return false;
    }

    public Map<String, String> a(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        SapiUtils.notNull(getTplStokenCallback, GetTplStokenCallback.class.getSimpleName() + " can't be null");
        GetTplStokenResult getTplStokenResult = new GetTplStokenResult();
        if (list != null && !list.isEmpty()) {
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
            if (accountFromBduss == null) {
                getTplStokenResult.setResultCode(-301);
                getTplStokenCallback.onFailure(getTplStokenResult);
                return getTplStokenResult.tplStokenMap;
            }
            String str2 = accountFromBduss.ptoken;
            if (a(str, list)) {
                try {
                    SapiAccount.DispersionCertification fromJSONObject = SapiAccount.DispersionCertification.fromJSONObject(new JSONObject(accountFromBduss.extra));
                    Iterator<String> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (fromJSONObject.tplStokenMap.containsKey(next)) {
                            getTplStokenResult.tplStokenMap.put(next, fromJSONObject.tplStokenMap.get(next));
                        } else {
                            getTplStokenResult.tplStokenMap.clear();
                            break;
                        }
                    }
                    if (!getTplStokenResult.tplStokenMap.isEmpty()) {
                        getTplStokenResult.setResultCode(0);
                        getTplStokenResult.setResultMsg("成功");
                        getTplStokenCallback.onSuccess(getTplStokenResult);
                        return getTplStokenResult.tplStokenMap;
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                    getTplStokenResult.setResultCode(-304);
                    getTplStokenCallback.onFailure(getTplStokenResult);
                    return getTplStokenResult.tplStokenMap;
                }
            }
            String str3 = list.get(0);
            for (int i2 = 1; i2 < list.size(); i2++) {
                str3 = str3 + FieldBuilder.SE + list.get(i2);
            }
            if (TextUtils.isEmpty(str2)) {
                getTplStokenResult.setResultCode(-305);
                getTplStokenResult.failureType = GetTplStokenResult.FailureType.PTOKEN_EMPTY;
                getTplStokenCallback.onFailure(getTplStokenResult);
            }
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("bduss", str);
            httpHashMapWrap.put("sign", SecurityUtil.md5((this.f11120a.appId + this.f11120a.tpl + str + this.f11120a.appSignKey).getBytes(), false));
            httpHashMapWrap.put("return_type", "1");
            if (!TextUtils.isEmpty(str2)) {
                httpHashMapWrap.put(SapiAccount.f10605h, str2);
            }
            httpHashMapWrap.put("tpl_list", str3);
            new HttpClientWrap().post(com.baidu.sapi2.utils.g.s, httpHashMapWrap, null, x(), new r(Looper.getMainLooper(), getTplStokenCallback, getTplStokenResult, accountFromBduss, list, z, str2));
            return getTplStokenResult.tplStokenMap;
        }
        getTplStokenResult.setResultCode(-302);
        getTplStokenResult.setResultMsg("参数错误，请稍后再试");
        getTplStokenCallback.onFailure(getTplStokenResult);
        return getTplStokenResult.tplStokenMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2) {
        return new String(Base64.encode((str + str2).getBytes(), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OAuthResult a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        OAuthResult oAuthResult = new OAuthResult();
        try {
            oAuthResult.setResultCode(Integer.parseInt(jSONObject.optString("errno")));
        } catch (Exception e2) {
            String str = f11117b;
            Log.e(str, "formatOauthResult parseInt: " + e2.getMessage());
        }
        oAuthResult.accessToken = jSONObject.optString("access_token");
        oAuthResult.expiresIn = jSONObject.optInt("expires_in");
        oAuthResult.scope = jSONObject.optString("scope");
        oAuthResult.refreshToken = jSONObject.optString("refresh_token");
        oAuthResult.sessionKey = jSONObject.optString("session_key");
        oAuthResult.sessionSecret = jSONObject.optString("session_secret");
        oAuthResult.extra = jSONObject.optString("extra");
        oAuthResult.openid = jSONObject.optString("openid");
        return oAuthResult;
    }

    public boolean a(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        Context context;
        SapiConfiguration sapiConfiguration = this.f11120a;
        if (sapiConfiguration == null || (context = sapiConfiguration.context) == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(257);
            }
            return false;
        } else {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("username", str);
            new HttpClientWrap().post(com.baidu.sapi2.utils.g.o, httpHashMapWrap, null, x(), new t(Looper.getMainLooper(), sapiCallBack));
            return true;
        }
    }

    public HttpHashMapWrap a(String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        httpHashMapWrap.put("sdk_version", "3");
        return httpHashMapWrap;
    }

    public void a(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        if (iqiyiLoginCallback == null) {
            return;
        }
        iqiyiLoginCallback.onStart();
        String str = iqiyiLoginDTO.accessToken;
        String str2 = iqiyiLoginDTO.phoneNum;
        String str3 = iqiyiLoginDTO.openID;
        IqiyiLoginResult iqiyiLoginResult = new IqiyiLoginResult();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        boolean z = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) ? false : true;
        if (!z && currentAccount == null) {
            iqiyiLoginCallback.onLogin(iqiyiLoginResult);
        } else if (z && currentAccount == null) {
            a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
        } else {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new u(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult, str2), currentAccount.bduss);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, IqiyiLoginResult iqiyiLoginResult) {
        if (!TextUtils.isEmpty(iqiyiLoginDTO.accessToken) && !TextUtils.isEmpty(iqiyiLoginDTO.openID)) {
            HttpHashMapWrap a2 = a(i());
            if (!TextUtils.isEmpty(iqiyiLoginDTO.phoneNum)) {
                a2.put("crypt_m", iqiyiLoginDTO.phoneNum);
            }
            a2.put("access_token", iqiyiLoginDTO.accessToken);
            a2.put("osuid", iqiyiLoginDTO.openID);
            a2.put("json", "1");
            a2.put("type", SocialType.IQIYI.getType() + "");
            a2.put("act", "special");
            a2.put("display", "native");
            new HttpClientWrap().get(i(), a2, null, x(), new a(Looper.getMainLooper(), iqiyiLoginCallback, iqiyiLoginResult));
            return;
        }
        iqiyiLoginCallback.onLogin(iqiyiLoginResult);
    }

    public void a(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(com.baidu.sapi2.utils.g.v);
        a2.put("clientfrom", "native");
        a2.put("bduss", str);
        if (map != null && !map.isEmpty()) {
            a2.putAll(map);
        }
        new HttpClientWrap().post(com.baidu.sapi2.utils.g.v, a2, null, x(), new b(Looper.getMainLooper(), sapiCallback, new CheckUserFaceIdResult()));
    }

    public void a(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(com.baidu.sapi2.utils.g.x);
        a2.put("clientfrom", "native");
        a2.put("bduss", str);
        new HttpClientWrap().post(com.baidu.sapi2.utils.g.x, a2, null, x(), new C0139c(Looper.getMainLooper(), sapiCallback, new FaceLoginStatusResult()));
    }

    public void a(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(com.baidu.sapi2.utils.g.x);
        if (z) {
            a2.put("action", "enable_face_login");
        } else {
            a2.put("action", "disable_face_login");
        }
        if (!TextUtils.isEmpty(str2)) {
            a2.put("callbackKey", str2);
        }
        a2.put("guidefrom", FaceBaseDTO.BUSINESS_SENCE_FACE_LOGIN_SWITCH);
        a2.put("clientfrom", "native");
        a2.put("bduss", str);
        new HttpClientWrap().post(com.baidu.sapi2.utils.g.w, a2, null, x(), new d(Looper.getMainLooper(), sapiCallback, new CheckUserFaceIdResult(), z));
    }

    @SuppressLint({"NewApi"})
    public void a(SsoHashCallback ssoHashCallback, String str, String str2) {
        SapiUtils.notNull(ssoHashCallback, "SsoHashCallback can't be null");
        new e(str, str2, ssoHashCallback).execute(com.baidu.sapi2.utils.g.y);
    }

    public void a(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("open_appid", str);
        httpHashMapWrap.put("open_apikey", str2);
        httpHashMapWrap.put("time", System.currentTimeMillis() + "");
        new HttpClientWrap().post(com.baidu.sapi2.utils.g.z, httpHashMapWrap, null, x(), new f(Looper.getMainLooper(), sapiCallback, new SapiResult()));
    }

    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, int i2) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("ability", "onekeylogin");
        httpHashMapWrap.put("scene", RetrieveTaskManager.KEY);
        httpHashMapWrap.put("clientfrom", "native");
        httpHashMapWrap.put("mobile", str);
        httpHashMapWrap.put("oneKeySdkVersion", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
        String n2 = n();
        new HttpClientWrap().get(n2, httpHashMapWrap, ParamsUtil.buildNaCookie(n2, this.f11120a), x(), i2, new g(Looper.getMainLooper(), str, oneKeyLoginCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        JSONObject jSONObject;
        Log.d(f11117b, "onSuccess, statusCode = " + i2 + ", response = " + str);
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        if (jSONObject == null) {
            SapiStatUtil.statOneKeyCheckAbility(i2, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_JSON_ERROR, false, OneKeyLoginSdkCall.getInstance().getOperatorType());
            new OneKeyLoginSdkCall().preGetPhoneFail(oneKeyLoginCallback, -100, null);
            return;
        }
        int optInt = jSONObject.optInt("errno");
        if ((optInt == 0 && (jSONObject2 = jSONObject.optJSONObject("data")) != null && 1 == jSONObject2.optInt(com.baidu.fsg.face.base.b.c.l)) && jSONObject2 != null) {
            oneKeyLoginResult.enable = true;
            oneKeyLoginResult.setResultCode(0);
            oneKeyLoginResult.hasHistory = jSONObject2.optInt("hasHistory", -1) == 1;
            oneKeyLoginResult.encryptPhoneNum = str2;
            String optString = jSONObject2.optString("sign");
            oneKeyLoginResult.sign = optString;
            OneKeyLoginSdkCall.signFromAbilityApi = optString;
            oneKeyLoginResult.operator = new OneKeyLoginSdkCall().getOperatorType();
            String optString2 = jSONObject2.optString(PackageTable.MD5);
            String optString3 = jSONObject2.optString("url");
            String optString4 = jSONObject2.optString("js");
            String onekeyLoginJsMd5 = SapiContext.getInstance().getOnekeyLoginJsMd5();
            if (optString2 != null && optString2.equals(onekeyLoginJsMd5)) {
                OneKeyLoginResult.secondJsCode = optString4;
                oneKeyLoginCallback.available(oneKeyLoginResult);
            } else {
                a(optString3, optString2, optString4, new h(optString4, oneKeyLoginCallback, oneKeyLoginResult));
            }
        } else {
            new OneKeyLoginSdkCall().preGetPhoneFail(oneKeyLoginCallback, optInt, jSONObject.optString("errmsg"));
        }
        SapiStatUtil.statOneKeyCheckAbility(i2, optInt, oneKeyLoginResult.enable, oneKeyLoginResult.operator);
    }

    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, com.baidu.sapi2.callback.a.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String operatorType = new OneKeyLoginSdkCall().getOperatorType();
            jSONObject.put("token", str);
            jSONObject.put("tpl", this.f11120a.tpl);
            jSONObject.put("client", "android");
            jSONObject.put("clientfrom", "native");
            jSONObject.put("appid", OneKeyLoginSdkCall.oneKeyLoginAppKey);
            jSONObject.put("operator", operatorType);
            jSONObject.put("scene", RetrieveTaskManager.KEY);
            jSONObject.put("sign", str2);
            if (OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC.equals(operatorType)) {
                jSONObject.put("CUVersion", "2");
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
        com.baidu.sapi2.utils.e.a(SapiContext.getInstance().getOneKeyLoginJsCode(), OneKeyLoginResult.secondJsCode, jSONObject.toString(), this.f11120a.context, new i(oneKeyLoginCallback, cVar));
    }

    private void a(String str, String str2, String str3, v vVar) {
        new HttpClientWrap().get(str, new j(Looper.getMainLooper(), str2, vVar));
    }

    public void a(String str, List<String> list, String str2, com.baidu.sapi2.callback.a.b bVar) {
        if (bVar == null) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("client", "android");
        httpHashMapWrap.put("clientfrom", "native");
        httpHashMapWrap.put("tpl", str);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String str3 : list) {
            sb.append("\"");
            sb.append(str3);
            sb.append("\"");
            sb.append(",");
        }
        StringBuilder deleteCharAt = sb.deleteCharAt(sb.length() - 1);
        deleteCharAt.append("]");
        httpHashMapWrap.put("interflowPkgList", deleteCharAt.toString());
        httpHashMapWrap.put("currentAppPkg", str2);
        String o2 = o();
        new HttpClientWrap().post(o2, httpHashMapWrap, ParamsUtil.buildNaCookie(o2, this.f11120a), x(), new l(bVar));
    }

    public void a(int i2, ShareStorage.StorageModel storageModel) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_SHARE_V3).f10805c) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            if (i2 == 2) {
                httpHashMapWrap.put("cmd", "insert");
            } else if (i2 == 3) {
                httpHashMapWrap.put("cmd", "delete");
            } else if (i2 != 4) {
                return;
            } else {
                httpHashMapWrap.put("cmd", "reset");
            }
            if (i2 == 2 && storageModel.flag == 0 && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                httpHashMapWrap.put("bduss", currentAccount.bduss);
                httpHashMapWrap.put(SapiAccount.f10605h, currentAccount.ptoken);
                httpHashMapWrap.put("stoken", currentAccount.stoken);
            }
            httpHashMapWrap.put("app", SapiUtils.getAppName(this.f11120a.context));
            httpHashMapWrap.put("pkg", this.f11120a.context.getPackageName());
            new HttpClientWrap().post(com.baidu.sapi2.utils.g.H, httpHashMapWrap, new m(Looper.getMainLooper(), i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, String> hashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.f11120a.environment.getWap(), hashMap.get("HISTORY")));
        SapiUtils.syncCookies(this.f11120a.context, arrayList);
    }

    public SapiAccount a(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = SapiUtils.getAppName(this.f11120a.context);
        return sapiAccount;
    }

    public String a(BindWidgetAction bindWidgetAction) {
        return v().getWap() + bindWidgetAction.getUri();
    }
}
