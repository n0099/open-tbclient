package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.ao.ah;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends a {
    public float cLA;
    public boolean cLB;
    public boolean cLC;
    public String cLz;
    public boolean mItalic;
    public String mText;

    public d(String str) {
        super(str);
        String[] split;
        this.cLz = "sans-serif";
        this.cLA = ah.T(10.0f);
        this.cLB = false;
        this.mItalic = false;
        this.cLC = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mText = jSONObject.optString("text");
            String optString = jSONObject.optString("font");
            if (optString != null && optString.length() > 0) {
                for (String str2 : optString.split(" ")) {
                    if (str2.contains("italic")) {
                        this.mItalic = true;
                    } else if (str2.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str2.contains("bold")) {
                        this.cLB = true;
                    } else if (str2.contains("normal")) {
                        this.cLC = true;
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
                        this.cLA = ah.T(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.cLz = str2;
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
