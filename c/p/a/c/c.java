package c.p.a.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f34559a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f34560a;

        /* renamed from: b  reason: collision with root package name */
        public int f34561b;

        /* renamed from: c  reason: collision with root package name */
        public int f34562c;

        /* renamed from: d  reason: collision with root package name */
        public long f34563d;

        /* renamed from: e  reason: collision with root package name */
        public String f34564e;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1242638775, "Lc/p/a/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1242638775, "Lc/p/a/c/c;");
                return;
            }
        }
        f34559a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static int a(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, file)) == null) {
            if (str == null || str.length() == 0) {
                return 2;
            }
            if (file != null) {
                try {
                    if (file.exists()) {
                        int i2 = -1;
                        long j2 = -1;
                        try {
                            b b2 = b(str);
                            if (b2 != null) {
                                if (b2.f34560a > 1) {
                                    return 3;
                                }
                                i2 = b2.f34562c;
                                j2 = b2.f34563d;
                            }
                            b bVar = null;
                            String k = k(file, i2, j2);
                            if (k != null && k.length() != 0) {
                                if (b2 != null && (b2.f34560a != 1 || b2.f34561b != 1)) {
                                    if (b2.f34564e != null) {
                                        try {
                                            bVar = b(k);
                                        } catch (Throwable unused) {
                                        }
                                        if (bVar != null && b2.f34562c == bVar.f34562c && b2.f34563d == bVar.f34563d && b2.f34564e.equals(bVar.f34564e)) {
                                            return 0;
                                        }
                                    }
                                }
                                return k.equals(str) ? 0 : 1;
                            }
                            return 6;
                        } catch (Throwable unused2) {
                            return 4;
                        }
                    }
                    return 5;
                } catch (Throwable unused3) {
                    return 99;
                }
            }
            return 5;
        }
        return invokeLL.intValue;
    }

    public static b b(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.startsWith("ttmd5:")) {
                String[] split = str.split(";");
                String[] split2 = split[0].split(":");
                b bVar = new b(null);
                bVar.f34560a = Integer.parseInt(split2[1]);
                if (bVar.f34560a > 1) {
                    return bVar;
                }
                bVar.f34561b = Integer.parseInt(split2[2]);
                String[] split3 = split2[3].split("g");
                bVar.f34562c = (int) j(split3[0]);
                bVar.f34563d = j(split3[1]);
                bVar.f34564e = split[1];
                return bVar;
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static String c(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            return "ttmd5:1:1:" + d(i2) + "g" + d(j2);
        }
        return (String) invokeCommon.objValue;
    }

    public static String d(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2)) == null) ? Long.toHexString((j2 << 4) + 31) : (String) invokeJ.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(13:7|8|(6:15|16|(3:18|(1:20)|21)|(1:23)|24|(4:33|35|36|37)(3:28|29|30))|40|16|(0)|(0)|24|(1:26)|33|35|36|37) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:8:0x0011, B:12:0x001e, B:17:0x0032, B:19:0x0044, B:21:0x0051, B:23:0x0068, B:24:0x0072, B:30:0x0084), top: B:43:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:8:0x0011, B:12:0x001e, B:17:0x0032, B:19:0x0044, B:21:0x0051, B:23:0x0068, B:24:0x0072, B:30:0x0084), top: B:43:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(c.p.a.c.b bVar, int i2, long j2) throws Exception {
        InterceptResult invokeCommon;
        long j3;
        String h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{bVar, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            int i3 = i2;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                return "";
            }
            try {
                long a2 = bVar.a();
                if (i3 > 0 && j2 > 0 && i3 * j2 <= (8 * a2) / 10) {
                    j3 = j2;
                    byte[] bArr = new byte[8192];
                    long j4 = 0;
                    i(bVar, messageDigest, bArr, 0L, j3);
                    if (i3 > 2) {
                        int i4 = i3 - 1;
                        long j5 = (a2 - (i3 * j3)) / i4;
                        int i5 = 1;
                        while (i5 < i4) {
                            j4 += j3 + j5;
                            i(bVar, messageDigest, bArr, j4, j3);
                            i5++;
                            i4 = i4;
                        }
                    }
                    if (i3 > 1) {
                        i(bVar, messageDigest, bArr, a2 - j3, j3);
                    }
                    h2 = h(messageDigest.digest());
                    if (i3 == 1 || j3 != a2) {
                        String str = c(i3, j3) + ";" + h2;
                        bVar.b();
                        return str;
                    }
                    return h2;
                }
                j3 = a2;
                i3 = 1;
                byte[] bArr2 = new byte[8192];
                long j42 = 0;
                i(bVar, messageDigest, bArr2, 0L, j3);
                if (i3 > 2) {
                }
                if (i3 > 1) {
                }
                h2 = h(messageDigest.digest());
                if (i3 == 1) {
                }
                String str2 = c(i3, j3) + ";" + h2;
                bVar.b();
                return str2;
            } finally {
                try {
                    bVar.b();
                } catch (Throwable unused) {
                }
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String f(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, file)) == null) ? g(file, 9, 8192L) : (String) invokeL.objValue;
    }

    public static String g(File file, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{file, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        return k(file, i2, j2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    public static String h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            if (bArr != null) {
                int length = bArr.length;
                int i2 = length * 2;
                char[] cArr = new char[i2];
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = bArr[i4 + 0] & 255;
                    int i6 = i3 + 1;
                    char[] cArr2 = f34559a;
                    cArr[i3] = cArr2[i5 >> 4];
                    i3 = i6 + 1;
                    cArr[i6] = cArr2[i5 & 15];
                }
                return new String(cArr, 0, i2);
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeL.objValue;
    }

    public static void i(c.p.a.c.b bVar, MessageDigest messageDigest, byte[] bArr, long j2, long j3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{bVar, messageDigest, bArr, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            bVar.a(j2, j3);
            long j4 = 0;
            while (j4 < j3) {
                int a2 = bVar.a(bArr, 0, (int) Math.min(j3 - j4, bArr.length));
                if (a2 > 0) {
                    messageDigest.update(bArr, 0, a2);
                    j4 += a2;
                } else {
                    throw new IOException("updateSample unexpected readCount <= 0, readCount = " + a2 + ", readTotalCount = " + j4 + ", sampleSize = " + j3);
                }
            }
        }
    }

    public static long j(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? (Long.parseLong(str, 16) - 31) >> 4 : invokeL.longValue;
    }

    public static String k(File file, int i2, long j2) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{file, Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? e(new c.p.a.c.a(file), i2, j2) : (String) invokeCommon.objValue;
    }
}
