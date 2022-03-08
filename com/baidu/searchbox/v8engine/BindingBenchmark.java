package com.baidu.searchbox.v8engine;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.a;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BindingBenchmark {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final V8Engine mEngine;

    /* loaded from: classes4.dex */
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

        public JavaObject(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDouble = 123.456789d;
            this.mString = "123.456789ABCDEF";
            this.mObject = new Object();
            this.mJSEvent = new JSEvent(a.f32279g);
            this.mInt = i2;
        }

        @JavascriptInterface
        public void function(int i2, double d2, String str, Object obj, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), str, obj, jSEvent}) == null) {
            }
        }
    }

    public BindingBenchmark(V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Engine};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEngine = v8Engine;
    }

    @JavascriptInterface
    public long invokeAddJavascriptInterface(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            if (j2 > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                for (long j3 = 0; j3 < j2; j3++) {
                    this.mEngine.addJavascriptInterface(new JavaObject((int) j3), "jsi_" + j3);
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                for (long j4 = 0; j4 < j2; j4++) {
                    this.mEngine.removeJavascriptInterface("jsi_" + j4);
                }
                return currentTimeMillis2;
            }
            return 0L;
        }
        return invokeJ.longValue;
    }

    @JavascriptInterface
    public long invokeJsFunctionArrayBuffer(JsFunction jsFunction, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsFunction, j2)) == null) {
            if (jsFunction == null || j2 <= 0) {
                return 0L;
            }
            Object[] objArr = new Object[1000];
            int i2 = 0;
            while (i2 < 1000) {
                int i3 = i2 + 1;
                objArr[i2] = new JsArrayBuffer(new byte[i3], i3);
                i2 = i3;
            }
            jsFunction.setReleaseMode(false);
            long currentTimeMillis = System.currentTimeMillis();
            for (long j3 = 0; j3 < j2; j3++) {
                jsFunction.call(objArr[(int) (j2 % 1000)]);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            jsFunction.release();
            return currentTimeMillis2;
        }
        return invokeLJ.longValue;
    }

    @JavascriptInterface
    public long invokeJsFunctionInt(JsFunction jsFunction, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, jsFunction, j2)) == null) {
            if (jsFunction == null || j2 <= 0) {
                return 0L;
            }
            jsFunction.setReleaseMode(false);
            long currentTimeMillis = System.currentTimeMillis();
            for (long j3 = 0; j3 < j2; j3++) {
                jsFunction.call(j2);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            jsFunction.release();
            return currentTimeMillis2;
        }
        return invokeLJ.longValue;
    }

    @JavascriptInterface
    public long invokeJsFunctionObject(JsFunction jsFunction, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, jsFunction, j2)) == null) {
            if (jsFunction == null || j2 <= 0) {
                return 0L;
            }
            Object[] objArr = new Object[1000];
            for (int i2 = 0; i2 < 1000; i2++) {
                objArr[i2] = new JavaObject(i2);
            }
            jsFunction.setReleaseMode(false);
            long currentTimeMillis = System.currentTimeMillis();
            for (long j3 = 0; j3 < j2; j3++) {
                jsFunction.call(objArr[(int) (j2 % 1000)]);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            jsFunction.release();
            return currentTimeMillis2;
        }
        return invokeLJ.longValue;
    }

    @JavascriptInterface
    public long invokeJsFunctionString(JsFunction jsFunction, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, jsFunction, j2)) == null) {
            if (jsFunction == null || j2 <= 0) {
                return 0L;
            }
            String[] strArr = new String[1000];
            for (int i2 = 0; i2 < 1000; i2++) {
                strArr[i2] = i2 + "";
            }
            jsFunction.setReleaseMode(false);
            long currentTimeMillis = System.currentTimeMillis();
            for (long j3 = 0; j3 < j2; j3++) {
                jsFunction.call(strArr[(int) (j2 % 1000)]);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            jsFunction.release();
            return currentTimeMillis2;
        }
        return invokeLJ.longValue;
    }

    @JavascriptInterface
    public long invokeJsFunctionVoid(JsFunction jsFunction, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, jsFunction, j2)) == null) {
            if (jsFunction == null || j2 <= 0) {
                return 0L;
            }
            jsFunction.setReleaseMode(false);
            long currentTimeMillis = System.currentTimeMillis();
            for (long j3 = 0; j3 < j2; j3++) {
                jsFunction.call();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            jsFunction.release();
            return currentTimeMillis2;
        }
        return invokeLJ.longValue;
    }

    @JavascriptInterface
    public long invokeRemoveJavascriptInterface(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            if (j2 > 0) {
                for (long j3 = 0; j3 < j2; j3++) {
                    this.mEngine.addJavascriptInterface(new JavaObject((int) j3), "jsi_" + j3);
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (long j4 = 0; j4 < j2; j4++) {
                    this.mEngine.removeJavascriptInterface("jsi_" + j4);
                }
                return System.currentTimeMillis() - currentTimeMillis;
            }
            return 0L;
        }
        return invokeJ.longValue;
    }

    @JavascriptInterface
    public void testArrayBuffer(JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsArrayBuffer) == null) {
        }
    }

    @JavascriptInterface
    public void testDouble(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) {
        }
    }

    @JavascriptInterface
    public void testFunction(JsFunction jsFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsFunction) == null) {
            jsFunction.release();
        }
    }

    @JavascriptInterface
    public void testInt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
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
}
