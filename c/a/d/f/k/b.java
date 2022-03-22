package c.a.d.f.k;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f2201b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f2202c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f2203d;

    public b(c<T> cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 10;
        this.f2201b = 0;
        this.f2202c = null;
        this.f2203d = null;
        if (cVar != null && i > 0 && i2 <= i) {
            this.f2203d = cVar;
            this.a = i;
            this.f2201b = i2;
            this.f2202c = new LinkedList<>();
            a(this.f2201b);
            return;
        }
        throw new InvalidParameterException("invalid params");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.util.LinkedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            synchronized (this) {
                for (int i2 = 0; i2 < i; i2++) {
                    Object obj = null;
                    try {
                        obj = this.f2203d.a(this.f2203d.d());
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    if (obj != null) {
                        this.f2202c.offer(obj);
                    }
                }
            }
        }
    }

    public T b() {
        InterceptResult invokeV;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                t = null;
                try {
                    if (this.f2202c.size() > 0) {
                        t = this.f2203d.a(this.f2202c.poll());
                    } else {
                        t = this.f2203d.a(this.f2203d.d());
                    }
                    a(this.f2201b - this.f2202c.size());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f2202c.clear();
            }
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this) {
                for (int i2 = 0; i2 < i; i2++) {
                    try {
                        this.f2203d.b(this.f2202c.poll());
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        }
    }

    public void e(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
            synchronized (this) {
                if (this.f2202c.size() < this.a) {
                    T t2 = null;
                    try {
                        t2 = this.f2203d.c(t);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    if (t2 != null) {
                        this.f2202c.offer(t2);
                    }
                } else {
                    this.f2203d.b(t);
                }
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            synchronized (this) {
                if (i < this.f2201b) {
                    i = this.f2201b;
                }
                if (i <= 0) {
                    i = 1;
                }
                this.a = i;
                d(this.f2202c.size() - this.a);
            }
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            synchronized (this) {
                if (i > this.a) {
                    i = this.a;
                }
                this.f2201b = i;
                a(i - this.f2202c.size());
            }
        }
    }
}
