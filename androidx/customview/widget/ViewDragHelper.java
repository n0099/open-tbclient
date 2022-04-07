package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class ViewDragHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final String TAG = "ViewDragHelper";
    public static final Interpolator sInterpolator;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActivePointerId;
    public final Callback mCallback;
    public View mCapturedView;
    public final int mDefaultEdgeSize;
    public int mDragState;
    public int[] mEdgeDragsInProgress;
    public int[] mEdgeDragsLocked;
    public int mEdgeSize;
    public int[] mInitialEdgesTouched;
    public float[] mInitialMotionX;
    public float[] mInitialMotionY;
    public float[] mLastMotionX;
    public float[] mLastMotionY;
    public float mMaxVelocity;
    public float mMinVelocity;
    public final ViewGroup mParentView;
    public int mPointersDown;
    public boolean mReleaseInProgress;
    public OverScroller mScroller;
    public final Runnable mSetIdleRunnable;
    public int mTouchSlop;
    public int mTrackingEdges;
    public VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Callback() {
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

        public int clampViewPositionHorizontal(@NonNull View view2, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view2, i, i2)) == null) {
                return 0;
            }
            return invokeLII.intValue;
        }

        public int clampViewPositionVertical(@NonNull View view2, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, i2)) == null) {
                return 0;
            }
            return invokeLII.intValue;
        }

        public int getOrderedChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.intValue;
        }

        public int getViewHorizontalDragRange(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        public int getViewVerticalDragRange(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        public void onEdgeDragStarted(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            }
        }

        public boolean onEdgeLock(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        public void onEdgeTouched(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            }
        }

        public void onViewCaptured(@NonNull View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i) == null) {
            }
        }

        public void onViewDragStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            }
        }

        public void onViewPositionChanged(@NonNull View view2, int i, int i2, @Px int i3, @Px int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            }
        }

        public void onViewReleased(@NonNull View view2, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            }
        }

        public abstract boolean tryCaptureView(@NonNull View view2, int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-386126360, "Landroidx/customview/widget/ViewDragHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-386126360, "Landroidx/customview/widget/ViewDragHelper;");
                return;
            }
        }
        sInterpolator = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
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
        };
    }

    public ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, callback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mActivePointerId = -1;
        this.mSetIdleRunnable = new Runnable(this) { // from class: androidx.customview.widget.ViewDragHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewDragHelper this$0;

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
                    this.this$0.setDragState(0);
                }
            }
        };
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback != null) {
            this.mParentView = viewGroup;
            this.mCallback = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i3 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mDefaultEdgeSize = i3;
            this.mEdgeSize = i3;
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            this.mScroller = new OverScroller(context, sInterpolator);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    private boolean checkNewEdgeDrag(float f, float f2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            float abs = Math.abs(f);
            float abs2 = Math.abs(f2);
            if ((this.mInitialEdgesTouched[i] & i2) != i2 || (this.mTrackingEdges & i2) == 0 || (this.mEdgeDragsLocked[i] & i2) == i2 || (this.mEdgeDragsInProgress[i] & i2) == i2) {
                return false;
            }
            int i3 = this.mTouchSlop;
            if (abs > i3 || abs2 > i3) {
                if (abs >= abs2 * 0.5f || !this.mCallback.onEdgeLock(i2)) {
                    return (this.mEdgeDragsInProgress[i] & i2) == 0 && abs > ((float) this.mTouchSlop);
                }
                int[] iArr = this.mEdgeDragsLocked;
                iArr[i] = iArr[i] | i2;
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean checkTouchSlop(View view2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (view2 == null) {
                return false;
            }
            boolean z = this.mCallback.getViewHorizontalDragRange(view2) > 0;
            boolean z2 = this.mCallback.getViewVerticalDragRange(view2) > 0;
            if (!z || !z2) {
                return z ? Math.abs(f) > ((float) this.mTouchSlop) : z2 && Math.abs(f2) > ((float) this.mTouchSlop);
            }
            int i = this.mTouchSlop;
            return (f * f) + (f2 * f2) > ((float) (i * i));
        }
        return invokeCommon.booleanValue;
    }

    private int clampMag(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65541, this, i, i2, i3)) == null) {
            int abs = Math.abs(i);
            if (abs < i2) {
                return 0;
            }
            return abs > i3 ? i > 0 ? i3 : -i3 : i;
        }
        return invokeIII.intValue;
    }

    private void clearMotionHistory() {
        float[] fArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (fArr = this.mInitialMotionX) == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private int computeAxisDuration(int i, int i2, int i3) {
        InterceptResult invokeIII;
        int abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65544, this, i, i2, i3)) == null) {
            if (i == 0) {
                return 0;
            }
            int width = this.mParentView.getWidth();
            float f = width / 2;
            float distanceInfluenceForSnapDuration = f + (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(i) / width)) * f);
            int abs2 = Math.abs(i2);
            if (abs2 > 0) {
                abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
            } else {
                abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
            }
            return Math.min(abs, 600);
        }
        return invokeIII.intValue;
    }

    private int computeSettleDuration(View view2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int clampMag = clampMag(i3, (int) this.mMinVelocity, (int) this.mMaxVelocity);
            int clampMag2 = clampMag(i4, (int) this.mMinVelocity, (int) this.mMaxVelocity);
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            int abs3 = Math.abs(clampMag);
            int abs4 = Math.abs(clampMag2);
            int i5 = abs3 + abs4;
            int i6 = abs + abs2;
            if (clampMag != 0) {
                f = abs3;
                f2 = i5;
            } else {
                f = abs;
                f2 = i6;
            }
            float f5 = f / f2;
            if (clampMag2 != 0) {
                f3 = abs4;
                f4 = i5;
            } else {
                f3 = abs2;
                f4 = i6;
            }
            return (int) ((computeAxisDuration(i, clampMag, this.mCallback.getViewHorizontalDragRange(view2)) * f5) + (computeAxisDuration(i2, clampMag2, this.mCallback.getViewVerticalDragRange(view2)) * (f3 / f4)));
        }
        return invokeCommon.intValue;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, viewGroup, callback)) == null) ? new ViewDragHelper(viewGroup.getContext(), viewGroup, callback) : (ViewDragHelper) invokeLL.objValue;
    }

    private void dispatchViewReleased(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.mReleaseInProgress = true;
            this.mCallback.onViewReleased(this.mCapturedView, f, f2);
            this.mReleaseInProgress = false;
            if (this.mDragState == 1) {
                setDragState(0);
            }
        }
    }

    private float distanceInfluenceForSnapDuration(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65549, this, f)) == null) ? (float) Math.sin((f - 0.5f) * 0.47123894f) : invokeF.floatValue;
    }

    private void dragTo(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65550, this, i, i2, i3, i4) == null) {
            int left = this.mCapturedView.getLeft();
            int top = this.mCapturedView.getTop();
            if (i3 != 0) {
                i = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i, i3);
                ViewCompat.offsetLeftAndRight(this.mCapturedView, i - left);
            }
            int i5 = i;
            if (i4 != 0) {
                i2 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i2, i4);
                ViewCompat.offsetTopAndBottom(this.mCapturedView, i2 - top);
            }
            int i6 = i2;
            if (i3 == 0 && i4 == 0) {
                return;
            }
            this.mCallback.onViewPositionChanged(this.mCapturedView, i5, i6, i5 - left, i6 - top);
        }
    }

    private void ensureMotionHistorySizeForId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, this, i) == null) {
            float[] fArr = this.mInitialMotionX;
            if (fArr == null || fArr.length <= i) {
                int i2 = i + 1;
                float[] fArr2 = new float[i2];
                float[] fArr3 = new float[i2];
                float[] fArr4 = new float[i2];
                float[] fArr5 = new float[i2];
                int[] iArr = new int[i2];
                int[] iArr2 = new int[i2];
                int[] iArr3 = new int[i2];
                float[] fArr6 = this.mInitialMotionX;
                if (fArr6 != null) {
                    System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                    float[] fArr7 = this.mInitialMotionY;
                    System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                    float[] fArr8 = this.mLastMotionX;
                    System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                    float[] fArr9 = this.mLastMotionY;
                    System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                    int[] iArr4 = this.mInitialEdgesTouched;
                    System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                    int[] iArr5 = this.mEdgeDragsInProgress;
                    System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                    int[] iArr6 = this.mEdgeDragsLocked;
                    System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
                }
                this.mInitialMotionX = fArr2;
                this.mInitialMotionY = fArr3;
                this.mLastMotionX = fArr4;
                this.mLastMotionY = fArr5;
                this.mInitialEdgesTouched = iArr;
                this.mEdgeDragsInProgress = iArr2;
                this.mEdgeDragsLocked = iArr3;
            }
        }
    }

    private boolean forceSettleCapturedViewAt(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65552, this, i, i2, i3, i4)) == null) {
            int left = this.mCapturedView.getLeft();
            int top = this.mCapturedView.getTop();
            int i5 = i - left;
            int i6 = i2 - top;
            if (i5 == 0 && i6 == 0) {
                this.mScroller.abortAnimation();
                setDragState(0);
                return false;
            }
            this.mScroller.startScroll(left, top, i5, i6, computeSettleDuration(this.mCapturedView, i5, i6, i3, i4));
            setDragState(2);
            return true;
        }
        return invokeIIII.booleanValue;
    }

    private int getEdgesTouched(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65553, this, i, i2)) == null) {
            int i3 = i < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
            if (i2 < this.mParentView.getTop() + this.mEdgeSize) {
                i3 |= 4;
            }
            if (i > this.mParentView.getRight() - this.mEdgeSize) {
                i3 |= 2;
            }
            return i2 > this.mParentView.getBottom() - this.mEdgeSize ? i3 | 8 : i3;
        }
        return invokeII.intValue;
    }

    private boolean isValidPointerForActionMove(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, this, i)) == null) {
            if (isPointerDown(i)) {
                return true;
            }
            Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            return false;
        }
        return invokeI.booleanValue;
    }

    private void releaseViewForPointerUp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
            dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
        }
    }

    private void reportNewEdgeDrags(float f, float f2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i)}) == null) {
            int i2 = checkNewEdgeDrag(f, f2, i, 1) ? 1 : 0;
            if (checkNewEdgeDrag(f2, f, i, 4)) {
                i2 |= 4;
            }
            if (checkNewEdgeDrag(f, f2, i, 2)) {
                i2 |= 2;
            }
            if (checkNewEdgeDrag(f2, f, i, 8)) {
                i2 |= 8;
            }
            if (i2 != 0) {
                int[] iArr = this.mEdgeDragsInProgress;
                iArr[i] = iArr[i] | i2;
                this.mCallback.onEdgeDragStarted(i2, i);
            }
        }
    }

    private void saveInitialMotion(float f, float f2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i)}) == null) {
            ensureMotionHistorySizeForId(i);
            float[] fArr = this.mInitialMotionX;
            this.mLastMotionX[i] = f;
            fArr[i] = f;
            float[] fArr2 = this.mInitialMotionY;
            this.mLastMotionY[i] = f2;
            fArr2[i] = f2;
            this.mInitialEdgesTouched[i] = getEdgesTouched((int) f, (int) f2);
            this.mPointersDown |= 1 << i;
        }
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, motionEvent) == null) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                int pointerId = motionEvent.getPointerId(i);
                if (isValidPointerForActionMove(pointerId)) {
                    float x = motionEvent.getX(i);
                    float y = motionEvent.getY(i);
                    this.mLastMotionX[pointerId] = x;
                    this.mLastMotionY[pointerId] = y;
                }
            }
        }
    }

    public void abort() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            cancel();
            if (this.mDragState == 2) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                this.mScroller.abortAnimation();
                int currX2 = this.mScroller.getCurrX();
                int currY2 = this.mScroller.getCurrY();
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
            }
            setDragState(0);
        }
    }

    public boolean canScroll(@NonNull View view2, boolean z, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int scrollX = view2.getScrollX();
                int scrollY = view2.getScrollY();
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    int i6 = i3 + scrollX;
                    if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && canScroll(childAt, true, i, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
            return z && (view2.canScrollHorizontally(-i) || view2.canScrollVertically(-i2));
        }
        return invokeCommon.booleanValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mActivePointerId = -1;
            clearMotionHistory();
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        }
    }

    public void captureChildView(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view2, i) == null) {
            if (view2.getParent() == this.mParentView) {
                this.mCapturedView = view2;
                this.mActivePointerId = i;
                this.mCallback.onViewCaptured(view2, i);
                setDragState(1);
                return;
            }
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public boolean continueSettling(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (this.mDragState == 2) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                int left = currX - this.mCapturedView.getLeft();
                int top = currY - this.mCapturedView.getTop();
                if (left != 0) {
                    ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
                }
                if (top != 0) {
                    ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
                }
                if (left != 0 || top != 0) {
                    this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
                }
                if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                    this.mScroller.abortAnimation();
                    computeScrollOffset = false;
                }
                if (!computeScrollOffset) {
                    if (z) {
                        this.mParentView.post(this.mSetIdleRunnable);
                    } else {
                        setDragState(0);
                    }
                }
            }
            return this.mDragState == 2;
        }
        return invokeZ.booleanValue;
    }

    @Nullable
    public View findTopChildUnder(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i, i2)) == null) {
            for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
                if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeII.objValue;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            if (this.mReleaseInProgress) {
                this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i, i3, i2, i4);
                setDragState(2);
                return;
            }
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
    }

    public int getActivePointerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mActivePointerId : invokeV.intValue;
    }

    @Nullable
    public View getCapturedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mCapturedView : (View) invokeV.objValue;
    }

    @Px
    public int getDefaultEdgeSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mDefaultEdgeSize : invokeV.intValue;
    }

    @Px
    public int getEdgeSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mEdgeSize : invokeV.intValue;
    }

    public float getMinVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mMinVelocity : invokeV.floatValue;
    }

    @Px
    public int getTouchSlop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mTouchSlop : invokeV.intValue;
    }

    public int getViewDragState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mDragState : invokeV.intValue;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i, i2)) == null) ? isViewUnder(this.mCapturedView, i, i2) : invokeII.booleanValue;
    }

    public boolean isEdgeTouched(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            int length = this.mInitialEdgesTouched.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (isEdgeTouched(i, i2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isPointerDown(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) ? ((1 << i) & this.mPointersDown) != 0 : invokeI.booleanValue;
    }

    public boolean isViewUnder(@Nullable View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048596, this, view2, i, i2)) == null) ? view2 != null && i >= view2.getLeft() && i < view2.getRight() && i2 >= view2.getTop() && i2 < view2.getBottom() : invokeLII.booleanValue;
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, motionEvent) == null) {
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked == 0) {
                cancel();
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int i2 = 0;
            if (actionMasked == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View findTopChildUnder = findTopChildUnder((int) x, (int) y);
                saveInitialMotion(x, y, pointerId);
                tryCaptureViewForDrag(findTopChildUnder, pointerId);
                int i3 = this.mInitialEdgesTouched[pointerId];
                int i4 = this.mTrackingEdges;
                if ((i3 & i4) != 0) {
                    this.mCallback.onEdgeTouched(i3 & i4, pointerId);
                }
            } else if (actionMasked == 1) {
                if (this.mDragState == 1) {
                    releaseViewForPointerUp();
                }
                cancel();
            } else if (actionMasked == 2) {
                if (this.mDragState == 1) {
                    if (isValidPointerForActionMove(this.mActivePointerId)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        float x2 = motionEvent.getX(findPointerIndex);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.mLastMotionX;
                        int i5 = this.mActivePointerId;
                        int i6 = (int) (x2 - fArr[i5]);
                        int i7 = (int) (y2 - this.mLastMotionY[i5]);
                        dragTo(this.mCapturedView.getLeft() + i6, this.mCapturedView.getTop() + i7, i6, i7);
                        saveLastMotion(motionEvent);
                        return;
                    }
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                while (i2 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i2);
                    if (isValidPointerForActionMove(pointerId2)) {
                        float x3 = motionEvent.getX(i2);
                        float y3 = motionEvent.getY(i2);
                        float f = x3 - this.mInitialMotionX[pointerId2];
                        float f2 = y3 - this.mInitialMotionY[pointerId2];
                        reportNewEdgeDrags(f, f2, pointerId2);
                        if (this.mDragState != 1) {
                            View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                            if (checkTouchSlop(findTopChildUnder2, f, f2) && tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i2++;
                }
                saveLastMotion(motionEvent);
            } else if (actionMasked == 3) {
                if (this.mDragState == 1) {
                    dispatchViewReleased(0.0f, 0.0f);
                }
                cancel();
            } else if (actionMasked == 5) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                saveInitialMotion(x4, y4, pointerId3);
                if (this.mDragState == 0) {
                    tryCaptureViewForDrag(findTopChildUnder((int) x4, (int) y4), pointerId3);
                    int i8 = this.mInitialEdgesTouched[pointerId3];
                    int i9 = this.mTrackingEdges;
                    if ((i8 & i9) != 0) {
                        this.mCallback.onEdgeTouched(i8 & i9, pointerId3);
                    }
                } else if (isCapturedViewUnder((int) x4, (int) y4)) {
                    tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                }
            } else if (actionMasked != 6) {
            } else {
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.mDragState == 1 && pointerId4 == this.mActivePointerId) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount2) {
                            i = -1;
                            break;
                        }
                        int pointerId5 = motionEvent.getPointerId(i2);
                        if (pointerId5 != this.mActivePointerId) {
                            View findTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                            View view2 = this.mCapturedView;
                            if (findTopChildUnder3 == view2 && tryCaptureViewForDrag(view2, pointerId5)) {
                                i = this.mActivePointerId;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        releaseViewForPointerUp();
                    }
                }
                clearMotionHistory(pointerId4);
            }
        }
    }

    public void setDragState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.mParentView.removeCallbacks(this.mSetIdleRunnable);
            if (this.mDragState != i) {
                this.mDragState = i;
                this.mCallback.onViewDragStateChanged(i);
                if (this.mDragState == 0) {
                    this.mCapturedView = null;
                }
            }
        }
    }

    public void setEdgeSize(@IntRange(from = 0) @Px int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.mEdgeSize = i;
        }
    }

    public void setEdgeTrackingEnabled(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.mTrackingEdges = i;
        }
    }

    public void setMinVelocity(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f) == null) {
            this.mMinVelocity = f;
        }
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048602, this, i, i2)) == null) {
            if (this.mReleaseInProgress) {
                return forceSettleCapturedViewAt(i, i2, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
            }
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return invokeII.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e1, code lost:
        if (r12 != r11) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        View findTopChildUnder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked == 0) {
                cancel();
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 5) {
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                float x = motionEvent.getX(actionIndex);
                                float y = motionEvent.getY(actionIndex);
                                saveInitialMotion(x, y, pointerId);
                                int i = this.mDragState;
                                if (i == 0) {
                                    int i2 = this.mInitialEdgesTouched[pointerId];
                                    int i3 = this.mTrackingEdges;
                                    if ((i2 & i3) != 0) {
                                        this.mCallback.onEdgeTouched(i2 & i3, pointerId);
                                    }
                                } else if (i == 2 && (findTopChildUnder = findTopChildUnder((int) x, (int) y)) == this.mCapturedView) {
                                    tryCaptureViewForDrag(findTopChildUnder, pointerId);
                                }
                            } else if (actionMasked == 6) {
                                clearMotionHistory(motionEvent.getPointerId(actionIndex));
                            }
                        }
                    } else if (this.mInitialMotionX != null && this.mInitialMotionY != null) {
                        int pointerCount = motionEvent.getPointerCount();
                        for (int i4 = 0; i4 < pointerCount; i4++) {
                            int pointerId2 = motionEvent.getPointerId(i4);
                            if (isValidPointerForActionMove(pointerId2)) {
                                float x2 = motionEvent.getX(i4);
                                float y2 = motionEvent.getY(i4);
                                float f = x2 - this.mInitialMotionX[pointerId2];
                                float f2 = y2 - this.mInitialMotionY[pointerId2];
                                View findTopChildUnder2 = findTopChildUnder((int) x2, (int) y2);
                                boolean z2 = findTopChildUnder2 != null && checkTouchSlop(findTopChildUnder2, f, f2);
                                if (z2) {
                                    int left = findTopChildUnder2.getLeft();
                                    int i5 = (int) f;
                                    int clampViewPositionHorizontal = this.mCallback.clampViewPositionHorizontal(findTopChildUnder2, left + i5, i5);
                                    int top = findTopChildUnder2.getTop();
                                    int i6 = (int) f2;
                                    int clampViewPositionVertical = this.mCallback.clampViewPositionVertical(findTopChildUnder2, top + i6, i6);
                                    int viewHorizontalDragRange = this.mCallback.getViewHorizontalDragRange(findTopChildUnder2);
                                    int viewVerticalDragRange = this.mCallback.getViewVerticalDragRange(findTopChildUnder2);
                                    if (viewHorizontalDragRange != 0) {
                                        if (viewHorizontalDragRange > 0) {
                                        }
                                    }
                                    if (viewVerticalDragRange == 0) {
                                        break;
                                    } else if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                        break;
                                    }
                                }
                                reportNewEdgeDrags(f, f2, pointerId2);
                                if (this.mDragState != 1) {
                                    if (z2 && tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        saveLastMotion(motionEvent);
                    }
                    z = false;
                }
                cancel();
                z = false;
            } else {
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                z = false;
                int pointerId3 = motionEvent.getPointerId(0);
                saveInitialMotion(x3, y3, pointerId3);
                View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
                if (findTopChildUnder3 == this.mCapturedView && this.mDragState == 2) {
                    tryCaptureViewForDrag(findTopChildUnder3, pointerId3);
                }
                int i7 = this.mInitialEdgesTouched[pointerId3];
                int i8 = this.mTrackingEdges;
                if ((i7 & i8) != 0) {
                    this.mCallback.onEdgeTouched(i7 & i8, pointerId3);
                }
            }
            if (this.mDragState == 1) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean smoothSlideViewTo(@NonNull View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048604, this, view2, i, i2)) == null) {
            this.mCapturedView = view2;
            this.mActivePointerId = -1;
            boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i, i2, 0, 0);
            if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
                this.mCapturedView = null;
            }
            return forceSettleCapturedViewAt;
        }
        return invokeLII.booleanValue;
    }

    public boolean tryCaptureViewForDrag(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, view2, i)) == null) {
            if (view2 == this.mCapturedView && this.mActivePointerId == i) {
                return true;
            }
            if (view2 == null || !this.mCallback.tryCaptureView(view2, i)) {
                return false;
            }
            this.mActivePointerId = i;
            captureChildView(view2, i);
            return true;
        }
        return invokeLI.booleanValue;
    }

    private float clampMag(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float abs = Math.abs(f);
            if (abs < f2) {
                return 0.0f;
            }
            return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
        }
        return invokeCommon.floatValue;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f, @NonNull Callback callback) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{viewGroup, Float.valueOf(f), callback})) == null) {
            ViewDragHelper create = create(viewGroup, callback);
            create.mTouchSlop = (int) (create.mTouchSlop * (1.0f / f));
            return create;
        }
        return (ViewDragHelper) invokeCommon.objValue;
    }

    public boolean isEdgeTouched(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048594, this, i, i2)) == null) ? isPointerDown(i2) && (i & this.mInitialEdgesTouched[i2]) != 0 : invokeII.booleanValue;
    }

    public boolean checkTouchSlop(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int length = this.mInitialMotionX.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (checkTouchSlop(i, i2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean checkTouchSlop(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
            if (isPointerDown(i2)) {
                boolean z = (i & 1) == 1;
                boolean z2 = (i & 2) == 2;
                float f = this.mLastMotionX[i2] - this.mInitialMotionX[i2];
                float f2 = this.mLastMotionY[i2] - this.mInitialMotionY[i2];
                if (!z || !z2) {
                    return z ? Math.abs(f) > ((float) this.mTouchSlop) : z2 && Math.abs(f2) > ((float) this.mTouchSlop);
                }
                int i3 = this.mTouchSlop;
                return (f * f) + (f2 * f2) > ((float) (i3 * i3));
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    private void clearMotionHistory(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65543, this, i) == null) && this.mInitialMotionX != null && isPointerDown(i)) {
            this.mInitialMotionX[i] = 0.0f;
            this.mInitialMotionY[i] = 0.0f;
            this.mLastMotionX[i] = 0.0f;
            this.mLastMotionY[i] = 0.0f;
            this.mInitialEdgesTouched[i] = 0;
            this.mEdgeDragsInProgress[i] = 0;
            this.mEdgeDragsLocked[i] = 0;
            this.mPointersDown = (~(1 << i)) & this.mPointersDown;
        }
    }
}
