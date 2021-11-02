package b.d.b;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.beans.WalletHomeBeanFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final Comparator<String> f30494b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, h> f30495c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f30496d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f30497e;

    /* renamed from: f  reason: collision with root package name */
    public static final h f30498f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f30499g;

    /* renamed from: h  reason: collision with root package name */
    public static final h f30500h;

    /* renamed from: i  reason: collision with root package name */
    public static final h f30501i;
    public static final h j;
    public static final h k;
    public static final h l;
    public static final h m;
    public static final h n;
    public static final h o;
    public static final h p;
    public static final h q;
    public static final h r;
    public static final h s;
    public static final h t;
    public static final h u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f30502a;

    /* loaded from: classes6.dex */
    public class a implements Comparator<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                int min = Math.min(str.length(), str2.length());
                for (int i2 = 4; i2 < min; i2++) {
                    char charAt = str.charAt(i2);
                    char charAt2 = str2.charAt(i2);
                    if (charAt != charAt2) {
                        return charAt < charAt2 ? -1 : 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(741423876, "Lb/d/b/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(741423876, "Lb/d/b/h;");
                return;
            }
        }
        f30494b = new a();
        f30495c = new LinkedHashMap();
        c("SSL_RSA_WITH_NULL_MD5", 1);
        c("SSL_RSA_WITH_NULL_SHA", 2);
        c("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        c("SSL_RSA_WITH_RC4_128_MD5", 4);
        c("SSL_RSA_WITH_RC4_128_SHA", 5);
        c("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        c("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f30496d = c("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        c("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        c("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        c("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        c("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        c("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        c("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        c("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        c("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        c("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        c("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        c("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        c("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        c("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        c("TLS_KRB5_WITH_RC4_128_SHA", 32);
        c("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        c("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        c("TLS_KRB5_WITH_RC4_128_MD5", 36);
        c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        c("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        c("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f30497e = c("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        c("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f30498f = c("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        c("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        c("TLS_RSA_WITH_NULL_SHA256", 59);
        c("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        c("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        c("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        c("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        c("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        c("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        c("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        c("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        c("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        c("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        c("TLS_PSK_WITH_RC4_128_SHA", 138);
        c("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        c("TLS_PSK_WITH_AES_128_CBC_SHA", PbFullScreenEditorActivity.REPLY_MAX_SIZE);
        c("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        c("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f30499g = c("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f30500h = c("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        c("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        c("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
        c("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        c("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        c("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        c("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        c("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        c("TLS_FALLBACK_SCSV", 22016);
        c("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        c("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        c("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", WalletHomeBeanFactory.BEAN_ID_HOME_CFG);
        c("TLS_ECDHE_ECDSA_WITH_NULL_SHA", WalletHomeBeanFactory.BEAN_ID_HOMETAB);
        c("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        c("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        c("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        c("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        c("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        c("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        c("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        c("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f30501i = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        j = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        c("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        c("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        c("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        c("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        c("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        k = c("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        l = c("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        c("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        c("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        m = c("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        n = c("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        c("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        c("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        c("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        c("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        o = c("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        p = c("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        c("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        c("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        q = c("TLS_AES_128_GCM_SHA256", 4865);
        r = c("TLS_AES_256_GCM_SHA384", 4866);
        s = c("TLS_CHACHA20_POLY1305_SHA256", 4867);
        t = c("TLS_AES_128_CCM_SHA256", 4868);
        u = c("TLS_AES_256_CCM_8_SHA256", 4869);
    }

    public h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (str != null) {
            this.f30502a = str;
            return;
        }
        throw null;
    }

    public static synchronized h a(String str) {
        InterceptResult invokeL;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (h.class) {
                hVar = f30495c.get(str);
                if (hVar == null) {
                    hVar = f30495c.get(e(str));
                    if (hVar == null) {
                        hVar = new h(str);
                    }
                    f30495c.put(str, hVar);
                }
            }
            return hVar;
        }
        return (h) invokeL.objValue;
    }

    public static List<h> b(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, strArr)) == null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(a(str));
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static h c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) {
            h hVar = new h(str);
            f30495c.put(str, hVar);
            return hVar;
        }
        return (h) invokeLI.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str.startsWith("TLS_")) {
                return "SSL_" + str.substring(4);
            } else if (str.startsWith("SSL_")) {
                return "TLS_" + str.substring(4);
            } else {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30502a : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30502a : (String) invokeV.objValue;
    }
}
