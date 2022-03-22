package c.a.n0.a.d0.j.g;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import c.a.n0.a.d0.g;
import c.a.n0.a.f.b.a.l;
import c.a.n0.a.p2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a implements b, c.a.n0.a.d0.j.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public l f4043b;

    /* renamed from: c  reason: collision with root package name */
    public volatile c.a.n0.a.d0.j.d.a[] f4044c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.a.d0.j.f.a f4045d;

    /* renamed from: c.a.n0.a.d0.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0233a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public RunnableC0233a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    public a(@NonNull c.a.n0.a.d0.j.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new g();
        this.f4043b = c.a.n0.a.s0.b.m();
        this.f4044c = new c.a.n0.a.d0.j.d.a[]{new c.a.n0.a.d0.j.d.e(), new c.a.n0.a.d0.j.d.c(), new c.a.n0.a.d0.j.d.b(), new c.a.n0.a.d0.j.d.d()};
        this.f4045d = aVar;
    }

    @Override // c.a.n0.a.d0.j.d.a
    public synchronized ArraySet<String> a() {
        InterceptResult invokeV;
        ArraySet<String> arraySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                c.a.n0.a.u.d.k("RecoveryPolicy", "renameAllPlatformFiles start");
                arraySet = new ArraySet<>();
                for (c.a.n0.a.d0.j.d.a aVar : this.f4044c) {
                    arraySet.addAll((ArraySet<? extends String>) aVar.a());
                }
                c.a.n0.a.u.d.k("RecoveryPolicy", "renameAllPlatformFiles end");
            }
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    @Override // c.a.n0.a.d0.j.g.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q.k(new RunnableC0233a(this), "performRecovery");
        }
    }

    public void c(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arraySet) == null) || arraySet == null || arraySet.isEmpty()) {
            return;
        }
        c.a.n0.a.u.d.k("RecoveryPolicy", "deleteFiles start");
        Iterator<String> it = arraySet.iterator();
        while (it.hasNext()) {
            c.a.n0.w.d.k(it.next());
        }
        c.a.n0.a.u.d.k("RecoveryPolicy", "deleteFiles end");
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.n0.a.o1.c.a e2 = c.a.n0.a.o1.c.a.e();
            c.a.n0.a.o1.c.c cVar = new c.a.n0.a.o1.c.c(132);
            cVar.d();
            e2.h(cVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void f(Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, collection) == null) || collection == null || collection.isEmpty()) {
            return;
        }
        c.a.n0.a.u.d.k("RecoveryPolicy", "resetAccredit appIds=" + collection);
        this.a.g(new ArrayList(collection));
    }
}
