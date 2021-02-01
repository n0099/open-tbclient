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
/* loaded from: classes5.dex */
public class PopupWindow {
    private static final int[] esx = {16842922};
    private boolean enb;
    private boolean erY;
    private View erZ;
    private int esA;
    private int esB;
    private int esa;
    private boolean esb;
    private boolean esc;
    private int esd;
    private boolean ese;
    private boolean esf;
    private boolean esg;
    private boolean esh;
    private boolean esi;
    private View.OnTouchListener esj;
    private int esk;
    private int esl;
    private int esm;
    private int esn;
    private int[] eso;
    private int[] esp;
    private Drawable esq;
    private Drawable esr;
    private boolean ess;
    private int est;
    private a esu;
    private boolean esv;
    private int esw;
    private WeakReference<View> esy;
    private ViewTreeObserver.OnScrollChangedListener esz;
    private Drawable mBackground;
    private View mContentView;
    private Context mContext;
    private boolean mFocusable;
    private int mHeight;
    private int mHeightMode;
    private boolean mOutsideTouchable;
    private int mSoftInputMode;
    private Rect mTempRect;
    private int mWidth;
    private int mWidthMode;
    private WindowManager mWindowManager;

    /* loaded from: classes5.dex */
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
        this.esa = 0;
        this.mSoftInputMode = 1;
        this.esb = true;
        this.mOutsideTouchable = false;
        this.esc = true;
        this.esd = -1;
        this.esg = true;
        this.esh = false;
        this.eso = new int[2];
        this.esp = new int[2];
        this.mTempRect = new Rect();
        this.est = 1000;
        this.esv = false;
        this.esw = -1;
        this.esz = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view;
                if (PopupWindow.this.esy != null) {
                    view = (View) PopupWindow.this.esy.get();
                } else {
                    view = null;
                }
                if (view != null && PopupWindow.this.erZ != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.erZ.getLayoutParams();
                    PopupWindow.this.iz(PopupWindow.this.b(view, layoutParams, PopupWindow.this.esA, PopupWindow.this.esB));
                    PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.h.PopupWindow, i, i2);
        this.mBackground = obtainStyledAttributes.getDrawable(f.h.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(f.h.PopupWindow_popupAnimationStyle, -1);
        this.esw = resourceId == 16973824 ? -1 : resourceId;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
        this.esa = 0;
        this.mSoftInputMode = 1;
        this.esb = true;
        this.mOutsideTouchable = false;
        this.esc = true;
        this.esd = -1;
        this.esg = true;
        this.esh = false;
        this.eso = new int[2];
        this.esp = new int[2];
        this.mTempRect = new Rect();
        this.est = 1000;
        this.esv = false;
        this.esw = -1;
        this.esz = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.swan.menu.PopupWindow.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                View view2;
                if (PopupWindow.this.esy != null) {
                    view2 = (View) PopupWindow.this.esy.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && PopupWindow.this.erZ != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.erZ.getLayoutParams();
                    PopupWindow.this.iz(PopupWindow.this.b(view2, layoutParams, PopupWindow.this.esA, PopupWindow.this.esB));
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
        this.esw = i;
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
        this.mSoftInputMode = i;
    }

    public void en(boolean z) {
        this.mOutsideTouchable = z;
    }

    public void eo(boolean z) {
        this.esc = z;
    }

    public boolean adW() {
        return (this.esd >= 0 || this.mContext == null) ? this.esd == 1 : this.mContext.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public boolean isShowing() {
        return this.enb;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        b(view.getWindowToken(), i, i2, i3);
    }

    public void b(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.mContentView != null) {
            bbE();
            this.enb = true;
            this.erY = false;
            WindowManager.LayoutParams d = d(iBinder);
            d.windowAnimations = bbD();
            c(d);
            if (i == 0) {
                i = 51;
            }
            d.gravity = i;
            d.x = i2;
            d.y = i3;
            if (this.mHeightMode < 0) {
                int i4 = this.mHeightMode;
                this.esl = i4;
                d.height = i4;
            }
            if (this.mWidthMode < 0) {
                int i5 = this.mWidthMode;
                this.esk = i5;
                d.width = i5;
            }
            d(d);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        h(view, i, i2);
    }

    public void h(View view, int i, int i2) {
        if (!isShowing() && this.mContentView != null) {
            i(view, i, i2);
            this.enb = true;
            this.erY = true;
            WindowManager.LayoutParams d = d(view.getWindowToken());
            c(d);
            iz(b(view, d, i, i2));
            if (this.mHeightMode < 0) {
                int i3 = this.mHeightMode;
                this.esl = i3;
                d.height = i3;
            }
            if (this.mWidthMode < 0) {
                int i4 = this.mWidthMode;
                this.esk = i4;
                d.width = i4;
            }
            d.windowAnimations = bbD();
            d(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz(boolean z) {
        if (z != this.ess) {
            this.ess = z;
            if (this.mBackground != null) {
                if (this.esq != null) {
                    if (this.ess) {
                        this.erZ.setBackgroundDrawable(this.esq);
                        return;
                    } else {
                        this.erZ.setBackgroundDrawable(this.esr);
                        return;
                    }
                }
                this.erZ.refreshDrawableState();
            }
        }
    }

    private void c(WindowManager.LayoutParams layoutParams) {
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
            this.erZ = bVar;
        } else {
            this.erZ = this.mContentView;
        }
        this.esm = layoutParams.width;
        this.esn = layoutParams.height;
    }

    private void d(WindowManager.LayoutParams layoutParams) {
        if (this.mContext != null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        this.mWindowManager.addView(this.erZ, layoutParams);
    }

    private WindowManager.LayoutParams d(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.mWidth;
        this.esk = i;
        layoutParams.width = i;
        int i2 = this.mHeight;
        this.esl = i2;
        layoutParams.height = i2;
        if (this.mBackground != null) {
            layoutParams.format = this.mBackground.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = lC(layoutParams.flags);
        layoutParams.type = this.est;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.mSoftInputMode;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private int lC(int i) {
        int i2 = (-8815129) & i;
        if (this.esv) {
            i2 |= 32768;
        }
        if (!this.mFocusable) {
            i2 |= 8;
            if (this.esa == 1) {
                i2 |= 131072;
            }
        } else if (this.esa == 2) {
            i2 |= 131072;
        }
        if (!this.esb) {
            i2 |= 16;
        }
        if (this.mOutsideTouchable) {
            i2 |= 262144;
        }
        if (!this.esc) {
            i2 |= 512;
        }
        if (adW()) {
            i2 |= 8388608;
        }
        if (this.ese) {
            i2 |= 256;
        }
        if (this.esh) {
            i2 |= 65536;
        }
        if (this.esi) {
            return i2 | 32;
        }
        return i2;
    }

    private int bbD() {
        if (this.esw == -1) {
            if (this.erY) {
                return this.ess ? f.g.PopupWindow_DropDownUp : f.g.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return this.esw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.eso);
        layoutParams.x = this.eso[0] + i;
        layoutParams.y = this.eso[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.esp);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.esp[1] + i2 + this.esn > rect.bottom || (layoutParams.x + this.esm) - rootView.getWidth() > 0) {
            if (this.esg) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.esm + scrollX + i, this.esn + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.eso);
            layoutParams.x = this.eso[0] + i;
            layoutParams.y = this.eso[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.esp);
            r0 = ((rect.bottom - this.esp[1]) - view.getHeight()) - i2 < (this.esp[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.eso[1]) + i2;
            } else {
                layoutParams.y = this.eso[1] + view.getHeight() + i2;
            }
        }
        if (this.esf) {
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
                int i5 = (this.esp[1] + i2) - this.esn;
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
        if (isShowing() && this.erZ != null) {
            this.enb = false;
            bbE();
            try {
                this.mWindowManager.removeView(this.erZ);
                if (this.erZ != this.mContentView && (this.erZ instanceof ViewGroup)) {
                    ((ViewGroup) this.erZ).removeView(this.mContentView);
                }
                this.erZ = null;
                if (this.esu != null) {
                    this.esu.onDismiss();
                }
            } catch (IllegalArgumentException e) {
                if (this.erZ != this.mContentView && (this.erZ instanceof ViewGroup)) {
                    ((ViewGroup) this.erZ).removeView(this.mContentView);
                }
                this.erZ = null;
                if (this.esu != null) {
                    this.esu.onDismiss();
                }
            } catch (Throwable th) {
                if (this.erZ != this.mContentView && (this.erZ instanceof ViewGroup)) {
                    ((ViewGroup) this.erZ).removeView(this.mContentView);
                }
                this.erZ = null;
                if (this.esu != null) {
                    this.esu.onDismiss();
                }
                throw th;
            }
        }
    }

    public void a(a aVar) {
        this.esu = aVar;
    }

    public void update() {
        boolean z = true;
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.erZ.getLayoutParams();
            boolean z2 = false;
            int bbD = bbD();
            if (bbD != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = bbD;
                z2 = true;
            }
            int lC = lC(layoutParams.flags);
            if (lC != layoutParams.flags) {
                layoutParams.flags = lC;
            } else {
                z = z2;
            }
            if (z) {
                this.mWindowManager.updateViewLayout(this.erZ, layoutParams);
            }
        }
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.esk = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.esl = i4;
            setHeight(i4);
        }
        if (isShowing() && this.mContentView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.erZ.getLayoutParams();
            int i5 = this.mWidthMode < 0 ? this.mWidthMode : this.esk;
            if (i3 != -1 && layoutParams.width != i5) {
                this.esk = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.mHeightMode < 0 ? this.mHeightMode : this.esl;
            if (i4 != -1 && layoutParams.height != i6) {
                this.esl = i6;
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
            int bbD = bbD();
            if (bbD != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = bbD;
                z = true;
            }
            int lC = lC(layoutParams.flags);
            if (lC != layoutParams.flags) {
                layoutParams.flags = lC;
            } else {
                z2 = z;
            }
            if (z2) {
                this.mWindowManager.updateViewLayout(this.erZ, layoutParams);
            }
        }
    }

    private void bbE() {
        WeakReference<View> weakReference = this.esy;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.esz);
        }
        this.esy = null;
    }

    private void i(View view, int i, int i2) {
        bbE();
        this.esy = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.esz);
        }
        this.esA = i;
        this.esB = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.ess) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.esx);
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
            if (PopupWindow.this.esj == null || !PopupWindow.this.esj.onTouch(this, motionEvent)) {
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
