package com.baidu.searchbox.v8engine;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smallgame.sdk.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@NotProguard
/* loaded from: classes9.dex */
public class JsFunction extends JsReleaser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "JsFunction";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mReleaseAfterInvoke;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsFunction(long j2, long j3, long j4) {
        super(j2, j3, j4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r9;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mReleaseAfterInvoke = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freeIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && this.mReleaseAfterInvoke) {
            release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamBoolean(long j2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamBooleanArray(long j2, boolean[] zArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamByteArray(long j2, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamCharArray(long j2, char[] cArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamDouble(long j2, double d2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamDoubleArray(long j2, double[] dArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamFloatArray(long j2, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamInteger(long j2, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamIntegerArray(long j2, int[] iArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamLong(long j2, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamLongArray(long j2, long[] jArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamObject(long j2, Object obj, Object obj2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamShortArray(long j2, short[] sArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamString(long j2, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamStringArray(long j2, String[] strArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void invokeJsFunctionParamUndefined(long j2);

    private native boolean nativeStrictEquals(long j2, long j3);

    private void runOnJSThreadSafely(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, runnable) == null) {
            V8Engine v8Engine = V8Engine.getInstance(this.mOwnedNativeEngine);
            if (v8Engine == null) {
                Log.e(TAG, Log.getStackTraceString(new Exception("engine object is invalid.")));
            } else {
                v8Engine.runOnJSThread(runnable);
            }
        }
    }

    public void call() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            runOnJSThreadSafely(new Runnable(this) { // from class: com.baidu.searchbox.v8engine.JsFunction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamUndefined(j2);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj instanceof JsFunction) {
                return strictEquals((JsFunction) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setReleaseMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mReleaseAfterInvoke = z;
        }
    }

    public boolean strictEquals(JsFunction jsFunction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jsFunction)) == null) {
            long j2 = this.mNativeObject.get();
            long j3 = jsFunction.mNativeObject.get();
            if (this == jsFunction || j2 == j3) {
                return true;
            }
            if (j2 == 0 || j3 == 0) {
                return false;
            }
            V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
            return nativeStrictEquals(j2, j3);
        }
        return invokeL.booleanValue;
    }

    public void call(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            runOnJSThreadSafely(new Runnable(this, z) { // from class: com.baidu.searchbox.v8engine.JsFunction.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ boolean val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamBoolean(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            runOnJSThreadSafely(new Runnable(this, i2) { // from class: com.baidu.searchbox.v8engine.JsFunction.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ int val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamInteger(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            runOnJSThreadSafely(new Runnable(this, j2) { // from class: com.baidu.searchbox.v8engine.JsFunction.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ long val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j3 = this.this$0.mNativeObject.get();
                        if (j3 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamLong(j3, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) {
            runOnJSThreadSafely(new Runnable(this, d2) { // from class: com.baidu.searchbox.v8engine.JsFunction.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ double val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Double.valueOf(d2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = d2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamDouble(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            runOnJSThreadSafely(new Runnable(this, str) { // from class: com.baidu.searchbox.v8engine.JsFunction.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ String val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamString(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            call(obj, true);
        }
    }

    public void call(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, obj, z) == null) {
            call(null, obj, z);
        }
    }

    public void call(Object obj, Object obj2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, obj, obj2, z) == null) {
            runOnJSThreadSafely(new Runnable(this, obj, obj2, z) { // from class: com.baidu.searchbox.v8engine.JsFunction.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ boolean val$binding;
                public final /* synthetic */ Object val$receiver;
                public final /* synthetic */ Object val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, obj, obj2, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$receiver = obj;
                    this.val$result = obj2;
                    this.val$binding = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamObject(j2, this.val$receiver, this.val$result, this.val$binding);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bArr) == null) {
            runOnJSThreadSafely(new Runnable(this, bArr) { // from class: com.baidu.searchbox.v8engine.JsFunction.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ byte[] val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = bArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamByteArray(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, zArr) == null) {
            runOnJSThreadSafely(new Runnable(this, zArr) { // from class: com.baidu.searchbox.v8engine.JsFunction.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ boolean[] val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, zArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = zArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamBooleanArray(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iArr) == null) {
            runOnJSThreadSafely(new Runnable(this, iArr) { // from class: com.baidu.searchbox.v8engine.JsFunction.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ int[] val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = iArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamIntegerArray(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jArr) == null) {
            runOnJSThreadSafely(new Runnable(this, jArr) { // from class: com.baidu.searchbox.v8engine.JsFunction.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ long[] val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = jArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamLongArray(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fArr) == null) {
            runOnJSThreadSafely(new Runnable(this, fArr) { // from class: com.baidu.searchbox.v8engine.JsFunction.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ float[] val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, fArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = fArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            this.this$0.invokeJsFunctionParamFloatArray(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dArr) == null) {
            runOnJSThreadSafely(new Runnable(this, dArr) { // from class: com.baidu.searchbox.v8engine.JsFunction.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ double[] val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, dArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = dArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamDoubleArray(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sArr) == null) {
            runOnJSThreadSafely(new Runnable(this, sArr) { // from class: com.baidu.searchbox.v8engine.JsFunction.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ short[] val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = sArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamShortArray(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cArr) == null) {
            runOnJSThreadSafely(new Runnable(this, cArr) { // from class: com.baidu.searchbox.v8engine.JsFunction.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ char[] val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = cArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamCharArray(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }

    public void call(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, strArr) == null) {
            runOnJSThreadSafely(new Runnable(this, strArr) { // from class: com.baidu.searchbox.v8engine.JsFunction.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JsFunction this$0;
                public final /* synthetic */ String[] val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, strArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = strArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long j2 = this.this$0.mNativeObject.get();
                        if (j2 != 0) {
                            JsFunction jsFunction = this.this$0;
                            V8Engine.checkValid(jsFunction.mOwnedNativeEngine, jsFunction.mOwnedThreadId);
                            this.this$0.invokeJsFunctionParamStringArray(j2, this.val$result);
                            this.this$0.freeIfNeeded();
                        }
                    }
                }
            });
        }
    }
}
