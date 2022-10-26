package com.baidu.nadcore.download.consts;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class AdDownloadCode {
    public static final /* synthetic */ AdDownloadCode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AdDownloadCode ERROR_CONNECT_TIMEOUT;
    public static final AdDownloadCode ERROR_FAST_CLICK;
    public static final AdDownloadCode ERROR_INVALID_DATA;
    public static final AdDownloadCode ERROR_OTHERS;
    public static final AdDownloadCode ERROR_START_FAIL;
    public static final AdDownloadCode SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;
    public int code;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-449095970, "Lcom/baidu/nadcore/download/consts/AdDownloadCode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-449095970, "Lcom/baidu/nadcore/download/consts/AdDownloadCode;");
                return;
            }
        }
        SUCCESS = new AdDownloadCode("SUCCESS", 0, 0);
        ERROR_START_FAIL = new AdDownloadCode("ERROR_START_FAIL", 1, 1);
        ERROR_CONNECT_TIMEOUT = new AdDownloadCode("ERROR_CONNECT_TIMEOUT", 2, 2);
        ERROR_FAST_CLICK = new AdDownloadCode("ERROR_FAST_CLICK", 3, 3);
        ERROR_INVALID_DATA = new AdDownloadCode("ERROR_INVALID_DATA", 4, 4);
        AdDownloadCode adDownloadCode = new AdDownloadCode("ERROR_OTHERS", 5, 5);
        ERROR_OTHERS = adDownloadCode;
        $VALUES = new AdDownloadCode[]{SUCCESS, ERROR_START_FAIL, ERROR_CONNECT_TIMEOUT, ERROR_FAST_CLICK, ERROR_INVALID_DATA, adDownloadCode};
    }

    public AdDownloadCode(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.code = i2;
    }

    public static AdDownloadCode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (AdDownloadCode) Enum.valueOf(AdDownloadCode.class, str);
        }
        return (AdDownloadCode) invokeL.objValue;
    }

    public static AdDownloadCode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (AdDownloadCode[]) $VALUES.clone();
        }
        return (AdDownloadCode[]) invokeV.objValue;
    }
}
