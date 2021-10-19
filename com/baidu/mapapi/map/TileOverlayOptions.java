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
    public static Bundle f41701c = null;

    /* renamed from: j  reason: collision with root package name */
    public static final String f41702j = "TileOverlayOptions";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f41703a;

    /* renamed from: b  reason: collision with root package name */
    public TileProvider f41704b;

    /* renamed from: d  reason: collision with root package name */
    public int f41705d;
    public int datasource;

    /* renamed from: e  reason: collision with root package name */
    public int f41706e;

    /* renamed from: f  reason: collision with root package name */
    public int f41707f;

    /* renamed from: g  reason: collision with root package name */
    public int f41708g;

    /* renamed from: h  reason: collision with root package name */
    public int f41709h;

    /* renamed from: i  reason: collision with root package name */
    public int f41710i;
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
        this.f41703a = CyberPlayerManager.StorageQuotaWarning;
        this.f41705d = 20;
        this.f41706e = 3;
        this.f41707f = 15786414;
        this.f41708g = -20037726;
        this.f41709h = -15786414;
        this.f41710i = 20037726;
        Bundle bundle = new Bundle();
        f41701c = bundle;
        bundle.putInt("rectr", this.f41707f);
        f41701c.putInt("rectb", this.f41708g);
        f41701c.putInt("rectl", this.f41709h);
        f41701c.putInt("rectt", this.f41710i);
    }

    private TileOverlayOptions a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i2, i3)) == null) {
            this.f41705d = i2;
            this.f41706e = i3;
            return this;
        }
        return (TileOverlayOptions) invokeII.objValue;
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            f41701c.putString("url", this.urlString);
            f41701c.putInt("datasource", this.datasource);
            f41701c.putInt("maxDisplay", this.f41705d);
            f41701c.putInt("minDisplay", this.f41706e);
            f41701c.putInt("sdktiletmpmax", this.f41703a);
            return f41701c;
        }
        return (Bundle) invokeV.objValue;
    }

    public TileOverlay a(BaiduMap baiduMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baiduMap)) == null) ? new TileOverlay(baiduMap, this.f41704b) : (TileOverlay) invokeL.objValue;
    }

    public TileOverlayOptions setMaxTileTmp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f41703a = i2;
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
                    f41701c.putInt("rectr", (int) longitudeE62);
                    f41701c.putInt("rectb", (int) latitudeE62);
                    f41701c.putInt("rectl", (int) longitudeE6);
                    f41701c.putInt("rectt", (int) latitudeE6);
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
            this.f41704b = tileProvider;
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
