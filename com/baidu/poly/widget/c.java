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
    private static final boolean DEBUG = d.bvX;
    private static final int[] byG = {16842922};
    private WindowManager byH;
    private boolean byI;
    private View byJ;
    private View byK;
    private boolean byL;
    private boolean byR;
    private boolean byS;
    private boolean byU;
    private View.OnTouchListener byV;
    private int byW;
    private int byX;
    private int byY;
    private int byZ;
    private int bza;
    private int bzb;
    private int bzc;
    private int bzd;
    private Drawable bzh;
    private Drawable bzi;
    private Drawable bzj;
    private boolean bzk;
    private b bzm;
    private WeakReference<View> bzp;
    private int bzr;
    private int bzs;
    private boolean fe;
    private Context mContext;
    private int byM = 0;
    private int byN = 1;
    private boolean me = true;
    private boolean byO = false;
    private boolean byP = true;
    private int byQ = -1;
    private boolean byT = true;
    private boolean te = false;
    private int[] bze = new int[2];
    private int[] bzf = new int[2];
    private Rect bzg = new Rect();
    private int bzl = 1000;
    private boolean bzn = false;
    private int bzo = -1;
    private ViewTreeObserver.OnScrollChangedListener bzq = new a();

    /* loaded from: classes11.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.bzp != null ? (View) c.this.bzp.get() : null;
            if (view == null || c.this.byK == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.byK.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.bzr, c.this.bzs));
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
    public class C0246c extends FrameLayout {
        public C0246c(Context context) {
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
            if (c.this.byV == null || !c.this.byV.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.bzk) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.byG);
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
            if (c.this.byJ != null) {
                c.this.byJ.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.byH = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int No() {
        int i = this.bzo;
        if (i == -1) {
            if (this.byI) {
                return this.bzk ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void Np() {
        WeakReference<View> weakReference = this.bzp;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.bzq);
        }
        this.bzp = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.byM == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.byM == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dO(int i) {
        int i2 = (-8815129) & i;
        if (this.bzn) {
            i2 |= 32768;
        }
        if (!this.byL) {
            i2 |= 8;
        }
        if (!this.me) {
            i2 |= 16;
        }
        if (this.byO) {
            i2 |= 262144;
        }
        if (!this.byP) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.byR) {
            i2 |= 256;
        }
        if (this.te) {
            i2 |= 65536;
        }
        return this.byU ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.byK != null) {
            this.fe = false;
            Np();
            try {
                try {
                    this.byH.removeView(this.byK);
                    View view = this.byK;
                    View view2 = this.byJ;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.byK = null;
                    bVar = this.bzm;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.byK;
                        View view4 = this.byJ;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.byK = null;
                        bVar = this.bzm;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.byK;
                View view6 = this.byJ;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.byK = null;
                b bVar2 = this.bzm;
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
        return (this.byQ >= 0 || (context = this.mContext) == null) ? this.byQ == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.bzh = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.byP = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.byJ = view;
            if (this.mContext == null && (view2 = this.byJ) != null) {
                this.mContext = view2.getContext();
            }
            if (this.byH != null || this.byJ == null || (context = this.mContext) == null) {
                return;
            }
            this.byH = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.byL = z;
    }

    public void setHeight(int i) {
        this.bza = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.byO = z;
    }

    public void setWidth(int i) {
        this.byX = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.byY = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bzb = i4;
            setHeight(i4);
        }
        if (isShowing() && this.byJ != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.byK.getLayoutParams();
            int i5 = this.byW;
            if (i5 >= 0) {
                i5 = this.byY;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.byY = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.byZ;
            if (i6 >= 0) {
                i6 = this.bzb;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.bzb = i6;
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
            int No = No();
            if (No != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = No;
                z = true;
            }
            int dO = dO(layoutParams.flags);
            if (dO != layoutParams.flags) {
                layoutParams.flags = dO;
            } else {
                z2 = z;
            }
            if (z2) {
                this.byH.updateViewLayout(this.byK, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.byJ;
        if (view != null && this.mContext != null && this.byH != null) {
            if (this.bzh != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0246c c0246c = new C0246c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0246c.setBackgroundDrawable(this.bzh);
                c0246c.addView(this.byJ, layoutParams3);
                this.byK = c0246c;
            } else {
                this.byK = view;
            }
            this.bzc = layoutParams.width;
            this.bzd = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.bzk) {
            this.bzk = z;
            if (this.bzh != null) {
                Drawable drawable = this.bzi;
                if (drawable != null) {
                    if (this.bzk) {
                        this.byK.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.byK.setBackgroundDrawable(this.bzj);
                        return;
                    }
                }
                this.byK.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.byJ != null) {
            Np();
            this.fe = true;
            this.byI = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = No();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.byZ;
            if (i4 < 0) {
                this.bzb = i4;
                c.height = i4;
            }
            int i5 = this.byW;
            if (i5 < 0) {
                this.byY = i5;
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
        this.byH.addView(this.byK, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.byX;
        this.byY = i;
        layoutParams.width = i;
        int i2 = this.bza;
        this.bzb = i2;
        layoutParams.height = i2;
        Drawable drawable = this.bzh;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = dO(layoutParams.flags);
        layoutParams.type = this.bzl;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.byN;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bze);
        int[] iArr = this.bze;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bzf);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bzf[1] + i2 + this.bzd > rect.bottom || (layoutParams.x + this.bzc) - rootView.getWidth() > 0) {
            if (this.byT) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.bzc + scrollX + i, this.bzd + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bze);
            int[] iArr2 = this.bze;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bzf);
            r0 = ((rect.bottom - this.bzf[1]) - view.getHeight()) - i2 < (this.bzf[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bze[1]) + i2;
            } else {
                layoutParams.y = this.bze[1] + view.getHeight() + i2;
            }
        }
        if (this.byS) {
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
                int i7 = (this.bzf[1] + i2) - this.bzd;
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
        this.bzm = bVar;
    }
}
