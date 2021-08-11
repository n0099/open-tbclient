package c.a.n0.n.i.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f11660e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f11661f;

    /* renamed from: g  reason: collision with root package name */
    public a f11662g;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atomicBoolean, bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11661f = atomicBoolean;
        this.f11660e = bVar;
        this.f11662g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f11660e.a(fVar);
            try {
                try {
                    fVar.run();
                } catch (Exception e2) {
                    if (c.a.n0.n.c.f11582a) {
                        String str = "run task error:" + e2.toString();
                    }
                }
            } finally {
                this.f11660e.b(fVar);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.f11661f.get() && (a2 = this.f11662g.a(true)) != null && (a2 instanceof f)) {
                try {
                    a((f) a2);
                } catch (Throwable th) {
                    if (c.a.n0.n.c.f11582a) {
                        String str = "runTask error:" + th.toString();
                    }
                }
            }
        }
    }
}
