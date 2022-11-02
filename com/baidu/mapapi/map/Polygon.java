package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class Polygon extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Stroke a;
    public int b;
    public List<LatLng> c;
    public List<HoleOptions> d;
    public HoleOptions e;
    public boolean f;
    public String g;
    public EncodePointType h;
    public int i;

    public Polygon() {
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
        this.i = 0;
        this.type = com.baidu.mapsdkplatform.comapi.map.i.j;
    }

    public String getEncodedPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public int getFillColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public HoleOptions getHoleOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (HoleOptions) invokeV.objValue;
    }

    public List<HoleOptions> getHoleOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public EncodePointType getPointType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (EncodePointType) invokeV.objValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public Stroke getStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (Stroke) invokeV.objValue;
    }

    private void b(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bundle) == null) {
            if (this.i == 1) {
                str = "CircleDashTexture.png";
            } else {
                str = "lineDashTexture.png";
            }
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
            if (fromAsset != null) {
                bundle.putBundle("image_info", fromAsset.b());
            }
        }
    }

    public void setFillColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.b = i;
            this.listener.c(this);
        }
    }

    public void setHoleOption(HoleOptions holeOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, holeOptions) == null) {
            this.e = holeOptions;
            this.d = null;
            this.listener.c(this);
        }
    }

    public void setHoleOptions(List<HoleOptions> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.d = list;
            this.e = null;
            this.listener.c(this);
        }
    }

    public void setStroke(Stroke stroke) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, stroke) == null) {
            this.a = stroke;
            this.listener.c(this);
        }
    }

    private void c(List<HoleOptions> list, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, list, bundle) == null) {
            Bundle bundle2 = new Bundle();
            boolean b = Overlay.b(list, bundle2);
            bundle.putInt("has_holes", b ? 1 : 0);
            if (b) {
                bundle.putBundle("holes", bundle2);
            }
        }
    }

    public void setEncodeInfo(String str, EncodePointType encodePointType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, encodePointType) == null) {
            this.g = str;
            this.h = encodePointType;
            this.listener.c(this);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            if (this.f) {
                bundle.putInt("has_dotted_stroke", 1);
                b(bundle);
            } else {
                bundle.putInt("has_dotted_stroke", 0);
            }
            String str = this.g;
            if (str != null && str.length() > 0 && this.h != null) {
                bundle.putString("encodedPoints", this.g);
                bundle.putInt("encodePointType", this.h.ordinal());
            } else {
                List<LatLng> list = this.c;
                if (list != null) {
                    GeoPoint ll2mc = CoordUtil.ll2mc(list.get(0));
                    bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                    bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                    Overlay.a(this.c, bundle);
                    if (this.f) {
                        bundle.putDouble("dotted_stroke_location_x", ll2mc.getLongitudeE6());
                        bundle.putDouble("dotted_stroke_location_y", ll2mc.getLatitudeE6());
                    }
                }
            }
            Overlay.a(this.b, bundle);
            if (this.a == null) {
                bundle.putInt("has_stroke", 0);
            } else {
                bundle.putInt("has_stroke", 1);
                bundle.putBundle("stroke", this.a.a(new Bundle()));
            }
            List<HoleOptions> list2 = this.d;
            if (list2 != null && list2.size() != 0) {
                c(this.d, bundle);
            } else if (this.e != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.e);
                c((List<HoleOptions>) arrayList, bundle);
            } else {
                bundle.putInt("has_holes", 0);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void setPoints(List<LatLng> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            if (list != null) {
                if (list.size() > 2) {
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
                        this.c = list;
                        this.listener.c(this);
                        return;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                }
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
            }
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
    }
}
