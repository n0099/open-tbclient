package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class d {
    private final char GF;
    private final double Gv;
    private final String fontFamily;
    private final List<j> shapes;
    private final String style;
    private final double width;

    public static int b(char c, String str, String str2) {
        return ((((c + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<j> list, char c, double d, double d2, String str, String str2) {
        this.shapes = list;
        this.GF = c;
        this.Gv = d;
        this.width = d2;
        this.style = str;
        this.fontFamily = str2;
    }

    public List<j> iX() {
        return this.shapes;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return b(this.GF, this.fontFamily, this.style);
    }
}
