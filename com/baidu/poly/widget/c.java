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
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.poly.util.c.aNC;
    private static final int[] aQm = {16842922};
    private boolean aQA;
    private boolean aQD;
    private View.OnTouchListener aQE;
    private int aQF;
    private int aQG;
    private int aQH;
    private int aQI;
    private int aQJ;
    private int aQK;
    private int aQL;
    private int aQM;
    private Drawable aQQ;
    private Drawable aQR;
    private Drawable aQS;
    private boolean aQT;
    private b aQV;
    private WeakReference<View> aQY;
    private WindowManager aQn;
    private boolean aQo;
    private boolean aQp;
    private View aQq;
    private View aQr;
    private boolean aQs;
    private boolean aQz;
    private int aRa;
    private int aRb;
    private Context mContext;
    private int aQt = 0;
    private int aQu = 1;
    private boolean aQv = true;
    private boolean aQw = false;
    private boolean aQx = true;
    private int aQy = -1;
    private boolean aQB = true;
    private boolean aQC = false;
    private int[] aQN = new int[2];
    private int[] aQO = new int[2];
    private Rect aQP = new Rect();
    private int aQU = 1000;
    private boolean aQW = false;
    private int aQX = -1;
    private ViewTreeObserver.OnScrollChangedListener aQZ = new a();

    /* loaded from: classes10.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.aQY != null ? (View) c.this.aQY.get() : null;
            if (view == null || c.this.aQr == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.aQr.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.aRa, c.this.aRb));
            c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.poly.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0158c extends FrameLayout {
        public C0158c(Context context) {
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
            if (c.this.aQE == null || !c.this.aQE.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.aQT) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.aQm);
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
            if (c.this.aQq != null) {
                c.this.aQq.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.aQn = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int Co() {
        int i = this.aQX;
        if (i == -1) {
            if (this.aQp) {
                return this.aQT ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void Cp() {
        WeakReference<View> weakReference = this.aQY;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.aQZ);
        }
        this.aQY = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.aQt == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.aQt == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dm(int i) {
        int i2 = (-8815129) & i;
        if (this.aQW) {
            i2 |= 32768;
        }
        if (!this.aQs) {
            i2 |= 8;
        }
        if (!this.aQv) {
            i2 |= 16;
        }
        if (this.aQw) {
            i2 |= 262144;
        }
        if (!this.aQx) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.aQz) {
            i2 |= 256;
        }
        if (this.aQC) {
            i2 |= 65536;
        }
        return this.aQD ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.aQr != null) {
            this.aQo = false;
            Cp();
            try {
                try {
                    this.aQn.removeView(this.aQr);
                    View view = this.aQr;
                    View view2 = this.aQq;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.aQr = null;
                    bVar = this.aQV;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.aQr;
                        View view4 = this.aQq;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.aQr = null;
                        bVar = this.aQV;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.aQr;
                View view6 = this.aQq;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.aQr = null;
                b bVar2 = this.aQV;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.aQo;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.aQy >= 0 || (context = this.mContext) == null) ? this.aQy == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.aQQ = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.aQx = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.aQq = view;
            if (this.mContext == null && (view2 = this.aQq) != null) {
                this.mContext = view2.getContext();
            }
            if (this.aQn != null || this.aQq == null || (context = this.mContext) == null) {
                return;
            }
            this.aQn = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.aQs = z;
    }

    public void setHeight(int i) {
        this.aQJ = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.aQw = z;
    }

    public void setWidth(int i) {
        this.aQG = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.aQH = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.aQK = i4;
            setHeight(i4);
        }
        if (isShowing() && this.aQq != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.aQr.getLayoutParams();
            int i5 = this.aQF;
            if (i5 >= 0) {
                i5 = this.aQH;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.aQH = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.aQI;
            if (i6 >= 0) {
                i6 = this.aQK;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.aQK = i6;
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
            int Co = Co();
            if (Co != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = Co;
                z = true;
            }
            int dm = dm(layoutParams.flags);
            if (dm != layoutParams.flags) {
                layoutParams.flags = dm;
            } else {
                z2 = z;
            }
            if (z2) {
                this.aQn.updateViewLayout(this.aQr, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.aQq;
        if (view != null && this.mContext != null && this.aQn != null) {
            if (this.aQQ != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0158c c0158c = new C0158c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0158c.setBackgroundDrawable(this.aQQ);
                c0158c.addView(this.aQq, layoutParams3);
                this.aQr = c0158c;
            } else {
                this.aQr = view;
            }
            this.aQL = layoutParams.width;
            this.aQM = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.aQT) {
            this.aQT = z;
            if (this.aQQ != null) {
                Drawable drawable = this.aQR;
                if (drawable != null) {
                    if (this.aQT) {
                        this.aQr.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.aQr.setBackgroundDrawable(this.aQS);
                        return;
                    }
                }
                this.aQr.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.aQq != null) {
            Cp();
            this.aQo = true;
            this.aQp = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = Co();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.aQI;
            if (i4 < 0) {
                this.aQK = i4;
                c.height = i4;
            }
            int i5 = this.aQF;
            if (i5 < 0) {
                this.aQH = i5;
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
        this.aQn.addView(this.aQr, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.aQG;
        this.aQH = i;
        layoutParams.width = i;
        int i2 = this.aQJ;
        this.aQK = i2;
        layoutParams.height = i2;
        Drawable drawable = this.aQQ;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = dm(layoutParams.flags);
        layoutParams.type = this.aQU;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.aQu;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.aQN);
        int[] iArr = this.aQN;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.aQO);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.aQO[1] + i2 + this.aQM > rect.bottom || (layoutParams.x + this.aQL) - rootView.getWidth() > 0) {
            if (this.aQB) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.aQL + scrollX + i, this.aQM + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.aQN);
            int[] iArr2 = this.aQN;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.aQO);
            r0 = ((rect.bottom - this.aQO[1]) - view.getHeight()) - i2 < (this.aQO[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.aQN[1]) + i2;
            } else {
                layoutParams.y = this.aQN[1] + view.getHeight() + i2;
            }
        }
        if (this.aQA) {
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
                int i7 = (this.aQO[1] + i2) - this.aQM;
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
        this.aQV = bVar;
    }
}
