package com.baidu.searchbox.v8engine.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.smallgame.sdk.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Observable;
@NotProguard
/* loaded from: classes4.dex */
public class NetRequest extends Observable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "NetRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<V8Engine> mEngineWeakReference;
    public NetRequestSettings mNetRequestSettings;
    public RedirectInterceptor mRedirectInterceptor;
    public RequestInterceptor mRequestInterceptor;

    /* loaded from: classes4.dex */
    public interface RedirectInterceptor {
        boolean shouldInterceptRedirect(NetRequestParam netRequestParam, NetRedirectInfo netRedirectInfo);
    }

    /* loaded from: classes4.dex */
    public interface RequestInterceptor {
        boolean shouldInterceptRequest(NetRequestResult netRequestResult, NetRequestParam netRequestParam);
    }

    public NetRequest() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeExecute(long j2, NetRequestParam netRequestParam);

    private synchronized void receiveRequestCallback(NetRequestParam netRequestParam, int i2, String str, int i3, String[] strArr, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{netRequestParam, Integer.valueOf(i2), str, Integer.valueOf(i3), strArr, Integer.valueOf(i4), str2}) == null) {
            synchronized (this) {
                if (netRequestParam != null && i2 != -1) {
                    NetRequestCallback netRequestCallback = netRequestParam.getNetRequestCallback();
                    if (netRequestCallback != null) {
                        if (i2 == 0) {
                            netRequestCallback.onSucceeded(str, i3, NetRequestParam.stringPairToMap(strArr));
                        } else if (i2 == 1) {
                            netRequestCallback.onFailed(i4, str2);
                        }
                    }
                }
            }
        }
    }

    private synchronized void receiveRequestResult(NetRequestResult netRequestResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, netRequestResult) == null) {
            synchronized (this) {
                setChanged();
                notifyObservers(netRequestResult);
            }
        }
    }

    private boolean shouldInterceptRedirect(NetRequestParam netRequestParam, NetRedirectInfo netRedirectInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, netRequestParam, netRedirectInfo)) == null) {
            RedirectInterceptor redirectInterceptor = this.mRedirectInterceptor;
            if (redirectInterceptor != null) {
                return redirectInterceptor.shouldInterceptRedirect(netRequestParam, netRedirectInfo);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean shouldInterceptRequest(NetRequestResult netRequestResult, NetRequestParam netRequestParam) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, netRequestResult, netRequestParam)) == null) {
            RequestInterceptor requestInterceptor = this.mRequestInterceptor;
            if (requestInterceptor != null) {
                return requestInterceptor.shouldInterceptRequest(netRequestResult, netRequestParam);
            }
            if (netRequestParam == null || netRequestParam.getJsObject() == null) {
                return false;
            }
            netRequestParam.getJsObject().release();
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void bindV8Engine(V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v8Engine) == null) {
            this.mEngineWeakReference = new WeakReference<>(v8Engine);
        }
    }

    public boolean execute(NetRequestParam netRequestParam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netRequestParam)) == null) {
            WeakReference<V8Engine> weakReference = this.mEngineWeakReference;
            if (weakReference == null) {
                Log.w(TAG, "Execute net request failed. Must call setNetRequest method of V8Engine object firstly");
                return false;
            }
            V8Engine v8Engine = weakReference.get();
            if (v8Engine == null) {
                Log.w(TAG, "Execute net request failed. The bound V8Engine object has been destroyed");
                return false;
            }
            v8Engine.postOnJSThread(new Runnable(this, v8Engine.nativePtr(), netRequestParam) { // from class: com.baidu.searchbox.v8engine.net.NetRequest.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NetRequest this$0;
                public final /* synthetic */ long val$nativePtr;
                public final /* synthetic */ NetRequestParam val$param;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(r7), netRequestParam};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$nativePtr = r7;
                    this.val$param = netRequestParam;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.nativeExecute(this.val$nativePtr, this.val$param);
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    public NetRequestSettings getNetRequestSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mNetRequestSettings : (NetRequestSettings) invokeV.objValue;
    }

    public RequestInterceptor getRequestInterceptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRequestInterceptor : (RequestInterceptor) invokeV.objValue;
    }

    public void setNetRequestSettings(NetRequestSettings netRequestSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, netRequestSettings) == null) {
            this.mNetRequestSettings = netRequestSettings;
            WeakReference<V8Engine> weakReference = this.mEngineWeakReference;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mEngineWeakReference.get().setNetRequest(this);
        }
    }

    public void setRedirectInterceptor(RedirectInterceptor redirectInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, redirectInterceptor) == null) {
            this.mRedirectInterceptor = redirectInterceptor;
        }
    }

    public void setRequestInterceptor(RequestInterceptor requestInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, requestInterceptor) == null) {
            this.mRequestInterceptor = requestInterceptor;
        }
    }
}
