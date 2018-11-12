package com.baidu.searchbox.ng.ai.apps.canvas.model;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CanvasBasicModel extends AiAppsNaViewModel {
    private static final String CANVAS_CANVAS_ID = "canvasId";
    private static final String CANVAS_DISABLE_SCROLL = "disableScroll";
    private static final String DISABLE_HIDDEN = "1";
    public boolean disableScroll;

    public CanvasBasicModel(String str) {
        super(CANVAS_CANVAS_ID, AiAppsNAViewType.CANVAS);
        this.disableScroll = false;
        try {
            parseFromJson(new JSONObject(str));
        } catch (JSONException e) {
            AiAppsLog.e("Canvas", "parsing CanvasBasicthis occurs exception", e);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.hidden = TextUtils.equals(jSONObject.optString("hide"), "1") || jSONObject.optBoolean("hide");
        this.disableScroll = !TextUtils.equals(jSONObject.optString(CANVAS_DISABLE_SCROLL), "0");
        this.gesture = TextUtils.equals(jSONObject.optString(AiAppsNaViewModel.KEY_GESTURE), "0") ? false : true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.slaveId)) ? false : true;
    }
}
