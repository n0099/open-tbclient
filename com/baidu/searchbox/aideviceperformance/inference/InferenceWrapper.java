package com.baidu.searchbox.aideviceperformance.inference;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ai.AlgorithmType;
import com.baidu.searchbox.ai.Common;
import com.baidu.searchbox.ai.DataType;
import com.baidu.searchbox.ai.Inference;
import com.baidu.searchbox.ai.Tensor;
import java.io.File;
/* loaded from: classes2.dex */
public class InferenceWrapper implements AutoCloseable {
    public static final String TAG = "InferenceWrapper";
    public Inference mInference;
    public DevicePerformanceModelInfo mModel;

    /* loaded from: classes2.dex */
    public interface InitCallback {
        void onInitResult(boolean z, String str);
    }

    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r4.mModel == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r4.mModel != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        com.baidu.searchbox.aideviceperformance.inference.InferenceRecorder.getInstance().inferenceStop(r4.mModel.getModelPath());
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
        r4.mInference = null;
        r4.mModel = null;
     */
    /* JADX WARN: Finally extract failed */
    @Override // java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() {
        try {
            try {
                if (this.mInference != null) {
                    this.mInference.close();
                    this.mInference = null;
                }
            } catch (Exception e) {
                if (InferenceConfig.DEBUG) {
                    e.printStackTrace();
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
        if (!innerCheck(algorithmType, devicePerformanceModelInfo)) {
            return;
        }
        this.mInference = Inference.getInstance(algorithmType.value(), devicePerformanceModelInfo.modelPath);
        this.mModel = devicePerformanceModelInfo;
        InferenceRecorder.getInstance().inferenceStart(devicePerformanceModelInfo.modelPath);
    }

    public int predictForClassId(Tensor tensor, float f) {
        Inference inference = this.mInference;
        if (inference != null) {
            return inference.predictForClassId(tensor, f);
        }
        throw new IllegalStateException("not init!!!");
    }

    public String predictForClassName(Tensor tensor, float f) {
        Inference inference = this.mInference;
        if (inference != null) {
            return inference.predictForClassName(tensor, f);
        }
        throw new IllegalStateException("not init!!!");
    }

    public <T> T[] predictForRegressorTargetArray(Tensor tensor, float f) {
        Inference inference = this.mInference;
        if (inference != null) {
            return (T[]) inference.predictForRegressorTargetArray(tensor, f);
        }
        throw new IllegalStateException("not init!!!");
    }

    public void initAndPreload(AlgorithmType algorithmType, DevicePerformanceModelInfo devicePerformanceModelInfo, DataType dataType) throws ModelLoadException {
        if (!innerCheck(algorithmType, devicePerformanceModelInfo)) {
            return;
        }
        Inference inference = Inference.getInstance(algorithmType.value(), devicePerformanceModelInfo.modelPath);
        this.mInference = inference;
        inference.preloadModel(dataType);
        this.mModel = devicePerformanceModelInfo;
        InferenceRecorder.getInstance().inferenceStart(devicePerformanceModelInfo.modelPath);
    }

    public <T> T[] predictForClassArray(Tensor tensor, float f, Class<T> cls) throws com.baidu.searchbox.ai.InferenceException {
        Inference inference = this.mInference;
        if (inference != null) {
            return (T[]) inference.predictForClassArray(tensor, f, cls);
        }
        throw new IllegalStateException("not init!!!");
    }

    public <T> T predictForRegressorTarget(Tensor tensor, float f, Class<T> cls) throws com.baidu.searchbox.ai.InferenceException {
        Inference inference = this.mInference;
        if (inference != null) {
            return (T) inference.predictForRegressorTarget(tensor, f, cls);
        }
        throw new IllegalStateException("not init!!!");
    }

    public boolean innerCheck(AlgorithmType algorithmType, DevicePerformanceModelInfo devicePerformanceModelInfo) throws ModelLoadException {
        if (devicePerformanceModelInfo != null && algorithmType != null) {
            if (Common.getSDKVersion() != null) {
                if (TextUtils.isEmpty(devicePerformanceModelInfo.modelPath)) {
                    if (InferenceConfig.DEBUG) {
                        Log.d(TAG, "has no model for id: " + devicePerformanceModelInfo.modelPath);
                    }
                    throw new ModelLoadException(-1, "has no model");
                } else if (!new File(devicePerformanceModelInfo.modelPath).exists()) {
                    if (InferenceConfig.DEBUG) {
                        Log.d(TAG, "has no model for id: " + devicePerformanceModelInfo.modelPath);
                    }
                    throw new ModelLoadException(-1, "has no model");
                } else {
                    return true;
                }
            }
            throw new ModelLoadException();
        }
        throw new ModelLoadException();
    }
}
