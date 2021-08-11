package c.d.b;

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
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final g f31845c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<b> f31846a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final c.d.b.e0.o.c f31847b;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<b> f31848a;

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
            this.f31848a = new ArrayList();
        }

        public g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new g(new LinkedHashSet(this.f31848a), null) : (g) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f31849a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31850b;

        /* renamed from: c  reason: collision with root package name */
        public final String f31851c;

        /* renamed from: d  reason: collision with root package name */
        public final ByteString f31852d;

        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.f31849a.startsWith(CertificatePinner.Pin.WILDCARD)) {
                    int indexOf = str.indexOf(46);
                    if ((str.length() - indexOf) - 1 == this.f31850b.length()) {
                        String str2 = this.f31850b;
                        if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                            return true;
                        }
                    }
                    return false;
                }
                return str.equals(this.f31850b);
            }
            return invokeL.booleanValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (this.f31849a.equals(bVar.f31849a) && this.f31851c.equals(bVar.f31851c) && this.f31852d.equals(bVar.f31852d)) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((((527 + this.f31849a.hashCode()) * 31) + this.f31851c.hashCode()) * 31) + this.f31852d.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.f31851c + this.f31852d.base64();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810733116, "Lc/d/b/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810733116, "Lc/d/b/g;");
                return;
            }
        }
        f31845c = new a().a();
    }

    public g(Set<b> set, @Nullable c.d.b.e0.o.c cVar) {
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
        this.f31846a = set;
        this.f31847b = cVar;
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
            c.d.b.e0.o.c cVar = this.f31847b;
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
                    if (bVar.f31851c.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = e(x509Certificate);
                        }
                        if (bVar.f31852d.equals(byteString)) {
                            return;
                        }
                    } else if (bVar.f31851c.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = d(x509Certificate);
                        }
                        if (bVar.f31852d.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f31851c);
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
            for (b bVar : this.f31846a) {
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
                if (c.d.b.e0.e.p(this.f31847b, gVar.f31847b) && this.f31846a.equals(gVar.f31846a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public g f(@Nullable c.d.b.e0.o.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) ? c.d.b.e0.e.p(this.f31847b, cVar) ? this : new g(this.f31846a, cVar) : (g) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.d.b.e0.o.c cVar = this.f31847b;
            return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f31846a.hashCode();
        }
        return invokeV.intValue;
    }
}
