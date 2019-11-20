package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private final Map<String, String> dI;
    private boolean dJ;

    public String I(String str) {
        return str;
    }

    public final String J(String str) {
        if (this.dJ && this.dI.containsKey(str)) {
            return this.dI.get(str);
        }
        String I = I(str);
        if (this.dJ) {
            this.dI.put(str, I);
            return I;
        }
        return I;
    }
}
