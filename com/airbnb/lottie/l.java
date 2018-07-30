package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private final Map<String, String> kV;
    private boolean kW;

    public String I(String str) {
        return str;
    }

    public final String J(String str) {
        if (this.kW && this.kV.containsKey(str)) {
            return this.kV.get(str);
        }
        String I = I(str);
        if (this.kW) {
            this.kV.put(str, I);
            return I;
        }
        return I;
    }
}
