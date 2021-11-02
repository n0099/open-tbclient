package b.a.k0.a;

import b.a.k0.a.d.c;
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
    public boolean f3200c;

    /* renamed from: d  reason: collision with root package name */
    public long f3201d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f3202e;

    /* renamed from: f  reason: collision with root package name */
    public int f3203f;

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
        this.f3200c = false;
    }

    @Override // b.a.k0.a.d.c
    public synchronized void a(int i2, V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, v8ExceptionInfo) == null) {
            synchronized (this) {
                if (this.f3202e == null && v8ExceptionInfo != null) {
                    this.f3202e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
                    this.f3203f = i2;
                    if (this.f3214b != null) {
                        this.f3214b.a();
                    }
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f3202e = null;
            this.f3201d = 0L;
            this.f3203f = -1;
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f3200c) {
                    return;
                }
                if (this.f3214b != null && this.f3201d > 0 && this.f3202e != null) {
                    if (System.currentTimeMillis() - this.f3202e.exceptionTime > this.f3213a && this.f3202e.exceptionTime > this.f3201d) {
                        this.f3214b.b(new b.a.k0.a.d.b(this.f3203f, this.f3202e, this.f3201d));
                        d();
                    }
                }
            }
        }
    }

    public synchronized void f(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (this) {
                this.f3200c = z;
                if (z) {
                    this.f3201d = j;
                    this.f3202e = null;
                }
            }
        }
    }
}
