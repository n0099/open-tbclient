package b.a.p0.a.a1.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.k;
import b.a.p0.t.d;
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
    public static final boolean f3934h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CountDownLatch f3935e;

    /* renamed from: f  reason: collision with root package name */
    public File f3936f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f3937g;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f3938a;

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
            this.f3938a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 != 100) {
                    if (i2 == 200) {
                        if (this.f3938a.f3935e != null) {
                            this.f3938a.f3935e.countDown();
                        }
                        this.f3938a.quit();
                        return;
                    }
                    return;
                }
                C0111c c0111c = (C0111c) message.obj;
                File file = new File(this.f3938a.f3936f, c0111c.f3940a);
                d.k(file.getParentFile());
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(c0111c.f3941b);
                    fileOutputStream.close();
                } catch (Exception e2) {
                    if (this.f3938a.f3937g != null) {
                        this.f3938a.f3937g.incrementAndGet();
                    }
                    b.a.p0.a.e0.d.i("FileOutputThread", "write file fail - " + file.getAbsolutePath(), e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f3939a;

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
            this.f3939a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 != 100) {
                    if (i2 == 200) {
                        if (this.f3939a.f3935e != null) {
                            this.f3939a.f3935e.countDown();
                        }
                        this.f3939a.quit();
                        return;
                    }
                    return;
                }
                C0111c c0111c = (C0111c) message.obj;
                File file = new File(this.f3939a.f3936f, c0111c.f3940a);
                try {
                    if (b.a.p0.a.a1.c.a()) {
                        this.f3939a.i(c0111c, file);
                    } else {
                        this.f3939a.h(c0111c, file);
                    }
                } catch (Exception e2) {
                    if (this.f3939a.f3937g != null) {
                        this.f3939a.f3937g.incrementAndGet();
                    }
                    b.a.p0.a.e0.d.i("FileOutputThread", "write file fail - " + file.getAbsolutePath(), e2);
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.a1.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0111c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f3940a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f3941b;

        public C0111c() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-291496632, "Lb/a/p0/a/a1/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-291496632, "Lb/a/p0/a/a1/h/c;");
                return;
            }
        }
        f3934h = k.f6397a;
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
                g2 = new File(this.f3936f, str);
            }
            if (!g2.exists()) {
                g2.getParentFile().mkdirs();
                if (!g2.createNewFile()) {
                    b.a.p0.a.e0.d.h("FileOutputThread", " unzip error caused by create file error.");
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(g2);
            fileOutputStream.write(bArr);
            d.d(fileOutputStream);
            if (z2) {
                File file = new File(this.f3936f, str);
                long currentTimeMillis = f3934h ? System.currentTimeMillis() : 0L;
                if (file.exists()) {
                    if (file.length() == g2.length()) {
                        if (f3934h) {
                            String str2 = "target file already exist, no need to rename - " + file.getAbsolutePath();
                        }
                        d.K(g2);
                        return true;
                    }
                    if (f3934h) {
                        String str3 = "target file already exist, but size not same - " + file.getAbsolutePath();
                    }
                    d.K(file);
                }
                z = (g2.renameTo(file) || file.exists()) ? true : true;
                if (f3934h) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str4 = "delete and rename file cost - " + (currentTimeMillis2 - currentTimeMillis);
                }
                if (!z) {
                    d.K(g2);
                    b.a.p0.a.e0.d.h("FileOutputThread", " rename to target fail - " + file.getAbsolutePath());
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
                File file = new File(this.f3936f, str3);
                if (!file.exists()) {
                    return file;
                }
                str3 = str2 + "_" + i2;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public void h(@NonNull C0111c c0111c, @NonNull File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, c0111c, file) == null) {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                if (!file.createNewFile()) {
                    b.a.p0.a.e0.d.h("FileOutputThread", " unzip error caused by create file error.");
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(c0111c.f3941b);
            d.d(fileOutputStream);
        }
    }

    public void i(@NonNull C0111c c0111c, @NonNull File file) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, c0111c, file) == null) || f(c0111c.f3941b, c0111c.f3940a)) {
            return;
        }
        AtomicInteger atomicInteger = this.f3937g;
        if (atomicInteger != null) {
            atomicInteger.incrementAndGet();
        }
        b.a.p0.a.e0.d.h("FileOutputThread", "write file fail - " + file.getAbsolutePath());
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
        this.f3936f = file;
        this.f3935e = countDownLatch;
        this.f3937g = atomicInteger;
    }
}
