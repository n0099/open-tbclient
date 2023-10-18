package com.baidu.mobads.sdk.internal.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PagerSnapHelper extends SnapHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 100;
    public static final float b = 100.0f;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public OrientationHelper c;
    @Nullable
    public RecyclerView.LayoutManager d;
    @Nullable
    public OrientationHelper e;
    @Nullable
    public RecyclerView.LayoutManager f;
    public RecyclerView h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-136214785, "Lcom/baidu/mobads/sdk/internal/widget/PagerSnapHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-136214785, "Lcom/baidu/mobads/sdk/internal/widget/PagerSnapHelper;");
                return;
            }
        }
        g = ar.a((Class<?>) OrientationHelper.class, "getLayoutManager", (Class<?>[]) new Class[0]);
    }

    public PagerSnapHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private int a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2, OrientationHelper orientationHelper) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, layoutManager, view2, orientationHelper)) == null) {
            return (orientationHelper.getDecoratedStart(view2) + (orientationHelper.getDecoratedMeasurement(view2) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
        }
        return invokeLLL.intValue;
    }

    @Nullable
    private View a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, layoutManager, orientationHelper)) == null) {
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

    @Nullable
    private OrientationHelper b(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, layoutManager)) == null) {
            if (layoutManager.canScrollVertically()) {
                return c(layoutManager);
            }
            if (layoutManager.canScrollHorizontally()) {
                return d(layoutManager);
            }
            return null;
        }
        return (OrientationHelper) invokeL.objValue;
    }

    @NonNull
    private OrientationHelper c(@NonNull RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, layoutManager)) == null) {
            if (this.c == null || this.d != layoutManager) {
                this.d = layoutManager;
                this.c = OrientationHelper.createVerticalHelper(layoutManager);
            }
            return this.c;
        }
        return (OrientationHelper) invokeL.objValue;
    }

    @NonNull
    private OrientationHelper d(@NonNull RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, layoutManager)) == null) {
            if (this.e == null || this.f != layoutManager) {
                this.f = layoutManager;
                this.e = OrientationHelper.createHorizontalHelper(layoutManager);
            }
            return this.e;
        }
        return (OrientationHelper) invokeL.objValue;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) {
            super.attachToRecyclerView(recyclerView);
            if (this.h == recyclerView) {
                return;
            }
            this.h = recyclerView;
        }
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutManager)) == null) {
            if ((layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (recyclerView = this.h) != null) {
                return new LinearSmoothScroller(this, recyclerView.getContext()) { // from class: com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PagerSnapHelper a;

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
                        this.a = this;
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, displayMetrics)) == null) {
                            return 100.0f / displayMetrics.densityDpi;
                        }
                        return invokeL2.floatValue;
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateTimeForScrolling(int i) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                            return Math.min(100, super.calculateTimeForScrolling(i));
                        }
                        return invokeI.intValue;
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                    public void onStop() {
                        RecyclerView.LayoutManager layoutManager2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            super.onStop();
                            if (PagerSnapHelper.g && this.a.h != null && this.a.h.getScrollState() != 0 && (layoutManager2 = this.a.h.getLayoutManager()) != null && layoutManager2.getChildCount() <= 1) {
                                this.a.h.stopScroll();
                            }
                        }
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                    public void onTargetFound(View view2, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLLL(1048579, this, view2, state, action) == null) && this.a.h != null && this.a.h.getLayoutManager() != null) {
                            PagerSnapHelper pagerSnapHelper = this.a;
                            int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.h.getLayoutManager(), view2);
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

    private boolean a(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        PointF computeScrollVectorForPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, layoutManager)) == null) {
            int itemCount = layoutManager.getItemCount();
            if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
                return false;
            }
            if (computeScrollVectorForPosition.x >= 0.0f && computeScrollVectorForPosition.y >= 0.0f) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutManager)) == null) {
            if (layoutManager.canScrollVertically()) {
                return a(layoutManager, c(layoutManager));
            }
            if (layoutManager.canScrollHorizontally()) {
                return a(layoutManager, d(layoutManager));
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    private boolean a(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, this, layoutManager, i, i2)) == null) {
            if (layoutManager.canScrollHorizontally()) {
                if (i > 0) {
                    return true;
                }
                return false;
            } else if (i2 > 0) {
                return true;
            } else {
                return false;
            }
        }
        return invokeLII.booleanValue;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutManager, view2)) == null) {
            int[] iArr = new int[2];
            if (layoutManager.canScrollHorizontally()) {
                iArr[0] = a(layoutManager, view2, d(layoutManager));
            } else {
                iArr[0] = 0;
            }
            if (layoutManager.canScrollVertically()) {
                iArr[1] = a(layoutManager, view2, c(layoutManager));
            } else {
                iArr[1] = 0;
            }
            return iArr;
        }
        return (int[]) invokeLL.objValue;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        InterceptResult invokeLII;
        OrientationHelper b2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, layoutManager, i, i2)) == null) {
            int itemCount = layoutManager.getItemCount();
            if (itemCount == 0 || (b2 = b(layoutManager)) == null) {
                return -1;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int childCount = layoutManager.getChildCount();
            View view2 = null;
            View view3 = null;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = layoutManager.getChildAt(i6);
                if (childAt != null) {
                    int a2 = a(layoutManager, childAt, b2);
                    if (a2 <= 0 && a2 > i4) {
                        view3 = childAt;
                        i4 = a2;
                    }
                    if (a2 >= 0 && a2 < i5) {
                        view2 = childAt;
                        i5 = a2;
                    }
                }
            }
            boolean a3 = a(layoutManager, i, i2);
            if (a3 && view2 != null) {
                return layoutManager.getPosition(view2);
            }
            if (!a3 && view3 != null) {
                return layoutManager.getPosition(view3);
            }
            if (a3) {
                view2 = view3;
            }
            if (view2 == null) {
                return -1;
            }
            int position = layoutManager.getPosition(view2);
            if (a(layoutManager) == a3) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            int i7 = position + i3;
            if (i7 < 0 || i7 >= itemCount) {
                return -1;
            }
            return i7;
        }
        return invokeLII.intValue;
    }
}
