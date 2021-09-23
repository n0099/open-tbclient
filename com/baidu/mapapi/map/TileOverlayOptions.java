package com.baidu.mapapi.map;

import android.os.Bundle;
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
/* loaded from: classes5.dex */
public final class TileOverlayOptions {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static Bundle f41697c = null;

    /* renamed from: j  reason: collision with root package name */
    public static final String f41698j = "TileOverlayOptions";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f41699a;

    /* renamed from: b  reason: collision with root package name */
    public TileProvider f41700b;

    /* renamed from: d  reason: collision with root package name */
    public int f41701d;
    public int datasource;

    /* renamed from: e  reason: collision with root package name */
    public int f41702e;

    /* renamed from: f  reason: collision with root package name */
    public int f41703f;

    /* renamed from: g  reason: collision with root package name */
    public int f41704g;

    /* renamed from: h  reason: collision with root package name */
    public int f41705h;

    /* renamed from: i  reason: collision with root package name */
    public int f41706i;
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
        this.f41699a = CyberPlayerManager.StorageQuotaWarning;
        this.f41701d = 20;
        this.f41702e = 3;
        this.f41703f = 15786414;
        this.f41704g = -20037726;
        this.f41705h = -15786414;
        this.f41706i = 20037726;
        Bundle bundle = new Bundle();
        f41697c = bundle;
        bundle.putInt("rectr", this.f41703f);
        f41697c.putInt("rectb", this.f41704g);
        f41697c.putInt("rectl", this.f41705h);
        f41697c.putInt("rectt", this.f41706i);
    }

    private TileOverlayOptions a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i2, i3)) == null) {
            this.f41701d = i2;
            this.f41702e = i3;
            return this;
        }
        return (TileOverlayOptions) invokeII.objValue;
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            f41697c.putString("url", this.urlString);
            f41697c.putInt("datasource", this.datasource);
            f41697c.putInt("maxDisplay", this.f41701d);
            f41697c.putInt("minDisplay", this.f41702e);
            f41697c.putInt("sdktiletmpmax", this.f41699a);
            return f41697c;
        }
        return (Bundle) invokeV.objValue;
    }

    public TileOverlay a(BaiduMap baiduMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baiduMap)) == null) ? new TileOverlay(baiduMap, this.f41700b) : (TileOverlay) invokeL.objValue;
    }

    public TileOverlayOptions setMaxTileTmp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f41699a = i2;
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
                if (latitudeE6 > latitudeE62 && longitudeE62 > longitudeE6) {
                    f41697c.putInt("rectr", (int) longitudeE62);
                    f41697c.putInt("rectb", (int) latitudeE62);
                    f41697c.putInt("rectl", (int) longitudeE6);
                    f41697c.putInt("rectt", (int) latitudeE6);
                }
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: bound can not be null");
        }
        return (TileOverlayOptions) invokeL.objValue;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tileProvider)) == null) {
            if (tileProvider == null) {
                return null;
            }
            if (tileProvider instanceof UrlTileProvider) {
                this.datasource = 1;
                String tileUrl = ((UrlTileProvider) tileProvider).getTileUrl();
                if (tileUrl == null || "".equals(tileUrl) || !tileUrl.contains("{x}") || !tileUrl.contains("{y}") || !tileUrl.contains("{z}")) {
                    return null;
                }
                this.urlString = tileUrl;
            } else if (!(tileProvider instanceof FileTileProvider)) {
                return null;
            } else {
                this.datasource = 0;
            }
            this.f41700b = tileProvider;
            int maxDisLevel = tileProvider.getMaxDisLevel();
            int minDisLevel = tileProvider.getMinDisLevel();
            if (maxDisLevel <= 21 && minDisLevel >= 3) {
                a(maxDisLevel, minDisLevel);
            }
            return this;
        }
        return (TileOverlayOptions) invokeL.objValue;
    }
}
