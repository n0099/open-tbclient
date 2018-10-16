package com.baidu.searchbox.ng.ai.apps.scheme.actions.www;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class WWWParams extends AiAppsNaViewModel {
    private static final boolean DEBUG = false;
    private static final String PARAMS_KEY = "params";
    private static final String SRC_KEY = "src";
    private static final String VIEW_ID_KEY = "viewId";
    public String mSrc;

    public WWWParams() {
        super(VIEW_ID_KEY, AiAppsNAViewType.WEBVIEW);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.mSrc = jSONObject.optString("src");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WWWParams parseWWWParams(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        String str = unitedSchemeEntity.getParams().get("params");
        WWWParams wWWParams = new WWWParams();
        try {
            wWWParams.parseFromJson(new JSONObject(str));
            return wWWParams;
        } catch (JSONException e) {
            AiAppsLog.e("WebView", "parsing params occurs exception", e);
            return null;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return !TextUtils.isEmpty(this.slaveId);
    }
}
