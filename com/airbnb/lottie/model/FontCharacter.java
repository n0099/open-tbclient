package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes9.dex */
public class FontCharacter {
    public final char character;
    public final String fontFamily;
    public final List<ShapeGroup> shapes;
    public final double size;
    public final String style;
    public final double width;

    public FontCharacter(List<ShapeGroup> list, char c2, double d2, double d3, String str, String str2) {
        this.shapes = list;
        this.character = c2;
        this.size = d2;
        this.width = d3;
        this.style = str;
        this.fontFamily = str2;
    }

    public static int hashFor(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<ShapeGroup> getShapes() {
        return this.shapes;
    }

    public double getSize() {
        return this.size;
    }

    public String getStyle() {
        return this.style;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return hashFor(this.character, this.fontFamily, this.style);
    }
}
