package com.baidu.android.glview;

import android.view.Surface;
/* loaded from: classes19.dex */
public class GL2JNILib {
    public static native void close(int i);

    public static native int create();

    public static native int getSTMatrixHandle(int i);

    public static native void init(int i, GL2RenderJNIView gL2RenderJNIView);

    public static native void ratio(int i, int i2);

    public static native void render(int i);

    public static native void setSurfaceTex(int i, Surface surface, int i2);

    public static native void setviewport(int i, int i2, int i3);

    public static native void stretch(int i, int i2);

    public static native void transform(int i, float f, float f2, float f3, float f4, int i2);
}
