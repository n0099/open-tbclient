package com.airbnb.lottie.model;
/* loaded from: classes3.dex */
public class Marker {
    public static String CARRIAGE_RETURN = "\r";
    public final float durationFrames;
    public final String name;
    public final float startFrame;

    public Marker(String str, float f2, float f3) {
        this.name = str;
        this.durationFrames = f3;
        this.startFrame = f2;
    }

    public boolean matchesName(String str) {
        if (this.name.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.name.endsWith(CARRIAGE_RETURN)) {
            String str2 = this.name;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
