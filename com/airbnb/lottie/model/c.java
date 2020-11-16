package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes16.dex */
public class c {
    private final String EF;
    private final float EG;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.EF = str;
        this.name = str2;
        this.style = str3;
        this.EG = f;
    }

    public String jx() {
        return this.EF;
    }

    public String getName() {
        return this.name;
    }

    public String jy() {
        return this.style;
    }
}
