package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class TileOverlayOptions {

    /* renamed from: c  reason: collision with root package name */
    public static Bundle f7041c = null;
    public static final String j = "TileOverlayOptions";

    /* renamed from: b  reason: collision with root package name */
    public TileProvider f7043b;
    public int datasource;
    public String urlString;

    /* renamed from: a  reason: collision with root package name */
    public int f7042a = 209715200;

    /* renamed from: d  reason: collision with root package name */
    public int f7044d = 20;

    /* renamed from: e  reason: collision with root package name */
    public int f7045e = 3;

    /* renamed from: f  reason: collision with root package name */
    public int f7046f = 15786414;

    /* renamed from: g  reason: collision with root package name */
    public int f7047g = -20037726;

    /* renamed from: h  reason: collision with root package name */
    public int f7048h = -15786414;
    public int i = 20037726;

    public TileOverlayOptions() {
        Bundle bundle = new Bundle();
        f7041c = bundle;
        bundle.putInt("rectr", this.f7046f);
        f7041c.putInt("rectb", this.f7047g);
        f7041c.putInt("rectl", this.f7048h);
        f7041c.putInt("rectt", this.i);
    }

    private TileOverlayOptions a(int i, int i2) {
        this.f7044d = i;
        this.f7045e = i2;
        return this;
    }

    public Bundle a() {
        f7041c.putString("url", this.urlString);
        f7041c.putInt("datasource", this.datasource);
        f7041c.putInt("maxDisplay", this.f7044d);
        f7041c.putInt("minDisplay", this.f7045e);
        f7041c.putInt("sdktiletmpmax", this.f7042a);
        return f7041c;
    }

    public TileOverlay a(BaiduMap baiduMap) {
        return new TileOverlay(baiduMap, this.f7043b);
    }

    public TileOverlayOptions setMaxTileTmp(int i) {
        this.f7042a = i;
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
                f7041c.putInt("rectr", (int) longitudeE62);
                f7041c.putInt("rectb", (int) latitudeE62);
                f7041c.putInt("rectl", (int) longitudeE6);
                f7041c.putInt("rectt", (int) latitudeE6);
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
            this.f7043b = tileProvider;
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
        this.f7043b = tileProvider;
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
