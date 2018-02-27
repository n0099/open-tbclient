package android.support.v7.util;

import android.support.v7.util.ThreadUtil;
import android.support.v7.util.TileList;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
/* loaded from: classes2.dex */
public class AsyncListUtil<T> {
    final Class<T> EY;
    final int EZ;
    final DataCallback<T> Fa;
    final ViewCallback Fb;
    final TileList<T> Fc;
    final ThreadUtil.MainThreadCallback<T> Fd;
    final ThreadUtil.BackgroundCallback<T> Fe;
    boolean Fi;
    final int[] Ff = new int[2];
    final int[] Fg = new int[2];
    final int[] Fh = new int[2];
    private int Fj = 0;
    int mItemCount = 0;
    int Fk = 0;
    int Fl = this.Fk;
    final SparseIntArray Fm = new SparseIntArray();
    private final ThreadUtil.MainThreadCallback<T> Fn = new ThreadUtil.MainThreadCallback<T>() { // from class: android.support.v7.util.AsyncListUtil.1
        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            if (aF(i)) {
                AsyncListUtil.this.mItemCount = i2;
                AsyncListUtil.this.Fb.onDataRefresh();
                AsyncListUtil.this.Fk = AsyncListUtil.this.Fl;
                ey();
                AsyncListUtil.this.Fi = false;
                AsyncListUtil.this.ex();
            }
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            if (!aF(i)) {
                AsyncListUtil.this.Fe.recycleTile(tile);
                return;
            }
            TileList.Tile<T> b = AsyncListUtil.this.Fc.b(tile);
            if (b != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + b.mStartPosition);
                AsyncListUtil.this.Fe.recycleTile(b);
            }
            int i2 = tile.mItemCount + tile.mStartPosition;
            int i3 = 0;
            while (i3 < AsyncListUtil.this.Fm.size()) {
                int keyAt = AsyncListUtil.this.Fm.keyAt(i3);
                if (tile.mStartPosition <= keyAt && keyAt < i2) {
                    AsyncListUtil.this.Fm.removeAt(i3);
                    AsyncListUtil.this.Fb.onItemLoaded(keyAt);
                } else {
                    i3++;
                }
            }
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            if (aF(i)) {
                TileList.Tile<T> aM = AsyncListUtil.this.Fc.aM(i2);
                if (aM == null) {
                    Log.e("AsyncListUtil", "tile not found @" + i2);
                } else {
                    AsyncListUtil.this.Fe.recycleTile(aM);
                }
            }
        }

        private void ey() {
            for (int i = 0; i < AsyncListUtil.this.Fc.size(); i++) {
                AsyncListUtil.this.Fe.recycleTile(AsyncListUtil.this.Fc.aL(i));
            }
            AsyncListUtil.this.Fc.clear();
        }

        private boolean aF(int i) {
            return i == AsyncListUtil.this.Fl;
        }
    };
    private final ThreadUtil.BackgroundCallback<T> Fo = new ThreadUtil.BackgroundCallback<T>() { // from class: android.support.v7.util.AsyncListUtil.2
        private TileList.Tile<T> Fq;
        final SparseBooleanArray Fr = new SparseBooleanArray();
        private int Fs;
        private int Ft;
        private int Fu;
        private int mItemCount;

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            this.Fs = i;
            this.Fr.clear();
            this.mItemCount = AsyncListUtil.this.Fa.refreshData();
            AsyncListUtil.this.Fd.updateItemCount(this.Fs, this.mItemCount);
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i <= i2) {
                int aG = aG(i);
                int aG2 = aG(i2);
                this.Ft = aG(i3);
                this.Fu = aG(i4);
                if (i5 == 1) {
                    a(this.Ft, aG2, i5, true);
                    a(AsyncListUtil.this.EZ + aG2, this.Fu, i5, false);
                    return;
                }
                a(aG, this.Fu, i5, false);
                a(this.Ft, aG - AsyncListUtil.this.EZ, i5, true);
            }
        }

        private int aG(int i) {
            return i - (i % AsyncListUtil.this.EZ);
        }

        private void a(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.Fe.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.EZ;
            }
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            if (!aH(i)) {
                TileList.Tile<T> ez = ez();
                ez.mStartPosition = i;
                ez.mItemCount = Math.min(AsyncListUtil.this.EZ, this.mItemCount - ez.mStartPosition);
                AsyncListUtil.this.Fa.fillData(ez.mItems, ez.mStartPosition, ez.mItemCount);
                aJ(i2);
                a(ez);
            }
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.Fa.recycleData(tile.mItems, tile.mItemCount);
            tile.Gu = this.Fq;
            this.Fq = tile;
        }

        private TileList.Tile<T> ez() {
            if (this.Fq != null) {
                TileList.Tile<T> tile = this.Fq;
                this.Fq = this.Fq.Gu;
                return tile;
            }
            return new TileList.Tile<>(AsyncListUtil.this.EY, AsyncListUtil.this.EZ);
        }

        private boolean aH(int i) {
            return this.Fr.get(i);
        }

        private void a(TileList.Tile<T> tile) {
            this.Fr.put(tile.mStartPosition, true);
            AsyncListUtil.this.Fd.addTile(this.Fs, tile);
        }

        private void aI(int i) {
            this.Fr.delete(i);
            AsyncListUtil.this.Fd.removeTile(this.Fs, i);
        }

        private void aJ(int i) {
            int maxCachedTiles = AsyncListUtil.this.Fa.getMaxCachedTiles();
            while (this.Fr.size() >= maxCachedTiles) {
                int keyAt = this.Fr.keyAt(0);
                int keyAt2 = this.Fr.keyAt(this.Fr.size() - 1);
                int i2 = this.Ft - keyAt;
                int i3 = keyAt2 - this.Fu;
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
        this.EY = cls;
        this.EZ = i;
        this.Fa = dataCallback;
        this.Fb = viewCallback;
        this.Fc = new TileList<>(this.EZ);
        a aVar = new a();
        this.Fd = aVar.a(this.Fn);
        this.Fe = aVar.a(this.Fo);
        refresh();
    }

    private boolean ew() {
        return this.Fl != this.Fk;
    }

    public void onRangeChanged() {
        if (!ew()) {
            ex();
            this.Fi = true;
        }
    }

    public void refresh() {
        this.Fm.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.Fe;
        int i = this.Fl + 1;
        this.Fl = i;
        backgroundCallback.refresh(i);
    }

    public T getItem(int i) {
        if (i < 0 || i >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.mItemCount);
        }
        T aK = this.Fc.aK(i);
        if (aK == null && !ew()) {
            this.Fm.put(i, 0);
        }
        return aK;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    void ex() {
        this.Fb.getItemRangeInto(this.Ff);
        if (this.Ff[0] <= this.Ff[1] && this.Ff[0] >= 0 && this.Ff[1] < this.mItemCount) {
            if (!this.Fi) {
                this.Fj = 0;
            } else if (this.Ff[0] > this.Fg[1] || this.Fg[0] > this.Ff[1]) {
                this.Fj = 0;
            } else if (this.Ff[0] < this.Fg[0]) {
                this.Fj = 1;
            } else if (this.Ff[0] > this.Fg[0]) {
                this.Fj = 2;
            }
            this.Fg[0] = this.Ff[0];
            this.Fg[1] = this.Ff[1];
            this.Fb.extendRangeInto(this.Ff, this.Fh, this.Fj);
            this.Fh[0] = Math.min(this.Ff[0], Math.max(this.Fh[0], 0));
            this.Fh[1] = Math.max(this.Ff[1], Math.min(this.Fh[1], this.mItemCount - 1));
            this.Fe.updateRange(this.Ff[0], this.Ff[1], this.Fh[0], this.Fh[1], this.Fj);
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
