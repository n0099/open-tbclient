package com.baidu.swan.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.swan.menu.f;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class PopupWindow {
    private static final int[] brL = {16842922};
    private boolean bnd;
    private int brA;
    private int brB;
    private int[] brC;
    private int[] brD;
    private Drawable brE;
    private Drawable brF;
    private boolean brG;
    private int brH;
    private a brI;
    private boolean brJ;
    private int brK;
    private WeakReference<View> brM;
    private ViewTreeObserver.OnScrollChangedListener brN;
    private int brO;
    private int brP;
    private boolean brl;
    private View brm;
    private int brn;
    private int bro;
    private boolean brp;
    private boolean brq;
    private int brr;
    private boolean brs;
    private boolean brt;
    private boolean bru;
    private boolean brv;
    private boolean brw;
    private View.OnTouchListener brx;
    private int bry;
    private int brz;
    private Drawable mBackground;
    private View mContentView;
    private Context mContext;
    private boolean mFocusable;
    private int mHeight;
    private int mHeightMode;
    private Rect mTempRect;
    private int mWidth;
    private int mWidthMode;
    private WindowManager mWindowManager;
    private boolean zo;

    /* loaded from: classes2.dex */
    public interface a {
        void onDismiss();
    }

    public PopupWindow(Context context) {
        this(context, null);
    }

    public PopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842870);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.brn = 0;
        this.bro = 1;
        this.brp = true;
        this.zo = false;
        this.brq = true;
        this.brr = -1;
        this.bru = true;
        this.brv = false;
        this.brC = new int[2];
        this.brD = new int[2];
        this.mTempRect = new Rect();
        this.brH = 1000;
        this.brJ = false;
        this.brK = -1;
        this.brN = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view;
                if (PopupWindow.this.brM != null) {
                    view = (View) PopupWindow.this.brM.get();
                } else {
                    view = null;
                }
                if (view != null && PopupWindow.this.brm != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.brm.getLayoutParams();
                    PopupWindow.this.dh(PopupWindow.this.a(view, layoutParams, PopupWindow.this.brO, PopupWindow.this.brP));
                    PopupWindow.this.a(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.h.PopupWindow, i, i2);
        this.mBackground = obtainStyledAttributes.getDrawable(f.h.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(f.h.PopupWindow_popupAnimationStyle, -1);
        this.brK = resourceId == 16973824 ? -1 : resourceId;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
        this.brn = 0;
        this.bro = 1;
        this.brp = true;
        this.zo = false;
        this.brq = true;
        this.brr = -1;
        this.bru = true;
        this.brv = false;
        this.brC = new int[2];
        this.brD = new int[2];
        this.mTempRect = new Rect();
        this.brH = 1000;
        this.brJ = false;
        this.brK = -1;
        this.brN = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2;
                if (PopupWindow.this.brM != null) {
                    view2 = (View) PopupWindow.this.brM.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && PopupWindow.this.brm != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.brm.getLayoutParams();
                    PopupWindow.this.dh(PopupWindow.this.a(view2, layoutParams, PopupWindow.this.brO, PopupWindow.this.brP));
                    PopupWindow.this.a(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        if (view != null) {
            this.mContext = view.getContext();
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackground = drawable;
    }

    public void setAnimationStyle(int i) {
        this.brK = i;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public void setContentView(View view) {
        if (!isShowing()) {
            this.mContentView = view;
            if (this.mContext == null && this.mContentView != null) {
                this.mContext = this.mContentView.getContext();
            }
            if (this.mWindowManager == null && this.mContext != null) {
                this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            }
        }
    }

    public void setFocusable(boolean z) {
        this.mFocusable = z;
    }

    public void setSoftInputMode(int i) {
        this.bro = i;
    }

    public void df(boolean z) {
        this.zo = z;
    }

    public void dg(boolean z) {
        this.brq = z;
    }

    public boolean VJ() {
        return (this.brr >= 0 || this.mContext == null) ? this.brr == 1 : this.mContext.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean isShowing() {
        return this.bnd;
    }

    public void a(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.mContentView != null) {
            VL();
            this.bnd = true;
            this.brl = false;
            WindowManager.LayoutParams d = d(iBinder);
            d.windowAnimations = VK();
            a(d);
            if (i == 0) {
                i = 51;
            }
            d.gravity = i;
            d.x = i2;
            d.y = i3;
            if (this.mHeightMode < 0) {
                int i4 = this.mHeightMode;
                this.brz = i4;
                d.height = i4;
            }
            if (this.mWidthMode < 0) {
                int i5 = this.mWidthMode;
                this.bry = i5;
                d.width = i5;
            }
            b(d);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        c(view, i, i2);
    }

    public void c(View view, int i, int i2) {
        if (!isShowing() && this.mContentView != null) {
            d(view, i, i2);
            this.bnd = true;
            this.brl = true;
            WindowManager.LayoutParams d = d(view.getWindowToken());
            a(d);
            dh(a(view, d, i, i2));
            if (this.mHeightMode < 0) {
                int i3 = this.mHeightMode;
                this.brz = i3;
                d.height = i3;
            }
            if (this.mWidthMode < 0) {
                int i4 = this.mWidthMode;
                this.bry = i4;
                d.width = i4;
            }
            d.windowAnimations = VK();
            b(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(boolean z) {
        if (z != this.brG) {
            this.brG = z;
            if (this.mBackground != null) {
                if (this.brE != null) {
                    if (this.brG) {
                        this.brm.setBackgroundDrawable(this.brE);
                        return;
                    } else {
                        this.brm.setBackgroundDrawable(this.brF);
                        return;
                    }
                }
                this.brm.refreshDrawableState();
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        if (this.mContentView == null || this.mContext == null || this.mWindowManager == null) {
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
        if (this.mBackground != null) {
            ViewGroup.LayoutParams layoutParams2 = this.mContentView.getLayoutParams();
            if (layoutParams2 == null || layoutParams2.height != -2) {
                i = -1;
            }
            b bVar = new b(this.mContext);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
            bVar.setBackgroundDrawable(this.mBackground);
            bVar.addView(this.mContentView, layoutParams3);
            this.brm = bVar;
        } else {
            this.brm = this.mContentView;
        }
        this.brA = layoutParams.width;
        this.brB = layoutParams.height;
    }

    private void b(WindowManager.LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        this.mWindowManager.addView(this.brm, layoutParams);
    }

    private WindowManager.LayoutParams d(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.mWidth;
        this.bry = i;
        layoutParams.width = i;
        int i2 = this.mHeight;
        this.brz = i2;
        layoutParams.height = i2;
        if (this.mBackground != null) {
            layoutParams.format = this.mBackground.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = fx(layoutParams.flags);
        layoutParams.type = this.brH;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bro;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private int fx(int i) {
        int i2 = (-8815129) & i;
        if (this.brJ) {
            i2 |= 32768;
        }
        if (!this.mFocusable) {
            i2 |= 8;
            if (this.brn == 1) {
                i2 |= 131072;
            }
        } else if (this.brn == 2) {
            i2 |= 131072;
        }
        if (!this.brp) {
            i2 |= 16;
        }
        if (this.zo) {
            i2 |= 262144;
        }
        if (!this.brq) {
            i2 |= 512;
        }
        if (VJ()) {
            i2 |= 8388608;
        }
        if (this.brs) {
            i2 |= 256;
        }
        if (this.brv) {
            i2 |= 65536;
        }
        if (this.brw) {
            return i2 | 32;
        }
        return i2;
    }

    private int VK() {
        if (this.brK == -1) {
            if (this.brl) {
                return this.brG ? f.g.PopupWindow_DropDownUp : f.g.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return this.brK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.brC);
        layoutParams.x = this.brC[0] + i;
        layoutParams.y = this.brC[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.brD);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.brD[1] + i2 + this.brB > rect.bottom || (layoutParams.x + this.brA) - rootView.getWidth() > 0) {
            if (this.bru) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.brA + scrollX + i, this.brB + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.brC);
            layoutParams.x = this.brC[0] + i;
            layoutParams.y = this.brC[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.brD);
            r0 = ((rect.bottom - this.brD[1]) - view.getHeight()) - i2 < (this.brD[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.brC[1]) + i2;
            } else {
                layoutParams.y = this.brC[1] + view.getHeight() + i2;
            }
        }
        if (this.brt) {
            int i3 = rect.right - rect.left;
            int i4 = layoutParams.x + layoutParams.width;
            if (i4 > i3) {
                layoutParams.x -= i4 - i3;
            }
            if (layoutParams.x < rect.left) {
                layoutParams.x = rect.left;
                layoutParams.width = Math.min(layoutParams.width, i3);
            }
            if (r0) {
                int i5 = (this.brD[1] + i2) - this.brB;
                if (i5 < 0) {
                    layoutParams.y = i5 + layoutParams.y;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= 268435456;
        return r0;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IGET]}, finally: {[IGET, IGET, IGET, INVOKE, IF, IPUT, IGET, IGET, CHECK_CAST, IGET, INVOKE, IGET, INVOKE, IF, IPUT, IGET, IF, IGET, INSTANCE_OF, IGET, INVOKE, IF, IPUT, IGET, IF] complete} */
    public void dismiss() {
        if (isShowing() && this.brm != null) {
            this.bnd = false;
            VL();
            try {
                this.mWindowManager.removeView(this.brm);
                if (this.brm != this.mContentView && (this.brm instanceof ViewGroup)) {
                    ((ViewGroup) this.brm).removeView(this.mContentView);
                }
                this.brm = null;
                if (this.brI != null) {
                    this.brI.onDismiss();
                }
            } catch (IllegalArgumentException e) {
                if (this.brm != this.mContentView && (this.brm instanceof ViewGroup)) {
                    ((ViewGroup) this.brm).removeView(this.mContentView);
                }
                this.brm = null;
                if (this.brI != null) {
                    this.brI.onDismiss();
                }
            } catch (Throwable th) {
                if (this.brm != this.mContentView && (this.brm instanceof ViewGroup)) {
                    ((ViewGroup) this.brm).removeView(this.mContentView);
                }
                this.brm = null;
                if (this.brI != null) {
                    this.brI.onDismiss();
                }
                throw th;
            }
        }
    }

    public void a(a aVar) {
        this.brI = aVar;
    }

    public void update() {
        boolean z = true;
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.brm.getLayoutParams();
            boolean z2 = false;
            int VK = VK();
            if (VK != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = VK;
                z2 = true;
            }
            int fx = fx(layoutParams.flags);
            if (fx != layoutParams.flags) {
                layoutParams.flags = fx;
            } else {
                z = z2;
            }
            if (z) {
                this.mWindowManager.updateViewLayout(this.brm, layoutParams);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bry = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.brz = i4;
            setHeight(i4);
        }
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.brm.getLayoutParams();
            int i5 = this.mWidthMode < 0 ? this.mWidthMode : this.bry;
            if (i3 != -1 && layoutParams.width != i5) {
                this.bry = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.mHeightMode < 0 ? this.mHeightMode : this.brz;
            if (i4 != -1 && layoutParams.height != i6) {
                this.brz = i6;
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
            int VK = VK();
            if (VK != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = VK;
                z = true;
            }
            int fx = fx(layoutParams.flags);
            if (fx != layoutParams.flags) {
                layoutParams.flags = fx;
            } else {
                z2 = z;
            }
            if (z2) {
                this.mWindowManager.updateViewLayout(this.brm, layoutParams);
            }
        }
    }

    private void VL() {
        WeakReference<View> weakReference = this.brM;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.brN);
        }
        this.brM = null;
    }

    private void d(View view, int i, int i2) {
        VL();
        this.brM = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.brN);
        }
        this.brO = i;
        this.brP = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.brG) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.brL);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i);
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
                    PopupWindow.this.dismiss();
                    return true;
                } else {
                    return super.dispatchKeyEvent(keyEvent);
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (PopupWindow.this.brx == null || !PopupWindow.this.brx.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= super.getWidth() || y < 0 || y >= super.getHeight())) {
                PopupWindow.this.dismiss();
                return true;
            } else if (motionEvent.getAction() == 4) {
                PopupWindow.this.dismiss();
                return true;
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i) {
            if (PopupWindow.this.mContentView != null) {
                PopupWindow.this.mContentView.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }
}
