package com.baidu.poly.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.poly.b;
import com.baidu.poly.util.d;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = d.bBe;
    private static final int[] bDO = {16842922};
    private WindowManager bDP;
    private boolean bDQ;
    private boolean bDR;
    private View bDS;
    private View bDT;
    private boolean bDU;
    private WeakReference<View> bEA;
    private int bEC;
    private int bED;
    private boolean bEb;
    private boolean bEc;
    private boolean bEf;
    private View.OnTouchListener bEg;
    private int bEh;
    private int bEi;
    private int bEj;
    private int bEk;
    private int bEl;
    private int bEm;
    private int bEn;
    private int bEo;
    private Drawable bEs;
    private Drawable bEt;
    private Drawable bEu;
    private boolean bEv;
    private b bEx;
    private Context mContext;
    private int bDV = 0;
    private int bDW = 1;
    private boolean bDX = true;
    private boolean bDY = false;
    private boolean bDZ = true;
    private int bEa = -1;
    private boolean bEd = true;
    private boolean bEe = false;
    private int[] bEp = new int[2];
    private int[] bEq = new int[2];
    private Rect bEr = new Rect();
    private int bEw = 1000;
    private boolean bEy = false;
    private int bEz = -1;
    private ViewTreeObserver.OnScrollChangedListener bEB = new a();

    /* loaded from: classes9.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.bEA != null ? (View) c.this.bEA.get() : null;
            if (view == null || c.this.bDT == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.bDT.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.bEC, c.this.bED));
            c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.poly.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0255c extends FrameLayout {
        public C0255c(Context context) {
            super(context);
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
                    c.this.dismiss();
                    return true;
                } else {
                    return super.dispatchKeyEvent(keyEvent);
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (c.this.bEg == null || !c.this.bEg.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.bEv) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.bDO);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= super.getWidth() || y < 0 || y >= super.getHeight())) {
                c.this.dismiss();
                return true;
            } else if (motionEvent.getAction() == 4) {
                c.this.dismiss();
                return true;
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i) {
            if (c.this.bDS != null) {
                c.this.bDS.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.bDP = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int OJ() {
        int i = this.bEz;
        if (i == -1) {
            if (this.bDR) {
                return this.bEv ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void OK() {
        WeakReference<View> weakReference = this.bEA;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.bEB);
        }
        this.bEA = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.bDV == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.bDV == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int eb(int i) {
        int i2 = (-8815129) & i;
        if (this.bEy) {
            i2 |= 32768;
        }
        if (!this.bDU) {
            i2 |= 8;
        }
        if (!this.bDX) {
            i2 |= 16;
        }
        if (this.bDY) {
            i2 |= 262144;
        }
        if (!this.bDZ) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.bEb) {
            i2 |= 256;
        }
        if (this.bEe) {
            i2 |= 65536;
        }
        return this.bEf ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.bDT != null) {
            this.bDQ = false;
            OK();
            try {
                try {
                    this.bDP.removeView(this.bDT);
                    View view = this.bDT;
                    View view2 = this.bDS;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.bDT = null;
                    bVar = this.bEx;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.bDT;
                        View view4 = this.bDS;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.bDT = null;
                        bVar = this.bEx;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.bDT;
                View view6 = this.bDS;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.bDT = null;
                b bVar2 = this.bEx;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.bDQ;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.bEa >= 0 || (context = this.mContext) == null) ? this.bEa == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.bEs = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.bDZ = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.bDS = view;
            if (this.mContext == null && (view2 = this.bDS) != null) {
                this.mContext = view2.getContext();
            }
            if (this.bDP != null || this.bDS == null || (context = this.mContext) == null) {
                return;
            }
            this.bDP = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.bDU = z;
    }

    public void setHeight(int i) {
        this.bEl = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.bDY = z;
    }

    public void setWidth(int i) {
        this.bEi = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bEj = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bEm = i4;
            setHeight(i4);
        }
        if (isShowing() && this.bDS != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bDT.getLayoutParams();
            int i5 = this.bEh;
            if (i5 >= 0) {
                i5 = this.bEj;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.bEj = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.bEk;
            if (i6 >= 0) {
                i6 = this.bEm;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.bEm = i6;
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
            int OJ = OJ();
            if (OJ != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = OJ;
                z = true;
            }
            int eb = eb(layoutParams.flags);
            if (eb != layoutParams.flags) {
                layoutParams.flags = eb;
            } else {
                z2 = z;
            }
            if (z2) {
                this.bDP.updateViewLayout(this.bDT, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.bDS;
        if (view != null && this.mContext != null && this.bDP != null) {
            if (this.bEs != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0255c c0255c = new C0255c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0255c.setBackgroundDrawable(this.bEs);
                c0255c.addView(this.bDS, layoutParams3);
                this.bDT = c0255c;
            } else {
                this.bDT = view;
            }
            this.bEn = layoutParams.width;
            this.bEo = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.bEv) {
            this.bEv = z;
            if (this.bEs != null) {
                Drawable drawable = this.bEt;
                if (drawable != null) {
                    if (this.bEv) {
                        this.bDT.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.bDT.setBackgroundDrawable(this.bEu);
                        return;
                    }
                }
                this.bDT.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.bDS != null) {
            OK();
            this.bDQ = true;
            this.bDR = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = OJ();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.bEk;
            if (i4 < 0) {
                this.bEm = i4;
                c.height = i4;
            }
            int i5 = this.bEh;
            if (i5 < 0) {
                this.bEj = i5;
                c.width = i5;
            }
            b(c);
        }
    }

    private void b(WindowManager.LayoutParams layoutParams) {
        Context context = this.mContext;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.bDP.addView(this.bDT, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.bEi;
        this.bEj = i;
        layoutParams.width = i;
        int i2 = this.bEl;
        this.bEm = i2;
        layoutParams.height = i2;
        Drawable drawable = this.bEs;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = eb(layoutParams.flags);
        layoutParams.type = this.bEw;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bDW;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bEp);
        int[] iArr = this.bEp;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bEq);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bEq[1] + i2 + this.bEo > rect.bottom || (layoutParams.x + this.bEn) - rootView.getWidth() > 0) {
            if (this.bEd) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.bEn + scrollX + i, this.bEo + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bEp);
            int[] iArr2 = this.bEp;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bEq);
            r0 = ((rect.bottom - this.bEq[1]) - view.getHeight()) - i2 < (this.bEq[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bEp[1]) + i2;
            } else {
                layoutParams.y = this.bEp[1] + view.getHeight() + i2;
            }
        }
        if (this.bEc) {
            int i3 = rect.right - rect.left;
            int i4 = layoutParams.x + layoutParams.width;
            if (i4 > i3) {
                layoutParams.x -= i4 - i3;
            }
            int i5 = layoutParams.x;
            int i6 = rect.left;
            if (i5 < i6) {
                layoutParams.x = i6;
                layoutParams.width = Math.min(layoutParams.width, i3);
            }
            if (r0) {
                int i7 = (this.bEq[1] + i2) - this.bEo;
                if (i7 < 0) {
                    layoutParams.y = i7 + layoutParams.y;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= 268435456;
        return r0;
    }

    public void a(b bVar) {
        this.bEx = bVar;
    }
}
