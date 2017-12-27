package android.support.v7.util;

import android.support.v7.util.ThreadUtil;
import android.support.v7.util.TileList;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
/* loaded from: classes2.dex */
public class AsyncListUtil<T> {
    final Class<T> Fe;
    final int Ff;
    final DataCallback<T> Fg;
    final ViewCallback Fh;
    final TileList<T> Fi;
    final ThreadUtil.MainThreadCallback<T> Fj;
    final ThreadUtil.BackgroundCallback<T> Fk;
    boolean Fo;
    final int[] Fl = new int[2];
    final int[] Fm = new int[2];
    final int[] Fn = new int[2];
    private int Fp = 0;
    int mItemCount = 0;
    int Fq = 0;
    int Fr = this.Fq;
    final SparseIntArray Fs = new SparseIntArray();
    private final ThreadUtil.MainThreadCallback<T> Ft = new ThreadUtil.MainThreadCallback<T>() { // from class: android.support.v7.util.AsyncListUtil.1
        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            if (aF(i)) {
                AsyncListUtil.this.mItemCount = i2;
                AsyncListUtil.this.Fh.onDataRefresh();
                AsyncListUtil.this.Fq = AsyncListUtil.this.Fr;
                ey();
                AsyncListUtil.this.Fo = false;
                AsyncListUtil.this.ex();
            }
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            if (!aF(i)) {
                AsyncListUtil.this.Fk.recycleTile(tile);
                return;
            }
            TileList.Tile<T> b = AsyncListUtil.this.Fi.b(tile);
            if (b != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + b.mStartPosition);
                AsyncListUtil.this.Fk.recycleTile(b);
            }
            int i2 = tile.mItemCount + tile.mStartPosition;
            int i3 = 0;
            while (i3 < AsyncListUtil.this.Fs.size()) {
                int keyAt = AsyncListUtil.this.Fs.keyAt(i3);
                if (tile.mStartPosition <= keyAt && keyAt < i2) {
                    AsyncListUtil.this.Fs.removeAt(i3);
                    AsyncListUtil.this.Fh.onItemLoaded(keyAt);
                } else {
                    i3++;
                }
            }
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            if (aF(i)) {
                TileList.Tile<T> aM = AsyncListUtil.this.Fi.aM(i2);
                if (aM == null) {
                    Log.e("AsyncListUtil", "tile not found @" + i2);
                } else {
                    AsyncListUtil.this.Fk.recycleTile(aM);
                }
            }
        }

        private void ey() {
            for (int i = 0; i < AsyncListUtil.this.Fi.size(); i++) {
                AsyncListUtil.this.Fk.recycleTile(AsyncListUtil.this.Fi.aL(i));
            }
            AsyncListUtil.this.Fi.clear();
        }

        private boolean aF(int i) {
            return i == AsyncListUtil.this.Fr;
        }
    };
    private final ThreadUtil.BackgroundCallback<T> Fu = new ThreadUtil.BackgroundCallback<T>() { // from class: android.support.v7.util.AsyncListUtil.2
        private int FA;
        private TileList.Tile<T> Fw;
        final SparseBooleanArray Fx = new SparseBooleanArray();
        private int Fy;
        private int Fz;
        private int mItemCount;

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            this.Fy = i;
            this.Fx.clear();
            this.mItemCount = AsyncListUtil.this.Fg.refreshData();
            AsyncListUtil.this.Fj.updateItemCount(this.Fy, this.mItemCount);
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i <= i2) {
                int aG = aG(i);
                int aG2 = aG(i2);
                this.Fz = aG(i3);
                this.FA = aG(i4);
                if (i5 == 1) {
                    a(this.Fz, aG2, i5, true);
                    a(AsyncListUtil.this.Ff + aG2, this.FA, i5, false);
                    return;
                }
                a(aG, this.FA, i5, false);
                a(this.Fz, aG - AsyncListUtil.this.Ff, i5, true);
            }
        }

        private int aG(int i) {
            return i - (i % AsyncListUtil.this.Ff);
        }

        private void a(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.Fk.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.Ff;
            }
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            if (!aH(i)) {
                TileList.Tile<T> ez = ez();
                ez.mStartPosition = i;
                ez.mItemCount = Math.min(AsyncListUtil.this.Ff, this.mItemCount - ez.mStartPosition);
                AsyncListUtil.this.Fg.fillData(ez.mItems, ez.mStartPosition, ez.mItemCount);
                aJ(i2);
                a(ez);
            }
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.Fg.recycleData(tile.mItems, tile.mItemCount);
            tile.GA = this.Fw;
            this.Fw = tile;
        }

        private TileList.Tile<T> ez() {
            if (this.Fw != null) {
                TileList.Tile<T> tile = this.Fw;
                this.Fw = this.Fw.GA;
                return tile;
            }
            return new TileList.Tile<>(AsyncListUtil.this.Fe, AsyncListUtil.this.Ff);
        }

        private boolean aH(int i) {
            return this.Fx.get(i);
        }

        private void a(TileList.Tile<T> tile) {
            this.Fx.put(tile.mStartPosition, true);
            AsyncListUtil.this.Fj.addTile(this.Fy, tile);
        }

        private void aI(int i) {
            this.Fx.delete(i);
            AsyncListUtil.this.Fj.removeTile(this.Fy, i);
        }

        private void aJ(int i) {
            int maxCachedTiles = AsyncListUtil.this.Fg.getMaxCachedTiles();
            while (this.Fx.size() >= maxCachedTiles) {
                int keyAt = this.Fx.keyAt(0);
                int keyAt2 = this.Fx.keyAt(this.Fx.size() - 1);
                int i2 = this.Fz - keyAt;
                int i3 = keyAt2 - this.FA;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    aI(keyAt);
                } else if (i3 <= 0) {
                    return;
                } else {
                    if (i2 < i3 || i == 1) {
                        aI(keyAt2);
                    } else {
                        return;
                    }
                }
            }
        }
    };

    public AsyncListUtil(Class<T> cls, int i, DataCallback<T> dataCallback, ViewCallback viewCallback) {
        this.Fe = cls;
        this.Ff = i;
        this.Fg = dataCallback;
        this.Fh = viewCallback;
        this.Fi = new TileList<>(this.Ff);
        a aVar = new a();
        this.Fj = aVar.a(this.Ft);
        this.Fk = aVar.a(this.Fu);
        refresh();
    }

    private boolean ew() {
        return this.Fr != this.Fq;
    }

    public void onRangeChanged() {
        if (!ew()) {
            ex();
            this.Fo = true;
        }
    }

    public void refresh() {
        this.Fs.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.Fk;
        int i = this.Fr + 1;
        this.Fr = i;
        backgroundCallback.refresh(i);
    }

    public T getItem(int i) {
        if (i < 0 || i >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.mItemCount);
        }
        T aK = this.Fi.aK(i);
        if (aK == null && !ew()) {
            this.Fs.put(i, 0);
        }
        return aK;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    void ex() {
        this.Fh.getItemRangeInto(this.Fl);
        if (this.Fl[0] <= this.Fl[1] && this.Fl[0] >= 0 && this.Fl[1] < this.mItemCount) {
            if (!this.Fo) {
                this.Fp = 0;
            } else if (this.Fl[0] > this.Fm[1] || this.Fm[0] > this.Fl[1]) {
                this.Fp = 0;
            } else if (this.Fl[0] < this.Fm[0]) {
                this.Fp = 1;
            } else if (this.Fl[0] > this.Fm[0]) {
                this.Fp = 2;
            }
            this.Fm[0] = this.Fl[0];
            this.Fm[1] = this.Fl[1];
            this.Fh.extendRangeInto(this.Fl, this.Fn, this.Fp);
            this.Fn[0] = Math.min(this.Fl[0], Math.max(this.Fn[0], 0));
            this.Fn[1] = Math.max(this.Fl[1], Math.min(this.Fn[1], this.mItemCount - 1));
            this.Fk.updateRange(this.Fl[0], this.Fl[1], this.Fn[0], this.Fn[1], this.Fp);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class DataCallback<T> {
        public abstract void fillData(T[] tArr, int i, int i2);

        public abstract int refreshData();

        public void recycleData(T[] tArr, int i) {
        }

        public int getMaxCachedTiles() {
            return 10;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        public abstract void getItemRangeInto(int[] iArr);

        public abstract void onDataRefresh();

        public abstract void onItemLoaded(int i);

        public void extendRangeInto(int[] iArr, int[] iArr2, int i) {
            int i2 = (iArr[1] - iArr[0]) + 1;
            int i3 = i2 / 2;
            iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
            int i4 = iArr[1];
            if (i != 2) {
                i2 = i3;
            }
            iArr2[1] = i4 + i2;
        }
    }
}
