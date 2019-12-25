package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class o extends a {
    String bbL = "sans-serif";
    float bbM = com.baidu.swan.apps.as.af.T(10.0f);
    boolean bbN = false;
    boolean mItalic = false;
    boolean bbO = true;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        String[] split;
        try {
            if (jSONArray.length() > 0) {
                for (String str : jSONArray.optString(0).split(HanziToPinyin.Token.SEPARATOR)) {
                    if (str.contains("italic")) {
                        this.mItalic = true;
                    } else if (str.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str.contains("bold")) {
                        this.bbN = true;
                    } else if (str.contains("normal")) {
                        this.bbO = true;
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
                        this.bbM = com.baidu.swan.apps.as.af.T(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.bbL = str;
                    }
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        int i = 0;
        if (this.bbN && this.mItalic) {
            i = 3;
        } else if (this.bbN) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.bbm.setTypeface(Typeface.create(this.bbL, i));
        bVar.bbm.setTextSize(this.bbM);
    }
}
