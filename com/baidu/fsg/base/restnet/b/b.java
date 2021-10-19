package com.baidu.fsg.base.restnet.b;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* loaded from: classes5.dex */
public class b implements HostnameVerifier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f39437a;

    public b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39437a = cVar;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        InterceptResult invokeLL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                eVar = this.f39437a.f39442e;
                String n = eVar.a().n();
                if (!TextUtils.isEmpty(n) && peerCertificates != null && peerCertificates.length > 0) {
                    X509Certificate x509Certificate = (X509Certificate) peerCertificates[0];
                    Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
                    if (subjectAlternativeNames != null) {
                        for (List<?> list : subjectAlternativeNames) {
                            if (((Integer) list.get(0)).intValue() == 2) {
                                String str2 = (String) list.get(1);
                                if (n.equals(str2)) {
                                    return true;
                                }
                                if (str2 != null && str2.startsWith("*") && Pattern.compile(str2.replace("*", "(\\w*-*\\w*)")).matcher(n).matches()) {
                                    return true;
                                }
                            }
                        }
                    } else {
                        String name = x509Certificate.getSubjectDN().getName();
                        if (!TextUtils.isEmpty(name) && name.contains("CN=")) {
                            int indexOf = name.indexOf("CN=") + 3;
                            int indexOf2 = name.indexOf(",", indexOf);
                            if (n.equals(indexOf2 > indexOf ? name.substring(indexOf, indexOf2) : name.substring(indexOf))) {
                                return true;
                            }
                        }
                    }
                }
            } catch (CertificateParsingException e2) {
                e2.printStackTrace();
            } catch (SSLPeerUnverifiedException e3) {
                e3.printStackTrace();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
