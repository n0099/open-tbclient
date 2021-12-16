package com.baidu.ar.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes9.dex */
public class c implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mLock;
    public com.baidu.ar.ihttp.a qF;
    public volatile boolean qH;
    public g qK;
    public HttpURLConnection qL;
    public i qM;
    public IProgressCallback qN;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(g gVar) {
        this(gVar, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((g) objArr2[0], (com.baidu.ar.ihttp.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c(g gVar, com.baidu.ar.ihttp.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.qH = false;
        this.qK = gVar;
        this.qF = aVar;
        this.qL = null;
        this.qM = null;
    }

    @Override // com.baidu.ar.http.l
    public void cancel() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.qH) {
            return;
        }
        this.qF = null;
        this.qN = null;
        synchronized (this.mLock) {
            this.qH = true;
        }
    }

    @Override // com.baidu.ar.http.l
    public i eH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.qM : (i) invokeV.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010d  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i eJ() {
        InterceptResult invokeV;
        InputStream[] inputStreamArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return (i) invokeV.objValue;
        }
        synchronized (this.mLock) {
            ?? r2 = 0;
            r2 = 0;
            r2 = 0;
            if (this.qH) {
                return null;
            }
            int i2 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) this.qK.url.openConnection();
                    this.qL = httpURLConnection;
                    httpURLConnection.setConnectTimeout(this.qK.rc.rg);
                    this.qL.setReadTimeout(this.qK.rc.rh);
                    this.qL.setUseCaches(this.qK.rc.ri);
                    this.qL.setRequestMethod(this.qK.method);
                    if (this.qK.rd != null) {
                        for (Map.Entry<String, String> entry : this.qK.rd.entrySet()) {
                            this.qL.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (!"POST".equals(this.qK.method) || this.qK.re == null) {
                        inputStreamArr = null;
                    } else {
                        int size = this.qK.re.getSize();
                        inputStreamArr = this.qK.re.eI();
                        if (inputStreamArr != null) {
                            try {
                                if (inputStreamArr.length > 0) {
                                    this.qL.setDoOutput(true);
                                    OutputStream outputStream = this.qL.getOutputStream();
                                    byte[] bArr = new byte[1024];
                                    int i3 = 0;
                                    for (InputStream inputStream : inputStreamArr) {
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read != -1) {
                                                outputStream.write(bArr, 0, read);
                                                if (this.qN != null) {
                                                    i3 += read;
                                                    this.qN.onProgress(i3, size);
                                                }
                                            }
                                        }
                                    }
                                    outputStream.flush();
                                    r2 = outputStream;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                if (this.qL != null) {
                                    this.qL.disconnect();
                                }
                                throw new HttpException(e);
                            }
                        }
                    }
                    i iVar = new i(this.qL, this.qK.rb);
                    this.qM = iVar;
                    if (r2 != 0) {
                        j.closeQuietly(r2);
                    }
                    if (inputStreamArr != null) {
                        int length = inputStreamArr.length;
                        while (i2 < length) {
                            j.closeQuietly(inputStreamArr[i2]);
                            i2++;
                        }
                    }
                    return iVar;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        j.closeQuietly(null);
                    }
                    if (0 != 0) {
                        int length2 = r2.length;
                        while (i2 < length2) {
                            j.closeQuietly(r2[i2]);
                            i2++;
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                if (0 != 0) {
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        HttpException httpException;
        HttpURLConnection httpURLConnection;
        boolean z;
        i eJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z2 = false;
            try {
                try {
                    eJ = eJ();
                } finally {
                    httpURLConnection = this.qL;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            } catch (HttpException e2) {
                httpException = e2;
            }
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                }
            } catch (HttpException e3) {
                httpException = e3;
                z2 = true;
                z = false;
                if (!z2) {
                    this.qF.a(httpException);
                }
            }
            synchronized (this.mLock) {
                try {
                    boolean z3 = this.qH;
                    if (!z3 && this.qF != null) {
                        try {
                            this.qF.a(eJ);
                        } catch (HttpException e4) {
                            httpException = e4;
                            z2 = z3;
                            z = true;
                            if (!z2 && !z && this.qF != null) {
                                this.qF.a(httpException);
                            }
                            if (httpURLConnection == null) {
                                return;
                            }
                        }
                    }
                    HttpURLConnection httpURLConnection2 = this.qL;
                    if (httpURLConnection2 == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }
    }

    public void setProgressCallback(IProgressCallback iProgressCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iProgressCallback) == null) {
            this.qN = iProgressCallback;
        }
    }
}
