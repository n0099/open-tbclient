package com.baidu.searchbox.ng.ai.apps.setting.oauth.request;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.setting.SettingDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthException;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LoginRequest extends OAuthRequest<Result> implements SettingDef, OAuthDef {
    private final Activity mActivity;
    private String mStoken;

    public LoginRequest(Activity activity) {
        super("ma/login");
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
    public boolean onInitialPrepare() {
        offerPreparation(new LoginPreparation());
        return super.onInitialPrepare();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
    public boolean onFinalPrepare() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", requireAiApp().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AiAppsApsUtils.APP_KEY, requireAiApp().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", OAuthUtils.getKeyHash());
            jSONObject2.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            String hostApiKey = AiAppsRuntime.getAiAppAccountRuntime().getHostApiKey();
            if (!TextUtils.isEmpty(hostApiKey)) {
                jSONObject2.put("host_api_key", hostApiKey);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        addQuery("data", jSONObject.toString());
        return super.onFinalPrepare();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
    public Result parse(JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("errno", 11001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + jSONObject.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new Result(str);
    }

    /* loaded from: classes2.dex */
    private class LoginPreparation extends Preparation implements OnAiAppLoginResultListener {
        private LoginPreparation() {
        }

        @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation
        protected boolean onPrepare() throws Exception {
            LoginRequest.this.requireAiApp().getAccount().login(LoginRequest.this.mActivity, this);
            return false;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener
        public void onResult(int i) {
            OAuthUtils.log("onResult :: " + i, false);
            switch (i) {
                case -2:
                    OAuthUtils.log("login error ERR_BY_UESR_REFUSE", true);
                    notifyReady(new OAuthException("login cancel by user", 10004));
                    return;
                case -1:
                default:
                    OAuthUtils.log("login error ERR_BY_LOGIN", true);
                    notifyReady(new OAuthException("system login error", 10004));
                    return;
                case 0:
                    OAuthUtils.log("Login Preparation ok, is already login", false);
                    LoginRequest.this.offerPreparation(new StokenPreparation());
                    notifyReady();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class StokenPreparation extends Preparation {
        private StokenPreparation() {
        }

        @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation
        protected boolean onPrepare() throws Exception {
            AiAppsRuntime.getAiAppAccountRuntime().getTplStoken(LoginRequest.this.mActivity, new TypedCallback<Bundle>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.LoginRequest.StokenPreparation.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Bundle bundle) {
                    if (bundle == null) {
                        StokenPreparation.this.notifyReady(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString(OAuthDef.TPL, "");
                    if (!TextUtils.isEmpty(string)) {
                        LoginRequest.this.mStoken = string;
                        StokenPreparation.this.notifyReady();
                        return;
                    }
                    StokenPreparation.this.notifyReady(new OAuthException("empty stoken", 10001));
                }
            }, OAuthDef.TPL);
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class Result {
        public final String code;

        private Result(String str) {
            this.code = str == null ? "" : str;
        }

        public String toString() {
            return String.format("Result code(%s)", this.code);
        }
    }
}
