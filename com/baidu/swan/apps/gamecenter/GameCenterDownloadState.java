package com.baidu.swan.apps.gamecenter;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.info.XDeviceInfo;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class GameCenterDownloadState {
    public static final /* synthetic */ GameCenterDownloadState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final GameCenterDownloadState CANCEL;
    public static final GameCenterDownloadState DOWNLOADING;
    public static final GameCenterDownloadState FAILED;
    public static final GameCenterDownloadState FINISH;
    public static final GameCenterDownloadState PAUSE;
    public static final GameCenterDownloadState UNKNOWN;
    public static final GameCenterDownloadState WAITING;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(564736756, "Lcom/baidu/swan/apps/gamecenter/GameCenterDownloadState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(564736756, "Lcom/baidu/swan/apps/gamecenter/GameCenterDownloadState;");
                return;
            }
        }
        WAITING = new GameCenterDownloadState("WAITING", 0);
        DOWNLOADING = new GameCenterDownloadState(AdDownloadApkUtils.DL_STATUS_DOWNLOADING, 1);
        PAUSE = new GameCenterDownloadState(XDeviceInfo.ABILITY_PAUSE, 2);
        FAILED = new GameCenterDownloadState("FAILED", 3);
        CANCEL = new GameCenterDownloadState("CANCEL", 4);
        FINISH = new GameCenterDownloadState("FINISH", 5);
        GameCenterDownloadState gameCenterDownloadState = new GameCenterDownloadState(RomUtils.UNKNOWN, 6);
        UNKNOWN = gameCenterDownloadState;
        $VALUES = new GameCenterDownloadState[]{WAITING, DOWNLOADING, PAUSE, FAILED, CANCEL, FINISH, gameCenterDownloadState};
    }

    public GameCenterDownloadState(String str, int i2) {
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

    public static GameCenterDownloadState getState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                return UNKNOWN;
                            }
                            return FAILED;
                        }
                        return FINISH;
                    }
                    return PAUSE;
                }
                return DOWNLOADING;
            }
            return WAITING;
        }
        return (GameCenterDownloadState) invokeI.objValue;
    }

    public static GameCenterDownloadState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (GameCenterDownloadState) Enum.valueOf(GameCenterDownloadState.class, str) : (GameCenterDownloadState) invokeL.objValue;
    }

    public static GameCenterDownloadState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (GameCenterDownloadState[]) $VALUES.clone() : (GameCenterDownloadState[]) invokeV.objValue;
    }
}
