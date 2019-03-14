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
import com.baidu.swan.menu.g;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class PopupWindow {
    private static final int[] bku = {16842922};
    private boolean BB;
    private boolean bjT;
    private boolean bjU;
    private View bjV;
    private int bjW;
    private int bjX;
    private boolean bjY;
    private boolean bjZ;
    private int bka;
    private boolean bkb;
    private boolean bkc;
    private boolean bkd;
    private boolean bke;
    private boolean bkf;
    private View.OnTouchListener bkg;
    private int bkh;
    private int bki;
    private int bkj;
    private int bkk;
    private int[] bkl;
    private int[] bkm;
    private Drawable bkn;
    private Drawable bko;
    private boolean bkp;
    private int bkq;
    private a bkr;
    private boolean bks;
    private int bkt;
    private WeakReference<View> bkv;
    private ViewTreeObserver.OnScrollChangedListener bkw;
    private int bkx;
    private int bky;
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
        this.bjW = 0;
        this.bjX = 1;
        this.bjY = true;
        this.BB = false;
        this.bjZ = true;
        this.bka = -1;
        this.bkd = true;
        this.bke = false;
        this.bkl = new int[2];
        this.bkm = new int[2];
        this.mTempRect = new Rect();
        this.bkq = 1000;
        this.bks = false;
        this.bkt = -1;
        this.bkw = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view;
                if (PopupWindow.this.bkv != null) {
                    view = (View) PopupWindow.this.bkv.get();
                } else {
                    view = null;
                }
                if (view != null && PopupWindow.this.bjV != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.bjV.getLayoutParams();
                    PopupWindow.this.cL(PopupWindow.this.a(view, layoutParams, PopupWindow.this.bkx, PopupWindow.this.bky));
                    PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.h.PopupWindow, i, i2);
        this.mBackground = obtainStyledAttributes.getDrawable(g.h.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(g.h.PopupWindow_popupAnimationStyle, -1);
        this.bkt = resourceId == 16973824 ? -1 : resourceId;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
        this.bjW = 0;
        this.bjX = 1;
        this.bjY = true;
        this.BB = false;
        this.bjZ = true;
        this.bka = -1;
        this.bkd = true;
        this.bke = false;
        this.bkl = new int[2];
        this.bkm = new int[2];
        this.mTempRect = new Rect();
        this.bkq = 1000;
        this.bks = false;
        this.bkt = -1;
        this.bkw = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2;
                if (PopupWindow.this.bkv != null) {
                    view2 = (View) PopupWindow.this.bkv.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && PopupWindow.this.bjV != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.bjV.getLayoutParams();
                    PopupWindow.this.cL(PopupWindow.this.a(view2, layoutParams, PopupWindow.this.bkx, PopupWindow.this.bky));
                    PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
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
        this.bkt = i;
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

    public void setOutsideTouchable(boolean z) {
        this.BB = z;
    }

    public void setClippingEnabled(boolean z) {
        this.bjZ = z;
    }

    public boolean isSplitTouchEnabled() {
        return (this.bka >= 0 || this.mContext == null) ? this.bka == 1 : this.mContext.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean isShowing() {
        return this.bjT;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.mContentView != null) {
            Re();
            this.bjT = true;
            this.bjU = false;
            WindowManager.LayoutParams d = d(iBinder);
            d.windowAnimations = Rd();
            a(d);
            if (i == 0) {
                i = 51;
            }
            d.gravity = i;
            d.x = i2;
            d.y = i3;
            if (this.mHeightMode < 0) {
                int i4 = this.mHeightMode;
                this.bki = i4;
                d.height = i4;
            }
            if (this.mWidthMode < 0) {
                int i5 = this.mWidthMode;
                this.bkh = i5;
                d.width = i5;
            }
            b(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(boolean z) {
        if (z != this.bkp) {
            this.bkp = z;
            if (this.mBackground != null) {
                if (this.bkn != null) {
                    if (this.bkp) {
                        this.bjV.setBackgroundDrawable(this.bkn);
                        return;
                    } else {
                        this.bjV.setBackgroundDrawable(this.bko);
                        return;
                    }
                }
                this.bjV.refreshDrawableState();
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
            this.bjV = bVar;
        } else {
            this.bjV = this.mContentView;
        }
        this.bkj = layoutParams.width;
        this.bkk = layoutParams.height;
    }

    private void b(WindowManager.LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        this.mWindowManager.addView(this.bjV, layoutParams);
    }

    private WindowManager.LayoutParams d(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.mWidth;
        this.bkh = i;
        layoutParams.width = i;
        int i2 = this.mHeight;
        this.bki = i2;
        layoutParams.height = i2;
        if (this.mBackground != null) {
            layoutParams.format = this.mBackground.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = eU(layoutParams.flags);
        layoutParams.type = this.bkq;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.bjX;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private int eU(int i) {
        int i2 = (-8815129) & i;
        if (this.bks) {
            i2 |= 32768;
        }
        if (!this.mFocusable) {
            i2 |= 8;
            if (this.bjW == 1) {
                i2 |= 131072;
            }
        } else if (this.bjW == 2) {
            i2 |= 131072;
        }
        if (!this.bjY) {
            i2 |= 16;
        }
        if (this.BB) {
            i2 |= 262144;
        }
        if (!this.bjZ) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.bkb) {
            i2 |= 256;
        }
        if (this.bke) {
            i2 |= 65536;
        }
        if (this.bkf) {
            return i2 | 32;
        }
        return i2;
    }

    private int Rd() {
        if (this.bkt == -1) {
            if (this.bjU) {
                return this.bkp ? g.C0211g.PopupWindow_DropDownUp : g.C0211g.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return this.bkt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.bkl);
        layoutParams.x = this.bkl[0] + i;
        layoutParams.y = this.bkl[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.bkm);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.bkm[1] + i2 + this.bkk > rect.bottom || (layoutParams.x + this.bkj) - rootView.getWidth() > 0) {
            if (this.bkd) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.bkj + scrollX + i, this.bkk + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.bkl);
            layoutParams.x = this.bkl[0] + i;
            layoutParams.y = this.bkl[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.bkm);
            r0 = ((rect.bottom - this.bkm[1]) - view.getHeight()) - i2 < (this.bkm[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.bkl[1]) + i2;
            } else {
                layoutParams.y = this.bkl[1] + view.getHeight() + i2;
            }
        }
        if (this.bkc) {
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
                int i5 = (this.bkm[1] + i2) - this.bkk;
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
        if (isShowing() && this.bjV != null) {
            this.bjT = false;
            Re();
            try {
                this.mWindowManager.removeView(this.bjV);
                if (this.bjV != this.mContentView && (this.bjV instanceof ViewGroup)) {
                    ((ViewGroup) this.bjV).removeView(this.mContentView);
                }
                this.bjV = null;
                if (this.bkr != null) {
                    this.bkr.onDismiss();
                }
            } catch (IllegalArgumentException e) {
                if (this.bjV != this.mContentView && (this.bjV instanceof ViewGroup)) {
                    ((ViewGroup) this.bjV).removeView(this.mContentView);
                }
                this.bjV = null;
                if (this.bkr != null) {
                    this.bkr.onDismiss();
                }
            } catch (Throwable th) {
                if (this.bjV != this.mContentView && (this.bjV instanceof ViewGroup)) {
                    ((ViewGroup) this.bjV).removeView(this.mContentView);
                }
                this.bjV = null;
                if (this.bkr != null) {
                    this.bkr.onDismiss();
                }
                throw th;
            }
        }
    }

    public void a(a aVar) {
        this.bkr = aVar;
    }

    public void update() {
        boolean z = true;
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bjV.getLayoutParams();
            boolean z2 = false;
            int Rd = Rd();
            if (Rd != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = Rd;
                z2 = true;
            }
            int eU = eU(layoutParams.flags);
            if (eU != layoutParams.flags) {
                layoutParams.flags = eU;
            } else {
                z = z2;
            }
            if (z) {
                this.mWindowManager.updateViewLayout(this.bjV, layoutParams);
            }
        }
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.bkh = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.bki = i4;
            setHeight(i4);
        }
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.bjV.getLayoutParams();
            int i5 = this.mWidthMode < 0 ? this.mWidthMode : this.bkh;
            if (i3 != -1 && layoutParams.width != i5) {
                this.bkh = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.mHeightMode < 0 ? this.mHeightMode : this.bki;
            if (i4 != -1 && layoutParams.height != i6) {
                this.bki = i6;
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
            int Rd = Rd();
            if (Rd != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = Rd;
                z = true;
            }
            int eU = eU(layoutParams.flags);
            if (eU != layoutParams.flags) {
                layoutParams.flags = eU;
            } else {
                z2 = z;
            }
            if (z2) {
                this.mWindowManager.updateViewLayout(this.bjV, layoutParams);
            }
        }
    }

    private void Re() {
        WeakReference<View> weakReference = this.bkv;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.bkw);
        }
        this.bkv = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.bkp) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.bku);
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
            if (PopupWindow.this.bkg == null || !PopupWindow.this.bkg.onTouch(this, motionEvent)) {
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
