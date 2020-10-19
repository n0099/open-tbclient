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
/* loaded from: classes6.dex */
public class c {
    private static final boolean DEBUG = d.bPw;
    private static final int[] bSd = {16842922};
    private int bSA;
    private int bSB;
    private Drawable bSF;
    private Drawable bSG;
    private Drawable bSH;
    private boolean bSI;
    private b bSK;
    private WeakReference<View> bSN;
    private int bSP;
    private int bSQ;
    private WindowManager bSe;
    private boolean bSf;
    private View bSg;
    private View bSh;
    private boolean bSi;
    private boolean bSo;
    private boolean bSp;
    private boolean bSs;
    private View.OnTouchListener bSt;
    private int bSu;
    private int bSv;
    private int bSw;
    private int bSx;
    private int bSy;
    private int bSz;
    private boolean le;
    private Context mContext;
    private int bSj = 0;
    private int bSk = 1;
    private boolean se = true;
    private boolean bSl = false;
    private boolean bSm = true;
    private int bSn = -1;
    private boolean bSq = true;
    private boolean bSr = false;
    private int[] bSC = new int[2];
    private int[] bSD = new int[2];
    private Rect bSE = new Rect();
    private int bSJ = 1000;
    private boolean bSL = false;
    private int bSM = -1;
    private ViewTreeObserver.OnScrollChangedListener bSO = new a();

    /* loaded from: classes6.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.bSN != null ? (View) c.this.bSN.get() : null;
            if (view == null || c.this.bSh == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.bSh.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.bSP, c.this.bSQ));
            c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.poly.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0289c extends FrameLayout {
        public C0289c(Context context) {
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
            if (c.this.bSt == null || !c.this.bSt.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.bSI) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.bSd);
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
            if (c.this.bSg != null) {
                c.this.bSg.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.bSe = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int Xl() {
        int i = this.bSM;
        if (i == -1) {
            if (this.bSf) {
                return this.bSI ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void Xm() {
        WeakReference<View> weakReference = this.bSN;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.bSO);
        }
        this.bSN = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.bSj == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.bSj == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int gA(int i) {
        int i2 = (-8815129) & i;
        if (this.bSL) {
            i2 |= 32768;
        }
        if (!this.bSi) {
            i2 |= 8;
        }
        if (!this.se) {
            i2 |= 16;
        }
        if (this.bSl) {
            i2 |= 262144;
        }
        if (!this.bSm) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.bSo) {
            i2 |= 256;
        }
        if (this.bSr) {
            i2 |= 65536;
        }
        return this.bSs ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.bSh != null) {
            this.le = false;
            Xm();
            try {
                try {
                    this.bSe.removeView(this.bSh);
                    View view = this.bSh;
                    View view2 = this.bSg;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.bSh = null;
                    bVar = this.bSK;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.bSh;
                        View view4 = this.bSg;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.bSh = null;
                        bVar = this.bSK;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.bSh;
                View view6 = this.bSg;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.bSh = null;
                b bVar2 = this.bSK;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.le;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.bSn >= 0 || (context = this.mContext) == null) ? this.bSn == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.bSF = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.bSm = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.bSg = view;
            if (this.mContext == null && (view2 = this.bSg) != null) {
                this.mContext = view2.getContext();
            }
            if (this.bSe != null || this.bSg == null || (context = this.mContext) == null) {
                return;
            }
            this.bSe = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.bSi = z;
    }

    public void setHeight(int i) {
        this.bSy = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.bSl = z;
    }

    public void setWidth(int i) {
        this.bSv = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bSw = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bSz = i4;
            setHeight(i4);
        }
        if (isShowing() && this.bSg != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bSh.getLayoutParams();
            int i5 = this.bSu;
            if (i5 >= 0) {
                i5 = this.bSw;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.bSw = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.bSx;
            if (i6 >= 0) {
                i6 = this.bSz;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.bSz = i6;
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
            int Xl = Xl();
            if (Xl != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = Xl;
                z = true;
            }
            int gA = gA(layoutParams.flags);
            if (gA != layoutParams.flags) {
                layoutParams.flags = gA;
            } else {
                z2 = z;
            }
            if (z2) {
                this.bSe.updateViewLayout(this.bSh, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.bSg;
        if (view != null && this.mContext != null && this.bSe != null) {
            if (this.bSF != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0289c c0289c = new C0289c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0289c.setBackgroundDrawable(this.bSF);
                c0289c.addView(this.bSg, layoutParams3);
                this.bSh = c0289c;
            } else {
                this.bSh = view;
            }
            this.bSA = layoutParams.width;
            this.bSB = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.bSI) {
            this.bSI = z;
            if (this.bSF != null) {
                Drawable drawable = this.bSG;
                if (drawable != null) {
                    if (this.bSI) {
                        this.bSh.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.bSh.setBackgroundDrawable(this.bSH);
                        return;
                    }
                }
                this.bSh.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.bSg != null) {
            Xm();
            this.le = true;
            this.bSf = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = Xl();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.bSx;
            if (i4 < 0) {
                this.bSz = i4;
                c.height = i4;
            }
            int i5 = this.bSu;
            if (i5 < 0) {
                this.bSw = i5;
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
        this.bSe.addView(this.bSh, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.bSv;
        this.bSw = i;
        layoutParams.width = i;
        int i2 = this.bSy;
        this.bSz = i2;
        layoutParams.height = i2;
        Drawable drawable = this.bSF;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = gA(layoutParams.flags);
        layoutParams.type = this.bSJ;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bSk;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bSC);
        int[] iArr = this.bSC;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bSD);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bSD[1] + i2 + this.bSB > rect.bottom || (layoutParams.x + this.bSA) - rootView.getWidth() > 0) {
            if (this.bSq) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.bSA + scrollX + i, this.bSB + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bSC);
            int[] iArr2 = this.bSC;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bSD);
            r0 = ((rect.bottom - this.bSD[1]) - view.getHeight()) - i2 < (this.bSD[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bSC[1]) + i2;
            } else {
                layoutParams.y = this.bSC[1] + view.getHeight() + i2;
            }
        }
        if (this.bSp) {
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
                int i7 = (this.bSD[1] + i2) - this.bSB;
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
        this.bSK = bVar;
    }
}
