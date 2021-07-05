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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private int clampApplyScroll(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i2, i3)) == null) {
            int i4 = i2 - i3;
            if (i2 * i4 <= 0) {
                return 0;
            }
            return i4;
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

    public int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            if (i6 != -1) {
                if (i6 != 0) {
                    if (i6 == 1) {
                        return i5 - i3;
                    }
                    throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
                }
                int i7 = i4 - i2;
                if (i7 > 0) {
                    return i7;
                }
                int i8 = i5 - i3;
                if (i8 < 0) {
                    return i8;
                }
                return 0;
            }
            return i4 - i2;
        }
        return invokeCommon.intValue;
    }

    public int calculateDxToMakeVisible(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2)) == null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
                return 0;
            }
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i2);
        }
        return invokeLI.intValue;
    }

    public int calculateDyToMakeVisible(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2)) == null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null || !layoutManager.canScrollVertically()) {
                return 0;
            }
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i2);
        }
        return invokeLI.intValue;
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, displayMetrics)) == null) ? 25.0f / displayMetrics.densityDpi : invokeL.floatValue;
    }

    public int calculateTimeForDeceleration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (int) Math.ceil(calculateTimeForScrolling(i2) / 0.3356d) : invokeI.intValue;
    }

    public int calculateTimeForScrolling(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (int) Math.ceil(Math.abs(i2) * getSpeedPerPixel()) : invokeI.intValue;
    }

    public int getHorizontalSnapPreference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PointF pointF = this.mTargetVector;
            if (pointF != null) {
                float f2 = pointF.x;
                if (f2 != 0.0f) {
                    return f2 > 0.0f ? 1 : -1;
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
                float f2 = pointF.y;
                if (f2 != 0.0f) {
                    return f2 > 0.0f ? 1 : -1;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onSeekTargetStep(int i2, int i3, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), state, action}) == null) {
            if (getChildCount() == 0) {
                stop();
                return;
            }
            this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, i2);
            int clampApplyScroll = clampApplyScroll(this.mInterimTargetDy, i3);
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
    public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, view, state, action) == null) {
            int calculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
            int calculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
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
