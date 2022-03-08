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
/* loaded from: classes3.dex */
public class b<E> implements Iterable<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<E> f25857e;

    /* renamed from: f  reason: collision with root package name */
    public int f25858f;

    /* renamed from: g  reason: collision with root package name */
    public int f25859g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25860h;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.s0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1577b implements Object<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f25861e;

        /* renamed from: f  reason: collision with root package name */
        public int f25862f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f25863g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f25864h;

        public /* synthetic */ C1577b(b bVar, a aVar) {
            this(bVar);
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25863g) {
                return;
            }
            this.f25863g = true;
            this.f25864h.h();
        }

        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.f25862f;
                while (i2 < this.f25861e && this.f25864h.i(i2) == null) {
                    i2++;
                }
                if (i2 < this.f25861e) {
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
                    int i2 = this.f25862f;
                    if (i2 >= this.f25861e || this.f25864h.i(i2) != null) {
                        break;
                    }
                    this.f25862f++;
                }
                int i3 = this.f25862f;
                if (i3 < this.f25861e) {
                    b bVar = this.f25864h;
                    this.f25862f = i3 + 1;
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

        public C1577b(b bVar) {
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
            this.f25864h = bVar;
            this.f25862f = 0;
            this.f25863g = false;
            bVar.j();
            this.f25861e = bVar.f();
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
        this.f25857e = new ArrayList();
        this.f25858f = 0;
        this.f25859g = 0;
        this.f25860h = false;
    }

    public boolean e(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            if (e2 == null || this.f25857e.contains(e2)) {
                return false;
            }
            this.f25857e.add(e2);
            this.f25859g++;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25857e.size() : invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int size = this.f25857e.size() - 1; size >= 0; size--) {
                if (this.f25857e.get(size) == null) {
                    this.f25857e.remove(size);
                }
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.f25858f - 1;
            this.f25858f = i2;
            if (i2 <= 0 && this.f25860h) {
                this.f25860h = false;
                g();
            }
        }
    }

    public final E i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f25857e.get(i2) : (E) invokeI.objValue;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new C1577b(this, null) : (Iterator) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f25858f++;
        }
    }

    public boolean k(E e2) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e2)) == null) {
            if (e2 == null || (indexOf = this.f25857e.indexOf(e2)) == -1) {
                return false;
            }
            if (this.f25858f == 0) {
                this.f25857e.remove(indexOf);
            } else {
                this.f25860h = true;
                this.f25857e.set(indexOf, null);
            }
            this.f25859g--;
            return true;
        }
        return invokeL.booleanValue;
    }
}
