package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.an.x;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {
    public String alJ;
    public String alK;
    public float alL;
    public boolean alM;
    public boolean alN;
    public boolean mItalic;

    public d(String str) {
        super(str);
        String[] split;
        this.alK = "sans-serif";
        this.alL = x.ad(10.0f);
        this.alM = false;
        this.mItalic = false;
        this.alN = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.alJ = jSONObject.optString("text");
            String optString = jSONObject.optString("font");
            if (optString != null && optString.length() > 0) {
                for (String str2 : optString.split(" ")) {
                    if (str2.contains("italic")) {
                        this.mItalic = true;
                    } else if (str2.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str2.contains("bold")) {
                        this.alM = true;
                    } else if (str2.contains("normal")) {
                        this.alN = true;
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
                        this.alL = x.ad(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.alK = str2;
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
