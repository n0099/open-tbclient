package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes2.dex */
public class PolygonHoleOptions extends HoleOptions {
    public List<LatLng> a;

    public PolygonHoleOptions() {
        this.mHoleType = "polygon";
    }

    public List<LatLng> getHolePoints() {
        return this.a;
    }

    public PolygonHoleOptions addPoints(List<LatLng> list) {
        if (list != null && list.size() >= 3) {
            this.a = list;
            return this;
        }
        Log.e("baidumapsdk", "PolygonHole's points can not be null or points's size can not be less than three");
        return this;
    }
}
