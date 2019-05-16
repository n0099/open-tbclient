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
    protected d aOI;
    protected b.a aOJ;
    protected PopupWindow aOK;
    protected View.OnKeyListener aOL;
    private InterfaceC0165a aOO;
    private View arn;
    protected Context mContext;
    protected Resources mResources;
    protected final View mViewToAttach;
    private boolean aON = true;
    private boolean aOP = false;
    private float aOQ = 0.5f;
    private boolean aOR = false;
    private int aOS = a.i.pop_window_anim;
    private Runnable aOU = new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.dismiss();
        }
    };
    protected List<com.baidu.swan.apps.res.widget.a.b> aOH = new ArrayList();
    private int aOM = -2;
    private boolean aOT = com.baidu.swan.apps.u.a.DW().Ev();

    /* renamed from: com.baidu.swan.apps.res.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0165a {
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
        return this.arn;
    }

    public void a(b.a aVar) {
        this.aOJ = aVar;
    }

    public void dz(int i) {
        this.aOM = i;
    }

    public com.baidu.swan.apps.res.widget.a.b b(com.baidu.swan.apps.res.widget.a.b bVar) {
        bVar.d(this);
        if (this.aON) {
            bVar.b(new b.a() { // from class: com.baidu.swan.apps.res.widget.a.a.1
                @Override // com.baidu.swan.apps.res.widget.a.b.a
                public void c(com.baidu.swan.apps.res.widget.a.b bVar2) {
                    if (bVar2.KT()) {
                        a.this.S(bVar2.KU());
                    }
                    if (a.this.aOJ != null) {
                        a.this.aOJ.c(bVar2);
                    }
                }
            });
        } else {
            bVar.b(this.aOJ);
        }
        this.aOH.add(bVar);
        return bVar;
    }

    public com.baidu.swan.apps.res.widget.a.b m(int i, int i2, int i3) {
        return b(i, this.mResources.getString(i2), this.mResources.getDrawable(i3));
    }

    public void show() {
        if (com.baidu.swan.apps.u.a.DW().Ev() != this.aOT) {
            bs(this.mContext);
            this.aOK = null;
        }
        ck(true);
        this.aOT = com.baidu.swan.apps.u.a.DW().Ev();
    }

    public void dismiss() {
        if (this.aOK != null) {
            try {
                this.aOK.dismiss();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.w("PopupWindow", "Exception", e);
                }
            }
        }
    }

    public void S(long j) {
        if (this.mViewToAttach != null) {
            this.mViewToAttach.removeCallbacks(this.aOU);
            if (j > 0) {
                this.mViewToAttach.postDelayed(this.aOU, j);
            } else {
                dismiss();
            }
        }
    }

    public void toggle() {
        if (this.aOK != null && this.aOK.isShowing()) {
            dismiss();
        } else {
            show();
        }
    }

    protected void bs(Context context) {
        this.arn = getMenuView(context);
        this.arn.setFocusable(true);
        this.arn.setFocusableInTouchMode(true);
        if (!(this.arn instanceof b)) {
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
        this.arn.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.swan.apps.res.widget.a.a.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && (i == 4 || i == 82)) {
                    a.this.dismiss();
                    if (a.this.aOL != null) {
                        a.this.aOL.onKey(view, i, keyEvent);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ci(boolean z) {
        this.aOP = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cj(boolean z) {
        this.aOR = z;
    }

    protected com.baidu.swan.apps.res.widget.a.b b(int i, CharSequence charSequence, Drawable drawable) {
        return b(new com.baidu.swan.apps.res.widget.a.b(this.mContext, i, charSequence, drawable));
    }

    protected void B(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (this.aOO != null) {
            this.aOO.C(list);
        }
    }

    private void ck(boolean z) {
        if (this.aOI != null) {
            this.aOI.onShowMenu();
        }
        B(this.aOH);
        ensureMenuLoaded(this.arn, this.aOH);
        dismiss();
        if (this.aOK == null) {
            this.aOK = new PopupWindow(this.arn, this.aOM, -2, true);
            if (this.aOR) {
                this.aOK.setAnimationStyle(this.aOS);
            }
            if (z) {
                this.aOK.setBackgroundDrawable(this.mResources.getDrawable(a.e.aiapps_pop_transparent_bg));
                this.aOK.setTouchable(true);
            } else {
                this.aOK.setTouchable(false);
            }
            this.aOK.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.swan.apps.res.widget.a.a.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (a.this.aOP) {
                        a.this.KS();
                    }
                    if (a.this.aOI != null) {
                        a.this.aOI.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.aOI != null) {
                this.aOI.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.aOP) {
                        a.this.ab(a.this.aOQ);
                    }
                    a.this.showMenu(a.this.aOK);
                } catch (Exception e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        Log.w("PopupWindow", "Exception", e);
                    }
                }
            }
        });
        this.arn.postInvalidate();
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
    public void KS() {
        if (this.mViewToAttach != null) {
            ((ViewGroup) this.mViewToAttach.getRootView()).getOverlay().clear();
        }
    }
}
