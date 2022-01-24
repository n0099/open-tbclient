package c.a.n0.a;

import c.a.n0.a.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4630c;

    /* renamed from: d  reason: collision with root package name */
    public long f4631d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f4632e;

    /* renamed from: f  reason: collision with root package name */
    public int f4633f;

    public b() {
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
        this.f4630c = false;
    }

    @Override // c.a.n0.a.d.c
    public synchronized void a(int i2, V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, v8ExceptionInfo) == null) {
            synchronized (this) {
                if (this.f4632e == null && v8ExceptionInfo != null) {
                    this.f4632e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
                    this.f4633f = i2;
                    if (this.f4641b != null) {
                        this.f4641b.a();
                    }
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f4632e = null;
            this.f4631d = 0L;
            this.f4633f = -1;
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f4630c) {
                    return;
                }
                if (this.f4641b != null && this.f4631d > 0 && this.f4632e != null) {
                    if (System.currentTimeMillis() - this.f4632e.exceptionTime > this.a && this.f4632e.exceptionTime > this.f4631d) {
                        this.f4641b.b(new c.a.n0.a.d.b(this.f4633f, this.f4632e, this.f4631d));
                        d();
                    }
                }
            }
        }
    }

    public synchronized void f(boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                this.f4630c = z;
                if (z) {
                    this.f4631d = j2;
                    this.f4632e = null;
                }
            }
        }
    }
}
