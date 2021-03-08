package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class o extends a {
    String cLz = "sans-serif";
    float cLA = com.baidu.swan.apps.ao.ah.T(10.0f);
    boolean cLB = false;
    boolean mItalic = false;
    boolean cLC = true;

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
                        this.cLB = true;
                    } else if (str.contains("normal")) {
                        this.cLC = true;
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
                        this.cLA = com.baidu.swan.apps.ao.ah.T(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.cLz = str;
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
        if (this.cLB && this.mItalic) {
            i = 3;
        } else if (this.cLB) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.cLc.setTypeface(Typeface.create(this.cLz, i));
        bVar.cLc.setTextSize(this.cLA);
    }
}
