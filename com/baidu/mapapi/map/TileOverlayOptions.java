package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class TileOverlayOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static Bundle c = null;
    public static final String j = "TileOverlayOptions";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TileProvider b;
    public int d;
    public int datasource;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public String urlString;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1191197353, "Lcom/baidu/mapapi/map/TileOverlayOptions;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1191197353, "Lcom/baidu/mapapi/map/TileOverlayOptions;");
        }
    }

    public TileOverlayOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = CyberPlayerManager.StorageQuotaWarning;
        this.d = 20;
        this.e = 3;
        this.f = 15786414;
        this.g = -20037726;
        this.h = -15786414;
        this.i = 20037726;
        Bundle bundle = new Bundle();
        c = bundle;
        bundle.putInt("rectr", this.f);
        c.putInt("rectb", this.g);
        c.putInt("rectl", this.h);
        c.putInt("rectt", this.i);
    }

    private TileOverlayOptions a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i, i2)) == null) {
            this.d = i;
            this.e = i2;
            return this;
        }
        return (TileOverlayOptions) invokeII.objValue;
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.putString("url", this.urlString);
            c.putInt("datasource", this.datasource);
            c.putInt("maxDisplay", this.d);
            c.putInt("minDisplay", this.e);
            c.putInt("sdktiletmpmax", this.a);
            return c;
        }
        return (Bundle) invokeV.objValue;
    }

    public TileOverlay a(BaiduMap baiduMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baiduMap)) == null) ? new TileOverlay(baiduMap, this.b) : (TileOverlay) invokeL.objValue;
    }

    public TileOverlayOptions setMaxTileTmp(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.a = i;
            return this;
        }
        return (TileOverlayOptions) invokeI.objValue;
    }

    public TileOverlayOptions setPositionFromBounds(LatLngBounds latLngBounds) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, latLngBounds)) == null) {
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
                    c.putInt("rectr", (int) longitudeE62);
                    c.putInt("rectb", (int) latitudeE62);
                    c.putInt("rectl", (int) longitudeE6);
                    c.putInt("rectt", (int) latitudeE6);
                }
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: bound can not be null");
        }
        return (TileOverlayOptions) invokeL.objValue;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        InterceptResult invokeL;
        String str;
        String str2;
        int maxDisLevel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tileProvider)) == null) {
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
                this.b = tileProvider;
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
            this.b = tileProvider;
            maxDisLevel = tileProvider.getMaxDisLevel();
            int minDisLevel2 = tileProvider.getMinDisLevel();
            if (maxDisLevel <= 21 || minDisLevel2 < 3) {
                Log.e(j, "display level is illegal");
            } else {
                a(maxDisLevel, minDisLevel2);
            }
            return this;
        }
        return (TileOverlayOptions) invokeL.objValue;
    }
}
