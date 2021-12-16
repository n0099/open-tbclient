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
/* loaded from: classes9.dex */
public class m<V> implements Iterable<b<V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f28218e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f28219f;

    /* renamed from: g  reason: collision with root package name */
    public V[] f28220g;

    /* renamed from: h  reason: collision with root package name */
    public V f28221h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28222i;

    /* renamed from: j  reason: collision with root package name */
    public final float f28223j;

    /* renamed from: k  reason: collision with root package name */
    public int f28224k;
    public int l;
    public int m;
    public transient a n;
    public transient a o;

    /* loaded from: classes9.dex */
    public static class a<V> extends c<V> implements Iterable<b<V>>, Iterator<b<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final b<V> f28225j;

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
            this.f28225j = new b<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: d */
        public b<V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f28227e) {
                    if (this.f28231i) {
                        m<V> mVar = this.f28228f;
                        int[] iArr = mVar.f28219f;
                        int i2 = this.f28229g;
                        if (i2 == -1) {
                            b<V> bVar = this.f28225j;
                            bVar.a = 0;
                            bVar.f28226b = mVar.f28221h;
                        } else {
                            b<V> bVar2 = this.f28225j;
                            bVar2.a = iArr[i2];
                            bVar2.f28226b = mVar.f28220g[i2];
                        }
                        this.f28230h = this.f28229g;
                        b();
                        return this.f28225j;
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
                if (this.f28231i) {
                    return this.f28227e;
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

    /* loaded from: classes9.dex */
    public static class b<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public V f28226b;

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
                return this.a + "=" + this.f28226b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f28227e;

        /* renamed from: f  reason: collision with root package name */
        public final m<V> f28228f;

        /* renamed from: g  reason: collision with root package name */
        public int f28229g;

        /* renamed from: h  reason: collision with root package name */
        public int f28230h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f28231i;

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
            this.f28231i = true;
            this.f28228f = mVar;
            c();
        }

        public void b() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = this.f28228f.f28219f;
                int length = iArr.length;
                do {
                    i2 = this.f28229g + 1;
                    this.f28229g = i2;
                    if (i2 >= length) {
                        this.f28227e = false;
                        return;
                    }
                } while (iArr[i2] == 0);
                this.f28227e = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f28230h = -2;
                this.f28229g = -1;
                if (this.f28228f.f28222i) {
                    this.f28227e = true;
                } else {
                    b();
                }
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.f28230h;
                if (i2 == -1) {
                    m<V> mVar = this.f28228f;
                    if (mVar.f28222i) {
                        mVar.f28222i = false;
                        mVar.f28221h = null;
                        this.f28230h = -2;
                        m<V> mVar2 = this.f28228f;
                        mVar2.f28218e--;
                        return;
                    }
                }
                if (i2 >= 0) {
                    m<V> mVar3 = this.f28228f;
                    int[] iArr = mVar3.f28219f;
                    V[] vArr = mVar3.f28220g;
                    int i3 = mVar3.m;
                    int i4 = i2 + 1;
                    while (true) {
                        int i5 = i4 & i3;
                        int i6 = iArr[i5];
                        if (i6 == 0) {
                            break;
                        }
                        int e2 = this.f28228f.e(i6);
                        if (((i5 - e2) & i3) > ((i2 - e2) & i3)) {
                            iArr[i2] = i6;
                            vArr[i2] = vArr[i5];
                            i2 = i5;
                        }
                        i4 = i5 + 1;
                    }
                    iArr[i2] = 0;
                    vArr[i2] = null;
                    if (i2 != this.f28230h) {
                        this.f28229g--;
                    }
                    this.f28230h = -2;
                    m<V> mVar22 = this.f28228f;
                    mVar22.f28218e--;
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
            if (!aVar.f28231i) {
                aVar.c();
                a<V> aVar2 = this.n;
                aVar2.f28231i = true;
                this.o.f28231i = false;
                return aVar2;
            }
            this.o.c();
            a<V> aVar3 = this.o;
            aVar3.f28231i = true;
            this.n.f28231i = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public V c(int i2, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, v)) == null) {
            if (i2 == 0) {
                return this.f28222i ? this.f28221h : v;
            }
            int d2 = d(i2);
            return d2 >= 0 ? this.f28220g[d2] : v;
        }
        return (V) invokeIL.objValue;
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) != null) {
            return invokeI.intValue;
        }
        int[] iArr = this.f28219f;
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
                if (mVar.f28218e != this.f28218e) {
                    return false;
                }
                boolean z = mVar.f28222i;
                boolean z2 = this.f28222i;
                if (z != z2) {
                    return false;
                }
                if (z2) {
                    V v = mVar.f28221h;
                    if (v == null) {
                        if (this.f28221h != null) {
                            return false;
                        }
                    } else if (!v.equals(this.f28221h)) {
                        return false;
                    }
                }
                int[] iArr = this.f28219f;
                V[] vArr = this.f28220g;
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
                V v2 = this.f28221h;
                this.f28221h = v;
                if (!this.f28222i) {
                    this.f28222i = true;
                    this.f28218e++;
                }
                return v2;
            }
            int d2 = d(i2);
            if (d2 >= 0) {
                V[] vArr = this.f28220g;
                V v3 = vArr[d2];
                vArr[d2] = v;
                return v3;
            }
            int i3 = -(d2 + 1);
            int[] iArr = this.f28219f;
            iArr[i3] = i2;
            this.f28220g[i3] = v;
            int i4 = this.f28218e + 1;
            this.f28218e = i4;
            if (i4 >= this.f28224k) {
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
            int[] iArr = this.f28219f;
            int e2 = e(i2);
            while (iArr[e2] != 0) {
                e2 = (e2 + 1) & this.m;
            }
            iArr[e2] = i2;
            this.f28220g[e2] = v;
        }
    }

    public V get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 == 0) {
                if (this.f28222i) {
                    return this.f28221h;
                }
                return null;
            }
            int d2 = d(i2);
            if (d2 >= 0) {
                return this.f28220g[d2];
            }
            return null;
        }
        return (V) invokeI.objValue;
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            int length = this.f28219f.length;
            this.f28224k = (int) (i2 * this.f28223j);
            int i3 = i2 - 1;
            this.m = i3;
            this.l = Long.numberOfLeadingZeros(i3);
            int[] iArr = this.f28219f;
            V[] vArr = this.f28220g;
            this.f28219f = new int[i2];
            this.f28220g = (V[]) new Object[i2];
            if (this.f28218e > 0) {
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
            int i2 = this.f28218e;
            if (this.f28222i && (v = this.f28221h) != null) {
                i2 += v.hashCode();
            }
            int[] iArr = this.f28219f;
            V[] vArr = this.f28220g;
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
        if (this.f28218e == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        int[] iArr = this.f28219f;
        V[] vArr = this.f28220g;
        int length = iArr.length;
        if (this.f28222i) {
            sb.append("0=");
            sb.append(this.f28221h);
            i2 = length - 1;
            if (length > 0) {
                int i3 = iArr[i2];
                if (i3 != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(i3);
                    sb.append(com.alipay.sdk.encrypt.a.f31721h);
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
                        sb.append(com.alipay.sdk.encrypt.a.f31721h);
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
            this.f28223j = f2;
            int h2 = x.h(i2, f2);
            this.f28224k = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.m = i5;
            this.l = Long.numberOfLeadingZeros(i5);
            this.f28219f = new int[h2];
            this.f28220g = (V[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
