package c.a.e.e.k;

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
    public int f2314a;

    /* renamed from: b  reason: collision with root package name */
    public int f2315b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f2316c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f2317d;

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
        this.f2314a = 10;
        this.f2315b = 0;
        this.f2316c = null;
        this.f2317d = null;
        if (cVar != null && i2 > 0 && i3 <= i2) {
            this.f2317d = cVar;
            this.f2314a = i2;
            this.f2315b = i3;
            this.f2316c = new LinkedList<>();
            a(this.f2315b);
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
                        obj = this.f2317d.a(this.f2317d.d());
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    if (obj != null) {
                        this.f2316c.offer(obj);
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
                    if (this.f2316c.size() > 0) {
                        t = this.f2317d.a(this.f2316c.poll());
                    } else {
                        t = this.f2317d.a(this.f2317d.d());
                    }
                    a(this.f2315b - this.f2316c.size());
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
                this.f2316c.clear();
            }
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (this) {
                for (int i3 = 0; i3 < i2; i3++) {
                    try {
                        this.f2317d.b(this.f2316c.poll());
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
                if (this.f2316c.size() < this.f2314a) {
                    T t2 = null;
                    try {
                        t2 = this.f2317d.c(t);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    if (t2 != null) {
                        this.f2316c.offer(t2);
                    }
                } else {
                    this.f2317d.b(t);
                }
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            synchronized (this) {
                if (i2 < this.f2315b) {
                    i2 = this.f2315b;
                }
                if (i2 <= 0) {
                    i2 = 1;
                }
                this.f2314a = i2;
                d(this.f2316c.size() - this.f2314a);
            }
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            synchronized (this) {
                if (i2 > this.f2314a) {
                    i2 = this.f2314a;
                }
                this.f2315b = i2;
                a(i2 - this.f2316c.size());
            }
        }
    }
}
