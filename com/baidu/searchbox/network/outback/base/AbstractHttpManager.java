package com.baidu.searchbox.network.outback.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.ConnectManager;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.searchbox.network.outback.OutbackComponent;
import com.baidu.searchbox.network.outback.base.RequestHandler;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.CallFactoryParams;
import com.baidu.searchbox.network.outback.request.GetRequest;
import com.baidu.searchbox.network.outback.request.PostByteRequest;
import com.baidu.searchbox.network.outback.request.PostFormRequest;
import com.baidu.searchbox.network.outback.request.PostStringRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class AbstractHttpManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Outback";
    public transient /* synthetic */ FieldHolder $fh;
    public CallFactory callFactory;
    public Map callFactoryMap;
    public CallFactoryParams callFactoryParams;
    public Context context;
    public CallFactory defaultCallFactory;
    public Handler deliver;
    public RequestHandler requestHandler;

    public AbstractHttpManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.callFactoryMap = new HashMap();
        this.context = context.getApplicationContext();
        this.deliver = new Handler(Looper.getMainLooper());
        this.requestHandler = new RequestHandler.Default();
        this.callFactoryParams = new CallFactoryParams.Builder().build();
        checkHasInitEngineCallApi();
        initCallFactory(this.callFactoryParams);
    }

    private void cancleTagByCall(Call call, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, this, call, obj) == null) && obj.equals(call.request().tag())) {
            call.cancel();
        }
    }

    public void chooseEngine(String str, CallFactoryParams callFactoryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, callFactoryParams) == null) {
            CallFactory chooseCallFactory = OutbackComponent.getInstance().chooseCallFactory(str, callFactoryParams);
            this.callFactory = chooseCallFactory;
            this.callFactoryMap.put("CUSTOM", chooseCallFactory);
        }
    }

    private void checkHasInitEngineCallApi() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65538, this) != null) || OutbackComponent.getInstance().isCallFactoryProducerAvailable()) {
            return;
        }
        throw new RuntimeException("need init EngineCallRuntime setEngineCallApi before here ");
    }

    private void setBackUpEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.callFactoryMap.put(EngineName.BACK_UP_ENGINE, OutbackComponent.getInstance().getBackupCallFactory(this.callFactoryParams));
        }
    }

    public Map getCallFactoryMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.callFactoryMap;
        }
        return (Map) invokeV.objValue;
    }

    public Handler getDeliver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.deliver;
        }
        return (Handler) invokeV.objValue;
    }

    public String getNetworkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ConnectManager.getNetworkInfo(this.context);
        }
        return (String) invokeV.objValue;
    }

    public GetRequest.GetRequestBuilder getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new GetRequest.GetRequestBuilder(this.callFactoryMap);
        }
        return (GetRequest.GetRequestBuilder) invokeV.objValue;
    }

    public RequestHandler getRequestHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.requestHandler;
        }
        return (RequestHandler) invokeV.objValue;
    }

    public boolean isNetWorkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ConnectManager.isNetworkConnected(this.context);
        }
        return invokeV.booleanValue;
    }

    public boolean isWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return ConnectManager.isWifi(this.context);
        }
        return invokeV.booleanValue;
    }

    public PostByteRequest.PostByteRequestBuilder postByteRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new PostByteRequest.PostByteRequestBuilder(this.callFactoryMap);
        }
        return (PostByteRequest.PostByteRequestBuilder) invokeV.objValue;
    }

    public PostFormRequest.PostFormRequestBuilder postFormRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new PostFormRequest.PostFormRequestBuilder(this.callFactoryMap);
        }
        return (PostFormRequest.PostFormRequestBuilder) invokeV.objValue;
    }

    public PostStringRequest.PostStringRequestBuilder postStringRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new PostStringRequest.PostStringRequestBuilder(this.callFactoryMap);
        }
        return (PostStringRequest.PostStringRequestBuilder) invokeV.objValue;
    }

    public void chooseEngine(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            chooseEngine(str, this.callFactoryParams);
        }
    }

    public void initCallFactory(CallFactoryParams callFactoryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, callFactoryParams) == null) {
            CallFactory newCallFactory = OutbackComponent.getInstance().newCallFactory(callFactoryParams);
            this.defaultCallFactory = newCallFactory;
            this.callFactoryMap.put(EngineName.DEFAULT_ENGINE, newCallFactory);
            setBackUpEngine();
        }
    }

    public void setRequestHandler(RequestHandler requestHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, requestHandler) == null) {
            this.requestHandler = requestHandler;
        }
    }
}
