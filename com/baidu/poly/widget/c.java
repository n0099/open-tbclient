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
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = d.cpz;
    private static final int[] csi = {16842922};
    private View.OnTouchListener csA;
    private int csB;
    private int csC;
    private int csD;
    private int csE;
    private int csF;
    private int csG;
    private int csH;
    private int csI;
    private Drawable csM;
    private Drawable csN;
    private Drawable csO;
    private boolean csP;
    private b csR;
    private WeakReference<View> csU;
    private int csW;
    private int csX;
    private WindowManager csj;
    private boolean csk;
    private boolean csl;
    private View csm;
    private View csn;
    private boolean cso;
    private boolean csv;
    private boolean csw;
    private boolean csz;
    private Context mContext;
    private int csp = 0;
    private int csq = 1;
    private boolean csr = true;
    private boolean css = false;
    private boolean cst = true;
    private int csu = -1;
    private boolean csx = true;
    private boolean csy = false;
    private int[] csJ = new int[2];
    private int[] csK = new int[2];
    private Rect csL = new Rect();
    private int csQ = 1000;
    private boolean csS = false;
    private int csT = -1;
    private ViewTreeObserver.OnScrollChangedListener csV = new a();

    /* loaded from: classes3.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.csU != null ? (View) c.this.csU.get() : null;
            if (view == null || c.this.csn == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.csn.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.csW, c.this.csX));
            c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.poly.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0324c extends FrameLayout {
        public C0324c(Context context) {
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
            if (c.this.csA == null || !c.this.csA.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.csP) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.csi);
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
            if (c.this.csm != null) {
                c.this.csm.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.csj = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int afY() {
        int i = this.csT;
        if (i == -1) {
            if (this.csl) {
                return this.csP ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void afZ() {
        WeakReference<View> weakReference = this.csU;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.csV);
        }
        this.csU = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.csp == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.csp == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int ho(int i) {
        int i2 = (-8815129) & i;
        if (this.csS) {
            i2 |= 32768;
        }
        if (!this.cso) {
            i2 |= 8;
        }
        if (!this.csr) {
            i2 |= 16;
        }
        if (this.css) {
            i2 |= 262144;
        }
        if (!this.cst) {
            i2 |= 512;
        }
        if (agb()) {
            i2 |= 8388608;
        }
        if (this.csv) {
            i2 |= 256;
        }
        if (this.csy) {
            i2 |= 65536;
        }
        return this.csz ? i2 | 32 : i2;
    }

    public boolean agb() {
        Context context;
        return (this.csu >= 0 || (context = this.mContext) == null) ? this.csu == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.csn != null) {
            this.csk = false;
            afZ();
            try {
                try {
                    this.csj.removeView(this.csn);
                    View view = this.csn;
                    View view2 = this.csm;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.csn = null;
                    bVar = this.csR;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.csn;
                        View view4 = this.csm;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.csn = null;
                        bVar = this.csR;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.csn;
                View view6 = this.csm;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.csn = null;
                b bVar2 = this.csR;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public void eh(boolean z) {
        this.css = z;
    }

    public void ei(boolean z) {
        this.cst = z;
    }

    public boolean isShowing() {
        return this.csk;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.csM = drawable;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.csm = view;
            if (this.mContext == null && (view2 = this.csm) != null) {
                this.mContext = view2.getContext();
            }
            if (this.csj != null || this.csm == null || (context = this.mContext) == null) {
                return;
            }
            this.csj = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.cso = z;
    }

    public void setHeight(int i) {
        this.csF = i;
    }

    public void setWidth(int i) {
        this.csC = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.csD = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.csG = i4;
            setHeight(i4);
        }
        if (isShowing() && this.csm != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.csn.getLayoutParams();
            int i5 = this.csB;
            if (i5 >= 0) {
                i5 = this.csD;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.csD = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.csE;
            if (i6 >= 0) {
                i6 = this.csG;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.csG = i6;
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
            int afY = afY();
            if (afY != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = afY;
                z = true;
            }
            int ho = ho(layoutParams.flags);
            if (ho != layoutParams.flags) {
                layoutParams.flags = ho;
            } else {
                z2 = z;
            }
            if (z2) {
                this.csj.updateViewLayout(this.csn, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.csm;
        if (view != null && this.mContext != null && this.csj != null) {
            if (this.csM != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0324c c0324c = new C0324c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0324c.setBackgroundDrawable(this.csM);
                c0324c.addView(this.csm, layoutParams3);
                this.csn = c0324c;
            } else {
                this.csn = view;
            }
            this.csH = layoutParams.width;
            this.csI = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.csP) {
            this.csP = z;
            if (this.csM != null) {
                Drawable drawable = this.csN;
                if (drawable != null) {
                    if (this.csP) {
                        this.csn.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.csn.setBackgroundDrawable(this.csO);
                        return;
                    }
                }
                this.csn.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.csm != null) {
            afZ();
            this.csk = true;
            this.csl = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = afY();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.csE;
            if (i4 < 0) {
                this.csG = i4;
                c.height = i4;
            }
            int i5 = this.csB;
            if (i5 < 0) {
                this.csD = i5;
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
        this.csj.addView(this.csn, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.csC;
        this.csD = i;
        layoutParams.width = i;
        int i2 = this.csF;
        this.csG = i2;
        layoutParams.height = i2;
        Drawable drawable = this.csM;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = ho(layoutParams.flags);
        layoutParams.type = this.csQ;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.csq;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.csJ);
        int[] iArr = this.csJ;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.csK);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.csK[1] + i2 + this.csI > rect.bottom || (layoutParams.x + this.csH) - rootView.getWidth() > 0) {
            if (this.csx) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.csH + scrollX + i, this.csI + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.csJ);
            int[] iArr2 = this.csJ;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.csK);
            r0 = ((rect.bottom - this.csK[1]) - view.getHeight()) - i2 < (this.csK[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.csJ[1]) + i2;
            } else {
                layoutParams.y = this.csJ[1] + view.getHeight() + i2;
            }
        }
        if (this.csw) {
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
                int i7 = (this.csK[1] + i2) - this.csI;
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
        this.csR = bVar;
    }
}
