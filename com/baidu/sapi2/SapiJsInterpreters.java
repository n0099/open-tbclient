package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.text.TextUtils;
import android.widget.DatePicker;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.g;
import com.baidu.sapi2.utils.l;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.webkit.internal.ETAG;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SapiJsInterpreters {

    /* renamed from: g  reason: collision with root package name */
    public static final String f10663g = "SapiJsInterpreters";

    /* renamed from: a  reason: collision with root package name */
    public SapiWebView f10664a;

    /* renamed from: c  reason: collision with root package name */
    public SapiJsCallBacks.CallBacks f10666c;

    /* renamed from: d  reason: collision with root package name */
    public Context f10667d;

    /* renamed from: f  reason: collision with root package name */
    public long f10669f;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, AbstractInterpreter> f10668e = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public SapiConfiguration f10665b = SapiAccountManager.getInstance().getSapiConfiguration();

    /* loaded from: classes2.dex */
    public abstract class AbstractInterpreter {
        public AbstractInterpreter() {
        }

        public abstract String interpret(SapiWebView.Command command);
    }

    /* loaded from: classes2.dex */
    public class ActionBindWidgetPhoneNumberExist extends AbstractInterpreter {
        public ActionBindWidgetPhoneNumberExist() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.f10666c.f10662h != null) {
                SapiJsInterpreters.this.f10666c.f10662h.onPhoneNumberExist(str);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionFaceLoginSwitch extends AbstractInterpreter {
        public ActionFaceLoginSwitch() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString("livinguname");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                new FaceLoginService().syncFaceLoginUID(SapiJsInterpreters.this.f10667d, optString);
                return null;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class ActionForgetPwd extends AbstractInterpreter {
        public ActionForgetPwd() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.f10666c.H != null ? SapiJsInterpreters.this.f10666c.H.onForgetPwd() : false ? "1" : "0";
        }
    }

    /* loaded from: classes2.dex */
    public class ActionGenerateSign extends AbstractInterpreter {
        public ActionGenerateSign() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return SapiUtils.calculateSig(hashMap, SapiJsInterpreters.this.f10665b.appSignKey);
        }
    }

    /* loaded from: classes2.dex */
    public class ActionGetLoadtime extends AbstractInterpreter {
        public ActionGetLoadtime() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView unused = SapiJsInterpreters.this.f10664a;
            if (SapiWebView.statLoadLogin != null) {
                SapiWebView unused2 = SapiJsInterpreters.this.f10664a;
                return SapiWebView.statLoadLogin.a().toString();
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionGetSmsCheckCodeFromClip extends AbstractInterpreter {
        public ActionGetSmsCheckCodeFromClip() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        @TargetApi(11)
        public String interpret(SapiWebView.Command command) {
            String str = "";
            try {
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.f10667d.getSystemService("clipboard");
                if (clipboardManager.hasPrimaryClip()) {
                    str = SapiUtils.getSmsCheckCode(clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
            SapiStatUtil.statSmsCodeClip(SapiJsInterpreters.this.f10667d, TextUtils.isEmpty(str) ? "0" : "1");
            return str;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionGloryLogin extends AbstractInterpreter {
        public ActionGloryLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.f10656b != null) {
                Message message = new Message();
                message.what = SocialType.GLORY.getType();
                message.obj = SocialType.GLORY;
                SapiJsInterpreters.this.f10666c.f10656b.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionHuaweiLogin extends AbstractInterpreter {
        public ActionHuaweiLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.f10656b != null) {
                Message message = new Message();
                message.what = SocialType.HUAWEI.getType();
                message.obj = SocialType.HUAWEI;
                SapiJsInterpreters.this.f10666c.f10656b.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionJoinLogin extends AbstractInterpreter {
        public ActionJoinLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                Object[] pkgIconAndName = SapiUtils.getPkgIconAndName(SapiJsInterpreters.this.f10667d, SapiJsInterpreters.this.f10667d.getPackageName());
                jSONObject.put("icon", pkgIconAndName[0]);
                jSONObject.put("name", pkgIconAndName[1]);
                List<ShareStorage.StorageModel> e2 = com.baidu.sapi2.share.d.e();
                Object obj = "false";
                if (SapiJsInterpreters.this.f10666c.s != null && e2 != null && e2.size() > 0) {
                    jSONObject.put("openShareLogin", "true");
                } else {
                    jSONObject.put("openShareLogin", "false");
                }
                if (SapiJsInterpreters.this.f10666c.U != null) {
                    obj = SapiJsInterpreters.this.f10666c.U.hasThirdAccount + "";
                }
                jSONObject.put("hasThirdAccount", obj);
                jSONObject.put("supportFaceLogin", new FaceLoginService().isSupFaceLogin());
                if (SapiJsInterpreters.this.f10666c.U != null && SapiJsInterpreters.this.f10666c.U.agreement != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : SapiJsInterpreters.this.f10666c.U.agreement.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", str);
                        jSONObject2.put("url", SapiJsInterpreters.this.f10666c.U.agreement.get(str));
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("agreement", jSONArray);
                }
            } catch (Exception e3) {
                Log.e(e3);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class ActionLoadExternalWebview extends AbstractInterpreter {
        public ActionLoadExternalWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.i != null) {
                SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult = new SapiWebView.LoadExternalWebViewResult();
                loadExternalWebViewResult.defaultTitle = command.getActionParams().get(0);
                loadExternalWebViewResult.externalUrl = command.getActionParams().get(1);
                SapiJsInterpreters.this.f10666c.i.loadExternalWebview(loadExternalWebViewResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionLoadSlideWebview extends AbstractInterpreter {
        public ActionLoadSlideWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.w != null) {
                SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult = new SapiWebView.LoadSlideWebViewResult();
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    loadSlideWebViewResult.placeholderTitle = jSONObject.optString("placeholderTitle");
                    loadSlideWebViewResult.url = jSONObject.optString("url");
                    loadSlideWebViewResult.page = jSONObject.optString("page");
                    loadSlideWebViewResult.adapter = jSONObject.optString("adapter");
                    SapiJsInterpreters.this.f10666c.w.loadSlideWebview(loadSlideWebViewResult);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("errno", "0");
                    return jSONObject2.toString();
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionRemoveShareAccount extends AbstractInterpreter {
        public ActionRemoveShareAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionSetTitle extends AbstractInterpreter {
        public ActionSetTitle() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.f10666c.f10657c != null) {
                SapiJsInterpreters.this.f10666c.f10657c.onTitleChange(str);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionShareAccountsViewBtnClicked extends AbstractInterpreter {
        public ActionShareAccountsViewBtnClicked() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.f10661g != null) {
                SapiJsInterpreters.this.f10666c.f10661g.handleOtherLogin();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionShareClickOther extends AbstractInterpreter {
        public ActionShareClickOther() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiStatUtil.statShareClickOther(command.getActionParams().get(0), SapiJsInterpreters.this.f10664a.extras);
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionShareV2Login extends AbstractInterpreter {
        public ActionShareV2Login() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.f10666c.Z.pageParams.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class ActionShareV2LoginClick extends AbstractInterpreter {
        public ActionShareV2LoginClick() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.f10666c.Z.onSuccess();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionShareV2LoginFail extends AbstractInterpreter {
        public ActionShareV2LoginFail() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.f10666c.Z.onError();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionSocialMeizuSso extends AbstractInterpreter {
        public ActionSocialMeizuSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.f10656b != null) {
                Message message = new Message();
                message.what = SocialType.MEIZU.getType();
                message.obj = SocialType.MEIZU;
                SapiJsInterpreters.this.f10666c.f10656b.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionSocialQqSso extends AbstractInterpreter {
        public ActionSocialQqSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.f10656b != null) {
                Message message = new Message();
                message.what = SocialType.QQ_SSO.getType();
                message.obj = SocialType.QQ_SSO;
                SapiJsInterpreters.this.f10666c.f10656b.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionSocialSinaSso extends AbstractInterpreter {
        public ActionSocialSinaSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.f10656b != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO_SSO.getType();
                message.obj = SocialType.SINA_WEIBO_SSO;
                SapiJsInterpreters.this.f10666c.f10656b.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionSocialSso extends AbstractInterpreter {
        public ActionSocialSso() {
            super();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
            if (r5.equals(com.baidu.sapi2.utils.enums.FastLoginFeature.a.f11479a) != false) goto L8;
         */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            SocialType socialType;
            if (SapiJsInterpreters.this.f10666c.f10656b != null) {
                char c2 = 0;
                String str = command.getActionParams().get(0);
                switch (str.hashCode()) {
                    case -1519161818:
                        break;
                    case -1506464740:
                        if (str.equals(FastLoginFeature.a.f11486h)) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -952571024:
                        if (str.equals(FastLoginFeature.a.f11482d)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -19158255:
                        if (str.equals(FastLoginFeature.a.f11484f)) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3872:
                        if (str.equals(FastLoginFeature.a.j)) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 110658813:
                        if (str.equals("tsina")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 738596251:
                        if (str.equals(FastLoginFeature.a.f11485g)) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1288743885:
                        if (str.equals(FastLoginFeature.a.f11480b)) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1587088523:
                        if (str.equals(FastLoginFeature.a.i)) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        socialType = SocialType.WEIXIN;
                        break;
                    case 1:
                    case 2:
                        socialType = SocialType.SINA_WEIBO_SSO;
                        break;
                    case 3:
                        socialType = SocialType.QQ_SSO;
                        break;
                    case 4:
                        socialType = SocialType.HUAWEI;
                        break;
                    case 5:
                        socialType = SocialType.GLORY;
                        break;
                    case 6:
                        socialType = SocialType.XIAOMI;
                        break;
                    case 7:
                        socialType = SocialType.MEIZU;
                        break;
                    case '\b':
                        socialType = SocialType.YY;
                        break;
                    default:
                        socialType = null;
                        break;
                }
                if (socialType != null) {
                    Message message = new Message();
                    message.what = socialType.getType();
                    message.obj = socialType;
                    SapiJsInterpreters.this.f10666c.f10656b.sendMessage(message);
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionSocialWeixinSso extends AbstractInterpreter {
        public ActionSocialWeixinSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.f10656b != null) {
                Message message = new Message();
                message.what = SocialType.WEIXIN.getType();
                message.obj = SocialType.WEIXIN;
                SapiJsInterpreters.this.f10666c.f10656b.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionStopSlideWebview extends AbstractInterpreter {
        public ActionStopSlideWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.E != null) {
                boolean z = false;
                try {
                    z = new JSONObject(command.getActionParams().get(0)).optBoolean("isStop");
                } catch (Exception e2) {
                    Log.e(e2);
                }
                SapiJsInterpreters.this.f10666c.E.onStopSlide(z);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ActionXiaoMiSso extends AbstractInterpreter {
        public ActionXiaoMiSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.f10656b != null) {
                Message message = new Message();
                message.what = SocialType.XIAOMI.getType();
                message.obj = SocialType.XIAOMI;
                SapiJsInterpreters.this.f10666c.f10656b.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class AddressManageGetPasteboard extends AbstractInterpreter {
        public AddressManageGetPasteboard() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.f10667d.getSystemService("clipboard");
                if (clipboardManager.hasPrimaryClip()) {
                    jSONObject.put("paste", clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class AuthorizedResponse extends AbstractInterpreter {
        public AuthorizedResponse() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            int parseInt = command.getActionParams().size() >= 2 ? Integer.parseInt(command.getActionParams().get(1)) : 0;
            String str2 = command.getActionParams().size() >= 3 ? command.getActionParams().get(2) : null;
            if (parseInt == 1) {
                SocialResponse b2 = SapiWebView.b(str, SapiJsInterpreters.this.f10667d);
                if (b2 == null) {
                    if (SapiJsInterpreters.this.f10666c.H != null) {
                        SapiJsInterpreters.this.f10664a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.f10666c.H != null) {
                                    SapiJsInterpreters.this.f10666c.H.onFailed(-100, "登录失败");
                                }
                            }
                        });
                    }
                } else if (b2.offlineNotice || b2.bindGuide || b2.errorCode == 21 || b2.bindConflict) {
                    SapiJsInterpreters.this.f10666c.T = b2;
                } else {
                    SapiJsInterpreters.this.f10664a.a(b2);
                }
            }
            if (parseInt == 0) {
                final SapiAccountResponse a2 = SapiJsInterpreters.this.f10664a.a(str, SapiJsInterpreters.this.f10667d);
                if (a2 == null) {
                    if (SapiJsInterpreters.this.f10666c.H != null) {
                        SapiJsInterpreters.this.f10664a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.f10666c.H != null) {
                                    SapiJsInterpreters.this.f10666c.H.onFailed(-100, "登录失败");
                                }
                            }
                        });
                    }
                } else {
                    int i = a2.errorCode;
                    if (i == 0 || i == 110000) {
                        SapiJsInterpreters.this.f10664a.a(a2);
                        if (SapiWebView.SWITCH_ACCOUNT_PAGE.equals(str2)) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("errno", 0);
                            } catch (JSONException e2) {
                                Log.e(e2);
                            }
                            return jSONObject.toString();
                        }
                    } else if (SapiJsInterpreters.this.f10666c.H != null) {
                        SapiJsInterpreters.this.f10664a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.f10666c.H != null) {
                                    AuthorizationListener authorizationListener = SapiJsInterpreters.this.f10666c.H;
                                    SapiAccountResponse sapiAccountResponse = a2;
                                    authorizationListener.onFailed(sapiAccountResponse.errorCode, sapiAccountResponse.errorMsg);
                                }
                            }
                        });
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class Back extends AbstractInterpreter {
        public Back() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.f10664a.back();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class ConfigFastloginFeatures extends AbstractInterpreter {
        public ConfigFastloginFeatures() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            List<FastLoginFeature> fastLoginFeatureList = SapiJsInterpreters.this.f10666c.v != null ? SapiJsInterpreters.this.f10666c.v.getFastLoginFeatureList() : null;
            if (fastLoginFeatureList == null) {
                fastLoginFeatureList = SapiJsInterpreters.this.f10665b.fastLoginFeatureList;
            }
            if (fastLoginFeatureList == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance().isHostsHijacked()) {
                return sb.toString();
            }
            for (int i = 0; i < fastLoginFeatureList.size(); i++) {
                FastLoginFeature fastLoginFeature = fastLoginFeatureList.get(i);
                if (i == 0) {
                    sb.append(fastLoginFeature.getStrValue());
                } else {
                    sb.append(",");
                    sb.append(fastLoginFeature.getStrValue());
                }
            }
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class ConfigLoginShareStrategy extends AbstractInterpreter {
        public ConfigLoginShareStrategy() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.f10665b.loginShareStrategy().getStrValue();
        }
    }

    /* loaded from: classes2.dex */
    public class CurrentAccountBdussExpired extends AbstractInterpreter {
        public CurrentAccountBdussExpired() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.D != null) {
                SapiJsInterpreters.this.f10666c.D.onBdussExpired();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class CurrentPageName extends AbstractInterpreter {
        public CurrentPageName() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.F != null) {
                try {
                    SapiJsInterpreters.this.f10666c.F.getCurrentPageName(new JSONObject(command.getActionParams().get(0)).optString("name"));
                    return null;
                } catch (Exception e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class Finish extends AbstractInterpreter {
        public Finish() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.f10664a.a(SapiJsInterpreters.this.f10666c.T);
            if (command.getActionParams().size() > 0) {
                try {
                    SapiJsInterpreters.this.f10664a.finish(new JSONObject(command.getActionParams().get(0)).optString("page"));
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            } else {
                SapiJsInterpreters.this.f10664a.finish();
            }
            if (SapiJsInterpreters.this.f10666c.z != null) {
                SapiJsInterpreters.this.f10666c.z.onFinish(command.getActionParams().size() > 0 ? command.getActionParams().get(0) : "");
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class FocusEdittextCoordinateY extends AbstractInterpreter {
        public FocusEdittextCoordinateY() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.M != null) {
                try {
                    SapiJsInterpreters.this.f10666c.M.onCallback(new JSONObject(command.getActionParams().get(0)).optInt("coordinateY"));
                    return null;
                } catch (Exception e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class GetAllClientAccounts extends AbstractInterpreter {
        public GetAllClientAccounts() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            Log.d(com.baidu.sapi2.share.d.f11377a, "GetAllClientAccounts ----- start --------");
            SapiContext sapiContext = SapiContext.getInstance();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            List<SapiAccount> touchidAccounts = sapiContext.getTouchidAccounts();
            try {
                JSONArray jSONArray = new JSONArray();
                boolean z = com.baidu.sapi2.g.d.a(SapiJsInterpreters.this.f10665b) == 0;
                for (SapiAccount sapiAccount : touchidAccounts) {
                    JSONObject jSONObject2 = sapiAccount.toJSONObject();
                    if (!TextUtils.isEmpty(sapiAccount.phone) && sapiAccount.phone.contains("http://")) {
                        sapiAccount.phone = sapiAccount.phone.replace("http://", "https://");
                    }
                    jSONObject2.put("portrait", sapiAccount.phone);
                    if (!z) {
                        jSONObject2.put("touchCode", "1");
                    } else {
                        jSONObject2.put("touchCode", TextUtils.isEmpty(sapiAccount.email) ? "1" : "0");
                    }
                    jSONObject2.remove("phone");
                    jSONObject2.remove("extra");
                    jSONObject2.remove("app");
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("fingerAccounts", jSONArray);
            } catch (Exception e3) {
                Log.e(e3);
            }
            try {
                jSONObject.put("onekeyAccounts", new OneKeyLoginSdkCall().getEncryptPhone());
            } catch (Exception e4) {
                Log.e(e4);
            }
            try {
                jSONObject.put("faceAccounts", sapiContext.getV2FaceLoginCheckResults());
            } catch (Exception e5) {
                Log.e(e5);
            }
            try {
                Log.d(com.baidu.sapi2.share.d.f11377a, "GetAllClientAccounts ----- share start --------");
                List<ShareStorage.StorageModel> e6 = com.baidu.sapi2.share.d.e();
                JSONArray jSONArray2 = ShareStorage.StorageModel.toJSONArray(e6);
                if (jSONArray2 != null && jSONArray2.length() != 0) {
                    jSONObject.put("from", com.baidu.sapi2.share.d.f11384h);
                    jSONObject.put("canshare2Accounts", jSONArray2);
                    Log.d(com.baidu.sapi2.share.d.f11377a, "shareV2 value=" + jSONObject.toString());
                    SapiStatUtil.statShareV2Open(e6, null, SapiJsInterpreters.this.f10664a.extras);
                } else if (sapiContext.getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_SHARE_V3).f10806c) {
                    String[] split = sapiContext.getBaiduAppPkgList().split(",");
                    String[] b2 = com.baidu.sapi2.share.d.b();
                    JSONArray jSONArray3 = new JSONArray();
                    JSONArray jSONArray4 = new JSONArray();
                    if (split != null && split.length > 0) {
                        for (String str : split) {
                            jSONArray3.put(str);
                        }
                    }
                    if (b2 != null && b2.length > 0) {
                        for (String str2 : b2) {
                            jSONArray4.put(str2);
                        }
                    }
                    jSONObject.put("from", com.baidu.sapi2.share.d.i);
                    jSONObject.put("appList", jSONArray3);
                    jSONObject.put("deleteAccounts", jSONArray4);
                    jSONObject.put("currentAppPkg", SapiJsInterpreters.this.f10665b.context.getPackageName());
                    Log.d(com.baidu.sapi2.share.d.f11377a, "shareV3 value=" + jSONObject.toString());
                } else {
                    Log.d(com.baidu.sapi2.share.d.f11377a, "not support shareV3");
                }
            } catch (Exception e7) {
                Log.e(e7);
            }
            try {
                jSONObject.put("recentLoginUid", sapiContext.getDecryptStr(SapiContext.KEY_LAST_LOGIN_UID));
                if (SapiJsInterpreters.this.f10664a != null && SapiJsInterpreters.this.f10664a.mExcludeTypes != null) {
                    jSONObject.put("excludeTypes", SapiJsInterpreters.this.f10664a.mExcludeTypes.getName());
                }
            } catch (JSONException e8) {
                Log.e(e8);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class GetCurrentAccountInfo extends AbstractInterpreter {
        public GetCurrentAccountInfo() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            JSONObject jSONObject = new JSONObject();
            if (currentAccount != null) {
                try {
                    currentAccount.portrait = currentAccount.getCompletePortrait();
                    jSONObject.put("currentAccount", currentAccount.toJSONObject());
                    jSONObject.put("errno", 0);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class GetPresetPhoneNumber extends AbstractInterpreter {
        public GetPresetPhoneNumber() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10665b.forbidPresetPhoneNumber) {
                return "";
            }
            if (SapiUtils.isValidPhoneNumber(SapiJsInterpreters.this.f10665b.presetPhoneNumber)) {
                return SapiJsInterpreters.this.f10665b.presetPhoneNumber;
            }
            String localPhoneNumber = SapiJsInterpreters.this.f10664a.getLocalPhoneNumber();
            return SapiUtils.isValidPhoneNumber(localPhoneNumber) ? localPhoneNumber : "";
        }
    }

    /* loaded from: classes2.dex */
    public class GrantWebLogin extends AbstractInterpreter {
        public GrantWebLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                int optInt = new JSONObject(command.getActionParams().get(0)).optInt("type");
                if (SapiJsInterpreters.this.f10666c.C != null) {
                    SapiJsInterpreters.this.f10666c.C.onGrant(optInt);
                    return null;
                }
                return null;
            } catch (Exception e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class InvoiceBuildSelectedInvoice extends AbstractInterpreter {
        public InvoiceBuildSelectedInvoice() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.J != null && command.getActionParams().size() > 0) {
                SapiJsInterpreters.this.f10666c.J.onCallback(command.getActionParams().get(0));
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class NormalizeGuestAccount extends AbstractInterpreter {
        public NormalizeGuestAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                int optInt = jSONObject.optInt("errno");
                String optString = jSONObject.optString("msg");
                if (optInt != 0) {
                    if (SapiJsInterpreters.this.f10666c.y != null) {
                        SapiJsInterpreters.this.f10666c.y.onFailure(optInt, optString);
                    }
                } else {
                    boolean z = jSONObject.optInt("merge") == 1;
                    String optString2 = jSONObject.optString("normalizeWay");
                    SapiAccountResponse a2 = SapiJsInterpreters.this.f10664a.a(jSONObject.optString("xml"), SapiJsInterpreters.this.f10667d);
                    if (a2 == null) {
                        if (SapiJsInterpreters.this.f10666c.y != null) {
                            SapiJsInterpreters.this.f10666c.y.onFailure(NormalizeGuestAccountResult.ERROR_CODE_PARSE_XML, NormalizeGuestAccountResult.ERROR_MSG_PARSE_XML);
                        }
                    } else {
                        SapiAccount b2 = SapiJsInterpreters.this.f10664a.b(a2);
                        if (!SapiAccount.isValidAccount(b2)) {
                            SapiJsInterpreters.this.f10666c.y.onFailure(-202, "网络连接失败，请检查网络设置");
                            return null;
                        }
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        if (currentAccount != null) {
                            b2.addSocialInfo(currentAccount.getSocialType(), currentAccount.getSocialPortrait());
                        }
                        SapiAccountManager.getInstance().removeLoginAccount(currentAccount);
                        SapiAccountManager.getInstance().validate(b2);
                        if (SapiJsInterpreters.this.f10666c.y != null) {
                            SapiJsInterpreters.this.f10666c.y.onSuccess(z, optString2);
                        }
                    }
                }
            } catch (JSONException e2) {
                Log.e(e2);
                if (SapiJsInterpreters.this.f10666c.y != null) {
                    SapiJsInterpreters.this.f10666c.y.onFailure(-202, "网络连接失败，请检查网络设置");
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class NormalizeGuestDescription extends AbstractInterpreter {
        public NormalizeGuestDescription() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                if (!TextUtils.isEmpty(SapiJsInterpreters.this.f10666c.V)) {
                    jSONObject.put("description", new JSONObject(SapiJsInterpreters.this.f10666c.V));
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class OauthCallBaidu extends AbstractInterpreter {
        public OauthCallBaidu() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.Y != null) {
                SapiJsInterpreters.this.f10666c.Y.callback.onCallback(command.getActionParams().get(0));
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class OauthSsoHash extends AbstractInterpreter {
        public OauthSsoHash() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.OauthSsoHash.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(SsoHashResult ssoHashResult) {
                    SapiJsInterpreters.this.f10666c.P.confirm(ssoHashResult.ssoHash);
                }
            }, SapiJsInterpreters.this.f10666c.Y.callingPkg, SapiJsInterpreters.this.f10666c.Y.callingAppId);
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class RealNameVerifySucceed extends AbstractInterpreter {
        public RealNameVerifySucceed() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.n != null) {
                SapiJsInterpreters.this.f10666c.n.onSuccess();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionAccountCenterFastloginFeatures extends AbstractInterpreter {
        public SapiActionAccountCenterFastloginFeatures() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            ArrayList arrayList = new ArrayList();
            if (SapiJsInterpreters.this.f10665b.fastLoginFeatureList == null || SapiJsInterpreters.this.f10665b.fastLoginFeatureList.isEmpty()) {
                return null;
            }
            arrayList.addAll(SapiJsInterpreters.this.f10665b.fastLoginFeatureList);
            if (arrayList.isEmpty()) {
                return null;
            }
            arrayList.remove(FastLoginFeature.MEIZU_SSO);
            arrayList.remove(FastLoginFeature.SINA_WEIBO_SSO);
            arrayList.remove(FastLoginFeature.TX_QQ_SSO);
            arrayList.remove(FastLoginFeature.HUAWEI_LOGIN);
            arrayList.remove(FastLoginFeature.TX_WEIXIN_SSO);
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance().isHostsHijacked()) {
                return sb.toString();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                FastLoginFeature fastLoginFeature = (FastLoginFeature) arrayList.get(i);
                if (i == 0) {
                    sb.append(fastLoginFeature.getStrValue());
                } else {
                    sb.append(",");
                    sb.append(fastLoginFeature.getStrValue());
                }
            }
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionAccountDestroy extends AbstractInterpreter {
        public SapiActionAccountDestroy() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.q != null) {
                SapiJsInterpreters.this.f10666c.q.onAccountDestory(new SapiWebView.AccountDestoryCallback.AccountDestoryResult());
            }
            SapiJsInterpreters.this.f10664a.finish();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionAccountFreeze extends AbstractInterpreter {
        public SapiActionAccountFreeze() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.r != null) {
                SapiJsInterpreters.this.f10666c.r.onAccountFreeze(new SapiWebView.AccountFreezeCallback.AccountFreezeResult());
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionBdussChanged extends AbstractInterpreter {
        public SapiActionBdussChanged() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.k != null) {
                SapiJsInterpreters.this.f10666c.k.onBdussChange();
            } else {
                SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionBdussChanged.1
                    @Override // com.baidu.sapi2.callback.Web2NativeLoginCallback
                    public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                    }
                }, true);
            }
            new com.baidu.sapi2.utils.c().a(com.baidu.sapi2.utils.c.i);
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionCheckLoginStatus extends AbstractInterpreter {
        public SapiActionCheckLoginStatus() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (SapiJsInterpreters.this.f10666c.B != null) {
                    jSONObject.put("sup", true);
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionCheckMethodSupport extends AbstractInterpreter {
        public SapiActionCheckMethodSupport() {
            super();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
            if (r4.f10726b.f10665b.supportFaceLogin != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
            if (r4.f10726b.f10666c.u != null) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
            if (r4.f10726b.f10665b.supportFaceLogin != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
            r0 = true;
         */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            boolean z;
            boolean z2 = false;
            String str = command.getActionParams().get(0);
            try {
                Class.forName(SapiJsInterpreters.this.c(str));
                z = true;
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (str.equals("sapi_biometrics_identification_with_uid")) {
                if (SapiJsInterpreters.this.f10666c.f10658d != null) {
                }
            } else if (str.equals("sapi_biometrics_identification") || str.equals("sapi_biometrics_identification_no_bduss") || str.equals("sapi_biometrics_identification_with_authtoken")) {
                if (SapiJsInterpreters.this.f10666c.f10659e != null) {
                }
            } else if (!str.equals("sapi_action_sc_app_check")) {
                z2 = z;
            }
            return z2 ? "1" : "0";
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionChinaMobileOauth extends AbstractInterpreter {
        public SapiActionChinaMobileOauth() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            new OneKeyLoginSdkCall().getToken(SapiJsInterpreters.this.f10665b, new OneKeyLoginSdkCall.TokenListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionChinaMobileOauth.1
                @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                public void onGetTokenComplete(JSONObject jSONObject) {
                    Log.d(OneKeyLoginSdkCall.TAG, "SapiActionChinaMobileOauth onGetTokenComplete result=" + jSONObject);
                    SapiJsInterpreters.this.f10666c.P.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionCoverWebBduss extends AbstractInterpreter {
        public SapiActionCoverWebBduss() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String cookieBduss = SapiUtils.getCookieBduss();
            if (SapiJsInterpreters.this.f10666c.o != null) {
                SapiJsInterpreters.this.f10666c.o.onCoverBduss(cookieBduss, new SapiWebView.CoverWebBdussResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionCoverWebBduss.1
                    @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussResult
                    public void setWebBduss(String str) {
                        SapiJsInterpreters.this.f10664a.a(SapiJsInterpreters.this.f10667d, str);
                        SapiJsInterpreters.this.f10664a.reload();
                    }
                });
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionDeliverParams extends AbstractInterpreter {
        public SapiActionDeliverParams() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString("username");
                boolean equals = jSONObject.optString(IntentConfig.CLOSE, "0").equals("1");
                SapiWebView.PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult = new SapiWebView.PreFillUserNameCallback.PreFillUserNameResult();
                preFillUserNameResult.userName = optString;
                if (SapiJsInterpreters.this.f10666c.p != null) {
                    SapiJsInterpreters.this.f10666c.p.onPreFillUserName(preFillUserNameResult);
                }
                if (equals) {
                    SapiJsInterpreters.this.f10664a.finish();
                    return null;
                }
                return null;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionDirectedLogin extends AbstractInterpreter {
        public SapiActionDirectedLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("encryptedId", SapiJsInterpreters.this.f10666c.W.encryptedId);
                jSONObject.put("displayname", SapiJsInterpreters.this.f10666c.W.displayname);
                jSONObject.put("errno", 0);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionGetAppTpl extends AbstractInterpreter {
        public SapiActionGetAppTpl() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.f10665b.getTpl();
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionGetNaUiConfig extends AbstractInterpreter {

        /* renamed from: b  reason: collision with root package name */
        public String f10734b;

        public SapiActionGetNaUiConfig() {
            super();
            this.f10734b = "sapi_action_get_na_ui_config";
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", "0");
                if (SapiJsInterpreters.this.f10665b != null) {
                    jSONObject.put("textZoom", SapiJsInterpreters.this.f10665b.textZoom);
                } else {
                    jSONObject.put("textZoom", 100);
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                Log.e(this.f10734b, "get na ui config error");
                return "";
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionHandleBackButton extends AbstractInterpreter {
        public SapiActionHandleBackButton() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.f10666c.Q = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.f10666c.m != null) {
                SapiJsInterpreters.this.f10666c.m.onLeftBtnVisible(SapiJsInterpreters.this.f10666c.Q);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionHideSuccessTip extends AbstractInterpreter {
        public SapiActionHideSuccessTip() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hideTip", SapiJsInterpreters.this.f10666c.X ? "1" : "0");
                jSONObject.put("errno", 0);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionLastLoginType extends AbstractInterpreter {
        public SapiActionLastLoginType() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lastLoginType", SapiUtils.getLastLoginType());
                jSONObject.put("errno", 0);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionLoginStatusChange extends AbstractInterpreter {
        public SapiActionLoginStatusChange() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.B != null) {
                SapiJsInterpreters.this.f10666c.B.onChange();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionMiniDi extends AbstractInterpreter {
        public SapiActionMiniDi() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONArray optJSONArray = new JSONObject(command.getActionParams().get(0)).optJSONArray("di_keys");
                if (optJSONArray == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        arrayList.add(optJSONArray.optString(i));
                    }
                }
                return SapiDeviceInfo.getDiCookieInfo(arrayList, false);
            } catch (Exception e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionPasteboardSet extends AbstractInterpreter {
        public SapiActionPasteboardSet() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                ((ClipboardManager) SapiJsInterpreters.this.f10667d.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("address", new JSONObject(command.getActionParams().get(0)).optString("content")));
                jSONObject.put("errno", 0);
                return jSONObject.toString();
            } catch (Exception e2) {
                Log.e(e2);
                return jSONObject.toString();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionPickDate extends AbstractInterpreter {
        public SapiActionPickDate() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        @TargetApi(11)
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            Calendar calendar = Calendar.getInstance();
            Date time = calendar.getTime();
            try {
                calendar.setTime(new SimpleDateFormat("yyyyMMdd").parse(str));
            } catch (Exception e2) {
                Log.e(e2);
            }
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            int i3 = calendar.get(5);
            calendar.setTime(time);
            int i4 = calendar.get(1);
            int i5 = calendar.get(2);
            int i6 = calendar.get(5);
            DatePickerDialog datePickerDialog = new DatePickerDialog(SapiJsInterpreters.this.f10667d, 3, new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.1
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public void onDateSet(DatePicker datePicker, int i7, int i8, int i9) {
                    SapiJsInterpreters.this.f10666c.P.confirm(i7 + String.format("%02d", Integer.valueOf(i8 + 1)) + String.format("%02d", Integer.valueOf(i9)) + "");
                }
            }, i, i2, i3);
            datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    SapiJsInterpreters.this.f10666c.P.confirm("");
                }
            });
            datePickerDialog.setTitle("");
            calendar.set(i4, i5, i6, 23, 59, 59);
            datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
            calendar.set(i4 - 100, i5, i6, 0, 0, 0);
            datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
            datePickerDialog.show();
            datePickerDialog.setCustomTitle(null);
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionPickImage extends AbstractInterpreter {
        public SapiActionPickImage() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int i = 0;
            try {
                i = Integer.parseInt(command.getActionParams().get(0));
            } catch (Exception e2) {
                Log.e(e2);
            }
            int i2 = 512;
            int i3 = 1;
            if (command.getActionParams().size() > 1) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                    i3 = jSONObject.optInt("sence", 1);
                    i2 = jSONObject.optInt("size", 512);
                } catch (JSONException e3) {
                    Log.e(e3);
                }
            }
            SapiJsInterpreters.this.f10666c.j.onPickImage(i, i3, i2, new SapiWebView.PickPhotoResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickImage.1
                @Override // com.baidu.sapi2.SapiWebView.PickPhotoResult
                public void setImageData(String str) {
                    if (SapiJsInterpreters.this.f10666c.P != null) {
                        SapiJsInterpreters.this.f10666c.P.confirm(str);
                    }
                }
            });
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionQrLogin extends AbstractInterpreter {
        public SapiActionQrLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                if (SapiJsInterpreters.this.f10666c.t != null) {
                    int optInt = jSONObject.optInt("relogin", -1);
                    if (optInt == 1) {
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        String optString = jSONObject.optString("bduss");
                        String optString2 = jSONObject.optString(SapiAccount.f10606h);
                        if (currentAccount != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            currentAccount.bduss = optString;
                            currentAccount.ptoken = optString2;
                            currentAccount.deleteStokens();
                            SapiAccountManager.getInstance().validate(currentAccount);
                        }
                    }
                    SapiJsInterpreters.this.f10666c.t.loginStatusChange(optInt == 1);
                }
                if (SapiJsInterpreters.this.f10666c.R) {
                    SapiJsInterpreters.this.f10664a.finish();
                    return null;
                }
                return null;
            } catch (Exception e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionRealname extends AbstractInterpreter {
        public SapiActionRealname() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                int optInt = jSONObject.optInt("status");
                accountRealNameResult.callbackkey = jSONObject.optString("callbackKey");
                if (SapiJsInterpreters.this.f10666c.A != null) {
                    if (optInt == 1) {
                        accountRealNameResult.juniorRealNameSuc = true;
                    } else if (optInt == 2) {
                        accountRealNameResult.seniorRealNameSuc = true;
                    }
                    SapiJsInterpreters.this.f10666c.A.onFinish(accountRealNameResult);
                    return null;
                }
                return null;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionScAppCheck extends AbstractInterpreter {
        public SapiActionScAppCheck() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                jSONObject.optString("action");
                String optString = jSONObject.optString("minver");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("state", new com.baidu.sapi2.f.a().a(SapiJsInterpreters.this.f10667d, optString, SapiJsInterpreters.this.f10666c.u));
                return jSONObject2.toString();
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionScAppInvoke extends AbstractInterpreter {
        public SapiActionScAppInvoke() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("minver");
                ArrayList arrayList = new ArrayList();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.equals("action")) {
                        arrayList.add(new PassNameValuePair(next, jSONObject.optString(next)));
                    }
                }
                SapiJsInterpreters.this.f10666c.u.onInvokeScApp(optString, optString2, arrayList, new SapiWebView.InvokeScAppCallback.InvokeScAppResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionScAppInvoke.1
                    @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback.InvokeScAppResult
                    public void setInvokeResult(String str) {
                        SapiJsInterpreters.this.f10666c.P.confirm(str);
                    }
                });
                return null;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionSwitchAccount extends AbstractInterpreter {
        public SapiActionSwitchAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.l != null) {
                List<String> actionParams = command.getActionParams();
                SapiWebView.SwitchAccountCallback.Result result = new SapiWebView.SwitchAccountCallback.Result();
                if (actionParams != null && actionParams.size() > 0) {
                    if (actionParams.size() > 1) {
                        try {
                            JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                            result.extraJson = jSONObject.optString("extrajson");
                            result.displayName = jSONObject.optString("displayname");
                            result.encryptedUid = jSONObject.optString("uid");
                            result.loginType = jSONObject.optInt("type");
                            result.switchAccountType = 2;
                            SapiJsInterpreters.this.f10666c.l.onAccountSwitch(result);
                            return null;
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                    } else {
                        result.userName = actionParams.get(0);
                        result.switchAccountType = 1;
                        SapiJsInterpreters.this.f10666c.l.onAccountSwitch(result);
                        return null;
                    }
                }
                result.switchAccountType = 0;
                SapiJsInterpreters.this.f10666c.l.onAccountSwitch(result);
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionThirdInstalledInfo extends AbstractInterpreter {
        public SapiActionThirdInstalledInfo() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", "0");
                JSONArray jSONArray = new JSONArray();
                if (l.d(SapiJsInterpreters.this.f10667d)) {
                    jSONArray.put(l.f11528a);
                }
                if (l.b(SapiJsInterpreters.this.f10667d)) {
                    jSONArray.put("qzone");
                }
                if (l.c(SapiJsInterpreters.this.f10667d)) {
                    jSONArray.put("tsina");
                }
                jSONObject.put("types", jSONArray);
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionThirdSafetyVerification extends AbstractInterpreter {
        public SapiActionThirdSafetyVerification() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.f10655a == null) {
                SapiJsInterpreters.this.f10666c.P.cancel();
                return null;
            }
            try {
                SapiJsInterpreters.this.f10666c.f10655a.sendMessage(l.a(new JSONObject(command.getActionParams().get(0)).optString("type")));
                return null;
            } catch (JSONException e2) {
                e2.printStackTrace();
                if (SapiJsInterpreters.this.f10666c == null || SapiJsInterpreters.this.f10666c.P == null) {
                    return null;
                }
                SapiJsInterpreters.this.f10666c.P.cancel();
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionUpdateNavigator extends AbstractInterpreter {
        public SapiActionUpdateNavigator() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int parseInt = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.f10666c.I != null) {
                SapiJsInterpreters.this.f10666c.I.pageState(parseInt);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionUpsms extends AbstractInterpreter {
        public SapiActionUpsms() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(command.getActionParams().get(0));
            SapiUtils.sendSms(SapiJsInterpreters.this.f10667d, command.getActionParams().get(1), arrayList);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", "0");
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class SapiBiometricsIdentification extends AbstractInterpreter {
        public SapiBiometricsIdentification() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentification.1
                @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.f10666c.P != null) {
                        SapiJsInterpreters.this.f10666c.P.confirm(str);
                    }
                }
            };
            biometricsIdentifyResult.biometricType = Integer.parseInt(command.getActionParams().get(0));
            biometricsIdentifyResult.livenessRecogType = "bduss";
            biometricsIdentifyResult.recordVideo = 0;
            biometricsIdentifyResult.subPro = "pp";
            if (command.getActionParams().size() > 1) {
                biometricsIdentifyResult.recordVideo = Integer.parseInt(command.getActionParams().get(1));
            }
            if (command.getActionParams().size() > 2) {
                biometricsIdentifyResult.subPro = command.getActionParams().get(2).toString();
            }
            if (command.getActionParams().size() > 3) {
                try {
                    biometricsIdentifyResult.showGuidePage = 1 - new JSONObject(command.getActionParams().get(3)).optInt("hideGuidePage", 0);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            biometricsIdentifyResult.subPro = TextUtils.isEmpty(biometricsIdentifyResult.subPro) ? "pp" : biometricsIdentifyResult.subPro;
            if (SapiJsInterpreters.this.f10666c.f10659e != null) {
                SapiJsInterpreters.this.f10666c.f10659e.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiBiometricsIdentificationLive extends AbstractInterpreter {
        public SapiBiometricsIdentificationLive() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.N == null) {
                SapiJsInterpreters.this.f10666c.P.cancel();
                return null;
            }
            try {
                SapiJsInterpreters.this.f10666c.N.getLiveImage((int) (Float.parseFloat(new JSONObject(command.getActionParams().get(0)).optString("scale")) * 100.0f), new PassFaceRecogCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationLive.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
                    public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", 0);
                            jSONObject.put("businessno", passFaceRecogResult.getResultCode());
                            SapiJsInterpreters.this.f10666c.P.confirm(jSONObject.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            SapiJsInterpreters.this.f10666c.P.cancel();
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
                    public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", 0);
                            jSONObject.put("originalimage", passFaceRecogResult.originalImage);
                            jSONObject.put("credentialKey", passFaceRecogResult.callbackkey);
                            SapiJsInterpreters.this.f10666c.P.confirm(jSONObject.toString());
                        } catch (JSONException e2) {
                            Log.e(SapiJsInterpreters.f10663g, e2.getMessage());
                            SapiJsInterpreters.this.f10666c.P.cancel();
                        }
                    }
                });
                return null;
            } catch (JSONException e2) {
                Log.e(SapiJsInterpreters.f10663g, e2.getMessage());
                if (SapiJsInterpreters.this.f10666c == null || SapiJsInterpreters.this.f10666c.P == null) {
                    return null;
                }
                SapiJsInterpreters.this.f10666c.P.cancel();
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiBiometricsIdentificationNoBduss extends AbstractInterpreter {
        public SapiBiometricsIdentificationNoBduss() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationNoBduss.1
                @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.f10666c.P != null) {
                        SapiJsInterpreters.this.f10666c.P.confirm(str);
                    }
                }
            };
            biometricsIdentifyResult.biometricType = Integer.parseInt(command.getActionParams().get(0));
            biometricsIdentifyResult.livenessRecogType = "certinfo";
            biometricsIdentifyResult.realName = command.getActionParams().get(1);
            biometricsIdentifyResult.idCardNum = command.getActionParams().get(2);
            biometricsIdentifyResult.recordVideo = 0;
            biometricsIdentifyResult.phoneNum = "";
            if (command.getActionParams().size() > 3) {
                biometricsIdentifyResult.recordVideo = Integer.parseInt(command.getActionParams().get(3));
            }
            if (command.getActionParams().size() > 4) {
                biometricsIdentifyResult.phoneNum = command.getActionParams().get(4);
            }
            biometricsIdentifyResult.subPro = "pp";
            if (command.getActionParams().size() > 5) {
                biometricsIdentifyResult.subPro = command.getActionParams().get(5);
            }
            if (command.getActionParams().size() > 6) {
                try {
                    biometricsIdentifyResult.showGuidePage = 1 - new JSONObject(command.getActionParams().get(6)).optInt("hideGuidePage", 0);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            biometricsIdentifyResult.subPro = TextUtils.isEmpty(biometricsIdentifyResult.subPro) ? "pp" : biometricsIdentifyResult.subPro;
            if (SapiJsInterpreters.this.f10666c.f10659e != null) {
                SapiJsInterpreters.this.f10666c.f10659e.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiBiometricsIdentificationWithAuthtoken extends AbstractInterpreter {
        public SapiBiometricsIdentificationWithAuthtoken() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationWithAuthtoken.1
                @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.f10666c.P != null) {
                        SapiJsInterpreters.this.f10666c.P.confirm(str);
                    }
                }
            };
            biometricsIdentifyResult.biometricType = Integer.parseInt(command.getActionParams().get(0));
            biometricsIdentifyResult.livenessRecogType = "authtoken";
            biometricsIdentifyResult.authToken = command.getActionParams().get(1);
            biometricsIdentifyResult.recordVideo = 0;
            biometricsIdentifyResult.subPro = "pp";
            if (command.getActionParams().size() > 2) {
                biometricsIdentifyResult.recordVideo = Integer.parseInt(command.getActionParams().get(2));
            }
            if (command.getActionParams().size() > 3) {
                biometricsIdentifyResult.subPro = command.getActionParams().get(3).toString();
            }
            if (command.getActionParams().size() > 4) {
                try {
                    biometricsIdentifyResult.showGuidePage = 1 - new JSONObject(command.getActionParams().get(4)).optInt("hideGuidePage", 0);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            biometricsIdentifyResult.subPro = TextUtils.isEmpty(biometricsIdentifyResult.subPro) ? "pp" : biometricsIdentifyResult.subPro;
            if (SapiJsInterpreters.this.f10666c.f10659e != null) {
                SapiJsInterpreters.this.f10666c.f10659e.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiBiometricsIdentificationWithUid extends AbstractInterpreter {
        public SapiBiometricsIdentificationWithUid() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.f10658d == null) {
                return null;
            }
            SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult = new SapiWebView.BioScanFaceCallback.BioScanFaceResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationWithUid.1
                @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback.BioScanFaceResult
                public void setScanFaceIdentifyResult(String str) {
                    SapiJsInterpreters.this.f10666c.P.confirm(str);
                }
            };
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                bioScanFaceResult.uid = jSONObject.optString("uid");
                bioScanFaceResult.type = jSONObject.optInt("type");
                bioScanFaceResult.subpro = jSONObject.optString("subpro");
                bioScanFaceResult.showGuidePage = 1 - jSONObject.optInt("hideGuidePage", 0);
                if (TextUtils.isEmpty(bioScanFaceResult.subpro)) {
                    bioScanFaceResult.subpro = "pp";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("transParams");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        bioScanFaceResult.transParamsMap.put(next, optJSONObject.optString(next));
                    }
                }
                SapiJsInterpreters.this.f10666c.f10658d.onBioScanFace(bioScanFaceResult);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiGoBack extends AbstractInterpreter {
        public SapiGoBack() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10664a.canGoBack()) {
                SapiJsInterpreters.this.f10664a.goBack();
                return null;
            }
            SapiJsInterpreters.this.f10664a.finish();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiOnekeyOauthToken extends AbstractInterpreter {
        public SapiOnekeyOauthToken() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            new OneKeyLoginSdkCall().getMobileOauthToken(SapiJsInterpreters.this.f10665b, new OneKeyLoginSdkCall.TokenListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiOnekeyOauthToken.1
                @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                public void onGetTokenComplete(JSONObject jSONObject) {
                    Log.d(OneKeyLoginSdkCall.TAG, "SapiOnekeyOauthToken onGetTokenComplete result=" + jSONObject.toString());
                    SapiJsInterpreters.this.f10666c.P.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiRemoveLoginHistory extends AbstractInterpreter {
        public SapiRemoveLoginHistory() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                JSONObject jSONObject2 = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject2.optString("portraitSign");
                if (!TextUtils.isEmpty(optString)) {
                    SapiContext.getInstance().removeTouchidAccountByPortrait(optString);
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray(FaceLoginService.f11393d);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    SapiContext.getInstance().markAsDeleteFaceLogin(optJSONArray);
                }
                String optString2 = jSONObject2.optString("portrait");
                if (!TextUtils.isEmpty(optString2)) {
                    String[] split = optString2.split("/");
                    String str = split[split.length - 1];
                    if (str.contains(".")) {
                        str = str.substring(0, str.lastIndexOf("."));
                    }
                    com.baidu.sapi2.share.d.a(str);
                }
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class SapiShareAccountClick extends AbstractInterpreter {
        public SapiShareAccountClick() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String optString;
            if (System.currentTimeMillis() - SapiJsInterpreters.this.f10669f > 1000) {
                SapiJsInterpreters.this.f10669f = System.currentTimeMillis();
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    String optString2 = jSONObject.optString("pkg");
                    String optString3 = jSONObject.optString("from", com.baidu.sapi2.share.d.f11384h);
                    if (com.baidu.sapi2.share.d.i.equals(optString3)) {
                        optString = jSONObject.optString("portrait");
                    } else {
                        optString = jSONObject.optString("url");
                    }
                    String str = optString;
                    String optString4 = jSONObject.optString("trace_id");
                    String optString5 = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID);
                    SapiJsInterpreters.this.f10666c.P.confirm("finish");
                    SapiJsInterpreters.this.f10666c.s.onClick(optString2, str, optString4, optString5, optString3);
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SpeechRecognitionGetContent extends AbstractInterpreter {
        public SpeechRecognitionGetContent() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.f10666c.x.onSpeechRecognition(new SapiJsCallBacks.SpeechRecognitionResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SpeechRecognitionGetContent.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionResult
                public void setSpeechData(int i, String str) {
                    if (SapiJsInterpreters.this.f10666c.P != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", i);
                            jSONObject.put("text", str);
                            SapiJsInterpreters.this.f10666c.P.confirm(jSONObject.toString());
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                    }
                }
            });
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SwitchAccountGetAccounts extends AbstractInterpreter {
        public SwitchAccountGetAccounts() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            List<SapiAccount> arrayList = new ArrayList<>();
            if (SapiJsInterpreters.this.f10665b.supportMultipleAccounts) {
                arrayList = SapiContext.getInstance().getLoginAccounts();
            } else {
                arrayList.add(SapiContext.getInstance().getCurrentAccount());
            }
            JSONArray jSONArray = new JSONArray();
            try {
                for (SapiAccount sapiAccount : arrayList) {
                    JSONObject jSONObject2 = sapiAccount.toJSONObject();
                    jSONObject2.put("portrait", sapiAccount.getCompletePortrait());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("errno", 0);
                jSONObject.put("accountList", jSONArray);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class SwitchAccountGetConfig extends AbstractInterpreter {
        public SwitchAccountGetConfig() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                jSONObject.put("showSwitchAccount", SapiJsInterpreters.this.f10664a.showSwitchAccount ? 1 : 0);
                jSONObject.put("showLinkAccount", SapiJsInterpreters.this.f10664a.showLinkAccount ? 1 : 0);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class SwitchAccountRemoveAccount extends AbstractInterpreter {
        public SwitchAccountRemoveAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString("uid");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                for (SapiAccount sapiAccount : SapiContext.getInstance().getLoginAccounts()) {
                    if (optString.equals(sapiAccount.uid)) {
                        SapiAccountManager.getInstance().removeLoginAccount(sapiAccount);
                        jSONObject.put("errno", 0);
                        return jSONObject.toString();
                    }
                }
                return null;
            } catch (Exception e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SwitchStyleForCloseBtnAndStatusBar extends AbstractInterpreter {
        public SwitchStyleForCloseBtnAndStatusBar() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f10666c.L != null) {
                try {
                    SapiJsInterpreters.this.f10666c.L.switchStyle(new JSONObject(command.getActionParams().get(0)).optString("styleType"));
                    return null;
                } catch (Exception e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class TouchidChangeStatus extends AbstractInterpreter {
        public TouchidChangeStatus() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            String str;
            String str2;
            String str3;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                jSONObject.put("status", 0);
                JSONObject jSONObject2 = new JSONObject(command.getActionParams().get(0));
                str = jSONObject2.optString("handle");
                try {
                    str2 = jSONObject2.optString("portrait");
                    try {
                        str3 = jSONObject2.optString("portraitSign");
                    } catch (JSONException e2) {
                        e = e2;
                        Log.e(e);
                        str3 = null;
                        final SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        currentAccount.phone = str2;
                        if (!"open".equals(str)) {
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str2 = null;
                }
            } catch (JSONException e4) {
                e = e4;
                str = null;
                str2 = null;
            }
            final SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
            currentAccount2.phone = str2;
            if (!"open".equals(str)) {
                currentAccount2.email = str3;
                SapiJsCallBacks.FingerprintResult fingerprintResult = new SapiJsCallBacks.FingerprintResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.TouchidChangeStatus.1
                    @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintResult
                    public void setResult(int i) {
                        try {
                            jSONObject.put("status", i);
                            if (i == 0) {
                                SapiContext.getInstance().addTouchidAccounts(currentAccount2);
                            }
                            SapiJsInterpreters.this.f10666c.P.confirm(jSONObject.toString());
                        } catch (Exception e5) {
                            Log.e(e5);
                        }
                    }
                };
                if (SapiJsInterpreters.this.f10666c.K != null) {
                    SapiJsInterpreters.this.f10666c.K.onCallback(fingerprintResult);
                }
                return null;
            }
            currentAccount2.email = "";
            SapiContext.getInstance().addTouchidAccounts(currentAccount2);
            SapiJsInterpreters.this.f10666c.P.confirm(jSONObject.toString());
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class TouchidCheckGuideStatus extends AbstractInterpreter {
        public TouchidCheckGuideStatus() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            boolean z;
            String str;
            JSONObject jSONObject = new JSONObject();
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString("portraitSign");
                int a2 = com.baidu.sapi2.g.d.a(SapiJsInterpreters.this.f10665b);
                boolean contains = SapiContext.getInstance().getTouchidLoginRecord().contains(optString);
                List<SapiAccount> touchidAccounts = SapiContext.getInstance().getTouchidAccounts();
                if (touchidAccounts != null) {
                    for (SapiAccount sapiAccount : touchidAccounts) {
                        if (sapiAccount != null && sapiAccount.email != null && sapiAccount.email.equals(optString)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                int i = (a2 != 0 || TextUtils.isEmpty(optString) || contains) ? 0 : 1;
                if (!SapiJsInterpreters.this.f10664a.supportTouchGuide) {
                    i = 0;
                }
                if (z) {
                    i = 0;
                }
                jSONObject.put("errno", 0);
                jSONObject.put(AuthoritySharedPreferences.KEY_CONFIG_FIRSTSHOT_GUIDE, i);
                if (TextUtils.isEmpty(optString)) {
                    str = "100";
                } else if (a2 == 101 || a2 == 102) {
                    str = a2 + "";
                } else if (contains) {
                    str = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
                } else if (!SapiJsInterpreters.this.f10664a.supportTouchGuide) {
                    str = TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT;
                } else if (z) {
                    str = TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP;
                } else {
                    str = a2 + "";
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                linkedHashMap.put("native_guide_finger", str);
                StatService.onEventAutoStatistic(linkedHashMap);
                if (i == 1) {
                    SapiContext.getInstance().addTouchidLoginRecord(optString);
                }
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class TouchidGetStatus extends AbstractInterpreter {
        public TouchidGetStatus() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            boolean z;
            JSONObject jSONObject = new JSONObject();
            try {
                int i = 1;
                if (com.baidu.sapi2.g.d.a(SapiJsInterpreters.this.f10665b) == 0) {
                    List<SapiAccount> touchidAccounts = SapiContext.getInstance().getTouchidAccounts();
                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    Iterator<SapiAccount> it = touchidAccounts.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        SapiAccount next = it.next();
                        if (next.equals(currentAccount) && !TextUtils.isEmpty(next.email)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        i = 2;
                    }
                } else {
                    i = 0;
                }
                jSONObject.put("errno", 0);
                jSONObject.put("status", i);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class TouchidLogin extends AbstractInterpreter {
        public TouchidLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsCallBacks.FingerprintResult fingerprintResult = new SapiJsCallBacks.FingerprintResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.TouchidLogin.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintResult
                public void setResult(int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("status", i);
                        SapiJsInterpreters.this.f10666c.P.confirm(jSONObject.toString());
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
            };
            fingerprintResult.authType = 3;
            if (SapiJsInterpreters.this.f10666c.K != null) {
                SapiJsInterpreters.this.f10666c.K.onCallback(fingerprintResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class TouchidOpenGuide extends AbstractInterpreter {
        public TouchidOpenGuide() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(final SapiWebView.Command command) {
            SapiJsCallBacks.FingerprintResult fingerprintResult = new SapiJsCallBacks.FingerprintResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.TouchidOpenGuide.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintResult
                public void setResult(int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("status", i);
                        SapiJsInterpreters.this.f10666c.P.confirm(jSONObject.toString());
                        if (i == 0) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(command.getActionParams().get(0));
                                String optString = jSONObject2.optString("portrait");
                                String optString2 = jSONObject2.optString("portraitSign");
                                if (TextUtils.isEmpty(optString)) {
                                    String[] strArr = SapiJsInterpreters.this.f10666c.O;
                                    strArr[0] = SapiJsInterpreters.this.f10665b.environment.getConfigHttpsUrl() + g.t;
                                    String[] strArr2 = SapiJsInterpreters.this.f10664a.touchidPortraitAndSign;
                                    strArr2[0] = SapiJsInterpreters.this.f10665b.environment.getConfigHttpsUrl() + g.t;
                                } else {
                                    SapiJsInterpreters.this.f10666c.O[0] = optString;
                                    SapiJsInterpreters.this.f10664a.touchidPortraitAndSign[0] = optString;
                                }
                                SapiJsInterpreters.this.f10666c.O[1] = optString2;
                                SapiJsInterpreters.this.f10664a.touchidPortraitAndSign[1] = optString2;
                            } catch (Exception e2) {
                                Log.e(e2);
                            }
                        }
                    } catch (Exception e3) {
                        Log.e(e3);
                    }
                }
            };
            if (SapiJsInterpreters.this.f10666c.K != null) {
                SapiJsInterpreters.this.f10666c.K.onCallback(fingerprintResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class UniteVerifyResult extends AbstractInterpreter {
        public UniteVerifyResult() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString("info");
                String optString2 = jSONObject.optString("u");
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = jSONObject.optString("passuid");
                sapiAccount.username = jSONObject.optString("username");
                sapiAccount.displayname = jSONObject.optString("displayname");
                sapiAccount.bduss = jSONObject.optString("bduss");
                sapiAccount.ptoken = jSONObject.optString(SapiAccount.f10606h);
                sapiAccount.stoken = jSONObject.optString("stoken");
                if (TextUtils.isEmpty(optString) || !SapiAccount.isValidAccount(sapiAccount) || SapiJsInterpreters.this.f10666c.f10660f == null) {
                    return null;
                }
                SapiJsInterpreters.this.f10666c.f10660f.onSuccess(optString, optString2, sapiAccount);
                return null;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    public SapiJsInterpreters(SapiWebView sapiWebView, SapiJsCallBacks.CallBacks callBacks) {
        this.f10664a = sapiWebView;
        this.f10667d = sapiWebView.getContext();
        this.f10666c = callBacks;
    }

    private AbstractInterpreter b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (AbstractInterpreter) Class.forName(c(str)).getDeclaredConstructor(getClass()).newInstance(this);
        } catch (Exception e2) {
            Log.e(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        String[] split = str.split("_");
        StringBuilder sb = new StringBuilder();
        sb.append("com.baidu.sapi2.SapiJsInterpreters$");
        for (String str2 : split) {
            char[] charArray = str2.toCharArray();
            if (charArray[0] >= 'a' && charArray[0] <= 'z') {
                charArray[0] = (char) (charArray[0] - ' ');
            }
            sb.append(new String(charArray));
        }
        return sb.toString();
    }

    public AbstractInterpreter a(String str) {
        AbstractInterpreter abstractInterpreter = this.f10668e.get(str);
        if (abstractInterpreter == null && (abstractInterpreter = b(str)) != null) {
            this.f10668e.put(str, abstractInterpreter);
        }
        return abstractInterpreter;
    }
}
