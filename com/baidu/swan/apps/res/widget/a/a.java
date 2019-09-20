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
/* loaded from: classes2.dex */
public abstract class a {
    protected d aPQ;
    protected b.a aPR;
    protected PopupWindow aPS;
    protected View.OnKeyListener aPT;
    private InterfaceC0176a aPW;
    private View aso;
    protected Context mContext;
    protected Resources mResources;
    protected final View mViewToAttach;
    private boolean aPV = true;
    private boolean aPX = false;
    private float aPY = 0.5f;
    private boolean aPZ = false;
    private int aQa = a.i.pop_window_anim;
    private Runnable aQc = new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.dismiss();
        }
    };
    protected List<com.baidu.swan.apps.res.widget.a.b> aPP = new ArrayList();
    private int aPU = -2;
    private boolean aQb = com.baidu.swan.apps.u.a.EJ().Fi();

    /* renamed from: com.baidu.swan.apps.res.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0176a {
        void C(List<com.baidu.swan.apps.res.widget.a.b> list);
    }

    /* loaded from: classes2.dex */
    public interface b {
    }

    protected abstract void ensureMenuLoaded(View view, List<com.baidu.swan.apps.res.widget.a.b> list);

    protected abstract View getMenuView(Context context);

    protected abstract void showMenu(PopupWindow popupWindow);

    public a(View view) {
        this.mViewToAttach = view;
        this.mContext = this.mViewToAttach.getContext();
        this.mResources = this.mViewToAttach.getResources();
        bs(this.mContext);
    }

    public View getView() {
        return this.aso;
    }

    public void a(b.a aVar) {
        this.aPR = aVar;
    }

    public void dD(int i) {
        this.aPU = i;
    }

    public com.baidu.swan.apps.res.widget.a.b b(com.baidu.swan.apps.res.widget.a.b bVar) {
        bVar.d(this);
        if (this.aPV) {
            bVar.b(new b.a() { // from class: com.baidu.swan.apps.res.widget.a.a.1
                @Override // com.baidu.swan.apps.res.widget.a.b.a
                public void c(com.baidu.swan.apps.res.widget.a.b bVar2) {
                    if (bVar2.LK()) {
                        a.this.S(bVar2.LL());
                    }
                    if (a.this.aPR != null) {
                        a.this.aPR.c(bVar2);
                    }
                }
            });
        } else {
            bVar.b(this.aPR);
        }
        this.aPP.add(bVar);
        return bVar;
    }

    public com.baidu.swan.apps.res.widget.a.b m(int i, int i2, int i3) {
        return b(i, this.mResources.getString(i2), this.mResources.getDrawable(i3));
    }

    public void show() {
        if (com.baidu.swan.apps.u.a.EJ().Fi() != this.aQb) {
            bs(this.mContext);
            this.aPS = null;
        }
        cn(true);
        this.aQb = com.baidu.swan.apps.u.a.EJ().Fi();
    }

    public void dismiss() {
        if (this.aPS != null) {
            try {
                this.aPS.dismiss();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.w("PopupWindow", "Exception", e);
                }
            }
        }
    }

    public void S(long j) {
        if (this.mViewToAttach != null) {
            this.mViewToAttach.removeCallbacks(this.aQc);
            if (j > 0) {
                this.mViewToAttach.postDelayed(this.aQc, j);
            } else {
                dismiss();
            }
        }
    }

    public void toggle() {
        if (this.aPS != null && this.aPS.isShowing()) {
            dismiss();
        } else {
            show();
        }
    }

    protected void bs(Context context) {
        this.aso = getMenuView(context);
        this.aso.setFocusable(true);
        this.aso.setFocusableInTouchMode(true);
        if (!(this.aso instanceof b)) {
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
        this.aso.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.swan.apps.res.widget.a.a.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && (i == 4 || i == 82)) {
                    a.this.dismiss();
                    if (a.this.aPT != null) {
                        a.this.aPT.onKey(view, i, keyEvent);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cl(boolean z) {
        this.aPX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cm(boolean z) {
        this.aPZ = z;
    }

    protected com.baidu.swan.apps.res.widget.a.b b(int i, CharSequence charSequence, Drawable drawable) {
        return b(new com.baidu.swan.apps.res.widget.a.b(this.mContext, i, charSequence, drawable));
    }

    protected void B(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (this.aPW != null) {
            this.aPW.C(list);
        }
    }

    private void cn(boolean z) {
        if (this.aPQ != null) {
            this.aPQ.onShowMenu();
        }
        B(this.aPP);
        ensureMenuLoaded(this.aso, this.aPP);
        dismiss();
        if (this.aPS == null) {
            this.aPS = new PopupWindow(this.aso, this.aPU, -2, true);
            if (this.aPZ) {
                this.aPS.setAnimationStyle(this.aQa);
            }
            if (z) {
                this.aPS.setBackgroundDrawable(this.mResources.getDrawable(a.e.aiapps_pop_transparent_bg));
                this.aPS.setTouchable(true);
            } else {
                this.aPS.setTouchable(false);
            }
            this.aPS.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.swan.apps.res.widget.a.a.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (a.this.aPX) {
                        a.this.LJ();
                    }
                    if (a.this.aPQ != null) {
                        a.this.aPQ.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.aPQ != null) {
                this.aPQ.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.aPX) {
                        a.this.ab(a.this.aPY);
                    }
                    a.this.showMenu(a.this.aPS);
                } catch (Exception e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        Log.w("PopupWindow", "Exception", e);
                    }
                }
            }
        });
        this.aso.postInvalidate();
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
    public void LJ() {
        if (this.mViewToAttach != null) {
            ((ViewGroup) this.mViewToAttach.getRootView()).getOverlay().clear();
        }
    }
}
