package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private final Map<String, String> lH;
    private boolean lI;

    public String I(String str) {
        return str;
    }

    public final String J(String str) {
        if (this.lI && this.lH.containsKey(str)) {
            return this.lH.get(str);
        }
        String I = I(str);
        if (this.lI) {
            this.lH.put(str, I);
            return I;
        }
        return I;
    }
}
