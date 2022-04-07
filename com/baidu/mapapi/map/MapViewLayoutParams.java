package com.baidu.mapapi.map;

import android.graphics.Point;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class MapViewLayoutParams extends ViewGroup.LayoutParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public LatLng a;
    public Point b;
    public ELayoutMode c;
    public float d;
    public float e;
    public int f;

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public LatLng c;
        public Point d;
        public ELayoutMode e;
        public int f;
        public int g;
        public int h;

        public Builder() {
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
            this.e = ELayoutMode.absoluteMode;
            this.f = 4;
            this.g = 16;
        }

        public Builder align(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
                if (i == 1 || i == 2 || i == 4) {
                    this.f = i;
                }
                if (i2 == 8 || i2 == 16 || i2 == 32) {
                    this.g = i2;
                }
                return this;
            }
            return (Builder) invokeII.objValue;
        }

        public MapViewLayoutParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ELayoutMode eLayoutMode = this.e;
                boolean z = true;
                if (eLayoutMode != ELayoutMode.mapMode ? eLayoutMode != ELayoutMode.absoluteMode || this.d != null : this.c != null) {
                    z = false;
                }
                if (z) {
                    throw new IllegalStateException("BDMapSDKException: if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
                }
                return new MapViewLayoutParams(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
            }
            return (MapViewLayoutParams) invokeV.objValue;
        }

        public Builder height(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.b = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eLayoutMode)) == null) {
                this.e = eLayoutMode;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder point(Point point) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, point)) == null) {
                this.d = point;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder position(LatLng latLng) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, latLng)) == null) {
                this.c = latLng;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder width(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.a = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder yOffset(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.h = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ELayoutMode {
        public static final /* synthetic */ ELayoutMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ELayoutMode absoluteMode;
        public static final ELayoutMode mapMode;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1646260978, "Lcom/baidu/mapapi/map/MapViewLayoutParams$ELayoutMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1646260978, "Lcom/baidu/mapapi/map/MapViewLayoutParams$ELayoutMode;");
                    return;
                }
            }
            mapMode = new ELayoutMode("mapMode", 0);
            ELayoutMode eLayoutMode = new ELayoutMode("absoluteMode", 1);
            absoluteMode = eLayoutMode;
            $VALUES = new ELayoutMode[]{mapMode, eLayoutMode};
        }

        public ELayoutMode(String str, int i) {
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

        public static ELayoutMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ELayoutMode) Enum.valueOf(ELayoutMode.class, str) : (ELayoutMode) invokeL.objValue;
        }

        public static ELayoutMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ELayoutMode[]) $VALUES.clone() : (ELayoutMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapViewLayoutParams(int i, int i2, LatLng latLng, Point point, ELayoutMode eLayoutMode, int i3, int i4, int i5) {
        super(i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), latLng, point, eLayoutMode, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = latLng;
        this.b = point;
        this.c = eLayoutMode;
        if (i3 == 1) {
            this.d = 0.0f;
        } else if (i3 != 2) {
            this.d = 0.5f;
        } else {
            this.d = 1.0f;
        }
        if (i4 == 8) {
            this.e = 0.0f;
        } else if (i4 == 16 || i4 != 32) {
            this.e = 1.0f;
        } else {
            this.e = 0.5f;
        }
        this.f = i5;
    }
}
