package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.i.a.b;
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

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3474a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f3475b;

    /* renamed from: c  reason: collision with root package name */
    public a f3476c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3477d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f3478e;

    /* renamed from: f  reason: collision with root package name */
    public String f3479f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f3480g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676870177, "Lcom/baidu/android/pushservice/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676870177, "Lcom/baidu/android/pushservice/j/c;");
                return;
            }
        }
        f3474a = new Object();
    }

    public c(Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, intent, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3475b = System.currentTimeMillis();
        this.f3477d = context;
        this.f3478e = intent;
        this.f3479f = str;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3475b : invokeV.longValue;
    }

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            a aVar = this.f3476c;
            if (aVar != null) {
                aVar.a(0, intent);
            }
            this.f3480g = intent;
            synchronized (f3474a) {
                f3474a.notifyAll();
            }
        }
    }

    public com.baidu.android.pushservice.message.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f3478e.putExtra("bd.cross.request.ID", this.f3475b);
            this.f3478e.putExtra("bd.cross.request.NEED_CALLBACK", true);
            this.f3478e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.f3477d.getPackageName());
            this.f3478e.putExtra("bd.cross.request.SENDING", true);
            b.a(this);
            try {
                m.a(this.f3477d, this.f3478e, this.f3479f);
            } catch (Exception unused) {
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, "timeOutRunnable-" + this.f3475b, (short) 50) { // from class: com.baidu.android.pushservice.j.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f3481a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Short.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f3481a = this;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Thread.sleep(1000L);
                            synchronized (c.f3474a) {
                                c.f3474a.notifyAll();
                            }
                        } catch (InterruptedException e2) {
                            new b.c(this.f3481a.f3477d).a(Log.getStackTraceString(e2)).a();
                        }
                    }
                }
            });
            if (this.f3476c == null) {
                synchronized (f3474a) {
                    try {
                        f3474a.wait();
                    } catch (Exception e2) {
                        new b.c(this.f3477d).a(Log.getStackTraceString(e2)).a();
                    }
                }
                c();
                Intent intent = this.f3480g;
                if (intent != null) {
                    gVar.a(intent.getIntExtra("bd.cross.request.RESULT_CODE", 10));
                    if (this.f3480g.hasExtra("bd.cross.request.RESULT_DATA")) {
                        String stringExtra = this.f3480g.getStringExtra("bd.cross.request.RESULT_DATA");
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
                this.f3476c = null;
                this.f3477d = null;
                b.a(this.f3475b);
            }
        }
    }
}
