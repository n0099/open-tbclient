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
    private static final boolean DEBUG = d.bGI;
    private static final int[] bJq = {16842922};
    private boolean bJB;
    private boolean bJC;
    private boolean bJF;
    private View.OnTouchListener bJG;
    private int bJH;
    private int bJI;
    private int bJJ;
    private int bJK;
    private int bJL;
    private int bJM;
    private int bJN;
    private int bJO;
    private Drawable bJS;
    private Drawable bJT;
    private Drawable bJU;
    private boolean bJV;
    private b bJX;
    private WindowManager bJr;
    private boolean bJs;
    private View bJt;
    private View bJu;
    private boolean bJv;
    private WeakReference<View> bKa;
    private int bKc;
    private int bKd;
    private boolean le;
    private Context mContext;
    private int bJw = 0;
    private int bJx = 1;
    private boolean se = true;
    private boolean bJy = false;
    private boolean bJz = true;
    private int bJA = -1;
    private boolean bJD = true;
    private boolean bJE = false;
    private int[] bJP = new int[2];
    private int[] bJQ = new int[2];
    private Rect bJR = new Rect();
    private int bJW = 1000;
    private boolean bJY = false;
    private int bJZ = -1;
    private ViewTreeObserver.OnScrollChangedListener bKb = new a();

    /* loaded from: classes6.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.bKa != null ? (View) c.this.bKa.get() : null;
            if (view == null || c.this.bJu == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.bJu.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.bKc, c.this.bKd));
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
    public class C0276c extends FrameLayout {
        public C0276c(Context context) {
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
            if (c.this.bJG == null || !c.this.bJG.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.bJV) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.bJq);
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
            if (c.this.bJt != null) {
                c.this.bJt.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.bJr = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int UF() {
        int i = this.bJZ;
        if (i == -1) {
            if (this.bJs) {
                return this.bJV ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void UG() {
        WeakReference<View> weakReference = this.bKa;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.bKb);
        }
        this.bKa = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.bJw == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.bJw == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int fX(int i) {
        int i2 = (-8815129) & i;
        if (this.bJY) {
            i2 |= 32768;
        }
        if (!this.bJv) {
            i2 |= 8;
        }
        if (!this.se) {
            i2 |= 16;
        }
        if (this.bJy) {
            i2 |= 262144;
        }
        if (!this.bJz) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.bJB) {
            i2 |= 256;
        }
        if (this.bJE) {
            i2 |= 65536;
        }
        return this.bJF ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.bJu != null) {
            this.le = false;
            UG();
            try {
                try {
                    this.bJr.removeView(this.bJu);
                    View view = this.bJu;
                    View view2 = this.bJt;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.bJu = null;
                    bVar = this.bJX;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.bJu;
                        View view4 = this.bJt;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.bJu = null;
                        bVar = this.bJX;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.bJu;
                View view6 = this.bJt;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.bJu = null;
                b bVar2 = this.bJX;
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
        return (this.bJA >= 0 || (context = this.mContext) == null) ? this.bJA == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.bJS = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.bJz = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.bJt = view;
            if (this.mContext == null && (view2 = this.bJt) != null) {
                this.mContext = view2.getContext();
            }
            if (this.bJr != null || this.bJt == null || (context = this.mContext) == null) {
                return;
            }
            this.bJr = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.bJv = z;
    }

    public void setHeight(int i) {
        this.bJL = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.bJy = z;
    }

    public void setWidth(int i) {
        this.bJI = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bJJ = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bJM = i4;
            setHeight(i4);
        }
        if (isShowing() && this.bJt != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bJu.getLayoutParams();
            int i5 = this.bJH;
            if (i5 >= 0) {
                i5 = this.bJJ;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.bJJ = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.bJK;
            if (i6 >= 0) {
                i6 = this.bJM;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.bJM = i6;
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
            int UF = UF();
            if (UF != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = UF;
                z = true;
            }
            int fX = fX(layoutParams.flags);
            if (fX != layoutParams.flags) {
                layoutParams.flags = fX;
            } else {
                z2 = z;
            }
            if (z2) {
                this.bJr.updateViewLayout(this.bJu, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.bJt;
        if (view != null && this.mContext != null && this.bJr != null) {
            if (this.bJS != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0276c c0276c = new C0276c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0276c.setBackgroundDrawable(this.bJS);
                c0276c.addView(this.bJt, layoutParams3);
                this.bJu = c0276c;
            } else {
                this.bJu = view;
            }
            this.bJN = layoutParams.width;
            this.bJO = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.bJV) {
            this.bJV = z;
            if (this.bJS != null) {
                Drawable drawable = this.bJT;
                if (drawable != null) {
                    if (this.bJV) {
                        this.bJu.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.bJu.setBackgroundDrawable(this.bJU);
                        return;
                    }
                }
                this.bJu.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.bJt != null) {
            UG();
            this.le = true;
            this.bJs = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = UF();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.bJK;
            if (i4 < 0) {
                this.bJM = i4;
                c.height = i4;
            }
            int i5 = this.bJH;
            if (i5 < 0) {
                this.bJJ = i5;
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
        this.bJr.addView(this.bJu, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.bJI;
        this.bJJ = i;
        layoutParams.width = i;
        int i2 = this.bJL;
        this.bJM = i2;
        layoutParams.height = i2;
        Drawable drawable = this.bJS;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = fX(layoutParams.flags);
        layoutParams.type = this.bJW;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bJx;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bJP);
        int[] iArr = this.bJP;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bJQ);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bJQ[1] + i2 + this.bJO > rect.bottom || (layoutParams.x + this.bJN) - rootView.getWidth() > 0) {
            if (this.bJD) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.bJN + scrollX + i, this.bJO + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bJP);
            int[] iArr2 = this.bJP;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bJQ);
            r0 = ((rect.bottom - this.bJQ[1]) - view.getHeight()) - i2 < (this.bJQ[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bJP[1]) + i2;
            } else {
                layoutParams.y = this.bJP[1] + view.getHeight() + i2;
            }
        }
        if (this.bJC) {
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
                int i7 = (this.bJQ[1] + i2) - this.bJO;
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
        this.bJX = bVar;
    }
}
