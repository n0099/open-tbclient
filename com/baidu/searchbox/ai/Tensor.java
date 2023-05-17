package com.baidu.searchbox.ai;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;
/* loaded from: classes3.dex */
public final class Tensor implements AutoCloseable {
    public DataType datatype;
    public long nativeHandle;
    public long[] shapeCopy = null;

    public static native ByteBuffer buffer(long j, int i);

    public static native long createNaTensor(int i, long[] jArr);

    public static native long createNaTensorAndSetValue(int i, long[] jArr, Object obj);

    public static native void deleteNaTensor(long j, int i);

    public static native long readArray(long j, int i, Object obj);

    static {
        Common.getSDKVersion();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        long j = this.nativeHandle;
        if (j != 0) {
            deleteNaTensor(j, this.datatype.value());
            this.nativeHandle = 0L;
        }
    }

    public DataType getDataType() {
        return this.datatype;
    }

    public long getNativeHandle() {
        return this.nativeHandle;
    }

    public int getNumDimens() {
        return this.shapeCopy.length;
    }

    public int getNumElements() {
        return numElements(this.shapeCopy);
    }

    public long[] shape() {
        return this.shapeCopy;
    }

    public static void assertArgIsArray(Object obj) {
        if (obj.getClass().isArray()) {
            return;
        }
        throw new IllegalArgumentException("object must is array");
    }

    public static Tensor createInstance(Object obj) {
        assertArgIsArray(obj);
        DataType dataTypeOf = DataType.dataTypeOf(obj);
        Tensor tensor = new Tensor();
        tensor.datatype = dataTypeOf;
        long[] jArr = new long[numDimensions(obj, dataTypeOf)];
        tensor.shapeCopy = jArr;
        fillShape(obj, 0, jArr);
        tensor.nativeHandle = createNaTensorAndSetValue(dataTypeOf.value(), flatShape(tensor.shapeCopy), flatObject(obj, tensor.shapeCopy, dataTypeOf));
        return tensor;
    }

    public static long[] flatShape(long[] jArr) {
        long[] jArr2 = new long[1];
        long j = 1;
        for (long j2 : jArr) {
            j *= j2;
        }
        jArr2[0] = j;
        return jArr2;
    }

    private ByteBuffer getBuffer(int i) {
        return buffer(this.nativeHandle, i).order(ByteOrder.nativeOrder());
    }

    public static int numArrayDimensions(Object obj) {
        Class<?> cls = obj.getClass();
        int i = 0;
        while (cls.isArray()) {
            cls = cls.getComponentType();
            i++;
        }
        return i;
    }

    public static int numElements(long[] jArr) {
        int i = 1;
        for (long j : jArr) {
            i *= (int) j;
        }
        return i;
    }

    public <T> T read(T t) {
        assertArgIsArray(t);
        readArray(this.nativeHandle, this.datatype.value(), t);
        return t;
    }

    public static Tensor createInstance(long[] jArr, ByteBuffer byteBuffer) {
        Tensor innerCreateInstance = innerCreateInstance(DataType.UINT8, jArr);
        byteBuffer.rewind();
        innerCreateInstance.getBuffer(DataType.UINT8.value()).put(byteBuffer);
        return innerCreateInstance;
    }

    public static Tensor innerCreateInstance(DataType dataType, long[] jArr) {
        Tensor tensor = new Tensor();
        tensor.datatype = dataType;
        tensor.shapeCopy = Arrays.copyOf(jArr, jArr.length);
        tensor.nativeHandle = createNaTensor(dataType.value(), flatShape(jArr));
        return tensor;
    }

    public static int numDimensions(Object obj, DataType dataType) {
        int numArrayDimensions = numArrayDimensions(obj);
        if (dataType == DataType.STRING && numArrayDimensions > 0) {
            return numArrayDimensions - 1;
        }
        return numArrayDimensions;
    }

    public static Tensor createInstance(long[] jArr, DoubleBuffer doubleBuffer) {
        Tensor innerCreateInstance = innerCreateInstance(DataType.DOUBLE, jArr);
        doubleBuffer.rewind();
        innerCreateInstance.getBuffer(DataType.DOUBLE.value()).asDoubleBuffer().put(doubleBuffer);
        return innerCreateInstance;
    }

    public static Tensor createInstance(long[] jArr, FloatBuffer floatBuffer) {
        Tensor innerCreateInstance = innerCreateInstance(DataType.FLOAT, jArr);
        floatBuffer.rewind();
        innerCreateInstance.getBuffer(DataType.FLOAT.value()).asFloatBuffer().put(floatBuffer);
        return innerCreateInstance;
    }

    public static Tensor createInstance(long[] jArr, IntBuffer intBuffer) {
        Tensor innerCreateInstance = innerCreateInstance(DataType.INT32, jArr);
        intBuffer.rewind();
        innerCreateInstance.getBuffer(DataType.INT32.value()).asIntBuffer().put(intBuffer);
        return innerCreateInstance;
    }

    public static Tensor createInstance(long[] jArr, LongBuffer longBuffer) {
        Tensor innerCreateInstance = innerCreateInstance(DataType.INT64, jArr);
        longBuffer.rewind();
        innerCreateInstance.getBuffer(DataType.INT64.value()).asLongBuffer().put(longBuffer);
        return innerCreateInstance;
    }

    public static void fillShape(Object obj, int i, long[] jArr) {
        if (jArr != null && i != jArr.length) {
            int length = Array.getLength(obj);
            if (length != 0) {
                if (jArr[i] == 0) {
                    jArr[i] = length;
                } else if (jArr[i] != length) {
                    throw new IllegalArgumentException(String.format("mismatched lengths (%d and %d) in dimension %d", Long.valueOf(jArr[i]), Integer.valueOf(length), Integer.valueOf(i)));
                }
                for (int i2 = 0; i2 < length; i2++) {
                    fillShape(Array.get(obj, i2), i + 1, jArr);
                }
                return;
            }
            throw new IllegalArgumentException("cannot create Tensors with a 0 dimension");
        }
    }

    public static Object flatObject(Object obj, long[] jArr, DataType dataType) {
        return Util.flat(obj, jArr, dataType);
    }
}
