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
/* loaded from: classes14.dex */
public class c {
    private static final boolean DEBUG = d.cqC;
    private static final int[] ctl = {16842922};
    private boolean ctB;
    private boolean ctC;
    private boolean ctF;
    private View.OnTouchListener ctG;
    private int ctH;
    private int ctI;
    private int ctJ;
    private int ctK;
    private int ctL;
    private int ctM;
    private int ctN;
    private int ctO;
    private Drawable ctS;
    private Drawable ctT;
    private Drawable ctU;
    private boolean ctV;
    private b ctX;
    private WindowManager ctm;
    private boolean ctn;
    private boolean cto;
    private View ctp;
    private View ctq;
    private boolean cts;
    private WeakReference<View> cua;
    private int cuc;
    private int cud;
    private Context mContext;
    private int ctu = 0;
    private int ctv = 1;
    private boolean ctw = true;
    private boolean cty = false;
    private boolean ctz = true;
    private int ctA = -1;
    private boolean ctD = true;
    private boolean ctE = false;
    private int[] ctP = new int[2];
    private int[] ctQ = new int[2];
    private Rect ctR = new Rect();
    private int ctW = 1000;
    private boolean ctY = false;
    private int ctZ = -1;
    private ViewTreeObserver.OnScrollChangedListener cub = new a();

    /* loaded from: classes14.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.cua != null ? (View) c.this.cua.get() : null;
            if (view == null || c.this.ctq == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.ctq.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.cuc, c.this.cud));
            c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes14.dex */
    public interface b {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.poly.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C0317c extends FrameLayout {
        public C0317c(Context context) {
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
            if (c.this.ctG == null || !c.this.ctG.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.ctV) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.ctl);
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
            if (c.this.ctp != null) {
                c.this.ctp.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.ctm = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int adW() {
        int i = this.ctZ;
        if (i == -1) {
            if (this.cto) {
                return this.ctV ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void adX() {
        WeakReference<View> weakReference = this.cua;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.cub);
        }
        this.cua = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.ctu == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.ctu == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int fO(int i) {
        int i2 = (-8815129) & i;
        if (this.ctY) {
            i2 |= 32768;
        }
        if (!this.cts) {
            i2 |= 8;
        }
        if (!this.ctw) {
            i2 |= 16;
        }
        if (this.cty) {
            i2 |= 262144;
        }
        if (!this.ctz) {
            i2 |= 512;
        }
        if (adZ()) {
            i2 |= 8388608;
        }
        if (this.ctB) {
            i2 |= 256;
        }
        if (this.ctE) {
            i2 |= 65536;
        }
        return this.ctF ? i2 | 32 : i2;
    }

    public boolean adZ() {
        Context context;
        return (this.ctA >= 0 || (context = this.mContext) == null) ? this.ctA == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.ctq != null) {
            this.ctn = false;
            adX();
            try {
                try {
                    this.ctm.removeView(this.ctq);
                    View view = this.ctq;
                    View view2 = this.ctp;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.ctq = null;
                    bVar = this.ctX;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.ctq;
                        View view4 = this.ctp;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.ctq = null;
                        bVar = this.ctX;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.ctq;
                View view6 = this.ctp;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.ctq = null;
                b bVar2 = this.ctX;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public void en(boolean z) {
        this.cty = z;
    }

    public void eo(boolean z) {
        this.ctz = z;
    }

    public boolean isShowing() {
        return this.ctn;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.ctS = drawable;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.ctp = view;
            if (this.mContext == null && (view2 = this.ctp) != null) {
                this.mContext = view2.getContext();
            }
            if (this.ctm != null || this.ctp == null || (context = this.mContext) == null) {
                return;
            }
            this.ctm = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.cts = z;
    }

    public void setHeight(int i) {
        this.ctL = i;
    }

    public void setWidth(int i) {
        this.ctI = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.ctJ = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.ctM = i4;
            setHeight(i4);
        }
        if (isShowing() && this.ctp != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.ctq.getLayoutParams();
            int i5 = this.ctH;
            if (i5 >= 0) {
                i5 = this.ctJ;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.ctJ = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.ctK;
            if (i6 >= 0) {
                i6 = this.ctM;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.ctM = i6;
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
            int adW = adW();
            if (adW != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = adW;
                z = true;
            }
            int fO = fO(layoutParams.flags);
            if (fO != layoutParams.flags) {
                layoutParams.flags = fO;
            } else {
                z2 = z;
            }
            if (z2) {
                this.ctm.updateViewLayout(this.ctq, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.ctp;
        if (view != null && this.mContext != null && this.ctm != null) {
            if (this.ctS != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0317c c0317c = new C0317c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0317c.setBackgroundDrawable(this.ctS);
                c0317c.addView(this.ctp, layoutParams3);
                this.ctq = c0317c;
            } else {
                this.ctq = view;
            }
            this.ctN = layoutParams.width;
            this.ctO = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.ctV) {
            this.ctV = z;
            if (this.ctS != null) {
                Drawable drawable = this.ctT;
                if (drawable != null) {
                    if (this.ctV) {
                        this.ctq.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.ctq.setBackgroundDrawable(this.ctU);
                        return;
                    }
                }
                this.ctq.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.ctp != null) {
            adX();
            this.ctn = true;
            this.cto = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = adW();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.ctK;
            if (i4 < 0) {
                this.ctM = i4;
                c.height = i4;
            }
            int i5 = this.ctH;
            if (i5 < 0) {
                this.ctJ = i5;
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
        this.ctm.addView(this.ctq, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.ctI;
        this.ctJ = i;
        layoutParams.width = i;
        int i2 = this.ctL;
        this.ctM = i2;
        layoutParams.height = i2;
        Drawable drawable = this.ctS;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = fO(layoutParams.flags);
        layoutParams.type = this.ctW;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.ctv;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.ctP);
        int[] iArr = this.ctP;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.ctQ);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.ctQ[1] + i2 + this.ctO > rect.bottom || (layoutParams.x + this.ctN) - rootView.getWidth() > 0) {
            if (this.ctD) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.ctN + scrollX + i, this.ctO + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.ctP);
            int[] iArr2 = this.ctP;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.ctQ);
            r0 = ((rect.bottom - this.ctQ[1]) - view.getHeight()) - i2 < (this.ctQ[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.ctP[1]) + i2;
            } else {
                layoutParams.y = this.ctP[1] + view.getHeight() + i2;
            }
        }
        if (this.ctC) {
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
                int i7 = (this.ctQ[1] + i2) - this.ctO;
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
        this.ctX = bVar;
    }
}
