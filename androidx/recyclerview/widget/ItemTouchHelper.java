package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_MODE_DRAG_MASK = 16711680;
    public static final int ACTION_MODE_IDLE_MASK = 255;
    public static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    public static final boolean DEBUG = false;
    public static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    public static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    public static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActionState;
    public int mActivePointerId;
    @NonNull
    public Callback mCallback;
    public RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback;
    public List<Integer> mDistances;
    public long mDragScrollStartTimeInMs;
    public float mDx;
    public float mDy;
    public GestureDetectorCompat mGestureDetector;
    public float mInitialTouchX;
    public float mInitialTouchY;
    public ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    public float mMaxSwipeVelocity;
    public final RecyclerView.OnItemTouchListener mOnItemTouchListener;
    public View mOverdrawChild;
    public int mOverdrawChildPosition;
    public final List<View> mPendingCleanup;
    public List<RecoverAnimation> mRecoverAnimations;
    public RecyclerView mRecyclerView;
    public final Runnable mScrollRunnable;
    public RecyclerView.ViewHolder mSelected;
    public int mSelectedFlags;
    public float mSelectedStartX;
    public float mSelectedStartY;
    public int mSlop;
    public List<RecyclerView.ViewHolder> mSwapTargets;
    public float mSwipeEscapeVelocity;
    public final float[] mTmpPosition;
    public Rect mTmpRect;
    public VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View view2, @NonNull View view3, int i, int i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        public static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        public static final int RELATIVE_DIR_FLAGS = 3158064;
        public static final Interpolator sDragScrollInterpolator;
        public static final Interpolator sDragViewScrollCapInterpolator;
        public transient /* synthetic */ FieldHolder $fh;
        public int mCachedMaxScrollSpeed;

        public static int convertToRelativeDirection(int i, int i2) {
            InterceptResult invokeII;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
                int i4 = i & ABS_HORIZONTAL_DIR_FLAGS;
                if (i4 == 0) {
                    return i;
                }
                int i5 = i & (~i4);
                if (i2 == 0) {
                    i3 = i4 << 2;
                } else {
                    int i6 = i4 << 1;
                    i5 |= (-789517) & i6;
                    i3 = (i6 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
                }
                return i5 | i3;
            }
            return invokeII.intValue;
        }

        public static int makeFlag(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) ? i2 << (i * 8) : invokeII.intValue;
        }

        public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, recyclerView, viewHolder, viewHolder2)) == null) {
                return true;
            }
            return invokeLLL.booleanValue;
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            InterceptResult invokeII;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
                int i4 = i & RELATIVE_DIR_FLAGS;
                if (i4 == 0) {
                    return i;
                }
                int i5 = i & (~i4);
                if (i2 == 0) {
                    i3 = i4 >> 2;
                } else {
                    int i6 = i4 >> 1;
                    i5 |= (-3158065) & i6;
                    i3 = (i6 & RELATIVE_DIR_FLAGS) >> 2;
                }
                return i5 | i3;
            }
            return invokeII.intValue;
        }

        public int getBoundingBoxMargin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewHolder)) == null) {
                return 0.5f;
            }
            return invokeL.floatValue;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f)) == null) ? f : invokeF.floatValue;
        }

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewHolder)) == null) {
                return 0.5f;
            }
            return invokeL.floatValue;
        }

        public float getSwipeVelocityThreshold(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f)) == null) ? f : invokeF.floatValue;
        }

        public boolean isItemViewSwipeEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public boolean isLongPressDragEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public abstract boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i);

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-172550190, "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-172550190, "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;");
                    return;
                }
            }
            sDragScrollInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f) {
                    InterceptResult invokeF;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeF = interceptable2.invokeF(1048576, this, f)) == null) ? f * f * f * f * f : invokeF.floatValue;
                }

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
            };
            sDragViewScrollCapInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f) {
                    InterceptResult invokeF;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeF = interceptable2.invokeF(1048576, this, f)) == null) {
                        float f2 = f - 1.0f;
                        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
                    }
                    return invokeF.floatValue;
                }

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
            };
        }

        public Callback() {
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
            this.mCachedMaxScrollSpeed = -1;
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return ItemTouchUIUtilImpl.INSTANCE;
            }
            return (ItemTouchUIUtil) invokeV.objValue;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, recyclerView)) == null) {
                if (this.mCachedMaxScrollSpeed == -1) {
                    this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070355);
                }
                return this.mCachedMaxScrollSpeed;
            }
            return invokeL.intValue;
        }

        public static int makeMovementFlags(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) {
                return makeFlag(2, i) | makeFlag(1, i2) | makeFlag(0, i2 | i);
            }
            return invokeII.intValue;
        }

        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recyclerView, viewHolder) == null) {
                ItemTouchUIUtilImpl.INSTANCE.clearView(viewHolder.itemView);
            }
        }

        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, recyclerView, viewHolder)) == null) {
                return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
            }
            return invokeLL.intValue;
        }

        public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, recyclerView, viewHolder)) == null) {
                if ((getAbsoluteMovementFlags(recyclerView, viewHolder) & 16711680) != 0) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, recyclerView, viewHolder)) == null) {
                if ((getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048599, this, viewHolder, i) == null) && viewHolder != null) {
                ItemTouchUIUtilImpl.INSTANCE.onSelected(viewHolder.itemView);
            }
        }

        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i, int i2) {
            InterceptResult invokeLLII;
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, list, i, i2)) == null) {
                int width = i + viewHolder.itemView.getWidth();
                int height = i2 + viewHolder.itemView.getHeight();
                int left2 = i - viewHolder.itemView.getLeft();
                int top2 = i2 - viewHolder.itemView.getTop();
                int size = list.size();
                RecyclerView.ViewHolder viewHolder2 = null;
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    RecyclerView.ViewHolder viewHolder3 = list.get(i4);
                    if (left2 > 0 && (right = viewHolder3.itemView.getRight() - width) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (abs4 = Math.abs(right)) > i3) {
                        viewHolder2 = viewHolder3;
                        i3 = abs4;
                    }
                    if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs3 = Math.abs(left)) > i3) {
                        viewHolder2 = viewHolder3;
                        i3 = abs3;
                    }
                    if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i2) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs2 = Math.abs(top)) > i3) {
                        viewHolder2 = viewHolder3;
                        i3 = abs2;
                    }
                    if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - height) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (abs = Math.abs(bottom)) > i3) {
                        viewHolder2 = viewHolder3;
                        i3 = abs;
                    }
                }
                return viewHolder2;
            }
            return (RecyclerView.ViewHolder) invokeLLII.objValue;
        }

        public long getAnimationDuration(@NonNull RecyclerView recyclerView, int i, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{recyclerView, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)})) == null) {
                RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
                if (itemAnimator == null) {
                    if (i == 8) {
                        return 200L;
                    }
                    return 250L;
                } else if (i == 8) {
                    return itemAnimator.getMoveDuration();
                } else {
                    return itemAnimator.getRemoveDuration();
                }
            }
            return invokeCommon.longValue;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView recyclerView, int i, int i2, int i3, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{recyclerView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) == null) {
                float f = 1.0f;
                int signum = (int) (((int) Math.signum(i2)) * getMaxDragScroll(recyclerView) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)));
                if (j <= 2000) {
                    f = ((float) j) / 2000.0f;
                }
                int interpolation = (int) (signum * sDragScrollInterpolator.getInterpolation(f));
                if (interpolation == 0) {
                    if (i2 > 0) {
                        return 1;
                    }
                    return -1;
                }
                return interpolation;
            }
            return invokeCommon.intValue;
        }

        public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{canvas, recyclerView, viewHolder, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                ItemTouchUIUtilImpl.INSTANCE.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
            }
        }

        public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{canvas, recyclerView, viewHolder, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                ItemTouchUIUtilImpl.INSTANCE.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
            }
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{canvas, recyclerView, viewHolder, list, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    RecoverAnimation recoverAnimation = list.get(i2);
                    recoverAnimation.update();
                    int save = canvas.save();
                    onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                    canvas.restoreToCount(save);
                }
                if (viewHolder != null) {
                    int save2 = canvas.save();
                    onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, true);
                    canvas.restoreToCount(save2);
                }
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{canvas, recyclerView, viewHolder, list, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
                int size = list.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    RecoverAnimation recoverAnimation = list.get(i2);
                    int save = canvas.save();
                    onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                    canvas.restoreToCount(save);
                }
                if (viewHolder != null) {
                    int save2 = canvas.save();
                    onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, true);
                    canvas.restoreToCount(save2);
                }
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    RecoverAnimation recoverAnimation2 = list.get(i3);
                    if (recoverAnimation2.mEnded && !recoverAnimation2.mIsPendingCleanup) {
                        list.remove(i3);
                    } else if (!recoverAnimation2.mEnded) {
                        z = true;
                    }
                }
                if (z) {
                    recyclerView.invalidate();
                }
            }
        }

        public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{recyclerView, viewHolder, Integer.valueOf(i), viewHolder2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof ViewDropHandler) {
                    ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                    return;
                }
                if (layoutManager.canScrollHorizontally()) {
                    if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                        recyclerView.scrollToPosition(i2);
                    }
                    if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                        recyclerView.scrollToPosition(i2);
                    }
                }
                if (layoutManager.canScrollVertically()) {
                    if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                        recyclerView.scrollToPosition(i2);
                    }
                    if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                        recyclerView.scrollToPosition(i2);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mShouldReactToLongPress;
        public final /* synthetic */ ItemTouchHelper this$0;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public ItemTouchHelperGestureListener(ItemTouchHelper itemTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = itemTouchHelper;
            this.mShouldReactToLongPress = true;
        }

        public void doNotReactToLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mShouldReactToLongPress = false;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View findChildView;
            RecyclerView.ViewHolder childViewHolder;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) && this.mShouldReactToLongPress && (findChildView = this.this$0.findChildView(motionEvent)) != null && (childViewHolder = this.this$0.mRecyclerView.getChildViewHolder(findChildView)) != null) {
                ItemTouchHelper itemTouchHelper = this.this$0;
                if (!itemTouchHelper.mCallback.hasDragFlag(itemTouchHelper.mRecyclerView, childViewHolder)) {
                    return;
                }
                int pointerId = motionEvent.getPointerId(0);
                int i = this.this$0.mActivePointerId;
                if (pointerId == i) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = this.this$0;
                    itemTouchHelper2.mInitialTouchX = x;
                    itemTouchHelper2.mInitialTouchY = y;
                    itemTouchHelper2.mDy = 0.0f;
                    itemTouchHelper2.mDx = 0.0f;
                    if (itemTouchHelper2.mCallback.isLongPressDragEnabled()) {
                        this.this$0.select(childViewHolder, 2);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class RecoverAnimation implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mActionState;
        public final int mAnimationType;
        public boolean mEnded;
        public float mFraction;
        public boolean mIsPendingCleanup;
        public boolean mOverridden;
        public final float mStartDx;
        public final float mStartDy;
        public final float mTargetX;
        public final float mTargetY;
        public final ValueAnimator mValueAnimator;
        public final RecyclerView.ViewHolder mViewHolder;
        public float mX;
        public float mY;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, animator) == null) {
            }
        }

        public RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewHolder, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mOverridden = false;
            this.mEnded = false;
            this.mActionState = i2;
            this.mAnimationType = i;
            this.mViewHolder = viewHolder;
            this.mStartDx = f;
            this.mStartDy = f2;
            this.mTargetX = f3;
            this.mTargetY = f4;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecoverAnimation this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i5 = newInitContext2.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.this$0.setFraction(valueAnimator.getAnimatedFraction());
                    }
                }
            });
            this.mValueAnimator.setTarget(viewHolder.itemView);
            this.mValueAnimator.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mValueAnimator.cancel();
            }
        }

        public void start() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.mViewHolder.setIsRecyclable(false);
                this.mValueAnimator.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                setFraction(1.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                if (!this.mEnded) {
                    this.mViewHolder.setIsRecyclable(true);
                }
                this.mEnded = true;
            }
        }

        public void setDuration(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.mValueAnimator.setDuration(j);
            }
        }

        public void setFraction(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
                this.mFraction = f;
            }
        }

        public void update() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                float f = this.mStartDx;
                float f2 = this.mTargetX;
                if (f == f2) {
                    this.mX = this.mViewHolder.itemView.getTranslationX();
                } else {
                    this.mX = f + (this.mFraction * (f2 - f));
                }
                float f3 = this.mStartDy;
                float f4 = this.mTargetY;
                if (f3 == f4) {
                    this.mY = this.mViewHolder.itemView.getTranslationY();
                } else {
                    this.mY = f3 + (this.mFraction * (f4 - f3));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SimpleCallback extends Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mDefaultDragDirs;
        public int mDefaultSwipeDirs;

        public SimpleCallback(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDefaultSwipeDirs = i2;
            this.mDefaultDragDirs = i;
        }

        public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, recyclerView, viewHolder)) == null) {
                return this.mDefaultDragDirs;
            }
            return invokeLL.intValue;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, viewHolder)) == null) {
                return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
            }
            return invokeLL.intValue;
        }

        public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recyclerView, viewHolder)) == null) {
                return this.mDefaultSwipeDirs;
            }
            return invokeLL.intValue;
        }

        public void setDefaultDragDirs(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.mDefaultDragDirs = i;
            }
        }

        public void setDefaultSwipeDirs(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.mDefaultSwipeDirs = i;
            }
        }
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPendingCleanup = new ArrayList();
        this.mTmpPosition = new float[2];
        this.mSelected = null;
        this.mActivePointerId = -1;
        this.mActionState = 0;
        this.mRecoverAnimations = new ArrayList();
        this.mScrollRunnable = new Runnable(this) { // from class: androidx.recyclerview.widget.ItemTouchHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ItemTouchHelper this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    ItemTouchHelper itemTouchHelper = this.this$0;
                    if (itemTouchHelper.mSelected != null && itemTouchHelper.scrollIfNecessary()) {
                        ItemTouchHelper itemTouchHelper2 = this.this$0;
                        RecyclerView.ViewHolder viewHolder = itemTouchHelper2.mSelected;
                        if (viewHolder != null) {
                            itemTouchHelper2.moveIfNecessary(viewHolder);
                        }
                        ItemTouchHelper itemTouchHelper3 = this.this$0;
                        itemTouchHelper3.mRecyclerView.removeCallbacks(itemTouchHelper3.mScrollRunnable);
                        ViewCompat.postOnAnimation(this.this$0.mRecyclerView, this);
                    }
                }
            }
        };
        this.mChildDrawingOrderCallback = null;
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        this.mOnItemTouchListener = new RecyclerView.OnItemTouchListener(this) { // from class: androidx.recyclerview.widget.ItemTouchHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ItemTouchHelper this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean z) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                    return;
                }
                this.this$0.select(null, 0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                InterceptResult invokeLL;
                int findPointerIndex;
                RecoverAnimation findAnimation;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, recyclerView, motionEvent)) == null) {
                    this.this$0.mGestureDetector.onTouchEvent(motionEvent);
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 0) {
                        this.this$0.mActivePointerId = motionEvent.getPointerId(0);
                        this.this$0.mInitialTouchX = motionEvent.getX();
                        this.this$0.mInitialTouchY = motionEvent.getY();
                        this.this$0.obtainVelocityTracker();
                        ItemTouchHelper itemTouchHelper = this.this$0;
                        if (itemTouchHelper.mSelected == null && (findAnimation = itemTouchHelper.findAnimation(motionEvent)) != null) {
                            ItemTouchHelper itemTouchHelper2 = this.this$0;
                            itemTouchHelper2.mInitialTouchX -= findAnimation.mX;
                            itemTouchHelper2.mInitialTouchY -= findAnimation.mY;
                            itemTouchHelper2.endRecoverAnimation(findAnimation.mViewHolder, true);
                            if (this.this$0.mPendingCleanup.remove(findAnimation.mViewHolder.itemView)) {
                                ItemTouchHelper itemTouchHelper3 = this.this$0;
                                itemTouchHelper3.mCallback.clearView(itemTouchHelper3.mRecyclerView, findAnimation.mViewHolder);
                            }
                            this.this$0.select(findAnimation.mViewHolder, findAnimation.mActionState);
                            ItemTouchHelper itemTouchHelper4 = this.this$0;
                            itemTouchHelper4.updateDxDy(motionEvent, itemTouchHelper4.mSelectedFlags, 0);
                        }
                    } else if (actionMasked != 3 && actionMasked != 1) {
                        int i3 = this.this$0.mActivePointerId;
                        if (i3 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i3)) >= 0) {
                            this.this$0.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                        }
                    } else {
                        ItemTouchHelper itemTouchHelper5 = this.this$0;
                        itemTouchHelper5.mActivePointerId = -1;
                        itemTouchHelper5.select(null, 0);
                    }
                    VelocityTracker velocityTracker = this.this$0.mVelocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                    }
                    if (this.this$0.mSelected != null) {
                        return true;
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recyclerView, motionEvent) == null) {
                    this.this$0.mGestureDetector.onTouchEvent(motionEvent);
                    VelocityTracker velocityTracker = this.this$0.mVelocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                    }
                    if (this.this$0.mActivePointerId == -1) {
                        return;
                    }
                    int actionMasked = motionEvent.getActionMasked();
                    int findPointerIndex = motionEvent.findPointerIndex(this.this$0.mActivePointerId);
                    if (findPointerIndex >= 0) {
                        this.this$0.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                    }
                    ItemTouchHelper itemTouchHelper = this.this$0;
                    RecyclerView.ViewHolder viewHolder = itemTouchHelper.mSelected;
                    if (viewHolder == null) {
                        return;
                    }
                    int i3 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked == 6) {
                                    int actionIndex = motionEvent.getActionIndex();
                                    if (motionEvent.getPointerId(actionIndex) == this.this$0.mActivePointerId) {
                                        if (actionIndex == 0) {
                                            i3 = 1;
                                        }
                                        this.this$0.mActivePointerId = motionEvent.getPointerId(i3);
                                        ItemTouchHelper itemTouchHelper2 = this.this$0;
                                        itemTouchHelper2.updateDxDy(motionEvent, itemTouchHelper2.mSelectedFlags, actionIndex);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            VelocityTracker velocityTracker2 = itemTouchHelper.mVelocityTracker;
                            if (velocityTracker2 != null) {
                                velocityTracker2.clear();
                            }
                        } else if (findPointerIndex >= 0) {
                            itemTouchHelper.updateDxDy(motionEvent, itemTouchHelper.mSelectedFlags, findPointerIndex);
                            this.this$0.moveIfNecessary(viewHolder);
                            ItemTouchHelper itemTouchHelper3 = this.this$0;
                            itemTouchHelper3.mRecyclerView.removeCallbacks(itemTouchHelper3.mScrollRunnable);
                            this.this$0.mScrollRunnable.run();
                            this.this$0.mRecyclerView.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    this.this$0.select(null, 0);
                    this.this$0.mActivePointerId = -1;
                }
            }
        };
        this.mCallback = callback;
    }

    private void getSelectedDxDy(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, fArr) == null) {
            if ((this.mSelectedFlags & 12) != 0) {
                fArr[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
            } else {
                fArr[0] = this.mSelected.itemView.getTranslationX();
            }
            if ((this.mSelectedFlags & 3) != 0) {
                fArr[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
            } else {
                fArr[1] = this.mSelected.itemView.getTranslationY();
            }
        }
    }

    public View findChildView(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            RecyclerView.ViewHolder viewHolder = this.mSelected;
            if (viewHolder != null) {
                View view2 = viewHolder.itemView;
                if (hitTest(view2, x, y, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                    return view2;
                }
            }
            for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
                RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
                View view3 = recoverAnimation.mViewHolder.itemView;
                if (hitTest(view3, x, y, recoverAnimation.mX, recoverAnimation.mY)) {
                    return view3;
                }
            }
            return this.mRecyclerView.findChildViewUnder(x, y);
        }
        return (View) invokeL.objValue;
    }

    private void addChildDrawingOrderCallback() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, this) != null) || Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.mChildDrawingOrderCallback == null) {
            this.mChildDrawingOrderCallback = new RecyclerView.ChildDrawingOrderCallback(this) { // from class: androidx.recyclerview.widget.ItemTouchHelper.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ItemTouchHelper this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
                public int onGetChildDrawingOrder(int i, int i2) {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i, i2)) == null) {
                        ItemTouchHelper itemTouchHelper = this.this$0;
                        View view2 = itemTouchHelper.mOverdrawChild;
                        if (view2 == null) {
                            return i2;
                        }
                        int i3 = itemTouchHelper.mOverdrawChildPosition;
                        if (i3 == -1) {
                            i3 = itemTouchHelper.mRecyclerView.indexOfChild(view2);
                            this.this$0.mOverdrawChildPosition = i3;
                        }
                        if (i2 == i - 1) {
                            return i3;
                        }
                        if (i2 >= i3) {
                            return i2 + 1;
                        }
                        return i2;
                    }
                    return invokeII.intValue;
                }
            };
        }
        this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void startGestureDetection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener(this);
            this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
        }
    }

    private void stopGestureDetection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.mItemTouchHelperGestureListener;
            if (itemTouchHelperGestureListener != null) {
                itemTouchHelperGestureListener.doNotReactToLongPress();
                this.mItemTouchHelperGestureListener = null;
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector = null;
            }
        }
    }

    public boolean hasRunningRecoverAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int size = this.mRecoverAnimations.size();
            for (int i = 0; i < size; i++) {
                if (!this.mRecoverAnimations.get(i).mEnded) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void obtainVelocityTracker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, viewHolder, i)) == null) {
            if ((i & 12) != 0) {
                int i3 = 8;
                if (this.mDx > 0.0f) {
                    i2 = 8;
                } else {
                    i2 = 4;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null && this.mActivePointerId > -1) {
                    velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                    float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                    float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    if (xVelocity <= 0.0f) {
                        i3 = 4;
                    }
                    float abs = Math.abs(xVelocity);
                    if ((i3 & i) != 0 && i2 == i3 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(yVelocity)) {
                        return i3;
                    }
                }
                float width = this.mRecyclerView.getWidth() * this.mCallback.getSwipeThreshold(viewHolder);
                if ((i & i2) != 0 && Math.abs(this.mDx) > width) {
                    return i2;
                }
                return 0;
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, viewHolder, i)) == null) {
            if ((i & 3) != 0) {
                int i3 = 2;
                if (this.mDy > 0.0f) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null && this.mActivePointerId > -1) {
                    velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                    float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                    float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    if (yVelocity <= 0.0f) {
                        i3 = 1;
                    }
                    float abs = Math.abs(yVelocity);
                    if ((i3 & i) != 0 && i3 == i2 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(xVelocity)) {
                        return i3;
                    }
                }
                float height = this.mRecyclerView.getHeight() * this.mCallback.getSwipeThreshold(viewHolder);
                if ((i & i2) != 0 && Math.abs(this.mDy) > height) {
                    return i2;
                }
                return 0;
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    private void destroyCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mRecyclerView.removeItemDecoration(this);
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
            for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
                this.mCallback.clearView(this.mRecyclerView, this.mRecoverAnimations.get(0).mViewHolder);
            }
            this.mRecoverAnimations.clear();
            this.mOverdrawChild = null;
            this.mOverdrawChildPosition = -1;
            releaseVelocityTracker();
            stopGestureDetection();
        }
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, viewHolder)) == null) {
            RecyclerView.ViewHolder viewHolder2 = viewHolder;
            List<RecyclerView.ViewHolder> list = this.mSwapTargets;
            if (list == null) {
                this.mSwapTargets = new ArrayList();
                this.mDistances = new ArrayList();
            } else {
                list.clear();
                this.mDistances.clear();
            }
            int boundingBoxMargin = this.mCallback.getBoundingBoxMargin();
            int round = Math.round(this.mSelectedStartX + this.mDx) - boundingBoxMargin;
            int round2 = Math.round(this.mSelectedStartY + this.mDy) - boundingBoxMargin;
            int i = boundingBoxMargin * 2;
            int width = viewHolder2.itemView.getWidth() + round + i;
            int height = viewHolder2.itemView.getHeight() + round2 + i;
            int i2 = (round + width) / 2;
            int i3 = (round2 + height) / 2;
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            int childCount = layoutManager.getChildCount();
            int i4 = 0;
            while (i4 < childCount) {
                View childAt = layoutManager.getChildAt(i4);
                if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                    RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(childAt);
                    if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, childViewHolder)) {
                        int abs = Math.abs(i2 - ((childAt.getLeft() + childAt.getRight()) / 2));
                        int abs2 = Math.abs(i3 - ((childAt.getTop() + childAt.getBottom()) / 2));
                        int i5 = (abs * abs) + (abs2 * abs2);
                        int size = this.mSwapTargets.size();
                        int i6 = 0;
                        for (int i7 = 0; i7 < size && i5 > this.mDistances.get(i7).intValue(); i7++) {
                            i6++;
                        }
                        this.mSwapTargets.add(i6, childViewHolder);
                        this.mDistances.add(i6, Integer.valueOf(i5));
                    }
                }
                i4++;
                viewHolder2 = viewHolder;
            }
            return this.mSwapTargets;
        }
        return (List) invokeL.objValue;
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        InterceptResult invokeL;
        View findChildView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, motionEvent)) == null) {
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            int i = this.mActivePointerId;
            if (i == -1) {
                return null;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.mInitialTouchX);
            float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.mInitialTouchY);
            int i2 = this.mSlop;
            if (abs < i2 && abs2 < i2) {
                return null;
            }
            if (abs > abs2 && layoutManager.canScrollHorizontally()) {
                return null;
            }
            if ((abs2 > abs && layoutManager.canScrollVertically()) || (findChildView = findChildView(motionEvent)) == null) {
                return null;
            }
            return this.mRecyclerView.getChildViewHolder(findChildView);
        }
        return (RecyclerView.ViewHolder) invokeL.objValue;
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, viewHolder)) == null) {
            if (this.mActionState == 2) {
                return 0;
            }
            int movementFlags = this.mCallback.getMovementFlags(this.mRecyclerView, viewHolder);
            int convertToAbsoluteDirection = (this.mCallback.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
            if (convertToAbsoluteDirection == 0) {
                return 0;
            }
            int i = (movementFlags & 65280) >> 8;
            if (Math.abs(this.mDx) > Math.abs(this.mDy)) {
                int checkHorizontalSwipe = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
                if (checkHorizontalSwipe > 0) {
                    if ((i & checkHorizontalSwipe) == 0) {
                        return Callback.convertToRelativeDirection(checkHorizontalSwipe, ViewCompat.getLayoutDirection(this.mRecyclerView));
                    }
                    return checkHorizontalSwipe;
                }
                int checkVerticalSwipe = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
                if (checkVerticalSwipe > 0) {
                    return checkVerticalSwipe;
                }
            } else {
                int checkVerticalSwipe2 = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
                if (checkVerticalSwipe2 > 0) {
                    return checkVerticalSwipe2;
                }
                int checkHorizontalSwipe2 = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
                if (checkHorizontalSwipe2 > 0) {
                    if ((i & checkHorizontalSwipe2) == 0) {
                        return Callback.convertToRelativeDirection(checkHorizontalSwipe2, ViewCompat.getLayoutDirection(this.mRecyclerView));
                    }
                    return checkHorizontalSwipe2;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean hitTest(View view2, float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f >= f3 && f <= f3 + view2.getWidth() && f2 >= f4 && f2 <= f4 + view2.getHeight()) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void setupCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
            this.mRecyclerView.addItemDecoration(this);
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this);
            startGestureDetection();
        }
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, recyclerView) != null) || (recyclerView2 = this.mRecyclerView) == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.mSwipeEscapeVelocity = resources.getDimension(R.dimen.obfuscated_res_0x7f070357);
            this.mMaxSwipeVelocity = resources.getDimension(R.dimen.obfuscated_res_0x7f070356);
            setupCallbacks();
        }
    }

    public RecoverAnimation findAnimation(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.mRecoverAnimations.isEmpty()) {
                return null;
            }
            View findChildView = findChildView(motionEvent);
            for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
                RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
                if (recoverAnimation.mViewHolder.itemView == findChildView) {
                    return recoverAnimation;
                }
            }
            return null;
        }
        return (RecoverAnimation) invokeL.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            removeChildDrawingOrderCallbackIfNecessary(view2);
            RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view2);
            if (childViewHolder == null) {
                return;
            }
            RecyclerView.ViewHolder viewHolder = this.mSelected;
            if (viewHolder != null && childViewHolder == viewHolder) {
                select(null, 0);
                return;
            }
            endRecoverAnimation(childViewHolder, false);
            if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
                this.mCallback.clearView(this.mRecyclerView, childViewHolder);
            }
        }
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, viewHolder) == null) {
            if (!this.mCallback.hasDragFlag(this.mRecyclerView, viewHolder)) {
                Log.e(TAG, "Start drag has been called but dragging is not enabled");
            } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
                Log.e(TAG, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            } else {
                obtainVelocityTracker();
                this.mDy = 0.0f;
                this.mDx = 0.0f;
                select(viewHolder, 2);
            }
        }
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, viewHolder) == null) {
            if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, viewHolder)) {
                Log.e(TAG, "Start swipe has been called but swiping is not enabled");
            } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
                Log.e(TAG, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
            } else {
                obtainVelocityTracker();
                this.mDy = 0.0f;
                this.mDx = 0.0f;
                select(viewHolder, 1);
            }
        }
    }

    public void checkSelectForSwipe(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder findSwipedView;
        int absoluteMovementFlags;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), motionEvent, Integer.valueOf(i2)}) != null) || this.mSelected != null || i != 2 || this.mActionState == 2 || !this.mCallback.isItemViewSwipeEnabled() || this.mRecyclerView.getScrollState() == 1 || (findSwipedView = findSwipedView(motionEvent)) == null || (absoluteMovementFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, findSwipedView) & 65280) >> 8) == 0) {
            return;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.mInitialTouchX;
        float f2 = y - this.mInitialTouchY;
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        int i3 = this.mSlop;
        if (abs < i3 && abs2 < i3) {
            return;
        }
        if (abs > abs2) {
            if (f < 0.0f && (absoluteMovementFlags & 4) == 0) {
                return;
            }
            if (f > 0.0f && (absoluteMovementFlags & 8) == 0) {
                return;
            }
        } else if (f2 < 0.0f && (absoluteMovementFlags & 1) == 0) {
            return;
        } else {
            if (f2 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                return;
            }
        }
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.mActivePointerId = motionEvent.getPointerId(0);
        select(findSwipedView, 1);
    }

    public void endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, viewHolder, z) == null) {
            for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
                RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
                if (recoverAnimation.mViewHolder == viewHolder) {
                    recoverAnimation.mOverridden |= z;
                    if (!recoverAnimation.mEnded) {
                        recoverAnimation.cancel();
                    }
                    this.mRecoverAnimations.remove(size);
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, rect, view2, recyclerView, state) == null) {
            rect.setEmpty();
        }
    }

    public void moveIfNecessary(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, viewHolder) != null) || this.mRecyclerView.isLayoutRequested() || this.mActionState != 2) {
            return;
        }
        float moveThreshold = this.mCallback.getMoveThreshold(viewHolder);
        int i = (int) (this.mSelectedStartX + this.mDx);
        int i2 = (int) (this.mSelectedStartY + this.mDy);
        if (Math.abs(i2 - viewHolder.itemView.getTop()) < viewHolder.itemView.getHeight() * moveThreshold && Math.abs(i - viewHolder.itemView.getLeft()) < viewHolder.itemView.getWidth() * moveThreshold) {
            return;
        }
        List<RecyclerView.ViewHolder> findSwapTargets = findSwapTargets(viewHolder);
        if (findSwapTargets.size() == 0) {
            return;
        }
        RecyclerView.ViewHolder chooseDropTarget = this.mCallback.chooseDropTarget(viewHolder, findSwapTargets, i, i2);
        if (chooseDropTarget == null) {
            this.mSwapTargets.clear();
            this.mDistances.clear();
            return;
        }
        int adapterPosition = chooseDropTarget.getAdapterPosition();
        int adapterPosition2 = viewHolder.getAdapterPosition();
        if (this.mCallback.onMove(this.mRecyclerView, viewHolder, chooseDropTarget)) {
            this.mCallback.onMoved(this.mRecyclerView, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, canvas, recyclerView, state) == null) {
            this.mOverdrawChildPosition = -1;
            if (this.mSelected != null) {
                getSelectedDxDy(this.mTmpPosition);
                float[] fArr = this.mTmpPosition;
                float f3 = fArr[0];
                f2 = fArr[1];
                f = f3;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f, f2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, canvas, recyclerView, state) == null) {
            if (this.mSelected != null) {
                getSelectedDxDy(this.mTmpPosition);
                float[] fArr = this.mTmpPosition;
                float f3 = fArr[0];
                f2 = fArr[1];
                f = f3;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f, f2);
        }
    }

    public void postDispatchSwipe(RecoverAnimation recoverAnimation, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, recoverAnimation, i) == null) {
            this.mRecyclerView.post(new Runnable(this, recoverAnimation, i) { // from class: androidx.recyclerview.widget.ItemTouchHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ItemTouchHelper this$0;
                public final /* synthetic */ RecoverAnimation val$anim;
                public final /* synthetic */ int val$swipeDir;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, recoverAnimation, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$anim = recoverAnimation;
                    this.val$swipeDir = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RecyclerView recyclerView;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (recyclerView = this.this$0.mRecyclerView) != null && recyclerView.isAttachedToWindow()) {
                        RecoverAnimation recoverAnimation2 = this.val$anim;
                        if (!recoverAnimation2.mOverridden && recoverAnimation2.mViewHolder.getAdapterPosition() != -1) {
                            RecyclerView.ItemAnimator itemAnimator = this.this$0.mRecyclerView.getItemAnimator();
                            if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !this.this$0.hasRunningRecoverAnim()) {
                                this.this$0.mCallback.onSwiped(this.val$anim.mViewHolder, this.val$swipeDir);
                            } else {
                                this.this$0.mRecyclerView.post(this);
                            }
                        }
                    }
                }
            });
        }
    }

    public void removeChildDrawingOrderCallbackIfNecessary(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view2) == null) && view2 == this.mOverdrawChild) {
            this.mOverdrawChild = null;
            if (this.mChildDrawingOrderCallback != null) {
                this.mRecyclerView.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c9, code lost:
        if (r1 > 0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0108 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean scrollIfNecessary() {
        InterceptResult invokeV;
        long j;
        int i;
        int i2;
        int i3;
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.mSelected == null) {
                this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.mDragScrollStartTimeInMs;
            if (j2 == Long.MIN_VALUE) {
                j = 0;
            } else {
                j = currentTimeMillis - j2;
            }
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (this.mTmpRect == null) {
                this.mTmpRect = new Rect();
            }
            layoutManager.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
            if (layoutManager.canScrollHorizontally()) {
                int i4 = (int) (this.mSelectedStartX + this.mDx);
                int paddingLeft = (i4 - this.mTmpRect.left) - this.mRecyclerView.getPaddingLeft();
                if (this.mDx < 0.0f && paddingLeft < 0) {
                    i = paddingLeft;
                } else if (this.mDx > 0.0f && (width = ((i4 + this.mSelected.itemView.getWidth()) + this.mTmpRect.right) - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight())) > 0) {
                    i = width;
                }
                if (layoutManager.canScrollVertically()) {
                    int i5 = (int) (this.mSelectedStartY + this.mDy);
                    int paddingTop = (i5 - this.mTmpRect.top) - this.mRecyclerView.getPaddingTop();
                    if (this.mDy < 0.0f && paddingTop < 0) {
                        i2 = paddingTop;
                    } else if (this.mDy > 0.0f) {
                        i2 = ((i5 + this.mSelected.itemView.getHeight()) + this.mTmpRect.bottom) - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
                    }
                    if (i != 0) {
                        i = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), i, this.mRecyclerView.getWidth(), j);
                    }
                    int i6 = i;
                    if (i2 != 0) {
                        i3 = i6;
                        i2 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), i2, this.mRecyclerView.getHeight(), j);
                    } else {
                        i3 = i6;
                    }
                    if (i3 != 0 && i2 == 0) {
                        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
                        return false;
                    }
                    if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
                        this.mDragScrollStartTimeInMs = currentTimeMillis;
                    }
                    this.mRecyclerView.scrollBy(i3, i2);
                    return true;
                }
                i2 = 0;
                if (i != 0) {
                }
                int i62 = i;
                if (i2 != 0) {
                }
                if (i3 != 0) {
                }
                if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
                }
                this.mRecyclerView.scrollBy(i3, i2);
                return true;
            }
            i = 0;
            if (layoutManager.canScrollVertically()) {
            }
            i2 = 0;
            if (i != 0) {
            }
            int i622 = i;
            if (i2 != 0) {
            }
            if (i3 != 0) {
            }
            if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
            }
            this.mRecyclerView.scrollBy(i3, i2);
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void select(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
        boolean z;
        ViewParent parent;
        boolean z2;
        int swipeIfNecessary;
        float signum;
        float f;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, viewHolder, i) == null) {
            if (viewHolder == this.mSelected && i == this.mActionState) {
                return;
            }
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            int i3 = this.mActionState;
            endRecoverAnimation(viewHolder, true);
            this.mActionState = i;
            if (i == 2) {
                if (viewHolder != null) {
                    this.mOverdrawChild = viewHolder.itemView;
                    addChildDrawingOrderCallback();
                } else {
                    throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
                }
            }
            int i4 = (1 << ((i * 8) + 8)) - 1;
            RecyclerView.ViewHolder viewHolder2 = this.mSelected;
            if (viewHolder2 != null) {
                if (viewHolder2.itemView.getParent() != null) {
                    if (i3 == 2) {
                        swipeIfNecessary = 0;
                    } else {
                        swipeIfNecessary = swipeIfNecessary(viewHolder2);
                    }
                    releaseVelocityTracker();
                    if (swipeIfNecessary != 1 && swipeIfNecessary != 2) {
                        if (swipeIfNecessary != 4 && swipeIfNecessary != 8 && swipeIfNecessary != 16 && swipeIfNecessary != 32) {
                            f = 0.0f;
                        } else {
                            f = Math.signum(this.mDx) * this.mRecyclerView.getWidth();
                        }
                        signum = 0.0f;
                    } else {
                        signum = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
                        f = 0.0f;
                    }
                    if (i3 == 2) {
                        i2 = 8;
                    } else if (swipeIfNecessary > 0) {
                        i2 = 2;
                    } else {
                        i2 = 4;
                    }
                    getSelectedDxDy(this.mTmpPosition);
                    float[] fArr = this.mTmpPosition;
                    float f2 = fArr[0];
                    float f3 = fArr[1];
                    RecoverAnimation recoverAnimation = new RecoverAnimation(this, viewHolder2, i2, i3, f2, f3, f, signum, swipeIfNecessary, viewHolder2) { // from class: androidx.recyclerview.widget.ItemTouchHelper.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ItemTouchHelper this$0;
                        public final /* synthetic */ RecyclerView.ViewHolder val$prevSelected;
                        public final /* synthetic */ int val$swipeDir;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(viewHolder2, i2, i3, f2, f3, f, signum);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, viewHolder2, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f), Float.valueOf(signum), Integer.valueOf(swipeIfNecessary), viewHolder2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((RecyclerView.ViewHolder) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Float) objArr2[3]).floatValue(), ((Float) objArr2[4]).floatValue(), ((Float) objArr2[5]).floatValue(), ((Float) objArr2[6]).floatValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$swipeDir = swipeIfNecessary;
                            this.val$prevSelected = viewHolder2;
                        }

                        @Override // androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                                super.onAnimationEnd(animator);
                                if (this.mOverridden) {
                                    return;
                                }
                                if (this.val$swipeDir <= 0) {
                                    ItemTouchHelper itemTouchHelper = this.this$0;
                                    itemTouchHelper.mCallback.clearView(itemTouchHelper.mRecyclerView, this.val$prevSelected);
                                } else {
                                    this.this$0.mPendingCleanup.add(this.val$prevSelected.itemView);
                                    this.mIsPendingCleanup = true;
                                    int i5 = this.val$swipeDir;
                                    if (i5 > 0) {
                                        this.this$0.postDispatchSwipe(this, i5);
                                    }
                                }
                                ItemTouchHelper itemTouchHelper2 = this.this$0;
                                View view2 = itemTouchHelper2.mOverdrawChild;
                                View view3 = this.val$prevSelected.itemView;
                                if (view2 == view3) {
                                    itemTouchHelper2.removeChildDrawingOrderCallbackIfNecessary(view3);
                                }
                            }
                        }
                    };
                    recoverAnimation.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i2, f - f2, signum - f3));
                    this.mRecoverAnimations.add(recoverAnimation);
                    recoverAnimation.start();
                    z = true;
                } else {
                    removeChildDrawingOrderCallbackIfNecessary(viewHolder2.itemView);
                    this.mCallback.clearView(this.mRecyclerView, viewHolder2);
                    z = false;
                }
                this.mSelected = null;
            } else {
                z = false;
            }
            if (viewHolder != null) {
                this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, viewHolder) & i4) >> (this.mActionState * 8);
                this.mSelectedStartX = viewHolder.itemView.getLeft();
                this.mSelectedStartY = viewHolder.itemView.getTop();
                this.mSelected = viewHolder;
                if (i == 2) {
                    viewHolder.itemView.performHapticFeedback(0);
                    parent = this.mRecyclerView.getParent();
                    if (parent != null) {
                        if (this.mSelected != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        parent.requestDisallowInterceptTouchEvent(z2);
                    }
                    if (!z) {
                        this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
                    }
                    this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
                    this.mRecyclerView.invalidate();
                }
            }
            parent = this.mRecyclerView.getParent();
            if (parent != null) {
            }
            if (!z) {
            }
            this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
            this.mRecyclerView.invalidate();
        }
    }

    public void updateDxDy(MotionEvent motionEvent, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048595, this, motionEvent, i, i2) == null) {
            float x = motionEvent.getX(i2);
            float y = motionEvent.getY(i2);
            float f = x - this.mInitialTouchX;
            this.mDx = f;
            this.mDy = y - this.mInitialTouchY;
            if ((i & 4) == 0) {
                this.mDx = Math.max(0.0f, f);
            }
            if ((i & 8) == 0) {
                this.mDx = Math.min(0.0f, this.mDx);
            }
            if ((i & 1) == 0) {
                this.mDy = Math.max(0.0f, this.mDy);
            }
            if ((i & 2) == 0) {
                this.mDy = Math.min(0.0f, this.mDy);
            }
        }
    }
}
