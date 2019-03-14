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
    protected List<com.baidu.swan.apps.res.widget.a.b> aMG;
    protected d aMH;
    protected b.a aMI;
    protected PopupWindow aMJ;
    protected View.OnKeyListener aMK;
    private int aML;
    private InterfaceC0159a aMM;
    private boolean aMN;
    private float aMO;
    private boolean aMP;
    private int aMQ;
    private boolean aMR;
    private View ard;
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
        return this.ard;
    }

    public void a(b.a aVar) {
        this.aMI = aVar;
    }

    public void show() {
        if (com.baidu.swan.apps.u.a.CT().Ds() != this.aMR) {
            bT(this.mContext);
            this.aMJ = null;
        }
        bX(true);
        this.aMR = com.baidu.swan.apps.u.a.CT().Ds();
    }

    public void dismiss() {
        if (this.aMJ != null) {
            try {
                this.aMJ.dismiss();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.w("PopupWindow", "Exception", e);
                }
            }
        }
    }

    public void toggle() {
        if (this.aMJ != null && this.aMJ.isShowing()) {
            dismiss();
        } else {
            show();
        }
    }

    protected void bT(Context context) {
        this.ard = getMenuView(context);
        this.ard.setFocusable(true);
        this.ard.setFocusableInTouchMode(true);
        if (!(this.ard instanceof b)) {
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
        this.ard.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.swan.apps.res.widget.a.a.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && (i == 4 || i == 82)) {
                    a.this.dismiss();
                    if (a.this.aMK != null) {
                        a.this.aMK.onKey(view, i, keyEvent);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    protected void A(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (this.aMM != null) {
            this.aMM.B(list);
        }
    }

    private void bX(boolean z) {
        if (this.aMH != null) {
            this.aMH.onShowMenu();
        }
        A(this.aMG);
        ensureMenuLoaded(this.ard, this.aMG);
        dismiss();
        if (this.aMJ == null) {
            this.aMJ = new PopupWindow(this.ard, this.aML, -2, true);
            if (this.aMP) {
                this.aMJ.setAnimationStyle(this.aMQ);
            }
            if (z) {
                this.aMJ.setBackgroundDrawable(this.mResources.getDrawable(a.e.aiapps_pop_transparent_bg));
                this.aMJ.setTouchable(true);
            } else {
                this.aMJ.setTouchable(false);
            }
            this.aMJ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.swan.apps.res.widget.a.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (a.this.aMN) {
                        a.this.IB();
                    }
                    if (a.this.aMH != null) {
                        a.this.aMH.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.aMH != null) {
                this.aMH.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.aMN) {
                        a.this.ab(a.this.aMO);
                    }
                    a.this.showMenu(a.this.aMJ);
                } catch (Exception e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        Log.w("PopupWindow", "Exception", e);
                    }
                }
            }
        });
        this.ard.postInvalidate();
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
