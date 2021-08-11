package com.baidu.searchbox.v8engine;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@NotProguard
/* loaded from: classes5.dex */
public class V8EngineConfiguration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mBasePath;
    public Context mContext;
    public String mDecodeBdFile;
    public V8FileSystemDelegatePolicy mFileSystemDelegatePolicy;
    public V8Engine.JavaScriptExceptionDelegate mJavaScriptExceptionDelegate;
    public String mJsPath;
    public Object mMainGlobalObject;
    public Object mOpenGlobalObject;
    public String mUserAgent;
    public List<V8Engine.V8EngineConsole> mV8EngineConsoles;
    public List<V8Engine.V8StatusListener> mV8StatusListeners;
    public V8ThreadDelegatePolicy mV8ThreadDelegatePolicy;

    /* loaded from: classes5.dex */
    public static class CacheInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean cached;
        public String jsPath;

        public CacheInfo(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.jsPath = str;
            this.cached = z;
        }
    }

    /* loaded from: classes5.dex */
    public static class CodeCacheSetting {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long diskCodeCacheSizeThreshold;
        public String id;
        public int maxCount;
        public ArrayList<String> pathList;
        public int sizeLimit;

        public CodeCacheSetting() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.diskCodeCacheSizeThreshold = 31457280L;
        }
    }

    /* loaded from: classes5.dex */
    public interface JSCacheCallback {
        void onCacheResult(CacheInfo cacheInfo);
    }

    public V8EngineConfiguration() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mV8EngineConsoles = new ArrayList();
        this.mV8StatusListeners = new ArrayList();
    }

    public void addV8EngineConsole(V8Engine.V8EngineConsole v8EngineConsole) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, v8EngineConsole) == null) || v8EngineConsole == null) {
            return;
        }
        this.mV8EngineConsoles.add(v8EngineConsole);
    }

    public void addV8StatusListener(V8Engine.V8StatusListener v8StatusListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8StatusListener) == null) || v8StatusListener == null) {
            return;
        }
        this.mV8StatusListeners.add(v8StatusListener);
    }

    public String getBasePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBasePath : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public String getDecodeBdFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDecodeBdFile : (String) invokeV.objValue;
    }

    public V8FileSystemDelegatePolicy getFileSystemDelegatePolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFileSystemDelegatePolicy : (V8FileSystemDelegatePolicy) invokeV.objValue;
    }

    public V8Engine.JavaScriptExceptionDelegate getJavaScriptExceptionDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mJavaScriptExceptionDelegate : (V8Engine.JavaScriptExceptionDelegate) invokeV.objValue;
    }

    public String getJsPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mJsPath : (String) invokeV.objValue;
    }

    public Object getMainGlobalObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mMainGlobalObject : invokeV.objValue;
    }

    public Object getOpenGlobalObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mOpenGlobalObject : invokeV.objValue;
    }

    public String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mUserAgent : (String) invokeV.objValue;
    }

    public List<V8Engine.V8EngineConsole> getV8EngineConsoles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mV8EngineConsoles : (List) invokeV.objValue;
    }

    public List<V8Engine.V8StatusListener> getV8StatusListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mV8StatusListeners : (List) invokeV.objValue;
    }

    public V8ThreadDelegatePolicy getV8ThreadDelegatePolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mV8ThreadDelegatePolicy : (V8ThreadDelegatePolicy) invokeV.objValue;
    }

    public void setBasePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mBasePath = str;
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            this.mContext = context;
        }
    }

    public void setDecodeBdFile(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mDecodeBdFile = str;
        }
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, v8FileSystemDelegatePolicy) == null) {
            this.mFileSystemDelegatePolicy = v8FileSystemDelegatePolicy;
        }
    }

    public void setJavaScriptExceptionDelegate(V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, javaScriptExceptionDelegate) == null) {
            this.mJavaScriptExceptionDelegate = javaScriptExceptionDelegate;
        }
    }

    public void setJsPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mJsPath = str;
        }
    }

    public void setMainGlobalObject(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, obj) == null) {
            this.mMainGlobalObject = obj;
        }
    }

    public void setOpenGlobalObject(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, obj) == null) {
            this.mOpenGlobalObject = obj;
        }
    }

    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mUserAgent = str;
        }
    }

    public void setV8EngineConsoles(List<V8Engine.V8EngineConsole> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            this.mV8EngineConsoles = list;
        }
    }

    public void setV8ThreadDelegatePolicy(V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, v8ThreadDelegatePolicy) == null) {
            this.mV8ThreadDelegatePolicy = v8ThreadDelegatePolicy;
        }
    }
}
