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

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7040a;

    /* renamed from: b  reason: collision with root package name */
    public Point f7041b;

    /* renamed from: c  reason: collision with root package name */
    public ELayoutMode f7042c;

    /* renamed from: d  reason: collision with root package name */
    public float f7043d;

    /* renamed from: e  reason: collision with root package name */
    public float f7044e;

    /* renamed from: f  reason: collision with root package name */
    public int f7045f;

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f7046a;

        /* renamed from: b  reason: collision with root package name */
        public int f7047b;

        /* renamed from: c  reason: collision with root package name */
        public LatLng f7048c;

        /* renamed from: d  reason: collision with root package name */
        public Point f7049d;

        /* renamed from: e  reason: collision with root package name */
        public ELayoutMode f7050e;

        /* renamed from: f  reason: collision with root package name */
        public int f7051f;

        /* renamed from: g  reason: collision with root package name */
        public int f7052g;

        /* renamed from: h  reason: collision with root package name */
        public int f7053h;

        public Builder() {
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
            this.f7050e = ELayoutMode.absoluteMode;
            this.f7051f = 4;
            this.f7052g = 16;
        }

        public Builder align(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                if (i2 == 1 || i2 == 2 || i2 == 4) {
                    this.f7051f = i2;
                }
                if (i3 == 8 || i3 == 16 || i3 == 32) {
                    this.f7052g = i3;
                }
                return this;
            }
            return (Builder) invokeII.objValue;
        }

        public MapViewLayoutParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ELayoutMode eLayoutMode = this.f7050e;
                boolean z = true;
                if (eLayoutMode != ELayoutMode.mapMode ? eLayoutMode != ELayoutMode.absoluteMode || this.f7049d != null : this.f7048c != null) {
                    z = false;
                }
                if (z) {
                    throw new IllegalStateException("BDMapSDKException: if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
                }
                return new MapViewLayoutParams(this.f7046a, this.f7047b, this.f7048c, this.f7049d, this.f7050e, this.f7051f, this.f7052g, this.f7053h);
            }
            return (MapViewLayoutParams) invokeV.objValue;
        }

        public Builder height(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f7047b = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eLayoutMode)) == null) {
                this.f7050e = eLayoutMode;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder point(Point point) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, point)) == null) {
                this.f7049d = point;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder position(LatLng latLng) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, latLng)) == null) {
                this.f7048c = latLng;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder width(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f7046a = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder yOffset(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f7053h = i2;
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

        public ELayoutMode(String str, int i2) {
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
    public MapViewLayoutParams(int i2, int i3, LatLng latLng, Point point, ELayoutMode eLayoutMode, int i4, int i5, int i6) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), latLng, point, eLayoutMode, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7040a = latLng;
        this.f7041b = point;
        this.f7042c = eLayoutMode;
        if (i4 == 1) {
            this.f7043d = 0.0f;
        } else if (i4 != 2) {
            this.f7043d = 0.5f;
        } else {
            this.f7043d = 1.0f;
        }
        if (i5 == 8) {
            this.f7044e = 0.0f;
        } else if (i5 == 16 || i5 != 32) {
            this.f7044e = 1.0f;
        } else {
            this.f7044e = 0.5f;
        }
        this.f7045f = i6;
    }
}
