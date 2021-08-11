package c.a.w.b;

import android.graphics.SurfaceTexture;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.w.b.c.a f30610a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f30611b;

    /* renamed from: c  reason: collision with root package name */
    public int f30612c;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30612c = 0;
        b(obj, list);
    }

    public void a(long j2) {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) || this.f30610a == null || (list = this.f30611b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (b bVar : this.f30611b) {
                this.f30610a.b(bVar.c());
                bVar.b(j2);
            }
            notifyAll();
        }
        this.f30610a.d(j2);
        this.f30610a.e();
    }

    public final void b(Object obj, List<c> list) {
        b bVar;
        c.a.w.b.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) || list == null || list.size() == 0) {
            return;
        }
        List<b> list2 = this.f30611b;
        if (list2 == null) {
            this.f30611b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                this.f30611b.add(new b(list.get(i2)));
                if (list.get(i2).n()) {
                    this.f30612c = i2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = this.f30611b.size();
        int i3 = this.f30612c;
        if (size > i3) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.f30610a = new c.a.w.b.c.a(this.f30611b.get(this.f30612c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.f30610a = new c.a.w.b.c.a(this.f30611b.get(this.f30612c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.f30610a = new c.a.w.b.c.a(this.f30611b.get(this.f30612c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<b> list3 = this.f30611b;
                if (list3 != null && list3 != null && (bVar = list3.get(i3)) != null && (aVar = this.f30610a) != null) {
                    aVar.f(bVar.c());
                }
            }
        }
        for (b bVar2 : this.f30611b) {
            c.a.w.b.c.a aVar2 = this.f30610a;
            if (aVar2 != null) {
                aVar2.b(bVar2.c());
                bVar2.f();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.w.b.c.a aVar = this.f30610a;
            if (aVar != null) {
                aVar.g();
                this.f30610a = null;
            }
            List<b> list = this.f30611b;
            if (list != null) {
                for (b bVar : list) {
                    bVar.e();
                }
                this.f30611b.clear();
                this.f30611b = null;
            }
        }
    }

    public void d(c.a.w.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            for (b bVar : this.f30611b) {
                c.a.w.b.c.a aVar = this.f30610a;
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
            this.f30610a.c();
            for (b bVar : this.f30611b) {
                bVar.e();
            }
            this.f30611b.clear();
            b(null, list);
        }
    }
}
