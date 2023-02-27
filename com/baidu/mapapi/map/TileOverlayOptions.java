package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
/* loaded from: classes2.dex */
public final class TileOverlayOptions {
    public static Bundle c = null;
    public static final String j = "TileOverlayOptions";
    public TileProvider b;
    public int datasource;
    public String urlString;
    public int a = CyberPlayerManager.StorageQuotaWarning;
    public int d = 20;
    public int e = 3;
    public int f = 15786414;
    public int g = -20037726;
    public int h = -15786414;
    public int i = 20037726;

    public TileOverlayOptions() {
        Bundle bundle = new Bundle();
        c = bundle;
        bundle.putInt("rectr", this.f);
        c.putInt("rectb", this.g);
        c.putInt("rectl", this.h);
        c.putInt("rectt", this.i);
    }

    private TileOverlayOptions a(int i, int i2) {
        this.d = i;
        this.e = i2;
        return this;
    }

    public Bundle a() {
        c.putString("url", this.urlString);
        c.putInt("datasource", this.datasource);
        c.putInt("maxDisplay", this.d);
        c.putInt("minDisplay", this.e);
        c.putInt("sdktiletmpmax", this.a);
        return c;
    }

    public TileOverlay a(BaiduMap baiduMap) {
        return new TileOverlay(baiduMap, this.b);
    }

    public TileOverlayOptions setMaxTileTmp(int i) {
        this.a = i;
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
            if (latitudeE6 > latitudeE62 && longitudeE62 > longitudeE6) {
                c.putInt("rectr", (int) longitudeE62);
                c.putInt("rectb", (int) latitudeE62);
                c.putInt("rectl", (int) longitudeE6);
                c.putInt("rectt", (int) latitudeE6);
            } else {
                Log.e(j, "BDMapSDKException: bounds is illegal, use default bounds");
            }
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: bound can not be null");
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        if (tileProvider == null) {
            return null;
        }
        if (tileProvider instanceof UrlTileProvider) {
            this.datasource = 1;
            String tileUrl = ((UrlTileProvider) tileProvider).getTileUrl();
            if (tileUrl != null && !"".equals(tileUrl) && tileUrl.contains("{x}") && tileUrl.contains("{y}") && tileUrl.contains("{z}")) {
                this.urlString = tileUrl;
            } else {
                Log.e(j, "tile url template is illegal, must contains {x}、{y}、{z}");
                return null;
            }
        } else if (tileProvider instanceof FileTileProvider) {
            this.datasource = 0;
        } else {
            Log.e(j, "tileProvider must be UrlTileProvider or FileTileProvider");
            return null;
        }
        this.b = tileProvider;
        int maxDisLevel = tileProvider.getMaxDisLevel();
        int minDisLevel = tileProvider.getMinDisLevel();
        if (maxDisLevel <= 21 && minDisLevel >= 3) {
            a(maxDisLevel, minDisLevel);
        } else {
            Log.e(j, "display level is illegal");
        }
        return this;
    }
}
