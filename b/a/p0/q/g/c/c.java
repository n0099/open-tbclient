package b.a.p0.q.g.c;

import android.net.Uri;
import b.a.p0.q.i.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f11740a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f11741b;

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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.f11740a.get(cls) : (b) invokeL.objValue;
    }

    public <T> Uri b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? this.f11741b.get(cls) : (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f11740a = new ConcurrentHashMap<>();
            this.f11741b = new ConcurrentHashMap<>();
            this.f11740a.put(b.a.p0.q.i.g.class, new f());
            this.f11740a.put(b.a.p0.q.i.h.class, new g());
            this.f11740a.put(b.a.p0.q.i.e.class, new e());
            this.f11740a.put(b.a.p0.q.i.c.class, new d());
            this.f11740a.put(PMSAppInfo.class, new a());
            this.f11740a.put(b.a.p0.q.i.i.class, new h());
            this.f11740a.put(j.class, new i());
            this.f11741b.put(b.a.p0.q.i.g.class, b.a.p0.q.g.e.b.f11752f);
            this.f11741b.put(b.a.p0.q.i.h.class, b.a.p0.q.g.e.b.f11753g);
            this.f11741b.put(b.a.p0.q.i.e.class, b.a.p0.q.g.e.b.f11750d);
            this.f11741b.put(b.a.p0.q.i.c.class, b.a.p0.q.g.e.b.f11754h);
            this.f11741b.put(PMSAppInfo.class, b.a.p0.q.g.e.b.f11751e);
            this.f11741b.put(b.a.p0.q.i.i.class, b.a.p0.q.g.e.b.f11755i);
            this.f11741b.put(j.class, b.a.p0.q.g.e.b.j);
        }
    }
}
