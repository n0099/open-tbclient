package android.support.v7.util;

import android.support.v7.util.ThreadUtil;
import android.support.v7.util.TileList;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
/* loaded from: classes2.dex */
public class AsyncListUtil<T> {
    final Class<T> Fd;
    final int Fe;
    final DataCallback<T> Ff;
    final ViewCallback Fg;
    final TileList<T> Fh;
    final ThreadUtil.MainThreadCallback<T> Fi;
    final ThreadUtil.BackgroundCallback<T> Fj;
    boolean Fn;
    final int[] Fk = new int[2];
    final int[] Fl = new int[2];
    final int[] Fm = new int[2];
    private int Fo = 0;
    int mItemCount = 0;
    int Fp = 0;
    int Fq = this.Fp;
    final SparseIntArray Fr = new SparseIntArray();
    private final ThreadUtil.MainThreadCallback<T> Fs = new ThreadUtil.MainThreadCallback<T>() { // from class: android.support.v7.util.AsyncListUtil.1
        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            if (aF(i)) {
                AsyncListUtil.this.mItemCount = i2;
                AsyncListUtil.this.Fg.onDataRefresh();
                AsyncListUtil.this.Fp = AsyncListUtil.this.Fq;
                ey();
                AsyncListUtil.this.Fn = false;
                AsyncListUtil.this.ex();
            }
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            if (!aF(i)) {
                AsyncListUtil.this.Fj.recycleTile(tile);
                return;
            }
            TileList.Tile<T> b = AsyncListUtil.this.Fh.b(tile);
            if (b != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + b.mStartPosition);
                AsyncListUtil.this.Fj.recycleTile(b);
            }
            int i2 = tile.mItemCount + tile.mStartPosition;
            int i3 = 0;
            while (i3 < AsyncListUtil.this.Fr.size()) {
                int keyAt = AsyncListUtil.this.Fr.keyAt(i3);
                if (tile.mStartPosition <= keyAt && keyAt < i2) {
                    AsyncListUtil.this.Fr.removeAt(i3);
                    AsyncListUtil.this.Fg.onItemLoaded(keyAt);
                } else {
                    i3++;
                }
            }
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            if (aF(i)) {
                TileList.Tile<T> aM = AsyncListUtil.this.Fh.aM(i2);
                if (aM == null) {
                    Log.e("AsyncListUtil", "tile not found @" + i2);
                } else {
                    AsyncListUtil.this.Fj.recycleTile(aM);
                }
            }
        }

        private void ey() {
            for (int i = 0; i < AsyncListUtil.this.Fh.size(); i++) {
                AsyncListUtil.this.Fj.recycleTile(AsyncListUtil.this.Fh.aL(i));
            }
            AsyncListUtil.this.Fh.clear();
        }

        private boolean aF(int i) {
            return i == AsyncListUtil.this.Fq;
        }
    };
    private final ThreadUtil.BackgroundCallback<T> Ft = new ThreadUtil.BackgroundCallback<T>() { // from class: android.support.v7.util.AsyncListUtil.2
        private TileList.Tile<T> Fv;
        final SparseBooleanArray Fw = new SparseBooleanArray();
        private int Fx;
        private int Fy;
        private int Fz;
        private int mItemCount;

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            this.Fx = i;
            this.Fw.clear();
            this.mItemCount = AsyncListUtil.this.Ff.refreshData();
            AsyncListUtil.this.Fi.updateItemCount(this.Fx, this.mItemCount);
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i <= i2) {
                int aG = aG(i);
                int aG2 = aG(i2);
                this.Fy = aG(i3);
                this.Fz = aG(i4);
                if (i5 == 1) {
                    a(this.Fy, aG2, i5, true);
                    a(AsyncListUtil.this.Fe + aG2, this.Fz, i5, false);
                    return;
                }
                a(aG, this.Fz, i5, false);
                a(this.Fy, aG - AsyncListUtil.this.Fe, i5, true);
            }
        }

        private int aG(int i) {
            return i - (i % AsyncListUtil.this.Fe);
        }

        private void a(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.Fj.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.Fe;
            }
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            if (!aH(i)) {
                TileList.Tile<T> ez = ez();
                ez.mStartPosition = i;
                ez.mItemCount = Math.min(AsyncListUtil.this.Fe, this.mItemCount - ez.mStartPosition);
                AsyncListUtil.this.Ff.fillData(ez.mItems, ez.mStartPosition, ez.mItemCount);
                aJ(i2);
                a(ez);
            }
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.Ff.recycleData(tile.mItems, tile.mItemCount);
            tile.Gz = this.Fv;
            this.Fv = tile;
        }

        private TileList.Tile<T> ez() {
            if (this.Fv != null) {
                TileList.Tile<T> tile = this.Fv;
                this.Fv = this.Fv.Gz;
                return tile;
            }
            return new TileList.Tile<>(AsyncListUtil.this.Fd, AsyncListUtil.this.Fe);
        }

        private boolean aH(int i) {
            return this.Fw.get(i);
        }

        private void a(TileList.Tile<T> tile) {
            this.Fw.put(tile.mStartPosition, true);
            AsyncListUtil.this.Fi.addTile(this.Fx, tile);
        }

        private void aI(int i) {
            this.Fw.delete(i);
            AsyncListUtil.this.Fi.removeTile(this.Fx, i);
        }

        private void aJ(int i) {
            int maxCachedTiles = AsyncListUtil.this.Ff.getMaxCachedTiles();
            while (this.Fw.size() >= maxCachedTiles) {
                int keyAt = this.Fw.keyAt(0);
                int keyAt2 = this.Fw.keyAt(this.Fw.size() - 1);
                int i2 = this.Fy - keyAt;
                int i3 = keyAt2 - this.Fz;
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
        this.Fd = cls;
        this.Fe = i;
        this.Ff = dataCallback;
        this.Fg = viewCallback;
        this.Fh = new TileList<>(this.Fe);
        a aVar = new a();
        this.Fi = aVar.a(this.Fs);
        this.Fj = aVar.a(this.Ft);
        refresh();
    }

    private boolean ew() {
        return this.Fq != this.Fp;
    }

    public void onRangeChanged() {
        if (!ew()) {
            ex();
            this.Fn = true;
        }
    }

    public void refresh() {
        this.Fr.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.Fj;
        int i = this.Fq + 1;
        this.Fq = i;
        backgroundCallback.refresh(i);
    }

    public T getItem(int i) {
        if (i < 0 || i >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.mItemCount);
        }
        T aK = this.Fh.aK(i);
        if (aK == null && !ew()) {
            this.Fr.put(i, 0);
        }
        return aK;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    void ex() {
        this.Fg.getItemRangeInto(this.Fk);
        if (this.Fk[0] <= this.Fk[1] && this.Fk[0] >= 0 && this.Fk[1] < this.mItemCount) {
            if (!this.Fn) {
                this.Fo = 0;
            } else if (this.Fk[0] > this.Fl[1] || this.Fl[0] > this.Fk[1]) {
                this.Fo = 0;
            } else if (this.Fk[0] < this.Fl[0]) {
                this.Fo = 1;
            } else if (this.Fk[0] > this.Fl[0]) {
                this.Fo = 2;
            }
            this.Fl[0] = this.Fk[0];
            this.Fl[1] = this.Fk[1];
            this.Fg.extendRangeInto(this.Fk, this.Fm, this.Fo);
            this.Fm[0] = Math.min(this.Fk[0], Math.max(this.Fm[0], 0));
            this.Fm[1] = Math.max(this.Fk[1], Math.min(this.Fm[1], this.mItemCount - 1));
            this.Fj.updateRange(this.Fk[0], this.Fk[1], this.Fm[0], this.Fm[1], this.Fo);
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
