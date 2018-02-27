package android.support.v7.util;

import android.util.SparseArray;
import java.lang.reflect.Array;
/* loaded from: classes2.dex */
class TileList<T> {
    final int EZ;
    private final SparseArray<Tile<T>> Gs = new SparseArray<>(10);
    Tile<T> Gt;

    public TileList(int i) {
        this.EZ = i;
    }

    public T aK(int i) {
        if (this.Gt == null || !this.Gt.aN(i)) {
            int indexOfKey = this.Gs.indexOfKey(i - (i % this.EZ));
            if (indexOfKey < 0) {
                return null;
            }
            this.Gt = this.Gs.valueAt(indexOfKey);
        }
        return this.Gt.aO(i);
    }

    public int size() {
        return this.Gs.size();
    }

    public void clear() {
        this.Gs.clear();
    }

    public Tile<T> aL(int i) {
        return this.Gs.valueAt(i);
    }

    public Tile<T> b(Tile<T> tile) {
        int indexOfKey = this.Gs.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.Gs.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.Gs.valueAt(indexOfKey);
        this.Gs.setValueAt(indexOfKey, tile);
        if (this.Gt == valueAt) {
            this.Gt = tile;
            return valueAt;
        }
        return valueAt;
    }

    public Tile<T> aM(int i) {
        Tile<T> tile = this.Gs.get(i);
        if (this.Gt == tile) {
            this.Gt = null;
        }
        this.Gs.delete(i);
        return tile;
    }

    /* loaded from: classes2.dex */
    public static class Tile<T> {
        Tile<T> Gu;
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
