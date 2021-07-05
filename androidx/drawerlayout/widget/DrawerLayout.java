package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class DrawerLayout extends ViewGroup implements Openable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
    public static final boolean ALLOW_EDGE_LOCK = false;
    public static final boolean CAN_HIDE_DESCENDANTS;
    public static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    public static final int DEFAULT_SCRIM_COLOR = -1728053248;
    public static final int[] LAYOUT_ATTRS;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    public static final int MIN_DRAWER_MARGIN = 64;
    public static final int MIN_FLING_VELOCITY = 400;
    public static final int PEEK_DELAY = 160;
    public static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final String TAG = "DrawerLayout";
    public static final int[] THEME_ATTRS;
    public static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    public static boolean sEdgeSizeUsingSystemGestureInsets;
    public transient /* synthetic */ FieldHolder $fh;
    public final AccessibilityViewCommand mActionDismiss;
    public final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    public Rect mChildHitRect;
    public Matrix mChildInvertedMatrix;
    public boolean mChildrenCanceledTouch;
    public boolean mDrawStatusBarBackground;
    public float mDrawerElevation;
    public int mDrawerState;
    public boolean mFirstLayout;
    public boolean mInLayout;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public Object mLastInsets;
    public final ViewDragCallback mLeftCallback;
    public final ViewDragHelper mLeftDragger;
    @Nullable
    public DrawerListener mListener;
    public List<DrawerListener> mListeners;
    public int mLockModeEnd;
    public int mLockModeLeft;
    public int mLockModeRight;
    public int mLockModeStart;
    public int mMinDrawerMargin;
    public final ArrayList<View> mNonDrawerViews;
    public final ViewDragCallback mRightCallback;
    public final ViewDragHelper mRightDragger;
    public int mScrimColor;
    public float mScrimOpacity;
    public Paint mScrimPaint;
    public Drawable mShadowEnd;
    public Drawable mShadowLeft;
    public Drawable mShadowLeftResolved;
    public Drawable mShadowRight;
    public Drawable mShadowRightResolved;
    public Drawable mShadowStart;
    public Drawable mStatusBarBackground;
    public CharSequence mTitleLeft;
    public CharSequence mTitleRight;

    /* loaded from: classes.dex */
    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Rect mTmpRect;
        public final /* synthetic */ DrawerLayout this$0;

        public AccessibilityDelegate(DrawerLayout drawerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = drawerLayout;
            this.mTmpRect = new Rect();
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, accessibilityNodeInfoCompat, viewGroup) == null) {
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (DrawerLayout.includeChildForAccessibility(childAt)) {
                        accessibilityNodeInfoCompat.addChild(childAt);
                    }
                }
            }
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, accessibilityNodeInfoCompat, accessibilityNodeInfoCompat2) == null) {
                Rect rect = this.mTmpRect;
                accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
                accessibilityNodeInfoCompat.setBoundsInScreen(rect);
                accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
                accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
                accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
                accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
                accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
                accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
                accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
                accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
                accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, accessibilityEvent)) == null) {
                if (accessibilityEvent.getEventType() == 32) {
                    List<CharSequence> text = accessibilityEvent.getText();
                    View findVisibleDrawer = this.this$0.findVisibleDrawer();
                    if (findVisibleDrawer != null) {
                        CharSequence drawerTitle = this.this$0.getDrawerTitle(this.this$0.getDrawerViewAbsoluteGravity(findVisibleDrawer));
                        if (drawerTitle != null) {
                            text.add(drawerTitle);
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, accessibilityNodeInfoCompat) == null) {
                if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                } else {
                    AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                    super.onInitializeAccessibilityNodeInfo(view, obtain);
                    accessibilityNodeInfoCompat.setSource(view);
                    ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
                    if (parentForAccessibility instanceof View) {
                        accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                    }
                    copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
                    obtain.recycle();
                    addChildrenForAccessibility(accessibilityNodeInfoCompat, (ViewGroup) view);
                }
                accessibilityNodeInfoCompat.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
                accessibilityNodeInfoCompat.setFocusable(false);
                accessibilityNodeInfoCompat.setFocused(false);
                accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
                accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, viewGroup, view, accessibilityEvent)) == null) {
                if (DrawerLayout.CAN_HIDE_DESCENDANTS || DrawerLayout.includeChildForAccessibility(view)) {
                    return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ChildAccessibilityDelegate() {
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

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, accessibilityNodeInfoCompat) == null) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (DrawerLayout.includeChildForAccessibility(view)) {
                    return;
                }
                accessibilityNodeInfoCompat.setParent(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface DrawerListener {
        void onDrawerClosed(@NonNull View view);

        void onDrawerOpened(@NonNull View view);

        void onDrawerSlide(@NonNull View view, float f2);

        void onDrawerStateChanged(int i2);
    }

    /* loaded from: classes.dex */
    public static abstract class SimpleDrawerListener implements DrawerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SimpleDrawerListener() {
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

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class ViewDragCallback extends ViewDragHelper.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mAbsGravity;
        public ViewDragHelper mDragger;
        public final Runnable mPeekRunnable;
        public final /* synthetic */ DrawerLayout this$0;

        public ViewDragCallback(DrawerLayout drawerLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawerLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = drawerLayout;
            this.mPeekRunnable = new Runnable(this) { // from class: androidx.drawerlayout.widget.DrawerLayout.ViewDragCallback.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ViewDragCallback this$1;

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
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$1.peekDrawer();
                    }
                }
            };
            this.mAbsGravity = i2;
        }

        private void closeOtherDrawer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                View findDrawerWithGravity = this.this$0.findDrawerWithGravity(this.mAbsGravity == 3 ? 5 : 3);
                if (findDrawerWithGravity != null) {
                    this.this$0.closeDrawer(findDrawerWithGravity);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view, i2, i3)) == null) {
                if (this.this$0.checkDrawerViewAbsoluteGravity(view, 3)) {
                    return Math.max(-view.getWidth(), Math.min(i2, 0));
                }
                int width = this.this$0.getWidth();
                return Math.max(width - view.getWidth(), Math.min(i2, width));
            }
            return invokeLII.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, i3)) == null) ? view.getTop() : invokeLII.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
                if (this.this$0.isDrawerView(view)) {
                    return view.getWidth();
                }
                return 0;
            }
            return invokeL.intValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i2, int i3) {
            View findDrawerWithGravity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
                if ((i2 & 1) == 1) {
                    findDrawerWithGravity = this.this$0.findDrawerWithGravity(3);
                } else {
                    findDrawerWithGravity = this.this$0.findDrawerWithGravity(5);
                }
                if (findDrawerWithGravity == null || this.this$0.getDrawerLockMode(findDrawerWithGravity) != 0) {
                    return;
                }
                this.mDragger.captureChildView(findDrawerWithGravity, i3);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
                this.this$0.postDelayed(this.mPeekRunnable, 160L);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048582, this, view, i2) == null) {
                ((LayoutParams) view.getLayoutParams()).isPeeking = false;
                closeOtherDrawer();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.this$0.updateDrawerState(i2, this.mDragger.getCapturedView());
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                int width = view.getWidth();
                float width2 = (this.this$0.checkDrawerViewAbsoluteGravity(view, 3) ? i2 + width : this.this$0.getWidth() - i2) / width;
                this.this$0.setDrawerViewOffset(view, width2);
                view.setVisibility(width2 == 0.0f ? 4 : 0);
                this.this$0.invalidate();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                float drawerViewOffset = this.this$0.getDrawerViewOffset(view);
                int width = view.getWidth();
                if (this.this$0.checkDrawerViewAbsoluteGravity(view, 3)) {
                    int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    i2 = (i3 > 0 || (i3 == 0 && drawerViewOffset > 0.5f)) ? 0 : -width;
                } else {
                    int width2 = this.this$0.getWidth();
                    if (f2 < 0.0f || (f2 == 0.0f && drawerViewOffset > 0.5f)) {
                        width2 -= width;
                    }
                    i2 = width2;
                }
                this.mDragger.settleCapturedViewAt(i2, view.getTop());
                this.this$0.invalidate();
            }
        }

        public void peekDrawer() {
            View findDrawerWithGravity;
            int width;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                int edgeSize = this.mDragger.getEdgeSize();
                boolean z = this.mAbsGravity == 3;
                if (z) {
                    findDrawerWithGravity = this.this$0.findDrawerWithGravity(3);
                    width = (findDrawerWithGravity != null ? -findDrawerWithGravity.getWidth() : 0) + edgeSize;
                } else {
                    findDrawerWithGravity = this.this$0.findDrawerWithGravity(5);
                    width = this.this$0.getWidth() - edgeSize;
                }
                if (findDrawerWithGravity != null) {
                    if (((!z || findDrawerWithGravity.getLeft() >= width) && (z || findDrawerWithGravity.getLeft() <= width)) || this.this$0.getDrawerLockMode(findDrawerWithGravity) != 0) {
                        return;
                    }
                    this.mDragger.smoothSlideViewTo(findDrawerWithGravity, width, findDrawerWithGravity.getTop());
                    ((LayoutParams) findDrawerWithGravity.getLayoutParams()).isPeeking = true;
                    this.this$0.invalidate();
                    closeOtherDrawer();
                    this.this$0.cancelChildViewTouch();
                }
            }
        }

        public void removeCallbacks() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.this$0.removeCallbacks(this.mPeekRunnable);
            }
        }

        public void setDragger(ViewDragHelper viewDragHelper) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, viewDragHelper) == null) {
                this.mDragger = viewDragHelper;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, view, i2)) == null) ? this.this$0.isDrawerView(view) && this.this$0.checkDrawerViewAbsoluteGravity(view, this.mAbsGravity) && this.this$0.getDrawerLockMode(view) == 0 : invokeLI.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1533780401, "Landroidx/drawerlayout/widget/DrawerLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1533780401, "Landroidx/drawerlayout/widget/DrawerLayout;");
                return;
            }
        }
        THEME_ATTRS = new int[]{16843828};
        LAYOUT_ATTRS = new int[]{16842931};
        CAN_HIDE_DESCENDANTS = Build.VERSION.SDK_INT >= 19;
        SET_DRAWER_SHADOW_FROM_ELEVATION = Build.VERSION.SDK_INT >= 21;
        sEdgeSizeUsingSystemGestureInsets = Build.VERSION.SDK_INT >= 29;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DrawerLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, motionEvent, view)) == null) {
            if (!view.getMatrix().isIdentity()) {
                MotionEvent transformedMotionEvent = getTransformedMotionEvent(motionEvent, view);
                boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(transformedMotionEvent);
                transformedMotionEvent.recycle();
                return dispatchGenericMotionEvent;
            }
            float scrollX = getScrollX() - view.getLeft();
            float scrollY = getScrollY() - view.getTop();
            motionEvent.offsetLocation(scrollX, scrollY);
            boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
            motionEvent.offsetLocation(-scrollX, -scrollY);
            return dispatchGenericMotionEvent2;
        }
        return invokeLL.booleanValue;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent motionEvent, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, motionEvent, view)) == null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.offsetLocation(getScrollX() - view.getLeft(), getScrollY() - view.getTop());
            Matrix matrix = view.getMatrix();
            if (!matrix.isIdentity()) {
                if (this.mChildInvertedMatrix == null) {
                    this.mChildInvertedMatrix = new Matrix();
                }
                matrix.invert(this.mChildInvertedMatrix);
                obtain.transform(this.mChildInvertedMatrix);
            }
            return obtain;
        }
        return (MotionEvent) invokeLL.objValue;
    }

    public static String gravityToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? (i2 & 3) == 3 ? "LEFT" : (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2) : (String) invokeI.objValue;
    }

    public static boolean hasOpaqueBackground(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) {
            Drawable background = view.getBackground();
            return background != null && background.getOpacity() == -1;
        }
        return invokeL.booleanValue;
    }

    private boolean hasPeekingDrawer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (((LayoutParams) getChildAt(i2).getLayoutParams()).isPeeking) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean hasVisibleDrawer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? findVisibleDrawer() != null : invokeV.booleanValue;
    }

    public static boolean includeChildForAccessibility(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, view)) == null) ? (ViewCompat.getImportantForAccessibility(view) == 4 || ViewCompat.getImportantForAccessibility(view) == 2) ? false : true : invokeL.booleanValue;
    }

    private boolean isInBoundsOfChild(float f2, float f3, View view) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), view})) == null) {
            if (this.mChildHitRect == null) {
                this.mChildHitRect = new Rect();
            }
            view.getHitRect(this.mChildHitRect);
            return this.mChildHitRect.contains((int) f2, (int) f3);
        }
        return invokeCommon.booleanValue;
    }

    private void mirror(Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65548, this, drawable, i2) == null) && drawable != null && DrawableCompat.isAutoMirrored(drawable)) {
            DrawableCompat.setLayoutDirection(drawable, i2);
        }
    }

    private Drawable resolveLeftShadow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            if (layoutDirection == 0) {
                Drawable drawable = this.mShadowStart;
                if (drawable != null) {
                    mirror(drawable, layoutDirection);
                    return this.mShadowStart;
                }
            } else {
                Drawable drawable2 = this.mShadowEnd;
                if (drawable2 != null) {
                    mirror(drawable2, layoutDirection);
                    return this.mShadowEnd;
                }
            }
            return this.mShadowLeft;
        }
        return (Drawable) invokeV.objValue;
    }

    private Drawable resolveRightShadow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            if (layoutDirection == 0) {
                Drawable drawable = this.mShadowEnd;
                if (drawable != null) {
                    mirror(drawable, layoutDirection);
                    return this.mShadowEnd;
                }
            } else {
                Drawable drawable2 = this.mShadowStart;
                if (drawable2 != null) {
                    mirror(drawable2, layoutDirection);
                    return this.mShadowStart;
                }
            }
            return this.mShadowRight;
        }
        return (Drawable) invokeV.objValue;
    }

    private void resolveShadowDrawables() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        this.mShadowLeftResolved = resolveLeftShadow();
        this.mShadowRightResolved = resolveRightShadow();
    }

    private void updateChildAccessibilityAction(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, view) == null) {
            ViewCompat.removeAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS.getId());
            if (!isDrawerOpen(view) || getDrawerLockMode(view) == 2) {
                return;
            }
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, this.mActionDismiss);
        }
    }

    private void updateChildrenImportantForAccessibility(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65553, this, view, z) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if ((!z && !isDrawerView(childAt)) || (z && childAt == view)) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                } else {
                    ViewCompat.setImportantForAccessibility(childAt, 4);
                }
            }
        }
    }

    public void addDrawerListener(@NonNull DrawerListener drawerListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, drawerListener) == null) || drawerListener == null) {
            return;
        }
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, i2, i3) == null) || getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (isDrawerView(childAt)) {
                if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z = true;
                }
            } else {
                this.mNonDrawerViews.add(childAt);
            }
        }
        if (!z) {
            int size = this.mNonDrawerViews.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = this.mNonDrawerViews.get(i5);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i2, i3);
                }
            }
        }
        this.mNonDrawerViews.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i2, layoutParams) == null) {
            super.addView(view, i2, layoutParams);
            if (findOpenDrawer() == null && !isDrawerView(view)) {
                ViewCompat.setImportantForAccessibility(view, 1);
            } else {
                ViewCompat.setImportantForAccessibility(view, 4);
            }
            if (CAN_HIDE_DESCENDANTS) {
                return;
            }
            ViewCompat.setAccessibilityDelegate(view, this.mChildAccessibilityDelegate);
        }
    }

    public void cancelChildViewTouch() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mChildrenCanceledTouch) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        this.mChildrenCanceledTouch = true;
    }

    public boolean checkDrawerViewAbsoluteGravity(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, view, i2)) == null) ? (getDrawerViewAbsoluteGravity(view) & i2) == i2 : invokeLI.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, layoutParams)) == null) ? (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams) : invokeL.booleanValue;
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getDrawerLockMode(GravityCompat.START) == 2) {
            return;
        }
        closeDrawer(GravityCompat.START);
    }

    public void closeDrawer(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            closeDrawer(view, true);
        }
    }

    public void closeDrawers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            closeDrawers(false);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int childCount = getChildCount();
            float f2 = 0.0f;
            for (int i2 = 0; i2 < childCount; i2++) {
                f2 = Math.max(f2, ((LayoutParams) getChildAt(i2).getLayoutParams()).onScreen);
            }
            this.mScrimOpacity = f2;
            boolean continueSettling = this.mLeftDragger.continueSettling(true);
            boolean continueSettling2 = this.mRightDragger.continueSettling(true);
            if (continueSettling || continueSettling2) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.mScrimOpacity > 0.0f) {
                int childCount = getChildCount();
                if (childCount != 0) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    for (int i2 = childCount - 1; i2 >= 0; i2--) {
                        View childAt = getChildAt(i2);
                        if (isInBoundsOfChild(x, y, childAt) && !isContentView(childAt) && dispatchTransformedGenericPointerEvent(motionEvent, childAt)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void dispatchOnDrawerClosed(View view) {
        View rootView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if ((layoutParams.openState & 1) == 1) {
                layoutParams.openState = 0;
                List<DrawerListener> list = this.mListeners;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        this.mListeners.get(size).onDrawerClosed(view);
                    }
                }
                updateChildrenImportantForAccessibility(view, false);
                updateChildAccessibilityAction(view);
                if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                    return;
                }
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    public void dispatchOnDrawerOpened(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if ((layoutParams.openState & 1) == 0) {
                layoutParams.openState = 1;
                List<DrawerListener> list = this.mListeners;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        this.mListeners.get(size).onDrawerOpened(view);
                    }
                }
                updateChildrenImportantForAccessibility(view, true);
                updateChildAccessibilityAction(view);
                if (hasWindowFocus()) {
                    sendAccessibilityEvent(32);
                }
            }
        }
    }

    public void dispatchOnDrawerSlide(View view, float f2) {
        List<DrawerListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048593, this, view, f2) == null) || (list = this.mListeners) == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            this.mListeners.get(size).onDrawerSlide(view, f2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{canvas, view, Long.valueOf(j)})) == null) {
            int height = getHeight();
            boolean isContentView = isContentView(view);
            int width = getWidth();
            int save = canvas.save();
            int i2 = 0;
            if (isContentView) {
                int childCount = getChildCount();
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt != view && childAt.getVisibility() == 0 && hasOpaqueBackground(childAt) && isDrawerView(childAt) && childAt.getHeight() >= height) {
                        if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                            int right = childAt.getRight();
                            if (right > i3) {
                                i3 = right;
                            }
                        } else {
                            int left = childAt.getLeft();
                            if (left < width) {
                                width = left;
                            }
                        }
                    }
                }
                canvas.clipRect(i3, 0, width, getHeight());
                i2 = i3;
            }
            boolean drawChild = super.drawChild(canvas, view, j);
            canvas.restoreToCount(save);
            float f2 = this.mScrimOpacity;
            if (f2 > 0.0f && isContentView) {
                int i5 = this.mScrimColor;
                this.mScrimPaint.setColor((i5 & 16777215) | (((int) ((((-16777216) & i5) >>> 24) * f2)) << 24));
                canvas.drawRect(i2, 0.0f, width, getHeight(), this.mScrimPaint);
            } else if (this.mShadowLeftResolved != null && checkDrawerViewAbsoluteGravity(view, 3)) {
                int intrinsicWidth = this.mShadowLeftResolved.getIntrinsicWidth();
                int right2 = view.getRight();
                float max = Math.max(0.0f, Math.min(right2 / this.mLeftDragger.getEdgeSize(), 1.0f));
                this.mShadowLeftResolved.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.mShadowLeftResolved.setAlpha((int) (max * 255.0f));
                this.mShadowLeftResolved.draw(canvas);
            } else if (this.mShadowRightResolved != null && checkDrawerViewAbsoluteGravity(view, 5)) {
                int intrinsicWidth2 = this.mShadowRightResolved.getIntrinsicWidth();
                int left2 = view.getLeft();
                float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.mRightDragger.getEdgeSize(), 1.0f));
                this.mShadowRightResolved.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.mShadowRightResolved.setAlpha((int) (max2 * 255.0f));
                this.mShadowRightResolved.draw(canvas);
            }
            return drawChild;
        }
        return invokeCommon.booleanValue;
    }

    public View findDrawerWithGravity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this)) & 7;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if ((getDrawerViewAbsoluteGravity(childAt) & 7) == absoluteGravity) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public View findOpenDrawer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if ((((LayoutParams) childAt.getLayoutParams()).openState & 1) == 1) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public View findVisibleDrawer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (isDrawerView(childAt) && isDrawerVisible(childAt)) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? new LayoutParams(-1, -1) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, layoutParams)) == null) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public float getDrawerElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
                return this.mDrawerElevation;
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public int getDrawerLockMode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            if (i2 == 3) {
                int i3 = this.mLockModeLeft;
                if (i3 != 3) {
                    return i3;
                }
                int i4 = layoutDirection == 0 ? this.mLockModeStart : this.mLockModeEnd;
                if (i4 != 3) {
                    return i4;
                }
                return 0;
            } else if (i2 == 5) {
                int i5 = this.mLockModeRight;
                if (i5 != 3) {
                    return i5;
                }
                int i6 = layoutDirection == 0 ? this.mLockModeEnd : this.mLockModeStart;
                if (i6 != 3) {
                    return i6;
                }
                return 0;
            } else if (i2 == 8388611) {
                int i7 = this.mLockModeStart;
                if (i7 != 3) {
                    return i7;
                }
                int i8 = layoutDirection == 0 ? this.mLockModeLeft : this.mLockModeRight;
                if (i8 != 3) {
                    return i8;
                }
                return 0;
            } else if (i2 != 8388613) {
                return 0;
            } else {
                int i9 = this.mLockModeEnd;
                if (i9 != 3) {
                    return i9;
                }
                int i10 = layoutDirection == 0 ? this.mLockModeRight : this.mLockModeLeft;
                if (i10 != 3) {
                    return i10;
                }
                return 0;
            }
        }
        return invokeI.intValue;
    }

    @Nullable
    public CharSequence getDrawerTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
            if (absoluteGravity == 3) {
                return this.mTitleLeft;
            }
            if (absoluteGravity == 5) {
                return this.mTitleRight;
            }
            return null;
        }
        return (CharSequence) invokeI.objValue;
    }

    public int getDrawerViewAbsoluteGravity(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view)) == null) ? GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this)) : invokeL.intValue;
    }

    public float getDrawerViewOffset(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, view)) == null) ? ((LayoutParams) view.getLayoutParams()).onScreen : invokeL.floatValue;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mStatusBarBackground : (Drawable) invokeV.objValue;
    }

    public boolean isContentView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, view)) == null) ? ((LayoutParams) view.getLayoutParams()).gravity == 0 : invokeL.booleanValue;
    }

    public boolean isDrawerOpen(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, view)) == null) {
            if (isDrawerView(view)) {
                return (((LayoutParams) view.getLayoutParams()).openState & 1) == 1;
            }
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return invokeL.booleanValue;
    }

    public boolean isDrawerView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, view)) == null) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view));
            return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public boolean isDrawerVisible(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, view)) == null) {
            if (isDrawerView(view)) {
                return ((LayoutParams) view.getLayoutParams()).onScreen > 0.0f;
            }
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? isDrawerOpen(GravityCompat.START) : invokeV.booleanValue;
    }

    public void moveDrawerToOffset(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048615, this, view, f2) == null) {
            float drawerViewOffset = getDrawerViewOffset(view);
            float width = view.getWidth();
            int i2 = ((int) (width * f2)) - ((int) (drawerViewOffset * width));
            if (!checkDrawerViewAbsoluteGravity(view, 3)) {
                i2 = -i2;
            }
            view.offsetLeftAndRight(i2);
            setDrawerViewOffset(view, f2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onAttachedToWindow();
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onDetachedFromWindow();
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, canvas) == null) {
            super.onDraw(canvas);
            if (!this.mDrawStatusBarBackground || this.mStatusBarBackground == null) {
                return;
            }
            int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.mLastInsets) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
            if (systemWindowInsetTop > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r0 != 3) goto L9;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        View findTopChildUnder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            boolean shouldInterceptTouchEvent = this.mLeftDragger.shouldInterceptTouchEvent(motionEvent) | this.mRightDragger.shouldInterceptTouchEvent(motionEvent);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (this.mLeftDragger.checkTouchSlop(3)) {
                            this.mLeftCallback.removeCallbacks();
                            this.mRightCallback.removeCallbacks();
                        }
                    }
                    z = false;
                }
                closeDrawers(true);
                this.mChildrenCanceledTouch = false;
                z = false;
            } else {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                z = this.mScrimOpacity > 0.0f && (findTopChildUnder = this.mLeftDragger.findTopChildUnder((int) x, (int) y)) != null && isContentView(findTopChildUnder);
                this.mChildrenCanceledTouch = false;
            }
            return shouldInterceptTouchEvent || z || hasPeekingDrawer() || this.mChildrenCanceledTouch;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048620, this, i2, keyEvent)) == null) {
            if (i2 == 4 && hasVisibleDrawer()) {
                keyEvent.startTracking();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048621, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                View findVisibleDrawer = findVisibleDrawer();
                if (findVisibleDrawer != null && getDrawerLockMode(findVisibleDrawer) == 0) {
                    closeDrawers();
                }
                return findVisibleDrawer != null;
            }
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        WindowInsets rootWindowInsets;
        int i6;
        float f2;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mInLayout = true;
            int i8 = i4 - i2;
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (isContentView(childAt)) {
                        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        childAt.layout(i10, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i10, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                    } else {
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                            float f3 = measuredWidth;
                            i7 = (-measuredWidth) + ((int) (layoutParams.onScreen * f3));
                            f2 = (measuredWidth + i7) / f3;
                        } else {
                            float f4 = measuredWidth;
                            f2 = (i8 - i6) / f4;
                            i7 = i8 - ((int) (layoutParams.onScreen * f4));
                        }
                        boolean z2 = f2 != layoutParams.onScreen;
                        int i11 = layoutParams.gravity & 112;
                        if (i11 == 16) {
                            int i12 = i5 - i3;
                            int i13 = (i12 - measuredHeight) / 2;
                            int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            if (i13 < i14) {
                                i13 = i14;
                            } else {
                                int i15 = i13 + measuredHeight;
                                int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                                if (i15 > i12 - i16) {
                                    i13 = (i12 - i16) - measuredHeight;
                                }
                            }
                            childAt.layout(i7, i13, measuredWidth + i7, measuredHeight + i13);
                        } else if (i11 != 80) {
                            int i17 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            childAt.layout(i7, i17, measuredWidth + i7, measuredHeight + i17);
                        } else {
                            int i18 = i5 - i3;
                            childAt.layout(i7, (i18 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i18 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                        if (z2) {
                            setDrawerViewOffset(childAt, f2);
                        }
                        int i19 = layoutParams.onScreen > 0.0f ? 0 : 4;
                        if (childAt.getVisibility() != i19) {
                            childAt.setVisibility(i19);
                        }
                    }
                }
            }
            if (sEdgeSizeUsingSystemGestureInsets && (rootWindowInsets = getRootWindowInsets()) != null) {
                Insets systemGestureInsets = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets).getSystemGestureInsets();
                ViewDragHelper viewDragHelper = this.mLeftDragger;
                viewDragHelper.setEdgeSize(Math.max(viewDragHelper.getDefaultEdgeSize(), systemGestureInsets.left));
                ViewDragHelper viewDragHelper2 = this.mRightDragger;
                viewDragHelper2.setEdgeSize(Math.max(viewDragHelper2.getDefaultEdgeSize(), systemGestureInsets.right));
            }
            this.mInLayout = false;
            this.mFirstLayout = false;
        }
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode != 1073741824 || mode2 != 1073741824) {
                if (!isInEditMode()) {
                    throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
                }
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            }
            setMeasuredDimension(size, size2);
            int i4 = 0;
            boolean z = this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this);
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            int childCount = getChildCount();
            int i5 = 0;
            boolean z2 = false;
            boolean z3 = false;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (z) {
                        int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.gravity, layoutDirection);
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                WindowInsets windowInsets = (WindowInsets) this.mLastInsets;
                                if (absoluteGravity == 3) {
                                    windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i4, windowInsets.getSystemWindowInsetBottom());
                                } else if (absoluteGravity == 5) {
                                    windowInsets = windowInsets.replaceSystemWindowInsets(i4, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                                }
                                childAt.dispatchApplyWindowInsets(windowInsets);
                            }
                        } else if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets2 = (WindowInsets) this.mLastInsets;
                            if (absoluteGravity == 3) {
                                windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i4, windowInsets2.getSystemWindowInsetBottom());
                            } else if (absoluteGravity == 5) {
                                windowInsets2 = windowInsets2.replaceSystemWindowInsets(i4, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                            }
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsets2.getSystemWindowInsetTop();
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsets2.getSystemWindowInsetRight();
                            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                        }
                    }
                    if (isContentView(childAt)) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                    } else if (isDrawerView(childAt)) {
                        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
                            float elevation = ViewCompat.getElevation(childAt);
                            float f2 = this.mDrawerElevation;
                            if (elevation != f2) {
                                ViewCompat.setElevation(childAt, f2);
                            }
                        }
                        int drawerViewAbsoluteGravity = getDrawerViewAbsoluteGravity(childAt) & 7;
                        boolean z4 = drawerViewAbsoluteGravity == 3;
                        if ((z4 && z2) || (!z4 && z3)) {
                            throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(drawerViewAbsoluteGravity) + " but this " + TAG + " already has a drawer view along that edge");
                        }
                        if (z4) {
                            z2 = true;
                        } else {
                            z3 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i2, this.mMinDrawerMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                        i5++;
                        i4 = 0;
                    } else {
                        throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                }
                i5++;
                i4 = 0;
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View findDrawerWithGravity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i2 = savedState.openDrawerGravity;
            if (i2 != 0 && (findDrawerWithGravity = findDrawerWithGravity(i2)) != null) {
                openDrawer(findDrawerWithGravity);
            }
            int i3 = savedState.lockModeLeft;
            if (i3 != 3) {
                setDrawerLockMode(i3, 3);
            }
            int i4 = savedState.lockModeRight;
            if (i4 != 3) {
                setDrawerLockMode(i4, 5);
            }
            int i5 = savedState.lockModeStart;
            if (i5 != 3) {
                setDrawerLockMode(i5, GravityCompat.START);
            }
            int i6 = savedState.lockModeEnd;
            if (i6 != 3) {
                setDrawerLockMode(i6, 8388613);
            }
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            resolveShadowDrawables();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                boolean z = layoutParams.openState == 1;
                boolean z2 = layoutParams.openState == 2;
                if (z || z2) {
                    savedState.openDrawerGravity = layoutParams.gravity;
                    break;
                }
            }
            savedState.lockModeLeft = this.mLockModeLeft;
            savedState.lockModeRight = this.mLockModeRight;
            savedState.lockModeStart = this.mLockModeStart;
            savedState.lockModeEnd = this.mLockModeEnd;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
        if (getDrawerLockMode(r7) != 2) goto L21;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, motionEvent)) == null) {
            this.mLeftDragger.processTouchEvent(motionEvent);
            this.mRightDragger.processTouchEvent(motionEvent);
            int action = motionEvent.getAction() & 255;
            boolean z = false;
            if (action == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.mChildrenCanceledTouch = false;
            } else if (action == 1) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View findTopChildUnder = this.mLeftDragger.findTopChildUnder((int) x2, (int) y2);
                if (findTopChildUnder != null && isContentView(findTopChildUnder)) {
                    float f2 = x2 - this.mInitialMotionX;
                    float f3 = y2 - this.mInitialMotionY;
                    int touchSlop = this.mLeftDragger.getTouchSlop();
                    if ((f2 * f2) + (f3 * f3) < touchSlop * touchSlop) {
                        View findOpenDrawer = findOpenDrawer();
                        if (findOpenDrawer != null) {
                        }
                    }
                }
                z = true;
                closeDrawers(z);
            } else if (action == 3) {
                closeDrawers(true);
                this.mChildrenCanceledTouch = false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || getDrawerLockMode(GravityCompat.START) == 1) {
            return;
        }
        openDrawer(GravityCompat.START);
    }

    public void openDrawer(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, view) == null) {
            openDrawer(view, true);
        }
    }

    public void removeDrawerListener(@NonNull DrawerListener drawerListener) {
        List<DrawerListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, drawerListener) == null) || drawerListener == null || (list = this.mListeners) == null) {
            return;
        }
        list.remove(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            super.requestDisallowInterceptTouchEvent(z);
            if (z) {
                closeDrawers(true);
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setChildInsets(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048636, this, obj, z) == null) {
            this.mLastInsets = obj;
            this.mDrawStatusBarBackground = z;
            setWillNotDraw(!z && getBackground() == null);
            requestLayout();
        }
    }

    public void setDrawerElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048637, this, f2) == null) {
            this.mDrawerElevation = f2;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (isDrawerView(childAt)) {
                    ViewCompat.setElevation(childAt, this.mDrawerElevation);
                }
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, drawerListener) == null) {
            DrawerListener drawerListener2 = this.mListener;
            if (drawerListener2 != null) {
                removeDrawerListener(drawerListener2);
            }
            if (drawerListener != null) {
                addDrawerListener(drawerListener);
            }
            this.mListener = drawerListener;
        }
    }

    public void setDrawerLockMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            setDrawerLockMode(i2, 3);
            setDrawerLockMode(i2, 5);
        }
    }

    public void setDrawerShadow(Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048643, this, drawable, i2) == null) || SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        if ((i2 & GravityCompat.START) == 8388611) {
            this.mShadowStart = drawable;
        } else if ((i2 & 8388613) == 8388613) {
            this.mShadowEnd = drawable;
        } else if ((i2 & 3) == 3) {
            this.mShadowLeft = drawable;
        } else if ((i2 & 5) != 5) {
            return;
        } else {
            this.mShadowRight = drawable;
        }
        resolveShadowDrawables();
        invalidate();
    }

    public void setDrawerTitle(int i2, @Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048644, this, i2, charSequence) == null) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
            if (absoluteGravity == 3) {
                this.mTitleLeft = charSequence;
            } else if (absoluteGravity == 5) {
                this.mTitleRight = charSequence;
            }
        }
    }

    public void setDrawerViewOffset(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048645, this, view, f2) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (f2 == layoutParams.onScreen) {
                return;
            }
            layoutParams.onScreen = f2;
            dispatchOnDrawerSlide(view, f2);
        }
    }

    public void setScrimColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            this.mScrimColor = i2;
            invalidate();
        }
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, drawable) == null) {
            this.mStatusBarBackground = drawable;
            invalidate();
        }
    }

    public void setStatusBarBackgroundColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
            this.mStatusBarBackground = new ColorDrawable(i2);
            invalidate();
        }
    }

    public void updateDrawerState(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048650, this, i2, view) == null) {
            int viewDragState = this.mLeftDragger.getViewDragState();
            int viewDragState2 = this.mRightDragger.getViewDragState();
            int i3 = 2;
            if (viewDragState == 1 || viewDragState2 == 1) {
                i3 = 1;
            } else if (viewDragState != 2 && viewDragState2 != 2) {
                i3 = 0;
            }
            if (view != null && i2 == 0) {
                float f2 = ((LayoutParams) view.getLayoutParams()).onScreen;
                if (f2 == 0.0f) {
                    dispatchOnDrawerClosed(view);
                } else if (f2 == 1.0f) {
                    dispatchOnDrawerOpened(view);
                }
            }
            if (i3 != this.mDrawerState) {
                this.mDrawerState = i3;
                List<DrawerListener> list = this.mListeners;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        this.mListeners.get(size).onDrawerStateChanged(i3);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.drawerLayoutStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void closeDrawer(@NonNull View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, view, z) == null) {
            if (isDrawerView(view)) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (this.mFirstLayout) {
                    layoutParams.onScreen = 0.0f;
                    layoutParams.openState = 0;
                } else if (z) {
                    layoutParams.openState |= 4;
                    if (checkDrawerViewAbsoluteGravity(view, 3)) {
                        this.mLeftDragger.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
                    } else {
                        this.mRightDragger.smoothSlideViewTo(view, getWidth(), view.getTop());
                    }
                } else {
                    moveDrawerToOffset(view, 0.0f);
                    updateDrawerState(0, view);
                    view.setVisibility(4);
                }
                invalidate();
                return;
            }
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
    }

    public void closeDrawers(boolean z) {
        boolean smoothSlideViewTo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (isDrawerView(childAt) && (!z || layoutParams.isPeeking)) {
                    int width = childAt.getWidth();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        smoothSlideViewTo = this.mLeftDragger.smoothSlideViewTo(childAt, -width, childAt.getTop());
                    } else {
                        smoothSlideViewTo = this.mRightDragger.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                    }
                    z2 |= smoothSlideViewTo;
                    layoutParams.isPeeking = false;
                }
            }
            this.mLeftCallback.removeCallbacks();
            this.mRightCallback.removeCallbacks();
            if (z2) {
                invalidate();
            }
        }
    }

    public void openDrawer(@NonNull View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048632, this, view, z) == null) {
            if (isDrawerView(view)) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (this.mFirstLayout) {
                    layoutParams.onScreen = 1.0f;
                    layoutParams.openState = 1;
                    updateChildrenImportantForAccessibility(view, true);
                    updateChildAccessibilityAction(view);
                } else if (z) {
                    layoutParams.openState |= 2;
                    if (checkDrawerViewAbsoluteGravity(view, 3)) {
                        this.mLeftDragger.smoothSlideViewTo(view, 0, view.getTop());
                    } else {
                        this.mRightDragger.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
                    }
                } else {
                    moveDrawerToOffset(view, 1.0f);
                    updateDrawerState(0, view);
                    view.setVisibility(0);
                }
                invalidate();
                return;
            }
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        this.mScrimColor = -1728053248;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        this.mActionDismiss = new AccessibilityViewCommand(this) { // from class: androidx.drawerlayout.widget.DrawerLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DrawerLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, commandArguments)) == null) {
                    if (!this.this$0.isDrawerOpen(view) || this.this$0.getDrawerLockMode(view) == 2) {
                        return false;
                    }
                    this.this$0.closeDrawer(view);
                    return true;
                }
                return invokeLL.booleanValue;
            }
        };
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * f2) + 0.5f);
        float f3 = f2 * 400.0f;
        this.mLeftCallback = new ViewDragCallback(this, 3);
        this.mRightCallback = new ViewDragCallback(this, 5);
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, this.mLeftCallback);
        this.mLeftDragger = create;
        create.setEdgeTrackingEnabled(1);
        this.mLeftDragger.setMinVelocity(f3);
        this.mLeftCallback.setDragger(this.mLeftDragger);
        ViewDragHelper create2 = ViewDragHelper.create(this, 1.0f, this.mRightCallback);
        this.mRightDragger = create2;
        create2.setEdgeTrackingEnabled(2);
        this.mRightDragger.setMinVelocity(f3);
        this.mRightCallback.setDragger(this.mRightDragger);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this) { // from class: androidx.drawerlayout.widget.DrawerLayout.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DrawerLayout this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr3 = {this};
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

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, windowInsets)) == null) {
                            ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                            return windowInsets.consumeSystemWindowInsets();
                        }
                        return (WindowInsets) invokeLL.objValue;
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(THEME_ATTRS);
                try {
                    this.mStatusBarBackground = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.mStatusBarBackground = null;
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.DrawerLayout, i2, 0);
        try {
            if (obtainStyledAttributes2.hasValue(R.styleable.DrawerLayout_elevation)) {
                this.mDrawerElevation = obtainStyledAttributes2.getDimension(R.styleable.DrawerLayout_elevation, 0.0f);
            } else {
                this.mDrawerElevation = getResources().getDimension(R.dimen.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.mNonDrawerViews = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setDrawerLockMode(int i2, int i3) {
        View findDrawerWithGravity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048640, this, i2, i3) == null) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(i3, ViewCompat.getLayoutDirection(this));
            if (i3 == 3) {
                this.mLockModeLeft = i2;
            } else if (i3 == 5) {
                this.mLockModeRight = i2;
            } else if (i3 == 8388611) {
                this.mLockModeStart = i2;
            } else if (i3 == 8388613) {
                this.mLockModeEnd = i2;
            }
            if (i2 != 0) {
                (absoluteGravity == 3 ? this.mLeftDragger : this.mRightDragger).cancel();
            }
            if (i2 != 1) {
                if (i2 == 2 && (findDrawerWithGravity = findDrawerWithGravity(absoluteGravity)) != null) {
                    openDrawer(findDrawerWithGravity);
                    return;
                }
                return;
            }
            View findDrawerWithGravity2 = findDrawerWithGravity(absoluteGravity);
            if (findDrawerWithGravity2 != null) {
                closeDrawer(findDrawerWithGravity2);
            }
        }
    }

    public void setStatusBarBackground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            this.mStatusBarBackground = i2 != 0 ? ContextCompat.getDrawable(getContext(), i2) : null;
            invalidate();
        }
    }

    public boolean isDrawerVisible(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            View findDrawerWithGravity = findDrawerWithGravity(i2);
            if (findDrawerWithGravity != null) {
                return isDrawerVisible(findDrawerWithGravity);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FLAG_IS_CLOSING = 4;
        public static final int FLAG_IS_OPENED = 1;
        public static final int FLAG_IS_OPENING = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public int gravity;
        public boolean isPeeking;
        public float onScreen;
        public int openState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.gravity = 0;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3, int i4) {
            this(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.gravity = i4;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.gravity = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(65540, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65540, newInitContext);
                    return;
                }
            }
            this.gravity = 0;
        }
    }

    public boolean isDrawerOpen(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            View findDrawerWithGravity = findDrawerWithGravity(i2);
            if (findDrawerWithGravity != null) {
                return isDrawerOpen(findDrawerWithGravity);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int lockModeEnd;
        public int lockModeLeft;
        public int lockModeRight;
        public int lockModeStart;
        public int openDrawerGravity;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-939614759, "Landroidx/drawerlayout/widget/DrawerLayout$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-939614759, "Landroidx/drawerlayout/widget/DrawerLayout$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.openDrawerGravity = 0;
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.openDrawerGravity);
                parcel.writeInt(this.lockModeLeft);
                parcel.writeInt(this.lockModeRight);
                parcel.writeInt(this.lockModeStart);
                parcel.writeInt(this.lockModeEnd);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.openDrawerGravity = 0;
        }
    }

    public void setDrawerShadow(@DrawableRes int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048642, this, i2, i3) == null) {
            setDrawerShadow(ContextCompat.getDrawable(getContext(), i2), i3);
        }
    }

    public int getDrawerLockMode(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, view)) == null) {
            if (isDrawerView(view)) {
                return getDrawerLockMode(((LayoutParams) view.getLayoutParams()).gravity);
            }
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return invokeL.intValue;
    }

    public void setDrawerLockMode(int i2, @NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048641, this, i2, view) == null) {
            if (isDrawerView(view)) {
                setDrawerLockMode(i2, ((LayoutParams) view.getLayoutParams()).gravity);
                return;
            }
            throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
        }
    }

    public void closeDrawer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            closeDrawer(i2, true);
        }
    }

    public void closeDrawer(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            View findDrawerWithGravity = findDrawerWithGravity(i2);
            if (findDrawerWithGravity != null) {
                closeDrawer(findDrawerWithGravity, z);
                return;
            }
            throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i2));
        }
    }

    public void openDrawer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            openDrawer(i2, true);
        }
    }

    public void openDrawer(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            View findDrawerWithGravity = findDrawerWithGravity(i2);
            if (findDrawerWithGravity != null) {
                openDrawer(findDrawerWithGravity, z);
                return;
            }
            throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i2));
        }
    }
}
