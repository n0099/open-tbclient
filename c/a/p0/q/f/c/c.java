package c.a.p0.q.f.c;

import android.net.Uri;
import c.a.p0.q.h.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Class<?>, b> a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f10933b;

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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? this.f10933b.get(cls) : (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = new ConcurrentHashMap<>();
            this.f10933b = new ConcurrentHashMap<>();
            this.a.put(c.a.p0.q.h.g.class, new f());
            this.a.put(c.a.p0.q.h.h.class, new g());
            this.a.put(c.a.p0.q.h.e.class, new e());
            this.a.put(c.a.p0.q.h.c.class, new d());
            this.a.put(PMSAppInfo.class, new a());
            this.a.put(c.a.p0.q.h.i.class, new h());
            this.a.put(j.class, new i());
            this.f10933b.put(c.a.p0.q.h.g.class, c.a.p0.q.f.e.b.f10942f);
            this.f10933b.put(c.a.p0.q.h.h.class, c.a.p0.q.f.e.b.f10943g);
            this.f10933b.put(c.a.p0.q.h.e.class, c.a.p0.q.f.e.b.f10940d);
            this.f10933b.put(c.a.p0.q.h.c.class, c.a.p0.q.f.e.b.f10944h);
            this.f10933b.put(PMSAppInfo.class, c.a.p0.q.f.e.b.f10941e);
            this.f10933b.put(c.a.p0.q.h.i.class, c.a.p0.q.f.e.b.f10945i);
            this.f10933b.put(j.class, c.a.p0.q.f.e.b.f10946j);
        }
    }
}
