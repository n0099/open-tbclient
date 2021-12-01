package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes7.dex */
public class m<V> implements Iterable<b<V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f27843e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f27844f;

    /* renamed from: g  reason: collision with root package name */
    public V[] f27845g;

    /* renamed from: h  reason: collision with root package name */
    public V f27846h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27847i;

    /* renamed from: j  reason: collision with root package name */
    public final float f27848j;

    /* renamed from: k  reason: collision with root package name */
    public int f27849k;
    public int l;
    public int m;
    public transient a n;
    public transient a o;

    /* loaded from: classes7.dex */
    public static class a<V> extends c<V> implements Iterable<b<V>>, Iterator<b<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final b<V> f27850j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m mVar) {
            super(mVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((m) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27850j = new b<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: d */
        public b<V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f27852e) {
                    if (this.f27856i) {
                        m<V> mVar = this.f27853f;
                        int[] iArr = mVar.f27844f;
                        int i2 = this.f27854g;
                        if (i2 == -1) {
                            b<V> bVar = this.f27850j;
                            bVar.a = 0;
                            bVar.f27851b = mVar.f27846h;
                        } else {
                            b<V> bVar2 = this.f27850j;
                            bVar2.a = iArr[i2];
                            bVar2.f27851b = mVar.f27845g[i2];
                        }
                        this.f27855h = this.f27854g;
                        b();
                        return this.f27850j;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (b) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f27856i) {
                    return this.f27852e;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public Iterator<b<V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public V f27851b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a + "=" + this.f27851b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27852e;

        /* renamed from: f  reason: collision with root package name */
        public final m<V> f27853f;

        /* renamed from: g  reason: collision with root package name */
        public int f27854g;

        /* renamed from: h  reason: collision with root package name */
        public int f27855h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f27856i;

        public c(m<V> mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27856i = true;
            this.f27853f = mVar;
            c();
        }

        public void b() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = this.f27853f.f27844f;
                int length = iArr.length;
                do {
                    i2 = this.f27854g + 1;
                    this.f27854g = i2;
                    if (i2 >= length) {
                        this.f27852e = false;
                        return;
                    }
                } while (iArr[i2] == 0);
                this.f27852e = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f27855h = -2;
                this.f27854g = -1;
                if (this.f27853f.f27847i) {
                    this.f27852e = true;
                } else {
                    b();
                }
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.f27855h;
                if (i2 == -1) {
                    m<V> mVar = this.f27853f;
                    if (mVar.f27847i) {
                        mVar.f27847i = false;
                        mVar.f27846h = null;
                        this.f27855h = -2;
                        m<V> mVar2 = this.f27853f;
                        mVar2.f27843e--;
                        return;
                    }
                }
                if (i2 >= 0) {
                    m<V> mVar3 = this.f27853f;
                    int[] iArr = mVar3.f27844f;
                    V[] vArr = mVar3.f27845g;
                    int i3 = mVar3.m;
                    int i4 = i2 + 1;
                    while (true) {
                        int i5 = i4 & i3;
                        int i6 = iArr[i5];
                        if (i6 == 0) {
                            break;
                        }
                        int e2 = this.f27853f.e(i6);
                        if (((i5 - e2) & i3) > ((i2 - e2) & i3)) {
                            iArr[i2] = i6;
                            vArr[i2] = vArr[i5];
                            i2 = i5;
                        }
                        i4 = i5 + 1;
                    }
                    iArr[i2] = 0;
                    vArr[i2] = null;
                    if (i2 != this.f27855h) {
                        this.f27854g--;
                    }
                    this.f27855h = -2;
                    m<V> mVar22 = this.f27853f;
                    mVar22.f27843e--;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m() {
        this(51, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a<V> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f.a) {
                return new a<>(this);
            }
            if (this.n == null) {
                this.n = new a(this);
                this.o = new a(this);
            }
            a aVar = this.n;
            if (!aVar.f27856i) {
                aVar.c();
                a<V> aVar2 = this.n;
                aVar2.f27856i = true;
                this.o.f27856i = false;
                return aVar2;
            }
            this.o.c();
            a<V> aVar3 = this.o;
            aVar3.f27856i = true;
            this.n.f27856i = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public V c(int i2, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, v)) == null) {
            if (i2 == 0) {
                return this.f27847i ? this.f27846h : v;
            }
            int d2 = d(i2);
            return d2 >= 0 ? this.f27845g[d2] : v;
        }
        return (V) invokeIL.objValue;
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) != null) {
            return invokeI.intValue;
        }
        int[] iArr = this.f27844f;
        int e2 = e(i2);
        while (true) {
            int i3 = iArr[e2];
            if (i3 == 0) {
                return -(e2 + 1);
            }
            if (i3 == i2) {
                return e2;
            }
            e2 = (e2 + 1) & this.m;
        }
    }

    public int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? (int) ((i2 * (-7046029254386353131L)) >>> this.l) : invokeI.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v1, resolved type: c.b.b.q.m */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof m) {
                m mVar = (m) obj;
                if (mVar.f27843e != this.f27843e) {
                    return false;
                }
                boolean z = mVar.f27847i;
                boolean z2 = this.f27847i;
                if (z != z2) {
                    return false;
                }
                if (z2) {
                    V v = mVar.f27846h;
                    if (v == null) {
                        if (this.f27846h != null) {
                            return false;
                        }
                    } else if (!v.equals(this.f27846h)) {
                        return false;
                    }
                }
                int[] iArr = this.f27844f;
                V[] vArr = this.f27845g;
                int length = iArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = iArr[i2];
                    if (i3 != 0) {
                        V v2 = vArr[i2];
                        if (v2 == null) {
                            if (mVar.c(i3, w.r) != null) {
                                return false;
                            }
                        } else if (!v2.equals(mVar.get(i3))) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public V f(int i2, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, v)) == null) {
            if (i2 == 0) {
                V v2 = this.f27846h;
                this.f27846h = v;
                if (!this.f27847i) {
                    this.f27847i = true;
                    this.f27843e++;
                }
                return v2;
            }
            int d2 = d(i2);
            if (d2 >= 0) {
                V[] vArr = this.f27845g;
                V v3 = vArr[d2];
                vArr[d2] = v;
                return v3;
            }
            int i3 = -(d2 + 1);
            int[] iArr = this.f27844f;
            iArr[i3] = i2;
            this.f27845g[i3] = v;
            int i4 = this.f27843e + 1;
            this.f27843e = i4;
            if (i4 >= this.f27849k) {
                h(iArr.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeIL.objValue;
    }

    public final void g(int i2, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, v) == null) {
            int[] iArr = this.f27844f;
            int e2 = e(i2);
            while (iArr[e2] != 0) {
                e2 = (e2 + 1) & this.m;
            }
            iArr[e2] = i2;
            this.f27845g[e2] = v;
        }
    }

    public V get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 == 0) {
                if (this.f27847i) {
                    return this.f27846h;
                }
                return null;
            }
            int d2 = d(i2);
            if (d2 >= 0) {
                return this.f27845g[d2];
            }
            return null;
        }
        return (V) invokeI.objValue;
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            int length = this.f27844f.length;
            this.f27849k = (int) (i2 * this.f27848j);
            int i3 = i2 - 1;
            this.m = i3;
            this.l = Long.numberOfLeadingZeros(i3);
            int[] iArr = this.f27844f;
            V[] vArr = this.f27845g;
            this.f27844f = new int[i2];
            this.f27845g = (V[]) new Object[i2];
            if (this.f27843e > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr[i4];
                    if (i5 != 0) {
                        g(i5, vArr[i4]);
                    }
                }
            }
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f27843e;
            if (this.f27847i && (v = this.f27846h) != null) {
                i2 += v.hashCode();
            }
            int[] iArr = this.f27844f;
            V[] vArr = this.f27845g;
            int length = iArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = iArr[i3];
                if (i4 != 0) {
                    i2 += i4 * 31;
                    V v2 = vArr[i3];
                    if (v2 != null) {
                        i2 += v2.hashCode();
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // java.lang.Iterable
    public Iterator<b<V>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? b() : (Iterator) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0042 -> B:18:0x0043). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048587, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (this.f27843e == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        int[] iArr = this.f27844f;
        V[] vArr = this.f27845g;
        int length = iArr.length;
        if (this.f27847i) {
            sb.append("0=");
            sb.append(this.f27846h);
            i2 = length - 1;
            if (length > 0) {
                int i3 = iArr[i2];
                if (i3 != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(i3);
                    sb.append(com.alipay.sdk.encrypt.a.f31351h);
                    sb.append(vArr[i2]);
                }
                length = i2;
                i2 = length - 1;
                if (length > 0) {
                }
            } else {
                sb.append(']');
                return sb.toString();
            }
        } else {
            while (true) {
                i2 = length - 1;
                if (length > 0) {
                    int i4 = iArr[i2];
                    if (i4 != 0) {
                        sb.append(i4);
                        sb.append(com.alipay.sdk.encrypt.a.f31351h);
                        sb.append(vArr[i2]);
                        break;
                    }
                    length = i2;
                } else {
                    break;
                }
            }
            length = i2;
            i2 = length - 1;
            if (length > 0) {
            }
        }
    }

    public m(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f27848j = f2;
            int h2 = x.h(i2, f2);
            this.f27849k = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.m = i5;
            this.l = Long.numberOfLeadingZeros(i5);
            this.f27844f = new int[h2];
            this.f27845g = (V[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
