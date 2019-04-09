package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class o extends a {
    String alP = "sans-serif";
    float alQ = com.baidu.swan.apps.an.x.ad(10.0f);
    boolean alR = false;
    boolean mItalic = false;
    boolean alS = true;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        String[] split;
        try {
            if (jSONArray.length() > 0) {
                for (String str : jSONArray.optString(0).split(" ")) {
                    if (str.contains("italic")) {
                        this.mItalic = true;
                    } else if (str.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str.contains("bold")) {
                        this.alR = true;
                    } else if (str.contains("normal")) {
                        this.alS = true;
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
                        this.alQ = com.baidu.swan.apps.an.x.ad(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.alP = str;
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
        if (this.alR && this.mItalic) {
            i = 3;
        } else if (this.alR) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.aln.setTypeface(Typeface.create(this.alP, i));
        bVar.aln.setTextSize(this.alQ);
    }
}
