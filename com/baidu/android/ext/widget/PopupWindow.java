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
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (this.this$0.mTouchInterceptor != null && this.this$0.mTouchInterceptor.onTouch(this, motionEvent)) {
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ViewGroup, android.view.View
        public int[] onCreateDrawableState(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (this.this$0.mAboveAnchor) {
                    int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                    View.mergeDrawableStates(onCreateDrawableState, PopupWindow.ABOVE_ANCHOR_STATE_SET);
                    return onCreateDrawableState;
                }
                return super.onCreateDrawableState(i);
            }
            return (int[]) invokeI.objValue;
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                if (this.this$0.mContentView != null) {
                    this.this$0.mContentView.sendAccessibilityEvent(i);
                } else {
                    super.sendAccessibilityEvent(i);
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

    private int computeAnimationResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            int i = this.mAnimationStyle;
            if (i == -1) {
                if (this.mIsDropdown) {
                    if (this.mAboveAnchor) {
                        return R.style.obfuscated_res_0x7f100179;
                    }
                    return R.style.obfuscated_res_0x7f100178;
                }
                return 0;
            }
            return i;
        }
        return invokeV.intValue;
    }

    private void unregisterForScrollChanged() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            WeakReference<View> weakReference = this.mAnchor;
            if (weakReference != null) {
                view2 = weakReference.get();
            } else {
                view2 = null;
            }
            if (view2 != null) {
                view2.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
            }
            this.mAnchor = null;
        }
    }

    public int getAnimationStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAnimationStyle;
        }
        return invokeV.intValue;
    }

    public Drawable getBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mBackground;
        }
        return (Drawable) invokeV.objValue;
    }

    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mContentView;
        }
        return (View) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mHeight;
        }
        return invokeV.intValue;
    }

    public int getInputMethodMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mInputMethodMode;
        }
        return invokeV.intValue;
    }

    public int getSoftInputMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mSoftInputMode;
        }
        return invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mWidth;
        }
        return invokeV.intValue;
    }

    public int getWindowLayoutType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mWindowLayoutType;
        }
        return invokeV.intValue;
    }

    public boolean isAboveAnchor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mAboveAnchor;
        }
        return invokeV.booleanValue;
    }

    public boolean isClippingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mClippingEnabled;
        }
        return invokeV.booleanValue;
    }

    public boolean isFocusable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mFocusable;
        }
        return invokeV.booleanValue;
    }

    public boolean isLayoutInScreenEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mLayoutInScreen;
        }
        return invokeV.booleanValue;
    }

    public boolean isOutsideTouchable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mOutsideTouchable;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mIsShowing;
        }
        return invokeV.booleanValue;
    }

    public boolean isSplitTouchEnabled() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.mSplitTouchEnabled < 0 && (context = this.mContext) != null) {
                if (context.getApplicationInfo().targetSdkVersion < 11) {
                    return false;
                }
                return true;
            } else if (this.mSplitTouchEnabled != 1) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isTouchable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mTouchable;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public void mutexDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            setOnDismissListener(null);
            dismiss();
        }
    }

    public void setIgnoreCheekPress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.mIgnoreCheekPress = true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow() {
        this((View) null, 0, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((View) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(int i, int i2) {
        this((View) null, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAboveAnchor(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65565, this, z) == null) && z != this.mAboveAnchor) {
            this.mAboveAnchor = z;
            if (this.mBackground != null) {
                Drawable drawable = this.mAboveAnchorBackgroundDrawable;
                if (drawable != null) {
                    if (z) {
                        this.mPopupView.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.mPopupView.setBackgroundDrawable(this.mBelowAnchorBackgroundDrawable);
                        return;
                    }
                }
                this.mPopupView.refreshDrawableState();
            }
        }
    }

    public void setContentView(View view2) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, view2) != null) || isShowing()) {
            return;
        }
        this.mContentView = view2;
        if (this.mContext == null && view2 != null) {
            this.mContext = view2.getContext();
        }
        if (this.mWindowManager == null && this.mContentView != null && (context = this.mContext) != null) {
            this.mWindowManager = (WindowManager) context.getSystemService("window");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    public void doShowAsDropDown(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, i2) == null) && !isShowing() && this.mContentView != null) {
            registerForScrollChanged(view2, i, i2);
            this.mIsShowing = true;
            this.mIsDropdown = true;
            WindowManager.LayoutParams createPopupLayout = createPopupLayout(view2.getWindowToken());
            preparePopup(createPopupLayout);
            updateAboveAnchor(findDropDownPosition(view2, createPopupLayout, i, i2));
            int i3 = this.mHeightMode;
            if (i3 < 0) {
                this.mLastHeight = i3;
                createPopupLayout.height = i3;
            }
            int i4 = this.mWidthMode;
            if (i4 < 0) {
                this.mLastWidth = i4;
                createPopupLayout.width = i4;
            }
            createPopupLayout.windowAnimations = computeAnimationResource();
            invokePopup(createPopupLayout);
        }
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
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

            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.mAnchor != null) {
                        view2 = (View) this.this$0.mAnchor.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && this.this$0.mPopupView != null) {
                        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.this$0.mPopupView.getLayoutParams();
                        PopupWindow popupWindow = this.this$0;
                        popupWindow.updateAboveAnchor(popupWindow.findDropDownPosition(view2, layoutParams, popupWindow.mAnchorXoff, this.this$0.mAnchorYoff));
                        this.this$0.update(layoutParams.x, layoutParams.y, -1, -1, true);
                    }
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.style.R.styleable.PopupWindow, i, i2);
        this.mBackground = obtainStyledAttributes.getDrawable(4);
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        this.mAnimationStyle = resourceId != 16973824 ? resourceId : -1;
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(View view2) {
        this(view2, 0, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65543, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
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
    private int computeFlags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, this, i)) == null) {
            int i2 = i & (-8815129);
            if (this.mIgnoreCheekPress) {
                i2 |= 32768;
            }
            if (!this.mFocusable) {
                i2 |= 8;
            }
            if (!this.mTouchable) {
                i2 |= 16;
            }
            if (this.mOutsideTouchable) {
                i2 |= 262144;
            }
            if (!this.mClippingEnabled) {
                i2 |= 512;
            }
            if (isSplitTouchEnabled()) {
                i2 |= 8388608;
            }
            if (this.mLayoutInScreen) {
                i2 |= 256;
            }
            if (this.mLayoutInsetDecor) {
                i2 |= 65536;
            }
            if (this.mNotTouchModal) {
                return i2 | 32;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    private WindowManager.LayoutParams createPopupLayout(IBinder iBinder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, iBinder)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.gravity = 51;
            int i = this.mWidth;
            this.mLastWidth = i;
            layoutParams.width = i;
            int i2 = this.mHeight;
            this.mLastHeight = i2;
            layoutParams.height = i2;
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
            layoutParams.setTitle(" ");
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    private void preparePopup(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, layoutParams) == null) {
            View view2 = this.mContentView;
            if (view2 != null && this.mContext != null && this.mWindowManager != null) {
                if (this.mBackground != null) {
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    int i = -2;
                    i = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                    PopupViewContainer popupViewContainer = new PopupViewContainer(this, this.mContext);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                    popupViewContainer.setBackgroundDrawable(this.mBackground);
                    popupViewContainer.addView(this.mContentView, layoutParams3);
                    this.mPopupView = popupViewContainer;
                } else {
                    this.mPopupView = view2;
                }
                this.mPopupWidth = layoutParams.width;
                this.mPopupHeight = layoutParams.height;
                return;
            }
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupWindow(View view2, int i, int i2) {
        this(view2, i, i2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65544, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
                return;
            }
        }
    }

    public int getMaxAvailableHeight(View view2, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Rect rect = new Rect();
            view2.getWindowVisibleDisplayFrame(rect);
            int[] iArr = this.mDrawingLocation;
            view2.getLocationOnScreen(iArr);
            int i2 = rect.bottom;
            if (z) {
                i2 = view2.getContext().getResources().getDisplayMetrics().heightPixels;
            }
            int max = Math.max((i2 - (iArr[1] + view2.getHeight())) - i, (iArr[1] - rect.top) + i);
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

    public PopupWindow(View view2, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65545, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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

            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view22;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.mAnchor != null) {
                        view22 = (View) this.this$0.mAnchor.get();
                    } else {
                        view22 = null;
                    }
                    if (view22 != null && this.this$0.mPopupView != null) {
                        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.this$0.mPopupView.getLayoutParams();
                        PopupWindow popupWindow = this.this$0;
                        popupWindow.updateAboveAnchor(popupWindow.findDropDownPosition(view22, layoutParams, popupWindow.mAnchorXoff, this.this$0.mAnchorYoff));
                        this.this$0.update(layoutParams.x, layoutParams.y, -1, -1, true);
                    }
                }
            }
        };
        if (view2 != null) {
            Context context = view2.getContext();
            this.mContext = context;
            this.mWindowManager = (WindowManager) context.getSystemService("window");
        }
        setContentView(view2);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
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

    public int getMaxAvailableHeight(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2)) == null) {
            return getMaxAvailableHeight(view2, 0);
        }
        return invokeL.intValue;
    }

    public void setAllowScrollingAnchorParent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.mAllowScrollingAnchorParent = z;
        }
    }

    public void setAnimationStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.mAnimationStyle = i;
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

    public void setEnableImmersion(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            if (ImmersionHelper.SUPPORT_IMMERSION && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mImmersionEnabled = z2;
        }
    }

    public void setFocusable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.mFocusable = z;
        }
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.mHeight = i;
        }
    }

    public void setInputMethodMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.mInputMethodMode = i;
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

    public void setSoftInputMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.mSoftInputMode = i;
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

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.mWidth = i;
        }
    }

    public void setWindowLayoutType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.mWindowLayoutType = i;
        }
    }

    public void showAsDropDown(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view2) == null) {
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            doShowAsDropDown(view2, 0, 0);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(5120);
                setFocusable(true);
                update();
            }
        }
    }

    public int getMaxAvailableHeight(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, view2, i)) == null) {
            return getMaxAvailableHeight(view2, i, false);
        }
        return invokeLI.intValue;
    }

    public void setWindowLayoutMode(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048621, this, i, i2) == null) {
            this.mWidthMode = i;
            this.mHeightMode = i2;
        }
    }

    public void update(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i, i2) == null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
            update(layoutParams.x, layoutParams.y, i, i2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean findDropDownPosition(View view2, WindowManager.LayoutParams layoutParams, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65559, this, view2, layoutParams, i, i2)) == null) {
            int height = view2.getHeight();
            view2.getLocationInWindow(this.mDrawingLocation);
            int[] iArr = this.mDrawingLocation;
            boolean z = false;
            layoutParams.x = iArr[0] + i;
            layoutParams.y = iArr[1] + height + i2;
            layoutParams.gravity = 51;
            view2.getLocationOnScreen(this.mScreenLocation);
            Rect rect = new Rect();
            view2.getWindowVisibleDisplayFrame(rect);
            View rootView = view2.getRootView();
            if (this.mScreenLocation[1] + height + i2 + this.mPopupHeight > rect.bottom || (layoutParams.x + this.mPopupWidth) - rootView.getWidth() > 0) {
                if (this.mAllowScrollingAnchorParent) {
                    int scrollX = view2.getScrollX();
                    int scrollY = view2.getScrollY();
                    view2.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.mPopupWidth + scrollX + i, this.mPopupHeight + scrollY + view2.getHeight() + i2), true);
                }
                view2.getLocationInWindow(this.mDrawingLocation);
                int[] iArr2 = this.mDrawingLocation;
                layoutParams.x = iArr2[0] + i;
                layoutParams.y = iArr2[1] + view2.getHeight() + i2;
                view2.getLocationOnScreen(this.mScreenLocation);
                if (((rect.bottom - this.mScreenLocation[1]) - view2.getHeight()) - i2 < (this.mScreenLocation[1] - i2) - rect.top) {
                    z = true;
                }
                if (z) {
                    layoutParams.gravity = 83;
                    layoutParams.y = (rootView.getHeight() - this.mDrawingLocation[1]) + i2;
                } else {
                    layoutParams.y = this.mDrawingLocation[1] + view2.getHeight() + i2;
                }
            }
            if (this.mClipToScreen) {
                int i3 = rect.right - rect.left;
                int i4 = layoutParams.x;
                int i5 = layoutParams.width + i4;
                if (i5 > i3) {
                    layoutParams.x = i4 - (i5 - i3);
                }
                int i6 = layoutParams.x;
                int i7 = rect.left;
                if (i6 < i7) {
                    layoutParams.x = i7;
                    layoutParams.width = Math.min(layoutParams.width, i3);
                }
                if (z) {
                    int i8 = (this.mScreenLocation[1] + i2) - this.mPopupHeight;
                    if (i8 < 0) {
                        layoutParams.y += i8;
                    }
                } else {
                    layoutParams.y = Math.max(layoutParams.y, rect.top);
                }
            }
            layoutParams.gravity |= LaunchTaskConstants.OTHER_PROCESS;
            return z;
        }
        return invokeLLII.booleanValue;
    }

    private void registerForScrollChanged(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65562, this, view2, i, i2) == null) {
            unregisterForScrollChanged();
            this.mAnchor = new WeakReference<>(view2);
            ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.mOnScrollChangedListener);
            }
            this.mAnchorXoff = i;
            this.mAnchorYoff = i2;
        }
    }

    public void showAsDropDown(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048624, this, view2, i, i2) == null) {
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            doShowAsDropDown(view2, i, i2);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(5120);
                setFocusable(true);
                update();
            }
        }
    }

    public void update(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048631, this, view2, i, i2) == null) {
            update(view2, false, 0, 0, true, i, i2);
        }
    }

    private void update(View view2, boolean z, int i, int i2, boolean z2, int i3, int i4) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int i5 = i3;
            int i6 = i4;
            if (isShowing() && this.mContentView != null) {
                WeakReference<View> weakReference = this.mAnchor;
                boolean z4 = false;
                if (z && (this.mAnchorXoff != i || this.mAnchorYoff != i2)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (weakReference != null && weakReference.get() == view2 && (!z3 || this.mIsDropdown)) {
                    if (z3) {
                        this.mAnchorXoff = i;
                        this.mAnchorYoff = i2;
                    }
                } else {
                    registerForScrollChanged(view2, i, i2);
                }
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
                if (z2) {
                    if (i5 == -1) {
                        i5 = this.mPopupWidth;
                    } else {
                        this.mPopupWidth = i5;
                    }
                    if (i6 == -1) {
                        i6 = this.mPopupHeight;
                    } else {
                        this.mPopupHeight = i6;
                    }
                }
                int i7 = layoutParams.x;
                int i8 = layoutParams.y;
                if (z) {
                    updateAboveAnchor(findDropDownPosition(view2, layoutParams, i, i2));
                } else {
                    updateAboveAnchor(findDropDownPosition(view2, layoutParams, this.mAnchorXoff, this.mAnchorYoff));
                }
                int i9 = layoutParams.x;
                int i10 = layoutParams.y;
                update(i9, i10, i5, i6, (i7 == i9 && i8 == i10) ? true : true);
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
                View view2 = this.mPopupView;
                View view3 = this.mContentView;
                if (view2 != view3 && (view2 instanceof ViewGroup)) {
                    ((ViewGroup) view2).removeView(view3);
                }
                this.mPopupView = null;
                onDismissListener = this.mOnDismissListener;
                if (onDismissListener == null) {
                    return;
                }
            } catch (IllegalArgumentException unused) {
                View view4 = this.mPopupView;
                View view5 = this.mContentView;
                if (view4 != view5 && (view4 instanceof ViewGroup)) {
                    ((ViewGroup) view4).removeView(view5);
                }
                this.mPopupView = null;
                onDismissListener = this.mOnDismissListener;
                if (onDismissListener == null) {
                    return;
                }
            } catch (Throwable th) {
                View view6 = this.mPopupView;
                View view7 = this.mContentView;
                if (view6 != view7 && (view6 instanceof ViewGroup)) {
                    ((ViewGroup) view6).removeView(view7);
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

    public void doShowAtLocation(IBinder iBinder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, iBinder, i, i2, i3) == null) && iBinder != null && !isShowing() && this.mContentView != null) {
            unregisterForScrollChanged();
            this.mIsShowing = true;
            this.mIsDropdown = false;
            WindowManager.LayoutParams createPopupLayout = createPopupLayout(iBinder);
            createPopupLayout.windowAnimations = computeAnimationResource();
            preparePopup(createPopupLayout);
            if (i == 0) {
                i = 51;
            }
            createPopupLayout.gravity = i;
            createPopupLayout.x = i2;
            createPopupLayout.y = i3;
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
            invokePopup(createPopupLayout);
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
            char c = 65535;
            if (str.hashCode() == 1939912032 && str.equals("showAsDropDown")) {
                c = 0;
            }
            if (c != 0) {
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

    public void showAtLocation(IBinder iBinder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048625, this, iBinder, i, i2, i3) == null) {
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            doShowAtLocation(iBinder, i, i2, i3);
            if (this.mImmersionEnabled) {
                getContentView().setSystemUiVisibility(5120);
                setFocusable(true);
                update();
            }
        }
    }

    public void update(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048629, this, i, i2, i3, i4) == null) {
            update(i, i2, i3, i4, false);
        }
    }

    public void showAtLocation(View view2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048626, this, view2, i, i2, i3) == null) {
            if (this.mImmersionEnabled) {
                setFocusable(false);
            }
            doShowAtLocation(view2.getWindowToken(), i, i2, i3);
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

    public void update(int i, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            if (i3 != -1) {
                this.mLastWidth = i3;
                setWidth(i3);
            }
            if (i4 != -1) {
                this.mLastHeight = i4;
                setHeight(i4);
            }
            if (isShowing() && this.mContentView != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
                int i5 = this.mWidthMode;
                if (i5 >= 0) {
                    i5 = this.mLastWidth;
                }
                boolean z2 = true;
                if (i3 != -1 && layoutParams.width != i5) {
                    this.mLastWidth = i5;
                    layoutParams.width = i5;
                    z = true;
                }
                int i6 = this.mHeightMode;
                if (i6 >= 0) {
                    i6 = this.mLastHeight;
                }
                if (i4 != -1 && layoutParams.height != i6) {
                    this.mLastHeight = i6;
                    layoutParams.height = i6;
                    z = true;
                }
                if (layoutParams.x != i) {
                    layoutParams.x = i;
                    z = true;
                }
                if (layoutParams.y != i2) {
                    layoutParams.y = i2;
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
    }

    public void update(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            update(view2, true, i, i2, true, i3, i4);
        }
    }
}
