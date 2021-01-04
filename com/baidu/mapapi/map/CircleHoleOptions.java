package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mobstat.Config;
/* loaded from: classes15.dex */
public class CircleHoleOptions extends HoleOptions {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2804a;

    /* renamed from: b  reason: collision with root package name */
    private int f2805b;

    public CircleHoleOptions() {
        this.mHoleType = Config.TRACE_CIRCLE;
    }

    public CircleHoleOptions center(LatLng latLng) {
        if (latLng == null) {
            Log.e("baidumapsdk", "CircleHole center can not be null");
        } else {
            this.f2804a = latLng;
        }
        return this;
    }

    public LatLng getHoleCenter() {
        return this.f2804a;
    }

    public int getHoleRadius() {
        return this.f2805b;
    }

    public CircleHoleOptions radius(int i) {
        if (i <= 0) {
            Log.e("baidumapsdk", "CircleHole's radius can not be less than zero");
        } else {
            this.f2805b = i;
        }
        return this;
    }
}
