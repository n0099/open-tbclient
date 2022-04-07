package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PagerSnapHelper extends SnapHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public OrientationHelper mHorizontalHelper;
    @Nullable
    public OrientationHelper mVerticalHelper;

    public PagerSnapHelper() {
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

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2, OrientationHelper orientationHelper) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, layoutManager, view2, orientationHelper)) == null) ? (orientationHelper.getDecoratedStart(view2) + (orientationHelper.getDecoratedMeasurement(view2) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2)) : invokeLLL.intValue;
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, layoutManager, orientationHelper)) == null) {
            int childCount = layoutManager.getChildCount();
            View view2 = null;
            if (childCount == 0) {
                return null;
            }
            int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = layoutManager.getChildAt(i2);
                int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
                if (abs < i) {
                    view2 = childAt;
                    i = abs;
                }
            }
            return view2;
        }
        return (View) invokeLL.objValue;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, layoutManager)) == null) {
            OrientationHelper orientationHelper = this.mHorizontalHelper;
            if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
                this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
            }
            return this.mHorizontalHelper;
        }
        return (OrientationHelper) invokeL.objValue;
    }

    @Nullable
    private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, layoutManager)) == null) {
            if (layoutManager.canScrollVertically()) {
                return getVerticalHelper(layoutManager);
            }
            if (layoutManager.canScrollHorizontally()) {
                return getHorizontalHelper(layoutManager);
            }
            return null;
        }
        return (OrientationHelper) invokeL.objValue;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, layoutManager)) == null) {
            OrientationHelper orientationHelper = this.mVerticalHelper;
            if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
                this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
            }
            return this.mVerticalHelper;
        }
        return (OrientationHelper) invokeL.objValue;
    }

    private boolean isForwardFling(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65542, this, layoutManager, i, i2)) == null) ? layoutManager.canScrollHorizontally() ? i > 0 : i2 > 0 : invokeLII.booleanValue;
    }

    private boolean isReverseLayout(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        PointF computeScrollVectorForPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, layoutManager)) == null) {
            int itemCount = layoutManager.getItemCount();
            if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
                return false;
            }
            return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutManager, view2)) == null) {
            int[] iArr = new int[2];
            if (layoutManager.canScrollHorizontally()) {
                iArr[0] = distanceToCenter(layoutManager, view2, getHorizontalHelper(layoutManager));
            } else {
                iArr[0] = 0;
            }
            if (layoutManager.canScrollVertically()) {
                iArr[1] = distanceToCenter(layoutManager, view2, getVerticalHelper(layoutManager));
            } else {
                iArr[1] = 0;
            }
            return iArr;
        }
        return (int[]) invokeLL.objValue;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutManager)) == null) {
            if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
                return new LinearSmoothScroller(this, this.mRecyclerView.getContext()) { // from class: androidx.recyclerview.widget.PagerSnapHelper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PagerSnapHelper this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super((Context) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, displayMetrics)) == null) ? 100.0f / displayMetrics.densityDpi : invokeL2.floatValue;
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateTimeForScrolling(int i) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? Math.min(100, super.calculateTimeForScrolling(i)) : invokeI.intValue;
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                    public void onTargetFound(View view2, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view2, state, action) == null) {
                            PagerSnapHelper pagerSnapHelper = this.this$0;
                            int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.mRecyclerView.getLayoutManager(), view2);
                            int i = calculateDistanceToFinalSnap[0];
                            int i2 = calculateDistanceToFinalSnap[1];
                            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                            if (calculateTimeForDeceleration > 0) {
                                action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                            }
                        }
                    }
                };
            }
            return null;
        }
        return (LinearSmoothScroller) invokeL.objValue;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutManager)) == null) {
            if (layoutManager.canScrollVertically()) {
                return findCenterView(layoutManager, getVerticalHelper(layoutManager));
            }
            if (layoutManager.canScrollHorizontally()) {
                return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        InterceptResult invokeLII;
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, layoutManager, i, i2)) == null) {
            int itemCount = layoutManager.getItemCount();
            if (itemCount == 0 || (orientationHelper = getOrientationHelper(layoutManager)) == null) {
                return -1;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int childCount = layoutManager.getChildCount();
            View view2 = null;
            View view3 = null;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = layoutManager.getChildAt(i5);
                if (childAt != null) {
                    int distanceToCenter = distanceToCenter(layoutManager, childAt, orientationHelper);
                    if (distanceToCenter <= 0 && distanceToCenter > i3) {
                        view3 = childAt;
                        i3 = distanceToCenter;
                    }
                    if (distanceToCenter >= 0 && distanceToCenter < i4) {
                        view2 = childAt;
                        i4 = distanceToCenter;
                    }
                }
            }
            boolean isForwardFling = isForwardFling(layoutManager, i, i2);
            if (!isForwardFling || view2 == null) {
                if (isForwardFling || view3 == null) {
                    if (isForwardFling) {
                        view2 = view3;
                    }
                    if (view2 == null) {
                        return -1;
                    }
                    int position = layoutManager.getPosition(view2) + (isReverseLayout(layoutManager) == isForwardFling ? -1 : 1);
                    if (position < 0 || position >= itemCount) {
                        return -1;
                    }
                    return position;
                }
                return layoutManager.getPosition(view3);
            }
            return layoutManager.getPosition(view2);
        }
        return invokeLII.intValue;
    }
}
