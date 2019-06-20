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
/* loaded from: classes2.dex */
public class PopupWindow {
    private static final int[] bqA = {16842922};
    private boolean blR;
    private WeakReference<View> bqB;
    private ViewTreeObserver.OnScrollChangedListener bqC;
    private int bqD;
    private int bqE;
    private boolean bqa;
    private View bqb;
    private int bqc;
    private int bqd;
    private boolean bqe;
    private boolean bqf;
    private int bqg;
    private boolean bqh;
    private boolean bqi;
    private boolean bqj;
    private boolean bqk;
    private boolean bql;
    private View.OnTouchListener bqm;
    private int bqn;
    private int bqo;
    private int bqp;
    private int bqq;
    private int[] bqr;
    private int[] bqs;
    private Drawable bqt;
    private Drawable bqu;
    private boolean bqv;
    private int bqw;
    private a bqx;
    private boolean bqy;
    private int bqz;
    private Drawable mBackground;
    private View mContentView;
    private Context mContext;
    private boolean mFocusable;
    private int mHeight;
    private int mHeightMode;
    private Rect mTempRect;
    private int mWidth;
    private int mWidthMode;
    private WindowManager mWindowManager;
    private boolean zi;

    /* loaded from: classes2.dex */
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
        this.bqc = 0;
        this.bqd = 1;
        this.bqe = true;
        this.zi = false;
        this.bqf = true;
        this.bqg = -1;
        this.bqj = true;
        this.bqk = false;
        this.bqr = new int[2];
        this.bqs = new int[2];
        this.mTempRect = new Rect();
        this.bqw = 1000;
        this.bqy = false;
        this.bqz = -1;
        this.bqC = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view;
                if (PopupWindow.this.bqB != null) {
                    view = (View) PopupWindow.this.bqB.get();
                } else {
                    view = null;
                }
                if (view != null && PopupWindow.this.bqb != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.bqb.getLayoutParams();
                    PopupWindow.this.dc(PopupWindow.this.a(view, layoutParams, PopupWindow.this.bqD, PopupWindow.this.bqE));
                    PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.h.PopupWindow, i, i2);
        this.mBackground = obtainStyledAttributes.getDrawable(f.h.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(f.h.PopupWindow_popupAnimationStyle, -1);
        this.bqz = resourceId == 16973824 ? -1 : resourceId;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
        this.bqc = 0;
        this.bqd = 1;
        this.bqe = true;
        this.zi = false;
        this.bqf = true;
        this.bqg = -1;
        this.bqj = true;
        this.bqk = false;
        this.bqr = new int[2];
        this.bqs = new int[2];
        this.mTempRect = new Rect();
        this.bqw = 1000;
        this.bqy = false;
        this.bqz = -1;
        this.bqC = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2;
                if (PopupWindow.this.bqB != null) {
                    view2 = (View) PopupWindow.this.bqB.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && PopupWindow.this.bqb != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.bqb.getLayoutParams();
                    PopupWindow.this.dc(PopupWindow.this.a(view2, layoutParams, PopupWindow.this.bqD, PopupWindow.this.bqE));
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
        this.bqz = i;
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
        this.bqd = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.zi = z;
    }

    public void setClippingEnabled(boolean z) {
        this.bqf = z;
    }

    public boolean isSplitTouchEnabled() {
        return (this.bqg >= 0 || this.mContext == null) ? this.bqg == 1 : this.mContext.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean isShowing() {
        return this.blR;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.mContentView != null) {
            UO();
            this.blR = true;
            this.bqa = false;
            WindowManager.LayoutParams d = d(iBinder);
            d.windowAnimations = UN();
            a(d);
            if (i == 0) {
                i = 51;
            }
            d.gravity = i;
            d.x = i2;
            d.y = i3;
            if (this.mHeightMode < 0) {
                int i4 = this.mHeightMode;
                this.bqo = i4;
                d.height = i4;
            }
            if (this.mWidthMode < 0) {
                int i5 = this.mWidthMode;
                this.bqn = i5;
                d.width = i5;
            }
            b(d);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        c(view, i, i2);
    }

    public void c(View view, int i, int i2) {
        if (!isShowing() && this.mContentView != null) {
            d(view, i, i2);
            this.blR = true;
            this.bqa = true;
            WindowManager.LayoutParams d = d(view.getWindowToken());
            a(d);
            dc(a(view, d, i, i2));
            if (this.mHeightMode < 0) {
                int i3 = this.mHeightMode;
                this.bqo = i3;
                d.height = i3;
            }
            if (this.mWidthMode < 0) {
                int i4 = this.mWidthMode;
                this.bqn = i4;
                d.width = i4;
            }
            d.windowAnimations = UN();
            b(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(boolean z) {
        if (z != this.bqv) {
            this.bqv = z;
            if (this.mBackground != null) {
                if (this.bqt != null) {
                    if (this.bqv) {
                        this.bqb.setBackgroundDrawable(this.bqt);
                        return;
                    } else {
                        this.bqb.setBackgroundDrawable(this.bqu);
                        return;
                    }
                }
                this.bqb.refreshDrawableState();
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
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
            this.bqb = bVar;
        } else {
            this.bqb = this.mContentView;
        }
        this.bqp = layoutParams.width;
        this.bqq = layoutParams.height;
    }

    private void b(WindowManager.LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        this.mWindowManager.addView(this.bqb, layoutParams);
    }

    private WindowManager.LayoutParams d(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.mWidth;
        this.bqn = i;
        layoutParams.width = i;
        int i2 = this.mHeight;
        this.bqo = i2;
        layoutParams.height = i2;
        if (this.mBackground != null) {
            layoutParams.format = this.mBackground.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = fs(layoutParams.flags);
        layoutParams.type = this.bqw;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bqd;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private int fs(int i) {
        int i2 = (-8815129) & i;
        if (this.bqy) {
            i2 |= 32768;
        }
        if (!this.mFocusable) {
            i2 |= 8;
            if (this.bqc == 1) {
                i2 |= 131072;
            }
        } else if (this.bqc == 2) {
            i2 |= 131072;
        }
        if (!this.bqe) {
            i2 |= 16;
        }
        if (this.zi) {
            i2 |= 262144;
        }
        if (!this.bqf) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.bqh) {
            i2 |= 256;
        }
        if (this.bqk) {
            i2 |= 65536;
        }
        if (this.bql) {
            return i2 | 32;
        }
        return i2;
    }

    private int UN() {
        if (this.bqz == -1) {
            if (this.bqa) {
                return this.bqv ? f.g.PopupWindow_DropDownUp : f.g.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return this.bqz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bqr);
        layoutParams.x = this.bqr[0] + i;
        layoutParams.y = this.bqr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bqs);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bqs[1] + i2 + this.bqq > rect.bottom || (layoutParams.x + this.bqp) - rootView.getWidth() > 0) {
            if (this.bqj) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.bqp + scrollX + i, this.bqq + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bqr);
            layoutParams.x = this.bqr[0] + i;
            layoutParams.y = this.bqr[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bqs);
            r0 = ((rect.bottom - this.bqs[1]) - view.getHeight()) - i2 < (this.bqs[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bqr[1]) + i2;
            } else {
                layoutParams.y = this.bqr[1] + view.getHeight() + i2;
            }
        }
        if (this.bqi) {
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
                int i5 = (this.bqs[1] + i2) - this.bqq;
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
        if (isShowing() && this.bqb != null) {
            this.blR = false;
            UO();
            try {
                this.mWindowManager.removeView(this.bqb);
                if (this.bqb != this.mContentView && (this.bqb instanceof ViewGroup)) {
                    ((ViewGroup) this.bqb).removeView(this.mContentView);
                }
                this.bqb = null;
                if (this.bqx != null) {
                    this.bqx.onDismiss();
                }
            } catch (IllegalArgumentException e) {
                if (this.bqb != this.mContentView && (this.bqb instanceof ViewGroup)) {
                    ((ViewGroup) this.bqb).removeView(this.mContentView);
                }
                this.bqb = null;
                if (this.bqx != null) {
                    this.bqx.onDismiss();
                }
            } catch (Throwable th) {
                if (this.bqb != this.mContentView && (this.bqb instanceof ViewGroup)) {
                    ((ViewGroup) this.bqb).removeView(this.mContentView);
                }
                this.bqb = null;
                if (this.bqx != null) {
                    this.bqx.onDismiss();
                }
                throw th;
            }
        }
    }

    public void a(a aVar) {
        this.bqx = aVar;
    }

    public void update() {
        boolean z = true;
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bqb.getLayoutParams();
            boolean z2 = false;
            int UN = UN();
            if (UN != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = UN;
                z2 = true;
            }
            int fs = fs(layoutParams.flags);
            if (fs != layoutParams.flags) {
                layoutParams.flags = fs;
            } else {
                z = z2;
            }
            if (z) {
                this.mWindowManager.updateViewLayout(this.bqb, layoutParams);
            }
        }
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bqn = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bqo = i4;
            setHeight(i4);
        }
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bqb.getLayoutParams();
            int i5 = this.mWidthMode < 0 ? this.mWidthMode : this.bqn;
            if (i3 != -1 && layoutParams.width != i5) {
                this.bqn = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.mHeightMode < 0 ? this.mHeightMode : this.bqo;
            if (i4 != -1 && layoutParams.height != i6) {
                this.bqo = i6;
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
            int UN = UN();
            if (UN != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = UN;
                z = true;
            }
            int fs = fs(layoutParams.flags);
            if (fs != layoutParams.flags) {
                layoutParams.flags = fs;
            } else {
                z2 = z;
            }
            if (z2) {
                this.mWindowManager.updateViewLayout(this.bqb, layoutParams);
            }
        }
    }

    private void UO() {
        WeakReference<View> weakReference = this.bqB;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.bqC);
        }
        this.bqB = null;
    }

    private void d(View view, int i, int i2) {
        UO();
        this.bqB = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.bqC);
        }
        this.bqD = i;
        this.bqE = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.bqv) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.bqA);
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
            if (PopupWindow.this.bqm == null || !PopupWindow.this.bqm.onTouch(this, motionEvent)) {
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
