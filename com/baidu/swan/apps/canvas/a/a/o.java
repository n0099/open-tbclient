package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class o extends a {
    String cwz = "sans-serif";
    float cwA = com.baidu.swan.apps.ap.ah.L(10.0f);
    boolean cwB = false;
    boolean mItalic = false;
    boolean cwC = true;

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
                        this.cwB = true;
                    } else if (str.contains("normal")) {
                        this.cwC = true;
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
                        this.cwA = com.baidu.swan.apps.ap.ah.L(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.cwz = str;
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
        if (this.cwB && this.mItalic) {
            i = 3;
        } else if (this.cwB) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.cwc.setTypeface(Typeface.create(this.cwz, i));
        bVar.cwc.setTextSize(this.cwA);
    }
}
