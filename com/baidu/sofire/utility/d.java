package com.baidu.sofire.utility;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static d f38550c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.sofire.g.a f38551b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1443542487, "Lcom/baidu/sofire/utility/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1443542487, "Lcom/baidu/sofire/utility/d;");
        }
    }

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        this.f38551b = new com.baidu.sofire.g.a(context);
    }

    public static synchronized d a(Context context) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (d.class) {
                if (f38550c == null) {
                    f38550c = new d(context);
                }
                dVar = f38550c;
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.baidu.sofire.g.a aVar = this.f38551b;
            Message message = new Message();
            message.what = 7;
            aVar.a(message);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Message message = new Message();
            message.what = 2;
            this.f38551b.a(message);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.sofire.g.a aVar = this.f38551b;
            if (aVar.f38471c == null) {
                aVar.f38471c = new Receiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.b.r.p");
            aVar.f38470b.getApplicationContext().registerReceiver(aVar.f38471c, intentFilter, aVar.f38470b.getPackageName() + ".permission.sofire.RECEIVE", null);
            Message message = new Message();
            message.what = 5;
            aVar.a(message);
        }
    }
}
