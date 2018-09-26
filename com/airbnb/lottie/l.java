package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private final Map<String, String> ny;
    private boolean nz;

    public String Z(String str) {
        return str;
    }

    public final String aa(String str) {
        if (this.nz && this.ny.containsKey(str)) {
            return this.ny.get(str);
        }
        String Z = Z(str);
        if (this.nz) {
            this.ny.put(str, Z);
            return Z;
        }
        return Z;
    }
}
