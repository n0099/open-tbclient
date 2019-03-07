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
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.a.b;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a {
    protected List<com.baidu.swan.apps.res.widget.a.b> aMF;
    protected d aMG;
    protected b.a aMH;
    protected PopupWindow aMI;
    protected View.OnKeyListener aMJ;
    private int aMK;
    private InterfaceC0130a aML;
    private boolean aMM;
    private float aMN;
    private boolean aMO;
    private int aMP;
    private boolean aMQ;
    private View arc;
    protected Context mContext;
    protected Resources mResources;
    protected final View mViewToAttach;

    /* renamed from: com.baidu.swan.apps.res.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0130a {
        void B(List<com.baidu.swan.apps.res.widget.a.b> list);
    }

    /* loaded from: classes2.dex */
    public interface b {
    }

    protected abstract void ensureMenuLoaded(View view, List<com.baidu.swan.apps.res.widget.a.b> list);

    protected abstract View getMenuView(Context context);

    protected abstract void showMenu(PopupWindow popupWindow);

    public View getView() {
        return this.arc;
    }

    public void a(b.a aVar) {
        this.aMH = aVar;
    }

    public void show() {
        if (com.baidu.swan.apps.u.a.CT().Ds() != this.aMQ) {
            bT(this.mContext);
            this.aMI = null;
        }
        bX(true);
        this.aMQ = com.baidu.swan.apps.u.a.CT().Ds();
    }

    public void dismiss() {
        if (this.aMI != null) {
            try {
                this.aMI.dismiss();
            } catch (Exception e) {
                if (com.baidu.swan.apps.c.DEBUG) {
                    Log.w("PopupWindow", "Exception", e);
                }
            }
        }
    }

    public void toggle() {
        if (this.aMI != null && this.aMI.isShowing()) {
            dismiss();
        } else {
            show();
        }
    }

    protected void bT(Context context) {
        this.arc = getMenuView(context);
        this.arc.setFocusable(true);
        this.arc.setFocusableInTouchMode(true);
        if (!(this.arc instanceof b)) {
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
        this.arc.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.swan.apps.res.widget.a.a.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && (i == 4 || i == 82)) {
                    a.this.dismiss();
                    if (a.this.aMJ != null) {
                        a.this.aMJ.onKey(view, i, keyEvent);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    protected void A(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (this.aML != null) {
            this.aML.B(list);
        }
    }

    private void bX(boolean z) {
        if (this.aMG != null) {
            this.aMG.onShowMenu();
        }
        A(this.aMF);
        ensureMenuLoaded(this.arc, this.aMF);
        dismiss();
        if (this.aMI == null) {
            this.aMI = new PopupWindow(this.arc, this.aMK, -2, true);
            if (this.aMO) {
                this.aMI.setAnimationStyle(this.aMP);
            }
            if (z) {
                this.aMI.setBackgroundDrawable(this.mResources.getDrawable(b.e.aiapps_pop_transparent_bg));
                this.aMI.setTouchable(true);
            } else {
                this.aMI.setTouchable(false);
            }
            this.aMI.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.swan.apps.res.widget.a.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (a.this.aMM) {
                        a.this.IB();
                    }
                    if (a.this.aMG != null) {
                        a.this.aMG.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.aMG != null) {
                this.aMG.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.aMM) {
                        a.this.ab(a.this.aMN);
                    }
                    a.this.showMenu(a.this.aMI);
                } catch (Exception e) {
                    if (com.baidu.swan.apps.c.DEBUG) {
                        Log.w("PopupWindow", "Exception", e);
                    }
                }
            }
        });
        this.arc.postInvalidate();
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
    public void IB() {
        if (this.mViewToAttach != null) {
            ((ViewGroup) this.mViewToAttach.getRootView()).getOverlay().clear();
        }
    }
}
