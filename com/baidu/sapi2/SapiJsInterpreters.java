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
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.e;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.k;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.bytedance.sdk.openadsdk.preload.falconx.statistic.StatisticData;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SapiJsInterpreters {

    /* renamed from: a  reason: collision with root package name */
    private SapiWebView f4854a;
    private SapiJsCallBacks.CallBacks c;
    private Context d;
    private long f;
    private HashMap<String, AbstractInterpreter> e = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private SapiConfiguration f4855b = SapiAccountManager.getInstance().getSapiConfiguration();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public abstract class AbstractInterpreter {
        AbstractInterpreter() {
        }

        public abstract String interpret(SapiWebView.Command command);
    }

    /* loaded from: classes3.dex */
    class ActionBindWidgetPhoneNumberExist extends AbstractInterpreter {
        ActionBindWidgetPhoneNumberExist() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.c.g != null) {
                SapiJsInterpreters.this.c.g.onPhoneNumberExist(str);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionFaceLoginSwitch extends AbstractInterpreter {
        ActionFaceLoginSwitch() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString("livinguname");
                if (!TextUtils.isEmpty(optString)) {
                    new FaceLoginService().syncFaceLoginUID(SapiJsInterpreters.this.d, optString);
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
    class ActionForgetPwd extends AbstractInterpreter {
        ActionForgetPwd() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.c.G != null ? SapiJsInterpreters.this.c.G.onForgetPwd() : false ? "1" : "0";
        }
    }

    /* loaded from: classes3.dex */
    class ActionGenerateSign extends AbstractInterpreter {
        ActionGenerateSign() {
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
            return SapiUtils.calculateSig(hashMap, SapiJsInterpreters.this.f4855b.appSignKey);
        }
    }

    /* loaded from: classes3.dex */
    class ActionGetLoadtime extends AbstractInterpreter {
        ActionGetLoadtime() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView unused = SapiJsInterpreters.this.f4854a;
            if (SapiWebView.statLoadLogin != null) {
                SapiWebView unused2 = SapiJsInterpreters.this.f4854a;
                return SapiWebView.statLoadLogin.a().toString();
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionGetSmsCheckCodeFromClip extends AbstractInterpreter {
        ActionGetSmsCheckCodeFromClip() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        @TargetApi(11)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            String str;
            try {
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.d.getSystemService("clipboard");
                if (clipboardManager.hasPrimaryClip()) {
                    try {
                        str = SapiUtils.getSmsCheckCode(clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                    } catch (Throwable th) {
                        th = th;
                        Log.e(th);
                        SapiStatUtil.statSmsCodeClip(SapiJsInterpreters.this.d, !TextUtils.isEmpty(str) ? "0" : "1");
                        return str;
                    }
                } else {
                    str = "";
                }
            } catch (Throwable th2) {
                th = th2;
                str = "";
            }
            SapiStatUtil.statSmsCodeClip(SapiJsInterpreters.this.d, !TextUtils.isEmpty(str) ? "0" : "1");
            return str;
        }
    }

    /* loaded from: classes3.dex */
    class ActionHuaweiLogin extends AbstractInterpreter {
        ActionHuaweiLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.f4852a != null) {
                Message message = new Message();
                message.what = SocialType.HUAWEI.getType();
                message.obj = SocialType.HUAWEI;
                SapiJsInterpreters.this.c.f4852a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionJoinLogin extends AbstractInterpreter {
        ActionJoinLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                Object[] pkgIconAndName = SapiUtils.getPkgIconAndName(SapiJsInterpreters.this.d, SapiJsInterpreters.this.d.getPackageName());
                jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, pkgIconAndName[0]);
                jSONObject.put("name", pkgIconAndName[1]);
                List<ShareStorage.StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(SapiJsInterpreters.this.f4855b.context);
                if (SapiJsInterpreters.this.c.r != null && shareStorageModel != null && shareStorageModel.size() > 0) {
                    jSONObject.put("openShareLogin", "true");
                } else {
                    jSONObject.put("openShareLogin", "false");
                }
                jSONObject.put("hasThirdAccount", SapiJsInterpreters.this.c.R == null ? "false" : SapiJsInterpreters.this.c.R.hasThirdAccount + "");
                jSONObject.put("supportFaceLogin", new FaceLoginService().isSupFaceLogin());
                if (SapiJsInterpreters.this.c.R != null && SapiJsInterpreters.this.c.R.agreement != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : SapiJsInterpreters.this.c.R.agreement.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", str);
                        jSONObject2.put("url", SapiJsInterpreters.this.c.R.agreement.get(str));
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
    class ActionLoadExternalWebview extends AbstractInterpreter {
        ActionLoadExternalWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.h != null) {
                SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult = new SapiWebView.LoadExternalWebViewResult();
                loadExternalWebViewResult.defaultTitle = command.getActionParams().get(0);
                loadExternalWebViewResult.externalUrl = command.getActionParams().get(1);
                SapiJsInterpreters.this.c.h.loadExternalWebview(loadExternalWebViewResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionLoadSlideWebview extends AbstractInterpreter {
        ActionLoadSlideWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.v != null) {
                SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult = new SapiWebView.LoadSlideWebViewResult();
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    loadSlideWebViewResult.placeholderTitle = jSONObject.optString("placeholderTitle");
                    loadSlideWebViewResult.url = jSONObject.optString("url");
                    loadSlideWebViewResult.page = jSONObject.optString("page");
                    loadSlideWebViewResult.adapter = jSONObject.optString("adapter");
                    SapiJsInterpreters.this.c.v.loadSlideWebview(loadSlideWebViewResult);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(BaseJsonData.TAG_ERRNO, "0");
                    return jSONObject2.toString();
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionRemoveShareAccount extends AbstractInterpreter {
        ActionRemoveShareAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (SapiAccount sapiAccount : SapiAccountManager.getInstance().getShareAccounts()) {
                if (str.equals(sapiAccount.uid)) {
                    SapiShareClient.getInstance().invalidate(sapiAccount);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionSetTitle extends AbstractInterpreter {
        ActionSetTitle() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.c.f4853b != null) {
                SapiJsInterpreters.this.c.f4853b.onTitleChange(str);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionShareAccountsViewBtnClicked extends AbstractInterpreter {
        ActionShareAccountsViewBtnClicked() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.f != null) {
                SapiJsInterpreters.this.c.f.handleOtherLogin();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionShareClickOther extends AbstractInterpreter {
        ActionShareClickOther() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiStatUtil.statShareClickOther(command.getActionParams().get(0), SapiJsInterpreters.this.f4854a.extras);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionShareV1AccountClick extends AbstractInterpreter {
        ActionShareV1AccountClick() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str;
            String str2 = command.getActionParams().get(0);
            String str3 = "";
            String str4 = "";
            List<SapiAccount> shareAccounts = SapiAccountManager.getInstance().getShareAccounts();
            int i = 0;
            int i2 = 0;
            while (i < shareAccounts.size()) {
                if (str2.equals(shareAccounts.get(i).uid)) {
                    String shareAccountTpl = shareAccounts.get(i).getShareAccountTpl();
                    str = shareAccounts.get(i).app;
                    str3 = shareAccountTpl;
                    i2 = i;
                } else {
                    str = str4;
                }
                i++;
                str4 = str;
            }
            SapiStatUtil.statShareV1AccountClick(i2, str3, str4, SapiJsInterpreters.this.f4854a.extras);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionShareV2Login extends AbstractInterpreter {
        ActionShareV2Login() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.c.W.pageParams.toString();
        }
    }

    /* loaded from: classes3.dex */
    class ActionShareV2LoginClick extends AbstractInterpreter {
        ActionShareV2LoginClick() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.W.onSuccess();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionShareV2LoginFail extends AbstractInterpreter {
        ActionShareV2LoginFail() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.W.onError();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionSocialMeizuSso extends AbstractInterpreter {
        ActionSocialMeizuSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.f4852a != null) {
                Message message = new Message();
                message.what = SocialType.MEIZU.getType();
                message.obj = SocialType.MEIZU;
                SapiJsInterpreters.this.c.f4852a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionSocialQqSso extends AbstractInterpreter {
        ActionSocialQqSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.f4852a != null) {
                Message message = new Message();
                message.what = SocialType.QQ_SSO.getType();
                message.obj = SocialType.QQ_SSO;
                SapiJsInterpreters.this.c.f4852a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionSocialSinaSso extends AbstractInterpreter {
        ActionSocialSinaSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.f4852a != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO_SSO.getType();
                message.obj = SocialType.SINA_WEIBO_SSO;
                SapiJsInterpreters.this.c.f4852a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionSocialWeixinSso extends AbstractInterpreter {
        ActionSocialWeixinSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.f4852a != null) {
                Message message = new Message();
                message.what = SocialType.WEIXIN.getType();
                message.obj = SocialType.WEIXIN;
                SapiJsInterpreters.this.c.f4852a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionStopSlideWebview extends AbstractInterpreter {
        ActionStopSlideWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            boolean z;
            if (SapiJsInterpreters.this.c.D != null) {
                try {
                    z = new JSONObject(command.getActionParams().get(0)).optBoolean("isStop");
                } catch (Exception e) {
                    Log.e(e);
                    z = false;
                }
                SapiJsInterpreters.this.c.D.onStopSlide(z);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ActionXiaoMiSso extends AbstractInterpreter {
        ActionXiaoMiSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.f4852a != null) {
                Message message = new Message();
                message.what = SocialType.XIAOMI.getType();
                message.obj = SocialType.XIAOMI;
                SapiJsInterpreters.this.c.f4852a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class AddressManageGetContact extends AbstractInterpreter {
        AddressManageGetContact() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.I.onGetContact(new SapiJsCallBacks.AddressManageCallback.GetContactResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.AddressManageGetContact.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.AddressManageCallback.GetContactResult
                public void setGetContactResult(String str) {
                    SapiJsInterpreters.this.c.M.confirm(str);
                }
            });
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class AddressManageGetPasteboard extends AbstractInterpreter {
        AddressManageGetPasteboard() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.d.getSystemService("clipboard");
                if (clipboardManager.hasPrimaryClip()) {
                    jSONObject.put("paste", clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class AddressManageSelectedAddress extends AbstractInterpreter {
        AddressManageSelectedAddress() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.I != null && command.getActionParams().size() > 0) {
                SapiJsInterpreters.this.c.I.onSelectedAddress(command.getActionParams().get(0));
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
            } catch (JSONException e) {
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class AuthorizedResponse extends AbstractInterpreter {
        AuthorizedResponse() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            int parseInt = command.getActionParams().size() >= 2 ? Integer.parseInt(command.getActionParams().get(1)) : 0;
            String str2 = command.getActionParams().size() >= 3 ? command.getActionParams().get(2) : null;
            if (parseInt == 1) {
                SocialResponse b2 = SapiWebView.b(str, SapiJsInterpreters.this.d);
                if (b2 == null) {
                    if (SapiJsInterpreters.this.c.G != null) {
                        SapiJsInterpreters.this.f4854a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.c.G != null) {
                                    SapiJsInterpreters.this.c.G.onFailed(-100, "登录失败");
                                }
                            }
                        });
                    }
                } else if (b2.offlineNotice || b2.bindGuide || b2.errorCode == 21 || b2.bindConflict) {
                    SapiJsInterpreters.this.c.Q = b2;
                } else {
                    SapiJsInterpreters.this.f4854a.a(b2);
                }
            }
            if (parseInt == 0) {
                final SapiAccountResponse a2 = SapiJsInterpreters.this.f4854a.a(str, SapiJsInterpreters.this.d);
                if (a2 == null) {
                    if (SapiJsInterpreters.this.c.G != null) {
                        SapiJsInterpreters.this.f4854a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.c.G != null) {
                                    SapiJsInterpreters.this.c.G.onFailed(-100, "登录失败");
                                }
                            }
                        });
                    }
                } else {
                    int i = a2.errorCode;
                    if (i == 0 || i == 110000) {
                        SapiJsInterpreters.this.f4854a.a(a2);
                        if (SapiWebView.SWITCH_ACCOUNT_PAGE.equals(str2)) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                            } catch (JSONException e) {
                                Log.e(e);
                            }
                            return jSONObject.toString();
                        }
                    } else if (SapiJsInterpreters.this.c.G != null) {
                        SapiJsInterpreters.this.f4854a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.c.G != null) {
                                    AuthorizationListener authorizationListener = SapiJsInterpreters.this.c.G;
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

    /* loaded from: classes3.dex */
    class Back extends AbstractInterpreter {
        Back() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.f4854a.back();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class ConfigFastloginFeatures extends AbstractInterpreter {
        ConfigFastloginFeatures() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            List<FastLoginFeature> fastLoginFeatureList = SapiJsInterpreters.this.c.u != null ? SapiJsInterpreters.this.c.u.getFastLoginFeatureList() : null;
            List<FastLoginFeature> list = fastLoginFeatureList == null ? SapiJsInterpreters.this.f4855b.fastLoginFeatureList : fastLoginFeatureList;
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance().isHostsHijacked()) {
                return sb.toString();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    FastLoginFeature fastLoginFeature = list.get(i2);
                    if (i2 == 0) {
                        sb.append(fastLoginFeature.getStrValue());
                    } else {
                        sb.append(",").append(fastLoginFeature.getStrValue());
                    }
                    i = i2 + 1;
                } else {
                    return sb.toString();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class ConfigLoginShareStrategy extends AbstractInterpreter {
        ConfigLoginShareStrategy() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.f4855b.loginShareStrategy().getStrValue();
        }
    }

    /* loaded from: classes3.dex */
    class CurrentAccountBdussExpired extends AbstractInterpreter {
        CurrentAccountBdussExpired() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.C != null) {
                SapiJsInterpreters.this.c.C.onBdussExpired();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class CurrentPageName extends AbstractInterpreter {
        CurrentPageName() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.E != null) {
                try {
                    SapiJsInterpreters.this.c.E.getCurrentPageName(new JSONObject(command.getActionParams().get(0)).optString("name"));
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
    class Finish extends AbstractInterpreter {
        Finish() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.f4854a.a(SapiJsInterpreters.this.c.Q);
            if (command.getActionParams().size() > 0) {
                try {
                    SapiJsInterpreters.this.f4854a.finish(new JSONObject(command.getActionParams().get(0)).optString("page"));
                } catch (JSONException e) {
                    Log.e(e);
                }
            } else {
                SapiJsInterpreters.this.f4854a.finish();
            }
            if (SapiJsInterpreters.this.c.y != null) {
                SapiJsInterpreters.this.c.y.onFinish(command.getActionParams().size() > 0 ? command.getActionParams().get(0) : "");
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class GetAllClientAccounts extends AbstractInterpreter {
        GetAllClientAccounts() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            List<SapiAccount> shareAccounts;
            Object jSONArray;
            SapiContext sapiContext = SapiContext.getInstance();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
            } catch (JSONException e) {
                Log.e(e);
            }
            List<SapiAccount> touchidAccounts = sapiContext.getTouchidAccounts();
            try {
                JSONArray jSONArray2 = new JSONArray();
                boolean z = com.baidu.sapi2.g.d.a(SapiJsInterpreters.this.f4855b) == 0;
                for (SapiAccount sapiAccount : touchidAccounts) {
                    JSONObject jSONObject2 = sapiAccount.toJSONObject();
                    if (!TextUtils.isEmpty(sapiAccount.phone) && sapiAccount.phone.contains("http://")) {
                        sapiAccount.phone = sapiAccount.phone.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
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
                    jSONArray2.put(jSONObject2);
                }
                jSONObject.put("fingerAccounts", jSONArray2);
            } catch (Exception e2) {
                Log.e(e2);
            }
            try {
                jSONObject.put("onekeyAccounts", new OneKeyLoginSdkCall().b());
            } catch (Exception e3) {
                Log.e(e3);
            }
            try {
                jSONObject.put("faceAccounts", sapiContext.getV2FaceLoginCheckResults());
            } catch (Exception e4) {
                Log.e(e4);
            }
            try {
                List<ShareStorage.StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(SapiJsInterpreters.this.f4855b.context);
                JSONArray jSONArray3 = ShareStorage.StorageModel.toJSONArray(shareStorageModel);
                if (jSONArray3 != null && jSONArray3.length() != 0) {
                    jSONObject.put("canshare2Accounts", jSONArray3);
                    SapiStatUtil.statShareV2Open(shareStorageModel, null, SapiJsInterpreters.this.f4854a.extras);
                } else if (sapiContext.getSapiOptions().u.a(e.c.f5231b).c) {
                    String[] split = sapiContext.getBaiduAppPkgList().split(",");
                    String[] deleteShareLoginList = sapiContext.getDeleteShareLoginList();
                    JSONArray jSONArray4 = new JSONArray();
                    JSONArray jSONArray5 = new JSONArray();
                    for (String str : split) {
                        jSONArray4.put(str);
                    }
                    for (String str2 : deleteShareLoginList) {
                        jSONArray5.put(str2);
                    }
                    jSONObject.put("appList", jSONArray4);
                    jSONObject.put("deleteAccounts", jSONArray5);
                    jSONObject.put("currentAppPkg", SapiJsInterpreters.this.f4855b.context.getPackageName());
                }
            } catch (Exception e5) {
                Log.e(e5);
            }
            try {
                if (!jSONObject.has("canshare2Accounts") && (jSONArray = SapiAccount.toJSONArray((shareAccounts = SapiAccountManager.getInstance().getShareAccounts()))) != null) {
                    jSONObject.put("canshare1Accounts", jSONArray);
                    SapiStatUtil.statShareV1OpenPage(shareAccounts, SapiJsInterpreters.this.f4854a.extras);
                }
            } catch (Exception e6) {
                Log.e(e6);
            }
            try {
                jSONObject.put("recentLoginUid", sapiContext.getDecryptStr(SapiContext.KEY_LAST_LOGIN_UID));
            } catch (JSONException e7) {
                Log.e(e7);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class GetCurrentAccountInfo extends AbstractInterpreter {
        GetCurrentAccountInfo() {
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
                    jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                    return jSONObject.toString();
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class GetPresetPhoneNumber extends AbstractInterpreter {
        GetPresetPhoneNumber() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f4855b.forbidPresetPhoneNumber) {
                return "";
            }
            if (SapiUtils.isValidPhoneNumber(SapiJsInterpreters.this.f4855b.presetPhoneNumber)) {
                return SapiJsInterpreters.this.f4855b.presetPhoneNumber;
            }
            String localPhoneNumber = SapiJsInterpreters.this.f4854a.getLocalPhoneNumber();
            return !SapiUtils.isValidPhoneNumber(localPhoneNumber) ? "" : localPhoneNumber;
        }
    }

    /* loaded from: classes3.dex */
    class GrantWebLogin extends AbstractInterpreter {
        GrantWebLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                int optInt = new JSONObject(command.getActionParams().get(0)).optInt("type");
                if (SapiJsInterpreters.this.c.B != null) {
                    SapiJsInterpreters.this.c.B.onGrant(optInt);
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
    class InvoiceBuildSelectedInvoice extends AbstractInterpreter {
        InvoiceBuildSelectedInvoice() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.J != null && command.getActionParams().size() > 0) {
                SapiJsInterpreters.this.c.J.onCallback(command.getActionParams().get(0));
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
            } catch (JSONException e) {
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class NormalizeGuestAccount extends AbstractInterpreter {
        NormalizeGuestAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                String optString = jSONObject.optString("msg");
                if (optInt != 0) {
                    if (SapiJsInterpreters.this.c.x != null) {
                        SapiJsInterpreters.this.c.x.onFailure(optInt, optString);
                    }
                } else {
                    boolean z = jSONObject.optInt("merge") == 1;
                    String optString2 = jSONObject.optString("normalizeWay");
                    SapiAccountResponse a2 = SapiJsInterpreters.this.f4854a.a(jSONObject.optString("xml"), SapiJsInterpreters.this.d);
                    if (a2 == null) {
                        if (SapiJsInterpreters.this.c.x != null) {
                            SapiJsInterpreters.this.c.x.onFailure(NormalizeGuestAccountResult.ERROR_CODE_PARSE_XML, NormalizeGuestAccountResult.ERROR_MSG_PARSE_XML);
                        }
                    } else {
                        SapiAccount b2 = SapiJsInterpreters.this.f4854a.b(a2);
                        if (!SapiAccount.isValidAccount(b2)) {
                            SapiJsInterpreters.this.c.x.onFailure(-202, "网络连接失败，请检查网络设置");
                        } else {
                            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                            if (currentAccount != null) {
                                b2.addSocialInfo(currentAccount.getSocialType(), currentAccount.getSocialPortrait());
                            }
                            SapiAccountManager.getInstance().removeLoginAccount(currentAccount);
                            SapiAccountManager.getInstance().validate(b2);
                            if (SapiJsInterpreters.this.c.x != null) {
                                SapiJsInterpreters.this.c.x.onSuccess(z, optString2);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                Log.e(e);
                if (SapiJsInterpreters.this.c.x != null) {
                    SapiJsInterpreters.this.c.x.onFailure(-202, "网络连接失败，请检查网络设置");
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class NormalizeGuestDescription extends AbstractInterpreter {
        NormalizeGuestDescription() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                if (!TextUtils.isEmpty(SapiJsInterpreters.this.c.S)) {
                    jSONObject.put("description", new JSONObject(SapiJsInterpreters.this.c.S));
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class OauthCallBaidu extends AbstractInterpreter {
        OauthCallBaidu() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.V != null) {
                SapiJsInterpreters.this.c.V.callback.onCallback(command.getActionParams().get(0));
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class OauthSsoHash extends AbstractInterpreter {
        OauthSsoHash() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.OauthSsoHash.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(SsoHashResult ssoHashResult) {
                    SapiJsInterpreters.this.c.M.confirm(ssoHashResult.ssoHash);
                }
            }, SapiJsInterpreters.this.c.V.callingPkg, SapiJsInterpreters.this.c.V.callingAppId);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class RealNameVerifySucceed extends AbstractInterpreter {
        RealNameVerifySucceed() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.m != null) {
                SapiJsInterpreters.this.c.m.onSuccess();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionAccountCenterFastloginFeatures extends AbstractInterpreter {
        SapiActionAccountCenterFastloginFeatures() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            ArrayList arrayList = new ArrayList();
            if (SapiJsInterpreters.this.f4855b.fastLoginFeatureList == null || SapiJsInterpreters.this.f4855b.fastLoginFeatureList.isEmpty()) {
                return null;
            }
            arrayList.addAll(SapiJsInterpreters.this.f4855b.fastLoginFeatureList);
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
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    FastLoginFeature fastLoginFeature = (FastLoginFeature) arrayList.get(i2);
                    if (i2 == 0) {
                        sb.append(fastLoginFeature.getStrValue());
                    } else {
                        sb.append(",").append(fastLoginFeature.getStrValue());
                    }
                    i = i2 + 1;
                } else {
                    return sb.toString();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionAccountDestroy extends AbstractInterpreter {
        SapiActionAccountDestroy() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.p != null) {
                SapiJsInterpreters.this.c.p.onAccountDestory(new SapiWebView.AccountDestoryCallback.AccountDestoryResult());
            }
            SapiJsInterpreters.this.f4854a.finish();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionAccountFreeze extends AbstractInterpreter {
        SapiActionAccountFreeze() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.q != null) {
                SapiJsInterpreters.this.c.q.onAccountFreeze(new SapiWebView.AccountFreezeCallback.AccountFreezeResult());
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionBdussChanged extends AbstractInterpreter {
        SapiActionBdussChanged() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.j != null) {
                SapiJsInterpreters.this.c.j.onBdussChange();
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
            new com.baidu.sapi2.utils.b().a(com.baidu.sapi2.utils.b.i);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionCheckLoginStatus extends AbstractInterpreter {
        SapiActionCheckLoginStatus() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (SapiJsInterpreters.this.c.A != null) {
                    jSONObject.put("sup", true);
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionCheckMethodSupport extends AbstractInterpreter {
        SapiActionCheckMethodSupport() {
            super();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
            if (r5.f4913b.f4855b.supportFaceLogin != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
            if (r5.f4913b.f4855b.supportFaceLogin != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
            if (r5.f4913b.c.t != null) goto L11;
         */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            boolean z;
            boolean z2 = true;
            String str = command.getActionParams().get(0);
            try {
                Class.forName(SapiJsInterpreters.this.c(str));
                z = true;
            } catch (ClassNotFoundException e) {
                z = false;
            }
            if (str.equals("sapi_biometrics_identification_with_uid")) {
                if (SapiJsInterpreters.this.c.c != null) {
                }
                z2 = false;
            } else if (str.equals("sapi_biometrics_identification") || str.equals("sapi_biometrics_identification_no_bduss") || str.equals("sapi_biometrics_identification_with_authtoken")) {
                if (SapiJsInterpreters.this.c.d != null) {
                }
                z2 = false;
            } else if (!str.equals("sapi_action_sc_app_check")) {
                z2 = z;
            }
            return z2 ? "1" : "0";
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionChinaMobileOauth extends AbstractInterpreter {
        SapiActionChinaMobileOauth() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            new OneKeyLoginSdkCall().b(SapiJsInterpreters.this.f4855b, new OneKeyLoginSdkCall.TokenListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionChinaMobileOauth.1
                @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                public void onGetTokenComplete(JSONObject jSONObject) {
                    SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionCoverWebBduss extends AbstractInterpreter {
        SapiActionCoverWebBduss() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String cookieBduss = SapiUtils.getCookieBduss();
            if (SapiJsInterpreters.this.c.n != null) {
                SapiJsInterpreters.this.c.n.onCoverBduss(cookieBduss, new SapiWebView.CoverWebBdussResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionCoverWebBduss.1
                    @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussResult
                    public void setWebBduss(String str) {
                        SapiJsInterpreters.this.f4854a.a(SapiJsInterpreters.this.d, str);
                        SapiJsInterpreters.this.f4854a.reload();
                    }
                });
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionDeliverParams extends AbstractInterpreter {
        SapiActionDeliverParams() {
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
                if (SapiJsInterpreters.this.c.o != null) {
                    SapiJsInterpreters.this.c.o.onPreFillUserName(preFillUserNameResult);
                }
                if (equals) {
                    SapiJsInterpreters.this.f4854a.finish();
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
    class SapiActionDirectedLogin extends AbstractInterpreter {
        SapiActionDirectedLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("encryptedId", SapiJsInterpreters.this.c.T.encryptedId);
                jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, SapiJsInterpreters.this.c.T.displayname);
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionGetAppTpl extends AbstractInterpreter {
        SapiActionGetAppTpl() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.f4855b.getTpl();
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionHandleBackButton extends AbstractInterpreter {
        SapiActionHandleBackButton() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.N = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.c.l != null) {
                SapiJsInterpreters.this.c.l.onLeftBtnVisible(SapiJsInterpreters.this.c.N);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionHideSuccessTip extends AbstractInterpreter {
        SapiActionHideSuccessTip() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hideTip", SapiJsInterpreters.this.c.U ? "1" : "0");
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionLastLoginType extends AbstractInterpreter {
        SapiActionLastLoginType() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lastLoginType", SapiUtils.getLastLoginType());
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionLoginStatusChange extends AbstractInterpreter {
        SapiActionLoginStatusChange() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.A != null) {
                SapiJsInterpreters.this.c.A.onChange();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionMiniDi extends AbstractInterpreter {
        SapiActionMiniDi() {
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
    class SapiActionPasteboardSet extends AbstractInterpreter {
        SapiActionPasteboardSet() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                ((ClipboardManager) SapiJsInterpreters.this.d.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("address", new JSONObject(command.getActionParams().get(0)).optString("content")));
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                return jSONObject.toString();
            } catch (Exception e) {
                Log.e(e);
                return jSONObject.toString();
            }
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionPickDate extends AbstractInterpreter {
        SapiActionPickDate() {
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
            DatePickerDialog datePickerDialog = new DatePickerDialog(SapiJsInterpreters.this.d, 3, new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.1
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public void onDateSet(DatePicker datePicker, int i7, int i8, int i9) {
                    SapiJsInterpreters.this.c.M.confirm(i7 + String.format("%02d", Integer.valueOf(i8 + 1)) + String.format("%02d", Integer.valueOf(i9)) + "");
                }
            }, i, i2, i3);
            datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    SapiJsInterpreters.this.c.M.confirm("");
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
    class SapiActionPickImage extends AbstractInterpreter {
        SapiActionPickImage() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int optInt;
            int i = 0;
            int i2 = 1;
            try {
                i = Integer.parseInt(command.getActionParams().get(0));
            } catch (Exception e) {
                Log.e(e);
            }
            if (command.getActionParams().size() > 1) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                    i2 = jSONObject.optInt("sence", 1);
                    optInt = jSONObject.optInt("size", 512);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                SapiJsInterpreters.this.c.i.onPickImage(i, i2, optInt, new SapiWebView.PickPhotoResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickImage.1
                    @Override // com.baidu.sapi2.SapiWebView.PickPhotoResult
                    public void setImageData(String str) {
                        if (SapiJsInterpreters.this.c.M != null) {
                            SapiJsInterpreters.this.c.M.confirm(str);
                        }
                    }
                });
                return null;
            }
            optInt = 512;
            SapiJsInterpreters.this.c.i.onPickImage(i, i2, optInt, new SapiWebView.PickPhotoResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickImage.1
                @Override // com.baidu.sapi2.SapiWebView.PickPhotoResult
                public void setImageData(String str) {
                    if (SapiJsInterpreters.this.c.M != null) {
                        SapiJsInterpreters.this.c.M.confirm(str);
                    }
                }
            });
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionQrLogin extends AbstractInterpreter {
        SapiActionQrLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                if (SapiJsInterpreters.this.c.s != null) {
                    int optInt = jSONObject.optInt(LogConfig.RELOGIN, -1);
                    if (optInt == 1) {
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        String optString = jSONObject.optString("bduss");
                        String optString2 = jSONObject.optString("ptoken");
                        if (currentAccount != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            currentAccount.bduss = optString;
                            currentAccount.ptoken = optString2;
                            currentAccount.deleteStokens();
                            SapiAccountManager.getInstance().validate(currentAccount);
                            SapiAccountManager.getInstance().preFetchStoken(currentAccount, true);
                        }
                    }
                    SapiJsInterpreters.this.c.s.loginStatusChange(optInt == 1);
                }
                if (SapiJsInterpreters.this.c.O) {
                    SapiJsInterpreters.this.f4854a.finish();
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
    class SapiActionRealname extends AbstractInterpreter {
        SapiActionRealname() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                int optInt = jSONObject.optInt("status");
                accountRealNameResult.callbackkey = jSONObject.optString("callbackKey");
                if (SapiJsInterpreters.this.c.z != null) {
                    if (optInt == 1) {
                        accountRealNameResult.juniorRealNameSuc = true;
                    } else if (optInt == 2) {
                        accountRealNameResult.seniorRealNameSuc = true;
                    }
                    SapiJsInterpreters.this.c.z.onFinish(accountRealNameResult);
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
    class SapiActionScAppCheck extends AbstractInterpreter {
        SapiActionScAppCheck() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                jSONObject.optString("action");
                String optString = jSONObject.optString("minver");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("state", new com.baidu.sapi2.f.a().a(SapiJsInterpreters.this.d, optString, SapiJsInterpreters.this.c.t));
                return jSONObject2.toString();
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionScAppInvoke extends AbstractInterpreter {
        SapiActionScAppInvoke() {
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
                SapiJsInterpreters.this.c.t.onInvokeScApp(optString, optString2, arrayList, new SapiWebView.InvokeScAppCallback.InvokeScAppResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionScAppInvoke.1
                    @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback.InvokeScAppResult
                    public void setInvokeResult(String str) {
                        SapiJsInterpreters.this.c.M.confirm(str);
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
    class SapiActionSwitchAccount extends AbstractInterpreter {
        SapiActionSwitchAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.k != null) {
                List<String> actionParams = command.getActionParams();
                SapiWebView.SwitchAccountCallback.Result result = new SapiWebView.SwitchAccountCallback.Result();
                if (actionParams != null && actionParams.size() > 0) {
                    if (actionParams.size() > 1) {
                        try {
                            JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                            result.extraJson = jSONObject.optString("extrajson");
                            result.displayName = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                            result.encryptedUid = jSONObject.optString("uid");
                            result.loginType = jSONObject.optInt("type");
                            result.switchAccountType = 2;
                            SapiJsInterpreters.this.c.k.onAccountSwitch(result);
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                    } else {
                        result.userName = actionParams.get(0);
                        result.switchAccountType = 1;
                        SapiJsInterpreters.this.c.k.onAccountSwitch(result);
                    }
                }
                result.switchAccountType = 0;
                SapiJsInterpreters.this.c.k.onAccountSwitch(result);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionUpdateNavigator extends AbstractInterpreter {
        SapiActionUpdateNavigator() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int parseInt = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.c.H != null) {
                SapiJsInterpreters.this.c.H.pageState(parseInt);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiActionUpsms extends AbstractInterpreter {
        SapiActionUpsms() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(command.getActionParams().get(0));
            SapiUtils.sendSms(SapiJsInterpreters.this.d, command.getActionParams().get(1), arrayList);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseJsonData.TAG_ERRNO, "0");
            } catch (JSONException e) {
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class SapiBiometricsIdentification extends AbstractInterpreter {
        SapiBiometricsIdentification() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentification.1
                @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.c.M != null) {
                        SapiJsInterpreters.this.c.M.confirm(str);
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
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            biometricsIdentifyResult.subPro = TextUtils.isEmpty(biometricsIdentifyResult.subPro) ? "pp" : biometricsIdentifyResult.subPro;
            if (SapiJsInterpreters.this.c.d != null) {
                SapiJsInterpreters.this.c.d.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiBiometricsIdentificationNoBduss extends AbstractInterpreter {
        SapiBiometricsIdentificationNoBduss() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationNoBduss.1
                @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.c.M != null) {
                        SapiJsInterpreters.this.c.M.confirm(str);
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
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            biometricsIdentifyResult.subPro = TextUtils.isEmpty(biometricsIdentifyResult.subPro) ? "pp" : biometricsIdentifyResult.subPro;
            if (SapiJsInterpreters.this.c.d != null) {
                SapiJsInterpreters.this.c.d.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiBiometricsIdentificationWithAuthtoken extends AbstractInterpreter {
        SapiBiometricsIdentificationWithAuthtoken() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationWithAuthtoken.1
                @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.c.M != null) {
                        SapiJsInterpreters.this.c.M.confirm(str);
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
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            biometricsIdentifyResult.subPro = TextUtils.isEmpty(biometricsIdentifyResult.subPro) ? "pp" : biometricsIdentifyResult.subPro;
            if (SapiJsInterpreters.this.c.d != null) {
                SapiJsInterpreters.this.c.d.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiBiometricsIdentificationWithUid extends AbstractInterpreter {
        SapiBiometricsIdentificationWithUid() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.c != null) {
                SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult = new SapiWebView.BioScanFaceCallback.BioScanFaceResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationWithUid.1
                    @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback.BioScanFaceResult
                    public void setScanFaceIdentifyResult(String str) {
                        SapiJsInterpreters.this.c.M.confirm(str);
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
                    SapiJsInterpreters.this.c.c.onBioScanFace(bioScanFaceResult);
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiGoBack extends AbstractInterpreter {
        SapiGoBack() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.f4854a.canGoBack()) {
                SapiJsInterpreters.this.f4854a.goBack();
                return null;
            }
            SapiJsInterpreters.this.f4854a.finish();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiOnekeyOauthToken extends AbstractInterpreter {
        SapiOnekeyOauthToken() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            new OneKeyLoginSdkCall().a(SapiJsInterpreters.this.f4855b, new OneKeyLoginSdkCall.TokenListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiOnekeyOauthToken.1
                @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                public void onGetTokenComplete(JSONObject jSONObject) {
                    SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SapiRemoveLoginHistory extends AbstractInterpreter {
        SapiRemoveLoginHistory() {
            super();
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00a8, code lost:
            com.baidu.sapi2.share.SapiShareClient.getInstance().invalidate(r0);
         */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                JSONObject jSONObject2 = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject2.optString("portraitSign");
                if (!TextUtils.isEmpty(optString)) {
                    SapiContext.getInstance().removeTouchidAccountByPortrait(optString);
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("livingunames");
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
                    SapiContext.getInstance().markAsDeleteShareLogin(str);
                }
                String optString3 = jSONObject2.optString("uid");
                if (!TextUtils.isEmpty(optString3)) {
                    Iterator<SapiAccount> it = SapiAccountManager.getInstance().getShareAccounts().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SapiAccount next = it.next();
                        if (optString3.equals(next.uid)) {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class SapiShareAccountClick extends AbstractInterpreter {
        SapiShareAccountClick() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String optString;
            if (System.currentTimeMillis() - SapiJsInterpreters.this.f > 1000) {
                SapiJsInterpreters.this.f = System.currentTimeMillis();
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    String optString2 = jSONObject.optString(Config.INPUT_DEF_PKG);
                    String optString3 = jSONObject.optString("from", SapiShareClient.SHARE_ACCOUNT_NEW_VERSION);
                    if (SapiShareClient.SHARE_ACCOUNT_CLOUND_VERSION.equals(optString3)) {
                        optString = jSONObject.optString("portrait");
                    } else {
                        optString = jSONObject.optString("url");
                    }
                    String optString4 = jSONObject.optString("trace_id");
                    String optString5 = jSONObject.optString("session_id");
                    SapiJsInterpreters.this.c.M.confirm("finish");
                    SapiJsInterpreters.this.c.r.onClick(optString2, optString, optString4, optString5, optString3);
                } catch (Exception e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class SpeechRecognitionGetContent extends AbstractInterpreter {
        SpeechRecognitionGetContent() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.w.onSpeechRecognition(new SapiJsCallBacks.SpeechRecognitionResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SpeechRecognitionGetContent.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionResult
                public void setSpeechData(int i, String str) {
                    if (SapiJsInterpreters.this.c.M != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(BaseJsonData.TAG_ERRNO, i);
                            jSONObject.put("text", str);
                            SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
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
    class SwitchAccountGetAccounts extends AbstractInterpreter {
        SwitchAccountGetAccounts() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            List<SapiAccount> arrayList = new ArrayList<>();
            if (SapiJsInterpreters.this.f4855b.supportMultipleAccounts) {
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
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                jSONObject.put("accountList", jSONArray);
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class SwitchAccountGetConfig extends AbstractInterpreter {
        SwitchAccountGetConfig() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                jSONObject.put("showSwitchAccount", SapiJsInterpreters.this.f4854a.showSwitchAccount ? 1 : 0);
                jSONObject.put("showLinkAccount", SapiJsInterpreters.this.f4854a.showLinkAccount ? 1 : 0);
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class SwitchAccountRemoveAccount extends AbstractInterpreter {
        SwitchAccountRemoveAccount() {
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
                            jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                            return jSONObject.toString();
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(e);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class TouchidChangeStatus extends AbstractInterpreter {
        TouchidChangeStatus() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x004c  */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            String str;
            String str2;
            String str3;
            JSONObject jSONObject;
            final JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(BaseJsonData.TAG_ERRNO, 0);
                jSONObject2.put("status", 0);
                jSONObject = new JSONObject(command.getActionParams().get(0));
                str2 = jSONObject.optString("handle");
                try {
                    str = jSONObject.optString("portrait");
                } catch (JSONException e) {
                    e = e;
                    str = null;
                }
            } catch (JSONException e2) {
                e = e2;
                str = null;
                str2 = null;
            }
            try {
                str3 = jSONObject.optString("portraitSign");
            } catch (JSONException e3) {
                e = e3;
                Log.e(e);
                str3 = null;
                final SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                currentAccount.phone = str;
                if (!"open".equals(str2)) {
                }
                return null;
            }
            final SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
            currentAccount2.phone = str;
            if (!"open".equals(str2)) {
                currentAccount2.email = str3;
                SapiJsCallBacks.FingerprintResult fingerprintResult = new SapiJsCallBacks.FingerprintResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.TouchidChangeStatus.1
                    @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintResult
                    public void setResult(int i) {
                        try {
                            jSONObject2.put("status", i);
                            if (i == 0) {
                                SapiContext.getInstance().addTouchidAccounts(currentAccount2);
                            }
                            SapiJsInterpreters.this.c.M.confirm(jSONObject2.toString());
                        } catch (Exception e4) {
                            Log.e(e4);
                        }
                    }
                };
                if (SapiJsInterpreters.this.c.K != null) {
                    SapiJsInterpreters.this.c.K.onCallback(fingerprintResult);
                }
            } else {
                currentAccount2.email = "";
                SapiContext.getInstance().addTouchidAccounts(currentAccount2);
                SapiJsInterpreters.this.c.M.confirm(jSONObject2.toString());
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class TouchidCheckGuideStatus extends AbstractInterpreter {
        TouchidCheckGuideStatus() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            boolean z;
            String str;
            JSONObject jSONObject = new JSONObject();
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString("portraitSign");
                int a2 = com.baidu.sapi2.g.d.a(SapiJsInterpreters.this.f4855b);
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
                if (!SapiJsInterpreters.this.f4854a.supportTouchGuide) {
                    i = 0;
                }
                int i2 = z ? 0 : i;
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                jSONObject.put("guide", i2);
                if (TextUtils.isEmpty(optString)) {
                    str = StatisticData.ERROR_CODE_NOT_FOUND;
                } else if (a2 != 101 && a2 != 102) {
                    if (contains) {
                        str = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
                    } else if (SapiJsInterpreters.this.f4854a.supportTouchGuide) {
                        str = z ? TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP : a2 + "";
                    } else {
                        str = TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT;
                    }
                } else {
                    str = a2 + "";
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                linkedHashMap.put("native_guide_finger", str);
                k.a(linkedHashMap);
                if (i2 == 1) {
                    SapiContext.getInstance().addTouchidLoginRecord(optString);
                }
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class TouchidGetStatus extends AbstractInterpreter {
        TouchidGetStatus() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int i;
            boolean z = false;
            JSONObject jSONObject = new JSONObject();
            try {
                if (com.baidu.sapi2.g.d.a(SapiJsInterpreters.this.f4855b) == 0) {
                    List<SapiAccount> touchidAccounts = SapiContext.getInstance().getTouchidAccounts();
                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    Iterator<SapiAccount> it = touchidAccounts.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SapiAccount next = it.next();
                        if (next.equals(currentAccount) && !TextUtils.isEmpty(next.email)) {
                            z = true;
                            break;
                        }
                    }
                    i = z ? 1 : 2;
                } else {
                    i = 0;
                }
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                jSONObject.put("status", i);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    class TouchidLogin extends AbstractInterpreter {
        TouchidLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsCallBacks.FingerprintResult fingerprintResult = new SapiJsCallBacks.FingerprintResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.TouchidLogin.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintResult
                public void setResult(int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                        jSONObject.put("status", i);
                        SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                    } catch (Exception e) {
                        Log.e(e);
                    }
                }
            };
            fingerprintResult.authType = 3;
            if (SapiJsInterpreters.this.c.K != null) {
                SapiJsInterpreters.this.c.K.onCallback(fingerprintResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class TouchidOpenGuide extends AbstractInterpreter {
        TouchidOpenGuide() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(final SapiWebView.Command command) {
            SapiJsCallBacks.FingerprintResult fingerprintResult = new SapiJsCallBacks.FingerprintResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.TouchidOpenGuide.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintResult
                public void setResult(int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                        jSONObject.put("status", i);
                        SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                        if (i == 0) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(command.getActionParams().get(0));
                                String optString = jSONObject2.optString("portrait");
                                String optString2 = jSONObject2.optString("portraitSign");
                                if (!TextUtils.isEmpty(optString)) {
                                    SapiJsInterpreters.this.c.L[0] = optString;
                                    SapiJsInterpreters.this.f4854a.touchidPortraitAndSign[0] = optString;
                                } else {
                                    SapiJsInterpreters.this.c.L[0] = SapiJsInterpreters.this.f4855b.environment.getConfigHttpsUrl() + com.baidu.sapi2.utils.e.A;
                                    SapiJsInterpreters.this.f4854a.touchidPortraitAndSign[0] = SapiJsInterpreters.this.f4855b.environment.getConfigHttpsUrl() + com.baidu.sapi2.utils.e.A;
                                }
                                SapiJsInterpreters.this.c.L[1] = optString2;
                                SapiJsInterpreters.this.f4854a.touchidPortraitAndSign[1] = optString2;
                            } catch (Exception e) {
                                Log.e(e);
                            }
                        }
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
            };
            if (SapiJsInterpreters.this.c.K != null) {
                SapiJsInterpreters.this.c.K.onCallback(fingerprintResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class UniteVerifyResult extends AbstractInterpreter {
        UniteVerifyResult() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString("info");
                String optString2 = jSONObject.optString("u");
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = jSONObject.optString(CashierData.PASS_UID);
                sapiAccount.username = jSONObject.optString("username");
                sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccount.bduss = jSONObject.optString("bduss");
                sapiAccount.ptoken = jSONObject.optString("ptoken");
                sapiAccount.stoken = jSONObject.optString("stoken");
                if (!TextUtils.isEmpty(optString) && SapiAccount.isValidAccount(sapiAccount) && SapiJsInterpreters.this.c.e != null) {
                    SapiJsInterpreters.this.c.e.onSuccess(optString, optString2, sapiAccount);
                    return null;
                }
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiJsInterpreters(SapiWebView sapiWebView, SapiJsCallBacks.CallBacks callBacks) {
        this.f4854a = sapiWebView;
        this.d = sapiWebView.getContext();
        this.c = callBacks;
    }

    private AbstractInterpreter b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (AbstractInterpreter) Class.forName(c(str)).getDeclaredConstructor(getClass()).newInstance(this);
        } catch (Exception e) {
            Log.e(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        String[] split = str.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractInterpreter a(String str) {
        AbstractInterpreter abstractInterpreter = this.e.get(str);
        if (abstractInterpreter == null && (abstractInterpreter = b(str)) != null) {
            this.e.put(str, abstractInterpreter);
        }
        return abstractInterpreter;
    }
}
