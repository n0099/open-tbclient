package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class c {
    private final String hA;
    private final float hB;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.hA = str;
        this.name = str2;
        this.style = str3;
        this.hB = f;
    }

    public String ch() {
        return this.hA;
    }

    public String getName() {
        return this.name;
    }

    public String ci() {
        return this.style;
    }
}
