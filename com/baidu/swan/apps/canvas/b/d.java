package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.ap.ah;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a {
    public String cbG;
    public float cbH;
    public boolean cbI;
    public boolean cbJ;
    public boolean mItalic;
    public String mText;

    public d(String str) {
        super(str);
        String[] split;
        this.cbG = "sans-serif";
        this.cbH = ah.H(10.0f);
        this.cbI = false;
        this.mItalic = false;
        this.cbJ = true;
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
                        this.cbI = true;
                    } else if (str2.contains("normal")) {
                        this.cbJ = true;
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
                        this.cbH = ah.H(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.cbG = str2;
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
