package c.a.w.b;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import c.a.w.b.g.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f21846d = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.w.b.c.a a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f21847b;

    /* renamed from: c  reason: collision with root package name */
    public int f21848c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-985178555, "Lc/a/w/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-985178555, "Lc/a/w/b/a;");
        }
    }

    public a(Object obj, List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21848c = 0;
        b(obj, list);
    }

    public void a(long j) {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.a == null || (list = this.f21847b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (b bVar : this.f21847b) {
                this.a.b(bVar.c());
                bVar.b(j);
            }
            notifyAll();
        }
        this.a.d(j);
        this.a.e();
    }

    public final void b(Object obj, List<c> list) {
        b bVar;
        c.a.w.b.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) || list == null || list.size() == 0) {
            return;
        }
        List<b> list2 = this.f21847b;
        if (list2 == null) {
            this.f21847b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                this.f21847b.add(new b(list.get(i)));
                if (list.get(i).k()) {
                    this.f21848c = i;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = this.f21847b.size();
        int i2 = this.f21848c;
        if (size > i2) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.a = new c.a.w.b.c.a(this.f21847b.get(this.f21848c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.a = new c.a.w.b.c.a(this.f21847b.get(this.f21848c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.a = new c.a.w.b.c.a(this.f21847b.get(this.f21848c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<b> list3 = this.f21847b;
                if (list3 != null && list3 != null && (bVar = list3.get(i2)) != null && (aVar = this.a) != null) {
                    aVar.f(bVar.c());
                }
            }
        }
        for (b bVar2 : this.f21847b) {
            c.a.w.b.c.a aVar2 = this.a;
            if (aVar2 != null) {
                aVar2.b(bVar2.c());
                bVar2.f();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.w.b.c.a aVar = this.a;
            if (aVar != null) {
                aVar.g();
                this.a = null;
            }
            List<b> list = this.f21847b;
            if (list != null) {
                for (b bVar : list) {
                    bVar.e();
                }
                this.f21847b.clear();
                this.f21847b = null;
            }
        }
    }

    public void d(c.a.w.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            for (b bVar : this.f21847b) {
                c.a.w.b.c.a aVar = this.a;
                if (aVar != null) {
                    aVar.b(bVar.c());
                    bVar.g(cVar);
                }
            }
        }
    }

    public void e(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(f21846d, "updateSurfaceDrawer !!!");
            this.a.c();
            for (b bVar : this.f21847b) {
                bVar.e();
            }
            this.f21847b.clear();
            b(null, list);
        }
    }
}
