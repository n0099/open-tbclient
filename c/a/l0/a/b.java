package c.a.l0.a;

import c.a.l0.a.d.c;
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
    public boolean f4117c;

    /* renamed from: d  reason: collision with root package name */
    public long f4118d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f4119e;

    /* renamed from: f  reason: collision with root package name */
    public int f4120f;

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
        this.f4117c = false;
    }

    @Override // c.a.l0.a.d.c
    public synchronized void a(int i2, V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, v8ExceptionInfo) == null) {
            synchronized (this) {
                if (this.f4119e == null && v8ExceptionInfo != null) {
                    this.f4119e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
                    this.f4120f = i2;
                    if (this.f4128b != null) {
                        this.f4128b.a();
                    }
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f4119e = null;
            this.f4118d = 0L;
            this.f4120f = -1;
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f4117c) {
                    return;
                }
                if (this.f4128b != null && this.f4118d > 0 && this.f4119e != null) {
                    if (System.currentTimeMillis() - this.f4119e.exceptionTime > this.a && this.f4119e.exceptionTime > this.f4118d) {
                        this.f4128b.b(new c.a.l0.a.d.b(this.f4120f, this.f4119e, this.f4118d));
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
                this.f4117c = z;
                if (z) {
                    this.f4118d = j2;
                    this.f4119e = null;
                }
            }
        }
    }
}
