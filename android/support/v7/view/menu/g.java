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
    private final int HQ;
    private final int HR;
    private final boolean HS;
    private final ViewTreeObserver.OnGlobalLayoutListener HX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.g.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (g.this.isShowing() && !g.this.JJ.isModal()) {
                View view = g.this.Ib;
                if (view == null || !view.isShown()) {
                    g.this.dismiss();
                } else {
                    g.this.JJ.show();
                }
            }
        }
    };
    private int Ia = 0;
    View Ib;
    private boolean Ig;
    private MenuPresenter.Callback Ih;
    private ViewTreeObserver Ii;
    private PopupWindow.OnDismissListener Ij;
    private final MenuAdapter JH;
    private final int JI;
    final MenuPopupWindow JJ;
    private boolean JK;
    private boolean JL;
    private int JM;
    private final Context mContext;
    private final MenuBuilder mMenu;
    private View oa;

    public g(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.HS = z;
        this.JH = new MenuAdapter(menuBuilder, LayoutInflater.from(context), this.HS);
        this.HQ = i;
        this.HR = i2;
        Resources resources = context.getResources();
        this.JI = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.oa = view;
        this.JJ = new MenuPopupWindow(this.mContext, null, this.HQ, this.HR);
        menuBuilder.addMenuPresenter(this, context);
    }

    @Override // android.support.v7.view.menu.e
    public void setForceShowIcon(boolean z) {
        this.JH.setForceShowIcon(z);
    }

    @Override // android.support.v7.view.menu.e
    public void setGravity(int i) {
        this.Ia = i;
    }

    private boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.JK || this.oa == null) {
            return false;
        }
        this.Ib = this.oa;
        this.JJ.setOnDismissListener(this);
        this.JJ.setOnItemClickListener(this);
        this.JJ.setModal(true);
        View view = this.Ib;
        boolean z = this.Ii == null;
        this.Ii = view.getViewTreeObserver();
        if (z) {
            this.Ii.addOnGlobalLayoutListener(this.HX);
        }
        this.JJ.setAnchorView(view);
        this.JJ.setDropDownGravity(this.Ia);
        if (!this.JL) {
            this.JM = a(this.JH, null, this.mContext, this.JI);
            this.JL = true;
        }
        this.JJ.setContentWidth(this.JM);
        this.JJ.setInputMethodMode(2);
        this.JJ.setEpicenterBounds(fb());
        this.JJ.show();
        ListView listView = this.JJ.getListView();
        listView.setOnKeyListener(this);
        if (this.Ig && this.mMenu.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.mMenu.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, null, false);
        }
        this.JJ.setAdapter(this.JH);
        this.JJ.show();
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
            this.JJ.dismiss();
        }
    }

    @Override // android.support.v7.view.menu.e
    public void c(MenuBuilder menuBuilder) {
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public boolean isShowing() {
        return !this.JK && this.JJ.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.JK = true;
        this.mMenu.close();
        if (this.Ii != null) {
            if (!this.Ii.isAlive()) {
                this.Ii = this.Ib.getViewTreeObserver();
            }
            this.Ii.removeGlobalOnLayoutListener(this.HX);
            this.Ii = null;
        }
        if (this.Ij != null) {
            this.Ij.onDismiss();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        this.JL = false;
        if (this.JH != null) {
            this.JH.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.Ih = callback;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.mContext, subMenuBuilder, this.Ib, this.HS, this.HQ, this.HR);
            menuPopupHelper.setPresenterCallback(this.Ih);
            menuPopupHelper.setForceShowIcon(e.f(subMenuBuilder));
            menuPopupHelper.setOnDismissListener(this.Ij);
            this.Ij = null;
            this.mMenu.close(false);
            if (menuPopupHelper.tryShow(this.JJ.getHorizontalOffset(), this.JJ.getVerticalOffset())) {
                if (this.Ih != null) {
                    this.Ih.onOpenSubMenu(subMenuBuilder);
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
            if (this.Ih != null) {
                this.Ih.onCloseMenu(menuBuilder, z);
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
        this.Ij = onDismissListener;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.JJ.getListView();
    }

    @Override // android.support.v7.view.menu.e
    public void setHorizontalOffset(int i) {
        this.JJ.setHorizontalOffset(i);
    }

    @Override // android.support.v7.view.menu.e
    public void setVerticalOffset(int i) {
        this.JJ.setVerticalOffset(i);
    }

    @Override // android.support.v7.view.menu.e
    public void setShowTitle(boolean z) {
        this.Ig = z;
    }
}
