package b.h.b.a.d0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes6.dex */
public abstract class c implements Loader.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.h.b.a.h0.g f32864a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32865b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f32866c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32867d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f32868e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32869f;

    /* renamed from: g  reason: collision with root package name */
    public final long f32870g;

    /* renamed from: h  reason: collision with root package name */
    public final b.h.b.a.h0.e f32871h;

    public c(b.h.b.a.h0.e eVar, b.h.b.a.h0.g gVar, int i2, Format format, int i3, Object obj, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, gVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b.h.b.a.i0.a.e(eVar);
        this.f32871h = eVar;
        b.h.b.a.i0.a.e(gVar);
        this.f32864a = gVar;
        this.f32865b = i2;
        this.f32866c = format;
        this.f32867d = i3;
        this.f32868e = obj;
        this.f32869f = j;
        this.f32870g = j2;
    }

    public abstract long c();

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32870g - this.f32869f : invokeV.longValue;
    }
}
