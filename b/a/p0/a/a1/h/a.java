package b.a.p0.a.a1.h;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.h.b;
import b.a.p0.a.a1.h.c;
import b.a.p0.a.e0.d;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3920a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f3921b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicInteger f3922c;

    /* renamed from: d  reason: collision with root package name */
    public static CharSequence f3923d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.a1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0110a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f3924a;

        /* renamed from: b  reason: collision with root package name */
        public String f3925b;

        public C0110a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3924a = z;
            this.f3925b = "";
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BufferedInputStream f3926a;

        /* renamed from: b  reason: collision with root package name */
        public int f3927b;

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
                    return;
                }
            }
            this.f3927b = -1;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-291496694, "Lb/a/p0/a/a1/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-291496694, "Lb/a/p0/a/a1/h/a;");
                return;
            }
        }
        f3920a = k.f6397a;
        b.a.p0.a.c1.a.Z().getSwitch("swan_pkg_download_finish_unzip_safely", false);
        f3921b = false;
        f3922c = new AtomicInteger(0);
        f3923d = "._";
    }

    public static boolean a(int i2, @NonNull File file, int i3, @NonNull C0110a c0110a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), file, Integer.valueOf(i3), c0110a})) == null) {
            if (i2 > 0) {
                String str = i2 + " files write error";
                c0110a.f3925b = str;
                d.h("BundleDecrypt", str);
                b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                aVar.j(4L);
                aVar.h(52L);
                dVar.p(aVar);
                dVar.l("path", file.getAbsolutePath());
                dVar.l("eMsg", str);
                dVar.l("decryptType", String.valueOf(i3));
                dVar.l("stack", q0.z(30));
                b.a.p0.a.j2.k.L(dVar);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @NonNull
    public static Pair<Boolean, File> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File file = new File(b.a.p0.a.c1.a.b().getFilesDir(), "swan_tmp_unzip");
            b.a.p0.t.d.k(file);
            File file2 = new File(file, System.nanoTime() + "_" + f3922c.incrementAndGet());
            boolean k = b.a.p0.t.d.k(file2);
            d.h("BundleDecrypt", "#createTmpUnzipDir tmpUnzipDir=" + file2 + " dirExist=" + k);
            return new Pair<>(Boolean.valueOf(k), file2);
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x01ed */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020b  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0110a c(BufferedInputStream bufferedInputStream, File file, int i2) {
        ?? r17;
        long j;
        DataInputStream dataInputStream;
        byte[] e2;
        DataInputStream dataInputStream2;
        DataInputStream dataInputStream3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r17 = 65539;
            InterceptResult invokeLLI = interceptable.invokeLLI(65539, null, bufferedInputStream, file, i2);
            if (invokeLLI != null) {
                return (C0110a) invokeLLI.objValue;
            }
        }
        if (f3921b) {
            d.h("BundleDecrypt", "命中开关，#decryptSafely dstFolder=" + file + " type=" + i2);
            return f(bufferedInputStream, file, i2);
        }
        long nanoTime = f3920a ? System.nanoTime() : 0L;
        C0110a c0110a = new C0110a(false);
        if (file == null || bufferedInputStream == null || i2 == 0) {
            return c0110a;
        }
        if (f3920a) {
            String str = "type :" + i2;
        }
        b.a.p0.a.a1.h.b bVar = new b.a.p0.a.a1.h.b();
        DataInputStream dataInputStream4 = null;
        try {
            try {
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (Exception e3) {
                e = e3;
                j = nanoTime;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                k(dataInputStream);
                bVar.f3928a = k(dataInputStream);
                bVar.f3929b = k(dataInputStream);
                k(dataInputStream);
                l(dataInputStream);
                dataInputStream.readFully(bVar.f3930c);
                e2 = e(bVar.f3930c);
                try {
                } catch (Exception e4) {
                    e = e4;
                    dataInputStream4 = dataInputStream;
                    j = r17;
                    c0110a.f3925b = e.getLocalizedMessage();
                    boolean z = f3920a;
                    b.a.p0.t.d.d(dataInputStream4);
                    if (f3920a) {
                    }
                    return c0110a;
                }
            } catch (Exception e5) {
                e = e5;
                r17 = nanoTime;
            }
            if (e2 != null && e2.length > 0) {
                byte[] bArr = new byte[bVar.f3929b];
                dataInputStream.readFully(bArr);
                byte[] bArr2 = new byte[16];
                byte[] bArr3 = new byte[16];
                System.arraycopy(e2, 0, bArr2, 0, 16);
                System.arraycopy(e2, 16, bArr3, 0, 16);
                byte[] d2 = d(bArr, bArr2, bArr3);
                if (d2 != null && d2.length > 0) {
                    if (i2 == 2) {
                        boolean z2 = f3920a;
                        dataInputStream2 = new DataInputStream(b.a.p0.a.c1.a.i().a(new ByteArrayInputStream(d2)));
                        dataInputStream3 = new DataInputStream(b.a.p0.a.c1.a.i().a(dataInputStream));
                    } else {
                        dataInputStream2 = new DataInputStream(new ByteArrayInputStream(d2));
                        dataInputStream3 = new DataInputStream(new GZIPInputStream(dataInputStream));
                    }
                    if (!file.exists() && !file.mkdirs()) {
                        boolean z3 = f3920a;
                        c0110a.f3925b = "create destination directory failed";
                        b.a.p0.t.d.d(dataInputStream);
                        return c0110a;
                    }
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    CountDownLatch countDownLatch = new CountDownLatch(4);
                    Handler[] handlerArr = new Handler[4];
                    int i3 = 0;
                    for (int i4 = 4; i3 < i4; i4 = 4) {
                        c cVar = new c("BundleDecrypt" + i3, file, countDownLatch, atomicInteger);
                        cVar.start();
                        handlerArr[i3] = cVar.d();
                        i3++;
                    }
                    ArrayList arrayList = new ArrayList();
                    int i5 = 0;
                    while (i5 < bVar.f3928a) {
                        b.a aVar = new b.a();
                        k(dataInputStream2);
                        b.a.p0.a.a1.h.b bVar2 = bVar;
                        aVar.f3931a = k(dataInputStream2);
                        int k = k(dataInputStream2);
                        aVar.f3932b = k;
                        byte[] bArr4 = new byte[k];
                        dataInputStream2.readFully(bArr4);
                        long j2 = nanoTime;
                        String str2 = new String(bArr4, "utf-8");
                        aVar.f3933c = str2;
                        if (str2.contains(f3923d)) {
                            dataInputStream3.skipBytes(aVar.f3931a);
                        } else {
                            byte[] bArr5 = new byte[aVar.f3931a];
                            dataInputStream3.readFully(bArr5);
                            Message obtain = Message.obtain();
                            c.C0111c c0111c = new c.C0111c();
                            c0111c.f3941b = bArr5;
                            c0111c.f3940a = aVar.f3933c;
                            obtain.what = 100;
                            obtain.obj = c0111c;
                            handlerArr[i5 % 4].sendMessage(obtain);
                            arrayList.add(aVar);
                        }
                        i5++;
                        bVar = bVar2;
                        nanoTime = j2;
                    }
                    j = nanoTime;
                    for (int i6 = 0; i6 < 4; i6++) {
                        handlerArr[i6].sendEmptyMessage(200);
                    }
                    countDownLatch.await();
                    b.a.p0.t.d.d(dataInputStream2);
                    b.a.p0.t.d.d(dataInputStream3);
                    if (a(atomicInteger.get(), file, i2, c0110a)) {
                        b.a.p0.t.d.d(dataInputStream);
                        return c0110a;
                    } else if (!m(arrayList, file, i2)) {
                        d.h("BundleDecrypt", "decrypt：unpack file check fail");
                        c0110a.f3925b = "decrypt：unpack file check fail";
                        b.a.p0.t.d.d(dataInputStream);
                        return c0110a;
                    } else {
                        c0110a.f3924a = true;
                        b.a.p0.t.d.d(dataInputStream);
                        if (f3920a) {
                            String str3 = "#decrypt dstFolder=" + file.getAbsolutePath() + " 耗时(ms): " + ((System.nanoTime() - j) / 1000000.0d);
                        }
                        return c0110a;
                    }
                }
                c0110a.f3925b = "index array length <= 0";
                b.a.p0.t.d.d(dataInputStream);
                return c0110a;
            }
            c0110a.f3925b = "cipher is null";
            b.a.p0.t.d.d(dataInputStream);
            return c0110a;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream4 = dataInputStream;
            b.a.p0.t.d.d(dataInputStream4);
            throw th;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, bArr2, bArr3)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
                boolean z = f3920a;
                return null;
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, n());
                return cipher.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
                boolean z = f3920a;
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0110a f(BufferedInputStream bufferedInputStream, File file, int i2) {
        InterceptResult invokeLLI;
        DataInputStream dataInputStream;
        long j;
        File file2;
        DataInputStream dataInputStream2;
        byte[] e2;
        DataInputStream dataInputStream3;
        DataInputStream dataInputStream4;
        AtomicInteger atomicInteger;
        CountDownLatch countDownLatch;
        String str;
        ArrayList arrayList;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, bufferedInputStream, file, i2)) == null) {
            String str5 = " 耗时(ms): ";
            String str6 = "#decryptSafely 删除临时目录: ";
            String str7 = "BundleDecrypt";
            long nanoTime = f3920a ? System.nanoTime() : 0L;
            C0110a c0110a = new C0110a(false);
            if (file == null || bufferedInputStream == null || i2 == 0) {
                return c0110a;
            }
            b.a.p0.a.a1.h.b bVar = new b.a.p0.a.a1.h.b();
            try {
                dataInputStream2 = new DataInputStream(bufferedInputStream);
                try {
                    try {
                        k(dataInputStream2);
                        bVar.f3928a = k(dataInputStream2);
                        bVar.f3929b = k(dataInputStream2);
                        k(dataInputStream2);
                        l(dataInputStream2);
                        dataInputStream2.readFully(bVar.f3930c);
                        e2 = e(bVar.f3930c);
                        try {
                        } catch (Exception e3) {
                            e = e3;
                            dataInputStream = dataInputStream2;
                            file2 = null;
                            try {
                                c0110a.f3925b = e.getLocalizedMessage();
                                d.i(str7, "#decryptSafely ex=", e);
                                b.a.p0.t.d.d(dataInputStream);
                                if (file2 != null) {
                                }
                                if (f3920a) {
                                }
                                return c0110a;
                            } catch (Throwable th) {
                                th = th;
                                b.a.p0.t.d.d(dataInputStream);
                                if (file2 != null) {
                                    d.h(str7, str6 + file2.getAbsolutePath());
                                    b.a.p0.t.d.K(file2);
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        j = nanoTime;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream = dataInputStream2;
                    file2 = null;
                    b.a.p0.t.d.d(dataInputStream);
                    if (file2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                j = nanoTime;
                dataInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream = null;
            }
            if (e2 != null && e2.length > 0) {
                byte[] bArr = new byte[bVar.f3929b];
                dataInputStream2.readFully(bArr);
                byte[] bArr2 = new byte[16];
                byte[] bArr3 = new byte[16];
                System.arraycopy(e2, 0, bArr2, 0, 16);
                System.arraycopy(e2, 16, bArr3, 0, 16);
                byte[] d2 = d(bArr, bArr2, bArr3);
                if (d2 != null && d2.length > 0) {
                    if (i2 == 2) {
                        try {
                            dataInputStream3 = new DataInputStream(b.a.p0.a.c1.a.i().a(new ByteArrayInputStream(d2)));
                            dataInputStream4 = new DataInputStream(b.a.p0.a.c1.a.i().a(dataInputStream2));
                        } catch (Exception e6) {
                            e = e6;
                            dataInputStream = dataInputStream2;
                            j = nanoTime;
                            file2 = null;
                            c0110a.f3925b = e.getLocalizedMessage();
                            d.i(str7, "#decryptSafely ex=", e);
                            b.a.p0.t.d.d(dataInputStream);
                            if (file2 != null) {
                            }
                            if (f3920a) {
                            }
                            return c0110a;
                        }
                    } else {
                        dataInputStream3 = new DataInputStream(new ByteArrayInputStream(d2));
                        dataInputStream4 = new DataInputStream(new GZIPInputStream(dataInputStream2));
                    }
                    DataInputStream dataInputStream5 = dataInputStream3;
                    DataInputStream dataInputStream6 = dataInputStream4;
                    if (!b.a.p0.t.d.k(file)) {
                        d.h("BundleDecrypt", "#decryptSafely 解压目录创建失败 path=" + file.getAbsolutePath());
                        c0110a.f3925b = "create destination directory failed";
                        b.a.p0.t.d.d(dataInputStream2);
                        return c0110a;
                    }
                    Pair<Boolean, File> b2 = b();
                    if (!((Boolean) b2.first).booleanValue()) {
                        d.h("BundleDecrypt", "#decryptSafely 临时解压目录创建失败 path=" + ((File) b2.second).getAbsolutePath());
                        c0110a.f3925b = "create temp unzip directory failed";
                        b.a.p0.t.d.d(dataInputStream2);
                        return c0110a;
                    }
                    File file3 = (File) b2.second;
                    try {
                        try {
                            atomicInteger = new AtomicInteger(0);
                            countDownLatch = new CountDownLatch(4);
                            j = nanoTime;
                            try {
                                Handler[] handlerArr = new Handler[4];
                                int i3 = 0;
                                for (int i4 = 4; i3 < i4; i4 = 4) {
                                    String str8 = str5;
                                    try {
                                        c cVar = new c("BundleDecrypt" + i3, file3, countDownLatch, atomicInteger);
                                        cVar.start();
                                        handlerArr[i3] = cVar.e();
                                        i3++;
                                        str5 = str8;
                                    } catch (Exception e7) {
                                        e = e7;
                                        dataInputStream = dataInputStream2;
                                        file2 = file3;
                                        str5 = str8;
                                        c0110a.f3925b = e.getLocalizedMessage();
                                        d.i(str7, "#decryptSafely ex=", e);
                                        b.a.p0.t.d.d(dataInputStream);
                                        if (file2 != null) {
                                            d.h(str7, str6 + file2.getAbsolutePath());
                                            b.a.p0.t.d.K(file2);
                                        }
                                        if (f3920a) {
                                        }
                                        return c0110a;
                                    }
                                }
                                str = str5;
                                try {
                                    arrayList = new ArrayList();
                                    int i5 = 0;
                                    while (i5 < bVar.f3928a) {
                                        try {
                                            b.a q = q(dataInputStream5);
                                            b.a.p0.a.a1.h.b bVar2 = bVar;
                                            String str9 = str7;
                                            try {
                                                if (q.f3933c.contains(f3923d)) {
                                                    dataInputStream6.skipBytes(q.f3931a);
                                                    str4 = str6;
                                                } else {
                                                    byte[] bArr4 = new byte[q.f3931a];
                                                    dataInputStream6.readFully(bArr4);
                                                    Message obtain = Message.obtain();
                                                    str4 = str6;
                                                    try {
                                                        c.C0111c c0111c = new c.C0111c();
                                                        c0111c.f3941b = bArr4;
                                                        c0111c.f3940a = q.f3933c;
                                                        obtain.what = 100;
                                                        obtain.obj = c0111c;
                                                        handlerArr[i5 % 4].sendMessage(obtain);
                                                        arrayList.add(q);
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        for (int i6 = 0; i6 < 4; i6++) {
                                                            handlerArr[i6].sendEmptyMessage(200);
                                                        }
                                                        countDownLatch.await();
                                                        b.a.p0.t.d.d(dataInputStream5);
                                                        b.a.p0.t.d.d(dataInputStream6);
                                                        throw th;
                                                    }
                                                }
                                                i5++;
                                                bVar = bVar2;
                                                str7 = str9;
                                                str6 = str4;
                                            } catch (Throwable th5) {
                                                th = th5;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                        }
                                    }
                                    str2 = str6;
                                    str3 = str7;
                                    int i7 = 0;
                                    for (int i8 = 4; i7 < i8; i8 = 4) {
                                        try {
                                            handlerArr[i7].sendEmptyMessage(200);
                                            i7++;
                                        } catch (Exception e8) {
                                            e = e8;
                                            dataInputStream = dataInputStream2;
                                            file2 = file3;
                                            str5 = str;
                                            str7 = str3;
                                            str6 = str2;
                                            c0110a.f3925b = e.getLocalizedMessage();
                                            d.i(str7, "#decryptSafely ex=", e);
                                            b.a.p0.t.d.d(dataInputStream);
                                            if (file2 != null) {
                                            }
                                            if (f3920a) {
                                            }
                                            return c0110a;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            dataInputStream = dataInputStream2;
                                            file2 = file3;
                                            str7 = str3;
                                            str6 = str2;
                                            b.a.p0.t.d.d(dataInputStream);
                                            if (file2 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                    str5 = str;
                                }
                            } catch (Exception e10) {
                                e = e10;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            j = nanoTime;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                    try {
                        countDownLatch.await();
                        b.a.p0.t.d.d(dataInputStream5);
                        b.a.p0.t.d.d(dataInputStream6);
                    } catch (Exception e12) {
                        e = e12;
                        str5 = str;
                        str7 = str3;
                        str6 = str2;
                        dataInputStream = dataInputStream2;
                        file2 = file3;
                        c0110a.f3925b = e.getLocalizedMessage();
                        d.i(str7, "#decryptSafely ex=", e);
                        b.a.p0.t.d.d(dataInputStream);
                        if (file2 != null) {
                        }
                        if (f3920a) {
                        }
                        return c0110a;
                    } catch (Throwable th9) {
                        th = th9;
                        str7 = str3;
                        str6 = str2;
                        dataInputStream = dataInputStream2;
                        file2 = file3;
                        b.a.p0.t.d.d(dataInputStream);
                        if (file2 != null) {
                        }
                        throw th;
                    }
                    if (a(atomicInteger.get(), file, i2, c0110a)) {
                        b.a.p0.t.d.d(dataInputStream2);
                        if (file3 != null) {
                            d.h(str3, str2 + file3.getAbsolutePath());
                            b.a.p0.t.d.K(file3);
                        }
                        return c0110a;
                    }
                    str7 = str3;
                    str6 = str2;
                    if (!m(arrayList, file3, i2)) {
                        d.h(str7, "decrypt：unpack file check fail");
                        c0110a.f3925b = "decrypt：unpack file check fail";
                        b.a.p0.t.d.d(dataInputStream2);
                        if (file3 != null) {
                            d.h(str7, str6 + file3.getAbsolutePath());
                            b.a.p0.t.d.K(file3);
                        }
                        return c0110a;
                    }
                    long nanoTime2 = f3920a ? System.nanoTime() : 0L;
                    boolean p = p(file3, file, arrayList);
                    if (f3920a) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("#moveToDestDir dstFolder=");
                        sb.append(file.getAbsolutePath());
                        sb.append(" moveRes=");
                        sb.append(p);
                        sb.append(" fileCount=");
                        sb.append(arrayList.size());
                        str5 = str;
                        sb.append(str5);
                        sb.append((System.nanoTime() - nanoTime2) / 1000000.0d);
                        sb.toString();
                    } else {
                        str5 = str;
                    }
                    if (!p) {
                        c0110a.f3925b = "decrypt: from temp unzip dir, move to dest dir fail";
                        b.a.p0.t.d.d(dataInputStream2);
                        if (file3 != null) {
                            d.h(str7, str6 + file3.getAbsolutePath());
                            b.a.p0.t.d.K(file3);
                        }
                        return c0110a;
                    }
                    c0110a.f3924a = true;
                    b.a.p0.t.d.d(dataInputStream2);
                    if (file3 != null) {
                        d.h(str7, str6 + file3.getAbsolutePath());
                        b.a.p0.t.d.K(file3);
                    }
                    if (f3920a) {
                        String str10 = "#decryptSafely dstFolder=" + file.getAbsolutePath() + str5 + ((System.nanoTime() - j) / 1000000.0d);
                    }
                    return c0110a;
                }
                c0110a.f3925b = "index array length <= 0";
                b.a.p0.t.d.d(dataInputStream2);
                return c0110a;
            }
            c0110a.f3925b = "cipher is null";
            b.a.p0.t.d.d(dataInputStream2);
            return c0110a;
        }
        return (C0110a) invokeLLI.objValue;
    }

    public static void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            File file = new File(j());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(String.valueOf(i2));
                fileWriter.write(44);
                b.a.p0.t.d.d(fileWriter);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static b h(@NonNull BufferedInputStream bufferedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bufferedInputStream)) == null) {
            b bVar = new b();
            bVar.f3926a = bufferedInputStream;
            bufferedInputStream.mark(8);
            int read = (bufferedInputStream.read() << 8) | bufferedInputStream.read() | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
            if (read == -1122498812) {
                bVar.f3927b = 1;
            } else if (read == -1122434039) {
                bVar.f3927b = 2;
            } else {
                bufferedInputStream.reset();
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static b i(File file) {
        InterceptResult invokeL;
        BufferedInputStream bufferedInputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, file)) == null) {
            b bVar = new b();
            if (file != null && file.exists()) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException unused) {
                }
                try {
                    read = bufferedInputStream.read() | (bufferedInputStream.read() << 8) | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
                } catch (IOException unused2) {
                    bufferedInputStream2 = bufferedInputStream;
                    boolean z = f3920a;
                    bufferedInputStream = bufferedInputStream2;
                    b.a.p0.t.d.d(bufferedInputStream);
                    return bVar;
                }
                if (read == -1122498812) {
                    bVar.f3926a = bufferedInputStream;
                    bVar.f3927b = 1;
                    return bVar;
                }
                if (read == -1122434039) {
                    bVar.f3926a = bufferedInputStream;
                    bVar.f3927b = 2;
                    return bVar;
                }
                b.a.p0.t.d.d(bufferedInputStream);
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new File(b.a.p0.a.f1.c.a.d().get(0).f8611a, "/decryptLog.csv").getAbsolutePath() : (String) invokeV.objValue;
    }

    public static int k(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, dataInputStream)) == null) {
            byte[] bArr = new byte[4];
            dataInputStream.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
        }
        return invokeL.intValue;
    }

    public static long l(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, dataInputStream)) == null) {
            byte[] bArr = new byte[8];
            dataInputStream.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
        }
        return invokeL.longValue;
    }

    public static boolean m(List<b.a> list, File file, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65549, null, list, file, i2)) == null) {
            long currentTimeMillis = f3920a ? System.currentTimeMillis() : 0L;
            for (b.a aVar : list) {
                File file2 = new File(file, aVar.f3933c);
                if (!file2.exists() || (file2.isFile() && file2.length() != aVar.f3931a)) {
                    d.h("BundleDecrypt", "decrypt：unpack file " + aVar.f3933c + " fail");
                    b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                    b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                    aVar2.j(4L);
                    aVar2.h(52L);
                    dVar.p(aVar2);
                    dVar.l("path", file2.getAbsolutePath());
                    dVar.l("eMsg", "decrypt files not match encrypt content");
                    dVar.l("decryptType", String.valueOf(i2));
                    dVar.l("stack", q0.z(30));
                    b.a.p0.a.j2.k.L(dVar);
                    return false;
                }
            }
            if (f3920a) {
                String str = "check all files valid cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms";
                return true;
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public static PublicKey n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB".getBytes("utf-8"), 0)));
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e2) {
                if (f3920a) {
                    e2.getMessage();
                    return null;
                }
                return null;
            }
        }
        return (PublicKey) invokeV.objValue;
    }

    public static boolean o(@NonNull File file, @NonNull File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, file, file2)) == null) {
            if (file2.exists()) {
                return file.length() == file2.length() || file.renameTo(file2);
            }
            file2.getParentFile().mkdirs();
            return file.renameTo(file2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(File file, File file2, List<b.a> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, file, file2, list)) == null) {
            if (file == null || file2 == null || list == null || !file.isDirectory() || !file2.isDirectory()) {
                return false;
            }
            for (b.a aVar : list) {
                String str = aVar.f3933c;
                File file3 = new File(file, str);
                File file4 = new File(file2, str);
                if (!o(file3, file4)) {
                    d.h("BundleDecrypt", "#moveFile fail src=" + file3.getAbsolutePath() + "dst=" + file4.getAbsolutePath());
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static b.a q(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, dataInputStream)) == null) {
            b.a aVar = new b.a();
            k(dataInputStream);
            aVar.f3931a = k(dataInputStream);
            int k = k(dataInputStream);
            aVar.f3932b = k;
            byte[] bArr = new byte[k];
            dataInputStream.readFully(bArr);
            aVar.f3933c = new String(bArr, "utf-8");
            return aVar;
        }
        return (b.a) invokeL.objValue;
    }
}
