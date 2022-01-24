package c.o.a.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes9.dex */
public class d extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.o.a.d a;

    /* renamed from: b  reason: collision with root package name */
    public final MethodChannel.Result f30285b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f30286c;

    public d(MethodChannel.Result result, c.o.a.d dVar, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {result, dVar, bool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30285b = result;
        this.a = dVar;
        this.f30286c = bool;
    }

    @Override // c.o.a.f.f
    public <T> T a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return null;
        }
        return (T) invokeL.objValue;
    }

    @Override // c.o.a.f.b, c.o.a.f.f
    public c.o.a.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c.o.a.d) invokeV.objValue;
    }

    @Override // c.o.a.f.b, c.o.a.f.f
    public Boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30286c : (Boolean) invokeV.objValue;
    }

    @Override // c.o.a.f.g
    public void error(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, obj) == null) {
            this.f30285b.error(str, str2, obj);
        }
    }

    @Override // c.o.a.f.g
    public void success(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.f30285b.success(obj);
        }
    }
}
