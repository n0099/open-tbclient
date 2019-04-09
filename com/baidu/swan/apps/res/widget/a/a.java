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
/* loaded from: classes2.dex */
public abstract class a {
    protected List<com.baidu.swan.apps.res.widget.a.b> aMK;
    protected d aML;
    protected b.a aMM;
    protected PopupWindow aMN;
    protected View.OnKeyListener aMO;
    private int aMP;
    private InterfaceC0159a aMQ;
    private boolean aMR;
    private float aMS;
    private boolean aMT;
    private int aMU;
    private boolean aMV;
    private View ari;
    protected Context mContext;
    protected Resources mResources;
    protected final View mViewToAttach;

    /* renamed from: com.baidu.swan.apps.res.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0159a {
        void B(List<com.baidu.swan.apps.res.widget.a.b> list);
    }

    /* loaded from: classes2.dex */
    public interface b {
    }

    protected abstract void ensureMenuLoaded(View view, List<com.baidu.swan.apps.res.widget.a.b> list);

    protected abstract View getMenuView(Context context);

    protected abstract void showMenu(PopupWindow popupWindow);

    public View getView() {
        return this.ari;
    }

    public void a(b.a aVar) {
        this.aMM = aVar;
    }

    public void show() {
        if (com.baidu.swan.apps.u.a.CR().Dq() != this.aMV) {
            bT(this.mContext);
            this.aMN = null;
        }
        bX(true);
        this.aMV = com.baidu.swan.apps.u.a.CR().Dq();
    }

    public void dismiss() {
        if (this.aMN != null) {
            try {
                this.aMN.dismiss();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.w("PopupWindow", "Exception", e);
                }
            }
        }
    }

    public void toggle() {
        if (this.aMN != null && this.aMN.isShowing()) {
            dismiss();
        } else {
            show();
        }
    }

    protected void bT(Context context) {
        this.ari = getMenuView(context);
        this.ari.setFocusable(true);
        this.ari.setFocusableInTouchMode(true);
        if (!(this.ari instanceof b)) {
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
        this.ari.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.swan.apps.res.widget.a.a.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && (i == 4 || i == 82)) {
                    a.this.dismiss();
                    if (a.this.aMO != null) {
                        a.this.aMO.onKey(view, i, keyEvent);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    protected void A(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (this.aMQ != null) {
            this.aMQ.B(list);
        }
    }

    private void bX(boolean z) {
        if (this.aML != null) {
            this.aML.onShowMenu();
        }
        A(this.aMK);
        ensureMenuLoaded(this.ari, this.aMK);
        dismiss();
        if (this.aMN == null) {
            this.aMN = new PopupWindow(this.ari, this.aMP, -2, true);
            if (this.aMT) {
                this.aMN.setAnimationStyle(this.aMU);
            }
            if (z) {
                this.aMN.setBackgroundDrawable(this.mResources.getDrawable(a.e.aiapps_pop_transparent_bg));
                this.aMN.setTouchable(true);
            } else {
                this.aMN.setTouchable(false);
            }
            this.aMN.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.swan.apps.res.widget.a.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (a.this.aMR) {
                        a.this.Iz();
                    }
                    if (a.this.aML != null) {
                        a.this.aML.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.aML != null) {
                this.aML.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.aMR) {
                        a.this.ab(a.this.aMS);
                    }
                    a.this.showMenu(a.this.aMN);
                } catch (Exception e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        Log.w("PopupWindow", "Exception", e);
                    }
                }
            }
        });
        this.ari.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(float f) {
        if (this.mViewToAttach != null) {
            ViewGroup viewGroup = (ViewGroup) this.mViewToAttach.getRootView();
            ColorDrawable colorDrawable = new ColorDrawable(ViewCompat.MEASURED_STATE_MASK);
            colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
            colorDrawable.setAlpha((int) (255.0f * f));
            viewGroup.getOverlay().add(colorDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iz() {
        if (this.mViewToAttach != null) {
            ((ViewGroup) this.mViewToAttach.getRootView()).getOverlay().clear();
        }
    }
}
