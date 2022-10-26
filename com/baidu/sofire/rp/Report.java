package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.k.a;
import com.baidu.sofire.k.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class Report {
    public static /* synthetic */ Interceptable $ic;
    public static Report b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public Report(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        InterceptResult invokeL;
        Report report;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (Report.class) {
                if (b == null) {
                    b = new Report(context);
                }
                report = b;
            }
            return report;
        }
        return (Report) invokeL.objValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            try {
                b.a(this.a).a(z);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            s(str, a.d());
        }
    }

    public void sr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            try {
                b a = b.a(this.a);
                a.getClass();
                Message message = new Message();
                message.what = 11;
                message.obj = str;
                a.b.a.sendMessage(message);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                a.b(this.a, str);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public void fr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                b a = b.a(this.a);
                a.getClass();
                Message message = new Message();
                message.what = 9;
                a.b.a.sendMessage(message);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                b a = b.a(this.a);
                a.getClass();
                Message message = new Message();
                message.what = 6;
                a.b.a.sendMessage(message);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4, str5) == null) {
            try {
                a.a(this.a, str, str2, str3, str4, str5);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public void s(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            try {
                a.a(this.a, str, z);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }
}
