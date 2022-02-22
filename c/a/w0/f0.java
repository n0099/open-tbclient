package c.a.w0;

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
/* loaded from: classes9.dex */
public class f0 implements c.a.w0.n0.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.w0.o0.a a;

    /* renamed from: b  reason: collision with root package name */
    public IPCService f26684b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.w0.o0.b f26685c;

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

    @Override // c.a.w0.n0.d
    public c.a.w0.n0.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                this.a = new c.a.w0.o0.a();
            }
            return this.a;
        }
        return (c.a.w0.n0.a) invokeV.objValue;
    }

    @Override // c.a.w0.n0.d
    public c.a.w0.n0.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f26684b == null) {
                this.f26684b = new IPCService();
            }
            return this.f26684b;
        }
        return (c.a.w0.n0.c) invokeV.objValue;
    }

    @Override // c.a.w0.n0.d
    public q c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.w0.m0.a.b() : (q) invokeV.objValue;
    }

    @Override // c.a.w0.n0.d
    public u d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.w0.m0.a.c() : (u) invokeV.objValue;
    }

    @Override // c.a.w0.n0.d
    public c.a.w0.n0.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f26685c == null) {
                this.f26685c = new c.a.w0.o0.b();
            }
            return this.f26685c;
        }
        return (c.a.w0.n0.b) invokeV.objValue;
    }
}
