package com.baidu.swan.apps.res.widget.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.a.b;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class a {
    private float dFA;
    private boolean dFB;
    private int dFC;
    private boolean dFD;
    protected d dFv;
    protected b.a dFw;
    private int dFx;
    private InterfaceC0468a dFy;
    private boolean dFz;
    protected Context mContext;
    protected List<com.baidu.swan.apps.res.widget.a.b> mItems;
    protected View.OnKeyListener mKeyClickListener;
    private View mMenu;
    protected PopupWindow mPopupWindow;
    protected Resources mResources;
    protected final View mViewToAttach;

    /* renamed from: com.baidu.swan.apps.res.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0468a {
        void aX(List<com.baidu.swan.apps.res.widget.a.b> list);
    }

    /* loaded from: classes9.dex */
    public interface b {
    }

    protected abstract void ensureMenuLoaded(View view, List<com.baidu.swan.apps.res.widget.a.b> list);

    protected abstract View getMenuView(Context context);

    protected abstract void showMenu(PopupWindow popupWindow);

    public View getView() {
        return this.mMenu;
    }

    public void a(b.a aVar) {
        this.dFw = aVar;
    }

    public void show() {
        if (com.baidu.swan.apps.t.a.aAN().alD() != this.dFD) {
            prepareMenuView(this.mContext);
            this.mPopupWindow = null;
        }
        hd(true);
        this.dFD = com.baidu.swan.apps.t.a.aAN().alD();
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

    protected void aW(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (this.dFy != null) {
            this.dFy.aX(list);
        }
    }

    private void hd(boolean z) {
        if (this.dFv != null) {
            this.dFv.onShowMenu();
        }
        aW(this.mItems);
        ensureMenuLoaded(this.mMenu, this.mItems);
        dismiss();
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow(this.mMenu, this.dFx, -2, true);
            if (this.dFB) {
                this.mPopupWindow.setAnimationStyle(this.dFC);
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
                    if (a.this.dFz) {
                        a.this.aLI();
                    }
                    if (a.this.dFv != null) {
                        a.this.dFv.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.dFv != null) {
                this.dFv.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.dFz) {
                        a.this.N(a.this.dFA);
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
    public void N(float f) {
        if (this.mViewToAttach != null) {
            ViewGroup viewGroup = (ViewGroup) this.mViewToAttach.getRootView();
            ColorDrawable colorDrawable = new ColorDrawable(ViewCompat.MEASURED_STATE_MASK);
            colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
            colorDrawable.setAlpha((int) (255.0f * f));
            viewGroup.getOverlay().add(colorDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLI() {
        if (this.mViewToAttach != null) {
            ((ViewGroup) this.mViewToAttach.getRootView()).getOverlay().clear();
        }
    }
}
