package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.an.x;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {
    public String alN;
    public String alO;
    public float alP;
    public boolean alQ;
    public boolean alR;
    public boolean mItalic;

    public d(String str) {
        super(str);
        String[] split;
        this.alO = "sans-serif";
        this.alP = x.ad(10.0f);
        this.alQ = false;
        this.mItalic = false;
        this.alR = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.alN = jSONObject.optString("text");
            String optString = jSONObject.optString("font");
            if (optString != null && optString.length() > 0) {
                for (String str2 : optString.split(" ")) {
                    if (str2.contains("italic")) {
                        this.mItalic = true;
                    } else if (str2.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str2.contains("bold")) {
                        this.alQ = true;
                    } else if (str2.contains("normal")) {
                        this.alR = true;
                    } else if (Character.isDigit(str2.charAt(0))) {
                        int length = str2.length();
                        int i = 0;
                        while (true) {
                            if (i >= str2.length()) {
                                i = length;
                                break;
                            } else if (!Character.isDigit(str2.charAt(i))) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        this.alP = x.ad(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.alO = str2;
                    }
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
