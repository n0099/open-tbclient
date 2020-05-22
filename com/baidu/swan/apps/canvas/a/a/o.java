package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class o extends a {
    String bOn = "sans-serif";
    float bOo = com.baidu.swan.apps.aq.ag.B(10.0f);
    boolean bOp = false;
    boolean mItalic = false;
    boolean bOq = true;

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
                        this.bOp = true;
                    } else if (str.contains("normal")) {
                        this.bOq = true;
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
                        this.bOo = com.baidu.swan.apps.aq.ag.B(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.bOn = str;
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
        if (this.bOp && this.mItalic) {
            i = 3;
        } else if (this.bOp) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.bNQ.setTypeface(Typeface.create(this.bOn, i));
        bVar.bNQ.setTextSize(this.bOo);
    }
}
