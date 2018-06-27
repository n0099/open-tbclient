package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private final Map<String, String> ld;
    private boolean le;

    public String I(String str) {
        return str;
    }

    public final String J(String str) {
        if (this.le && this.ld.containsKey(str)) {
            return this.ld.get(str);
        }
        String I = I(str);
        if (this.le) {
            this.ld.put(str, I);
            return I;
        }
        return I;
    }
}
