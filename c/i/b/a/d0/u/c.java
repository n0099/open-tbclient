package c.i.b.a.d0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes9.dex */
public abstract class c implements Loader.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.i.b.a.h0.g a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30079b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f30080c;

    /* renamed from: d  reason: collision with root package name */
    public final int f30081d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f30082e;

    /* renamed from: f  reason: collision with root package name */
    public final long f30083f;

    /* renamed from: g  reason: collision with root package name */
    public final long f30084g;

    /* renamed from: h  reason: collision with root package name */
    public final c.i.b.a.h0.e f30085h;

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
        this.f30085h = eVar;
        c.i.b.a.i0.a.e(gVar);
        this.a = gVar;
        this.f30079b = i2;
        this.f30080c = format;
        this.f30081d = i3;
        this.f30082e = obj;
        this.f30083f = j2;
        this.f30084g = j3;
    }

    public abstract long b();

    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30084g - this.f30083f : invokeV.longValue;
    }
}
