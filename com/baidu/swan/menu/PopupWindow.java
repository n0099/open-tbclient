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
    private static final int[] brn = {16842922};
    private boolean bmF;
    private boolean bqN;
    private View bqO;
    private int bqP;
    private int bqQ;
    private boolean bqR;
    private boolean bqS;
    private int bqT;
    private boolean bqU;
    private boolean bqV;
    private boolean bqW;
    private boolean bqX;
    private boolean bqY;
    private View.OnTouchListener bqZ;
    private int bra;
    private int brb;
    private int brc;
    private int brd;
    private int[] bre;
    private int[] brf;
    private Drawable brg;
    private Drawable brh;
    private boolean bri;
    private int brj;
    private a brk;
    private boolean brl;
    private int brm;
    private WeakReference<View> bro;
    private ViewTreeObserver.OnScrollChangedListener brp;
    private int brq;
    private int brr;
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
    private boolean zo;

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
        this.bqP = 0;
        this.bqQ = 1;
        this.bqR = true;
        this.zo = false;
        this.bqS = true;
        this.bqT = -1;
        this.bqW = true;
        this.bqX = false;
        this.bre = new int[2];
        this.brf = new int[2];
        this.mTempRect = new Rect();
        this.brj = 1000;
        this.brl = false;
        this.brm = -1;
        this.brp = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view;
                if (PopupWindow.this.bro != null) {
                    view = (View) PopupWindow.this.bro.get();
                } else {
                    view = null;
                }
                if (view != null && PopupWindow.this.bqO != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.bqO.getLayoutParams();
                    PopupWindow.this.dh(PopupWindow.this.a(view, layoutParams, PopupWindow.this.brq, PopupWindow.this.brr));
                    PopupWindow.this.a(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.h.PopupWindow, i, i2);
        this.mBackground = obtainStyledAttributes.getDrawable(f.h.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(f.h.PopupWindow_popupAnimationStyle, -1);
        this.brm = resourceId == 16973824 ? -1 : resourceId;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
        this.bqP = 0;
        this.bqQ = 1;
        this.bqR = true;
        this.zo = false;
        this.bqS = true;
        this.bqT = -1;
        this.bqW = true;
        this.bqX = false;
        this.bre = new int[2];
        this.brf = new int[2];
        this.mTempRect = new Rect();
        this.brj = 1000;
        this.brl = false;
        this.brm = -1;
        this.brp = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2;
                if (PopupWindow.this.bro != null) {
                    view2 = (View) PopupWindow.this.bro.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && PopupWindow.this.bqO != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.bqO.getLayoutParams();
                    PopupWindow.this.dh(PopupWindow.this.a(view2, layoutParams, PopupWindow.this.brq, PopupWindow.this.brr));
                    PopupWindow.this.a(layoutParams.x, layoutParams.y, -1, -1, true);
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
        this.brm = i;
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
        this.bqQ = i;
    }

    public void df(boolean z) {
        this.zo = z;
    }

    public void dg(boolean z) {
        this.bqS = z;
    }

    public boolean VF() {
        return (this.bqT >= 0 || this.mContext == null) ? this.bqT == 1 : this.mContext.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean isShowing() {
        return this.bmF;
    }

    public void a(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.mContentView != null) {
            VH();
            this.bmF = true;
            this.bqN = false;
            WindowManager.LayoutParams d = d(iBinder);
            d.windowAnimations = VG();
            a(d);
            if (i == 0) {
                i = 51;
            }
            d.gravity = i;
            d.x = i2;
            d.y = i3;
            if (this.mHeightMode < 0) {
                int i4 = this.mHeightMode;
                this.brb = i4;
                d.height = i4;
            }
            if (this.mWidthMode < 0) {
                int i5 = this.mWidthMode;
                this.bra = i5;
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
            this.bmF = true;
            this.bqN = true;
            WindowManager.LayoutParams d = d(view.getWindowToken());
            a(d);
            dh(a(view, d, i, i2));
            if (this.mHeightMode < 0) {
                int i3 = this.mHeightMode;
                this.brb = i3;
                d.height = i3;
            }
            if (this.mWidthMode < 0) {
                int i4 = this.mWidthMode;
                this.bra = i4;
                d.width = i4;
            }
            d.windowAnimations = VG();
            b(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(boolean z) {
        if (z != this.bri) {
            this.bri = z;
            if (this.mBackground != null) {
                if (this.brg != null) {
                    if (this.bri) {
                        this.bqO.setBackgroundDrawable(this.brg);
                        return;
                    } else {
                        this.bqO.setBackgroundDrawable(this.brh);
                        return;
                    }
                }
                this.bqO.refreshDrawableState();
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
            this.bqO = bVar;
        } else {
            this.bqO = this.mContentView;
        }
        this.brc = layoutParams.width;
        this.brd = layoutParams.height;
    }

    private void b(WindowManager.LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        this.mWindowManager.addView(this.bqO, layoutParams);
    }

    private WindowManager.LayoutParams d(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.mWidth;
        this.bra = i;
        layoutParams.width = i;
        int i2 = this.mHeight;
        this.brb = i2;
        layoutParams.height = i2;
        if (this.mBackground != null) {
            layoutParams.format = this.mBackground.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = fw(layoutParams.flags);
        layoutParams.type = this.brj;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bqQ;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private int fw(int i) {
        int i2 = (-8815129) & i;
        if (this.brl) {
            i2 |= 32768;
        }
        if (!this.mFocusable) {
            i2 |= 8;
            if (this.bqP == 1) {
                i2 |= 131072;
            }
        } else if (this.bqP == 2) {
            i2 |= 131072;
        }
        if (!this.bqR) {
            i2 |= 16;
        }
        if (this.zo) {
            i2 |= 262144;
        }
        if (!this.bqS) {
            i2 |= 512;
        }
        if (VF()) {
            i2 |= 8388608;
        }
        if (this.bqU) {
            i2 |= 256;
        }
        if (this.bqX) {
            i2 |= 65536;
        }
        if (this.bqY) {
            return i2 | 32;
        }
        return i2;
    }

    private int VG() {
        if (this.brm == -1) {
            if (this.bqN) {
                return this.bri ? f.g.PopupWindow_DropDownUp : f.g.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return this.brm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bre);
        layoutParams.x = this.bre[0] + i;
        layoutParams.y = this.bre[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.brf);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.brf[1] + i2 + this.brd > rect.bottom || (layoutParams.x + this.brc) - rootView.getWidth() > 0) {
            if (this.bqW) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.brc + scrollX + i, this.brd + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bre);
            layoutParams.x = this.bre[0] + i;
            layoutParams.y = this.bre[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.brf);
            r0 = ((rect.bottom - this.brf[1]) - view.getHeight()) - i2 < (this.brf[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bre[1]) + i2;
            } else {
                layoutParams.y = this.bre[1] + view.getHeight() + i2;
            }
        }
        if (this.bqV) {
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
                int i5 = (this.brf[1] + i2) - this.brd;
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
        if (isShowing() && this.bqO != null) {
            this.bmF = false;
            VH();
            try {
                this.mWindowManager.removeView(this.bqO);
                if (this.bqO != this.mContentView && (this.bqO instanceof ViewGroup)) {
                    ((ViewGroup) this.bqO).removeView(this.mContentView);
                }
                this.bqO = null;
                if (this.brk != null) {
                    this.brk.onDismiss();
                }
            } catch (IllegalArgumentException e) {
                if (this.bqO != this.mContentView && (this.bqO instanceof ViewGroup)) {
                    ((ViewGroup) this.bqO).removeView(this.mContentView);
                }
                this.bqO = null;
                if (this.brk != null) {
                    this.brk.onDismiss();
                }
            } catch (Throwable th) {
                if (this.bqO != this.mContentView && (this.bqO instanceof ViewGroup)) {
                    ((ViewGroup) this.bqO).removeView(this.mContentView);
                }
                this.bqO = null;
                if (this.brk != null) {
                    this.brk.onDismiss();
                }
                throw th;
            }
        }
    }

    public void a(a aVar) {
        this.brk = aVar;
    }

    public void update() {
        boolean z = true;
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bqO.getLayoutParams();
            boolean z2 = false;
            int VG = VG();
            if (VG != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = VG;
                z2 = true;
            }
            int fw = fw(layoutParams.flags);
            if (fw != layoutParams.flags) {
                layoutParams.flags = fw;
            } else {
                z = z2;
            }
            if (z) {
                this.mWindowManager.updateViewLayout(this.bqO, layoutParams);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bra = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.brb = i4;
            setHeight(i4);
        }
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bqO.getLayoutParams();
            int i5 = this.mWidthMode < 0 ? this.mWidthMode : this.bra;
            if (i3 != -1 && layoutParams.width != i5) {
                this.bra = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.mHeightMode < 0 ? this.mHeightMode : this.brb;
            if (i4 != -1 && layoutParams.height != i6) {
                this.brb = i6;
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
            int VG = VG();
            if (VG != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = VG;
                z = true;
            }
            int fw = fw(layoutParams.flags);
            if (fw != layoutParams.flags) {
                layoutParams.flags = fw;
            } else {
                z2 = z;
            }
            if (z2) {
                this.mWindowManager.updateViewLayout(this.bqO, layoutParams);
            }
        }
    }

    private void VH() {
        WeakReference<View> weakReference = this.bro;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.brp);
        }
        this.bro = null;
    }

    private void d(View view, int i, int i2) {
        VH();
        this.bro = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.brp);
        }
        this.brq = i;
        this.brr = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.bri) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.brn);
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
            if (PopupWindow.this.bqZ == null || !PopupWindow.this.bqZ.onTouch(this, motionEvent)) {
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
