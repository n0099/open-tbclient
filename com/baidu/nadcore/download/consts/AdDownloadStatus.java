package com.baidu.nadcore.download.consts;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class AdDownloadStatus {
    public static final /* synthetic */ AdDownloadStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AdDownloadStatus COMPLETED;
    public static final AdDownloadStatus DOWNLOADING;
    public static final AdDownloadStatus FAILED;
    public static final AdDownloadStatus INSTALLED;
    public static final AdDownloadStatus NONE;
    public static final AdDownloadStatus PAUSE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int status;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-628459143, "Lcom/baidu/nadcore/download/consts/AdDownloadStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-628459143, "Lcom/baidu/nadcore/download/consts/AdDownloadStatus;");
                return;
            }
        }
        NONE = new AdDownloadStatus("NONE", 0, 0);
        DOWNLOADING = new AdDownloadStatus("DOWNLOADING", 1, 1);
        PAUSE = new AdDownloadStatus("PAUSE", 2, 2);
        COMPLETED = new AdDownloadStatus("COMPLETED", 3, 3);
        INSTALLED = new AdDownloadStatus("INSTALLED", 4, 4);
        AdDownloadStatus adDownloadStatus = new AdDownloadStatus("FAILED", 5, 5);
        FAILED = adDownloadStatus;
        $VALUES = new AdDownloadStatus[]{NONE, DOWNLOADING, PAUSE, COMPLETED, INSTALLED, adDownloadStatus};
    }

    public AdDownloadStatus(String str, int i2, int i3) {
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
        this.status = i3;
    }

    public static AdDownloadStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AdDownloadStatus) Enum.valueOf(AdDownloadStatus.class, str) : (AdDownloadStatus) invokeL.objValue;
    }

    public static AdDownloadStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AdDownloadStatus[]) $VALUES.clone() : (AdDownloadStatus[]) invokeV.objValue;
    }
}
