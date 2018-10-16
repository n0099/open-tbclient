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
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.widget.DatePicker;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.webkit.internal.ABTestConstants;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
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
        String[] split = str.split(BaseRequestAction.SPLITE);
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
            if (SapiJsInterpreters.this.c.g != null) {
                SapiJsInterpreters.this.c.g.onTitleChange(str);
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
                if (SapiJsInterpreters.this.c.h == null || !SapiJsInterpreters.this.b.supportFaceLogin) {
                    z2 = false;
                }
            } else if (str.equals("sapi_biometrics_identification") || str.equals("sapi_biometrics_identification_no_bduss") || str.equals("sapi_biometrics_identification_with_authtoken")) {
                if (SapiJsInterpreters.this.c.i == null || !SapiJsInterpreters.this.b.supportFaceLogin) {
                    z2 = false;
                }
            } else if (!str.equals("sapi_action_sc_app_check")) {
                z2 = z;
            } else if (SapiJsInterpreters.this.c.z == null) {
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
            List<FastLoginFeature> fastLoginFeatureList = SapiJsInterpreters.this.c.A != null ? SapiJsInterpreters.this.c.A.getFastLoginFeatureList() : null;
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
                        sb.append(",").append(fastLoginFeature.getStrValue());
                    }
                    i = i2 + 1;
                } else {
                    return sb.toString();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class ActionFeifanLogin extends AbstractInterpreter {
        ActionFeifanLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.a != null) {
                Message message = new Message();
                message.what = SocialType.WANDA_FEIFAN.getType();
                message.obj = SocialType.WANDA_FEIFAN;
                SapiJsInterpreters.this.c.a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class ActionChuankeLogin extends AbstractInterpreter {
        ActionChuankeLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.a != null) {
                Message message = new Message();
                message.what = SocialType.CHUANKE.getType();
                message.obj = SocialType.CHUANKE;
                SapiJsInterpreters.this.c.a.sendMessage(message);
                return null;
            }
            return null;
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
    class ActionSocialTxWeiboWebview extends AbstractInterpreter {
        ActionSocialTxWeiboWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.a != null) {
                Message message = new Message();
                message.what = SocialType.TENCENT_WEIBO.getType();
                message.obj = SocialType.TENCENT_WEIBO;
                SapiJsInterpreters.this.c.a.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class ActionSocialSinaWeiboWebview extends AbstractInterpreter {
        ActionSocialSinaWeiboWebview() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.a != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO.getType();
                message.obj = SocialType.SINA_WEIBO;
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
    class ActionNuomiLogin extends AbstractInterpreter {
        ActionNuomiLogin() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.c.b != null) {
                SapiJsInterpreters.this.c.b.handleNMLogin();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class ActionUniteVerify extends AbstractInterpreter {
        ActionUniteVerify() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.c.c != null && !TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    SapiJsInterpreters.this.c.c.handleUniteVerify(jSONObject.optString("token"), jSONObject.optString("adtext"));
                    return null;
                } catch (JSONException e) {
                    Log.e(e);
                    return null;
                }
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
            SapiStatUtil.statShareV1OpenPage(shareAccounts);
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
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<ShareStorage.StorageModel> a = com.baidu.sapi2.share.a.a().a(SapiJsInterpreters.this.b.context);
            for (ShareStorage.StorageModel storageModel : a) {
                if (!TextUtils.isEmpty(storageModel.tpl)) {
                    arrayList.add(storageModel.tpl);
                }
                if (!TextUtils.isEmpty(storageModel.app)) {
                    arrayList2.add(storageModel.app);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(Config.DEVICE_PART, Build.MODEL);
            hashMap.put("account_size", a.size() + "");
            hashMap.put("account_tpls", TextUtils.join(",", arrayList));
            hashMap.put("account_apps", TextUtils.join(",", arrayList2));
            StatService.onEvent("share_account_open", hashMap, false);
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
                String optString = jSONObject.optString("info");
                String optString2 = jSONObject.optString("u");
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = jSONObject.optString("passuid");
                sapiAccount.username = jSONObject.optString("username");
                sapiAccount.displayname = jSONObject.optString("displayname");
                sapiAccount.bduss = jSONObject.optString("bduss");
                sapiAccount.ptoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
                sapiAccount.stoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_STOKEN);
                if (!TextUtils.isEmpty(optString) && SapiUtils.isValidAccount(sapiAccount) && SapiJsInterpreters.this.c.j != null) {
                    SapiJsInterpreters.this.c.j.onSuccess(optString, optString2, sapiAccount);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_UNITEVERIFY, IEventCenterService.EventResult.PHASE.SUCCESS);
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
            if (SapiJsInterpreters.this.c.k != null) {
                SapiJsInterpreters.this.c.k.handleOtherLogin();
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
            if (SapiJsInterpreters.this.c.l != null) {
                SapiJsInterpreters.this.c.l.onPhoneNumberExist(str);
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
            if (SapiJsInterpreters.this.c.d != null) {
                SapiJsInterpreters.this.c.d.handleFastReg();
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
            if (SapiJsInterpreters.this.c.F != null) {
                z = SapiJsInterpreters.this.c.F.onForgetPwd();
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
            SapiJsInterpreters.this.a.a(SapiJsInterpreters.this.c.e);
            SapiJsInterpreters.this.c.e.a = command.getActionParams().get(0);
            SapiJsInterpreters.this.c.e.b = command.getActionParams().get(1);
            SapiJsInterpreters.this.c.e.postDelayed(SapiJsInterpreters.this.c.G, 15000L);
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
                calendar.setTime(new SimpleDateFormat(AiAppDateTimeUtil.DAY_FORMAT).parse(str));
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
                    SapiJsInterpreters.this.c.H.confirm(i7 + String.format("%02d", Integer.valueOf(i8 + 1)) + String.format("%02d", Integer.valueOf(i9)) + "");
                }
            }, i, i2, i3);
            datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    SapiJsInterpreters.this.c.H.confirm("");
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
            if (SapiJsInterpreters.this.c.m != null) {
                SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult = new SapiWebView.LoadExternalWebViewResult();
                loadExternalWebViewResult.defaultTitle = command.getActionParams().get(0);
                loadExternalWebViewResult.externalUrl = command.getActionParams().get(1);
                SapiJsInterpreters.this.c.m.loadExternalWebview(loadExternalWebViewResult);
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
            SapiJsInterpreters.this.c.n.onPickImage(i, new SapiWebView.PickPhotoResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickImage.1
                @Override // com.baidu.sapi2.SapiWebView.PickPhotoResult
                public void setImageData(String str) {
                    if (SapiJsInterpreters.this.c.H != null) {
                        SapiJsInterpreters.this.c.H.confirm(str);
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
            if (SapiJsInterpreters.this.c.o != null) {
                SapiJsInterpreters.this.c.o.onBdussChange();
                return null;
            }
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
            if (SapiJsInterpreters.this.c.p != null) {
                List<String> actionParams = command.getActionParams();
                if (actionParams != null && actionParams.size() > 0) {
                    SapiWebView.SwitchAccountCallback.Result result = new SapiWebView.SwitchAccountCallback.Result();
                    result.userName = actionParams.get(0);
                    try {
                        if (!SapiWebView.SwitchAccountCallback.class.equals(SapiJsInterpreters.this.c.p.getClass().getMethod("onAccountSwitch", SapiWebView.SwitchAccountCallback.Result.class).getDeclaringClass())) {
                            SapiJsInterpreters.this.c.p.onAccountSwitch(result);
                        }
                    } catch (NoSuchMethodException e) {
                        Log.e(e);
                    }
                }
                SapiJsInterpreters.this.c.p.onAccountSwitch();
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
                    if (SapiJsInterpreters.this.c.H != null) {
                        SapiJsInterpreters.this.c.H.confirm(str);
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
            if (SapiJsInterpreters.this.c.i != null) {
                SapiJsInterpreters.this.c.i.onBiometricsIdentify(biometricsIdentifyResult);
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
                    if (SapiJsInterpreters.this.c.H != null) {
                        SapiJsInterpreters.this.c.H.confirm(str);
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
            if (SapiJsInterpreters.this.c.i != null) {
                SapiJsInterpreters.this.c.i.onBiometricsIdentify(biometricsIdentifyResult);
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
                    if (SapiJsInterpreters.this.c.H != null) {
                        SapiJsInterpreters.this.c.H.confirm(str);
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
            if (SapiJsInterpreters.this.c.i != null) {
                SapiJsInterpreters.this.c.i.onBiometricsIdentify(biometricsIdentifyResult);
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
            SapiJsInterpreters.this.c.I = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.c.q != null) {
                SapiJsInterpreters.this.c.q.onLeftBtnVisible(SapiJsInterpreters.this.c.I);
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
            if (SapiJsInterpreters.this.c.r != null) {
                SapiJsInterpreters.this.c.r.onSuccess();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REALNAME_AUTHENTICATE, IEventCenterService.EventResult.PHASE.SUCCESS);
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
            if (SapiJsInterpreters.this.c.s != null) {
                SapiJsInterpreters.this.c.s.onCoverBduss(cookieBduss, new SapiWebView.CoverWebBdussResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionCoverWebBduss.1
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
            SapiJsInterpreters.this.c.J = true;
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
                String optString = jSONObject.optString("username");
                boolean equals = jSONObject.optString("close", "0").equals("1");
                SapiWebView.PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult = new SapiWebView.PreFillUserNameCallback.PreFillUserNameResult();
                preFillUserNameResult.userName = optString;
                if (SapiJsInterpreters.this.c.t != null) {
                    SapiJsInterpreters.this.c.t.onPreFillUserName(preFillUserNameResult);
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
                com.baidu.sapi2.share.face.a aVar = new com.baidu.sapi2.share.face.a();
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
            if (SapiJsInterpreters.this.c.u != null) {
                SapiJsInterpreters.this.c.u.onAccountDestory(new SapiWebView.AccountDestoryCallback.AccountDestoryResult());
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
            if (SapiJsInterpreters.this.c.v != null) {
                SapiJsInterpreters.this.c.v.onAccountFreeze(new SapiWebView.AccountFreezeCallback.AccountFreezeResult());
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
            if (SapiJsInterpreters.this.c.h != null) {
                SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult = new SapiWebView.BioScanFaceCallback.BioScanFaceResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationWithUid.1
                    @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback.BioScanFaceResult
                    public void setScanFaceIdentifyResult(String str) {
                        SapiJsInterpreters.this.c.H.confirm(str);
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
                            bioScanFaceResult.transParamsList.add(new BasicNameValuePair(next, optJSONObject.optString(next)));
                        }
                    }
                    SapiJsInterpreters.this.c.h.onBioScanFace(bioScanFaceResult);
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
                    String optString = jSONObject.optString("pkg");
                    String optString2 = jSONObject.optString("url");
                    SapiJsInterpreters.this.c.H.confirm("finish");
                    SapiJsInterpreters.this.c.w.onClick(optString, optString2);
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
            SapiStatUtil.statShareClickOther(command.getActionParams().get(0));
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
            SapiStatUtil.statShareV1AccountClick(i3, str4, str5);
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
                if (SapiJsInterpreters.this.c.x != null) {
                    int optInt = jSONObject.optInt("relogin", -1);
                    if (optInt == 1) {
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        String optString = jSONObject.optString("bduss");
                        String optString2 = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
                        if (session != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            session.bduss = optString;
                            session.ptoken = optString2;
                            session.deleteStokens();
                            SapiAccountManager.getInstance().validate(session);
                            SapiAccountManager.getInstance().preFetchStoken(session, true);
                        }
                    }
                    SapiJsInterpreters.this.c.x.loginStatusChange(optInt == 1);
                }
                if (SapiJsInterpreters.this.c.K) {
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
            if (WXAPIFactory.createWXAPI(SapiJsInterpreters.this.d, SapiJsInterpreters.this.b.wxAppID).isWXAppInstalled()) {
                SapiJsInterpreters.this.c.L = command.getActionParams().get(0);
                if (SapiJsInterpreters.this.c.f != null) {
                    Message message = new Message();
                    message.what = SocialType.WEIXIN.getType();
                    message.obj = SapiJsInterpreters.this.c.L;
                    SapiJsInterpreters.this.c.f.sendMessage(message);
                }
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, SapiWebView.ErrorCode.WEIXIN_NOT_INTALL);
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
            SapiJsInterpreters.this.a.a(SapiJsInterpreters.this.c.M);
            SapiJsInterpreters.this.a.finish();
            if (SapiJsInterpreters.this.c.D != null) {
                String str = "";
                if (command.getActionParams().size() > 0) {
                    str = command.getActionParams().get(0);
                }
                SapiJsInterpreters.this.c.D.onFinish(str);
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
            SapiJsInterpreters.this.a.c(SapiJsInterpreters.this.c.N);
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
                    if (SapiJsInterpreters.this.c.F != null) {
                        SapiJsInterpreters.this.a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.c.F != null) {
                                    SapiJsInterpreters.this.c.F.onFailed(-100, "登录失败");
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.FAILURE);
                                }
                            }
                        });
                    }
                } else if (b.offlineNotice || b.bindGuide || b.errorCode == 21 || b.bindConflict) {
                    SapiJsInterpreters.this.c.M = b;
                } else {
                    SapiJsInterpreters.this.a.a(b);
                }
            }
            if (parseInt == 0) {
                final SapiAccountResponse a = SapiJsInterpreters.this.a.a(str, SapiJsInterpreters.this.d);
                if (a == null) {
                    if (SapiJsInterpreters.this.c.F != null) {
                        SapiJsInterpreters.this.a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiJsInterpreters.this.c.F != null) {
                                    SapiJsInterpreters.this.c.F.onFailed(-100, "登录失败");
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.FAILURE);
                                }
                            }
                        });
                        return null;
                    }
                    return null;
                } else if (SapiJsInterpreters.this.c.O != null && a.newReg) {
                    SapiJsInterpreters.this.c.N = a;
                    SapiJsInterpreters.this.a.a(a);
                    return null;
                } else if (a.errorCode == 0 || a.errorCode == 110000) {
                    SapiJsInterpreters.this.a.c(a);
                    return null;
                } else if (SapiJsInterpreters.this.c.F != null) {
                    SapiJsInterpreters.this.a.post(new Runnable() { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiJsInterpreters.this.c.F != null) {
                                SapiJsInterpreters.this.c.F.onFailed(a.errorCode, a.errorMsg);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.FAILURE);
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
                        jSONObject.put(AiAppsUBCStatistic.VALUE_CANCEL, z3);
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                    SapiJsInterpreters.this.c.H.confirm(jSONObject.toString());
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
            PackageManager packageManager = SapiJsInterpreters.this.d.getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(SapiJsInterpreters.this.d.getPackageName(), 0);
                jSONObject.put("name", packageInfo.applicationInfo.loadLabel(packageManager).toString());
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(((BitmapDrawable) packageInfo.applicationInfo.loadIcon(packageManager)).getBitmap(), 160, 160, true);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i = 100;
                createScaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                while (byteArrayOutputStream.toByteArray().length > 524288 && i > 0) {
                    i /= 2;
                    byteArrayOutputStream.reset();
                    createScaledBitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
                }
                jSONObject.put(AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY, "data:image/png;base64," + SapiDeviceUtils.DeviceCrypto.base64Encode(byteArrayOutputStream.toByteArray()));
                List<ShareStorage.StorageModel> a = com.baidu.sapi2.share.a.a().a(SapiJsInterpreters.this.b.context);
                if (SapiJsInterpreters.this.c.w != null && a != null && a.size() > 0) {
                    jSONObject.put("openShareLogin", "true");
                } else {
                    jSONObject.put("openShareLogin", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
                }
                jSONObject.put("hasThirdAccount", SapiJsInterpreters.this.c.P == null ? ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE : SapiJsInterpreters.this.c.P.hasThirdAccount + "");
                if (!new FaceLoginService().isSupFaceLogin()) {
                    jSONObject.put("supportFaceLogin", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
                } else {
                    jSONObject.put("supportFaceLogin", "true");
                }
                if (SapiJsInterpreters.this.c.P != null && SapiJsInterpreters.this.c.P.agreement != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : SapiJsInterpreters.this.c.P.agreement.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", str);
                        jSONObject2.put("url", SapiJsInterpreters.this.c.P.agreement.get(str));
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("agreement", jSONArray);
                }
                byteArrayOutputStream.close();
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
    class SapiActionRealname extends AbstractInterpreter {
        SapiActionRealname() {
            super();
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            try {
                int optInt = new JSONObject(command.getActionParams().get(0)).optInt("status");
                if (SapiJsInterpreters.this.c.E != null) {
                    SapiJsInterpreters.this.c.E.onFinish(optInt);
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
                jSONObject2.put("state", new SapiScheme().getInvokeScState(SapiJsInterpreters.this.d, optString, SapiJsInterpreters.this.c.z));
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
            if (SapiJsInterpreters.this.c.B != null) {
                SapiJsInterpreters.this.c.B.pageState(parseInt);
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
                        arrayList.add(new BasicNameValuePair(next, jSONObject.optString(next)));
                    }
                }
                SapiJsInterpreters.this.c.z.onInvokeScApp(optString, optString2, arrayList, new SapiWebView.InvokeScAppCallback.InvokeScAppResult() { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionScAppInvoke.1
                    @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback.InvokeScAppResult
                    public void setInvokeResult(String str) {
                        SapiJsInterpreters.this.c.H.confirm(str);
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
            if (SapiJsInterpreters.this.c.f == null) {
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
                        sb.append(",").append(fastLoginFeature.getStrValue());
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
                    new FaceLoginService().syncFaceLoginUID(SapiJsInterpreters.this.d, optString);
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
                    if (SapiJsInterpreters.this.c.C != null) {
                        SapiJsInterpreters.this.c.C.onFailure(optInt, optString);
                    }
                } else {
                    boolean z = jSONObject.optInt("merge") == 1;
                    SapiAccountResponse a = SapiJsInterpreters.this.a.a(jSONObject.optString("xml"), SapiJsInterpreters.this.d);
                    if (a == null) {
                        if (SapiJsInterpreters.this.c.C != null) {
                            SapiJsInterpreters.this.c.C.onFailure(NormalizeGuestAccountResult.ERROR_CODE_PARSE_XML, NormalizeGuestAccountResult.ERROR_MSG_PARSE_XML);
                        }
                    } else {
                        SapiAccount b = SapiJsInterpreters.this.a.b(a);
                        if (!SapiUtils.isValidAccount(b)) {
                            SapiJsInterpreters.this.c.C.onFailure(-202, SapiResult.ERROR_MSG_UNKNOWN);
                        } else {
                            SapiAccount session = SapiAccountManager.getInstance().getSession();
                            b.addSocialInfo(session.getSocialType(), session.getSocialPortrait());
                            SapiAccountManager.getInstance().removeLoginAccount(session);
                            SapiAccountManager.getInstance().validate(b);
                            if (SapiJsInterpreters.this.c.C != null) {
                                SapiJsInterpreters.this.c.C.onSuccess(z);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                Log.e(e);
                if (SapiJsInterpreters.this.c.C != null) {
                    SapiJsInterpreters.this.c.C.onFailure(-202, SapiResult.ERROR_MSG_UNKNOWN);
                }
            }
            return null;
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
            HashMap hashMap = new HashMap();
            hashMap.put("cuid", SapiUtils.getClientId(SapiJsInterpreters.this.d));
            hashMap.put(Config.DEVICE_PART, Build.MODEL);
            hashMap.put(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE);
            hashMap.put("success", TextUtils.isEmpty(str) ? "0" : "1");
            StatService.onEvent("get_sms_check_code_from_clip", hashMap, false);
            return str;
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
            PendingIntent broadcast = PendingIntent.getBroadcast(SapiJsInterpreters.this.d, 0, new Intent(f), 0);
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
            if (SapiJsInterpreters.this.c.y != null) {
                SapiWebView.SystemUpwardSmsCallback.Result result = new SapiWebView.SystemUpwardSmsCallback.Result() { // from class: com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms.6
                    @Override // com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback.Result
                    public void onFinish() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("with_permision", false);
                            jSONObject.put("send_suc", false);
                            jSONObject.put(AiAppsUBCStatistic.VALUE_CANCEL, false);
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                        if (SapiJsInterpreters.this.c.H != null) {
                            SapiJsInterpreters.this.c.H.confirm(jSONObject.toString());
                        }
                        SendUpwardSms.this.k.onResult(SendUpwardSms.this.l, SendUpwardSms.this.m, false);
                    }
                };
                result.content = this.h;
                result.destination = this.g;
                SapiJsInterpreters.this.c.y.onResult(result);
            }
        }
    }
}
