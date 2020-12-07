package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class o extends a {
    String cHE = "sans-serif";
    float cHF = com.baidu.swan.apps.ap.ah.M(10.0f);
    boolean cHG = false;
    boolean mItalic = false;
    boolean cHH = true;

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
                        this.cHG = true;
                    } else if (str.contains("normal")) {
                        this.cHH = true;
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
                        this.cHF = com.baidu.swan.apps.ap.ah.M(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.cHE = str;
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
        if (this.cHG && this.mItalic) {
            i = 3;
        } else if (this.cHG) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.cHd.setTypeface(Typeface.create(this.cHE, i));
        bVar.cHd.setTextSize(this.cHF);
    }
}
