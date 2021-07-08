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

    /* renamed from: c  reason: collision with root package name */
    public static Bundle f7135c = null;
    public static final String j = "TileOverlayOptions";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f7136a;

    /* renamed from: b  reason: collision with root package name */
    public TileProvider f7137b;

    /* renamed from: d  reason: collision with root package name */
    public int f7138d;
    public int datasource;

    /* renamed from: e  reason: collision with root package name */
    public int f7139e;

    /* renamed from: f  reason: collision with root package name */
    public int f7140f;

    /* renamed from: g  reason: collision with root package name */
    public int f7141g;

    /* renamed from: h  reason: collision with root package name */
    public int f7142h;

    /* renamed from: i  reason: collision with root package name */
    public int f7143i;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7136a = CyberPlayerManager.StorageQuotaWarning;
        this.f7138d = 20;
        this.f7139e = 3;
        this.f7140f = 15786414;
        this.f7141g = -20037726;
        this.f7142h = -15786414;
        this.f7143i = 20037726;
        Bundle bundle = new Bundle();
        f7135c = bundle;
        bundle.putInt("rectr", this.f7140f);
        f7135c.putInt("rectb", this.f7141g);
        f7135c.putInt("rectl", this.f7142h);
        f7135c.putInt("rectt", this.f7143i);
    }

    private TileOverlayOptions a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i2, i3)) == null) {
            this.f7138d = i2;
            this.f7139e = i3;
            return this;
        }
        return (TileOverlayOptions) invokeII.objValue;
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            f7135c.putString("url", this.urlString);
            f7135c.putInt("datasource", this.datasource);
            f7135c.putInt("maxDisplay", this.f7138d);
            f7135c.putInt("minDisplay", this.f7139e);
            f7135c.putInt("sdktiletmpmax", this.f7136a);
            return f7135c;
        }
        return (Bundle) invokeV.objValue;
    }

    public TileOverlay a(BaiduMap baiduMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baiduMap)) == null) ? new TileOverlay(baiduMap, this.f7137b) : (TileOverlay) invokeL.objValue;
    }

    public TileOverlayOptions setMaxTileTmp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f7136a = i2;
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
                    f7135c.putInt("rectr", (int) longitudeE62);
                    f7135c.putInt("rectb", (int) latitudeE62);
                    f7135c.putInt("rectl", (int) longitudeE6);
                    f7135c.putInt("rectt", (int) latitudeE6);
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
                this.f7137b = tileProvider;
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
            this.f7137b = tileProvider;
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
