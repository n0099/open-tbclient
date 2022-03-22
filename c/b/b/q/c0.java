package c.b.b.q;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public class c0<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f22734b;

    /* renamed from: c  reason: collision with root package name */
    public int f22735c;

    /* renamed from: d  reason: collision with root package name */
    public int f22736d;

    /* renamed from: e  reason: collision with root package name */
    public transient a f22737e;

    /* loaded from: classes3.dex */
    public static class a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c0<T> a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f22738b;

        /* renamed from: c  reason: collision with root package name */
        public b f22739c;

        /* renamed from: d  reason: collision with root package name */
        public b f22740d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(c0<T> c0Var) {
            this(c0Var, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((c0) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (f.a) {
                    return new b(this.a, this.f22738b);
                }
                if (this.f22739c == null) {
                    this.f22739c = new b(this.a, this.f22738b);
                    this.f22740d = new b(this.a, this.f22738b);
                }
                b bVar = this.f22739c;
                if (!bVar.f22743d) {
                    bVar.f22742c = 0;
                    bVar.f22743d = true;
                    this.f22740d.f22743d = false;
                    return bVar;
                }
                b bVar2 = this.f22740d;
                bVar2.f22742c = 0;
                bVar2.f22743d = true;
                bVar.f22743d = false;
                return bVar2;
            }
            return (Iterator) invokeV.objValue;
        }

        public a(c0<T> c0Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = c0Var;
            this.f22738b = z;
        }
    }

    /* loaded from: classes3.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c0<T> a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f22741b;

        /* renamed from: c  reason: collision with root package name */
        public int f22742c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22743d;

        public b(c0<T> c0Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22743d = true;
            this.a = c0Var;
            this.f22741b = z;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f22743d) {
                    return this.f22742c < this.a.f22736d;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.f22742c;
                c0<T> c0Var = this.a;
                if (i < c0Var.f22736d) {
                    if (this.f22743d) {
                        this.f22742c = i + 1;
                        return c0Var.get(i);
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.f22742c));
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f22741b) {
                    int i = this.f22742c - 1;
                    this.f22742c = i;
                    this.a.a(i);
                    return;
                }
                throw new GdxRuntimeException("Remove not allowed.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c0() {
        this(16);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public T a(int i) {
        InterceptResult invokeI;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= 0) {
                if (i < this.f22736d) {
                    T[] tArr = this.a;
                    int i2 = this.f22734b;
                    int i3 = this.f22735c;
                    int i4 = i + i2;
                    if (i2 < i3) {
                        t = tArr[i4];
                        System.arraycopy(tArr, i4 + 1, tArr, i4, i3 - i4);
                        tArr[i3] = null;
                        this.f22735c--;
                    } else if (i4 >= tArr.length) {
                        int length = i4 - tArr.length;
                        t = tArr[length];
                        System.arraycopy(tArr, length + 1, tArr, length, i3 - length);
                        this.f22735c--;
                    } else {
                        T t2 = tArr[i4];
                        System.arraycopy(tArr, i2, tArr, i2 + 1, i4 - i2);
                        tArr[i2] = null;
                        int i5 = this.f22734b + 1;
                        this.f22734b = i5;
                        if (i5 == tArr.length) {
                            this.f22734b = 0;
                        }
                        t = t2;
                    }
                    this.f22736d--;
                    return t;
                }
                throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f22736d);
            }
            throw new IndexOutOfBoundsException("index can't be < 0: " + i);
        }
        return (T) invokeI.objValue;
    }

    public void addLast(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            T[] tArr = this.a;
            if (this.f22736d == tArr.length) {
                b(tArr.length << 1);
                tArr = this.a;
            }
            int i = this.f22735c;
            int i2 = i + 1;
            this.f22735c = i2;
            tArr[i] = t;
            if (i2 == tArr.length) {
                this.f22735c = 0;
            }
            this.f22736d++;
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            T[] tArr = this.a;
            int i2 = this.f22734b;
            int i3 = this.f22735c;
            T[] tArr2 = (T[]) ((Object[]) c.b.b.q.p0.a.a(tArr.getClass().getComponentType(), i));
            if (i2 < i3) {
                System.arraycopy(tArr, i2, tArr2, 0, i3 - i2);
            } else if (this.f22736d > 0) {
                int length = tArr.length - i2;
                System.arraycopy(tArr, i2, tArr2, 0, length);
                System.arraycopy(tArr, 0, tArr2, length, i3);
            }
            this.a = tArr2;
            this.f22734b = 0;
            this.f22735c = this.f22736d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0040 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof c0)) {
                return false;
            }
            c0 c0Var = (c0) obj;
            int i = this.f22736d;
            if (c0Var.f22736d != i) {
                return false;
            }
            T[] tArr = this.a;
            int length = tArr.length;
            T[] tArr2 = c0Var.a;
            int length2 = tArr2.length;
            int i2 = this.f22734b;
            int i3 = c0Var.f22734b;
            for (int i4 = 0; i4 < i; i4++) {
                T t = tArr[i2];
                T t2 = tArr2[i3];
                if (t == null) {
                    if (t2 != null) {
                        return false;
                    }
                    i2++;
                    i3++;
                    if (i2 == length) {
                        i2 = 0;
                    }
                    if (i3 != length2) {
                        i3 = 0;
                    }
                } else {
                    if (!t.equals(t2)) {
                        return false;
                    }
                    i2++;
                    i3++;
                    if (i2 == length) {
                    }
                    if (i3 != length2) {
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public T get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i >= 0) {
                if (i < this.f22736d) {
                    T[] tArr = this.a;
                    int i2 = this.f22734b + i;
                    if (i2 >= tArr.length) {
                        i2 -= tArr.length;
                    }
                    return tArr[i2];
                }
                throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f22736d);
            }
            throw new IndexOutOfBoundsException("index can't be < 0: " + i);
        }
        return (T) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.f22736d;
            T[] tArr = this.a;
            int length = tArr.length;
            int i2 = this.f22734b;
            int i3 = i + 1;
            for (int i4 = 0; i4 < i; i4++) {
                T t = tArr[i2];
                i3 *= 31;
                if (t != null) {
                    i3 += t.hashCode();
                }
                i2++;
                if (i2 == length) {
                    i2 = 0;
                }
            }
            return i3;
        }
        return invokeV.intValue;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (f.a) {
                return new b(this, true);
            }
            if (this.f22737e == null) {
                this.f22737e = new a(this);
            }
            return this.f22737e.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048583, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (this.f22736d == 0) {
            return "[]";
        }
        T[] tArr = this.a;
        int i = this.f22734b;
        int i2 = this.f22735c;
        j0 j0Var = new j0(64);
        j0Var.a('[');
        j0Var.m(tArr[i]);
        while (true) {
            i = (i + 1) % tArr.length;
            if (i != i2) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.m(tArr[i]);
            } else {
                j0Var.a(']');
                return j0Var.toString();
            }
        }
    }

    public c0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22734b = 0;
        this.f22735c = 0;
        this.f22736d = 0;
        this.a = (T[]) new Object[i];
    }
}
