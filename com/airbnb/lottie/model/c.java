package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class c {
    private final String DH;
    private final float DI;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.DH = str;
        this.name = str2;
        this.style = str3;
        this.DI = f;
    }

    public String hU() {
        return this.DH;
    }

    public String getName() {
        return this.name;
    }

    public String hV() {
        return this.style;
    }
}
