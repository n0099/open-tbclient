package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.SapiAccount;
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
import com.baidu.sapi2.e;
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
import com.baidu.sapi2.share.SapiShareClient;
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
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
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
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static final String f5169b = "c";
    private static final int c = 6;
    private static final String d = "3";

    /* renamed from: a  reason: collision with root package name */
    private SapiConfiguration f5170a = SapiAccountManager.getInstance().getSapiConfiguration();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IqiyiLoginCallback f5171a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ IqiyiLoginResult f5172b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginResult iqiyiLoginResult) {
            super(looper);
            this.f5171a = iqiyiLoginCallback;
            this.f5172b = iqiyiLoginResult;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f5172b.setResultCode(i);
            this.f5171a.onFailure(this.f5172b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f5171a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            if (c.this.b(str) != 302) {
                SocialResponse b2 = SapiWebView.b(str, c.this.f5170a.context);
                if (b2 == null) {
                    this.f5172b.setResultCode(-100);
                    this.f5172b.setResultMsg("登录失败");
                    this.f5171a.onFailure(this.f5172b);
                    return;
                } else if (b2.errorCode != -100) {
                    this.f5172b.setResultCode(-100);
                    this.f5172b.setResultMsg("登录失败");
                    this.f5171a.onFailure(this.f5172b);
                    return;
                } else {
                    SapiAccount a2 = c.this.a(b2);
                    a2.addSocialInfo(b2.socialType, b2.socialPortraitUrl);
                    a2.putExtra("account_type", Integer.valueOf(b2.accountType.getType()));
                    a2.addDispersionCertification(b2.tplStokenMap);
                    a2.addIsGuestAccount(b2.isGuestAccount);
                    a2.putExtra("tpl", c.this.f5170a.tpl);
                    SapiShareClient.getInstance().validate(a2);
                    this.f5171a.onSuccess(this.f5172b);
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f5172b.nextUrl = jSONObject.optString("next_url");
                this.f5171a.onBindWebview(this.f5172b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends HttpHandlerWrap {
        b(Looper looper) {
            super(looper);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0339c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SapiCallback f5174a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckUserFaceIdResult f5175b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0339c(Looper looper, SapiCallback sapiCallback, CheckUserFaceIdResult checkUserFaceIdResult) {
            super(looper);
            this.f5174a = sapiCallback;
            this.f5175b = checkUserFaceIdResult;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f5175b.setResultCode(i);
            this.f5174a.onFailure(this.f5175b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f5174a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f5174a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString(BaseJsonData.TAG_ERRNO));
                this.f5175b.setResultCode(parseInt);
                this.f5175b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                if (parseInt == 0) {
                    this.f5175b.status = jSONObject.optInt("status");
                    this.f5175b.livingUname = jSONObject.optString("livinguname");
                    this.f5175b.authsid = jSONObject.optString("authsid");
                    this.f5175b.authWidgetURL = jSONObject.optString("authurl");
                    this.f5174a.onSuccess(this.f5175b);
                } else {
                    this.f5174a.onFailure(this.f5175b);
                }
            } catch (Throwable th) {
                this.f5175b.setResultCode(-202);
                this.f5174a.onFailure(this.f5175b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SapiCallback f5176a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FaceLoginStatusResult f5177b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Looper looper, SapiCallback sapiCallback, FaceLoginStatusResult faceLoginStatusResult) {
            super(looper);
            this.f5176a = sapiCallback;
            this.f5177b = faceLoginStatusResult;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f5177b.setResultCode(i);
            this.f5176a.onFailure(this.f5177b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f5176a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f5176a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString(BaseJsonData.TAG_ERRNO));
                this.f5177b.setResultCode(parseInt);
                this.f5177b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                if (parseInt == 0) {
                    this.f5177b.status = jSONObject.optInt("status");
                    this.f5177b.livingUname = jSONObject.optString("livinguname");
                    this.f5177b.authsid = jSONObject.optString("authsid");
                    this.f5177b.authWidgetURL = jSONObject.optString("authurl");
                    this.f5177b.faceLoginSwitch = jSONObject.optInt("faceLoginEnabled") == 1;
                    this.f5176a.onSuccess(this.f5177b);
                } else {
                    this.f5176a.onFailure(this.f5177b);
                }
            } catch (Throwable th) {
                this.f5177b.setResultCode(-202);
                this.f5176a.onFailure(this.f5177b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SapiCallback f5178a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckUserFaceIdResult f5179b;
        final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Looper looper, SapiCallback sapiCallback, CheckUserFaceIdResult checkUserFaceIdResult, boolean z) {
            super(looper);
            this.f5178a = sapiCallback;
            this.f5179b = checkUserFaceIdResult;
            this.c = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f5179b.setResultCode(i);
            this.f5178a.onFailure(this.f5179b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f5178a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f5178a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString(BaseJsonData.TAG_ERRNO));
                this.f5179b.setResultCode(parseInt);
                this.f5179b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                if (parseInt == 0) {
                    if (this.c) {
                        String optString = jSONObject.optString("livinguname");
                        if (!TextUtils.isEmpty(optString)) {
                            new FaceLoginService().syncFaceLoginUID(c.this.f5170a.context, optString);
                        }
                    }
                    this.f5178a.onSuccess(this.f5179b);
                    return;
                }
                this.f5178a.onFailure(this.f5179b);
            } catch (Throwable th) {
                this.f5179b.setResultCode(-202);
                this.f5178a.onFailure(this.f5179b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SapiCallback f5182a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SapiResult f5183b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Looper looper, SapiCallback sapiCallback, SapiResult sapiResult) {
            super(looper);
            this.f5182a = sapiCallback;
            this.f5183b = sapiResult;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f5183b.setResultCode(i);
            this.f5183b.setResultMsg(str);
            this.f5182a.onFailure(this.f5183b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f5182a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f5182a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f5183b.setResultCode(jSONObject.optInt(BaseJsonData.TAG_ERRNO));
                this.f5183b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
            } catch (JSONException e) {
                Log.e(e);
            }
            if (this.f5183b.getResultCode() == 0) {
                this.f5182a.onSuccess(this.f5183b);
            } else {
                this.f5182a.onFailure(this.f5183b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OneKeyLoginResult f5184a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f5185b;
        final /* synthetic */ OneKeyLoginCallback c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Looper looper, OneKeyLoginResult oneKeyLoginResult, String str, OneKeyLoginCallback oneKeyLoginCallback) {
            super(looper);
            this.f5184a = oneKeyLoginResult;
            this.f5185b = str;
            this.c = oneKeyLoginCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Log.d(c.f5169b, "onFailure, error = " + th + ", errorCode = " + i + ", responseBody = " + str);
            new OneKeyLoginSdkCall().b(this.c, i, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            JSONObject optJSONObject;
            Log.d(c.f5169b, "onSuccess, statusCode = " + i + ", response = " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                String optString = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                if (optInt == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    this.f5184a.setResultCode(0);
                    this.f5184a.enable = optJSONObject.optInt(com.baidu.fsg.face.base.b.c.l, -1) == 1;
                    this.f5184a.hasHistory = optJSONObject.optInt("hasHistory", -1) == 1;
                    this.f5184a.encryptPhoneNum = this.f5185b;
                    this.f5184a.sign = optJSONObject.optString("sign");
                    this.f5184a.operator = new OneKeyLoginSdkCall().c();
                    String optString2 = optJSONObject.optString("js");
                    String optString3 = optJSONObject.optString("md5");
                    String optString4 = optJSONObject.optString("url");
                    String onekeyLoginJsMd5 = SapiContext.getInstance().getOnekeyLoginJsMd5();
                    if (optString3 == null || !optString3.equals(onekeyLoginJsMd5)) {
                        c.this.a(this.c, optString4, optString3, optString2, this.f5184a);
                    } else {
                        OneKeyLoginResult.secondJsCode = optString2;
                        this.c.available(this.f5184a);
                    }
                } else {
                    new OneKeyLoginSdkCall().b(this.c, optInt, optString);
                }
            } catch (Exception e) {
                Log.e(e);
                new OneKeyLoginSdkCall().b(this.c, -100, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements com.baidu.sapi2.callback.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OneKeyLoginCallback f5186a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.baidu.sapi2.callback.a.b f5187b;

        /* loaded from: classes3.dex */
        class a extends HttpHandlerWrap {
            a(Looper looper) {
                super(looper);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                Log.d(c.f5169b, "onFailure, error = " + th + ", errorCode = " + i + ", responseBody = " + str);
                new OneKeyLoginSdkCall().a(i.this.f5186a, -100, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
                String optString;
                Log.d(c.f5169b, "onSuccess, statusCode = " + i + ", response = " + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("errInfo");
                    String optString2 = optJSONObject.optString("no");
                    String optString3 = optJSONObject.optString("msg");
                    if ("0".equals(optString2)) {
                        c.this.a(hashMap);
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                        if (optJSONObject2 != null) {
                            SapiAccountManager.getInstance().getAccountService().handleOneKeyLoginResult(i.this.f5186a, optJSONObject2.optString("xml"));
                            return;
                        } else {
                            new OneKeyLoginSdkCall().a(i.this.f5186a, -100, null);
                            return;
                        }
                    }
                    if (!"400101".equals(optString2) && !"400031".equals(optString2) && !"400023".equals(optString2)) {
                        if (!"400704".equals(optString2) && !"400706".equals(optString2)) {
                            new OneKeyLoginSdkCall().a(i.this.f5186a, Integer.parseInt(optString2), optString3);
                            return;
                        }
                        JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
                        if (optJSONObject3 != null) {
                            optString = optJSONObject3.optString("ppDatau");
                        }
                        optString = null;
                    } else {
                        JSONObject optJSONObject4 = jSONObject.optJSONObject("data");
                        if (optJSONObject4 != null) {
                            optString = optJSONObject4.optString("verifyUrl");
                        }
                        optString = null;
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
                        oneKeyLoginResult.setResultCode(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
                        i.this.f5186a.onGuideProcess(oneKeyLoginResult);
                        i.this.f5187b.a("", optString);
                        return;
                    }
                    new OneKeyLoginSdkCall().a(i.this.f5186a, -100, null);
                } catch (Exception e) {
                    Log.e(e);
                    new OneKeyLoginSdkCall().a(i.this.f5186a, -100, null);
                }
            }
        }

        i(OneKeyLoginCallback oneKeyLoginCallback, com.baidu.sapi2.callback.a.b bVar) {
            this.f5186a = oneKeyLoginCallback;
            this.f5187b = bVar;
        }

        @Override // com.baidu.sapi2.callback.a.a
        public void a(String str) {
            JSONObject jSONObject = null;
            if (TextUtils.isEmpty(str)) {
                Log.e(c.f5169b, "oneKeyLogin execute JavaScript failed, it only support after KitKat version");
                new OneKeyLoginSdkCall().a(this.f5186a, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_EXECUTE_JS_FAIL, null);
                return;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                Log.e(e);
            }
            HttpHashMap httpHashMap = new HttpHashMap();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    httpHashMap.put(next, jSONObject.optString(next));
                }
            }
            String l = c.this.l();
            new HttpClientWrap().post(l, httpHashMap, ParamsUtil.buildNaCookie(l, c.this.f5170a), c.this.w(), new a(Looper.getMainLooper()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f5189a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OneKeyLoginCallback f5190b;
        final /* synthetic */ String c;
        final /* synthetic */ OneKeyLoginResult d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Looper looper, String str, OneKeyLoginCallback oneKeyLoginCallback, String str2, OneKeyLoginResult oneKeyLoginResult) {
            super(looper);
            this.f5189a = str;
            this.f5190b = oneKeyLoginCallback;
            this.c = str2;
            this.d = oneKeyLoginResult;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            new OneKeyLoginSdkCall().b(this.f5190b, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            String md5 = SecurityUtil.md5(str.getBytes(), false);
            String str2 = this.f5189a;
            if (str2 != null && !str2.equals(md5)) {
                Log.d(c.f5169b, "oneKeyLogin check javsScript MD5 failed");
                new OneKeyLoginSdkCall().b(this.f5190b, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL, null);
                return;
            }
            SapiContext.getInstance().setOneKeyLoginJSCode(str);
            SapiContext.getInstance().setOnekeyLoginJsMd5(this.f5189a);
            OneKeyLoginResult.secondJsCode = this.c;
            this.f5190b.available(this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k extends GetUserInfoCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Web2NativeLoginResult f5191a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Web2NativeLoginCallback f5192b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        k(Web2NativeLoginResult web2NativeLoginResult, Web2NativeLoginCallback web2NativeLoginCallback, String str, String str2) {
            this.f5191a = web2NativeLoginResult;
            this.f5192b = web2NativeLoginCallback;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            this.f5192b.onFinish();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            this.f5192b.onStart();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            this.f5191a.setResultCode(400021);
            this.f5192b.onBdussExpired(this.f5191a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            this.f5191a.setResultCode(-202);
            this.f5192b.onFailure(this.f5191a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = getUserInfoResult.uid;
            sapiAccount.username = getUserInfoResult.username;
            sapiAccount.displayname = getUserInfoResult.displayname;
            sapiAccount.bduss = this.c;
            if (!TextUtils.isEmpty(this.d)) {
                sapiAccount.ptoken = this.d;
            }
            sapiAccount.app = SapiUtils.getAppName(c.this.f5170a.context);
            SapiShareClient.getInstance().validate(sapiAccount);
            this.f5191a.setResultCode(0);
            this.f5192b.onSuccess(this.f5191a);
            new com.baidu.sapi2.utils.b().a(com.baidu.sapi2.utils.b.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class l extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f5193a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Looper looper, int i) {
            super(looper);
            this.f5193a = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            SapiStatUtil.statSetCloudShareAccount(this.f5193a, 2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Log.d(c.f5169b, "set clound share account start");
            SapiStatUtil.statSetCloudShareAccount(this.f5193a, 0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                if (new JSONObject(str).optInt("code") == 110000) {
                    SapiStatUtil.statSetCloudShareAccount(this.f5193a, 1);
                    return;
                }
            } catch (Exception e) {
                Log.e(e);
            }
            SapiStatUtil.statSetCloudShareAccount(this.f5193a, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class m extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SapiCallBack f5195a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f5196b;
        final /* synthetic */ SapiDataEncryptor c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(Looper looper, SapiCallBack sapiCallBack, boolean z, SapiDataEncryptor sapiDataEncryptor, String str, String str2) {
            super(looper);
            this.f5195a = sapiCallBack;
            this.f5196b = z;
            this.c = sapiDataEncryptor;
            this.d = str;
            this.e = str2;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            if (i == -201) {
                this.f5195a.onNetworkFailed();
            } else {
                this.f5195a.onSystemError(i);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            if (!TextUtils.isEmpty(str)) {
                c.this.a(-100, this.f5195a, str, this.f5196b, this.c);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                c.this.a(this.f5195a, jSONObject.optString("cert"), jSONObject.optString("cert_id"), this.d, this.e, this.f5196b, this.c);
            } catch (Exception e) {
                c.this.a(-100, this.f5195a, str, this.f5196b, this.c);
                Log.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class n extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SapiCallBack f5197a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f5198b;
        final /* synthetic */ SapiDataEncryptor c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(Looper looper, SapiCallBack sapiCallBack, boolean z, SapiDataEncryptor sapiDataEncryptor) {
            super(looper);
            this.f5197a = sapiCallBack;
            this.f5198b = z;
            this.c = sapiDataEncryptor;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            if (i == -201) {
                this.f5197a.onNetworkFailed();
            } else {
                this.f5197a.onSystemError(i);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            c cVar = c.this;
            cVar.a(cVar.b(str), this.f5197a, str, this.f5198b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class o extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GetUserInfoCallback f5199a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GetUserInfoResult f5200b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(Looper looper, GetUserInfoCallback getUserInfoCallback, GetUserInfoResult getUserInfoResult) {
            super(looper);
            this.f5199a = getUserInfoCallback;
            this.f5200b = getUserInfoResult;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f5200b.setResultCode(i);
            this.f5199a.onFailure(this.f5200b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f5199a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f5199a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            int b2 = c.this.b(str);
            this.f5200b.setResultCode(b2);
            if (b2 != 0) {
                if (b2 != 400021) {
                    this.f5199a.onFailure(this.f5200b);
                    return;
                } else {
                    this.f5199a.onBdussExpired(this.f5200b);
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f5200b.portraitSign = jSONObject.optString("portrait_tag");
                this.f5200b.isInitialPortrait = "0".equals(this.f5200b.portraitSign);
                String optString = jSONObject.optString("portrait");
                if (!TextUtils.isEmpty(optString)) {
                    this.f5200b.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.f5200b.portraitSign);
                    this.f5200b.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.f5200b.portraitSign);
                }
                this.f5200b.username = jSONObject.optString("username");
                this.f5200b.uid = jSONObject.optString(DpStatConstants.KEY_USER_ID);
                this.f5200b.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                this.f5200b.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                this.f5200b.secureMobile = jSONObject.optString("securemobil");
                this.f5200b.secureEmail = jSONObject.optString("secureemail");
                this.f5200b.havePwd = "1".equals(jSONObject.optString("have_psw"));
                this.f5200b.carSdkFace = jSONObject.optInt("carSdkFace");
                this.f5200b.faceLoginSwitch = jSONObject.optInt("faceLoginSwitch");
                this.f5199a.onSuccess(this.f5200b);
            } catch (Exception e) {
                this.f5199a.onFailure(this.f5200b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class p extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FillUsernameCallback f5201a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FillUsernameResult f5202b;
        final /* synthetic */ SapiDataEncryptor c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(Looper looper, FillUsernameCallback fillUsernameCallback, FillUsernameResult fillUsernameResult, SapiDataEncryptor sapiDataEncryptor) {
            super(looper);
            this.f5201a = fillUsernameCallback;
            this.f5202b = fillUsernameResult;
            this.c = sapiDataEncryptor;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f5202b.setResultCode(i);
            this.f5201a.onFailure(this.f5202b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f5201a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f5201a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            int b2 = c.this.b(str);
            this.f5202b.setResultCode(b2);
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f5202b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                JSONObject jSONObject2 = new JSONObject(this.c.decrypt(jSONObject.optString(TableDefine.DB_TABLE_USERINFO)));
                if (b2 == 0 || b2 == 110000) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.bduss = jSONObject2.optString("bduss");
                    sapiAccount.ptoken = jSONObject2.optString("ptoken");
                    sapiAccount.stoken = jSONObject2.optString("stoken");
                    sapiAccount.displayname = jSONObject2.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccount.username = jSONObject2.optString(BdStatsConstant.StatsKey.UNAME);
                    sapiAccount.uid = jSONObject2.optString("uid");
                    sapiAccount.app = SapiUtils.getAppName(c.this.f5170a.context);
                    sapiAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject2).tplStokenMap);
                    sapiAccount.putExtra("tpl", c.this.f5170a.tpl);
                    SapiShareClient.getInstance().validate(sapiAccount);
                    this.f5202b.session = sapiAccount;
                    this.f5201a.onSuccess(this.f5202b);
                    new com.baidu.sapi2.utils.b().a(com.baidu.sapi2.utils.b.f);
                } else if (b2 == 160103) {
                    this.f5201a.onBdussExpired(this.f5202b);
                } else if (b2 != 160104) {
                    this.f5201a.onFailure(this.f5202b);
                } else {
                    this.f5201a.onUserHaveUsername(this.f5202b);
                }
            } catch (Throwable th) {
                this.f5201a.onFailure(this.f5202b);
                Log.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class q extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GetTplStokenCallback f5203a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GetTplStokenResult f5204b;
        final /* synthetic */ SapiAccount c;
        final /* synthetic */ List d;
        final /* synthetic */ boolean e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(Looper looper, GetTplStokenCallback getTplStokenCallback, GetTplStokenResult getTplStokenResult, SapiAccount sapiAccount, List list, boolean z, String str) {
            super(looper);
            this.f5203a = getTplStokenCallback;
            this.f5204b = getTplStokenResult;
            this.c = sapiAccount;
            this.d = list;
            this.e = z;
            this.f = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            if (TextUtils.isEmpty(this.f)) {
                return;
            }
            this.f5204b.setResultCode(i);
            this.f5203a.onFailure(this.f5204b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f5203a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f5203a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString(BaseJsonData.TAG_ERRNO));
                this.f5204b.setResultCode(parseInt);
                if (parseInt == 0) {
                    Map<String, String> tplStokenMap = SapiAccount.DispersionCertification.getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
                    this.f5204b.tplStokenMap = tplStokenMap;
                    SapiAccount.ExtraProperty extraProperty = new SapiAccount.ExtraProperty();
                    if (!TextUtils.isEmpty(this.c.extra)) {
                        extraProperty = SapiAccount.ExtraProperty.fromJSONObject(new JSONObject(this.c.extra));
                    }
                    extraProperty.dispersionCertification.tplStokenMap.putAll(tplStokenMap);
                    this.c.extra = extraProperty.toJSONObject().toString();
                    if (this.d.size() == tplStokenMap.size()) {
                        if (this.e) {
                            SapiShareClient.getInstance().validate(this.c);
                        } else {
                            SapiContext.getInstance().setCurrentAccount(this.c);
                            SapiAccountManager.getInstance().preFetchStoken(this.c, false);
                            SapiContext.getInstance().addLoginAccount(this.c);
                            new com.baidu.sapi2.share.b().a(5);
                        }
                        this.f5203a.onSuccess(this.f5204b);
                        return;
                    }
                    this.f5204b.setResultCode(-306);
                    this.f5203a.onFailure(this.f5204b);
                } else if (parseInt != 8) {
                    if (!TextUtils.isEmpty(this.f)) {
                        this.f5204b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                        this.f5203a.onFailure(this.f5204b);
                    }
                } else if (!TextUtils.isEmpty(this.f)) {
                    String optString = jSONObject.optString("ssnerror");
                    if (TextUtils.isEmpty(optString)) {
                        optString = "0";
                    }
                    int parseInt2 = Integer.parseInt(optString);
                    if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH.ordinal()) {
                        this.f5204b.failureType = GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH;
                    } else if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_EXPIRED.ordinal()) {
                        this.f5204b.failureType = GetTplStokenResult.FailureType.BDUSS_EXPIRED;
                    }
                    this.f5204b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    this.f5203a.onFailure(this.f5204b);
                }
            } catch (Exception e) {
                Log.e(e);
                if (!TextUtils.isEmpty(this.f)) {
                    this.f5204b.setResultCode(-205);
                    this.f5203a.onFailure(this.f5204b);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class r extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SapiCallback f5205a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OAuthResult f5206b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(Looper looper, SapiCallback sapiCallback, OAuthResult oAuthResult) {
            super(looper);
            this.f5205a = sapiCallback;
            this.f5206b = oAuthResult;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f5206b.setResultCode(i);
            this.f5205a.onFailure(this.f5206b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f5205a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f5205a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString(BaseJsonData.TAG_ERRNO));
                this.f5206b.setResultCode(parseInt);
                if (parseInt != 0) {
                    this.f5205a.onFailure(this.f5206b);
                } else {
                    this.f5206b.accessToken = jSONObject.optString("access_token");
                    this.f5206b.expiresIn = jSONObject.optInt("expires_in");
                    this.f5206b.scope = jSONObject.optString("scope");
                    this.f5206b.refreshToken = jSONObject.optString(Oauth2AccessToken.KEY_REFRESH_TOKEN);
                    this.f5206b.sessionKey = jSONObject.optString("session_key");
                    this.f5206b.sessionSecret = jSONObject.optString("session_secret");
                    this.f5206b.extra = str;
                    this.f5206b.openid = jSONObject.optString("openid");
                    this.f5205a.onSuccess(this.f5206b);
                }
            } catch (Throwable th) {
                this.f5206b.setResultCode(-202);
                this.f5205a.onFailure(this.f5206b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class s extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SapiCallBack f5207a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(Looper looper, SapiCallBack sapiCallBack) {
            super(looper);
            this.f5207a = sapiCallBack;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            if (i == -203) {
                this.f5207a.onSystemError(i);
            } else {
                c.this.b(this.f5207a, str);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            c.this.b(this.f5207a, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class t extends GetUserInfoCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IqiyiLoginCallback f5209a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ IqiyiLoginDTO f5210b;
        final /* synthetic */ IqiyiLoginResult c;
        final /* synthetic */ String d;

        t(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, IqiyiLoginResult iqiyiLoginResult, String str) {
            this.f5209a = iqiyiLoginCallback;
            this.f5210b = iqiyiLoginDTO;
            this.c = iqiyiLoginResult;
            this.d = str;
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
            c.this.a(this.f5209a, this.f5210b, this.c);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            this.c.setResultCode(getUserInfoResult.getResultCode());
            this.c.setResultMsg(getUserInfoResult.getResultMsg());
            this.f5209a.onFailure(this.c);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            String str = getUserInfoResult.secureMobile;
            boolean z = getUserInfoResult.incompleteUser;
            if (!TextUtils.isEmpty(str)) {
                this.f5209a.onSuccess(this.c);
            } else if (z) {
                c.this.a(this.f5209a, this.f5210b, this.c);
            } else if (!TextUtils.isEmpty(this.d)) {
                c.this.a(this.f5209a, this.f5210b, this.c);
            } else {
                this.f5209a.onSuccess(this.c);
            }
        }
    }

    private Domain u() {
        return this.f5170a.environment;
    }

    private String v() {
        return "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w() {
        return "tpl:" + this.f5170a.tpl + ";android_sapi_v8.9.9.1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("accesstoken", str);
            new HttpClientWrap().post(com.baidu.sapi2.utils.e.z, httpHashMapWrap, null, w(), new b(Looper.getMainLooper()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return u().getWap() + "/wp/v3/ucenter/realnameverify";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return u().getWap() + "/v6/shippingAddress";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return u().getURL() + com.baidu.sapi2.utils.e.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return u().getURL() + com.baidu.sapi2.utils.e.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return u().getURL() + "/phoenix/account/ssologin";
    }

    String i() {
        return u().getURL() + "/phoenix/account/ssologin";
    }

    public String j() {
        return u().getWap() + com.baidu.sapi2.utils.e.N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return u().getWap() + "/v6/invoiceManage";
    }

    String l() {
        return u().getWap() + com.baidu.sapi2.utils.e.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return u().getURL() + com.baidu.sapi2.utils.e.B;
    }

    String n() {
        return u().getWap() + com.baidu.sapi2.utils.e.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String o() {
        return u().getWap() + com.baidu.sapi2.utils.e.M;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String p() {
        return u().getWap() + "/wp/unitewidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String q() {
        return u().getWap() + "/passport/getpass";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String r() {
        return u().getWap() + "/passport/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String s() {
        return u().getWap() + "/v3/login/api/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        OAuthResult oAuthResult = new OAuthResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("openPlatformId", str2);
        }
        httpHashMapWrap.put("bduss", str);
        new HttpClientWrap().post(com.baidu.sapi2.utils.e.u, httpHashMapWrap, null, w(), new r(Looper.getMainLooper(), sapiCallback, oAuthResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
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
        String str = "";
        String str2 = "";
        if (currentAccount != null) {
            str = currentAccount.bduss;
            str2 = currentAccount.ptoken;
        }
        if (cookieBduss.equals(str) && !TextUtils.isEmpty(cookiePtoken) && cookiePtoken.equals(str2)) {
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        } else if (SapiAccountManager.getInstance().isLogin() && !z) {
            SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
            if (!cookieBduss.equals(currentAccount2.bduss)) {
                SapiAccountManager.getInstance().getAccountService().webLogin(this.f5170a.context, currentAccount2.bduss);
            }
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        } else {
            a((GetUserInfoCallback) new k(web2NativeLoginResult, web2NativeLoginCallback, cookieBduss, cookiePtoken), cookieBduss);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f extends AsyncTask<String, Void, Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f5180a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f5181b;
        final /* synthetic */ SsoHashCallback c;

        f(String str, String str2, SsoHashCallback ssoHashCallback) {
            this.f5180a = str;
            this.f5181b = str2;
            this.c = ssoHashCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Long doInBackground(String... strArr) {
            try {
                URLConnection openConnection = new URL(strArr[0]).openConnection();
                openConnection.setConnectTimeout(3000);
                openConnection.connect();
                return Long.valueOf(openConnection.getDate() / 1000);
            } catch (Exception e) {
                Log.e(e);
                return 0L;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Long l) {
            SsoHashResult ssoHashResult = new SsoHashResult();
            ssoHashResult.ssoHash = new com.baidu.sapi2.utils.h().a(l, this.f5180a, this.f5181b);
            ssoHashResult.setResultCode(0);
            this.c.onSuccess(ssoHashResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return u().getWap() + "/v4/security";
    }

    void b(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        try {
            int parseInt = Integer.parseInt(new JSONObject(str).optString(BaseJsonData.TAG_ERRNO));
            if (parseInt != 0) {
                sapiCallBack.onSystemError(parseInt);
            } else {
                SapiResponse sapiResponse = new SapiResponse();
                sapiResponse.errorCode = parseInt;
                sapiResponse.errorMsg = "短信验证码发送成功";
                sapiCallBack.onSuccess(sapiResponse);
            }
        } catch (Exception e2) {
            sapiCallBack.onSystemError(-100);
        }
    }

    int b(String str) {
        try {
            return new JSONObject(str).getInt(BaseJsonData.TAG_ERRNO);
        } catch (Exception e2) {
            Log.e(e2);
            return -100;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return u().getWap() + "/wp/v3/ucenter/index";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, boolean z) {
        SapiConfiguration sapiConfiguration = this.f5170a;
        if (sapiConfiguration != null && sapiConfiguration.context != null) {
            SapiUtils.notNull(sapiCallBack, SapiCallBack.class.getSimpleName() + " can't be null");
            new HttpClientWrap().get(v(), null, null, w(), new m(Looper.getMainLooper(), sapiCallBack, z, new SapiDataEncryptor(), str, str2));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, boolean z, SapiDataEncryptor sapiDataEncryptor) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("crypttype", "6");
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(com.baidu.sapi2.utils.e.f5389a);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("cert_id", str2);
        httpHashMapWrap.put("isdpass", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", "1");
        jSONObject.put("password", str4);
        jSONObject.put(Constants.KEY_LOGIN_TYPE, "3");
        jSONObject.put("key", sapiDataEncryptor.getAESKey());
        jSONObject.put(SapiContext.KEY_SDK_VERSION, "2");
        jSONObject.put("pinfo", SapiDeviceUtils.b());
        httpHashMapWrap.put(TableDefine.DB_TABLE_USERINFO, sapiDataEncryptor.encrypt(str, jSONObject.toString()));
        new HttpClientWrap().post(com.baidu.sapi2.utils.e.f5389a, httpHashMapWrap, null, w(), new n(Looper.getMainLooper(), sapiCallBack, z, sapiDataEncryptor));
    }

    void a(int i2, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z, SapiDataEncryptor sapiDataEncryptor) {
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
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.username = jSONObject.optString(BdStatsConstant.StatsKey.UNAME);
                sapiAccountResponse.uid = jSONObject.optString("uid");
                sapiAccountResponse.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
                sapiAccountResponse.bduss = jSONObject.optString("bduss");
                sapiAccountResponse.ptoken = jSONObject.optString("ptoken");
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
                    a2.putExtra("tpl", this.f5170a.tpl);
                    SapiShareClient.getInstance().validate(a2);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GetUserInfoCallback getUserInfoCallback, String str) {
        SapiUtils.notNull(getUserInfoCallback, GetUserInfoCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
        if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
            httpHashMapWrap.put("ptoken", accountFromBduss.ptoken);
        }
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(com.baidu.sapi2.utils.e.f5390b);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        new HttpClientWrap().post(com.baidu.sapi2.utils.e.f5390b, httpHashMapWrap, null, w(), new o(Looper.getMainLooper(), getUserInfoCallback, getUserInfoResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
            if (!TextUtils.isEmpty(this.f5170a.clientId)) {
                jSONObject.put("clientid", this.f5170a.clientId);
            }
            if (!TextUtils.isEmpty(this.f5170a.clientIp)) {
                jSONObject.put("clientip", this.f5170a.clientIp);
            }
            jSONObject.put("username", str2);
            jSONObject.put("key", sapiDataEncryptor.getAESKey());
            httpHashMapWrap.put(TableDefine.DB_TABLE_USERINFO, sapiDataEncryptor.encrypt("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", jSONObject.toString()));
            new HttpClientWrap().post(com.baidu.sapi2.utils.e.n, httpHashMapWrap, null, w(), new p(Looper.getMainLooper(), fillUsernameCallback, fillUsernameResult, sapiDataEncryptor));
        } catch (Throwable th) {
            fillUsernameResult.setResultCode(-202);
            fillUsernameCallback.onFailure(fillUsernameResult);
            Log.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, List<String> list) {
        SapiUtils.notEmpty(str, "bduss can't be empty");
        if (list != null && !list.isEmpty()) {
            return a(SapiContext.getInstance().getAccountFromBduss(str), list);
        }
        throw new IllegalArgumentException("targetTplList can't be null or empty");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiAccount sapiAccount, List<String> list) {
        boolean z;
        if (sapiAccount == null || TextUtils.isEmpty(sapiAccount.extra)) {
            return false;
        }
        try {
            SapiAccount.DispersionCertification fromJSONObject = SapiAccount.DispersionCertification.fromJSONObject(new JSONObject(sapiAccount.extra));
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (!fromJSONObject.tplStokenMap.containsKey(it.next())) {
                    z = false;
                    break;
                }
            }
            return z;
        } catch (JSONException e2) {
            Log.e(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
                str3 = str3 + "|" + list.get(i2);
            }
            if (TextUtils.isEmpty(str2)) {
                getTplStokenResult.setResultCode(-305);
                getTplStokenResult.failureType = GetTplStokenResult.FailureType.PTOKEN_EMPTY;
                getTplStokenCallback.onFailure(getTplStokenResult);
            }
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("bduss", str);
            httpHashMapWrap.put("sign", SecurityUtil.md5((this.f5170a.appId + this.f5170a.tpl + str + this.f5170a.appSignKey).getBytes(), false));
            httpHashMapWrap.put("return_type", "1");
            if (!TextUtils.isEmpty(str2)) {
                httpHashMapWrap.put("ptoken", str2);
            }
            httpHashMapWrap.put("tpl_list", str3);
            new HttpClientWrap().post(com.baidu.sapi2.utils.e.v, httpHashMapWrap, null, w(), new q(Looper.getMainLooper(), getTplStokenCallback, getTplStokenResult, accountFromBduss, list, z, str2));
            return getTplStokenResult.tplStokenMap;
        }
        getTplStokenResult.setResultCode(-302);
        getTplStokenResult.setResultMsg("参数错误，请稍后再试");
        getTplStokenCallback.onFailure(getTplStokenResult);
        return getTplStokenResult.tplStokenMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        Context context;
        SapiConfiguration sapiConfiguration = this.f5170a;
        if (sapiConfiguration == null || (context = sapiConfiguration.context) == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(257);
                return false;
            }
            return false;
        } else {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("username", str);
            new HttpClientWrap().post(com.baidu.sapi2.utils.e.o, httpHashMapWrap, null, w(), new s(Looper.getMainLooper(), sapiCallBack));
            return true;
        }
    }

    HttpHashMapWrap a(String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        httpHashMapWrap.put(SapiContext.KEY_SDK_VERSION, "3");
        return httpHashMapWrap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        if (iqiyiLoginCallback != null) {
            iqiyiLoginCallback.onStart();
            String str = iqiyiLoginDTO.accessToken;
            String str2 = iqiyiLoginDTO.phoneNum;
            String str3 = iqiyiLoginDTO.openID;
            IqiyiLoginResult iqiyiLoginResult = new IqiyiLoginResult();
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            boolean z = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) ? false : true;
            if (z || currentAccount != null) {
                if (z && currentAccount == null) {
                    a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
                    return;
                } else {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new t(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult, str2), currentAccount.bduss);
                    return;
                }
            }
            iqiyiLoginCallback.onLogin(iqiyiLoginResult);
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
            new HttpClientWrap().get(i(), a2, null, w(), new a(Looper.getMainLooper(), iqiyiLoginCallback, iqiyiLoginResult));
            return;
        }
        iqiyiLoginCallback.onLogin(iqiyiLoginResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(com.baidu.sapi2.utils.e.C);
        a2.put("clientfrom", "native");
        a2.put("bduss", str);
        if (map != null && !map.isEmpty()) {
            a2.putAll(map);
        }
        new HttpClientWrap().post(com.baidu.sapi2.utils.e.C, a2, null, w(), new C0339c(Looper.getMainLooper(), sapiCallback, new CheckUserFaceIdResult()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().m().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(com.baidu.sapi2.utils.e.E);
        a2.put("clientfrom", "native");
        a2.put("bduss", str);
        new HttpClientWrap().post(com.baidu.sapi2.utils.e.E, a2, null, w(), new d(Looper.getMainLooper(), sapiCallback, new FaceLoginStatusResult()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().m().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(com.baidu.sapi2.utils.e.E);
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
        new HttpClientWrap().post(com.baidu.sapi2.utils.e.D, a2, null, w(), new e(Looper.getMainLooper(), sapiCallback, new CheckUserFaceIdResult(), z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(SsoHashCallback ssoHashCallback, String str, String str2) {
        SapiUtils.notNull(ssoHashCallback, "SsoHashCallback can't be null");
        new f(str, str2, ssoHashCallback).execute(com.baidu.sapi2.utils.e.F);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("open_appid", str);
        httpHashMapWrap.put("open_apikey", str2);
        httpHashMapWrap.put("time", System.currentTimeMillis() + "");
        new HttpClientWrap().post(com.baidu.sapi2.utils.e.G, httpHashMapWrap, null, w(), new g(Looper.getMainLooper(), sapiCallback, new SapiResult()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, int i2) {
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put(FuFaceItem.JK_ABILITY, "onekeylogin");
        httpHashMapWrap.put("scene", "api");
        httpHashMapWrap.put("clientfrom", "native");
        httpHashMapWrap.put("mobile", str);
        String n2 = n();
        new HttpClientWrap().get(n2, httpHashMapWrap, ParamsUtil.buildNaCookie(n2, this.f5170a), w(), i2, new h(Looper.getMainLooper(), oneKeyLoginResult, str, oneKeyLoginCallback));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, com.baidu.sapi2.callback.a.b bVar) {
        String packageName;
        JSONObject jSONObject = new JSONObject();
        try {
            String c2 = new OneKeyLoginSdkCall().c();
            jSONObject.put("token", str);
            jSONObject.put("tpl", this.f5170a.tpl);
            jSONObject.put("client", HttpConstants.OS_TYPE_VALUE);
            jSONObject.put("clientfrom", "native");
            jSONObject.put("appid", this.f5170a.appId);
            jSONObject.put("operator", c2);
            jSONObject.put("scene", "api");
            jSONObject.put("sign", str2);
            if ("CM".equals(c2)) {
                packageName = this.f5170a.chinaMobileAppID;
            } else if ("CT".equals(c2)) {
                packageName = this.f5170a.chinaTelecomAppKey;
            } else {
                packageName = this.f5170a.context.getPackageName();
                jSONObject.put("CUVersion", "2");
            }
            jSONObject.put("appid", packageName);
        } catch (JSONException e2) {
            Log.e(e2);
        }
        com.baidu.sapi2.utils.d.a(SapiContext.getInstance().getOneKeyLoginJsCode(), OneKeyLoginResult.secondJsCode, jSONObject.toString(), this.f5170a.context, new i(oneKeyLoginCallback, bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, String str3, OneKeyLoginResult oneKeyLoginResult) {
        new HttpClientWrap().get(str, new j(Looper.getMainLooper(), str2, oneKeyLoginCallback, str3, oneKeyLoginResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, ShareStorage.StorageModel storageModel) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().u.a(e.c.f5231b).c) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            if (i2 == 2) {
                httpHashMapWrap.put("cmd", "insert");
            } else if (i2 == 3) {
                httpHashMapWrap.put("cmd", "delete");
            } else if (i2 == 4) {
                httpHashMapWrap.put("cmd", "reset");
            } else {
                return;
            }
            if (i2 == 2 && storageModel.flag == 0 && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                httpHashMapWrap.put("bduss", currentAccount.bduss);
                httpHashMapWrap.put("ptoken", currentAccount.ptoken);
                httpHashMapWrap.put("stoken", currentAccount.stoken);
            }
            httpHashMapWrap.put("app", SapiUtils.getAppName(this.f5170a.context));
            httpHashMapWrap.put(Config.INPUT_DEF_PKG, this.f5170a.context.getPackageName());
            new HttpClientWrap().post(com.baidu.sapi2.utils.e.O, httpHashMapWrap, new l(Looper.getMainLooper(), i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, String> hashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.f5170a.environment.getWap(), hashMap.get("HISTORY")));
        SapiUtils.syncCookies(this.f5170a.context, arrayList);
    }

    SapiAccount a(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = SapiUtils.getAppName(this.f5170a.context);
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        return u().getWap() + bindWidgetAction.getUri();
    }
}
