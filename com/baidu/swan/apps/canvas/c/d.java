package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.an.z;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {
    public String ama;
    public String amb;
    public float amc;
    public boolean amd;
    public boolean ame;
    public boolean mItalic;

    public d(String str) {
        super(str);
        String[] split;
        this.amb = "sans-serif";
        this.amc = z.ad(10.0f);
        this.amd = false;
        this.mItalic = false;
        this.ame = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ama = jSONObject.optString("text");
            String optString = jSONObject.optString("font");
            if (optString != null && optString.length() > 0) {
                for (String str2 : optString.split(" ")) {
                    if (str2.contains("italic")) {
                        this.mItalic = true;
                    } else if (str2.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str2.contains("bold")) {
                        this.amd = true;
                    } else if (str2.contains("normal")) {
                        this.ame = true;
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
                        this.amc = z.ad(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.amb = str2;
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
