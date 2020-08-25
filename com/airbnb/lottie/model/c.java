package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes18.dex */
public class c {
    private final String En;
    private final float Eo;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.En = str;
        this.name = str2;
        this.style = str3;
        this.Eo = f;
    }

    public String jv() {
        return this.En;
    }

    public String getName() {
        return this.name;
    }

    public String jw() {
        return this.style;
    }
}
