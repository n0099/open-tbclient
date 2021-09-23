package c.a.p0.a.n0.j.g;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import c.a.p0.a.n0.g;
import c.a.p0.a.p.b.a.l;
import c.a.p0.a.v2.q;
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
public class a implements b, c.a.p0.a.n0.j.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f7521a;

    /* renamed from: b  reason: collision with root package name */
    public l f7522b;

    /* renamed from: c  reason: collision with root package name */
    public volatile c.a.p0.a.n0.j.d.a[] f7523c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.n0.j.f.a f7524d;

    /* renamed from: c.a.p0.a.n0.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0312a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7525e;

        public RunnableC0312a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7525e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7525e.e();
            }
        }
    }

    public a(@NonNull c.a.p0.a.n0.j.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7521a = new g();
        this.f7522b = c.a.p0.a.c1.b.m();
        this.f7523c = new c.a.p0.a.n0.j.d.a[]{new c.a.p0.a.n0.j.d.e(), new c.a.p0.a.n0.j.d.c(), new c.a.p0.a.n0.j.d.b(), new c.a.p0.a.n0.j.d.d()};
        this.f7524d = aVar;
    }

    @Override // c.a.p0.a.n0.j.d.a
    public synchronized ArraySet<String> a() {
        InterceptResult invokeV;
        ArraySet<String> arraySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                c.a.p0.a.e0.d.h("RecoveryPolicy", "renameAllPlatformFiles start");
                arraySet = new ArraySet<>();
                for (c.a.p0.a.n0.j.d.a aVar : this.f7523c) {
                    arraySet.addAll((ArraySet<? extends String>) aVar.a());
                }
                c.a.p0.a.e0.d.h("RecoveryPolicy", "renameAllPlatformFiles end");
            }
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    @Override // c.a.p0.a.n0.j.g.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q.j(new RunnableC0312a(this), "performRecovery");
        }
    }

    public void c(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arraySet) == null) || arraySet == null || arraySet.isEmpty()) {
            return;
        }
        c.a.p0.a.e0.d.h("RecoveryPolicy", "deleteFiles start");
        Iterator<String> it = arraySet.iterator();
        while (it.hasNext()) {
            c.a.p0.t.d.j(it.next());
        }
        c.a.p0.a.e0.d.h("RecoveryPolicy", "deleteFiles end");
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.a.v1.c.a e2 = c.a.p0.a.v1.c.a.e();
            c.a.p0.a.v1.c.c cVar = new c.a.p0.a.v1.c.c(132);
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
        c.a.p0.a.e0.d.h("RecoveryPolicy", "resetAccredit appIds=" + collection);
        this.f7521a.g(new ArrayList(collection));
    }
}
