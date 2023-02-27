package com.baidu.searchbox.ai;

import java.lang.reflect.Array;
/* loaded from: classes2.dex */
public class Inference implements AutoCloseable {
    public int algorithm;
    public int dataType;
    public boolean hasInited = false;
    public String modelPath;
    public long nativeHandle;

    public static native void delete(long j, int i, int i2);

    public static native long innerInit(int i, int i2, String str);

    public static native Object innerPredictForClassArray(long j, int i, float f, int i2, long j2, int i3);

    public static native int innerPredictForClassId(long j, int i, float f, int i2, long j2, int i3);

    public static native String innerPredictForClassName(long j, int i, float f, int i2, long j2, int i3);

    public static native Object innerPredictForRegressorTarget(long j, int i, float f, int i2, long j2, int i3);

    public static native Object innerPredictForRegressorTargetArray(long j, int i, float f, int i2, long j2, int i3);

    static {
        Common.getSDKVersion();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        try {
            delete(this.nativeHandle, this.dataType, this.algorithm);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    private boolean checkInit(int i) {
        if (this.hasInited) {
            if (this.nativeHandle == 0) {
                return false;
            }
            return true;
        }
        try {
            this.nativeHandle = innerInit(this.algorithm, i, this.modelPath);
            this.dataType = i;
            this.hasInited = true;
            return true;
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean preloadModel(DataType dataType) {
        return checkInit(dataType.value());
    }

    public static Inference getInstance(int i, String str) {
        Inference inference = new Inference();
        inference.init(i, str);
        return inference;
    }

    private void init(int i, String str) {
        this.algorithm = i;
        this.modelPath = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] predictForClassArray(Tensor tensor, float f, Class<T> cls) throws InferenceException {
        if (tensor != null) {
            checkInit(tensor.getDataType().value());
            long j = this.nativeHandle;
            if (j != 0) {
                Object innerPredictForClassArray = innerPredictForClassArray(j, this.algorithm, f, tensor.getDataType().value(), tensor.getNativeHandle(), tensor.getDataType().value());
                if (innerPredictForClassArray != null) {
                    if (innerPredictForClassArray.getClass().isArray()) {
                        int length = Array.getLength(innerPredictForClassArray);
                        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
                        if (length > 0) {
                            for (int i = 0; i < length; i++) {
                                Object obj = Array.get(innerPredictForClassArray, i);
                                if (obj.getClass() == cls) {
                                    tArr[i] = obj;
                                }
                            }
                        }
                        return tArr;
                    }
                    throw new InferenceException(1);
                }
                throw new InferenceException(2);
            }
            throw new IllegalStateException("not init!!!");
        }
        throw new IllegalArgumentException("predict caller should pass valid input & output");
    }

    public <T> T predictForRegressorTarget(Tensor tensor, float f, Class<T> cls) throws InferenceException {
        if (tensor != null) {
            checkInit(tensor.getDataType().value());
            long j = this.nativeHandle;
            if (j != 0) {
                Object innerPredictForRegressorTarget = innerPredictForRegressorTarget(j, this.algorithm, f, tensor.getDataType().value(), tensor.getNativeHandle(), tensor.getDataType().value());
                if (innerPredictForRegressorTarget != null) {
                    if (innerPredictForRegressorTarget.getClass().isArray() && Array.getLength(innerPredictForRegressorTarget) > 0) {
                        T t = (T) Array.get(innerPredictForRegressorTarget, 0);
                        if (t.getClass() == cls) {
                            return t;
                        }
                    }
                    throw new InferenceException(1);
                }
                throw new InferenceException(2);
            }
            throw new IllegalStateException("not init!!!");
        }
        throw new IllegalArgumentException("predict caller should pass valid input & output");
    }

    public int predictForClassId(Tensor tensor, float f) {
        if (tensor != null) {
            checkInit(tensor.getDataType().value());
            long j = this.nativeHandle;
            if (j != 0) {
                return innerPredictForClassId(j, this.algorithm, f, tensor.getDataType().value(), tensor.getNativeHandle(), tensor.getDataType().value());
            }
            throw new IllegalStateException("not init!!!");
        }
        throw new IllegalArgumentException("predict caller should pass valid input & output");
    }

    public String predictForClassName(Tensor tensor, float f) {
        if (tensor != null) {
            checkInit(tensor.getDataType().value());
            long j = this.nativeHandle;
            if (j != 0) {
                return innerPredictForClassName(j, this.algorithm, f, tensor.getDataType().value(), tensor.getNativeHandle(), tensor.getDataType().value());
            }
            throw new IllegalStateException("not init!!!");
        }
        throw new IllegalArgumentException("predict caller should pass valid input & output");
    }

    public <T> T[] predictForRegressorTargetArray(Tensor tensor, float f) {
        if (tensor != null) {
            checkInit(tensor.getDataType().value());
            long j = this.nativeHandle;
            if (j != 0) {
                return (T[]) ((Object[]) innerPredictForRegressorTargetArray(j, this.algorithm, f, tensor.getDataType().value(), tensor.getNativeHandle(), tensor.getDataType().value()));
            }
            throw new IllegalStateException("not init!!!");
        }
        throw new IllegalArgumentException("predict caller should pass valid input & output");
    }
}
