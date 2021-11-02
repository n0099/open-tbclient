package b.i.b.a.d0;

import androidx.core.view.InputDeviceCompat;
import b.i.b.a.d0.l;
import b.i.b.a.d0.q;
import b.i.b.a.i0.v;
import b.i.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class f implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final l[] f31918e;

    /* renamed from: f  reason: collision with root package name */
    public final w[] f31919f;

    /* renamed from: g  reason: collision with root package name */
    public final Object[] f31920g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<k, Integer> f31921h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean[] f31922i;
    public final boolean j;
    public final q k;
    public l.a l;
    public b m;

    /* loaded from: classes6.dex */
    public class a implements l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f31923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f31924f;

        public a(f fVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31924f = fVar;
            this.f31923e = i2;
        }

        @Override // b.i.b.a.d0.l.a
        public void c(l lVar, w wVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, lVar, wVar, obj) == null) {
                this.f31924f.h(this.f31923e, wVar, obj);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends b.i.b.a.d0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final w[] f31925d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f31926e;

        /* renamed from: f  reason: collision with root package name */
        public final int[] f31927f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f31928g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(w[] wVarArr, boolean z, q qVar) {
            super(qVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVarArr, Boolean.valueOf(z), qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((q) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int[] iArr = new int[wVarArr.length];
            int[] iArr2 = new int[wVarArr.length];
            long j = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < wVarArr.length; i5++) {
                w wVar = wVarArr[i5];
                j += wVar.h();
                b.i.b.a.i0.a.g(j <= 2147483647L, "ConcatenatingMediaSource children contain too many periods");
                iArr[i5] = (int) j;
                i4 += wVar.o();
                iArr2[i5] = i4;
            }
            this.f31925d = wVarArr;
            this.f31926e = iArr;
            this.f31927f = iArr2;
            this.f31928g = z;
        }

        @Override // b.i.b.a.d0.a, b.i.b.a.w
        public int a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                return super.a(!this.f31928g && z);
            }
            return invokeZ.intValue;
        }

        @Override // b.i.b.a.d0.a, b.i.b.a.w
        public int c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return super.c(!this.f31928g && z);
            }
            return invokeZ.intValue;
        }

        @Override // b.i.b.a.d0.a, b.i.b.a.w
        public int e(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                boolean z2 = true;
                if (this.f31928g && i3 == 1) {
                    i3 = 2;
                }
                return super.e(i2, i3, (this.f31928g || !z) ? false : false);
            }
            return invokeCommon.intValue;
        }

        @Override // b.i.b.a.w
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int[] iArr = this.f31926e;
                return iArr[iArr.length - 1];
            }
            return invokeV.intValue;
        }

        @Override // b.i.b.a.d0.a, b.i.b.a.w
        public int k(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                boolean z2 = true;
                if (this.f31928g && i3 == 1) {
                    i3 = 2;
                }
                return super.k(i2, i3, (this.f31928g || !z) ? false : false);
            }
            return invokeCommon.intValue;
        }

        @Override // b.i.b.a.w
        public int o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int[] iArr = this.f31927f;
                return iArr[iArr.length - 1];
            }
            return invokeV.intValue;
        }

        @Override // b.i.b.a.d0.a
        public int r(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // b.i.b.a.d0.a
        public int s(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? v.d(this.f31926e, i2 + 1, false, false) + 1 : invokeI.intValue;
        }

        @Override // b.i.b.a.d0.a
        public int t(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? v.d(this.f31927f, i2 + 1, false, false) + 1 : invokeI.intValue;
        }

        @Override // b.i.b.a.d0.a
        public Object u(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? Integer.valueOf(i2) : invokeI.objValue;
        }

        @Override // b.i.b.a.d0.a
        public int v(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                if (i2 == 0) {
                    return 0;
                }
                return this.f31926e[i2 - 1];
            }
            return invokeI.intValue;
        }

        @Override // b.i.b.a.d0.a
        public int w(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                if (i2 == 0) {
                    return 0;
                }
                return this.f31927f[i2 - 1];
            }
            return invokeI.intValue;
        }

        @Override // b.i.b.a.d0.a
        public w z(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? this.f31925d[i2] : (w) invokeI.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(l... lVarArr) {
        this(false, lVarArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVarArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (l[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static boolean[] g(l[] lVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lVarArr)) == null) {
            boolean[] zArr = new boolean[lVarArr.length];
            IdentityHashMap identityHashMap = new IdentityHashMap(lVarArr.length);
            for (int i2 = 0; i2 < lVarArr.length; i2++) {
                l lVar = lVarArr[i2];
                if (!identityHashMap.containsKey(lVar)) {
                    identityHashMap.put(lVar, null);
                } else {
                    zArr[i2] = true;
                }
            }
            return zArr;
        }
        return (boolean[]) invokeL.objValue;
    }

    @Override // b.i.b.a.d0.l
    public void a(b.i.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) != null) {
            return;
        }
        this.l = aVar;
        if (this.f31918e.length == 0) {
            aVar.c(this, w.f32777a, null);
            return;
        }
        int i2 = 0;
        while (true) {
            l[] lVarArr = this.f31918e;
            if (i2 >= lVarArr.length) {
                return;
            }
            if (!this.f31922i[i2]) {
                lVarArr[i2].a(gVar, false, new a(this, i2));
            }
            i2++;
        }
    }

    @Override // b.i.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            l[] lVarArr = this.f31918e;
            if (i2 >= lVarArr.length) {
                return;
            }
            if (!this.f31922i[i2]) {
                lVarArr[i2].b();
            }
            i2++;
        }
    }

    @Override // b.i.b.a.d0.l
    public k d(l.b bVar, b.i.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2)) == null) {
            int s = this.m.s(bVar.f31958a);
            k d2 = this.f31918e[s].d(bVar.a(bVar.f31958a - this.m.v(s)), bVar2);
            this.f31921h.put(d2, Integer.valueOf(s));
            return d2;
        }
        return (k) invokeLL.objValue;
    }

    @Override // b.i.b.a.d0.l
    public void e(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            int intValue = this.f31921h.get(kVar).intValue();
            this.f31921h.remove(kVar);
            this.f31918e[intValue].e(kVar);
        }
    }

    @Override // b.i.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            l[] lVarArr = this.f31918e;
            if (i2 >= lVarArr.length) {
                return;
            }
            if (!this.f31922i[i2]) {
                lVarArr[i2].f();
            }
            i2++;
        }
    }

    public final void h(int i2, w wVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, wVar, obj) == null) {
            this.f31919f[i2] = wVar;
            this.f31920g[i2] = obj;
            int i3 = i2 + 1;
            while (true) {
                l[] lVarArr = this.f31918e;
                if (i3 >= lVarArr.length) {
                    break;
                }
                if (lVarArr[i3] == lVarArr[i2]) {
                    this.f31919f[i3] = wVar;
                    this.f31920g[i3] = obj;
                }
                i3++;
            }
            for (w wVar2 : this.f31919f) {
                if (wVar2 == null) {
                    return;
                }
            }
            b bVar = new b((w[]) this.f31919f.clone(), this.j, this.k);
            this.m = bVar;
            this.l.c(this, bVar, this.f31920g.clone());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(boolean z, l... lVarArr) {
        this(z, new q.a(lVarArr.length), lVarArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), lVarArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (q) objArr2[1], (l[]) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public f(boolean z, q qVar, l... lVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), qVar, lVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        for (l lVar : lVarArr) {
            b.i.b.a.i0.a.e(lVar);
        }
        b.i.b.a.i0.a.a(qVar.getLength() == lVarArr.length);
        this.f31918e = lVarArr;
        this.j = z;
        this.k = qVar;
        this.f31919f = new w[lVarArr.length];
        this.f31920g = new Object[lVarArr.length];
        this.f31921h = new HashMap();
        this.f31922i = g(lVarArr);
    }
}
