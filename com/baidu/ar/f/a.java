package com.baidu.ar.f;
/* loaded from: classes3.dex */
public final class a {
    public static String mPackageName = null;

    public static String aH(String str) {
        return str + "/face_metadata.json";
    }

    public static void setPackageName(String str) {
        if (mPackageName == null) {
            mPackageName = str;
        }
    }
}
