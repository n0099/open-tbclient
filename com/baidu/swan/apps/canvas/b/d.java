package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.ao.ah;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d extends a {
    public String cMt;
    public float cMu;
    public boolean cMv;
    public boolean cMw;
    public boolean mItalic;
    public String mText;

    public d(String str) {
        super(str);
        String[] split;
        this.cMt = "sans-serif";
        this.cMu = ah.O(10.0f);
        this.cMv = false;
        this.mItalic = false;
        this.cMw = true;
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
                        this.cMv = true;
                    } else if (str2.contains("normal")) {
                        this.cMw = true;
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
                        this.cMu = ah.O(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.cMt = str2;
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
