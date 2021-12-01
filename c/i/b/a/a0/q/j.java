package c.i.b.a.a0.q;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes7.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29177b;

    /* renamed from: c  reason: collision with root package name */
    public final long f29178c;

    /* renamed from: d  reason: collision with root package name */
    public final long f29179d;

    /* renamed from: e  reason: collision with root package name */
    public final long f29180e;

    /* renamed from: f  reason: collision with root package name */
    public final Format f29181f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29182g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final long[] f29183h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final long[] f29184i;

    /* renamed from: j  reason: collision with root package name */
    public final int f29185j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final k[] f29186k;

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
        this.a = i2;
        this.f29177b = i3;
        this.f29178c = j2;
        this.f29179d = j3;
        this.f29180e = j4;
        this.f29181f = format;
        this.f29182g = i4;
        this.f29186k = kVarArr;
        this.f29185j = i5;
        this.f29183h = jArr;
        this.f29184i = jArr2;
    }

    public k a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            k[] kVarArr = this.f29186k;
            if (kVarArr == null) {
                return null;
            }
            return kVarArr[i2];
        }
        return (k) invokeI.objValue;
    }
}
