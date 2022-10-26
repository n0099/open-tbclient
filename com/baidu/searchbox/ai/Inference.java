package com.baidu.searchbox.ai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
/* loaded from: classes2.dex */
public class Inference implements AutoCloseable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int algorithm;
    public int dataType;
    public boolean hasInited;
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
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(547593967, "Lcom/baidu/searchbox/ai/Inference;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(547593967, "Lcom/baidu/searchbox/ai/Inference;");
                return;
            }
        }
        Common.getSDKVersion();
    }

    public Inference() {
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
        this.hasInited = false;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                delete(this.nativeHandle, this.dataType, this.algorithm);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkInit(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
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
        return invokeI.booleanValue;
    }

    public static Inference getInstance(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str)) == null) {
            Inference inference = new Inference();
            inference.init(i, str);
            return inference;
        }
        return (Inference) invokeIL.objValue;
    }

    private void init(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, this, i, str) == null) {
            this.algorithm = i;
            this.modelPath = str;
        }
    }

    public Object[] predictForClassArray(Tensor tensor, float f, Class cls) throws InferenceException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tensor, Float.valueOf(f), cls})) == null) {
            if (tensor != null) {
                checkInit(tensor.getDataType().value());
                long j = this.nativeHandle;
                if (j != 0) {
                    Object innerPredictForClassArray = innerPredictForClassArray(j, this.algorithm, f, tensor.getDataType().value(), tensor.getNativeHandle(), tensor.getDataType().value());
                    if (innerPredictForClassArray != null) {
                        if (innerPredictForClassArray.getClass().isArray()) {
                            int length = Array.getLength(innerPredictForClassArray);
                            Object[] objArr = (Object[]) Array.newInstance(cls, length);
                            if (length > 0) {
                                for (int i = 0; i < length; i++) {
                                    Object obj = Array.get(innerPredictForClassArray, i);
                                    if (obj.getClass() == cls) {
                                        objArr[i] = obj;
                                    }
                                }
                            }
                            return objArr;
                        }
                        throw new InferenceException(1);
                    }
                    throw new InferenceException(2);
                }
                throw new IllegalStateException("not init!!!");
            }
            throw new IllegalArgumentException("predict caller should pass valid input & output");
        }
        return (Object[]) invokeCommon.objValue;
    }

    public int predictForClassId(Tensor tensor, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, tensor, f)) == null) {
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
        return invokeLF.intValue;
    }

    public String predictForClassName(Tensor tensor, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048579, this, tensor, f)) == null) {
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
        return (String) invokeLF.objValue;
    }

    public Object[] predictForRegressorTargetArray(Tensor tensor, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048581, this, tensor, f)) == null) {
            if (tensor != null) {
                checkInit(tensor.getDataType().value());
                long j = this.nativeHandle;
                if (j != 0) {
                    return (Object[]) innerPredictForRegressorTargetArray(j, this.algorithm, f, tensor.getDataType().value(), tensor.getNativeHandle(), tensor.getDataType().value());
                }
                throw new IllegalStateException("not init!!!");
            }
            throw new IllegalArgumentException("predict caller should pass valid input & output");
        }
        return (Object[]) invokeLF.objValue;
    }

    public Object predictForRegressorTarget(Tensor tensor, float f, Class cls) throws InferenceException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{tensor, Float.valueOf(f), cls})) == null) {
            if (tensor != null) {
                checkInit(tensor.getDataType().value());
                long j = this.nativeHandle;
                if (j != 0) {
                    Object innerPredictForRegressorTarget = innerPredictForRegressorTarget(j, this.algorithm, f, tensor.getDataType().value(), tensor.getNativeHandle(), tensor.getDataType().value());
                    if (innerPredictForRegressorTarget != null) {
                        if (innerPredictForRegressorTarget.getClass().isArray() && Array.getLength(innerPredictForRegressorTarget) > 0) {
                            Object obj = Array.get(innerPredictForRegressorTarget, 0);
                            if (obj.getClass() == cls) {
                                return obj;
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
        return invokeCommon.objValue;
    }

    public boolean preloadModel(DataType dataType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dataType)) == null) {
            return checkInit(dataType.value());
        }
        return invokeL.booleanValue;
    }
}
