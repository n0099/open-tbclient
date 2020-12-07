package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public class c {
    private final String Fw;
    private final float Fx;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.Fw = str;
        this.name = str2;
        this.style = str3;
        this.Fx = f;
    }

    public String jx() {
        return this.Fw;
    }

    public String getName() {
        return this.name;
    }

    public String jy() {
        return this.style;
    }
}
