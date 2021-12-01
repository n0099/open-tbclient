package c.a.r0.x.d;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f25293c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<InterfaceC1445a> a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.q0.t.f.a> f25294b;

    /* renamed from: c.a.r0.x.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1445a {
        void notifyCacheDataChanged(List<c.a.q0.t.f.a> list);
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
                if (f25293c == null) {
                    f25293c = new a();
                }
                aVar = f25293c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public void a(c.a.q0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f25294b == null || aVar == null) {
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
        for (c.a.q0.t.f.a aVar2 : this.f25294b) {
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
            c.a.q0.t.f.a aVar3 = new c.a.q0.t.f.a();
            aVar3.k(a);
            this.f25294b.add(aVar3);
        }
        this.f25294b.add(aVar);
        Collections.sort(this.f25294b, new ContactComparator());
        e();
    }

    public void b(long j2) {
        List<c.a.q0.t.f.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || (list = this.f25294b) == null) {
            return;
        }
        String str = null;
        Iterator<c.a.q0.t.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.q0.t.f.a next = it.next();
            if (next.e() == j2) {
                str = next.a();
                this.f25294b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.q0.t.f.a aVar : this.f25294b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f25294b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<c.a.q0.t.f.a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25294b : (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (InterfaceC1445a interfaceC1445a : this.a) {
                interfaceC1445a.notifyCacheDataChanged(this.f25294b);
            }
        }
    }

    public void f(InterfaceC1445a interfaceC1445a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, interfaceC1445a) == null) || interfaceC1445a == null || this.a.contains(interfaceC1445a)) {
            return;
        }
        this.a.add(interfaceC1445a);
    }

    public void g(List<c.a.q0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f25294b = list;
            if (list != null) {
                Collections.sort(list, new ContactComparator());
            }
            e();
        }
    }

    public void h(InterfaceC1445a interfaceC1445a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, interfaceC1445a) == null) || interfaceC1445a == null) {
            return;
        }
        this.a.remove(interfaceC1445a);
    }
}
