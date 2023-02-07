package com.baidu.ar.arplay.core.engine;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class ARPScriptEnvironment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_AR_KEY = "ar_key";
    public static final String KEY_AR_TYPE = "ar_type";
    public static final String KEY_DATA_CAMERA_POSITION = "camera_position";
    public static final String KEY_DATA_PIP_IMU = "imu";
    public static final String KEY_DATA_PIP_SLAM = "slam";
    public static final String KEY_DATA_PIP_TRACK = "track";
    public static ARPScriptEnvironment mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map mDataPip;
    public Map mEnvironment;
    public Lock mLock;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1559930267, "Lcom/baidu/ar/arplay/core/engine/ARPScriptEnvironment;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1559930267, "Lcom/baidu/ar/arplay/core/engine/ARPScriptEnvironment;");
        }
    }

    public ARPScriptEnvironment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEnvironment = new HashMap();
        this.mDataPip = new HashMap();
        this.mLock = new ReentrantLock();
    }

    public static ARPScriptEnvironment getInstance() {
        InterceptResult invokeV;
        ARPScriptEnvironment aRPScriptEnvironment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ARPScriptEnvironment aRPScriptEnvironment2 = mInstance;
            if (aRPScriptEnvironment2 == null) {
                synchronized (ARPScriptEnvironment.class) {
                    if (mInstance == null) {
                        mInstance = new ARPScriptEnvironment();
                    }
                    aRPScriptEnvironment = mInstance;
                }
                return aRPScriptEnvironment;
            }
            return aRPScriptEnvironment2;
        }
        return (ARPScriptEnvironment) invokeV.objValue;
    }

    public static native Object nativeGetSharedEnvironment();

    public static native void nativeSetDataPip(Object obj);

    public static native void nativeSetSharedEnvironment(Object obj);

    public static void setSharedEnvironment(Map map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, map) == null) || map == null) {
            return;
        }
        nativeSetSharedEnvironment(map);
    }

    public Object getSharedEnvironmentValue(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.mLock.lock();
            try {
                try {
                    obj = nativeGetSharedEnvironment();
                } catch (Exception e) {
                    e.printStackTrace();
                    this.mLock.unlock();
                    obj = null;
                }
                if (obj instanceof HashMap) {
                    return ((HashMap) obj).get(str);
                }
                return null;
            } finally {
                this.mLock.unlock();
            }
        }
        return invokeL.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Map map = this.mEnvironment;
            if (map != null) {
                map.clear();
            }
            Map map2 = this.mDataPip;
            if (map2 != null) {
                map2.clear();
            }
        }
    }

    public void setDataPipKV(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (obj == null) {
            this.mDataPip.remove(str);
        }
        this.mDataPip.put(str, obj);
        nativeSetDataPip(this.mDataPip);
    }

    public void setLocalEnvironmentKV(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, obj) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (obj == null) {
            this.mEnvironment.remove(str);
        }
        this.mEnvironment.put(str, obj);
    }

    public void setSharedEnvironmentKV(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, obj) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mLock.lock();
        try {
            if (obj == null) {
                try {
                    this.mEnvironment.remove(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mEnvironment.put(str, obj);
            nativeSetSharedEnvironment(this.mEnvironment);
        } finally {
            this.mLock.unlock();
        }
    }

    public void syncSharedEnvironmentData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mLock.lock();
            try {
                try {
                    nativeSetSharedEnvironment(this.mEnvironment);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public void testEnvironmentData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            nativeGetSharedEnvironment();
            Log.e("ARPScriptEnvironment", "getSharedEnvironmentValue(KEY_AR_KEY) :" + getSharedEnvironmentValue("ar_key"));
            getSharedEnvironmentValue(DebugActiveUploadResult.SOURCE);
            Log.e("ARPScriptEnvironment", "end");
        }
    }
}
