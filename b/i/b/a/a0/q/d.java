package b.i.b.a.a0.q;

import b.i.b.a.i0.v;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long[] f31497a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f31498b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31499c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f31500d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f31501e;

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
            this.f31497a = jArr;
            this.f31498b = iArr;
            this.f31499c = i2;
            this.f31500d = jArr2;
            this.f31501e = iArr2;
        }
    }

    public static b a(int i2, long[] jArr, int[] iArr, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), jArr, iArr, Long.valueOf(j)})) == null) {
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
                long j2 = jArr[i9];
                while (i10 > 0) {
                    int min = Math.min(i3, i10);
                    jArr2[i7] = j2;
                    iArr2[i7] = i2 * min;
                    i8 = Math.max(i8, iArr2[i7]);
                    jArr3[i7] = i6 * j;
                    iArr3[i7] = 1;
                    j2 += iArr2[i7];
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
