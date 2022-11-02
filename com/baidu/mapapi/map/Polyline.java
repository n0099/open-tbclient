package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public final class Polyline extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public List<LatLng> b;
    public int[] c;
    public int[] d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public BitmapDescriptor j;
    public List<BitmapDescriptor> k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public PolylineOptions.LineCapType p;
    public PolylineOptions.LineJoinType q;
    public PolylineOptions.LineDirectionCross180 r;

    public Polyline() {
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
        this.e = 5;
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = true;
        this.l = 0;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = PolylineOptions.LineCapType.LineCapButt;
        this.q = PolylineOptions.LineJoinType.LineJoinRound;
        this.r = PolylineOptions.LineDirectionCross180.NONE;
        this.type = com.baidu.mapsdkplatform.comapi.map.i.i;
    }

    private Bundle a(boolean z, String str) {
        InterceptResult invokeZL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65537, this, z, str)) == null) {
            if (z) {
                if (this.l == 1) {
                    str2 = "CircleDashTexture.png";
                } else {
                    str2 = "lineDashTexture.png";
                }
                if (str == null) {
                    str = str2;
                }
                BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
                if (fromAsset != null) {
                    return fromAsset.b();
                }
            }
            return this.j.b();
        }
        return (Bundle) invokeZL.objValue;
    }

    public static void a(List<LatLng> list, PolylineOptions.LineDirectionCross180 lineDirectionCross180, Bundle bundle) {
        LatLng latLng;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, list, lineDirectionCross180, bundle) == null) {
            int size = list.size();
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            for (int i = 0; i < size; i++) {
                LatLng latLng2 = list.get(i);
                if (lineDirectionCross180 == PolylineOptions.LineDirectionCross180.FROM_EAST_TO_WEST && latLng2.longitude < 0.0d) {
                    latLng = new LatLng(latLng2.latitude, latLng2.longitude + 360.0d);
                } else {
                    if (lineDirectionCross180 == PolylineOptions.LineDirectionCross180.FROM_WEST_TO_EAST && latLng2.longitude > 0.0d) {
                        latLng = new LatLng(latLng2.latitude, latLng2.longitude - 360.0d);
                    }
                    GeoPoint ll2mc = CoordUtil.ll2mc(latLng2);
                    dArr[i] = ll2mc.getLongitudeE6();
                    dArr2[i] = ll2mc.getLatitudeE6();
                }
                latLng2 = latLng;
                GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
                dArr[i] = ll2mc2.getLongitudeE6();
                dArr2[i] = ll2mc2.getLatitudeE6();
            }
            bundle.putDoubleArray("x_array", dArr);
            bundle.putDoubleArray("y_array", dArr2);
        }
    }

    public static void a(int[] iArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, iArr, bundle) == null) && iArr != null && iArr.length > 0) {
            bundle.putIntArray("traffic_array", iArr);
        }
    }

    public static void b(int[] iArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, iArr, bundle) == null) && iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_array", iArr);
            bundle.putInt("total", 1);
        }
    }

    public static void c(int[] iArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, iArr, bundle) == null) && iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_indexs", iArr);
        }
    }

    public static void d(int[] iArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, iArr, bundle) == null) && iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_array", iArr);
        }
    }

    private Bundle b(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bundle)) == null) {
            int[] iArr = this.d;
            if (iArr != null) {
                if (iArr.length != 0) {
                    d(iArr, bundle);
                    a(this.b, this.r, bundle);
                    int length = this.d.length;
                    int[] iArr2 = new int[length];
                    for (int i = 0; i < length; i++) {
                        iArr2[i] = i;
                    }
                    int size = this.b.size();
                    int[] iArr3 = this.d;
                    if (size == iArr3.length) {
                        iArr2[iArr3.length - 1] = iArr3.length - 2;
                    }
                    c(iArr2, bundle);
                    return bundle;
                }
                throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
            }
            throw new IllegalStateException("BDMapSDKException: colors array can not be null");
        }
        return (Bundle) invokeL.objValue;
    }

    private Bundle b(boolean z, String str) {
        InterceptResult invokeZL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65541, this, z, str)) == null) {
            if (z) {
                Bundle bundle = new Bundle();
                bundle.putInt("total", 1);
                if (this.l == 1) {
                    str2 = "CircleDashTexture.png";
                } else {
                    str2 = "lineDashTexture.png";
                }
                if (str == null) {
                    str = str2;
                }
                BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
                if (fromAsset != null) {
                    bundle.putBundle("texture_0", fromAsset.b());
                }
                return bundle;
            }
            Bundle bundle2 = new Bundle();
            int i = 0;
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                if (this.k.get(i2) != null) {
                    bundle2.putBundle("texture_" + String.valueOf(i), this.k.get(i2).b());
                    i++;
                }
            }
            bundle2.putInt("total", i);
            return bundle2;
        }
        return (Bundle) invokeZL.objValue;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            List<LatLng> list = this.b;
            if (list != null && list.size() >= 2) {
                GeoPoint ll2mc = CoordUtil.ll2mc(this.b.get(0));
                bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                bundle.putInt("width", this.e);
                if (this.o) {
                    return b(bundle);
                }
                int i = 1;
                if (this.n && this.b.size() == 2) {
                    this.b = com.baidu.mapsdkplatform.comapi.map.k.b(this.b.get(0), this.b.get(1));
                }
                a(this.b, this.r, bundle);
                Overlay.a(this.a, bundle);
                a(this.c, bundle);
                b(this.d, bundle);
                int[] iArr = this.c;
                if (iArr != null && iArr.length > 0 && iArr.length > this.b.size() - 1) {
                    Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
                }
                bundle.putInt("dotline", this.f ? 1 : 0);
                bundle.putInt(AddFriendActivityConfig.TYPE_FOCUS, this.g ? 1 : 0);
                bundle.putInt("isClickable", this.i ? 1 : 0);
                if (this.n) {
                    this.m = false;
                    this.o = false;
                }
                bundle.putInt("isThined", this.m ? 1 : 0);
                bundle.putInt("isGradient", this.o ? 1 : 0);
                bundle.putInt("lineJoinType", this.q.ordinal());
                bundle.putInt("lineCapType", this.p.ordinal());
                bundle.putInt("lineDirectionCross180", this.r.ordinal());
                try {
                    String str = "line_texture.png";
                    if (this.j != null) {
                        bundle.putInt("custom", 1);
                        bundle.putBundle("image_info", a(false, (String) null));
                    } else {
                        if (this.f) {
                            bundle.putBundle("image_info", a(true, (String) null));
                            bundle.putInt("dotted_line_type", this.l);
                        } else {
                            bundle.putBundle("image_info", a(true, "line_texture.png"));
                        }
                        bundle.putInt("custom", 0);
                    }
                    if (this.k != null) {
                        bundle.putInt("customlist", 1);
                        bundle.putBundle("image_info_list", b(false, (String) null));
                    } else {
                        if (this.f) {
                            str = null;
                        }
                        if (this.d != null && this.d.length > 0) {
                            bundle.putBundle("image_info_list", b(true, str));
                        } else if (this.j != null) {
                            bundle.putBundle("image_info", this.j.b());
                            bundle.putInt("dotline", 0);
                        } else {
                            bundle.putBundle("image_info", a(true, str));
                        }
                        bundle.putInt("customlist", 0);
                    }
                    if (!this.h) {
                        i = 0;
                    }
                    bundle.putInt("keep", i);
                } catch (Exception unused) {
                    Log.e("baidumapsdk", "load texture resource failed!");
                    bundle.putInt("dotline", 0);
                }
                return bundle;
            }
            throw new IllegalStateException("BDMapSDKException: when you add Polyline, you must at least supply 2 points");
        }
        return (Bundle) invokeL.objValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int[] getColorList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (int[]) invokeV.objValue;
    }

    public int getDottedLineType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public PolylineOptions.LineCapType getLineCapType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.p;
        }
        return (PolylineOptions.LineCapType) invokeV.objValue;
    }

    public PolylineOptions.LineDirectionCross180 getLineDirectionCross180() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (PolylineOptions.LineDirectionCross180) invokeV.objValue;
    }

    public PolylineOptions.LineJoinType getLineJoinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.q;
        }
        return (PolylineOptions.LineJoinType) invokeV.objValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public BitmapDescriptor getTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.j;
        }
        return (BitmapDescriptor) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public boolean isClickable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean isDottedLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean isFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean isGeodesic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public boolean isGradient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean isIsKeepScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public boolean isThined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public void setClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.i = z;
            this.listener.c(this);
        }
    }

    public void setColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.a = i;
            this.listener.c(this);
        }
    }

    public void setColorList(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, iArr) == null) {
            if (iArr != null && iArr.length != 0) {
                this.d = iArr;
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
        }
    }

    public void setDottedLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f = z;
            this.listener.c(this);
        }
    }

    public void setDottedLineType(PolylineDottedLineType polylineDottedLineType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, polylineDottedLineType) == null) {
            this.l = polylineDottedLineType.ordinal();
            this.listener.c(this);
        }
    }

    public void setFocus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.g = z;
            this.listener.c(this);
        }
    }

    public void setGeodesic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.n = z;
            this.listener.c(this);
        }
    }

    public void setGradient(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.o = z;
            this.listener.c(this);
        }
    }

    public void setIndexs(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iArr) == null) {
            if (iArr != null && iArr.length != 0) {
                this.c = iArr;
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
        }
    }

    public void setIsKeepScale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.h = z;
        }
    }

    public void setLineCapType(PolylineOptions.LineCapType lineCapType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, lineCapType) == null) {
            this.p = lineCapType;
            this.listener.c(this);
        }
    }

    public void setLineDirectionCross180(PolylineOptions.LineDirectionCross180 lineDirectionCross180) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, lineDirectionCross180) == null) {
            this.r = lineDirectionCross180;
        }
    }

    public void setLineJoinType(PolylineOptions.LineJoinType lineJoinType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, lineJoinType) == null) {
            this.q = lineJoinType;
            this.listener.c(this);
        }
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bitmapDescriptor) == null) {
            this.j = bitmapDescriptor;
            this.listener.c(this);
        }
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                this.k = list;
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
        }
    }

    public void setThined(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.m = z;
            this.listener.c(this);
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i) == null) && i > 0) {
            this.e = i;
            this.listener.c(this);
        }
    }

    public void setPoints(List<LatLng> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            if (list != null) {
                if (list.size() >= 2) {
                    if (!list.contains(null)) {
                        this.b = list;
                        this.listener.c(this);
                        return;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                }
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2 or more than 10000");
            }
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
    }
}
