package com.baidu.ar.h;
/* loaded from: classes10.dex */
public final class a {
    public static String mPackageName = null;

    public static String aP(String str) {
        return str + "/face_metadata.json";
    }

    public static void setPackageName(String str) {
        if (mPackageName == null) {
            mPackageName = str;
        }
    }
}
