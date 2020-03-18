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
    private static final boolean DEBUG = com.baidu.poly.util.c.aSq;
    private static final int[] aVa = {16842922};
    private int aVA;
    private Drawable aVE;
    private Drawable aVF;
    private Drawable aVG;
    private boolean aVH;
    private b aVJ;
    private WeakReference<View> aVM;
    private int aVO;
    private int aVP;
    private WindowManager aVb;
    private boolean aVc;
    private boolean aVd;
    private View aVe;
    private View aVf;
    private boolean aVg;
    private boolean aVn;
    private boolean aVo;
    private boolean aVr;
    private View.OnTouchListener aVs;
    private int aVt;
    private int aVu;
    private int aVv;
    private int aVw;
    private int aVx;
    private int aVy;
    private int aVz;
    private Context mContext;
    private int aVh = 0;
    private int aVi = 1;
    private boolean aVj = true;
    private boolean aVk = false;
    private boolean aVl = true;
    private int aVm = -1;
    private boolean aVp = true;
    private boolean aVq = false;
    private int[] aVB = new int[2];
    private int[] aVC = new int[2];
    private Rect aVD = new Rect();
    private int aVI = 1000;
    private boolean aVK = false;
    private int aVL = -1;
    private ViewTreeObserver.OnScrollChangedListener aVN = new a();

    /* loaded from: classes11.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.aVM != null ? (View) c.this.aVM.get() : null;
            if (view == null || c.this.aVf == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.aVf.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.aVO, c.this.aVP));
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
            if (c.this.aVs == null || !c.this.aVs.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.aVH) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.aVa);
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
            if (c.this.aVe != null) {
                c.this.aVe.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.aVb = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int ER() {
        int i = this.aVL;
        if (i == -1) {
            if (this.aVd) {
                return this.aVH ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void ES() {
        WeakReference<View> weakReference = this.aVM;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.aVN);
        }
        this.aVM = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.aVh == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.aVh == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dC(int i) {
        int i2 = (-8815129) & i;
        if (this.aVK) {
            i2 |= 32768;
        }
        if (!this.aVg) {
            i2 |= 8;
        }
        if (!this.aVj) {
            i2 |= 16;
        }
        if (this.aVk) {
            i2 |= 262144;
        }
        if (!this.aVl) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.aVn) {
            i2 |= 256;
        }
        if (this.aVq) {
            i2 |= 65536;
        }
        return this.aVr ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.aVf != null) {
            this.aVc = false;
            ES();
            try {
                try {
                    this.aVb.removeView(this.aVf);
                    View view = this.aVf;
                    View view2 = this.aVe;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.aVf = null;
                    bVar = this.aVJ;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.aVf;
                        View view4 = this.aVe;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.aVf = null;
                        bVar = this.aVJ;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.aVf;
                View view6 = this.aVe;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.aVf = null;
                b bVar2 = this.aVJ;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.aVc;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.aVm >= 0 || (context = this.mContext) == null) ? this.aVm == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.aVE = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.aVl = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.aVe = view;
            if (this.mContext == null && (view2 = this.aVe) != null) {
                this.mContext = view2.getContext();
            }
            if (this.aVb != null || this.aVe == null || (context = this.mContext) == null) {
                return;
            }
            this.aVb = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.aVg = z;
    }

    public void setHeight(int i) {
        this.aVx = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.aVk = z;
    }

    public void setWidth(int i) {
        this.aVu = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.aVv = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.aVy = i4;
            setHeight(i4);
        }
        if (isShowing() && this.aVe != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.aVf.getLayoutParams();
            int i5 = this.aVt;
            if (i5 >= 0) {
                i5 = this.aVv;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.aVv = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.aVw;
            if (i6 >= 0) {
                i6 = this.aVy;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.aVy = i6;
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
            int ER = ER();
            if (ER != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = ER;
                z = true;
            }
            int dC = dC(layoutParams.flags);
            if (dC != layoutParams.flags) {
                layoutParams.flags = dC;
            } else {
                z2 = z;
            }
            if (z2) {
                this.aVb.updateViewLayout(this.aVf, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.aVe;
        if (view != null && this.mContext != null && this.aVb != null) {
            if (this.aVE != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0167c c0167c = new C0167c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0167c.setBackgroundDrawable(this.aVE);
                c0167c.addView(this.aVe, layoutParams3);
                this.aVf = c0167c;
            } else {
                this.aVf = view;
            }
            this.aVz = layoutParams.width;
            this.aVA = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.aVH) {
            this.aVH = z;
            if (this.aVE != null) {
                Drawable drawable = this.aVF;
                if (drawable != null) {
                    if (this.aVH) {
                        this.aVf.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.aVf.setBackgroundDrawable(this.aVG);
                        return;
                    }
                }
                this.aVf.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.aVe != null) {
            ES();
            this.aVc = true;
            this.aVd = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = ER();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.aVw;
            if (i4 < 0) {
                this.aVy = i4;
                c.height = i4;
            }
            int i5 = this.aVt;
            if (i5 < 0) {
                this.aVv = i5;
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
        this.aVb.addView(this.aVf, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.aVu;
        this.aVv = i;
        layoutParams.width = i;
        int i2 = this.aVx;
        this.aVy = i2;
        layoutParams.height = i2;
        Drawable drawable = this.aVE;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = dC(layoutParams.flags);
        layoutParams.type = this.aVI;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.aVi;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.aVB);
        int[] iArr = this.aVB;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.aVC);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.aVC[1] + i2 + this.aVA > rect.bottom || (layoutParams.x + this.aVz) - rootView.getWidth() > 0) {
            if (this.aVp) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.aVz + scrollX + i, this.aVA + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.aVB);
            int[] iArr2 = this.aVB;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.aVC);
            r0 = ((rect.bottom - this.aVC[1]) - view.getHeight()) - i2 < (this.aVC[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.aVB[1]) + i2;
            } else {
                layoutParams.y = this.aVB[1] + view.getHeight() + i2;
            }
        }
        if (this.aVo) {
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
                int i7 = (this.aVC[1] + i2) - this.aVA;
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
        this.aVJ = bVar;
    }
}
