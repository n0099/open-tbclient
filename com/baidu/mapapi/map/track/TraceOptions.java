package com.baidu.mapapi.map.track;

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
import java.util.List;
/* loaded from: classes2.dex */
public class TraceOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public List<LatLng> c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public boolean h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class TraceAnimateType {
        public static /* synthetic */ Interceptable $ic;
        public static final TraceAnimateType TraceOverlayAnimationEasingCurveEaseIn;
        public static final TraceAnimateType TraceOverlayAnimationEasingCurveEaseInOut;
        public static final TraceAnimateType TraceOverlayAnimationEasingCurveEaseOut;
        public static final TraceAnimateType TraceOverlayAnimationEasingCurveLinear;
        public static final /* synthetic */ TraceAnimateType[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-40378764, "Lcom/baidu/mapapi/map/track/TraceOptions$TraceAnimateType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-40378764, "Lcom/baidu/mapapi/map/track/TraceOptions$TraceAnimateType;");
                    return;
                }
            }
            TraceOverlayAnimationEasingCurveLinear = new TraceAnimateType("TraceOverlayAnimationEasingCurveLinear", 0);
            TraceOverlayAnimationEasingCurveEaseIn = new TraceAnimateType("TraceOverlayAnimationEasingCurveEaseIn", 1);
            TraceOverlayAnimationEasingCurveEaseOut = new TraceAnimateType("TraceOverlayAnimationEasingCurveEaseOut", 2);
            TraceAnimateType traceAnimateType = new TraceAnimateType("TraceOverlayAnimationEasingCurveEaseInOut", 3);
            TraceOverlayAnimationEasingCurveEaseInOut = traceAnimateType;
            a = new TraceAnimateType[]{TraceOverlayAnimationEasingCurveLinear, TraceOverlayAnimationEasingCurveEaseIn, TraceOverlayAnimationEasingCurveEaseOut, traceAnimateType};
        }

        public TraceAnimateType(String str, int i) {
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

        public static TraceAnimateType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (TraceAnimateType) Enum.valueOf(TraceAnimateType.class, str);
            }
            return (TraceAnimateType) invokeL.objValue;
        }

        public static TraceAnimateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (TraceAnimateType[]) a.clone();
            }
            return (TraceAnimateType[]) invokeV.objValue;
        }
    }

    public TraceOptions() {
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
        this.a = -15794282;
        this.b = 14;
        this.d = 300;
        this.e = false;
        this.g = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear.ordinal();
        this.h = false;
    }

    public TraceOverlay getOverlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TraceOverlay traceOverlay = new TraceOverlay();
            traceOverlay.a = this.a;
            traceOverlay.b = this.b;
            traceOverlay.c = this.c;
            traceOverlay.d = this.d;
            traceOverlay.f = this.e;
            traceOverlay.e = this.f;
            traceOverlay.g = this.g;
            traceOverlay.h = this.h;
            return traceOverlay;
        }
        return (TraceOverlay) invokeV.objValue;
    }

    public TraceOptions animate(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.e = z;
            return this;
        }
        return (TraceOptions) invokeZ.objValue;
    }

    public TraceOptions animationDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.f = i;
            return this;
        }
        return (TraceOptions) invokeI.objValue;
    }

    public TraceOptions animationTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i >= 300) {
                this.d = i;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
        }
        return (TraceOptions) invokeI.objValue;
    }

    public TraceOptions animationType(TraceAnimateType traceAnimateType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, traceAnimateType)) == null) {
            if (traceAnimateType == null) {
                traceAnimateType = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
            }
            this.g = traceAnimateType.ordinal();
            return this;
        }
        return (TraceOptions) invokeL.objValue;
    }

    public TraceOptions color(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.a = i;
            return this;
        }
        return (TraceOptions) invokeI.objValue;
    }

    public TraceOptions setTrackMove(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (TraceOptions) invokeZ.objValue;
    }

    public TraceOptions width(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            this.b = i;
            return this;
        }
        return (TraceOptions) invokeI.objValue;
    }

    public TraceAnimateType getAnimateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.g;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
                    }
                    return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseInOut;
                }
                return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseOut;
            }
            return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseIn;
        }
        return (TraceAnimateType) invokeV.objValue;
    }

    public int getAnimationDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int getAnimationTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean isAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean isTrackMove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public TraceOptions points(List<LatLng> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            if (list != null) {
                if (list.size() >= 2) {
                    if (!list.contains(null)) {
                        this.c = list;
                        return this;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                }
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
            }
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        return (TraceOptions) invokeL.objValue;
    }
}
