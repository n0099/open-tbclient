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
    private static final boolean DEBUG = d.bGM;
    private static final int[] bJu = {16842922};
    private boolean bJF;
    private boolean bJG;
    private boolean bJJ;
    private View.OnTouchListener bJK;
    private int bJL;
    private int bJM;
    private int bJN;
    private int bJO;
    private int bJP;
    private int bJQ;
    private int bJR;
    private int bJS;
    private Drawable bJW;
    private Drawable bJX;
    private Drawable bJY;
    private boolean bJZ;
    private WindowManager bJv;
    private boolean bJw;
    private View bJx;
    private View bJy;
    private boolean bJz;
    private b bKb;
    private WeakReference<View> bKe;
    private int bKg;
    private int bKh;
    private boolean le;
    private Context mContext;
    private int bJA = 0;
    private int bJB = 1;
    private boolean se = true;
    private boolean bJC = false;
    private boolean bJD = true;
    private int bJE = -1;
    private boolean bJH = true;
    private boolean bJI = false;
    private int[] bJT = new int[2];
    private int[] bJU = new int[2];
    private Rect bJV = new Rect();
    private int bKa = 1000;
    private boolean bKc = false;
    private int bKd = -1;
    private ViewTreeObserver.OnScrollChangedListener bKf = new a();

    /* loaded from: classes6.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.bKe != null ? (View) c.this.bKe.get() : null;
            if (view == null || c.this.bJy == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.bJy.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.bKg, c.this.bKh));
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
            if (c.this.bJK == null || !c.this.bJK.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.bJZ) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.bJu);
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
            if (c.this.bJx != null) {
                c.this.bJx.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.bJv = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int UF() {
        int i = this.bKd;
        if (i == -1) {
            if (this.bJw) {
                return this.bJZ ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void UG() {
        WeakReference<View> weakReference = this.bKe;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.bKf);
        }
        this.bKe = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.bJA == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.bJA == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int fX(int i) {
        int i2 = (-8815129) & i;
        if (this.bKc) {
            i2 |= 32768;
        }
        if (!this.bJz) {
            i2 |= 8;
        }
        if (!this.se) {
            i2 |= 16;
        }
        if (this.bJC) {
            i2 |= 262144;
        }
        if (!this.bJD) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.bJF) {
            i2 |= 256;
        }
        if (this.bJI) {
            i2 |= 65536;
        }
        return this.bJJ ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.bJy != null) {
            this.le = false;
            UG();
            try {
                try {
                    this.bJv.removeView(this.bJy);
                    View view = this.bJy;
                    View view2 = this.bJx;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.bJy = null;
                    bVar = this.bKb;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.bJy;
                        View view4 = this.bJx;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.bJy = null;
                        bVar = this.bKb;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.bJy;
                View view6 = this.bJx;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.bJy = null;
                b bVar2 = this.bKb;
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
        return (this.bJE >= 0 || (context = this.mContext) == null) ? this.bJE == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.bJW = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.bJD = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.bJx = view;
            if (this.mContext == null && (view2 = this.bJx) != null) {
                this.mContext = view2.getContext();
            }
            if (this.bJv != null || this.bJx == null || (context = this.mContext) == null) {
                return;
            }
            this.bJv = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.bJz = z;
    }

    public void setHeight(int i) {
        this.bJP = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.bJC = z;
    }

    public void setWidth(int i) {
        this.bJM = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bJN = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bJQ = i4;
            setHeight(i4);
        }
        if (isShowing() && this.bJx != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bJy.getLayoutParams();
            int i5 = this.bJL;
            if (i5 >= 0) {
                i5 = this.bJN;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.bJN = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.bJO;
            if (i6 >= 0) {
                i6 = this.bJQ;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.bJQ = i6;
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
                this.bJv.updateViewLayout(this.bJy, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.bJx;
        if (view != null && this.mContext != null && this.bJv != null) {
            if (this.bJW != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0276c c0276c = new C0276c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0276c.setBackgroundDrawable(this.bJW);
                c0276c.addView(this.bJx, layoutParams3);
                this.bJy = c0276c;
            } else {
                this.bJy = view;
            }
            this.bJR = layoutParams.width;
            this.bJS = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.bJZ) {
            this.bJZ = z;
            if (this.bJW != null) {
                Drawable drawable = this.bJX;
                if (drawable != null) {
                    if (this.bJZ) {
                        this.bJy.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.bJy.setBackgroundDrawable(this.bJY);
                        return;
                    }
                }
                this.bJy.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.bJx != null) {
            UG();
            this.le = true;
            this.bJw = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = UF();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.bJO;
            if (i4 < 0) {
                this.bJQ = i4;
                c.height = i4;
            }
            int i5 = this.bJL;
            if (i5 < 0) {
                this.bJN = i5;
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
        this.bJv.addView(this.bJy, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.bJM;
        this.bJN = i;
        layoutParams.width = i;
        int i2 = this.bJP;
        this.bJQ = i2;
        layoutParams.height = i2;
        Drawable drawable = this.bJW;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = fX(layoutParams.flags);
        layoutParams.type = this.bKa;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bJB;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bJT);
        int[] iArr = this.bJT;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bJU);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bJU[1] + i2 + this.bJS > rect.bottom || (layoutParams.x + this.bJR) - rootView.getWidth() > 0) {
            if (this.bJH) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.bJR + scrollX + i, this.bJS + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bJT);
            int[] iArr2 = this.bJT;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bJU);
            r0 = ((rect.bottom - this.bJU[1]) - view.getHeight()) - i2 < (this.bJU[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bJT[1]) + i2;
            } else {
                layoutParams.y = this.bJT[1] + view.getHeight() + i2;
            }
        }
        if (this.bJG) {
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
                int i7 = (this.bJU[1] + i2) - this.bJS;
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
        this.bKb = bVar;
    }
}
