package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    static Comparator<Task> sTaskComparator = new Comparator<Task>() { // from class: android.support.v7.widget.GapWorker.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Task task, Task task2) {
            if ((task.view == null) != (task2.view == null)) {
                return task.view == null ? 1 : -1;
            } else if (task.immediate != task2.immediate) {
                return task.immediate ? -1 : 1;
            } else {
                int i = task2.viewVelocity - task.viewVelocity;
                if (i == 0) {
                    int i2 = task.distanceToItem - task2.distanceToItem;
                    if (i2 == 0) {
                        return 0;
                    }
                    return i2;
                }
                return i;
            }
        }
    };
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    private ArrayList<Task> mTasks = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        void setPrefetchVector(int i, int i2) {
            this.mPrefetchDx = i;
            this.mPrefetchDy = i2;
        }

        void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z) {
            this.mCount = 0;
            if (this.mPrefetchArray != null) {
                Arrays.fill(this.mPrefetchArray, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
                }
                if (this.mCount > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = this.mCount;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.mCount * 2;
            if (this.mPrefetchArray == null) {
                this.mPrefetchArray = new int[4];
                Arrays.fill(this.mPrefetchArray, -1);
            } else if (i3 >= this.mPrefetchArray.length) {
                int[] iArr = this.mPrefetchArray;
                this.mPrefetchArray = new int[i3 * 2];
                System.arraycopy(iArr, 0, this.mPrefetchArray, 0, iArr.length);
            }
            this.mPrefetchArray[i3] = i;
            this.mPrefetchArray[i3 + 1] = i2;
            this.mCount++;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean lastPrefetchIncludedPosition(int i) {
            if (this.mPrefetchArray != null) {
                int i2 = this.mCount * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.mPrefetchArray[i3] == i) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clearPrefetchPositions() {
            if (this.mPrefetchArray != null) {
                Arrays.fill(this.mPrefetchArray, -1);
            }
            this.mCount = 0;
        }
    }

    public void add(RecyclerView recyclerView) {
        this.mRecyclerViews.add(recyclerView);
    }

    public void remove(RecyclerView recyclerView) {
        this.mRecyclerViews.remove(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postFromTraversal(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(i, i2);
    }

    private void buildTaskList() {
        Task task;
        int i;
        int size = this.mRecyclerViews.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            RecyclerView recyclerView = this.mRecyclerViews.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
                i = recyclerView.mPrefetchRegistry.mCount + i3;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        this.mTasks.ensureCapacity(i3);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.mRecyclerViews.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy);
                int i6 = i4;
                for (int i7 = 0; i7 < layoutPrefetchRegistryImpl.mCount * 2; i7 += 2) {
                    if (i6 >= this.mTasks.size()) {
                        task = new Task();
                        this.mTasks.add(task);
                    } else {
                        task = this.mTasks.get(i6);
                    }
                    int i8 = layoutPrefetchRegistryImpl.mPrefetchArray[i7 + 1];
                    task.immediate = i8 <= abs;
                    task.viewVelocity = abs;
                    task.distanceToItem = i8;
                    task.view = recyclerView2;
                    task.position = layoutPrefetchRegistryImpl.mPrefetchArray[i7];
                    i6++;
                }
                i4 = i6;
            }
        }
        Collections.sort(this.mTasks, sTaskComparator);
    }

    static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int i) {
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i, long j) {
        if (isPrefetchPositionAttached(recyclerView, i)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(i, false, j);
            if (tryGetViewHolderForPositionByDeadline != null) {
                if (tryGetViewHolderForPositionByDeadline.isBound() && !tryGetViewHolderForPositionByDeadline.isInvalid()) {
                    recycler.recycleView(tryGetViewHolderForPositionByDeadline.itemView);
                } else {
                    recycler.addViewHolderToRecycledViewPool(tryGetViewHolderForPositionByDeadline, false);
                }
            }
            return tryGetViewHolderForPositionByDeadline;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.getUnfilteredChildCount() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
            layoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(recyclerView, true);
            if (layoutPrefetchRegistryImpl.mCount != 0) {
                try {
                    TraceCompat.beginSection("RV Nested Prefetch");
                    recyclerView.mState.prepareForNestedPrefetch(recyclerView.mAdapter);
                    for (int i = 0; i < layoutPrefetchRegistryImpl.mCount * 2; i += 2) {
                        prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl.mPrefetchArray[i], j);
                    }
                } finally {
                    TraceCompat.endSection();
                }
            }
        }
    }

    private void flushTaskWithDeadline(Task task, long j) {
        RecyclerView.ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(task.view, task.position, task.immediate ? Format.OFFSET_SAMPLE_RELATIVE : j);
        if (prefetchPositionWithDeadline != null && prefetchPositionWithDeadline.mNestedRecyclerView != null && prefetchPositionWithDeadline.isBound() && !prefetchPositionWithDeadline.isInvalid()) {
            prefetchInnerRecyclerViewWithDeadline(prefetchPositionWithDeadline.mNestedRecyclerView.get(), j);
        }
    }

    private void flushTasksWithDeadline(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTasks.size()) {
                Task task = this.mTasks.get(i2);
                if (task.view != null) {
                    flushTaskWithDeadline(task, j);
                    task.clear();
                    i = i2 + 1;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    void prefetch(long j) {
        buildTaskList();
        flushTasksWithDeadline(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [400=4, 401=4] */
    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (this.mRecyclerViews.isEmpty()) {
                return;
            }
            int size = this.mRecyclerViews.size();
            int i = 0;
            long j = 0;
            while (i < size) {
                RecyclerView recyclerView = this.mRecyclerViews.get(i);
                i++;
                j = recyclerView.getWindowVisibility() == 0 ? Math.max(recyclerView.getDrawingTime(), j) : j;
            }
            if (j == 0) {
                return;
            }
            prefetch(TimeUnit.MILLISECONDS.toNanos(j) + this.mFrameIntervalNs);
        } finally {
            this.mPostTimeNs = 0L;
            TraceCompat.endSection();
        }
    }
}
