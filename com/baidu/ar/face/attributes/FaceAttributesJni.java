package com.baidu.ar.face.attributes;

import android.content.res.AssetManager;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class FaceAttributesJni {
    protected static boolean nX;

    static {
        nX = false;
        try {
            com.baidu.ar.libloader.a.require("FaceAttributes");
            nX = true;
        } catch (Throwable th) {
            nX = false;
            th.printStackTrace();
        }
    }

    public static native int getVersion();

    public static native synchronized int initGenderDetect(String str);

    public static native synchronized int initGenderDetectFromAssets(String str);

    public static native synchronized int predictGenderDetect(ByteBuffer byteBuffer, int i, int i2, float[] fArr, float[] fArr2);

    public static native synchronized int releaseGenderDetect();

    public static native int setAssetManager(AssetManager assetManager);
}
