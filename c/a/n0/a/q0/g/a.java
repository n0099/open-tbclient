package c.a.n0.a.q0.g;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.p2.q0;
import c.a.n0.a.q0.g.b;
import c.a.n0.a.q0.g.c;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
import java.io.FileOutputStream;
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
import java.util.concurrent.TimeUnit;
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
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicInteger f5977b;

    /* renamed from: c  reason: collision with root package name */
    public static CharSequence f5978c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5979d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.q0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0424a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5980b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f5981c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f5982d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f5983e;

        public RunnableC0424a(File file, String str, byte[] bArr, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, bArr, atomicInteger, atomicInteger2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.f5980b = str;
            this.f5981c = bArr;
            this.f5982d = atomicInteger;
            this.f5983e = atomicInteger2;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    File file = new File(this.a, this.f5980b);
                    if (file.exists()) {
                        if (file.length() == this.f5981c.length) {
                            return;
                        }
                    }
                    c.a.n0.w.d.m(file.getParentFile());
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(this.f5981c);
                            fileOutputStream.close();
                        } finally {
                        }
                    } catch (Exception e2) {
                        if (this.f5982d != null) {
                            this.f5982d.incrementAndGet();
                        }
                        c.a.n0.a.u.d.l("BundleDecrypt", "write file fail - " + file.getAbsolutePath(), e2);
                    }
                } finally {
                    this.f5983e.getAndDecrement();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f5984b;

        public b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.f5984b = "";
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BufferedInputStream a;

        /* renamed from: b  reason: collision with root package name */
        public int f5985b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5985b = -1;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(226301757, "Lc/a/n0/a/q0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(226301757, "Lc/a/n0/a/q0/g/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f5977b = new AtomicInteger(0);
        f5978c = "._";
        c.a.n0.a.s0.a.g0().getSwitch("swan_pkg_unzip_quickly", false);
        f5979d = false;
    }

    public static void a(File file, String str, byte[] bArr, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, file, str, bArr, atomicInteger, atomicInteger2) == null) {
            d.a(new RunnableC0424a(file, str, bArr, atomicInteger, atomicInteger2));
        }
    }

    public static boolean b(int i, @NonNull File file, int i2, @NonNull b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), file, Integer.valueOf(i2), bVar})) == null) {
            if (i > 0) {
                String str = i + " files write error";
                bVar.f5984b = str;
                c.a.n0.a.u.d.k("BundleDecrypt", str);
                c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(4L);
                aVar.i(52L);
                dVar.p(aVar);
                dVar.l("path", file.getAbsolutePath());
                dVar.l("eMsg", str);
                dVar.l("decryptType", String.valueOf(i2));
                dVar.l("stack", q0.z(30));
                n.R(dVar);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @NonNull
    public static Pair<Boolean, File> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            File file = new File(c.a.n0.a.s0.a.c().getFilesDir(), "swan_tmp_unzip");
            c.a.n0.w.d.l(file);
            File file2 = new File(file, System.nanoTime() + "_" + f5977b.incrementAndGet());
            boolean l = c.a.n0.w.d.l(file2);
            c.a.n0.a.u.d.k("BundleDecrypt", "#createTmpUnzipDir tmpUnzipDir=" + file2 + " dirExist=" + l);
            return new Pair<>(Boolean.valueOf(l), file2);
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03f6  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b d(BufferedInputStream bufferedInputStream, File file, int i) {
        InterceptResult invokeLLI;
        DataInputStream dataInputStream;
        long j;
        File file2;
        DataInputStream dataInputStream2;
        byte[] f2;
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
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bufferedInputStream, file, i)) == null) {
            String str5 = " 耗时(ms): ";
            String str6 = "删除tmpUnzipDir ";
            String str7 = "BundleDecrypt";
            if (f5979d) {
                c.a.n0.a.u.d.k("BundleDecrypt", "#decryptQuickly dstFolder=" + file + " type=" + i);
                return g(bufferedInputStream, file, i);
            }
            long nanoTime = a ? System.nanoTime() : 0L;
            b bVar = new b(false);
            if (file == null || bufferedInputStream == null || i == 0) {
                return bVar;
            }
            c.a.n0.a.q0.g.b bVar2 = new c.a.n0.a.q0.g.b();
            try {
                dataInputStream2 = new DataInputStream(bufferedInputStream);
                try {
                    try {
                        l(dataInputStream2);
                        bVar2.a = l(dataInputStream2);
                        bVar2.f5986b = l(dataInputStream2);
                        l(dataInputStream2);
                        m(dataInputStream2);
                        dataInputStream2.readFully(bVar2.f5987c);
                        f2 = f(bVar2.f5987c);
                    } catch (Throwable th) {
                        th = th;
                        dataInputStream = dataInputStream2;
                        file2 = null;
                        c.a.n0.w.d.d(dataInputStream);
                        if (file2 != null) {
                            c.a.n0.a.u.d.k(str7, str6 + file2.getAbsolutePath());
                            c.a.n0.w.d.L(file2);
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    j = nanoTime;
                }
                try {
                } catch (Exception e3) {
                    e = e3;
                    dataInputStream = dataInputStream2;
                    file2 = null;
                    try {
                        bVar.f5984b = e.getLocalizedMessage();
                        c.a.n0.a.u.d.l(str7, "解压异常", e);
                        c.a.n0.w.d.d(dataInputStream);
                        if (file2 != null) {
                        }
                        if (a) {
                        }
                        return bVar;
                    } catch (Throwable th2) {
                        th = th2;
                        c.a.n0.w.d.d(dataInputStream);
                        if (file2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                j = nanoTime;
                dataInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream = null;
            }
            if (f2 != null && f2.length > 0) {
                byte[] bArr = new byte[bVar2.f5986b];
                dataInputStream2.readFully(bArr);
                byte[] bArr2 = new byte[16];
                byte[] bArr3 = new byte[16];
                System.arraycopy(f2, 0, bArr2, 0, 16);
                System.arraycopy(f2, 16, bArr3, 0, 16);
                byte[] e5 = e(bArr, bArr2, bArr3);
                if (e5 != null && e5.length > 0) {
                    if (i == 2) {
                        try {
                            dataInputStream3 = new DataInputStream(c.a.n0.a.s0.a.j().a(new ByteArrayInputStream(e5)));
                            dataInputStream4 = new DataInputStream(c.a.n0.a.s0.a.j().a(dataInputStream2));
                        } catch (Exception e6) {
                            e = e6;
                            dataInputStream = dataInputStream2;
                            j = nanoTime;
                            file2 = null;
                            bVar.f5984b = e.getLocalizedMessage();
                            c.a.n0.a.u.d.l(str7, "解压异常", e);
                            c.a.n0.w.d.d(dataInputStream);
                            if (file2 != null) {
                            }
                            if (a) {
                            }
                            return bVar;
                        }
                    } else {
                        dataInputStream3 = new DataInputStream(new ByteArrayInputStream(e5));
                        dataInputStream4 = new DataInputStream(new GZIPInputStream(dataInputStream2));
                    }
                    DataInputStream dataInputStream5 = dataInputStream3;
                    DataInputStream dataInputStream6 = dataInputStream4;
                    if (!c.a.n0.w.d.l(file)) {
                        String str8 = "解压目录创建失败 path=" + file.getAbsolutePath();
                        c.a.n0.a.u.d.k("BundleDecrypt", str8);
                        bVar.f5984b = str8;
                        c.a.n0.w.d.d(dataInputStream2);
                        return bVar;
                    }
                    Pair<Boolean, File> c2 = c();
                    if (!((Boolean) c2.first).booleanValue()) {
                        String str9 = "临时目录创建失败 path=" + ((File) c2.second).getAbsolutePath();
                        c.a.n0.a.u.d.k("BundleDecrypt", str9);
                        bVar.f5984b = str9;
                        c.a.n0.w.d.d(dataInputStream2);
                        return bVar;
                    }
                    File file3 = (File) c2.second;
                    try {
                        try {
                            atomicInteger = new AtomicInteger(0);
                            countDownLatch = new CountDownLatch(4);
                            j = nanoTime;
                            try {
                                Handler[] handlerArr = new Handler[4];
                                int i2 = 0;
                                for (int i3 = 4; i2 < i3; i3 = 4) {
                                    String str10 = str5;
                                    try {
                                        c.a.n0.a.q0.g.c cVar = new c.a.n0.a.q0.g.c("BundleDecrypt" + i2, file3, countDownLatch, atomicInteger);
                                        cVar.start();
                                        handlerArr[i2] = cVar.d();
                                        i2++;
                                        str5 = str10;
                                    } catch (Exception e7) {
                                        e = e7;
                                        dataInputStream = dataInputStream2;
                                        file2 = file3;
                                        str5 = str10;
                                        bVar.f5984b = e.getLocalizedMessage();
                                        c.a.n0.a.u.d.l(str7, "解压异常", e);
                                        c.a.n0.w.d.d(dataInputStream);
                                        if (file2 != null) {
                                            c.a.n0.a.u.d.k(str7, str6 + file2.getAbsolutePath());
                                            c.a.n0.w.d.L(file2);
                                        }
                                        if (a) {
                                        }
                                        return bVar;
                                    }
                                }
                                str = str5;
                                try {
                                    arrayList = new ArrayList();
                                    int i4 = 0;
                                    while (i4 < bVar2.a) {
                                        try {
                                            b.a r = r(dataInputStream5);
                                            c.a.n0.a.q0.g.b bVar3 = bVar2;
                                            String str11 = str7;
                                            try {
                                                if (r.f5989c.contains(f5978c)) {
                                                    dataInputStream6.skipBytes(r.a);
                                                    str4 = str6;
                                                } else {
                                                    byte[] bArr4 = new byte[r.a];
                                                    dataInputStream6.readFully(bArr4);
                                                    Message obtain = Message.obtain();
                                                    str4 = str6;
                                                    try {
                                                        c.b bVar4 = new c.b();
                                                        bVar4.f5992b = bArr4;
                                                        bVar4.a = r.f5989c;
                                                        obtain.what = 100;
                                                        obtain.obj = bVar4;
                                                        handlerArr[i4 % 4].sendMessage(obtain);
                                                        arrayList.add(r);
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        for (int i5 = 0; i5 < 4; i5++) {
                                                            handlerArr[i5].sendEmptyMessage(200);
                                                        }
                                                        countDownLatch.await();
                                                        c.a.n0.w.d.d(dataInputStream5);
                                                        c.a.n0.w.d.d(dataInputStream6);
                                                        throw th;
                                                    }
                                                }
                                                i4++;
                                                bVar2 = bVar3;
                                                str7 = str11;
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
                                    int i6 = 0;
                                    for (int i7 = 4; i6 < i7; i7 = 4) {
                                        try {
                                            handlerArr[i6].sendEmptyMessage(200);
                                            i6++;
                                        } catch (Exception e8) {
                                            e = e8;
                                            dataInputStream = dataInputStream2;
                                            file2 = file3;
                                            str5 = str;
                                            str7 = str3;
                                            str6 = str2;
                                            bVar.f5984b = e.getLocalizedMessage();
                                            c.a.n0.a.u.d.l(str7, "解压异常", e);
                                            c.a.n0.w.d.d(dataInputStream);
                                            if (file2 != null) {
                                            }
                                            if (a) {
                                            }
                                            return bVar;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            dataInputStream = dataInputStream2;
                                            file2 = file3;
                                            str7 = str3;
                                            str6 = str2;
                                            c.a.n0.w.d.d(dataInputStream);
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
                        } catch (Throwable th8) {
                            th = th8;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        j = nanoTime;
                    }
                    try {
                        countDownLatch.await();
                        c.a.n0.w.d.d(dataInputStream5);
                        c.a.n0.w.d.d(dataInputStream6);
                    } catch (Exception e12) {
                        e = e12;
                        str5 = str;
                        str7 = str3;
                        str6 = str2;
                        dataInputStream = dataInputStream2;
                        file2 = file3;
                        bVar.f5984b = e.getLocalizedMessage();
                        c.a.n0.a.u.d.l(str7, "解压异常", e);
                        c.a.n0.w.d.d(dataInputStream);
                        if (file2 != null) {
                        }
                        if (a) {
                        }
                        return bVar;
                    } catch (Throwable th9) {
                        th = th9;
                        str7 = str3;
                        str6 = str2;
                        dataInputStream = dataInputStream2;
                        file2 = file3;
                        c.a.n0.w.d.d(dataInputStream);
                        if (file2 != null) {
                        }
                        throw th;
                    }
                    if (b(atomicInteger.get(), file, i, bVar)) {
                        c.a.n0.w.d.d(dataInputStream2);
                        if (file3 != null) {
                            c.a.n0.a.u.d.k(str3, str2 + file3.getAbsolutePath());
                            c.a.n0.w.d.L(file3);
                        }
                        return bVar;
                    }
                    str7 = str3;
                    str6 = str2;
                    if (!n(arrayList, file3, i)) {
                        String str12 = "解压后校验失败 tmpUnzipDir=" + file3;
                        c.a.n0.a.u.d.k(str7, str12);
                        bVar.f5984b = str12;
                        c.a.n0.w.d.d(dataInputStream2);
                        if (file3 != null) {
                            c.a.n0.a.u.d.k(str7, str6 + file3.getAbsolutePath());
                            c.a.n0.w.d.L(file3);
                        }
                        return bVar;
                    }
                    long nanoTime2 = a ? System.nanoTime() : 0L;
                    boolean q = q(file3, file, arrayList);
                    if (a) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("#moveToDestDir dstFolder=");
                        sb.append(file.getAbsolutePath());
                        sb.append(" moveRes=");
                        sb.append(q);
                        sb.append(" fileCount=");
                        sb.append(arrayList.size());
                        str5 = str;
                        sb.append(str5);
                        sb.append((System.nanoTime() - nanoTime2) / 1000000.0d);
                        Log.i(str7, sb.toString());
                    } else {
                        str5 = str;
                    }
                    if (!q) {
                        String str13 = "解压后rename失败 dstFolder=" + file;
                        c.a.n0.a.u.d.k(str7, str13);
                        bVar.f5984b = str13;
                        c.a.n0.w.d.d(dataInputStream2);
                        if (file3 != null) {
                            c.a.n0.a.u.d.k(str7, str6 + file3.getAbsolutePath());
                            c.a.n0.w.d.L(file3);
                        }
                        return bVar;
                    }
                    bVar.a = true;
                    c.a.n0.w.d.d(dataInputStream2);
                    if (file3 != null) {
                        c.a.n0.a.u.d.k(str7, str6 + file3.getAbsolutePath());
                        c.a.n0.w.d.L(file3);
                    }
                    if (a) {
                        Log.i(str7, "#decrypt dstFolder=" + file.getAbsolutePath() + str5 + ((System.nanoTime() - j) / 1000000.0d));
                    }
                    return bVar;
                }
                c.a.n0.a.u.d.k("BundleDecrypt", "index array length <= 0");
                bVar.f5984b = "index array length <= 0";
                c.a.n0.w.d.d(dataInputStream2);
                return bVar;
            }
            c.a.n0.a.u.d.k("BundleDecrypt", "cipher is null");
            bVar.f5984b = "cipher is null";
            c.a.n0.w.d.d(dataInputStream2);
            return bVar;
        }
        return (b) invokeLLI.objValue;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, bArr, bArr2, bArr3)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
                if (a) {
                    Log.e("BundleDecrypt", "use key/iv decrypt AES fail", e2);
                    return null;
                }
                return null;
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, o());
                return cipher.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
                if (a) {
                    Log.e("BundleDecrypt", "decypt cipher fail", e2);
                    return null;
                }
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static b g(BufferedInputStream bufferedInputStream, File file, int i) {
        InterceptResult invokeLLI;
        DataInputStream dataInputStream;
        byte[] f2;
        DataInputStream dataInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, bufferedInputStream, file, i)) == null) {
            b bVar = new b(false);
            if (file == null || bufferedInputStream == null || i == 0) {
                return bVar;
            }
            c.a.n0.a.q0.g.b bVar2 = new c.a.n0.a.q0.g.b();
            DataInputStream dataInputStream3 = null;
            try {
                try {
                    dataInputStream = new DataInputStream(bufferedInputStream);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                l(dataInputStream);
                bVar2.a = l(dataInputStream);
                bVar2.f5986b = l(dataInputStream);
                l(dataInputStream);
                m(dataInputStream);
                dataInputStream.readFully(bVar2.f5987c);
                f2 = f(bVar2.f5987c);
            } catch (Exception e3) {
                e = e3;
                dataInputStream3 = dataInputStream;
                bVar.f5984b = e.getLocalizedMessage();
                c.a.n0.a.u.d.l("BundleDecrypt", "解压异常 dstFolder=" + file, e);
                c.a.n0.w.d.d(dataInputStream3);
                return bVar;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream3 = dataInputStream;
                c.a.n0.w.d.d(dataInputStream3);
                throw th;
            }
            if (f2 != null && f2.length > 0) {
                byte[] bArr = new byte[bVar2.f5986b];
                dataInputStream.readFully(bArr);
                byte[] bArr2 = new byte[16];
                byte[] bArr3 = new byte[16];
                System.arraycopy(f2, 0, bArr2, 0, 16);
                System.arraycopy(f2, 16, bArr3, 0, 16);
                byte[] e4 = e(bArr, bArr2, bArr3);
                if (e4 != null && e4.length > 0) {
                    if (i == 2) {
                        dataInputStream3 = new DataInputStream(c.a.n0.a.s0.a.j().a(new ByteArrayInputStream(e4)));
                        dataInputStream2 = new DataInputStream(c.a.n0.a.s0.a.j().a(dataInputStream));
                    } else {
                        dataInputStream3 = new DataInputStream(new ByteArrayInputStream(e4));
                        dataInputStream2 = new DataInputStream(new GZIPInputStream(dataInputStream));
                    }
                    if (!c.a.n0.w.d.m(file)) {
                        String str = "解压目录创建失败 path=" + file.getAbsolutePath();
                        c.a.n0.a.u.d.k("BundleDecrypt", str);
                        bVar.f5984b = str;
                        c.a.n0.w.d.d(dataInputStream);
                        return bVar;
                    }
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    AtomicInteger atomicInteger2 = new AtomicInteger(bVar2.a);
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < bVar2.a; i2++) {
                        try {
                            b.a r = r(dataInputStream3);
                            if (r.f5989c.contains(f5978c)) {
                                atomicInteger2.getAndDecrement();
                                dataInputStream2.skipBytes(r.a);
                            } else {
                                byte[] bArr4 = new byte[r.a];
                                dataInputStream2.readFully(bArr4);
                                a(file, r.f5989c, bArr4, atomicInteger, atomicInteger2);
                                arrayList.add(r);
                            }
                        } catch (Throwable th3) {
                            atomicInteger2.set(0);
                            c.a.n0.w.d.d(dataInputStream3);
                            c.a.n0.w.d.d(dataInputStream2);
                            throw th3;
                        }
                    }
                    while (atomicInteger2.get() > 0) {
                        TimeUnit.MILLISECONDS.sleep(1L);
                    }
                    atomicInteger2.set(0);
                    c.a.n0.w.d.d(dataInputStream3);
                    c.a.n0.w.d.d(dataInputStream2);
                    if (b(atomicInteger.get(), file, i, bVar)) {
                        c.a.n0.w.d.d(dataInputStream);
                        return bVar;
                    } else if (!n(arrayList, file, i)) {
                        String str2 = "解压后校验失败 dstFolder=" + file;
                        c.a.n0.a.u.d.k("BundleDecrypt", str2);
                        bVar.f5984b = str2;
                        c.a.n0.w.d.d(dataInputStream);
                        return bVar;
                    } else {
                        bVar.a = true;
                        c.a.n0.w.d.d(dataInputStream);
                        return bVar;
                    }
                }
                c.a.n0.a.u.d.k("BundleDecrypt", "index array length <= 0");
                bVar.f5984b = "index array length <= 0";
                c.a.n0.w.d.d(dataInputStream);
                return bVar;
            }
            c.a.n0.a.u.d.k("BundleDecrypt", "cipher is null");
            bVar.f5984b = "cipher is null";
            c.a.n0.w.d.d(dataInputStream);
            return bVar;
        }
        return (b) invokeLLI.objValue;
    }

    public static void h(int i) {
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i) == null) {
            File file = new File(k());
            FileWriter fileWriter2 = null;
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileWriter = new FileWriter(file, true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                fileWriter.write(String.valueOf(i));
                fileWriter.write(44);
                c.a.n0.w.d.d(fileWriter);
            } catch (IOException e3) {
                e = e3;
                fileWriter2 = fileWriter;
                if (a) {
                    e.printStackTrace();
                }
                c.a.n0.w.d.d(fileWriter2);
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                c.a.n0.w.d.d(fileWriter2);
                throw th;
            }
        }
    }

    public static c i(@NonNull BufferedInputStream bufferedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bufferedInputStream)) == null) {
            c cVar = new c();
            cVar.a = bufferedInputStream;
            bufferedInputStream.mark(8);
            int read = (bufferedInputStream.read() << 8) | bufferedInputStream.read() | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
            if (read == -1122498812) {
                cVar.f5985b = 1;
            } else if (read == -1122434039) {
                cVar.f5985b = 2;
            } else {
                bufferedInputStream.reset();
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static c j(File file) {
        InterceptResult invokeL;
        BufferedInputStream bufferedInputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, file)) == null) {
            c cVar = new c();
            if (file != null && file.exists()) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    read = bufferedInputStream.read() | (bufferedInputStream.read() << 8) | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
                } catch (IOException e3) {
                    e = e3;
                    bufferedInputStream2 = bufferedInputStream;
                    if (a) {
                        Log.e("BundleDecrypt", "bundle encryption check fail", e);
                    }
                    bufferedInputStream = bufferedInputStream2;
                    c.a.n0.w.d.d(bufferedInputStream);
                    return cVar;
                }
                if (read == -1122498812) {
                    cVar.a = bufferedInputStream;
                    cVar.f5985b = 1;
                    return cVar;
                }
                if (read == -1122434039) {
                    cVar.a = bufferedInputStream;
                    cVar.f5985b = 2;
                    return cVar;
                }
                c.a.n0.w.d.d(bufferedInputStream);
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new File(c.a.n0.a.v0.c.a.d().get(0).a, "/decryptLog.csv").getAbsolutePath() : (String) invokeV.objValue;
    }

    public static int l(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, dataInputStream)) == null) {
            byte[] bArr = new byte[4];
            dataInputStream.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
        }
        return invokeL.intValue;
    }

    public static long m(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, dataInputStream)) == null) {
            byte[] bArr = new byte[8];
            dataInputStream.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
        }
        return invokeL.longValue;
    }

    public static boolean n(List<b.a> list, File file, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, list, file, i)) == null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            for (b.a aVar : list) {
                File file2 = new File(file, aVar.f5989c);
                if (!file2.exists() || (file2.isFile() && file2.length() != aVar.a)) {
                    c.a.n0.a.u.d.k("BundleDecrypt", "decrypt：unpack file " + aVar.f5989c + " fail");
                    c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                    c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
                    aVar2.k(4L);
                    aVar2.i(52L);
                    dVar.p(aVar2);
                    dVar.l("path", file2.getAbsolutePath());
                    dVar.l("eMsg", "decrypt files not match encrypt content");
                    dVar.l("decryptType", String.valueOf(i));
                    dVar.l("stack", q0.z(30));
                    n.R(dVar);
                    return false;
                }
            }
            if (a) {
                Log.d("BundleDecrypt", "check all files valid cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return true;
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public static PublicKey o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
                return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode("MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB".getBytes(IMAudioTransRequest.CHARSET), 0)));
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e2) {
                if (a) {
                    Log.e("BundleDecrypt", e2.getMessage());
                    return null;
                }
                return null;
            }
        }
        return (PublicKey) invokeV.objValue;
    }

    public static boolean p(@NonNull File file, @NonNull File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, file, file2)) == null) {
            if (file2.exists()) {
                return file.length() == file2.length() || file.renameTo(file2);
            }
            file2.getParentFile().mkdirs();
            return file.renameTo(file2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(File file, File file2, List<b.a> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, file, file2, list)) == null) {
            if (file == null || file2 == null || list == null || !file.isDirectory() || !file2.isDirectory()) {
                return false;
            }
            for (b.a aVar : list) {
                String str = aVar.f5989c;
                File file3 = new File(file, str);
                File file4 = new File(file2, str);
                if (!p(file3, file4)) {
                    c.a.n0.a.u.d.k("BundleDecrypt", "#moveFile fail src=" + file3.getAbsolutePath() + "dst=" + file4.getAbsolutePath());
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static b.a r(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, dataInputStream)) == null) {
            b.a aVar = new b.a();
            l(dataInputStream);
            aVar.a = l(dataInputStream);
            int l = l(dataInputStream);
            aVar.f5988b = l;
            byte[] bArr = new byte[l];
            dataInputStream.readFully(bArr);
            aVar.f5989c = new String(bArr, IMAudioTransRequest.CHARSET);
            return aVar;
        }
        return (b.a) invokeL.objValue;
    }
}
