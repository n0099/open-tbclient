package com.baidu.searchbox.aideviceperformance.inference;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ai.AlgorithmType;
import com.baidu.searchbox.ai.Common;
import com.baidu.searchbox.ai.DataType;
import com.baidu.searchbox.ai.Inference;
import com.baidu.searchbox.ai.Tensor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class InferenceWrapper implements AutoCloseable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InferenceWrapper";
    public transient /* synthetic */ FieldHolder $fh;
    public Inference mInference;
    public DevicePerformanceModelInfo mModel;

    /* loaded from: classes4.dex */
    public interface InitCallback {
        void onInitResult(boolean z, String str);
    }

    public InferenceWrapper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
        com.baidu.searchbox.aideviceperformance.inference.InferenceRecorder.getInstance().inferenceStop(r4.mModel.getModelPath());
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        r4.mInference = null;
        r4.mModel = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r4.mModel == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r4.mModel != null) goto L11;
     */
    /* JADX WARN: Finally extract failed */
    @Override // java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        try {
            try {
                if (this.mInference != null) {
                    this.mInference.close();
                    this.mInference = null;
                }
            } catch (Exception e2) {
                if (InferenceConfig.DEBUG) {
                    e2.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (this.mModel != null) {
                InferenceRecorder.getInstance().inferenceStop(this.mModel.getModelPath());
            }
            this.mInference = null;
            this.mModel = null;
            throw th;
        }
    }

    public void init(AlgorithmType algorithmType, DevicePerformanceModelInfo devicePerformanceModelInfo) throws ModelLoadException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, algorithmType, devicePerformanceModelInfo) == null) && innerCheck(algorithmType, devicePerformanceModelInfo)) {
            this.mInference = Inference.getInstance(algorithmType.value(), devicePerformanceModelInfo.modelPath);
            this.mModel = devicePerformanceModelInfo;
            InferenceRecorder.getInstance().inferenceStart(devicePerformanceModelInfo.modelPath);
        }
    }

    public void initAndPreload(AlgorithmType algorithmType, DevicePerformanceModelInfo devicePerformanceModelInfo, DataType dataType) throws ModelLoadException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, algorithmType, devicePerformanceModelInfo, dataType) == null) && innerCheck(algorithmType, devicePerformanceModelInfo)) {
            Inference inference = Inference.getInstance(algorithmType.value(), devicePerformanceModelInfo.modelPath);
            this.mInference = inference;
            inference.preloadModel(dataType);
            this.mModel = devicePerformanceModelInfo;
            InferenceRecorder.getInstance().inferenceStart(devicePerformanceModelInfo.modelPath);
        }
    }

    public boolean innerCheck(AlgorithmType algorithmType, DevicePerformanceModelInfo devicePerformanceModelInfo) throws ModelLoadException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, algorithmType, devicePerformanceModelInfo)) == null) {
            if (devicePerformanceModelInfo != null && algorithmType != null) {
                if (Common.getSDKVersion() != null) {
                    if (TextUtils.isEmpty(devicePerformanceModelInfo.modelPath)) {
                        if (InferenceConfig.DEBUG) {
                            Log.d(TAG, "has no model for id: " + devicePerformanceModelInfo.modelPath);
                        }
                        throw new ModelLoadException(-1, "has no model");
                    } else if (new File(devicePerformanceModelInfo.modelPath).exists()) {
                        return true;
                    } else {
                        if (InferenceConfig.DEBUG) {
                            Log.d(TAG, "has no model for id: " + devicePerformanceModelInfo.modelPath);
                        }
                        throw new ModelLoadException(-1, "has no model");
                    }
                }
                throw new ModelLoadException();
            }
            throw new ModelLoadException();
        }
        return invokeLL.booleanValue;
    }

    public <T> T[] predictForClassArray(Tensor tensor, float f2, Class<T> cls) throws com.baidu.searchbox.ai.InferenceException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{tensor, Float.valueOf(f2), cls})) == null) {
            Inference inference = this.mInference;
            if (inference != null) {
                return (T[]) inference.predictForClassArray(tensor, f2, cls);
            }
            throw new IllegalStateException("not init!!!");
        }
        return (T[]) ((Object[]) invokeCommon.objValue);
    }

    public int predictForClassId(Tensor tensor, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048581, this, tensor, f2)) == null) {
            Inference inference = this.mInference;
            if (inference != null) {
                return inference.predictForClassId(tensor, f2);
            }
            throw new IllegalStateException("not init!!!");
        }
        return invokeLF.intValue;
    }

    public String predictForClassName(Tensor tensor, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048582, this, tensor, f2)) == null) {
            Inference inference = this.mInference;
            if (inference != null) {
                return inference.predictForClassName(tensor, f2);
            }
            throw new IllegalStateException("not init!!!");
        }
        return (String) invokeLF.objValue;
    }

    public <T> T predictForRegressorTarget(Tensor tensor, float f2, Class<T> cls) throws com.baidu.searchbox.ai.InferenceException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{tensor, Float.valueOf(f2), cls})) == null) {
            Inference inference = this.mInference;
            if (inference != null) {
                return (T) inference.predictForRegressorTarget(tensor, f2, cls);
            }
            throw new IllegalStateException("not init!!!");
        }
        return (T) invokeCommon.objValue;
    }

    public <T> T[] predictForRegressorTargetArray(Tensor tensor, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, tensor, f2)) == null) {
            Inference inference = this.mInference;
            if (inference != null) {
                return (T[]) inference.predictForRegressorTargetArray(tensor, f2);
            }
            throw new IllegalStateException("not init!!!");
        }
        return (T[]) ((Object[]) invokeLF.objValue);
    }
}
