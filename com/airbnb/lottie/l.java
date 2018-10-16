package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private final Map<String, String> ol;
    private boolean om;

    public String Z(String str) {
        return str;
    }

    public final String aa(String str) {
        if (this.om && this.ol.containsKey(str)) {
            return this.ol.get(str);
        }
        String Z = Z(str);
        if (this.om) {
            this.ol.put(str, Z);
            return Z;
        }
        return Z;
    }
}
