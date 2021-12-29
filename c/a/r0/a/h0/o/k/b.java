package c.a.r0.a.h0.o.k;

import android.text.TextUtils;
import c.a.r0.a.a1.d;
import c.a.r0.a.k;
import c.a.r0.a.z2.o0;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(21932843, "Lc/a/r0/a/h0/o/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(21932843, "Lc/a/r0/a/h0/o/k/b;");
                return;
            }
        }
        a = k.a;
    }

    public static a a(PMSAppInfo pMSAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pMSAppInfo, str)) == null) {
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.appCategory != 0) {
                return null;
            }
            File i2 = d.e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
            if (!i2.exists()) {
                boolean z = a;
                return null;
            }
            a aVar = new a();
            if (new File(i2, "app.json").exists()) {
                boolean z2 = a;
                aVar.a = i2;
                return aVar;
            } else if (TextUtils.isEmpty(str)) {
                return null;
            } else {
                String g2 = o0.g(str);
                int lastIndexOf = g2.lastIndexOf(File.separator);
                if (lastIndexOf >= 0) {
                    g2 = g2.substring(0, lastIndexOf);
                }
                if (new File(i2, g2).exists()) {
                    int lastIndexOf2 = g2.lastIndexOf(File.separator);
                    while (lastIndexOf2 >= 0) {
                        g2 = g2.substring(0, lastIndexOf2);
                        if (new File(i2, g2 + File.separator + "app.json").exists()) {
                            if (a) {
                                String str2 = "isInDependentPkg=true, pagePath=" + g2;
                            }
                            aVar.f6966b = true;
                            aVar.f6967c = g2;
                            aVar.a = new File(i2, g2);
                            return aVar;
                        }
                        lastIndexOf2 = g2.lastIndexOf(File.separator);
                    }
                    return null;
                }
                return null;
            }
        }
        return (a) invokeLL.objValue;
    }
}
