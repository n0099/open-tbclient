package c.a.r0.a.h0.l.g;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f6726d;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<k> a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f6727b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6728c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-64073619, "Lc/a/r0/a/h0/l/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-64073619, "Lc/a/r0/a/h0/l/g/g;");
                return;
            }
        }
        f6726d = c.a.r0.a.k.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i2 < 1) {
            if (f6726d) {
                throw new RuntimeException("MasterPool size can not less than 1");
            }
            i2 = 1;
        }
        this.f6728c = i2;
        this.f6727b = new Object();
        this.a = new LinkedList();
    }

    public void a(Collection<k> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, collection) == null) {
            boolean z = collection == null || collection.size() <= 0;
            if (f6726d) {
                StringBuilder sb = new StringBuilder();
                sb.append("master pool clear, excludes size - ");
                sb.append(collection != null ? collection.size() : 0);
                sb.toString();
                if (collection != null) {
                    for (k kVar : collection) {
                        if (kVar.i() != null) {
                            String str = "excludes  - " + kVar.i().c();
                        }
                    }
                }
            }
            synchronized (this.f6727b) {
                ArrayList arrayList = new ArrayList();
                for (k kVar2 : this.a) {
                    if (z || (collection != null && !collection.contains(kVar2))) {
                        arrayList.add(kVar2);
                    }
                }
                b(arrayList);
            }
        }
    }

    public final void b(Collection<k> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) || collection.size() <= 0) {
            return;
        }
        long currentTimeMillis = f6726d ? System.currentTimeMillis() : 0L;
        this.a.removeAll(collection);
        if (f6726d) {
            String str = "remove no use master in pool, size - " + collection.size();
        }
        for (k kVar : collection) {
            if (kVar.i() != null) {
                kVar.i().destroy();
                if (f6726d) {
                    String str2 = "master destroy, id - " + kVar.i().c() + ", isReady - " + kVar.n() + ", is Default - " + kVar.l() + ", is Prefetch - " + kVar.j();
                }
            }
        }
        if (f6726d) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str3 = "destroy masters cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || TextUtils.equals(str, "_default_id_")) {
            return;
        }
        synchronized (this.f6727b) {
            ArrayList arrayList = new ArrayList();
            for (k kVar : this.a) {
                if (TextUtils.equals(kVar.h(), str)) {
                    arrayList.add(kVar);
                }
            }
            b(arrayList);
        }
    }

    public k d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            k kVar = null;
            if (TextUtils.isEmpty(str)) {
                boolean z = f6726d;
                return null;
            }
            synchronized (this.f6727b) {
                if (TextUtils.equals(str, "_default_id_")) {
                    if (f6726d) {
                        String str2 = "get default master manger for id - " + str;
                    }
                    return e();
                }
                int size = this.a.size() - 1;
                int i2 = size;
                while (true) {
                    if (i2 < 0) {
                        break;
                    }
                    k kVar2 = this.a.get(i2);
                    if (TextUtils.equals(kVar2.h(), str)) {
                        if (f6726d) {
                            String str3 = "get master in pool for id - " + str;
                        }
                        kVar = kVar2;
                    } else {
                        i2--;
                    }
                }
                if (kVar != null && i2 != size) {
                    this.a.remove(i2);
                    this.a.add(kVar);
                }
                if (f6726d) {
                    if (kVar == null) {
                        String str4 = "find no master for id - " + str;
                    } else {
                        String str5 = "hit a master cache for id - " + str;
                    }
                }
                return kVar;
            }
        }
        return (k) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final k e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            for (k kVar : this.a) {
                if (kVar.l()) {
                    return kVar;
                }
            }
            if (f6726d) {
                throw new RuntimeException("there must be one default master in pool, you should add default one first");
            }
            return null;
        }
        return (k) invokeV.objValue;
    }

    public void f(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) || kVar == null) {
            return;
        }
        synchronized (this.f6727b) {
            if (!this.a.contains(kVar)) {
                this.a.add(kVar);
            }
            h();
        }
    }

    public void g(Collection<k> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, collection) == null) {
            if (this.f6728c >= 3) {
                boolean z = true;
                if (this.a.size() > 1) {
                    if (collection != null && collection.size() > 0) {
                        z = false;
                    }
                    synchronized (this.f6727b) {
                        ArrayList arrayList = new ArrayList();
                        for (k kVar : this.a) {
                            if (!kVar.l() && kVar.j() && (z || !collection.contains(kVar))) {
                                arrayList.add(kVar);
                            }
                        }
                        if (f6726d) {
                            String str = "remove all prefetch event master, size - " + arrayList.size();
                        }
                        b(arrayList);
                    }
                    return;
                }
            }
            if (f6726d) {
                String str2 = "max size - " + this.f6728c;
                String str3 = "current cache size - " + this.a.size();
            }
        }
    }

    public final void h() {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (size = this.a.size()) <= this.f6728c) {
            return;
        }
        if (f6726d) {
            String str = "resize, current - " + size + ", target - " + this.f6728c;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = this.a.get(i2);
            if (!kVar.l() || z) {
                arrayList.add(kVar);
                if (arrayList.size() >= size - this.f6728c) {
                    break;
                }
            } else {
                z = true;
            }
        }
        b(arrayList);
    }
}
