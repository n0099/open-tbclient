package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.widget.DatePicker;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.GetContactCallback;
import com.baidu.sapi2.callback.RequestSMSCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.contact.utils.GetContactHelper;
import com.baidu.sapi2.dto.GetContactDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetContactResult;
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
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes4.dex */
public class SapiJsInterpreters {
    private SapiWebView a;
    private SapiJsCallBacks.CallBacks c;
    private Context d;
    private long f;
    private HashMap<String, AbstractInterpreter> e = new HashMap<>();
    private SapiConfiguration b = SapiAccountManager.getInstance().getSapiConfiguration();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public abstract class AbstractInterpreter {
        AbstractInterpreter() {
        }

        public abstract String interpret(SapiWebView.Command command);
    }

    /* loaded from: classes4.dex */
    class ActionBindWidgetPhoneNumberExist extends AbstractInterpreter {
        ActionBindWidgetPhoneNumberExist() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.c.h != null) {
                SapiJsInterpreters.this.c.h.onPhoneNumberExist(str);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    class ActionForgetPwd extends AbstractInterpreter {
        ActionForgetPwd() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.c.E != null ? SapiJsInterpreters.this.c.E.onForgetPwd() : false ? "1" : "0";
        }
    }

    /* loaded from: classes4.dex */
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
            return SapiUtils.calculateSig(hashMap, SapiJsInterpreters.this.b.appSignKey);
        }
    }

    /* loaded from: classes4.dex */
    class ActionGetLoadtime extends AbstractInterpreter {
        ActionGetLoadtime() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView unused = SapiJsInterpreters.this.a;
            if (SapiWebView.statLoadLogin != null) {
                SapiWebView unused2 = SapiJsInterpreters.this.a;
                return SapiWebView.statLoadLogin.a().toString();
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ActionGetSmsCheckCodeFromClip extends AbstractInterpreter {
        ActionGetSmsCheckCodeFromClip() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        @TargetApi(11)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            String str = "";
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
                }
            } catch (Throwable th2) {
                th = th2;
            }
            SapiStatUtil.statSmsCodeClip(SapiJsInterpreters.this.d, !TextUtils.isEmpty(str) ? "0" : "1");
            return str;
        }
    }

    /* loaded from: classes4.dex */
    class ActionHuaweiLogin extends AbstractInterpreter {
        ActionHuaweiLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.a != null) {
                Message message = new Message();
                message.what = SocialType.HUAWEI.getType();
                message.obj = SocialType.HUAWEI;
                SapiJsInterpreters.this.c.a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
                List<ShareStorage.StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(SapiJsInterpreters.this.b.context);
                if (SapiJsInterpreters.this.c.s != null && shareStorageModel != null && shareStorageModel.size() > 0) {
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

    /* loaded from: classes4.dex */
    class ActionLoadExternalWebview extends AbstractInterpreter {
        ActionLoadExternalWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.i != null) {
                SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult = new SapiWebView.LoadExternalWebViewResult();
                loadExternalWebViewResult.defaultTitle = command.getActionParams().get(0);
                loadExternalWebViewResult.externalUrl = command.getActionParams().get(1);
                SapiJsInterpreters.this.c.i.loadExternalWebview(loadExternalWebViewResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ActionLoadSlideWebview extends AbstractInterpreter {
        ActionLoadSlideWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.x != null) {
                SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult = new SapiWebView.LoadSlideWebViewResult();
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    loadSlideWebViewResult.placeholderTitle = jSONObject.optString("placeholderTitle");
                    loadSlideWebViewResult.url = jSONObject.optString("url");
                    loadSlideWebViewResult.page = jSONObject.optString("page");
                    SapiJsInterpreters.this.c.x.loadSlideWebview(loadSlideWebViewResult);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("errno", "0");
                    return jSONObject2.toString();
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ActionReceivedSmsCode extends AbstractInterpreter {
        ActionReceivedSmsCode() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.a.a(SapiJsInterpreters.this.c.b);
            SapiJsInterpreters.this.c.b.a = command.getActionParams().get(0);
            SapiJsInterpreters.this.c.b.b = command.getActionParams().get(1);
            SapiJsInterpreters.this.c.b.postDelayed(SapiJsInterpreters.this.c.L, 15000L);
            return null;
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    class ActionSetTitle extends AbstractInterpreter {
        ActionSetTitle() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.c.c != null) {
                SapiJsInterpreters.this.c.c.onTitleChange(str);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ActionShareAccountsViewBtnClicked extends AbstractInterpreter {
        ActionShareAccountsViewBtnClicked() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.g != null) {
                SapiJsInterpreters.this.c.g.handleOtherLogin();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ActionShareClickOther extends AbstractInterpreter {
        ActionShareClickOther() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiStatUtil.statShareClickOther(command.getActionParams().get(0), SapiJsInterpreters.this.a.extras);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ActionShareV1AccountClick extends AbstractInterpreter {
        ActionShareV1AccountClick() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str;
            String str2;
            int i;
            int i2 = 0;
            String str3 = command.getActionParams().get(0);
            String str4 = "";
            String str5 = "";
            List<SapiAccount> shareAccounts = SapiAccountManager.getInstance().getShareAccounts();
            int i3 = 0;
            while (i2 < shareAccounts.size()) {
                if (str3.equals(shareAccounts.get(i2).uid)) {
                    str2 = shareAccounts.get(i2).getShareAccountTpl();
                    str = shareAccounts.get(i2).app;
                    i = i2;
                } else {
                    str = str5;
                    str2 = str4;
                    i = i3;
                }
                i2++;
                i3 = i;
                str4 = str2;
                str5 = str;
            }
            SapiStatUtil.statShareV1AccountClick(i3, str4, str5, SapiJsInterpreters.this.a.extras);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ActionShareV2Login extends AbstractInterpreter {
        ActionShareV2Login() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.c.W.pageParams.toString();
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    class ActionSocialMeizuSso extends AbstractInterpreter {
        ActionSocialMeizuSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.a != null) {
                Message message = new Message();
                message.what = SocialType.MEIZU.getType();
                message.obj = SocialType.MEIZU;
                SapiJsInterpreters.this.c.a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ActionSocialQqSso extends AbstractInterpreter {
        ActionSocialQqSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.a != null) {
                Message message = new Message();
                message.what = SocialType.QQ_SSO.getType();
                message.obj = SocialType.QQ_SSO;
                SapiJsInterpreters.this.c.a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ActionSocialSinaSso extends AbstractInterpreter {
        ActionSocialSinaSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.a != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO_SSO.getType();
                message.obj = SocialType.SINA_WEIBO_SSO;
                SapiJsInterpreters.this.c.a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ActionSocialWeixinSso extends AbstractInterpreter {
        ActionSocialWeixinSso() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.a != null) {
                Message message = new Message();
                message.what = SocialType.WEIXIN.getType();
                message.obj = SocialType.WEIXIN;
                SapiJsInterpreters.this.c.a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class AddressManageGetContact extends AbstractInterpreter {
        AddressManageGetContact() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            GetContactDTO getContactDTO = new GetContactDTO();
            getContactDTO.context = SapiJsInterpreters.this.a.getContext();
            GetContactHelper.getInstance().requestContact(getContactDTO, new GetContactCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.AddressManageGetContact.1
                public AlertDialogInterface getDialog(Activity activity) {
                    return SapiJsInterpreters.this.c.G.buildDialog(activity);
                }

                public void onCall(GetContactResult getContactResult) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("name", getContactResult.name);
                        jSONObject.put("phone", getContactResult.phone);
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                    SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class AddressManageGetPasteboard extends AbstractInterpreter {
        AddressManageGetPasteboard() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
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

    /* loaded from: classes4.dex */
    class AddressManageSelectedAddress extends AbstractInterpreter {
        AddressManageSelectedAddress() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.H != null && command.getActionParams().size() > 0) {
                SapiJsInterpreters.this.c.H.onCallback(command.getActionParams().get(0));
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException e) {
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
    class AuthorizedResponse extends AbstractInterpreter {
        AuthorizedResponse() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            int parseInt = command.getActionParams().size() >= 2 ? Integer.parseInt(command.getActionParams().get(1)) : 0;
            if (parseInt == 1) {
                SocialResponse b = SapiWebView.b(str, SapiJsInterpreters.this.d);
                if (b == null) {
                    if (SapiJsInterpreters.this.c.E != null) {
                        SapiJsInterpreters.this.a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.c.E != null) {
                                    SapiJsInterpreters.this.c.E.onFailed(-100, "登录失败");
                                }
                            }
                        });
                    }
                } else if (b.offlineNotice || b.bindGuide || b.errorCode == 21 || b.bindConflict) {
                    SapiJsInterpreters.this.c.Q = b;
                } else {
                    SapiJsInterpreters.this.a.a(b);
                }
            }
            if (parseInt == 0) {
                final SapiAccountResponse a = SapiJsInterpreters.this.a.a(str, SapiJsInterpreters.this.d);
                if (a == null) {
                    if (SapiJsInterpreters.this.c.E != null) {
                        SapiJsInterpreters.this.a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.c.E != null) {
                                    SapiJsInterpreters.this.c.E.onFailed(-100, "登录失败");
                                }
                            }
                        });
                        return null;
                    }
                    return null;
                }
                int i = a.errorCode;
                if (i == 0 || i == 110000) {
                    SapiJsInterpreters.this.a.a(a);
                    return null;
                } else if (SapiJsInterpreters.this.c.E != null) {
                    SapiJsInterpreters.this.a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiJsInterpreters.this.c.E != null) {
                                AuthorizationListener authorizationListener = SapiJsInterpreters.this.c.E;
                                SapiAccountResponse sapiAccountResponse = a;
                                authorizationListener.onFailed(sapiAccountResponse.errorCode, sapiAccountResponse.errorMsg);
                            }
                        }
                    });
                    return null;
                } else {
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class Back extends AbstractInterpreter {
        Back() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.a.back();
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class ConfigFastloginFeatures extends AbstractInterpreter {
        ConfigFastloginFeatures() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            List<FastLoginFeature> fastLoginFeatureList = SapiJsInterpreters.this.c.w != null ? SapiJsInterpreters.this.c.w.getFastLoginFeatureList() : null;
            List<FastLoginFeature> list = fastLoginFeatureList == null ? SapiJsInterpreters.this.b.fastLoginFeatureList : fastLoginFeatureList;
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
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(fastLoginFeature.getStrValue());
                    }
                    i = i2 + 1;
                } else {
                    return sb.toString();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    class ConfigLoginShareStrategy extends AbstractInterpreter {
        ConfigLoginShareStrategy() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.b.loginShareStrategy().getStrValue();
        }
    }

    /* loaded from: classes4.dex */
    class Finish extends AbstractInterpreter {
        Finish() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.a.a(SapiJsInterpreters.this.c.Q);
            if (command.getActionParams().size() > 0) {
                try {
                    SapiJsInterpreters.this.a.finish(new JSONObject(command.getActionParams().get(0)).optString("page"));
                } catch (JSONException e) {
                    Log.e(e);
                }
            } else {
                SapiJsInterpreters.this.a.finish();
            }
            if (SapiJsInterpreters.this.c.A != null) {
                SapiJsInterpreters.this.c.A.onFinish(command.getActionParams().size() > 0 ? command.getActionParams().get(0) : "");
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class GetAllClientAccounts extends AbstractInterpreter {
        GetAllClientAccounts() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            List<SapiAccount> shareAccounts;
            Object jSONArray;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException e) {
                Log.e(e);
            }
            List<SapiAccount> touchidAccounts = SapiContext.getInstance().getTouchidAccounts();
            try {
                JSONArray jSONArray2 = new JSONArray();
                boolean z = com.baidu.sapi2.c.h.a(SapiJsInterpreters.this.b) == 0;
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
                jSONObject.put("onekeyAccounts", new com.baidu.sapi2.outsdk.c().b());
            } catch (Exception e3) {
                Log.e(e3);
            }
            try {
                jSONObject.put("faceAccounts", SapiContext.getInstance().getV2FaceLoginCheckResults());
            } catch (Exception e4) {
                Log.e(e4);
            }
            try {
                List<ShareStorage.StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(SapiJsInterpreters.this.b.context);
                Object jSONArray3 = ShareStorage.StorageModel.toJSONArray(shareStorageModel);
                if (jSONArray3 != null) {
                    jSONObject.put("canshare2Accounts", jSONArray3);
                    SapiStatUtil.statShareV2Open(shareStorageModel, null, SapiJsInterpreters.this.a.extras);
                }
            } catch (Exception e5) {
                Log.e(e5);
            }
            try {
                if (!jSONObject.has("canshare2Accounts") && (jSONArray = SapiAccount.toJSONArray((shareAccounts = SapiAccountManager.getInstance().getShareAccounts()))) != null) {
                    jSONObject.put("canshare1Accounts", jSONArray);
                    SapiStatUtil.statShareV1OpenPage(shareAccounts, SapiJsInterpreters.this.a.extras);
                }
            } catch (Exception e6) {
                Log.e(e6);
            }
            try {
                jSONObject.put("recentLoginUid", SapiContext.getInstance().getDecryptStr(SapiContext.KEY_LAST_LOGIN_UID));
            } catch (JSONException e7) {
                Log.e(e7);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
    class GetPresetPhoneNumber extends AbstractInterpreter {
        GetPresetPhoneNumber() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.b.forbidPresetPhoneNumber) {
                return "";
            }
            if (SapiUtils.isValidPhoneNumber(SapiJsInterpreters.this.b.presetPhoneNumber)) {
                return SapiJsInterpreters.this.b.presetPhoneNumber;
            }
            String localPhoneNumber = SapiJsInterpreters.this.a.getLocalPhoneNumber();
            return !SapiUtils.isValidPhoneNumber(localPhoneNumber) ? "" : localPhoneNumber;
        }
    }

    /* loaded from: classes4.dex */
    class InvoiceBuildSelectedInvoice extends AbstractInterpreter {
        InvoiceBuildSelectedInvoice() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.I != null && command.getActionParams().size() > 0) {
                SapiJsInterpreters.this.c.I.onCallback(command.getActionParams().get(0));
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException e) {
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
    class NormalizeGuestAccount extends AbstractInterpreter {
        NormalizeGuestAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                int optInt = jSONObject.optInt("errno");
                String optString = jSONObject.optString("msg");
                if (optInt != 0) {
                    if (SapiJsInterpreters.this.c.z != null) {
                        SapiJsInterpreters.this.c.z.onFailure(optInt, optString);
                    }
                } else {
                    boolean z = jSONObject.optInt("merge") == 1;
                    String optString2 = jSONObject.optString("normalizeWay");
                    SapiAccountResponse a = SapiJsInterpreters.this.a.a(jSONObject.optString("xml"), SapiJsInterpreters.this.d);
                    if (a == null) {
                        if (SapiJsInterpreters.this.c.z != null) {
                            SapiJsInterpreters.this.c.z.onFailure(NormalizeGuestAccountResult.ERROR_CODE_PARSE_XML, NormalizeGuestAccountResult.ERROR_MSG_PARSE_XML);
                        }
                    } else {
                        SapiAccount b = SapiJsInterpreters.this.a.b(a);
                        if (!SapiUtils.isValidAccount(b)) {
                            SapiJsInterpreters.this.c.z.onFailure(-202, "网络连接失败，请检查网络设置");
                        } else {
                            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                            if (currentAccount != null) {
                                b.addSocialInfo(currentAccount.getSocialType(), currentAccount.getSocialPortrait());
                            }
                            SapiAccountManager.getInstance().removeLoginAccount(currentAccount);
                            SapiAccountManager.getInstance().validate(b);
                            if (SapiJsInterpreters.this.c.z != null) {
                                SapiJsInterpreters.this.c.z.onSuccess(z, optString2);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                Log.e(e);
                if (SapiJsInterpreters.this.c.z != null) {
                    SapiJsInterpreters.this.c.z.onFailure(-202, "网络连接失败，请检查网络设置");
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class NormalizeGuestDescription extends AbstractInterpreter {
        NormalizeGuestDescription() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                if (!TextUtils.isEmpty(SapiJsInterpreters.this.c.S)) {
                    jSONObject.put("description", new JSONObject(SapiJsInterpreters.this.c.S));
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    class RealNameVerifySucceed extends AbstractInterpreter {
        RealNameVerifySucceed() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.n != null) {
                SapiJsInterpreters.this.c.n.onSuccess();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionAccountCenterFastloginFeatures extends AbstractInterpreter {
        SapiActionAccountCenterFastloginFeatures() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            ArrayList arrayList = new ArrayList();
            if (SapiJsInterpreters.this.b.fastLoginFeatureList == null || SapiJsInterpreters.this.b.fastLoginFeatureList.isEmpty()) {
                return null;
            }
            arrayList.addAll(SapiJsInterpreters.this.b.fastLoginFeatureList);
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
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(fastLoginFeature.getStrValue());
                    }
                    i = i2 + 1;
                } else {
                    return sb.toString();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionAccountDestroy extends AbstractInterpreter {
        SapiActionAccountDestroy() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.q != null) {
                SapiJsInterpreters.this.c.q.onAccountDestory(new SapiWebView.AccountDestoryCallback.AccountDestoryResult());
            }
            SapiJsInterpreters.this.a.finish();
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionAccountFreeze extends AbstractInterpreter {
        SapiActionAccountFreeze() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.r != null) {
                SapiJsInterpreters.this.c.r.onAccountFreeze(new SapiWebView.AccountFreezeCallback.AccountFreezeResult());
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionBdussChanged extends AbstractInterpreter {
        SapiActionBdussChanged() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.k != null) {
                SapiJsInterpreters.this.c.k.onBdussChange();
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

    /* loaded from: classes4.dex */
    class SapiActionCheckLoginStatus extends AbstractInterpreter {
        SapiActionCheckLoginStatus() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (SapiJsInterpreters.this.c.C != null) {
                    jSONObject.put("sup", true);
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionCheckMethodSupport extends AbstractInterpreter {
        SapiActionCheckMethodSupport() {
            super();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
            if (r5.b.b.supportFaceLogin != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
            if (r5.b.b.supportFaceLogin != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
            if (r5.b.c.v != null) goto L11;
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
                if (SapiJsInterpreters.this.c.d != null) {
                }
                z2 = false;
            } else if (str.equals("sapi_biometrics_identification") || str.equals("sapi_biometrics_identification_no_bduss") || str.equals("sapi_biometrics_identification_with_authtoken")) {
                if (SapiJsInterpreters.this.c.e != null) {
                }
                z2 = false;
            } else if (!str.equals("sapi_action_sc_app_check")) {
                z2 = z;
            }
            return z2 ? "1" : "0";
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionChinaMobileOauth extends AbstractInterpreter {
        SapiActionChinaMobileOauth() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            new com.baidu.sapi2.outsdk.c().a(SapiJsInterpreters.this.b, new c.a() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionChinaMobileOauth.1
                @Override // com.baidu.sapi2.outsdk.c.a
                public void onGetTokenComplete(JSONObject jSONObject) {
                    SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionCoverWebBduss extends AbstractInterpreter {
        SapiActionCoverWebBduss() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String cookieBduss = SapiUtils.getCookieBduss();
            if (SapiJsInterpreters.this.c.o != null) {
                SapiJsInterpreters.this.c.o.onCoverBduss(cookieBduss, new SapiWebView.CoverWebBdussResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionCoverWebBduss.1
                    @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussResult
                    public void setWebBduss(String str) {
                        SapiJsInterpreters.this.a.a(SapiJsInterpreters.this.d, str);
                        SapiJsInterpreters.this.a.reload();
                    }
                });
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
                if (SapiJsInterpreters.this.c.p != null) {
                    SapiJsInterpreters.this.c.p.onPreFillUserName(preFillUserNameResult);
                }
                if (equals) {
                    SapiJsInterpreters.this.a.finish();
                    return null;
                }
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
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
                jSONObject.put("errno", 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionGetAppTpl extends AbstractInterpreter {
        SapiActionGetAppTpl() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.b.getTpl();
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionGetDeviceAuthToken extends AbstractInterpreter {
        SapiActionGetDeviceAuthToken() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = null;
            try {
                boolean z = !new JSONObject(command.getActionParams().get(0)).optBoolean("is_only_outside_get_token", true);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_outside_company", "0");
                jSONObject.put("errno", 0);
                if (z) {
                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    jSONObject.put("once_token", SapiAccountManager.getInstance().getDeviceAuthToken(SapiJsInterpreters.this.d, currentAccount == null ? null : currentAccount.uid, 122));
                }
                str = jSONObject.toString();
                return str;
            } catch (JSONException e) {
                Log.e(e);
                return str;
            }
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionHandleBackButton extends AbstractInterpreter {
        SapiActionHandleBackButton() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.N = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.c.m != null) {
                SapiJsInterpreters.this.c.m.onLeftBtnVisible(SapiJsInterpreters.this.c.N);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionHideSuccessTip extends AbstractInterpreter {
        SapiActionHideSuccessTip() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hideTip", SapiJsInterpreters.this.c.U ? "1" : "0");
                jSONObject.put("errno", 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionLastLoginType extends AbstractInterpreter {
        SapiActionLastLoginType() {
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

    /* loaded from: classes4.dex */
    class SapiActionLoginStatusChange extends AbstractInterpreter {
        SapiActionLoginStatusChange() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.C != null) {
                SapiJsInterpreters.this.c.C.onChange();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                calendar.setTime(new SimpleDateFormat(DateTimeUtil.DAY_FORMAT).parse(str));
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

    /* loaded from: classes4.dex */
    class SapiActionPickImage extends AbstractInterpreter {
        SapiActionPickImage() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int i;
            int i2 = 0;
            int i3 = 1;
            try {
                i2 = Integer.parseInt(command.getActionParams().get(0));
            } catch (Exception e) {
                Log.e(e);
            }
            if (command.getActionParams().size() > 1) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                    i3 = jSONObject.optInt("sence", 1);
                    try {
                        i = jSONObject.optInt(TiebaInitialize.LogFields.SIZE, 512);
                    } catch (JSONException e2) {
                        e = e2;
                        Log.e(e);
                        i = 512;
                        SapiJsInterpreters.this.c.j.onPickImage(i2, i3, i, new SapiWebView.PickPhotoResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickImage.1
                            @Override // com.baidu.sapi2.SapiWebView.PickPhotoResult
                            public void setImageData(String str) {
                                if (SapiJsInterpreters.this.c.M != null) {
                                    SapiJsInterpreters.this.c.M.confirm(str);
                                }
                            }
                        });
                        return null;
                    }
                } catch (JSONException e3) {
                    e = e3;
                }
            } else {
                i = 512;
            }
            SapiJsInterpreters.this.c.j.onPickImage(i2, i3, i, new SapiWebView.PickPhotoResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickImage.1
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

    /* loaded from: classes4.dex */
    class SapiActionQrLogin extends AbstractInterpreter {
        SapiActionQrLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                if (SapiJsInterpreters.this.c.t != null) {
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
                    SapiJsInterpreters.this.c.t.loginStatusChange(optInt == 1);
                }
                if (SapiJsInterpreters.this.c.O) {
                    SapiJsInterpreters.this.a.finish();
                    return null;
                }
                return null;
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (SapiJsInterpreters.this.c.B != null) {
                    if (optInt == 1) {
                        accountRealNameResult.juniorRealNameSuc = true;
                    } else if (optInt == 2) {
                        accountRealNameResult.seniorRealNameSuc = true;
                    }
                    SapiJsInterpreters.this.c.B.onFinish(accountRealNameResult);
                    return null;
                }
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
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
                jSONObject2.put("state", new com.baidu.sapi2.b.a().a(SapiJsInterpreters.this.d, optString, SapiJsInterpreters.this.c.v));
                return jSONObject2.toString();
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
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
                SapiJsInterpreters.this.c.v.onInvokeScApp(optString, optString2, arrayList, new SapiWebView.InvokeScAppCallback.InvokeScAppResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionScAppInvoke.1
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

    /* loaded from: classes4.dex */
    class SapiActionSidAbility extends AbstractInterpreter {
        SapiActionSidAbility() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sidValue", SapiJsInterpreters.this.b.sidValue);
                jSONObject.put("errno", 0);
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionSwitchAccount extends AbstractInterpreter {
        SapiActionSwitchAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.l != null) {
                List<String> actionParams = command.getActionParams();
                if (actionParams != null && actionParams.size() > 0) {
                    if (actionParams.size() > 1) {
                        try {
                            JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                            SapiWebView.SwitchAccountCallback.Result result = new SapiWebView.SwitchAccountCallback.Result();
                            result.displayName = jSONObject.getString(SapiAccountManager.SESSION_DISPLAYNAME);
                            result.encryptedUid = jSONObject.getString("uid");
                            result.loginType = jSONObject.getInt("type");
                            result.switchAccountType = 2;
                            SapiJsInterpreters.this.c.l.onAccountSwitch(result);
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                    } else {
                        SapiWebView.SwitchAccountCallback.Result result2 = new SapiWebView.SwitchAccountCallback.Result();
                        result2.userName = actionParams.get(0);
                        result2.switchAccountType = 1;
                        SapiJsInterpreters.this.c.l.onAccountSwitch(result2);
                    }
                }
                SapiWebView.SwitchAccountCallback.Result result3 = new SapiWebView.SwitchAccountCallback.Result();
                result3.switchAccountType = 0;
                SapiJsInterpreters.this.c.l.onAccountSwitch(result3);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionUpdateNavigator extends AbstractInterpreter {
        SapiActionUpdateNavigator() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int parseInt = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.c.F != null) {
                SapiJsInterpreters.this.c.F.pageState(parseInt);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class SapiActionUpsms extends AbstractInterpreter {
        SapiActionUpsms() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            new SendUpwardSms(command.getActionParams().get(0), command.getActionParams().get(1), command.getActionParams().get(2), command.getActionParams().get(3), new SapiWebView.UpwardSmsCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionUpsms.1
                @Override // com.baidu.sapi2.SapiWebView.UpwardSmsCallback
                public void onResult(boolean z, boolean z2, boolean z3) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("with_permision", z);
                        jSONObject.put("send_suc", z2);
                        jSONObject.put(UgcUBCUtils.UGC_TIME_CANCEL, z3);
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                    SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                }
            }).c();
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
            if (SapiJsInterpreters.this.c.e != null) {
                SapiJsInterpreters.this.c.e.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
            if (SapiJsInterpreters.this.c.e != null) {
                SapiJsInterpreters.this.c.e.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
            if (SapiJsInterpreters.this.c.e != null) {
                SapiJsInterpreters.this.c.e.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class SapiBiometricsIdentificationWithUid extends AbstractInterpreter {
        SapiBiometricsIdentificationWithUid() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.d != null) {
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
                    SapiJsInterpreters.this.c.d.onBioScanFace(bioScanFaceResult);
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class SapiGoBack extends AbstractInterpreter {
        SapiGoBack() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.a.canGoBack()) {
                SapiJsInterpreters.this.a.goBack();
                return null;
            }
            SapiJsInterpreters.this.a.finish();
            return null;
        }
    }

    /* loaded from: classes4.dex */
    class SapiRemoveLoginHistory extends AbstractInterpreter {
        SapiRemoveLoginHistory() {
            super();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a8, code lost:
            com.baidu.sapi2.share.SapiShareClient.getInstance().invalidate(r0);
         */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
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

    /* loaded from: classes4.dex */
    class SapiShareAccountClick extends AbstractInterpreter {
        SapiShareAccountClick() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (System.currentTimeMillis() - SapiJsInterpreters.this.f > 1000) {
                SapiJsInterpreters.this.f = System.currentTimeMillis();
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    String optString = jSONObject.optString(Config.INPUT_DEF_PKG);
                    String optString2 = jSONObject.optString("url");
                    String optString3 = jSONObject.optString("trace_id");
                    String optString4 = jSONObject.optString("session_id");
                    SapiJsInterpreters.this.c.M.confirm("finish");
                    SapiJsInterpreters.this.c.s.onClick(optString, optString2, optString3, optString4);
                } catch (Exception e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private class SendUpwardSms {
        static final String a = "收不到短信验证码?";
        static final String b = "我们邀请您发送一条短信至百度账号后台（10698000036592）以验证您的身份，预计花费0.1元短信费用";
        static final String c = "确定";
        static final String d = "发送上行短信";
        static final String e = "10698000036592";
        static final String f = "SENT_SMS_ACTION";
        String g;
        String h;
        String i;
        String j;
        SapiWebView.UpwardSmsCallback k;
        boolean l;
        boolean m;
        Runnable n;
        private BroadcastReceiver o;

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (SapiJsInterpreters.this.c.u != null) {
                SapiWebView.SystemUpwardSmsCallback.Result result = new SapiWebView.SystemUpwardSmsCallback.Result() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.6
                    @Override // com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback.Result
                    public void onFinish() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("with_permision", false);
                            jSONObject.put("send_suc", false);
                            jSONObject.put(UgcUBCUtils.UGC_TIME_CANCEL, false);
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                        if (SapiJsInterpreters.this.c.M != null) {
                            SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                        }
                        SendUpwardSms sendUpwardSms = SendUpwardSms.this;
                        sendUpwardSms.k.onResult(sendUpwardSms.l, sendUpwardSms.m, false);
                    }
                };
                result.content = this.h;
                result.destination = this.g;
                SapiJsInterpreters.this.c.u.onResult(result);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            if (this.o != null) {
                try {
                    SapiJsInterpreters.this.d.unregisterReceiver(this.o);
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
        }

        private SendUpwardSms(String str, String str2, String str3, String str4, SapiWebView.UpwardSmsCallback upwardSmsCallback) {
            this.l = false;
            this.m = false;
            this.n = new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.1
                @Override // java.lang.Runnable
                public void run() {
                    SendUpwardSms.this.e();
                    SendUpwardSms.this.d();
                }
            };
            this.o = new BroadcastReceiver() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    SapiJsInterpreters.this.a.removeCallbacks(SendUpwardSms.this.n);
                    SendUpwardSms.this.e();
                    if (getResultCode() != -1) {
                        SendUpwardSms.this.d();
                        return;
                    }
                    SendUpwardSms sendUpwardSms = SendUpwardSms.this;
                    sendUpwardSms.l = true;
                    sendUpwardSms.m = true;
                    sendUpwardSms.k.onResult(sendUpwardSms.l, sendUpwardSms.m, false);
                }
            };
            if (TextUtils.isEmpty(str)) {
                this.g = "10698000036592";
            } else {
                this.g = str;
            }
            if (TextUtils.isEmpty(str2)) {
                this.h = d;
            } else {
                this.h = str2;
            }
            if (TextUtils.isEmpty(str3)) {
                this.i = a;
            } else {
                this.i = str3;
            }
            if (TextUtils.isEmpty(str4)) {
                this.j = b;
            } else {
                this.j = str4;
            }
            this.k = upwardSmsCallback;
        }

        private String b() {
            return this.j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (Build.VERSION.SDK_INT < 23 && SapiJsInterpreters.this.d.checkCallingOrSelfPermission("android.permission.SEND_SMS") == -1) {
                d();
            } else {
                a();
            }
        }

        @TargetApi(11)
        private void a() {
            AlertDialog.Builder builder = new AlertDialog.Builder(SapiJsInterpreters.this.d, 3);
            builder.setTitle(this.i);
            builder.setMessage(b());
            builder.setPositiveButton(c, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SendUpwardSms.this.a(new RequestSMSCallback() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.3.1
                        @Override // com.baidu.sapi2.callback.RequestSMSCallback
                        public void sendSmsResult(boolean z) {
                            if (z) {
                                return;
                            }
                            SendUpwardSms.this.d();
                        }
                    });
                }
            });
            builder.setNegativeButton(PayHelper.STATUS_CANCEL_DESC, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SendUpwardSms.this.k.onResult(false, false, true);
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    SendUpwardSms.this.k.onResult(false, false, true);
                }
            });
            AlertDialog create = builder.create();
            if (((Activity) SapiJsInterpreters.this.d).isFinishing() || create.isShowing()) {
                return;
            }
            create.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(RequestSMSCallback requestSMSCallback) {
            Intent intent = new Intent(f);
            intent.setPackage(SapiJsInterpreters.this.d.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(SapiJsInterpreters.this.d, 0, intent, 0);
            SapiJsInterpreters.this.d.registerReceiver(this.o, new IntentFilter(f));
            com.baidu.sapi2.utils.e.a(SapiJsInterpreters.this.a.getContext(), this.g, this.h, broadcast, null, requestSMSCallback);
        }
    }

    /* loaded from: classes4.dex */
    class SpeechRecognitionGetContent extends AbstractInterpreter {
        SpeechRecognitionGetContent() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.y.onSpeechRecognition(new SapiJsCallBacks.SpeechRecognitionResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SpeechRecognitionGetContent.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionResult
                public void setSpeechData(int i, String str) {
                    if (SapiJsInterpreters.this.c.M != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", i);
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

    /* loaded from: classes4.dex */
    class TouchidChangeStatus extends AbstractInterpreter {
        TouchidChangeStatus() {
            super();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [7=4] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
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
                str2 = jSONObject2.optString("handle");
                try {
                    str = jSONObject2.optString("portrait");
                } catch (JSONException e) {
                    e = e;
                    str = null;
                }
                try {
                    str3 = jSONObject2.optString("portraitSign");
                } catch (JSONException e2) {
                    e = e2;
                    Log.e(e);
                    str3 = null;
                    final SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    currentAccount.phone = str;
                    if ("open".equals(str2)) {
                    }
                    return null;
                }
            } catch (JSONException e3) {
                e = e3;
                str = null;
                str2 = null;
            }
            final SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
            currentAccount2.phone = str;
            if ("open".equals(str2)) {
                currentAccount2.email = "";
                SapiContext.getInstance().addTouchidAccounts(currentAccount2);
                SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
            } else {
                currentAccount2.email = str3;
                SapiJsCallBacks.FingerprintResult fingerprintResult = new SapiJsCallBacks.FingerprintResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.TouchidChangeStatus.1
                    @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintResult
                    public void setResult(int i) {
                        try {
                            jSONObject.put("status", i);
                            if (i == 0) {
                                SapiContext.getInstance().addTouchidAccounts(currentAccount2);
                            }
                            SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                        } catch (Exception e4) {
                            Log.e(e4);
                        }
                    }
                };
                if (SapiJsInterpreters.this.c.J != null) {
                    SapiJsInterpreters.this.c.J.onCallback(fingerprintResult);
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
                int a = com.baidu.sapi2.c.h.a(SapiJsInterpreters.this.b);
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
                int i = (a != 0 || contains) ? 0 : 1;
                if (!SapiJsInterpreters.this.a.supportTouchGuide) {
                    i = 0;
                }
                if (z) {
                    i = 0;
                }
                jSONObject.put("errno", 0);
                jSONObject.put("guide", i);
                if (TextUtils.isEmpty(optString)) {
                    str = "100";
                } else if (a != 101 && a != 102) {
                    if (contains) {
                        str = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
                    } else if (SapiJsInterpreters.this.a.supportTouchGuide) {
                        str = z ? TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP : a + "";
                    } else {
                        str = TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT;
                    }
                } else {
                    str = a + "";
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                linkedHashMap.put("native_guide_finger", str);
                com.baidu.sapi2.utils.r.a(linkedHashMap);
                if (i == 1) {
                    SapiContext.getInstance().addTouchidLoginRecord(optString);
                }
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
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
                if (com.baidu.sapi2.c.h.a(SapiJsInterpreters.this.b) == 0) {
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
                jSONObject.put("errno", 0);
                jSONObject.put("status", i);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
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
                        jSONObject.put("errno", 0);
                        jSONObject.put("status", i);
                        SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                    } catch (Exception e) {
                        Log.e(e);
                    }
                }
            };
            fingerprintResult.authType = 3;
            if (SapiJsInterpreters.this.c.J != null) {
                SapiJsInterpreters.this.c.J.onCallback(fingerprintResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
                        jSONObject.put("errno", 0);
                        jSONObject.put("status", i);
                        SapiJsInterpreters.this.c.M.confirm(jSONObject.toString());
                        if (i == 0) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(command.getActionParams().get(0));
                                String optString = jSONObject2.optString("portrait");
                                String optString2 = jSONObject2.optString("portraitSign");
                                if (TextUtils.isEmpty(optString)) {
                                    SapiJsInterpreters.this.c.K[0] = SapiJsInterpreters.this.b.environment.getConfigHttpsUrl() + com.baidu.sapi2.utils.f.D;
                                    SapiJsInterpreters.this.a.touchidPortraitAndSign[0] = SapiJsInterpreters.this.b.environment.getConfigHttpsUrl() + com.baidu.sapi2.utils.f.D;
                                } else {
                                    SapiJsInterpreters.this.c.K[0] = optString;
                                    SapiJsInterpreters.this.a.touchidPortraitAndSign[0] = optString;
                                }
                                SapiJsInterpreters.this.c.K[1] = optString2;
                                SapiJsInterpreters.this.a.touchidPortraitAndSign[1] = optString2;
                            } catch (Exception e) {
                                Log.e(e);
                            }
                        }
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
            };
            if (SapiJsInterpreters.this.c.J != null) {
                SapiJsInterpreters.this.c.J.onCallback(fingerprintResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
                if (!TextUtils.isEmpty(optString) && SapiUtils.isValidAccount(sapiAccount) && SapiJsInterpreters.this.c.f != null) {
                    SapiJsInterpreters.this.c.f.onSuccess(optString, optString2, sapiAccount);
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
        this.a = sapiWebView;
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
