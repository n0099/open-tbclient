package c.a.q0.s.d;

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
    public static a f24213c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1116a> f24214a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.p0.t.f.a> f24215b;

    /* renamed from: c.a.q0.s.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1116a {
        void notifyCacheDataChanged(List<c.a.p0.t.f.a> list);
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
        this.f24214a = new ArrayList();
    }

    public static synchronized a d() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f24213c == null) {
                    f24213c = new a();
                }
                aVar = f24213c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public void a(c.a.p0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f24215b == null || aVar == null) {
            return;
        }
        String a2 = aVar.a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "#";
            aVar.k("#");
        }
        String f2 = aVar.f();
        if (f2 == null) {
            f2 = "";
        }
        boolean z = false;
        boolean z2 = false;
        for (c.a.p0.t.f.a aVar2 : this.f24215b) {
            if (f2.equals(aVar2.f())) {
                z = true;
            }
            if (a2.equals(aVar2.a())) {
                z2 = true;
            }
        }
        if (z) {
            return;
        }
        if (!z2) {
            c.a.p0.t.f.a aVar3 = new c.a.p0.t.f.a();
            aVar3.k(a2);
            this.f24215b.add(aVar3);
        }
        this.f24215b.add(aVar);
        Collections.sort(this.f24215b, new ContactComparator());
        e();
    }

    public void b(long j2) {
        List<c.a.p0.t.f.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || (list = this.f24215b) == null) {
            return;
        }
        String str = null;
        Iterator<c.a.p0.t.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.p0.t.f.a next = it.next();
            if (next.e() == j2) {
                str = next.a();
                this.f24215b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.p0.t.f.a aVar : this.f24215b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f24215b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<c.a.p0.t.f.a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24215b : (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (InterfaceC1116a interfaceC1116a : this.f24214a) {
                interfaceC1116a.notifyCacheDataChanged(this.f24215b);
            }
        }
    }

    public void f(InterfaceC1116a interfaceC1116a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, interfaceC1116a) == null) || interfaceC1116a == null || this.f24214a.contains(interfaceC1116a)) {
            return;
        }
        this.f24214a.add(interfaceC1116a);
    }

    public void g(List<c.a.p0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f24215b = list;
            if (list != null) {
                Collections.sort(list, new ContactComparator());
            }
            e();
        }
    }

    public void h(InterfaceC1116a interfaceC1116a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, interfaceC1116a) == null) || interfaceC1116a == null) {
            return;
        }
        this.f24214a.remove(interfaceC1116a);
    }
}
