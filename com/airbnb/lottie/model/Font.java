package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public class Font {
    public final float ascent;
    public final String family;
    public final String name;
    public final String style;

    public Font(String str, String str2, String str3, float f2) {
        this.family = str;
        this.name = str2;
        this.style = str3;
        this.ascent = f2;
    }

    public float getAscent() {
        return this.ascent;
    }

    public String getFamily() {
        return this.family;
    }

    public String getName() {
        return this.name;
    }

    public String getStyle() {
        return this.style;
    }
}
