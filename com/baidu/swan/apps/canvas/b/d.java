package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.ao.ah;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends a {
    public String cHH;
    public float cHI;
    public boolean cHJ;
    public boolean cHK;
    public boolean mItalic;
    public String mText;

    public d(String str) {
        super(str);
        String[] split;
        this.cHH = "sans-serif";
        this.cHI = ah.O(10.0f);
        this.cHJ = false;
        this.mItalic = false;
        this.cHK = true;
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
                        this.cHJ = true;
                    } else if (str2.contains("normal")) {
                        this.cHK = true;
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
                        this.cHI = ah.O(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.cHH = str2;
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
