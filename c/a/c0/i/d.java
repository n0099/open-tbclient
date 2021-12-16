package c.a.c0.i;

import android.text.TextUtils;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.a.c0.r.p.c<String> {
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

        @Override // c.a.c0.r.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
            }
        }

        @Override // c.a.c0.r.p.b
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i2) throws Exception {
            f(headers, str, i2);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.c0.r.p.b
        /* renamed from: e */
        public void b(Headers headers, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i2) == null) {
            }
        }

        public String f(Headers headers, String str, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    public static c.a.c0.x.c.e a(ADConfigError aDConfigError, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{aDConfigError, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            c.a.c0.x.c.e eVar = new c.a.c0.x.c.e();
            eVar.f("1042").a("f1", b(aDConfigError.code)).a("f2", b(String.valueOf(i2))).a("f3", b(z ? "0" : "1"));
            return eVar;
        }
        return (c.a.c0.x.c.e) invokeCommon.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return URLEncoder.encode(str, "utf-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void c(ADConfigError aDConfigError, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{aDConfigError, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || aDConfigError == null) {
            return;
        }
        c.a.c0.x.a.c(a(aDConfigError, i2, z), new a());
    }
}
