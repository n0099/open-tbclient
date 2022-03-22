package com.baidu.clientupdate.download;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
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
        DOWNLOADING = new DownloadState("DOWNLOADING", 1);
        PAUSE = new DownloadState("PAUSE", 2);
        FAILED = new DownloadState("FAILED", 3);
        CANCEL = new DownloadState("CANCEL", 4);
        FINISH = new DownloadState("FINISH", 5);
        UNKNOWN = new DownloadState(RomUtils.UNKNOWN, 6);
        MEAGESTART = new DownloadState("MEAGESTART", 7);
        DownloadState downloadState = new DownloadState("MEAGEEND", 8);
        MEAGEEND = downloadState;
        $VALUES = new DownloadState[]{WAITING, DOWNLOADING, PAUSE, FAILED, CANCEL, FINISH, UNKNOWN, MEAGESTART, downloadState};
    }

    public DownloadState(String str, int i) {
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

    public static DownloadState getState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 0 ? WAITING : i == 1 ? DOWNLOADING : i == 2 ? PAUSE : i == 3 ? FAILED : i == 4 ? CANCEL : i == 5 ? FINISH : i == 6 ? UNKNOWN : i == 7 ? MEAGESTART : i == 8 ? MEAGEEND : UNKNOWN : (DownloadState) invokeI.objValue;
    }

    public static DownloadState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (DownloadState) Enum.valueOf(DownloadState.class, str) : (DownloadState) invokeL.objValue;
    }

    public static DownloadState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (DownloadState[]) $VALUES.clone() : (DownloadState[]) invokeV.objValue;
    }
}
