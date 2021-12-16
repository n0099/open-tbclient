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
/* loaded from: classes9.dex */
public class c0<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public T[] f28164e;

    /* renamed from: f  reason: collision with root package name */
    public int f28165f;

    /* renamed from: g  reason: collision with root package name */
    public int f28166g;

    /* renamed from: h  reason: collision with root package name */
    public int f28167h;

    /* renamed from: i  reason: collision with root package name */
    public transient a f28168i;

    /* loaded from: classes9.dex */
    public static class a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c0<T> f28169e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f28170f;

        /* renamed from: g  reason: collision with root package name */
        public b f28171g;

        /* renamed from: h  reason: collision with root package name */
        public b f28172h;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(c0<T> c0Var) {
            this(c0Var, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    return new b(this.f28169e, this.f28170f);
                }
                if (this.f28171g == null) {
                    this.f28171g = new b(this.f28169e, this.f28170f);
                    this.f28172h = new b(this.f28169e, this.f28170f);
                }
                b bVar = this.f28171g;
                if (!bVar.f28176h) {
                    bVar.f28175g = 0;
                    bVar.f28176h = true;
                    this.f28172h.f28176h = false;
                    return bVar;
                }
                b bVar2 = this.f28172h;
                bVar2.f28175g = 0;
                bVar2.f28176h = true;
                bVar.f28176h = false;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28169e = c0Var;
            this.f28170f = z;
        }
    }

    /* loaded from: classes9.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c0<T> f28173e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f28174f;

        /* renamed from: g  reason: collision with root package name */
        public int f28175g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f28176h;

        public b(c0<T> c0Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28176h = true;
            this.f28173e = c0Var;
            this.f28174f = z;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f28176h) {
                    return this.f28175g < this.f28173e.f28167h;
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
                int i2 = this.f28175g;
                c0<T> c0Var = this.f28173e;
                if (i2 < c0Var.f28167h) {
                    if (this.f28176h) {
                        this.f28175g = i2 + 1;
                        return c0Var.get(i2);
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.f28175g));
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f28174f) {
                    int i2 = this.f28175g - 1;
                    this.f28175g = i2;
                    this.f28173e.a(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public T a(int i2) {
        InterceptResult invokeI;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= 0) {
                if (i2 < this.f28167h) {
                    T[] tArr = this.f28164e;
                    int i3 = this.f28165f;
                    int i4 = this.f28166g;
                    int i5 = i2 + i3;
                    if (i3 < i4) {
                        t = tArr[i5];
                        System.arraycopy(tArr, i5 + 1, tArr, i5, i4 - i5);
                        tArr[i4] = null;
                        this.f28166g--;
                    } else if (i5 >= tArr.length) {
                        int length = i5 - tArr.length;
                        t = tArr[length];
                        System.arraycopy(tArr, length + 1, tArr, length, i4 - length);
                        this.f28166g--;
                    } else {
                        T t2 = tArr[i5];
                        System.arraycopy(tArr, i3, tArr, i3 + 1, i5 - i3);
                        tArr[i3] = null;
                        int i6 = this.f28165f + 1;
                        this.f28165f = i6;
                        if (i6 == tArr.length) {
                            this.f28165f = 0;
                        }
                        t = t2;
                    }
                    this.f28167h--;
                    return t;
                }
                throw new IndexOutOfBoundsException("index can't be >= size: " + i2 + " >= " + this.f28167h);
            }
            throw new IndexOutOfBoundsException("index can't be < 0: " + i2);
        }
        return (T) invokeI.objValue;
    }

    public void addLast(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            T[] tArr = this.f28164e;
            if (this.f28167h == tArr.length) {
                b(tArr.length << 1);
                tArr = this.f28164e;
            }
            int i2 = this.f28166g;
            int i3 = i2 + 1;
            this.f28166g = i3;
            tArr[i2] = t;
            if (i3 == tArr.length) {
                this.f28166g = 0;
            }
            this.f28167h++;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            T[] tArr = this.f28164e;
            int i3 = this.f28165f;
            int i4 = this.f28166g;
            T[] tArr2 = (T[]) ((Object[]) c.b.b.q.p0.a.a(tArr.getClass().getComponentType(), i2));
            if (i3 < i4) {
                System.arraycopy(tArr, i3, tArr2, 0, i4 - i3);
            } else if (this.f28167h > 0) {
                int length = tArr.length - i3;
                System.arraycopy(tArr, i3, tArr2, 0, length);
                System.arraycopy(tArr, 0, tArr2, length, i4);
            }
            this.f28164e = tArr2;
            this.f28165f = 0;
            this.f28166g = this.f28167h;
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
            int i2 = this.f28167h;
            if (c0Var.f28167h != i2) {
                return false;
            }
            T[] tArr = this.f28164e;
            int length = tArr.length;
            T[] tArr2 = c0Var.f28164e;
            int length2 = tArr2.length;
            int i3 = this.f28165f;
            int i4 = c0Var.f28165f;
            for (int i5 = 0; i5 < i2; i5++) {
                T t = tArr[i3];
                T t2 = tArr2[i4];
                if (t == null) {
                    if (t2 != null) {
                        return false;
                    }
                    i3++;
                    i4++;
                    if (i3 == length) {
                        i3 = 0;
                    }
                    if (i4 != length2) {
                        i4 = 0;
                    }
                } else {
                    if (!t.equals(t2)) {
                        return false;
                    }
                    i3++;
                    i4++;
                    if (i3 == length) {
                    }
                    if (i4 != length2) {
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public T get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 >= 0) {
                if (i2 < this.f28167h) {
                    T[] tArr = this.f28164e;
                    int i3 = this.f28165f + i2;
                    if (i3 >= tArr.length) {
                        i3 -= tArr.length;
                    }
                    return tArr[i3];
                }
                throw new IndexOutOfBoundsException("index can't be >= size: " + i2 + " >= " + this.f28167h);
            }
            throw new IndexOutOfBoundsException("index can't be < 0: " + i2);
        }
        return (T) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.f28167h;
            T[] tArr = this.f28164e;
            int length = tArr.length;
            int i3 = this.f28165f;
            int i4 = i2 + 1;
            for (int i5 = 0; i5 < i2; i5++) {
                T t = tArr[i3];
                i4 *= 31;
                if (t != null) {
                    i4 += t.hashCode();
                }
                i3++;
                if (i3 == length) {
                    i3 = 0;
                }
            }
            return i4;
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
            if (this.f28168i == null) {
                this.f28168i = new a(this);
            }
            return this.f28168i.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048583, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (this.f28167h == 0) {
            return "[]";
        }
        T[] tArr = this.f28164e;
        int i2 = this.f28165f;
        int i3 = this.f28166g;
        j0 j0Var = new j0(64);
        j0Var.a('[');
        j0Var.m(tArr[i2]);
        while (true) {
            i2 = (i2 + 1) % tArr.length;
            if (i2 != i3) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.m(tArr[i2]);
            } else {
                j0Var.a(']');
                return j0Var.toString();
            }
        }
    }

    public c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28165f = 0;
        this.f28166g = 0;
        this.f28167h = 0;
        this.f28164e = (T[]) new Object[i2];
    }
}
