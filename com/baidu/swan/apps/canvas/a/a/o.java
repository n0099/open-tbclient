package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class o extends a {
    String cnW = "sans-serif";
    float cnX = com.baidu.swan.apps.ap.ah.J(10.0f);
    boolean cnY = false;
    boolean mItalic = false;
    boolean cnZ = true;

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
                        this.cnY = true;
                    } else if (str.contains("normal")) {
                        this.cnZ = true;
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
                        this.cnX = com.baidu.swan.apps.ap.ah.J(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.cnW = str;
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
        if (this.cnY && this.mItalic) {
            i = 3;
        } else if (this.cnY) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.cnz.setTypeface(Typeface.create(this.cnW, i));
        bVar.cnz.setTextSize(this.cnX);
    }
}
