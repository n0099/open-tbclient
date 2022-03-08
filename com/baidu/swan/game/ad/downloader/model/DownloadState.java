package com.baidu.swan.game.ad.downloader.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class DownloadState {
    public static final /* synthetic */ DownloadState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DownloadState DELETED;
    public static final DownloadState DOWNLOADED;
    public static final DownloadState DOWNLOADING;
    public static final DownloadState DOWNLOAD_FAILED;
    public static final DownloadState DOWNLOAD_PAUSED;
    public static final DownloadState INSTALLED;
    public static final DownloadState NOT_START;
    public static final DownloadState PREPARE_DOWNLOAD;
    public static final DownloadState WAIT;
    public transient /* synthetic */ FieldHolder $fh;
    public int state;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1138545587, "Lcom/baidu/swan/game/ad/downloader/model/DownloadState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1138545587, "Lcom/baidu/swan/game/ad/downloader/model/DownloadState;");
                return;
            }
        }
        NOT_START = new DownloadState("NOT_START", 0, 0);
        DOWNLOADING = new DownloadState("DOWNLOADING", 1, 1);
        DOWNLOAD_PAUSED = new DownloadState("DOWNLOAD_PAUSED", 2, 2);
        DOWNLOADED = new DownloadState("DOWNLOADED", 3, 3);
        DOWNLOAD_FAILED = new DownloadState("DOWNLOAD_FAILED", 4, 4);
        INSTALLED = new DownloadState("INSTALLED", 5, 5);
        DELETED = new DownloadState("DELETED", 6, 6);
        PREPARE_DOWNLOAD = new DownloadState("PREPARE_DOWNLOAD", 7, 7);
        DownloadState downloadState = new DownloadState("WAIT", 8, 8);
        WAIT = downloadState;
        $VALUES = new DownloadState[]{NOT_START, DOWNLOADING, DOWNLOAD_PAUSED, DOWNLOADED, DOWNLOAD_FAILED, INSTALLED, DELETED, PREPARE_DOWNLOAD, downloadState};
    }

    public DownloadState(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.state = i3;
    }

    public static DownloadState convert(int i2) {
        InterceptResult invokeI;
        DownloadState[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            DownloadState downloadState = NOT_START;
            for (DownloadState downloadState2 : values()) {
                if (downloadState2.state == i2) {
                    downloadState = downloadState2;
                }
            }
            return downloadState;
        }
        return (DownloadState) invokeI.objValue;
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

    public int value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.state : invokeV.intValue;
    }
}
