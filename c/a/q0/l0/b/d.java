package c.a.q0.l0.b;

import c.a.p0.x.p.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends c.a.p0.x.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static d f21586f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<c.a.p0.x.p.c> f21587e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1772577477, "Lc/a/q0/l0/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1772577477, "Lc/a/q0/l0/b/d;");
                return;
            }
        }
        f21586f = new d();
    }

    public d() {
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

    public static synchronized d f() {
        InterceptResult invokeV;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (d.class) {
                dVar = f21586f;
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    @Override // c.a.p0.x.p.a
    public void b(a.InterfaceC0719a interfaceC0719a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0719a) == null) {
            LinkedList<c.a.p0.x.p.c> linkedList = this.f21587e;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<c.a.p0.x.p.c> it = this.f21587e.iterator();
                while (it.hasNext()) {
                    c.a.p0.x.p.c next = it.next();
                    if (interfaceC0719a != null) {
                        interfaceC0719a.a(next);
                    }
                }
                return;
            }
            this.f21587e = new LinkedList<>();
            if (TbFaceManager.e().h() > 0) {
                c cVar = new c();
                this.f21587e.add(cVar);
                if (interfaceC0719a != null) {
                    interfaceC0719a.a(cVar);
                }
            }
        }
    }

    @Override // c.a.p0.x.p.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.x.p.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public List<c.a.p0.x.p.c> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21587e : (List) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinkedList<c.a.p0.x.p.c> linkedList = this.f21587e;
            return linkedList == null || linkedList.size() == 0;
        }
        return invokeV.booleanValue;
    }
}
