package androidx.recyclerview.widget;

import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AsyncListUtil<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncListUtil";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllowScrollHints;
    public final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    public final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    public final DataCallback<T> mDataCallback;
    public int mDisplayedGeneration;
    public int mItemCount;
    public final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    public final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    public final SparseIntArray mMissingPositions;
    public final int[] mPrevRange;
    public int mRequestedGeneration;
    public int mScrollHint;
    public final Class<T> mTClass;
    public final TileList<T> mTileList;
    public final int mTileSize;
    public final int[] mTmpRange;
    public final int[] mTmpRangeExtended;
    public final ViewCallback mViewCallback;

    /* loaded from: classes.dex */
    public static abstract class DataCallback<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DataCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i2, int i3);

        @WorkerThread
        public int getMaxCachedTiles() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 10;
            }
            return invokeV.intValue;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tArr, i2) == null) {
            }
        }

        @WorkerThread
        public abstract int refreshData();
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCallback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;
        public transient /* synthetic */ FieldHolder $fh;

        public ViewCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, iArr, iArr2, i2) == null) {
                int i3 = (iArr[1] - iArr[0]) + 1;
                int i4 = i3 / 2;
                iArr2[0] = iArr[0] - (i2 == 1 ? i3 : i4);
                int i5 = iArr[1];
                if (i2 != 2) {
                    i3 = i4;
                }
                iArr2[1] = i5 + i3;
            }
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i2);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i2, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, Integer.valueOf(i2), dataCallback, viewCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTmpRange = new int[2];
        this.mPrevRange = new int[2];
        this.mTmpRangeExtended = new int[2];
        this.mScrollHint = 0;
        this.mItemCount = 0;
        this.mDisplayedGeneration = 0;
        this.mRequestedGeneration = 0;
        this.mMissingPositions = new SparseIntArray();
        this.mMainThreadCallback = new ThreadUtil.MainThreadCallback<T>(this) { // from class: androidx.recyclerview.widget.AsyncListUtil.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AsyncListUtil this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private boolean isRequestedGeneration(int i5) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(65537, this, i5)) == null) ? i5 == this.this$0.mRequestedGeneration : invokeI.booleanValue;
            }

            private void recycleAllTiles() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(65538, this) == null) {
                    for (int i5 = 0; i5 < this.this$0.mTileList.size(); i5++) {
                        AsyncListUtil asyncListUtil = this.this$0;
                        asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i5));
                    }
                    this.this$0.mTileList.clear();
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void addTile(int i5, TileList.Tile<T> tile) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i5, tile) == null) {
                    if (!isRequestedGeneration(i5)) {
                        this.this$0.mBackgroundProxy.recycleTile(tile);
                        return;
                    }
                    TileList.Tile<T> addOrReplace = this.this$0.mTileList.addOrReplace(tile);
                    if (addOrReplace != null) {
                        String str = "duplicate tile @" + addOrReplace.mStartPosition;
                        this.this$0.mBackgroundProxy.recycleTile(addOrReplace);
                    }
                    int i6 = tile.mStartPosition + tile.mItemCount;
                    int i7 = 0;
                    while (i7 < this.this$0.mMissingPositions.size()) {
                        int keyAt = this.this$0.mMissingPositions.keyAt(i7);
                        if (tile.mStartPosition > keyAt || keyAt >= i6) {
                            i7++;
                        } else {
                            this.this$0.mMissingPositions.removeAt(i7);
                            this.this$0.mViewCallback.onItemLoaded(keyAt);
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void removeTile(int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i5, i6) == null) && isRequestedGeneration(i5)) {
                    TileList.Tile<T> removeAtPos = this.this$0.mTileList.removeAtPos(i6);
                    if (removeAtPos == null) {
                        String str = "tile not found @" + i6;
                        return;
                    }
                    this.this$0.mBackgroundProxy.recycleTile(removeAtPos);
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void updateItemCount(int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeII(Constants.METHOD_SEND_USER_MSG, this, i5, i6) == null) && isRequestedGeneration(i5)) {
                    AsyncListUtil asyncListUtil = this.this$0;
                    asyncListUtil.mItemCount = i6;
                    asyncListUtil.mViewCallback.onDataRefresh();
                    AsyncListUtil asyncListUtil2 = this.this$0;
                    asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                    recycleAllTiles();
                    AsyncListUtil asyncListUtil3 = this.this$0;
                    asyncListUtil3.mAllowScrollHints = false;
                    asyncListUtil3.updateRange();
                }
            }
        };
        this.mBackgroundCallback = new ThreadUtil.BackgroundCallback<T>(this) { // from class: androidx.recyclerview.widget.AsyncListUtil.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int mFirstRequiredTileStart;
            public int mGeneration;
            public int mItemCount;
            public int mLastRequiredTileStart;
            public final SparseBooleanArray mLoadedTiles;
            public TileList.Tile<T> mRecycledRoot;
            public final /* synthetic */ AsyncListUtil this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.mLoadedTiles = new SparseBooleanArray();
            }

            private TileList.Tile<T> acquireTile() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) {
                    TileList.Tile<T> tile = this.mRecycledRoot;
                    if (tile != null) {
                        this.mRecycledRoot = tile.mNext;
                        return tile;
                    }
                    AsyncListUtil asyncListUtil = this.this$0;
                    return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
                }
                return (TileList.Tile) invokeV.objValue;
            }

            private void addTile(TileList.Tile<T> tile) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(65538, this, tile) == null) {
                    this.mLoadedTiles.put(tile.mStartPosition, true);
                    this.this$0.mMainThreadProxy.addTile(this.mGeneration, tile);
                }
            }

            private void flushTileCache(int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(65539, this, i5) == null) {
                    int maxCachedTiles = this.this$0.mDataCallback.getMaxCachedTiles();
                    while (this.mLoadedTiles.size() >= maxCachedTiles) {
                        int keyAt = this.mLoadedTiles.keyAt(0);
                        SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                        int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                        int i6 = this.mFirstRequiredTileStart - keyAt;
                        int i7 = keyAt2 - this.mLastRequiredTileStart;
                        if (i6 > 0 && (i6 >= i7 || i5 == 2)) {
                            removeTile(keyAt);
                        } else if (i7 <= 0) {
                            return;
                        } else {
                            if (i6 >= i7 && i5 != 1) {
                                return;
                            }
                            removeTile(keyAt2);
                        }
                    }
                }
            }

            private int getTileStart(int i5) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i5)) == null) ? i5 - (i5 % this.this$0.mTileSize) : invokeI.intValue;
            }

            private boolean isTileLoaded(int i5) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(AdIconUtil.AD_TEXT_ID, this, i5)) == null) ? this.mLoadedTiles.get(i5) : invokeI.booleanValue;
            }

            private void log(String str, Object... objArr2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, str, objArr2) == null) {
                    String str2 = "[BKGR] " + String.format(str, objArr2);
                }
            }

            private void removeTile(int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(65543, this, i5) == null) {
                    this.mLoadedTiles.delete(i5);
                    this.this$0.mMainThreadProxy.removeTile(this.mGeneration, i5);
                }
            }

            private void requestTiles(int i5, int i6, int i7, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(65544, this, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z)}) == null) {
                    int i8 = i5;
                    while (i8 <= i6) {
                        this.this$0.mBackgroundProxy.loadTile(z ? (i6 + i5) - i8 : i8, i7);
                        i8 += this.this$0.mTileSize;
                    }
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void loadTile(int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048576, this, i5, i6) == null) || isTileLoaded(i5)) {
                    return;
                }
                TileList.Tile<T> acquireTile = acquireTile();
                acquireTile.mStartPosition = i5;
                int min = Math.min(this.this$0.mTileSize, this.mItemCount - i5);
                acquireTile.mItemCount = min;
                this.this$0.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
                flushTileCache(i6);
                addTile(acquireTile);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void recycleTile(TileList.Tile<T> tile) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tile) == null) {
                    this.this$0.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
                    tile.mNext = this.mRecycledRoot;
                    this.mRecycledRoot = tile;
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void refresh(int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i5) == null) {
                    this.mGeneration = i5;
                    this.mLoadedTiles.clear();
                    int refreshData = this.this$0.mDataCallback.refreshData();
                    this.mItemCount = refreshData;
                    this.this$0.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void updateRange(int i5, int i6, int i7, int i8, int i9) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) || i5 > i6) {
                    return;
                }
                int tileStart = getTileStart(i5);
                int tileStart2 = getTileStart(i6);
                this.mFirstRequiredTileStart = getTileStart(i7);
                int tileStart3 = getTileStart(i8);
                this.mLastRequiredTileStart = tileStart3;
                if (i9 == 1) {
                    requestTiles(this.mFirstRequiredTileStart, tileStart2, i9, true);
                    requestTiles(tileStart2 + this.this$0.mTileSize, this.mLastRequiredTileStart, i9, false);
                    return;
                }
                requestTiles(tileStart, tileStart3, i9, false);
                requestTiles(this.mFirstRequiredTileStart, tileStart - this.this$0.mTileSize, i9, true);
            }
        };
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.mRequestedGeneration != this.mDisplayedGeneration : invokeV.booleanValue;
    }

    @Nullable
    public T getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= 0 && i2 < this.mItemCount) {
                T itemAt = this.mTileList.getItemAt(i2);
                if (itemAt == null && !isRefreshPending()) {
                    this.mMissingPositions.put(i2, 0);
                }
                return itemAt;
            }
            throw new IndexOutOfBoundsException(i2 + " is not within 0 and " + this.mItemCount);
        }
        return (T) invokeI.objValue;
    }

    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mItemCount : invokeV.intValue;
    }

    public void log(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr) == null) {
            String str2 = "[MAIN] " + String.format(str, objArr);
        }
    }

    public void onRangeChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || isRefreshPending()) {
            return;
        }
        updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mMissingPositions.clear();
            ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
            int i2 = this.mRequestedGeneration + 1;
            this.mRequestedGeneration = i2;
            backgroundCallback.refresh(i2);
        }
    }

    public void updateRange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
}
