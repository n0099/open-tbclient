package b.i.b.a.f0;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.d0.t;
import b.i.b.a.f0.f;
import b.i.b.a.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class e extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<Map<t, b>> f32493a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseBooleanArray f32494b;

    /* renamed from: c  reason: collision with root package name */
    public int f32495c;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(int[] iArr, t[] tVarArr, int[] iArr2, int[][][] iArr3, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iArr, tVarArr, iArr2, iArr3, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int length = tVarArr.length;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final f.a f32496a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32497b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f32498c;

        public f a(t tVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tVar)) == null) ? this.f32496a.a(tVar.a(this.f32497b), this.f32498c) : (f) invokeL.objValue;
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32493a = new SparseArray<>();
        this.f32494b = new SparseBooleanArray();
        this.f32495c = 0;
    }

    public static int e(s[] sVarArr, b.i.b.a.d0.s sVar) throws ExoPlaybackException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, sVarArr, sVar)) == null) {
            int length = sVarArr.length;
            int i2 = 0;
            for (int i3 = 0; i3 < sVarArr.length; i3++) {
                s sVar2 = sVarArr[i3];
                for (int i4 = 0; i4 < sVar.f31997a; i4++) {
                    int a2 = sVar2.a(sVar.a(i4)) & 7;
                    if (a2 > i2) {
                        if (a2 == 4) {
                            return i3;
                        }
                        length = i3;
                        i2 = a2;
                    }
                }
            }
            return length;
        }
        return invokeLL.intValue;
    }

    public static int[] f(s sVar, b.i.b.a.d0.s sVar2) throws ExoPlaybackException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, sVar, sVar2)) == null) {
            int[] iArr = new int[sVar2.f31997a];
            for (int i2 = 0; i2 < sVar2.f31997a; i2++) {
                iArr[i2] = sVar.a(sVar2.a(i2));
            }
            return iArr;
        }
        return (int[]) invokeLL.objValue;
    }

    public static int[] g(s[] sVarArr) throws ExoPlaybackException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sVarArr)) == null) {
            int length = sVarArr.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = sVarArr[i2].r();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static void i(s[] sVarArr, t[] tVarArr, int[][][] iArr, b.i.b.a.t[] tVarArr2, f[] fVarArr, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{sVarArr, tVarArr, iArr, tVarArr2, fVarArr, Integer.valueOf(i2)}) == null) || i2 == 0) {
            return;
        }
        boolean z2 = false;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < sVarArr.length; i5++) {
            int e2 = sVarArr[i5].e();
            f fVar = fVarArr[i5];
            if ((e2 == 1 || e2 == 2) && fVar != null && j(iArr[i5], tVarArr[i5], fVar)) {
                if (e2 == 1) {
                    if (i4 != -1) {
                        z = false;
                        break;
                    }
                    i4 = i5;
                } else if (i3 != -1) {
                    z = false;
                    break;
                } else {
                    i3 = i5;
                }
            }
        }
        z = true;
        if (i4 != -1 && i3 != -1) {
            z2 = true;
        }
        if (z && z2) {
            b.i.b.a.t tVar = new b.i.b.a.t(i2);
            tVarArr2[i4] = tVar;
            tVarArr2[i3] = tVar;
        }
    }

    public static boolean j(int[][] iArr, t tVar, f fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, iArr, tVar, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            int b2 = tVar.b(fVar.d());
            for (int i2 = 0; i2 < fVar.length(); i2++) {
                if ((iArr[b2][fVar.b(i2)] & 32) != 32) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // b.i.b.a.f0.h
    public final void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            a aVar = (a) obj;
        }
    }

    @Override // b.i.b.a.f0.h
    public final i c(s[] sVarArr, t tVar) throws ExoPlaybackException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVarArr, tVar)) == null) {
            int[] iArr = new int[sVarArr.length + 1];
            int length = sVarArr.length + 1;
            b.i.b.a.d0.s[][] sVarArr2 = new b.i.b.a.d0.s[length];
            int[][][] iArr2 = new int[sVarArr.length + 1][];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = tVar.f32001a;
                sVarArr2[i2] = new b.i.b.a.d0.s[i3];
                iArr2[i2] = new int[i3];
            }
            int[] g2 = g(sVarArr);
            for (int i4 = 0; i4 < tVar.f32001a; i4++) {
                b.i.b.a.d0.s a2 = tVar.a(i4);
                int e2 = e(sVarArr, a2);
                int[] f2 = e2 == sVarArr.length ? new int[a2.f31997a] : f(sVarArr[e2], a2);
                int i5 = iArr[e2];
                sVarArr2[e2][i5] = a2;
                iArr2[e2][i5] = f2;
                iArr[e2] = iArr[e2] + 1;
            }
            t[] tVarArr = new t[sVarArr.length];
            int[] iArr3 = new int[sVarArr.length];
            for (int i6 = 0; i6 < sVarArr.length; i6++) {
                int i7 = iArr[i6];
                tVarArr[i6] = new t((b.i.b.a.d0.s[]) Arrays.copyOf(sVarArr2[i6], i7));
                iArr2[i6] = (int[][]) Arrays.copyOf(iArr2[i6], i7);
                iArr3[i6] = sVarArr[i6].e();
            }
            t tVar2 = new t((b.i.b.a.d0.s[]) Arrays.copyOf(sVarArr2[sVarArr.length], iArr[sVarArr.length]));
            f[] k = k(sVarArr, tVarArr, iArr2);
            int i8 = 0;
            while (true) {
                if (i8 >= sVarArr.length) {
                    break;
                }
                if (this.f32494b.get(i8)) {
                    k[i8] = null;
                } else {
                    t tVar3 = tVarArr[i8];
                    if (h(i8, tVar3)) {
                        b bVar = this.f32493a.get(i8).get(tVar3);
                        k[i8] = bVar != null ? bVar.a(tVar3) : null;
                    }
                }
                i8++;
            }
            boolean[] d2 = d(sVarArr, k);
            a aVar = new a(iArr3, tVarArr, g2, iArr2, tVar2);
            b.i.b.a.t[] tVarArr2 = new b.i.b.a.t[sVarArr.length];
            for (int i9 = 0; i9 < sVarArr.length; i9++) {
                tVarArr2[i9] = d2[i9] ? b.i.b.a.t.f32765b : null;
            }
            i(sVarArr, tVarArr, iArr2, tVarArr2, k, this.f32495c);
            return new i(tVar, d2, new g(k), aVar, tVarArr2);
        }
        return (i) invokeLL.objValue;
    }

    public final boolean[] d(s[] sVarArr, f[] fVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sVarArr, fVarArr)) == null) {
            int length = fVarArr.length;
            boolean[] zArr = new boolean[length];
            for (int i2 = 0; i2 < length; i2++) {
                zArr[i2] = !this.f32494b.get(i2) && (sVarArr[i2].e() == 5 || fVarArr[i2] != null);
            }
            return zArr;
        }
        return (boolean[]) invokeLL.objValue;
    }

    public final boolean h(int i2, t tVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, tVar)) == null) {
            Map<t, b> map = this.f32493a.get(i2);
            return map != null && map.containsKey(tVar);
        }
        return invokeIL.booleanValue;
    }

    public abstract f[] k(s[] sVarArr, t[] tVarArr, int[][][] iArr) throws ExoPlaybackException;
}
