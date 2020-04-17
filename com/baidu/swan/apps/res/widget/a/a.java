package com.baidu.swan.apps.res.widget.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.a.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class a {
    protected d cnu;
    protected b.a cnv;
    private InterfaceC0308a cnw;
    protected Context mContext;
    protected View.OnKeyListener mKeyClickListener;
    private View mMenu;
    protected PopupWindow mPopupWindow;
    protected Resources mResources;
    protected final View mViewToAttach;
    private boolean mDismissOnClick = true;
    private boolean mIsBackgroundDarken = false;
    private float mBgDarkAlpha = 0.5f;
    private boolean mIsHaveAnimation = false;
    private int mPopAnimStyle = a.i.pop_window_anim;
    private Runnable mDismissMenuTask = new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.dismiss();
        }
    };
    protected List<com.baidu.swan.apps.res.widget.a.b> mItems = new ArrayList();
    private int mPopupWindowWidth = -2;
    private boolean mCurrentMode = com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();

    /* renamed from: com.baidu.swan.apps.res.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0308a {
        void onMenuItemUpdated(List<com.baidu.swan.apps.res.widget.a.b> list);
    }

    /* loaded from: classes11.dex */
    public interface b {
    }

    protected abstract void ensureMenuLoaded(View view, List<com.baidu.swan.apps.res.widget.a.b> list);

    protected abstract View getMenuView(Context context);

    protected abstract void showMenu(PopupWindow popupWindow);

    public a(View view) {
        this.mViewToAttach = view;
        this.mContext = this.mViewToAttach.getContext();
        this.mResources = this.mViewToAttach.getResources();
        prepareMenuView(this.mContext);
    }

    public View getView() {
        return this.mMenu;
    }

    public void a(b.a aVar) {
        this.cnv = aVar;
    }

    public void setPopupWindowWidth(int i) {
        this.mPopupWindowWidth = i;
    }

    public com.baidu.swan.apps.res.widget.a.b b(com.baidu.swan.apps.res.widget.a.b bVar) {
        bVar.d(this);
        if (this.mDismissOnClick) {
            bVar.b(new b.a() { // from class: com.baidu.swan.apps.res.widget.a.a.1
                @Override // com.baidu.swan.apps.res.widget.a.b.a
                public void c(com.baidu.swan.apps.res.widget.a.b bVar2) {
                    if (bVar2.isAutoDismiss()) {
                        a.this.dismiss(bVar2.getDismissDelayTime());
                    }
                    if (a.this.cnv != null) {
                        a.this.cnv.c(bVar2);
                    }
                }
            });
        } else {
            bVar.b(this.cnv);
        }
        this.mItems.add(bVar);
        return bVar;
    }

    public com.baidu.swan.apps.res.widget.a.b u(int i, int i2, int i3) {
        return a(i, this.mResources.getString(i2), this.mResources.getDrawable(i3));
    }

    public void show() {
        if (com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState() != this.mCurrentMode) {
            prepareMenuView(this.mContext);
            this.mPopupWindow = null;
        }
        showPopUpWindow(true);
        this.mCurrentMode = com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();
    }

    public void dismiss() {
        if (this.mPopupWindow != null) {
            try {
                this.mPopupWindow.dismiss();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.w("PopupWindow", "Exception", e);
                }
            }
        }
    }

    public void dismiss(long j) {
        if (this.mViewToAttach != null) {
            this.mViewToAttach.removeCallbacks(this.mDismissMenuTask);
            if (j > 0) {
                this.mViewToAttach.postDelayed(this.mDismissMenuTask, j);
            } else {
                dismiss();
            }
        }
    }

    public void toggle() {
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            dismiss();
        } else {
            show();
        }
    }

    protected void prepareMenuView(Context context) {
        this.mMenu = getMenuView(context);
        this.mMenu.setFocusable(true);
        this.mMenu.setFocusableInTouchMode(true);
        if (!(this.mMenu instanceof b)) {
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
        this.mMenu.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.swan.apps.res.widget.a.a.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && (i == 4 || i == 82)) {
                    a.this.dismiss();
                    if (a.this.mKeyClickListener != null) {
                        a.this.mKeyClickListener.onKey(view, i, keyEvent);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBackgroundDarken(boolean z) {
        this.mIsBackgroundDarken = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setHaveAnimation(boolean z) {
        this.mIsHaveAnimation = z;
    }

    protected com.baidu.swan.apps.res.widget.a.b a(int i, CharSequence charSequence, Drawable drawable) {
        return b(new com.baidu.swan.apps.res.widget.a.b(this.mContext, i, charSequence, drawable));
    }

    protected void updateMenuItems(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (this.cnw != null) {
            this.cnw.onMenuItemUpdated(list);
        }
    }

    private void showPopUpWindow(boolean z) {
        if (this.cnu != null) {
            this.cnu.onShowMenu();
        }
        updateMenuItems(this.mItems);
        ensureMenuLoaded(this.mMenu, this.mItems);
        dismiss();
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow(this.mMenu, this.mPopupWindowWidth, -2, true);
            if (this.mIsHaveAnimation) {
                this.mPopupWindow.setAnimationStyle(this.mPopAnimStyle);
            }
            if (z) {
                this.mPopupWindow.setBackgroundDrawable(this.mResources.getDrawable(a.e.aiapps_pop_transparent_bg));
                this.mPopupWindow.setTouchable(true);
            } else {
                this.mPopupWindow.setTouchable(false);
            }
            this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.swan.apps.res.widget.a.a.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (a.this.mIsBackgroundDarken) {
                        a.this.clearBackgroundDarkenStatus();
                    }
                    if (a.this.cnu != null) {
                        a.this.cnu.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.cnu != null) {
                this.cnu.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.mIsBackgroundDarken) {
                        a.this.darkenTheBackground(a.this.mBgDarkAlpha);
                    }
                    a.this.showMenu(a.this.mPopupWindow);
                } catch (Exception e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        Log.w("PopupWindow", "Exception", e);
                    }
                }
            }
        });
        this.mMenu.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void darkenTheBackground(float f) {
        if (this.mViewToAttach != null) {
            ViewGroup viewGroup = (ViewGroup) this.mViewToAttach.getRootView();
            ColorDrawable colorDrawable = new ColorDrawable(ViewCompat.MEASURED_STATE_MASK);
            colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
            colorDrawable.setAlpha((int) (255.0f * f));
            viewGroup.getOverlay().add(colorDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBackgroundDarkenStatus() {
        if (this.mViewToAttach != null) {
            ((ViewGroup) this.mViewToAttach.getRootView()).getOverlay().clear();
        }
    }
}
