package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public final class Polyline extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public List<LatLng> f26260b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f26261c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f26262d;

    /* renamed from: e  reason: collision with root package name */
    public int f26263e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26264f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26265g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26266h;
    public BitmapDescriptor i;
    public List<BitmapDescriptor> j;

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
        this.f26263e = 5;
        this.f26264f = false;
        this.f26265g = false;
        this.f26266h = true;
        this.type = com.baidu.mapsdkplatform.comapi.map.h.i;
    }

    private Bundle a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) {
            return (z ? BitmapDescriptorFactory.fromAsset("lineDashTexture.png") : this.i).b();
        }
        return (Bundle) invokeZ.objValue;
    }

    public static void a(int[] iArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, iArr, bundle) == null) || iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("traffic_array", iArr);
    }

    private Bundle b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, this, z)) == null) {
            if (z) {
                Bundle bundle = new Bundle();
                bundle.putInt("total", 1);
                bundle.putBundle("texture_0", BitmapDescriptorFactory.fromAsset("lineDashTexture.png").b());
                return bundle;
            }
            Bundle bundle2 = new Bundle();
            int i = 0;
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                if (this.j.get(i2) != null) {
                    bundle2.putBundle("texture_" + String.valueOf(i), this.j.get(i2).b());
                    i++;
                }
            }
            bundle2.putInt("total", i);
            return bundle2;
        }
        return (Bundle) invokeZ.objValue;
    }

    public static void b(int[] iArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr, bundle) == null) || iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
        bundle.putInt("total", 1);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f26260b.get(0));
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            bundle.putInt("width", this.f26263e);
            Overlay.a(this.f26260b, bundle);
            Overlay.a(this.a, bundle);
            a(this.f26261c, bundle);
            b(this.f26262d, bundle);
            int[] iArr = this.f26261c;
            int i = 1;
            if (iArr != null && iArr.length > 0 && iArr.length > this.f26260b.size() - 1) {
                Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
            }
            bundle.putInt("dotline", this.f26264f ? 1 : 0);
            bundle.putInt(AddFriendActivityConfig.TYPE_FOCUS, this.f26265g ? 1 : 0);
            try {
                if (this.i != null) {
                    bundle.putInt("custom", 1);
                    bundle.putBundle("image_info", a(false));
                } else {
                    if (this.f26264f) {
                        bundle.putBundle("image_info", a(true));
                    }
                    bundle.putInt("custom", 0);
                }
                if (this.j != null) {
                    bundle.putInt("customlist", 1);
                    bundle.putBundle("image_info_list", b(false));
                } else {
                    if (this.f26264f && ((this.f26261c != null && this.f26261c.length > 0) || (this.f26262d != null && this.f26262d.length > 0))) {
                        bundle.putBundle("image_info_list", b(true));
                    }
                    bundle.putInt("customlist", 0);
                }
                if (!this.f26266h) {
                    i = 0;
                }
                bundle.putInt("keep", i);
            } catch (Exception unused) {
                Log.e("baidumapsdk", "load texture resource failed!");
                bundle.putInt("dotline", 0);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.intValue;
    }

    public int[] getColorList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26262d : (int[]) invokeV.objValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26260b : (List) invokeV.objValue;
    }

    public BitmapDescriptor getTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (BitmapDescriptor) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26263e : invokeV.intValue;
    }

    public boolean isDottedLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26264f : invokeV.booleanValue;
    }

    public boolean isFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f26265g : invokeV.booleanValue;
    }

    public boolean isIsKeepScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f26266h : invokeV.booleanValue;
    }

    public void setColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.a = i;
            this.listener.b(this);
        }
    }

    public void setColorList(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iArr) == null) {
            if (iArr == null || iArr.length == 0) {
                throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
            }
            this.f26262d = iArr;
        }
    }

    public void setDottedLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f26264f = z;
            this.listener.b(this);
        }
    }

    public void setFocus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f26265g = z;
            this.listener.b(this);
        }
    }

    public void setIndexs(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iArr) == null) {
            if (iArr == null || iArr.length == 0) {
                throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
            }
            this.f26261c = iArr;
        }
    }

    public void setIsKeepScale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f26266h = z;
        }
    }

    public void setPoints(List<LatLng> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            if (list == null) {
                throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
            }
            if (list.size() < 2) {
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2 or more than 10000");
            }
            if (list.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            this.f26260b = list;
            this.listener.b(this);
        }
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bitmapDescriptor) == null) {
            this.i = bitmapDescriptor;
            this.listener.b(this);
        }
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
            }
            this.j = list;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || i <= 0) {
            return;
        }
        this.f26263e = i;
        this.listener.b(this);
    }
}
