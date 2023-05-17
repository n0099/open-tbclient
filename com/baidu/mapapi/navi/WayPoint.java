package com.baidu.mapapi.navi;

import java.util.List;
/* loaded from: classes3.dex */
public class WayPoint {
    public List<WayPointInfo> a;

    public WayPoint(List<WayPointInfo> list) {
        if (list == null) {
            return;
        }
        this.a = list;
    }

    public List<WayPointInfo> getViaPoints() {
        return this.a;
    }
}
