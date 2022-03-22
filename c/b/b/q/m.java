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
/* loaded from: classes3.dex */
public class m<V> implements Iterable<b<V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f22783b;

    /* renamed from: c  reason: collision with root package name */
    public V[] f22784c;

    /* renamed from: d  reason: collision with root package name */
    public V f22785d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22786e;

    /* renamed from: f  reason: collision with root package name */
    public final float f22787f;

    /* renamed from: g  reason: collision with root package name */
    public int f22788g;

    /* renamed from: h  reason: collision with root package name */
    public int f22789h;
    public int i;
    public transient a j;
    public transient a k;

    /* loaded from: classes3.dex */
    public static class a<V> extends c<V> implements Iterable<b<V>>, Iterator<b<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final b<V> f22790f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m mVar) {
            super(mVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((m) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22790f = new b<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: d */
        public b<V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a) {
                    if (this.f22795e) {
                        m<V> mVar = this.f22792b;
                        int[] iArr = mVar.f22783b;
                        int i = this.f22793c;
                        if (i == -1) {
                            b<V> bVar = this.f22790f;
                            bVar.a = 0;
                            bVar.f22791b = mVar.f22785d;
                        } else {
                            b<V> bVar2 = this.f22790f;
                            bVar2.a = iArr[i];
                            bVar2.f22791b = mVar.f22784c[i];
                        }
                        this.f22794d = this.f22793c;
                        b();
                        return this.f22790f;
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
                if (this.f22795e) {
                    return this.a;
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

    /* loaded from: classes3.dex */
    public static class b<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public V f22791b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a + "=" + this.f22791b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final m<V> f22792b;

        /* renamed from: c  reason: collision with root package name */
        public int f22793c;

        /* renamed from: d  reason: collision with root package name */
        public int f22794d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22795e;

        public c(m<V> mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22795e = true;
            this.f22792b = mVar;
            c();
        }

        public void b() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = this.f22792b.f22783b;
                int length = iArr.length;
                do {
                    i = this.f22793c + 1;
                    this.f22793c = i;
                    if (i >= length) {
                        this.a = false;
                        return;
                    }
                } while (iArr[i] == 0);
                this.a = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f22794d = -2;
                this.f22793c = -1;
                if (this.f22792b.f22786e) {
                    this.a = true;
                } else {
                    b();
                }
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.f22794d;
                if (i == -1) {
                    m<V> mVar = this.f22792b;
                    if (mVar.f22786e) {
                        mVar.f22786e = false;
                        mVar.f22785d = null;
                        this.f22794d = -2;
                        m<V> mVar2 = this.f22792b;
                        mVar2.a--;
                        return;
                    }
                }
                if (i >= 0) {
                    m<V> mVar3 = this.f22792b;
                    int[] iArr = mVar3.f22783b;
                    V[] vArr = mVar3.f22784c;
                    int i2 = mVar3.i;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        int i5 = iArr[i4];
                        if (i5 == 0) {
                            break;
                        }
                        int e2 = this.f22792b.e(i5);
                        if (((i4 - e2) & i2) > ((i - e2) & i2)) {
                            iArr[i] = i5;
                            vArr[i] = vArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    iArr[i] = 0;
                    vArr[i] = null;
                    if (i != this.f22794d) {
                        this.f22793c--;
                    }
                    this.f22794d = -2;
                    m<V> mVar22 = this.f22792b;
                    mVar22.a--;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (this.j == null) {
                this.j = new a(this);
                this.k = new a(this);
            }
            a aVar = this.j;
            if (!aVar.f22795e) {
                aVar.c();
                a<V> aVar2 = this.j;
                aVar2.f22795e = true;
                this.k.f22795e = false;
                return aVar2;
            }
            this.k.c();
            a<V> aVar3 = this.k;
            aVar3.f22795e = true;
            this.j.f22795e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public V c(int i, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, v)) == null) {
            if (i == 0) {
                return this.f22786e ? this.f22785d : v;
            }
            int d2 = d(i);
            return d2 >= 0 ? this.f22784c[d2] : v;
        }
        return (V) invokeIL.objValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) != null) {
            return invokeI.intValue;
        }
        int[] iArr = this.f22783b;
        int e2 = e(i);
        while (true) {
            int i2 = iArr[e2];
            if (i2 == 0) {
                return -(e2 + 1);
            }
            if (i2 == i) {
                return e2;
            }
            e2 = (e2 + 1) & this.i;
        }
    }

    public int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? (int) ((i * (-7046029254386353131L)) >>> this.f22789h) : invokeI.intValue;
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
                if (mVar.a != this.a) {
                    return false;
                }
                boolean z = mVar.f22786e;
                boolean z2 = this.f22786e;
                if (z != z2) {
                    return false;
                }
                if (z2) {
                    V v = mVar.f22785d;
                    if (v == null) {
                        if (this.f22785d != null) {
                            return false;
                        }
                    } else if (!v.equals(this.f22785d)) {
                        return false;
                    }
                }
                int[] iArr = this.f22783b;
                V[] vArr = this.f22784c;
                int length = iArr.length;
                for (int i = 0; i < length; i++) {
                    int i2 = iArr[i];
                    if (i2 != 0) {
                        V v2 = vArr[i];
                        if (v2 == null) {
                            if (mVar.c(i2, w.n) != null) {
                                return false;
                            }
                        } else if (!v2.equals(mVar.get(i2))) {
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

    public V f(int i, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, v)) == null) {
            if (i == 0) {
                V v2 = this.f22785d;
                this.f22785d = v;
                if (!this.f22786e) {
                    this.f22786e = true;
                    this.a++;
                }
                return v2;
            }
            int d2 = d(i);
            if (d2 >= 0) {
                V[] vArr = this.f22784c;
                V v3 = vArr[d2];
                vArr[d2] = v;
                return v3;
            }
            int i2 = -(d2 + 1);
            int[] iArr = this.f22783b;
            iArr[i2] = i;
            this.f22784c[i2] = v;
            int i3 = this.a + 1;
            this.a = i3;
            if (i3 >= this.f22788g) {
                h(iArr.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeIL.objValue;
    }

    public final void g(int i, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, v) == null) {
            int[] iArr = this.f22783b;
            int e2 = e(i);
            while (iArr[e2] != 0) {
                e2 = (e2 + 1) & this.i;
            }
            iArr[e2] = i;
            this.f22784c[e2] = v;
        }
    }

    public V get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i == 0) {
                if (this.f22786e) {
                    return this.f22785d;
                }
                return null;
            }
            int d2 = d(i);
            if (d2 >= 0) {
                return this.f22784c[d2];
            }
            return null;
        }
        return (V) invokeI.objValue;
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int length = this.f22783b.length;
            this.f22788g = (int) (i * this.f22787f);
            int i2 = i - 1;
            this.i = i2;
            this.f22789h = Long.numberOfLeadingZeros(i2);
            int[] iArr = this.f22783b;
            V[] vArr = this.f22784c;
            this.f22783b = new int[i];
            this.f22784c = (V[]) new Object[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i3];
                    if (i4 != 0) {
                        g(i4, vArr[i3]);
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
            int i = this.a;
            if (this.f22786e && (v = this.f22785d) != null) {
                i += v.hashCode();
            }
            int[] iArr = this.f22783b;
            V[] vArr = this.f22784c;
            int length = iArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = iArr[i2];
                if (i3 != 0) {
                    i += i3 * 31;
                    V v2 = vArr[i2];
                    if (v2 != null) {
                        i += v2.hashCode();
                    }
                }
            }
            return i;
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048587, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (this.a == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        int[] iArr = this.f22783b;
        V[] vArr = this.f22784c;
        int length = iArr.length;
        if (this.f22786e) {
            sb.append("0=");
            sb.append(this.f22785d);
            i = length - 1;
            if (length > 0) {
                int i2 = iArr[i];
                if (i2 != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(i2);
                    sb.append('=');
                    sb.append(vArr[i]);
                }
                length = i;
                i = length - 1;
                if (length > 0) {
                }
            } else {
                sb.append(']');
                return sb.toString();
            }
        } else {
            while (true) {
                i = length - 1;
                if (length > 0) {
                    int i3 = iArr[i];
                    if (i3 != 0) {
                        sb.append(i3);
                        sb.append('=');
                        sb.append(vArr[i]);
                        break;
                    }
                    length = i;
                } else {
                    break;
                }
            }
            length = i;
            i = length - 1;
            if (length > 0) {
            }
        }
    }

    public m(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f22787f = f2;
            int h2 = x.h(i, f2);
            this.f22788g = (int) (h2 * f2);
            int i4 = h2 - 1;
            this.i = i4;
            this.f22789h = Long.numberOfLeadingZeros(i4);
            this.f22783b = new int[h2];
            this.f22784c = (V[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
