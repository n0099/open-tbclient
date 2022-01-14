package com.baidu.browser.core.async;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class AsyncTask$Status {
    public static final /* synthetic */ AsyncTask$Status[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AsyncTask$Status FINISHED;
    public static final AsyncTask$Status PENDING;
    public static final AsyncTask$Status RUNNING;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1905024280, "Lcom/baidu/browser/core/async/AsyncTask$Status;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1905024280, "Lcom/baidu/browser/core/async/AsyncTask$Status;");
                return;
            }
        }
        PENDING = new AsyncTask$Status("PENDING", 0);
        RUNNING = new AsyncTask$Status(TornadoLiteRuntime.STATE_RUNNING, 1);
        AsyncTask$Status asyncTask$Status = new AsyncTask$Status("FINISHED", 2);
        FINISHED = asyncTask$Status;
        $VALUES = new AsyncTask$Status[]{PENDING, RUNNING, asyncTask$Status};
    }

    public AsyncTask$Status(String str, int i2) {
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

    public static AsyncTask$Status valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AsyncTask$Status) Enum.valueOf(AsyncTask$Status.class, str) : (AsyncTask$Status) invokeL.objValue;
    }

    public static AsyncTask$Status[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AsyncTask$Status[]) $VALUES.clone() : (AsyncTask$Status[]) invokeV.objValue;
    }
}
