package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
/* loaded from: classes2.dex */
final class g extends e implements MenuPresenter, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    private final int HK;
    private final int HL;
    private final boolean HM;
    private final ViewTreeObserver.OnGlobalLayoutListener HQ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.g.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (g.this.isShowing() && !g.this.JD.isModal()) {
                View view = g.this.HV;
                if (view == null || !view.isShown()) {
                    g.this.dismiss();
                } else {
                    g.this.JD.show();
                }
            }
        }
    };
    private int HU = 0;
    View HV;
    private boolean Ia;
    private MenuPresenter.Callback Ib;
    private ViewTreeObserver Ic;
    private PopupWindow.OnDismissListener Id;
    private final MenuAdapter JB;
    private final int JC;
    final MenuPopupWindow JD;
    private boolean JE;
    private boolean JF;
    private int JG;
    private final Context mContext;
    private final MenuBuilder mMenu;
    private View oa;

    public g(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.HM = z;
        this.JB = new MenuAdapter(menuBuilder, LayoutInflater.from(context), this.HM);
        this.HK = i;
        this.HL = i2;
        Resources resources = context.getResources();
        this.JC = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.oa = view;
        this.JD = new MenuPopupWindow(this.mContext, null, this.HK, this.HL);
        menuBuilder.addMenuPresenter(this, context);
    }

    @Override // android.support.v7.view.menu.e
    public void setForceShowIcon(boolean z) {
        this.JB.setForceShowIcon(z);
    }

    @Override // android.support.v7.view.menu.e
    public void setGravity(int i) {
        this.HU = i;
    }

    private boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.JE || this.oa == null) {
            return false;
        }
        this.HV = this.oa;
        this.JD.setOnDismissListener(this);
        this.JD.setOnItemClickListener(this);
        this.JD.setModal(true);
        View view = this.HV;
        boolean z = this.Ic == null;
        this.Ic = view.getViewTreeObserver();
        if (z) {
            this.Ic.addOnGlobalLayoutListener(this.HQ);
        }
        this.JD.setAnchorView(view);
        this.JD.setDropDownGravity(this.HU);
        if (!this.JF) {
            this.JG = a(this.JB, null, this.mContext, this.JC);
            this.JF = true;
        }
        this.JD.setContentWidth(this.JG);
        this.JD.setInputMethodMode(2);
        this.JD.setEpicenterBounds(fb());
        this.JD.show();
        ListView listView = this.JD.getListView();
        listView.setOnKeyListener(this);
        if (this.Ia && this.mMenu.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.mMenu.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, null, false);
        }
        this.JD.setAdapter(this.JB);
        this.JD.show();
        return true;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void dismiss() {
        if (isShowing()) {
            this.JD.dismiss();
        }
    }

    @Override // android.support.v7.view.menu.e
    public void c(MenuBuilder menuBuilder) {
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public boolean isShowing() {
        return !this.JE && this.JD.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.JE = true;
        this.mMenu.close();
        if (this.Ic != null) {
            if (!this.Ic.isAlive()) {
                this.Ic = this.HV.getViewTreeObserver();
            }
            this.Ic.removeGlobalOnLayoutListener(this.HQ);
            this.Ic = null;
        }
        if (this.Id != null) {
            this.Id.onDismiss();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        this.JF = false;
        if (this.JB != null) {
            this.JB.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.Ib = callback;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.mContext, subMenuBuilder, this.HV, this.HM, this.HK, this.HL);
            menuPopupHelper.setPresenterCallback(this.Ib);
            menuPopupHelper.setForceShowIcon(e.f(subMenuBuilder));
            menuPopupHelper.setOnDismissListener(this.Id);
            this.Id = null;
            this.mMenu.close(false);
            if (menuPopupHelper.tryShow(this.JD.getHorizontalOffset(), this.JD.getVerticalOffset())) {
                if (this.Ib != null) {
                    this.Ib.onOpenSubMenu(subMenuBuilder);
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.mMenu) {
            dismiss();
            if (this.Ib != null) {
                this.Ib.onCloseMenu(menuBuilder, z);
            }
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // android.support.v7.view.menu.e
    public void setAnchorView(View view) {
        this.oa = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.support.v7.view.menu.e
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.Id = onDismissListener;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.JD.getListView();
    }

    @Override // android.support.v7.view.menu.e
    public void setHorizontalOffset(int i) {
        this.JD.setHorizontalOffset(i);
    }

    @Override // android.support.v7.view.menu.e
    public void setVerticalOffset(int i) {
        this.JD.setVerticalOffset(i);
    }

    @Override // android.support.v7.view.menu.e
    public void setShowTitle(boolean z) {
        this.Ia = z;
    }
}
