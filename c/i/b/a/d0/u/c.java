package c.i.b.a.d0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes7.dex */
public abstract class c implements Loader.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.i.b.a.h0.g a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29631b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f29632c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29633d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f29634e;

    /* renamed from: f  reason: collision with root package name */
    public final long f29635f;

    /* renamed from: g  reason: collision with root package name */
    public final long f29636g;

    /* renamed from: h  reason: collision with root package name */
    public final c.i.b.a.h0.e f29637h;

    public c(c.i.b.a.h0.e eVar, c.i.b.a.h0.g gVar, int i2, Format format, int i3, Object obj, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, gVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.a.e(eVar);
        this.f29637h = eVar;
        c.i.b.a.i0.a.e(gVar);
        this.a = gVar;
        this.f29631b = i2;
        this.f29632c = format;
        this.f29633d = i3;
        this.f29634e = obj;
        this.f29635f = j2;
        this.f29636g = j3;
    }

    public abstract long b();

    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29636g - this.f29635f : invokeV.longValue;
    }
}
