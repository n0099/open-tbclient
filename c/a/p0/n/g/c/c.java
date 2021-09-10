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
    public ConcurrentHashMap<Class<?>, b> f11859a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f11860b;

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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.f11859a.get(cls) : (b) invokeL.objValue;
    }

    public <T> Uri b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? this.f11860b.get(cls) : (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f11859a = new ConcurrentHashMap<>();
            this.f11860b = new ConcurrentHashMap<>();
            this.f11859a.put(c.a.p0.n.h.f.class, new f());
            this.f11859a.put(c.a.p0.n.h.g.class, new g());
            this.f11859a.put(c.a.p0.n.h.d.class, new e());
            this.f11859a.put(c.a.p0.n.h.b.class, new d());
            this.f11859a.put(PMSAppInfo.class, new a());
            this.f11859a.put(c.a.p0.n.h.h.class, new h());
            this.f11859a.put(c.a.p0.n.h.i.class, new i());
            this.f11860b.put(c.a.p0.n.h.f.class, c.a.p0.n.g.e.b.f11868e);
            this.f11860b.put(c.a.p0.n.h.g.class, c.a.p0.n.g.e.b.f11869f);
            this.f11860b.put(c.a.p0.n.h.d.class, c.a.p0.n.g.e.b.f11866c);
            this.f11860b.put(c.a.p0.n.h.b.class, c.a.p0.n.g.e.b.f11870g);
            this.f11860b.put(PMSAppInfo.class, c.a.p0.n.g.e.b.f11867d);
            this.f11860b.put(c.a.p0.n.h.h.class, c.a.p0.n.g.e.b.f11871h);
            this.f11860b.put(c.a.p0.n.h.i.class, c.a.p0.n.g.e.b.f11872i);
        }
    }
}
