package com.baidu.searchbox.network.outback.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class AbstractHttpManager {
    public static final String TAG = "Outback";
    public CallFactory callFactory;
    public Context context;
    public CallFactory defaultCallFactory;
    public Map<String, CallFactory> callFactoryMap = new HashMap();
    public Handler deliver = new Handler(Looper.getMainLooper());
    public RequestHandler requestHandler = new RequestHandler.Default();
    public CallFactoryParams callFactoryParams = new CallFactoryParams.Builder().build();

    public AbstractHttpManager(Context context) {
        this.context = context.getApplicationContext();
        checkHasInitEngineCallApi();
        initCallFactory(this.callFactoryParams);
    }

    private void cancleTagByCall(Call call, Object obj) {
        if (obj.equals(call.request().tag())) {
            call.cancel();
        }
    }

    public void chooseEngine(String str, CallFactoryParams callFactoryParams) {
        CallFactory chooseCallFactory = OutbackComponent.getInstance().chooseCallFactory(str, callFactoryParams);
        this.callFactory = chooseCallFactory;
        this.callFactoryMap.put("CUSTOM", chooseCallFactory);
    }

    private void checkHasInitEngineCallApi() {
        if (OutbackComponent.getInstance().isCallFactoryProducerAvailable()) {
            return;
        }
        throw new RuntimeException("need init EngineCallRuntime setEngineCallApi before here ");
    }

    private void setBackUpEngine() {
        this.callFactoryMap.put(EngineName.BACK_UP_ENGINE, OutbackComponent.getInstance().getBackupCallFactory(this.callFactoryParams));
    }

    public Map<String, CallFactory> getCallFactoryMap() {
        return this.callFactoryMap;
    }

    public Handler getDeliver() {
        return this.deliver;
    }

    public String getNetworkInfo() {
        return ConnectManager.getNetworkInfo(this.context);
    }

    public GetRequest.GetRequestBuilder getRequest() {
        return new GetRequest.GetRequestBuilder(this.callFactoryMap);
    }

    public RequestHandler getRequestHandler() {
        return this.requestHandler;
    }

    public boolean isNetWorkConnected() {
        return ConnectManager.isNetworkConnected(this.context);
    }

    public boolean isWifi() {
        return ConnectManager.isWifi(this.context);
    }

    public PostByteRequest.PostByteRequestBuilder postByteRequest() {
        return new PostByteRequest.PostByteRequestBuilder(this.callFactoryMap);
    }

    public PostFormRequest.PostFormRequestBuilder postFormRequest() {
        return new PostFormRequest.PostFormRequestBuilder(this.callFactoryMap);
    }

    public PostStringRequest.PostStringRequestBuilder postStringRequest() {
        return new PostStringRequest.PostStringRequestBuilder(this.callFactoryMap);
    }

    public void chooseEngine(String str) {
        chooseEngine(str, this.callFactoryParams);
    }

    public void initCallFactory(CallFactoryParams callFactoryParams) {
        CallFactory newCallFactory = OutbackComponent.getInstance().newCallFactory(callFactoryParams);
        this.defaultCallFactory = newCallFactory;
        this.callFactoryMap.put(EngineName.DEFAULT_ENGINE, newCallFactory);
        setBackUpEngine();
    }

    public void setRequestHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }
}
