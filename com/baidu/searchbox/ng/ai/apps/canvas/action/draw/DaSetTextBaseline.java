package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaSetTextBaseline extends AbsDrawAction {
    public static final String ACTION_TYPE = "setTextBaseline";
    private int mTextBaseLine = 0;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, AiAppsNaViewModel.POSITION_KEY_TOP)) {
                    this.mTextBaseLine = 1;
                } else if (TextUtils.equals(optString, "middle")) {
                    this.mTextBaseLine = 2;
                } else if (TextUtils.equals(optString, "bottom")) {
                    this.mTextBaseLine = 3;
                } else {
                    this.mTextBaseLine = 0;
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        canvasContext.mTextBaseLine = this.mTextBaseLine;
    }
}
