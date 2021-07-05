package com.baidu.ar.ihttp;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.h.i;
import com.baidu.ar.h.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public final class Downloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String rs;
    public int rt;

    public Downloader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rs = str;
        this.rt = 0;
    }

    public static void a(InputStream inputStream, String str, int i2, IProgressCallback iProgressCallback) {
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLIL(65539, null, inputStream, str, i2, iProgressCallback) != null) {
            return;
        }
        i.c(new File(str));
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                randomAccessFile.seek(0L);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream, 8192);
                int i3 = 0;
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(bArr, 0, 8192);
                        if (read == -1) {
                            k.closeQuietly(bufferedInputStream2);
                            k.closeQuietly(randomAccessFile);
                            return;
                        }
                        randomAccessFile.write(bArr, 0, read);
                        i3 += read;
                        if (iProgressCallback != null) {
                            iProgressCallback.onProgress(i3, i2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        k.closeQuietly(bufferedInputStream);
                        k.closeQuietly(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    public static int getNetFileSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) ? HttpFactory.newRequest().setUrl(str).setMethod("HEAD").execute().getContentLength() : invokeL.intValue;
    }

    public int download(String str, IProgressCallback iProgressCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, iProgressCallback)) == null) {
            int fileSize = getFileSize();
            IHttpResponse execute = HttpFactory.newRequest().setUrl(this.rs).setMethod("GET").execute();
            if (execute.isSuccess()) {
                a(execute.getStream(), str, fileSize, iProgressCallback);
                return fileSize;
            }
            throw new HttpException(4, "下载失败");
        }
        return invokeLL.intValue;
    }

    public IHttpRequest downloadAsync(String str, ICallbackWith<Integer> iCallbackWith, ICallbackWith<Exception> iCallbackWith2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iCallbackWith, iCallbackWith2)) == null) ? downloadAsync(str, iCallbackWith, iCallbackWith2, null) : (IHttpRequest) invokeLLL.objValue;
    }

    public IHttpRequest downloadAsync(String str, ICallbackWith<Integer> iCallbackWith, ICallbackWith<Exception> iCallbackWith2, IProgressCallback iProgressCallback) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, iCallbackWith, iCallbackWith2, iProgressCallback)) == null) {
            IHttpRequest newRequest = HttpFactory.newRequest();
            newRequest.setUrl(this.rs).setMethod("HEAD").enqueue(new a(this, str, iProgressCallback, iCallbackWith2, iCallbackWith) { // from class: com.baidu.ar.ihttp.Downloader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ICallbackWith bT;
                public final /* synthetic */ String ru;
                public final /* synthetic */ IProgressCallback rv;
                public final /* synthetic */ ICallbackWith rw;

                /* renamed from: rx  reason: collision with root package name */
                public final /* synthetic */ Downloader f4224rx;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, iProgressCallback, iCallbackWith2, iCallbackWith};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f4224rx = this;
                    this.ru = str;
                    this.rv = iProgressCallback;
                    this.rw = iCallbackWith2;
                    this.bT = iCallbackWith;
                }

                @Override // com.baidu.ar.ihttp.a
                public void a(HttpException httpException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, httpException) == null) {
                        this.rw.run(httpException);
                    }
                }

                @Override // com.baidu.ar.ihttp.a
                public void a(IHttpResponse iHttpResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iHttpResponse) == null) {
                        this.f4224rx.rt = iHttpResponse.getContentLength();
                        try {
                            this.f4224rx.download(this.ru, this.rv);
                            this.bT.run(Integer.valueOf(this.f4224rx.rt));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            this.rw.run(e2);
                        }
                    }
                }
            });
            return newRequest;
        }
        return (IHttpRequest) invokeLLLL.objValue;
    }

    public int getFileSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.rt == 0) {
                this.rt = getNetFileSize(this.rs);
            }
            return this.rt;
        }
        return invokeV.intValue;
    }
}
