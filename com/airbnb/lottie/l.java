package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private final Map<String, String> le;
    private boolean lf;

    public String I(String str) {
        return str;
    }

    public final String J(String str) {
        if (this.lf && this.le.containsKey(str)) {
            return this.le.get(str);
        }
        String I = I(str);
        if (this.lf) {
            this.le.put(str, I);
            return I;
        }
        return I;
    }
}
