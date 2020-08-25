package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class o extends a {
    String bZB = "sans-serif";
    float bZC = com.baidu.swan.apps.ap.ah.H(10.0f);
    boolean bZD = false;
    boolean mItalic = false;
    boolean bZE = true;

    @Override // com.baidu.swan.apps.canvas.a.a.a
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
                        this.bZD = true;
                    } else if (str.contains("normal")) {
                        this.bZE = true;
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
                        this.bZC = com.baidu.swan.apps.ap.ah.H(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.bZB = str;
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
        if (this.bZD && this.mItalic) {
            i = 3;
        } else if (this.bZD) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.bZe.setTypeface(Typeface.create(this.bZB, i));
        bVar.bZe.setTextSize(this.bZC);
    }
}
