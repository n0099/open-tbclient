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
/* loaded from: classes5.dex */
public class PopupWindow {
    private static final int[] eqq = {16842922};
    private boolean ekU;
    private boolean epR;
    private View epS;
    private int epT;
    private boolean epU;
    private boolean epV;
    private int epW;
    private boolean epX;
    private boolean epY;
    private boolean epZ;
    private boolean eqa;
    private boolean eqb;
    private View.OnTouchListener eqc;
    private int eqd;
    private int eqe;
    private int eqf;
    private int eqg;
    private int[] eqh;
    private int[] eqi;
    private Drawable eqj;
    private Drawable eqk;
    private boolean eql;
    private int eqm;
    private a eqn;
    private boolean eqo;
    private int eqp;
    private WeakReference<View> eqr;
    private ViewTreeObserver.OnScrollChangedListener eqs;
    private int eqt;
    private int equ;
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

    /* loaded from: classes5.dex */
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
        this.epT = 0;
        this.mSoftInputMode = 1;
        this.epU = true;
        this.mOutsideTouchable = false;
        this.epV = true;
        this.epW = -1;
        this.epZ = true;
        this.eqa = false;
        this.eqh = new int[2];
        this.eqi = new int[2];
        this.mTempRect = new Rect();
        this.eqm = 1000;
        this.eqo = false;
        this.eqp = -1;
        this.eqs = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view;
                if (PopupWindow.this.eqr != null) {
                    view = (View) PopupWindow.this.eqr.get();
                } else {
                    view = null;
                }
                if (view != null && PopupWindow.this.epS != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.epS.getLayoutParams();
                    PopupWindow.this.ix(PopupWindow.this.b(view, layoutParams, PopupWindow.this.eqt, PopupWindow.this.equ));
                    PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.h.PopupWindow, i, i2);
        this.mBackground = obtainStyledAttributes.getDrawable(f.h.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(f.h.PopupWindow_popupAnimationStyle, -1);
        this.eqp = resourceId == 16973824 ? -1 : resourceId;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
        this.epT = 0;
        this.mSoftInputMode = 1;
        this.epU = true;
        this.mOutsideTouchable = false;
        this.epV = true;
        this.epW = -1;
        this.epZ = true;
        this.eqa = false;
        this.eqh = new int[2];
        this.eqi = new int[2];
        this.mTempRect = new Rect();
        this.eqm = 1000;
        this.eqo = false;
        this.eqp = -1;
        this.eqs = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2;
                if (PopupWindow.this.eqr != null) {
                    view2 = (View) PopupWindow.this.eqr.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && PopupWindow.this.epS != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.epS.getLayoutParams();
                    PopupWindow.this.ix(PopupWindow.this.b(view2, layoutParams, PopupWindow.this.eqt, PopupWindow.this.equ));
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
        this.eqp = i;
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

    public void ed(boolean z) {
        this.mOutsideTouchable = z;
    }

    public void ee(boolean z) {
        this.epV = z;
    }

    public boolean aci() {
        return (this.epW >= 0 || this.mContext == null) ? this.epW == 1 : this.mContext.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean isShowing() {
        return this.ekU;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        b(view.getWindowToken(), i, i2, i3);
    }

    public void b(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.mContentView != null) {
            bbr();
            this.ekU = true;
            this.epR = false;
            WindowManager.LayoutParams d = d(iBinder);
            d.windowAnimations = bbq();
            c(d);
            if (i == 0) {
                i = 51;
            }
            d.gravity = i;
            d.x = i2;
            d.y = i3;
            if (this.mHeightMode < 0) {
                int i4 = this.mHeightMode;
                this.eqe = i4;
                d.height = i4;
            }
            if (this.mWidthMode < 0) {
                int i5 = this.mWidthMode;
                this.eqd = i5;
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
            this.ekU = true;
            this.epR = true;
            WindowManager.LayoutParams d = d(view.getWindowToken());
            c(d);
            ix(b(view, d, i, i2));
            if (this.mHeightMode < 0) {
                int i3 = this.mHeightMode;
                this.eqe = i3;
                d.height = i3;
            }
            if (this.mWidthMode < 0) {
                int i4 = this.mWidthMode;
                this.eqd = i4;
                d.width = i4;
            }
            d.windowAnimations = bbq();
            d(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ix(boolean z) {
        if (z != this.eql) {
            this.eql = z;
            if (this.mBackground != null) {
                if (this.eqj != null) {
                    if (this.eql) {
                        this.epS.setBackgroundDrawable(this.eqj);
                        return;
                    } else {
                        this.epS.setBackgroundDrawable(this.eqk);
                        return;
                    }
                }
                this.epS.refreshDrawableState();
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
            this.epS = bVar;
        } else {
            this.epS = this.mContentView;
        }
        this.eqf = layoutParams.width;
        this.eqg = layoutParams.height;
    }

    private void d(WindowManager.LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        this.mWindowManager.addView(this.epS, layoutParams);
    }

    private WindowManager.LayoutParams d(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.mWidth;
        this.eqd = i;
        layoutParams.width = i;
        int i2 = this.mHeight;
        this.eqe = i2;
        layoutParams.height = i2;
        if (this.mBackground != null) {
            layoutParams.format = this.mBackground.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = lz(layoutParams.flags);
        layoutParams.type = this.eqm;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.mSoftInputMode;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private int lz(int i) {
        int i2 = (-8815129) & i;
        if (this.eqo) {
            i2 |= 32768;
        }
        if (!this.mFocusable) {
            i2 |= 8;
            if (this.epT == 1) {
                i2 |= 131072;
            }
        } else if (this.epT == 2) {
            i2 |= 131072;
        }
        if (!this.epU) {
            i2 |= 16;
        }
        if (this.mOutsideTouchable) {
            i2 |= 262144;
        }
        if (!this.epV) {
            i2 |= 512;
        }
        if (aci()) {
            i2 |= 8388608;
        }
        if (this.epX) {
            i2 |= 256;
        }
        if (this.eqa) {
            i2 |= 65536;
        }
        if (this.eqb) {
            return i2 | 32;
        }
        return i2;
    }

    private int bbq() {
        if (this.eqp == -1) {
            if (this.epR) {
                return this.eql ? f.g.PopupWindow_DropDownUp : f.g.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return this.eqp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.eqh);
        layoutParams.x = this.eqh[0] + i;
        layoutParams.y = this.eqh[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.eqi);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.eqi[1] + i2 + this.eqg > rect.bottom || (layoutParams.x + this.eqf) - rootView.getWidth() > 0) {
            if (this.epZ) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.eqf + scrollX + i, this.eqg + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.eqh);
            layoutParams.x = this.eqh[0] + i;
            layoutParams.y = this.eqh[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.eqi);
            r0 = ((rect.bottom - this.eqi[1]) - view.getHeight()) - i2 < (this.eqi[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.eqh[1]) + i2;
            } else {
                layoutParams.y = this.eqh[1] + view.getHeight() + i2;
            }
        }
        if (this.epY) {
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
                int i5 = (this.eqi[1] + i2) - this.eqg;
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
        if (isShowing() && this.epS != null) {
            this.ekU = false;
            bbr();
            try {
                this.mWindowManager.removeView(this.epS);
                if (this.epS != this.mContentView && (this.epS instanceof ViewGroup)) {
                    ((ViewGroup) this.epS).removeView(this.mContentView);
                }
                this.epS = null;
                if (this.eqn != null) {
                    this.eqn.onDismiss();
                }
            } catch (IllegalArgumentException e) {
                if (this.epS != this.mContentView && (this.epS instanceof ViewGroup)) {
                    ((ViewGroup) this.epS).removeView(this.mContentView);
                }
                this.epS = null;
                if (this.eqn != null) {
                    this.eqn.onDismiss();
                }
            } catch (Throwable th) {
                if (this.epS != this.mContentView && (this.epS instanceof ViewGroup)) {
                    ((ViewGroup) this.epS).removeView(this.mContentView);
                }
                this.epS = null;
                if (this.eqn != null) {
                    this.eqn.onDismiss();
                }
                throw th;
            }
        }
    }

    public void a(a aVar) {
        this.eqn = aVar;
    }

    public void update() {
        boolean z = true;
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.epS.getLayoutParams();
            boolean z2 = false;
            int bbq = bbq();
            if (bbq != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = bbq;
                z2 = true;
            }
            int lz = lz(layoutParams.flags);
            if (lz != layoutParams.flags) {
                layoutParams.flags = lz;
            } else {
                z = z2;
            }
            if (z) {
                this.mWindowManager.updateViewLayout(this.epS, layoutParams);
            }
        }
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.eqd = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.eqe = i4;
            setHeight(i4);
        }
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.epS.getLayoutParams();
            int i5 = this.mWidthMode < 0 ? this.mWidthMode : this.eqd;
            if (i3 != -1 && layoutParams.width != i5) {
                this.eqd = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.mHeightMode < 0 ? this.mHeightMode : this.eqe;
            if (i4 != -1 && layoutParams.height != i6) {
                this.eqe = i6;
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
            int bbq = bbq();
            if (bbq != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = bbq;
                z = true;
            }
            int lz = lz(layoutParams.flags);
            if (lz != layoutParams.flags) {
                layoutParams.flags = lz;
            } else {
                z2 = z;
            }
            if (z2) {
                this.mWindowManager.updateViewLayout(this.epS, layoutParams);
            }
        }
    }

    private void bbr() {
        WeakReference<View> weakReference = this.eqr;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.eqs);
        }
        this.eqr = null;
    }

    private void i(View view, int i, int i2) {
        bbr();
        this.eqr = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.eqs);
        }
        this.eqt = i;
        this.equ = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.eql) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.eqq);
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
            if (PopupWindow.this.eqc == null || !PopupWindow.this.eqc.onTouch(this, motionEvent)) {
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
