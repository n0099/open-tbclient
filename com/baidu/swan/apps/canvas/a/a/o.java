package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class o extends a {
    String bTb = "sans-serif";
    float bTc = com.baidu.swan.apps.aq.ag.D(10.0f);
    boolean bTd = false;
    boolean mItalic = false;
    boolean bTe = true;

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
                        this.bTd = true;
                    } else if (str.contains("normal")) {
                        this.bTe = true;
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
                        this.bTc = com.baidu.swan.apps.aq.ag.D(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.bTb = str;
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
        if (this.bTd && this.mItalic) {
            i = 3;
        } else if (this.bTd) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.bSE.setTypeface(Typeface.create(this.bTb, i));
        bVar.bSE.setTextSize(this.bTc);
    }
}
