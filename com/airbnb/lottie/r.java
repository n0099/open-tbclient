package com.airbnb.lottie;

import java.util.Map;
/* loaded from: classes6.dex */
public class r {
    private final Map<String, String> BI;
    private boolean BJ;

    private String bb(String str) {
        return str;
    }

    public final String bc(String str) {
        if (this.BJ && this.BI.containsKey(str)) {
            return this.BI.get(str);
        }
        String bb = bb(str);
        if (this.BJ) {
            this.BI.put(str, bb);
            return bb;
        }
        return bb;
    }
}
