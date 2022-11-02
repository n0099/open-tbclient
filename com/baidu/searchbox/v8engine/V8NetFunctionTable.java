package com.baidu.searchbox.v8engine;

import android.webkit.ValueCallback;
import androidx.core.view.InputDeviceCompat;
import com.baidu.smallgame.sdk.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@NotProguard
/* loaded from: classes2.dex */
public class V8NetFunctionTable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "V8NetFunctionTable";
    public static long sNativeGlobalFunctionTablePointer;
    public static final List<ValueCallback<Long>> sV8NetFunctionTableInitListenerList;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-258722481, "Lcom/baidu/searchbox/v8engine/V8NetFunctionTable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-258722481, "Lcom/baidu/searchbox/v8engine/V8NetFunctionTable;");
                return;
            }
        }
        sV8NetFunctionTableInitListenerList = new ArrayList();
    }

    public V8NetFunctionTable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, valueCallback) == null) {
            synchronized (sV8NetFunctionTableInitListenerList) {
                if (valueCallback != null) {
                    if (sNativeGlobalFunctionTablePointer != 0) {
                        valueCallback.onReceiveValue(Long.valueOf(sNativeGlobalFunctionTablePointer));
                    } else {
                        sV8NetFunctionTableInitListenerList.add(valueCallback);
                    }
                }
            }
        }
    }

    public static void removeOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, valueCallback) == null) {
            synchronized (sV8NetFunctionTableInitListenerList) {
                sV8NetFunctionTableInitListenerList.remove(valueCallback);
            }
        }
    }

    public static void addOnCronetThreadInitializedListenerForT7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            try {
                Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("addOnCronetThreadInitializedListener", ValueCallback.class).invoke(null, new ValueCallback<Long>() { // from class: com.baidu.searchbox.v8engine.V8NetFunctionTable.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(Long l) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, l) == null) {
                            Log.i(V8NetFunctionTable.TAG, "[mario-request] Receive global V8NetFunctionTable raw pointer: " + l);
                            if (l != null && l.longValue() != 0) {
                                V8NetFunctionTable.notifyAllV8NetFunctionTableListeners(l.longValue());
                            } else {
                                Log.e(V8NetFunctionTable.TAG, "[mario-request] Failed to notify V8NetFunctionTable listeners, because pointer is null or 0");
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                Log.w(TAG, th.getMessage(), th);
            }
        }
    }

    public static void notifyAllV8NetFunctionTableListeners(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65541, null, j) == null) {
            synchronized (sV8NetFunctionTableInitListenerList) {
                sNativeGlobalFunctionTablePointer = j;
                for (ValueCallback<Long> valueCallback : sV8NetFunctionTableInitListenerList) {
                    valueCallback.onReceiveValue(Long.valueOf(j));
                }
                sV8NetFunctionTableInitListenerList.clear();
            }
        }
    }
}
