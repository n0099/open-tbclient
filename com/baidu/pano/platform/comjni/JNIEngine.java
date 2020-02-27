package com.baidu.pano.platform.comjni;

import android.graphics.Bitmap;
/* loaded from: classes8.dex */
public class JNIEngine {
    public static native boolean addCustomMarkerByBitmap(String str, double d, double d2, double d3, Bitmap bitmap);

    public static native boolean addCustomMarkerByText(String str, double d, double d2, double d3, String str2, float f, int i, int i2, int i3);

    public static native boolean addCustomMarkerByURL(String str, double d, double d2, double d3, String str2, float f, float f2);

    public static native void addPoiMarker(double d, double d2, double d3);

    public static native void clearScene();

    public static native void destroySurface();

    public static native void enableFastMove(boolean z);

    public static native float getCameraFOV();

    public static native float getCameraRotation(int i);

    public static native void initEngine(Object obj);

    public static native void onSurfaceChanged(Object obj, int i, int i2, int i3);

    public static native void pause();

    public static native void procClickEvent(float f, float f2);

    public static native boolean removeAllCustomMarker();

    public static native boolean removeCustomMarker(String str);

    public static native void removePoiMarker();

    public static native void resume();

    public static native double[] screenPt2Mercator(float f, float f2);

    public static native boolean setArrowShow(boolean z);

    public static native boolean setArrowTextStyle(int i, int i2, int i3);

    public static native boolean setArrowTextureByBitmap(Bitmap bitmap);

    public static native boolean setArrowTextureByUrl(String str);

    public static native void setArrowVisibility(boolean z);

    public static native void setCameraFOV(float f);

    public static native void setCameraRotationByAngle(float f, float f2, float f3);

    public static native void setCameraRotationBySpace(float f, float f2);

    public static native void setCumtomMarkerShow(boolean z);

    public static native boolean setCustomMarkerAnchor(String str, float f, float f2);

    public static native void setEntranceBitmap(Bitmap bitmap);

    public static native void setMarkerVisibility(boolean z);

    public static native void setPanoramaByMercator(double d, double d2);

    public static native void setPanoramaByPid(String str);

    public static native void setPanoramaByUid(String str);

    public static native void setPitchLimit(float f, float f2);

    public static native void setPoiBitmap(Bitmap bitmap);

    public static native void setPoiMarkerVisibility(boolean z);

    public static native void setTexureLevel(int i);

    public static native boolean showCertifyMarkerByText(String str, float f, int i, int i2, long j);
}
