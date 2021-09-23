package c.a.p0.a.a1.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.k;
import c.a.p0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class c extends HandlerThread {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f4538h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CountDownLatch f4539e;

    /* renamed from: f  reason: collision with root package name */
    public File f4540f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f4541g;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f4542a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4542a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 != 100) {
                    if (i2 == 200) {
                        if (this.f4542a.f4539e != null) {
                            this.f4542a.f4539e.countDown();
                        }
                        this.f4542a.quit();
                        return;
                    }
                    return;
                }
                C0116c c0116c = (C0116c) message.obj;
                File file = new File(this.f4542a.f4540f, c0116c.f4544a);
                d.k(file.getParentFile());
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(c0116c.f4545b);
                    fileOutputStream.close();
                } catch (Exception e2) {
                    if (this.f4542a.f4541g != null) {
                        this.f4542a.f4541g.incrementAndGet();
                    }
                    c.a.p0.a.e0.d.i("FileOutputThread", "write file fail - " + file.getAbsolutePath(), e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f4543a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4543a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 != 100) {
                    if (i2 == 200) {
                        if (this.f4543a.f4539e != null) {
                            this.f4543a.f4539e.countDown();
                        }
                        this.f4543a.quit();
                        return;
                    }
                    return;
                }
                C0116c c0116c = (C0116c) message.obj;
                File file = new File(this.f4543a.f4540f, c0116c.f4544a);
                try {
                    if (c.a.p0.a.a1.c.a()) {
                        this.f4543a.i(c0116c, file);
                    } else {
                        this.f4543a.h(c0116c, file);
                    }
                } catch (Exception e2) {
                    if (this.f4543a.f4541g != null) {
                        this.f4543a.f4541g.incrementAndGet();
                    }
                    c.a.p0.a.e0.d.i("FileOutputThread", "write file fail - " + file.getAbsolutePath(), e2);
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.a1.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0116c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f4544a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f4545b;

        public C0116c() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-802030809, "Lc/a/p0/a/a1/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-802030809, "Lc/a/p0/a/a1/h/c;");
                return;
            }
        }
        f4538h = k.f7085a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String str, File file, CountDownLatch countDownLatch, AtomicInteger atomicInteger) {
        this(str, 0, file, countDownLatch, atomicInteger);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, file, countDownLatch, atomicInteger};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (File) objArr2[2], (CountDownLatch) objArr2[3], (AtomicInteger) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public Handler d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this, getLooper()) : (Handler) invokeV.objValue;
    }

    public Handler e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this, getLooper()) : (Handler) invokeV.objValue;
    }

    public boolean f(byte[] bArr, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, str)) == null) {
            boolean z = false;
            if (bArr == null || TextUtils.isEmpty(str)) {
                return false;
            }
            File g2 = g(str);
            boolean z2 = g2 != null;
            if (!z2) {
                g2 = new File(this.f4540f, str);
            }
            if (!g2.exists()) {
                g2.getParentFile().mkdirs();
                if (!g2.createNewFile()) {
                    c.a.p0.a.e0.d.h("FileOutputThread", " unzip error caused by create file error.");
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(g2);
            fileOutputStream.write(bArr);
            d.d(fileOutputStream);
            if (z2) {
                File file = new File(this.f4540f, str);
                long currentTimeMillis = f4538h ? System.currentTimeMillis() : 0L;
                if (file.exists()) {
                    if (file.length() == g2.length()) {
                        if (f4538h) {
                            String str2 = "target file already exist, no need to rename - " + file.getAbsolutePath();
                        }
                        d.K(g2);
                        return true;
                    }
                    if (f4538h) {
                        String str3 = "target file already exist, but size not same - " + file.getAbsolutePath();
                    }
                    d.K(file);
                }
                z = (g2.renameTo(file) || file.exists()) ? true : true;
                if (f4538h) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str4 = "delete and rename file cost - " + (currentTimeMillis2 - currentTimeMillis);
                }
                if (!z) {
                    d.K(g2);
                    c.a.p0.a.e0.d.h("FileOutputThread", " rename to target fail - " + file.getAbsolutePath());
                }
                return z;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public File g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String str2 = str + "_" + System.nanoTime();
            String str3 = str2;
            for (int i2 = 0; i2 < 100; i2++) {
                File file = new File(this.f4540f, str3);
                if (!file.exists()) {
                    return file;
                }
                str3 = str2 + "_" + i2;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public void h(@NonNull C0116c c0116c, @NonNull File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, c0116c, file) == null) {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                if (!file.createNewFile()) {
                    c.a.p0.a.e0.d.h("FileOutputThread", " unzip error caused by create file error.");
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(c0116c.f4545b);
            d.d(fileOutputStream);
        }
    }

    public void i(@NonNull C0116c c0116c, @NonNull File file) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, c0116c, file) == null) || f(c0116c.f4545b, c0116c.f4544a)) {
            return;
        }
        AtomicInteger atomicInteger = this.f4541g;
        if (atomicInteger != null) {
            atomicInteger.incrementAndGet();
        }
        c.a.p0.a.e0.d.h("FileOutputThread", "write file fail - " + file.getAbsolutePath());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, int i2, File file, CountDownLatch countDownLatch, AtomicInteger atomicInteger) {
        super(str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), file, countDownLatch, atomicInteger};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4540f = file;
        this.f4539e = countDownLatch;
        this.f4541g = atomicInteger;
    }
}
