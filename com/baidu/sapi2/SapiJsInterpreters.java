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
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.a.c;
import com.baidu.sapi2.a.e;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.a.c;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SapiJsInterpreters {
    private SapiWebView a;
    private SapiJsCallBacks.CallBacks c;
    private Context d;
    private long f;
    private HashMap<String, AbstractInterpreter> e = new HashMap<>();
    private SapiConfiguration b = SapiAccountManager.getInstance().getSapiConfiguration();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiJsInterpreters(SapiWebView sapiWebView, SapiJsCallBacks.CallBacks callBacks) {
        this.a = sapiWebView;
        this.d = sapiWebView.getContext();
        this.c = callBacks;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractInterpreter a(String str) {
        AbstractInterpreter abstractInterpreter = this.e.get(str);
        if (abstractInterpreter == null && (abstractInterpreter = b(str)) != null) {
            this.e.put(str, abstractInterpreter);
        }
        return abstractInterpreter;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class AbstractInterpreter {
        public abstract String interpret(SapiWebView.Command command);

        AbstractInterpreter() {
        }
    }

    /* loaded from: classes.dex */
    class ActionSetTitle extends AbstractInterpreter {
        ActionSetTitle() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.c.e != null) {
                SapiJsInterpreters.this.c.e.onTitleChange(str);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiActionCheckMethodSupport extends AbstractInterpreter {
        SapiActionCheckMethodSupport() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
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
                if (SapiJsInterpreters.this.c.f == null || !SapiJsInterpreters.this.b.supportFaceLogin) {
                    z2 = false;
                }
            } else if (str.equals("sapi_biometrics_identification") || str.equals("sapi_biometrics_identification_no_bduss") || str.equals("sapi_biometrics_identification_with_authtoken")) {
                if (SapiJsInterpreters.this.c.g == null || !SapiJsInterpreters.this.b.supportFaceLogin) {
                    z2 = false;
                }
            } else if (!str.equals("sapi_action_sc_app_check")) {
                z2 = z;
            } else if (SapiJsInterpreters.this.c.x == null) {
                z2 = false;
            }
            return z2 ? "1" : "0";
        }
    }

    /* loaded from: classes.dex */
    class ConfigFastloginFeatures extends AbstractInterpreter {
        ConfigFastloginFeatures() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            List<FastLoginFeature> fastLoginFeatureList = SapiJsInterpreters.this.c.y != null ? SapiJsInterpreters.this.c.y.getFastLoginFeatureList() : null;
            List<FastLoginFeature> list = fastLoginFeatureList == null ? SapiJsInterpreters.this.b.fastLoginFeatureList : fastLoginFeatureList;
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance(SapiJsInterpreters.this.d).isHostsHijacked()) {
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    class ConfigLoginShareStrategy extends AbstractInterpreter {
        ConfigLoginShareStrategy() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.b.loginShareStrategy().getStrValue();
        }
    }

    /* loaded from: classes.dex */
    class ConfigCanshareAccounts extends AbstractInterpreter {
        ConfigCanshareAccounts() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            List<SapiAccount> shareAccounts = SapiAccountManager.getInstance().getShareAccounts();
            JSONArray jSONArray = SapiAccount.toJSONArray(shareAccounts);
            SapiStatUtil.statShareV1OpenPage(shareAccounts, SapiJsInterpreters.this.a.extras);
            if (jSONArray == null) {
                return null;
            }
            return jSONArray.toString();
        }
    }

    /* loaded from: classes.dex */
    class ActionRemoveShareAccount extends AbstractInterpreter {
        ActionRemoveShareAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (!TextUtils.isEmpty(str)) {
                for (SapiAccount sapiAccount : SapiAccountManager.getInstance().getShareAccounts()) {
                    if (str.equals(sapiAccount.uid)) {
                        com.baidu.sapi2.share.a.a().b(sapiAccount);
                        return null;
                    }
                }
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class ConfigCanshareVersion2Accounts extends AbstractInterpreter {
        ConfigCanshareVersion2Accounts() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            List<ShareStorage.StorageModel> a = com.baidu.sapi2.share.a.a().a(SapiJsInterpreters.this.b.context);
            SapiStatUtil.statShareV2Open(a, null, SapiJsInterpreters.this.a.extras);
            JSONArray jSONArray = ShareStorage.StorageModel.toJSONArray(a);
            if (jSONArray == null) {
                return null;
            }
            return jSONArray.toString();
        }
    }

    /* loaded from: classes.dex */
    class UniteVerifyResult extends AbstractInterpreter {
        UniteVerifyResult() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString(Config.LAUNCH_INFO);
                String optString2 = jSONObject.optString("u");
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = jSONObject.optString("passuid");
                sapiAccount.username = jSONObject.optString(LoginActivity.EXTRA_PARAM_USERNAME);
                sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccount.bduss = jSONObject.optString("bduss");
                sapiAccount.ptoken = jSONObject.optString("ptoken");
                sapiAccount.stoken = jSONObject.optString("stoken");
                if (!TextUtils.isEmpty(optString) && SapiUtils.isValidAccount(sapiAccount) && SapiJsInterpreters.this.c.h != null) {
                    SapiJsInterpreters.this.c.h.onSuccess(optString, optString2, sapiAccount);
                    return null;
                }
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    class ActionShareAccountsViewBtnClicked extends AbstractInterpreter {
        ActionShareAccountsViewBtnClicked() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.i != null) {
                SapiJsInterpreters.this.c.i.handleOtherLogin();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class ActionBindWidgetPhoneNumberExist extends AbstractInterpreter {
        ActionBindWidgetPhoneNumberExist() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.c.j != null) {
                SapiJsInterpreters.this.c.j.onPhoneNumberExist(str);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    class ActionFastReg extends AbstractInterpreter {
        ActionFastReg() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.b != null) {
                SapiJsInterpreters.this.c.b.handleFastReg();
                return null;
            }
            SapiJsInterpreters.this.a.loadFastReg();
            return null;
        }
    }

    /* loaded from: classes.dex */
    class ActionForgetPwd extends AbstractInterpreter {
        ActionForgetPwd() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            boolean z = false;
            if (SapiJsInterpreters.this.c.D != null) {
                z = SapiJsInterpreters.this.c.D.onForgetPwd();
            }
            return z ? "1" : "0";
        }
    }

    /* loaded from: classes.dex */
    class ActionReceivedSmsCode extends AbstractInterpreter {
        ActionReceivedSmsCode() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.a.a(SapiJsInterpreters.this.c.c);
            SapiJsInterpreters.this.c.c.a = command.getActionParams().get(0);
            SapiJsInterpreters.this.c.c.b = command.getActionParams().get(1);
            SapiJsInterpreters.this.c.c.postDelayed(SapiJsInterpreters.this.c.F, 15000L);
            return null;
        }
    }

    /* loaded from: classes.dex */
    class GetPresetPhoneNumber extends AbstractInterpreter {
        GetPresetPhoneNumber() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (!SapiJsInterpreters.this.b.forbidPresetPhoneNumber) {
                if (SapiUtils.isValidPhoneNumber(SapiJsInterpreters.this.b.presetPhoneNumber)) {
                    return SapiJsInterpreters.this.b.presetPhoneNumber;
                }
                String a = SapiJsInterpreters.this.a.a();
                return !SapiUtils.isValidPhoneNumber(a) ? "" : a;
            }
            return "";
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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
                    SapiJsInterpreters.this.c.G.confirm(i7 + String.format("%02d", Integer.valueOf(i8 + 1)) + String.format("%02d", Integer.valueOf(i9)) + "");
                }
            }, i, i2, i3);
            datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    SapiJsInterpreters.this.c.G.confirm("");
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

    /* loaded from: classes.dex */
    class ActionLoadExternalWebview extends AbstractInterpreter {
        ActionLoadExternalWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.k != null) {
                SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult = new SapiWebView.LoadExternalWebViewResult();
                loadExternalWebViewResult.defaultTitle = command.getActionParams().get(0);
                loadExternalWebViewResult.externalUrl = command.getActionParams().get(1);
                SapiJsInterpreters.this.c.k.loadExternalWebview(loadExternalWebViewResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiActionPickImage extends AbstractInterpreter {
        SapiActionPickImage() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int i;
            try {
                i = Integer.parseInt(command.getActionParams().get(0));
            } catch (Exception e) {
                Log.e(e);
                i = 0;
            }
            SapiJsInterpreters.this.c.l.onPickImage(i, new SapiWebView.PickPhotoResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickImage.1
                @Override // com.baidu.sapi2.SapiWebView.PickPhotoResult
                public void setImageData(String str) {
                    if (SapiJsInterpreters.this.c.G != null) {
                        SapiJsInterpreters.this.c.G.confirm(str);
                    }
                }
            });
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiActionBdussChanged extends AbstractInterpreter {
        SapiActionBdussChanged() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.m != null) {
                SapiJsInterpreters.this.c.m.onBdussChange();
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
                    public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, true);
            }
            new PtokenStat().onEvent(PtokenStat.SAPI_ACTION_BDUSS_CHANGED);
            return null;
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    class SapiActionSwitchAccount extends AbstractInterpreter {
        SapiActionSwitchAccount() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.n != null) {
                List<String> actionParams = command.getActionParams();
                if (actionParams != null && actionParams.size() > 0) {
                    SapiWebView.SwitchAccountCallback.Result result = new SapiWebView.SwitchAccountCallback.Result();
                    result.userName = actionParams.get(0);
                    try {
                        if (!SapiWebView.SwitchAccountCallback.class.equals(SapiJsInterpreters.this.c.n.getClass().getMethod("onAccountSwitch", SapiWebView.SwitchAccountCallback.Result.class).getDeclaringClass())) {
                            SapiJsInterpreters.this.c.n.onAccountSwitch(result);
                        }
                    } catch (NoSuchMethodException e) {
                        Log.e(e);
                    }
                }
                SapiJsInterpreters.this.c.n.onAccountSwitch();
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiBiometricsIdentification extends AbstractInterpreter {
        SapiBiometricsIdentification() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentification.1
                @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.c.G != null) {
                        SapiJsInterpreters.this.c.G.confirm(str);
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
            if (SapiJsInterpreters.this.c.g != null) {
                SapiJsInterpreters.this.c.g.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiBiometricsIdentificationNoBduss extends AbstractInterpreter {
        SapiBiometricsIdentificationNoBduss() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationNoBduss.1
                @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.c.G != null) {
                        SapiJsInterpreters.this.c.G.confirm(str);
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
            if (SapiJsInterpreters.this.c.g != null) {
                SapiJsInterpreters.this.c.g.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiBiometricsIdentificationWithAuthtoken extends AbstractInterpreter {
        SapiBiometricsIdentificationWithAuthtoken() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationWithAuthtoken.1
                @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.c.G != null) {
                        SapiJsInterpreters.this.c.G.confirm(str);
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
            if (SapiJsInterpreters.this.c.g != null) {
                SapiJsInterpreters.this.c.g.onBiometricsIdentify(biometricsIdentifyResult);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiActionHandleBackButton extends AbstractInterpreter {
        SapiActionHandleBackButton() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.H = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.c.o != null) {
                SapiJsInterpreters.this.c.o.onLeftBtnVisible(SapiJsInterpreters.this.c.H);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class RealNameVerifySucceed extends AbstractInterpreter {
        RealNameVerifySucceed() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.p != null) {
                SapiJsInterpreters.this.c.p.onSuccess();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiActionCoverWebBduss extends AbstractInterpreter {
        SapiActionCoverWebBduss() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String cookieBduss = SapiUtils.getCookieBduss();
            if (SapiJsInterpreters.this.c.q != null) {
                SapiJsInterpreters.this.c.q.onCoverBduss(cookieBduss, new SapiWebView.CoverWebBdussResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionCoverWebBduss.1
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

    /* loaded from: classes.dex */
    class SapiActionGetAppTpl extends AbstractInterpreter {
        SapiActionGetAppTpl() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.b.getTpl();
        }
    }

    /* loaded from: classes.dex */
    class SapiKefuIn extends AbstractInterpreter {
        SapiKefuIn() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.I = true;
            return null;
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    class SapiActionDeliverParams extends AbstractInterpreter {
        SapiActionDeliverParams() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString(LoginActivity.EXTRA_PARAM_USERNAME);
                boolean equals = jSONObject.optString("close", "0").equals("1");
                SapiWebView.PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult = new SapiWebView.PreFillUserNameCallback.PreFillUserNameResult();
                preFillUserNameResult.userName = optString;
                if (SapiJsInterpreters.this.c.r != null) {
                    SapiJsInterpreters.this.c.r.onPreFillUserName(preFillUserNameResult);
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

    /* loaded from: classes.dex */
    class GetFaceLoginInfo extends AbstractInterpreter {
        GetFaceLoginInfo() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                String v2FaceLoginCheckResults = SapiContext.getInstance(SapiJsInterpreters.this.d).getV2FaceLoginCheckResults();
                Log.e(Log.TAG, "v2FaceLoginCheckResults", v2FaceLoginCheckResults);
                com.baidu.sapi2.share.a.a aVar = new com.baidu.sapi2.share.a.a();
                aVar.a(v2FaceLoginCheckResults);
                if (!TextUtils.isEmpty(aVar.b)) {
                    jSONObject.put("livinguname", aVar.b);
                    jSONObject.put("queryRes", aVar.c);
                }
            } catch (JSONException e) {
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes.dex */
    class GetFaceLoginListInfo extends AbstractInterpreter {
        GetFaceLoginListInfo() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String v2FaceLoginCheckResults = SapiContext.getInstance(SapiJsInterpreters.this.d).getV2FaceLoginCheckResults();
            Log.e(Log.TAG, "v2FaceLoginCheckResults", v2FaceLoginCheckResults);
            return v2FaceLoginCheckResults;
        }
    }

    /* loaded from: classes.dex */
    class SapiActionAccountDestroy extends AbstractInterpreter {
        SapiActionAccountDestroy() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.s != null) {
                SapiJsInterpreters.this.c.s.onAccountDestory(new SapiWebView.AccountDestoryCallback.AccountDestoryResult());
            }
            SapiJsInterpreters.this.a.finish();
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiActionAccountFreeze extends AbstractInterpreter {
        SapiActionAccountFreeze() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.t != null) {
                SapiJsInterpreters.this.c.t.onAccountFreeze(new SapiWebView.AccountFreezeCallback.AccountFreezeResult());
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiBiometricsIdentificationWithUid extends AbstractInterpreter {
        SapiBiometricsIdentificationWithUid() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.f != null) {
                SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult = new SapiWebView.BioScanFaceCallback.BioScanFaceResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationWithUid.1
                    @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback.BioScanFaceResult
                    public void setScanFaceIdentifyResult(String str) {
                        android.util.Log.i("dragon", str);
                        SapiJsInterpreters.this.c.G.confirm(str);
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
                    SapiJsInterpreters.this.c.f.onBioScanFace(bioScanFaceResult);
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
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
                    SapiJsInterpreters.this.c.G.confirm("finish");
                    SapiJsInterpreters.this.c.u.onClick(optString, optString2, optString3, optString4);
                } catch (Exception e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    class SapiActionQrLogin extends AbstractInterpreter {
        SapiActionQrLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                if (SapiJsInterpreters.this.c.v != null) {
                    int optInt = jSONObject.optInt("relogin", -1);
                    if (optInt == 1) {
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        String optString = jSONObject.optString("bduss");
                        String optString2 = jSONObject.optString("ptoken");
                        if (session != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            session.bduss = optString;
                            session.ptoken = optString2;
                            session.deleteStokens();
                            SapiAccountManager.getInstance().validate(session);
                            SapiAccountManager.getInstance().preFetchStoken(session, true);
                        }
                    }
                    SapiJsInterpreters.this.c.v.loginStatusChange(optInt == 1);
                }
                if (SapiJsInterpreters.this.c.J) {
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

    /* loaded from: classes.dex */
    class SapiActionRelateWeixin extends AbstractInterpreter {
        SapiActionRelateWeixin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (new e().a(SapiJsInterpreters.this.b)) {
                SapiJsInterpreters.this.c.K = command.getActionParams().get(0);
                if (SapiJsInterpreters.this.c.d != null) {
                    Message message = new Message();
                    message.what = SocialType.WEIXIN.getType();
                    message.obj = SapiJsInterpreters.this.c.K;
                    SapiJsInterpreters.this.c.d.sendMessage(message);
                }
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error", SapiWebView.ErrorCode.WEIXIN_NOT_INTALL);
                jSONObject.put("errmsg", SapiWebView.DEFAULT_WEIXIN_NOT_INSTALL_ERROR);
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes.dex */
    class Finish extends AbstractInterpreter {
        Finish() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.a.a(SapiJsInterpreters.this.c.L);
            SapiJsInterpreters.this.a.finish();
            if (SapiJsInterpreters.this.c.A != null) {
                String str = "";
                if (command.getActionParams().size() > 0) {
                    str = command.getActionParams().get(0);
                }
                SapiJsInterpreters.this.c.A.onFinish(str);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SetPassCanceled extends AbstractInterpreter {
        SetPassCanceled() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.a.c(SapiJsInterpreters.this.c.M);
            return null;
        }
    }

    /* loaded from: classes.dex */
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
                    if (SapiJsInterpreters.this.c.D != null) {
                        SapiJsInterpreters.this.a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.c.D != null) {
                                    SapiJsInterpreters.this.c.D.onFailed(-100, "登录失败");
                                }
                            }
                        });
                    }
                } else if (b.offlineNotice || b.bindGuide || b.errorCode == 21 || b.bindConflict) {
                    SapiJsInterpreters.this.c.L = b;
                } else {
                    SapiJsInterpreters.this.a.a(b);
                }
            }
            if (parseInt == 0) {
                final SapiAccountResponse a = SapiJsInterpreters.this.a.a(str, SapiJsInterpreters.this.d);
                if (a == null) {
                    if (SapiJsInterpreters.this.c.D != null) {
                        SapiJsInterpreters.this.a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.c.D != null) {
                                    SapiJsInterpreters.this.c.D.onFailed(-100, "登录失败");
                                }
                            }
                        });
                        return null;
                    }
                    return null;
                } else if (SapiJsInterpreters.this.c.N != null && a.newReg) {
                    SapiJsInterpreters.this.c.M = a;
                    SapiJsInterpreters.this.a.a(a);
                    return null;
                } else if (a.errorCode == 0 || a.errorCode == 110000) {
                    SapiJsInterpreters.this.a.c(a);
                    return null;
                } else if (SapiJsInterpreters.this.c.D != null) {
                    SapiJsInterpreters.this.a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiJsInterpreters.this.c.D != null) {
                                SapiJsInterpreters.this.c.D.onFailed(a.errorCode, a.errorMsg);
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

    /* loaded from: classes.dex */
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
                        jSONObject.put("cancel", z3);
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                    SapiJsInterpreters.this.c.G.confirm(jSONObject.toString());
                }
            }).a();
            return null;
        }
    }

    /* loaded from: classes.dex */
    class ActionJoinLogin extends AbstractInterpreter {
        ActionJoinLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                Object[] pkgIconAndName = SapiUtils.getPkgIconAndName(SapiJsInterpreters.this.d, SapiJsInterpreters.this.d.getPackageName());
                jSONObject.put("icon", pkgIconAndName[0]);
                jSONObject.put("name", pkgIconAndName[1]);
                List<ShareStorage.StorageModel> a = com.baidu.sapi2.share.a.a().a(SapiJsInterpreters.this.b.context);
                if (SapiJsInterpreters.this.c.u != null && a != null && a.size() > 0) {
                    jSONObject.put("openShareLogin", "true");
                } else {
                    jSONObject.put("openShareLogin", "false");
                }
                jSONObject.put("hasThirdAccount", SapiJsInterpreters.this.c.O == null ? "false" : SapiJsInterpreters.this.c.O.hasThirdAccount + "");
                if (!new c().b()) {
                    jSONObject.put("supportFaceLogin", "false");
                } else {
                    jSONObject.put("supportFaceLogin", "true");
                }
                if (SapiJsInterpreters.this.c.O != null && SapiJsInterpreters.this.c.O.agreement != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : SapiJsInterpreters.this.c.O.agreement.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", str);
                        jSONObject2.put("url", SapiJsInterpreters.this.c.O.agreement.get(str));
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    class SapiActionGetDeviceAuthToken extends AbstractInterpreter {
        SapiActionGetDeviceAuthToken() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                boolean optBoolean = new JSONObject(command.getActionParams().get(0)).optBoolean("is_only_outside_get_token", true);
                if (optBoolean) {
                }
                boolean z = optBoolean ? false : true;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_outside_company", "0");
                jSONObject.put("errno", 0);
                if (z) {
                    SapiAccount session = SapiAccountManager.getInstance().getSession();
                    jSONObject.put("once_token", SapiAccountManager.getInstance().getDeviceAuthToken(SapiJsInterpreters.this.d, session == null ? null : session.uid, 122));
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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
                jSONObject2.put(WXLoginActivity.KEY_BASE_RESP_STATE, new SapiScheme().getInvokeScState(SapiJsInterpreters.this.d, optString, SapiJsInterpreters.this.c.x));
                return jSONObject2.toString();
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    class SapiActionUpdateNavigator extends AbstractInterpreter {
        SapiActionUpdateNavigator() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            int parseInt = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.c.E != null) {
                SapiJsInterpreters.this.c.E.pageState(parseInt);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
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
                SapiJsInterpreters.this.c.x.onInvokeScApp(optString, optString2, arrayList, new SapiWebView.InvokeScAppCallback.InvokeScAppResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionScAppInvoke.1
                    @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback.InvokeScAppResult
                    public void setInvokeResult(String str) {
                        SapiJsInterpreters.this.c.G.confirm(str);
                    }
                });
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
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
            if (SapiJsInterpreters.this.c.d == null) {
                arrayList.remove(FastLoginFeature.TX_WEIXIN_SSO);
            }
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance(SapiJsInterpreters.this.d).isHostsHijacked()) {
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

    /* loaded from: classes.dex */
    class ActionGetLoadtime extends AbstractInterpreter {
        ActionGetLoadtime() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiWebView unused = SapiJsInterpreters.this.a;
            if (SapiWebView.statLoadLogin != null) {
                SapiWebView unused2 = SapiJsInterpreters.this.a;
                return SapiWebView.statLoadLogin.toJSON().toString();
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class ActionFaceLoginSwitch extends AbstractInterpreter {
        ActionFaceLoginSwitch() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString("livinguname");
                if (!TextUtils.isEmpty(optString)) {
                    new c().a(SapiJsInterpreters.this.d, optString);
                } else {
                    SapiAccountManager.getInstance().getAccountService().checkFaceLoginEnable(SapiJsInterpreters.this.d, null);
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
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
                            SapiJsInterpreters.this.c.z.onFailure(-202, SapiResult.ERROR_MSG_UNKNOWN);
                        } else {
                            SapiAccount session = SapiAccountManager.getInstance().getSession();
                            b.addSocialInfo(session.getSocialType(), session.getSocialPortrait());
                            SapiAccountManager.getInstance().removeLoginAccount(session);
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
                    SapiJsInterpreters.this.c.z.onFailure(-202, SapiResult.ERROR_MSG_UNKNOWN);
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class NormalizeGuestDescription extends AbstractInterpreter {
        NormalizeGuestDescription() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                if (!TextUtils.isEmpty(SapiJsInterpreters.this.c.P)) {
                    jSONObject.put("description", new JSONObject(SapiJsInterpreters.this.c.P));
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes.dex */
    class ActionGetSmsCheckCodeFromClip extends AbstractInterpreter {
        ActionGetSmsCheckCodeFromClip() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        @TargetApi(11)
        public String interpret(SapiWebView.Command command) {
            String str;
            String str2 = "";
            try {
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.d.getSystemService("clipboard");
                if (!clipboardManager.hasPrimaryClip()) {
                    str = "";
                } else {
                    str2 = clipboardManager.getPrimaryClip().getItemAt(0).getText().toString();
                    str = SapiUtils.getSmsCheckCode(str2);
                }
            } catch (Throwable th) {
                str = str2;
                Log.e(th);
            }
            SapiStatUtil.statSmsCodeClip(SapiJsInterpreters.this.d, TextUtils.isEmpty(str) ? "0" : "1");
            return str;
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    class SapiActionPreGetPhone extends AbstractInterpreter {
        SapiActionPreGetPhone() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return new com.baidu.sapi2.a.c().a(SapiJsInterpreters.this.d).toString();
        }
    }

    /* loaded from: classes.dex */
    class SapiActionChinaMobileOauth extends AbstractInterpreter {
        SapiActionChinaMobileOauth() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            new com.baidu.sapi2.a.c().a(SapiJsInterpreters.this.b, new c.a() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionChinaMobileOauth.1
                @Override // com.baidu.sapi2.a.c.a
                public void onGetTokenComplete(JSONObject jSONObject) {
                    SapiJsInterpreters.this.c.G.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    /* loaded from: classes.dex */
    class SapiActionDirectedLogin extends AbstractInterpreter {
        SapiActionDirectedLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("encryptedId", SapiJsInterpreters.this.c.Q.encryptedId);
                jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, SapiJsInterpreters.this.c.Q.displayname);
                jSONObject.put("errno", 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes.dex */
    class SapiActionHideSuccessTip extends AbstractInterpreter {
        SapiActionHideSuccessTip() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hideTip", SapiJsInterpreters.this.c.R ? "1" : "0");
                jSONObject.put("errno", 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
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
                    SapiJsInterpreters.this.c.G.confirm(ssoHashResult.ssoHash);
                }
            }, SapiJsInterpreters.this.c.S.callingPkg, SapiJsInterpreters.this.c.S.callingAppId);
            return null;
        }
    }

    /* loaded from: classes.dex */
    class ActionShareV2Login extends AbstractInterpreter {
        ActionShareV2Login() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.c.T.pageParams.toString();
        }
    }

    /* loaded from: classes.dex */
    class ActionShareV2LoginClick extends AbstractInterpreter {
        ActionShareV2LoginClick() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.T.onSuccess();
            return null;
        }
    }

    /* loaded from: classes.dex */
    class ActionShareV2LoginFail extends AbstractInterpreter {
        ActionShareV2LoginFail() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.c.T.onError();
            return null;
        }
    }

    /* loaded from: classes.dex */
    class OauthCallBaidu extends AbstractInterpreter {
        OauthCallBaidu() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.S != null) {
                SapiJsInterpreters.this.c.S.callback.onCallback(command.getActionParams().get(0));
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
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
        private BroadcastReceiver p;

        private SendUpwardSms(String str, String str2, String str3, String str4, SapiWebView.UpwardSmsCallback upwardSmsCallback) {
            this.l = false;
            this.m = false;
            this.n = new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.1
                @Override // java.lang.Runnable
                public void run() {
                    SendUpwardSms.this.d();
                    SendUpwardSms.this.f();
                }
            };
            this.p = new BroadcastReceiver() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    SapiJsInterpreters.this.a.removeCallbacks(SendUpwardSms.this.n);
                    SendUpwardSms.this.d();
                    if (getResultCode() != -1) {
                        SendUpwardSms.this.f();
                        return;
                    }
                    SendUpwardSms.this.l = true;
                    SendUpwardSms.this.m = true;
                    SendUpwardSms.this.k.onResult(SendUpwardSms.this.l, SendUpwardSms.this.m, false);
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

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Build.VERSION.SDK_INT >= 23 && SapiJsInterpreters.this.d.checkSelfPermission("android.permission.SEND_SMS") == -1) {
                f();
            } else if (Build.VERSION.SDK_INT < 23 && SapiJsInterpreters.this.d.checkCallingOrSelfPermission("android.permission.SEND_SMS") == -1) {
                f();
            } else {
                c();
            }
        }

        private String b() {
            return this.j;
        }

        @TargetApi(11)
        private void c() {
            AlertDialog.Builder builder = new AlertDialog.Builder(SapiJsInterpreters.this.d, 3);
            builder.setTitle(this.i);
            builder.setMessage(b());
            builder.setPositiveButton(c, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (!SendUpwardSms.this.e()) {
                        SendUpwardSms.this.f();
                    }
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.4
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
            if (!((Activity) SapiJsInterpreters.this.d).isFinishing() && !create.isShowing()) {
                create.show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (this.p != null) {
                try {
                    SapiJsInterpreters.this.d.unregisterReceiver(this.p);
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            Intent intent = new Intent(f);
            intent.setPackage(SapiJsInterpreters.this.d.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(SapiJsInterpreters.this.d, 0, intent, 0);
            SapiJsInterpreters.this.d.registerReceiver(this.p, new IntentFilter(f));
            try {
                SmsService.sendSms(this.g, this.h, broadcast, null);
                SapiJsInterpreters.this.a.postDelayed(this.n, 500L);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            if (SapiJsInterpreters.this.c.w != null) {
                SapiWebView.SystemUpwardSmsCallback.Result result = new SapiWebView.SystemUpwardSmsCallback.Result() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.6
                    @Override // com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback.Result
                    public void onFinish() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("with_permision", false);
                            jSONObject.put("send_suc", false);
                            jSONObject.put("cancel", false);
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                        if (SapiJsInterpreters.this.c.G != null) {
                            SapiJsInterpreters.this.c.G.confirm(jSONObject.toString());
                        }
                        SendUpwardSms.this.k.onResult(SendUpwardSms.this.l, SendUpwardSms.this.m, false);
                    }
                };
                result.content = this.h;
                result.destination = this.g;
                SapiJsInterpreters.this.c.w.onResult(result);
            }
        }
    }
}
