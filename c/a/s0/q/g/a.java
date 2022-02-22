package c.a.s0.q.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import c.a.s0.q.i.c;
import c.a.s0.q.i.e;
import c.a.s0.q.i.f;
import c.a.s0.q.i.g;
import c.a.s0.q.i.h;
import c.a.s0.q.i.i;
import c.a.s0.q.i.j;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a a;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new b();
                    }
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    public abstract boolean a(g gVar, PMSAppInfo pMSAppInfo);

    public abstract boolean b(g gVar, List<h> list, e eVar, c cVar, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends f> boolean e(Class<T> cls, String str);

    public abstract boolean f(i iVar);

    public abstract boolean g(List<i> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<h> k(@NonNull String str, int i2);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends f> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends f> T o(Class<T> cls, String str);

    public abstract Map<String, g> p();

    public abstract i q(String str, long j2, long j3);

    public abstract List<i> r(String str, String[] strArr);

    public abstract List<i> s(String str, long j2, long j3);

    @Nullable
    public abstract j t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<i> w(String str);

    public abstract boolean x(i iVar);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i2);
}
