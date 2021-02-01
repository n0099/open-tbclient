package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class o extends a {
    String cJZ = "sans-serif";
    float cKa = com.baidu.swan.apps.ao.ah.P(10.0f);
    boolean cKb = false;
    boolean mItalic = false;
    boolean cKc = true;

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
                        this.cKb = true;
                    } else if (str.contains("normal")) {
                        this.cKc = true;
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
                        this.cKa = com.baidu.swan.apps.ao.ah.P(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.cJZ = str;
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
        if (this.cKb && this.mItalic) {
            i = 3;
        } else if (this.cKb) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.cJC.setTypeface(Typeface.create(this.cJZ, i));
        bVar.cJC.setTextSize(this.cKa);
    }
}
