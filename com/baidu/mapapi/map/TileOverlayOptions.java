package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class TileOverlayOptions {

    /* renamed from: c  reason: collision with root package name */
    public static Bundle f7040c = null;
    public static final String j = "TileOverlayOptions";

    /* renamed from: b  reason: collision with root package name */
    public TileProvider f7042b;
    public int datasource;
    public String urlString;

    /* renamed from: a  reason: collision with root package name */
    public int f7041a = 209715200;

    /* renamed from: d  reason: collision with root package name */
    public int f7043d = 20;

    /* renamed from: e  reason: collision with root package name */
    public int f7044e = 3;

    /* renamed from: f  reason: collision with root package name */
    public int f7045f = 15786414;

    /* renamed from: g  reason: collision with root package name */
    public int f7046g = -20037726;

    /* renamed from: h  reason: collision with root package name */
    public int f7047h = -15786414;
    public int i = 20037726;

    public TileOverlayOptions() {
        Bundle bundle = new Bundle();
        f7040c = bundle;
        bundle.putInt("rectr", this.f7045f);
        f7040c.putInt("rectb", this.f7046g);
        f7040c.putInt("rectl", this.f7047h);
        f7040c.putInt("rectt", this.i);
    }

    private TileOverlayOptions a(int i, int i2) {
        this.f7043d = i;
        this.f7044e = i2;
        return this;
    }

    public Bundle a() {
        f7040c.putString("url", this.urlString);
        f7040c.putInt("datasource", this.datasource);
        f7040c.putInt("maxDisplay", this.f7043d);
        f7040c.putInt("minDisplay", this.f7044e);
        f7040c.putInt("sdktiletmpmax", this.f7041a);
        return f7040c;
    }

    public TileOverlay a(BaiduMap baiduMap) {
        return new TileOverlay(baiduMap, this.f7042b);
    }

    public TileOverlayOptions setMaxTileTmp(int i) {
        this.f7041a = i;
        return this;
    }

    public TileOverlayOptions setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds != null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.northeast);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.southwest);
            double latitudeE6 = ll2mc.getLatitudeE6();
            double longitudeE6 = ll2mc2.getLongitudeE6();
            double latitudeE62 = ll2mc2.getLatitudeE6();
            double longitudeE62 = ll2mc.getLongitudeE6();
            if (latitudeE6 <= latitudeE62 || longitudeE62 <= longitudeE6) {
                Log.e(j, "bounds is illegal, use default bounds");
            } else {
                f7040c.putInt("rectr", (int) longitudeE62);
                f7040c.putInt("rectb", (int) latitudeE62);
                f7040c.putInt("rectl", (int) longitudeE6);
                f7040c.putInt("rectt", (int) latitudeE6);
            }
            return this;
        }
        throw new IllegalArgumentException("bound can not be null");
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        String str;
        String str2;
        int maxDisLevel;
        if (tileProvider == null) {
            return null;
        }
        if (!(tileProvider instanceof UrlTileProvider)) {
            if (!(tileProvider instanceof FileTileProvider)) {
                str = j;
                str2 = "tileProvider must be UrlTileProvider or FileTileProvider";
                Log.e(str, str2);
                return null;
            }
            this.datasource = 0;
            this.f7042b = tileProvider;
            maxDisLevel = tileProvider.getMaxDisLevel();
            int minDisLevel = tileProvider.getMinDisLevel();
            if (maxDisLevel <= 21) {
            }
            Log.e(j, "display level is illegal");
            return this;
        }
        this.datasource = 1;
        String tileUrl = ((UrlTileProvider) tileProvider).getTileUrl();
        if (tileUrl == null || "".equals(tileUrl) || !tileUrl.contains("{x}") || !tileUrl.contains("{y}") || !tileUrl.contains("{z}")) {
            str = j;
            str2 = "tile url template is illegal, must contains {x}、{y}、{z}";
            Log.e(str, str2);
            return null;
        }
        this.urlString = tileUrl;
        this.f7042b = tileProvider;
        maxDisLevel = tileProvider.getMaxDisLevel();
        int minDisLevel2 = tileProvider.getMinDisLevel();
        if (maxDisLevel <= 21 || minDisLevel2 < 3) {
            Log.e(j, "display level is illegal");
        } else {
            a(maxDisLevel, minDisLevel2);
        }
        return this;
    }
}
