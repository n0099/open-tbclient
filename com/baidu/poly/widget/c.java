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
    private static final boolean DEBUG = com.baidu.poly.util.c.aSc;
    private static final int[] aUM = {16842922};
    private WindowManager aUN;
    private boolean aUO;
    private boolean aUP;
    private View aUQ;
    private View aUR;
    private boolean aUS;
    private boolean aUZ;
    private int aVA;
    private int aVB;
    private boolean aVa;
    private boolean aVd;
    private View.OnTouchListener aVe;
    private int aVf;
    private int aVg;
    private int aVh;
    private int aVi;
    private int aVj;
    private int aVk;
    private int aVl;
    private int aVm;
    private Drawable aVq;
    private Drawable aVr;
    private Drawable aVs;
    private boolean aVt;
    private b aVv;
    private WeakReference<View> aVy;
    private Context mContext;
    private int aUT = 0;
    private int aUU = 1;
    private boolean aUV = true;
    private boolean aUW = false;
    private boolean aUX = true;
    private int aUY = -1;
    private boolean aVb = true;
    private boolean aVc = false;
    private int[] aVn = new int[2];
    private int[] aVo = new int[2];
    private Rect aVp = new Rect();
    private int aVu = 1000;
    private boolean aVw = false;
    private int aVx = -1;
    private ViewTreeObserver.OnScrollChangedListener aVz = new a();

    /* loaded from: classes11.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.aVy != null ? (View) c.this.aVy.get() : null;
            if (view == null || c.this.aUR == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.aUR.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.aVA, c.this.aVB));
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
            if (c.this.aVe == null || !c.this.aVe.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.aVt) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.aUM);
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
            if (c.this.aUQ != null) {
                c.this.aUQ.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.aUN = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int EM() {
        int i = this.aVx;
        if (i == -1) {
            if (this.aUP) {
                return this.aVt ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void EN() {
        WeakReference<View> weakReference = this.aVy;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.aVz);
        }
        this.aVy = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.aUT == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.aUT == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dC(int i) {
        int i2 = (-8815129) & i;
        if (this.aVw) {
            i2 |= 32768;
        }
        if (!this.aUS) {
            i2 |= 8;
        }
        if (!this.aUV) {
            i2 |= 16;
        }
        if (this.aUW) {
            i2 |= 262144;
        }
        if (!this.aUX) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.aUZ) {
            i2 |= 256;
        }
        if (this.aVc) {
            i2 |= 65536;
        }
        return this.aVd ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.aUR != null) {
            this.aUO = false;
            EN();
            try {
                try {
                    this.aUN.removeView(this.aUR);
                    View view = this.aUR;
                    View view2 = this.aUQ;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.aUR = null;
                    bVar = this.aVv;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.aUR;
                        View view4 = this.aUQ;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.aUR = null;
                        bVar = this.aVv;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.aUR;
                View view6 = this.aUQ;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.aUR = null;
                b bVar2 = this.aVv;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.aUO;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.aUY >= 0 || (context = this.mContext) == null) ? this.aUY == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.aVq = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.aUX = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.aUQ = view;
            if (this.mContext == null && (view2 = this.aUQ) != null) {
                this.mContext = view2.getContext();
            }
            if (this.aUN != null || this.aUQ == null || (context = this.mContext) == null) {
                return;
            }
            this.aUN = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.aUS = z;
    }

    public void setHeight(int i) {
        this.aVj = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.aUW = z;
    }

    public void setWidth(int i) {
        this.aVg = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.aVh = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.aVk = i4;
            setHeight(i4);
        }
        if (isShowing() && this.aUQ != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.aUR.getLayoutParams();
            int i5 = this.aVf;
            if (i5 >= 0) {
                i5 = this.aVh;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.aVh = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.aVi;
            if (i6 >= 0) {
                i6 = this.aVk;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.aVk = i6;
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
            int EM = EM();
            if (EM != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = EM;
                z = true;
            }
            int dC = dC(layoutParams.flags);
            if (dC != layoutParams.flags) {
                layoutParams.flags = dC;
            } else {
                z2 = z;
            }
            if (z2) {
                this.aUN.updateViewLayout(this.aUR, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.aUQ;
        if (view != null && this.mContext != null && this.aUN != null) {
            if (this.aVq != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0167c c0167c = new C0167c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0167c.setBackgroundDrawable(this.aVq);
                c0167c.addView(this.aUQ, layoutParams3);
                this.aUR = c0167c;
            } else {
                this.aUR = view;
            }
            this.aVl = layoutParams.width;
            this.aVm = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.aVt) {
            this.aVt = z;
            if (this.aVq != null) {
                Drawable drawable = this.aVr;
                if (drawable != null) {
                    if (this.aVt) {
                        this.aUR.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.aUR.setBackgroundDrawable(this.aVs);
                        return;
                    }
                }
                this.aUR.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.aUQ != null) {
            EN();
            this.aUO = true;
            this.aUP = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = EM();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.aVi;
            if (i4 < 0) {
                this.aVk = i4;
                c.height = i4;
            }
            int i5 = this.aVf;
            if (i5 < 0) {
                this.aVh = i5;
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
        this.aUN.addView(this.aUR, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.aVg;
        this.aVh = i;
        layoutParams.width = i;
        int i2 = this.aVj;
        this.aVk = i2;
        layoutParams.height = i2;
        Drawable drawable = this.aVq;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = dC(layoutParams.flags);
        layoutParams.type = this.aVu;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.aUU;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.aVn);
        int[] iArr = this.aVn;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.aVo);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.aVo[1] + i2 + this.aVm > rect.bottom || (layoutParams.x + this.aVl) - rootView.getWidth() > 0) {
            if (this.aVb) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.aVl + scrollX + i, this.aVm + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.aVn);
            int[] iArr2 = this.aVn;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.aVo);
            r0 = ((rect.bottom - this.aVo[1]) - view.getHeight()) - i2 < (this.aVo[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.aVn[1]) + i2;
            } else {
                layoutParams.y = this.aVn[1] + view.getHeight() + i2;
            }
        }
        if (this.aVa) {
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
                int i7 = (this.aVo[1] + i2) - this.aVm;
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
        this.aVv = bVar;
    }
}
