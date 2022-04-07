package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
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
/* loaded from: classes2.dex */
public final class MarkerOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public Bundle c;
    public LatLng d;
    public BitmapDescriptor e;
    public float f;
    public float g;
    public boolean h;
    public boolean i;
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
    /* loaded from: classes2.dex */
    public static final class MarkerAnimateType {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ MarkerAnimateType[] a;
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
            MarkerAnimateType markerAnimateType = new MarkerAnimateType(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, 3);
            jump = markerAnimateType;
            a = new MarkerAnimateType[]{none, drop, grow, markerAnimateType};
        }

        public MarkerAnimateType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MarkerAnimateType[]) a.clone() : (MarkerAnimateType[]) invokeV.objValue;
        }
    }

    public MarkerOptions() {
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
        this.f = 0.5f;
        this.g = 1.0f;
        this.h = true;
        this.i = false;
        this.m = false;
        this.o = 20;
        this.p = 1.0f;
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = MarkerAnimateType.none.ordinal();
        this.t = false;
        this.b = true;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Marker marker = new Marker();
            marker.A = this.b;
            marker.z = this.a;
            marker.B = this.c;
            LatLng latLng = this.d;
            if (latLng != null) {
                marker.a = latLng;
                if (this.e == null && this.n == null) {
                    throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the icon or icons");
                }
                marker.b = this.e;
                marker.c = this.f;
                marker.d = this.g;
                marker.e = this.h;
                marker.f = this.i;
                marker.g = this.j;
                marker.h = this.k;
                marker.i = this.l;
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

    public MarkerOptions alpha(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            if (f < 0.0f || f > 1.0f) {
                this.r = 1.0f;
                return this;
            }
            this.r = f;
            return this;
        }
        return (MarkerOptions) invokeF.objValue;
    }

    public MarkerOptions anchor(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
                this.f = f;
                this.g = f2;
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
            this.i = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bundle)) == null) {
            this.c = bundle;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.g : invokeV.floatValue;
    }

    public MarkerAnimateType getAnimateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i = this.s;
            return i != 1 ? i != 2 ? i != 3 ? MarkerAnimateType.none : MarkerAnimateType.jump : MarkerAnimateType.grow : MarkerAnimateType.drop;
        }
        return (MarkerAnimateType) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c : (Bundle) invokeV.objValue;
    }

    public BitmapDescriptor getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.e : (BitmapDescriptor) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.d : (LatLng) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.a : invokeV.intValue;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.e = bitmapDescriptor;
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
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) == null || arrayList.get(i).a == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public boolean isFlat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean isPerspective() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public MarkerOptions period(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            if (i > 0) {
                this.o = i;
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
            this.h = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions position(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, latLng)) == null) {
            if (latLng != null) {
                this.d = latLng;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions rotate(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048606, this, f)) == null) {
            while (f < 0.0f) {
                f += 360.0f;
            }
            this.j = f % 360.0f;
            return this;
        }
        return (MarkerOptions) invokeF.objValue;
    }

    public MarkerOptions scaleX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f)) == null) {
            if (f < 0.0f) {
                return this;
            }
            this.p = f;
            return this;
        }
        return (MarkerOptions) invokeF.objValue;
    }

    public MarkerOptions scaleY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048608, this, f)) == null) {
            if (f < 0.0f) {
                return this;
            }
            this.q = f;
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
            this.b = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions yOffset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            this.l = i;
            return this;
        }
        return (MarkerOptions) invokeI.objValue;
    }

    public MarkerOptions zIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) {
            this.a = i;
            return this;
        }
        return (MarkerOptions) invokeI.objValue;
    }
}
