package com.baidu.searchbox.v8engine;

import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
@NotProguard
/* loaded from: classes4.dex */
public class JsObject extends JsReleaser {
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
    private int mSize;

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

    static {
        $assertionsDisabled = !JsObject.class.desiredAssertionStatus();
    }

    public JsObject() {
        super(0L, 0L, 0L);
        this.mSize = 0;
        this.mSize = 0;
    }

    public JsObject(long j, long j2, long j3, int i) {
        super(j, j2, j3);
        this.mSize = 0;
        this.mSize = i;
    }

    public int length() {
        return this.mSize;
    }

    private boolean checkValid(int i) {
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        return this.mNativeObject.get() != 0 && i >= 0 && i < this.mSize;
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
            long j = this.mNativeObject.get();
            return j == 0 ? SessionMonitorEngine.PUBLIC_DATA_UNDIFNED : nativeGetPropertyName(j, i);
        }
        throw new AssertionError();
    }

    public int getPropertyIndex(String str) {
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0;
        }
        return nativeGetPropertyIndex(j, str);
    }

    public int getPropertyType(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return 0;
            }
            return nativePropertyType(j, i);
        }
        throw new AssertionError();
    }

    public int getType() {
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        long j = this.mNativeObject.get();
        if (j == 0) {
            return 0;
        }
        return nativeType(j);
    }

    public boolean toBoolean(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return false;
            }
            return nativeToBoolean(j, i);
        }
        throw new AssertionError();
    }

    public int toInteger(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return 0;
            }
            return nativeToInteger(j, i);
        }
        throw new AssertionError();
    }

    public long toLong(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return 0L;
            }
            return nativeToLong(j, i);
        }
        throw new AssertionError();
    }

    public JsSerializeValue toSerializeValue(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToSerializeValue(j, i);
        }
        throw new AssertionError();
    }

    public JsSerializeValue asSerializeValue() {
        long andSet = this.mNativeObject.getAndSet(0L);
        if (andSet == 0) {
            return null;
        }
        this.mSize = 0;
        return nativeAsSerializeValue(andSet);
    }

    public double toDouble(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return 0.0d;
            }
            return nativeToDouble(j, i);
        }
        throw new AssertionError();
    }

    public String toString(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            return j == 0 ? "null" : nativeToString(j, i);
        }
        throw new AssertionError();
    }

    public JsFunction toJsFunction(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToJsFunction(this.mOwnedNativeEngine, j, i);
        }
        throw new AssertionError();
    }

    public JsObject toJsObject(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToJsObject(j, i);
        }
        throw new AssertionError();
    }

    public JsArrayBuffer toJsArrayBuffer(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToJsArrayBuffer(j, i);
        }
        throw new AssertionError();
    }

    public boolean isBoolean(int i) {
        return getPropertyType(i) == 1;
    }

    public boolean isInteger(int i) {
        return getPropertyType(i) == 2;
    }

    public boolean isLong(int i) {
        return getPropertyType(i) == 3;
    }

    public boolean isDouble(int i) {
        return getPropertyType(i) == 5;
    }

    public boolean isString(int i) {
        return getPropertyType(i) == 7;
    }

    public boolean isJsFunction(int i) {
        return getPropertyType(i) == 8;
    }

    public boolean isJsObject(int i) {
        return getPropertyType(i) == 9;
    }

    public boolean isJsArrayBuffer(int i) {
        return getPropertyType(i) == 10;
    }

    public boolean isArray(int i) {
        return getPropertyType(i) == 6;
    }

    public String[] toStringArray(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToStringArray(j, i);
        }
        throw new AssertionError();
    }

    public double[] toDoubleArray(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToDoubleArray(j, i);
        }
        throw new AssertionError();
    }

    public int[] toIntegerArray(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToIntegerArray(j, i);
        }
        throw new AssertionError();
    }

    public JsObject[] toObjectArray(int i) {
        if ($assertionsDisabled || checkValid(i)) {
            long j = this.mNativeObject.get();
            if (j == 0) {
                return null;
            }
            return nativeToObjectArray(j, i);
        }
        throw new AssertionError();
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
}
