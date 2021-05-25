package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class TileOverlayOptions {

    /* renamed from: c  reason: collision with root package name */
    public static Bundle f7045c = null;
    public static final String j = "TileOverlayOptions";

    /* renamed from: b  reason: collision with root package name */
    public TileProvider f7047b;
    public int datasource;
    public String urlString;

    /* renamed from: a  reason: collision with root package name */
    public int f7046a = 209715200;

    /* renamed from: d  reason: collision with root package name */
    public int f7048d = 20;

    /* renamed from: e  reason: collision with root package name */
    public int f7049e = 3;

    /* renamed from: f  reason: collision with root package name */
    public int f7050f = 15786414;

    /* renamed from: g  reason: collision with root package name */
    public int f7051g = -20037726;

    /* renamed from: h  reason: collision with root package name */
    public int f7052h = -15786414;

    /* renamed from: i  reason: collision with root package name */
    public int f7053i = 20037726;

    public TileOverlayOptions() {
        Bundle bundle = new Bundle();
        f7045c = bundle;
        bundle.putInt("rectr", this.f7050f);
        f7045c.putInt("rectb", this.f7051g);
        f7045c.putInt("rectl", this.f7052h);
        f7045c.putInt("rectt", this.f7053i);
    }

    private TileOverlayOptions a(int i2, int i3) {
        this.f7048d = i2;
        this.f7049e = i3;
        return this;
    }

    public Bundle a() {
        f7045c.putString("url", this.urlString);
        f7045c.putInt("datasource", this.datasource);
        f7045c.putInt("maxDisplay", this.f7048d);
        f7045c.putInt("minDisplay", this.f7049e);
        f7045c.putInt("sdktiletmpmax", this.f7046a);
        return f7045c;
    }

    public TileOverlay a(BaiduMap baiduMap) {
        return new TileOverlay(baiduMap, this.f7047b);
    }

    public TileOverlayOptions setMaxTileTmp(int i2) {
        this.f7046a = i2;
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
                Log.e(j, "BDMapSDKException: bounds is illegal, use default bounds");
            } else {
                f7045c.putInt("rectr", (int) longitudeE62);
                f7045c.putInt("rectb", (int) latitudeE62);
                f7045c.putInt("rectl", (int) longitudeE6);
                f7045c.putInt("rectt", (int) latitudeE6);
            }
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: bound can not be null");
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
            this.f7047b = tileProvider;
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
        this.f7047b = tileProvider;
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
