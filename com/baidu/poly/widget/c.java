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
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = d.ckJ;
    private static final int[] cns = {16842922};
    private boolean cnG;
    private boolean cnH;
    private boolean cnK;
    private View.OnTouchListener cnL;
    private int cnM;
    private int cnN;
    private int cnO;
    private int cnP;
    private int cnQ;
    private int cnR;
    private int cnS;
    private int cnT;
    private Drawable cnX;
    private Drawable cnY;
    private Drawable cnZ;
    private WindowManager cnu;
    private boolean cnv;
    private boolean cnw;
    private View cnx;
    private View cny;
    private boolean cnz;
    private boolean coa;
    private b coc;
    private WeakReference<View> cof;
    private int coh;
    private int coi;
    private Context mContext;
    private int cnA = 0;
    private int cnB = 1;
    private boolean cnC = true;
    private boolean cnD = false;
    private boolean cnE = true;
    private int cnF = -1;
    private boolean cnI = true;
    private boolean cnJ = false;
    private int[] cnU = new int[2];
    private int[] cnV = new int[2];
    private Rect cnW = new Rect();
    private int cob = 1000;
    private boolean cod = false;
    private int coe = -1;
    private ViewTreeObserver.OnScrollChangedListener cog = new a();

    /* loaded from: classes3.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.cof != null ? (View) c.this.cof.get() : null;
            if (view == null || c.this.cny == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.cny.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.coh, c.this.coi));
            c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.poly.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0307c extends FrameLayout {
        public C0307c(Context context) {
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
            if (c.this.cnL == null || !c.this.cnL.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.coa) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.cns);
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
            if (c.this.cnx != null) {
                c.this.cnx.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.cnu = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int acf() {
        int i = this.coe;
        if (i == -1) {
            if (this.cnw) {
                return this.coa ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void acg() {
        WeakReference<View> weakReference = this.cof;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.cog);
        }
        this.cof = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.cnA == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.cnA == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int fH(int i) {
        int i2 = (-8815129) & i;
        if (this.cod) {
            i2 |= 32768;
        }
        if (!this.cnz) {
            i2 |= 8;
        }
        if (!this.cnC) {
            i2 |= 16;
        }
        if (this.cnD) {
            i2 |= 262144;
        }
        if (!this.cnE) {
            i2 |= 512;
        }
        if (aci()) {
            i2 |= 8388608;
        }
        if (this.cnG) {
            i2 |= 256;
        }
        if (this.cnJ) {
            i2 |= 65536;
        }
        return this.cnK ? i2 | 32 : i2;
    }

    public boolean aci() {
        Context context;
        return (this.cnF >= 0 || (context = this.mContext) == null) ? this.cnF == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.cny != null) {
            this.cnv = false;
            acg();
            try {
                try {
                    this.cnu.removeView(this.cny);
                    View view = this.cny;
                    View view2 = this.cnx;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.cny = null;
                    bVar = this.coc;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.cny;
                        View view4 = this.cnx;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.cny = null;
                        bVar = this.coc;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.cny;
                View view6 = this.cnx;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.cny = null;
                b bVar2 = this.coc;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public void ed(boolean z) {
        this.cnD = z;
    }

    public void ee(boolean z) {
        this.cnE = z;
    }

    public boolean isShowing() {
        return this.cnv;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.cnX = drawable;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.cnx = view;
            if (this.mContext == null && (view2 = this.cnx) != null) {
                this.mContext = view2.getContext();
            }
            if (this.cnu != null || this.cnx == null || (context = this.mContext) == null) {
                return;
            }
            this.cnu = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.cnz = z;
    }

    public void setHeight(int i) {
        this.cnQ = i;
    }

    public void setWidth(int i) {
        this.cnN = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.cnO = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.cnR = i4;
            setHeight(i4);
        }
        if (isShowing() && this.cnx != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.cny.getLayoutParams();
            int i5 = this.cnM;
            if (i5 >= 0) {
                i5 = this.cnO;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.cnO = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.cnP;
            if (i6 >= 0) {
                i6 = this.cnR;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.cnR = i6;
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
            int acf = acf();
            if (acf != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = acf;
                z = true;
            }
            int fH = fH(layoutParams.flags);
            if (fH != layoutParams.flags) {
                layoutParams.flags = fH;
            } else {
                z2 = z;
            }
            if (z2) {
                this.cnu.updateViewLayout(this.cny, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.cnx;
        if (view != null && this.mContext != null && this.cnu != null) {
            if (this.cnX != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0307c c0307c = new C0307c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0307c.setBackgroundDrawable(this.cnX);
                c0307c.addView(this.cnx, layoutParams3);
                this.cny = c0307c;
            } else {
                this.cny = view;
            }
            this.cnS = layoutParams.width;
            this.cnT = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.coa) {
            this.coa = z;
            if (this.cnX != null) {
                Drawable drawable = this.cnY;
                if (drawable != null) {
                    if (this.coa) {
                        this.cny.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.cny.setBackgroundDrawable(this.cnZ);
                        return;
                    }
                }
                this.cny.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.cnx != null) {
            acg();
            this.cnv = true;
            this.cnw = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = acf();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.cnP;
            if (i4 < 0) {
                this.cnR = i4;
                c.height = i4;
            }
            int i5 = this.cnM;
            if (i5 < 0) {
                this.cnO = i5;
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
        this.cnu.addView(this.cny, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.cnN;
        this.cnO = i;
        layoutParams.width = i;
        int i2 = this.cnQ;
        this.cnR = i2;
        layoutParams.height = i2;
        Drawable drawable = this.cnX;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = fH(layoutParams.flags);
        layoutParams.type = this.cob;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.cnB;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.cnU);
        int[] iArr = this.cnU;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.cnV);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.cnV[1] + i2 + this.cnT > rect.bottom || (layoutParams.x + this.cnS) - rootView.getWidth() > 0) {
            if (this.cnI) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.cnS + scrollX + i, this.cnT + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.cnU);
            int[] iArr2 = this.cnU;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.cnV);
            r0 = ((rect.bottom - this.cnV[1]) - view.getHeight()) - i2 < (this.cnV[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.cnU[1]) + i2;
            } else {
                layoutParams.y = this.cnU[1] + view.getHeight() + i2;
            }
        }
        if (this.cnH) {
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
                int i7 = (this.cnV[1] + i2) - this.cnT;
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
        this.coc = bVar;
    }
}
