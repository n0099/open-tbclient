package com.baidu.mapapi.map;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class PrismOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public float b;
    public List<LatLng> c;
    public int d;
    public int e;
    public BuildingInfo f;
    public BitmapDescriptor g;
    public boolean h;
    public int i;
    public boolean j;

    public PrismOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = -16777216;
        this.e = -16777216;
        this.a = true;
    }

    public BuildingInfo getBuildingInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (BuildingInfo) invokeV.objValue;
    }

    public BitmapDescriptor getCustomSideImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (BitmapDescriptor) invokeV.objValue;
    }

    public float getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.floatValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public int getShowLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int getSideFaceColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int getTopFaceColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public boolean isAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        List<LatLng> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Prism prism = new Prism();
            prism.H = this.a;
            prism.g = this.g;
            prism.a = this.b;
            prism.f = this.h;
            prism.i = this.j;
            prism.h = this.i;
            if (this.f == null && ((list = this.c) == null || list.size() <= 3)) {
                throw new IllegalStateException("BDMapSDKException: when you add prism, you must at least supply 4 points");
            }
            prism.b = this.c;
            prism.d = this.e;
            prism.c = this.d;
            prism.e = this.f;
            return prism;
        }
        return (Overlay) invokeV.objValue;
    }

    public PrismOptions customSideImage(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmapDescriptor)) == null) {
            this.g = bitmapDescriptor;
            return this;
        }
        return (PrismOptions) invokeL.objValue;
    }

    public PrismOptions setAnimation(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.j = z;
            return this;
        }
        return (PrismOptions) invokeZ.objValue;
    }

    public PrismOptions setBuildingInfo(BuildingInfo buildingInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, buildingInfo)) == null) {
            this.f = buildingInfo;
            return this;
        }
        return (PrismOptions) invokeL.objValue;
    }

    public PrismOptions setHeight(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f)) == null) {
            this.b = f;
            return this;
        }
        return (PrismOptions) invokeF.objValue;
    }

    public PrismOptions setPoints(List<LatLng> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            this.c = list;
            return this;
        }
        return (PrismOptions) invokeL.objValue;
    }

    public PrismOptions setShowLevel(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            this.i = i;
            return this;
        }
        return (PrismOptions) invokeI.objValue;
    }

    public PrismOptions setSideFaceColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            this.e = i;
            return this;
        }
        return (PrismOptions) invokeI.objValue;
    }

    public PrismOptions setTopFaceColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.d = i;
            return this;
        }
        return (PrismOptions) invokeI.objValue;
    }

    public PrismOptions showMarker(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (PrismOptions) invokeZ.objValue;
    }

    public PrismOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            this.a = z;
            return this;
        }
        return (PrismOptions) invokeZ.objValue;
    }
}
