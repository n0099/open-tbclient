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
    private static final boolean DEBUG = com.baidu.poly.util.c.box;
    private static final int[] brd = {16842922};
    private int brA;
    private Drawable brE;
    private Drawable brF;
    private Drawable brG;
    private boolean brH;
    private b brJ;
    private WeakReference<View> brM;
    private int brO;
    private int brP;
    private WindowManager bre;
    private boolean brf;
    private boolean brg;
    private View brh;
    private View bri;
    private boolean brj;
    private boolean brp;
    private boolean brq;
    private boolean brs;
    private View.OnTouchListener brt;
    private int bru;
    private int brv;
    private int brw;
    private int brx;
    private int bry;
    private int brz;
    private Context mContext;
    private int qe;
    private int brk = 0;
    private int brl = 1;
    private boolean fe = true;
    private boolean brm = false;
    private boolean brn = true;
    private int bro = -1;
    private boolean brr = true;
    private boolean me = false;
    private int[] brB = new int[2];
    private int[] brC = new int[2];
    private Rect brD = new Rect();
    private int brI = 1000;
    private boolean brK = false;
    private int brL = -1;
    private ViewTreeObserver.OnScrollChangedListener brN = new a();

    /* loaded from: classes11.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.brM != null ? (View) c.this.brM.get() : null;
            if (view == null || c.this.bri == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.bri.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.brO, c.this.brP));
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
    public class C0213c extends FrameLayout {
        public C0213c(Context context) {
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
            if (c.this.brt == null || !c.this.brt.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.brH) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.brd);
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
            if (c.this.brh != null) {
                c.this.brh.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.bre = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int Lc() {
        int i = this.brL;
        if (i == -1) {
            if (this.brg) {
                return this.brH ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void ca() {
        WeakReference<View> weakReference = this.brM;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.brN);
        }
        this.brM = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.brk == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.brk == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dI(int i) {
        int i2 = (-8815129) & i;
        if (this.brK) {
            i2 |= 32768;
        }
        if (!this.brj) {
            i2 |= 8;
        }
        if (!this.fe) {
            i2 |= 16;
        }
        if (this.brm) {
            i2 |= 262144;
        }
        if (!this.brn) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.brp) {
            i2 |= 256;
        }
        if (this.me) {
            i2 |= 65536;
        }
        return this.brs ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.bri != null) {
            this.brf = false;
            ca();
            try {
                try {
                    this.bre.removeView(this.bri);
                    View view = this.bri;
                    View view2 = this.brh;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.bri = null;
                    bVar = this.brJ;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.bri;
                        View view4 = this.brh;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.bri = null;
                        bVar = this.brJ;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.bri;
                View view6 = this.brh;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.bri = null;
                b bVar2 = this.brJ;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.brf;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.bro >= 0 || (context = this.mContext) == null) ? this.bro == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.brE = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.brn = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.brh = view;
            if (this.mContext == null && (view2 = this.brh) != null) {
                this.mContext = view2.getContext();
            }
            if (this.bre != null || this.brh == null || (context = this.mContext) == null) {
                return;
            }
            this.bre = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.brj = z;
    }

    public void setHeight(int i) {
        this.brx = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.brm = z;
    }

    public void setWidth(int i) {
        this.qe = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.brv = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bry = i4;
            setHeight(i4);
        }
        if (isShowing() && this.brh != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bri.getLayoutParams();
            int i5 = this.bru;
            if (i5 >= 0) {
                i5 = this.brv;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.brv = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.brw;
            if (i6 >= 0) {
                i6 = this.bry;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.bry = i6;
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
            int Lc = Lc();
            if (Lc != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = Lc;
                z = true;
            }
            int dI = dI(layoutParams.flags);
            if (dI != layoutParams.flags) {
                layoutParams.flags = dI;
            } else {
                z2 = z;
            }
            if (z2) {
                this.bre.updateViewLayout(this.bri, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.brh;
        if (view != null && this.mContext != null && this.bre != null) {
            if (this.brE != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0213c c0213c = new C0213c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0213c.setBackgroundDrawable(this.brE);
                c0213c.addView(this.brh, layoutParams3);
                this.bri = c0213c;
            } else {
                this.bri = view;
            }
            this.brz = layoutParams.width;
            this.brA = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.brH) {
            this.brH = z;
            if (this.brE != null) {
                Drawable drawable = this.brF;
                if (drawable != null) {
                    if (this.brH) {
                        this.bri.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.bri.setBackgroundDrawable(this.brG);
                        return;
                    }
                }
                this.bri.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.brh != null) {
            ca();
            this.brf = true;
            this.brg = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = Lc();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.brw;
            if (i4 < 0) {
                this.bry = i4;
                c.height = i4;
            }
            int i5 = this.bru;
            if (i5 < 0) {
                this.brv = i5;
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
        this.bre.addView(this.bri, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.qe;
        this.brv = i;
        layoutParams.width = i;
        int i2 = this.brx;
        this.bry = i2;
        layoutParams.height = i2;
        Drawable drawable = this.brE;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = dI(layoutParams.flags);
        layoutParams.type = this.brI;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.brl;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.brB);
        int[] iArr = this.brB;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.brC);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.brC[1] + i2 + this.brA > rect.bottom || (layoutParams.x + this.brz) - rootView.getWidth() > 0) {
            if (this.brr) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.brz + scrollX + i, this.brA + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.brB);
            int[] iArr2 = this.brB;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.brC);
            r0 = ((rect.bottom - this.brC[1]) - view.getHeight()) - i2 < (this.brC[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.brB[1]) + i2;
            } else {
                layoutParams.y = this.brB[1] + view.getHeight() + i2;
            }
        }
        if (this.brq) {
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
                int i7 = (this.brC[1] + i2) - this.brA;
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
        this.brJ = bVar;
    }
}
