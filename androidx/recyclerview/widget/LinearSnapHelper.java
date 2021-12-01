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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            View view = null;
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = layoutManager.getChildAt(i4);
                int position = layoutManager.getPosition(childAt);
                if (position != -1) {
                    if (position < i2) {
                        view = childAt;
                        i2 = position;
                    }
                    if (position > i3) {
                        view2 = childAt;
                        i3 = position;
                    }
                }
            }
            if (view == null || view2 == null) {
                return 1.0f;
            }
            int max = Math.max(orientationHelper.getDecoratedEnd(view), orientationHelper.getDecoratedEnd(view2)) - Math.min(orientationHelper.getDecoratedStart(view), orientationHelper.getDecoratedStart(view2));
            if (max == 0) {
                return 1.0f;
            }
            return (max * 1.0f) / ((i3 - i2) + 1);
        }
        return invokeLL.floatValue;
    }

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, layoutManager, view, orientationHelper)) == null) ? (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2)) : invokeLLL.intValue;
    }

    private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, this, layoutManager, orientationHelper, i2, i3)) == null) {
            int[] calculateScrollDistance = calculateScrollDistance(i2, i3);
            float computeDistancePerChild = computeDistancePerChild(layoutManager, orientationHelper);
            if (computeDistancePerChild <= 0.0f) {
                return 0;
            }
            return Math.round((Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1]) ? calculateScrollDistance[0] : calculateScrollDistance[1]) / computeDistancePerChild);
        }
        return invokeLLII.intValue;
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, layoutManager, orientationHelper)) == null) {
            int childCount = layoutManager.getChildCount();
            View view = null;
            if (childCount == 0) {
                return null;
            }
            int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = layoutManager.getChildAt(i3);
                int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
                if (abs < i2) {
                    view = childAt;
                    i2 = abs;
                }
            }
            return view;
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
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutManager, view)) == null) {
            int[] iArr = new int[2];
            if (layoutManager.canScrollHorizontally()) {
                iArr[0] = distanceToCenter(layoutManager, view, getHorizontalHelper(layoutManager));
            } else {
                iArr[0] = 0;
            }
            if (layoutManager.canScrollVertically()) {
                iArr[1] = distanceToCenter(layoutManager, view, getVerticalHelper(layoutManager));
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
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        InterceptResult invokeLII;
        int itemCount;
        View findSnapView;
        int position;
        int i4;
        PointF computeScrollVectorForPosition;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, layoutManager, i2, i3)) == null) {
            if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (itemCount = layoutManager.getItemCount()) == 0 || (findSnapView = findSnapView(layoutManager)) == null || (position = layoutManager.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
                return -1;
            }
            if (layoutManager.canScrollHorizontally()) {
                i5 = estimateNextPositionDiffForFling(layoutManager, getHorizontalHelper(layoutManager), i2, 0);
                if (computeScrollVectorForPosition.x < 0.0f) {
                    i5 = -i5;
                }
            } else {
                i5 = 0;
            }
            if (layoutManager.canScrollVertically()) {
                i6 = estimateNextPositionDiffForFling(layoutManager, getVerticalHelper(layoutManager), 0, i3);
                if (computeScrollVectorForPosition.y < 0.0f) {
                    i6 = -i6;
                }
            } else {
                i6 = 0;
            }
            if (layoutManager.canScrollVertically()) {
                i5 = i6;
            }
            if (i5 == 0) {
                return -1;
            }
            int i7 = position + i5;
            int i8 = i7 >= 0 ? i7 : 0;
            return i8 >= itemCount ? i4 : i8;
        }
        return invokeLII.intValue;
    }
}
