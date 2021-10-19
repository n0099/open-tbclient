package c.d.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public final class d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f31780a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f31781b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f31782c;

    public d0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, proxy, inetSocketAddress};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f31780a = aVar;
            this.f31781b = proxy;
            this.f31782c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31780a : (a) invokeV.objValue;
    }

    public Proxy b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31781b : (Proxy) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31780a.f31736i != null && this.f31781b.type() == Proxy.Type.HTTP : invokeV.booleanValue;
    }

    public InetSocketAddress d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31782c : (InetSocketAddress) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj instanceof d0) {
                d0 d0Var = (d0) obj;
                if (d0Var.f31780a.equals(this.f31780a) && d0Var.f31781b.equals(this.f31781b) && d0Var.f31782c.equals(this.f31782c)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ((((527 + this.f31780a.hashCode()) * 31) + this.f31781b.hashCode()) * 31) + this.f31782c.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "Route{" + this.f31782c + "}";
        }
        return (String) invokeV.objValue;
    }
}
