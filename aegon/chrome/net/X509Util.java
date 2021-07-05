package aegon.chrome.net;

import aegon.chrome.base.ContextUtils;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes.dex */
public class X509Util {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static final char[] HEX_DIGITS;
    public static CertificateFactory sCertificateFactory;
    public static X509TrustManagerImplementation sDefaultTrustManager;
    public static boolean sLoadedSystemKeyStore;
    public static final Object sLock;
    public static File sSystemCertificateDirectory;
    public static KeyStore sSystemKeyStore;
    public static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    public static KeyStore sTestKeyStore;
    public static X509TrustManagerImplementation sTestTrustManager;
    public static TrustStorageListener sTrustStorageListener;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: aegon.chrome.net.X509Util$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static final class TrustStorageListener extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ TrustStorageListener(AnonymousClass1 anonymousClass1) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                boolean z = false;
                if (Build.VERSION.SDK_INT < 26) {
                    z = "android.security.STORAGE_CHANGED".equals(intent.getAction());
                } else if ("android.security.action.KEYCHAIN_CHANGED".equals(intent.getAction()) || "android.security.action.TRUST_STORE_CHANGED".equals(intent.getAction()) || ("android.security.action.KEY_ACCESS_CHANGED".equals(intent.getAction()) && !intent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false))) {
                    z = true;
                }
                if (z) {
                    try {
                        X509Util.reloadDefaultTrustManager();
                    } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                        Log.e("X509Util", "Unable to reload the default TrustManager", e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class X509TrustManagerIceCreamSandwich implements X509TrustManagerImplementation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final X509TrustManager mTrustManager;

        public X509TrustManagerIceCreamSandwich(X509TrustManager x509TrustManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509TrustManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTrustManager = x509TrustManager;
        }

        @Override // aegon.chrome.net.X509Util.X509TrustManagerImplementation
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, x509CertificateArr, str, str2)) == null) {
                this.mTrustManager.checkServerTrusted(x509CertificateArr, str);
                return Collections.emptyList();
            }
            return (List) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface X509TrustManagerImplementation {
        List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2);
    }

    /* loaded from: classes.dex */
    public static final class X509TrustManagerJellyBean implements X509TrustManagerImplementation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final X509TrustManagerExtensions mTrustManagerExtensions;

        @SuppressLint({"NewApi"})
        public X509TrustManagerJellyBean(X509TrustManager x509TrustManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509TrustManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        }

        @Override // aegon.chrome.net.X509Util.X509TrustManagerImplementation
        @SuppressLint({"NewApi"})
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, x509CertificateArr, str, str2)) == null) ? this.mTrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, str2) : (List) invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-957563643, "Laegon/chrome/net/X509Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-957563643, "Laegon/chrome/net/X509Util;");
                return;
            }
        }
        sLock = new Object();
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public X509Util() {
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

    public static void addTestRootCertificate(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bArr) == null) {
            ensureInitialized();
            X509Certificate createCertificateFromBytes = createCertificateFromBytes(bArr);
            synchronized (sLock) {
                KeyStore keyStore = sTestKeyStore;
                StringBuilder sb = new StringBuilder();
                sb.append("root_cert_");
                sb.append(Integer.toString(sTestKeyStore.size()));
                keyStore.setCertificateEntry(sb.toString(), createCertificateFromBytes);
                reloadTestTrustManager();
            }
        }
    }

    public static void clearTestRootCertificates() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            ensureInitialized();
            synchronized (sLock) {
                try {
                    sTestKeyStore.load(null);
                    reloadTestTrustManager();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static X509Certificate createCertificateFromBytes(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, bArr)) == null) {
            ensureInitialized();
            return (X509Certificate) sCertificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
        }
        return (X509Certificate) invokeL.objValue;
    }

    public static X509TrustManagerImplementation createTrustManager(KeyStore keyStore) {
        InterceptResult invokeL;
        TrustManager[] trustManagers;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, keyStore)) == null) {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    try {
                        return Build.VERSION.SDK_INT >= 17 ? new X509TrustManagerJellyBean((X509TrustManager) trustManager) : new X509TrustManagerIceCreamSandwich((X509TrustManager) trustManager);
                    } catch (IllegalArgumentException e2) {
                        Log.e("X509Util", "Error creating trust manager (" + trustManager.getClass().getName() + "): " + e2);
                    }
                }
            }
            Log.e("X509Util", "Could not find suitable trust manager");
            return null;
        }
        return (X509TrustManagerImplementation) invokeL.objValue;
    }

    public static void ensureInitialized() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            synchronized (sLock) {
                ensureInitializedLocked();
            }
        }
    }

    public static void ensureInitializedLocked() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            if (sCertificateFactory == null) {
                sCertificateFactory = CertificateFactory.getInstance("X.509");
            }
            if (sDefaultTrustManager == null) {
                sDefaultTrustManager = createTrustManager(null);
            }
            if (!sLoadedSystemKeyStore) {
                try {
                    KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                    sSystemKeyStore = keyStore;
                    try {
                        keyStore.load(null);
                    } catch (IOException unused) {
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.getenv("ANDROID_ROOT"));
                    sb.append("/etc/security/cacerts");
                    sSystemCertificateDirectory = new File(sb.toString());
                } catch (KeyStoreException unused2) {
                }
                sLoadedSystemKeyStore = true;
            }
            if (sSystemTrustAnchorCache == null) {
                sSystemTrustAnchorCache = new HashSet();
            }
            if (sTestKeyStore == null) {
                KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
                sTestKeyStore = keyStore2;
                try {
                    keyStore2.load(null);
                } catch (IOException unused3) {
                }
            }
            if (sTestTrustManager == null) {
                sTestTrustManager = createTrustManager(sTestKeyStore);
            }
            if (sTrustStorageListener == null) {
                sTrustStorageListener = new TrustStorageListener(null);
                IntentFilter intentFilter = new IntentFilter();
                if (Build.VERSION.SDK_INT >= 26) {
                    intentFilter.addAction("android.security.action.KEYCHAIN_CHANGED");
                    intentFilter.addAction("android.security.action.KEY_ACCESS_CHANGED");
                    str = "android.security.action.TRUST_STORE_CHANGED";
                } else {
                    str = "android.security.STORAGE_CHANGED";
                }
                intentFilter.addAction(str);
                ContextUtils.sApplicationContext.registerReceiver(sTrustStorageListener, intentFilter);
            }
        }
    }

    public static boolean isKnownRoot(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65544, null, x509Certificate)) != null) {
            return invokeL.booleanValue;
        }
        if (sSystemKeyStore == null) {
            return false;
        }
        Pair<X500Principal, PublicKey> pair = new Pair<>(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
        if (sSystemTrustAnchorCache.contains(pair)) {
            return true;
        }
        byte[] digest = MessageDigest.getInstance("MD5").digest(x509Certificate.getSubjectX500Principal().getEncoded());
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 * 2;
            char[] cArr2 = HEX_DIGITS;
            int i4 = 3 - i2;
            cArr[i3] = cArr2[(digest[i4] >> 4) & 15];
            cArr[i3 + 1] = cArr2[digest[i4] & 15];
        }
        String str = new String(cArr);
        int i5 = 0;
        while (true) {
            String str2 = str + IStringUtil.EXTENSION_SEPARATOR + i5;
            if (!new File(sSystemCertificateDirectory, str2).exists()) {
                return false;
            }
            Certificate certificate = sSystemKeyStore.getCertificate("system:" + str2);
            if (certificate != null) {
                if (certificate instanceof X509Certificate) {
                    X509Certificate x509Certificate2 = (X509Certificate) certificate;
                    if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                        sSystemTrustAnchorCache.add(pair);
                        return true;
                    }
                } else {
                    Log.e("X509Util", "Anchor " + str2 + " not an X509Certificate: " + certificate.getClass().getName());
                }
            }
            i5++;
        }
    }

    public static native void nativeNotifyKeyChainChanged();

    public static void reloadDefaultTrustManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            synchronized (sLock) {
                sDefaultTrustManager = null;
                sSystemTrustAnchorCache = null;
                ensureInitializedLocked();
            }
            nativeNotifyKeyChainChanged();
        }
    }

    public static void reloadTestTrustManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            sTestTrustManager = createTrustManager(sTestKeyStore);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean verifyKeyUsage(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        List<String> extendedKeyUsage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, x509Certificate)) == null) {
            try {
                extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
            } catch (NullPointerException unused) {
            }
            if (extendedKeyUsage == null) {
                return true;
            }
            for (String str : extendedKeyUsage) {
                if (str.equals("1.3.6.1.5.5.7.3.1") || str.equals("2.5.29.37.0") || str.equals("2.16.840.1.113730.4.1") || str.equals("1.3.6.1.4.1.311.10.3.3")) {
                    return true;
                }
                while (r4.hasNext()) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        InterceptResult invokeLLL;
        List<X509Certificate> checkServerTrusted;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, bArr, str, str2)) == null) {
            if (bArr == null || bArr.length == 0 || bArr[0] == null) {
                throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(bArr));
            }
            try {
                ensureInitialized();
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(createCertificateFromBytes(bArr[0]));
                    for (int i2 = 1; i2 < bArr.length; i2++) {
                        try {
                            arrayList.add(createCertificateFromBytes(bArr[i2]));
                        } catch (CertificateException unused) {
                            Log.w("X509Util", "intermediate " + i2 + " failed parsing");
                        }
                    }
                    X509Certificate[] x509CertificateArr = (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                    try {
                        x509CertificateArr[0].checkValidity();
                        if (verifyKeyUsage(x509CertificateArr[0])) {
                            synchronized (sLock) {
                                if (sDefaultTrustManager == null) {
                                    return new AndroidCertVerifyResult(-1);
                                }
                                try {
                                    checkServerTrusted = sDefaultTrustManager.checkServerTrusted(x509CertificateArr, str, str2);
                                } catch (CertificateException e2) {
                                    try {
                                        checkServerTrusted = sTestTrustManager.checkServerTrusted(x509CertificateArr, str, str2);
                                    } catch (CertificateException unused2) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Failed to validate the certificate chain, error: ");
                                        sb.append(e2.getMessage());
                                        Log.i("X509Util", sb.toString());
                                        return new AndroidCertVerifyResult(-2);
                                    }
                                }
                                return new AndroidCertVerifyResult(0, checkServerTrusted.size() > 0 ? isKnownRoot(checkServerTrusted.get(checkServerTrusted.size() - 1)) : false, checkServerTrusted);
                            }
                        }
                        return new AndroidCertVerifyResult(-6);
                    } catch (CertificateExpiredException unused3) {
                        return new AndroidCertVerifyResult(-3);
                    } catch (CertificateNotYetValidException unused4) {
                        return new AndroidCertVerifyResult(-4);
                    } catch (CertificateException unused5) {
                        return new AndroidCertVerifyResult(-1);
                    }
                } catch (CertificateException unused6) {
                    return new AndroidCertVerifyResult(-5);
                }
            } catch (CertificateException unused7) {
                return new AndroidCertVerifyResult(-1);
            }
        }
        return (AndroidCertVerifyResult) invokeLLL.objValue;
    }
}
