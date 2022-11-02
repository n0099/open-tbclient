package com.baidu.mapapi.navi;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class TruckNaviOption extends NaviParaOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int g;
    public double h;
    public double i;
    public double j;
    public double k;
    public double l;
    public int m;
    public boolean n;
    public String o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;

    public TruckNaviOption() {
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

    public int getAxleCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public double getAxleWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return invokeV.doubleValue;
    }

    public int getDisplacement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public int getEmissionLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public String getEndName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return super.getEndName();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public LatLng getEndPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return super.getEndPoint();
        }
        return (LatLng) invokeV.objValue;
    }

    public double getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return invokeV.doubleValue;
    }

    public boolean getIsTrailer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public double getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return invokeV.doubleValue;
    }

    public int getLoadWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public String getNaviRoutePolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return super.getNaviRoutePolicy();
        }
        return (String) invokeV.objValue;
    }

    public int getPlateColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public String getPlateNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public int getPowerType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public int getTruckType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public JSONArray getWayPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return super.getWayPoint();
        }
        return (JSONArray) invokeV.objValue;
    }

    public double getWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.j;
        }
        return invokeV.doubleValue;
    }

    public double getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.i;
        }
        return invokeV.doubleValue;
    }

    public TruckNaviOption setAxleCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            this.m = i;
            return this;
        }
        return (TruckNaviOption) invokeI.objValue;
    }

    public TruckNaviOption setAxleWeight(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Double.valueOf(d)})) == null) {
            this.l = d;
            return this;
        }
        return (TruckNaviOption) invokeCommon.objValue;
    }

    public TruckNaviOption setDisplacement(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            this.q = i;
            return this;
        }
        return (TruckNaviOption) invokeI.objValue;
    }

    public TruckNaviOption setEmissionLimit(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            this.s = i;
            return this;
        }
        return (TruckNaviOption) invokeI.objValue;
    }

    public TruckNaviOption setHeight(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Double.valueOf(d)})) == null) {
            this.h = d;
            return this;
        }
        return (TruckNaviOption) invokeCommon.objValue;
    }

    public TruckNaviOption setIsTrailer(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            this.n = z;
            return this;
        }
        return (TruckNaviOption) invokeZ.objValue;
    }

    public TruckNaviOption setLength(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Double.valueOf(d)})) == null) {
            this.k = d;
            return this;
        }
        return (TruckNaviOption) invokeCommon.objValue;
    }

    public TruckNaviOption setLoadWeight(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            this.t = i;
            return this;
        }
        return (TruckNaviOption) invokeI.objValue;
    }

    public TruckNaviOption setPlateColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            this.p = i;
            return this;
        }
        return (TruckNaviOption) invokeI.objValue;
    }

    public TruckNaviOption setPlateNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            this.o = str;
            return this;
        }
        return (TruckNaviOption) invokeL.objValue;
    }

    public TruckNaviOption setPowerType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            this.r = i;
            return this;
        }
        return (TruckNaviOption) invokeI.objValue;
    }

    public TruckNaviOption setTruckType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            this.g = i;
            return this;
        }
        return (TruckNaviOption) invokeI.objValue;
    }

    public TruckNaviOption setWeight(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{Double.valueOf(d)})) == null) {
            this.j = d;
            return this;
        }
        return (TruckNaviOption) invokeCommon.objValue;
    }

    public TruckNaviOption setWidth(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Double.valueOf(d)})) == null) {
            this.i = d;
            return this;
        }
        return (TruckNaviOption) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption endName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return (TruckNaviOption) super.endName(str);
        }
        return (TruckNaviOption) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption endPoint(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, latLng)) == null) {
            return (TruckNaviOption) super.endPoint(latLng);
        }
        return (TruckNaviOption) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption setNaviRoutePolicy(NaviParaOption.NaviRoutePolicy naviRoutePolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, naviRoutePolicy)) == null) {
            return (TruckNaviOption) super.setNaviRoutePolicy(naviRoutePolicy);
        }
        return (TruckNaviOption) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption setWayPoint(WayPoint wayPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, wayPoint)) == null) {
            return (TruckNaviOption) super.setWayPoint(wayPoint);
        }
        return (TruckNaviOption) invokeL.objValue;
    }
}
