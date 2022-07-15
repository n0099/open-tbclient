package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class GapWorker implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<GapWorker> sGapWorker;
    public static Comparator<Task> sTaskComparator;
    public transient /* synthetic */ FieldHolder $fh;
    public long mFrameIntervalNs;
    public long mPostTimeNs;
    public ArrayList<RecyclerView> mRecyclerViews;
    public ArrayList<Task> mTasks;

    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mCount;
        public int[] mPrefetchArray;
        public int mPrefetchDx;
        public int mPrefetchDy;

        public LayoutPrefetchRegistryImpl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (i < 0) {
                    throw new IllegalArgumentException("Layout positions must be non-negative");
                }
                if (i2 >= 0) {
                    int i3 = this.mCount * 2;
                    int[] iArr = this.mPrefetchArray;
                    if (iArr == null) {
                        int[] iArr2 = new int[4];
                        this.mPrefetchArray = iArr2;
                        Arrays.fill(iArr2, -1);
                    } else if (i3 >= iArr.length) {
                        int[] iArr3 = new int[i3 * 2];
                        this.mPrefetchArray = iArr3;
                        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    }
                    int[] iArr4 = this.mPrefetchArray;
                    iArr4[i3] = i;
                    iArr4[i3 + 1] = i2;
                    this.mCount++;
                    return;
                }
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public void clearPrefetchPositions() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int[] iArr = this.mPrefetchArray;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                this.mCount = 0;
            }
        }

        public void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, recyclerView, z) == null) {
                this.mCount = 0;
                int[] iArr = this.mPrefetchArray;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
                if (recyclerView.mAdapter == null || layoutManager == null || !layoutManager.isItemPrefetchEnabled()) {
                    return;
                }
                if (z) {
                    if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
                }
                int i = this.mCount;
                if (i > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public boolean lastPrefetchIncludedPosition(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                if (this.mPrefetchArray != null) {
                    int i2 = this.mCount * 2;
                    for (int i3 = 0; i3 < i2; i3 += 2) {
                        if (this.mPrefetchArray[i3] == i) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return invokeI.booleanValue;
        }

        public void setPrefetchVector(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
                this.mPrefetchDx = i;
                this.mPrefetchDy = i2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int distanceToItem;
        public boolean immediate;
        public int position;

        /* renamed from: view  reason: collision with root package name */
        public RecyclerView f1746view;
        public int viewVelocity;

        public Task() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.immediate = false;
                this.viewVelocity = 0;
                this.distanceToItem = 0;
                this.f1746view = null;
                this.position = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-707219263, "Landroidx/recyclerview/widget/GapWorker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-707219263, "Landroidx/recyclerview/widget/GapWorker;");
                return;
            }
        }
        sGapWorker = new ThreadLocal<>();
        sTaskComparator = new Comparator<Task>() { // from class: androidx.recyclerview.widget.GapWorker.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Task task, Task task2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, task, task2)) == null) {
                    if ((task.f1746view == null) != (task2.f1746view == null)) {
                        return task.f1746view == null ? 1 : -1;
                    }
                    boolean z = task.immediate;
                    if (z != task2.immediate) {
                        return z ? -1 : 1;
                    }
                    int i = task2.viewVelocity - task.viewVelocity;
                    if (i != 0) {
                        return i;
                    }
                    int i2 = task.distanceToItem - task2.distanceToItem;
                    if (i2 != 0) {
                        return i2;
                    }
                    return 0;
                }
                return invokeLL.intValue;
            }
        };
    }

    public GapWorker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRecyclerViews = new ArrayList<>();
        this.mTasks = new ArrayList<>();
    }

    private void buildTaskList() {
        Task task;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int size = this.mRecyclerViews.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView recyclerView = this.mRecyclerViews.get(i2);
                if (recyclerView.getWindowVisibility() == 0) {
                    recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
                    i += recyclerView.mPrefetchRegistry.mCount;
                }
            }
            this.mTasks.ensureCapacity(i);
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView recyclerView2 = this.mRecyclerViews.get(i4);
                if (recyclerView2.getWindowVisibility() == 0) {
                    LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                    int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy);
                    for (int i5 = 0; i5 < layoutPrefetchRegistryImpl.mCount * 2; i5 += 2) {
                        if (i3 >= this.mTasks.size()) {
                            task = new Task();
                            this.mTasks.add(task);
                        } else {
                            task = this.mTasks.get(i3);
                        }
                        int i6 = layoutPrefetchRegistryImpl.mPrefetchArray[i5 + 1];
                        task.immediate = i6 <= abs;
                        task.viewVelocity = abs;
                        task.distanceToItem = i6;
                        task.f1746view = recyclerView2;
                        task.position = layoutPrefetchRegistryImpl.mPrefetchArray[i5];
                        i3++;
                    }
                }
            }
            Collections.sort(this.mTasks, sTaskComparator);
        }
    }

    private void flushTaskWithDeadline(Task task, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65539, this, task, j) == null) {
            RecyclerView.ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(task.f1746view, task.position, task.immediate ? Long.MAX_VALUE : j);
            if (prefetchPositionWithDeadline == null || prefetchPositionWithDeadline.mNestedRecyclerView == null || !prefetchPositionWithDeadline.isBound() || prefetchPositionWithDeadline.isInvalid()) {
                return;
            }
            prefetchInnerRecyclerViewWithDeadline(prefetchPositionWithDeadline.mNestedRecyclerView.get(), j);
        }
    }

    private void flushTasksWithDeadline(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j) == null) {
            for (int i = 0; i < this.mTasks.size(); i++) {
                Task task = this.mTasks.get(i);
                if (task.f1746view == null) {
                    return;
                }
                flushTaskWithDeadline(task, j);
                task.clear();
            }
        }
    }

    public static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, recyclerView, i)) == null) {
            int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
            for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
                RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i2));
                if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView recyclerView, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65542, this, recyclerView, j) == null) || recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.getUnfilteredChildCount() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(recyclerView, true);
        if (layoutPrefetchRegistryImpl.mCount != 0) {
            try {
                TraceCompat.beginSection(RecyclerView.TRACE_NESTED_PREFETCH_TAG);
                recyclerView.mState.prepareForNestedPrefetch(recyclerView.mAdapter);
                for (int i = 0; i < layoutPrefetchRegistryImpl.mCount * 2; i += 2) {
                    prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl.mPrefetchArray[i], j);
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{recyclerView, Integer.valueOf(i), Long.valueOf(j)})) == null) {
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
        return (RecyclerView.ViewHolder) invokeCommon.objValue;
    }

    public void add(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) {
            this.mRecyclerViews.add(recyclerView);
        }
    }

    public void postFromTraversal(RecyclerView recyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
            if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
                this.mPostTimeNs = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
            recyclerView.mPrefetchRegistry.setPrefetchVector(i, i2);
        }
    }

    public void prefetch(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            buildTaskList();
            flushTasksWithDeadline(j);
        }
    }

    public void remove(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, recyclerView) == null) {
            this.mRecyclerViews.remove(recyclerView);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                TraceCompat.beginSection(RecyclerView.TRACE_PREFETCH_TAG);
                if (!this.mRecyclerViews.isEmpty()) {
                    int size = this.mRecyclerViews.size();
                    long j = 0;
                    for (int i = 0; i < size; i++) {
                        RecyclerView recyclerView = this.mRecyclerViews.get(i);
                        if (recyclerView.getWindowVisibility() == 0) {
                            j = Math.max(recyclerView.getDrawingTime(), j);
                        }
                    }
                    if (j != 0) {
                        prefetch(TimeUnit.MILLISECONDS.toNanos(j) + this.mFrameIntervalNs);
                    }
                }
            } finally {
                this.mPostTimeNs = 0L;
                TraceCompat.endSection();
            }
        }
    }
}
