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
/* loaded from: classes10.dex */
public final class PolylineOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35408b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f35409c;

    /* renamed from: d  reason: collision with root package name */
    public int f35410d;

    /* renamed from: e  reason: collision with root package name */
    public List<LatLng> f35411e;

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f35412f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f35413g;

    /* renamed from: h  reason: collision with root package name */
    public int f35414h;

    /* renamed from: i  reason: collision with root package name */
    public BitmapDescriptor f35415i;

    /* renamed from: j  reason: collision with root package name */
    public List<BitmapDescriptor> f35416j;
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
        this.f35410d = -16777216;
        this.f35414h = 5;
        this.k = true;
        this.l = false;
        this.f35408b = true;
        this.m = false;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Polyline polyline = new Polyline();
            polyline.A = this.f35408b;
            polyline.f35403f = this.m;
            polyline.z = this.a;
            polyline.B = this.f35409c;
            List<LatLng> list = this.f35411e;
            if (list == null || list.size() < 2) {
                throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
            }
            polyline.f35399b = this.f35411e;
            polyline.a = this.f35410d;
            polyline.f35402e = this.f35414h;
            polyline.f35406i = this.f35415i;
            polyline.f35407j = this.f35416j;
            polyline.f35404g = this.k;
            polyline.f35405h = this.l;
            List<Integer> list2 = this.f35412f;
            if (list2 != null && list2.size() < this.f35411e.size() - 1) {
                ArrayList arrayList = new ArrayList((this.f35411e.size() - 1) - this.f35412f.size());
                List<Integer> list3 = this.f35412f;
                list3.addAll(list3.size(), arrayList);
            }
            List<Integer> list4 = this.f35412f;
            int i2 = 0;
            if (list4 != null && list4.size() > 0) {
                int[] iArr = new int[this.f35412f.size()];
                int i3 = 0;
                for (Integer num : this.f35412f) {
                    iArr[i3] = num.intValue();
                    i3++;
                }
                polyline.f35400c = iArr;
            }
            List<Integer> list5 = this.f35413g;
            if (list5 != null && list5.size() < this.f35411e.size() - 1) {
                ArrayList arrayList2 = new ArrayList((this.f35411e.size() - 1) - this.f35413g.size());
                List<Integer> list6 = this.f35413g;
                list6.addAll(list6.size(), arrayList2);
            }
            List<Integer> list7 = this.f35413g;
            if (list7 != null && list7.size() > 0) {
                int[] iArr2 = new int[this.f35413g.size()];
                for (Integer num2 : this.f35413g) {
                    iArr2[i2] = num2.intValue();
                    i2++;
                }
                polyline.f35401d = iArr2;
            }
            return polyline;
        }
        return (Overlay) invokeV.objValue;
    }

    public PolylineOptions color(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f35410d = i2;
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
                this.f35413g = list;
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
            this.f35415i = bitmapDescriptor;
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
                this.f35416j = list;
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
            this.f35409c = bundle;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f35410d : invokeV.intValue;
    }

    public BitmapDescriptor getCustomTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f35415i : (BitmapDescriptor) invokeV.objValue;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f35416j : (List) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f35409c : (Bundle) invokeV.objValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f35411e : (List) invokeV.objValue;
    }

    public List<Integer> getTextureIndexs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f35412f : (List) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f35414h : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f35408b : invokeV.booleanValue;
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
                    this.f35411e = list;
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
                this.f35412f = list;
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
            this.f35408b = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions width(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            if (i2 > 0) {
                this.f35414h = i2;
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
