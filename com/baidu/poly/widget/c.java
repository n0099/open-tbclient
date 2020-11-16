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
    private static final boolean DEBUG = d.cbS;
    private static final int[] ceB = {16842922};
    private WindowManager ceC;
    private boolean ceD;
    private View ceE;
    private View ceF;
    private boolean ceG;
    private boolean ceM;
    private boolean ceN;
    private boolean ceQ;
    private View.OnTouchListener ceR;
    private int ceS;
    private int ceT;
    private int ceU;
    private int ceV;
    private int ceW;
    private int ceX;
    private int ceY;
    private int ceZ;
    private Drawable cfd;
    private Drawable cfe;
    private Drawable cff;
    private boolean cfg;
    private b cfi;
    private WeakReference<View> cfl;
    private int cfn;
    private int cfo;
    private boolean le;
    private Context mContext;
    private int ceH = 0;
    private int ceI = 1;
    private boolean se = true;
    private boolean ceJ = false;
    private boolean ceK = true;
    private int ceL = -1;
    private boolean ceO = true;
    private boolean ceP = false;
    private int[] cfa = new int[2];
    private int[] cfb = new int[2];
    private Rect cfc = new Rect();
    private int cfh = 1000;
    private boolean cfj = false;
    private int cfk = -1;
    private ViewTreeObserver.OnScrollChangedListener cfm = new a();

    /* loaded from: classes6.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.cfl != null ? (View) c.this.cfl.get() : null;
            if (view == null || c.this.ceF == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.ceF.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.cfn, c.this.cfo));
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
    public class C0313c extends FrameLayout {
        public C0313c(Context context) {
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
            if (c.this.ceR == null || !c.this.ceR.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.cfg) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.ceB);
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
            if (c.this.ceE != null) {
                c.this.ceE.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.ceC = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int aaV() {
        int i = this.cfk;
        if (i == -1) {
            if (this.ceD) {
                return this.cfg ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void aaW() {
        WeakReference<View> weakReference = this.cfl;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.cfm);
        }
        this.cfl = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.ceH == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.ceH == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int gR(int i) {
        int i2 = (-8815129) & i;
        if (this.cfj) {
            i2 |= 32768;
        }
        if (!this.ceG) {
            i2 |= 8;
        }
        if (!this.se) {
            i2 |= 16;
        }
        if (this.ceJ) {
            i2 |= 262144;
        }
        if (!this.ceK) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.ceM) {
            i2 |= 256;
        }
        if (this.ceP) {
            i2 |= 65536;
        }
        return this.ceQ ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.ceF != null) {
            this.le = false;
            aaW();
            try {
                try {
                    this.ceC.removeView(this.ceF);
                    View view = this.ceF;
                    View view2 = this.ceE;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.ceF = null;
                    bVar = this.cfi;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.ceF;
                        View view4 = this.ceE;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.ceF = null;
                        bVar = this.cfi;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.ceF;
                View view6 = this.ceE;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.ceF = null;
                b bVar2 = this.cfi;
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
        return (this.ceL >= 0 || (context = this.mContext) == null) ? this.ceL == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.cfd = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.ceK = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.ceE = view;
            if (this.mContext == null && (view2 = this.ceE) != null) {
                this.mContext = view2.getContext();
            }
            if (this.ceC != null || this.ceE == null || (context = this.mContext) == null) {
                return;
            }
            this.ceC = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.ceG = z;
    }

    public void setHeight(int i) {
        this.ceW = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.ceJ = z;
    }

    public void setWidth(int i) {
        this.ceT = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.ceU = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.ceX = i4;
            setHeight(i4);
        }
        if (isShowing() && this.ceE != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.ceF.getLayoutParams();
            int i5 = this.ceS;
            if (i5 >= 0) {
                i5 = this.ceU;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.ceU = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.ceV;
            if (i6 >= 0) {
                i6 = this.ceX;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.ceX = i6;
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
            int aaV = aaV();
            if (aaV != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = aaV;
                z = true;
            }
            int gR = gR(layoutParams.flags);
            if (gR != layoutParams.flags) {
                layoutParams.flags = gR;
            } else {
                z2 = z;
            }
            if (z2) {
                this.ceC.updateViewLayout(this.ceF, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.ceE;
        if (view != null && this.mContext != null && this.ceC != null) {
            if (this.cfd != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0313c c0313c = new C0313c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0313c.setBackgroundDrawable(this.cfd);
                c0313c.addView(this.ceE, layoutParams3);
                this.ceF = c0313c;
            } else {
                this.ceF = view;
            }
            this.ceY = layoutParams.width;
            this.ceZ = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.cfg) {
            this.cfg = z;
            if (this.cfd != null) {
                Drawable drawable = this.cfe;
                if (drawable != null) {
                    if (this.cfg) {
                        this.ceF.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.ceF.setBackgroundDrawable(this.cff);
                        return;
                    }
                }
                this.ceF.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.ceE != null) {
            aaW();
            this.le = true;
            this.ceD = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = aaV();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.ceV;
            if (i4 < 0) {
                this.ceX = i4;
                c.height = i4;
            }
            int i5 = this.ceS;
            if (i5 < 0) {
                this.ceU = i5;
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
        this.ceC.addView(this.ceF, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.ceT;
        this.ceU = i;
        layoutParams.width = i;
        int i2 = this.ceW;
        this.ceX = i2;
        layoutParams.height = i2;
        Drawable drawable = this.cfd;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = gR(layoutParams.flags);
        layoutParams.type = this.cfh;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.ceI;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.cfa);
        int[] iArr = this.cfa;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.cfb);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.cfb[1] + i2 + this.ceZ > rect.bottom || (layoutParams.x + this.ceY) - rootView.getWidth() > 0) {
            if (this.ceO) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.ceY + scrollX + i, this.ceZ + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.cfa);
            int[] iArr2 = this.cfa;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.cfb);
            r0 = ((rect.bottom - this.cfb[1]) - view.getHeight()) - i2 < (this.cfb[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.cfa[1]) + i2;
            } else {
                layoutParams.y = this.cfa[1] + view.getHeight() + i2;
            }
        }
        if (this.ceN) {
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
                int i7 = (this.cfb[1] + i2) - this.ceZ;
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
        this.cfi = bVar;
    }
}
