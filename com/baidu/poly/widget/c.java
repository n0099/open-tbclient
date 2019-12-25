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
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.poly.util.c.aMK;
    private static final int[] aPu = {16842922};
    private boolean aPA;
    private boolean aPH;
    private boolean aPI;
    private boolean aPL;
    private View.OnTouchListener aPM;
    private int aPN;
    private int aPO;
    private int aPP;
    private int aPQ;
    private int aPR;
    private int aPS;
    private int aPT;
    private int aPU;
    private Drawable aPY;
    private Drawable aPZ;
    private WindowManager aPv;
    private boolean aPw;
    private boolean aPx;
    private View aPy;
    private View aPz;
    private Drawable aQa;
    private boolean aQb;
    private b aQd;
    private WeakReference<View> aQg;
    private int aQi;
    private int aQj;
    private Context mContext;
    private int aPB = 0;
    private int aPC = 1;
    private boolean aPD = true;
    private boolean aPE = false;
    private boolean aPF = true;
    private int aPG = -1;
    private boolean aPJ = true;
    private boolean aPK = false;
    private int[] aPV = new int[2];
    private int[] aPW = new int[2];
    private Rect aPX = new Rect();
    private int aQc = 1000;
    private boolean aQe = false;
    private int aQf = -1;
    private ViewTreeObserver.OnScrollChangedListener aQh = new a();

    /* loaded from: classes9.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.aQg != null ? (View) c.this.aQg.get() : null;
            if (view == null || c.this.aPz == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.aPz.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.aQi, c.this.aQj));
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
    public class C0156c extends FrameLayout {
        public C0156c(Context context) {
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
            if (c.this.aPM == null || !c.this.aPM.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.aQb) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.aPu);
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
            if (c.this.aPy != null) {
                c.this.aPy.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.aPv = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int BS() {
        int i = this.aQf;
        if (i == -1) {
            if (this.aPx) {
                return this.aQb ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void BT() {
        WeakReference<View> weakReference = this.aQg;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.aQh);
        }
        this.aQg = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.aPB == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.aPB == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dl(int i) {
        int i2 = (-8815129) & i;
        if (this.aQe) {
            i2 |= 32768;
        }
        if (!this.aPA) {
            i2 |= 8;
        }
        if (!this.aPD) {
            i2 |= 16;
        }
        if (this.aPE) {
            i2 |= 262144;
        }
        if (!this.aPF) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.aPH) {
            i2 |= 256;
        }
        if (this.aPK) {
            i2 |= 65536;
        }
        return this.aPL ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.aPz != null) {
            this.aPw = false;
            BT();
            try {
                try {
                    this.aPv.removeView(this.aPz);
                    View view = this.aPz;
                    View view2 = this.aPy;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.aPz = null;
                    bVar = this.aQd;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.aPz;
                        View view4 = this.aPy;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.aPz = null;
                        bVar = this.aQd;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.aPz;
                View view6 = this.aPy;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.aPz = null;
                b bVar2 = this.aQd;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.aPw;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.aPG >= 0 || (context = this.mContext) == null) ? this.aPG == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.aPY = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.aPF = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.aPy = view;
            if (this.mContext == null && (view2 = this.aPy) != null) {
                this.mContext = view2.getContext();
            }
            if (this.aPv != null || this.aPy == null || (context = this.mContext) == null) {
                return;
            }
            this.aPv = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.aPA = z;
    }

    public void setHeight(int i) {
        this.aPR = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.aPE = z;
    }

    public void setWidth(int i) {
        this.aPO = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.aPP = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.aPS = i4;
            setHeight(i4);
        }
        if (isShowing() && this.aPy != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.aPz.getLayoutParams();
            int i5 = this.aPN;
            if (i5 >= 0) {
                i5 = this.aPP;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.aPP = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.aPQ;
            if (i6 >= 0) {
                i6 = this.aPS;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.aPS = i6;
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
            int BS = BS();
            if (BS != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = BS;
                z = true;
            }
            int dl = dl(layoutParams.flags);
            if (dl != layoutParams.flags) {
                layoutParams.flags = dl;
            } else {
                z2 = z;
            }
            if (z2) {
                this.aPv.updateViewLayout(this.aPz, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.aPy;
        if (view != null && this.mContext != null && this.aPv != null) {
            if (this.aPY != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0156c c0156c = new C0156c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0156c.setBackgroundDrawable(this.aPY);
                c0156c.addView(this.aPy, layoutParams3);
                this.aPz = c0156c;
            } else {
                this.aPz = view;
            }
            this.aPT = layoutParams.width;
            this.aPU = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.aQb) {
            this.aQb = z;
            if (this.aPY != null) {
                Drawable drawable = this.aPZ;
                if (drawable != null) {
                    if (this.aQb) {
                        this.aPz.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.aPz.setBackgroundDrawable(this.aQa);
                        return;
                    }
                }
                this.aPz.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.aPy != null) {
            BT();
            this.aPw = true;
            this.aPx = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = BS();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.aPQ;
            if (i4 < 0) {
                this.aPS = i4;
                c.height = i4;
            }
            int i5 = this.aPN;
            if (i5 < 0) {
                this.aPP = i5;
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
        this.aPv.addView(this.aPz, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.aPO;
        this.aPP = i;
        layoutParams.width = i;
        int i2 = this.aPR;
        this.aPS = i2;
        layoutParams.height = i2;
        Drawable drawable = this.aPY;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = dl(layoutParams.flags);
        layoutParams.type = this.aQc;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.aPC;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.aPV);
        int[] iArr = this.aPV;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.aPW);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.aPW[1] + i2 + this.aPU > rect.bottom || (layoutParams.x + this.aPT) - rootView.getWidth() > 0) {
            if (this.aPJ) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.aPT + scrollX + i, this.aPU + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.aPV);
            int[] iArr2 = this.aPV;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.aPW);
            r0 = ((rect.bottom - this.aPW[1]) - view.getHeight()) - i2 < (this.aPW[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.aPV[1]) + i2;
            } else {
                layoutParams.y = this.aPV[1] + view.getHeight() + i2;
            }
        }
        if (this.aPI) {
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
                int i7 = (this.aPW[1] + i2) - this.aPU;
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
        this.aQd = bVar;
    }
}
