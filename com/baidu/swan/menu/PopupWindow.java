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
    private static final int[] bJF = {16842922};
    private boolean bEY;
    private boolean bJA;
    private int bJB;
    private a bJC;
    private boolean bJD;
    private int bJE;
    private WeakReference<View> bJG;
    private ViewTreeObserver.OnScrollChangedListener bJH;
    private int bJI;
    private int bJJ;
    private boolean bJf;
    private View bJg;
    private int bJh;
    private int bJi;
    private boolean bJj;
    private boolean bJk;
    private int bJl;
    private boolean bJm;
    private boolean bJn;
    private boolean bJo;
    private boolean bJp;
    private boolean bJq;
    private View.OnTouchListener bJr;
    private int bJs;
    private int bJt;
    private int bJu;
    private int bJv;
    private int[] bJw;
    private int[] bJx;
    private Drawable bJy;
    private Drawable bJz;
    private Drawable mBackground;
    private View mContentView;
    private Context mContext;
    private boolean mFocusable;
    private int mHeight;
    private int mHeightMode;
    private boolean mOutsideTouchable;
    private Rect mTempRect;
    private int mWidth;
    private int mWidthMode;
    private WindowManager mWindowManager;

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
        this.bJh = 0;
        this.bJi = 1;
        this.bJj = true;
        this.mOutsideTouchable = false;
        this.bJk = true;
        this.bJl = -1;
        this.bJo = true;
        this.bJp = false;
        this.bJw = new int[2];
        this.bJx = new int[2];
        this.mTempRect = new Rect();
        this.bJB = 1000;
        this.bJD = false;
        this.bJE = -1;
        this.bJH = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view;
                if (PopupWindow.this.bJG != null) {
                    view = (View) PopupWindow.this.bJG.get();
                } else {
                    view = null;
                }
                if (view != null && PopupWindow.this.bJg != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.bJg.getLayoutParams();
                    PopupWindow.this.dy(PopupWindow.this.a(view, layoutParams, PopupWindow.this.bJI, PopupWindow.this.bJJ));
                    PopupWindow.this.a(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.h.PopupWindow, i, i2);
        this.mBackground = obtainStyledAttributes.getDrawable(f.h.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(f.h.PopupWindow_popupAnimationStyle, -1);
        this.bJE = resourceId == 16973824 ? -1 : resourceId;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
        this.bJh = 0;
        this.bJi = 1;
        this.bJj = true;
        this.mOutsideTouchable = false;
        this.bJk = true;
        this.bJl = -1;
        this.bJo = true;
        this.bJp = false;
        this.bJw = new int[2];
        this.bJx = new int[2];
        this.mTempRect = new Rect();
        this.bJB = 1000;
        this.bJD = false;
        this.bJE = -1;
        this.bJH = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2;
                if (PopupWindow.this.bJG != null) {
                    view2 = (View) PopupWindow.this.bJG.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && PopupWindow.this.bJg != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.bJg.getLayoutParams();
                    PopupWindow.this.dy(PopupWindow.this.a(view2, layoutParams, PopupWindow.this.bJI, PopupWindow.this.bJJ));
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
        this.bJE = i;
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
        this.bJi = i;
    }

    public void dw(boolean z) {
        this.mOutsideTouchable = z;
    }

    public void dx(boolean z) {
        this.bJk = z;
    }

    public boolean aaw() {
        return (this.bJl >= 0 || this.mContext == null) ? this.bJl == 1 : this.mContext.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean isShowing() {
        return this.bEY;
    }

    public void a(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.mContentView != null) {
            aay();
            this.bEY = true;
            this.bJf = false;
            WindowManager.LayoutParams d = d(iBinder);
            d.windowAnimations = aax();
            a(d);
            if (i == 0) {
                i = 51;
            }
            d.gravity = i;
            d.x = i2;
            d.y = i3;
            if (this.mHeightMode < 0) {
                int i4 = this.mHeightMode;
                this.bJt = i4;
                d.height = i4;
            }
            if (this.mWidthMode < 0) {
                int i5 = this.mWidthMode;
                this.bJs = i5;
                d.width = i5;
            }
            b(d);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        b(view, i, i2);
    }

    public void b(View view, int i, int i2) {
        if (!isShowing() && this.mContentView != null) {
            c(view, i, i2);
            this.bEY = true;
            this.bJf = true;
            WindowManager.LayoutParams d = d(view.getWindowToken());
            a(d);
            dy(a(view, d, i, i2));
            if (this.mHeightMode < 0) {
                int i3 = this.mHeightMode;
                this.bJt = i3;
                d.height = i3;
            }
            if (this.mWidthMode < 0) {
                int i4 = this.mWidthMode;
                this.bJs = i4;
                d.width = i4;
            }
            d.windowAnimations = aax();
            b(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(boolean z) {
        if (z != this.bJA) {
            this.bJA = z;
            if (this.mBackground != null) {
                if (this.bJy != null) {
                    if (this.bJA) {
                        this.bJg.setBackgroundDrawable(this.bJy);
                        return;
                    } else {
                        this.bJg.setBackgroundDrawable(this.bJz);
                        return;
                    }
                }
                this.bJg.refreshDrawableState();
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
            this.bJg = bVar;
        } else {
            this.bJg = this.mContentView;
        }
        this.bJu = layoutParams.width;
        this.bJv = layoutParams.height;
    }

    private void b(WindowManager.LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        this.mWindowManager.addView(this.bJg, layoutParams);
    }

    private WindowManager.LayoutParams d(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.mWidth;
        this.bJs = i;
        layoutParams.width = i;
        int i2 = this.mHeight;
        this.bJt = i2;
        layoutParams.height = i2;
        if (this.mBackground != null) {
            layoutParams.format = this.mBackground.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = gr(layoutParams.flags);
        layoutParams.type = this.bJB;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bJi;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private int gr(int i) {
        int i2 = (-8815129) & i;
        if (this.bJD) {
            i2 |= 32768;
        }
        if (!this.mFocusable) {
            i2 |= 8;
            if (this.bJh == 1) {
                i2 |= 131072;
            }
        } else if (this.bJh == 2) {
            i2 |= 131072;
        }
        if (!this.bJj) {
            i2 |= 16;
        }
        if (this.mOutsideTouchable) {
            i2 |= 262144;
        }
        if (!this.bJk) {
            i2 |= 512;
        }
        if (aaw()) {
            i2 |= 8388608;
        }
        if (this.bJm) {
            i2 |= 256;
        }
        if (this.bJp) {
            i2 |= 65536;
        }
        if (this.bJq) {
            return i2 | 32;
        }
        return i2;
    }

    private int aax() {
        if (this.bJE == -1) {
            if (this.bJf) {
                return this.bJA ? f.g.PopupWindow_DropDownUp : f.g.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return this.bJE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bJw);
        layoutParams.x = this.bJw[0] + i;
        layoutParams.y = this.bJw[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bJx);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bJx[1] + i2 + this.bJv > rect.bottom || (layoutParams.x + this.bJu) - rootView.getWidth() > 0) {
            if (this.bJo) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.bJu + scrollX + i, this.bJv + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bJw);
            layoutParams.x = this.bJw[0] + i;
            layoutParams.y = this.bJw[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bJx);
            r0 = ((rect.bottom - this.bJx[1]) - view.getHeight()) - i2 < (this.bJx[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bJw[1]) + i2;
            } else {
                layoutParams.y = this.bJw[1] + view.getHeight() + i2;
            }
        }
        if (this.bJn) {
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
                int i5 = (this.bJx[1] + i2) - this.bJv;
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
        if (isShowing() && this.bJg != null) {
            this.bEY = false;
            aay();
            try {
                this.mWindowManager.removeView(this.bJg);
                if (this.bJg != this.mContentView && (this.bJg instanceof ViewGroup)) {
                    ((ViewGroup) this.bJg).removeView(this.mContentView);
                }
                this.bJg = null;
                if (this.bJC != null) {
                    this.bJC.onDismiss();
                }
            } catch (IllegalArgumentException e) {
                if (this.bJg != this.mContentView && (this.bJg instanceof ViewGroup)) {
                    ((ViewGroup) this.bJg).removeView(this.mContentView);
                }
                this.bJg = null;
                if (this.bJC != null) {
                    this.bJC.onDismiss();
                }
            } catch (Throwable th) {
                if (this.bJg != this.mContentView && (this.bJg instanceof ViewGroup)) {
                    ((ViewGroup) this.bJg).removeView(this.mContentView);
                }
                this.bJg = null;
                if (this.bJC != null) {
                    this.bJC.onDismiss();
                }
                throw th;
            }
        }
    }

    public void a(a aVar) {
        this.bJC = aVar;
    }

    public void update() {
        boolean z = true;
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bJg.getLayoutParams();
            boolean z2 = false;
            int aax = aax();
            if (aax != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = aax;
                z2 = true;
            }
            int gr = gr(layoutParams.flags);
            if (gr != layoutParams.flags) {
                layoutParams.flags = gr;
            } else {
                z = z2;
            }
            if (z) {
                this.mWindowManager.updateViewLayout(this.bJg, layoutParams);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bJs = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bJt = i4;
            setHeight(i4);
        }
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bJg.getLayoutParams();
            int i5 = this.mWidthMode < 0 ? this.mWidthMode : this.bJs;
            if (i3 != -1 && layoutParams.width != i5) {
                this.bJs = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.mHeightMode < 0 ? this.mHeightMode : this.bJt;
            if (i4 != -1 && layoutParams.height != i6) {
                this.bJt = i6;
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
            int aax = aax();
            if (aax != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = aax;
                z = true;
            }
            int gr = gr(layoutParams.flags);
            if (gr != layoutParams.flags) {
                layoutParams.flags = gr;
            } else {
                z2 = z;
            }
            if (z2) {
                this.mWindowManager.updateViewLayout(this.bJg, layoutParams);
            }
        }
    }

    private void aay() {
        WeakReference<View> weakReference = this.bJG;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.bJH);
        }
        this.bJG = null;
    }

    private void c(View view, int i, int i2) {
        aay();
        this.bJG = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.bJH);
        }
        this.bJI = i;
        this.bJJ = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.bJA) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.bJF);
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
            if (PopupWindow.this.bJr == null || !PopupWindow.this.bJr.onTouch(this, motionEvent)) {
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
