package com.baidu.swan.apps.canvas.c;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.swan.apps.an.z;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {
    public String aGc;
    public float aGd;
    public boolean aGe;
    public boolean aGf;
    public boolean mItalic;
    public String mText;

    public d(String str) {
        super(str);
        String[] split;
        this.aGc = "sans-serif";
        this.aGd = z.S(10.0f);
        this.aGe = false;
        this.mItalic = false;
        this.aGf = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mText = jSONObject.optString("text");
            String optString = jSONObject.optString("font");
            if (optString != null && optString.length() > 0) {
                for (String str2 : optString.split(HanziToPinyin.Token.SEPARATOR)) {
                    if (str2.contains("italic")) {
                        this.mItalic = true;
                    } else if (str2.contains("oblique")) {
                        this.mItalic = true;
                    } else if (str2.contains("bold")) {
                        this.aGe = true;
                    } else if (str2.contains("normal")) {
                        this.aGf = true;
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
                        this.aGd = z.S(Float.parseFloat(str2.substring(0, i)));
                    } else {
                        this.aGc = str2;
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
