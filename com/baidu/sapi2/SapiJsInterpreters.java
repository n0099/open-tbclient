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
import com.baidu.sapi2.callback.IdcardOcrImageCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.IdcardOcrImageRusult;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.touchid.FingerprintUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
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
    public static final String TAG = "SapiJsInterpreters";
    public Context context;
    public SapiJsCallBacks.CallBacks jsCallBacks;
    public long preShareClickTime;
    public SapiWebView sapiWebView;
    public HashMap<String, AbstractInterpreter> interpreterHashMap = new HashMap<>();
    public SapiConfiguration configuration = SapiAccountManager.getInstance().getSapiConfiguration();

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
            if (SapiJsInterpreters.this.jsCallBacks.bindWidgetCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.bindWidgetCallback.onPhoneNumberExist(str);
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
                new FaceLoginService().syncFaceLoginUID(SapiJsInterpreters.this.context, optString);
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
            return SapiJsInterpreters.this.jsCallBacks.authorizationListener != null ? SapiJsInterpreters.this.jsCallBacks.authorizationListener.onForgetPwd() : false ? "1" : "0";
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
            return SapiUtils.calculateSig(hashMap, SapiJsInterpreters.this.configuration.appSignKey);
        }
    }

    /* loaded from: classes2.dex */
    public class ActionGetLoadtime extends AbstractInterpreter {
        public ActionGetLoadtime() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView unused = SapiJsInterpreters.this.sapiWebView;
            if (SapiWebView.statLoadLogin != null) {
                SapiWebView unused2 = SapiJsInterpreters.this.sapiWebView;
                return SapiWebView.statLoadLogin.toJSON().toString();
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
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.context.getSystemService("clipboard");
                if (clipboardManager.hasPrimaryClip()) {
                    str = SapiUtils.getSmsCheckCode(clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
            SapiStatUtil.statSmsCodeClip(SapiJsInterpreters.this.context, TextUtils.isEmpty(str) ? "0" : "1");
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
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                Message message = new Message();
                message.what = SocialType.GLORY.getType();
                message.obj = SocialType.GLORY;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
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
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                Message message = new Message();
                message.what = SocialType.HUAWEI.getType();
                message.obj = SocialType.HUAWEI;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
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
                Object[] pkgIconAndName = SapiUtils.getPkgIconAndName(SapiJsInterpreters.this.context, SapiJsInterpreters.this.context.getPackageName());
                jSONObject.put("icon", pkgIconAndName[0]);
                jSONObject.put("name", pkgIconAndName[1]);
                List<ShareStorage.StorageModel> shareStorageModel = ShareUtils.getShareStorageModel();
                Object obj = "false";
                if (SapiJsInterpreters.this.jsCallBacks.shareAccountClickCallback != null && shareStorageModel != null && shareStorageModel.size() > 0) {
                    jSONObject.put("openShareLogin", "true");
                } else {
                    jSONObject.put("openShareLogin", "false");
                }
                if (SapiJsInterpreters.this.jsCallBacks.joinLoginParams != null) {
                    obj = SapiJsInterpreters.this.jsCallBacks.joinLoginParams.hasThirdAccount + "";
                }
                jSONObject.put("hasThirdAccount", obj);
                jSONObject.put("supportFaceLogin", new FaceLoginService().isSupFaceLogin());
                if (SapiJsInterpreters.this.jsCallBacks.joinLoginParams != null && SapiJsInterpreters.this.jsCallBacks.joinLoginParams.agreement != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : SapiJsInterpreters.this.jsCallBacks.joinLoginParams.agreement.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", str);
                        jSONObject2.put("url", SapiJsInterpreters.this.jsCallBacks.joinLoginParams.agreement.get(str));
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("agreement", jSONArray);
                }
            } catch (Exception e2) {
                Log.e(e2);
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
            if (SapiJsInterpreters.this.jsCallBacks.loadExternalWebViewCallback != null) {
                SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult = new SapiWebView.LoadExternalWebViewResult();
                loadExternalWebViewResult.defaultTitle = command.getActionParams().get(0);
                loadExternalWebViewResult.externalUrl = command.getActionParams().get(1);
                SapiJsInterpreters.this.jsCallBacks.loadExternalWebViewCallback.loadExternalWebview(loadExternalWebViewResult);
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
            if (SapiJsInterpreters.this.jsCallBacks.loadSlideWebViewCallback != null) {
                SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult = new SapiWebView.LoadSlideWebViewResult();
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    loadSlideWebViewResult.placeholderTitle = jSONObject.optString("placeholderTitle");
                    loadSlideWebViewResult.url = jSONObject.optString("url");
                    loadSlideWebViewResult.page = jSONObject.optString("page");
                    loadSlideWebViewResult.adapter = jSONObject.optString("adapter");
                    SapiJsInterpreters.this.jsCallBacks.loadSlideWebViewCallback.loadSlideWebview(loadSlideWebViewResult);
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
            if (SapiJsInterpreters.this.jsCallBacks.webViewTitleCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.webViewTitleCallback.onTitleChange(str);
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
            if (SapiJsInterpreters.this.jsCallBacks.quickLoginHandler != null) {
                SapiJsInterpreters.this.jsCallBacks.quickLoginHandler.handleOtherLogin();
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
            SapiStatUtil.statShareClickOther(command.getActionParams().get(0), SapiJsInterpreters.this.sapiWebView.extras);
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
            return SapiJsInterpreters.this.jsCallBacks.shareV2LoginParams.pageParams.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class ActionShareV2LoginClick extends AbstractInterpreter {
        public ActionShareV2LoginClick() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.jsCallBacks.shareV2LoginParams.onSuccess();
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
            SapiJsInterpreters.this.jsCallBacks.shareV2LoginParams.onError();
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
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                Message message = new Message();
                message.what = SocialType.MEIZU.getType();
                message.obj = SocialType.MEIZU;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
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
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                Message message = new Message();
                message.what = SocialType.QQ_SSO.getType();
                message.obj = SocialType.QQ_SSO;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
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
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO_SSO.getType();
                message.obj = SocialType.SINA_WEIBO_SSO;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
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
            if (r5.equals(com.baidu.sapi2.utils.enums.FastLoginFeature.SSOLoginType.WEIXIN) != false) goto L8;
         */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            SocialType socialType;
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                char c2 = 0;
                String str = command.getActionParams().get(0);
                switch (str.hashCode()) {
                    case -1519161818:
                        break;
                    case -1506464740:
                        if (str.equals(FastLoginFeature.SSOLoginType.MEIZU)) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -952571024:
                        if (str.equals(FastLoginFeature.SSOLoginType.QQ)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -19158255:
                        if (str.equals(FastLoginFeature.SSOLoginType.HUAWEI)) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3872:
                        if (str.equals(FastLoginFeature.SSOLoginType.YY)) {
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
                        if (str.equals(FastLoginFeature.SSOLoginType.HONOR)) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1288743885:
                        if (str.equals(FastLoginFeature.SSOLoginType.SINA_SSO)) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1587088523:
                        if (str.equals(FastLoginFeature.SSOLoginType.XIAOMI)) {
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
                    SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
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
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                Message message = new Message();
                message.what = SocialType.WEIXIN.getType();
                message.obj = SocialType.WEIXIN;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
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
            if (SapiJsInterpreters.this.jsCallBacks.stopSlideWebviewCallback != null) {
                boolean z = false;
                try {
                    z = new JSONObject(command.getActionParams().get(0)).optBoolean("isStop");
                } catch (Exception e2) {
                    Log.e(e2);
                }
                SapiJsInterpreters.this.jsCallBacks.stopSlideWebviewCallback.onStopSlide(z);
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
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                Message message = new Message();
                message.what = SocialType.XIAOMI.getType();
                message.obj = SocialType.XIAOMI;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
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
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.context.getSystemService("clipboard");
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
                SocialResponse parseOpenApiAuthorizedResult = SapiWebView.parseOpenApiAuthorizedResult(str, SapiJsInterpreters.this.context);
                if (parseOpenApiAuthorizedResult == null) {
                    if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                        SapiJsInterpreters.this.sapiWebView.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                                    SapiJsInterpreters.this.jsCallBacks.authorizationListener.onFailed(-100, "登录失败");
                                }
                            }
                        });
                    }
                } else if (parseOpenApiAuthorizedResult.offlineNotice || parseOpenApiAuthorizedResult.bindGuide || parseOpenApiAuthorizedResult.errorCode == 21 || parseOpenApiAuthorizedResult.bindConflict) {
                    SapiJsInterpreters.this.jsCallBacks.rrLoginResponse = parseOpenApiAuthorizedResult;
                } else {
                    SapiJsInterpreters.this.sapiWebView.handleOpenApiAuthorizeResponse(parseOpenApiAuthorizedResult);
                }
            }
            if (parseInt == 0) {
                final SapiAccountResponse parseAuthorizedResult = SapiJsInterpreters.this.sapiWebView.parseAuthorizedResult(str, SapiJsInterpreters.this.context);
                if (parseAuthorizedResult == null) {
                    if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                        SapiJsInterpreters.this.sapiWebView.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                                    SapiJsInterpreters.this.jsCallBacks.authorizationListener.onFailed(-100, "登录失败");
                                }
                            }
                        });
                    }
                } else {
                    int i2 = parseAuthorizedResult.errorCode;
                    if (i2 == 0 || i2 == 110000) {
                        SapiJsInterpreters.this.sapiWebView.handleAuthorizeResponse(parseAuthorizedResult);
                        if (SapiWebView.SWITCH_ACCOUNT_PAGE.equals(str2)) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("errno", 0);
                            } catch (JSONException e2) {
                                Log.e(e2);
                            }
                            return jSONObject.toString();
                        }
                    } else if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                        SapiJsInterpreters.this.sapiWebView.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                                    AuthorizationListener authorizationListener = SapiJsInterpreters.this.jsCallBacks.authorizationListener;
                                    SapiAccountResponse sapiAccountResponse = parseAuthorizedResult;
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
            SapiJsInterpreters.this.sapiWebView.back();
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
            List<FastLoginFeature> fastLoginFeatureList = SapiJsInterpreters.this.jsCallBacks.localConfigCallback != null ? SapiJsInterpreters.this.jsCallBacks.localConfigCallback.getFastLoginFeatureList() : null;
            if (fastLoginFeatureList == null) {
                fastLoginFeatureList = SapiJsInterpreters.this.configuration.fastLoginFeatureList;
            }
            if (fastLoginFeatureList == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance().isHostsHijacked()) {
                return sb.toString();
            }
            for (int i2 = 0; i2 < fastLoginFeatureList.size(); i2++) {
                FastLoginFeature fastLoginFeature = fastLoginFeatureList.get(i2);
                if (i2 == 0) {
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
            return SapiJsInterpreters.this.configuration.loginShareStrategy().getStrValue();
        }
    }

    /* loaded from: classes2.dex */
    public class CurrentAccountBdussExpired extends AbstractInterpreter {
        public CurrentAccountBdussExpired() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.currentAccountBdussExpiredCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.currentAccountBdussExpiredCallback.onBdussExpired();
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
            if (SapiJsInterpreters.this.jsCallBacks.getCurrentPageNameCallback != null) {
                try {
                    SapiJsInterpreters.this.jsCallBacks.getCurrentPageNameCallback.getCurrentPageName(new JSONObject(command.getActionParams().get(0)).optString("name"));
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
            SapiJsInterpreters.this.sapiWebView.handleOpenApiAuthorizeResponse(SapiJsInterpreters.this.jsCallBacks.rrLoginResponse);
            if (command.getActionParams().size() > 0) {
                try {
                    SapiJsInterpreters.this.sapiWebView.finish(new JSONObject(command.getActionParams().get(0)).optString("page"));
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            } else {
                SapiJsInterpreters.this.sapiWebView.finish();
            }
            if (SapiJsInterpreters.this.jsCallBacks.webviewPageFinishCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.webviewPageFinishCallback.onFinish(command.getActionParams().size() > 0 ? command.getActionParams().get(0) : "");
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
            if (SapiJsInterpreters.this.jsCallBacks.focusEdittextCoordinateYCallBack != null) {
                try {
                    SapiJsInterpreters.this.jsCallBacks.focusEdittextCoordinateYCallBack.onCallback(new JSONObject(command.getActionParams().get(0)).optInt("coordinateY"));
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
            Log.d(ShareUtils.TAG, "GetAllClientAccounts ----- start --------");
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
                boolean z = FingerprintUtil.getFingerPrintState(SapiJsInterpreters.this.configuration) == 0;
                for (SapiAccount sapiAccount : touchidAccounts) {
                    JSONObject jSONObject2 = sapiAccount.toJSONObject();
                    if (!TextUtils.isEmpty(sapiAccount.phone) && sapiAccount.phone.contains("http://")) {
                        sapiAccount.phone = sapiAccount.phone.replace("http://", "https://");
                    }
                    jSONObject2.put("portrait", sapiAccount.phone);
                    String str = "1";
                    if (!z) {
                        jSONObject2.put("touchCode", "1");
                    } else {
                        if (!TextUtils.isEmpty(sapiAccount.email)) {
                            str = "0";
                        }
                        jSONObject2.put("touchCode", str);
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
                Log.d(ShareUtils.TAG, "GetAllClientAccounts ----- share start --------");
                List<ShareStorage.StorageModel> shareStorageModel = ShareUtils.getShareStorageModel();
                JSONArray jSONArray2 = ShareStorage.StorageModel.toJSONArray(shareStorageModel);
                if (jSONArray2 != null && jSONArray2.length() != 0) {
                    jSONObject.put("from", ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
                    jSONObject.put("canshare2Accounts", jSONArray2);
                    Log.d(ShareUtils.TAG, "shareV2 value=" + jSONObject.toString());
                    SapiStatUtil.statShareV2Open(shareStorageModel, null, SapiJsInterpreters.this.sapiWebView.extras);
                } else if (sapiContext.getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_SHARE_V3).meetGray) {
                    String[] split = sapiContext.getBaiduAppPkgList().split(",");
                    String[] deletedShareModels = ShareUtils.getDeletedShareModels();
                    JSONArray jSONArray3 = new JSONArray();
                    JSONArray jSONArray4 = new JSONArray();
                    if (split != null && split.length > 0) {
                        for (String str2 : split) {
                            jSONArray3.put(str2);
                        }
                    }
                    if (deletedShareModels != null && deletedShareModels.length > 0) {
                        for (String str3 : deletedShareModels) {
                            jSONArray4.put(str3);
                        }
                    }
                    jSONObject.put("from", ShareUtils.SHARE_ACCOUNT_CLOUND_VERSION);
                    jSONObject.put("appList", jSONArray3);
                    jSONObject.put("deleteAccounts", jSONArray4);
                    jSONObject.put("currentAppPkg", SapiJsInterpreters.this.configuration.context.getPackageName());
                    Log.d(ShareUtils.TAG, "shareV3 value=" + jSONObject.toString());
                } else {
                    Log.d(ShareUtils.TAG, "not support shareV3");
                }
            } catch (Exception e6) {
                Log.e(e6);
            }
            try {
                jSONObject.put("recentLoginUid", sapiContext.getDecryptStr(SapiContext.KEY_LAST_LOGIN_UID));
                if (SapiJsInterpreters.this.sapiWebView != null && SapiJsInterpreters.this.sapiWebView.mExcludeTypes != null) {
                    jSONObject.put("excludeTypes", SapiJsInterpreters.this.sapiWebView.mExcludeTypes.getName());
                }
            } catch (JSONException e7) {
                Log.e(e7);
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
            if (SapiJsInterpreters.this.configuration.forbidPresetPhoneNumber) {
                return "";
            }
            if (SapiUtils.isValidPhoneNumber(SapiJsInterpreters.this.configuration.presetPhoneNumber)) {
                return SapiJsInterpreters.this.configuration.presetPhoneNumber;
            }
            String localPhoneNumber = SapiJsInterpreters.this.sapiWebView.getLocalPhoneNumber();
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
                if (SapiJsInterpreters.this.jsCallBacks.grantWebCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.grantWebCallback.onGrant(optInt);
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
            if (SapiJsInterpreters.this.jsCallBacks.invoiceBuildCallback != null && command.getActionParams().size() > 0) {
                SapiJsInterpreters.this.jsCallBacks.invoiceBuildCallback.onCallback(command.getActionParams().get(0));
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
                    if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                        SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(optInt, optString);
                    }
                } else {
                    boolean z = jSONObject.optInt("merge") == 1;
                    String optString2 = jSONObject.optString("normalizeWay");
                    SapiAccountResponse parseAuthorizedResult = SapiJsInterpreters.this.sapiWebView.parseAuthorizedResult(jSONObject.optString("xml"), SapiJsInterpreters.this.context);
                    if (parseAuthorizedResult == null) {
                        if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                            SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(NormalizeGuestAccountResult.ERROR_CODE_PARSE_XML, NormalizeGuestAccountResult.ERROR_MSG_PARSE_XML);
                        }
                    } else {
                        SapiAccount sapiAccountResponseToAccount = SapiJsInterpreters.this.sapiWebView.sapiAccountResponseToAccount(parseAuthorizedResult);
                        if (!SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
                            SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(-202, "网络连接失败，请检查网络设置");
                            return null;
                        }
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        if (currentAccount != null) {
                            sapiAccountResponseToAccount.addSocialInfo(currentAccount.getSocialType(), currentAccount.getSocialPortrait());
                        }
                        SapiAccountManager.getInstance().removeLoginAccount(currentAccount);
                        SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                        if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                            SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onSuccess(z, optString2);
                        }
                    }
                }
            } catch (JSONException e2) {
                Log.e(e2);
                if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(-202, "网络连接失败，请检查网络设置");
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
                if (!TextUtils.isEmpty(SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountDesc)) {
                    jSONObject.put("description", new JSONObject(SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountDesc));
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
            if (SapiJsInterpreters.this.jsCallBacks.bdOauthLoginParams != null) {
                SapiJsInterpreters.this.jsCallBacks.bdOauthLoginParams.callback.onCallback(command.getActionParams().get(0));
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
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(ssoHashResult.ssoHash);
                }
            }, SapiJsInterpreters.this.jsCallBacks.bdOauthLoginParams.callingPkg, SapiJsInterpreters.this.jsCallBacks.bdOauthLoginParams.callingAppId);
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
            if (SapiJsInterpreters.this.jsCallBacks.realnameAuthenticateCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.realnameAuthenticateCallback.onSuccess();
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
            if (SapiJsInterpreters.this.configuration.fastLoginFeatureList == null || SapiJsInterpreters.this.configuration.fastLoginFeatureList.isEmpty()) {
                return null;
            }
            arrayList.addAll(SapiJsInterpreters.this.configuration.fastLoginFeatureList);
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
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                FastLoginFeature fastLoginFeature = (FastLoginFeature) arrayList.get(i2);
                if (i2 == 0) {
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
            if (SapiJsInterpreters.this.jsCallBacks.accountDestoryCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.accountDestoryCallback.onAccountDestory(new SapiWebView.AccountDestoryCallback.AccountDestoryResult());
            }
            SapiJsInterpreters.this.sapiWebView.finish();
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
            if (SapiJsInterpreters.this.jsCallBacks.accountFreezeCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.accountFreezeCallback.onAccountFreeze(new SapiWebView.AccountFreezeCallback.AccountFreezeResult());
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
            if (SapiJsInterpreters.this.jsCallBacks.bdussChangeCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.bdussChangeCallback.onBdussChange();
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
            new PtokenStat().onEvent(PtokenStat.SAPI_ACTION_BDUSS_CHANGED);
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
                if (SapiJsInterpreters.this.jsCallBacks.loginStatusChangeCallback != null) {
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

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
            if (r4.this$0.configuration.supportFaceLogin != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
            if (r4.this$0.jsCallBacks.invokeScAppCallback != null) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x007a, code lost:
            if (r4.this$0.configuration.supportFaceLogin != false) goto L11;
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
                Class.forName(SapiJsInterpreters.this.interpreterNameToClassFullName(str));
                z = true;
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (str.equals("sapi_biometrics_identification_with_uid")) {
                if (SapiJsInterpreters.this.jsCallBacks.bioScanFaceCallback != null) {
                }
                z = z2;
            } else if (str.equals("sapi_biometrics_identification") || str.equals("sapi_biometrics_identification_no_bduss") || str.equals("sapi_biometrics_identification_with_authtoken")) {
                if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback != null) {
                }
                z = z2;
            } else if (str.equals("sapi_action_sc_app_check")) {
            }
            return z ? "1" : "0";
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionChinaMobileOauth extends AbstractInterpreter {
        public SapiActionChinaMobileOauth() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            new OneKeyLoginSdkCall().getToken(SapiJsInterpreters.this.configuration, new OneKeyLoginSdkCall.TokenListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionChinaMobileOauth.1
                @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                public void onGetTokenComplete(JSONObject jSONObject) {
                    Log.d(OneKeyLoginSdkCall.TAG, "SapiActionChinaMobileOauth onGetTokenComplete result=" + jSONObject);
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
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
            if (SapiJsInterpreters.this.jsCallBacks.coverWebBdussCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.coverWebBdussCallback.onCoverBduss(cookieBduss, new SapiWebView.CoverWebBdussResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionCoverWebBduss.1
                    @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussResult
                    public void setWebBduss(String str) {
                        SapiJsInterpreters.this.sapiWebView.webLogin(SapiJsInterpreters.this.context, str);
                        SapiJsInterpreters.this.sapiWebView.reload();
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
                if (SapiJsInterpreters.this.jsCallBacks.prefillUserNameCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.prefillUserNameCallback.onPreFillUserName(preFillUserNameResult);
                }
                if (equals) {
                    SapiJsInterpreters.this.sapiWebView.finish();
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
                jSONObject.put("encryptedId", SapiJsInterpreters.this.jsCallBacks.directedLoginParams.encryptedId);
                jSONObject.put("displayname", SapiJsInterpreters.this.jsCallBacks.directedLoginParams.displayname);
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
            return SapiJsInterpreters.this.configuration.getTpl();
        }
    }

    /* loaded from: classes2.dex */
    public class SapiActionGetNaUiConfig extends AbstractInterpreter {
        public String TAG;

        public SapiActionGetNaUiConfig() {
            super();
            this.TAG = "sapi_action_get_na_ui_config";
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", "0");
                if (SapiJsInterpreters.this.configuration != null) {
                    jSONObject.put("textZoom", SapiJsInterpreters.this.configuration.textZoom);
                } else {
                    jSONObject.put("textZoom", 100);
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                Log.e(this.TAG, "get na ui config error");
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
            SapiJsInterpreters.this.jsCallBacks.leftBtnIsVisible = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.jsCallBacks.leftBtnVisibleCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.leftBtnVisibleCallback.onLeftBtnVisible(SapiJsInterpreters.this.jsCallBacks.leftBtnIsVisible);
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
                jSONObject.put("hideTip", SapiJsInterpreters.this.jsCallBacks.hideSuccessTip ? "1" : "0");
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
            if (SapiJsInterpreters.this.jsCallBacks.loginStatusChangeCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.loginStatusChangeCallback.onChange();
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
                for (int i2 = 0; i2 < length; i2++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i2))) {
                        arrayList.add(optJSONArray.optString(i2));
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
                ((ClipboardManager) SapiJsInterpreters.this.context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("address", new JSONObject(command.getActionParams().get(0)).optString("content")));
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
            int i2 = calendar.get(1);
            int i3 = calendar.get(2);
            int i4 = calendar.get(5);
            calendar.setTime(time);
            int i5 = calendar.get(1);
            int i6 = calendar.get(2);
            int i7 = calendar.get(5);
            DatePickerDialog datePickerDialog = new DatePickerDialog(SapiJsInterpreters.this.context, 3, new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.1
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public void onDateSet(DatePicker datePicker, int i8, int i9, int i10) {
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(i8 + String.format("%02d", Integer.valueOf(i9 + 1)) + String.format("%02d", Integer.valueOf(i10)) + "");
                }
            }, i2, i3, i4);
            datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm("");
                }
            });
            datePickerDialog.setTitle("");
            calendar.set(i5, i6, i7, 23, 59, 59);
            datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
            calendar.set(i5 - 100, i6, i7, 0, 0, 0);
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
            int i2 = 0;
            try {
                i2 = Integer.parseInt(command.getActionParams().get(0));
            } catch (Exception e2) {
                Log.e(e2);
            }
            int i3 = 512;
            int i4 = 1;
            if (command.getActionParams().size() > 1) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                    i4 = jSONObject.optInt("sence", 1);
                    i3 = jSONObject.optInt("size", 512);
                } catch (JSONException e3) {
                    Log.e(e3);
                }
            }
            SapiJsInterpreters.this.jsCallBacks.pickPhotoCallback.onPickImage(i2, i4, i3, new SapiWebView.PickPhotoResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickImage.1
                @Override // com.baidu.sapi2.SapiWebView.PickPhotoResult
                public void setImageData(String str) {
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
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
                if (SapiJsInterpreters.this.jsCallBacks.qrLoginCallback != null) {
                    int optInt = jSONObject.optInt("relogin", -1);
                    if (optInt == 1) {
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        String optString = jSONObject.optString("bduss");
                        String optString2 = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PTOKEN);
                        if (currentAccount != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            currentAccount.bduss = optString;
                            currentAccount.ptoken = optString2;
                            currentAccount.deleteStokens();
                            SapiAccountManager.getInstance().validate(currentAccount);
                        }
                    }
                    SapiJsInterpreters.this.jsCallBacks.qrLoginCallback.loginStatusChange(optInt == 1);
                }
                if (SapiJsInterpreters.this.jsCallBacks.finishPage) {
                    SapiJsInterpreters.this.sapiWebView.finish();
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
                if (SapiJsInterpreters.this.jsCallBacks.realNameStatusCallback != null) {
                    if (optInt == 1) {
                        accountRealNameResult.juniorRealNameSuc = true;
                    } else if (optInt == 2) {
                        accountRealNameResult.seniorRealNameSuc = true;
                    }
                    SapiJsInterpreters.this.jsCallBacks.realNameStatusCallback.onFinish(accountRealNameResult);
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
                jSONObject2.put("state", new SapiScheme().getInvokeScState(SapiJsInterpreters.this.context, optString, SapiJsInterpreters.this.jsCallBacks.invokeScAppCallback));
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
                SapiJsInterpreters.this.jsCallBacks.invokeScAppCallback.onInvokeScApp(optString, optString2, arrayList, new SapiWebView.InvokeScAppCallback.InvokeScAppResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionScAppInvoke.1
                    @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback.InvokeScAppResult
                    public void setInvokeResult(String str) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
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
            if (SapiJsInterpreters.this.jsCallBacks.switchAccountCallback != null) {
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
                            SapiJsInterpreters.this.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
                            return null;
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                    } else {
                        result.userName = actionParams.get(0);
                        result.switchAccountType = 1;
                        SapiJsInterpreters.this.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
                        return null;
                    }
                }
                result.switchAccountType = 0;
                SapiJsInterpreters.this.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
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
                if (ThirdPartyUtil.isWeixinAvilible(SapiJsInterpreters.this.context)) {
                    jSONArray.put(ThirdPartyUtil.TYPE_WEIXIN);
                }
                if (ThirdPartyUtil.isQQClientAvailable(SapiJsInterpreters.this.context)) {
                    jSONArray.put("qzone");
                }
                if (ThirdPartyUtil.isSinaInstalled(SapiJsInterpreters.this.context)) {
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
            if (SapiJsInterpreters.this.jsCallBacks.socialVerificationHandler == null) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                return null;
            }
            try {
                SapiJsInterpreters.this.jsCallBacks.socialVerificationHandler.sendMessage(ThirdPartyUtil.getVerificationMsg(new JSONObject(command.getActionParams().get(0)).optString("type")));
                return null;
            } catch (JSONException e2) {
                e2.printStackTrace();
                if (SapiJsInterpreters.this.jsCallBacks == null || SapiJsInterpreters.this.jsCallBacks.promptResult == null) {
                    return null;
                }
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
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
            if (SapiJsInterpreters.this.jsCallBacks.pageStateCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.pageStateCallback.pageState(parseInt);
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
            SapiUtils.sendSms(SapiJsInterpreters.this.context, command.getActionParams().get(1), arrayList);
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
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
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
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(biometricsIdentifyResult);
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
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentificationLiveCallBack == null) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                return null;
            }
            try {
                SapiJsInterpreters.this.jsCallBacks.biometricsIdentificationLiveCallBack.getLiveImage((int) (Float.parseFloat(new JSONObject(command.getActionParams().get(0)).optString("scale")) * 100.0f), new PassFaceRecogCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationLive.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
                    public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", 0);
                            jSONObject.put("businessno", passFaceRecogResult.getResultCode());
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
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
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        } catch (JSONException e2) {
                            Log.e(SapiJsInterpreters.TAG, e2.getMessage());
                            SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                        }
                    }
                });
                return null;
            } catch (JSONException e2) {
                Log.e(SapiJsInterpreters.TAG, e2.getMessage());
                if (SapiJsInterpreters.this.jsCallBacks == null || SapiJsInterpreters.this.jsCallBacks.promptResult == null) {
                    return null;
                }
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
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
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
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
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(biometricsIdentifyResult);
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
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
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
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(biometricsIdentifyResult);
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
            if (SapiJsInterpreters.this.jsCallBacks.bioScanFaceCallback == null) {
                return null;
            }
            SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult = new SapiWebView.BioScanFaceCallback.BioScanFaceResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationWithUid.1
                @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback.BioScanFaceResult
                public void setScanFaceIdentifyResult(String str) {
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
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
                SapiJsInterpreters.this.jsCallBacks.bioScanFaceCallback.onBioScanFace(bioScanFaceResult);
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
            if (SapiJsInterpreters.this.sapiWebView.canGoBack()) {
                SapiJsInterpreters.this.sapiWebView.goBack();
                return null;
            }
            SapiJsInterpreters.this.sapiWebView.finish();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class SapiIdcardOcrImage extends AbstractInterpreter {
        public SapiIdcardOcrImage() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.idcardOcrImageCallBack == null) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                SapiJsInterpreters.this.jsCallBacks.idcardOcrImageCallBack.getIdcardImage(jSONObject.optString("way"), jSONObject.optString("type"), new IdcardOcrImageCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiIdcardOcrImage.1
                    @Override // com.baidu.sapi2.callback.IdcardOcrImageCallback
                    public void onFailure(IdcardOcrImageRusult idcardOcrImageRusult) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("errno", idcardOcrImageRusult.getResultCode());
                            jSONObject2.put("errmsg", idcardOcrImageRusult.getResultMsg());
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                        }
                    }

                    @Override // com.baidu.sapi2.callback.IdcardOcrImageCallback
                    public void onSuccess(IdcardOcrImageRusult idcardOcrImageRusult) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("errno", idcardOcrImageRusult.getResultCode());
                            jSONObject2.put("errmsg", idcardOcrImageRusult.getResultMsg());
                            jSONObject2.put("type", idcardOcrImageRusult.type);
                            jSONObject2.put("image", idcardOcrImageRusult.image);
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                        }
                    }
                });
                return null;
            } catch (JSONException e2) {
                Log.e(SapiJsInterpreters.TAG, e2.getMessage());
                if (SapiJsInterpreters.this.jsCallBacks == null || SapiJsInterpreters.this.jsCallBacks.promptResult == null) {
                    return null;
                }
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SapiOnekeyOauthToken extends AbstractInterpreter {
        public SapiOnekeyOauthToken() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            new OneKeyLoginSdkCall().getMobileOauthToken(SapiJsInterpreters.this.configuration, new OneKeyLoginSdkCall.TokenListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiOnekeyOauthToken.1
                @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                public void onGetTokenComplete(JSONObject jSONObject) {
                    Log.d(OneKeyLoginSdkCall.TAG, "SapiOnekeyOauthToken onGetTokenComplete result=" + jSONObject.toString());
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
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
                JSONArray optJSONArray = jSONObject2.optJSONArray(FaceLoginService.KEY_FACE_LOGIN_LIVINGUNAMES);
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
                    ShareUtils.markAsDeleteShareLogin(str);
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
            if (System.currentTimeMillis() - SapiJsInterpreters.this.preShareClickTime > 1000) {
                SapiJsInterpreters.this.preShareClickTime = System.currentTimeMillis();
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    String optString2 = jSONObject.optString("pkg");
                    String optString3 = jSONObject.optString("from", ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
                    if (ShareUtils.SHARE_ACCOUNT_CLOUND_VERSION.equals(optString3)) {
                        optString = jSONObject.optString("portrait");
                    } else {
                        optString = jSONObject.optString("url");
                    }
                    String optString4 = jSONObject.optString("trace_id");
                    String optString5 = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID);
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm("finish");
                    SapiJsInterpreters.this.jsCallBacks.shareAccountClickCallback.onClick(optString2, optString, optString4, optString5, optString3);
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
            SapiJsInterpreters.this.jsCallBacks.speechRecognitionCallback.onSpeechRecognition(new SapiJsCallBacks.SpeechRecognitionResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SpeechRecognitionGetContent.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionResult
                public void setSpeechData(int i2, String str) {
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", i2);
                            jSONObject.put("text", str);
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
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
            if (SapiJsInterpreters.this.configuration.supportMultipleAccounts) {
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
                jSONObject.put("showSwitchAccount", SapiJsInterpreters.this.sapiWebView.showSwitchAccount ? 1 : 0);
                jSONObject.put("showLinkAccount", SapiJsInterpreters.this.sapiWebView.showLinkAccount ? 1 : 0);
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
            if (SapiJsInterpreters.this.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack != null) {
                try {
                    SapiJsInterpreters.this.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack.switchStyle(new JSONObject(command.getActionParams().get(0)).optString("styleType"));
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

        /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
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
                    public void setResult(int i2) {
                        try {
                            jSONObject.put("status", i2);
                            if (i2 == 0) {
                                SapiContext.getInstance().addTouchidAccounts(currentAccount2);
                            }
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        } catch (Exception e5) {
                            Log.e(e5);
                        }
                    }
                };
                if (SapiJsInterpreters.this.jsCallBacks.fingerprintCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.fingerprintCallback.onCallback(fingerprintResult);
                }
                return null;
            }
            currentAccount2.email = "";
            SapiContext.getInstance().addTouchidAccounts(currentAccount2);
            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
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
                int fingerPrintState = FingerprintUtil.getFingerPrintState(SapiJsInterpreters.this.configuration);
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
                int i2 = (fingerPrintState != 0 || TextUtils.isEmpty(optString) || contains) ? 0 : 1;
                if (!SapiJsInterpreters.this.sapiWebView.supportTouchGuide) {
                    i2 = 0;
                }
                if (z) {
                    i2 = 0;
                }
                jSONObject.put("errno", 0);
                jSONObject.put(AuthoritySharedPreferences.KEY_CONFIG_FIRSTSHOT_GUIDE, i2);
                if (TextUtils.isEmpty(optString)) {
                    str = "100";
                } else if (fingerPrintState == 101 || fingerPrintState == 102) {
                    str = fingerPrintState + "";
                } else if (contains) {
                    str = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
                } else if (!SapiJsInterpreters.this.sapiWebView.supportTouchGuide) {
                    str = TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT;
                } else if (z) {
                    str = TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP;
                } else {
                    str = fingerPrintState + "";
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                linkedHashMap.put("native_guide_finger", str);
                StatService.onEventAutoStatistic(linkedHashMap);
                if (i2 == 1) {
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
                int i2 = 1;
                if (FingerprintUtil.getFingerPrintState(SapiJsInterpreters.this.configuration) == 0) {
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
                        i2 = 2;
                    }
                } else {
                    i2 = 0;
                }
                jSONObject.put("errno", 0);
                jSONObject.put("status", i2);
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
                public void setResult(int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("status", i2);
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
            };
            fingerprintResult.authType = 3;
            if (SapiJsInterpreters.this.jsCallBacks.fingerprintCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.fingerprintCallback.onCallback(fingerprintResult);
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
                public void setResult(int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("status", i2);
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        if (i2 == 0) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(command.getActionParams().get(0));
                                String optString = jSONObject2.optString("portrait");
                                String optString2 = jSONObject2.optString("portraitSign");
                                if (TextUtils.isEmpty(optString)) {
                                    String[] strArr = SapiJsInterpreters.this.jsCallBacks.touchidPortraitAndSign;
                                    strArr[0] = SapiJsInterpreters.this.configuration.environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
                                    String[] strArr2 = SapiJsInterpreters.this.sapiWebView.touchidPortraitAndSign;
                                    strArr2[0] = SapiJsInterpreters.this.configuration.environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
                                } else {
                                    SapiJsInterpreters.this.jsCallBacks.touchidPortraitAndSign[0] = optString;
                                    SapiJsInterpreters.this.sapiWebView.touchidPortraitAndSign[0] = optString;
                                }
                                SapiJsInterpreters.this.jsCallBacks.touchidPortraitAndSign[1] = optString2;
                                SapiJsInterpreters.this.sapiWebView.touchidPortraitAndSign[1] = optString2;
                            } catch (Exception e2) {
                                Log.e(e2);
                            }
                        }
                    } catch (Exception e3) {
                        Log.e(e3);
                    }
                }
            };
            if (SapiJsInterpreters.this.jsCallBacks.fingerprintCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.fingerprintCallback.onCallback(fingerprintResult);
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
                sapiAccount.ptoken = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PTOKEN);
                sapiAccount.stoken = jSONObject.optString("stoken");
                if (TextUtils.isEmpty(optString) || !SapiAccount.isValidAccount(sapiAccount) || SapiJsInterpreters.this.jsCallBacks.uniteVerifyCallback == null) {
                    return null;
                }
                SapiJsInterpreters.this.jsCallBacks.uniteVerifyCallback.onSuccess(optString, optString2, sapiAccount);
                return null;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    public SapiJsInterpreters(SapiWebView sapiWebView, SapiJsCallBacks.CallBacks callBacks) {
        this.sapiWebView = sapiWebView;
        this.context = sapiWebView.getContext();
        this.jsCallBacks = callBacks;
    }

    private AbstractInterpreter buidInterpreterByName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (AbstractInterpreter) Class.forName(interpreterNameToClassFullName(str)).getDeclaredConstructor(getClass()).newInstance(this);
        } catch (Exception e2) {
            Log.e(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String interpreterNameToClassFullName(String str) {
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

    public AbstractInterpreter getInterpreter(String str) {
        AbstractInterpreter abstractInterpreter = this.interpreterHashMap.get(str);
        if (abstractInterpreter == null && (abstractInterpreter = buidInterpreterByName(str)) != null) {
            this.interpreterHashMap.put(str, abstractInterpreter);
        }
        return abstractInterpreter;
    }
}
