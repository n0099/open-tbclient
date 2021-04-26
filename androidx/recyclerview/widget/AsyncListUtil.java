package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
/* loaded from: classes.dex */
public class AsyncListUtil<T> {
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncListUtil";
    public boolean mAllowScrollHints;
    public final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    public final DataCallback<T> mDataCallback;
    public final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    public final Class<T> mTClass;
    public final TileList<T> mTileList;
    public final int mTileSize;
    public final ViewCallback mViewCallback;
    public final int[] mTmpRange = new int[2];
    public final int[] mPrevRange = new int[2];
    public final int[] mTmpRangeExtended = new int[2];
    public int mScrollHint = 0;
    public int mItemCount = 0;
    public int mDisplayedGeneration = 0;
    public int mRequestedGeneration = 0;
    public final SparseIntArray mMissingPositions = new SparseIntArray();
    public final ThreadUtil.MainThreadCallback<T> mMainThreadCallback = new ThreadUtil.MainThreadCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.1
        private boolean isRequestedGeneration(int i2) {
            return i2 == AsyncListUtil.this.mRequestedGeneration;
        }

        private void recycleAllTiles() {
            for (int i2 = 0; i2 < AsyncListUtil.this.mTileList.size(); i2++) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i2));
            }
            AsyncListUtil.this.mTileList.clear();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i2, TileList.Tile<T> tile) {
            if (!isRequestedGeneration(i2)) {
                AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                return;
            }
            TileList.Tile<T> addOrReplace = AsyncListUtil.this.mTileList.addOrReplace(tile);
            if (addOrReplace != null) {
                Log.e(AsyncListUtil.TAG, "duplicate tile @" + addOrReplace.mStartPosition);
                AsyncListUtil.this.mBackgroundProxy.recycleTile(addOrReplace);
            }
            int i3 = tile.mStartPosition + tile.mItemCount;
            int i4 = 0;
            while (i4 < AsyncListUtil.this.mMissingPositions.size()) {
                int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i4);
                if (tile.mStartPosition > keyAt || keyAt >= i3) {
                    i4++;
                } else {
                    AsyncListUtil.this.mMissingPositions.removeAt(i4);
                    AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i2, int i3) {
            if (isRequestedGeneration(i2)) {
                TileList.Tile<T> removeAtPos = AsyncListUtil.this.mTileList.removeAtPos(i3);
                if (removeAtPos == null) {
                    Log.e(AsyncListUtil.TAG, "tile not found @" + i3);
                    return;
                }
                AsyncListUtil.this.mBackgroundProxy.recycleTile(removeAtPos);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i2, int i3) {
            if (isRequestedGeneration(i2)) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.mItemCount = i3;
                asyncListUtil.mViewCallback.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                recycleAllTiles();
                AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                asyncListUtil3.mAllowScrollHints = false;
                asyncListUtil3.updateRange();
            }
        }
    };
    public final ThreadUtil.BackgroundCallback<T> mBackgroundCallback = new ThreadUtil.BackgroundCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.2
        public int mFirstRequiredTileStart;
        public int mGeneration;
        public int mItemCount;
        public int mLastRequiredTileStart;
        public final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
        public TileList.Tile<T> mRecycledRoot;

        private TileList.Tile<T> acquireTile() {
            TileList.Tile<T> tile = this.mRecycledRoot;
            if (tile != null) {
                this.mRecycledRoot = tile.mNext;
                return tile;
            }
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
        }

        private void addTile(TileList.Tile<T> tile) {
            this.mLoadedTiles.put(tile.mStartPosition, true);
            AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
        }

        private void flushTileCache(int i2) {
            int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
            while (this.mLoadedTiles.size() >= maxCachedTiles) {
                int keyAt = this.mLoadedTiles.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i3 = this.mFirstRequiredTileStart - keyAt;
                int i4 = keyAt2 - this.mLastRequiredTileStart;
                if (i3 > 0 && (i3 >= i4 || i2 == 2)) {
                    removeTile(keyAt);
                } else if (i4 <= 0) {
                    return;
                } else {
                    if (i3 >= i4 && i2 != 1) {
                        return;
                    }
                    removeTile(keyAt2);
                }
            }
        }

        private int getTileStart(int i2) {
            return i2 - (i2 % AsyncListUtil.this.mTileSize);
        }

        private boolean isTileLoaded(int i2) {
            return this.mLoadedTiles.get(i2);
        }

        private void log(String str, Object... objArr) {
            Log.d(AsyncListUtil.TAG, "[BKGR] " + String.format(str, objArr));
        }

        private void removeTile(int i2) {
            this.mLoadedTiles.delete(i2);
            AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i2);
        }

        private void requestTiles(int i2, int i3, int i4, boolean z) {
            int i5 = i2;
            while (i5 <= i3) {
                AsyncListUtil.this.mBackgroundProxy.loadTile(z ? (i3 + i2) - i5 : i5, i4);
                i5 += AsyncListUtil.this.mTileSize;
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i2, int i3) {
            if (isTileLoaded(i2)) {
                return;
            }
            TileList.Tile<T> acquireTile = acquireTile();
            acquireTile.mStartPosition = i2;
            int min = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - i2);
            acquireTile.mItemCount = min;
            AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
            flushTileCache(i3);
            addTile(acquireTile);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
            tile.mNext = this.mRecycledRoot;
            this.mRecycledRoot = tile;
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i2) {
            this.mGeneration = i2;
            this.mLoadedTiles.clear();
            int refreshData = AsyncListUtil.this.mDataCallback.refreshData();
            this.mItemCount = refreshData;
            AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i2, int i3, int i4, int i5, int i6) {
            if (i2 > i3) {
                return;
            }
            int tileStart = getTileStart(i2);
            int tileStart2 = getTileStart(i3);
            this.mFirstRequiredTileStart = getTileStart(i4);
            int tileStart3 = getTileStart(i5);
            this.mLastRequiredTileStart = tileStart3;
            if (i6 == 1) {
                requestTiles(this.mFirstRequiredTileStart, tileStart2, i6, true);
                requestTiles(tileStart2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i6, false);
                return;
            }
            requestTiles(tileStart, tileStart3, i6, false);
            requestTiles(this.mFirstRequiredTileStart, tileStart - AsyncListUtil.this.mTileSize, i6, true);
        }
    };

    /* loaded from: classes.dex */
    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i2, int i3);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i2) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i2) {
            int i3 = (iArr[1] - iArr[0]) + 1;
            int i4 = i3 / 2;
            iArr2[0] = iArr[0] - (i2 == 1 ? i3 : i4);
            int i5 = iArr[1];
            if (i2 != 2) {
                i3 = i4;
            }
            iArr2[1] = i5 + i3;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i2);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i2, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        this.mTClass = cls;
        this.mTileSize = i2;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList<>(i2);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(this.mMainThreadCallback);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(this.mBackgroundCallback);
        refresh();
    }

    private boolean isRefreshPending() {
        return this.mRequestedGeneration != this.mDisplayedGeneration;
    }

    @Nullable
    public T getItem(int i2) {
        if (i2 >= 0 && i2 < this.mItemCount) {
            T itemAt = this.mTileList.getItemAt(i2);
            if (itemAt == null && !isRefreshPending()) {
                this.mMissingPositions.put(i2, 0);
            }
            return itemAt;
        }
        throw new IndexOutOfBoundsException(i2 + " is not within 0 and " + this.mItemCount);
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public void log(String str, Object... objArr) {
        Log.d(TAG, "[MAIN] " + String.format(str, objArr));
    }

    public void onRangeChanged() {
        if (isRefreshPending()) {
            return;
        }
        updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int i2 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i2;
        backgroundCallback.refresh(i2);
    }

    public void updateRange() {
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        if (iArr[0] > iArr[1] || iArr[0] < 0 || iArr[1] >= this.mItemCount) {
            return;
        }
        if (!this.mAllowScrollHints) {
            this.mScrollHint = 0;
        } else {
            int i2 = iArr[0];
            int[] iArr2 = this.mPrevRange;
            if (i2 <= iArr2[1] && iArr2[0] <= iArr[1]) {
                if (iArr[0] < iArr2[0]) {
                    this.mScrollHint = 1;
                } else if (iArr[0] > iArr2[0]) {
                    this.mScrollHint = 2;
                }
            } else {
                this.mScrollHint = 0;
            }
        }
        int[] iArr3 = this.mPrevRange;
        int[] iArr4 = this.mTmpRange;
        iArr3[0] = iArr4[0];
        iArr3[1] = iArr4[1];
        this.mViewCallback.extendRangeInto(iArr4, this.mTmpRangeExtended, this.mScrollHint);
        int[] iArr5 = this.mTmpRangeExtended;
        iArr5[0] = Math.min(this.mTmpRange[0], Math.max(iArr5[0], 0));
        int[] iArr6 = this.mTmpRangeExtended;
        iArr6[1] = Math.max(this.mTmpRange[1], Math.min(iArr6[1], this.mItemCount - 1));
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int[] iArr7 = this.mTmpRange;
        int i3 = iArr7[0];
        int i4 = iArr7[1];
        int[] iArr8 = this.mTmpRangeExtended;
        backgroundCallback.updateRange(i3, i4, iArr8[0], iArr8[1], this.mScrollHint);
    }
}
