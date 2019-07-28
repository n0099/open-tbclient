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
    protected d aPs;
    protected b.a aPt;
    protected PopupWindow aPu;
    protected View.OnKeyListener aPv;
    private InterfaceC0167a aPy;
    private View arQ;
    protected Context mContext;
    protected Resources mResources;
    protected final View mViewToAttach;
    private boolean aPx = true;
    private boolean aPz = false;
    private float aPA = 0.5f;
    private boolean aPB = false;
    private int aPC = a.i.pop_window_anim;
    private Runnable aPE = new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.dismiss();
        }
    };
    protected List<com.baidu.swan.apps.res.widget.a.b> aPr = new ArrayList();
    private int aPw = -2;
    private boolean aPD = com.baidu.swan.apps.u.a.EF().Fe();

    /* renamed from: com.baidu.swan.apps.res.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0167a {
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
        return this.arQ;
    }

    public void a(b.a aVar) {
        this.aPt = aVar;
    }

    public void dC(int i) {
        this.aPw = i;
    }

    public com.baidu.swan.apps.res.widget.a.b b(com.baidu.swan.apps.res.widget.a.b bVar) {
        bVar.d(this);
        if (this.aPx) {
            bVar.b(new b.a() { // from class: com.baidu.swan.apps.res.widget.a.a.1
                @Override // com.baidu.swan.apps.res.widget.a.b.a
                public void c(com.baidu.swan.apps.res.widget.a.b bVar2) {
                    if (bVar2.LG()) {
                        a.this.S(bVar2.LH());
                    }
                    if (a.this.aPt != null) {
                        a.this.aPt.c(bVar2);
                    }
                }
            });
        } else {
            bVar.b(this.aPt);
        }
        this.aPr.add(bVar);
        return bVar;
    }

    public com.baidu.swan.apps.res.widget.a.b m(int i, int i2, int i3) {
        return b(i, this.mResources.getString(i2), this.mResources.getDrawable(i3));
    }

    public void show() {
        if (com.baidu.swan.apps.u.a.EF().Fe() != this.aPD) {
            bs(this.mContext);
            this.aPu = null;
        }
        cn(true);
        this.aPD = com.baidu.swan.apps.u.a.EF().Fe();
    }

    public void dismiss() {
        if (this.aPu != null) {
            try {
                this.aPu.dismiss();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.w("PopupWindow", "Exception", e);
                }
            }
        }
    }

    public void S(long j) {
        if (this.mViewToAttach != null) {
            this.mViewToAttach.removeCallbacks(this.aPE);
            if (j > 0) {
                this.mViewToAttach.postDelayed(this.aPE, j);
            } else {
                dismiss();
            }
        }
    }

    public void toggle() {
        if (this.aPu != null && this.aPu.isShowing()) {
            dismiss();
        } else {
            show();
        }
    }

    protected void bs(Context context) {
        this.arQ = getMenuView(context);
        this.arQ.setFocusable(true);
        this.arQ.setFocusableInTouchMode(true);
        if (!(this.arQ instanceof b)) {
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
        this.arQ.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.swan.apps.res.widget.a.a.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && (i == 4 || i == 82)) {
                    a.this.dismiss();
                    if (a.this.aPv != null) {
                        a.this.aPv.onKey(view, i, keyEvent);
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
        this.aPz = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cm(boolean z) {
        this.aPB = z;
    }

    protected com.baidu.swan.apps.res.widget.a.b b(int i, CharSequence charSequence, Drawable drawable) {
        return b(new com.baidu.swan.apps.res.widget.a.b(this.mContext, i, charSequence, drawable));
    }

    protected void B(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (this.aPy != null) {
            this.aPy.C(list);
        }
    }

    private void cn(boolean z) {
        if (this.aPs != null) {
            this.aPs.onShowMenu();
        }
        B(this.aPr);
        ensureMenuLoaded(this.arQ, this.aPr);
        dismiss();
        if (this.aPu == null) {
            this.aPu = new PopupWindow(this.arQ, this.aPw, -2, true);
            if (this.aPB) {
                this.aPu.setAnimationStyle(this.aPC);
            }
            if (z) {
                this.aPu.setBackgroundDrawable(this.mResources.getDrawable(a.e.aiapps_pop_transparent_bg));
                this.aPu.setTouchable(true);
            } else {
                this.aPu.setTouchable(false);
            }
            this.aPu.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.swan.apps.res.widget.a.a.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (a.this.aPz) {
                        a.this.LF();
                    }
                    if (a.this.aPs != null) {
                        a.this.aPs.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.aPs != null) {
                this.aPs.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.aPz) {
                        a.this.ab(a.this.aPA);
                    }
                    a.this.showMenu(a.this.aPu);
                } catch (Exception e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        Log.w("PopupWindow", "Exception", e);
                    }
                }
            }
        });
        this.arQ.postInvalidate();
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
    public void LF() {
        if (this.mViewToAttach != null) {
            ((ViewGroup) this.mViewToAttach.getRootView()).getOverlay().clear();
        }
    }
}
