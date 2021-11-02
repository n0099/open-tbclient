package com.baidu.android.ext.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.manage.MutexPopManager;
import com.baidu.android.ext.manage.PopItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.popupwindow.R;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class PopupWindow implements PopItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ABOVE_ANCHOR_STATE_SET;
    public static final boolean DEBUG = false;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAboveAnchor;
    public Drawable mAboveAnchorBackgroundDrawable;
    public boolean mAllowScrollingAnchorParent;
    public WeakReference<View> mAnchor;
    public int mAnchorXoff;
    public int mAnchorYoff;
    public int mAnimationStyle;
    public Drawable mBackground;
    public Drawable mBelowAnchorBackgroundDrawable;
    public boolean mClipToScreen;
    public boolean mClippingEnabled;
    public View mContentView;
    public Context mContext;
    public int[] mDrawingLocation;
    public boolean mFocusable;
    public int mHeight;
    public int mHeightMode;
    public boolean mIgnoreCheekPress;
    public boolean mImmersionEnabled;
    public int mInputMethodMode;
    public boolean mIsDropdown;
    public boolean mIsShowing;
    public int mLastHeight;
    public int mLastWidth;
    public boolean mLayoutInScreen;
    public boolean mLayoutInsetDecor;
    public boolean mNotTouchModal;
    public OnDismissListener mOnDismissListener;
    public ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
    public boolean mOutsideTouchable;
    public int mPopupHeight;
    public View mPopupView;
    public int mPopupWidth;
    public int[] mScreenLocation;
    public int mSoftInputMode;
    public int mSplitTouchEnabled;
    public Rect mTempRect;
    public View.OnTouchListener mTouchInterceptor;
    public boolean mTouchable;
    public int mWidth;
    public int mWidthMode;
    public int mWindowLayoutType;
    public WindowManager mWindowManager;

    /* loaded from: classes6.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* loaded from: classes6.dex */
    public class PopupViewContainer extends FrameLayout {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "PopupWindow.PopupViewContainer";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopupWindow this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PopupViewContainer(PopupWindow popupWindow, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupWindow, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = popupWindow;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            KeyEvent.DispatcherState keyDispatcherState;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
                if (keyEvent.getKeyCode() == 4) {
                    if (getKeyDispatcherState() == null) {
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                        KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                        if (keyDispatcherState2 != null) {
                            keyDispatcherState2.startTracking(keyEvent, this);
                        }
                        return true;
                    } else if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                        this.this$0.dismiss();
                        return true;
                    } else {
                        return super.dispatchKeyEvent(keyEvent);
                    }
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (this.this$0.mTouchInterceptor == null || !this.this$0.mTouchInterceptor.onTouch(this, motionEvent)) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ViewGroup, android.view.View
        public int[] onCreateDrawableState(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (this.this$0.mAboveAnchor) {
                    int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
                    View.mergeDrawableStates(onCreateDrawableState, PopupWindow.ABOVE_ANCHOR_STATE_SET);
                    return onCreateDrawableState;
                }
                return super.onCreateDrawableState(i2);
            }
            return (int[]) invokeI.objValue;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 0 && (x < 0 || x >= super.getWidth() || y < 0 || y >= super.getHeight())) {
                    this.this$0.dismiss();
                    return true;
                } else if (motionEvent.getAction() == 4) {
                    this.this$0.dismiss();
                    return true;
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                if (this.this$0.mContentView != null) {
                    this.this$0.mContentView.sendAccessibilityEvent(i2);
                } else {
                    super.sendAccessibilityEvent(i2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1918788782, "Lcom/baidu/android/ext/widget/PopupWindow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1918788782, "Lcom/baidu/android/ext/widget/PopupWindow;");
                return;
            }
        }
        ABOVE_ANCHOR_STATE_SET = new int[]{16842922};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(Context context) {
        this(context, (AttributeSet) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    private int computeAnimationResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            int i2 = this.mAnimationStyle;
            if (i2 == -1) {
                if (this.mIsDropdown) {
                    return this.mAboveAnchor ? R.style.PopupWindow_DropDownUp : R.style.PopupWindow_DropDownDown;
                }
                return 0;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r4.mInputMethodMode == 1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r4.mInputMethodMode == 2) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
        r5 = r5 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int computeFlags(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, this, i2)) == null) {
            int i3 = i2 & (-8815129);
            if (this.mIgnoreCheekPress) {
                i3 |= 32768;
            }
            if (!this.mFocusable) {
                i3 |= 8;
            }
            if (!this.mTouchable) {
                i3 |= 16;
            }
            if (this.mOutsideTouchable) {
                i3 |= 262144;
            }
            if (!this.mClippingEnabled) {
                i3 |= 512;
            }
            if (isSplitTouchEnabled()) {
                i3 |= 8388608;
            }
            if (this.mLayoutInScreen) {
                i3 |= 256;
            }
            if (this.mLayoutInsetDecor) {
                i3 |= 65536;
            }
            return this.mNotTouchModal ? i3 | 32 : i3;
        }
        return invokeI.intValue;
    }

    private WindowManager.LayoutParams createPopupLayout(IBinder iBinder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, iBinder)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.gravity = 51;
            int i2 = this.mWidth;
            this.mLastWidth = i2;
            layoutParams.width = i2;
            int i3 = this.mHeight;
            this.mLastHeight = i3;
            layoutParams.height = i3;
            Drawable drawable = this.mBackground;
            if (drawable != null) {
                layoutParams.format = drawable.getOpacity();
            } else {
                layoutParams.format = -3;
            }
            layoutParams.flags = computeFlags(layoutParams.flags);
            layoutParams.type = this.mWindowLayoutType;
            layoutParams.token = iBinder;
            layoutParams.softInputMode = this.mSoftInputMode;
            layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean findDropDownPosition(View view, WindowManager.LayoutParams layoutParams, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65559, this, view, layoutParams, i2, i3)) == null) {
            int height = view.getHeight();
            view.getLocationInWindow(this.mDrawingLocation);
            int[] iArr = this.mDrawingLocation;
            layoutParams.x = iArr[0] + i2;
            layoutParams.y = iArr[1] + height + i3;
            layoutParams.gravity = 51;
            view.getLocationOnScreen(this.mScreenLocation);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            View rootView = view.getRootView();
            if (this.mScreenLocation[1] + height + i3 + this.mPopupHeight > rect.bottom || (layoutParams.x + this.mPopupWidth) - rootView.getWidth() > 0) {
                if (this.mAllowScrollingAnchorParent) {
                    int scrollX = view.getScrollX();
                    int scrollY = view.getScrollY();
                    view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.mPopupWidth + scrollX + i2, this.mPopupHeight + scrollY + view.getHeight() + i3), true);
                }
                view.getLocationInWindow(this.mDrawingLocation);
                int[] iArr2 = this.mDrawingLocation;
                layoutParams.x = iArr2[0] + i2;
                layoutParams.y = iArr2[1] + view.getHeight() + i3;
                view.getLocationOnScreen(this.mScreenLocation);
                r2 = ((rect.bottom - this.mScreenLocation[1]) - view.getHeight()) - i3 < (this.mScreenLocation[1] - i3) - rect.top;
                if (r2) {
                    layoutParams.gravity = 83;
                    layoutParams.y = (rootView.getHeight() - this.mDrawingLocation[1]) + i3;
                } else {
                    layoutParams.y = this.mDrawingLocation[1] + view.getHeight() + i3;
                }
            }
            if (this.mClipToScreen) {
                int i4 = rect.right - rect.left;
                int i5 = layoutParams.x;
                int i6 = layoutParams.width + i5;
                if (i6 > i4) {
                    layoutParams.x = i5 - (i6 - i4);
                }
                int i7 = layoutParams.x;
                int i8 = rect.left;
                if (i7 < i8) {
                    layoutParams.x = i8;
                    layoutParams.width = Math.min(layoutParams.width, i4);
                }
                if (r2) {
                    int i9 = (this.mScreenLocation[1] + i3) - this.mPopupHeight;
                    if (i9 < 0) {
                        layoutParams.y += i9;
                    }
                } else {
                    layoutParams.y = Math.max(layoutParams.y, rect.top);
                }
            }
            layoutParams.gravity |= 268435456;
            return r2;
        }
        return invokeLLII.booleanValue;
    }

    private void invokePopup(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, layoutParams) == null) {
            Context context = this.mContext;
            if (context != null) {
                layoutParams.packageName = context.getPackageName();
            }
            this.mWindowManager.addView(this.mPopupView, layoutParams);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    private void preparePopup(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, layoutParams) == null) {
            View view = this.mContentView;
            if (view != null && this.mContext != null && this.mWindowManager != null) {
                if (this.mBackground != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    int i2 = -2;
                    i2 = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                    PopupViewContainer popupViewContainer = new PopupViewContainer(this, this.mContext);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i2);
                    popupViewContainer.setBackgroundDrawable(this.mBackground);
                    popupViewContainer.addView(this.mContentView, layoutParams3);
                    this.mPopupView = popupViewContainer;
                } else {
                    this.mPopupView = view;
                }
                this.mPopupWidth = layoutParams.width;
                this.mPopupHeight = layoutParams.height;
                return;
            }
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
    }

    private void registerForScrollChanged(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65562, this, view, i2, i3) == null) {
            unregisterForScrollChanged();
            this.mAnchor = new WeakReference<>(view);
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.mOnScrollChangedListener);
            }
            this.mAnchorXoff = i2;
            this.mAnchorYoff = i3;
        }
    }

    private void unregisterForScrollChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            WeakReference<View> weakReference = this.mAnchor;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null) {
                view.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
            }
            this.mAnchor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAboveAnchor(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65565, this, z) == null) || z == this.mAboveAnchor) {
            return;
        }
        this.mAboveAnchor = z;
        if (this.mBackground != null) {
            Drawable drawable = this.mAboveAnchorBackgroundDrawable;
            if (drawable == null) {
                this.mPopupView.refreshDrawableState();
            } else if (z) {
                this.mPopupView.setBackgroundDrawable(drawable);
            } else {
                this.mPopupView.setBackgroundDrawable(this.mBelowAnchorBackgroundDrawable);
            }
        }
    }

    public void dismiss() {
        OnDismissListener onDismissListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && isShowing() && this.mPopupView != null) {
            this.mIsShowing = false;
            unregisterForScrollChanged();
            try {
                this.mWindowManager.removeView(this.mPopupView);
                View view = this.mPopupView;
                View view2 = this.mContentView;
                if (view != view2 && (view instanceof ViewGroup)) {
                    ((ViewGroup) view).removeView(view2);
                }
                this.mPopupView = null;
                onDismissListener = this.mOnDismissListener;
                if (onDismissListener == null) {
                    return;
                }
            } catch (IllegalArgumentException unused) {
                View view3 = this.mPopupView;
                View view4 = this.mContentView;
                if (view3 != view4 && (view3 instanceof ViewGroup)) {
                    ((ViewGroup) view3).removeView(view4);
                }
                this.mPopupView = null;
                onDismissListener = this.mOnDismissListener;
                if (onDismissListener == null) {
                    return;
                }
            } catch (Throwable th) {
                View view5 = this.mPopupView;
                View view6 = this.mContentView;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.mPopupView = null;
                OnDismissListener onDismissListener2 = this.mOnDismissListener;
                if (onDismissListener2 != null) {
                    onDismissListener2.onDismiss();
                }
                throw th;
            }
            onDismissListener.onDismiss();
        }
    }

    public void doShowAsDropDown(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, i3) == null) || isShowing() || this.mContentView == null) {
            return;
        }
        registerForScrollChanged(view, i2, i3);
        this.mIsShowing = true;
        this.mIsDropdown = true;
        WindowManager.LayoutParams createPopupLayout = createPopupLayout(view.getWindowToken());
        preparePopup(createPopupLayout);
        updateAboveAnchor(findDropDownPosition(view, createPopupLayout, i2, i3));
        int i4 = this.mHeightMode;
        if (i4 < 0) {
            this.mLastHeight = i4;
            createPopupLayout.height = i4;
        }
        int i5 = this.mWidthMode;
        if (i5 < 0) {
            this.mLastWidth = i5;
            createPopupLayout.width = i5;
        }
        createPopupLayout.windowAnimations = computeAnimationResource();
        invokePopup(createPopupLayout);
    }

    public void doShowAtLocation(IBinder iBinder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, iBinder, i2, i3, i4) == null) || iBinder == null || isShowing() || this.mContentView == null) {
            return;
        }
        unregisterForScrollChanged();
        this.mIsShowing = true;
        this.mIsDropdown = false;
        WindowManager.LayoutParams createPopupLayout = createPopupLayout(iBinder);
        createPopupLayout.windowAnimations = computeAnimationResource();
        preparePopup(createPopupLayout);
        if (i2 == 0) {
            i2 = 51;
        }
        createPopupLayout.gravity = i2;
        createPopupLayout.x = i3;
        createPopupLayout.y = i4;
        int i5 = this.mHeightMode;
        if (i5 < 0) {
            this.mLastHeight = i5;
            createPopupLayout.height = i5;
        }
        int i6 = this.mWidthMode;
        if (i6 < 0) {
            this.mLastWidth = i6;
            createPopupLayout.width = i6;
        }
        invokePopup(createPopupLayout);
    }

    public int getAnimationStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAnimationStyle : invokeV.intValue;
    }

    public Drawable getBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBackground : (Drawable) invokeV.objValue;
    }

    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mContentView : (View) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mHeight : invokeV.intValue;
    }

    public int getInputMethodMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mInputMethodMode : invokeV.intValue;
    }

    public int getMaxAvailableHeight(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view)) == null) ? getMaxAvailableHeight(view, 0) : invokeL.intValue;
    }

    public int getSoftInputMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mSoftInputMode : invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mWidth : invokeV.intValue;
    }

    public int getWindowLayoutType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mWindowLayoutType : invokeV.intValue;
    }

    public boolean isAboveAnchor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mAboveAnchor : invokeV.booleanValue;
    }

    public boolean isClippingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mClippingEnabled : invokeV.booleanValue;
    }

    public boolean isFocusable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mFocusable : invokeV.booleanValue;
    }

    public boolean isLayoutInScreenEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mLayoutInScreen : invokeV.booleanValue;
    }

    public boolean isOutsideTouchable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mOutsideTouchable : invokeV.booleanValue;
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mIsShowing : invokeV.booleanValue;
    }

    public boolean isSplitTouchEnabled() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.mSplitTouchEnabled >= 0 || (context = this.mContext) == null) ? this.mSplitTouchEnabled == 1 : context.getApplicationInfo().targetSdkVersion >= 11 : invokeV.booleanValue;
    }

    public boolean isTouchable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mTouchable : invokeV.booleanValue;
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public void mutexDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            setOnDismissListener(null);
            dismiss();
        }
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public boolean mutexShow(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, objArr)) == null) {
            OnDismissListener onDismissListener = this.mOnDismissListener;
            setOnDismissListener(new OnDismissListener(this, onDismissListener) { // from class: com.baidu.android.ext.widget.PopupWindow.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PopupWindow this$0;
                public final /* synthetic */ OnDismissListener val$oldListener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, onDismissListener};
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
                    this.val$oldListener = onDismissListener;
                }

                @Override // com.baidu.android.ext.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        OnDismissListener onDismissListener2 = this.val$oldListener;
                        if (onDismissListener2 != null) {
                            onDismissListener2.onDismiss();
                        }
                        MutexPopManager.doNextTask();
                    }
                }
            });
            if (str == null) {
                str = "";
            }
            char c2 = 65535;
            if (str.hashCode() == 1939912032 && str.equals("showAsDropDown")) {
                c2 = 0;
            }
            if (c2 != 0) {
                setOnDismissListener(onDismissListener);
                return false;
            } else if (objArr == null || objArr.length == 0) {
                return false;
            } else {
                if (objArr.length == 1) {
                    showAsDropDown((View) objArr[0]);
                } else if (objArr.length == 3) {
                    showAsDropDown((View) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public void setAllowScrollingAnchorParent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.mAllowScrollingAnchorParent = z;
        }
    }

    public void setAnimationStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mAnimationStyle = i2;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, drawable) == null) {
            this.mBackground = drawable;
        }
    }

    public void setClipToScreenEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.mClipToScreen = z;
            setClippingEnabled(!z);
        }
    }

    public void setClippingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mClippingEnabled = z;
        }
    }

    public void setContentView(View view) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, view) == null) || isShowing()) {
            return;
        }
        this.mContentView = view;
        if (this.mContext == null && view != null) {
            this.mContext = view.getContext();
        }
        if (this.mWindowManager != null || this.mContentView == null || (context = this.mContext) == null) {
            return;
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    public void setEnableImmersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION && z;
        }
    }

    public void setFocusable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.mFocusable = z;
        }
    }

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.mHeight = i2;
        }
    }

    public void setIgnoreCheekPress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.mIgnoreCheekPress = true;
        }
    }

    public void setInputMethodMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.mInputMethodMode = i2;
        }
    }

    public void setLayoutInScreenEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.mLayoutInScreen = z;
        }
    }

    public void setLayoutInsetDecor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.mLayoutInsetDecor = z;
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onDismissListener) == null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void setOutsideTouchable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.mOutsideTouchable = z;
        }
    }

    public void setSoftInputMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.mSoftInputMode = i2;
        }
    }

    public void setSplitTouchEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.mSplitTouchEnabled = z ? 1 : 0;
        }
    }

    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onTouchListener) == null) {
            this.mTouchInterceptor = onTouchListener;
        }
    }

    public void setTouchModal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.mNotTouchModal = !z;
        }
    }

    public void setTouchable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.mTouchable = z;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.mWidth = i2;
        }
    }

    public void setWindowLayoutMode(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048621, this, i2, i3) == null) {
            this.mWidthMode = i2;
            this.mHeightMode = i3;
        }
    }

    public void setWindowLayoutType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.mWindowLayoutType = i2;
        }
    }

    public void showAsDropDown(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view) == null) {
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            doShowAsDropDown(view, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(5120);
                setFocusable(true);
                update();
            }
        }
    }

    public void showAtLocation(View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048626, this, view, i2, i3, i4) == null) {
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            doShowAtLocation(view.getWindowToken(), i2, i3, i4);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(5120);
                setFocusable(true);
                update();
            }
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
            boolean z = false;
            int computeAnimationResource = computeAnimationResource();
            boolean z2 = true;
            if (computeAnimationResource != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = computeAnimationResource;
                z = true;
            }
            int computeFlags = computeFlags(layoutParams.flags);
            if (computeFlags != layoutParams.flags) {
                layoutParams.flags = computeFlags;
            } else {
                z2 = z;
            }
            if (z2) {
                this.mWindowManager.updateViewLayout(this.mPopupView, layoutParams);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842870);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public int getMaxAvailableHeight(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, view, i2)) == null) ? getMaxAvailableHeight(view, i2, false) : invokeLI.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
    }

    public int getMaxAvailableHeight(View view, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int[] iArr = this.mDrawingLocation;
            view.getLocationOnScreen(iArr);
            int i3 = rect.bottom;
            if (z) {
                i3 = view.getContext().getResources().getDisplayMetrics().heightPixels;
            }
            int max = Math.max((i3 - (iArr[1] + view.getHeight())) - i2, (iArr[1] - rect.top) + i2);
            Drawable drawable = this.mBackground;
            if (drawable != null) {
                drawable.getPadding(this.mTempRect);
                Rect rect2 = this.mTempRect;
                return max - (rect2.top + rect2.bottom);
            }
            return max;
        }
        return invokeCommon.intValue;
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
        this.mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION;
        this.mInputMethodMode = 0;
        this.mSoftInputMode = 1;
        this.mTouchable = true;
        this.mOutsideTouchable = false;
        this.mClippingEnabled = true;
        this.mSplitTouchEnabled = -1;
        this.mAllowScrollingAnchorParent = true;
        this.mLayoutInsetDecor = false;
        this.mDrawingLocation = new int[2];
        this.mScreenLocation = new int[2];
        this.mTempRect = new Rect();
        this.mWindowLayoutType = 1000;
        this.mIgnoreCheekPress = false;
        this.mAnimationStyle = -1;
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener(this) { // from class: com.baidu.android.ext.widget.PopupWindow.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PopupWindow this$0;

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

            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    View view = this.this$0.mAnchor != null ? (View) this.this$0.mAnchor.get() : null;
                    if (view == null || this.this$0.mPopupView == null) {
                        return;
                    }
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.this$0.mPopupView.getLayoutParams();
                    PopupWindow popupWindow = this.this$0;
                    popupWindow.updateAboveAnchor(popupWindow.findDropDownPosition(view, layoutParams, popupWindow.mAnchorXoff, this.this$0.mAnchorYoff));
                    this.this$0.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PopupWindow, i2, i3);
        this.mBackground = obtainStyledAttributes.getDrawable(R.styleable.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PopupWindow_popupAnimationStyle, -1);
        this.mAnimationStyle = resourceId != 16973824 ? resourceId : -1;
        obtainStyledAttributes.recycle();
    }

    public void showAsDropDown(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048624, this, view, i2, i3) == null) {
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            doShowAsDropDown(view, i2, i3);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(5120);
                setFocusable(true);
                update();
            }
        }
    }

    public void showAtLocation(IBinder iBinder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048625, this, iBinder, i2, i3, i4) == null) {
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            doShowAtLocation(iBinder, i2, i3, i4);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(5120);
                setFocusable(true);
                update();
            }
        }
    }

    public void update(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i2, i3) == null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
            update(layoutParams.x, layoutParams.y, i2, i3, false);
        }
    }

    public void update(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048629, this, i2, i3, i4, i5) == null) {
            update(i2, i3, i4, i5, false);
        }
    }

    public void update(int i2, int i3, int i4, int i5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)}) == null) {
            if (i4 != -1) {
                this.mLastWidth = i4;
                setWidth(i4);
            }
            if (i5 != -1) {
                this.mLastHeight = i5;
                setHeight(i5);
            }
            if (!isShowing() || this.mContentView == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
            int i6 = this.mWidthMode;
            if (i6 >= 0) {
                i6 = this.mLastWidth;
            }
            boolean z2 = true;
            if (i4 != -1 && layoutParams.width != i6) {
                this.mLastWidth = i6;
                layoutParams.width = i6;
                z = true;
            }
            int i7 = this.mHeightMode;
            if (i7 >= 0) {
                i7 = this.mLastHeight;
            }
            if (i5 != -1 && layoutParams.height != i7) {
                this.mLastHeight = i7;
                layoutParams.height = i7;
                z = true;
            }
            if (layoutParams.x != i2) {
                layoutParams.x = i2;
                z = true;
            }
            if (layoutParams.y != i3) {
                layoutParams.y = i3;
                z = true;
            }
            int computeAnimationResource = computeAnimationResource();
            if (computeAnimationResource != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = computeAnimationResource;
                z = true;
            }
            int computeFlags = computeFlags(layoutParams.flags);
            if (computeFlags != layoutParams.flags) {
                layoutParams.flags = computeFlags;
            } else {
                z2 = z;
            }
            if (z2) {
                this.mWindowManager.updateViewLayout(this.mPopupView, layoutParams);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow() {
        this((View) null, 0, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((View) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(View view) {
        this(view, 0, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(int i2, int i3) {
        this((View) null, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(View view, int i2, int i3) {
        this(view, i2, i3, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65544, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
                return;
            }
        }
    }

    public PopupWindow(View view, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65545, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65545, newInitContext);
                return;
            }
        }
        this.mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION;
        this.mInputMethodMode = 0;
        this.mSoftInputMode = 1;
        this.mTouchable = true;
        this.mOutsideTouchable = false;
        this.mClippingEnabled = true;
        this.mSplitTouchEnabled = -1;
        this.mAllowScrollingAnchorParent = true;
        this.mLayoutInsetDecor = false;
        this.mDrawingLocation = new int[2];
        this.mScreenLocation = new int[2];
        this.mTempRect = new Rect();
        this.mWindowLayoutType = 1000;
        this.mIgnoreCheekPress = false;
        this.mAnimationStyle = -1;
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener(this) { // from class: com.baidu.android.ext.widget.PopupWindow.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PopupWindow this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
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

            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    View view2 = this.this$0.mAnchor != null ? (View) this.this$0.mAnchor.get() : null;
                    if (view2 == null || this.this$0.mPopupView == null) {
                        return;
                    }
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.this$0.mPopupView.getLayoutParams();
                    PopupWindow popupWindow = this.this$0;
                    popupWindow.updateAboveAnchor(popupWindow.findDropDownPosition(view2, layoutParams, popupWindow.mAnchorXoff, this.this$0.mAnchorYoff));
                    this.this$0.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        if (view != null) {
            Context context = view.getContext();
            this.mContext = context;
            this.mWindowManager = (WindowManager) context.getSystemService("window");
        }
        setContentView(view);
        setWidth(i2);
        setHeight(i3);
        setFocusable(z);
    }

    public void update(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048631, this, view, i2, i3) == null) {
            update(view, false, 0, 0, true, i2, i3);
        }
    }

    public void update(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            update(view, true, i2, i3, true, i4, i5);
        }
    }

    private void update(View view, boolean z, int i2, int i3, boolean z2, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = i4;
            int i7 = i5;
            if (!isShowing() || this.mContentView == null) {
                return;
            }
            WeakReference<View> weakReference = this.mAnchor;
            boolean z3 = false;
            boolean z4 = z && !(this.mAnchorXoff == i2 && this.mAnchorYoff == i3);
            if (weakReference == null || weakReference.get() != view || (z4 && !this.mIsDropdown)) {
                registerForScrollChanged(view, i2, i3);
            } else if (z4) {
                this.mAnchorXoff = i2;
                this.mAnchorYoff = i3;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
            if (z2) {
                if (i6 == -1) {
                    i6 = this.mPopupWidth;
                } else {
                    this.mPopupWidth = i6;
                }
                if (i7 == -1) {
                    i7 = this.mPopupHeight;
                } else {
                    this.mPopupHeight = i7;
                }
            }
            int i8 = layoutParams.x;
            int i9 = layoutParams.y;
            if (z) {
                updateAboveAnchor(findDropDownPosition(view, layoutParams, i2, i3));
            } else {
                updateAboveAnchor(findDropDownPosition(view, layoutParams, this.mAnchorXoff, this.mAnchorYoff));
            }
            int i10 = layoutParams.x;
            int i11 = layoutParams.y;
            update(i10, i11, i6, i7, (i8 == i10 && i9 == i11) ? true : true);
        }
    }
}
