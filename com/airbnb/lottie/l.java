package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private final Map<String, String> lG;
    private boolean lH;

    public String I(String str) {
        return str;
    }

    public final String J(String str) {
        if (this.lH && this.lG.containsKey(str)) {
            return this.lG.get(str);
        }
        String I = I(str);
        if (this.lH) {
            this.lG.put(str, I);
            return I;
        }
        return I;
    }
}
