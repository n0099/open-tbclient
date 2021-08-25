package c.a.o0.n.i.i.g;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.pms.constants.ErrorConstant;
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
/* loaded from: classes3.dex */
public class j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f11915a;

    /* renamed from: b  reason: collision with root package name */
    public f<T> f11916b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f11917c;

    /* renamed from: d  reason: collision with root package name */
    public T f11918d;

    public j(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11916b = fVar;
        this.f11915a = fVar.f11900e;
        this.f11918d = fVar.f11901f;
        this.f11917c = fVar.f11903h;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, outputStream, Long.valueOf(j2)})) == null) {
            int i2 = 32768;
            byte[] bArr = new byte[32768];
            long j3 = 0;
            int i3 = 0;
            while (!this.f11917c.get() && i3 != -1) {
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
                    this.f11915a.f11899b.f11852b = j3;
                    this.f11916b.k();
                }
            }
            if (c.a.o0.n.c.f11828a) {
                String str = "copyStream: mCanceled=" + this.f11917c.get() + ", readed=" + j3 + ",totalBytes" + j2;
            }
            return j3 == j2;
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f11917c.get()) {
            return;
        }
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.f11915a.f11898a = new c.a.o0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
        } else if (!this.f11916b.c()) {
            this.f11915a.f11898a = new c.a.o0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            this.f11916b.o();
            c.a.o0.n.i.i.f.e eVar = null;
            try {
                try {
                    eVar = c.a.o0.n.c.b().y().b(this.f11915a.f11899b.n);
                    int code = eVar.code();
                    int d2 = d(eVar, code);
                    if (this.f11915a.f11898a.f11847a != d2) {
                        this.f11915a.f11898a = new c.a.o0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        if (c.a.o0.n.c.f11828a) {
                            String str = "mismatch errorCode:" + d2 + "!=" + this.f11915a.f11898a.f11847a + " HTTP-ErrorCode:" + code;
                        }
                    }
                } catch (Exception e2) {
                    if (c.a.o0.n.c.f11828a) {
                        e2.toString();
                        e2.printStackTrace();
                    }
                    this.f11915a.f11898a = new c.a.o0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
            } finally {
                c.a.o0.t.d.d(eVar);
            }
        }
    }

    public final boolean c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!new File(str).exists()) {
                this.f11915a.f11898a = new c.a.o0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, c.a.o0.n.o.d.a("local file save failed:", str)));
                return false;
            }
            String str2 = this.f11915a.f11899b.l;
            String b2 = c.a.o0.n.o.b.b(new File(str), true);
            if (str2 != null && b2 != null) {
                String upperCase = str2.toUpperCase();
                if (upperCase.equals(b2)) {
                    return true;
                }
                this.f11915a.f11898a = new c.a.o0.n.h.a(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + c.a.o0.n.o.d.a("server:", upperCase, ",local", b2));
                return false;
            }
            this.f11915a.f11898a = new c.a.o0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, c.a.o0.n.o.d.a("server:", str2, ",local", b2)));
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int d(c.a.o0.n.i.i.f.e eVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, eVar, i2)) == null) {
            if (c.a.o0.n.c.f11828a) {
                String str = "download " + this.f11915a.f11899b.n + "response code:" + eVar.code();
            }
            this.f11915a.f11898a = null;
            if (i2 >= 200 && i2 <= 300) {
                c.a.o0.n.i.i.f.d body = eVar.body();
                if (body != null) {
                    long a2 = body.a();
                    if (c.a.o0.n.c.f11828a) {
                        String str2 = "currentSize:" + this.f11915a.f11899b.f11852b + ",totalBytes:" + this.f11915a.f11899b.k + ",Content-Length:" + a2;
                    }
                    if (!this.f11916b.i(this.f11915a.f11899b.k)) {
                        this.f11915a.f11898a = new c.a.o0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                        return this.f11915a.f11898a.f11847a;
                    }
                    try {
                        if (e(body, a2)) {
                            this.f11915a.f11898a = new c.a.o0.n.h.a(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                            return this.f11915a.f11898a.f11847a;
                        }
                    } catch (IOException e2) {
                        if (c.a.o0.n.c.f11828a) {
                            e2.printStackTrace();
                        }
                        this.f11915a.f11898a = new c.a.o0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                        return this.f11915a.f11898a.f11847a;
                    }
                }
                e eVar2 = this.f11915a;
                if (eVar2.f11898a == null) {
                    eVar2.f11898a = new c.a.o0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
                return this.f11915a.f11898a.f11847a;
            }
            this.f11915a.f11898a = new c.a.o0.n.h.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
            return this.f11915a.f11898a.f11847a;
        }
        return invokeLI.intValue;
    }

    public final boolean e(c.a.o0.n.i.i.f.d dVar, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048580, this, dVar, j2)) != null) {
            return invokeLJ.booleanValue;
        }
        f<T> fVar = this.f11916b;
        c<T> cVar = fVar.f11904i;
        ReadableByteChannel readableByteChannel = null;
        try {
            T t = this.f11918d;
            File file = fVar.f11902g;
            ReadableByteChannel source = dVar.source();
            try {
                c.a.o0.n.h.a h2 = cVar.h(t, file, j2, source);
                if (h2.f11847a == 2302) {
                    if (f(Channels.newInputStream(source), new FileOutputStream(this.f11916b.f11902g), j2) && c(this.f11915a.f11899b.f11851a)) {
                        if (source != null && source.isOpen()) {
                            c.a.o0.t.d.d(source);
                        }
                        return true;
                    }
                    if (source != null && source.isOpen()) {
                        c.a.o0.t.d.d(source);
                    }
                    return false;
                } else if (h2.f11847a == 2300) {
                    this.f11915a.f11899b.f11852b = j2;
                    this.f11916b.k();
                    if (source != null && source.isOpen()) {
                        c.a.o0.t.d.d(source);
                    }
                    return true;
                } else {
                    this.f11915a.f11898a = h2;
                    if (source != null && source.isOpen()) {
                        c.a.o0.t.d.d(source);
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                readableByteChannel = source;
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    c.a.o0.t.d.d(readableByteChannel);
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
                    if (c.a.o0.n.c.f11828a) {
                        String str = "safeCopyStream: " + e2.getMessage();
                    }
                    c.a.o0.t.d.d(inputStream);
                    c.a.o0.t.d.d(outputStream);
                    return false;
                }
            } finally {
                c.a.o0.t.d.d(inputStream);
                c.a.o0.t.d.d(outputStream);
            }
        }
        return invokeCommon.booleanValue;
    }
}
