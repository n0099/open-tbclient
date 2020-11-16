package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.ap.ah;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends a {
    public String cAI;
    public float cAJ;
    public boolean cAK;
    public boolean cAL;
    public boolean mItalic;
    public String mText;

    public d(String str) {
        super(str);
        String[] split;
        this.cAI = "sans-serif";
        this.cAJ = ah.M(10.0f);
        this.cAK = false;
        this.mItalic = false;
        this.cAL = true;
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
                        this.cAK = true;
                    } else if (str2.contains("normal")) {
                        this.cAL = true;
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
                        this.cAJ = ah.M(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.cAI = str2;
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
