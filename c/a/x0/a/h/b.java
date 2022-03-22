package c.a.x0.a.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f22066g;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public long f22067b;

    /* renamed from: c  reason: collision with root package name */
    public int f22068c;

    /* renamed from: d  reason: collision with root package name */
    public long f22069d;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<c.a.x0.a.h.a> f22070e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f22071f;

    /* loaded from: classes3.dex */
    public class a implements Comparator<c.a.x0.a.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c.a.x0.a.h.a aVar, c.a.x0.a.h.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) {
                int h2 = aVar2.h() - aVar.h();
                return h2 == 0 ? (int) (aVar2.i() - aVar.i()) : h2;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1361180319, "Lc/a/x0/a/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1361180319, "Lc/a/x0/a/h/b;");
                return;
            }
        }
        f22066g = AppConfig.isDebug();
    }

    public b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = c.f(context);
        j(z);
    }

    public void a(c.a.x0.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar != null) {
                if (this.f22070e.size() == 0) {
                    this.f22070e.addFirst(aVar);
                } else {
                    int i = 0;
                    Iterator<c.a.x0.a.h.a> it = this.f22070e.iterator();
                    while (it.hasNext() && aVar.h() < it.next().h()) {
                        i++;
                    }
                    this.f22070e.add(i, aVar);
                }
            }
            if (f22066g) {
                Log.d("VoyagerTaskModel", "count: " + this.f22070e.size());
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f22068c < c.a.x0.a.b.b.f().m()) {
                if (f22066g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.f22068c + ", max: " + c.a.x0.a.b.b.f().m());
                }
                return true;
            }
            this.f22068c = 0;
            return System.currentTimeMillis() - this.f22067b > c.a.x0.a.b.b.f().l();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            c.a.x0.c.c.b(c.a.x0.a.d.a.g().h());
            LinkedList<c.a.x0.a.h.a> linkedList = this.f22070e;
            if (linkedList != null && linkedList.size() > 0) {
                this.f22070e.clear();
            }
            ArrayList<String> arrayList = this.f22071f;
            if (arrayList != null && arrayList.size() > 0) {
                this.f22071f.clear();
            }
            this.f22067b = 0L;
            this.f22068c = 0;
            this.f22069d = 0L;
        }
    }

    public final void d() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.a) == null) {
            return;
        }
        cVar.a();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<c.a.x0.a.h.a> linkedList = this.f22070e;
            if (linkedList != null && linkedList.size() != 0) {
                long h2 = c.a.x0.a.b.b.f().h();
                File h3 = c.a.x0.a.d.a.g().h();
                Iterator<c.a.x0.a.h.a> it = this.f22070e.iterator();
                while (it.hasNext()) {
                    c.a.x0.a.h.a next = it.next();
                    File file = new File(h3, next.j());
                    if (this.f22069d < h2) {
                        if (file.exists()) {
                            this.f22069d += file.length();
                        }
                    } else {
                        next.r(false);
                        next.q(System.currentTimeMillis());
                        n(next);
                        file.delete();
                    }
                }
                if (f22066g) {
                    Log.d("VoyagerTaskModel", "task count after delete exceed task: " + this.f22070e.size());
                }
                int g2 = c.a.x0.a.b.b.f().g();
                int size = this.f22070e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    c.a.x0.a.h.a removeLast = this.f22070e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    c.a.x0.c.c.d(c.a.x0.a.d.a.g().h(), removeLast.j());
                }
                if (f22066g) {
                    Log.d("VoyagerTaskModel", "delete count: " + i);
                }
            } else if (f22066g) {
                Log.d("VoyagerTaskModel", "task list length 0");
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.g(this.f22071f, this.f22070e);
            if (this.f22071f.size() > 0) {
                Iterator<String> it = this.f22071f.iterator();
                while (it.hasNext()) {
                    c.a.x0.c.c.d(c.a.x0.a.d.a.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public final void g() {
        ArrayList<File> f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (f2 = c.a.x0.a.d.a.g().f()) == null || f2.size() == 0) {
            return;
        }
        Iterator<File> it = f2.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            Iterator<c.a.x0.a.h.a> it2 = this.f22070e.iterator();
            while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
            }
            it.remove();
        }
        if (f22066g) {
            Log.d("VoyagerTaskModel", "unreference file count: " + f2.size());
        }
        if (f2.size() > 0) {
            c.a.x0.c.c.c(f2);
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<c.a.x0.a.h.a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.f22070e) == null || linkedList.size() == 0) {
                return false;
            }
            String c2 = this.a.c();
            c.a.x0.a.h.a aVar = null;
            Iterator<c.a.x0.a.h.a> it = this.f22070e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.a.x0.a.h.a next = it.next();
                if (TextUtils.equals(c2, next.j())) {
                    aVar = next;
                    break;
                }
            }
            if (aVar != null) {
                this.f22070e.remove(aVar);
            }
            File file = new File(c.a.x0.a.d.a.g().h(), c2);
            if (file.exists()) {
                file.delete();
                this.f22069d -= file.length();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public c.a.x0.a.h.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<c.a.x0.a.h.a> linkedList = this.f22070e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.f22070e.getFirst();
            }
            if (f22066g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.f22068c = 0;
            return null;
        }
        return (c.a.x0.a.h.a) invokeV.objValue;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                c();
                return;
            }
            this.f22070e = new LinkedList<>();
            this.f22071f = new ArrayList<>();
            this.f22067b = 0L;
            this.f22068c = 0;
            this.f22069d = 0L;
            f();
            g();
            e();
            l();
        }
    }

    public void k(c.a.x0.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a.h(aVar);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f22070e.size() <= 0) {
            return;
        }
        Collections.sort(this.f22070e, new a(this));
    }

    public void m(boolean z, c.a.x0.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, aVar) == null) {
            aVar.r(false);
            aVar.q(System.currentTimeMillis());
            n(aVar);
            if (z) {
                this.f22070e.remove(aVar);
            }
        }
    }

    public void n(c.a.x0.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a.i(aVar);
    }

    public void o(c.a.x0.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a.j(aVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f22067b = System.currentTimeMillis();
            if (f22066g) {
                Log.d("VoyagerTaskModel", "update check task time: " + this.f22067b);
            }
        }
    }

    public void q(c.a.x0.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f22070e.remove(aVar);
        this.f22070e.addLast(aVar);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f22068c++;
        }
    }

    public void s(boolean z, c.a.x0.a.h.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), aVar, Long.valueOf(j)}) == null) {
            aVar.r(false);
            aVar.s(aVar.k() + 1);
            aVar.q(System.currentTimeMillis());
            if (z) {
                if (f22066g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + aVar.d() + ", has uploaded " + aVar.k());
                }
                if (aVar.k() < aVar.d()) {
                    o(aVar);
                    q(aVar);
                    return;
                }
                n(aVar);
                this.f22070e.remove(aVar);
                return;
            }
            o(aVar);
            a(aVar);
            if (f22066g) {
                Log.d("VoyagerTaskModel", "add task " + aVar.j() + " to list");
            }
            this.f22069d += j;
            while (this.f22069d > c.a.x0.a.b.b.f().h()) {
                if (!h()) {
                    this.f22069d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, c.a.x0.a.h.a aVar, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), aVar, Long.valueOf(j), str}) == null) {
            aVar.r(true);
            aVar.q(System.currentTimeMillis());
            aVar.p(str);
            n(aVar);
            if (z) {
                this.f22070e.remove(aVar);
                this.f22069d -= j;
            }
        }
    }

    public void u(boolean z, c.a.x0.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, aVar) == null) {
            aVar.r(false);
            aVar.q(System.currentTimeMillis());
            o(aVar);
            if (z) {
                q(aVar);
            } else {
                a(aVar);
            }
        }
    }
}
