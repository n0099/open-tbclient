package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class o extends a {
    String amE = "sans-serif";
    float amF = com.baidu.swan.apps.an.z.ad(10.0f);
    boolean amG = false;
    boolean mItalic = false;
    boolean amH = true;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        String[] split;
        try {
            if (jSONArray.length() > 0) {
                for (String str : jSONArray.optString(0).split(" ")) {
                    if (str.contains("italic")) {
                        this.mItalic = true;
                    } else if (str.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str.contains("bold")) {
                        this.amG = true;
                    } else if (str.contains("normal")) {
                        this.amH = true;
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
                        this.amF = com.baidu.swan.apps.an.z.ad(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.amE = str;
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
        if (this.amG && this.mItalic) {
            i = 3;
        } else if (this.amG) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.amc.setTypeface(Typeface.create(this.amE, i));
        bVar.amc.setTextSize(this.amF);
    }
}
