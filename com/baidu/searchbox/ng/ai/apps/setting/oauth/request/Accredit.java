package com.baidu.searchbox.ng.ai.apps.setting.oauth.request;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsAccreditNode;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.setting.SettingDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthException;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsDialogDecorate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Accredit extends OAuthRequest<Result> implements SettingDef, OAuthDef {
    private final Activity mActivity;
    private final boolean mFlagPermit;
    private final String mScope;
    private String mStoken;

    public Accredit(Activity activity, boolean z, String str) {
        super("ma/accredit_data");
        this.mActivity = activity;
        this.mScope = str;
        this.mFlagPermit = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
    public boolean onInitialPrepare() {
        offerPreparation(new StokenPreparation());
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
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.mFlagPermit));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
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
        String str;
        JSONObject jSONObject2;
        int optInt = jSONObject.optInt("errno", 11001);
        handleBdussInvalid(this.mActivity, jSONObject);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + jSONObject.optString("errms"));
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new Result(this.mFlagPermit, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.request.OAuthRequest
    public void onRequestSuccess() {
        super.onRequestSuccess();
        AiAppsAccreditNode.cleanAccreditListData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class StokenPreparation extends Preparation {
        private StokenPreparation() {
        }

        @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation
        protected boolean onPrepare() throws Exception {
            AiAppsRuntime.getAiAppAccountRuntime().getTplStoken(Accredit.this.mActivity, new TypedCallback<Bundle>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.Accredit.StokenPreparation.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Bundle bundle) {
                    if (bundle == null) {
                        StokenPreparation.this.notifyReady(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString(OAuthDef.TPL, "");
                    if (!TextUtils.isEmpty(string)) {
                        Accredit.this.mStoken = string;
                        StokenPreparation.this.notifyReady();
                        return;
                    }
                    StokenPreparation.this.notifyReady(new OAuthException("empty stoken", 10001));
                }
            }, OAuthDef.TPL);
            return false;
        }
    }

    private void showBdussInvalidDialog(String str, String str2) {
        new AiAppAlertDialog.Builder(this.mActivity).setTitle(str).setMessage(str2).setDecorate(new AiAppsDialogDecorate()).setCancelable(true).setPositiveButton(this.mActivity.getString(R.string.aiapps_login_immediately), new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.Accredit.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AiAppsRuntime.getAiAppAccountRuntime().login(Accredit.this.mActivity, "key_login_source", true, null);
            }
        }).setNegativeButton(this.mActivity.getString(R.string.aiapps_login_refuse), (DialogInterface.OnClickListener) null).show();
    }

    /* loaded from: classes2.dex */
    public static class Result {
        public final String code;
        public final JSONObject openData;
        public final boolean permit;

        private Result(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.permit = z;
            this.openData = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.permit), this.code);
        }
    }
}
