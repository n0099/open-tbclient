package com.baidu.platform.comapi.wnplatform.walkmap;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapsdkplatform.comjni.map.basemap.JNIBaseMap;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.net.BdNetTask;
/* loaded from: classes2.dex */
public class WNaviBaiduMap {

    /* renamed from: b  reason: collision with root package name */
    public static long f10382b;

    /* renamed from: c  reason: collision with root package name */
    public static WNaviBaiduMap f10383c;

    /* renamed from: a  reason: collision with root package name */
    public JNIBaseMap f10384a = new JNIBaseMap();

    public static void clearOverlay(Overlay overlay) {
        if (overlay instanceof Marker) {
            overlay.remove();
        }
    }

    public static void clearOverlays() {
    }

    public static long getId() {
        return f10382b;
    }

    public static synchronized WNaviBaiduMap getInstance() {
        WNaviBaiduMap wNaviBaiduMap;
        synchronized (WNaviBaiduMap.class) {
            if (f10383c == null) {
                f10383c = new WNaviBaiduMap();
            }
            wNaviBaiduMap = f10383c;
        }
        return wNaviBaiduMap;
    }

    public static int getScaleDis(int i) {
        switch (i) {
            case 1:
                return ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT;
            case 2:
                return 5000000;
            case 3:
                return 2000000;
            case 4:
                return 1000000;
            case 5:
                return 500000;
            case 6:
                return 200000;
            case 7:
                return 100000;
            case 8:
                return IMConstants.ERROR_BASE;
            case 9:
                return BdNetTask.TIMEOUT_READ;
            case 10:
                return 20000;
            case 11:
                return 10000;
            case 12:
                return 5000;
            case 13:
                return 2000;
            case 14:
                return 1000;
            case 15:
                return 500;
            case 16:
                return 200;
            case 17:
                return 100;
            case 18:
                return 50;
            case 19:
                return 20;
            case 20:
                return 10;
            case 21:
                return 5;
            case 22:
                return 2;
            default:
                return 0;
        }
    }

    public static void setCompassPosition(Point point) {
    }

    public static void showMapPoi(boolean z) {
    }

    public void SetStyleMode(int i) {
    }

    public float getZoomLevel() {
        return 3.0f;
    }

    public float getZoomToBound(Bundle bundle, int i, int i2) {
        bundle.putInt("hasHW", 1);
        bundle.putInt("width", i);
        bundle.putInt("height", i2);
        return this.f10384a.GetZoomToBound(f10382b, bundle);
    }

    public double getZoomUnitsInMeter() {
        return Math.pow(2.0d, 18.0f - getZoomLevel());
    }

    public void setId(long j) {
        f10382b = j;
    }

    public void setSatellite(boolean z) {
    }
}
