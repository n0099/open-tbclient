package com.baidu.android.glview;
/* loaded from: classes.dex */
public class GL2JNILib {
    static {
        System.loadLibrary("gl2jni");
    }

    public static native void close();

    public static native void init();

    public static native void ratio(int i);

    public static native void render();

    public static native void setviewport(int i, int i2);

    public static native void stretch(int i);

    public static native void transform(float f, float f2, float f3, float f4, int i);
}
