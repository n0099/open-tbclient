package android.support.v7.util;

import android.util.SparseArray;
import java.lang.reflect.Array;
/* loaded from: classes2.dex */
class TileList<T> {
    final int Fe;
    private final SparseArray<Tile<T>> Gx = new SparseArray<>(10);
    Tile<T> Gy;

    public TileList(int i) {
        this.Fe = i;
    }

    public T aK(int i) {
        if (this.Gy == null || !this.Gy.aN(i)) {
            int indexOfKey = this.Gx.indexOfKey(i - (i % this.Fe));
            if (indexOfKey < 0) {
                return null;
            }
            this.Gy = this.Gx.valueAt(indexOfKey);
        }
        return this.Gy.aO(i);
    }

    public int size() {
        return this.Gx.size();
    }

    public void clear() {
        this.Gx.clear();
    }

    public Tile<T> aL(int i) {
        return this.Gx.valueAt(i);
    }

    public Tile<T> b(Tile<T> tile) {
        int indexOfKey = this.Gx.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.Gx.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.Gx.valueAt(indexOfKey);
        this.Gx.setValueAt(indexOfKey, tile);
        if (this.Gy == valueAt) {
            this.Gy = tile;
            return valueAt;
        }
        return valueAt;
    }

    public Tile<T> aM(int i) {
        Tile<T> tile = this.Gx.get(i);
        if (this.Gy == tile) {
            this.Gy = null;
        }
        this.Gx.delete(i);
        return tile;
    }

    /* loaded from: classes2.dex */
    public static class Tile<T> {
        Tile<T> Gz;
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
