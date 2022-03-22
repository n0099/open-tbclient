package c.a.n0.q.i.i.g;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.pms.constants.ErrorConstant;
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
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class j<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final c.a.n0.q.o.a f9181f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public e f9182b;

    /* renamed from: c  reason: collision with root package name */
    public f<T> f9183c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f9184d;

    /* renamed from: e  reason: collision with root package name */
    public T f9185e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-758518038, "Lc/a/n0/q/i/i/g/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-758518038, "Lc/a/n0/q/i/i/g/j;");
                return;
            }
        }
        f9181f = c.a.n0.q.o.a.e();
    }

    public j(f<T> fVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9183c = fVar;
        this.f9182b = fVar.a;
        this.a = i;
        this.f9185e = fVar.f9169b;
        this.f9184d = fVar.f9171d;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, outputStream, Long.valueOf(j)})) == null) {
            int i = 32768;
            byte[] bArr = new byte[32768];
            long j2 = 0;
            int i2 = 0;
            while (!this.f9184d.get() && i2 != -1) {
                if (j > 0) {
                    if (j2 >= j) {
                        break;
                    } else if (i + j2 > j) {
                        i = (int) (j - j2);
                    }
                }
                i2 = inputStream.read(bArr, 0, i);
                if (i2 > 0) {
                    outputStream.write(bArr, 0, i2);
                    j2 += i2;
                    this.f9182b.f9167b.f9140b = j2;
                    this.f9183c.l();
                }
            }
            c.a.n0.q.c.b().y("PMSTaskProcessor", "#copyStream canceled=" + this.f9184d.get() + " readed" + j2 + " totalBytes=" + j);
            return j2 == j;
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        c.a.n0.q.i.i.f.e eVar;
        Exception e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9184d.get()) {
            return;
        }
        c.a.n0.q.i.i.f.e eVar2 = null;
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            f9181f.g("PMSTaskProcessor", "#downloadLogic 没有网络连接", null);
            this.f9182b.a = new c.a.n0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_MISS_PARAM, "download : no network");
            this.f9182b.a.a("没有网络连接");
        } else if (!this.f9183c.c()) {
            f9181f.g("PMSTaskProcessor", "#downloadLogic 无法创建本地文件", null);
            this.f9182b.a = new c.a.n0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            this.f9183c.p();
            try {
                try {
                    eVar = c.a.n0.q.c.b().A().b(this.f9182b.f9167b.n, this.a);
                    try {
                        int code = eVar.code();
                        int d2 = d(eVar, code);
                        if (this.f9182b.a.a != d2) {
                            this.f9182b.a = new c.a.n0.q.h.b(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                            this.f9182b.a.a("状态不匹配错误，可能有未捕获的异常");
                            f9181f.g("PMSTaskProcessor", "#downloadLogic 状态不匹配错误 errorCode=" + d2 + " errNo=" + this.f9182b.a.a + " httpStatus=" + code, null);
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        f9181f.g("PMSTaskProcessor", "#downloadLogic 包下载异常", e2);
                        this.f9182b.a = new c.a.n0.q.h.b(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        this.f9182b.a.a(Log.getStackTraceString(e2));
                        c.a.n0.w.d.d(eVar);
                    }
                } catch (Throwable th) {
                    th = th;
                    eVar2 = eVar;
                    c.a.n0.w.d.d(eVar2);
                    throw th;
                }
            } catch (Exception e4) {
                eVar = null;
                e2 = e4;
            } catch (Throwable th2) {
                th = th2;
                c.a.n0.w.d.d(eVar2);
                throw th;
            }
            c.a.n0.w.d.d(eVar);
        }
    }

    public final boolean c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!new File(str).exists()) {
                this.f9182b.a = new c.a.n0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, c.a.n0.q.o.e.a("local file save failed:", str)));
                return false;
            }
            String str2 = this.f9182b.f9167b.l;
            String b2 = c.a.n0.q.o.c.b(new File(str), true);
            if (str2 != null && b2 != null) {
                String upperCase = str2.toUpperCase();
                if (upperCase.equals(b2)) {
                    return true;
                }
                this.f9182b.a = new c.a.n0.q.h.b(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + c.a.n0.q.o.e.a("server:", upperCase, ",local", b2));
                return false;
            }
            this.f9182b.a = new c.a.n0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, c.a.n0.q.o.e.a("server:", str2, ",local", b2)));
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int d(c.a.n0.q.i.i.f.e eVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, eVar, i)) == null) {
            c.a.n0.q.c.b().y("PMSTaskProcessor", "#parseResponse url=" + this.f9182b.f9167b.n + " code=" + eVar.code());
            this.f9182b.a = null;
            if (i >= 200 && i <= 300) {
                c.a.n0.q.i.i.f.d body = eVar.body();
                if (body != null) {
                    long a = body.a();
                    f9181f.g("PMSTaskProcessor", "#parseResponse currentSize=" + this.f9182b.f9167b.f9140b + " pkgSize=" + this.f9182b.f9167b.k + " contentLength=" + a, null);
                    if (!this.f9183c.j(this.f9182b.f9167b.k)) {
                        f9181f.g("PMSTaskProcessor", "#parseResponse 磁盘空间不足", null);
                        this.f9182b.a = new c.a.n0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                        return this.f9182b.a.a;
                    }
                    try {
                        if (e(body, a)) {
                            this.f9182b.a = new c.a.n0.q.h.b(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                            return this.f9182b.a.a;
                        }
                    } catch (IOException e2) {
                        f9181f.g("PMSTaskProcessor", "#parseResponse 写到文件过程中出错", e2);
                        this.f9182b.a = new c.a.n0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                        return this.f9182b.a.a;
                    }
                }
                e eVar2 = this.f9182b;
                if (eVar2.a == null) {
                    eVar2.a = new c.a.n0.q.h.b(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                    this.f9182b.a.a("错误码为空时设置的默认错误");
                }
                return this.f9182b.a.a;
            }
            String str = "statusCode=" + i;
            f9181f.g("PMSTaskProcessor", "#parseResponse error " + str, null);
            e eVar3 = this.f9182b;
            c.a.n0.q.h.b bVar = new c.a.n0.q.h.b(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
            bVar.a(str);
            eVar3.a = bVar;
            return this.f9182b.a.a;
        }
        return invokeLI.intValue;
    }

    public final boolean e(c.a.n0.q.i.i.f.d dVar, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048580, this, dVar, j)) != null) {
            return invokeLJ.booleanValue;
        }
        f<T> fVar = this.f9183c;
        c<T> cVar = fVar.f9172e;
        ReadableByteChannel readableByteChannel = null;
        try {
            T t = this.f9185e;
            File file = fVar.f9170c;
            ReadableByteChannel source = dVar.source();
            try {
                c.a.n0.q.h.b h2 = cVar.h(t, file, j, source);
                if (h2.a == 2302) {
                    if (f(Channels.newInputStream(source), new FileOutputStream(this.f9183c.f9170c), j) && c(this.f9182b.f9167b.a)) {
                        if (source != null && source.isOpen()) {
                            c.a.n0.w.d.d(source);
                        }
                        return true;
                    }
                    if (source != null && source.isOpen()) {
                        c.a.n0.w.d.d(source);
                    }
                    return false;
                } else if (h2.a == 2300) {
                    this.f9182b.f9167b.f9140b = j;
                    this.f9183c.l();
                    if (source != null && source.isOpen()) {
                        c.a.n0.w.d.d(source);
                    }
                    return true;
                } else {
                    this.f9182b.a = h2;
                    if (source != null && source.isOpen()) {
                        c.a.n0.w.d.d(source);
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                readableByteChannel = source;
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    c.a.n0.w.d.d(readableByteChannel);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean f(InputStream inputStream, OutputStream outputStream, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{inputStream, outputStream, Long.valueOf(j)})) == null) {
            try {
                try {
                    return a(inputStream, outputStream, j);
                } catch (IOException e2) {
                    c.a.n0.q.c.b().G("PMSTaskProcessor", "#safeCopyStream 写入输出流出错", e2);
                    c.a.n0.w.d.d(inputStream);
                    c.a.n0.w.d.d(outputStream);
                    return false;
                }
            } finally {
                c.a.n0.w.d.d(inputStream);
                c.a.n0.w.d.d(outputStream);
            }
        }
        return invokeCommon.booleanValue;
    }
}
