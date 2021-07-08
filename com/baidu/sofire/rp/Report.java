package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class Report {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Report f10486a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f10487b;

    public Report(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10487b = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        InterceptResult invokeL;
        Report report;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (Report.class) {
                if (f10486a == null) {
                    f10486a = new Report(context);
                }
                report = f10486a;
            }
            return report;
        }
        return (Report) invokeL.objValue;
    }

    public void fr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                d a2 = d.a(this.f10487b);
                Message message = new Message();
                message.what = 9;
                a2.f10499b.a(message);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4, str5) == null) {
            try {
                c.a(this.f10487b, str, str2, str3, str4, str5);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                d a2 = d.a(this.f10487b);
                Message message = new Message();
                message.what = 6;
                a2.f10499b.a(message);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            try {
                d.a(this.f10487b).a();
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            s(str, c.e());
        }
    }

    public void sr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            try {
                d a2 = d.a(this.f10487b);
                Message message = new Message();
                message.what = 11;
                message.obj = str;
                a2.f10499b.a(message);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                c.a(this.f10487b, str);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public void s(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            try {
                c.a(this.f10487b, str, z);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }
}
