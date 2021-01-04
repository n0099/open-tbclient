package com.baidu.live.lottie;

import java.util.Map;
/* loaded from: classes10.dex */
public class s {
    private final Map<String, String> Dq;
    private boolean Dr;

    private String bg(String str) {
        return str;
    }

    public final String bh(String str) {
        if (this.Dr && this.Dq.containsKey(str)) {
            return this.Dq.get(str);
        }
        String bg = bg(str);
        if (this.Dr) {
            this.Dq.put(str, bg);
            return bg;
        }
        return bg;
    }
}
