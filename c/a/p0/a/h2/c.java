package c.a.p0.a.h2;

import android.os.Build;
import android.text.TextUtils;
import c.a.p0.a.j2.c;
import c.a.p0.a.k;
import c.a.p0.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class c implements SoUtils.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6563a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(819066630, "Lc/a/p0/a/h2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(819066630, "Lc/a/p0/a/h2/c;");
                return;
            }
        }
        f6563a = k.f7077a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(c.a.p0.a.c1.a.b(), str);
            return String.format(Locale.CHINA, "[%s:%s,size:%d]", str, findSoFilesInLibrary == null ? null : findSoFilesInLibrary.getAbsolutePath(), Long.valueOf(findSoFilesInLibrary == null ? 0L : findSoFilesInLibrary.length()));
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.swan.apps.so.SoUtils.a
    public void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        String[] strArr = {Build.CPU_ABI, Build.CPU_ABI2};
        String str3 = Arrays.toString(strArr) + StringUtils.LF + l.a() + StringUtils.LF + a("v8.engine") + StringUtils.LF + a("zeusv8") + StringUtils.LF + str2;
        if (f6563a) {
            String str4 = "reportSoLoadInfo: " + str3;
        }
        c.b bVar = new c.b(10007);
        bVar.j(str);
        bVar.i(str3);
        bVar.h(c.a.p0.a.a2.e.V());
        bVar.m();
    }
}
