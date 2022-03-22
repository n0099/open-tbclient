package c.a.j0.a;

import android.util.Log;
import c.a.j0.a.d.c;
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
    public boolean f3330c;

    /* renamed from: d  reason: collision with root package name */
    public long f3331d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f3332e;

    /* renamed from: f  reason: collision with root package name */
    public int f3333f;

    public b() {
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
        this.f3330c = false;
    }

    @Override // c.a.j0.a.d.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, v8ExceptionInfo) == null) {
            synchronized (this) {
                if (this.f3332e == null && v8ExceptionInfo != null) {
                    this.f3332e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
                    this.f3333f = i;
                    if (this.f3341b != null) {
                        this.f3341b.a();
                    }
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f3332e = null;
            this.f3331d = 0L;
            this.f3333f = -1;
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f3330c) {
                    return;
                }
                if (this.f3341b != null && this.f3331d > 0 && this.f3332e != null) {
                    if (System.currentTimeMillis() - this.f3332e.exceptionTime > this.a && this.f3332e.exceptionTime > this.f3331d) {
                        this.f3341b.b(new c.a.j0.a.d.b(this.f3333f, this.f3332e, this.f3331d));
                        d();
                    }
                    return;
                }
                Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            }
        }
    }

    public synchronized void f(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (this) {
                this.f3330c = z;
                if (z) {
                    this.f3331d = j;
                    this.f3332e = null;
                }
            }
        }
    }
}
