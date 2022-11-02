package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import java.util.List;
/* loaded from: classes2.dex */
public final class Prism extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public List<LatLng> b;
    public int c;
    public int d;
    public BuildingInfo e;
    public boolean f;
    public BitmapDescriptor g;
    public int h;
    public boolean i;

    public Prism() {
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
        this.c = -16777216;
        this.d = DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK;
        this.type = com.baidu.mapsdkplatform.comapi.map.i.l;
    }

    public BuildingInfo getBuildingInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (BuildingInfo) invokeV.objValue;
    }

    public BitmapDescriptor getCustomSideImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (BitmapDescriptor) invokeV.objValue;
    }

    public float getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.floatValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public int getShowLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int getSideFaceColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int getTopFaceColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public boolean isAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            Overlay.b(this.c, bundle);
            Overlay.c(this.d, bundle);
            BitmapDescriptor bitmapDescriptor = this.g;
            if (bitmapDescriptor != null) {
                bundle.putBundle("image_info", bitmapDescriptor.b());
            }
            BuildingInfo buildingInfo = this.e;
            int i = 0;
            if (buildingInfo != null) {
                bundle.putDouble("m_height", buildingInfo.getHeight());
                bundle.putString("encodedPoints", this.e.getGeom());
                bundle.putInt("encodePointType", EncodePointType.BUILDINGINFO.ordinal());
                bundle.putInt("m_showLevel", this.h);
                bundle.putInt("m_isAnimation", this.i ? 1 : 0);
            } else {
                List<LatLng> list = this.b;
                if (list != null) {
                    GeoPoint ll2mc = CoordUtil.ll2mc(list.get(0));
                    bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                    bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                    Overlay.a(this.b, bundle);
                    bundle.putDouble("m_height", this.a);
                }
            }
            if (this.e != null) {
                i = 1;
            }
            bundle.putInt("m_isBuilding", i);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void setPoints(List<LatLng> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            if (list != null) {
                if (list.size() > 3) {
                    if (!list.contains(null)) {
                        int i = 0;
                        while (i < list.size()) {
                            int i2 = i + 1;
                            for (int i3 = i2; i3 < list.size(); i3++) {
                                if (list.get(i) == list.get(i3)) {
                                    throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                                }
                            }
                            i = i2;
                        }
                        this.b = list;
                        this.listener.c(this);
                        return;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                }
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than four");
            }
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
    }

    public void setAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.i = z;
        }
    }

    public void setBuildingInfo(BuildingInfo buildingInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, buildingInfo) == null) {
            this.e = buildingInfo;
            this.listener.c(this);
        }
    }

    public void setCustomSideImage(BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bitmapDescriptor) == null) {
            this.g = bitmapDescriptor;
            this.listener.c(this);
        }
    }

    public void setHeight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f) == null) {
            this.a = f;
            this.listener.c(this);
        }
    }

    public void setShowLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.h = i;
        }
    }

    public void setSideFaceColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.d = i;
            this.listener.c(this);
        }
    }

    public void setTopFaceColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.c = i;
            this.listener.c(this);
        }
    }
}
