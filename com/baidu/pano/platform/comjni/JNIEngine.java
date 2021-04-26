package com.baidu.pano.platform.comjni;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class JNIEngine {
    public static native boolean addCustomMarkerByBitmap(String str, double d2, double d3, double d4, Bitmap bitmap);

    public static native boolean addCustomMarkerByText(String str, double d2, double d3, double d4, String str2, float f2, int i2, int i3, int i4);

    public static native boolean addCustomMarkerByURL(String str, double d2, double d3, double d4, String str2, float f2, float f3);

    public static native void addPoiMarker(double d2, double d3, double d4);

    public static native void clearScene();

    public static native void destroySurface();

    public static native void enableFastMove(boolean z);

    public static native float getCameraFOV();

    public static native float getCameraRotation(int i2);

    public static native void initEngine(Object obj);

    public static native void onSurfaceChanged(Object obj, int i2, int i3, int i4);

    public static native void pause();

    public static native void procClickEvent(float f2, float f3);

    public static native boolean removeAllCustomMarker();

    public static native boolean removeCustomMarker(String str);

    public static native void removePoiMarker();

    public static native void resume();

    public static native double[] screenPt2Mercator(float f2, float f3);

    public static native boolean setArrowShow(boolean z);

    public static native boolean setArrowTextStyle(int i2, int i3, int i4);

    public static native boolean setArrowTextureByBitmap(Bitmap bitmap);

    public static native boolean setArrowTextureByUrl(String str);

    public static native void setArrowVisibility(boolean z);

    public static native void setCameraFOV(float f2);

    public static native void setCameraRotationByAngle(float f2, float f3, float f4);

    public static native void setCameraRotationBySpace(float f2, float f3);

    public static native void setCumtomMarkerShow(boolean z);

    public static native boolean setCustomMarkerAnchor(String str, float f2, float f3);

    public static native void setEntranceBitmap(Bitmap bitmap);

    public static native void setMarkerVisibility(boolean z);

    public static native void setPanoramaByMercator(double d2, double d3);

    public static native void setPanoramaByPid(String str);

    public static native void setPanoramaByUid(String str);

    public static native void setPitchLimit(float f2, float f3);

    public static native void setPoiBitmap(Bitmap bitmap);

    public static native void setPoiMarkerVisibility(boolean z);

    public static native void setTexureLevel(int i2);

    public static native boolean showCertifyMarkerByText(String str, float f2, int i2, int i3, long j);
}
