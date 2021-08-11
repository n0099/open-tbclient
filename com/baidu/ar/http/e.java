package com.baidu.ar.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService qQ;
    public int qR;
    public int qS;
    public int qT;
    public long qU;

    public e(int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.qR = i2;
        this.qS = i3;
        this.qT = i4;
        this.qU = j2;
    }

    private ExecutorService eK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.qQ == null) {
                this.qQ = new ThreadPoolExecutor(this.qR, this.qS, this.qU, TimeUnit.SECONDS, new LinkedBlockingQueue(this.qT), Executors.defaultThreadFactory(), new RejectedExecutionHandler(this) { // from class: com.baidu.ar.http.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ e qV;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.qV = this;
                    }

                    @Override // java.util.concurrent.RejectedExecutionHandler
                    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
                            com.baidu.ar.h.b.b("HttpRequestExecutor", "请求队列已满，请求被丢弃");
                        }
                    }
                });
            }
            return this.qQ;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public l a(g gVar, IProgressCallback iProgressCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gVar, iProgressCallback)) == null) {
            c cVar = new c(gVar);
            cVar.setProgressCallback(iProgressCallback);
            cVar.eJ();
            return cVar;
        }
        return (l) invokeLL.objValue;
    }

    public l a(g gVar, com.baidu.ar.ihttp.a aVar, IProgressCallback iProgressCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, aVar, iProgressCallback)) == null) {
            c cVar = new c(gVar, aVar);
            cVar.setProgressCallback(iProgressCallback);
            eK().submit(cVar);
            return cVar;
        }
        return (l) invokeLLL.objValue;
    }

    public l a(HttpException httpException, com.baidu.ar.ihttp.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, httpException, aVar)) == null) {
            a aVar2 = new a(httpException, aVar);
            eK().submit(aVar2);
            return aVar2;
        }
        return (l) invokeLL.objValue;
    }

    public void shutdown() {
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (executorService = this.qQ) == null) {
            return;
        }
        executorService.shutdown();
    }
}
