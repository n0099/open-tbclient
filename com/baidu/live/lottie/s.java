package com.baidu.live.lottie;

import java.util.Map;
/* loaded from: classes9.dex */
public class s {
    private final Map<String, String> EK;
    private boolean EL;

    private String bk(String str) {
        return str;
    }

    public final String bl(String str) {
        if (this.EL && this.EK.containsKey(str)) {
            return this.EK.get(str);
        }
        String bk = bk(str);
        if (this.EL) {
            this.EK.put(str, bk);
            return bk;
        }
        return bk;
    }
}
