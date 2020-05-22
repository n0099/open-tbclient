package com.baidu.swan.apps.res.widget.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.a.b;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class a {
    protected d czf;
    protected b.a czg;
    private InterfaceC0372a czh;
    private float mBgDarkAlpha;
    protected Context mContext;
    private boolean mCurrentMode;
    private boolean mIsBackgroundDarken;
    private boolean mIsHaveAnimation;
    protected List<com.baidu.swan.apps.res.widget.a.b> mItems;
    protected View.OnKeyListener mKeyClickListener;
    private View mMenu;
    private int mPopAnimStyle;
    protected PopupWindow mPopupWindow;
    private int mPopupWindowWidth;
    protected Resources mResources;
    protected final View mViewToAttach;

    /* renamed from: com.baidu.swan.apps.res.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0372a {
        void onMenuItemUpdated(List<com.baidu.swan.apps.res.widget.a.b> list);
    }

    /* loaded from: classes11.dex */
    public interface b {
    }

    protected abstract void ensureMenuLoaded(View view, List<com.baidu.swan.apps.res.widget.a.b> list);

    protected abstract View getMenuView(Context context);

    protected abstract void showMenu(PopupWindow popupWindow);

    public View getView() {
        return this.mMenu;
    }

    public void a(b.a aVar) {
        this.czg = aVar;
    }

    public void show() {
        if (com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState() != this.mCurrentMode) {
            prepareMenuView(this.mContext);
            this.mPopupWindow = null;
        }
        showPopUpWindow(true);
        this.mCurrentMode = com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState();
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
        this.mMenu.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.swan.apps.res.widget.a.a.1
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

    protected void updateMenuItems(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (this.czh != null) {
            this.czh.onMenuItemUpdated(list);
        }
    }

    private void showPopUpWindow(boolean z) {
        if (this.czf != null) {
            this.czf.onShowMenu();
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
            this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.swan.apps.res.widget.a.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (a.this.mIsBackgroundDarken) {
                        a.this.clearBackgroundDarkenStatus();
                    }
                    if (a.this.czf != null) {
                        a.this.czf.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.czf != null) {
                this.czf.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.3
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
