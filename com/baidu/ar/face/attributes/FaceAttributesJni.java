package com.baidu.ar.face.attributes;

import android.content.res.AssetManager;
import com.baidu.ar.libloader.b;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class FaceAttributesJni {
    protected static boolean mZ;

    static {
        mZ = false;
        try {
            b.ao("FaceAttributes");
            mZ = true;
        } catch (Throwable th) {
            mZ = false;
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
