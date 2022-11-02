package androidx.recyclerview.widget;

import android.graphics.PointF;
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
public class LinearSnapHelper extends SnapHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float INVALID_DISTANCE = 1.0f;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public OrientationHelper mHorizontalHelper;
    @Nullable
    public OrientationHelper mVerticalHelper;

    public LinearSnapHelper() {
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

    private float computeDistancePerChild(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, layoutManager, orientationHelper)) == null) {
            int childCount = layoutManager.getChildCount();
            if (childCount == 0) {
                return 1.0f;
            }
            View view2 = null;
            View view3 = null;
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MIN_VALUE;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = layoutManager.getChildAt(i3);
                int position = layoutManager.getPosition(childAt);
                if (position != -1) {
                    if (position < i) {
                        view2 = childAt;
                        i = position;
                    }
                    if (position > i2) {
                        view3 = childAt;
                        i2 = position;
                    }
                }
            }
            if (view2 == null || view3 == null) {
                return 1.0f;
            }
            int max = Math.max(orientationHelper.getDecoratedEnd(view2), orientationHelper.getDecoratedEnd(view3)) - Math.min(orientationHelper.getDecoratedStart(view2), orientationHelper.getDecoratedStart(view3));
            if (max == 0) {
                return 1.0f;
            }
            return (max * 1.0f) / ((i2 - i) + 1);
        }
        return invokeLL.floatValue;
    }

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2, OrientationHelper orientationHelper) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, layoutManager, view2, orientationHelper)) == null) {
            return (orientationHelper.getDecoratedStart(view2) + (orientationHelper.getDecoratedMeasurement(view2) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
        }
        return invokeLLL.intValue;
    }

    private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2) {
        InterceptResult invokeLLII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, this, layoutManager, orientationHelper, i, i2)) == null) {
            int[] calculateScrollDistance = calculateScrollDistance(i, i2);
            float computeDistancePerChild = computeDistancePerChild(layoutManager, orientationHelper);
            if (computeDistancePerChild <= 0.0f) {
                return 0;
            }
            if (Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1])) {
                i3 = calculateScrollDistance[0];
            } else {
                i3 = calculateScrollDistance[1];
            }
            return Math.round(i3 / computeDistancePerChild);
        }
        return invokeLLII.intValue;
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, layoutManager, orientationHelper)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, layoutManager)) == null) {
            OrientationHelper orientationHelper = this.mHorizontalHelper;
            if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
                this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
            }
            return this.mHorizontalHelper;
        }
        return (OrientationHelper) invokeL.objValue;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, layoutManager)) == null) {
            OrientationHelper orientationHelper = this.mVerticalHelper;
            if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
                this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
            }
            return this.mVerticalHelper;
        }
        return (OrientationHelper) invokeL.objValue;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
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
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutManager)) == null) {
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
        int itemCount;
        View findSnapView;
        int position;
        int i3;
        PointF computeScrollVectorForPosition;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, layoutManager, i, i2)) == null) {
            if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (itemCount = layoutManager.getItemCount()) == 0 || (findSnapView = findSnapView(layoutManager)) == null || (position = layoutManager.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
                return -1;
            }
            int i6 = 0;
            if (layoutManager.canScrollHorizontally()) {
                i4 = estimateNextPositionDiffForFling(layoutManager, getHorizontalHelper(layoutManager), i, 0);
                if (computeScrollVectorForPosition.x < 0.0f) {
                    i4 = -i4;
                }
            } else {
                i4 = 0;
            }
            if (layoutManager.canScrollVertically()) {
                i5 = estimateNextPositionDiffForFling(layoutManager, getVerticalHelper(layoutManager), 0, i2);
                if (computeScrollVectorForPosition.y < 0.0f) {
                    i5 = -i5;
                }
            } else {
                i5 = 0;
            }
            if (layoutManager.canScrollVertically()) {
                i4 = i5;
            }
            if (i4 == 0) {
                return -1;
            }
            int i7 = position + i4;
            if (i7 >= 0) {
                i6 = i7;
            }
            if (i6 < itemCount) {
                return i6;
            }
            return i3;
        }
        return invokeLII.intValue;
    }
}
