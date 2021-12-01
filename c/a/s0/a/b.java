package c.a.s0.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes7.dex */
public class b<E> implements Iterable<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<E> f26081e;

    /* renamed from: f  reason: collision with root package name */
    public int f26082f;

    /* renamed from: g  reason: collision with root package name */
    public int f26083g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26084h;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.s0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1498b implements Object<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f26085e;

        /* renamed from: f  reason: collision with root package name */
        public int f26086f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f26087g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f26088h;

        public /* synthetic */ C1498b(b bVar, a aVar) {
            this(bVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26087g) {
                return;
            }
            this.f26087g = true;
            this.f26088h.h();
        }

        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.f26086f;
                while (i2 < this.f26085e && this.f26088h.i(i2) == null) {
                    i2++;
                }
                if (i2 < this.f26085e) {
                    return true;
                }
                a();
                return false;
            }
            return invokeV.booleanValue;
        }

        public E next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                while (true) {
                    int i2 = this.f26086f;
                    if (i2 >= this.f26085e || this.f26088h.i(i2) != null) {
                        break;
                    }
                    this.f26086f++;
                }
                int i3 = this.f26086f;
                if (i3 < this.f26085e) {
                    b bVar = this.f26088h;
                    this.f26086f = i3 + 1;
                    return (E) bVar.i(i3);
                }
                a();
                throw new NoSuchElementException();
            }
            return (E) invokeV.objValue;
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public C1498b(b bVar) {
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
            this.f26088h = bVar;
            this.f26086f = 0;
            this.f26087g = false;
            bVar.j();
            this.f26085e = bVar.f();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(252160787, "Lc/a/s0/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(252160787, "Lc/a/s0/a/b;");
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26081e = new ArrayList();
        this.f26082f = 0;
        this.f26083g = 0;
        this.f26084h = false;
    }

    public boolean e(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            if (e2 == null || this.f26081e.contains(e2)) {
                return false;
            }
            this.f26081e.add(e2);
            this.f26083g++;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26081e.size() : invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int size = this.f26081e.size() - 1; size >= 0; size--) {
                if (this.f26081e.get(size) == null) {
                    this.f26081e.remove(size);
                }
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.f26082f - 1;
            this.f26082f = i2;
            if (i2 <= 0 && this.f26084h) {
                this.f26084h = false;
                g();
            }
        }
    }

    public final E i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f26081e.get(i2) : (E) invokeI.objValue;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new C1498b(this, null) : (Iterator) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f26082f++;
        }
    }

    public boolean k(E e2) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e2)) == null) {
            if (e2 == null || (indexOf = this.f26081e.indexOf(e2)) == -1) {
                return false;
            }
            if (this.f26082f == 0) {
                this.f26081e.remove(indexOf);
            } else {
                this.f26084h = true;
                this.f26081e.set(indexOf, null);
            }
            this.f26083g--;
            return true;
        }
        return invokeL.booleanValue;
    }
}
