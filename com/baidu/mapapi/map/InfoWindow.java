package com.baidu.mapapi.map;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class InfoWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BitmapDescriptor a;

    /* renamed from: b  reason: collision with root package name */
    public View f33921b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f33922c;

    /* renamed from: d  reason: collision with root package name */
    public OnInfoWindowClickListener f33923d;

    /* renamed from: e  reason: collision with root package name */
    public a f33924e;

    /* renamed from: f  reason: collision with root package name */
    public int f33925f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33926g;

    /* renamed from: h  reason: collision with root package name */
    public int f33927h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33928i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f33929j;
    public boolean k;
    public String l;

    /* loaded from: classes4.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    /* loaded from: classes4.dex */
    public interface a {
        void a(InfoWindow infoWindow);

        void b(InfoWindow infoWindow);
    }

    public InfoWindow(View view, LatLng latLng, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, latLng, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = "";
        this.f33926g = false;
        this.f33927h = SysOSUtil.getDensityDpi();
        this.f33928i = false;
        this.f33929j = false;
        this.k = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.f33921b = view;
        this.f33922c = latLng;
        this.f33925f = i2;
        this.f33929j = true;
    }

    public InfoWindow(View view, LatLng latLng, int i2, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, latLng, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = "";
        this.f33926g = false;
        this.f33927h = SysOSUtil.getDensityDpi();
        this.f33928i = false;
        this.f33929j = false;
        this.k = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.f33921b = view;
        this.f33922c = latLng;
        this.f33925f = i2;
        this.f33926g = z;
        this.f33927h = i3;
        this.f33929j = true;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i2, OnInfoWindowClickListener onInfoWindowClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapDescriptor, latLng, Integer.valueOf(i2), onInfoWindowClickListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = "";
        this.f33926g = false;
        this.f33927h = SysOSUtil.getDensityDpi();
        this.f33928i = false;
        this.f33929j = false;
        this.k = false;
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
        }
        this.a = bitmapDescriptor;
        this.f33922c = latLng;
        this.f33923d = onInfoWindowClickListener;
        this.f33925f = i2;
        this.k = true;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (BitmapDescriptor) invokeV.objValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33922c : (LatLng) invokeV.objValue;
    }

    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33921b : (View) invokeV.objValue;
    }

    public int getYOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33925f : invokeV.intValue;
    }

    public void setBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bitmapDescriptor) == null) || bitmapDescriptor == null) {
            return;
        }
        this.a = bitmapDescriptor;
        this.f33924e.b(this);
    }

    public void setPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, latLng) == null) || latLng == null) {
            return;
        }
        this.f33922c = latLng;
        this.f33924e.b(this);
    }

    public void setTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.l = str;
        }
    }

    public void setView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || view == null) {
            return;
        }
        this.f33921b = view;
        this.f33924e.b(this);
    }

    public void setYOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f33925f = i2;
            this.f33924e.b(this);
        }
    }
}
