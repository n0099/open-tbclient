package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class LinearSmoothScroller extends RecyclerView.SmoothScroller {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    public static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    public static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public final DecelerateInterpolator mDecelerateInterpolator;
    public final DisplayMetrics mDisplayMetrics;
    public boolean mHasCalculatedMillisPerPixel;
    public int mInterimTargetDx;
    public int mInterimTargetDy;
    public final LinearInterpolator mLinearInterpolator;
    public float mMillisPerPixel;
    public PointF mTargetVector;

    public LinearSmoothScroller(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLinearInterpolator = new LinearInterpolator();
        this.mDecelerateInterpolator = new DecelerateInterpolator();
        this.mHasCalculatedMillisPerPixel = false;
        this.mInterimTargetDx = 0;
        this.mInterimTargetDy = 0;
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    private int clampApplyScroll(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i, i2)) == null) {
            int i3 = i - i2;
            if (i * i3 <= 0) {
                return 0;
            }
            return i3;
        }
        return invokeII.intValue;
    }

    private float getSpeedPerPixel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (!this.mHasCalculatedMillisPerPixel) {
                this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
                this.mHasCalculatedMillisPerPixel = true;
            }
            return this.mMillisPerPixel;
        }
        return invokeV.floatValue;
    }

    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i5 != -1) {
                if (i5 != 0) {
                    if (i5 == 1) {
                        return i4 - i2;
                    }
                    throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
                }
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                int i7 = i4 - i2;
                if (i7 < 0) {
                    return i7;
                }
                return 0;
            }
            return i3 - i;
        }
        return invokeCommon.intValue;
    }

    public int calculateDxToMakeVisible(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i)) == null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
                return 0;
            }
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedLeft(view2) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutManager.getDecoratedRight(view2) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i);
        }
        return invokeLI.intValue;
    }

    public int calculateDyToMakeVisible(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i)) == null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null || !layoutManager.canScrollVertically()) {
                return 0;
            }
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedTop(view2) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutManager.getDecoratedBottom(view2) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i);
        }
        return invokeLI.intValue;
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, displayMetrics)) == null) ? 25.0f / displayMetrics.densityDpi : invokeL.floatValue;
    }

    public int calculateTimeForDeceleration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? (int) Math.ceil(calculateTimeForScrolling(i) / 0.3356d) : invokeI.intValue;
    }

    public int calculateTimeForScrolling(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? (int) Math.ceil(Math.abs(i) * getSpeedPerPixel()) : invokeI.intValue;
    }

    public int getHorizontalSnapPreference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PointF pointF = this.mTargetVector;
            if (pointF != null) {
                float f = pointF.x;
                if (f != 0.0f) {
                    return f > 0.0f ? 1 : -1;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVerticalSnapPreference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PointF pointF = this.mTargetVector;
            if (pointF != null) {
                float f = pointF.y;
                if (f != 0.0f) {
                    return f > 0.0f ? 1 : -1;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onSeekTargetStep(int i, int i2, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), state, action}) == null) {
            if (getChildCount() == 0) {
                stop();
                return;
            }
            this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, i);
            int clampApplyScroll = clampApplyScroll(this.mInterimTargetDy, i2);
            this.mInterimTargetDy = clampApplyScroll;
            if (this.mInterimTargetDx == 0 && clampApplyScroll == 0) {
                updateActionForInterimTarget(action);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mInterimTargetDy = 0;
            this.mInterimTargetDx = 0;
            this.mTargetVector = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onTargetFound(View view2, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, view2, state, action) == null) {
            int calculateDxToMakeVisible = calculateDxToMakeVisible(view2, getHorizontalSnapPreference());
            int calculateDyToMakeVisible = calculateDyToMakeVisible(view2, getVerticalSnapPreference());
            int calculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((calculateDxToMakeVisible * calculateDxToMakeVisible) + (calculateDyToMakeVisible * calculateDyToMakeVisible)));
            if (calculateTimeForDeceleration > 0) {
                action.update(-calculateDxToMakeVisible, -calculateDyToMakeVisible, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    public void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, action) == null) {
            PointF computeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
            if (computeScrollVectorForPosition != null && (computeScrollVectorForPosition.x != 0.0f || computeScrollVectorForPosition.y != 0.0f)) {
                normalize(computeScrollVectorForPosition);
                this.mTargetVector = computeScrollVectorForPosition;
                this.mInterimTargetDx = (int) (computeScrollVectorForPosition.x * 10000.0f);
                this.mInterimTargetDy = (int) (computeScrollVectorForPosition.y * 10000.0f);
                action.update((int) (this.mInterimTargetDx * 1.2f), (int) (this.mInterimTargetDy * 1.2f), (int) (calculateTimeForScrolling(10000) * 1.2f), this.mLinearInterpolator);
                return;
            }
            action.jumpTo(getTargetPosition());
            stop();
        }
    }
}
