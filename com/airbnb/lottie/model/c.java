package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public class c {
    private final String Fk;
    private final float Fl;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.Fk = str;
        this.name = str2;
        this.style = str3;
        this.Fl = f;
    }

    public String iW() {
        return this.Fk;
    }

    public String getName() {
        return this.name;
    }

    public String iX() {
        return this.style;
    }
}
