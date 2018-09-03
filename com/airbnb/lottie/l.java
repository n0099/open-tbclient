package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private final Map<String, String> kW;
    private boolean kX;

    public String I(String str) {
        return str;
    }

    public final String J(String str) {
        if (this.kX && this.kW.containsKey(str)) {
            return this.kW.get(str);
        }
        String I = I(str);
        if (this.kX) {
            this.kW.put(str, I);
            return I;
        }
        return I;
    }
}
