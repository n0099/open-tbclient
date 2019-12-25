package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes4.dex */
public class c {
    private final String hw;
    private final float hx;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.hw = str;
        this.name = str2;
        this.style = str3;
        this.hx = f;
    }

    public String cg() {
        return this.hw;
    }

    public String getName() {
        return this.name;
    }

    public String ch() {
        return this.style;
    }
}
