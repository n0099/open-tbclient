package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
import com.airbnb.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class d {
    private final char hC;
    private final String hD;
    private final double hs;
    private final List<j> shapes;
    private final String style;
    private final double width;

    public static int a(char c, String str, String str2) {
        return ((((c + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<j> list, char c, double d, double d2, String str, String str2) {
        this.shapes = list;
        this.hC = c;
        this.hs = d;
        this.width = d2;
        this.style = str;
        this.hD = str2;
    }

    public List<j> cj() {
        return this.shapes;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return a(this.hC, this.hD, this.style);
    }
}
