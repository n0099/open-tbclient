package c.i.b.a.a0.q;

import c.i.b.a.i0.v;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long[] a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f28679b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28680c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f28681d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f28682e;

        public /* synthetic */ b(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, a aVar) {
            this(jArr, iArr, i2, jArr2, iArr2);
        }

        public b(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jArr, iArr, Integer.valueOf(i2), jArr2, iArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jArr;
            this.f28679b = iArr;
            this.f28680c = i2;
            this.f28681d = jArr2;
            this.f28682e = iArr2;
        }
    }

    public static b a(int i2, long[] jArr, int[] iArr, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), jArr, iArr, Long.valueOf(j2)})) == null) {
            int i3 = 8192 / i2;
            int i4 = 0;
            for (int i5 : iArr) {
                i4 += v.f(i5, i3);
            }
            long[] jArr2 = new long[i4];
            int[] iArr2 = new int[i4];
            long[] jArr3 = new long[i4];
            int[] iArr3 = new int[i4];
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < iArr.length; i9++) {
                int i10 = iArr[i9];
                long j3 = jArr[i9];
                while (i10 > 0) {
                    int min = Math.min(i3, i10);
                    jArr2[i7] = j3;
                    iArr2[i7] = i2 * min;
                    i8 = Math.max(i8, iArr2[i7]);
                    jArr3[i7] = i6 * j2;
                    iArr3[i7] = 1;
                    j3 += iArr2[i7];
                    i6 += min;
                    i10 -= min;
                    i7++;
                }
            }
            return new b(jArr2, iArr2, i8, jArr3, iArr3, null);
        }
        return (b) invokeCommon.objValue;
    }
}
