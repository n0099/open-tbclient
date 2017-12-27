package android.support.v7.util;

import android.util.SparseArray;
import java.lang.reflect.Array;
/* loaded from: classes2.dex */
class TileList<T> {
    final int Ff;
    private final SparseArray<Tile<T>> Gy = new SparseArray<>(10);
    Tile<T> Gz;

    public TileList(int i) {
        this.Ff = i;
    }

    public T aK(int i) {
        if (this.Gz == null || !this.Gz.aN(i)) {
            int indexOfKey = this.Gy.indexOfKey(i - (i % this.Ff));
            if (indexOfKey < 0) {
                return null;
            }
            this.Gz = this.Gy.valueAt(indexOfKey);
        }
        return this.Gz.aO(i);
    }

    public int size() {
        return this.Gy.size();
    }

    public void clear() {
        this.Gy.clear();
    }

    public Tile<T> aL(int i) {
        return this.Gy.valueAt(i);
    }

    public Tile<T> b(Tile<T> tile) {
        int indexOfKey = this.Gy.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.Gy.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.Gy.valueAt(indexOfKey);
        this.Gy.setValueAt(indexOfKey, tile);
        if (this.Gz == valueAt) {
            this.Gz = tile;
            return valueAt;
        }
        return valueAt;
    }

    public Tile<T> aM(int i) {
        Tile<T> tile = this.Gy.get(i);
        if (this.Gz == tile) {
            this.Gz = null;
        }
        this.Gy.delete(i);
        return tile;
    }

    /* loaded from: classes2.dex */
    public static class Tile<T> {
        Tile<T> GA;
        public int mItemCount;
        public final T[] mItems;
        public int mStartPosition;

        public Tile(Class<T> cls, int i) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        }

        boolean aN(int i) {
            return this.mStartPosition <= i && i < this.mStartPosition + this.mItemCount;
        }

        T aO(int i) {
            return this.mItems[i - this.mStartPosition];
        }
    }
}
