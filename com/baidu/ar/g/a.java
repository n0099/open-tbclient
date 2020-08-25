package com.baidu.ar.g;
/* loaded from: classes11.dex */
public final class a {
    public static String mPackageName = null;

    public static String aM(String str) {
        return str + "/face_metadata.json";
    }

    public static void setPackageName(String str) {
        if (mPackageName == null) {
            mPackageName = str;
        }
    }
}
