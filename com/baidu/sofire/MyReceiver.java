package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.a.b;
import com.baidu.sofire.a.f;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.k.p;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class MyReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public long b;
    public long c;

    /* loaded from: classes2.dex */
    public class a extends Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(MyReceiver myReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myReceiver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.sofire.ac.Callback
        public Object onEnd(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                return super.onEnd(objArr);
            }
            return invokeL.objValue;
        }
    }

    public MyReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        new a(this);
        this.a = false;
        this.b = 0L;
        this.c = 0L;
    }

    public MyReceiver a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.b = System.currentTimeMillis();
                this.a = true;
            } catch (Throwable unused) {
                int i = b.a;
            }
            return this;
        }
        return (MyReceiver) invokeV.objValue;
    }

    public static void a(ClassLoader classLoader, Intent intent, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, classLoader, intent, context) == null) {
            try {
                Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
                loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent) != null) || intent == null) {
            return;
        }
        try {
            if (this.a && System.currentTimeMillis() - this.b < 2000) {
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (System.currentTimeMillis() - this.c >= 100 && com.baidu.sofire.k.a.l(context)) {
                    this.c = System.currentTimeMillis();
                } else {
                    return;
                }
            }
            Context applicationContext = context.getApplicationContext();
            p.a(applicationContext).a(new f(intent, applicationContext, this.a));
        } catch (Throwable unused) {
            int i = b.a;
        }
    }
}
