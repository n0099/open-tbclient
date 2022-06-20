package com.baidu.searchbox.logsystem.logsys;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class LogType {
    public static final /* synthetic */ LogType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LogType JAVA_CRASH;
    public static final LogType NATIVE_CRASH;
    public static final LogType NONE;
    public transient /* synthetic */ FieldHolder $fh;
    public String mTypeName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1388955757, "Lcom/baidu/searchbox/logsystem/logsys/LogType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1388955757, "Lcom/baidu/searchbox/logsystem/logsys/LogType;");
                return;
            }
        }
        JAVA_CRASH = new LogType("JAVA_CRASH", 0, "$JAVA_CRASH$");
        NATIVE_CRASH = new LogType("NATIVE_CRASH", 1, "$NATIVE_CRASH$");
        LogType logType = new LogType(HlsPlaylistParser.METHOD_NONE, 2, "$NONE$");
        NONE = logType;
        $VALUES = new LogType[]{JAVA_CRASH, NATIVE_CRASH, logType};
    }

    public LogType(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTypeName = str2;
    }

    public static LogType getLogType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (JAVA_CRASH.getTypeName().equals(str)) {
                return JAVA_CRASH;
            }
            if (NATIVE_CRASH.getTypeName().equals(str)) {
                return NATIVE_CRASH;
            }
            if (NONE.getTypeName().equals(str)) {
                return NONE;
            }
            return null;
        }
        return (LogType) invokeL.objValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
        }
    }

    public static LogType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (LogType) Enum.valueOf(LogType.class, str) : (LogType) invokeL.objValue;
    }

    public static LogType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (LogType[]) $VALUES.clone() : (LogType[]) invokeV.objValue;
    }

    public String getTypeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mTypeName : (String) invokeV.objValue;
    }
}
