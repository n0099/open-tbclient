package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class PolylineOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34017b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f34018c;

    /* renamed from: d  reason: collision with root package name */
    public int f34019d;

    /* renamed from: e  reason: collision with root package name */
    public List<LatLng> f34020e;

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f34021f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f34022g;

    /* renamed from: h  reason: collision with root package name */
    public int f34023h;

    /* renamed from: i  reason: collision with root package name */
    public BitmapDescriptor f34024i;

    /* renamed from: j  reason: collision with root package name */
    public List<BitmapDescriptor> f34025j;
    public boolean k;
    public boolean l;
    public boolean m;

    public PolylineOptions() {
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
        this.f34019d = -16777216;
        this.f34023h = 5;
        this.k = true;
        this.l = false;
        this.f34017b = true;
        this.m = false;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Polyline polyline = new Polyline();
            polyline.A = this.f34017b;
            polyline.f34012f = this.m;
            polyline.z = this.a;
            polyline.B = this.f34018c;
            List<LatLng> list = this.f34020e;
            if (list == null || list.size() < 2) {
                throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
            }
            polyline.f34008b = this.f34020e;
            polyline.a = this.f34019d;
            polyline.f34011e = this.f34023h;
            polyline.f34015i = this.f34024i;
            polyline.f34016j = this.f34025j;
            polyline.f34013g = this.k;
            polyline.f34014h = this.l;
            List<Integer> list2 = this.f34021f;
            if (list2 != null && list2.size() < this.f34020e.size() - 1) {
                ArrayList arrayList = new ArrayList((this.f34020e.size() - 1) - this.f34021f.size());
                List<Integer> list3 = this.f34021f;
                list3.addAll(list3.size(), arrayList);
            }
            List<Integer> list4 = this.f34021f;
            int i2 = 0;
            if (list4 != null && list4.size() > 0) {
                int[] iArr = new int[this.f34021f.size()];
                int i3 = 0;
                for (Integer num : this.f34021f) {
                    iArr[i3] = num.intValue();
                    i3++;
                }
                polyline.f34009c = iArr;
            }
            List<Integer> list5 = this.f34022g;
            if (list5 != null && list5.size() < this.f34020e.size() - 1) {
                ArrayList arrayList2 = new ArrayList((this.f34020e.size() - 1) - this.f34022g.size());
                List<Integer> list6 = this.f34022g;
                list6.addAll(list6.size(), arrayList2);
            }
            List<Integer> list7 = this.f34022g;
            if (list7 != null && list7.size() > 0) {
                int[] iArr2 = new int[this.f34022g.size()];
                for (Integer num2 : this.f34022g) {
                    iArr2[i2] = num2.intValue();
                    i2++;
                }
                polyline.f34010d = iArr2;
            }
            return polyline;
        }
        return (Overlay) invokeV.objValue;
    }

    public PolylineOptions color(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f34019d = i2;
            return this;
        }
        return (PolylineOptions) invokeI.objValue;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list != null) {
                if (list.contains(null)) {
                    throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
                }
                this.f34022g = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bitmapDescriptor)) == null) {
            this.f34024i = bitmapDescriptor;
            return this;
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions customTextureList(List<BitmapDescriptor> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (list != null) {
                list.size();
                for (BitmapDescriptor bitmapDescriptor : list) {
                }
                this.f34025j = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: customTexture list can not be null");
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions dottedLine(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.m = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bundle)) == null) {
            this.f34018c = bundle;
            return this;
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions focus(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.k = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34019d : invokeV.intValue;
    }

    public BitmapDescriptor getCustomTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34024i : (BitmapDescriptor) invokeV.objValue;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34025j : (List) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34018c : (Bundle) invokeV.objValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f34020e : (List) invokeV.objValue;
    }

    public List<Integer> getTextureIndexs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f34021f : (List) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f34023h : invokeV.intValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a : invokeV.intValue;
    }

    public boolean isDottedLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean isFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f34017b : invokeV.booleanValue;
    }

    public PolylineOptions keepScale(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            this.l = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions points(List<LatLng> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, list)) == null) {
            if (list != null) {
                if (list.size() >= 2) {
                    if (list.contains(null)) {
                        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                    }
                    this.f34020e = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
            }
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions textureIndex(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, list)) == null) {
            if (list != null) {
                if (list.contains(null)) {
                    throw new IllegalArgumentException("BDMapSDKException: index list can not contains null");
                }
                this.f34021f = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.f34017b = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions width(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            if (i2 > 0) {
                this.f34023h = i2;
            }
            return this;
        }
        return (PolylineOptions) invokeI.objValue;
    }

    public PolylineOptions zIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            this.a = i2;
            return this;
        }
        return (PolylineOptions) invokeI.objValue;
    }
}
