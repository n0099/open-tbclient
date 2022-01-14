package c.i.b.a.d0.v.g;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29228b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f29229c;

    /* renamed from: d  reason: collision with root package name */
    public final long f29230d;

    /* renamed from: e  reason: collision with root package name */
    public final long f29231e;

    /* renamed from: f  reason: collision with root package name */
    public final long f29232f;

    /* renamed from: g  reason: collision with root package name */
    public final k f29233g;

    /* renamed from: h  reason: collision with root package name */
    public final Uri f29234h;

    /* renamed from: i  reason: collision with root package name */
    public final List<e> f29235i;

    public b(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, k kVar, Uri uri, List<e> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), kVar, uri, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j2;
        this.f29228b = j3;
        this.f29229c = z;
        this.f29230d = j5;
        this.f29231e = j6;
        this.f29232f = j7;
        this.f29233g = kVar;
        this.f29234h = uri;
        this.f29235i = list == null ? Collections.emptyList() : list;
    }

    public final e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f29235i.get(i2) : (e) invokeI.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29235i.size() : invokeV.intValue;
    }

    public final long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 == this.f29235i.size() - 1) {
                long j2 = this.f29228b;
                if (j2 == -9223372036854775807L) {
                    return -9223372036854775807L;
                }
                return j2 - this.f29235i.get(i2).f29247b;
            }
            return this.f29235i.get(i2 + 1).f29247b - this.f29235i.get(i2).f29247b;
        }
        return invokeI.longValue;
    }

    public final long d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? c.i.b.a.b.a(c(i2)) : invokeI.longValue;
    }
}
