package com.baidu.platform.comapi.wnplatform.p;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
/* loaded from: classes26.dex */
public class e {
    public static void a(String str, String str2, boolean z) {
        BaiduMap map;
        com.baidu.platform.comapi.wnplatform.walkmap.d J = com.baidu.platform.comapi.walknavi.b.a().J();
        if (J != null && J.a() != null && (map = J.a().getMap()) != null) {
            map.switchBaseIndoorMapFloor(str, str2);
            MapStatus mapStatus = map.getMapStatus();
            if (mapStatus != null && mapStatus.overlook != 0.0f) {
                map.setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder(mapStatus).overlook(0.0f).build()));
            }
        }
        if (z) {
            com.baidu.platform.comapi.walknavi.b.a().G().a(str2, str);
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
            com.baidu.platform.comapi.walknavi.b.a().I().run("强诱导转到分段");
            com.baidu.platform.comapi.walknavi.b.a().G().k();
        }
    }

    public static void a(boolean z) {
        BaiduMap map;
        com.baidu.platform.comapi.wnplatform.walkmap.d J = com.baidu.platform.comapi.walknavi.b.a().J();
        if (J != null && J.a() != null && (map = J.a().getMap()) != null) {
            map.setIndoorEnable(z);
        }
    }
}
