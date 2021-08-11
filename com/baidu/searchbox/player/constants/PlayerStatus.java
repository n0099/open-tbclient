package com.baidu.searchbox.player.constants;

import com.baidu.mobads.container.info.XDeviceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class PlayerStatus {
    public static final /* synthetic */ PlayerStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PlayerStatus COMPLETE;
    public static final PlayerStatus ERROR;
    public static final PlayerStatus IDLE;
    public static final PlayerStatus PAUSE;
    public static final PlayerStatus PLAYING;
    public static final PlayerStatus PREPARED;
    public static final PlayerStatus PREPARING;
    public static final PlayerStatus STOP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1559974868, "Lcom/baidu/searchbox/player/constants/PlayerStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1559974868, "Lcom/baidu/searchbox/player/constants/PlayerStatus;");
                return;
            }
        }
        IDLE = new PlayerStatus("IDLE", 0);
        PREPARING = new PlayerStatus("PREPARING", 1);
        PREPARED = new PlayerStatus("PREPARED", 2);
        PLAYING = new PlayerStatus("PLAYING", 3);
        PAUSE = new PlayerStatus(XDeviceInfo.ABILITY_PAUSE, 4);
        STOP = new PlayerStatus("STOP", 5);
        COMPLETE = new PlayerStatus("COMPLETE", 6);
        PlayerStatus playerStatus = new PlayerStatus("ERROR", 7);
        ERROR = playerStatus;
        $VALUES = new PlayerStatus[]{IDLE, PREPARING, PREPARED, PLAYING, PAUSE, STOP, COMPLETE, playerStatus};
    }

    public PlayerStatus(String str, int i2) {
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

    public static PlayerStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PlayerStatus) Enum.valueOf(PlayerStatus.class, str) : (PlayerStatus) invokeL.objValue;
    }

    public static PlayerStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PlayerStatus[]) $VALUES.clone() : (PlayerStatus[]) invokeV.objValue;
    }
}
