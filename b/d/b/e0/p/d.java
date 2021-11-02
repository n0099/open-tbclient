package b.d.b.e0.p;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.CertificatePinner;
/* loaded from: classes6.dex */
public final class d implements HostnameVerifier {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final d f30485a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-796852759, "Lb/d/b/e0/p/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-796852759, "Lb/d/b/e0/p/d;");
                return;
            }
        }
        f30485a = new d();
    }

    public d() {
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

    public static List<String> a(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, x509Certificate)) == null) {
            List<String> b2 = b(x509Certificate, 7);
            List<String> b3 = b(x509Certificate, 2);
            ArrayList arrayList = new ArrayList(b2.size() + b3.size());
            arrayList.addAll(b2);
            arrayList.addAll(b3);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<String> b(X509Certificate x509Certificate, int i2) {
        InterceptResult invokeLI;
        Integer num;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, x509Certificate, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
                if (subjectAlternativeNames == null) {
                    return Collections.emptyList();
                }
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i2 && (str = (String) list.get(1)) != null) {
                        arrayList.add(str);
                    }
                }
                return arrayList;
            } catch (CertificateParsingException unused) {
                return Collections.emptyList();
            }
        }
        return (List) invokeLI.objValue;
    }

    public boolean c(String str, X509Certificate x509Certificate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, x509Certificate)) == null) {
            if (b.d.b.e0.e.I(str)) {
                return f(str, x509Certificate);
            }
            return e(str, x509Certificate);
        }
        return invokeLL.booleanValue;
    }

    public boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith(IStringUtil.TOP_PATH) && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith(IStringUtil.TOP_PATH)) {
                if (!str.endsWith(".")) {
                    str = str + '.';
                }
                if (!str2.endsWith(".")) {
                    str2 = str2 + '.';
                }
                String lowerCase = str2.toLowerCase(Locale.US);
                if (!lowerCase.contains("*")) {
                    return str.equals(lowerCase);
                }
                if (!lowerCase.startsWith(CertificatePinner.Pin.WILDCARD) || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || CertificatePinner.Pin.WILDCARD.equals(lowerCase)) {
                    return false;
                }
                String substring = lowerCase.substring(1);
                if (str.endsWith(substring)) {
                    int length = str.length() - substring.length();
                    return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean e(String str, X509Certificate x509Certificate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, x509Certificate)) == null) {
            String lowerCase = str.toLowerCase(Locale.US);
            for (String str2 : b(x509Certificate, 2)) {
                if (d(lowerCase, str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean f(String str, X509Certificate x509Certificate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, x509Certificate)) == null) {
            List<String> b2 = b(x509Certificate, 7);
            int size = b2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (str.equalsIgnoreCase(b2.get(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, sSLSession)) == null) {
            try {
                return c(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            } catch (SSLException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
