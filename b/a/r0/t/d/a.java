package b.a.r0.t.d;

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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f23551c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1146a> f23552a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.q0.t.f.a> f23553b;

    /* renamed from: b.a.r0.t.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1146a {
        void notifyCacheDataChanged(List<b.a.q0.t.f.a> list);
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
        this.f23552a = new ArrayList();
    }

    public static synchronized a d() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f23551c == null) {
                    f23551c = new a();
                }
                aVar = f23551c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public void a(b.a.q0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f23553b == null || aVar == null) {
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
        for (b.a.q0.t.f.a aVar2 : this.f23553b) {
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
            b.a.q0.t.f.a aVar3 = new b.a.q0.t.f.a();
            aVar3.k(a2);
            this.f23553b.add(aVar3);
        }
        this.f23553b.add(aVar);
        Collections.sort(this.f23553b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<b.a.q0.t.f.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (list = this.f23553b) == null) {
            return;
        }
        String str = null;
        Iterator<b.a.q0.t.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b.a.q0.t.f.a next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.f23553b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (b.a.q0.t.f.a aVar : this.f23553b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f23553b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<b.a.q0.t.f.a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23553b : (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (InterfaceC1146a interfaceC1146a : this.f23552a) {
                interfaceC1146a.notifyCacheDataChanged(this.f23553b);
            }
        }
    }

    public void f(InterfaceC1146a interfaceC1146a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, interfaceC1146a) == null) || interfaceC1146a == null || this.f23552a.contains(interfaceC1146a)) {
            return;
        }
        this.f23552a.add(interfaceC1146a);
    }

    public void g(List<b.a.q0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f23553b = list;
            if (list != null) {
                Collections.sort(list, new ContactComparator());
            }
            e();
        }
    }

    public void h(InterfaceC1146a interfaceC1146a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, interfaceC1146a) == null) || interfaceC1146a == null) {
            return;
        }
        this.f23552a.remove(interfaceC1146a);
    }
}
