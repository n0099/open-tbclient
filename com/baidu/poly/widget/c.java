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
    private static final boolean DEBUG = com.baidu.poly.util.c.aSb;
    private static final int[] aUL = {16842922};
    private WindowManager aUM;
    private boolean aUN;
    private boolean aUO;
    private View aUP;
    private View aUQ;
    private boolean aUR;
    private boolean aUY;
    private boolean aUZ;
    private int aVA;
    private boolean aVc;
    private View.OnTouchListener aVd;
    private int aVe;
    private int aVf;
    private int aVg;
    private int aVh;
    private int aVi;
    private int aVj;
    private int aVk;
    private int aVl;
    private Drawable aVp;
    private Drawable aVq;
    private Drawable aVr;
    private boolean aVs;
    private b aVu;
    private WeakReference<View> aVx;
    private int aVz;
    private Context mContext;
    private int aUS = 0;
    private int aUT = 1;
    private boolean aUU = true;
    private boolean aUV = false;
    private boolean aUW = true;
    private int aUX = -1;
    private boolean aVa = true;
    private boolean aVb = false;
    private int[] aVm = new int[2];
    private int[] aVn = new int[2];
    private Rect aVo = new Rect();
    private int aVt = 1000;
    private boolean aVv = false;
    private int aVw = -1;
    private ViewTreeObserver.OnScrollChangedListener aVy = new a();

    /* loaded from: classes11.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.aVx != null ? (View) c.this.aVx.get() : null;
            if (view == null || c.this.aUQ == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.aUQ.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.aVz, c.this.aVA));
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
    public class C0167c extends FrameLayout {
        public C0167c(Context context) {
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
            if (c.this.aVd == null || !c.this.aVd.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.aVs) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.aUL);
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
            if (c.this.aUP != null) {
                c.this.aUP.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.aUM = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int EK() {
        int i = this.aVw;
        if (i == -1) {
            if (this.aUO) {
                return this.aVs ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void EL() {
        WeakReference<View> weakReference = this.aVx;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.aVy);
        }
        this.aVx = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.aUS == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.aUS == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dC(int i) {
        int i2 = (-8815129) & i;
        if (this.aVv) {
            i2 |= 32768;
        }
        if (!this.aUR) {
            i2 |= 8;
        }
        if (!this.aUU) {
            i2 |= 16;
        }
        if (this.aUV) {
            i2 |= 262144;
        }
        if (!this.aUW) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.aUY) {
            i2 |= 256;
        }
        if (this.aVb) {
            i2 |= 65536;
        }
        return this.aVc ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.aUQ != null) {
            this.aUN = false;
            EL();
            try {
                try {
                    this.aUM.removeView(this.aUQ);
                    View view = this.aUQ;
                    View view2 = this.aUP;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.aUQ = null;
                    bVar = this.aVu;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.aUQ;
                        View view4 = this.aUP;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.aUQ = null;
                        bVar = this.aVu;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.aUQ;
                View view6 = this.aUP;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.aUQ = null;
                b bVar2 = this.aVu;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.aUN;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.aUX >= 0 || (context = this.mContext) == null) ? this.aUX == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.aVp = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.aUW = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.aUP = view;
            if (this.mContext == null && (view2 = this.aUP) != null) {
                this.mContext = view2.getContext();
            }
            if (this.aUM != null || this.aUP == null || (context = this.mContext) == null) {
                return;
            }
            this.aUM = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.aUR = z;
    }

    public void setHeight(int i) {
        this.aVi = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.aUV = z;
    }

    public void setWidth(int i) {
        this.aVf = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.aVg = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.aVj = i4;
            setHeight(i4);
        }
        if (isShowing() && this.aUP != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.aUQ.getLayoutParams();
            int i5 = this.aVe;
            if (i5 >= 0) {
                i5 = this.aVg;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.aVg = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.aVh;
            if (i6 >= 0) {
                i6 = this.aVj;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.aVj = i6;
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
            int EK = EK();
            if (EK != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = EK;
                z = true;
            }
            int dC = dC(layoutParams.flags);
            if (dC != layoutParams.flags) {
                layoutParams.flags = dC;
            } else {
                z2 = z;
            }
            if (z2) {
                this.aUM.updateViewLayout(this.aUQ, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.aUP;
        if (view != null && this.mContext != null && this.aUM != null) {
            if (this.aVp != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0167c c0167c = new C0167c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0167c.setBackgroundDrawable(this.aVp);
                c0167c.addView(this.aUP, layoutParams3);
                this.aUQ = c0167c;
            } else {
                this.aUQ = view;
            }
            this.aVk = layoutParams.width;
            this.aVl = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.aVs) {
            this.aVs = z;
            if (this.aVp != null) {
                Drawable drawable = this.aVq;
                if (drawable != null) {
                    if (this.aVs) {
                        this.aUQ.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.aUQ.setBackgroundDrawable(this.aVr);
                        return;
                    }
                }
                this.aUQ.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.aUP != null) {
            EL();
            this.aUN = true;
            this.aUO = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = EK();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.aVh;
            if (i4 < 0) {
                this.aVj = i4;
                c.height = i4;
            }
            int i5 = this.aVe;
            if (i5 < 0) {
                this.aVg = i5;
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
        this.aUM.addView(this.aUQ, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.aVf;
        this.aVg = i;
        layoutParams.width = i;
        int i2 = this.aVi;
        this.aVj = i2;
        layoutParams.height = i2;
        Drawable drawable = this.aVp;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = dC(layoutParams.flags);
        layoutParams.type = this.aVt;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.aUT;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.aVm);
        int[] iArr = this.aVm;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.aVn);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.aVn[1] + i2 + this.aVl > rect.bottom || (layoutParams.x + this.aVk) - rootView.getWidth() > 0) {
            if (this.aVa) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.aVk + scrollX + i, this.aVl + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.aVm);
            int[] iArr2 = this.aVm;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.aVn);
            r0 = ((rect.bottom - this.aVn[1]) - view.getHeight()) - i2 < (this.aVn[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.aVm[1]) + i2;
            } else {
                layoutParams.y = this.aVm[1] + view.getHeight() + i2;
            }
        }
        if (this.aUZ) {
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
                int i7 = (this.aVn[1] + i2) - this.aVl;
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
        this.aVu = bVar;
    }
}
