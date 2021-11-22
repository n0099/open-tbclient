package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class MarkerOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40275a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40276b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f40277c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f40278d;

    /* renamed from: e  reason: collision with root package name */
    public BitmapDescriptor f40279e;

    /* renamed from: f  reason: collision with root package name */
    public float f40280f;

    /* renamed from: g  reason: collision with root package name */
    public float f40281g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40282h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40283i;
    public float j;
    public String k;
    public int l;
    public boolean m;
    public ArrayList<BitmapDescriptor> n;
    public int o;
    public float p;
    public float q;
    public float r;
    public int s;
    public boolean t;
    public Point u;
    public InfoWindow v;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class MarkerAnimateType {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ MarkerAnimateType[] f40284a;
        public static final MarkerAnimateType drop;
        public static final MarkerAnimateType grow;
        public static final MarkerAnimateType jump;
        public static final MarkerAnimateType none;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-302041648, "Lcom/baidu/mapapi/map/MarkerOptions$MarkerAnimateType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-302041648, "Lcom/baidu/mapapi/map/MarkerOptions$MarkerAnimateType;");
                    return;
                }
            }
            none = new MarkerAnimateType("none", 0);
            drop = new MarkerAnimateType("drop", 1);
            grow = new MarkerAnimateType("grow", 2);
            MarkerAnimateType markerAnimateType = new MarkerAnimateType("jump", 3);
            jump = markerAnimateType;
            f40284a = new MarkerAnimateType[]{none, drop, grow, markerAnimateType};
        }

        public MarkerAnimateType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MarkerAnimateType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MarkerAnimateType) Enum.valueOf(MarkerAnimateType.class, str) : (MarkerAnimateType) invokeL.objValue;
        }

        public static MarkerAnimateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MarkerAnimateType[]) f40284a.clone() : (MarkerAnimateType[]) invokeV.objValue;
        }
    }

    public MarkerOptions() {
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
        this.f40280f = 0.5f;
        this.f40281g = 1.0f;
        this.f40282h = true;
        this.f40283i = false;
        this.m = false;
        this.o = 20;
        this.p = 1.0f;
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = MarkerAnimateType.none.ordinal();
        this.t = false;
        this.f40276b = true;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Marker marker = new Marker();
            marker.A = this.f40276b;
            marker.z = this.f40275a;
            marker.B = this.f40277c;
            LatLng latLng = this.f40278d;
            if (latLng != null) {
                marker.f40266a = latLng;
                if (this.f40279e == null && this.n == null) {
                    throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the icon or icons");
                }
                marker.f40267b = this.f40279e;
                marker.f40268c = this.f40280f;
                marker.f40269d = this.f40281g;
                marker.f40270e = this.f40282h;
                marker.f40271f = this.f40283i;
                marker.f40272g = this.j;
                marker.f40273h = this.k;
                marker.f40274i = this.l;
                marker.j = this.m;
                marker.o = this.n;
                marker.p = this.o;
                marker.l = this.r;
                marker.r = this.p;
                marker.s = this.q;
                marker.m = this.s;
                marker.n = this.t;
                marker.v = this.v;
                Point point = this.u;
                if (point != null) {
                    marker.u = point;
                }
                return marker;
            }
            throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the position");
        }
        return (Overlay) invokeV.objValue;
    }

    public MarkerOptions alpha(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            if (f2 < 0.0f || f2 > 1.0f) {
                this.r = 1.0f;
                return this;
            }
            this.r = f2;
            return this;
        }
        return (MarkerOptions) invokeF.objValue;
    }

    public MarkerOptions anchor(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f2 >= 0.0f && f2 <= 1.0f && f3 >= 0.0f && f3 <= 1.0f) {
                this.f40280f = f2;
                this.f40281g = f3;
            }
            return this;
        }
        return (MarkerOptions) invokeCommon.objValue;
    }

    public MarkerOptions animateType(MarkerAnimateType markerAnimateType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, markerAnimateType)) == null) {
            if (markerAnimateType == null) {
                markerAnimateType = MarkerAnimateType.none;
            }
            this.s = markerAnimateType.ordinal();
            return this;
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions draggable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.f40283i = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bundle)) == null) {
            this.f40277c = bundle;
            return this;
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions fixedScreenPosition(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, point)) == null) {
            this.u = point;
            this.t = true;
            return this;
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions flat(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.m = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public float getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.r : invokeV.floatValue;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40280f : invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f40281g : invokeV.floatValue;
    }

    public MarkerAnimateType getAnimateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.s;
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? MarkerAnimateType.none : MarkerAnimateType.jump : MarkerAnimateType.grow : MarkerAnimateType.drop;
        }
        return (MarkerAnimateType) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f40277c : (Bundle) invokeV.objValue;
    }

    public BitmapDescriptor getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f40279e : (BitmapDescriptor) invokeV.objValue;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.n : (ArrayList) invokeV.objValue;
    }

    public int getPeriod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.o : invokeV.intValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f40278d : (LatLng) invokeV.objValue;
    }

    public float getRotate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.j : invokeV.floatValue;
    }

    @Deprecated
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f40275a : invokeV.intValue;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.f40279e = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, arrayList)) == null) {
            if (arrayList != null) {
                if (arrayList.size() == 0) {
                    return this;
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (arrayList.get(i2) == null || arrayList.get(i2).f40136a == null) {
                        return this;
                    }
                }
                this.n = arrayList;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions infoWindow(InfoWindow infoWindow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, infoWindow)) == null) {
            this.v = infoWindow;
            return this;
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public boolean isDraggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f40283i : invokeV.booleanValue;
    }

    public boolean isFlat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean isPerspective() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f40282h : invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f40276b : invokeV.booleanValue;
    }

    public MarkerOptions period(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            if (i2 > 0) {
                this.o = i2;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
        }
        return (MarkerOptions) invokeI.objValue;
    }

    public MarkerOptions perspective(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
            this.f40282h = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions position(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, latLng)) == null) {
            if (latLng != null) {
                this.f40278d = latLng;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions rotate(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048606, this, f2)) == null) {
            while (f2 < 0.0f) {
                f2 += 360.0f;
            }
            this.j = f2 % 360.0f;
            return this;
        }
        return (MarkerOptions) invokeF.objValue;
    }

    public MarkerOptions scaleX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f2)) == null) {
            if (f2 < 0.0f) {
                return this;
            }
            this.p = f2;
            return this;
        }
        return (MarkerOptions) invokeF.objValue;
    }

    public MarkerOptions scaleY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048608, this, f2)) == null) {
            if (f2 < 0.0f) {
                return this;
            }
            this.q = f2;
            return this;
        }
        return (MarkerOptions) invokeF.objValue;
    }

    @Deprecated
    public MarkerOptions title(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
            this.f40276b = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions yOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            this.l = i2;
            return this;
        }
        return (MarkerOptions) invokeI.objValue;
    }

    public MarkerOptions zIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            this.f40275a = i2;
            return this;
        }
        return (MarkerOptions) invokeI.objValue;
    }
}
