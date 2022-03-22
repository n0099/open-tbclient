package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
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
    public boolean f26267b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f26268c;

    /* renamed from: d  reason: collision with root package name */
    public int f26269d;

    /* renamed from: e  reason: collision with root package name */
    public List<LatLng> f26270e;

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f26271f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f26272g;

    /* renamed from: h  reason: collision with root package name */
    public int f26273h;
    public BitmapDescriptor i;
    public List<BitmapDescriptor> j;
    public boolean k;
    public boolean l;
    public boolean m;

    public PolylineOptions() {
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
        this.f26269d = -16777216;
        this.f26273h = 5;
        this.k = true;
        this.l = false;
        this.f26267b = true;
        this.m = false;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Polyline polyline = new Polyline();
            polyline.A = this.f26267b;
            polyline.f26264f = this.m;
            polyline.z = this.a;
            polyline.B = this.f26268c;
            List<LatLng> list = this.f26270e;
            if (list == null || list.size() < 2) {
                throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
            }
            polyline.f26260b = this.f26270e;
            polyline.a = this.f26269d;
            polyline.f26263e = this.f26273h;
            polyline.i = this.i;
            polyline.j = this.j;
            polyline.f26265g = this.k;
            polyline.f26266h = this.l;
            List<Integer> list2 = this.f26271f;
            if (list2 != null && list2.size() < this.f26270e.size() - 1) {
                ArrayList arrayList = new ArrayList((this.f26270e.size() - 1) - this.f26271f.size());
                List<Integer> list3 = this.f26271f;
                list3.addAll(list3.size(), arrayList);
            }
            List<Integer> list4 = this.f26271f;
            int i = 0;
            if (list4 != null && list4.size() > 0) {
                int[] iArr = new int[this.f26271f.size()];
                int i2 = 0;
                for (Integer num : this.f26271f) {
                    iArr[i2] = num.intValue();
                    i2++;
                }
                polyline.f26261c = iArr;
            }
            List<Integer> list5 = this.f26272g;
            if (list5 != null && list5.size() < this.f26270e.size() - 1) {
                ArrayList arrayList2 = new ArrayList((this.f26270e.size() - 1) - this.f26272g.size());
                List<Integer> list6 = this.f26272g;
                list6.addAll(list6.size(), arrayList2);
            }
            List<Integer> list7 = this.f26272g;
            if (list7 != null && list7.size() > 0) {
                int[] iArr2 = new int[this.f26272g.size()];
                for (Integer num2 : this.f26272g) {
                    iArr2[i] = num2.intValue();
                    i++;
                }
                polyline.f26262d = iArr2;
            }
            return polyline;
        }
        return (Overlay) invokeV.objValue;
    }

    public PolylineOptions color(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.f26269d = i;
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
                this.f26272g = list;
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
            this.i = bitmapDescriptor;
            return this;
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions customTextureList(List<BitmapDescriptor> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (list != null) {
                if (list.size() == 0) {
                    Log.e("baidumapsdk", "custom texture list is empty,the texture will not work");
                }
                for (BitmapDescriptor bitmapDescriptor : list) {
                    if (bitmapDescriptor == null) {
                        Log.e("baidumapsdk", "the custom texture item is null,it will be discard");
                    }
                }
                this.j = list;
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
            this.f26268c = bundle;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f26269d : invokeV.intValue;
    }

    public BitmapDescriptor getCustomTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.i : (BitmapDescriptor) invokeV.objValue;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (List) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f26268c : (Bundle) invokeV.objValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f26270e : (List) invokeV.objValue;
    }

    public List<Integer> getTextureIndexs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f26271f : (List) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f26273h : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f26267b : invokeV.booleanValue;
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
                    this.f26270e = list;
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
                this.f26271f = list;
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
            this.f26267b = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions width(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            if (i > 0) {
                this.f26273h = i;
            }
            return this;
        }
        return (PolylineOptions) invokeI.objValue;
    }

    public PolylineOptions zIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            this.a = i;
            return this;
        }
        return (PolylineOptions) invokeI.objValue;
    }
}
