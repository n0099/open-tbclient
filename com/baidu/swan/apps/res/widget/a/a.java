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
    protected d biG;
    protected b.a biH;
    private InterfaceC0203a biJ;
    protected Context mContext;
    protected View.OnKeyListener mKeyClickListener;
    private View mMenu;
    protected PopupWindow mPopupWindow;
    protected Resources mResources;
    protected final View mViewToAttach;
    private boolean mDismissOnClick = true;
    private boolean biK = false;
    private float biL = 0.5f;
    private boolean biM = false;
    private int biN = a.i.pop_window_anim;
    private Runnable biP = new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.dismiss();
        }
    };
    protected List<com.baidu.swan.apps.res.widget.a.b> mItems = new ArrayList();
    private int biI = -2;
    private boolean biO = com.baidu.swan.apps.u.a.JE().Kd();

    /* renamed from: com.baidu.swan.apps.res.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0203a {
        void ab(List<com.baidu.swan.apps.res.widget.a.b> list);
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
        prepareMenuView(this.mContext);
    }

    public View getView() {
        return this.mMenu;
    }

    public void a(b.a aVar) {
        this.biH = aVar;
    }

    public void ey(int i) {
        this.biI = i;
    }

    public com.baidu.swan.apps.res.widget.a.b b(com.baidu.swan.apps.res.widget.a.b bVar) {
        bVar.d(this);
        if (this.mDismissOnClick) {
            bVar.b(new b.a() { // from class: com.baidu.swan.apps.res.widget.a.a.1
                @Override // com.baidu.swan.apps.res.widget.a.b.a
                public void c(com.baidu.swan.apps.res.widget.a.b bVar2) {
                    if (bVar2.QE()) {
                        a.this.ak(bVar2.QF());
                    }
                    if (a.this.biH != null) {
                        a.this.biH.c(bVar2);
                    }
                }
            });
        } else {
            bVar.b(this.biH);
        }
        this.mItems.add(bVar);
        return bVar;
    }

    public com.baidu.swan.apps.res.widget.a.b s(int i, int i2, int i3) {
        return a(i, this.mResources.getString(i2), this.mResources.getDrawable(i3));
    }

    public void show() {
        if (com.baidu.swan.apps.u.a.JE().Kd() != this.biO) {
            prepareMenuView(this.mContext);
            this.mPopupWindow = null;
        }
        cE(true);
        this.biO = com.baidu.swan.apps.u.a.JE().Kd();
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

    public void ak(long j) {
        if (this.mViewToAttach != null) {
            this.mViewToAttach.removeCallbacks(this.biP);
            if (j > 0) {
                this.mViewToAttach.postDelayed(this.biP, j);
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
    public void cC(boolean z) {
        this.biK = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cD(boolean z) {
        this.biM = z;
    }

    protected com.baidu.swan.apps.res.widget.a.b a(int i, CharSequence charSequence, Drawable drawable) {
        return b(new com.baidu.swan.apps.res.widget.a.b(this.mContext, i, charSequence, drawable));
    }

    protected void aa(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (this.biJ != null) {
            this.biJ.ab(list);
        }
    }

    private void cE(boolean z) {
        if (this.biG != null) {
            this.biG.onShowMenu();
        }
        aa(this.mItems);
        ensureMenuLoaded(this.mMenu, this.mItems);
        dismiss();
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow(this.mMenu, this.biI, -2, true);
            if (this.biM) {
                this.mPopupWindow.setAnimationStyle(this.biN);
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
                    if (a.this.biK) {
                        a.this.QD();
                    }
                    if (a.this.biG != null) {
                        a.this.biG.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.biG != null) {
                this.biG.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.biK) {
                        a.this.Q(a.this.biL);
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
    public void Q(float f) {
        if (this.mViewToAttach != null) {
            ViewGroup viewGroup = (ViewGroup) this.mViewToAttach.getRootView();
            ColorDrawable colorDrawable = new ColorDrawable(ViewCompat.MEASURED_STATE_MASK);
            colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
            colorDrawable.setAlpha((int) (255.0f * f));
            viewGroup.getOverlay().add(colorDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QD() {
        if (this.mViewToAttach != null) {
            ((ViewGroup) this.mViewToAttach.getRootView()).getOverlay().clear();
        }
    }
}
