package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class o extends a {
    String bTT = "sans-serif";
    float bTU = com.baidu.swan.apps.aq.ai.D(10.0f);
    boolean bTV = false;
    boolean mItalic = false;
    boolean bTW = true;

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
                        this.bTV = true;
                    } else if (str.contains("normal")) {
                        this.bTW = true;
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
                        this.bTU = com.baidu.swan.apps.aq.ai.D(Float.parseFloat(str.substring(0, i)));
                    } else {
                        this.bTT = str;
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
        if (this.bTV && this.mItalic) {
            i = 3;
        } else if (this.bTV) {
            i = 1;
        } else if (this.mItalic) {
            i = 2;
        }
        bVar.bTw.setTypeface(Typeface.create(this.bTT, i));
        bVar.bTw.setTextSize(this.bTU);
    }
}
