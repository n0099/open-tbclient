package com.baidu.live.lottie;

import java.util.Map;
/* loaded from: classes10.dex */
public class s {
    private final Map<String, String> Do;
    private boolean Dp;

    private String bg(String str) {
        return str;
    }

    public final String bh(String str) {
        if (this.Dp && this.Do.containsKey(str)) {
            return this.Do.get(str);
        }
        String bg = bg(str);
        if (this.Dp) {
            this.Do.put(str, bg);
            return bg;
        }
        return bg;
    }
}
