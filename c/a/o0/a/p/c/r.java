package c.a.o0.a.p.c;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import c.a.o0.a.v0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class r implements c.a.o0.a.p.d.f0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r() {
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

    @Override // c.a.o0.a.p.d.f0
    public boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.o0.a.p.d.f0
    public void b(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
        }
    }

    @Override // c.a.o0.a.p.d.f0
    public void c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // c.a.o0.a.p.d.f0
    public void d(@NonNull CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, callbackHandler) == null) {
            callbackHandler.handleSchemeDispatchCallback("", "");
        }
    }

    @Override // c.a.o0.a.p.d.f0
    public void e(c.a.o0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
        }
    }

    @Override // c.a.o0.a.p.d.f0
    public String f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? context.getString(c.a.o0.a.h.aiapps_fav_success) : (String) invokeL.objValue;
    }

    @Override // c.a.o0.a.p.d.f0
    public void g(c.a.o0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
        }
    }

    @Override // c.a.o0.a.p.d.f0
    public void h(@NonNull Activity activity, String str, String str2, c.a.o0.a.v0.b bVar, c.b bVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048583, this, activity, str, str2, bVar, bVar2) == null) || bVar2 == null) {
            return;
        }
        bVar2.a();
    }
}
