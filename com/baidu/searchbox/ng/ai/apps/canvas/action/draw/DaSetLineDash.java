package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaSetLineDash extends AbsDrawAction {
    public static final String ACTION_TYPE = "setLineDash";
    private DashPathEffect mDashPathEffect;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        JSONArray optJSONArray;
        int length;
        float[] fArr = null;
        if (jSONArray.length() > 0 && (optJSONArray = jSONArray.optJSONArray(0)) != null && (length = optJSONArray.length()) > 0) {
            fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = AiAppsUIUtils.dp2px((float) optJSONArray.optDouble(i));
            }
        }
        int dp2px = jSONArray.length() > 1 ? AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1)) : 0;
        if (fArr != null && dp2px >= 0) {
            this.mDashPathEffect = new DashPathEffect(fArr, dp2px);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mDashPathEffect != null) {
            canvasContext.mStrokePaint.setPathEffect(this.mDashPathEffect);
        }
    }
}
