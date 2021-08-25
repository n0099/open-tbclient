package c.f.a.b;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes4.dex */
public class b implements X509TrustManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final X509TrustManager f32119a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<c> f32120b;

    public b(@NonNull Set<c> set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32119a = d.a();
        this.f32120b = set;
    }

    public static boolean a(List<X509Certificate> list, Set<c> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, set)) == null) {
            for (X509Certificate x509Certificate : list) {
                if (set.contains(new c(x509Certificate))) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, x509CertificateArr, str) == null) {
            this.f32119a.checkClientTrusted(x509CertificateArr, str);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str) == null) {
            this.f32119a.checkServerTrusted(x509CertificateArr, str);
            if (this.f32120b.isEmpty() || a(Arrays.asList(x509CertificateArr), this.f32120b)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Pin verification failed");
            sb.append("\n  Configured pins: ");
            for (c cVar : this.f32120b) {
                sb.append(cVar);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("\n  Peer certificate chain: ");
            for (Certificate certificate : Arrays.asList(x509CertificateArr)) {
                sb.append("\n    ");
                sb.append(new c(certificate));
                sb.append(" - ");
                sb.append(((X509Certificate) certificate).getSubjectDN());
            }
            throw new CertificateException(sb.toString());
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32119a.getAcceptedIssuers() : (X509Certificate[]) invokeV.objValue;
    }
}
