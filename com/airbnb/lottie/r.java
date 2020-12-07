package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes7.dex */
public class r {
    private final Map<String, String> DC;
    private boolean DD;

    private String bj(String str) {
        return str;
    }

    public final String bk(String str) {
        if (this.DD && this.DC.containsKey(str)) {
            return this.DC.get(str);
        }
        String bj = bj(str);
        if (this.DD) {
            this.DC.put(str, bj);
            return bj;
        }
        return bj;
    }
}
