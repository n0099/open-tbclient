package c.a.n0.a.x.o.k;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.p2.o0;
import c.a.n0.a.q0.d;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1365024183, "Lc/a/n0/a/x/o/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1365024183, "Lc/a/n0/a/x/o/k/b;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static a a(PMSAppInfo pMSAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pMSAppInfo, str)) == null) {
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.appCategory != 0) {
                return null;
            }
            File i = d.e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
            if (!i.exists()) {
                if (a) {
                    Log.w("PrefetchUtils", "aiapp dir not exist ");
                }
                return null;
            }
            a aVar = new a();
            if (new File(i, "app.json").exists()) {
                if (a) {
                    Log.d("PrefetchUtils", "find main pkg's app config file");
                }
                aVar.a = i;
                return aVar;
            } else if (TextUtils.isEmpty(str)) {
                return null;
            } else {
                String g2 = o0.g(str);
                int lastIndexOf = g2.lastIndexOf(File.separator);
                if (lastIndexOf >= 0) {
                    g2 = g2.substring(0, lastIndexOf);
                }
                if (new File(i, g2).exists()) {
                    int lastIndexOf2 = g2.lastIndexOf(File.separator);
                    while (lastIndexOf2 >= 0) {
                        g2 = g2.substring(0, lastIndexOf2);
                        if (new File(i, g2 + File.separator + "app.json").exists()) {
                            if (a) {
                                Log.d("PrefetchUtils", "isInDependentPkg=true, pagePath=" + g2);
                            }
                            aVar.f7389b = true;
                            aVar.f7390c = g2;
                            aVar.a = new File(i, g2);
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
