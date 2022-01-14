package c.a.r0.a.h0.d;

import androidx.annotation.NonNull;
import c.a.r0.a.h0.d.a;
import c.a.r0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebSettings;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1344944754, "Lc/a/r0/a/h0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1344944754, "Lc/a/r0/a/h0/d/b;");
                return;
            }
        }
        a = k.a;
    }

    @NonNull
    public static WebSettings.CodeCacheSetting a(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            WebSettings.CodeCacheSetting codeCacheSetting = new WebSettings.CodeCacheSetting();
            codeCacheSetting.id = str;
            ArrayList<String> arrayList = new ArrayList<>();
            codeCacheSetting.pathList = arrayList;
            arrayList.add(str2);
            if (((str.hashCode() == 93029162 && str.equals("appjs")) ? (char) 0 : (char) 65535) != 0) {
                codeCacheSetting.maxCount = 20;
                codeCacheSetting.sizeLimit = 102400;
            } else {
                a.C0349a d2 = a.b.d();
                codeCacheSetting.maxCount = d2.a;
                codeCacheSetting.sizeLimit = d2.f6292b;
                codeCacheSetting.diskCodeCacheSizeThreshold = d2.f6293c;
            }
            if (a) {
                String str3 = "buildCacheSetting cacheType: " + str;
                String str4 = "buildCacheSetting maxCount: " + codeCacheSetting.maxCount;
                String str5 = "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit;
            }
            return codeCacheSetting;
        }
        return (WebSettings.CodeCacheSetting) invokeLL.objValue;
    }
}
