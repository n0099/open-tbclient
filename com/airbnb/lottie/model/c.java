package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class c {
    private final String GC;
    private final float GD;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.GC = str;
        this.name = str2;
        this.style = str3;
        this.GD = f;
    }

    public String iV() {
        return this.GC;
    }

    public String getName() {
        return this.name;
    }

    public String iW() {
        return this.style;
    }
}
