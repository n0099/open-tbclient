package c.a.b0.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<k>> a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<Object, ArrayList<k>> f1671b;

    public c() {
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
        this.a = new ConcurrentHashMap<>();
        this.f1671b = new ConcurrentHashMap<>();
    }

    public final void a(@NonNull k kVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            synchronized (this) {
                ArrayList<k> arrayList = this.a.get(kVar.f1676b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(kVar.f1676b, arrayList);
                } else {
                    Iterator<k> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == kVar.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(kVar);
                }
                ArrayList<k> arrayList2 = this.f1671b.get(kVar.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.f1671b.put(kVar.a, arrayList2);
                } else {
                    Iterator<k> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().f1678d == kVar.f1678d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(kVar);
                }
            }
        }
    }

    public <T extends f> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<k> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    f(next, next.f1678d, t);
                }
            }
        }
    }

    public <T extends f> void c(@NonNull Object obj, int i2, @NonNull i<T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i2, iVar) == null) {
            a(new k(i2, obj, iVar.a(), iVar));
        }
    }

    public <T extends f> void d(@NonNull Object obj, @NonNull i<T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, iVar) == null) {
            c(obj, 0, iVar);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<k> arrayList = this.f1671b.get(obj);
                if (arrayList != null) {
                    Iterator<k> it = arrayList.iterator();
                    while (it.hasNext()) {
                        k next = it.next();
                        ArrayList<k> arrayList2 = this.a.get(next.f1676b);
                        if (arrayList2 != null) {
                            arrayList2.remove(next);
                        }
                    }
                    arrayList.clear();
                    this.f1671b.remove(obj);
                }
            }
        }
    }

    public final <T extends f> void f(k kVar, i<T> iVar, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, kVar, iVar, t) == null) {
            int i2 = kVar.f1677c;
            if (i2 == 0) {
                iVar.onEvent(t);
            } else if (i2 == 1) {
                j.b().a(kVar, iVar, t);
            } else if (i2 == 2) {
                b.b().a(kVar, iVar, t);
            } else if (i2 != 3) {
            } else {
                a.b().a(kVar, iVar, t);
            }
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
