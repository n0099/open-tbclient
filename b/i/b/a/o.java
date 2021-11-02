package b.i.b.a;

import b.i.b.a.d0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f32754a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f32755b;

    /* renamed from: c  reason: collision with root package name */
    public final l.b f32756c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32757d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32758e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f32759f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f32760g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(w wVar, Object obj, int i2, long j) {
        this(wVar, obj, new l.b(i2), j, -9223372036854775807L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {wVar, obj, Integer.valueOf(i2), Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((w) objArr2[0], objArr2[1], (l.b) objArr2[2], ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void a(o oVar, o oVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, oVar, oVar2) == null) {
            oVar2.f32759f = oVar.f32759f;
            oVar2.f32760g = oVar.f32760g;
        }
    }

    public o b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            o oVar = new o(this.f32754a, this.f32755b, this.f32756c.a(i2), this.f32757d, this.f32758e);
            a(this, oVar);
            return oVar;
        }
        return (o) invokeI.objValue;
    }

    public o c(w wVar, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar, obj)) == null) {
            o oVar = new o(wVar, obj, this.f32756c, this.f32757d, this.f32758e);
            a(this, oVar);
            return oVar;
        }
        return (o) invokeLL.objValue;
    }

    public o d(int i2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) ? e(new l.b(i2), j, j2) : (o) invokeCommon.objValue;
    }

    public o e(l.b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) ? new o(this.f32754a, this.f32755b, bVar, j, j2) : (o) invokeCommon.objValue;
    }

    public o(w wVar, Object obj, l.b bVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, obj, bVar, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32754a = wVar;
        this.f32755b = obj;
        this.f32756c = bVar;
        this.f32757d = j;
        this.f32758e = j2;
        this.f32759f = j;
        this.f32760g = j;
    }
}
