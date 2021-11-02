package b.a.q0.s.z;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.dxmpay.wallet.core.Domains;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes4.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            try {
                URL url = new URL(str);
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    return true;
                }
                if (!"http".equals(protocol) && !"https".equals(protocol)) {
                    return false;
                }
                if (url.getHost().endsWith(Domains.BAIDU)) {
                    if (str.contains("tieba_hybrid_enabled=1")) {
                        return true;
                    }
                    if (str.contains("tieba_hybrid_enabled%3D1")) {
                        return true;
                    }
                }
                return false;
            } catch (MalformedURLException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            try {
                URL url = new URL(str);
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    return true;
                }
                if (!"http".equals(protocol) && !"https".equals(protocol)) {
                    return false;
                }
                return url.getHost().endsWith(Domains.BAIDU);
            } catch (MalformedURLException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
