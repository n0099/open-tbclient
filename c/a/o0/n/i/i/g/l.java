package c.a.o0.n.i.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Vector;
/* loaded from: classes3.dex */
public class l implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Vector<b> f11921a;

    /* renamed from: b  reason: collision with root package name */
    public Object f11922b;

    public l(b bVar) {
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
                return;
            }
        }
        this.f11922b = new Object();
        this.f11921a = new Vector<>();
        c(bVar);
    }

    @Override // c.a.o0.n.i.i.g.b
    public <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            try {
                synchronized (this.f11922b) {
                    Iterator<b> it = this.f11921a.iterator();
                    while (it.hasNext()) {
                        it.next().a(fVar);
                    }
                }
            } catch (Throwable th) {
                if (c.a.o0.n.c.f11828a) {
                    String str = "notifyTaskRunning error:" + th.toString();
                }
            }
        }
    }

    @Override // c.a.o0.n.i.i.g.b
    public <T> void b(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            Vector vector = new Vector();
            try {
                synchronized (this.f11922b) {
                    Iterator<b> it = this.f11921a.iterator();
                    while (it.hasNext()) {
                        vector.add(it.next());
                    }
                }
                Iterator it2 = vector.iterator();
                while (it2.hasNext()) {
                    ((b) it2.next()).b(fVar);
                }
            } catch (Throwable th) {
                if (c.a.o0.n.c.f11828a) {
                    String str = "notifyTaskEnd error:" + th.toString();
                }
            }
        }
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (this.f11922b) {
            this.f11921a.add(bVar);
        }
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null) {
            return;
        }
        synchronized (this.f11922b) {
            if (!this.f11921a.remove(bVar)) {
                this.f11921a.remove(this.f11921a.indexOf(bVar));
            }
        }
    }
}
