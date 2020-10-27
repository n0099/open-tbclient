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
    private static final boolean DEBUG = d.bXT;
    private static final int[] caA = {16842922};
    private WindowManager caB;
    private boolean caC;
    private View caD;
    private View caE;
    private boolean caF;
    private boolean caL;
    private boolean caM;
    private boolean caP;
    private View.OnTouchListener caQ;
    private int caR;
    private int caS;
    private int caT;
    private int caU;
    private int caV;
    private int caW;
    private int caX;
    private int caY;
    private Drawable cbc;
    private Drawable cbd;
    private Drawable cbe;
    private boolean cbf;
    private b cbh;
    private WeakReference<View> cbk;
    private int cbm;
    private int cbn;
    private boolean le;
    private Context mContext;
    private int caG = 0;
    private int caH = 1;
    private boolean se = true;
    private boolean caI = false;
    private boolean caJ = true;
    private int caK = -1;
    private boolean caN = true;
    private boolean caO = false;
    private int[] caZ = new int[2];
    private int[] cba = new int[2];
    private Rect cbb = new Rect();
    private int cbg = 1000;
    private boolean cbi = false;
    private int cbj = -1;
    private ViewTreeObserver.OnScrollChangedListener cbl = new a();

    /* loaded from: classes6.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.cbk != null ? (View) c.this.cbk.get() : null;
            if (view == null || c.this.caE == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.caE.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.cbm, c.this.cbn));
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
    public class C0303c extends FrameLayout {
        public C0303c(Context context) {
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
            if (c.this.caQ == null || !c.this.caQ.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.cbf) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.caA);
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
            if (c.this.caD != null) {
                c.this.caD.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.caB = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int Zf() {
        int i = this.cbj;
        if (i == -1) {
            if (this.caC) {
                return this.cbf ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void Zg() {
        WeakReference<View> weakReference = this.cbk;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.cbl);
        }
        this.cbk = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.caG == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.caG == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int gL(int i) {
        int i2 = (-8815129) & i;
        if (this.cbi) {
            i2 |= 32768;
        }
        if (!this.caF) {
            i2 |= 8;
        }
        if (!this.se) {
            i2 |= 16;
        }
        if (this.caI) {
            i2 |= 262144;
        }
        if (!this.caJ) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.caL) {
            i2 |= 256;
        }
        if (this.caO) {
            i2 |= 65536;
        }
        return this.caP ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.caE != null) {
            this.le = false;
            Zg();
            try {
                try {
                    this.caB.removeView(this.caE);
                    View view = this.caE;
                    View view2 = this.caD;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.caE = null;
                    bVar = this.cbh;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.caE;
                        View view4 = this.caD;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.caE = null;
                        bVar = this.cbh;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.caE;
                View view6 = this.caD;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.caE = null;
                b bVar2 = this.cbh;
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
        return (this.caK >= 0 || (context = this.mContext) == null) ? this.caK == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.cbc = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.caJ = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.caD = view;
            if (this.mContext == null && (view2 = this.caD) != null) {
                this.mContext = view2.getContext();
            }
            if (this.caB != null || this.caD == null || (context = this.mContext) == null) {
                return;
            }
            this.caB = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.caF = z;
    }

    public void setHeight(int i) {
        this.caV = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.caI = z;
    }

    public void setWidth(int i) {
        this.caS = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.caT = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.caW = i4;
            setHeight(i4);
        }
        if (isShowing() && this.caD != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.caE.getLayoutParams();
            int i5 = this.caR;
            if (i5 >= 0) {
                i5 = this.caT;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.caT = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.caU;
            if (i6 >= 0) {
                i6 = this.caW;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.caW = i6;
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
            int Zf = Zf();
            if (Zf != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = Zf;
                z = true;
            }
            int gL = gL(layoutParams.flags);
            if (gL != layoutParams.flags) {
                layoutParams.flags = gL;
            } else {
                z2 = z;
            }
            if (z2) {
                this.caB.updateViewLayout(this.caE, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.caD;
        if (view != null && this.mContext != null && this.caB != null) {
            if (this.cbc != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0303c c0303c = new C0303c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0303c.setBackgroundDrawable(this.cbc);
                c0303c.addView(this.caD, layoutParams3);
                this.caE = c0303c;
            } else {
                this.caE = view;
            }
            this.caX = layoutParams.width;
            this.caY = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.cbf) {
            this.cbf = z;
            if (this.cbc != null) {
                Drawable drawable = this.cbd;
                if (drawable != null) {
                    if (this.cbf) {
                        this.caE.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.caE.setBackgroundDrawable(this.cbe);
                        return;
                    }
                }
                this.caE.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.caD != null) {
            Zg();
            this.le = true;
            this.caC = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = Zf();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.caU;
            if (i4 < 0) {
                this.caW = i4;
                c.height = i4;
            }
            int i5 = this.caR;
            if (i5 < 0) {
                this.caT = i5;
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
        this.caB.addView(this.caE, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.caS;
        this.caT = i;
        layoutParams.width = i;
        int i2 = this.caV;
        this.caW = i2;
        layoutParams.height = i2;
        Drawable drawable = this.cbc;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = gL(layoutParams.flags);
        layoutParams.type = this.cbg;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.caH;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.caZ);
        int[] iArr = this.caZ;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.cba);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.cba[1] + i2 + this.caY > rect.bottom || (layoutParams.x + this.caX) - rootView.getWidth() > 0) {
            if (this.caN) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.caX + scrollX + i, this.caY + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.caZ);
            int[] iArr2 = this.caZ;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.cba);
            r0 = ((rect.bottom - this.cba[1]) - view.getHeight()) - i2 < (this.cba[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.caZ[1]) + i2;
            } else {
                layoutParams.y = this.caZ[1] + view.getHeight() + i2;
            }
        }
        if (this.caM) {
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
                int i7 = (this.cba[1] + i2) - this.caY;
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
        this.cbh = bVar;
    }
}
