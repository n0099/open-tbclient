package b.i.b.a.d0.u;

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
    public final b.i.b.a.h0.g f32006a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32007b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f32008c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32009d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f32010e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32011f;

    /* renamed from: g  reason: collision with root package name */
    public final long f32012g;

    /* renamed from: h  reason: collision with root package name */
    public final b.i.b.a.h0.e f32013h;

    public c(b.i.b.a.h0.e eVar, b.i.b.a.h0.g gVar, int i2, Format format, int i3, Object obj, long j, long j2) {
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
        b.i.b.a.i0.a.e(eVar);
        this.f32013h = eVar;
        b.i.b.a.i0.a.e(gVar);
        this.f32006a = gVar;
        this.f32007b = i2;
        this.f32008c = format;
        this.f32009d = i3;
        this.f32010e = obj;
        this.f32011f = j;
        this.f32012g = j2;
    }

    public abstract long c();

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32012g - this.f32011f : invokeV.longValue;
    }
}
