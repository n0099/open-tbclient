package com.baidu.searchbox.v8engine;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes2.dex */
public class JsObject extends JsReleaser {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int JARRAY = 6;
    public static final int JARRAYBUFFER = 10;
    public static final int JBOOLEAN = 1;
    public static final int JDOUBLE = 5;
    public static final int JFUNCTION = 8;
    public static final int JINTEGER = 2;
    public static final int JLONG = 3;
    public static final int JNONSUPPORT = 0;
    public static final int JNULL = 11;
    public static final int JOBJECT = 9;
    public static final int JSTRING = 7;
    public static final int JUNDEFINED = 12;
    public static final String TAG = "JsObject";
    public transient /* synthetic */ FieldHolder $fh;
    public int mSize;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1905084066, "Lcom/baidu/searchbox/v8engine/JsObject;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1905084066, "Lcom/baidu/searchbox/v8engine/JsObject;");
        }
    }

    private native JsSerializeValue nativeAsSerializeValue(long j);

    private native int nativeGetPropertyIndex(long j, String str);

    private native String nativeGetPropertyName(long j, int i);

    private native int nativePropertyType(long j, int i);

    private native boolean nativeStrictEquals(long j, long j2);

    private native boolean nativeToBoolean(long j, int i);

    private native double nativeToDouble(long j, int i);

    private native double[] nativeToDoubleArray(long j, int i);

    private native int nativeToInteger(long j, int i);

    private native int[] nativeToIntegerArray(long j, int i);

    private native JsArrayBuffer nativeToJsArrayBuffer(long j, int i);

    private native JsFunction nativeToJsFunction(long j, long j2, int i);

    private native JsObject nativeToJsObject(long j, int i);

    private native long nativeToLong(long j, int i);

    private native JsObject[] nativeToObjectArray(long j, int i);

    private native JsSerializeValue nativeToSerializeValue(long j, int i);

    private native String nativeToString(long j, int i);

    private native String[] nativeToStringArray(long j, int i);

    private native int nativeType(long j);

    public static String typeToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i)) == null) {
            switch (i) {
                case 0:
                    return "Jnonsupport";
                case 1:
                    return "Jboolean";
                case 2:
                    return "Jinteger";
                case 3:
                    return "Jlong";
                case 4:
                default:
                    return "Junknown";
                case 5:
                    return "Jdouble";
                case 6:
                    return "Jarray";
                case 7:
                    return "Jstring";
                case 8:
                    return "Jfunction";
                case 9:
                    return "Jobject";
                case 10:
                    return "Jarraybuffer";
            }
        }
        return (String) invokeI.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsObject() {
        super(0L, 0L, 0L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSize = 0;
        this.mSize = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsObject(long j, long j2, long j3, int i) {
        super(j, j2, j3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r9;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSize = 0;
        this.mSize = i;
    }

    private boolean checkValid(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
            if (this.mNativeObject.get() != 0 && i >= 0 && i < this.mSize) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public int getPropertyIndex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return 0;
            }
            return nativeGetPropertyIndex(j, str);
        }
        return invokeL.intValue;
    }

    public String getPropertyName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
            }
            return nativeGetPropertyName(j, i);
        }
        return (String) invokeI.objValue;
    }

    public int getPropertyType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return 0;
            }
            return nativePropertyType(j, i);
        }
        return invokeI.intValue;
    }

    public boolean isArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (getPropertyType(i) == 6) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isBoolean(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (getPropertyType(i) == 1) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isDouble(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (getPropertyType(i) == 5) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isInteger(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (getPropertyType(i) == 2) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isJsArrayBuffer(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (getPropertyType(i) == 10) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isJsFunction(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (getPropertyType(i) == 8) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isJsObject(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (getPropertyType(i) == 9) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isLong(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (getPropertyType(i) == 3) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (getPropertyType(i) == 7) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean toBoolean(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return false;
            }
            return nativeToBoolean(j, i);
        }
        return invokeI.booleanValue;
    }

    public double toDouble(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return 0.0d;
            }
            return nativeToDouble(j, i);
        }
        return invokeI.doubleValue;
    }

    public double[] toDoubleArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToDoubleArray(j, i);
        }
        return (double[]) invokeI.objValue;
    }

    public int toInteger(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return 0;
            }
            return nativeToInteger(j, i);
        }
        return invokeI.intValue;
    }

    public int[] toIntegerArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToIntegerArray(j, i);
        }
        return (int[]) invokeI.objValue;
    }

    public JsArrayBuffer toJsArrayBuffer(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToJsArrayBuffer(j, i);
        }
        return (JsArrayBuffer) invokeI.objValue;
    }

    public JsFunction toJsFunction(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToJsFunction(this.mOwnedNativeEngine, j, i);
        }
        return (JsFunction) invokeI.objValue;
    }

    public JsObject toJsObject(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToJsObject(j, i);
        }
        return (JsObject) invokeI.objValue;
    }

    public long toLong(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return 0L;
            }
            return nativeToLong(j, i);
        }
        return invokeI.longValue;
    }

    public JsObject[] toObjectArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToObjectArray(j, i);
        }
        return (JsObject[]) invokeI.objValue;
    }

    public JsSerializeValue toSerializeValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToSerializeValue(j, i);
        }
        return (JsSerializeValue) invokeI.objValue;
    }

    public String toString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return StringUtil.NULL_STRING;
            }
            return nativeToString(j, i);
        }
        return (String) invokeI.objValue;
    }

    public String[] toStringArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToStringArray(j, i);
        }
        return (String[]) invokeI.objValue;
    }

    public JsSerializeValue asSerializeValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long andSet = this.mNativeObject.getAndSet(0L);
            if (andSet == 0) {
                return null;
            }
            this.mSize = 0;
            return nativeAsSerializeValue(andSet);
        }
        return (JsSerializeValue) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
            long j = this.mNativeObject.get();
            if (j == 0) {
                return 0;
            }
            return nativeType(j);
        }
        return invokeV.intValue;
    }

    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mSize;
        }
        return invokeV.intValue;
    }

    public boolean strictEquals(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jsObject)) == null) {
            if (this.mNativeObject.get() != 0 && jsObject != null) {
                if (this != jsObject && this.mNativeObject.get() != jsObject.mNativeObject.get()) {
                    V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
                    return nativeStrictEquals(this.mNativeObject.get(), jsObject.mNativeObject.get());
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
