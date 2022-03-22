package com.baidu.ar.track2d;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public interface ITrack2DState {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class DistanceState {
        public static final /* synthetic */ DistanceState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DistanceState NORMAL;
        public static final DistanceState TOO_FAR;
        public static final DistanceState TOO_NEAR;
        public static final DistanceState UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1108189512, "Lcom/baidu/ar/track2d/ITrack2DState$DistanceState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1108189512, "Lcom/baidu/ar/track2d/ITrack2DState$DistanceState;");
                    return;
                }
            }
            NORMAL = new DistanceState("NORMAL", 0);
            TOO_FAR = new DistanceState("TOO_FAR", 1);
            TOO_NEAR = new DistanceState("TOO_NEAR", 2);
            DistanceState distanceState = new DistanceState(RomUtils.UNKNOWN, 3);
            UNKNOWN = distanceState;
            $VALUES = new DistanceState[]{NORMAL, TOO_FAR, TOO_NEAR, distanceState};
        }

        public DistanceState(String str, int i) {
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

        public static DistanceState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DistanceState) Enum.valueOf(DistanceState.class, str) : (DistanceState) invokeL.objValue;
        }

        public static DistanceState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DistanceState[]) $VALUES.clone() : (DistanceState[]) invokeV.objValue;
        }
    }

    DistanceState distanceState();

    boolean isModelAppear();

    boolean isShowImmediately();

    boolean isTrackFound();
}
