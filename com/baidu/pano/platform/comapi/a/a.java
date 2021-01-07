package com.baidu.pano.platform.comapi.a;

import android.os.Bundle;
import com.baidu.lbsapi.panoramaview.OnTabMarkListener;
import com.baidu.lbsapi.tools.Point;
import com.baidu.pano.platform.comjni.JNITool;
import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes3.dex */
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

    public void setOnTabMarkListener(OnTabMarkListener onTabMarkListener) {
        this.mListener = onTabMarkListener;
    }

    public Bundle toBundle(String str, Bundle bundle) {
        this.mKey = str;
        bundle.putString("key", str);
        if (this.mLongitude > 1000000.0d && this.mLatitude > 100000.0d) {
            bundle.putDouble("x", this.mLongitude * 100.0d);
            bundle.putDouble("y", this.mLatitude * 100.0d);
        } else {
            bundle.putDouble("x", JNITool.ll2mc(this.mLongitude, this.mLatitude).x * 100.0d);
            bundle.putDouble("y", JNITool.ll2mc(this.mLongitude, this.mLatitude).y * 100.0d);
        }
        bundle.putFloat(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mHeight * 100.0f);
        return bundle;
    }

    public void setMarkerHeight(float f) {
        this.mHeight = f;
    }

    public void setMarkerPosition(Point point) {
        this.mLongitude = point.x;
        this.mLatitude = point.y;
    }
}
