package com.baidu.mapapi.search.geocode;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GeoCoder extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.platform.core.b.d f41862a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41863b;

    public GeoCoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41862a = new com.baidu.platform.core.b.a();
    }

    public static GeoCoder newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            BMapManager.init();
            return new GeoCoder();
        }
        return (GeoCoder) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41863b) {
            return;
        }
        this.f41863b = true;
        this.f41862a.a();
        BMapManager.destroy();
    }

    public boolean geocode(GeoCodeOption geoCodeOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, geoCodeOption)) == null) {
            com.baidu.platform.core.b.d dVar = this.f41862a;
            if (dVar != null) {
                if (geoCodeOption == null || geoCodeOption.mAddress == null || geoCodeOption.mCity == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option or address or city can not be null");
                }
                return dVar.a(geoCodeOption);
            }
            throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
        }
        return invokeL.booleanValue;
    }

    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, reverseGeoCodeOption)) == null) {
            if (this.f41862a != null) {
                if (reverseGeoCodeOption == null || reverseGeoCodeOption.getLocation() == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option or mLocation can not be null");
                }
                return this.f41862a.a(reverseGeoCodeOption);
            }
            throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
        }
        return invokeL.booleanValue;
    }

    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onGetGeoCoderResultListener) == null) {
            com.baidu.platform.core.b.d dVar = this.f41862a;
            if (dVar == null) {
                throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
            }
            if (onGetGeoCoderResultListener == null) {
                throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
            }
            dVar.a(onGetGeoCoderResultListener);
        }
    }
}
