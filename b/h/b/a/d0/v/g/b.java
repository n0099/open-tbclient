package b.h.b.a.d0.v.g;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f32948a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32949b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f32950c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32951d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32952e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32953f;

    /* renamed from: g  reason: collision with root package name */
    public final k f32954g;

    /* renamed from: h  reason: collision with root package name */
    public final Uri f32955h;

    /* renamed from: i  reason: collision with root package name */
    public final List<e> f32956i;

    public b(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<e> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), kVar, uri, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32948a = j;
        this.f32949b = j2;
        this.f32950c = z;
        this.f32951d = j4;
        this.f32952e = j5;
        this.f32953f = j6;
        this.f32954g = kVar;
        this.f32955h = uri;
        this.f32956i = list == null ? Collections.emptyList() : list;
    }

    public final e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f32956i.get(i2) : (e) invokeI.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32956i.size() : invokeV.intValue;
    }

    public final long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 == this.f32956i.size() - 1) {
                long j = this.f32949b;
                if (j == -9223372036854775807L) {
                    return -9223372036854775807L;
                }
                return j - this.f32956i.get(i2).f32972b;
            }
            return this.f32956i.get(i2 + 1).f32972b - this.f32956i.get(i2).f32972b;
        }
        return invokeI.longValue;
    }

    public final long d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? b.h.b.a.b.a(c(i2)) : invokeI.longValue;
    }
}
