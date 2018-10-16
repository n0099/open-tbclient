package com.baidu.searchbox.ng.ai.apps.canvas.model;

import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CanvasMeasureTextModel extends CanvasBasicModel {
    private static final String KEY_FONT = "font";
    private static final String KEY_TEXT = "text";
    public boolean mBold;
    public String mFontFamily;
    public float mFontSize;
    public boolean mItalic;
    public boolean mNormal;
    public String mText;

    public CanvasMeasureTextModel(String str) {
        super(str);
        String[] split;
        this.mFontFamily = "sans-serif";
        this.mFontSize = AiAppsUIUtils.dp2px(10.0f);
        this.mBold = false;
        this.mItalic = false;
        this.mNormal = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mText = jSONObject.optString("text");
            String optString = jSONObject.optString("font");
            if (optString != null && optString.length() > 0) {
                for (String str2 : optString.split(" ")) {
                    if (str2.contains("italic")) {
                        this.mItalic = true;
                    } else if (str2.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str2.contains("bold")) {
                        this.mBold = true;
                    } else if (str2.contains("normal")) {
                        this.mNormal = true;
                    } else if (Character.isDigit(str2.charAt(0))) {
                        int length = str2.length();
                        int i = 0;
                        while (true) {
                            if (i >= str2.length()) {
                                i = length;
                                break;
                            } else if (!Character.isDigit(str2.charAt(i))) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        this.mFontSize = AiAppsUIUtils.dp2px(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.mFontFamily = str2;
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
