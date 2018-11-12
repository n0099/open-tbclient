package com.baidu.searchbox.ng.ai.apps.model.view.base;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.model.IModel;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.util.Diff;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsNaViewModel implements IModel {
    public static final String DISABLE_DEFAULT = "0";
    public static final String ENABLE_DEFAULT = "1";
    public static final String KEY_CALLBACK = "cb";
    public static final String KEY_GESTURE = "gesture";
    public static final String KEY_HIDDEN = "hide";
    public static final String KEY_PARENT_ID = "parentId";
    public static final String KEY_POSITION = "position";
    public static final String KEY_SLAVE_ID = "slaveId";
    public static final String POSITION_KEY_HEIGHT = "height";
    public static final String POSITION_KEY_LEFT = "left";
    public static final String POSITION_KEY_TOP = "top";
    public static final String POSITION_KEY_WIDTH = "width";
    public String callback;
    public boolean gesture = false;
    public boolean hidden;
    public String id;
    private String mViewIdKey;
    public String parentId;
    public AiAppsRectPosition position;
    public String slaveId;
    public String viewType;

    public AiAppsNaViewModel(String str, String str2) {
        this.mViewIdKey = "id";
        this.viewType = "unknown";
        if (!TextUtils.isEmpty(str)) {
            this.mViewIdKey = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.viewType = str2;
        }
    }

    public AiAppsNaViewModel cloneModel() {
        AiAppsNaViewModel aiAppsNaViewModel = new AiAppsNaViewModel(this.mViewIdKey, this.viewType);
        aiAppsNaViewModel.mViewIdKey = this.mViewIdKey;
        aiAppsNaViewModel.viewType = this.viewType;
        aiAppsNaViewModel.slaveId = this.slaveId;
        aiAppsNaViewModel.id = this.id;
        aiAppsNaViewModel.parentId = this.parentId;
        aiAppsNaViewModel.hidden = this.hidden;
        aiAppsNaViewModel.gesture = this.gesture;
        aiAppsNaViewModel.callback = this.callback;
        if (this.position != null) {
            aiAppsNaViewModel.position = new AiAppsRectPosition(this.position);
        }
        return aiAppsNaViewModel;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.mViewIdKey);
            this.slaveId = jSONObject.optString("slaveId");
            this.parentId = jSONObject.optString(KEY_PARENT_ID);
            this.hidden = jSONObject.optBoolean("hide", false);
            this.gesture = TextUtils.equals(jSONObject.optString(KEY_GESTURE), "1");
            this.callback = jSONObject.optString("cb");
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.position = new AiAppsRectPosition();
                this.position.setLeft(AiAppsUIUtils.dp2px(getFloat(optJSONObject, "left", 0.0f)));
                this.position.setTop(AiAppsUIUtils.dp2px(getFloat(optJSONObject, POSITION_KEY_TOP, 0.0f)));
                this.position.setWidth(AiAppsUIUtils.dp2px(getFloat(optJSONObject, "width", 0.0f)));
                this.position.setHeight(AiAppsUIUtils.dp2px(getFloat(optJSONObject, "height", 0.0f)));
            }
        }
    }

    public void updateFromJson(JSONObject jSONObject, @NonNull AiAppsNaViewModel aiAppsNaViewModel) {
        if (jSONObject != null) {
            this.id = jSONObject.optString(this.mViewIdKey, aiAppsNaViewModel.id);
            this.slaveId = jSONObject.optString("slaveId", aiAppsNaViewModel.slaveId);
            this.parentId = jSONObject.optString(KEY_PARENT_ID, aiAppsNaViewModel.parentId);
            this.hidden = jSONObject.optBoolean("hide", aiAppsNaViewModel.hidden);
            this.callback = jSONObject.optString("cb", aiAppsNaViewModel.callback);
            this.gesture = TextUtils.equals(jSONObject.optString(KEY_GESTURE, aiAppsNaViewModel.gesture ? "1" : "0"), "1");
            this.position = aiAppsNaViewModel.position;
            if (this.position == null) {
                this.position = new AiAppsRectPosition();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.position.setLeft(AiAppsUIUtils.dp2px(getFloat(optJSONObject, "left", this.position.left)));
                this.position.setTop(AiAppsUIUtils.dp2px(getFloat(optJSONObject, POSITION_KEY_TOP, this.position.top)));
                this.position.setWidth(AiAppsUIUtils.dp2px(getFloat(optJSONObject, "width", this.position.width)));
                this.position.setHeight(AiAppsUIUtils.dp2px(getFloat(optJSONObject, "height", this.position.height)));
            }
        }
    }

    public FrameLayout.LayoutParams generateLayoutParams() {
        int width = this.position != null ? this.position.getWidth() : -1;
        int height = this.position != null ? this.position.getHeight() : -1;
        int left = this.position != null ? this.position.getLeft() : 0;
        int top = this.position != null ? this.position.getTop() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(left, top, 0, 0);
        return layoutParams;
    }

    public void setPosition(AiAppsRectPosition aiAppsRectPosition) {
        this.position = aiAppsRectPosition;
    }

    public void diff(AiAppsNaViewModel aiAppsNaViewModel, Diff diff) {
        if (aiAppsNaViewModel != null && diff != null) {
            if (!TextUtils.equals(this.id, aiAppsNaViewModel.id)) {
                diff.mask(15);
                return;
            }
            if (this.position != null && !this.position.equals(aiAppsNaViewModel.position)) {
                diff.mask(1);
            }
            if (aiAppsNaViewModel.hidden != this.hidden) {
                diff.mask(8);
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return (TextUtils.isEmpty(this.slaveId) || TextUtils.isEmpty(this.id) || this.position == null || !this.position.isValid()) ? false : true;
    }

    public static float getFloat(JSONObject jSONObject, String str, float f) {
        return jSONObject == null ? f : (float) jSONObject.optDouble(str, f);
    }
}
