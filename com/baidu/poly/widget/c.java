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
/* loaded from: classes19.dex */
public class c {
    private static final boolean DEBUG = d.ciw;
    private static final int[] clf = {16842922};
    private int clA;
    private int clB;
    private int clC;
    private int clD;
    private int clE;
    private int clF;
    private Drawable clJ;
    private Drawable clK;
    private Drawable clL;
    private boolean clM;
    private b clO;
    private WeakReference<View> clR;
    private int clT;
    private int clU;
    private WindowManager clg;
    private boolean clh;
    private boolean cli;
    private View clj;
    private View clk;
    private boolean cll;
    private boolean cls;
    private boolean clt;
    private boolean clw;
    private View.OnTouchListener clx;
    private int cly;
    private int clz;
    private Context mContext;
    private int clm = 0;
    private int cln = 1;
    private boolean clo = true;
    private boolean clp = false;
    private boolean clq = true;
    private int clr = -1;
    private boolean clu = true;
    private boolean clv = false;
    private int[] clG = new int[2];
    private int[] clH = new int[2];
    private Rect clI = new Rect();
    private int clN = 1000;
    private boolean clP = false;
    private int clQ = -1;
    private ViewTreeObserver.OnScrollChangedListener clS = new a();

    /* loaded from: classes19.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.clR != null ? (View) c.this.clR.get() : null;
            if (view == null || c.this.clk == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.clk.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.clT, c.this.clU));
            c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes19.dex */
    public interface b {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.poly.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
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
            if (c.this.clx == null || !c.this.clx.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.clM) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.clf);
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
            if (c.this.clj != null) {
                c.this.clj.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.clg = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int aed() {
        int i = this.clQ;
        if (i == -1) {
            if (this.cli) {
                return this.clM ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void aee() {
        WeakReference<View> weakReference = this.clR;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.clS);
        }
        this.clR = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.clm == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.clm == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int hp(int i) {
        int i2 = (-8815129) & i;
        if (this.clP) {
            i2 |= 32768;
        }
        if (!this.cll) {
            i2 |= 8;
        }
        if (!this.clo) {
            i2 |= 16;
        }
        if (this.clp) {
            i2 |= 262144;
        }
        if (!this.clq) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.cls) {
            i2 |= 256;
        }
        if (this.clv) {
            i2 |= 65536;
        }
        return this.clw ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.clk != null) {
            this.clh = false;
            aee();
            try {
                try {
                    this.clg.removeView(this.clk);
                    View view = this.clk;
                    View view2 = this.clj;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.clk = null;
                    bVar = this.clO;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.clk;
                        View view4 = this.clj;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.clk = null;
                        bVar = this.clO;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.clk;
                View view6 = this.clj;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.clk = null;
                b bVar2 = this.clO;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.clh;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.clr >= 0 || (context = this.mContext) == null) ? this.clr == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.clJ = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.clq = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.clj = view;
            if (this.mContext == null && (view2 = this.clj) != null) {
                this.mContext = view2.getContext();
            }
            if (this.clg != null || this.clj == null || (context = this.mContext) == null) {
                return;
            }
            this.clg = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.cll = z;
    }

    public void setHeight(int i) {
        this.clC = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.clp = z;
    }

    public void setWidth(int i) {
        this.clz = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.clA = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.clD = i4;
            setHeight(i4);
        }
        if (isShowing() && this.clj != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.clk.getLayoutParams();
            int i5 = this.cly;
            if (i5 >= 0) {
                i5 = this.clA;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.clA = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.clB;
            if (i6 >= 0) {
                i6 = this.clD;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.clD = i6;
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
            int aed = aed();
            if (aed != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = aed;
                z = true;
            }
            int hp = hp(layoutParams.flags);
            if (hp != layoutParams.flags) {
                layoutParams.flags = hp;
            } else {
                z2 = z;
            }
            if (z2) {
                this.clg.updateViewLayout(this.clk, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.clj;
        if (view != null && this.mContext != null && this.clg != null) {
            if (this.clJ != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0324c c0324c = new C0324c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0324c.setBackgroundDrawable(this.clJ);
                c0324c.addView(this.clj, layoutParams3);
                this.clk = c0324c;
            } else {
                this.clk = view;
            }
            this.clE = layoutParams.width;
            this.clF = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.clM) {
            this.clM = z;
            if (this.clJ != null) {
                Drawable drawable = this.clK;
                if (drawable != null) {
                    if (this.clM) {
                        this.clk.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.clk.setBackgroundDrawable(this.clL);
                        return;
                    }
                }
                this.clk.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.clj != null) {
            aee();
            this.clh = true;
            this.cli = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = aed();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.clB;
            if (i4 < 0) {
                this.clD = i4;
                c.height = i4;
            }
            int i5 = this.cly;
            if (i5 < 0) {
                this.clA = i5;
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
        this.clg.addView(this.clk, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.clz;
        this.clA = i;
        layoutParams.width = i;
        int i2 = this.clC;
        this.clD = i2;
        layoutParams.height = i2;
        Drawable drawable = this.clJ;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = hp(layoutParams.flags);
        layoutParams.type = this.clN;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.cln;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.clG);
        int[] iArr = this.clG;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.clH);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.clH[1] + i2 + this.clF > rect.bottom || (layoutParams.x + this.clE) - rootView.getWidth() > 0) {
            if (this.clu) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.clE + scrollX + i, this.clF + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.clG);
            int[] iArr2 = this.clG;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.clH);
            r0 = ((rect.bottom - this.clH[1]) - view.getHeight()) - i2 < (this.clH[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.clG[1]) + i2;
            } else {
                layoutParams.y = this.clG[1] + view.getHeight() + i2;
            }
        }
        if (this.clt) {
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
                int i7 = (this.clH[1] + i2) - this.clF;
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
        this.clO = bVar;
    }
}
