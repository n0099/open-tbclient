package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Typeface;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaFont extends AbsDrawAction {
    public static final String ACTION_TYPE = "font";
    String mFontFamily = "sans-serif";
    float mFontSize = AiAppsUIUtils.dp2px(10.0f);
    boolean mBold = false;
    boolean mItalic = false;
    boolean mNormal = true;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        String[] split;
        try {
            if (jSONArray.length() > 0) {
                for (String str : jSONArray.optString(0).split(" ")) {
                    if (str.contains("italic")) {
                        this.mItalic = true;
                    } else if (str.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str.contains("bold")) {
                        this.mBold = true;
                    } else if (str.contains("normal")) {
                        this.mNormal = true;
                    } else if (Character.isDigit(str.charAt(0))) {
                        int length = str.length();
                        int i = 0;
                        while (true) {
                            if (i >= str.length()) {
                                i = length;
                                break;
                            } else if (!Character.isDigit(str.charAt(i))) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        this.mFontSize = AiAppsUIUtils.dp2px(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.mFontFamily = str;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        int i = 0;
        if (this.mBold && this.mItalic) {
            i = 3;
        } else if (this.mBold) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        canvasContext.mFontPaint.setTypeface(Typeface.create(this.mFontFamily, i));
        canvasContext.mFontPaint.setTextSize(this.mFontSize);
    }
}
