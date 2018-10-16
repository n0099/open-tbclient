package com.baidu.searchbox.ng.aiapps.menu.view;

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
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.aiapps.menu.R;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class PopupWindow {
    private static final int[] ABOVE_ANCHOR_STATE_SET = {16842922};
    private static final boolean DEBUG = false;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    private boolean mAboveAnchor;
    private Drawable mAboveAnchorBackgroundDrawable;
    private boolean mAllowScrollingAnchorParent;
    private WeakReference<View> mAnchor;
    private int mAnchorXoff;
    private int mAnchorYoff;
    private int mAnimationStyle;
    private Drawable mBackground;
    private Drawable mBelowAnchorBackgroundDrawable;
    private boolean mClipToScreen;
    private boolean mClippingEnabled;
    private View mContentView;
    private Context mContext;
    private int[] mDrawingLocation;
    private boolean mFocusable;
    private int mHeight;
    private int mHeightMode;
    private boolean mIgnoreCheekPress;
    private int mInputMethodMode;
    private boolean mIsDropdown;
    private boolean mIsShowing;
    private int mLastHeight;
    private int mLastWidth;
    private boolean mLayoutInScreen;
    private boolean mLayoutInsetDecor;
    private boolean mNotTouchModal;
    private OnDismissListener mOnDismissListener;
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
    private boolean mOutsideTouchable;
    private int mPopupHeight;
    private View mPopupView;
    private int mPopupWidth;
    private int[] mScreenLocation;
    private int mSoftInputMode;
    private int mSplitTouchEnabled;
    private Rect mTempRect;
    private View.OnTouchListener mTouchInterceptor;
    private boolean mTouchable;
    private int mWidth;
    private int mWidthMode;
    private int mWindowLayoutType;
    private WindowManager mWindowManager;

    /* loaded from: classes2.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    public PopupWindow(Context context) {
        this(context, (AttributeSet) null);
    }

    public PopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842870);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
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
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.searchbox.ng.aiapps.menu.view.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view;
                if (PopupWindow.this.mAnchor != null) {
                    view = (View) PopupWindow.this.mAnchor.get();
                } else {
                    view = null;
                }
                if (view != null && PopupWindow.this.mPopupView != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.mPopupView.getLayoutParams();
                    PopupWindow.this.updateAboveAnchor(PopupWindow.this.findDropDownPosition(view, layoutParams, PopupWindow.this.mAnchorXoff, PopupWindow.this.mAnchorYoff));
                    PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PopupWindow, i, i2);
        this.mBackground = obtainStyledAttributes.getDrawable(R.styleable.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PopupWindow_popupAnimationStyle, -1);
        this.mAnimationStyle = resourceId == 16973824 ? -1 : resourceId;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view) {
        this(view, 0, 0);
    }

    public PopupWindow(int i, int i2) {
        this((View) null, i, i2);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
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
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.searchbox.ng.aiapps.menu.view.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2;
                if (PopupWindow.this.mAnchor != null) {
                    view2 = (View) PopupWindow.this.mAnchor.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && PopupWindow.this.mPopupView != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.mPopupView.getLayoutParams();
                    PopupWindow.this.updateAboveAnchor(PopupWindow.this.findDropDownPosition(view2, layoutParams, PopupWindow.this.mAnchorXoff, PopupWindow.this.mAnchorYoff));
                    PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        if (view != null) {
            this.mContext = view.getContext();
            this.mWindowManager = (WindowManager) this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY);
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    public Drawable getBackground() {
        return this.mBackground;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackground = drawable;
    }

    public int getAnimationStyle() {
        return this.mAnimationStyle;
    }

    public void setIgnoreCheekPress() {
        this.mIgnoreCheekPress = true;
    }

    public void setAnimationStyle(int i) {
        this.mAnimationStyle = i;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public void setContentView(View view) {
        if (!isShowing()) {
            this.mContentView = view;
            if (this.mContext == null && this.mContentView != null) {
                this.mContext = this.mContentView.getContext();
            }
            if (this.mWindowManager == null && this.mContentView != null) {
                this.mWindowManager = (WindowManager) this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY);
            }
        }
    }

    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        this.mTouchInterceptor = onTouchListener;
    }

    public boolean isFocusable() {
        return this.mFocusable;
    }

    public void setFocusable(boolean z) {
        this.mFocusable = z;
    }

    public int getInputMethodMode() {
        return this.mInputMethodMode;
    }

    public void setInputMethodMode(int i) {
        this.mInputMethodMode = i;
    }

    public void setSoftInputMode(int i) {
        this.mSoftInputMode = i;
    }

    public int getSoftInputMode() {
        return this.mSoftInputMode;
    }

    public boolean isTouchable() {
        return this.mTouchable;
    }

    public void setTouchable(boolean z) {
        this.mTouchable = z;
    }

    public boolean isOutsideTouchable() {
        return this.mOutsideTouchable;
    }

    public void setOutsideTouchable(boolean z) {
        this.mOutsideTouchable = z;
    }

    public boolean isClippingEnabled() {
        return this.mClippingEnabled;
    }

    public void setClippingEnabled(boolean z) {
        this.mClippingEnabled = z;
    }

    public void setClipToScreenEnabled(boolean z) {
        this.mClipToScreen = z;
        setClippingEnabled(!z);
    }

    void setAllowScrollingAnchorParent(boolean z) {
        this.mAllowScrollingAnchorParent = z;
    }

    public boolean isSplitTouchEnabled() {
        return (this.mSplitTouchEnabled >= 0 || this.mContext == null) ? this.mSplitTouchEnabled == 1 : this.mContext.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setSplitTouchEnabled(boolean z) {
        this.mSplitTouchEnabled = z ? 1 : 0;
    }

    public boolean isLayoutInScreenEnabled() {
        return this.mLayoutInScreen;
    }

    public void setLayoutInScreenEnabled(boolean z) {
        this.mLayoutInScreen = z;
    }

    public void setLayoutInsetDecor(boolean z) {
        this.mLayoutInsetDecor = z;
    }

    public void setWindowLayoutType(int i) {
        this.mWindowLayoutType = i;
    }

    public int getWindowLayoutType() {
        return this.mWindowLayoutType;
    }

    public void setTouchModal(boolean z) {
        this.mNotTouchModal = !z;
    }

    public void setWindowLayoutMode(int i, int i2) {
        this.mWidthMode = i;
        this.mHeightMode = i2;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        doShowAtLocation(view.getWindowToken(), i, i2, i3);
    }

    public void showAtLocation(IBinder iBinder, int i, int i2, int i3) {
        doShowAtLocation(iBinder, i, i2, i3);
    }

    public void doShowAtLocation(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.mContentView != null) {
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
            if (this.mHeightMode < 0) {
                int i4 = this.mHeightMode;
                this.mLastHeight = i4;
                createPopupLayout.height = i4;
            }
            if (this.mWidthMode < 0) {
                int i5 = this.mWidthMode;
                this.mLastWidth = i5;
                createPopupLayout.width = i5;
            }
            invokePopup(createPopupLayout);
        }
    }

    public void showAsDropDown(View view) {
        doShowAsDropDown(view, 0, 0);
    }

    public void showAsDropDown(View view, int i, int i2) {
        doShowAsDropDown(view, i, i2);
    }

    public void doShowAsDropDown(View view, int i, int i2) {
        if (!isShowing() && this.mContentView != null) {
            registerForScrollChanged(view, i, i2);
            this.mIsShowing = true;
            this.mIsDropdown = true;
            WindowManager.LayoutParams createPopupLayout = createPopupLayout(view.getWindowToken());
            preparePopup(createPopupLayout);
            updateAboveAnchor(findDropDownPosition(view, createPopupLayout, i, i2));
            if (this.mHeightMode < 0) {
                int i3 = this.mHeightMode;
                this.mLastHeight = i3;
                createPopupLayout.height = i3;
            }
            if (this.mWidthMode < 0) {
                int i4 = this.mWidthMode;
                this.mLastWidth = i4;
                createPopupLayout.width = i4;
            }
            createPopupLayout.windowAnimations = computeAnimationResource();
            invokePopup(createPopupLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAboveAnchor(boolean z) {
        if (z != this.mAboveAnchor) {
            this.mAboveAnchor = z;
            if (this.mBackground != null) {
                if (this.mAboveAnchorBackgroundDrawable != null) {
                    if (this.mAboveAnchor) {
                        this.mPopupView.setBackgroundDrawable(this.mAboveAnchorBackgroundDrawable);
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

    public boolean isAboveAnchor() {
        return this.mAboveAnchor;
    }

    private void preparePopup(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        if (this.mContentView == null || this.mContext == null || this.mWindowManager == null) {
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
        if (this.mBackground != null) {
            ViewGroup.LayoutParams layoutParams2 = this.mContentView.getLayoutParams();
            if (layoutParams2 == null || layoutParams2.height != -2) {
                i = -1;
            }
            PopupViewContainer popupViewContainer = new PopupViewContainer(this.mContext);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
            popupViewContainer.setBackgroundDrawable(this.mBackground);
            popupViewContainer.addView(this.mContentView, layoutParams3);
            this.mPopupView = popupViewContainer;
        } else {
            this.mPopupView = this.mContentView;
        }
        this.mPopupWidth = layoutParams.width;
        this.mPopupHeight = layoutParams.height;
    }

    private void invokePopup(WindowManager.LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        this.mWindowManager.addView(this.mPopupView, layoutParams);
    }

    private WindowManager.LayoutParams createPopupLayout(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.mWidth;
        this.mLastWidth = i;
        layoutParams.width = i;
        int i2 = this.mHeight;
        this.mLastHeight = i2;
        layoutParams.height = i2;
        if (this.mBackground != null) {
            layoutParams.format = this.mBackground.getOpacity();
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

    private int computeFlags(int i) {
        int i2 = (-8815129) & i;
        if (this.mIgnoreCheekPress) {
            i2 |= 32768;
        }
        if (!this.mFocusable) {
            i2 |= 8;
            if (this.mInputMethodMode == 1) {
                i2 |= 131072;
            }
        } else if (this.mInputMethodMode == 2) {
            i2 |= 131072;
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

    private int computeAnimationResource() {
        if (this.mAnimationStyle == -1) {
            if (this.mIsDropdown) {
                return this.mAboveAnchor ? R.style.PopupWindow_DropDownUp : R.style.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return this.mAnimationStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean findDropDownPosition(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.mDrawingLocation);
        layoutParams.x = this.mDrawingLocation[0] + i;
        layoutParams.y = this.mDrawingLocation[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.mScreenLocation);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.mScreenLocation[1] + i2 + this.mPopupHeight > rect.bottom || (layoutParams.x + this.mPopupWidth) - rootView.getWidth() > 0) {
            if (this.mAllowScrollingAnchorParent) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.mPopupWidth + scrollX + i, this.mPopupHeight + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.mDrawingLocation);
            layoutParams.x = this.mDrawingLocation[0] + i;
            layoutParams.y = this.mDrawingLocation[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.mScreenLocation);
            r0 = ((rect.bottom - this.mScreenLocation[1]) - view.getHeight()) - i2 < (this.mScreenLocation[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.mDrawingLocation[1]) + i2;
            } else {
                layoutParams.y = this.mDrawingLocation[1] + view.getHeight() + i2;
            }
        }
        if (this.mClipToScreen) {
            int i3 = rect.right - rect.left;
            int i4 = layoutParams.x + layoutParams.width;
            if (i4 > i3) {
                layoutParams.x -= i4 - i3;
            }
            if (layoutParams.x < rect.left) {
                layoutParams.x = rect.left;
                layoutParams.width = Math.min(layoutParams.width, i3);
            }
            if (r0) {
                int i5 = (this.mScreenLocation[1] + i2) - this.mPopupHeight;
                if (i5 < 0) {
                    layoutParams.y = i5 + layoutParams.y;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= 268435456;
        return r0;
    }

    public int getMaxAvailableHeight(View view) {
        return getMaxAvailableHeight(view, 0);
    }

    public int getMaxAvailableHeight(View view, int i) {
        return getMaxAvailableHeight(view, i, false);
    }

    public int getMaxAvailableHeight(View view, int i, boolean z) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = this.mDrawingLocation;
        view.getLocationOnScreen(iArr);
        int i2 = rect.bottom;
        if (z) {
            i2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int max = Math.max((i2 - (iArr[1] + view.getHeight())) - i, (iArr[1] - rect.top) + i);
        if (this.mBackground != null) {
            this.mBackground.getPadding(this.mTempRect);
            return max - (this.mTempRect.top + this.mTempRect.bottom);
        }
        return max;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IGET]}, finally: {[IGET, IGET, IGET, INVOKE, IF, IPUT, IGET, IGET, CHECK_CAST, IGET, INVOKE, IGET, INVOKE, IF, IPUT, IGET, IF, IGET, INSTANCE_OF, IGET, INVOKE, IF, IPUT, IGET, IF] complete} */
    public void dismiss() {
        if (isShowing() && this.mPopupView != null) {
            this.mIsShowing = false;
            unregisterForScrollChanged();
            try {
                this.mWindowManager.removeView(this.mPopupView);
                if (this.mPopupView != this.mContentView && (this.mPopupView instanceof ViewGroup)) {
                    ((ViewGroup) this.mPopupView).removeView(this.mContentView);
                }
                this.mPopupView = null;
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss();
                }
            } catch (IllegalArgumentException e) {
                if (this.mPopupView != this.mContentView && (this.mPopupView instanceof ViewGroup)) {
                    ((ViewGroup) this.mPopupView).removeView(this.mContentView);
                }
                this.mPopupView = null;
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss();
                }
            } catch (Throwable th) {
                if (this.mPopupView != this.mContentView && (this.mPopupView instanceof ViewGroup)) {
                    ((ViewGroup) this.mPopupView).removeView(this.mContentView);
                }
                this.mPopupView = null;
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss();
                }
                throw th;
            }
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void update() {
        boolean z = true;
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
            boolean z2 = false;
            int computeAnimationResource = computeAnimationResource();
            if (computeAnimationResource != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = computeAnimationResource;
                z2 = true;
            }
            int computeFlags = computeFlags(layoutParams.flags);
            if (computeFlags != layoutParams.flags) {
                layoutParams.flags = computeFlags;
            } else {
                z = z2;
            }
            if (z) {
                this.mWindowManager.updateViewLayout(this.mPopupView, layoutParams);
            }
        }
    }

    public void update(int i, int i2) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
        update(layoutParams.x, layoutParams.y, i, i2, false);
    }

    public void update(int i, int i2, int i3, int i4) {
        update(i, i2, i3, i4, false);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
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
            int i5 = this.mWidthMode < 0 ? this.mWidthMode : this.mLastWidth;
            if (i3 != -1 && layoutParams.width != i5) {
                this.mLastWidth = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.mHeightMode < 0 ? this.mHeightMode : this.mLastHeight;
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

    public void update(View view, int i, int i2) {
        update(view, false, 0, 0, true, i, i2);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        update(view, true, i, i2, true, i3, i4);
    }

    private void update(View view, boolean z, int i, int i2, boolean z2, int i3, int i4) {
        int i5;
        int i6;
        if (isShowing() && this.mContentView != null) {
            WeakReference<View> weakReference = this.mAnchor;
            boolean z3 = z && !(this.mAnchorXoff == i && this.mAnchorYoff == i2);
            if (weakReference == null || weakReference.get() != view || (z3 && !this.mIsDropdown)) {
                registerForScrollChanged(view, i, i2);
            } else if (z3) {
                this.mAnchorXoff = i;
                this.mAnchorYoff = i2;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mPopupView.getLayoutParams();
            if (z2) {
                if (i3 == -1) {
                    i6 = this.mPopupWidth;
                } else {
                    this.mPopupWidth = i3;
                    i6 = i3;
                }
                if (i4 == -1) {
                    i5 = this.mPopupHeight;
                } else {
                    this.mPopupHeight = i4;
                    i5 = i4;
                }
            } else {
                i5 = i4;
                i6 = i3;
            }
            int i7 = layoutParams.x;
            int i8 = layoutParams.y;
            if (z) {
                updateAboveAnchor(findDropDownPosition(view, layoutParams, i, i2));
            } else {
                updateAboveAnchor(findDropDownPosition(view, layoutParams, this.mAnchorXoff, this.mAnchorYoff));
            }
            update(layoutParams.x, layoutParams.y, i6, i5, (i7 == layoutParams.x && i8 == layoutParams.y) ? false : true);
        }
    }

    private void unregisterForScrollChanged() {
        WeakReference<View> weakReference = this.mAnchor;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
        }
        this.mAnchor = null;
    }

    private void registerForScrollChanged(View view, int i, int i2) {
        unregisterForScrollChanged();
        this.mAnchor = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.mOnScrollChangedListener);
        }
        this.mAnchorXoff = i;
        this.mAnchorYoff = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class PopupViewContainer extends FrameLayout {
        private static final String TAG = "PopupWindow.PopupViewContainer";

        public PopupViewContainer(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.mAboveAnchor) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.ABOVE_ANCHOR_STATE_SET);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            if (keyEvent.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                        return true;
                    }
                    return true;
                } else if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    PopupWindow.this.dismiss();
                    return true;
                } else {
                    return super.dispatchKeyEvent(keyEvent);
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (PopupWindow.this.mTouchInterceptor == null || !PopupWindow.this.mTouchInterceptor.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= super.getWidth() || y < 0 || y >= super.getHeight())) {
                PopupWindow.this.dismiss();
                return true;
            } else if (motionEvent.getAction() == 4) {
                PopupWindow.this.dismiss();
                return true;
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i) {
            if (PopupWindow.this.mContentView != null) {
                PopupWindow.this.mContentView.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }
}
