package com.baidu.searchbox.aideviceperformance.inference;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class InferenceRecorder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InferenceRecorder";
    public static volatile InferenceRecorder mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCount;
    public Map<String, Integer> mInferenceMap;

    public InferenceRecorder() {
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

    public synchronized void inferenceStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.mInferenceMap.put(str, Integer.valueOf((this.mInferenceMap.containsKey(str) ? this.mInferenceMap.get(str).intValue() : 0) + 1));
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
                    int intValue = this.mInferenceMap.get(str).intValue();
                    if (intValue > 0 && this.mCount > 0) {
                        int i2 = intValue - 1;
                        if (i2 == 0) {
                            this.mInferenceMap.remove(str);
                        } else {
                            this.mInferenceMap.put(str, Integer.valueOf(i2));
                        }
                        this.mCount--;
                    }
                    if (InferenceConfig.DEBUG) {
                        String str2 = "Inference count error mCount=" + this.mCount + ", count is " + intValue + " for " + str;
                    }
                }
            }
        }
    }

    public synchronized boolean isInferencing() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                z = this.mCount > 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
