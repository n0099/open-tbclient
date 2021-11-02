package b.a.e.e.k;

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

    /* renamed from: a  reason: collision with root package name */
    public int f1849a;

    /* renamed from: b  reason: collision with root package name */
    public int f1850b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f1851c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f1852d;

    public b(c<T> cVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1849a = 10;
        this.f1850b = 0;
        this.f1851c = null;
        this.f1852d = null;
        if (cVar != null && i2 > 0 && i3 <= i2) {
            this.f1852d = cVar;
            this.f1849a = i2;
            this.f1850b = i3;
            this.f1851c = new LinkedList<>();
            a(this.f1850b);
            return;
        }
        throw new InvalidParameterException("invalid params");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.util.LinkedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            synchronized (this) {
                for (int i3 = 0; i3 < i2; i3++) {
                    Object obj = null;
                    try {
                        obj = this.f1852d.a(this.f1852d.d());
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    if (obj != null) {
                        this.f1851c.offer(obj);
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
                    if (this.f1851c.size() > 0) {
                        t = this.f1852d.a(this.f1851c.poll());
                    } else {
                        t = this.f1852d.a(this.f1852d.d());
                    }
                    a(this.f1850b - this.f1851c.size());
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
                this.f1851c.clear();
            }
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (this) {
                for (int i3 = 0; i3 < i2; i3++) {
                    try {
                        this.f1852d.b(this.f1851c.poll());
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
                if (this.f1851c.size() < this.f1849a) {
                    T t2 = null;
                    try {
                        t2 = this.f1852d.c(t);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    if (t2 != null) {
                        this.f1851c.offer(t2);
                    }
                } else {
                    this.f1852d.b(t);
                }
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            synchronized (this) {
                if (i2 < this.f1850b) {
                    i2 = this.f1850b;
                }
                if (i2 <= 0) {
                    i2 = 1;
                }
                this.f1849a = i2;
                d(this.f1851c.size() - this.f1849a);
            }
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            synchronized (this) {
                if (i2 > this.f1849a) {
                    i2 = this.f1849a;
                }
                this.f1850b = i2;
                a(i2 - this.f1851c.size());
            }
        }
    }
}
