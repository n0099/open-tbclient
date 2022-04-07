package com.baidu.android.pushservice.i;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public transient /* synthetic */ FieldHolder $fh;
    public long b;
    public a c;
    public Context d;
    public Intent e;
    public String f;
    public Intent g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676899968, "Lcom/baidu/android/pushservice/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676899968, "Lcom/baidu/android/pushservice/i/c;");
                return;
            }
        }
        a = new Object();
    }

    public c(Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, intent, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = System.currentTimeMillis();
        this.d = context;
        this.e = intent;
        this.f = str;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.longValue;
    }

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(0, intent);
            }
            this.g = intent;
            synchronized (a) {
                a.notifyAll();
            }
        }
    }

    public com.baidu.android.pushservice.message.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.e.putExtra("bd.cross.request.ID", this.b);
            this.e.putExtra("bd.cross.request.NEED_CALLBACK", true);
            this.e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.d.getPackageName());
            this.e.putExtra("bd.cross.request.SENDING", true);
            b.a(this);
            try {
                m.a(this.d, this.e, this.f);
            } catch (Exception unused) {
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            com.baidu.android.pushservice.g.e.a().a(new com.baidu.android.pushservice.g.c(this, "timeOutRunnable-" + this.b, (short) 50) { // from class: com.baidu.android.pushservice.i.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Short.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Thread.sleep(1000L);
                            synchronized (c.a) {
                                c.a.notifyAll();
                            }
                        } catch (InterruptedException e) {
                            new b.c(this.a.d).a(Log.getStackTraceString(e)).a();
                        }
                    }
                }
            });
            if (this.c == null) {
                synchronized (a) {
                    try {
                        a.wait();
                    } catch (Exception e) {
                        new b.c(this.d).a(Log.getStackTraceString(e)).a();
                    }
                }
                c();
                Intent intent = this.g;
                if (intent != null) {
                    gVar.a(intent.getIntExtra("bd.cross.request.RESULT_CODE", 10));
                    if (this.g.hasExtra("bd.cross.request.RESULT_DATA")) {
                        String stringExtra = this.g.getStringExtra("bd.cross.request.RESULT_DATA");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            gVar.a(stringExtra.getBytes());
                        }
                    }
                } else {
                    gVar.a(11);
                }
            }
            return gVar;
        }
        return (com.baidu.android.pushservice.message.g) invokeV.objValue;
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.c = null;
                this.d = null;
                b.a(this.b);
            }
        }
    }
}
