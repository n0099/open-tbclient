package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.an.x;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {
    public String alI;
    public String alJ;
    public float alK;
    public boolean alL;
    public boolean alM;
    public boolean mItalic;

    public d(String str) {
        super(str);
        String[] split;
        this.alJ = "sans-serif";
        this.alK = x.ad(10.0f);
        this.alL = false;
        this.mItalic = false;
        this.alM = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.alI = jSONObject.optString("text");
            String optString = jSONObject.optString("font");
            if (optString != null && optString.length() > 0) {
                for (String str2 : optString.split(" ")) {
                    if (str2.contains("italic")) {
                        this.mItalic = true;
                    } else if (str2.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str2.contains("bold")) {
                        this.alL = true;
                    } else if (str2.contains("normal")) {
                        this.alM = true;
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
                        this.alK = x.ad(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.alJ = str2;
                    }
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
