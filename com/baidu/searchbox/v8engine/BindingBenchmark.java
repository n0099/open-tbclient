package com.baidu.searchbox.v8engine;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BindingBenchmark {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final V8Engine mEngine;

    @JavascriptInterface
    public void testArrayBuffer(JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsArrayBuffer) == null) {
        }
    }

    @JavascriptInterface
    public void testDouble(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d)}) == null) {
        }
    }

    @JavascriptInterface
    public void testInt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    @JavascriptInterface
    public void testString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    @JavascriptInterface
    public void testVoid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class JavaObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @V8JavascriptField
        public double mDouble;
        @V8JavascriptField
        public int mInt;
        @V8JavascriptField
        public JSEvent mJSEvent;
        @V8JavascriptField
        public Object mObject;
        @V8JavascriptField
        public String mString;

        @JavascriptInterface
        public void function(int i, double d, String str, Object obj, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), str, obj, jSEvent}) == null) {
            }
        }

        public JavaObject(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDouble = 123.456789d;
            this.mString = "123.456789ABCDEF";
            this.mObject = new Object();
            this.mJSEvent = new JSEvent("test");
            this.mInt = i;
        }
    }

    public BindingBenchmark(V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Engine};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEngine = v8Engine;
    }

    @JavascriptInterface
    public void testFunction(JsFunction jsFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsFunction) == null) {
            jsFunction.release();
        }
    }

    @JavascriptInterface
    public void testObject(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) {
            jsObject.release();
        }
    }

    @JavascriptInterface
    public long invokeAddJavascriptInterface(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j <= 0) {
                return 0L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (long j2 = 0; j2 < j; j2++) {
                this.mEngine.addJavascriptInterface(new JavaObject((int) j2), "jsi_" + j2);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            for (long j3 = 0; j3 < j; j3++) {
                this.mEngine.removeJavascriptInterface("jsi_" + j3);
            }
            return currentTimeMillis2;
        }
        return invokeJ.longValue;
    }

    @JavascriptInterface
    public long invokeRemoveJavascriptInterface(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            if (j <= 0) {
                return 0L;
            }
            for (long j2 = 0; j2 < j; j2++) {
                this.mEngine.addJavascriptInterface(new JavaObject((int) j2), "jsi_" + j2);
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (long j3 = 0; j3 < j; j3++) {
                this.mEngine.removeJavascriptInterface("jsi_" + j3);
            }
            return System.currentTimeMillis() - currentTimeMillis;
        }
        return invokeJ.longValue;
    }

    @JavascriptInterface
    public long invokeJsFunctionArrayBuffer(JsFunction jsFunction, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsFunction, j)) == null) {
            if (jsFunction == null || j <= 0) {
                return 0L;
            }
            Object[] objArr = new Object[1000];
            int i = 0;
            while (i < 1000) {
                int i2 = i + 1;
                objArr[i] = new JsArrayBuffer(new byte[i2], i2);
                i = i2;
            }
            jsFunction.setReleaseMode(false);
            long currentTimeMillis = System.currentTimeMillis();
            for (long j2 = 0; j2 < j; j2++) {
                jsFunction.call(objArr[(int) (j % 1000)]);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            jsFunction.release();
            return currentTimeMillis2;
        }
        return invokeLJ.longValue;
    }

    @JavascriptInterface
    public long invokeJsFunctionObject(JsFunction jsFunction, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, jsFunction, j)) == null) {
            if (jsFunction == null || j <= 0) {
                return 0L;
            }
            Object[] objArr = new Object[1000];
            for (int i = 0; i < 1000; i++) {
                objArr[i] = new JavaObject(i);
            }
            jsFunction.setReleaseMode(false);
            long currentTimeMillis = System.currentTimeMillis();
            for (long j2 = 0; j2 < j; j2++) {
                jsFunction.call(objArr[(int) (j % 1000)]);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            jsFunction.release();
            return currentTimeMillis2;
        }
        return invokeLJ.longValue;
    }

    @JavascriptInterface
    public long invokeJsFunctionString(JsFunction jsFunction, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, jsFunction, j)) == null) {
            if (jsFunction == null || j <= 0) {
                return 0L;
            }
            String[] strArr = new String[1000];
            for (int i = 0; i < 1000; i++) {
                strArr[i] = i + "";
            }
            jsFunction.setReleaseMode(false);
            long currentTimeMillis = System.currentTimeMillis();
            for (long j2 = 0; j2 < j; j2++) {
                jsFunction.call(strArr[(int) (j % 1000)]);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            jsFunction.release();
            return currentTimeMillis2;
        }
        return invokeLJ.longValue;
    }

    @JavascriptInterface
    public long invokeJsFunctionInt(JsFunction jsFunction, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, jsFunction, j)) == null) {
            if (jsFunction == null || j <= 0) {
                return 0L;
            }
            jsFunction.setReleaseMode(false);
            long currentTimeMillis = System.currentTimeMillis();
            for (long j2 = 0; j2 < j; j2++) {
                jsFunction.call(j);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            jsFunction.release();
            return currentTimeMillis2;
        }
        return invokeLJ.longValue;
    }

    @JavascriptInterface
    public long invokeJsFunctionVoid(JsFunction jsFunction, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, jsFunction, j)) == null) {
            if (jsFunction == null || j <= 0) {
                return 0L;
            }
            jsFunction.setReleaseMode(false);
            long currentTimeMillis = System.currentTimeMillis();
            for (long j2 = 0; j2 < j; j2++) {
                jsFunction.call();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            jsFunction.release();
            return currentTimeMillis2;
        }
        return invokeLJ.longValue;
    }
}
