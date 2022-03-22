package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@VisibleForTesting
/* loaded from: classes.dex */
public class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_STATE_FADING_IN = 1;
    public static final int ANIMATION_STATE_FADING_OUT = 3;
    public static final int ANIMATION_STATE_IN = 2;
    public static final int ANIMATION_STATE_OUT = 0;
    public static final int DRAG_NONE = 0;
    public static final int DRAG_X = 1;
    public static final int DRAG_Y = 2;
    public static final int[] EMPTY_STATE_SET;
    public static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
    public static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
    public static final int HIDE_DURATION_MS = 500;
    public static final int[] PRESSED_STATE_SET;
    public static final int SCROLLBAR_FULL_OPAQUE = 255;
    public static final int SHOW_DURATION_MS = 500;
    public static final int STATE_DRAGGING = 2;
    public static final int STATE_HIDDEN = 0;
    public static final int STATE_VISIBLE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAnimationState;
    public int mDragState;
    public final Runnable mHideRunnable;
    @VisibleForTesting
    public float mHorizontalDragX;
    public final int[] mHorizontalRange;
    @VisibleForTesting
    public int mHorizontalThumbCenterX;
    public final StateListDrawable mHorizontalThumbDrawable;
    public final int mHorizontalThumbHeight;
    @VisibleForTesting
    public int mHorizontalThumbWidth;
    public final Drawable mHorizontalTrackDrawable;
    public final int mHorizontalTrackHeight;
    public final int mMargin;
    public boolean mNeedHorizontalScrollbar;
    public boolean mNeedVerticalScrollbar;
    public final RecyclerView.OnScrollListener mOnScrollListener;
    public RecyclerView mRecyclerView;
    public int mRecyclerViewHeight;
    public int mRecyclerViewWidth;
    public final int mScrollbarMinimumRange;
    public final ValueAnimator mShowHideAnimator;
    public int mState;
    @VisibleForTesting
    public float mVerticalDragY;
    public final int[] mVerticalRange;
    @VisibleForTesting
    public int mVerticalThumbCenterY;
    public final StateListDrawable mVerticalThumbDrawable;
    @VisibleForTesting
    public int mVerticalThumbHeight;
    public final int mVerticalThumbWidth;
    public final Drawable mVerticalTrackDrawable;
    public final int mVerticalTrackWidth;

    /* loaded from: classes.dex */
    public class AnimatorListener extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mCanceled;
        public final /* synthetic */ FastScroller this$0;

        public AnimatorListener(FastScroller fastScroller) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fastScroller};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fastScroller;
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.mCanceled = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.mCanceled) {
                    this.mCanceled = false;
                } else if (((Float) this.this$0.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
                    FastScroller fastScroller = this.this$0;
                    fastScroller.mAnimationState = 0;
                    fastScroller.setState(0);
                } else {
                    FastScroller fastScroller2 = this.this$0;
                    fastScroller2.mAnimationState = 2;
                    fastScroller2.requestRedraw();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastScroller this$0;

        public AnimatorUpdater(FastScroller fastScroller) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fastScroller};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fastScroller;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                this.this$0.mVerticalThumbDrawable.setAlpha(floatValue);
                this.this$0.mVerticalTrackDrawable.setAlpha(floatValue);
                this.this$0.requestRedraw();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1030717451, "Landroidx/recyclerview/widget/FastScroller;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1030717451, "Landroidx/recyclerview/widget/FastScroller;");
                return;
            }
        }
        PRESSED_STATE_SET = new int[]{16842919};
        EMPTY_STATE_SET = new int[0];
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recyclerView, stateListDrawable, drawable, stateListDrawable2, drawable2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRecyclerViewWidth = 0;
        this.mRecyclerViewHeight = 0;
        this.mNeedVerticalScrollbar = false;
        this.mNeedHorizontalScrollbar = false;
        this.mState = 0;
        this.mDragState = 0;
        this.mVerticalRange = new int[2];
        this.mHorizontalRange = new int[2];
        this.mShowHideAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimationState = 0;
        this.mHideRunnable = new Runnable(this) { // from class: androidx.recyclerview.widget.FastScroller.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FastScroller this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.hide(500);
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener(this) { // from class: androidx.recyclerview.widget.FastScroller.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FastScroller this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i6, int i7) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, recyclerView2, i6, i7) == null) {
                    this.this$0.updateScrollPosition(recyclerView2.computeHorizontalScrollOffset(), recyclerView2.computeVerticalScrollOffset());
                }
            }
        };
        this.mVerticalThumbDrawable = stateListDrawable;
        this.mVerticalTrackDrawable = drawable;
        this.mHorizontalThumbDrawable = stateListDrawable2;
        this.mHorizontalTrackDrawable = drawable2;
        this.mVerticalThumbWidth = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(i, drawable.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(i, drawable2.getIntrinsicWidth());
        this.mScrollbarMinimumRange = i2;
        this.mMargin = i3;
        this.mVerticalThumbDrawable.setAlpha(255);
        this.mVerticalTrackDrawable.setAlpha(255);
        this.mShowHideAnimator.addListener(new AnimatorListener(this));
        this.mShowHideAnimator.addUpdateListener(new AnimatorUpdater(this));
        attachToRecyclerView(recyclerView);
    }

    private void cancelHide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mRecyclerView.removeCallbacks(this.mHideRunnable);
        }
    }

    private void destroyCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mRecyclerView.removeItemDecoration(this);
            this.mRecyclerView.removeOnItemTouchListener(this);
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
            cancelHide();
        }
    }

    private void drawHorizontalScrollbar(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas) == null) {
            int i = this.mRecyclerViewHeight;
            int i2 = this.mHorizontalThumbHeight;
            int i3 = i - i2;
            int i4 = this.mHorizontalThumbCenterX;
            int i5 = this.mHorizontalThumbWidth;
            int i6 = i4 - (i5 / 2);
            this.mHorizontalThumbDrawable.setBounds(0, 0, i5, i2);
            this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
            canvas.translate(0.0f, i3);
            this.mHorizontalTrackDrawable.draw(canvas);
            canvas.translate(i6, 0.0f);
            this.mHorizontalThumbDrawable.draw(canvas);
            canvas.translate(-i6, -i3);
        }
    }

    private void drawVerticalScrollbar(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, canvas) == null) {
            int i = this.mRecyclerViewWidth;
            int i2 = this.mVerticalThumbWidth;
            int i3 = i - i2;
            int i4 = this.mVerticalThumbCenterY;
            int i5 = this.mVerticalThumbHeight;
            int i6 = i4 - (i5 / 2);
            this.mVerticalThumbDrawable.setBounds(0, 0, i2, i5);
            this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
            if (isLayoutRTL()) {
                this.mVerticalTrackDrawable.draw(canvas);
                canvas.translate(this.mVerticalThumbWidth, i6);
                canvas.scale(-1.0f, 1.0f);
                this.mVerticalThumbDrawable.draw(canvas);
                canvas.scale(1.0f, 1.0f);
                canvas.translate(-this.mVerticalThumbWidth, -i6);
                return;
            }
            canvas.translate(i3, 0.0f);
            this.mVerticalTrackDrawable.draw(canvas);
            canvas.translate(0.0f, i6);
            this.mVerticalThumbDrawable.draw(canvas);
            canvas.translate(-i3, -i6);
        }
    }

    private int[] getHorizontalRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            int[] iArr = this.mHorizontalRange;
            int i = this.mMargin;
            iArr[0] = i;
            iArr[1] = this.mRecyclerViewWidth - i;
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    private int[] getVerticalRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int[] iArr = this.mVerticalRange;
            int i = this.mMargin;
            iArr[0] = i;
            iArr[1] = this.mRecyclerViewHeight - i;
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    private void horizontalScrollTo(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65544, this, f2) == null) {
            int[] horizontalRange = getHorizontalRange();
            float max = Math.max(horizontalRange[0], Math.min(horizontalRange[1], f2));
            if (Math.abs(this.mHorizontalThumbCenterX - max) < 2.0f) {
                return;
            }
            int scrollTo = scrollTo(this.mHorizontalDragX, max, horizontalRange, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
            if (scrollTo != 0) {
                this.mRecyclerView.scrollBy(scrollTo, 0);
            }
            this.mHorizontalDragX = max;
        }
    }

    private boolean isLayoutRTL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? ViewCompat.getLayoutDirection(this.mRecyclerView) == 1 : invokeV.booleanValue;
    }

    private void resetHideDelay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, this, i) == null) {
            cancelHide();
            this.mRecyclerView.postDelayed(this.mHideRunnable, i);
        }
    }

    private int scrollTo(float f2, float f3, int[] iArr, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), iArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int i4 = iArr[1] - iArr[0];
            if (i4 == 0) {
                return 0;
            }
            int i5 = i - i3;
            int i6 = (int) (((f3 - f2) / i4) * i5);
            int i7 = i2 + i6;
            if (i7 >= i5 || i7 < 0) {
                return 0;
            }
            return i6;
        }
        return invokeCommon.intValue;
    }

    private void setupCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.mRecyclerView.addItemDecoration(this);
            this.mRecyclerView.addOnItemTouchListener(this);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        }
    }

    private void verticalScrollTo(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65549, this, f2) == null) {
            int[] verticalRange = getVerticalRange();
            float max = Math.max(verticalRange[0], Math.min(verticalRange[1], f2));
            if (Math.abs(this.mVerticalThumbCenterY - max) < 2.0f) {
                return;
            }
            int scrollTo = scrollTo(this.mVerticalDragY, max, verticalRange, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
            if (scrollTo != 0) {
                this.mRecyclerView.scrollBy(0, scrollTo);
            }
            this.mVerticalDragY = max;
        }
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) || (recyclerView2 = this.mRecyclerView) == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
        }
    }

    @VisibleForTesting
    public Drawable getHorizontalThumbDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHorizontalThumbDrawable : (Drawable) invokeV.objValue;
    }

    @VisibleForTesting
    public Drawable getHorizontalTrackDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mHorizontalTrackDrawable : (Drawable) invokeV.objValue;
    }

    @VisibleForTesting
    public Drawable getVerticalThumbDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVerticalThumbDrawable : (Drawable) invokeV.objValue;
    }

    @VisibleForTesting
    public Drawable getVerticalTrackDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVerticalTrackDrawable : (Drawable) invokeV.objValue;
    }

    @VisibleForTesting
    public void hide(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            int i2 = this.mAnimationState;
            if (i2 == 1) {
                this.mShowHideAnimator.cancel();
            } else if (i2 != 2) {
                return;
            }
            this.mAnimationState = 3;
            ValueAnimator valueAnimator = this.mShowHideAnimator;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            this.mShowHideAnimator.setDuration(i);
            this.mShowHideAnimator.start();
        }
    }

    public boolean isDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mState == 2 : invokeV.booleanValue;
    }

    @VisibleForTesting
    public boolean isPointInsideHorizontalThumb(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f3 >= this.mRecyclerViewHeight - this.mHorizontalThumbHeight) {
                int i = this.mHorizontalThumbCenterX;
                int i2 = this.mHorizontalThumbWidth;
                if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @VisibleForTesting
    public boolean isPointInsideVerticalThumb(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (!isLayoutRTL() ? f2 >= this.mRecyclerViewWidth - this.mVerticalThumbWidth : f2 <= this.mVerticalThumbWidth / 2) {
                int i = this.mVerticalThumbCenterY;
                int i2 = this.mVerticalThumbHeight;
                if (f3 >= i - (i2 / 2) && f3 <= i + (i2 / 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @VisibleForTesting
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mState == 1 : invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, canvas, recyclerView, state) == null) {
            if (this.mRecyclerViewWidth == this.mRecyclerView.getWidth() && this.mRecyclerViewHeight == this.mRecyclerView.getHeight()) {
                if (this.mAnimationState != 0) {
                    if (this.mNeedVerticalScrollbar) {
                        drawVerticalScrollbar(canvas);
                    }
                    if (this.mNeedHorizontalScrollbar) {
                        drawHorizontalScrollbar(canvas);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
            this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
            setState(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, recyclerView, motionEvent)) == null) {
            int i = this.mState;
            if (i == 1) {
                boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
                boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (!isPointInsideVerticalThumb && !isPointInsideHorizontalThumb) {
                    return false;
                }
                if (isPointInsideHorizontalThumb) {
                    this.mDragState = 1;
                    this.mHorizontalDragX = (int) motionEvent.getX();
                } else if (isPointInsideVerticalThumb) {
                    this.mDragState = 2;
                    this.mVerticalDragY = (int) motionEvent.getY();
                }
                setState(2);
            } else if (i != 2) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, recyclerView, motionEvent) == null) || this.mState == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
            boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
            if (isPointInsideVerticalThumb || isPointInsideHorizontalThumb) {
                if (isPointInsideHorizontalThumb) {
                    this.mDragState = 1;
                    this.mHorizontalDragX = (int) motionEvent.getX();
                } else if (isPointInsideVerticalThumb) {
                    this.mDragState = 2;
                    this.mVerticalDragY = (int) motionEvent.getY();
                }
                setState(2);
            }
        } else if (motionEvent.getAction() == 1 && this.mState == 2) {
            this.mVerticalDragY = 0.0f;
            this.mHorizontalDragX = 0.0f;
            setState(1);
            this.mDragState = 0;
        } else if (motionEvent.getAction() == 2 && this.mState == 2) {
            show();
            if (this.mDragState == 1) {
                horizontalScrollTo(motionEvent.getX());
            }
            if (this.mDragState == 2) {
                verticalScrollTo(motionEvent.getY());
            }
        }
    }

    public void requestRedraw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mRecyclerView.invalidate();
        }
    }

    public void setState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            if (i == 2 && this.mState != 2) {
                this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
                cancelHide();
            }
            if (i == 0) {
                requestRedraw();
            } else {
                show();
            }
            if (this.mState == 2 && i != 2) {
                this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
                resetHideDelay(1200);
            } else if (i == 1) {
                resetHideDelay(1500);
            }
            this.mState = i;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i = this.mAnimationState;
            if (i != 0) {
                if (i != 3) {
                    return;
                }
                this.mShowHideAnimator.cancel();
            }
            this.mAnimationState = 1;
            ValueAnimator valueAnimator = this.mShowHideAnimator;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
            this.mShowHideAnimator.setDuration(500L);
            this.mShowHideAnimator.setStartDelay(0L);
            this.mShowHideAnimator.start();
        }
    }

    public void updateScrollPosition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            int computeVerticalScrollRange = this.mRecyclerView.computeVerticalScrollRange();
            int i3 = this.mRecyclerViewHeight;
            this.mNeedVerticalScrollbar = computeVerticalScrollRange - i3 > 0 && i3 >= this.mScrollbarMinimumRange;
            int computeHorizontalScrollRange = this.mRecyclerView.computeHorizontalScrollRange();
            int i4 = this.mRecyclerViewWidth;
            boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= this.mScrollbarMinimumRange;
            this.mNeedHorizontalScrollbar = z;
            if (!this.mNeedVerticalScrollbar && !z) {
                if (this.mState != 0) {
                    setState(0);
                    return;
                }
                return;
            }
            if (this.mNeedVerticalScrollbar) {
                float f2 = i3;
                this.mVerticalThumbCenterY = (int) ((f2 * (i2 + (f2 / 2.0f))) / computeVerticalScrollRange);
                this.mVerticalThumbHeight = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
            }
            if (this.mNeedHorizontalScrollbar) {
                float f3 = i4;
                this.mHorizontalThumbCenterX = (int) ((f3 * (i + (f3 / 2.0f))) / computeHorizontalScrollRange);
                this.mHorizontalThumbWidth = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
            }
            int i5 = this.mState;
            if (i5 == 0 || i5 == 1) {
                setState(1);
            }
        }
    }
}
