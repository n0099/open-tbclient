package com.baidu.searchbox.network.outback.request;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.Cancelable;
import com.baidu.searchbox.network.outback.ConnectManager;
import com.baidu.searchbox.network.outback.OutbackComponent;
import com.baidu.searchbox.network.outback.callback.ResponseCallback;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.Callback;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.response.ResponseException;
import com.baidu.searchbox.network.outback.response.StatusCodeException;
import com.baidu.searchbox.network.outback.statistics.DoRecordManager;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.searchbox.network.outback.statistics.RequestCallException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes3.dex */
public class RequestCall implements Cancelable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler deliver;
    public Call realCall;
    public Request request;

    public RequestCall(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {request};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.deliver = new Handler(Looper.getMainLooper());
        this.request = request;
        buildCall();
    }

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallback)) == null) {
            return executeAsyncWithHandler(null, responseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback)) == null) {
            return executeAsyncWithHandler(this.deliver, responseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeStat(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, responseCallback)) == null) {
            return executeStatWithHandler(null, responseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeStatUIBack(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, responseCallback)) == null) {
            return executeStatWithHandler(this.deliver, responseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    private void buildCall() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.realCall = this.request.newCall();
        }
    }

    private void checkExecuteWifiOnly() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.request.isWifiOnly && !ConnectManager.isWifi(getContext())) {
            throw new IOException(" only allow wifi connected");
        }
    }

    private void executePreCheck() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            checkExecuteWifiOnly();
        }
    }

    @Override // com.baidu.searchbox.network.outback.Cancelable
    public void cancel() {
        Call call;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (call = this.realCall) != null) {
            call.cancel();
        }
    }

    public Response executeStat() throws RequestCallException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return executeSync();
        }
        return (Response) invokeV.objValue;
    }

    public Call getCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.realCall;
        }
        return (Call) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OutbackComponent.getInstance().getContext();
        }
        return (Context) invokeV.objValue;
    }

    private void recordStatusCode(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65543, this, i, str) == null) && StatusCodeException.isStatusCodeMatched(i)) {
            StatusCodeException statusCodeException = new StatusCodeException(String.format("Server statusCode Error; statusCode=%s; response.message=%s", Integer.valueOf(i), str));
            Request request = this.request;
            if (request != null) {
                request.onException4NetworkStatRecord(statusCodeException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, ResponseCallback responseCallback, Exception exc) {
        Exception wrapNoNetworkExceptionWithDetail;
        String message;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, handler, responseCallback, exc) == null) {
            if (responseCallback != null) {
                if (ConnectManager.isNetworkConnected(getContext())) {
                    wrapNoNetworkExceptionWithDetail = exc;
                } else {
                    wrapNoNetworkExceptionWithDetail = ResponseException.wrapNoNetworkExceptionWithDetail(exc);
                }
                this.request.onException4NetworkStatRecord(wrapNoNetworkExceptionWithDetail);
                if (TextUtils.isEmpty(wrapNoNetworkExceptionWithDetail.getMessage())) {
                    message = exc.getClass().getName();
                } else {
                    message = wrapNoNetworkExceptionWithDetail.getMessage();
                }
                if (handler != null) {
                    handler.post(new Runnable(this, responseCallback, message, wrapNoNetworkExceptionWithDetail) { // from class: com.baidu.searchbox.network.outback.request.RequestCall.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ RequestCall this$0;
                        public final /* synthetic */ ResponseCallback val$callback;
                        public final /* synthetic */ String val$message;
                        public final /* synthetic */ Exception val$wrappedException;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, responseCallback, message, wrapNoNetworkExceptionWithDetail};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$callback = responseCallback;
                            this.val$message = message;
                            this.val$wrappedException = wrapNoNetworkExceptionWithDetail;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$callback.onFail(new RequestCallException(this.val$message, this.val$wrappedException, this.this$0.request.getNetworkStatRecord()));
                            }
                        }
                    });
                } else {
                    responseCallback.onFail(new RequestCallException(message, wrapNoNetworkExceptionWithDetail, this.request.getNetworkStatRecord()));
                }
            }
            DoRecordManager.getInstance().doRecord(this.request.getNetworkStatRecord(), DoRecordManager.FAILED_MSG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, ResponseCallback<T> responseCallback, Response response) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65545, this, handler, responseCallback, response) == null) && response != null) {
            try {
                recordStatusCode(response.code(), response.message());
                if (responseCallback != null) {
                    T parseResponse = responseCallback.parseResponse(response, response.code());
                    if (handler != null) {
                        handler.post(new Runnable(this, parseResponse, responseCallback, response) { // from class: com.baidu.searchbox.network.outback.request.RequestCall.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ RequestCall this$0;
                            public final /* synthetic */ ResponseCallback val$callback;
                            public final /* synthetic */ Object val$entity;
                            public final /* synthetic */ Response val$response;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, parseResponse, responseCallback, response};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$entity = parseResponse;
                                this.val$callback = responseCallback;
                                this.val$response = response;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    Object obj = this.val$entity;
                                    if (obj != null) {
                                        this.val$callback.onSuccess(obj, this.val$response.code());
                                    } else {
                                        this.val$callback.onFail(new IOException("parse response return null"));
                                    }
                                }
                            }
                        });
                    } else if (parseResponse != null) {
                        responseCallback.onSuccess(parseResponse, response.code());
                    } else {
                        responseCallback.onFail(new IOException("parse response return null"));
                    }
                }
                DoRecordManager.getInstance().doRecord(response.getStatRecord(), DoRecordManager.SUCCESSFUL_MSG);
            } catch (Exception e) {
                sendFailResult(handler, responseCallback, e);
            }
        }
    }

    public <T> Cancelable executeAsyncWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, handler, responseCallback)) == null) {
            try {
                executePreCheck();
                this.realCall.enqueue(new Callback(this, handler, responseCallback) { // from class: com.baidu.searchbox.network.outback.request.RequestCall.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RequestCall this$0;
                    public final /* synthetic */ ResponseCallback val$callback;
                    public final /* synthetic */ Handler val$handler;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, handler, responseCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$handler = handler;
                        this.val$callback = responseCallback;
                    }

                    @Override // com.baidu.searchbox.network.outback.core.Callback
                    public void onFailure(Call call, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                            this.this$0.sendFailResult(this.val$handler, this.val$callback, iOException);
                        }
                    }

                    @Override // com.baidu.searchbox.network.outback.core.Callback
                    public void onResponse(Call call, Response response) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                            this.this$0.sendSuccessResult(this.val$handler, this.val$callback, response);
                        }
                    }
                });
                return this;
            } catch (IOException e) {
                sendFailResult(handler, responseCallback, e);
                return this;
            }
        }
        return (Cancelable) invokeLL.objValue;
    }

    public <T> Cancelable executeStatWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, handler, responseCallback)) == null) {
            try {
                executePreCheck();
                this.realCall.enqueue(new Callback(this, handler, responseCallback) { // from class: com.baidu.searchbox.network.outback.request.RequestCall.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RequestCall this$0;
                    public final /* synthetic */ ResponseCallback val$callback;
                    public final /* synthetic */ Handler val$handler;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, handler, responseCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$handler = handler;
                        this.val$callback = responseCallback;
                    }

                    @Override // com.baidu.searchbox.network.outback.core.Callback
                    public void onFailure(Call call, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                            this.this$0.sendFailResult(this.val$handler, this.val$callback, iOException);
                        }
                    }

                    @Override // com.baidu.searchbox.network.outback.core.Callback
                    public void onResponse(Call call, Response response) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                            this.this$0.sendSuccessResult(this.val$handler, this.val$callback, response);
                        }
                    }
                });
                return this;
            } catch (IOException e) {
                sendFailResult(handler, responseCallback, e);
                return this;
            }
        }
        return (Cancelable) invokeLL.objValue;
    }

    public Response executeSync() throws RequestCallException {
        InterceptResult invokeV;
        Exception wrapNoNetworkExceptionWithDetail;
        String message;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = DoRecordManager.FAILED_MSG;
            NetworkStatRecord networkStatRecord = this.request.getNetworkStatRecord();
            try {
                try {
                    executePreCheck();
                    Response execute = this.realCall.execute();
                    if (execute != null) {
                        recordStatusCode(execute.code(), execute.message());
                        networkStatRecord = execute.getStatRecord();
                        i = DoRecordManager.SUCCESSFUL_MSG;
                    }
                    return execute;
                } catch (Exception e) {
                    if (ConnectManager.isNetworkConnected(getContext())) {
                        wrapNoNetworkExceptionWithDetail = e;
                    } else {
                        wrapNoNetworkExceptionWithDetail = ResponseException.wrapNoNetworkExceptionWithDetail(e);
                    }
                    wrapNoNetworkExceptionWithDetail.printStackTrace();
                    this.request.onException4NetworkStatRecord(wrapNoNetworkExceptionWithDetail);
                    this.request.getNetworkStatRecord();
                    int i2 = DoRecordManager.FAILED_MSG;
                    if (TextUtils.isEmpty(wrapNoNetworkExceptionWithDetail.getMessage())) {
                        message = Log.getStackTraceString(e);
                    } else {
                        message = wrapNoNetworkExceptionWithDetail.getMessage();
                    }
                    throw new RequestCallException(message, wrapNoNetworkExceptionWithDetail, this.request.getNetworkStatRecord());
                }
            } finally {
                DoRecordManager.getInstance().doRecord(networkStatRecord, i);
            }
        }
        return (Response) invokeV.objValue;
    }
}
