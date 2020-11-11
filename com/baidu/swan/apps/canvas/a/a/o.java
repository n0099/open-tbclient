package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class o extends a {
    String cCs = "sans-serif";
    float cCt = com.baidu.swan.apps.ap.ah.N(10.0f);
    boolean cCu = false;
    boolean mItalic = false;
    boolean cCv = true;

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
                        this.cCu = true;
                    } else if (str.contains("normal")) {
                        this.cCv = true;
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
                        this.cCt = com.baidu.swan.apps.ap.ah.N(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.cCs = str;
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
        if (this.cCu && this.mItalic) {
            i = 3;
        } else if (this.cCu) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.cBV.setTypeface(Typeface.create(this.cCs, i));
        bVar.cBV.setTextSize(this.cCt);
    }
}
