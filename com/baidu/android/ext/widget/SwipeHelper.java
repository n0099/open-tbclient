package com.baidu.android.ext.widget;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.ext.widget.VersionedHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SwipeHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ALPHA_FADE_END = 0.5f;
    public static float ALPHA_FADE_START = 0.0f;
    public static final boolean CONSTRAIN_SWIPE = true;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_ESCAPE_ANIMATION_DURATION = 200;
    public static final boolean DISMISS_IF_SWIPED_FAR_ENOUGH = true;
    public static final boolean FADE_OUT_DURING_SWIPE = true;
    public static final int MAX_DISMISS_VELOCITY = 2000;
    public static final int MAX_ESCAPE_ANIMATION_DURATION = 400;
    public static final float MAX_MOVE_SLOP = 0.3f;
    public static final boolean SLOW_ANIMATIONS = false;
    public static final int SNAP_ANIM_LEN = 150;
    public static final float SWIPE_ESCAPE_VELOCITY = 100.0f;
    public static final String TAG = "SwipeHelper";
    public static final int X = 0;
    public static final int Y = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public View mCurrAnimView;
    public View mCurrView;
    public float mCurrViewOriginalPos;
    public float mDensityScale;
    public boolean mDragging;
    public float mInitialTouchPos;
    public float mInitialTouchPosVertical;
    public float mPagingTouchSlop;
    public SwipeCallback mSwipeCallback;
    public int mSwipeDirection;
    public VelocityTracker mVelocityTracker;
    public VersionedHelper mVersionedHelper;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(103546466, "Lcom/baidu/android/ext/widget/SwipeHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(103546466, "Lcom/baidu/android/ext/widget/SwipeHelper;");
        }
    }

    public SwipeHelper(int i, SwipeCallback swipeCallback, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), swipeCallback, Float.valueOf(f), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSwipeCallback = swipeCallback;
        this.mSwipeDirection = i;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mDensityScale = f;
        this.mPagingTouchSlop = f2;
        this.mVersionedHelper = VersionedHelper.getInstance();
    }

    private void setTranslation(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65548, this, view2, f) == null) {
            if (this.mSwipeDirection == 0) {
                this.mVersionedHelper.setTranslationX(view2, f);
            } else {
                this.mVersionedHelper.setTranslationY(view2, f);
            }
        }
    }

    private float getPerpendicularVelocity(VelocityTracker velocityTracker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, velocityTracker)) == null) {
            if (this.mSwipeDirection == 0) {
                return velocityTracker.getYVelocity();
            }
            return velocityTracker.getXVelocity();
        }
        return invokeL.floatValue;
    }

    private float getPos(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, motionEvent)) == null) {
            if (this.mSwipeDirection == 0) {
                return motionEvent.getX();
            }
            return motionEvent.getY();
        }
        return invokeL.floatValue;
    }

    private float getPosVertical(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, motionEvent)) == null) {
            if (this.mSwipeDirection == 0) {
                return motionEvent.getY();
            }
            return motionEvent.getX();
        }
        return invokeL.floatValue;
    }

    private float getSize(View view2) {
        InterceptResult invokeL;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, view2)) == null) {
            if (this.mSwipeDirection == 0) {
                measuredHeight = view2.getMeasuredWidth();
            } else {
                measuredHeight = view2.getMeasuredHeight();
            }
            return measuredHeight;
        }
        return invokeL.floatValue;
    }

    private float getTranslation(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, view2)) == null) {
            if (this.mSwipeDirection == 0) {
                return this.mVersionedHelper.getTranslationX(view2);
            }
            return this.mVersionedHelper.getTranslationY(view2);
        }
        return invokeL.floatValue;
    }

    private float getVelocity(VelocityTracker velocityTracker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, velocityTracker)) == null) {
            if (this.mSwipeDirection == 0) {
                return velocityTracker.getXVelocity();
            }
            return velocityTracker.getYVelocity();
        }
        return invokeL.floatValue;
    }

    public void invalidateGlobalRegion(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.mVersionedHelper.invalidateGlobalRegion(view2, new RectF(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom()));
        }
    }

    public void setDensityScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.mDensityScale = f;
        }
    }

    public void setPagingTouchSlop(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.mPagingTouchSlop = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getAlphaForOffset(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, view2)) == null) {
            float size = getSize(view2);
            float f = 0.5f * size;
            float translation = getTranslation(view2);
            float f2 = ALPHA_FADE_START;
            float f3 = 1.0f;
            if (translation >= size * f2) {
                f3 = 1.0f - ((translation - (size * f2)) / f);
            } else if (translation < (1.0f - f2) * size) {
                f3 = 1.0f + (((size * f2) + translation) / f);
            }
            return Math.max(0.03f, f3);
        }
        return invokeL.floatValue;
    }

    public void dismissChild(View view2, float f) {
        int swipeChildIndex;
        float f2;
        int i;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLF(1048576, this, view2, f) != null) || (swipeChildIndex = this.mSwipeCallback.getSwipeChildIndex(view2)) < 0) {
            return;
        }
        int swipeAction = this.mSwipeCallback.getSwipeAdapter().getSwipeAction(swipeChildIndex);
        if (f >= 0.0f && ((f != 0.0f || getTranslation(view2) >= 0.0f) && (i2 != 0 || getTranslation(view2) != 0.0f || this.mSwipeDirection != 1))) {
            f2 = getSize(view2);
        } else {
            f2 = -getSize(view2);
        }
        if (f != 0.0f) {
            i = Math.min(400, (int) ((Math.abs(f2 - getTranslation(view2)) * 1000.0f) / Math.abs(f)));
        } else {
            i = 200;
        }
        if (this.mSwipeDirection == 0) {
            str = Key.TRANSLATION_X;
        } else {
            str = Key.TRANSLATION_Y;
        }
        this.mVersionedHelper.startAnimation(view2, i, str, Float.valueOf(f2), new VersionedHelper.VersionedAnimationListener(this, swipeAction, view2, view2) { // from class: com.baidu.android.ext.widget.SwipeHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwipeHelper this$0;
            public final /* synthetic */ View val$animView;
            public final /* synthetic */ int val$animViewSwipAction;
            public final /* synthetic */ View val$view;

            @Override // com.baidu.android.ext.widget.VersionedHelper.VersionedAnimationListener
            public void onAnimationRepeat() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.baidu.android.ext.widget.VersionedHelper.VersionedAnimationListener
            public void onAnimationStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(swipeAction), view2, view2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$animViewSwipAction = swipeAction;
                this.val$animView = view2;
                this.val$view = view2;
            }

            @Override // com.baidu.android.ext.widget.VersionedHelper.VersionedAnimationListener
            public void onAnimationEnd() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mSwipeCallback.onChildDismissed(this.val$view);
                }
            }

            @Override // com.baidu.android.ext.widget.VersionedHelper.VersionedAnimationListener
            public void onAnimationUpdate() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    if ((this.val$animViewSwipAction & 2) == 2) {
                        VersionedHelper versionedHelper = this.this$0.mVersionedHelper;
                        View view3 = this.val$animView;
                        versionedHelper.setAlpha(view3, this.this$0.getAlphaForOffset(view3));
                    }
                    this.this$0.invalidateGlobalRegion(this.val$animView);
                }
            }
        });
    }

    public boolean isDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDragging;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
        if (r0 != 3) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (this.mCurrView != null) {
                            this.mVelocityTracker.addMovement(motionEvent);
                            float pos = getPos(motionEvent);
                            float posVertical = getPosVertical(motionEvent);
                            float f = pos - this.mInitialTouchPos;
                            float f2 = posVertical - this.mInitialTouchPosVertical;
                            float f3 = Float.MAX_VALUE;
                            if (f != 0.0f) {
                                f3 = Math.abs(f2 / f);
                            }
                            if (Math.abs(f) > this.mPagingTouchSlop && f3 < 0.3f) {
                                this.mSwipeCallback.onBeginDrag(this.mCurrView);
                                this.mDragging = true;
                                this.mInitialTouchPos = getPos(motionEvent) - getTranslation(this.mCurrAnimView);
                            }
                        }
                    }
                }
                this.mDragging = false;
                this.mCurrView = null;
                this.mCurrAnimView = null;
            } else {
                this.mDragging = false;
                this.mCurrView = this.mSwipeCallback.getSwipeChildAtPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                this.mVelocityTracker.clear();
                View view2 = this.mCurrView;
                if (view2 != null) {
                    this.mCurrViewOriginalPos = getTranslation(view2);
                    this.mCurrAnimView = this.mCurrView;
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mInitialTouchPos = getPos(motionEvent);
                    this.mInitialTouchPosVertical = getPosVertical(motionEvent);
                }
            }
            return this.mDragging;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
        if (r0 != 4) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0105 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int swipeChildIndex;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            boolean z5 = false;
            if (!this.mDragging) {
                return false;
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int action = motionEvent.getAction();
            float f = 0.0f;
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                    }
                }
                View view2 = this.mCurrView;
                if (view2 != null) {
                    int swipeChildIndex2 = this.mSwipeCallback.getSwipeChildIndex(view2);
                    if (swipeChildIndex2 < 0) {
                        return false;
                    }
                    int swipeAction = this.mSwipeCallback.getSwipeAdapter().getSwipeAction(swipeChildIndex2);
                    float pos = getPos(motionEvent) - this.mInitialTouchPos;
                    if ((swipeAction & 1) == 1) {
                        int i = swipeAction & 2;
                        if (i != 2) {
                            float size = getSize(this.mCurrAnimView);
                            float f2 = 0.15f * size;
                            if (Math.abs(pos) >= size) {
                                if (pos > 0.0f) {
                                    pos = f2;
                                } else {
                                    pos = -f2;
                                }
                            } else {
                                pos = ((float) Math.sin((pos / size) * 1.5707963267948966d)) * f2;
                            }
                        }
                        setTranslation(this.mCurrAnimView, pos);
                        if (i == 2) {
                            VersionedHelper versionedHelper = this.mVersionedHelper;
                            View view3 = this.mCurrAnimView;
                            versionedHelper.setAlpha(view3, getAlphaForOffset(view3));
                        }
                        invalidateGlobalRegion(this.mCurrView);
                    }
                }
                return true;
            }
            if (this.mCurrView != null) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mDensityScale * 2000.0f);
                float f3 = this.mDensityScale * 100.0f;
                float velocity = getVelocity(this.mVelocityTracker);
                float perpendicularVelocity = getPerpendicularVelocity(this.mVelocityTracker);
                if (Math.abs(getTranslation(this.mCurrAnimView)) > getSize(this.mCurrAnimView) * 0.4d) {
                    z = true;
                } else {
                    z = false;
                }
                if (Math.abs(velocity) > f3 && Math.abs(velocity) > Math.abs(perpendicularVelocity)) {
                    if (velocity > 0.0f) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (getTranslation(this.mCurrAnimView) > 0.0f) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z3 == z4) {
                        z2 = true;
                        swipeChildIndex = this.mSwipeCallback.getSwipeChildIndex(this.mCurrView);
                        if (swipeChildIndex >= 0) {
                            return false;
                        }
                        if ((this.mSwipeCallback.getSwipeAdapter().getSwipeAction(swipeChildIndex) & 2) == 2 && (z2 || z)) {
                            z5 = true;
                        }
                        if (z5) {
                            View view4 = this.mCurrView;
                            if (z2) {
                                f = velocity;
                            }
                            dismissChild(view4, f);
                        } else {
                            this.mSwipeCallback.onDragCancelled(this.mCurrView);
                            snapChild(this.mCurrView, velocity, this.mCurrViewOriginalPos);
                        }
                    }
                }
                z2 = false;
                swipeChildIndex = this.mSwipeCallback.getSwipeChildIndex(this.mCurrView);
                if (swipeChildIndex >= 0) {
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void snapChild(View view2, float f, float f2) {
        int swipeChildIndex;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) != null) || (swipeChildIndex = this.mSwipeCallback.getSwipeChildIndex(view2)) < 0) {
            return;
        }
        int swipeAction = this.mSwipeCallback.getSwipeAdapter().getSwipeAction(swipeChildIndex);
        if (this.mSwipeDirection == 0) {
            str = Key.TRANSLATION_X;
        } else {
            str = Key.TRANSLATION_Y;
        }
        this.mVersionedHelper.startAnimation(view2, 150, str, Float.valueOf(f2), new VersionedHelper.VersionedAnimationListener(this, swipeAction, view2) { // from class: com.baidu.android.ext.widget.SwipeHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwipeHelper this$0;
            public final /* synthetic */ View val$animView;
            public final /* synthetic */ int val$animViewSwipAction;

            @Override // com.baidu.android.ext.widget.VersionedHelper.VersionedAnimationListener
            public void onAnimationEnd() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.android.ext.widget.VersionedHelper.VersionedAnimationListener
            public void onAnimationRepeat() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.baidu.android.ext.widget.VersionedHelper.VersionedAnimationListener
            public void onAnimationStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(swipeAction), view2};
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
                this.val$animViewSwipAction = swipeAction;
                this.val$animView = view2;
            }

            @Override // com.baidu.android.ext.widget.VersionedHelper.VersionedAnimationListener
            public void onAnimationUpdate() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    if ((this.val$animViewSwipAction & 2) == 2) {
                        VersionedHelper versionedHelper = this.this$0.mVersionedHelper;
                        View view3 = this.val$animView;
                        versionedHelper.setAlpha(view3, this.this$0.getAlphaForOffset(view3));
                    }
                    this.this$0.invalidateGlobalRegion(this.val$animView);
                }
            }
        });
    }
}
