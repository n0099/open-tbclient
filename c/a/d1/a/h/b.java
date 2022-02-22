package c.a.d1.a.h;

import android.content.Context;
import android.text.TextUtils;
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
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f3550g;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public long f3551b;

    /* renamed from: c  reason: collision with root package name */
    public int f3552c;

    /* renamed from: d  reason: collision with root package name */
    public long f3553d;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<c.a.d1.a.h.a> f3554e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f3555f;

    /* loaded from: classes.dex */
    public class a implements Comparator<c.a.d1.a.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c.a.d1.a.h.a aVar, c.a.d1.a.h.a aVar2) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(598374250, "Lc/a/d1/a/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(598374250, "Lc/a/d1/a/h/b;");
                return;
            }
        }
        f3550g = AppConfig.isDebug();
    }

    public b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = c.f(context);
        j(z);
    }

    public void a(c.a.d1.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar != null) {
                if (this.f3554e.size() == 0) {
                    this.f3554e.addFirst(aVar);
                } else {
                    int i2 = 0;
                    Iterator<c.a.d1.a.h.a> it = this.f3554e.iterator();
                    while (it.hasNext() && aVar.h() < it.next().h()) {
                        i2++;
                    }
                    this.f3554e.add(i2, aVar);
                }
            }
            if (f3550g) {
                String str = "count: " + this.f3554e.size();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f3552c < c.a.d1.a.b.b.f().m()) {
                if (f3550g) {
                    String str = "current count: " + this.f3552c + ", max: " + c.a.d1.a.b.b.f().m();
                }
                return true;
            }
            this.f3552c = 0;
            return System.currentTimeMillis() - this.f3551b > c.a.d1.a.b.b.f().l();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            c.a.d1.c.c.b(c.a.d1.a.d.a.g().h());
            LinkedList<c.a.d1.a.h.a> linkedList = this.f3554e;
            if (linkedList != null && linkedList.size() > 0) {
                this.f3554e.clear();
            }
            ArrayList<String> arrayList = this.f3555f;
            if (arrayList != null && arrayList.size() > 0) {
                this.f3555f.clear();
            }
            this.f3551b = 0L;
            this.f3552c = 0;
            this.f3553d = 0L;
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
            LinkedList<c.a.d1.a.h.a> linkedList = this.f3554e;
            if (linkedList != null && linkedList.size() != 0) {
                long h2 = c.a.d1.a.b.b.f().h();
                File h3 = c.a.d1.a.d.a.g().h();
                Iterator<c.a.d1.a.h.a> it = this.f3554e.iterator();
                while (it.hasNext()) {
                    c.a.d1.a.h.a next = it.next();
                    File file = new File(h3, next.j());
                    if (this.f3553d < h2) {
                        if (file.exists()) {
                            this.f3553d += file.length();
                        }
                    } else {
                        next.r(false);
                        next.q(System.currentTimeMillis());
                        n(next);
                        file.delete();
                    }
                }
                if (f3550g) {
                    String str = "task count after delete exceed task: " + this.f3554e.size();
                }
                int g2 = c.a.d1.a.b.b.f().g();
                int size = this.f3554e.size();
                if (size <= g2) {
                    return;
                }
                int i2 = size - g2;
                for (int i3 = i2; i3 > 0; i3--) {
                    c.a.d1.a.h.a removeLast = this.f3554e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    c.a.d1.c.c.d(c.a.d1.a.d.a.g().h(), removeLast.j());
                }
                if (f3550g) {
                    String str2 = "delete count: " + i2;
                    return;
                }
                return;
            }
            boolean z = f3550g;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.g(this.f3555f, this.f3554e);
            if (this.f3555f.size() > 0) {
                Iterator<String> it = this.f3555f.iterator();
                while (it.hasNext()) {
                    c.a.d1.c.c.d(c.a.d1.a.d.a.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public final void g() {
        ArrayList<File> f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (f2 = c.a.d1.a.d.a.g().f()) == null || f2.size() == 0) {
            return;
        }
        Iterator<File> it = f2.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            Iterator<c.a.d1.a.h.a> it2 = this.f3554e.iterator();
            while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
            }
            it.remove();
        }
        if (f3550g) {
            String str = "unreference file count: " + f2.size();
        }
        if (f2.size() > 0) {
            c.a.d1.c.c.c(f2);
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<c.a.d1.a.h.a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.f3554e) == null || linkedList.size() == 0) {
                return false;
            }
            String c2 = this.a.c();
            c.a.d1.a.h.a aVar = null;
            Iterator<c.a.d1.a.h.a> it = this.f3554e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.a.d1.a.h.a next = it.next();
                if (TextUtils.equals(c2, next.j())) {
                    aVar = next;
                    break;
                }
            }
            if (aVar != null) {
                this.f3554e.remove(aVar);
            }
            File file = new File(c.a.d1.a.d.a.g().h(), c2);
            if (file.exists()) {
                file.delete();
                this.f3553d -= file.length();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public c.a.d1.a.h.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<c.a.d1.a.h.a> linkedList = this.f3554e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.f3554e.getFirst();
            }
            boolean z = f3550g;
            this.f3552c = 0;
            return null;
        }
        return (c.a.d1.a.h.a) invokeV.objValue;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                c();
                return;
            }
            this.f3554e = new LinkedList<>();
            this.f3555f = new ArrayList<>();
            this.f3551b = 0L;
            this.f3552c = 0;
            this.f3553d = 0L;
            f();
            g();
            e();
            l();
        }
    }

    public void k(c.a.d1.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a.h(aVar);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f3554e.size() <= 0) {
            return;
        }
        Collections.sort(this.f3554e, new a(this));
    }

    public void m(boolean z, c.a.d1.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, aVar) == null) {
            aVar.r(false);
            aVar.q(System.currentTimeMillis());
            n(aVar);
            if (z) {
                this.f3554e.remove(aVar);
            }
        }
    }

    public void n(c.a.d1.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a.i(aVar);
    }

    public void o(c.a.d1.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a.j(aVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f3551b = System.currentTimeMillis();
            if (f3550g) {
                String str = "update check task time: " + this.f3551b;
            }
        }
    }

    public void q(c.a.d1.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f3554e.remove(aVar);
        this.f3554e.addLast(aVar);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f3552c++;
        }
    }

    public void s(boolean z, c.a.d1.a.h.a aVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), aVar, Long.valueOf(j2)}) == null) {
            aVar.r(false);
            aVar.s(aVar.k() + 1);
            aVar.q(System.currentTimeMillis());
            if (z) {
                if (f3550g) {
                    String str = "max upload count: " + aVar.d() + ", has uploaded " + aVar.k();
                }
                if (aVar.k() < aVar.d()) {
                    o(aVar);
                    q(aVar);
                    return;
                }
                n(aVar);
                this.f3554e.remove(aVar);
                return;
            }
            o(aVar);
            a(aVar);
            if (f3550g) {
                String str2 = "add task " + aVar.j() + " to list";
            }
            this.f3553d += j2;
            while (this.f3553d > c.a.d1.a.b.b.f().h()) {
                if (!h()) {
                    this.f3553d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, c.a.d1.a.h.a aVar, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), aVar, Long.valueOf(j2), str}) == null) {
            aVar.r(true);
            aVar.q(System.currentTimeMillis());
            aVar.p(str);
            n(aVar);
            if (z) {
                this.f3554e.remove(aVar);
                this.f3553d -= j2;
            }
        }
    }

    public void u(boolean z, c.a.d1.a.h.a aVar) {
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
