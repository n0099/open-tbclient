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
/* loaded from: classes4.dex */
public class c {
    private static final boolean DEBUG = d.cpa;
    private static final int[] crL = {16842922};
    private WindowManager crM;
    private boolean crN;
    private boolean crO;
    private View crP;
    private View crQ;
    private boolean crR;
    private boolean crY;
    private boolean crZ;
    private int csA;
    private boolean csc;
    private View.OnTouchListener csd;
    private int cse;
    private int csf;
    private int csg;
    private int csh;
    private int csi;
    private int csj;
    private int csk;
    private int csl;
    private Drawable csp;
    private Drawable csq;
    private Drawable csr;
    private boolean css;
    private b csu;
    private WeakReference<View> csx;
    private int csz;
    private Context mContext;
    private int crS = 0;
    private int crT = 1;
    private boolean crU = true;
    private boolean crV = false;
    private boolean crW = true;
    private int crX = -1;
    private boolean csa = true;
    private boolean csb = false;
    private int[] csm = new int[2];
    private int[] csn = new int[2];
    private Rect cso = new Rect();
    private int cst = 1000;
    private boolean csv = false;
    private int csw = -1;
    private ViewTreeObserver.OnScrollChangedListener csy = new a();

    /* loaded from: classes4.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.csx != null ? (View) c.this.csx.get() : null;
            if (view == null || c.this.crQ == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.crQ.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.csz, c.this.csA));
            c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.poly.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0311c extends FrameLayout {
        public C0311c(Context context) {
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
            if (c.this.csd == null || !c.this.csd.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.css) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.crL);
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
            if (c.this.crP != null) {
                c.this.crP.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.crM = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int adT() {
        int i = this.csw;
        if (i == -1) {
            if (this.crO) {
                return this.css ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void adU() {
        WeakReference<View> weakReference = this.csx;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.csy);
        }
        this.csx = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.crS == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.crS == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int fN(int i) {
        int i2 = (-8815129) & i;
        if (this.csv) {
            i2 |= 32768;
        }
        if (!this.crR) {
            i2 |= 8;
        }
        if (!this.crU) {
            i2 |= 16;
        }
        if (this.crV) {
            i2 |= 262144;
        }
        if (!this.crW) {
            i2 |= 512;
        }
        if (adW()) {
            i2 |= 8388608;
        }
        if (this.crY) {
            i2 |= 256;
        }
        if (this.csb) {
            i2 |= 65536;
        }
        return this.csc ? i2 | 32 : i2;
    }

    public boolean adW() {
        Context context;
        return (this.crX >= 0 || (context = this.mContext) == null) ? this.crX == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.crQ != null) {
            this.crN = false;
            adU();
            try {
                try {
                    this.crM.removeView(this.crQ);
                    View view = this.crQ;
                    View view2 = this.crP;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.crQ = null;
                    bVar = this.csu;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.crQ;
                        View view4 = this.crP;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.crQ = null;
                        bVar = this.csu;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.crQ;
                View view6 = this.crP;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.crQ = null;
                b bVar2 = this.csu;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public void en(boolean z) {
        this.crV = z;
    }

    public void eo(boolean z) {
        this.crW = z;
    }

    public boolean isShowing() {
        return this.crN;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.csp = drawable;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.crP = view;
            if (this.mContext == null && (view2 = this.crP) != null) {
                this.mContext = view2.getContext();
            }
            if (this.crM != null || this.crP == null || (context = this.mContext) == null) {
                return;
            }
            this.crM = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.crR = z;
    }

    public void setHeight(int i) {
        this.csi = i;
    }

    public void setWidth(int i) {
        this.csf = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.csg = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.csj = i4;
            setHeight(i4);
        }
        if (isShowing() && this.crP != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.crQ.getLayoutParams();
            int i5 = this.cse;
            if (i5 >= 0) {
                i5 = this.csg;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.csg = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.csh;
            if (i6 >= 0) {
                i6 = this.csj;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.csj = i6;
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
            int adT = adT();
            if (adT != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = adT;
                z = true;
            }
            int fN = fN(layoutParams.flags);
            if (fN != layoutParams.flags) {
                layoutParams.flags = fN;
            } else {
                z2 = z;
            }
            if (z2) {
                this.crM.updateViewLayout(this.crQ, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.crP;
        if (view != null && this.mContext != null && this.crM != null) {
            if (this.csp != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0311c c0311c = new C0311c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0311c.setBackgroundDrawable(this.csp);
                c0311c.addView(this.crP, layoutParams3);
                this.crQ = c0311c;
            } else {
                this.crQ = view;
            }
            this.csk = layoutParams.width;
            this.csl = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.css) {
            this.css = z;
            if (this.csp != null) {
                Drawable drawable = this.csq;
                if (drawable != null) {
                    if (this.css) {
                        this.crQ.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.crQ.setBackgroundDrawable(this.csr);
                        return;
                    }
                }
                this.crQ.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.crP != null) {
            adU();
            this.crN = true;
            this.crO = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = adT();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.csh;
            if (i4 < 0) {
                this.csj = i4;
                c.height = i4;
            }
            int i5 = this.cse;
            if (i5 < 0) {
                this.csg = i5;
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
        this.crM.addView(this.crQ, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.csf;
        this.csg = i;
        layoutParams.width = i;
        int i2 = this.csi;
        this.csj = i2;
        layoutParams.height = i2;
        Drawable drawable = this.csp;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = fN(layoutParams.flags);
        layoutParams.type = this.cst;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.crT;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.csm);
        int[] iArr = this.csm;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.csn);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.csn[1] + i2 + this.csl > rect.bottom || (layoutParams.x + this.csk) - rootView.getWidth() > 0) {
            if (this.csa) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.csk + scrollX + i, this.csl + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.csm);
            int[] iArr2 = this.csm;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.csn);
            r0 = ((rect.bottom - this.csn[1]) - view.getHeight()) - i2 < (this.csn[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.csm[1]) + i2;
            } else {
                layoutParams.y = this.csm[1] + view.getHeight() + i2;
            }
        }
        if (this.crZ) {
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
                int i7 = (this.csn[1] + i2) - this.csl;
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
        this.csu = bVar;
    }
}
