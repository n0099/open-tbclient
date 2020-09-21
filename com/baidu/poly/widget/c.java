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
    private static final boolean DEBUG = d.bIN;
    private static final int[] bLu = {16842922};
    private boolean bLF;
    private boolean bLG;
    private boolean bLJ;
    private View.OnTouchListener bLK;
    private int bLL;
    private int bLM;
    private int bLN;
    private int bLO;
    private int bLP;
    private int bLQ;
    private int bLR;
    private int bLS;
    private Drawable bLW;
    private Drawable bLX;
    private Drawable bLY;
    private boolean bLZ;
    private WindowManager bLv;
    private boolean bLw;
    private View bLx;
    private View bLy;
    private boolean bLz;
    private b bMb;
    private WeakReference<View> bMe;
    private int bMg;
    private int bMh;
    private boolean le;
    private Context mContext;
    private int bLA = 0;
    private int bLB = 1;
    private boolean se = true;
    private boolean bLC = false;
    private boolean bLD = true;
    private int bLE = -1;
    private boolean bLH = true;
    private boolean bLI = false;
    private int[] bLT = new int[2];
    private int[] bLU = new int[2];
    private Rect bLV = new Rect();
    private int bMa = 1000;
    private boolean bMc = false;
    private int bMd = -1;
    private ViewTreeObserver.OnScrollChangedListener bMf = new a();

    /* loaded from: classes9.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.bMe != null ? (View) c.this.bMe.get() : null;
            if (view == null || c.this.bLy == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.bLy.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.bMg, c.this.bMh));
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
    public class C0274c extends FrameLayout {
        public C0274c(Context context) {
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
            if (c.this.bLK == null || !c.this.bLK.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.bLZ) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.bLu);
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
            if (c.this.bLx != null) {
                c.this.bLx.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.bLv = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int Vo() {
        int i = this.bMd;
        if (i == -1) {
            if (this.bLw) {
                return this.bLZ ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void Vp() {
        WeakReference<View> weakReference = this.bMe;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.bMf);
        }
        this.bMe = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.bLA == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.bLA == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int gg(int i) {
        int i2 = (-8815129) & i;
        if (this.bMc) {
            i2 |= 32768;
        }
        if (!this.bLz) {
            i2 |= 8;
        }
        if (!this.se) {
            i2 |= 16;
        }
        if (this.bLC) {
            i2 |= 262144;
        }
        if (!this.bLD) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.bLF) {
            i2 |= 256;
        }
        if (this.bLI) {
            i2 |= 65536;
        }
        return this.bLJ ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.bLy != null) {
            this.le = false;
            Vp();
            try {
                try {
                    this.bLv.removeView(this.bLy);
                    View view = this.bLy;
                    View view2 = this.bLx;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.bLy = null;
                    bVar = this.bMb;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.bLy;
                        View view4 = this.bLx;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.bLy = null;
                        bVar = this.bMb;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.bLy;
                View view6 = this.bLx;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.bLy = null;
                b bVar2 = this.bMb;
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
        return (this.bLE >= 0 || (context = this.mContext) == null) ? this.bLE == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.bLW = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.bLD = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.bLx = view;
            if (this.mContext == null && (view2 = this.bLx) != null) {
                this.mContext = view2.getContext();
            }
            if (this.bLv != null || this.bLx == null || (context = this.mContext) == null) {
                return;
            }
            this.bLv = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.bLz = z;
    }

    public void setHeight(int i) {
        this.bLP = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.bLC = z;
    }

    public void setWidth(int i) {
        this.bLM = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bLN = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bLQ = i4;
            setHeight(i4);
        }
        if (isShowing() && this.bLx != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bLy.getLayoutParams();
            int i5 = this.bLL;
            if (i5 >= 0) {
                i5 = this.bLN;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.bLN = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.bLO;
            if (i6 >= 0) {
                i6 = this.bLQ;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.bLQ = i6;
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
            int Vo = Vo();
            if (Vo != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = Vo;
                z = true;
            }
            int gg = gg(layoutParams.flags);
            if (gg != layoutParams.flags) {
                layoutParams.flags = gg;
            } else {
                z2 = z;
            }
            if (z2) {
                this.bLv.updateViewLayout(this.bLy, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.bLx;
        if (view != null && this.mContext != null && this.bLv != null) {
            if (this.bLW != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0274c c0274c = new C0274c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0274c.setBackgroundDrawable(this.bLW);
                c0274c.addView(this.bLx, layoutParams3);
                this.bLy = c0274c;
            } else {
                this.bLy = view;
            }
            this.bLR = layoutParams.width;
            this.bLS = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.bLZ) {
            this.bLZ = z;
            if (this.bLW != null) {
                Drawable drawable = this.bLX;
                if (drawable != null) {
                    if (this.bLZ) {
                        this.bLy.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.bLy.setBackgroundDrawable(this.bLY);
                        return;
                    }
                }
                this.bLy.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.bLx != null) {
            Vp();
            this.le = true;
            this.bLw = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = Vo();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.bLO;
            if (i4 < 0) {
                this.bLQ = i4;
                c.height = i4;
            }
            int i5 = this.bLL;
            if (i5 < 0) {
                this.bLN = i5;
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
        this.bLv.addView(this.bLy, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.bLM;
        this.bLN = i;
        layoutParams.width = i;
        int i2 = this.bLP;
        this.bLQ = i2;
        layoutParams.height = i2;
        Drawable drawable = this.bLW;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = gg(layoutParams.flags);
        layoutParams.type = this.bMa;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bLB;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bLT);
        int[] iArr = this.bLT;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bLU);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bLU[1] + i2 + this.bLS > rect.bottom || (layoutParams.x + this.bLR) - rootView.getWidth() > 0) {
            if (this.bLH) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.bLR + scrollX + i, this.bLS + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bLT);
            int[] iArr2 = this.bLT;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bLU);
            r0 = ((rect.bottom - this.bLU[1]) - view.getHeight()) - i2 < (this.bLU[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bLT[1]) + i2;
            } else {
                layoutParams.y = this.bLT[1] + view.getHeight() + i2;
            }
        }
        if (this.bLG) {
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
                int i7 = (this.bLU[1] + i2) - this.bLS;
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
        this.bMb = bVar;
    }
}
