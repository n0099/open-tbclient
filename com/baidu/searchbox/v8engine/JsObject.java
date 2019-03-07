package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes2.dex */
public class JsObject {
    static final /* synthetic */ boolean $assertionsDisabled;
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
    static final String TAG = "JsObject";
    private long mNativeObject;
    private final long mOwnedNativeEngine;
    private final long mOwnedThreadId;
    private int mSize;

    private native JsSerializeValue nativeAsSerializeValue(long j);

    private native int nativeGetPropertyIndex(long j, String str);

    private native String nativeGetPropertyName(long j, int i);

    private native int nativePropertyType(long j, int i);

    private native void nativeRelease(long j);

    private native boolean nativeStrictEquals(long j, long j2);

    private native boolean nativeToBoolean(long j, int i);

    private native double nativeToDouble(long j, int i);

    private native double[] nativeToDoubleArray(long j, int i);

    private native int nativeToInteger(long j, int i);

    private native int[] nativeToIntegerArray(long j, int i);

    private native JsArrayBuffer nativeToJsArrayBuffer(long j, int i);

    private native JsFunction nativeToJsFunction(long j, int i);

    private native JsObject nativeToJsObject(long j, int i);

    private native long nativeToLong(long j, int i);

    private native JsObject[] nativeToObjectArray(long j, int i);

    private native JsSerializeValue nativeToSerializeValue(long j, int i);

    private native String nativeToString(long j, int i);

    private native String[] nativeToStringArray(long j, int i);

    static {
        $assertionsDisabled = !JsObject.class.desiredAssertionStatus();
    }

    public JsObject() {
        this.mSize = 0;
        this.mNativeObject = 0L;
        this.mSize = 0;
        this.mNativeObject = 0L;
        this.mOwnedThreadId = 0L;
        this.mOwnedNativeEngine = 0L;
    }

    public JsObject(long j, long j2, long j3, int i) {
        this.mSize = 0;
        this.mNativeObject = 0L;
        this.mSize = i;
        this.mNativeObject = j;
        this.mOwnedThreadId = j3;
        this.mOwnedNativeEngine = j2;
    }

    long nativePtr() {
        return this.mNativeObject;
    }

    public void release() {
        if (this.mNativeObject != 0) {
            V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
            nativeRelease(this.mNativeObject);
            this.mNativeObject = 0L;
            this.mSize = 0;
        }
    }

    public int length() {
        return this.mSize;
    }

    private boolean checkValid(int i) {
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        return this.mNativeObject != 0 && i >= 0 && i < this.mSize;
    }

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

    public String getPropertyName(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeGetPropertyName(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public int getPropertyIndex(String str) {
        return nativeGetPropertyIndex(this.mNativeObject, str);
    }

    public int getPropertyType(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativePropertyType(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public boolean toBoolean(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToBoolean(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public int toInteger(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToInteger(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public long toLong(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToLong(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public JsSerializeValue toSerializeValue(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToSerializeValue(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public JsSerializeValue asSerializeValue() {
        long j = this.mNativeObject;
        this.mSize = 0;
        this.mNativeObject = 0L;
        return nativeAsSerializeValue(j);
    }

    public double toDouble(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToDouble(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public String toString(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToString(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public JsFunction toJsFunction(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToJsFunction(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public JsObject toJsObject(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToJsObject(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public JsArrayBuffer toJsArrayBuffer(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToJsArrayBuffer(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public boolean isBoolean(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return getPropertyType(i) == 1;
        }
        throw new AssertionError();
    }

    public boolean isInteger(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return getPropertyType(i) == 2;
        }
        throw new AssertionError();
    }

    public boolean isLong(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return getPropertyType(i) == 3;
        }
        throw new AssertionError();
    }

    public boolean isDouble(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return getPropertyType(i) == 5;
        }
        throw new AssertionError();
    }

    public boolean isString(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return getPropertyType(i) == 7;
        }
        throw new AssertionError();
    }

    public boolean isJsFunction(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return getPropertyType(i) == 8;
        }
        throw new AssertionError();
    }

    public boolean isJsObject(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return getPropertyType(i) == 9;
        }
        throw new AssertionError();
    }

    public boolean isJsArrayBuffer(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return getPropertyType(i) == 10;
        }
        throw new AssertionError();
    }

    public boolean isArray(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return getPropertyType(i) == 6;
        }
        throw new AssertionError();
    }

    public String[] toStringArray(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToStringArray(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public double[] toDoubleArray(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToDoubleArray(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public int[] toIntegerArray(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToIntegerArray(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public JsObject[] toObjectArray(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            return nativeToObjectArray(this.mNativeObject, i);
        }
        throw new AssertionError();
    }

    public boolean strictEquals(JsObject jsObject) {
        if (this.mNativeObject == 0 || jsObject == null) {
            return false;
        }
        if (this == jsObject || this.mNativeObject == jsObject.mNativeObject) {
            return true;
        }
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        return nativeStrictEquals(this.mNativeObject, jsObject.mNativeObject);
    }
}
