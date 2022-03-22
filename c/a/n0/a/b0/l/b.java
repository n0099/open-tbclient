package c.a.n0.a.b0.l;

import android.annotation.SuppressLint;
import android.util.Log;
import c.a.n0.a.f.d.p0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes.dex */
public class b implements V8Engine.V8EngineConsole {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.b0.a a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3891b;

    public b(c.a.n0.a.b0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3891b = true;
        this.a = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f3891b) {
                Log.d("V8Console", this.a.o0() + str);
            }
            c.a.n0.a.s0.b.h().e(2, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            c.a.n0.a.s0.b.h().e(4, str);
            Log.e("V8Console", this.a.o0() + str);
            p0 p0 = c.a.n0.a.s0.a.p0();
            p0.e("V8Console", this.a.o0() + str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (this.f3891b) {
                Log.i("V8Console", this.a.o0() + str);
            }
            c.a.n0.a.s0.b.h().e(3, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.f3891b) {
                Log.v("V8Console", this.a.o0() + str);
            }
            c.a.n0.a.s0.b.h().e(1, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (this.f3891b) {
                Log.d("V8Console", this.a.o0() + str);
            }
            c.a.n0.a.s0.b.h().e(6, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            c.a.n0.a.s0.b.h().e(5, str);
            Log.w("V8Console", this.a.o0() + str);
            p0 p0 = c.a.n0.a.s0.a.p0();
            p0.w("V8Console", this.a.o0() + str);
        }
    }
}
