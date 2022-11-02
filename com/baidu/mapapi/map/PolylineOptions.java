package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
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
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolylineOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public Bundle c;
    public int d;
    public List<LatLng> e;
    public List<Integer> f;
    public List<Integer> g;
    public int h;
    public BitmapDescriptor i;
    public List<BitmapDescriptor> j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public LineJoinType p;
    public LineCapType q;
    public boolean r;
    public boolean s;
    public boolean t;
    public LineDirectionCross180 u;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class LineCapType {
        public static /* synthetic */ Interceptable $ic;
        public static final LineCapType LineCapButt;
        public static final LineCapType LineCapRound;
        public static final /* synthetic */ LineCapType[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1174966337, "Lcom/baidu/mapapi/map/PolylineOptions$LineCapType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1174966337, "Lcom/baidu/mapapi/map/PolylineOptions$LineCapType;");
                    return;
                }
            }
            LineCapButt = new LineCapType("LineCapButt", 0);
            LineCapType lineCapType = new LineCapType("LineCapRound", 1);
            LineCapRound = lineCapType;
            a = new LineCapType[]{LineCapButt, lineCapType};
        }

        public LineCapType(String str, int i) {
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

        public static LineCapType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (LineCapType) Enum.valueOf(LineCapType.class, str);
            }
            return (LineCapType) invokeL.objValue;
        }

        public static LineCapType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (LineCapType[]) a.clone();
            }
            return (LineCapType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class LineDirectionCross180 {
        public static /* synthetic */ Interceptable $ic;
        public static final LineDirectionCross180 FROM_EAST_TO_WEST;
        public static final LineDirectionCross180 FROM_WEST_TO_EAST;
        public static final LineDirectionCross180 NONE;
        public static final /* synthetic */ LineDirectionCross180[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1503484381, "Lcom/baidu/mapapi/map/PolylineOptions$LineDirectionCross180;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1503484381, "Lcom/baidu/mapapi/map/PolylineOptions$LineDirectionCross180;");
                    return;
                }
            }
            NONE = new LineDirectionCross180(HlsPlaylistParser.METHOD_NONE, 0);
            FROM_EAST_TO_WEST = new LineDirectionCross180("FROM_EAST_TO_WEST", 1);
            LineDirectionCross180 lineDirectionCross180 = new LineDirectionCross180("FROM_WEST_TO_EAST", 2);
            FROM_WEST_TO_EAST = lineDirectionCross180;
            a = new LineDirectionCross180[]{NONE, FROM_EAST_TO_WEST, lineDirectionCross180};
        }

        public LineDirectionCross180(String str, int i) {
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

        public static LineDirectionCross180 valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (LineDirectionCross180) Enum.valueOf(LineDirectionCross180.class, str);
            }
            return (LineDirectionCross180) invokeL.objValue;
        }

        public static LineDirectionCross180[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (LineDirectionCross180[]) a.clone();
            }
            return (LineDirectionCross180[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class LineJoinType {
        public static /* synthetic */ Interceptable $ic;
        public static final LineJoinType LineJoinBerzier;
        public static final LineJoinType LineJoinBevel;
        public static final LineJoinType LineJoinMiter;
        public static final LineJoinType LineJoinRound;
        public static final /* synthetic */ LineJoinType[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-114079993, "Lcom/baidu/mapapi/map/PolylineOptions$LineJoinType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-114079993, "Lcom/baidu/mapapi/map/PolylineOptions$LineJoinType;");
                    return;
                }
            }
            LineJoinBevel = new LineJoinType("LineJoinBevel", 0);
            LineJoinMiter = new LineJoinType("LineJoinMiter", 1);
            LineJoinRound = new LineJoinType("LineJoinRound", 2);
            LineJoinType lineJoinType = new LineJoinType("LineJoinBerzier", 3);
            LineJoinBerzier = lineJoinType;
            a = new LineJoinType[]{LineJoinBevel, LineJoinMiter, LineJoinRound, lineJoinType};
        }

        public LineJoinType(String str, int i) {
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

        public static LineJoinType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (LineJoinType) Enum.valueOf(LineJoinType.class, str);
            }
            return (LineJoinType) invokeL.objValue;
        }

        public static LineJoinType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (LineJoinType[]) a.clone();
            }
            return (LineJoinType[]) invokeV.objValue;
        }
    }

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
        this.d = -16777216;
        this.h = 5;
        this.k = true;
        this.l = false;
        this.b = true;
        this.m = false;
        this.n = true;
        this.o = 0;
        this.p = LineJoinType.LineJoinRound;
        this.q = LineCapType.LineCapButt;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = LineDirectionCross180.NONE;
    }

    private Polyline a(Polyline polyline) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, polyline)) == null) {
            polyline.H = this.b;
            polyline.r = this.u;
            polyline.b = this.e;
            polyline.o = this.t;
            List<Integer> list = this.g;
            if (list != null && list.size() != 0) {
                int[] iArr = new int[this.g.size()];
                int i = 0;
                for (Integer num : this.g) {
                    iArr[i] = num.intValue();
                    i++;
                }
                polyline.d = iArr;
                return polyline;
            }
            throw new IllegalStateException("BDMapSDKException: colors array can not be null");
        }
        return (Polyline) invokeL.objValue;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Polyline polyline = new Polyline();
            List<LatLng> list = this.e;
            if (list != null && list.size() >= 2) {
                boolean z = this.t;
                if (z) {
                    polyline.type = com.baidu.mapsdkplatform.comapi.map.i.n;
                    return a(polyline);
                }
                polyline.H = this.b;
                polyline.f = this.m;
                polyline.G = this.a;
                polyline.I = this.c;
                polyline.b = this.e;
                polyline.a = this.d;
                polyline.e = this.h;
                polyline.j = this.i;
                polyline.k = this.j;
                polyline.g = this.k;
                polyline.h = this.l;
                polyline.i = this.n;
                polyline.m = this.r;
                polyline.n = this.s;
                polyline.o = z;
                polyline.l = this.o;
                polyline.q = this.p;
                polyline.p = this.q;
                polyline.r = this.u;
                List<Integer> list2 = this.f;
                if (list2 != null && list2.size() < this.e.size() - 1) {
                    ArrayList arrayList = new ArrayList((this.e.size() - 1) - this.f.size());
                    List<Integer> list3 = this.f;
                    list3.addAll(list3.size(), arrayList);
                }
                List<Integer> list4 = this.f;
                int i = 0;
                if (list4 != null && list4.size() > 0) {
                    int[] iArr = new int[this.f.size()];
                    int i2 = 0;
                    for (Integer num : this.f) {
                        iArr[i2] = num.intValue();
                        i2++;
                    }
                    polyline.c = iArr;
                }
                List<Integer> list5 = this.g;
                if (list5 != null && list5.size() < this.e.size() - 1) {
                    ArrayList arrayList2 = new ArrayList((this.e.size() - 1) - this.g.size());
                    List<Integer> list6 = this.g;
                    list6.addAll(list6.size(), arrayList2);
                }
                List<Integer> list7 = this.g;
                if (list7 != null && list7.size() > 0) {
                    int[] iArr2 = new int[this.g.size()];
                    for (Integer num2 : this.g) {
                        iArr2[i] = num2.intValue();
                        i++;
                    }
                    polyline.d = iArr2;
                }
                return polyline;
            }
            throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
        }
        return (Overlay) invokeV.objValue;
    }

    public PolylineOptions clickable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.n = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions color(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.d = i;
            return this;
        }
        return (PolylineOptions) invokeI.objValue;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null) {
                if (!list.contains(null)) {
                    this.g = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bitmapDescriptor)) == null) {
            this.i = bitmapDescriptor;
            return this;
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions dottedLine(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.m = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions dottedLineType(PolylineDottedLineType polylineDottedLineType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, polylineDottedLineType)) == null) {
            this.o = polylineDottedLineType.ordinal();
            return this;
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle)) == null) {
            this.c = bundle;
            return this;
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions focus(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.k = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions isGeodesic(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.s = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions isGradient(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            this.t = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions isThined(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.r = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions keepScale(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            this.l = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions lineCapType(LineCapType lineCapType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, lineCapType)) == null) {
            this.q = lineCapType;
            return this;
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions lineDirectionCross180(LineDirectionCross180 lineDirectionCross180) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, lineDirectionCross180)) == null) {
            this.u = lineDirectionCross180;
            return this;
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions lineJoinType(LineJoinType lineJoinType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, lineJoinType)) == null) {
            this.p = lineJoinType;
            return this;
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions textureIndex(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, list)) == null) {
            if (list != null) {
                if (!list.contains(null)) {
                    this.f = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: index list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public PolylineOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
            this.b = z;
            return this;
        }
        return (PolylineOptions) invokeZ.objValue;
    }

    public PolylineOptions width(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            if (i > 0) {
                this.h = i;
            }
            return this;
        }
        return (PolylineOptions) invokeI.objValue;
    }

    public PolylineOptions zIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            this.a = i;
            return this;
        }
        return (PolylineOptions) invokeI.objValue;
    }

    public PolylineOptions customTextureList(List<BitmapDescriptor> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
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

    public PolylineOptions points(List<LatLng> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, list)) == null) {
            if (list != null) {
                if (list.size() >= 2) {
                    if (!list.contains(null)) {
                        this.e = list;
                        return this;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                }
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
            }
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        return (PolylineOptions) invokeL.objValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public BitmapDescriptor getCustomTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.i;
        }
        return (BitmapDescriptor) invokeV.objValue;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j;
        }
        return (List) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c;
        }
        return (Bundle) invokeV.objValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> getTextureIndexs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean isDottedLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public boolean isFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }
}
