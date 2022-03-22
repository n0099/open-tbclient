package com.baidu.mapsdkplatform.comapi.util;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CoordTrans {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CoordTrans() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static LatLng baiduToGcj(LatLng latLng) {
        InterceptResult invokeL;
        double[] baiduToGcj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, latLng)) == null) {
            if (latLng == null || (baiduToGcj = JNITools.baiduToGcj(latLng.latitude, latLng.longitude)) == null) {
                return null;
            }
            return new LatLng(baiduToGcj[0], baiduToGcj[1]);
        }
        return (LatLng) invokeL.objValue;
    }

    public static LatLng gcjToBaidu(LatLng latLng) {
        InterceptResult invokeL;
        double[] gcjToBaidu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, latLng)) == null) {
            if (latLng == null || (gcjToBaidu = JNITools.gcjToBaidu(latLng.latitude, latLng.longitude)) == null) {
                return null;
            }
            return new LatLng(gcjToBaidu[0], gcjToBaidu[1]);
        }
        return (LatLng) invokeL.objValue;
    }

    public static LatLng wgsToBaidu(LatLng latLng) {
        InterceptResult invokeL;
        double[] wgsToBaidu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, latLng)) == null) {
            if (latLng == null || (wgsToBaidu = JNITools.wgsToBaidu(latLng.latitude, latLng.longitude)) == null) {
                return null;
            }
            return new LatLng(wgsToBaidu[0], wgsToBaidu[1]);
        }
        return (LatLng) invokeL.objValue;
    }
}
