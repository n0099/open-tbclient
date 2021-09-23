package c.a.p0.n.g.c;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f11867a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f11868b;

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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.f11867a.get(cls) : (b) invokeL.objValue;
    }

    public <T> Uri b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? this.f11868b.get(cls) : (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f11867a = new ConcurrentHashMap<>();
            this.f11868b = new ConcurrentHashMap<>();
            this.f11867a.put(c.a.p0.n.h.f.class, new f());
            this.f11867a.put(c.a.p0.n.h.g.class, new g());
            this.f11867a.put(c.a.p0.n.h.d.class, new e());
            this.f11867a.put(c.a.p0.n.h.b.class, new d());
            this.f11867a.put(PMSAppInfo.class, new a());
            this.f11867a.put(c.a.p0.n.h.h.class, new h());
            this.f11867a.put(c.a.p0.n.h.i.class, new i());
            this.f11868b.put(c.a.p0.n.h.f.class, c.a.p0.n.g.e.b.f11876e);
            this.f11868b.put(c.a.p0.n.h.g.class, c.a.p0.n.g.e.b.f11877f);
            this.f11868b.put(c.a.p0.n.h.d.class, c.a.p0.n.g.e.b.f11874c);
            this.f11868b.put(c.a.p0.n.h.b.class, c.a.p0.n.g.e.b.f11878g);
            this.f11868b.put(PMSAppInfo.class, c.a.p0.n.g.e.b.f11875d);
            this.f11868b.put(c.a.p0.n.h.h.class, c.a.p0.n.g.e.b.f11879h);
            this.f11868b.put(c.a.p0.n.h.i.class, c.a.p0.n.g.e.b.f11880i);
        }
    }
}
