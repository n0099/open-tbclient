package c.i.b.a;

import c.i.b.a.d0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f29821b;

    /* renamed from: c  reason: collision with root package name */
    public final l.b f29822c;

    /* renamed from: d  reason: collision with root package name */
    public final long f29823d;

    /* renamed from: e  reason: collision with root package name */
    public final long f29824e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f29825f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f29826g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(w wVar, Object obj, int i2, long j2) {
        this(wVar, obj, new l.b(i2), j2, -9223372036854775807L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {wVar, obj, Integer.valueOf(i2), Long.valueOf(j2)};
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
            oVar2.f29825f = oVar.f29825f;
            oVar2.f29826g = oVar.f29826g;
        }
    }

    public o b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            o oVar = new o(this.a, this.f29821b, this.f29822c.a(i2), this.f29823d, this.f29824e);
            a(this, oVar);
            return oVar;
        }
        return (o) invokeI.objValue;
    }

    public o c(w wVar, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar, obj)) == null) {
            o oVar = new o(wVar, obj, this.f29822c, this.f29823d, this.f29824e);
            a(this, oVar);
            return oVar;
        }
        return (o) invokeLL.objValue;
    }

    public o d(int i2, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? e(new l.b(i2), j2, j3) : (o) invokeCommon.objValue;
    }

    public o e(l.b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) ? new o(this.a, this.f29821b, bVar, j2, j3) : (o) invokeCommon.objValue;
    }

    public o(w wVar, Object obj, l.b bVar, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, obj, bVar, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = wVar;
        this.f29821b = obj;
        this.f29822c = bVar;
        this.f29823d = j2;
        this.f29824e = j3;
        this.f29825f = j2;
        this.f29826g = j2;
    }
}
