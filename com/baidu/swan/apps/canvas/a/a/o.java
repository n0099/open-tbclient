package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class o extends a {
    String cbG = "sans-serif";
    float cbH = com.baidu.swan.apps.ap.ah.H(10.0f);
    boolean cbI = false;
    boolean mItalic = false;
    boolean cbJ = true;

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
                        this.cbI = true;
                    } else if (str.contains("normal")) {
                        this.cbJ = true;
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
                        this.cbH = com.baidu.swan.apps.ap.ah.H(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.cbG = str;
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
        if (this.cbI && this.mItalic) {
            i = 3;
        } else if (this.cbI) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.cbj.setTypeface(Typeface.create(this.cbG, i));
        bVar.cbj.setTextSize(this.cbH);
    }
}
