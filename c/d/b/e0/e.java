package c.d.b.e0;

import androidx.core.view.InputDeviceCompat;
import c.d.b.a0;
import c.d.b.c0;
import c.d.b.r;
import c.d.b.s;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f28089b;

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f28090c;

    /* renamed from: d  reason: collision with root package name */
    public static final a0 f28091d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f28092e;

    /* renamed from: f  reason: collision with root package name */
    public static final TimeZone f28093f;

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<String> f28094g;

    /* renamed from: h  reason: collision with root package name */
    public static final Method f28095h;

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f28096i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? str.compareTo(str2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f28097e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f28098f;

        public b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28097e = str;
            this.f28098f = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, this.f28097e);
                thread.setDaemon(this.f28098f);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1236852618, "Lc/d/b/e0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1236852618, "Lc/d/b/e0/e;");
                return;
            }
        }
        byte[] bArr = new byte[0];
        a = bArr;
        f28089b = new String[0];
        Method method = null;
        f28090c = c0.e(null, bArr);
        f28091d = a0.c(null, a);
        ByteString.decodeHex("efbbbf");
        ByteString.decodeHex("feff");
        ByteString.decodeHex("fffe");
        ByteString.decodeHex("0000ffff");
        ByteString.decodeHex("ffff0000");
        f28092e = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-32BE");
        Charset.forName("UTF-32LE");
        f28093f = TimeZone.getTimeZone("GMT");
        f28094g = new a();
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f28095h = method;
        f28096i = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static boolean A(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, comparator, strArr, strArr2)) == null) {
            if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static X509TrustManager B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                    return (X509TrustManager) trustManagers[0];
                }
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            } catch (GeneralSecurityException e2) {
                throw b("No System TLS", e2);
            }
        }
        return (X509TrustManager) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[CMP_L]}, finally: {[CMP_L, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, IF] complete} */
    public static boolean C(Source source, int i2, TimeUnit timeUnit) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, source, i2, timeUnit)) == null) {
            long nanoTime = System.nanoTime();
            long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
            source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i2)) + nanoTime);
            try {
                Buffer buffer = new Buffer();
                while (source.read(buffer, 8192L) != -1) {
                    buffer.clear();
                }
                if (deadlineNanoTime == Long.MAX_VALUE) {
                    source.timeout().clearDeadline();
                } else {
                    source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
                }
                return true;
            } catch (InterruptedIOException unused) {
                if (deadlineNanoTime == Long.MAX_VALUE) {
                    source.timeout().clearDeadline();
                } else {
                    source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
                }
                return false;
            } catch (Throwable th) {
                if (deadlineNanoTime == Long.MAX_VALUE) {
                    source.timeout().clearDeadline();
                } else {
                    source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
                }
                throw th;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static int D(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3)) == null) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeLII.intValue;
    }

    public static int E(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, str, i2, i3)) == null) {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                char charAt = str.charAt(i4);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i4 + 1;
                }
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static ThreadFactory F(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, str, z)) == null) ? new b(str, z) : (ThreadFactory) invokeLZ.objValue;
    }

    public static r G(List<c.d.b.e0.k.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
            r.a aVar = new r.a();
            for (c.d.b.e0.k.a aVar2 : list) {
                c.d.b.e0.a.a.b(aVar, aVar2.a.utf8(), aVar2.f28209b.utf8());
            }
            return aVar.d();
        }
        return (r) invokeL.objValue;
    }

    public static String H(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, str, i2, i3)) == null) {
            int D = D(str, i2, i3);
            return str.substring(D, E(str, D, i3));
        }
        return (String) invokeLII.objValue;
    }

    public static boolean I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? f28096i.matcher(str).matches() : invokeL.booleanValue;
    }

    public static void a(Throwable th, Throwable th2) {
        Method method;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, th, th2) == null) || (method = f28095h) == null) {
            return;
        }
        try {
            method.invoke(th, th2);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public static AssertionError b(String str, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, exc)) == null) {
            AssertionError assertionError = new AssertionError(str);
            try {
                assertionError.initCause(exc);
            } catch (IllegalStateException unused) {
            }
            return assertionError;
        }
        return (AssertionError) invokeLL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        InetAddress l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (str.contains(":")) {
                if (str.startsWith(PreferencesUtil.LEFT_MOUNT) && str.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
                    l = l(str, 1, str.length() - 1);
                } else {
                    l = l(str, 0, str.length());
                }
                if (l == null) {
                    return null;
                }
                byte[] address = l.getAddress();
                if (address.length == 16) {
                    return x(address);
                }
                throw new AssertionError("Invalid IPv6 address: '" + str + "'");
            }
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (i(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int d(String str, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{str, Long.valueOf(j2), timeUnit})) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j2);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i2 <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }
        return invokeCommon.intValue;
    }

    public static void e(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    public static void f(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static void g(Socket socket) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, socket) == null) || socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (AssertionError e2) {
            if (!z(e2)) {
                throw e2;
            }
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static String[] h(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, strArr, str)) == null) {
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[length - 1] = str;
            return strArr2;
        }
        return (String[]) invokeLL.objValue;
    }

    public static boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int j(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < '0' || c2 > '9') {
                char c3 = 'a';
                if (c2 < 'a' || c2 > 'f') {
                    c3 = 'A';
                    if (c2 < 'A' || c2 > 'F') {
                        return -1;
                    }
                }
                return (c2 - c3) + 10;
            }
            return c2 - '0';
        }
        return invokeCommon.intValue;
    }

    public static boolean k(String str, int i2, int i3, byte[] bArr, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), bArr, Integer.valueOf(i4)})) == null) {
            int i5 = i4;
            while (i2 < i3) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i4) {
                    if (str.charAt(i2) != '.') {
                        return false;
                    }
                    i2++;
                }
                int i6 = i2;
                int i7 = 0;
                while (i6 < i3) {
                    char charAt = str.charAt(i6);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i6++;
                    }
                }
                if (i6 - i2 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i7;
                i5++;
                i2 = i6;
            }
            return i5 == i4 + 4;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0053  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InetAddress l(String str, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65557, null, str, i2, i3)) == null) {
            byte[] bArr = new byte[16];
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i2 < i3) {
                    if (i5 != 16) {
                        int i8 = i2 + 2;
                        if (i8 <= i3 && str.regionMatches(i2, "::", 0, 2)) {
                            if (i6 == -1) {
                                i5 += 2;
                                i6 = i5;
                                if (i8 != i3) {
                                    i7 = i8;
                                    i2 = i7;
                                    int i9 = 0;
                                    while (i2 < i3) {
                                    }
                                    i4 = i2 - i7;
                                    if (i4 == 0) {
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            return null;
                        }
                        if (i5 != 0) {
                            if (str.regionMatches(i2, ":", 0, 1)) {
                                i2++;
                            } else if (!str.regionMatches(i2, ".", 0, 1) || !k(str, i7, i3, bArr, i5 - 2)) {
                                return null;
                            } else {
                                i5 += 2;
                            }
                        }
                        i7 = i2;
                        i2 = i7;
                        int i92 = 0;
                        while (i2 < i3) {
                            int j2 = j(str.charAt(i2));
                            if (j2 == -1) {
                                break;
                            }
                            i92 = (i92 << 4) + j2;
                            i2++;
                        }
                        i4 = i2 - i7;
                        if (i4 == 0 || i4 > 4) {
                            break;
                        }
                        int i10 = i5 + 1;
                        bArr[i5] = (byte) ((i92 >>> 8) & 255);
                        i5 = i10 + 1;
                        bArr[i10] = (byte) (i92 & 255);
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            if (i5 != 16) {
                if (i6 == -1) {
                    return null;
                }
                int i11 = i5 - i6;
                System.arraycopy(bArr, i6, bArr, 16 - i11, i11);
                Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }
        return (InetAddress) invokeLII.objValue;
    }

    public static int m(String str, int i2, int i3, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(c2)})) == null) {
            while (i2 < i3) {
                if (str.charAt(i2) == c2) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static int n(String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
            while (i2 < i3) {
                if (str2.indexOf(str.charAt(i2)) != -1) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static boolean o(Source source, int i2, TimeUnit timeUnit) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65560, null, source, i2, timeUnit)) == null) {
            try {
                return C(source, i2, timeUnit);
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static boolean p(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static String q(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, str, objArr)) == null) ? String.format(Locale.US, str, objArr) : (String) invokeLL.objValue;
    }

    public static String r(s sVar, boolean z) {
        InterceptResult invokeLZ;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65563, null, sVar, z)) == null) {
            if (sVar.l().contains(":")) {
                l = PreferencesUtil.LEFT_MOUNT + sVar.l() + PreferencesUtil.RIGHT_MOUNT;
            } else {
                l = sVar.l();
            }
            if (z || sVar.w() != s.d(sVar.A())) {
                return l + ":" + sVar.w();
            }
            return l;
        }
        return (String) invokeLZ.objValue;
    }

    public static <T> List<T> s(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, list)) == null) ? Collections.unmodifiableList(new ArrayList(list)) : (List) invokeL.objValue;
    }

    public static <T> List<T> t(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, tArr)) == null) ? Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone())) : (List) invokeL.objValue;
    }

    public static <K, V> Map<K, V> u(Map<K, V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, map)) == null) {
            if (map.isEmpty()) {
                return Collections.emptyMap();
            }
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        return (Map) invokeL.objValue;
    }

    public static int v(Comparator<String> comparator, String[] strArr, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, comparator, strArr, str)) == null) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (comparator.compare(strArr[i2], str) == 0) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static int w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String x(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, bArr)) == null) {
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            int i5 = 0;
            while (i4 < bArr.length) {
                int i6 = i4;
                while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                    i6 += 2;
                }
                int i7 = i6 - i4;
                if (i7 > i5 && i7 >= 4) {
                    i3 = i4;
                    i5 = i7;
                }
                i4 = i6 + 2;
            }
            Buffer buffer = new Buffer();
            while (i2 < bArr.length) {
                if (i2 == i3) {
                    buffer.writeByte(58);
                    i2 += i5;
                    if (i2 == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i2 > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                    i2 += 2;
                }
            }
            return buffer.readUtf8();
        }
        return (String) invokeL.objValue;
    }

    public static String[] y(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, null, comparator, strArr, strArr2)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                int length = strArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (comparator.compare(str, strArr2[i2]) == 0) {
                        arrayList.add(str);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeLLL.objValue;
    }

    public static boolean z(AssertionError assertionError) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, assertionError)) == null) ? (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true : invokeL.booleanValue;
    }
}
