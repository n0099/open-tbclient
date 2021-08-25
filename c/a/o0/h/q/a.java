package c.a.o0.h.q;

import c.a.o0.a.k;
import c.a.o0.h.f0.h;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements DebugConsole {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11485b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f11486a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(649073447, "Lc/a/o0/h/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(649073447, "Lc/a/o0/h/q/a;");
                return;
            }
        }
        f11485b = k.f7049a;
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

    @Override // com.baidu.searchbox.v8engine.console.DebugConsole
    public void onReceiveInfo(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) && f11485b && !h.d()) {
            if (i2 == 0) {
                String.format("%s: %s %s", "queue event", "", str);
            } else if (i2 == 1) {
                this.f11486a = System.currentTimeMillis();
                String.format("%s: %s %s", "run event start", "", str);
            } else if (i2 != 2) {
            } else {
                String.format("%s: %s %s", "run event end", Long.valueOf(System.currentTimeMillis() - this.f11486a), str);
            }
        }
    }
}
