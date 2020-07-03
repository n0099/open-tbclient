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
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = d.bAO;
    private static final int[] bDv = {16842922};
    private boolean bDA;
    private boolean bDG;
    private boolean bDJ;
    private View.OnTouchListener bDK;
    private int bDL;
    private int bDM;
    private int bDN;
    private int bDO;
    private int bDP;
    private int bDQ;
    private int bDR;
    private Drawable bDV;
    private Drawable bDW;
    private Drawable bDX;
    private boolean bDY;
    private WindowManager bDw;
    private boolean bDx;
    private View bDy;
    private View bDz;
    private b bEa;
    private WeakReference<View> bEd;
    private int bEf;
    private int bEg;
    private boolean fe;
    private Context mContext;
    private boolean re;
    private int xe;
    private int bDB = 0;
    private int bDC = 1;
    private boolean bDD = true;
    private boolean bDE = false;
    private boolean bDF = true;
    private int pe = -1;
    private boolean bDH = true;
    private boolean bDI = false;
    private int[] bDS = new int[2];
    private int[] bDT = new int[2];
    private Rect bDU = new Rect();
    private int bDZ = 1000;
    private boolean bEb = false;
    private int bEc = -1;
    private ViewTreeObserver.OnScrollChangedListener bEe = new a();

    /* loaded from: classes11.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.bEd != null ? (View) c.this.bEd.get() : null;
            if (view == null || c.this.bDz == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.bDz.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.bEf, c.this.bEg));
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
    public class C0252c extends FrameLayout {
        public C0252c(Context context) {
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
            if (c.this.bDK == null || !c.this.bDK.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.bDY) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.bDv);
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
            if (c.this.bDy != null) {
                c.this.bDy.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.bDw = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int Ou() {
        int i = this.bEc;
        if (i == -1) {
            if (this.bDx) {
                return this.bDY ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void Ov() {
        WeakReference<View> weakReference = this.bEd;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.bEe);
        }
        this.bEd = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.bDB == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.bDB == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int eb(int i) {
        int i2 = (-8815129) & i;
        if (this.bEb) {
            i2 |= 32768;
        }
        if (!this.bDA) {
            i2 |= 8;
        }
        if (!this.bDD) {
            i2 |= 16;
        }
        if (this.bDE) {
            i2 |= 262144;
        }
        if (!this.bDF) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.bDG) {
            i2 |= 256;
        }
        if (this.bDI) {
            i2 |= 65536;
        }
        return this.bDJ ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.bDz != null) {
            this.fe = false;
            Ov();
            try {
                try {
                    this.bDw.removeView(this.bDz);
                    View view = this.bDz;
                    View view2 = this.bDy;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.bDz = null;
                    bVar = this.bEa;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.bDz;
                        View view4 = this.bDy;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.bDz = null;
                        bVar = this.bEa;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.bDz;
                View view6 = this.bDy;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.bDz = null;
                b bVar2 = this.bEa;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.fe;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.pe >= 0 || (context = this.mContext) == null) ? this.pe == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.bDV = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.bDF = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.bDy = view;
            if (this.mContext == null && (view2 = this.bDy) != null) {
                this.mContext = view2.getContext();
            }
            if (this.bDw != null || this.bDy == null || (context = this.mContext) == null) {
                return;
            }
            this.bDw = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.bDA = z;
    }

    public void setHeight(int i) {
        this.bDO = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.bDE = z;
    }

    public void setWidth(int i) {
        this.xe = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bDM = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bDP = i4;
            setHeight(i4);
        }
        if (isShowing() && this.bDy != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bDz.getLayoutParams();
            int i5 = this.bDL;
            if (i5 >= 0) {
                i5 = this.bDM;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.bDM = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.bDN;
            if (i6 >= 0) {
                i6 = this.bDP;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.bDP = i6;
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
            int Ou = Ou();
            if (Ou != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = Ou;
                z = true;
            }
            int eb = eb(layoutParams.flags);
            if (eb != layoutParams.flags) {
                layoutParams.flags = eb;
            } else {
                z2 = z;
            }
            if (z2) {
                this.bDw.updateViewLayout(this.bDz, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.bDy;
        if (view != null && this.mContext != null && this.bDw != null) {
            if (this.bDV != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0252c c0252c = new C0252c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0252c.setBackgroundDrawable(this.bDV);
                c0252c.addView(this.bDy, layoutParams3);
                this.bDz = c0252c;
            } else {
                this.bDz = view;
            }
            this.bDQ = layoutParams.width;
            this.bDR = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.bDY) {
            this.bDY = z;
            if (this.bDV != null) {
                Drawable drawable = this.bDW;
                if (drawable != null) {
                    if (this.bDY) {
                        this.bDz.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.bDz.setBackgroundDrawable(this.bDX);
                        return;
                    }
                }
                this.bDz.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.bDy != null) {
            Ov();
            this.fe = true;
            this.bDx = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = Ou();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.bDN;
            if (i4 < 0) {
                this.bDP = i4;
                c.height = i4;
            }
            int i5 = this.bDL;
            if (i5 < 0) {
                this.bDM = i5;
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
        this.bDw.addView(this.bDz, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.xe;
        this.bDM = i;
        layoutParams.width = i;
        int i2 = this.bDO;
        this.bDP = i2;
        layoutParams.height = i2;
        Drawable drawable = this.bDV;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = eb(layoutParams.flags);
        layoutParams.type = this.bDZ;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bDC;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bDS);
        int[] iArr = this.bDS;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bDT);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bDT[1] + i2 + this.bDR > rect.bottom || (layoutParams.x + this.bDQ) - rootView.getWidth() > 0) {
            if (this.bDH) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.bDQ + scrollX + i, this.bDR + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bDS);
            int[] iArr2 = this.bDS;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bDT);
            r0 = ((rect.bottom - this.bDT[1]) - view.getHeight()) - i2 < (this.bDT[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bDS[1]) + i2;
            } else {
                layoutParams.y = this.bDS[1] + view.getHeight() + i2;
            }
        }
        if (this.re) {
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
                int i7 = (this.bDT[1] + i2) - this.bDR;
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
        this.bEa = bVar;
    }
}
