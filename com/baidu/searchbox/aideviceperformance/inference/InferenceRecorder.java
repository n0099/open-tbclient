package com.baidu.searchbox.aideviceperformance.inference;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class InferenceRecorder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InferenceRecorder";
    public static volatile InferenceRecorder mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCount;
    public Map mInferenceMap;

    public InferenceRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInferenceMap = new HashMap();
        this.mCount = 0;
    }

    public static InferenceRecorder getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mInstance == null) {
                synchronized (InferenceRecorder.class) {
                    if (mInstance == null) {
                        mInstance = new InferenceRecorder();
                    }
                }
            }
            return mInstance;
        }
        return (InferenceRecorder) invokeV.objValue;
    }

    public synchronized boolean isInferencing() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.mCount > 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void inferenceStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                int i = 0;
                if (this.mInferenceMap.containsKey(str)) {
                    i = ((Integer) this.mInferenceMap.get(str)).intValue();
                }
                this.mInferenceMap.put(str, Integer.valueOf(i + 1));
                this.mCount++;
            }
        }
    }

    public synchronized void inferenceStop(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (this.mInferenceMap.containsKey(str)) {
                    int intValue = ((Integer) this.mInferenceMap.get(str)).intValue();
                    if (intValue > 0 && this.mCount > 0) {
                        int i = intValue - 1;
                        if (i == 0) {
                            this.mInferenceMap.remove(str);
                        } else {
                            this.mInferenceMap.put(str, Integer.valueOf(i));
                        }
                        this.mCount--;
                    }
                    if (InferenceConfig.DEBUG) {
                        Log.e(TAG, "Inference count error mCount=" + this.mCount + ", count is " + intValue + " for " + str);
                    }
                }
            }
        }
    }
}
