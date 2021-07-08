package com.baidu.swan.apps.media.audio.service;

import com.baidu.mobads.container.info.XDeviceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class BgMusicPlayState {
    public static final /* synthetic */ BgMusicPlayState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BgMusicPlayState END;
    public static final BgMusicPlayState INTERRUPT;
    public static final BgMusicPlayState LOADING;
    public static final BgMusicPlayState PAUSE;
    public static final BgMusicPlayState PLAY;
    public static final BgMusicPlayState READY;
    public static final BgMusicPlayState REPLAY;
    public static final BgMusicPlayState STOP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(377812883, "Lcom/baidu/swan/apps/media/audio/service/BgMusicPlayState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(377812883, "Lcom/baidu/swan/apps/media/audio/service/BgMusicPlayState;");
                return;
            }
        }
        PLAY = new BgMusicPlayState("PLAY", 0);
        REPLAY = new BgMusicPlayState("REPLAY", 1);
        PAUSE = new BgMusicPlayState(XDeviceInfo.ABILITY_PAUSE, 2);
        STOP = new BgMusicPlayState("STOP", 3);
        INTERRUPT = new BgMusicPlayState("INTERRUPT", 4);
        LOADING = new BgMusicPlayState("LOADING", 5);
        READY = new BgMusicPlayState("READY", 6);
        BgMusicPlayState bgMusicPlayState = new BgMusicPlayState("END", 7);
        END = bgMusicPlayState;
        $VALUES = new BgMusicPlayState[]{PLAY, REPLAY, PAUSE, STOP, INTERRUPT, LOADING, READY, bgMusicPlayState};
    }

    public BgMusicPlayState(String str, int i2) {
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

    public static BgMusicPlayState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BgMusicPlayState) Enum.valueOf(BgMusicPlayState.class, str) : (BgMusicPlayState) invokeL.objValue;
    }

    public static BgMusicPlayState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BgMusicPlayState[]) $VALUES.clone() : (BgMusicPlayState[]) invokeV.objValue;
    }
}
