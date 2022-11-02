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
    public int A;
    public int B;
    public boolean C;
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
    public int t;
    public boolean u;
    public Point v;
    public boolean w;
    public InfoWindow x;
    public int y;
    public boolean z;

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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (MarkerAnimateType) Enum.valueOf(MarkerAnimateType.class, str);
            }
            return (MarkerAnimateType) invokeL.objValue;
        }

        public static MarkerAnimateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (MarkerAnimateType[]) a.clone();
            }
            return (MarkerAnimateType[]) invokeV.objValue;
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
        this.s = 0;
        this.t = MarkerAnimateType.none.ordinal();
        this.u = false;
        this.w = true;
        this.y = Integer.MAX_VALUE;
        this.z = false;
        this.A = 4;
        this.B = 22;
        this.C = false;
        this.b = true;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Marker marker = new Marker();
            marker.H = this.b;
            marker.G = this.a;
            marker.I = this.c;
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
                marker.s = this.n;
                marker.t = this.o;
                marker.l = this.r;
                marker.r = this.s;
                marker.v = this.p;
                marker.w = this.q;
                marker.m = this.t;
                marker.n = this.u;
                marker.z = this.x;
                marker.o = this.w;
                marker.C = this.y;
                marker.q = this.z;
                marker.D = this.A;
                marker.E = this.B;
                marker.p = this.C;
                Point point = this.v;
                if (point != null) {
                    marker.y = point;
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
            if (f >= 0.0f && f <= 1.0f) {
                this.r = f;
                return this;
            }
            this.r = 1.0f;
            return this;
        }
        return (MarkerOptions) invokeF.objValue;
    }

    public MarkerOptions animateType(MarkerAnimateType markerAnimateType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, markerAnimateType)) == null) {
            if (markerAnimateType == null) {
                markerAnimateType = MarkerAnimateType.none;
            }
            this.t = markerAnimateType.ordinal();
            return this;
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions clickable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.w = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions draggable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions endLevel(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.B = i;
            return this;
        }
        return (MarkerOptions) invokeI.objValue;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
            this.c = bundle;
            return this;
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions fixedScreenPosition(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, point)) == null) {
            this.v = point;
            this.u = true;
            return this;
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions flat(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.m = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions height(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            if (i < 0) {
                this.s = 0;
                return this;
            }
            this.s = i;
            return this;
        }
        return (MarkerOptions) invokeI.objValue;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.e = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions infoWindow(InfoWindow infoWindow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, infoWindow)) == null) {
            this.x = infoWindow;
            return this;
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions isForceDisPlay(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048611, this, z)) == null) {
            this.z = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions isJoinCollision(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
            this.C = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions period(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) {
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions position(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, latLng)) == null) {
            if (latLng != null) {
                this.d = latLng;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions priority(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i)) == null) {
            this.y = i;
            return this;
        }
        return (MarkerOptions) invokeI.objValue;
    }

    public MarkerOptions rotate(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048619, this, f)) == null) {
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
        if (interceptable == null || (invokeF = interceptable.invokeF(1048620, this, f)) == null) {
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
        if (interceptable == null || (invokeF = interceptable.invokeF(1048621, this, f)) == null) {
            if (f < 0.0f) {
                return this;
            }
            this.q = f;
            return this;
        }
        return (MarkerOptions) invokeF.objValue;
    }

    public MarkerOptions startLevel(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
            this.A = i;
            return this;
        }
        return (MarkerOptions) invokeI.objValue;
    }

    @Deprecated
    public MarkerOptions title(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (MarkerOptions) invokeL.objValue;
    }

    public MarkerOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048624, this, z)) == null) {
            this.b = z;
            return this;
        }
        return (MarkerOptions) invokeZ.objValue;
    }

    public MarkerOptions yOffset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i)) == null) {
            this.l = i;
            return this;
        }
        return (MarkerOptions) invokeI.objValue;
    }

    public MarkerOptions zIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i)) == null) {
            this.a = i;
            return this;
        }
        return (MarkerOptions) invokeI.objValue;
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

    public float getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.r;
        }
        return invokeV.floatValue;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g;
        }
        return invokeV.floatValue;
    }

    public MarkerAnimateType getAnimateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i = this.t;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return MarkerAnimateType.none;
                    }
                    return MarkerAnimateType.jump;
                }
                return MarkerAnimateType.grow;
            }
            return MarkerAnimateType.drop;
        }
        return (MarkerAnimateType) invokeV.objValue;
    }

    public int getEndLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.c;
        }
        return (Bundle) invokeV.objValue;
    }

    public boolean getForceDisPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public BitmapDescriptor getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.e;
        }
        return (BitmapDescriptor) invokeV.objValue;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.n;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean getIsClickable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public boolean getJoinCollision() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.C;
        }
        return invokeV.booleanValue;
    }

    public int getPeriod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.d;
        }
        return (LatLng) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.y;
        }
        return invokeV.intValue;
    }

    public float getRotate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.j;
        }
        return invokeV.floatValue;
    }

    public int getStartLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean isDraggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean isFlat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public boolean isPerspective() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, arrayList)) == null) {
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
}
