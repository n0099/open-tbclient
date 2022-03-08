package c.a.p0.q.i.i.g;

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
    public static final c.a.p0.q.o.a f11004f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public e f11005b;

    /* renamed from: c  reason: collision with root package name */
    public f<T> f11006c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f11007d;

    /* renamed from: e  reason: collision with root package name */
    public T f11008e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1345324052, "Lc/a/p0/q/i/i/g/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1345324052, "Lc/a/p0/q/i/i/g/j;");
                return;
            }
        }
        f11004f = c.a.p0.q.o.a.e();
    }

    public j(f<T> fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11006c = fVar;
        this.f11005b = fVar.f10990e;
        this.a = i2;
        this.f11008e = fVar.f10991f;
        this.f11007d = fVar.f10993h;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, outputStream, Long.valueOf(j2)})) == null) {
            int i2 = 32768;
            byte[] bArr = new byte[32768];
            long j3 = 0;
            int i3 = 0;
            while (!this.f11007d.get() && i3 != -1) {
                if (j2 > 0) {
                    if (j3 >= j2) {
                        break;
                    } else if (i2 + j3 > j2) {
                        i2 = (int) (j2 - j3);
                    }
                }
                i3 = inputStream.read(bArr, 0, i2);
                if (i3 > 0) {
                    outputStream.write(bArr, 0, i3);
                    j3 += i3;
                    this.f11005b.f10989b.f10956b = j3;
                    this.f11006c.l();
                }
            }
            c.a.p0.q.c.b().y("PMSTaskProcessor", "#copyStream canceled=" + this.f11007d.get() + " readed" + j3 + " totalBytes=" + j2);
            return j3 == j2;
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        c.a.p0.q.i.i.f.e eVar;
        Exception e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f11007d.get()) {
            return;
        }
        c.a.p0.q.i.i.f.e eVar2 = null;
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            f11004f.g("PMSTaskProcessor", "#downloadLogic 没有网络连接", null);
            this.f11005b.a = new c.a.p0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_MISS_PARAM, "download : no network");
            this.f11005b.a.a("没有网络连接");
        } else if (!this.f11006c.c()) {
            f11004f.g("PMSTaskProcessor", "#downloadLogic 无法创建本地文件", null);
            this.f11005b.a = new c.a.p0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            this.f11006c.p();
            try {
                try {
                    eVar = c.a.p0.q.c.b().A().b(this.f11005b.f10989b.n, this.a);
                    try {
                        int code = eVar.code();
                        int d2 = d(eVar, code);
                        if (this.f11005b.a.a != d2) {
                            this.f11005b.a = new c.a.p0.q.h.b(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                            this.f11005b.a.a("状态不匹配错误，可能有未捕获的异常");
                            f11004f.g("PMSTaskProcessor", "#downloadLogic 状态不匹配错误 errorCode=" + d2 + " errNo=" + this.f11005b.a.a + " httpStatus=" + code, null);
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        f11004f.g("PMSTaskProcessor", "#downloadLogic 包下载异常", e2);
                        this.f11005b.a = new c.a.p0.q.h.b(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        this.f11005b.a.a(Log.getStackTraceString(e2));
                        c.a.p0.w.d.d(eVar);
                    }
                } catch (Throwable th) {
                    th = th;
                    eVar2 = eVar;
                    c.a.p0.w.d.d(eVar2);
                    throw th;
                }
            } catch (Exception e4) {
                eVar = null;
                e2 = e4;
            } catch (Throwable th2) {
                th = th2;
                c.a.p0.w.d.d(eVar2);
                throw th;
            }
            c.a.p0.w.d.d(eVar);
        }
    }

    public final boolean c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!new File(str).exists()) {
                this.f11005b.a = new c.a.p0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, c.a.p0.q.o.e.a("local file save failed:", str)));
                return false;
            }
            String str2 = this.f11005b.f10989b.l;
            String b2 = c.a.p0.q.o.c.b(new File(str), true);
            if (str2 != null && b2 != null) {
                String upperCase = str2.toUpperCase();
                if (upperCase.equals(b2)) {
                    return true;
                }
                this.f11005b.a = new c.a.p0.q.h.b(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + c.a.p0.q.o.e.a("server:", upperCase, ",local", b2));
                return false;
            }
            this.f11005b.a = new c.a.p0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, c.a.p0.q.o.e.a("server:", str2, ",local", b2)));
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int d(c.a.p0.q.i.i.f.e eVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, eVar, i2)) == null) {
            c.a.p0.q.c.b().y("PMSTaskProcessor", "#parseResponse url=" + this.f11005b.f10989b.n + " code=" + eVar.code());
            this.f11005b.a = null;
            if (i2 >= 200 && i2 <= 300) {
                c.a.p0.q.i.i.f.d body = eVar.body();
                if (body != null) {
                    long a = body.a();
                    f11004f.g("PMSTaskProcessor", "#parseResponse currentSize=" + this.f11005b.f10989b.f10956b + " pkgSize=" + this.f11005b.f10989b.k + " contentLength=" + a, null);
                    if (!this.f11006c.j(this.f11005b.f10989b.k)) {
                        f11004f.g("PMSTaskProcessor", "#parseResponse 磁盘空间不足", null);
                        this.f11005b.a = new c.a.p0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                        return this.f11005b.a.a;
                    }
                    try {
                        if (e(body, a)) {
                            this.f11005b.a = new c.a.p0.q.h.b(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                            return this.f11005b.a.a;
                        }
                    } catch (IOException e2) {
                        f11004f.g("PMSTaskProcessor", "#parseResponse 写到文件过程中出错", e2);
                        this.f11005b.a = new c.a.p0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                        return this.f11005b.a.a;
                    }
                }
                e eVar2 = this.f11005b;
                if (eVar2.a == null) {
                    eVar2.a = new c.a.p0.q.h.b(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                    this.f11005b.a.a("错误码为空时设置的默认错误");
                }
                return this.f11005b.a.a;
            }
            String str = "statusCode=" + i2;
            f11004f.g("PMSTaskProcessor", "#parseResponse error " + str, null);
            e eVar3 = this.f11005b;
            c.a.p0.q.h.b bVar = new c.a.p0.q.h.b(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
            bVar.a(str);
            eVar3.a = bVar;
            return this.f11005b.a.a;
        }
        return invokeLI.intValue;
    }

    public final boolean e(c.a.p0.q.i.i.f.d dVar, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048580, this, dVar, j2)) != null) {
            return invokeLJ.booleanValue;
        }
        f<T> fVar = this.f11006c;
        c<T> cVar = fVar.f10994i;
        ReadableByteChannel readableByteChannel = null;
        try {
            T t = this.f11008e;
            File file = fVar.f10992g;
            ReadableByteChannel source = dVar.source();
            try {
                c.a.p0.q.h.b h2 = cVar.h(t, file, j2, source);
                if (h2.a == 2302) {
                    if (f(Channels.newInputStream(source), new FileOutputStream(this.f11006c.f10992g), j2) && c(this.f11005b.f10989b.a)) {
                        if (source != null && source.isOpen()) {
                            c.a.p0.w.d.d(source);
                        }
                        return true;
                    }
                    if (source != null && source.isOpen()) {
                        c.a.p0.w.d.d(source);
                    }
                    return false;
                } else if (h2.a == 2300) {
                    this.f11005b.f10989b.f10956b = j2;
                    this.f11006c.l();
                    if (source != null && source.isOpen()) {
                        c.a.p0.w.d.d(source);
                    }
                    return true;
                } else {
                    this.f11005b.a = h2;
                    if (source != null && source.isOpen()) {
                        c.a.p0.w.d.d(source);
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                readableByteChannel = source;
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    c.a.p0.w.d.d(readableByteChannel);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean f(InputStream inputStream, OutputStream outputStream, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{inputStream, outputStream, Long.valueOf(j2)})) == null) {
            try {
                try {
                    return a(inputStream, outputStream, j2);
                } catch (IOException e2) {
                    c.a.p0.q.c.b().G("PMSTaskProcessor", "#safeCopyStream 写入输出流出错", e2);
                    c.a.p0.w.d.d(inputStream);
                    c.a.p0.w.d.d(outputStream);
                    return false;
                }
            } finally {
                c.a.p0.w.d.d(inputStream);
                c.a.p0.w.d.d(outputStream);
            }
        }
        return invokeCommon.booleanValue;
    }
}
