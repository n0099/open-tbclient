package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    public static final String TAG = "GridLayoutManager";
    public transient /* synthetic */ FieldHolder $fh;
    public int[] mCachedBorders;
    public final Rect mDecorInsets;
    public boolean mPendingSpanCountChange;
    public final SparseIntArray mPreLayoutSpanIndexCache;
    public final SparseIntArray mPreLayoutSpanSizeCache;
    public View[] mSet;
    public int mSpanCount;
    public SpanSizeLookup mSpanSizeLookup;
    public boolean mUsingSpansToEstimateScrollBarDimensions;

    /* loaded from: classes.dex */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultSpanSizeLookup() {
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

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) ? i % i2 : invokeII.intValue;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return 1;
            }
            return invokeI.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SpanSizeLookup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mCacheSpanGroupIndices;
        public boolean mCacheSpanIndices;
        public final SparseIntArray mSpanGroupIndexCache;
        public final SparseIntArray mSpanIndexCache;

        public SpanSizeLookup() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSpanIndexCache = new SparseIntArray();
            this.mSpanGroupIndexCache = new SparseIntArray();
            this.mCacheSpanIndices = false;
            this.mCacheSpanGroupIndices = false;
        }

        public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, sparseIntArray, i)) == null) {
                int size = sparseIntArray.size() - 1;
                int i2 = 0;
                while (i2 <= size) {
                    int i3 = (i2 + size) >>> 1;
                    if (sparseIntArray.keyAt(i3) < i) {
                        i2 = i3 + 1;
                    } else {
                        size = i3 - 1;
                    }
                }
                int i4 = i2 - 1;
                if (i4 < 0 || i4 >= sparseIntArray.size()) {
                    return -1;
                }
                return sparseIntArray.keyAt(i4);
            }
            return invokeLI.intValue;
        }

        public int getCachedSpanGroupIndex(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
                if (!this.mCacheSpanGroupIndices) {
                    return getSpanGroupIndex(i, i2);
                }
                int i3 = this.mSpanGroupIndexCache.get(i, -1);
                if (i3 != -1) {
                    return i3;
                }
                int spanGroupIndex = getSpanGroupIndex(i, i2);
                this.mSpanGroupIndexCache.put(i, spanGroupIndex);
                return spanGroupIndex;
            }
            return invokeII.intValue;
        }

        public int getCachedSpanIndex(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
                if (!this.mCacheSpanIndices) {
                    return getSpanIndex(i, i2);
                }
                int i3 = this.mSpanIndexCache.get(i, -1);
                if (i3 != -1) {
                    return i3;
                }
                int spanIndex = getSpanIndex(i, i2);
                this.mSpanIndexCache.put(i, spanIndex);
                return spanIndex;
            }
            return invokeII.intValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanGroupIndex(int i, int i2) {
            InterceptResult invokeII;
            int i3;
            int i4;
            int findFirstKeyLessThan;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) != null) {
                return invokeII.intValue;
            }
            if (this.mCacheSpanGroupIndices && (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i)) != -1) {
                int i5 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i3 = findFirstKeyLessThan + 1;
                i4 = getCachedSpanIndex(findFirstKeyLessThan, i2) + getSpanSize(findFirstKeyLessThan);
                i5 = i4 == i2 ? i5 + 1 : 0;
                int spanSize = getSpanSize(i);
                while (i3 < i) {
                    int spanSize2 = getSpanSize(i3);
                    i4 += spanSize2;
                    if (i4 == i2) {
                        i5++;
                        i4 = 0;
                    } else if (i4 > i2) {
                        i5++;
                        i4 = spanSize2;
                    }
                    i3++;
                }
                return i4 + spanSize <= i2 ? i5 + 1 : i5;
            }
            i3 = 0;
            i4 = 0;
            int spanSize3 = getSpanSize(i);
            while (i3 < i) {
            }
            if (i4 + spanSize3 <= i2) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:19:0x0034). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0031 -> B:19:0x0034). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0033 -> B:19:0x0034). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanIndex(int i, int i2) {
            InterceptResult invokeII;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeII = interceptable.invokeII(1048579, this, i, i2)) != null) {
                return invokeII.intValue;
            }
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return 0;
            }
            if (!this.mCacheSpanIndices || (i3 = findFirstKeyLessThan(this.mSpanIndexCache, i)) < 0) {
                i3 = 0;
                i4 = 0;
                if (i3 >= i) {
                    int spanSize2 = getSpanSize(i3);
                    i4 += spanSize2;
                    if (i4 == i2) {
                        i4 = 0;
                    } else if (i4 > i2) {
                        i4 = spanSize2;
                    }
                    i3++;
                    if (i3 >= i) {
                        if (spanSize + i4 <= i2) {
                            return i4;
                        }
                        return 0;
                    }
                }
            } else {
                i4 = this.mSpanIndexCache.get(i3) + getSpanSize(i3);
                i3++;
                if (i3 >= i) {
                }
            }
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanGroupIndexCache() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.mSpanGroupIndexCache.clear();
            }
        }

        public void invalidateSpanIndexCache() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.mSpanIndexCache.clear();
            }
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mCacheSpanGroupIndices : invokeV.booleanValue;
        }

        public boolean isSpanIndexCacheEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mCacheSpanIndices : invokeV.booleanValue;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                if (!z) {
                    this.mSpanGroupIndexCache.clear();
                }
                this.mCacheSpanGroupIndices = z;
            }
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                if (!z) {
                    this.mSpanGroupIndexCache.clear();
                }
                this.mCacheSpanIndices = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i, boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{recycler, state, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int i4 = 0;
            int i5 = -1;
            if (z) {
                i5 = i;
                i2 = 0;
                i3 = 1;
            } else {
                i2 = i - 1;
                i3 = -1;
            }
            while (i2 != i5) {
                View view2 = this.mSet[i2];
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                int spanSize = getSpanSize(recycler, state, getPosition(view2));
                layoutParams.mSpanSize = spanSize;
                layoutParams.mSpanIndex = i4;
                i4 += spanSize;
                i2 += i3;
            }
        }
    }

    private void cachePreLayoutSpanMapping() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int viewLayoutPosition = layoutParams.getViewLayoutPosition();
                this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
                this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
            }
        }
    }

    private void calculateItemBorders(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i);
        }
    }

    private void clearPreLayoutSpanMappingCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mPreLayoutSpanSizeCache.clear();
            this.mPreLayoutSpanIndexCache.clear();
        }
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State state) {
        InterceptResult invokeL;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, state)) == null) {
            if (getChildCount() != 0 && state.getItemCount() != 0) {
                ensureLayoutState();
                boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
                View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
                View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
                if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                    int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                    int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                    int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                    int max2 = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                    int cachedSpanGroupIndex3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                    if (this.mShouldReverseLayout) {
                        max = Math.max(0, (cachedSpanGroupIndex3 - max2) - 1);
                    } else {
                        max = Math.max(0, min);
                    }
                    return !isSmoothScrollbarEnabled ? max : Math.round((max * (Math.abs(this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)));
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, state)) == null) {
            if (getChildCount() != 0 && state.getItemCount() != 0) {
                ensureLayoutState();
                View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
                View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
                if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                    if (!isSmoothScrollbarEnabled()) {
                        return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                    }
                    return (int) (((this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1));
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65546, this, recycler, state, anchorInfo, i) == null) {
            boolean z = i == 1;
            int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
            if (z) {
                while (spanIndex > 0) {
                    int i2 = anchorInfo.mPosition;
                    if (i2 <= 0) {
                        return;
                    }
                    int i3 = i2 - 1;
                    anchorInfo.mPosition = i3;
                    spanIndex = getSpanIndex(recycler, state, i3);
                }
                return;
            }
            int itemCount = state.getItemCount() - 1;
            int i4 = anchorInfo.mPosition;
            while (i4 < itemCount) {
                int i5 = i4 + 1;
                int spanIndex2 = getSpanIndex(recycler, state, i5);
                if (spanIndex2 <= spanIndex) {
                    break;
                }
                i4 = i5;
                spanIndex = spanIndex2;
            }
            anchorInfo.mPosition = i4;
        }
    }

    private void ensureViewSet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            View[] viewArr = this.mSet;
            if (viewArr == null || viewArr.length != this.mSpanCount) {
                this.mSet = new View[this.mSpanCount];
            }
        }
    }

    private int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65548, this, recycler, state, i)) == null) {
            if (!state.isPreLayout()) {
                return this.mSpanSizeLookup.getCachedSpanGroupIndex(i, this.mSpanCount);
            }
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
            if (convertPreLayoutPositionToPostLayout == -1) {
                Log.w(TAG, "Cannot find span size for pre layout position. " + i);
                return 0;
            }
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        return invokeLLI.intValue;
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65549, this, recycler, state, i)) == null) {
            if (!state.isPreLayout()) {
                return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
            }
            int i2 = this.mPreLayoutSpanIndexCache.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
            if (convertPreLayoutPositionToPostLayout == -1) {
                Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
                return 0;
            }
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        return invokeLLI.intValue;
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, this, recycler, state, i)) == null) {
            if (!state.isPreLayout()) {
                return this.mSpanSizeLookup.getSpanSize(i);
            }
            int i2 = this.mPreLayoutSpanSizeCache.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
            if (convertPreLayoutPositionToPostLayout == -1) {
                Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
                return 1;
            }
            return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        return invokeLLI.intValue;
    }

    private void guessMeasurement(float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
            calculateItemBorders(Math.max(Math.round(f * this.mSpanCount), i));
        }
    }

    private void measureChild(View view2, int i, boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
            if (this.mOrientation == 1) {
                i3 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                i2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
            } else {
                int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
                i2 = childMeasureSpec;
                i3 = childMeasureSpec2;
            }
            measureChildWithDecorationsAndMargin(view2, i3, i2, z);
        }
    }

    private void measureChildWithDecorationsAndMargin(View view2, int i, int i2, boolean z) {
        boolean shouldMeasureChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
            if (z) {
                shouldMeasureChild = shouldReMeasureChild(view2, i, i2, layoutParams);
            } else {
                shouldMeasureChild = shouldMeasureChild(view2, i, i2, layoutParams);
            }
            if (shouldMeasureChild) {
                view2.measure(i, i2);
            }
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (getOrientation() == 1) {
                height = getWidth() - getPaddingRight();
                paddingTop = getPaddingLeft();
            } else {
                height = getHeight() - getPaddingBottom();
                paddingTop = getPaddingTop();
            }
            calculateItemBorders(height - paddingTop);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state, layoutState, layoutPrefetchRegistry) == null) {
            int i = this.mSpanCount;
            for (int i2 = 0; i2 < this.mSpanCount && layoutState.hasMore(state) && i > 0; i2++) {
                int i3 = layoutState.mCurrentPosition;
                layoutPrefetchRegistry.addPosition(i3, Math.max(0, layoutState.mScrollingOffset));
                i -= this.mSpanSizeLookup.getSpanSize(i3);
                layoutState.mCurrentPosition += layoutState.mItemDirection;
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, state)) == null) {
            if (this.mUsingSpansToEstimateScrollBarDimensions) {
                return computeScrollOffsetWithSpanInfo(state);
            }
            return super.computeHorizontalScrollOffset(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, state)) == null) {
            if (this.mUsingSpansToEstimateScrollBarDimensions) {
                return computeScrollRangeWithSpanInfo(state);
            }
            return super.computeHorizontalScrollRange(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, state)) == null) {
            if (this.mUsingSpansToEstimateScrollBarDimensions) {
                return computeScrollOffsetWithSpanInfo(state);
            }
            return super.computeVerticalScrollOffset(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, state)) == null) {
            if (this.mUsingSpansToEstimateScrollBarDimensions) {
                return computeScrollRangeWithSpanInfo(state);
            }
            return super.computeVerticalScrollRange(state);
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{recycler, state, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            ensureLayoutState();
            int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
            int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
            int i4 = i2 > i ? 1 : -1;
            View view2 = null;
            View view3 = null;
            while (i != i2) {
                View childAt = getChildAt(i);
                int position = getPosition(childAt);
                if (position >= 0 && position < i3 && getSpanIndex(recycler, state, position) == 0) {
                    if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                        if (view3 == null) {
                            view3 = childAt;
                        }
                    } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    } else {
                        if (view2 == null) {
                            view2 = childAt;
                        }
                    }
                }
                i += i4;
            }
            return view2 != null ? view2 : view3;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mOrientation == 0) {
                return new LayoutParams(-2, -1);
            }
            return new LayoutParams(-1, -2);
        }
        return (RecyclerView.LayoutParams) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, attributeSet)) == null) ? new LayoutParams(context, attributeSet) : (RecyclerView.LayoutParams) invokeLL.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, recycler, state)) == null) {
            if (this.mOrientation == 1) {
                return this.mSpanCount;
            }
            if (state.getItemCount() < 1) {
                return 0;
            }
            return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
        }
        return invokeLL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, recycler, state)) == null) {
            if (this.mOrientation == 0) {
                return this.mSpanCount;
            }
            if (state.getItemCount() < 1) {
                return 0;
            }
            return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
        }
        return invokeLL.intValue;
    }

    public int getSpaceForSpanRange(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i, i2)) == null) {
            if (this.mOrientation == 1 && isLayoutRTL()) {
                int[] iArr = this.mCachedBorders;
                int i3 = this.mSpanCount;
                return iArr[i3 - i] - iArr[(i3 - i) - i2];
            }
            int[] iArr2 = this.mCachedBorders;
            return iArr2[i2 + i] - iArr2[i];
        }
        return invokeII.intValue;
    }

    public int getSpanCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mSpanCount : invokeV.intValue;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mSpanSizeLookup : (SpanSizeLookup) invokeV.objValue;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mUsingSpansToEstimateScrollBarDimensions : invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: androidx.recyclerview.widget.GridLayoutManager */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a3, code lost:
        r21.mFinished = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a5, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int decoratedMeasurementInOther;
        int i7;
        int childMeasureSpec;
        int i8;
        View next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, recycler, state, layoutState, layoutChunkResult) == null) {
            int modeInOther = this.mOrientationHelper.getModeInOther();
            ?? r5 = 0;
            boolean z = modeInOther != 1073741824;
            int i9 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
            if (z) {
                updateMeasurements();
            }
            boolean z2 = layoutState.mItemDirection == 1;
            int i10 = this.mSpanCount;
            if (!z2) {
                i10 = getSpanIndex(recycler, state, layoutState.mCurrentPosition) + getSpanSize(recycler, state, layoutState.mCurrentPosition);
            }
            int i11 = 0;
            while (i11 < this.mSpanCount && layoutState.hasMore(state) && i10 > 0) {
                int i12 = layoutState.mCurrentPosition;
                int spanSize = getSpanSize(recycler, state, i12);
                if (spanSize > this.mSpanCount) {
                    throw new IllegalArgumentException("Item at position " + i12 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
                }
                i10 -= spanSize;
                if (i10 < 0 || (next = layoutState.next(recycler)) == null) {
                    break;
                }
                this.mSet[i11] = next;
                i11++;
            }
            float f = 0.0f;
            assignSpans(recycler, state, i11, z2);
            int i13 = 0;
            int i14 = 0;
            while (i13 < i11) {
                View view2 = this.mSet[i13];
                if (layoutState.mScrapList == null) {
                    if (z2) {
                        addView(view2);
                    } else {
                        addView(view2, r5);
                    }
                } else if (z2) {
                    addDisappearingView(view2);
                } else {
                    addDisappearingView(view2, r5);
                }
                calculateItemDecorationsForChild(view2, this.mDecorInsets);
                measureChild(view2, modeInOther, (boolean) r5);
                int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement > i14) {
                    i14 = decoratedMeasurement;
                }
                float decoratedMeasurementInOther2 = (this.mOrientationHelper.getDecoratedMeasurementInOther(view2) * 1.0f) / ((LayoutParams) view2.getLayoutParams()).mSpanSize;
                if (decoratedMeasurementInOther2 > f) {
                    f = decoratedMeasurementInOther2;
                }
                i13++;
                r5 = 0;
            }
            if (z) {
                guessMeasurement(f, i9);
                i14 = 0;
                for (int i15 = 0; i15 < i11; i15++) {
                    View view3 = this.mSet[i15];
                    measureChild(view3, 1073741824, true);
                    int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view3);
                    if (decoratedMeasurement2 > i14) {
                        i14 = decoratedMeasurement2;
                    }
                }
            }
            for (int i16 = 0; i16 < i11; i16++) {
                View view4 = this.mSet[i16];
                if (this.mOrientationHelper.getDecoratedMeasurement(view4) != i14) {
                    LayoutParams layoutParams = (LayoutParams) view4.getLayoutParams();
                    Rect rect = layoutParams.mDecorInsets;
                    int i17 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    int i18 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                    if (this.mOrientation == 1) {
                        i8 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i18, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                        childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14 - i17, 1073741824);
                    } else {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14 - i18, 1073741824);
                        childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i17, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                        i8 = makeMeasureSpec;
                    }
                    measureChildWithDecorationsAndMargin(view4, i8, childMeasureSpec, true);
                }
            }
            int i19 = 0;
            layoutChunkResult.mConsumed = i14;
            if (this.mOrientation == 1) {
                if (layoutState.mLayoutDirection == -1) {
                    i3 = layoutState.mOffset;
                    i4 = i3 - i14;
                } else {
                    int i20 = layoutState.mOffset;
                    i4 = i20;
                    i3 = i14 + i20;
                }
                i = 0;
                i2 = 0;
            } else if (layoutState.mLayoutDirection == -1) {
                int i21 = layoutState.mOffset;
                i2 = i21 - i14;
                i4 = 0;
                i = i21;
                i3 = 0;
            } else {
                int i22 = layoutState.mOffset;
                i = i14 + i22;
                i2 = i22;
                i3 = 0;
                i4 = 0;
            }
            while (i19 < i11) {
                View view5 = this.mSet[i19];
                LayoutParams layoutParams2 = (LayoutParams) view5.getLayoutParams();
                if (this.mOrientation == 1) {
                    if (isLayoutRTL()) {
                        int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.mSpanIndex];
                        i2 = paddingLeft - this.mOrientationHelper.getDecoratedMeasurementInOther(view5);
                        decoratedMeasurementInOther = i3;
                        i6 = paddingLeft;
                        i5 = i4;
                    } else {
                        int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[layoutParams2.mSpanIndex];
                        decoratedMeasurementInOther = i3;
                        i7 = paddingLeft2;
                        i5 = i4;
                        i6 = this.mOrientationHelper.getDecoratedMeasurementInOther(view5) + paddingLeft2;
                        layoutDecoratedWithMargins(view5, i7, i5, i6, decoratedMeasurementInOther);
                        if (!layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                            layoutChunkResult.mIgnoreConsumed = true;
                        }
                        layoutChunkResult.mFocusable |= view5.hasFocusable();
                        i19++;
                        i3 = decoratedMeasurementInOther;
                        i = i6;
                        i4 = i5;
                        i2 = i7;
                    }
                } else {
                    int paddingTop = getPaddingTop() + this.mCachedBorders[layoutParams2.mSpanIndex];
                    i5 = paddingTop;
                    i6 = i;
                    decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(view5) + paddingTop;
                }
                i7 = i2;
                layoutDecoratedWithMargins(view5, i7, i5, i6, decoratedMeasurementInOther);
                if (!layoutParams2.isItemRemoved()) {
                }
                layoutChunkResult.mIgnoreConsumed = true;
                layoutChunkResult.mFocusable |= view5.hasFocusable();
                i19++;
                i3 = decoratedMeasurementInOther;
                i = i6;
                i4 = i5;
                i2 = i7;
            }
            Arrays.fill(this.mSet, (Object) null);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048593, this, recycler, state, anchorInfo, i) == null) {
            super.onAnchorReady(recycler, state, anchorInfo, i);
            updateMeasurements();
            if (state.getItemCount() > 0 && !state.isPreLayout()) {
                ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i);
            }
            ensureViewSet();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00da, code lost:
        if (r13 == (r2 > r15)) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00fa, code lost:
        if (r13 == (r2 > r7)) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:81:0x010b  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFocusSearchFailed(View view2, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeLILL;
        int childCount;
        int i2;
        int i3;
        View view3;
        View view4;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048594, this, view2, i, recycler, state)) == null) {
            RecyclerView.Recycler recycler2 = recycler;
            RecyclerView.State state2 = state;
            View findContainingItemView = findContainingItemView(view2);
            View view5 = null;
            if (findContainingItemView == null) {
                return null;
            }
            LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
            int i8 = layoutParams.mSpanIndex;
            int i9 = layoutParams.mSpanSize + i8;
            if (super.onFocusSearchFailed(view2, i, recycler, state) == null) {
                return null;
            }
            if ((convertFocusDirectionToLayoutDirection(i) == 1) != this.mShouldReverseLayout) {
                i2 = getChildCount() - 1;
                childCount = -1;
                i3 = -1;
            } else {
                childCount = getChildCount();
                i2 = 0;
                i3 = 1;
            }
            boolean z2 = this.mOrientation == 1 && isLayoutRTL();
            int spanGroupIndex = getSpanGroupIndex(recycler2, state2, i2);
            int i10 = i2;
            int i11 = 0;
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            View view6 = null;
            while (i10 != childCount) {
                int spanGroupIndex2 = getSpanGroupIndex(recycler2, state2, i10);
                View childAt = getChildAt(i10);
                if (childAt == findContainingItemView) {
                    break;
                }
                if (!childAt.hasFocusable() || spanGroupIndex2 == spanGroupIndex) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    int i15 = layoutParams2.mSpanIndex;
                    view3 = findContainingItemView;
                    int i16 = layoutParams2.mSpanSize + i15;
                    if (childAt.hasFocusable() && i15 == i8 && i16 == i9) {
                        return childAt;
                    }
                    if (!(childAt.hasFocusable() && view5 == null) && (childAt.hasFocusable() || view6 != null)) {
                        view4 = view6;
                        int min = Math.min(i16, i9) - Math.max(i15, i8);
                        if (childAt.hasFocusable()) {
                            if (min <= i11) {
                                if (min == i11) {
                                }
                            }
                        } else if (view5 == null) {
                            i4 = i11;
                            i5 = childCount;
                            if (isViewPartiallyVisible(childAt, false, true)) {
                                i6 = i14;
                                if (min > i6) {
                                    i7 = i13;
                                    if (z) {
                                        if (childAt.hasFocusable()) {
                                            i12 = layoutParams2.mSpanIndex;
                                            i13 = i7;
                                            i14 = i6;
                                            view6 = view4;
                                            view5 = childAt;
                                            i11 = Math.min(i16, i9) - Math.max(i15, i8);
                                        } else {
                                            int i17 = layoutParams2.mSpanIndex;
                                            i14 = Math.min(i16, i9) - Math.max(i15, i8);
                                            i13 = i17;
                                            i11 = i4;
                                            view6 = childAt;
                                        }
                                        i10 += i3;
                                        recycler2 = recycler;
                                        state2 = state;
                                        findContainingItemView = view3;
                                        childCount = i5;
                                    }
                                } else {
                                    if (min == i6) {
                                        i7 = i13;
                                    } else {
                                        i7 = i13;
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                            }
                            i7 = i13;
                            i6 = i14;
                            z = false;
                            if (z) {
                            }
                        }
                        i4 = i11;
                        i5 = childCount;
                        i7 = i13;
                        i6 = i14;
                        z = false;
                        if (z) {
                        }
                    } else {
                        view4 = view6;
                    }
                    i4 = i11;
                    i5 = childCount;
                    i7 = i13;
                    i6 = i14;
                    z = true;
                    if (z) {
                    }
                } else if (view5 != null) {
                    break;
                } else {
                    view3 = findContainingItemView;
                    view4 = view6;
                    i4 = i11;
                    i5 = childCount;
                    i7 = i13;
                    i6 = i14;
                }
                i13 = i7;
                i14 = i6;
                i11 = i4;
                view6 = view4;
                i10 += i3;
                recycler2 = recycler;
                state2 = state;
                findContainingItemView = view3;
                childCount = i5;
            }
            return view5 != null ? view5 : view6;
        }
        return (View) invokeLILL.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048595, this, recycler, state, view2, accessibilityNodeInfoCompat) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (!(layoutParams instanceof LayoutParams)) {
                super.onInitializeAccessibilityNodeInfoForItem(view2, accessibilityNodeInfoCompat);
                return;
            }
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
            if (this.mOrientation == 0) {
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), spanGroupIndex, 1, false, false));
            } else {
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048596, this, recyclerView, i, i2) == null) {
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, recyclerView) == null) {
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048598, this, recyclerView, i, i2, i3) == null) {
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048599, this, recyclerView, i, i2) == null) {
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{recyclerView, Integer.valueOf(i), Integer.valueOf(i2), obj}) == null) {
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, recycler, state) == null) {
            if (state.isPreLayout()) {
                cachePreLayoutSpanMapping();
            }
            super.onLayoutChildren(recycler, state);
            clearPreLayoutSpanMappingCache();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, state) == null) {
            super.onLayoutCompleted(state);
            this.mPendingSpanCountChange = false;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048603, this, i, recycler, state)) == null) {
            updateMeasurements();
            ensureViewSet();
            return super.scrollHorizontallyBy(i, recycler, state);
        }
        return invokeILL.intValue;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048604, this, i, recycler, state)) == null) {
            updateMeasurements();
            ensureViewSet();
            return super.scrollVerticallyBy(i, recycler, state);
        }
        return invokeILL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048605, this, rect, i, i2) == null) {
            if (this.mCachedBorders == null) {
                super.setMeasuredDimension(rect, i, i2);
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.mOrientation == 1) {
                chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
                int[] iArr = this.mCachedBorders;
                chooseSize = RecyclerView.LayoutManager.chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
            } else {
                chooseSize = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
                int[] iArr2 = this.mCachedBorders;
                chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
            }
            setMeasuredDimension(chooseSize, chooseSize2);
        }
    }

    public void setSpanCount(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048606, this, i) == null) || i == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i >= 1) {
            this.mSpanCount = i;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, spanSizeLookup) == null) {
            this.mSpanSizeLookup = spanSizeLookup;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            if (!z) {
                super.setStackFromEnd(false);
                return;
            }
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.mUsingSpansToEstimateScrollBarDimensions = z;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mPendingSavedState == null && !this.mPendingSpanCountChange : invokeV.booleanValue;
    }

    public static int[] calculateItemBorders(int[] iArr, int i, int i2) {
        InterceptResult invokeLII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, iArr, i, i2)) == null) {
            if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
                iArr = new int[i + 1];
            }
            int i4 = 0;
            iArr[0] = 0;
            int i5 = i2 / i;
            int i6 = i2 % i;
            int i7 = 0;
            for (int i8 = 1; i8 <= i; i8++) {
                i4 += i6;
                if (i4 <= 0 || i - i4 >= i6) {
                    i3 = i5;
                } else {
                    i3 = i5 + 1;
                    i4 -= i;
                }
                i7 += i3;
                iArr[i8] = i7;
            }
            return iArr;
        }
        return (int[]) invokeLII.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, layoutParams)) == null) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }
        return (RecyclerView.LayoutParams) invokeL.objValue;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_SPAN_ID = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public int mSpanIndex;
        public int mSpanSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSpanIndex : invokeV.intValue;
        }

        public int getSpanSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSpanSize : invokeV.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((RecyclerView.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLayoutManager(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(i);
    }
}
