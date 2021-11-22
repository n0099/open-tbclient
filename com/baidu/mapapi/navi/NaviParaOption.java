package com.baidu.mapapi.navi;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NaviParaOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LatLng f40459a;

    /* renamed from: b  reason: collision with root package name */
    public String f40460b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f40461c;

    /* renamed from: d  reason: collision with root package name */
    public String f40462d;

    public NaviParaOption() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public NaviParaOption endName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f40462d = str;
            return this;
        }
        return (NaviParaOption) invokeL.objValue;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng)) == null) {
            this.f40461c = latLng;
            return this;
        }
        return (NaviParaOption) invokeL.objValue;
    }

    public String getEndName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40462d : (String) invokeV.objValue;
    }

    public LatLng getEndPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40461c : (LatLng) invokeV.objValue;
    }

    public String getStartName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40460b : (String) invokeV.objValue;
    }

    public LatLng getStartPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40459a : (LatLng) invokeV.objValue;
    }

    public NaviParaOption startName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f40460b = str;
            return this;
        }
        return (NaviParaOption) invokeL.objValue;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, latLng)) == null) {
            this.f40459a = latLng;
            return this;
        }
        return (NaviParaOption) invokeL.objValue;
    }
}
