package c.a.o0.n.g.c;

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
    public ConcurrentHashMap<Class<?>, b> f11831a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f11832b;

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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.f11831a.get(cls) : (b) invokeL.objValue;
    }

    public <T> Uri b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? this.f11832b.get(cls) : (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f11831a = new ConcurrentHashMap<>();
            this.f11832b = new ConcurrentHashMap<>();
            this.f11831a.put(c.a.o0.n.h.f.class, new f());
            this.f11831a.put(c.a.o0.n.h.g.class, new g());
            this.f11831a.put(c.a.o0.n.h.d.class, new e());
            this.f11831a.put(c.a.o0.n.h.b.class, new d());
            this.f11831a.put(PMSAppInfo.class, new a());
            this.f11831a.put(c.a.o0.n.h.h.class, new h());
            this.f11831a.put(c.a.o0.n.h.i.class, new i());
            this.f11832b.put(c.a.o0.n.h.f.class, c.a.o0.n.g.e.b.f11840e);
            this.f11832b.put(c.a.o0.n.h.g.class, c.a.o0.n.g.e.b.f11841f);
            this.f11832b.put(c.a.o0.n.h.d.class, c.a.o0.n.g.e.b.f11838c);
            this.f11832b.put(c.a.o0.n.h.b.class, c.a.o0.n.g.e.b.f11842g);
            this.f11832b.put(PMSAppInfo.class, c.a.o0.n.g.e.b.f11839d);
            this.f11832b.put(c.a.o0.n.h.h.class, c.a.o0.n.g.e.b.f11843h);
            this.f11832b.put(c.a.o0.n.h.i.class, c.a.o0.n.g.e.b.f11844i);
        }
    }
}
