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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f33019a;

    /* renamed from: b  reason: collision with root package name */
    public final long f33020b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f33021c;

    /* renamed from: d  reason: collision with root package name */
    public final long f33022d;

    /* renamed from: e  reason: collision with root package name */
    public final long f33023e;

    /* renamed from: f  reason: collision with root package name */
    public final long f33024f;

    /* renamed from: g  reason: collision with root package name */
    public final k f33025g;

    /* renamed from: h  reason: collision with root package name */
    public final Uri f33026h;

    /* renamed from: i  reason: collision with root package name */
    public final List<e> f33027i;

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
        this.f33019a = j2;
        this.f33020b = j3;
        this.f33021c = z;
        this.f33022d = j5;
        this.f33023e = j6;
        this.f33024f = j7;
        this.f33025g = kVar;
        this.f33026h = uri;
        this.f33027i = list == null ? Collections.emptyList() : list;
    }

    public final e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f33027i.get(i2) : (e) invokeI.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33027i.size() : invokeV.intValue;
    }

    public final long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 == this.f33027i.size() - 1) {
                long j2 = this.f33020b;
                if (j2 == -9223372036854775807L) {
                    return -9223372036854775807L;
                }
                return j2 - this.f33027i.get(i2).f33043b;
            }
            return this.f33027i.get(i2 + 1).f33043b - this.f33027i.get(i2).f33043b;
        }
        return invokeI.longValue;
    }

    public final long d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? c.i.b.a.b.a(c(i2)) : invokeI.longValue;
    }
}
