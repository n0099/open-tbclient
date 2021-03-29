package com.baidu.searchbox.v8engine;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
@NotProguard
/* loaded from: classes2.dex */
public class JsObject extends JsReleaser {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
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
    public int mSize;

    public JsObject() {
        super(0L, 0L, 0L);
        this.mSize = 0;
        this.mSize = 0;
    }

    private boolean checkValid(int i) {
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        return this.mNativeObject.get() != 0 && i >= 0 && i < this.mSize;
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

    public JsSerializeValue asSerializeValue() {
        long andSet = this.mNativeObject.getAndSet(0L);
        if (andSet == 0) {
            return null;
        }
        this.mSize = 0;
        return nativeAsSerializeValue(andSet);
    }

    public int getPropertyIndex(String str) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0;
        }
        return nativeGetPropertyIndex(j, str);
    }

    public String getPropertyName(int i) {
        long j = this.mNativeObject.get();
        return j == 0 ? SessionMonitorEngine.PUBLIC_DATA_UNDIFNED : nativeGetPropertyName(j, i);
    }

    public int getPropertyType(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0;
        }
        return nativePropertyType(j, i);
    }

    public int getType() {
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0;
        }
        return nativeType(j);
    }

    public boolean isArray(int i) {
        return getPropertyType(i) == 6;
    }

    public boolean isBoolean(int i) {
        return getPropertyType(i) == 1;
    }

    public boolean isDouble(int i) {
        return getPropertyType(i) == 5;
    }

    public boolean isInteger(int i) {
        return getPropertyType(i) == 2;
    }

    public boolean isJsArrayBuffer(int i) {
        return getPropertyType(i) == 10;
    }

    public boolean isJsFunction(int i) {
        return getPropertyType(i) == 8;
    }

    public boolean isJsObject(int i) {
        return getPropertyType(i) == 9;
    }

    public boolean isLong(int i) {
        return getPropertyType(i) == 3;
    }

    public boolean isString(int i) {
        return getPropertyType(i) == 7;
    }

    public int length() {
        return this.mSize;
    }

    public boolean strictEquals(JsObject jsObject) {
        if (this.mNativeObject.get() == 0 || jsObject == null) {
            return false;
        }
        if (this == jsObject || this.mNativeObject.get() == jsObject.mNativeObject.get()) {
            return true;
        }
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        return nativeStrictEquals(this.mNativeObject.get(), jsObject.mNativeObject.get());
    }

    public boolean toBoolean(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return false;
        }
        return nativeToBoolean(j, i);
    }

    public double toDouble(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0.0d;
        }
        return nativeToDouble(j, i);
    }

    public double[] toDoubleArray(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToDoubleArray(j, i);
    }

    public int toInteger(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0;
        }
        return nativeToInteger(j, i);
    }

    public int[] toIntegerArray(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToIntegerArray(j, i);
    }

    public JsArrayBuffer toJsArrayBuffer(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToJsArrayBuffer(j, i);
    }

    public JsFunction toJsFunction(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToJsFunction(this.mOwnedNativeEngine, j, i);
    }

    public JsObject toJsObject(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToJsObject(j, i);
    }

    public long toLong(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0L;
        }
        return nativeToLong(j, i);
    }

    public JsObject[] toObjectArray(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToObjectArray(j, i);
    }

    public JsSerializeValue toSerializeValue(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToSerializeValue(j, i);
    }

    public String toString(int i) {
        long j = this.mNativeObject.get();
        return j == 0 ? StringUtil.NULL_STRING : nativeToString(j, i);
    }

    public String[] toStringArray(int i) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToStringArray(j, i);
    }

    public JsObject(long j, long j2, long j3, int i) {
        super(j, j2, j3);
        this.mSize = 0;
        this.mSize = i;
    }
}
