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
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.poly.util.c.bos;
    private static final int[] bqZ = {16842922};
    private Drawable brA;
    private Drawable brB;
    private Drawable brC;
    private boolean brD;
    private b brF;
    private WeakReference<View> brI;
    private int brK;
    private int brL;
    private WindowManager bra;
    private boolean brb;
    private boolean brc;
    private View brd;
    private View bre;
    private boolean brf;
    private boolean brl;
    private boolean brm;
    private boolean bro;
    private View.OnTouchListener brp;
    private int brq;
    private int brr;
    private int brs;
    private int brt;
    private int bru;
    private int brv;
    private int brw;
    private Context mContext;
    private int qe;
    private int brg = 0;
    private int brh = 1;
    private boolean fe = true;
    private boolean bri = false;
    private boolean brj = true;
    private int brk = -1;
    private boolean brn = true;
    private boolean me = false;
    private int[] brx = new int[2];
    private int[] bry = new int[2];
    private Rect brz = new Rect();
    private int brE = 1000;
    private boolean brG = false;
    private int brH = -1;
    private ViewTreeObserver.OnScrollChangedListener brJ = new a();

    /* loaded from: classes11.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.brI != null ? (View) c.this.brI.get() : null;
            if (view == null || c.this.bre == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.bre.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.brK, c.this.brL));
            c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.poly.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0191c extends FrameLayout {
        public C0191c(Context context) {
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
            if (c.this.brp == null || !c.this.brp.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.brD) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.bqZ);
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
            if (c.this.brd != null) {
                c.this.brd.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.bra = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int Ld() {
        int i = this.brH;
        if (i == -1) {
            if (this.brc) {
                return this.brD ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void ca() {
        WeakReference<View> weakReference = this.brI;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.brJ);
        }
        this.brI = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.brg == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.brg == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dI(int i) {
        int i2 = (-8815129) & i;
        if (this.brG) {
            i2 |= 32768;
        }
        if (!this.brf) {
            i2 |= 8;
        }
        if (!this.fe) {
            i2 |= 16;
        }
        if (this.bri) {
            i2 |= 262144;
        }
        if (!this.brj) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.brl) {
            i2 |= 256;
        }
        if (this.me) {
            i2 |= 65536;
        }
        return this.bro ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.bre != null) {
            this.brb = false;
            ca();
            try {
                try {
                    this.bra.removeView(this.bre);
                    View view = this.bre;
                    View view2 = this.brd;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.bre = null;
                    bVar = this.brF;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.bre;
                        View view4 = this.brd;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.bre = null;
                        bVar = this.brF;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.bre;
                View view6 = this.brd;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.bre = null;
                b bVar2 = this.brF;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.brb;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.brk >= 0 || (context = this.mContext) == null) ? this.brk == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.brA = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.brj = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.brd = view;
            if (this.mContext == null && (view2 = this.brd) != null) {
                this.mContext = view2.getContext();
            }
            if (this.bra != null || this.brd == null || (context = this.mContext) == null) {
                return;
            }
            this.bra = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.brf = z;
    }

    public void setHeight(int i) {
        this.brt = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.bri = z;
    }

    public void setWidth(int i) {
        this.qe = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.brr = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bru = i4;
            setHeight(i4);
        }
        if (isShowing() && this.brd != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bre.getLayoutParams();
            int i5 = this.brq;
            if (i5 >= 0) {
                i5 = this.brr;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.brr = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.brs;
            if (i6 >= 0) {
                i6 = this.bru;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.bru = i6;
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
            int Ld = Ld();
            if (Ld != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = Ld;
                z = true;
            }
            int dI = dI(layoutParams.flags);
            if (dI != layoutParams.flags) {
                layoutParams.flags = dI;
            } else {
                z2 = z;
            }
            if (z2) {
                this.bra.updateViewLayout(this.bre, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.brd;
        if (view != null && this.mContext != null && this.bra != null) {
            if (this.brA != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0191c c0191c = new C0191c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0191c.setBackgroundDrawable(this.brA);
                c0191c.addView(this.brd, layoutParams3);
                this.bre = c0191c;
            } else {
                this.bre = view;
            }
            this.brv = layoutParams.width;
            this.brw = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.brD) {
            this.brD = z;
            if (this.brA != null) {
                Drawable drawable = this.brB;
                if (drawable != null) {
                    if (this.brD) {
                        this.bre.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.bre.setBackgroundDrawable(this.brC);
                        return;
                    }
                }
                this.bre.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.brd != null) {
            ca();
            this.brb = true;
            this.brc = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = Ld();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.brs;
            if (i4 < 0) {
                this.bru = i4;
                c.height = i4;
            }
            int i5 = this.brq;
            if (i5 < 0) {
                this.brr = i5;
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
        this.bra.addView(this.bre, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.qe;
        this.brr = i;
        layoutParams.width = i;
        int i2 = this.brt;
        this.bru = i2;
        layoutParams.height = i2;
        Drawable drawable = this.brA;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = dI(layoutParams.flags);
        layoutParams.type = this.brE;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.brh;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.brx);
        int[] iArr = this.brx;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bry);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bry[1] + i2 + this.brw > rect.bottom || (layoutParams.x + this.brv) - rootView.getWidth() > 0) {
            if (this.brn) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.brv + scrollX + i, this.brw + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.brx);
            int[] iArr2 = this.brx;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bry);
            r0 = ((rect.bottom - this.bry[1]) - view.getHeight()) - i2 < (this.bry[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.brx[1]) + i2;
            } else {
                layoutParams.y = this.brx[1] + view.getHeight() + i2;
            }
        }
        if (this.brm) {
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
                int i7 = (this.bry[1] + i2) - this.brw;
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
        this.brF = bVar;
    }
}
