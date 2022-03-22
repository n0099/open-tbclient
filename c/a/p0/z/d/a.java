package c.a.p0.z.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f20831c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<InterfaceC1557a> a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.o0.s.f.a> f20832b;

    /* renamed from: c.a.p0.z.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1557a {
        void k(List<c.a.o0.s.f.a> list);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public static synchronized a d() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f20831c == null) {
                    f20831c = new a();
                }
                aVar = f20831c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public void a(c.a.o0.s.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f20832b == null || aVar == null) {
            return;
        }
        String a = aVar.a();
        if (TextUtils.isEmpty(a)) {
            a = "#";
            aVar.k("#");
        }
        String f2 = aVar.f();
        if (f2 == null) {
            f2 = "";
        }
        boolean z = false;
        boolean z2 = false;
        for (c.a.o0.s.f.a aVar2 : this.f20832b) {
            if (f2.equals(aVar2.f())) {
                z = true;
            }
            if (a.equals(aVar2.a())) {
                z2 = true;
            }
        }
        if (z) {
            return;
        }
        if (!z2) {
            c.a.o0.s.f.a aVar3 = new c.a.o0.s.f.a();
            aVar3.k(a);
            this.f20832b.add(aVar3);
        }
        this.f20832b.add(aVar);
        Collections.sort(this.f20832b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<c.a.o0.s.f.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (list = this.f20832b) == null) {
            return;
        }
        String str = null;
        Iterator<c.a.o0.s.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.o0.s.f.a next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.f20832b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.o0.s.f.a aVar : this.f20832b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f20832b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<c.a.o0.s.f.a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20832b : (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (InterfaceC1557a interfaceC1557a : this.a) {
                interfaceC1557a.k(this.f20832b);
            }
        }
    }

    public void f(InterfaceC1557a interfaceC1557a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, interfaceC1557a) == null) || interfaceC1557a == null || this.a.contains(interfaceC1557a)) {
            return;
        }
        this.a.add(interfaceC1557a);
    }

    public void g(List<c.a.o0.s.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f20832b = list;
            if (list != null) {
                Collections.sort(list, new ContactComparator());
            }
            e();
        }
    }

    public void h(InterfaceC1557a interfaceC1557a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, interfaceC1557a) == null) || interfaceC1557a == null) {
            return;
        }
        this.a.remove(interfaceC1557a);
    }
}
