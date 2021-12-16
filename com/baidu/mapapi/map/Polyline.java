package com.baidu.mapapi.map;

import android.os.Bundle;
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
import io.reactivex.annotations.SchedulerSupport;
import java.util.List;
/* loaded from: classes10.dex */
public final class Polyline extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public List<LatLng> f36418b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f36419c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f36420d;

    /* renamed from: e  reason: collision with root package name */
    public int f36421e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36422f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36423g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36424h;

    /* renamed from: i  reason: collision with root package name */
    public BitmapDescriptor f36425i;

    /* renamed from: j  reason: collision with root package name */
    public List<BitmapDescriptor> f36426j;

    public Polyline() {
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
        this.f36421e = 5;
        this.f36422f = false;
        this.f36423g = false;
        this.f36424h = true;
        this.type = com.baidu.mapsdkplatform.comapi.map.h.f36942i;
    }

    private Bundle a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) {
            return (z ? BitmapDescriptorFactory.fromAsset("lineDashTexture.png") : this.f36425i).b();
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
            int i2 = 0;
            for (int i3 = 0; i3 < this.f36426j.size(); i3++) {
                if (this.f36426j.get(i3) != null) {
                    bundle2.putBundle("texture_" + String.valueOf(i2), this.f36426j.get(i3).b());
                    i2++;
                }
            }
            bundle2.putInt("total", i2);
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
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f36418b.get(0));
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            bundle.putInt("width", this.f36421e);
            Overlay.a(this.f36418b, bundle);
            Overlay.a(this.a, bundle);
            a(this.f36419c, bundle);
            b(this.f36420d, bundle);
            int[] iArr = this.f36419c;
            int i2 = 1;
            if (iArr != null && iArr.length > 0) {
                int length = iArr.length;
                int size = this.f36418b.size() - 1;
            }
            bundle.putInt("dotline", this.f36422f ? 1 : 0);
            bundle.putInt(AddFriendActivityConfig.TYPE_FOCUS, this.f36423g ? 1 : 0);
            try {
                if (this.f36425i != null) {
                    bundle.putInt(SchedulerSupport.CUSTOM, 1);
                    bundle.putBundle("image_info", a(false));
                } else {
                    if (this.f36422f) {
                        bundle.putBundle("image_info", a(true));
                    }
                    bundle.putInt(SchedulerSupport.CUSTOM, 0);
                }
                if (this.f36426j != null) {
                    bundle.putInt("customlist", 1);
                    bundle.putBundle("image_info_list", b(false));
                } else {
                    if (this.f36422f && ((this.f36419c != null && this.f36419c.length > 0) || (this.f36420d != null && this.f36420d.length > 0))) {
                        bundle.putBundle("image_info_list", b(true));
                    }
                    bundle.putInt("customlist", 0);
                }
                if (!this.f36424h) {
                    i2 = 0;
                }
                bundle.putInt("keep", i2);
            } catch (Exception unused) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36420d : (int[]) invokeV.objValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36418b : (List) invokeV.objValue;
    }

    public BitmapDescriptor getTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36425i : (BitmapDescriptor) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36421e : invokeV.intValue;
    }

    public boolean isDottedLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f36422f : invokeV.booleanValue;
    }

    public boolean isFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36423g : invokeV.booleanValue;
    }

    public boolean isIsKeepScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36424h : invokeV.booleanValue;
    }

    public void setColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.a = i2;
            this.listener.b(this);
        }
    }

    public void setColorList(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iArr) == null) {
            if (iArr == null || iArr.length == 0) {
                throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
            }
            this.f36420d = iArr;
        }
    }

    public void setDottedLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f36422f = z;
            this.listener.b(this);
        }
    }

    public void setFocus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f36423g = z;
            this.listener.b(this);
        }
    }

    public void setIndexs(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iArr) == null) {
            if (iArr == null || iArr.length == 0) {
                throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
            }
            this.f36419c = iArr;
        }
    }

    public void setIsKeepScale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f36424h = z;
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
            this.f36418b = list;
            this.listener.b(this);
        }
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bitmapDescriptor) == null) {
            this.f36425i = bitmapDescriptor;
            this.listener.b(this);
        }
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
            }
            this.f36426j = list;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f36421e = i2;
        this.listener.b(this);
    }
}
