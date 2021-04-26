package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    public static final Object DELETED = new Object();
    public boolean mGarbage;
    public long[] mKeys;
    public int mSize;
    public Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    private void gc() {
        int i2 = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != DELETED) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.mGarbage = false;
        this.mSize = i3;
    }

    public void append(long j, E e2) {
        int i2 = this.mSize;
        if (i2 != 0 && j <= this.mKeys[i2 - 1]) {
            put(j, e2);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc();
        }
        int i3 = this.mSize;
        if (i3 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i3 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = jArr;
            this.mValues = objArr;
        }
        this.mKeys[i3] = j;
        this.mValues[i3] = e2;
        this.mSize = i3 + 1;
    }

    public void clear() {
        int i2 = this.mSize;
        Object[] objArr = this.mValues;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public boolean containsKey(long j) {
        return indexOfKey(j) >= 0;
    }

    public boolean containsValue(E e2) {
        return indexOfValue(e2) >= 0;
    }

    @Deprecated
    public void delete(long j) {
        remove(j);
    }

    @Nullable
    public E get(long j) {
        return get(j, null);
    }

    public int indexOfKey(long j) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
    }

    public int indexOfValue(E e2) {
        if (this.mGarbage) {
            gc();
        }
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (this.mValues[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i2) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i2];
    }

    public void put(long j, E e2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e2;
            return;
        }
        int i2 = ~binarySearch;
        if (i2 < this.mSize) {
            Object[] objArr = this.mValues;
            if (objArr[i2] == DELETED) {
                this.mKeys[i2] = j;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc();
            i2 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        }
        int i3 = this.mSize;
        if (i3 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i3 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr2 = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            long[] jArr3 = this.mKeys;
            int i5 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i5, i4 - i2);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i2, objArr4, i5, this.mSize - i2);
        }
        this.mKeys[i2] = j;
        this.mValues[i2] = e2;
        this.mSize++;
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            put(longSparseArray.keyAt(i2), longSparseArray.valueAt(i2));
        }
    }

    @Nullable
    public E putIfAbsent(long j, E e2) {
        E e3 = get(j);
        if (e3 == null) {
            put(j, e2);
        }
        return e3;
    }

    public void remove(long j) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            Object obj = objArr[binarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[binarySearch] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public void removeAt(int i2) {
        Object[] objArr = this.mValues;
        Object obj = objArr[i2];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.mGarbage = true;
        }
    }

    @Nullable
    public E replace(long j, E e2) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey >= 0) {
            Object[] objArr = this.mValues;
            E e3 = (E) objArr[indexOfKey];
            objArr[indexOfKey] = e2;
            return e3;
        }
        return null;
    }

    public void setValueAt(int i2, E e2) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i2] = e2;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return StringUtil.EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (i2 > 0) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(keyAt(i2));
            sb.append(a.f1873h);
            E valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i2) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i2];
    }

    public LongSparseArray(int i2) {
        this.mGarbage = false;
        if (i2 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
            return;
        }
        int idealLongArraySize = ContainerHelpers.idealLongArraySize(i2);
        this.mKeys = new long[idealLongArraySize];
        this.mValues = new Object[idealLongArraySize];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public LongSparseArray<E> m0clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E get(long j, E e2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            if (objArr[binarySearch] != DELETED) {
                return (E) objArr[binarySearch];
            }
        }
        return e2;
    }

    public boolean replace(long j, E e2, E e3) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey >= 0) {
            Object obj = this.mValues[indexOfKey];
            if (obj == e2 || (e2 != null && e2.equals(obj))) {
                this.mValues[indexOfKey] = e3;
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean remove(long j, Object obj) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey >= 0) {
            E valueAt = valueAt(indexOfKey);
            if (obj == valueAt || (obj != null && obj.equals(valueAt))) {
                removeAt(indexOfKey);
                return true;
            }
            return false;
        }
        return false;
    }
}
