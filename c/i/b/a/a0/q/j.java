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
    public final int f32647a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32648b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32649c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32650d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32651e;

    /* renamed from: f  reason: collision with root package name */
    public final Format f32652f;

    /* renamed from: g  reason: collision with root package name */
    public final int f32653g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final long[] f32654h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final long[] f32655i;

    /* renamed from: j  reason: collision with root package name */
    public final int f32656j;
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
        this.f32647a = i2;
        this.f32648b = i3;
        this.f32649c = j2;
        this.f32650d = j3;
        this.f32651e = j4;
        this.f32652f = format;
        this.f32653g = i4;
        this.k = kVarArr;
        this.f32656j = i5;
        this.f32654h = jArr;
        this.f32655i = jArr2;
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
