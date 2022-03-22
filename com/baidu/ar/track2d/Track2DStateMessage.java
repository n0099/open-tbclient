package com.baidu.ar.track2d;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class Track2DStateMessage {
    public static final /* synthetic */ Track2DStateMessage[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Track2DStateMessage MODEL_CAN_DISAPPEARING;
    public static final Track2DStateMessage MODEL_LOADED;
    public static final Track2DStateMessage TRACK_DISTANCE_NORMAL;
    public static final Track2DStateMessage TRACK_DISTANCE_TOO_FAR;
    public static final Track2DStateMessage TRACK_DISTANCE_TOO_NEAR;
    public static final Track2DStateMessage TRACK_FOUND;
    public static final Track2DStateMessage TRACK_LOST;
    public static final Track2DStateMessage TRACK_MODEL_APPEAR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1403762986, "Lcom/baidu/ar/track2d/Track2DStateMessage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1403762986, "Lcom/baidu/ar/track2d/Track2DStateMessage;");
                return;
            }
        }
        MODEL_LOADED = new Track2DStateMessage("MODEL_LOADED", 0);
        TRACK_MODEL_APPEAR = new Track2DStateMessage("TRACK_MODEL_APPEAR", 1);
        TRACK_LOST = new Track2DStateMessage("TRACK_LOST", 2);
        TRACK_FOUND = new Track2DStateMessage("TRACK_FOUND", 3);
        TRACK_DISTANCE_TOO_FAR = new Track2DStateMessage("TRACK_DISTANCE_TOO_FAR", 4);
        TRACK_DISTANCE_TOO_NEAR = new Track2DStateMessage("TRACK_DISTANCE_TOO_NEAR", 5);
        TRACK_DISTANCE_NORMAL = new Track2DStateMessage("TRACK_DISTANCE_NORMAL", 6);
        Track2DStateMessage track2DStateMessage = new Track2DStateMessage("MODEL_CAN_DISAPPEARING", 7);
        MODEL_CAN_DISAPPEARING = track2DStateMessage;
        $VALUES = new Track2DStateMessage[]{MODEL_LOADED, TRACK_MODEL_APPEAR, TRACK_LOST, TRACK_FOUND, TRACK_DISTANCE_TOO_FAR, TRACK_DISTANCE_TOO_NEAR, TRACK_DISTANCE_NORMAL, track2DStateMessage};
    }

    public Track2DStateMessage(String str, int i) {
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

    public static Track2DStateMessage valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Track2DStateMessage) Enum.valueOf(Track2DStateMessage.class, str) : (Track2DStateMessage) invokeL.objValue;
    }

    public static Track2DStateMessage[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Track2DStateMessage[]) $VALUES.clone() : (Track2DStateMessage[]) invokeV.objValue;
    }
}
