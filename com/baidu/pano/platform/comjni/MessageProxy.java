package com.baidu.pano.platform.comjni;

import com.baidu.lbsapi.model.StatisticsEvent;
import com.baidu.pano.platform.c.g;
import com.baidu.pano.platform.comapi.map.b;
/* loaded from: classes8.dex */
public class MessageProxy {
    private static b mListener;

    public static void registerPanoViewListener(b bVar) {
        mListener = bVar;
    }

    public static void unRegisterPanoViewListener() {
        mListener = null;
    }

    public static void initEngineStart() {
        g.a("initEngineStart");
        b bVar = mListener;
        if (bVar != null) {
            bVar.a();
        }
    }

    public static void initEngineEnd(boolean z) {
        g.a("initEngineEnd");
        b bVar = mListener;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public static void thumbLoadStart() {
        g.a("thumbLoadStart");
        b bVar = mListener;
        if (bVar != null) {
            bVar.b();
        }
    }

    public static void thumbLoadEnd(boolean z) {
        g.a("thumbLoadEnd");
        b bVar = mListener;
        if (bVar != null) {
            bVar.b(z);
        }
    }

    public static void descriptionLoadStart() {
        g.a("descriptionLoadStart");
        b bVar = mListener;
        if (bVar != null) {
            bVar.c();
        }
    }

    public static void descriptionLoadEvent(String str, boolean z) {
        g.a("descriptionLoadEvent:" + str);
        b bVar = mListener;
        if (bVar != null) {
            bVar.a(str, z);
        }
    }

    public static void onMoveStart() {
        g.a("onMoveStart");
        b bVar = mListener;
        if (bVar != null) {
            bVar.d();
        }
    }

    public static void onMoveEnd() {
        g.a("onMoveEnd");
        b bVar = mListener;
        if (bVar != null) {
            bVar.e();
        }
    }

    public static void onCustomMarkerClick(String str) {
        g.a("onCustomMarkerClick");
        b bVar = mListener;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public static void onPoiMarkerClick() {
        g.a(StatisticsEvent.ON_POI_MARKER_CLICK);
        b bVar = mListener;
        if (bVar != null) {
            bVar.f();
        }
    }

    public static void onPoiEntranceClick() {
        g.a(StatisticsEvent.ON_POI_ENTRANCE_CLICK);
        b bVar = mListener;
        if (bVar != null) {
            bVar.g();
        }
    }

    public static void onMessage(String str, int i, byte[] bArr, int i2) {
        g.a("onMessage");
        b bVar = mListener;
        if (bVar != null) {
            bVar.a(str, i, bArr, i2);
        }
    }
}
