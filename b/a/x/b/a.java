package b.a.x.b;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import b.a.x.b.g.c;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.x.b.c.a f29365a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f29366b;

    /* renamed from: c  reason: collision with root package name */
    public int f29367c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-760035899, "Lb/a/x/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-760035899, "Lb/a/x/b/a;");
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
        this.f29367c = 0;
        b(obj, list);
    }

    public void a(long j) {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.f29365a == null || (list = this.f29366b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (b bVar : this.f29366b) {
                this.f29365a.b(bVar.c());
                bVar.b(j);
            }
            notifyAll();
        }
        this.f29365a.d(j);
        this.f29365a.e();
    }

    public final void b(Object obj, List<c> list) {
        b bVar;
        b.a.x.b.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) || list == null || list.size() == 0) {
            return;
        }
        List<b> list2 = this.f29366b;
        if (list2 == null) {
            this.f29366b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                this.f29366b.add(new b(list.get(i2)));
                if (list.get(i2).l()) {
                    this.f29367c = i2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = this.f29366b.size();
        int i3 = this.f29367c;
        if (size > i3) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.f29365a = new b.a.x.b.c.a(this.f29366b.get(this.f29367c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.f29365a = new b.a.x.b.c.a(this.f29366b.get(this.f29367c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.f29365a = new b.a.x.b.c.a(this.f29366b.get(this.f29367c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<b> list3 = this.f29366b;
                if (list3 != null && list3 != null && (bVar = list3.get(i3)) != null && (aVar = this.f29365a) != null) {
                    aVar.f(bVar.c());
                }
            }
        }
        for (b bVar2 : this.f29366b) {
            b.a.x.b.c.a aVar2 = this.f29365a;
            if (aVar2 != null) {
                aVar2.b(bVar2.c());
                bVar2.f();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.x.b.c.a aVar = this.f29365a;
            if (aVar != null) {
                aVar.g();
                this.f29365a = null;
            }
            List<b> list = this.f29366b;
            if (list != null) {
                for (b bVar : list) {
                    bVar.e();
                }
                this.f29366b.clear();
                this.f29366b = null;
            }
        }
    }

    public void d(b.a.x.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            for (b bVar : this.f29366b) {
                b.a.x.b.c.a aVar = this.f29365a;
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
            this.f29365a.c();
            for (b bVar : this.f29366b) {
                bVar.e();
            }
            this.f29366b.clear();
            b(null, list);
        }
    }
}
