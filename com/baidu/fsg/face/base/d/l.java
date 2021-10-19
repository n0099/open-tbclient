package com.baidu.fsg.face.base.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class l implements c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39946a = "ThreadPoolService";

    /* renamed from: d  reason: collision with root package name */
    public static final int f39947d = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f39948b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f39949c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f39950e;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static l f39952a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1157686924, "Lcom/baidu/fsg/face/base/d/l$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1157686924, "Lcom/baidu/fsg/face/base/d/l$a;");
                    return;
                }
            }
            f39952a = new l();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public static l a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f39952a : (l) invokeV.objValue;
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
            d.a(f39946a, "runInUiThread()", kVar.f39944a);
            this.f39950e.sendMessage(this.f39950e.obtainMessage(0, kVar));
        }
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void c(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            d.a(f39946a, "runImport()", kVar.f39944a);
            this.f39948b.submit(kVar);
        }
    }

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39950e = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.fsg.face.base.d.l.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f39951a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f39951a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Runnable runnable;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 0 && (runnable = ((k) message.obj).f39945b) != null) {
                    runnable.run();
                }
            }
        };
        this.f39949c = Executors.newScheduledThreadPool(6);
        this.f39948b = Executors.newScheduledThreadPool(3);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f39949c.submit(kVar);
        }
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar, j2) == null) {
            d.a(f39946a, "runDelay()", kVar.f39944a, Long.valueOf(j2));
            this.f39949c.submit(kVar, Long.valueOf(j2));
        }
    }

    public void c(k kVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, kVar, j2) == null) {
            d.a(f39946a, "runDelayImport()", kVar.f39944a, Long.valueOf(j2));
            this.f39948b.submit(kVar, Long.valueOf(j2));
        }
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, kVar, j2) == null) {
            d.a(f39946a, "runInUiThreadDelay()", kVar.f39944a, Long.valueOf(j2));
            this.f39950e.sendMessageDelayed(this.f39950e.obtainMessage(0, kVar), j2);
        }
    }
}
