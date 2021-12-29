package c.a.r0.q.g.c;

import android.net.Uri;
import c.a.r0.q.i.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Class<?>, b> a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f11732b;

    public c() {
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
        c();
    }

    public <T> b<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.a.get(cls) : (b) invokeL.objValue;
    }

    public <T> Uri b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? this.f11732b.get(cls) : (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = new ConcurrentHashMap<>();
            this.f11732b = new ConcurrentHashMap<>();
            this.a.put(c.a.r0.q.i.g.class, new f());
            this.a.put(c.a.r0.q.i.h.class, new g());
            this.a.put(c.a.r0.q.i.e.class, new e());
            this.a.put(c.a.r0.q.i.c.class, new d());
            this.a.put(PMSAppInfo.class, new a());
            this.a.put(c.a.r0.q.i.i.class, new h());
            this.a.put(j.class, new i());
            this.f11732b.put(c.a.r0.q.i.g.class, c.a.r0.q.g.e.b.f11741f);
            this.f11732b.put(c.a.r0.q.i.h.class, c.a.r0.q.g.e.b.f11742g);
            this.f11732b.put(c.a.r0.q.i.e.class, c.a.r0.q.g.e.b.f11739d);
            this.f11732b.put(c.a.r0.q.i.c.class, c.a.r0.q.g.e.b.f11743h);
            this.f11732b.put(PMSAppInfo.class, c.a.r0.q.g.e.b.f11740e);
            this.f11732b.put(c.a.r0.q.i.i.class, c.a.r0.q.g.e.b.f11744i);
            this.f11732b.put(j.class, c.a.r0.q.g.e.b.f11745j);
        }
    }
}
