package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.widget.DatePicker;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.IdcardOcrImageCallback;
import com.baidu.sapi2.callback.LoadDuVipPayCallBack;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.loginhistory.LoginHistoryItem;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.CertGuardianResult;
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
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.stat.TouchidLoginStat;
import com.baidu.sapi2.touchid.FingerprintUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.Security;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.SyncAccountUtils;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.logindialog.view.a;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.ugc.transcoder.interfaces.UgcTranscoderConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
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
/* loaded from: classes3.dex */
public class SapiJsInterpreters {
    public static final String TAG = "SapiJsInterpreters";
    public Context context;
    public SapiJsCallBacks.CallBacks jsCallBacks;
    public long preShareClickTime;
    public SapiWebView sapiWebView;
    public HashMap<String, AbstractInterpreter> interpreterHashMap = new HashMap<>();
    public SapiConfiguration configuration = SapiAccountManager.getInstance().getSapiConfiguration();

    /* loaded from: classes3.dex */
    public abstract class AbstractInterpreter {
        public abstract String interpret(SapiWebView.Command command);

        public AbstractInterpreter() {
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class ActionFaceLoginSwitch extends AbstractInterpreter {
        public ActionFaceLoginSwitch() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString("livinguname");
                if (!TextUtils.isEmpty(optString)) {
                    new FaceLoginService().syncFaceLoginUID(SapiJsInterpreters.this.context, optString);
                    return null;
                }
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class ActionForgetPwd extends AbstractInterpreter {
        public ActionForgetPwd() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            boolean z;
            if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                z = SapiJsInterpreters.this.jsCallBacks.authorizationListener.onForgetPwd();
            } else {
                z = false;
            }
            if (z) {
                return "1";
            }
            return "0";
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return SapiUtils.calculateSig(hashMap, SapiJsInterpreters.this.configuration.appSignKey);
        }
    }

    /* loaded from: classes3.dex */
    public class ActionGetLoadtime extends AbstractInterpreter {
        public ActionGetLoadtime() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView unused = SapiJsInterpreters.this.sapiWebView;
            if (SapiWebView.statLoadLogin == null) {
                return null;
            }
            SapiWebView unused2 = SapiJsInterpreters.this.sapiWebView;
            return SapiWebView.statLoadLogin.toJSON().toString();
        }
    }

    /* loaded from: classes3.dex */
    public class ActionGetSmsCheckCodeFromClip extends AbstractInterpreter {
        public ActionGetSmsCheckCodeFromClip() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        @TargetApi(11)
        public String interpret(SapiWebView.Command command) {
            String str;
            String str2 = "";
            try {
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.context.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                if (clipboardManager.hasPrimaryClip()) {
                    str2 = SapiUtils.getSmsCheckCode(clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
            if (TextUtils.isEmpty(str2)) {
                str = "0";
            } else {
                str = "1";
            }
            SapiStatUtil.statSmsCodeClip(SapiJsInterpreters.this.context, str);
            return str2;
        }
    }

    /* loaded from: classes3.dex */
    public class ActionGloryLogin extends AbstractInterpreter {
        public ActionGloryLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HONOR;
                Message message = new Message();
                message.what = SocialType.HONOR.getType();
                message.obj = SocialType.HONOR;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class ActionHuaweiLogin extends AbstractInterpreter {
        public ActionHuaweiLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HUAWEI;
                Message message = new Message();
                message.what = SocialType.HUAWEI.getType();
                message.obj = SocialType.HUAWEI;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
                if (SapiJsInterpreters.this.jsCallBacks.shareAccountClickCallback != null && shareStorageModel.size() > 0) {
                    jSONObject.put("openShareLogin", YYOption.IsLive.VALUE_TRUE);
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
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                } catch (JSONException e) {
                    Log.e(e);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class ActionRemoveShareAccount extends AbstractInterpreter {
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return null;
        }

        public ActionRemoveShareAccount() {
            super();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class ActionShareV2Login extends AbstractInterpreter {
        public ActionShareV2Login() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.jsCallBacks.shareV2LoginParams.pageParams.toString();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class ActionSocialMeizuSso extends AbstractInterpreter {
        public ActionSocialMeizuSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.MEIZU;
                Message message = new Message();
                message.what = SocialType.MEIZU.getType();
                message.obj = SocialType.MEIZU;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class ActionSocialQqSso extends AbstractInterpreter {
        public ActionSocialQqSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.QQ;
                Message message = new Message();
                message.what = SocialType.QQ_SSO.getType();
                message.obj = SocialType.QQ_SSO;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class ActionSocialSinaSso extends AbstractInterpreter {
        public ActionSocialSinaSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WEIBO;
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO_SSO.getType();
                message.obj = SocialType.SINA_WEIBO_SSO;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class ActionSocialSso extends AbstractInterpreter {
        public ActionSocialSso() {
            super();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
            if (r5.equals(com.baidu.sapi2.utils.enums.FastLoginFeature.SSOLoginType.WEIXIN) != false) goto L8;
         */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            SocialType socialType;
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                char c = 0;
                String str = command.getActionParams().get(0);
                switch (str.hashCode()) {
                    case -1519161818:
                        break;
                    case -1506464740:
                        if (str.equals(FastLoginFeature.SSOLoginType.MEIZU)) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case -952571024:
                        if (str.equals(FastLoginFeature.SSOLoginType.QQ)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -19158255:
                        if (str.equals(FastLoginFeature.SSOLoginType.HUAWEI)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3872:
                        if (str.equals("yy")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 110658813:
                        if (str.equals("tsina")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 738596251:
                        if (str.equals(FastLoginFeature.SSOLoginType.HONOR)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1288743885:
                        if (str.equals(FastLoginFeature.SSOLoginType.SINA_SSO)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1587088523:
                        if (str.equals(FastLoginFeature.SSOLoginType.XIAOMI)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WECHAT;
                        socialType = SocialType.WEIXIN;
                        break;
                    case 1:
                    case 2:
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WEIBO;
                        socialType = SocialType.SINA_WEIBO_SSO;
                        break;
                    case 3:
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.QQ;
                        socialType = SocialType.QQ_SSO;
                        break;
                    case 4:
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HUAWEI;
                        socialType = SocialType.HUAWEI;
                        break;
                    case 5:
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HONOR;
                        socialType = SocialType.HONOR;
                        break;
                    case 6:
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.XIAOMI;
                        socialType = SocialType.XIAOMI;
                        break;
                    case 7:
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.MEIZU;
                        socialType = SocialType.MEIZU;
                        break;
                    case '\b':
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.YY;
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

    /* loaded from: classes3.dex */
    public class ActionSocialWeixinSso extends AbstractInterpreter {
        public ActionSocialWeixinSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WECHAT;
                Message message = new Message();
                message.what = SocialType.WEIXIN.getType();
                message.obj = SocialType.WEIXIN;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
                } catch (Exception e) {
                    Log.e(e);
                }
                SapiJsInterpreters.this.jsCallBacks.stopSlideWebviewCallback.onStopSlide(z);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class ActionXiaoMiSso extends AbstractInterpreter {
        public ActionXiaoMiSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler != null) {
                SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.XIAOMI;
                Message message = new Message();
                message.what = SocialType.XIAOMI.getType();
                message.obj = SocialType.XIAOMI;
                SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class AddressManageGetPasteboard extends AbstractInterpreter {
        public AddressManageGetPasteboard() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.context.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                if (clipboardManager.hasPrimaryClip()) {
                    jSONObject.put(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_PASTE, clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class AuthorizedResponse extends AbstractInterpreter {
        public AuthorizedResponse() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int i;
            String str;
            String str2 = command.getActionParams().get(0);
            if (command.getActionParams().size() >= 2) {
                i = Integer.parseInt(command.getActionParams().get(1));
            } else {
                i = 0;
            }
            if (command.getActionParams().size() >= 3) {
                str = command.getActionParams().get(2);
            } else {
                str = null;
            }
            if (i == 1) {
                SocialResponse parseOpenApiAuthorizedResult = SapiWebView.parseOpenApiAuthorizedResult(str2, SapiJsInterpreters.this.context);
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
                } else if (!parseOpenApiAuthorizedResult.offlineNotice && !parseOpenApiAuthorizedResult.bindGuide && parseOpenApiAuthorizedResult.errorCode != 21 && !parseOpenApiAuthorizedResult.bindConflict) {
                    SapiJsInterpreters.this.sapiWebView.handleOpenApiAuthorizeResponse(parseOpenApiAuthorizedResult);
                } else {
                    SapiJsInterpreters.this.jsCallBacks.rrLoginResponse = parseOpenApiAuthorizedResult;
                }
            }
            if (i == 0) {
                final SapiAccountResponse parseAuthorizedResult = SapiJsInterpreters.this.sapiWebView.parseAuthorizedResult(str2, SapiJsInterpreters.this.context);
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
                    if (i2 != 0 && i2 != 110000) {
                        if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
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
                    } else {
                        SapiJsInterpreters.this.sapiWebView.handleAuthorizeResponse(parseAuthorizedResult);
                        if (SapiWebView.SWITCH_ACCOUNT_PAGE.equals(str)) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("errno", 0);
                            } catch (JSONException e) {
                                Log.e(e);
                            }
                            return jSONObject.toString();
                        }
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class ConfigFastloginFeatures extends AbstractInterpreter {
        public ConfigFastloginFeatures() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            List<FastLoginFeature> list;
            if (SapiJsInterpreters.this.jsCallBacks.localConfigCallback != null) {
                list = SapiJsInterpreters.this.jsCallBacks.localConfigCallback.getFastLoginFeatureList();
            } else {
                list = null;
            }
            if (list == null) {
                list = SapiJsInterpreters.this.configuration.fastLoginFeatureList;
            }
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance().isHostsHijacked()) {
                return sb.toString();
            }
            for (int i = 0; i < list.size(); i++) {
                FastLoginFeature fastLoginFeature = list.get(i);
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

    /* loaded from: classes3.dex */
    public class ConfigLoginShareStrategy extends AbstractInterpreter {
        public ConfigLoginShareStrategy() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.configuration.loginShareStrategy().getStrValue();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                } catch (Exception e) {
                    Log.e(e);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class Finish extends AbstractInterpreter {
        public Finish() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str;
            SapiJsInterpreters.this.sapiWebView.handleOpenApiAuthorizeResponse(SapiJsInterpreters.this.jsCallBacks.rrLoginResponse);
            if (command.getActionParams().size() > 0) {
                try {
                    SapiJsInterpreters.this.sapiWebView.finish(new JSONObject(command.getActionParams().get(0)).optString("page"));
                } catch (JSONException e) {
                    Log.e(e);
                }
            } else {
                SapiJsInterpreters.this.sapiWebView.finish();
            }
            if (SapiJsInterpreters.this.jsCallBacks.webviewPageFinishCallback != null) {
                if (command.getActionParams().size() > 0) {
                    str = command.getActionParams().get(0);
                } else {
                    str = "";
                }
                SapiJsInterpreters.this.jsCallBacks.webviewPageFinishCallback.onFinish(str);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
                } catch (Exception e) {
                    Log.e(e);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class GetAllClientAccounts extends AbstractInterpreter {
        public GetAllClientAccounts() {
            super();
        }

        private boolean isShareEnable() {
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration != null && sapiConfiguration.loginShareStrategy() == LoginShareStrategy.CHOICE) {
                String packageName = sapiConfiguration.context.getPackageName();
                if (TextUtils.isEmpty(packageName)) {
                    return false;
                }
                for (String str : SapiContext.getInstance().getAuthorizedPackages().keySet()) {
                    if (packageName.matches(str)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            boolean z;
            Log.d(ShareUtils.TAG, "GetAllClientAccounts ----- start --------");
            SapiContext sapiContext = SapiContext.getInstance();
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException e) {
                Log.e(e);
            }
            List<SapiAccount> touchidAccounts = sapiContext.getTouchidAccounts();
            try {
                JSONArray jSONArray = new JSONArray();
                if (FingerprintUtil.getFingerPrintState(SapiJsInterpreters.this.configuration) == 0) {
                    z = true;
                } else {
                    z = false;
                }
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
            } catch (Exception e2) {
                Log.e(e2);
            }
            try {
                jSONObject.put("onekeyAccounts", new OneKeyLoginSdkCall().getEncryptPhone());
            } catch (Exception e3) {
                Log.e(e3);
            }
            try {
                jSONObject.put("faceAccounts", sapiContext.getV2FaceLoginCheckResults());
            } catch (Exception e4) {
                Log.e(e4);
            }
            try {
                Object jSONArray2 = LoginHistoryItem.toJSONArray(LoginHistoryLoginModel.getAvailableLoginHistoryItems());
                if (jSONArray2 != null) {
                    jSONObject.put("history", jSONArray2);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                jSONObject.put("recentLoginUid", sapiContext.getDecryptStr(SapiContext.KEY_LAST_LOGIN_UID));
                if (SapiJsInterpreters.this.sapiWebView != null && SapiJsInterpreters.this.sapiWebView.mExcludeTypes != null) {
                    jSONObject.put("excludeTypes", SapiJsInterpreters.this.sapiWebView.mExcludeTypes.getName());
                }
            } catch (JSONException e6) {
                Log.e(e6);
            }
            try {
                if (isShareEnable()) {
                    Log.d(ShareUtils.TAG, "GetAllClientAccounts share login is enable");
                    ShareLoginStat.GetShareListStat.sValueSence = "in";
                    SapiAccountManager.getInstance().getShareModels(2000L, new ShareModelCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.GetAllClientAccounts.1
                        @Override // com.baidu.sapi2.callback.ShareModelCallback
                        public void onReceiveShareModels(List<ShareStorage.StorageModel> list) {
                            if (list == null || list.size() == 0) {
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            }
                            try {
                                JSONArray jSONArray3 = ShareStorage.StorageModel.toJSONArray(list);
                                jSONObject.put("from", ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
                                jSONObject.put("canshare2Accounts", jSONArray3);
                                Log.d(ShareUtils.TAG, "shareV2 value=" + jSONObject.toString());
                                SapiStatUtil.statShareV2Open(list, null, SapiJsInterpreters.this.sapiWebView.extras);
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            } catch (JSONException e7) {
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                                e7.printStackTrace();
                            }
                        }
                    });
                    return null;
                }
                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                Log.d(ShareUtils.TAG, "GetAllClientAccounts share login is disable");
                return null;
            } catch (Exception e7) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                Log.e(e7);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
                } catch (JSONException e) {
                    Log.e(e);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
            if (!SapiUtils.isValidPhoneNumber(localPhoneNumber)) {
                return "";
            }
            return localPhoneNumber;
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class NormalizeGuestAccount extends AbstractInterpreter {
        public NormalizeGuestAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                boolean z = false;
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                int optInt = jSONObject.optInt("errno");
                String optString = jSONObject.optString("msg");
                if (optInt == 0) {
                    if (jSONObject.optInt("merge") == 1) {
                        z = true;
                    }
                    String optString2 = jSONObject.optString("normalizeWay");
                    SapiAccountResponse parseAuthorizedResult = SapiJsInterpreters.this.sapiWebView.parseAuthorizedResult(jSONObject.optString("xml"), SapiJsInterpreters.this.context);
                    if (parseAuthorizedResult == null) {
                        if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                            SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(-601, NormalizeGuestAccountResult.ERROR_MSG_PARSE_XML);
                        }
                    } else {
                        SapiAccount sapiAccountResponseToAccount = SapiJsInterpreters.this.sapiWebView.sapiAccountResponseToAccount(parseAuthorizedResult);
                        if (!SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
                            SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(-202, "网络连接失败，请检查网络设置");
                            return null;
                        }
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        if (currentAccount != null) {
                            sapiAccountResponseToAccount.addSocialInfo(currentAccount.getSocialType(), currentAccount.getSocialPortrait(), currentAccount.getSocialNickname());
                        }
                        SapiAccountManager.getInstance().removeLoginAccount(currentAccount);
                        SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                        if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                            SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onSuccess(z, optString2);
                        }
                    }
                } else if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(optInt, optString);
                }
            } catch (JSONException e) {
                Log.e(e);
                if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(-202, "网络连接失败，请检查网络设置");
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class SapiActionCertGuardianResult extends AbstractInterpreter {
        public SapiActionCertGuardianResult() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                CertGuardianResult certGuardianResult = new CertGuardianResult();
                int optInt = jSONObject.optInt("errno");
                String optString = jSONObject.optString("errmsg");
                certGuardianResult.setResultCode(optInt);
                certGuardianResult.setResultMsg(optString);
                if (SapiJsInterpreters.this.jsCallBacks.certGuardianRusultCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.certGuardianRusultCallback.onFinish(certGuardianResult);
                    return null;
                }
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
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
            } else if (!str.equals("sapi_biometrics_identification") && !str.equals("sapi_biometrics_identification_no_bduss") && !str.equals("sapi_biometrics_identification_with_authtoken")) {
                if (str.equals("sapi_action_sc_app_check")) {
                }
            } else {
                if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback != null) {
                }
                z = z2;
            }
            if (z) {
                return "1";
            }
            return "0";
        }
    }

    /* loaded from: classes3.dex */
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
                    String operatorType = new OneKeyLoginSdkCall().getOperatorType();
                    if ("CM".equals(operatorType)) {
                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CM.getName());
                    } else if ("CU".equals(operatorType)) {
                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CU.getName());
                    } else if ("CT".equals(operatorType)) {
                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CT.getName());
                    }
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class SapiActionCurrentLoginType extends AbstractInterpreter {
        public SapiActionCurrentLoginType() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (command != null && command.getActionParams() != null && !command.getActionParams().isEmpty()) {
                String str = command.getActionParams().get(0);
                if (a.m.equals(str)) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.PWD;
                } else if (LoginConstants.SMS_LOGIN.equals(str)) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.SMS;
                } else if (UgcTranscoderConstant.URL_GET_FACE.equals(str)) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.FACE;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class SapiActionDeliverParams extends AbstractInterpreter {
        public SapiActionDeliverParams() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString("username");
                boolean equals = jSONObject.optString("close", "0").equals("1");
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
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class SapiActionGetAppTpl extends AbstractInterpreter {
        public SapiActionGetAppTpl() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.configuration.getTpl();
        }
    }

    /* loaded from: classes3.dex */
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
                    jSONObject.put("textZoom", SapiJsInterpreters.this.configuration.getTextZoom());
                    jSONObject.put("browseModeState", SapiJsInterpreters.this.configuration.browseModeState);
                } else {
                    jSONObject.put("textZoom", 100);
                    jSONObject.put("browseModeState", 1);
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                Log.e(this.TAG, "get na ui config error");
                return "";
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SapiActionGetSecurityZid extends AbstractInterpreter {
        public SapiActionGetSecurityZid() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                int optInt = new JSONObject(command.getActionParams().get(0)).optInt("eventId");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", "0");
                jSONObject.put("zid", Security.getZid(ServiceManager.getInstance().getIsAccountManager().getConfignation().context, optInt));
                return jSONObject.toString();
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class SapiActionHideSuccessTip extends AbstractInterpreter {
        public SapiActionHideSuccessTip() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str;
            JSONObject jSONObject = new JSONObject();
            try {
                if (SapiJsInterpreters.this.jsCallBacks.hideSuccessTip) {
                    str = "1";
                } else {
                    str = "0";
                }
                jSONObject.put("hideTip", str);
                jSONObject.put("errno", 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class SapiActionJumpToUri extends AbstractInterpreter {
        public SapiActionJumpToUri() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                return null;
            }
            if (SapiJsInterpreters.this.jsCallBacks.jumpToUriCallBack != null) {
                try {
                    SapiJsInterpreters.this.jsCallBacks.jumpToUriCallBack.onJumpTo(new JSONObject(command.getActionParams().get(0)).optString("url"));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errno", 0);
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    }
                }
            } else {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class SapiActionListenIsForbidRecord extends AbstractInterpreter {
        public SapiActionListenIsForbidRecord() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                return null;
            }
            try {
                String str = command.getActionParams().get(0);
                if (SapiJsInterpreters.this.jsCallBacks.isForbidRecordCallBack != null) {
                    SapiJsInterpreters.this.jsCallBacks.isForbidRecordCallBack.onForbidRecord(Boolean.valueOf("1".equals(str)));
                }
            } catch (Exception e) {
                Log.e(e);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class SapiActionMakeVibrate extends AbstractInterpreter {
        public SapiActionMakeVibrate() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.makeVibrateCallBack != null) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    JSONArray optJSONArray = jSONObject.optJSONArray("pattern");
                    int optInt = jSONObject.optInt("repeat", -1);
                    String optString = jSONObject.optString("broadcastText");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        long[] jArr = new long[optJSONArray.length()];
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            jArr[i] = optJSONArray.getLong(i);
                        }
                        SapiJsInterpreters.this.jsCallBacks.makeVibrateCallBack.vibrate(jArr, optInt, optString);
                        return null;
                    }
                    SapiJsInterpreters.this.jsCallBacks.makeVibrateCallBack.presetVibrate(optString);
                    return null;
                } catch (JSONException e) {
                    Log.e(SapiJsInterpreters.TAG, e.getMessage());
                    if (SapiJsInterpreters.this.jsCallBacks != null && SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                        return null;
                    }
                    return null;
                }
            }
            SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SapiActionOpenDuVip extends AbstractInterpreter {
        public SapiActionOpenDuVip() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_open_du_vip jsCallBacks is null");
                return "";
            }
            try {
                if (SapiJsInterpreters.this.jsCallBacks.mOpenDuVipPayCallback == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_open_du_vip jsCallBacks,mOpenDuVipPayCallback is null");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                } else if (SapiContext.getInstance() == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_open_du_vip SapiContext.getInstance() is null, please check pass sdk has init");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                } else {
                    SapiJsInterpreters.this.jsCallBacks.mOpenDuVipPayCallback.onOpenDuVipPay(new LoadDuVipPayCallBack() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionOpenDuVip.1
                        @Override // com.baidu.sapi2.callback.LoadDuVipPayCallBack
                        public void onFinish(String str) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("errno", "0");
                                jSONObject.put("msg", "");
                                jSONObject.put("data", str);
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                            }
                        }
                    });
                    return null;
                }
            } catch (Exception e) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                Log.e(e);
                return "";
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SapiActionPasteboardSet extends AbstractInterpreter {
        public SapiActionPasteboardSet() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                ((ClipboardManager) SapiJsInterpreters.this.context.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("address", new JSONObject(command.getActionParams().get(0)).optString("content")));
                jSONObject.put("errno", 0);
                return jSONObject.toString();
            } catch (Exception e) {
                Log.e(e);
                return jSONObject.toString();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (Exception e) {
                Log.e(e);
            }
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            int i3 = calendar.get(5);
            calendar.setTime(time);
            int i4 = calendar.get(1);
            int i5 = calendar.get(2);
            int i6 = calendar.get(5);
            DatePickerDialog datePickerDialog = new DatePickerDialog(SapiJsInterpreters.this.context, 3, new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.1
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public void onDateSet(DatePicker datePicker, int i7, int i8, int i9) {
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(i7 + String.format("%02d", Integer.valueOf(i8 + 1)) + String.format("%02d", Integer.valueOf(i9)) + "");
                }
            }, i, i2, i3);
            datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm("");
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

    /* loaded from: classes3.dex */
    public class SapiActionPickImage extends AbstractInterpreter {
        public SapiActionPickImage() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int i = 0;
            try {
                i = Integer.parseInt(command.getActionParams().get(0));
            } catch (Exception e) {
                Log.e(e);
            }
            int i2 = 512;
            int i3 = 1;
            if (command.getActionParams().size() > 1) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                    i3 = jSONObject.optInt("sence", 1);
                    i2 = jSONObject.optInt("size", 512);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            SapiJsInterpreters.this.jsCallBacks.pickPhotoCallback.onPickImage(i, i3, i2, new SapiWebView.PickPhotoResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickImage.1
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

    /* loaded from: classes3.dex */
    public class SapiActionQrLogin extends AbstractInterpreter {
        public SapiActionQrLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            boolean z = false;
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                if (SapiJsInterpreters.this.jsCallBacks.qrLoginCallback != null) {
                    int optInt = jSONObject.optInt("relogin", -1);
                    if (optInt == 1) {
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        String optString = jSONObject.optString("bduss");
                        String optString2 = jSONObject.optString("ptoken");
                        if (currentAccount != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            currentAccount.bduss = optString;
                            currentAccount.ptoken = optString2;
                            currentAccount.deleteStokens();
                            SapiAccountManager.getInstance().validate(currentAccount);
                        }
                    }
                    SapiWebView.QrLoginCallback qrLoginCallback = SapiJsInterpreters.this.jsCallBacks.qrLoginCallback;
                    if (optInt == 1) {
                        z = true;
                    }
                    qrLoginCallback.loginStatusChange(z);
                }
                if (SapiJsInterpreters.this.jsCallBacks.finishPage) {
                    SapiJsInterpreters.this.sapiWebView.finish();
                    return null;
                }
                return null;
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SapiActionRealnameSubError extends AbstractInterpreter {
        public SapiActionRealnameSubError() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                accountRealNameResult.errorStep = jSONObject.optInt("errorStep");
                accountRealNameResult.subResultCode = jSONObject.optInt("subResultCode");
                accountRealNameResult.subResultMsg = jSONObject.optString("subResultMsg");
                if (SapiJsInterpreters.this.jsCallBacks.realNameSubErrorCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.realNameSubErrorCallback.onFinish(accountRealNameResult);
                    return null;
                }
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
                        } catch (JSONException e) {
                            Log.e(e);
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

    /* loaded from: classes3.dex */
    public class SapiActionSyncAccountInfo extends AbstractInterpreter {
        public SapiActionSyncAccountInfo() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks != null && SapiJsInterpreters.this.jsCallBacks.mSyncAccountCallBack != null) {
                try {
                    SapiContext sapiContext = SapiContext.getInstance();
                    if (sapiContext == null) {
                        Log.e(SapiJsInterpreters.TAG, "sapi_action_sync_account_info SapiContext.getInstance() is null, please check pass sdk has init");
                        return "";
                    }
                    SapiAccount currentAccount = sapiContext.getCurrentAccount();
                    if (currentAccount == null) {
                        Log.e(SapiJsInterpreters.TAG, "sapi_action_sync_account_info currentAccount is null, please check current is login");
                        return "";
                    }
                    boolean syncAccount = SyncAccountUtils.syncAccount(command.getActionParams().get(0), currentAccount);
                    JSONObject jSONObject = new JSONObject();
                    if (syncAccount) {
                        SapiContext.getInstance().updateTouchidAccounts(currentAccount);
                        SapiContext.getInstance().addLoginAccount(currentAccount);
                        new ShareStorage().asyncSet(2);
                        jSONObject.put("errno", "0");
                        SapiJsInterpreters.this.jsCallBacks.mSyncAccountCallBack.onSyncAccount(currentAccount);
                    } else {
                        jSONObject.put("errno", "1");
                    }
                    return jSONObject.toString();
                } catch (Exception e) {
                    Log.e(e);
                    return "";
                }
            }
            Log.e(SapiJsInterpreters.TAG, "sapi_action_sync_account_info jsCallBacks is null");
            return "";
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SapiActionThirdSafetyVerification extends AbstractInterpreter {
        public SapiActionThirdSafetyVerification() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialVerificationHandler != null) {
                try {
                    SapiJsInterpreters.this.jsCallBacks.socialVerificationHandler.sendMessage(ThirdPartyUtil.getVerificationMsg(new JSONObject(command.getActionParams().get(0)).optString("type")));
                    return null;
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (SapiJsInterpreters.this.jsCallBacks != null && SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                        return null;
                    }
                    return null;
                }
            }
            SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
            return null;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            String str = "pp";
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
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            if (command.getActionParams().size() > 4) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(4));
                    Iterator<String> keys = jSONObject.keys();
                    Bundle bundle = new Bundle();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        bundle.putString(next, jSONObject.optString(next));
                    }
                    biometricsIdentifyResult.extraParams = bundle;
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
            if (!TextUtils.isEmpty(biometricsIdentifyResult.subPro)) {
                str = biometricsIdentifyResult.subPro;
            }
            biometricsIdentifyResult.subPro = str;
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class SapiBiometricsIdentificationLive extends AbstractInterpreter {
        public SapiBiometricsIdentificationLive() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentificationLiveCallBack != null) {
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
                            } catch (JSONException e) {
                                e.printStackTrace();
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
                            } catch (JSONException e) {
                                Log.e(SapiJsInterpreters.TAG, e.getMessage());
                                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                            }
                        }
                    });
                    return null;
                } catch (JSONException e) {
                    Log.e(SapiJsInterpreters.TAG, e.getMessage());
                    if (SapiJsInterpreters.this.jsCallBacks != null && SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                        return null;
                    }
                    return null;
                }
            }
            SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
            String str = "pp";
            biometricsIdentifyResult.subPro = "pp";
            if (command.getActionParams().size() > 5) {
                biometricsIdentifyResult.subPro = command.getActionParams().get(5);
            }
            if (command.getActionParams().size() > 6) {
                try {
                    biometricsIdentifyResult.showGuidePage = 1 - new JSONObject(command.getActionParams().get(6)).optInt("hideGuidePage", 0);
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            if (!TextUtils.isEmpty(biometricsIdentifyResult.subPro)) {
                str = biometricsIdentifyResult.subPro;
            }
            biometricsIdentifyResult.subPro = str;
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
            String str = "pp";
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
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            if (!TextUtils.isEmpty(biometricsIdentifyResult.subPro)) {
                str = biometricsIdentifyResult.subPro;
            }
            biometricsIdentifyResult.subPro = str;
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
            } catch (JSONException e) {
                Log.e(e);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class SapiClientHistoryLogin extends AbstractInterpreter {
        public SapiClientHistoryLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(command.getActionParams().get(0));
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject != null) {
                LoginHistoryModel loginHistoryModel = new LoginHistoryModel();
                loginHistoryModel.bduss = jSONObject.optString("bduss");
                SapiAccountManager.getInstance().loadHistoryActionLoginFromWap(loginHistoryModel, new LoginHistoryCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiClientHistoryLogin.1
                    @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                    public void onLoginSuccess(SapiAccount sapiAccount) {
                        if (SapiJsInterpreters.this.jsCallBacks.historyLoginCallback != null) {
                            SapiJsInterpreters.this.sapiWebView.handleLoginHistoryLogin(sapiAccount);
                            SapiJsInterpreters.this.jsCallBacks.historyLoginCallback.onSuccess();
                        }
                    }

                    @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                    public void onLoginFailure() {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("errno", -1);
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class SapiIdcardOcrImage extends AbstractInterpreter {
        public SapiIdcardOcrImage() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.idcardOcrImageCallBack != null) {
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
                            } catch (JSONException e) {
                                e.printStackTrace();
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
                            } catch (JSONException e) {
                                e.printStackTrace();
                                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                            }
                        }
                    });
                    return null;
                } catch (JSONException e) {
                    Log.e(SapiJsInterpreters.TAG, e.getMessage());
                    if (SapiJsInterpreters.this.jsCallBacks != null && SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                        return null;
                    }
                    return null;
                }
            }
            SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
            return null;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class SapiRemoveLoginHistory extends AbstractInterpreter {
        public SapiRemoveLoginHistory() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = null;
            try {
                jSONObject2.put("errno", 0);
                jSONObject = new JSONObject(command.getActionParams().get(0));
                try {
                    String optString = jSONObject.optString(SyncAccountUtils.KEY_PORTRAIT_SIGN);
                    if (!TextUtils.isEmpty(optString)) {
                        SapiContext.getInstance().removeTouchidAccountByPortrait(optString);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray(FaceLoginService.KEY_FACE_LOGIN_LIVINGUNAMES);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        SapiContext.getInstance().markAsDeleteFaceLogin(optJSONArray);
                    }
                    String optString2 = jSONObject.optString("portrait");
                    if (!TextUtils.isEmpty(optString2)) {
                        String[] split = optString2.split("/");
                        String str = split[split.length - 1];
                        if (str.contains(".")) {
                            str = str.substring(0, str.lastIndexOf("."));
                        }
                        ShareUtils.markAsDeleteShareLogin(str);
                    }
                } catch (Exception e) {
                    e = e;
                    jSONObject3 = jSONObject;
                    Log.e(e);
                    jSONObject = jSONObject3;
                    if (jSONObject != null) {
                    }
                    return jSONObject2.toString();
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (jSONObject != null) {
                try {
                    if (TextUtils.equals(jSONObject.optString("loginType"), "history")) {
                        LoginHistoryLoginModel.delBdussLoginHistoryInfo(jSONObject.optString("bduss"));
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return jSONObject2.toString();
        }
    }

    /* loaded from: classes3.dex */
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
                    String optString5 = jSONObject.optString("session_id");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm("finish");
                    ShareLoginStat.MakeShareLoginStat.sValueSence = "in";
                    SapiJsInterpreters.this.jsCallBacks.shareAccountClickCallback.onClick(optString2, optString, optString4, optString5, optString3);
                } catch (Exception e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class SpeechRecognitionGetContent extends AbstractInterpreter {
        public SpeechRecognitionGetContent() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.jsCallBacks.speechRecognitionCallback.onSpeechRecognition(new SapiJsCallBacks.SpeechRecognitionResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SpeechRecognitionGetContent.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionResult
                public void setSpeechData(int i, String str) {
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", i);
                            jSONObject.put("text", str);
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                    }
                }
            });
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.SWITCH;
            JSONArray jSONArray = new JSONArray();
            try {
                for (SapiAccount sapiAccount : arrayList) {
                    JSONObject jSONObject2 = sapiAccount.toJSONObject();
                    jSONObject2.put("portrait", sapiAccount.getCompletePortrait());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("errno", 0);
                jSONObject.put("accountList", jSONArray);
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class SwitchAccountGetConfig extends AbstractInterpreter {
        public SwitchAccountGetConfig() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int i;
            JSONObject jSONObject = new JSONObject();
            try {
                int i2 = 0;
                jSONObject.put("errno", 0);
                if (SapiJsInterpreters.this.sapiWebView.showSwitchAccount) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("showSwitchAccount", i);
                if (SapiJsInterpreters.this.sapiWebView.showLinkAccount) {
                    i2 = 1;
                }
                jSONObject.put("showLinkAccount", i2);
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class SwitchAccountRemoveAccount extends AbstractInterpreter {
        public SwitchAccountRemoveAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString("uid");
                if (!TextUtils.isEmpty(optString)) {
                    for (SapiAccount sapiAccount : SapiContext.getInstance().getLoginAccounts()) {
                        if (optString.equals(sapiAccount.uid)) {
                            SapiAccountManager.getInstance().removeLoginAccount(sapiAccount);
                            jSONObject.put("errno", 0);
                            return jSONObject.toString();
                        }
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
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
                } catch (Exception e) {
                    Log.e(e);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class TouchidChangeStatus extends AbstractInterpreter {
        public TouchidChangeStatus() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
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
                        str3 = jSONObject2.optString(SyncAccountUtils.KEY_PORTRAIT_SIGN);
                    } catch (JSONException e) {
                        e = e;
                        Log.e(e);
                        str3 = null;
                        final SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        currentAccount.phone = str2;
                        if (!"open".equals(str)) {
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    str2 = null;
                }
            } catch (JSONException e3) {
                e = e3;
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
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        } catch (Exception e4) {
                            Log.e(e4);
                        }
                    }
                };
                if (SapiJsInterpreters.this.jsCallBacks != null && SapiJsInterpreters.this.jsCallBacks.fingerprintCallback != null) {
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

    /* loaded from: classes3.dex */
    public class TouchidCheckGuideStatus extends AbstractInterpreter {
        public TouchidCheckGuideStatus() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            boolean z;
            int i;
            String str;
            JSONObject jSONObject = new JSONObject();
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString(SyncAccountUtils.KEY_PORTRAIT_SIGN);
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
                if (fingerPrintState == 0 && !TextUtils.isEmpty(optString) && !contains) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (!SapiJsInterpreters.this.sapiWebView.supportTouchGuide) {
                    i = 0;
                }
                if (z) {
                    i = 0;
                }
                jSONObject.put("errno", 0);
                jSONObject.put("guide", i);
                if (TextUtils.isEmpty(optString)) {
                    str = YYOption.UrlProtocol.USER;
                } else if (fingerPrintState != 101 && fingerPrintState != 102) {
                    if (contains) {
                        str = "103";
                    } else if (!SapiJsInterpreters.this.sapiWebView.supportTouchGuide) {
                        str = "106";
                    } else if (z) {
                        str = "107";
                    } else {
                        str = fingerPrintState + "";
                    }
                } else {
                    str = fingerPrintState + "";
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                linkedHashMap.put(TouchidLoginStat.VALUE_PAGE, str);
                StatService.onEventAutoStatistic(linkedHashMap);
                TouchidLoginStat.sValue = str;
                TouchidLoginStat.upload();
                if (i == 1) {
                    SapiContext.getInstance().addTouchidLoginRecord(optString);
                }
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
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
                if (FingerprintUtil.getFingerPrintState(SapiJsInterpreters.this.configuration) == 0) {
                    List<SapiAccount> touchidAccounts = SapiContext.getInstance().getTouchidAccounts();
                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    Iterator<SapiAccount> it = touchidAccounts.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            SapiAccount next = it.next();
                            if (next.equals(currentAccount) && !TextUtils.isEmpty(next.email)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
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
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
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
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                    } catch (Exception e) {
                        Log.e(e);
                    }
                }
            };
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.TOUCHID;
            fingerprintResult.authType = 3;
            if (SapiJsInterpreters.this.jsCallBacks != null && SapiJsInterpreters.this.jsCallBacks.fingerprintCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.fingerprintCallback.onCallback(fingerprintResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        if (i == 0) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(command.getActionParams().get(0));
                                String optString = jSONObject2.optString("portrait");
                                String optString2 = jSONObject2.optString(SyncAccountUtils.KEY_PORTRAIT_SIGN);
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
                            } catch (Exception e) {
                                Log.e(e);
                            }
                        }
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
            };
            if (SapiJsInterpreters.this.jsCallBacks != null && SapiJsInterpreters.this.jsCallBacks.fingerprintCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.fingerprintCallback.onCallback(fingerprintResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
                sapiAccount.ptoken = jSONObject.optString("ptoken");
                sapiAccount.stoken = jSONObject.optString("stoken");
                if (!TextUtils.isEmpty(optString) && SapiAccount.isValidAccount(sapiAccount) && SapiJsInterpreters.this.jsCallBacks.uniteVerifyCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.uniteVerifyCallback.onSuccess(optString, optString2, sapiAccount);
                    return null;
                }
                return null;
            } catch (JSONException e) {
                Log.e(e);
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
        } catch (Exception e) {
            Log.e(e);
            return null;
        }
    }

    public AbstractInterpreter getInterpreter(String str) {
        AbstractInterpreter abstractInterpreter = this.interpreterHashMap.get(str);
        if (abstractInterpreter == null && (abstractInterpreter = buidInterpreterByName(str)) != null) {
            this.interpreterHashMap.put(str, abstractInterpreter);
        }
        return abstractInterpreter;
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
}
