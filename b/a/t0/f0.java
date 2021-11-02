package b.a.t0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.service.IPCService;
@Singleton
@Service
/* loaded from: classes6.dex */
public class f0 implements b.a.t0.n0.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.t0.o0.a f28769a;

    /* renamed from: b  reason: collision with root package name */
    public IPCService f28770b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.t0.o0.b f28771c;

    public f0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // b.a.t0.n0.d
    public b.a.t0.n0.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f28769a == null) {
                this.f28769a = new b.a.t0.o0.a();
            }
            return this.f28769a;
        }
        return (b.a.t0.n0.a) invokeV.objValue;
    }

    @Override // b.a.t0.n0.d
    public b.a.t0.n0.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f28770b == null) {
                this.f28770b = new IPCService();
            }
            return this.f28770b;
        }
        return (b.a.t0.n0.c) invokeV.objValue;
    }

    @Override // b.a.t0.n0.d
    public q c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.t0.m0.a.b() : (q) invokeV.objValue;
    }

    @Override // b.a.t0.n0.d
    public u d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b.a.t0.m0.a.c() : (u) invokeV.objValue;
    }

    @Override // b.a.t0.n0.d
    public b.a.t0.n0.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f28771c == null) {
                this.f28771c = new b.a.t0.o0.b();
            }
            return this.f28771c;
        }
        return (b.a.t0.n0.b) invokeV.objValue;
    }
}
