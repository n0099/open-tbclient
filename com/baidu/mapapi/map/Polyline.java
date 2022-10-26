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
/* loaded from: classes2.dex */
public final class Polyline extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public List b;
    public int[] c;
    public int[] d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public BitmapDescriptor i;
    public List j;

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
                    bundle2.putBundle("texture_" + String.valueOf(i), ((BitmapDescriptor) this.j.get(i2)).b());
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
            GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) this.b.get(0));
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            bundle.putInt("width", this.e);
            Overlay.a(this.b, bundle);
            Overlay.a(this.a, bundle);
            a(this.c, bundle);
            b(this.d, bundle);
            int[] iArr = this.c;
            int i = 1;
            if (iArr != null && iArr.length > 0 && iArr.length > this.b.size() - 1) {
                Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
            }
            bundle.putInt("dotline", this.f ? 1 : 0);
            bundle.putInt(AddFriendActivityConfig.TYPE_FOCUS, this.g ? 1 : 0);
            try {
                if (this.i != null) {
                    bundle.putInt("custom", 1);
                    bundle.putBundle("image_info", a(false));
                } else {
                    if (this.f) {
                        bundle.putBundle("image_info", a(true));
                    }
                    bundle.putInt("custom", 0);
                }
                if (this.j != null) {
                    bundle.putInt("customlist", 1);
                    bundle.putBundle("image_info_list", b(false));
                } else {
                    if (this.f && ((this.c != null && this.c.length > 0) || (this.d != null && this.d.length > 0))) {
                        bundle.putBundle("image_info_list", b(true));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (int[]) invokeV.objValue;
    }

    public List getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public BitmapDescriptor getTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (BitmapDescriptor) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : invokeV.intValue;
    }

    public boolean isDottedLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public boolean isFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean isIsKeepScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : invokeV.booleanValue;
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
            this.d = iArr;
        }
    }

    public void setDottedLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f = z;
            this.listener.b(this);
        }
    }

    public void setFocus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.g = z;
            this.listener.b(this);
        }
    }

    public void setIndexs(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iArr) == null) {
            if (iArr == null || iArr.length == 0) {
                throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
            }
            this.c = iArr;
        }
    }

    public void setIsKeepScale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.h = z;
        }
    }

    public void setPoints(List list) {
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
            this.b = list;
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

    public void setTextureList(List list) {
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
        this.e = i;
        this.listener.b(this);
    }
}
