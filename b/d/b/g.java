package b.d.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.CertificatePinner;
import okio.ByteString;
/* loaded from: classes6.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final g f30486c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<b> f30487a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final b.d.b.e0.p.c f30488b;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<b> f30489a;

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
                    return;
                }
            }
            this.f30489a = new ArrayList();
        }

        public g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new g(new LinkedHashSet(this.f30489a), null) : (g) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f30490a;

        /* renamed from: b  reason: collision with root package name */
        public final String f30491b;

        /* renamed from: c  reason: collision with root package name */
        public final String f30492c;

        /* renamed from: d  reason: collision with root package name */
        public final ByteString f30493d;

        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.f30490a.startsWith(CertificatePinner.Pin.WILDCARD)) {
                    int indexOf = str.indexOf(46);
                    if ((str.length() - indexOf) - 1 == this.f30491b.length()) {
                        String str2 = this.f30491b;
                        if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                            return true;
                        }
                    }
                    return false;
                }
                return str.equals(this.f30491b);
            }
            return invokeL.booleanValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (this.f30490a.equals(bVar.f30490a) && this.f30492c.equals(bVar.f30492c) && this.f30493d.equals(bVar.f30493d)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((((527 + this.f30490a.hashCode()) * 31) + this.f30492c.hashCode()) * 31) + this.f30493d.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.f30492c + this.f30493d.base64();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(741423845, "Lb/d/b/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(741423845, "Lb/d/b/g;");
                return;
            }
        }
        f30486c = new a().a();
    }

    public g(Set<b> set, @Nullable b.d.b.e0.p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30487a = set;
        this.f30488b = cVar;
    }

    public static String c(Certificate certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, certificate)) == null) {
            if (certificate instanceof X509Certificate) {
                return "sha256/" + e((X509Certificate) certificate).base64();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return (String) invokeL.objValue;
    }

    public static ByteString d(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x509Certificate)) == null) ? ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1() : (ByteString) invokeL.objValue;
    }

    public static ByteString e(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, x509Certificate)) == null) ? ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256() : (ByteString) invokeL.objValue;
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            List<b> b2 = b(str);
            if (b2.isEmpty()) {
                return;
            }
            b.d.b.e0.p.c cVar = this.f30488b;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = b2.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    b bVar = b2.get(i3);
                    if (bVar.f30492c.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = e(x509Certificate);
                        }
                        if (bVar.f30493d.equals(byteString)) {
                            return;
                        }
                    } else if (bVar.f30492c.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = d(x509Certificate);
                        }
                        if (bVar.f30493d.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f30492c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                sb.append("\n    ");
                sb.append(c(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = b2.size();
            for (int i5 = 0; i5 < size4; i5++) {
                sb.append("\n    ");
                sb.append(b2.get(i5));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public List<b> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            List<b> emptyList = Collections.emptyList();
            for (b bVar : this.f30487a) {
                if (bVar.a(str)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(bVar);
                }
            }
            return emptyList;
        }
        return (List) invokeL.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (b.d.b.e0.e.p(this.f30488b, gVar.f30488b) && this.f30487a.equals(gVar.f30487a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public g f(@Nullable b.d.b.e0.p.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) ? b.d.b.e0.e.p(this.f30488b, cVar) ? this : new g(this.f30487a, cVar) : (g) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.d.b.e0.p.c cVar = this.f30488b;
            return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f30487a.hashCode();
        }
        return invokeV.intValue;
    }
}
