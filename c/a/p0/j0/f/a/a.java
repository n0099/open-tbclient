package c.a.p0.j0.f.a;

import android.webkit.JsPromptResult;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements c.a.p0.j0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // c.a.p0.j0.b
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048576, this, str, str2, str3, str4, jsPromptResult) == null) && b().equals(str)) {
            c.a.p0.j0.a.f().e();
        }
    }

    @Override // c.a.p0.j0.b
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "closeDialog" : (String) invokeV.objValue;
    }
}
