package com.baidu.http.engine.urlconnect.interceptor;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class LogInterceptor$Level {
    public static final /* synthetic */ LogInterceptor$Level[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LogInterceptor$Level BASIC;
    public static final LogInterceptor$Level BODY;
    public static final LogInterceptor$Level HEADERS;
    public static final LogInterceptor$Level NONE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-257822256, "Lcom/baidu/http/engine/urlconnect/interceptor/LogInterceptor$Level;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-257822256, "Lcom/baidu/http/engine/urlconnect/interceptor/LogInterceptor$Level;");
                return;
            }
        }
        NONE = new LogInterceptor$Level(HlsPlaylistParser.METHOD_NONE, 0);
        BASIC = new LogInterceptor$Level("BASIC", 1);
        HEADERS = new LogInterceptor$Level("HEADERS", 2);
        LogInterceptor$Level logInterceptor$Level = new LogInterceptor$Level("BODY", 3);
        BODY = logInterceptor$Level;
        $VALUES = new LogInterceptor$Level[]{NONE, BASIC, HEADERS, logInterceptor$Level};
    }

    public LogInterceptor$Level(String str, int i) {
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

    public static LogInterceptor$Level valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (LogInterceptor$Level) Enum.valueOf(LogInterceptor$Level.class, str);
        }
        return (LogInterceptor$Level) invokeL.objValue;
    }

    public static LogInterceptor$Level[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (LogInterceptor$Level[]) $VALUES.clone();
        }
        return (LogInterceptor$Level[]) invokeV.objValue;
    }
}
