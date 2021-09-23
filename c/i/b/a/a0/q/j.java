package c.i.b.a.a0.q;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes4.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f32670a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32671b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32672c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32673d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32674e;

    /* renamed from: f  reason: collision with root package name */
    public final Format f32675f;

    /* renamed from: g  reason: collision with root package name */
    public final int f32676g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final long[] f32677h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final long[] f32678i;

    /* renamed from: j  reason: collision with root package name */
    public final int f32679j;
    @Nullable
    public final k[] k;

    public j(int i2, int i3, long j2, long j3, long j4, Format format, int i4, @Nullable k[] kVarArr, int i5, @Nullable long[] jArr, @Nullable long[] jArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), format, Integer.valueOf(i4), kVarArr, Integer.valueOf(i5), jArr, jArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32670a = i2;
        this.f32671b = i3;
        this.f32672c = j2;
        this.f32673d = j3;
        this.f32674e = j4;
        this.f32675f = format;
        this.f32676g = i4;
        this.k = kVarArr;
        this.f32679j = i5;
        this.f32677h = jArr;
        this.f32678i = jArr2;
    }

    public k a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            k[] kVarArr = this.k;
            if (kVarArr == null) {
                return null;
            }
            return kVarArr[i2];
        }
        return (k) invokeI.objValue;
    }
}
