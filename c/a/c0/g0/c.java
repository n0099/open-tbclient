package c.a.c0.g0;

import android.content.Context;
import c.a.c0.g0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.container.BaseNativeBrowserContainer;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c implements a.InterfaceC0041a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // c.a.c0.g0.a.InterfaceC0041a
    public AbsContainer a(c.a.c0.g0.n.a.a aVar, c.a.c0.g0.n.a.b bVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, aVar, bVar, i2)) == null) ? new BaseNativeBrowserContainer(aVar, bVar) : (AbsContainer) invokeLLI.objValue;
    }

    @Override // c.a.c0.g0.a.InterfaceC0041a
    public boolean b(HashMap<String, String> hashMap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap, i2)) == null) {
            return true;
        }
        return invokeLI.booleanValue;
    }

    @Override // c.a.c0.g0.a.InterfaceC0041a
    public void c(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
        }
    }
}
