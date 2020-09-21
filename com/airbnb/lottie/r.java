package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes6.dex */
public class r {
    private final Map<String, String> Co;
    private boolean Cp;

    private String bg(String str) {
        return str;
    }

    public final String bh(String str) {
        if (this.Cp && this.Co.containsKey(str)) {
            return this.Co.get(str);
        }
        String bg = bg(str);
        if (this.Cp) {
            this.Co.put(str, bg);
            return bg;
        }
        return bg;
    }
}
