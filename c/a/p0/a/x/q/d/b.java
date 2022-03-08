package c.a.p0.a.x.q.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8823c;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.a.x.q.c.a a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8824b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1894780432, "Lc/a/p0/a/x/q/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1894780432, "Lc/a/p0/a/x/q/d/b;");
                return;
            }
        }
        f8823c = c.a.p0.a.a.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new c.a.p0.a.x.q.c.c();
        this.f8824b = 30;
    }

    @Override // c.a.p0.a.x.q.d.c
    public c.a.p0.a.x.q.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (c.a.p0.a.x.q.c.a) invokeV.objValue;
    }

    @Override // c.a.p0.a.x.q.d.c
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.q.d.c
    public boolean c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3)) == null) {
            if (f8823c) {
                String str4 = "prefetchId - " + str;
                String str5 = "appId - " + str2;
                String str6 = "url - " + str3;
            }
            c.a.p0.a.x.q.c.b a = this.a.a(str2, str3);
            if (a == null) {
                boolean z = f8823c;
                return true;
            } else if (!TextUtils.isEmpty(str)) {
                boolean z2 = f8823c;
                return false;
            } else {
                String curProcessName = ProcessUtils.getCurProcessName();
                if (!TextUtils.equals(curProcessName, a.a)) {
                    if (f8823c) {
                        String str7 = "process not match, current - " + curProcessName + ", record - " + a.a;
                    }
                    return true;
                }
                boolean z3 = System.currentTimeMillis() - a.f8820b >= ((long) (this.f8824b * 1000));
                if (f8823c) {
                    String str8 = "url in recorder, time is out - " + z3;
                }
                return z3;
            }
        }
        return invokeLLL.booleanValue;
    }
}
