package c.a.n0.a.x.l.g;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
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
    public static final boolean f7195d;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<k> a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f7196b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7197c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1451030645, "Lc/a/n0/a/x/l/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1451030645, "Lc/a/n0/a/x/l/g/g;");
                return;
            }
        }
        f7195d = c.a.n0.a.a.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i < 1) {
            if (f7195d) {
                throw new RuntimeException("MasterPool size can not less than 1");
            }
            i = 1;
        }
        this.f7197c = i;
        this.f7196b = new Object();
        this.a = new LinkedList();
    }

    public void a(Collection<k> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, collection) == null) {
            boolean z = collection == null || collection.size() <= 0;
            if (f7195d) {
                StringBuilder sb = new StringBuilder();
                sb.append("master pool clear, excludes size - ");
                sb.append(collection != null ? collection.size() : 0);
                Log.i("MasterPool", sb.toString());
                if (collection != null) {
                    for (k kVar : collection) {
                        if (kVar.i() != null) {
                            Log.i("MasterPool", "excludes  - " + kVar.i().c());
                        }
                    }
                }
            }
            synchronized (this.f7196b) {
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
        long currentTimeMillis = f7195d ? System.currentTimeMillis() : 0L;
        this.a.removeAll(collection);
        if (f7195d) {
            Log.i("MasterPool", "remove no use master in pool, size - " + collection.size());
        }
        for (k kVar : collection) {
            if (kVar.i() != null) {
                kVar.i().destroy();
                if (f7195d) {
                    Log.i("MasterPool", "master destroy, id - " + kVar.i().c() + ", isReady - " + kVar.n() + ", is Default - " + kVar.l() + ", is Prefetch - " + kVar.j());
                }
            }
        }
        if (f7195d) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("MasterPool", "destroy masters cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || TextUtils.equals(str, "_default_id_")) {
            return;
        }
        synchronized (this.f7196b) {
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
                if (f7195d) {
                    Log.w("MasterPool", "appId can not be empty");
                }
                return null;
            }
            synchronized (this.f7196b) {
                if (TextUtils.equals(str, "_default_id_")) {
                    if (f7195d) {
                        Log.i("MasterPool", "get default master manger for id - " + str);
                    }
                    return e();
                }
                int size = this.a.size() - 1;
                int i = size;
                while (true) {
                    if (i < 0) {
                        break;
                    }
                    k kVar2 = this.a.get(i);
                    if (TextUtils.equals(kVar2.h(), str)) {
                        if (f7195d) {
                            Log.i("MasterPool", "get master in pool for id - " + str);
                        }
                        kVar = kVar2;
                    } else {
                        i--;
                    }
                }
                if (kVar != null && i != size) {
                    this.a.remove(i);
                    this.a.add(kVar);
                }
                if (f7195d) {
                    if (kVar == null) {
                        Log.i("MasterPool", "find no master for id - " + str);
                    } else {
                        Log.i("MasterPool", "hit a master cache for id - " + str);
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
            if (f7195d) {
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
        synchronized (this.f7196b) {
            if (!this.a.contains(kVar)) {
                this.a.add(kVar);
            }
            h();
        }
    }

    public void g(Collection<k> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, collection) == null) {
            if (this.f7197c >= 3) {
                boolean z = true;
                if (this.a.size() > 1) {
                    if (collection != null && collection.size() > 0) {
                        z = false;
                    }
                    synchronized (this.f7196b) {
                        ArrayList arrayList = new ArrayList();
                        for (k kVar : this.a) {
                            if (!kVar.l() && kVar.j() && (z || !collection.contains(kVar))) {
                                arrayList.add(kVar);
                            }
                        }
                        if (f7195d) {
                            Log.d("MasterPool", "remove all prefetch event master, size - " + arrayList.size());
                        }
                        b(arrayList);
                    }
                    return;
                }
            }
            if (f7195d) {
                Log.d("MasterPool", "no need to remove prefetch master");
                Log.d("MasterPool", "max size - " + this.f7197c);
                Log.d("MasterPool", "current cache size - " + this.a.size());
            }
        }
    }

    public final void h() {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (size = this.a.size()) <= this.f7197c) {
            return;
        }
        if (f7195d) {
            Log.i("MasterPool", "resize, current - " + size + ", target - " + this.f7197c);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            k kVar = this.a.get(i);
            if (!kVar.l() || z) {
                arrayList.add(kVar);
                if (arrayList.size() >= size - this.f7197c) {
                    break;
                }
            } else {
                z = true;
            }
        }
        b(arrayList);
    }
}
