package c.a.n0.a.h0.o.j;

import android.text.TextUtils;
import c.a.n0.a.a1.e;
import c.a.n0.a.k;
import c.a.n0.a.v2.o0;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6093a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2044137552, "Lc/a/n0/a/h0/o/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2044137552, "Lc/a/n0/a/h0/o/j/b;");
                return;
            }
        }
        f6093a = k.f6803a;
    }

    public static a a(PMSAppInfo pMSAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pMSAppInfo, str)) == null) {
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.appCategory != 0) {
                return null;
            }
            File i2 = e.C0104e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
            if (!i2.exists()) {
                boolean z = f6093a;
                return null;
            }
            a aVar = new a();
            if (new File(i2, "app.json").exists()) {
                boolean z2 = f6093a;
                aVar.f6090a = i2;
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
                            if (f6093a) {
                                String str2 = "isInDependentPkg=true, pagePath=" + g2;
                            }
                            aVar.f6091b = true;
                            aVar.f6092c = g2;
                            aVar.f6090a = new File(i2, g2);
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
