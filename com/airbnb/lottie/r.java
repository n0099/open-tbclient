package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes5.dex */
public class r {
    private final Map<String, String> fC;
    private boolean fD;

    private String K(String str) {
        return str;
    }

    public final String L(String str) {
        if (this.fD && this.fC.containsKey(str)) {
            return this.fC.get(str);
        }
        String K = K(str);
        if (this.fD) {
            this.fC.put(str, K);
            return K;
        }
        return K;
    }
}
