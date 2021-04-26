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

    private boolean checkValid(int i2) {
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        return this.mNativeObject.get() != 0 && i2 >= 0 && i2 < this.mSize;
    }

    private native JsSerializeValue nativeAsSerializeValue(long j);

    private native int nativeGetPropertyIndex(long j, String str);

    private native String nativeGetPropertyName(long j, int i2);

    private native int nativePropertyType(long j, int i2);

    private native boolean nativeStrictEquals(long j, long j2);

    private native boolean nativeToBoolean(long j, int i2);

    private native double nativeToDouble(long j, int i2);

    private native double[] nativeToDoubleArray(long j, int i2);

    private native int nativeToInteger(long j, int i2);

    private native int[] nativeToIntegerArray(long j, int i2);

    private native JsArrayBuffer nativeToJsArrayBuffer(long j, int i2);

    private native JsFunction nativeToJsFunction(long j, long j2, int i2);

    private native JsObject nativeToJsObject(long j, int i2);

    private native long nativeToLong(long j, int i2);

    private native JsObject[] nativeToObjectArray(long j, int i2);

    private native JsSerializeValue nativeToSerializeValue(long j, int i2);

    private native String nativeToString(long j, int i2);

    private native String[] nativeToStringArray(long j, int i2);

    private native int nativeType(long j);

    public static String typeToString(int i2) {
        switch (i2) {
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

    public String getPropertyName(int i2) {
        long j = this.mNativeObject.get();
        return j == 0 ? SessionMonitorEngine.PUBLIC_DATA_UNDIFNED : nativeGetPropertyName(j, i2);
    }

    public int getPropertyType(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0;
        }
        return nativePropertyType(j, i2);
    }

    public int getType() {
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0;
        }
        return nativeType(j);
    }

    public boolean isArray(int i2) {
        return getPropertyType(i2) == 6;
    }

    public boolean isBoolean(int i2) {
        return getPropertyType(i2) == 1;
    }

    public boolean isDouble(int i2) {
        return getPropertyType(i2) == 5;
    }

    public boolean isInteger(int i2) {
        return getPropertyType(i2) == 2;
    }

    public boolean isJsArrayBuffer(int i2) {
        return getPropertyType(i2) == 10;
    }

    public boolean isJsFunction(int i2) {
        return getPropertyType(i2) == 8;
    }

    public boolean isJsObject(int i2) {
        return getPropertyType(i2) == 9;
    }

    public boolean isLong(int i2) {
        return getPropertyType(i2) == 3;
    }

    public boolean isString(int i2) {
        return getPropertyType(i2) == 7;
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

    public boolean toBoolean(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return false;
        }
        return nativeToBoolean(j, i2);
    }

    public double toDouble(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0.0d;
        }
        return nativeToDouble(j, i2);
    }

    public double[] toDoubleArray(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToDoubleArray(j, i2);
    }

    public int toInteger(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0;
        }
        return nativeToInteger(j, i2);
    }

    public int[] toIntegerArray(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToIntegerArray(j, i2);
    }

    public JsArrayBuffer toJsArrayBuffer(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToJsArrayBuffer(j, i2);
    }

    public JsFunction toJsFunction(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToJsFunction(this.mOwnedNativeEngine, j, i2);
    }

    public JsObject toJsObject(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToJsObject(j, i2);
    }

    public long toLong(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0L;
        }
        return nativeToLong(j, i2);
    }

    public JsObject[] toObjectArray(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToObjectArray(j, i2);
    }

    public JsSerializeValue toSerializeValue(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToSerializeValue(j, i2);
    }

    public String toString(int i2) {
        long j = this.mNativeObject.get();
        return j == 0 ? StringUtil.NULL_STRING : nativeToString(j, i2);
    }

    public String[] toStringArray(int i2) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return null;
        }
        return nativeToStringArray(j, i2);
    }

    public JsObject(long j, long j2, long j3, int i2) {
        super(j, j2, j3);
        this.mSize = 0;
        this.mSize = i2;
    }
}
