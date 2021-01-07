package com.baidu.swan.menu;

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
import com.baidu.swan.menu.f;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class PopupWindow {
    private static final int[] eve = {16842922};
    private boolean epJ;
    private boolean euF;
    private View euG;
    private int euH;
    private boolean euI;
    private boolean euJ;
    private int euK;
    private boolean euL;
    private boolean euM;
    private boolean euN;
    private boolean euO;
    private boolean euP;
    private View.OnTouchListener euQ;
    private int euR;
    private int euS;
    private int euT;
    private int euU;
    private int[] euV;
    private int[] euW;
    private Drawable euX;
    private Drawable euY;
    private boolean euZ;
    private int eva;
    private a evb;
    private boolean evc;
    private int evd;
    private WeakReference<View> evf;
    private ViewTreeObserver.OnScrollChangedListener evg;
    private int evh;
    private int evi;
    private Drawable mBackground;
    private View mContentView;
    private Context mContext;
    private boolean mFocusable;
    private int mHeight;
    private int mHeightMode;
    private boolean mOutsideTouchable;
    private int mSoftInputMode;
    private Rect mTempRect;
    private int mWidth;
    private int mWidthMode;
    private WindowManager mWindowManager;

    /* loaded from: classes6.dex */
    public interface a {
        void onDismiss();
    }

    public PopupWindow(Context context) {
        this(context, null);
    }

    public PopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842870);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.euH = 0;
        this.mSoftInputMode = 1;
        this.euI = true;
        this.mOutsideTouchable = false;
        this.euJ = true;
        this.euK = -1;
        this.euN = true;
        this.euO = false;
        this.euV = new int[2];
        this.euW = new int[2];
        this.mTempRect = new Rect();
        this.eva = 1000;
        this.evc = false;
        this.evd = -1;
        this.evg = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view;
                if (PopupWindow.this.evf != null) {
                    view = (View) PopupWindow.this.evf.get();
                } else {
                    view = null;
                }
                if (view != null && PopupWindow.this.euG != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.euG.getLayoutParams();
                    PopupWindow.this.iB(PopupWindow.this.b(view, layoutParams, PopupWindow.this.evh, PopupWindow.this.evi));
                    PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.h.PopupWindow, i, i2);
        this.mBackground = obtainStyledAttributes.getDrawable(f.h.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(f.h.PopupWindow_popupAnimationStyle, -1);
        this.evd = resourceId == 16973824 ? -1 : resourceId;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
        this.euH = 0;
        this.mSoftInputMode = 1;
        this.euI = true;
        this.mOutsideTouchable = false;
        this.euJ = true;
        this.euK = -1;
        this.euN = true;
        this.euO = false;
        this.euV = new int[2];
        this.euW = new int[2];
        this.mTempRect = new Rect();
        this.eva = 1000;
        this.evc = false;
        this.evd = -1;
        this.evg = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2;
                if (PopupWindow.this.evf != null) {
                    view2 = (View) PopupWindow.this.evf.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && PopupWindow.this.euG != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.euG.getLayoutParams();
                    PopupWindow.this.iB(PopupWindow.this.b(view2, layoutParams, PopupWindow.this.evh, PopupWindow.this.evi));
                    PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        if (view != null) {
            this.mContext = view.getContext();
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackground = drawable;
    }

    public void setAnimationStyle(int i) {
        this.evd = i;
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
            if (this.mWindowManager == null && this.mContext != null) {
                this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            }
        }
    }

    public void setFocusable(boolean z) {
        this.mFocusable = z;
    }

    public void setSoftInputMode(int i) {
        this.mSoftInputMode = i;
    }

    public void eh(boolean z) {
        this.mOutsideTouchable = z;
    }

    public void ei(boolean z) {
        this.euJ = z;
    }

    public boolean agc() {
        return (this.euK >= 0 || this.mContext == null) ? this.euK == 1 : this.mContext.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean isShowing() {
        return this.epJ;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        b(view.getWindowToken(), i, i2, i3);
    }

    public void b(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.mContentView != null) {
            bfl();
            this.epJ = true;
            this.euF = false;
            WindowManager.LayoutParams d = d(iBinder);
            d.windowAnimations = bfk();
            c(d);
            if (i == 0) {
                i = 51;
            }
            d.gravity = i;
            d.x = i2;
            d.y = i3;
            if (this.mHeightMode < 0) {
                int i4 = this.mHeightMode;
                this.euS = i4;
                d.height = i4;
            }
            if (this.mWidthMode < 0) {
                int i5 = this.mWidthMode;
                this.euR = i5;
                d.width = i5;
            }
            d(d);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        h(view, i, i2);
    }

    public void h(View view, int i, int i2) {
        if (!isShowing() && this.mContentView != null) {
            i(view, i, i2);
            this.epJ = true;
            this.euF = true;
            WindowManager.LayoutParams d = d(view.getWindowToken());
            c(d);
            iB(b(view, d, i, i2));
            if (this.mHeightMode < 0) {
                int i3 = this.mHeightMode;
                this.euS = i3;
                d.height = i3;
            }
            if (this.mWidthMode < 0) {
                int i4 = this.mWidthMode;
                this.euR = i4;
                d.width = i4;
            }
            d.windowAnimations = bfk();
            d(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(boolean z) {
        if (z != this.euZ) {
            this.euZ = z;
            if (this.mBackground != null) {
                if (this.euX != null) {
                    if (this.euZ) {
                        this.euG.setBackgroundDrawable(this.euX);
                        return;
                    } else {
                        this.euG.setBackgroundDrawable(this.euY);
                        return;
                    }
                }
                this.euG.refreshDrawableState();
            }
        }
    }

    private void c(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        if (this.mContentView == null || this.mContext == null || this.mWindowManager == null) {
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
        if (this.mBackground != null) {
            ViewGroup.LayoutParams layoutParams2 = this.mContentView.getLayoutParams();
            if (layoutParams2 == null || layoutParams2.height != -2) {
                i = -1;
            }
            b bVar = new b(this.mContext);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
            bVar.setBackgroundDrawable(this.mBackground);
            bVar.addView(this.mContentView, layoutParams3);
            this.euG = bVar;
        } else {
            this.euG = this.mContentView;
        }
        this.euT = layoutParams.width;
        this.euU = layoutParams.height;
    }

    private void d(WindowManager.LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        this.mWindowManager.addView(this.euG, layoutParams);
    }

    private WindowManager.LayoutParams d(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.mWidth;
        this.euR = i;
        layoutParams.width = i;
        int i2 = this.mHeight;
        this.euS = i2;
        layoutParams.height = i2;
        if (this.mBackground != null) {
            layoutParams.format = this.mBackground.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = nf(layoutParams.flags);
        layoutParams.type = this.eva;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.mSoftInputMode;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private int nf(int i) {
        int i2 = (-8815129) & i;
        if (this.evc) {
            i2 |= 32768;
        }
        if (!this.mFocusable) {
            i2 |= 8;
            if (this.euH == 1) {
                i2 |= 131072;
            }
        } else if (this.euH == 2) {
            i2 |= 131072;
        }
        if (!this.euI) {
            i2 |= 16;
        }
        if (this.mOutsideTouchable) {
            i2 |= 262144;
        }
        if (!this.euJ) {
            i2 |= 512;
        }
        if (agc()) {
            i2 |= 8388608;
        }
        if (this.euL) {
            i2 |= 256;
        }
        if (this.euO) {
            i2 |= 65536;
        }
        if (this.euP) {
            return i2 | 32;
        }
        return i2;
    }

    private int bfk() {
        if (this.evd == -1) {
            if (this.euF) {
                return this.euZ ? f.g.PopupWindow_DropDownUp : f.g.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return this.evd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.euV);
        layoutParams.x = this.euV[0] + i;
        layoutParams.y = this.euV[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.euW);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.euW[1] + i2 + this.euU > rect.bottom || (layoutParams.x + this.euT) - rootView.getWidth() > 0) {
            if (this.euN) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.euT + scrollX + i, this.euU + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.euV);
            layoutParams.x = this.euV[0] + i;
            layoutParams.y = this.euV[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.euW);
            r0 = ((rect.bottom - this.euW[1]) - view.getHeight()) - i2 < (this.euW[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.euV[1]) + i2;
            } else {
                layoutParams.y = this.euV[1] + view.getHeight() + i2;
            }
        }
        if (this.euM) {
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
                int i5 = (this.euW[1] + i2) - this.euU;
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IGET]}, finally: {[IGET, IGET, IGET, INVOKE, IF, IPUT, IGET, IGET, CHECK_CAST, IGET, INVOKE, IGET, INVOKE, IF, IPUT, IGET, IF, IGET, INSTANCE_OF, IGET, INVOKE, IF, IPUT, IGET, IF] complete} */
    public void dismiss() {
        if (isShowing() && this.euG != null) {
            this.epJ = false;
            bfl();
            try {
                this.mWindowManager.removeView(this.euG);
                if (this.euG != this.mContentView && (this.euG instanceof ViewGroup)) {
                    ((ViewGroup) this.euG).removeView(this.mContentView);
                }
                this.euG = null;
                if (this.evb != null) {
                    this.evb.onDismiss();
                }
            } catch (IllegalArgumentException e) {
                if (this.euG != this.mContentView && (this.euG instanceof ViewGroup)) {
                    ((ViewGroup) this.euG).removeView(this.mContentView);
                }
                this.euG = null;
                if (this.evb != null) {
                    this.evb.onDismiss();
                }
            } catch (Throwable th) {
                if (this.euG != this.mContentView && (this.euG instanceof ViewGroup)) {
                    ((ViewGroup) this.euG).removeView(this.mContentView);
                }
                this.euG = null;
                if (this.evb != null) {
                    this.evb.onDismiss();
                }
                throw th;
            }
        }
    }

    public void a(a aVar) {
        this.evb = aVar;
    }

    public void update() {
        boolean z = true;
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.euG.getLayoutParams();
            boolean z2 = false;
            int bfk = bfk();
            if (bfk != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = bfk;
                z2 = true;
            }
            int nf = nf(layoutParams.flags);
            if (nf != layoutParams.flags) {
                layoutParams.flags = nf;
            } else {
                z = z2;
            }
            if (z) {
                this.mWindowManager.updateViewLayout(this.euG, layoutParams);
            }
        }
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.euR = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.euS = i4;
            setHeight(i4);
        }
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.euG.getLayoutParams();
            int i5 = this.mWidthMode < 0 ? this.mWidthMode : this.euR;
            if (i3 != -1 && layoutParams.width != i5) {
                this.euR = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.mHeightMode < 0 ? this.mHeightMode : this.euS;
            if (i4 != -1 && layoutParams.height != i6) {
                this.euS = i6;
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
            int bfk = bfk();
            if (bfk != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = bfk;
                z = true;
            }
            int nf = nf(layoutParams.flags);
            if (nf != layoutParams.flags) {
                layoutParams.flags = nf;
            } else {
                z2 = z;
            }
            if (z2) {
                this.mWindowManager.updateViewLayout(this.euG, layoutParams);
            }
        }
    }

    private void bfl() {
        WeakReference<View> weakReference = this.evf;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.evg);
        }
        this.evf = null;
    }

    private void i(View view, int i, int i2) {
        bfl();
        this.evf = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.evg);
        }
        this.evh = i;
        this.evi = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.euZ) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.eve);
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
            if (PopupWindow.this.euQ == null || !PopupWindow.this.euQ.onTouch(this, motionEvent)) {
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
