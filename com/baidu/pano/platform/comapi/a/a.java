package com.baidu.pano.platform.comapi.a;

import android.os.Bundle;
import com.baidu.lbsapi.panoramaview.OnTabMarkListener;
import com.baidu.lbsapi.tools.Point;
import com.baidu.pano.platform.comjni.JNITool;
/* loaded from: classes2.dex */
public abstract class a {
    public static final int MARKERTYPE_IMAGE_RES = 1002;
    public static final int MARKERTYPE_IMAGE_URL = 1001;
    public static final int MARKERTYPE_POI = 1004;
    public static final int MARKERTYPE_TXT = 1003;
    public float mHeight;
    public String mKey;
    public double mLatitude;
    public OnTabMarkListener mListener;
    public double mLongitude;

    public void setMarkerHeight(float f2) {
        this.mHeight = f2;
    }

    public void setMarkerPosition(Point point) {
        this.mLongitude = point.x;
        this.mLatitude = point.y;
    }

    public void setOnTabMarkListener(OnTabMarkListener onTabMarkListener) {
        this.mListener = onTabMarkListener;
    }

    public Bundle toBundle(String str, Bundle bundle) {
        this.mKey = str;
        bundle.putString("key", str);
        double d2 = this.mLongitude;
        if (d2 > 1000000.0d && this.mLatitude > 100000.0d) {
            bundle.putDouble("x", d2 * 100.0d);
            bundle.putDouble("y", this.mLatitude * 100.0d);
        } else {
            bundle.putDouble("x", JNITool.ll2mc(this.mLongitude, this.mLatitude).x * 100.0d);
            bundle.putDouble("y", JNITool.ll2mc(this.mLongitude, this.mLatitude).y * 100.0d);
        }
        bundle.putFloat("z", this.mHeight * 100.0f);
        return bundle;
    }
}
