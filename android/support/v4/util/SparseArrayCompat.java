package android.support.v4.util;
/* loaded from: classes.dex */
public class SparseArrayCompat<E> {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        this.mGarbage = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.mKeys = new int[idealIntArraySize];
        this.mValues = new Object[idealIntArraySize];
        this.mSize = 0;
    }

    public E get(int i) {
        return get(i, null);
    }

    public E get(int i, E e) {
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i);
        return (binarySearch < 0 || this.mValues[binarySearch] == DELETED) ? e : (E) this.mValues[binarySearch];
    }

    public void delete(int i) {
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i);
        if (binarySearch >= 0 && this.mValues[binarySearch] != DELETED) {
            this.mValues[binarySearch] = DELETED;
            this.mGarbage = true;
        }
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        if (this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.mSize, i + i2);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void put(int i, E e) {
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e;
            return;
        }
        int i2 = binarySearch ^ (-1);
        if (i2 < this.mSize && this.mValues[i2] == DELETED) {
            this.mKeys[i2] = i;
            this.mValues[i2] = e;
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc();
            i2 = binarySearch(this.mKeys, 0, this.mSize, i) ^ (-1);
        }
        if (this.mSize >= this.mKeys.length) {
            int idealIntArraySize = idealIntArraySize(this.mSize + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr = new Object[idealIntArraySize];
            System.arraycopy(this.mKeys, 0, iArr, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
            this.mKeys = iArr;
            this.mValues = objArr;
        }
        if (this.mSize - i2 != 0) {
            System.arraycopy(this.mKeys, i2, this.mKeys, i2 + 1, this.mSize - i2);
            System.arraycopy(this.mValues, i2, this.mValues, i2 + 1, this.mSize - i2);
        }
        this.mKeys[i2] = i;
        this.mValues[i2] = e;
        this.mSize++;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public int keyAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i];
    }

    public E valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i];
    }

    public void setValueAt(int i, E e) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i] = e;
    }

    public int indexOfKey(int i) {
        if (this.mGarbage) {
            gc();
        }
        return binarySearch(this.mKeys, 0, this.mSize, i);
    }

    public int indexOfValue(E e) {
        if (this.mGarbage) {
            gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void append(int i, E e) {
        if (this.mSize != 0 && i <= this.mKeys[this.mSize - 1]) {
            put(i, e);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc();
        }
        int i2 = this.mSize;
        if (i2 >= this.mKeys.length) {
            int idealIntArraySize = idealIntArraySize(i2 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr = new Object[idealIntArraySize];
            System.arraycopy(this.mKeys, 0, iArr, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
            this.mKeys = iArr;
            this.mValues = objArr;
        }
        this.mKeys[i2] = i;
        this.mValues[i2] = e;
        this.mSize = i2 + 1;
    }

    private static int binarySearch(int[] iArr, int i, int i2, int i3) {
        int i4 = i - 1;
        int i5 = i + i2;
        while (i5 - i4 > 1) {
            int i6 = (i5 + i4) / 2;
            if (iArr[i6] < i3) {
                i4 = i6;
            } else {
                i5 = i6;
            }
        }
        if (i5 == i + i2) {
            return (i + i2) ^ (-1);
        }
        return iArr[i5] != i3 ? i5 ^ (-1) : i5;
    }

    static int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    static int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }
}
