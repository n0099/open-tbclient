package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private final Map<String, String> of;
    private boolean og;

    public String Z(String str) {
        return str;
    }

    public final String aa(String str) {
        if (this.og && this.of.containsKey(str)) {
            return this.of.get(str);
        }
        String Z = Z(str);
        if (this.og) {
            this.of.put(str, Z);
            return Z;
        }
        return Z;
    }
}
