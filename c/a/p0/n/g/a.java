package c.a.p0.n.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import c.a.p0.n.h.d;
import c.a.p0.n.h.e;
import c.a.p0.n.h.f;
import c.a.p0.n.h.g;
import c.a.p0.n.h.h;
import c.a.p0.n.h.i;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f11857a;
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

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f11857a == null) {
                synchronized (a.class) {
                    if (f11857a == null) {
                        f11857a = new b();
                    }
                }
            }
            return f11857a;
        }
        return (a) invokeV.objValue;
    }

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean b(f fVar, List<g> list, d dVar, c.a.p0.n.h.b bVar, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends e> boolean e(Class<T> cls, String str);

    public abstract boolean f(h hVar);

    public abstract boolean g(String str);

    @WorkerThread
    public abstract int i(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<g> j(@NonNull String str, int i2);

    public abstract boolean k(PMSAppInfo pMSAppInfo);

    public abstract <T extends e> boolean l(T t);

    public abstract boolean m(String str, String str2, String str3);

    public abstract List<h> n(int i2);

    public abstract <T extends e> T o(Class<T> cls, String str);

    public abstract Map<String, f> p();

    public abstract List<h> q(String str, String[] strArr);

    @Nullable
    public abstract i r(String str);

    public abstract PMSAppInfo s(String str);

    public abstract Map<String, PMSAppInfo> t();

    public abstract List<h> u(String str);

    public abstract boolean v(h hVar);

    public abstract boolean w(PMSAppInfo pMSAppInfo);

    public abstract boolean x(String str, int i2);
}
