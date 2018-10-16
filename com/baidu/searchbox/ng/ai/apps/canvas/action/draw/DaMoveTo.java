package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaMoveTo extends AbsDrawAction {
    public static final String ACTION_TYPE = "moveTo";
    private int mX = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int mY = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.mX = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
            this.mY = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mX != Integer.MAX_VALUE && this.mY != Integer.MAX_VALUE) {
            canvasContext.mPath.moveTo(this.mX, this.mY);
        }
    }
}
