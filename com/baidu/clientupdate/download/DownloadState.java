package com.baidu.clientupdate.download;

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
/* loaded from: classes3.dex */
public final class DownloadState {
    public static final /* synthetic */ DownloadState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DownloadState CANCEL;
    public static final DownloadState DOWNLOADING;
    public static final DownloadState FAILED;
    public static final DownloadState FINISH;
    public static final DownloadState MEAGEEND;
    public static final DownloadState MEAGESTART;
    public static final DownloadState PAUSE;
    public static final DownloadState UNKNOWN;
    public static final DownloadState WAITING;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1917115468, "Lcom/baidu/clientupdate/download/DownloadState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1917115468, "Lcom/baidu/clientupdate/download/DownloadState;");
                return;
            }
        }
        WAITING = new DownloadState("WAITING", 0);
        DOWNLOADING = new DownloadState(AdDownloadApkUtils.DL_STATUS_DOWNLOADING, 1);
        PAUSE = new DownloadState(XDeviceInfo.ABILITY_PAUSE, 2);
        FAILED = new DownloadState("FAILED", 3);
        CANCEL = new DownloadState("CANCEL", 4);
        FINISH = new DownloadState("FINISH", 5);
        UNKNOWN = new DownloadState(RomUtils.UNKNOWN, 6);
        MEAGESTART = new DownloadState("MEAGESTART", 7);
        DownloadState downloadState = new DownloadState("MEAGEEND", 8);
        MEAGEEND = downloadState;
        $VALUES = new DownloadState[]{WAITING, DOWNLOADING, PAUSE, FAILED, CANCEL, FINISH, UNKNOWN, MEAGESTART, downloadState};
    }

    public DownloadState(String str, int i2) {
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

    public static DownloadState getState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 0 ? WAITING : i2 == 1 ? DOWNLOADING : i2 == 2 ? PAUSE : i2 == 3 ? FAILED : i2 == 4 ? CANCEL : i2 == 5 ? FINISH : i2 == 6 ? UNKNOWN : i2 == 7 ? MEAGESTART : i2 == 8 ? MEAGEEND : UNKNOWN : (DownloadState) invokeI.objValue;
    }

    public static DownloadState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (DownloadState) Enum.valueOf(DownloadState.class, str) : (DownloadState) invokeL.objValue;
    }

    public static DownloadState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (DownloadState[]) $VALUES.clone() : (DownloadState[]) invokeV.objValue;
    }
}
