package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class c {
    private final String Dc;
    private final float Dd;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.Dc = str;
        this.name = str2;
        this.style = str3;
        this.Dd = f;
    }

    public String hE() {
        return this.Dc;
    }

    public String getName() {
        return this.name;
    }

    public String hF() {
        return this.style;
    }
}
