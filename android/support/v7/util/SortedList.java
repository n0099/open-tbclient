package android.support.v7.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class SortedList<T> {
    public static final int INVALID_POSITION = -1;
    private final Class<T> Fe;
    private T[] Gq;
    private int Gr;
    private int Gs;
    private int Gt;
    private Callback Gu;
    private BatchedCallback Gv;
    T[] mData;
    private int mSize;

    public SortedList(Class<T> cls, Callback<T> callback) {
        this(cls, callback, 10);
    }

    public SortedList(Class<T> cls, Callback<T> callback, int i) {
        this.Fe = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        this.Gu = callback;
        this.mSize = 0;
    }

    public int size() {
        return this.mSize;
    }

    public int add(T t) {
        eE();
        return b((SortedList<T>) t, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: android.support.v7.util.SortedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(T[] tArr, boolean z) {
        eE();
        if (tArr.length != 0) {
            if (z) {
                f(tArr);
                return;
            }
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.Fe, tArr.length);
            System.arraycopy(tArr, 0, objArr, 0, tArr.length);
            f(objArr);
        }
    }

    public void addAll(T... tArr) {
        addAll(tArr, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.support.v7.util.SortedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.Fe, collection.size())), true);
    }

    private void f(T[] tArr) {
        boolean z = !(this.Gu instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.Gq = this.mData;
        this.Gr = 0;
        this.Gs = this.mSize;
        Arrays.sort(tArr, this.Gu);
        int g = g(tArr);
        if (this.mSize == 0) {
            this.mData = tArr;
            this.mSize = g;
            this.Gt = g;
            this.Gu.onInserted(0, g);
        } else {
            b(tArr, g);
        }
        this.Gq = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    private int g(T[] tArr) {
        if (tArr.length == 0) {
            throw new IllegalArgumentException("Input array must be non-empty");
        }
        int i = 0;
        int i2 = 1;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T t = tArr[i3];
            int compare = this.Gu.compare(tArr[i], t);
            if (compare > 0) {
                throw new IllegalArgumentException("Input must be sorted in ascending order.");
            }
            if (compare == 0) {
                int a = a((SortedList<T>) t, (SortedList<T>[]) tArr, i, i2);
                if (a != -1) {
                    tArr[a] = t;
                } else {
                    if (i2 != i3) {
                        tArr[i2] = t;
                    }
                    i2++;
                }
            } else {
                if (i2 != i3) {
                    tArr[i2] = t;
                }
                i = i2;
                i2++;
            }
        }
        return i2;
    }

    private int a(T t, T[] tArr, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (this.Gu.areItemsTheSame(tArr[i3], t)) {
                return i3;
            }
        }
        return -1;
    }

    private void b(T[] tArr, int i) {
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.Fe, this.mSize + i + 10));
        this.Gt = 0;
        int i2 = 0;
        while (true) {
            if (this.Gr < this.Gs || i2 < i) {
                if (this.Gr == this.Gs) {
                    int i3 = i - i2;
                    System.arraycopy(tArr, i2, this.mData, this.Gt, i3);
                    this.Gt += i3;
                    this.mSize += i3;
                    this.Gu.onInserted(this.Gt - i3, i3);
                    return;
                } else if (i2 == i) {
                    int i4 = this.Gs - this.Gr;
                    System.arraycopy(this.Gq, this.Gr, this.mData, this.Gt, i4);
                    this.Gt = i4 + this.Gt;
                    return;
                } else {
                    T t = this.Gq[this.Gr];
                    T t2 = tArr[i2];
                    int compare = this.Gu.compare(t, t2);
                    if (compare > 0) {
                        T[] tArr2 = this.mData;
                        int i5 = this.Gt;
                        this.Gt = i5 + 1;
                        tArr2[i5] = t2;
                        this.mSize++;
                        i2++;
                        this.Gu.onInserted(this.Gt - 1, 1);
                    } else if (compare == 0 && this.Gu.areItemsTheSame(t, t2)) {
                        T[] tArr3 = this.mData;
                        int i6 = this.Gt;
                        this.Gt = i6 + 1;
                        tArr3[i6] = t2;
                        i2++;
                        this.Gr++;
                        if (!this.Gu.areContentsTheSame(t, t2)) {
                            this.Gu.onChanged(this.Gt - 1, 1);
                        }
                    } else {
                        T[] tArr4 = this.mData;
                        int i7 = this.Gt;
                        this.Gt = i7 + 1;
                        tArr4[i7] = t;
                        this.Gr++;
                    }
                }
            } else {
                return;
            }
        }
    }

    private void eE() {
        if (this.Gq != null) {
            throw new IllegalStateException("Cannot call this method from within addAll");
        }
    }

    public void beginBatchedUpdates() {
        eE();
        if (!(this.Gu instanceof BatchedCallback)) {
            if (this.Gv == null) {
                this.Gv = new BatchedCallback(this.Gu);
            }
            this.Gu = this.Gv;
        }
    }

    public void endBatchedUpdates() {
        eE();
        if (this.Gu instanceof BatchedCallback) {
            ((BatchedCallback) this.Gu).dispatchLastEvent();
        }
        if (this.Gu == this.Gv) {
            this.Gu = this.Gv.Gw;
        }
    }

    private int b(T t, boolean z) {
        int i = 0;
        int a = a(t, this.mData, 0, this.mSize, 1);
        if (a != -1) {
            if (a < this.mSize) {
                T t2 = this.mData[a];
                if (this.Gu.areItemsTheSame(t2, t)) {
                    if (this.Gu.areContentsTheSame(t2, t)) {
                        this.mData[a] = t;
                        return a;
                    }
                    this.mData[a] = t;
                    this.Gu.onChanged(a, 1);
                    return a;
                }
            }
            i = a;
        }
        c(i, (int) t);
        if (z) {
            this.Gu.onInserted(i, 1);
        }
        return i;
    }

    public boolean remove(T t) {
        eE();
        return c((SortedList<T>) t, true);
    }

    public T removeItemAt(int i) {
        eE();
        T t = get(i);
        h(i, true);
        return t;
    }

    private boolean c(T t, boolean z) {
        int a = a(t, this.mData, 0, this.mSize, 2);
        if (a == -1) {
            return false;
        }
        h(a, z);
        return true;
    }

    private void h(int i, boolean z) {
        System.arraycopy(this.mData, i + 1, this.mData, i, (this.mSize - i) - 1);
        this.mSize--;
        this.mData[this.mSize] = null;
        if (z) {
            this.Gu.onRemoved(i, 1);
        }
    }

    public void updateItemAt(int i, T t) {
        eE();
        T t2 = get(i);
        boolean z = t2 == t || !this.Gu.areContentsTheSame(t2, t);
        if (t2 != t && this.Gu.compare(t2, t) == 0) {
            this.mData[i] = t;
            if (z) {
                this.Gu.onChanged(i, 1);
                return;
            }
            return;
        }
        if (z) {
            this.Gu.onChanged(i, 1);
        }
        h(i, false);
        int b = b((SortedList<T>) t, false);
        if (i != b) {
            this.Gu.onMoved(i, b);
        }
    }

    public void recalculatePositionOfItemAt(int i) {
        eE();
        T t = get(i);
        h(i, false);
        int b = b((SortedList<T>) t, false);
        if (i != b) {
            this.Gu.onMoved(i, b);
        }
    }

    public T get(int i) throws IndexOutOfBoundsException {
        if (i >= this.mSize || i < 0) {
            throw new IndexOutOfBoundsException("Asked to get item at " + i + " but size is " + this.mSize);
        }
        return (this.Gq == null || i < this.Gt) ? this.mData[i] : this.Gq[(i - this.Gt) + this.Gr];
    }

    public int indexOf(T t) {
        if (this.Gq != null) {
            int a = a(t, this.mData, 0, this.Gt, 4);
            if (a == -1) {
                int a2 = a(t, this.Gq, this.Gr, this.Gs, 4);
                if (a2 != -1) {
                    return (a2 - this.Gr) + this.Gt;
                }
                return -1;
            }
            return a;
        }
        return a(t, this.mData, 0, this.mSize, 4);
    }

    private int a(T t, T[] tArr, int i, int i2, int i3) {
        int i4;
        int i5 = i2;
        int i6 = i;
        while (i6 < i5) {
            int i7 = (i6 + i5) / 2;
            T t2 = tArr[i7];
            int compare = this.Gu.compare(t2, t);
            if (compare < 0) {
                int i8 = i5;
                i4 = i7 + 1;
                i7 = i8;
            } else if (compare == 0) {
                if (!this.Gu.areItemsTheSame(t2, t)) {
                    int a = a((SortedList<T>) t, i7, i6, i5);
                    return (i3 == 1 && a == -1) ? i7 : a;
                }
                return i7;
            } else {
                i4 = i6;
            }
            i6 = i4;
            i5 = i7;
        }
        if (i3 != 1) {
            i6 = -1;
        }
        return i6;
    }

    private int a(T t, int i, int i2, int i3) {
        for (int i4 = i - 1; i4 >= i2; i4--) {
            T t2 = this.mData[i4];
            if (this.Gu.compare(t2, t) != 0) {
                break;
            } else if (this.Gu.areItemsTheSame(t2, t)) {
                return i4;
            }
        }
        for (int i5 = i + 1; i5 < i3; i5++) {
            T t3 = this.mData[i5];
            if (this.Gu.compare(t3, t) != 0) {
                break;
            } else if (this.Gu.areItemsTheSame(t3, t)) {
                return i5;
            }
        }
        return -1;
    }

    private void c(int i, T t) {
        if (i > this.mSize) {
            throw new IndexOutOfBoundsException("cannot add item to " + i + " because size is " + this.mSize);
        }
        if (this.mSize == this.mData.length) {
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) this.Fe, this.mData.length + 10));
            System.arraycopy(this.mData, 0, tArr, 0, i);
            tArr[i] = t;
            System.arraycopy(this.mData, i, tArr, i + 1, this.mSize - i);
            this.mData = tArr;
        } else {
            System.arraycopy(this.mData, i, this.mData, i + 1, this.mSize - i);
            this.mData[i] = t;
        }
        this.mSize++;
    }

    public void clear() {
        eE();
        if (this.mSize != 0) {
            int i = this.mSize;
            Arrays.fill(this.mData, 0, i, (Object) null);
            this.mSize = 0;
            this.Gu.onRemoved(0, i);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Callback<T2> implements ListUpdateCallback, Comparator<T2> {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        public abstract int compare(T2 t2, T2 t22);

        public abstract void onChanged(int i, int i2);

        @Override // android.support.v7.util.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            onChanged(i, i2);
        }
    }

    /* loaded from: classes2.dex */
    public static class BatchedCallback<T2> extends Callback<T2> {
        final Callback<T2> Gw;
        private final BatchingListUpdateCallback Gx;

        public BatchedCallback(Callback<T2> callback) {
            this.Gw = callback;
            this.Gx = new BatchingListUpdateCallback(this.Gw);
        }

        @Override // android.support.v7.util.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            return this.Gw.compare(t2, t22);
        }

        @Override // android.support.v7.util.ListUpdateCallback
        public void onInserted(int i, int i2) {
            this.Gx.onInserted(i, i2);
        }

        @Override // android.support.v7.util.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            this.Gx.onRemoved(i, i2);
        }

        @Override // android.support.v7.util.ListUpdateCallback
        public void onMoved(int i, int i2) {
            this.Gx.onMoved(i, i2);
        }

        @Override // android.support.v7.util.SortedList.Callback
        public void onChanged(int i, int i2) {
            this.Gx.onChanged(i, i2, null);
        }

        @Override // android.support.v7.util.SortedList.Callback
        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.Gw.areContentsTheSame(t2, t22);
        }

        @Override // android.support.v7.util.SortedList.Callback
        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.Gw.areItemsTheSame(t2, t22);
        }

        public void dispatchLastEvent() {
            this.Gx.dispatchLastEvent();
        }
    }
}
