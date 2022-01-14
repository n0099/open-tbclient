package com.baidu.mapapi.synchronization;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class DisplayOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "DisplayOptions";
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public View C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public int I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public List<BitmapDescriptor> R;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f35658b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35659c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35660d;

    /* renamed from: e  reason: collision with root package name */
    public int f35661e;

    /* renamed from: f  reason: collision with root package name */
    public BitmapDescriptor f35662f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35663g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35664h;

    /* renamed from: i  reason: collision with root package name */
    public int f35665i;

    /* renamed from: j  reason: collision with root package name */
    public BitmapDescriptor f35666j;
    public boolean k;
    public boolean l;
    public int m;
    public BitmapDescriptor n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public BitmapDescriptor u;
    public BitmapDescriptor v;
    public BitmapDescriptor w;
    public BitmapDescriptor x;
    public BitmapDescriptor y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1932501037, "Lcom/baidu/mapapi/synchronization/DisplayOptions;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1932501037, "Lcom/baidu/mapapi/synchronization/DisplayOptions;");
        }
    }

    public DisplayOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35661e = 6;
        this.f35665i = 7;
        this.k = true;
        this.l = true;
        this.m = 8;
        this.q = 10;
        this.t = 5;
        this.D = true;
        this.E = true;
        this.F = 6;
        this.G = true;
        this.H = true;
        this.I = 7;
        this.J = true;
        this.K = true;
        this.L = 8;
        this.M = 50;
        this.N = 50;
        this.O = 50;
        this.P = 50;
        this.R = new ArrayList();
        this.f35658b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");
        this.f35659c = true;
        this.f35660d = true;
        this.f35662f = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");
        this.f35663g = true;
        this.f35664h = true;
        this.f35666j = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");
        this.k = true;
        this.l = true;
        this.n = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Passenger.png");
        this.o = true;
        this.p = true;
        this.r = true;
        this.s = true;
        this.u = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Smooth.png");
        this.v = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Slow.png");
        this.w = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Congestion.png");
        this.x = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_SevereCongestion.png");
        this.y = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Bule_Arrow.png");
        this.z = 22;
    }

    public boolean get3DCarMarkerEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.Q : invokeV.booleanValue;
    }

    public List<BitmapDescriptor> get3DCarMarkerIconList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.R : (List) invokeV.objValue;
    }

    public BitmapDescriptor getCarIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35666j : (BitmapDescriptor) invokeV.objValue;
    }

    public View getCarInfoWindowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.A : (View) invokeV.objValue;
    }

    public int getCarPositionInfoWindowZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.L : invokeV.intValue;
    }

    public int getCarPositionMarkerZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public BitmapDescriptor getEndPositionIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35662f : (BitmapDescriptor) invokeV.objValue;
    }

    public View getEndPositionInfoWindowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.C : (View) invokeV.objValue;
    }

    public int getEndPositionInfoWindowZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.I : invokeV.intValue;
    }

    public int getEndPositionMarkerZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f35665i : invokeV.intValue;
    }

    public int getPaddingBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.P : invokeV.intValue;
    }

    public int getPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.M : invokeV.intValue;
    }

    public int getPaddingRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.N : invokeV.intValue;
    }

    public int getPaddingTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.O : invokeV.intValue;
    }

    public BitmapDescriptor getPassengerIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.n : (BitmapDescriptor) invokeV.objValue;
    }

    public int getPassengerMarkerZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.q : invokeV.intValue;
    }

    public int getRouteLineWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.z : invokeV.intValue;
    }

    public int getRouteLineZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.t : invokeV.intValue;
    }

    public BitmapDescriptor getStartPositionIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f35658b : (BitmapDescriptor) invokeV.objValue;
    }

    public View getStartPositionInfoWindowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.B : (View) invokeV.objValue;
    }

    public int getStartPositionInfoWindowZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.F : invokeV.intValue;
    }

    public int getStartPositionMarkerZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f35661e : invokeV.intValue;
    }

    public List<BitmapDescriptor> getTrafficTextureList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.y);
            arrayList.add(this.u);
            arrayList.add(this.v);
            arrayList.add(this.w);
            arrayList.add(this.x);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean isShowCarInfoWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.J : invokeV.booleanValue;
    }

    public boolean isShowCarMarker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean isShowCarMarkerInSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean isShowEndPositionInfoWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public boolean isShowEndPositionMarker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f35663g : invokeV.booleanValue;
    }

    public boolean isShowEndPositionMarkerInSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f35664h : invokeV.booleanValue;
    }

    public boolean isShowPassengerIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean isShowPassengerIconInSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean isShowRoutePlan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean isShowRoutePlanInSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean isShowStartPositionInfoWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean isShowStartPositionMarker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f35659c : invokeV.booleanValue;
    }

    public boolean isShowStartPositionMarkerInSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f35660d : invokeV.booleanValue;
    }

    public DisplayOptions set3DCarMarkerEnable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
            this.Q = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions set3DCarMarkerIconList(List<BitmapDescriptor> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                this.R = null;
            } else {
                this.R.addAll(list);
            }
            return this;
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.f35666j = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: CarIcon descriptor is null");
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setCarInfoWindowView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, view)) == null) {
            this.A = view;
            return this;
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setCarPositionInfoWindowZIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            if (i2 <= 1) {
                i2 = 2;
            }
            this.L = i2;
            return this;
        }
        return (DisplayOptions) invokeI.objValue;
    }

    public DisplayOptions setCarPositionMarkerZIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
            if (i2 <= 1) {
                i2 = 2;
            }
            this.m = i2;
            return this;
        }
        return (DisplayOptions) invokeI.objValue;
    }

    public DisplayOptions setCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.w = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: CongestionTrafficTexture descriptor is null");
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.f35662f = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: EndPositionIcon descriptor is null");
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setEndPositionInfoWindowView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, view)) == null) {
            this.C = view;
            return this;
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setEndPositionInfoWindowZIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
            if (i2 <= 1) {
                i2 = 2;
            }
            this.I = i2;
            return this;
        }
        return (DisplayOptions) invokeI.objValue;
    }

    public DisplayOptions setEndPositionMarkerZIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
            if (i2 <= 1) {
                i2 = 2;
            }
            this.f35665i = i2;
            return this;
        }
        return (DisplayOptions) invokeI.objValue;
    }

    public DisplayOptions setMapViewPadding(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048623, this, i2, i3, i4, i5)) == null) {
            if (i2 < 0 || i4 < 0 || i3 < 0 || i5 < 0) {
                String str = a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Padding param is invalid. paddingLeft = " + i2 + "; paddingRight = " + i4 + "; paddingTop = " + i3 + "; paddingBottom = " + i5);
            }
            if (i2 < 0) {
                i2 = 30;
            }
            this.M = i2;
            if (i3 < 0) {
                i3 = 30;
            }
            this.O = i3;
            if (i4 < 0) {
                i4 = 30;
            }
            this.N = i4;
            if (i5 < 0) {
                i5 = 50;
            }
            this.P = i5;
            return this;
        }
        return (DisplayOptions) invokeIIII.objValue;
    }

    public DisplayOptions setPassengerIcon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.n = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: PassengerIcon descriptor is null");
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setPassengerMarkerZIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
            if (i2 <= 1) {
                i2 = 2;
            }
            this.q = i2;
            return this;
        }
        return (DisplayOptions) invokeI.objValue;
    }

    public DisplayOptions setRouteLineWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
            int i3 = 5;
            if (i2 >= 5) {
                i3 = 40;
                if (i2 <= 40) {
                    this.z = i2;
                    return this;
                }
            }
            this.z = i3;
            return this;
        }
        return (DisplayOptions) invokeI.objValue;
    }

    public DisplayOptions setRouteLineZIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
            if (i2 <= 1) {
                i2 = 2;
            }
            this.t = i2;
            return this;
        }
        return (DisplayOptions) invokeI.objValue;
    }

    public DisplayOptions setSevereCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.x = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: SevereCongestionTrafficTexture descriptor is null");
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setSlowTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.v = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: SlowTrafficTexture descriptor is null");
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setSmoothTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.u = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: SmoothTrafficTexture descriptor is null");
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.f35658b = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: StartPositionIcon descriptor is null");
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setStartPositionInfoWindowView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, view)) == null) {
            this.B = view;
            return this;
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions setStartPositionInfoWindowZIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            if (i2 <= 1) {
                i2 = 2;
            }
            this.F = i2;
            return this;
        }
        return (DisplayOptions) invokeI.objValue;
    }

    public DisplayOptions setStartPositionMarkerZIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) {
            if (i2 <= 1) {
                i2 = 2;
            }
            this.f35661e = i2;
            return this;
        }
        return (DisplayOptions) invokeI.objValue;
    }

    public DisplayOptions setUnknownTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.y = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: UnknownTrafficTexture descriptor is null");
        }
        return (DisplayOptions) invokeL.objValue;
    }

    public DisplayOptions showCarIcon(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048636, this, z)) == null) {
            this.k = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showCarIconInSpan(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048637, this, z)) == null) {
            this.l = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showCarInfoWindow(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z)) == null) {
            this.J = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showCarInfoWindowInSpan(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048639, this, z)) == null) {
            this.K = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showEndPositionIcon(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048640, this, z)) == null) {
            this.f35663g = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showEndPositionIconInSpan(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048641, this, z)) == null) {
            this.f35664h = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showEndPositionInfoWindow(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048642, this, z)) == null) {
            this.G = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showEndPositionInfoWindowInSpan(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048643, this, z)) == null) {
            this.H = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showPassengereIcon(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048644, this, z)) == null) {
            this.o = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showPassengereIconInSpan(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048645, this, z)) == null) {
            this.p = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showRoutePlan(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048646, this, z)) == null) {
            this.r = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showRoutePlanInSpan(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048647, this, z)) == null) {
            this.s = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showStartPositionIcon(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048648, this, z)) == null) {
            this.f35659c = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showStartPositionIconInSpan(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048649, this, z)) == null) {
            this.f35660d = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showStartPositionInfoWindow(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048650, this, z)) == null) {
            this.D = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }

    public DisplayOptions showStartPositionInfoWindowInSpan(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048651, this, z)) == null) {
            this.E = z;
            return this;
        }
        return (DisplayOptions) invokeZ.objValue;
    }
}
