package c.a.t0.x.d;

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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f25063c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<InterfaceC1510a> a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.s0.t.f.a> f25064b;

    /* renamed from: c.a.t0.x.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1510a {
        void notifyCacheDataChanged(List<c.a.s0.t.f.a> list);
    }

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
                if (f25063c == null) {
                    f25063c = new a();
                }
                aVar = f25063c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public void a(c.a.s0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f25064b == null || aVar == null) {
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
        for (c.a.s0.t.f.a aVar2 : this.f25064b) {
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
            c.a.s0.t.f.a aVar3 = new c.a.s0.t.f.a();
            aVar3.k(a);
            this.f25064b.add(aVar3);
        }
        this.f25064b.add(aVar);
        Collections.sort(this.f25064b, new ContactComparator());
        e();
    }

    public void b(long j2) {
        List<c.a.s0.t.f.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || (list = this.f25064b) == null) {
            return;
        }
        String str = null;
        Iterator<c.a.s0.t.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.s0.t.f.a next = it.next();
            if (next.e() == j2) {
                str = next.a();
                this.f25064b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.s0.t.f.a aVar : this.f25064b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f25064b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<c.a.s0.t.f.a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25064b : (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (InterfaceC1510a interfaceC1510a : this.a) {
                interfaceC1510a.notifyCacheDataChanged(this.f25064b);
            }
        }
    }

    public void f(InterfaceC1510a interfaceC1510a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, interfaceC1510a) == null) || interfaceC1510a == null || this.a.contains(interfaceC1510a)) {
            return;
        }
        this.a.add(interfaceC1510a);
    }

    public void g(List<c.a.s0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f25064b = list;
            if (list != null) {
                Collections.sort(list, new ContactComparator());
            }
            e();
        }
    }

    public void h(InterfaceC1510a interfaceC1510a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, interfaceC1510a) == null) || interfaceC1510a == null) {
            return;
        }
        this.a.remove(interfaceC1510a);
    }
}
