package com.baidu.searchbox.v8engine;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class BindingBenchmark {
    public final V8Engine mEngine;

    @JavascriptInterface
    public void testArrayBuffer(JsArrayBuffer jsArrayBuffer) {
    }

    @JavascriptInterface
    public void testDouble(double d) {
    }

    @JavascriptInterface
    public void testInt(int i) {
    }

    @JavascriptInterface
    public void testString(String str) {
    }

    @JavascriptInterface
    public void testVoid() {
    }

    /* loaded from: classes3.dex */
    public static class JavaObject {
        @V8JavascriptField
        public int mInt;
        @V8JavascriptField
        public double mDouble = 123.456789d;
        @V8JavascriptField
        public String mString = "123.456789ABCDEF";
        @V8JavascriptField
        public Object mObject = new Object();
        @V8JavascriptField
        public JSEvent mJSEvent = new JSEvent(DebugActiveUploadResult.SOURCE);

        @JavascriptInterface
        public void function(int i, double d, String str, Object obj, JSEvent jSEvent) {
        }

        public JavaObject(int i) {
            this.mInt = i;
        }
    }

    public BindingBenchmark(V8Engine v8Engine) {
        this.mEngine = v8Engine;
    }

    @JavascriptInterface
    public void testFunction(JsFunction jsFunction) {
        jsFunction.release();
    }

    @JavascriptInterface
    public void testObject(JsObject jsObject) {
        jsObject.release();
    }

    @JavascriptInterface
    public long invokeAddJavascriptInterface(long j) {
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

    @JavascriptInterface
    public long invokeRemoveJavascriptInterface(long j) {
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

    @JavascriptInterface
    public long invokeJsFunctionArrayBuffer(JsFunction jsFunction, long j) {
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

    @JavascriptInterface
    public long invokeJsFunctionObject(JsFunction jsFunction, long j) {
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

    @JavascriptInterface
    public long invokeJsFunctionInt(JsFunction jsFunction, long j) {
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

    @JavascriptInterface
    public long invokeJsFunctionVoid(JsFunction jsFunction, long j) {
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

    @JavascriptInterface
    public long invokeJsFunctionString(JsFunction jsFunction, long j) {
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
}
