package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class o extends a {
    String cHH = "sans-serif";
    float cHI = com.baidu.swan.apps.ao.ah.O(10.0f);
    boolean cHJ = false;
    boolean mItalic = false;
    boolean cHK = true;

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
                        this.cHJ = true;
                    } else if (str.contains("normal")) {
                        this.cHK = true;
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
                        this.cHI = com.baidu.swan.apps.ao.ah.O(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.cHH = str;
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
        if (this.cHJ && this.mItalic) {
            i = 3;
        } else if (this.cHJ) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.cHi.setTypeface(Typeface.create(this.cHH, i));
        bVar.cHi.setTextSize(this.cHI);
    }
}
