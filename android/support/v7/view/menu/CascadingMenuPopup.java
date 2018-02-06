package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
final class CascadingMenuPopup extends e implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    private final int HO;
    private final int HP;
    private final int HQ;
    private final boolean HR;
    final Handler HS;
    View Ia;
    private boolean Ib;
    private boolean Ic;
    private int Id;
    private boolean If;
    private MenuPresenter.Callback Ig;
    private ViewTreeObserver Ih;
    private PopupWindow.OnDismissListener Ii;
    boolean Ij;
    private final Context mContext;
    private int mYOffset;
    private View oa;
    private final List<MenuBuilder> HU = new LinkedList();
    final List<a> HV = new ArrayList();
    private final ViewTreeObserver.OnGlobalLayoutListener HW = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.CascadingMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.HV.size() > 0 && !CascadingMenuPopup.this.HV.get(0).Ip.isModal()) {
                View view = CascadingMenuPopup.this.Ia;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (a aVar : CascadingMenuPopup.this.HV) {
                    aVar.Ip.show();
                }
            }
        }
    };
    private final MenuItemHoverListener HX = new MenuItemHoverListener() { // from class: android.support.v7.view.menu.CascadingMenuPopup.2
        @Override // android.support.v7.widget.MenuItemHoverListener
        public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.HS.removeCallbacksAndMessages(menuBuilder);
        }

        @Override // android.support.v7.widget.MenuItemHoverListener
        public void onItemHoverEnter(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            int i;
            CascadingMenuPopup.this.HS.removeCallbacksAndMessages(null);
            int i2 = 0;
            int size = CascadingMenuPopup.this.HV.size();
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.HV.get(i2).Dw) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i != -1) {
                int i3 = i + 1;
                final a aVar = i3 < CascadingMenuPopup.this.HV.size() ? CascadingMenuPopup.this.HV.get(i3) : null;
                CascadingMenuPopup.this.HS.postAtTime(new Runnable() { // from class: android.support.v7.view.menu.CascadingMenuPopup.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar != null) {
                            CascadingMenuPopup.this.Ij = true;
                            aVar.Dw.close(false);
                            CascadingMenuPopup.this.Ij = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            menuBuilder.performItemAction(menuItem, 0);
                        }
                    }
                }, menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int HY = 0;
    private int HZ = 0;
    private boolean Ie = false;
    private int mLastPosition = eQ();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(Context context, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.oa = view;
        this.HP = i;
        this.HQ = i2;
        this.HR = z;
        Resources resources = context.getResources();
        this.HO = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.HS = new Handler();
    }

    @Override // android.support.v7.view.menu.e
    public void setForceShowIcon(boolean z) {
        this.Ie = z;
    }

    private MenuPopupWindow eP() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.mContext, null, this.HP, this.HQ);
        menuPopupWindow.setHoverListener(this.HX);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.oa);
        menuPopupWindow.setDropDownGravity(this.HZ);
        menuPopupWindow.setModal(true);
        return menuPopupWindow;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void show() {
        if (!isShowing()) {
            for (MenuBuilder menuBuilder : this.HU) {
                d(menuBuilder);
            }
            this.HU.clear();
            this.Ia = this.oa;
            if (this.Ia != null) {
                boolean z = this.Ih == null;
                this.Ih = this.Ia.getViewTreeObserver();
                if (z) {
                    this.Ih.addOnGlobalLayoutListener(this.HW);
                }
            }
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void dismiss() {
        int size = this.HV.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.HV.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.Ip.isShowing()) {
                    aVar.Ip.dismiss();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    private int eQ() {
        return ViewCompat.getLayoutDirection(this.oa) == 1 ? 0 : 1;
    }

    private int aR(int i) {
        ListView listView = this.HV.get(this.HV.size() - 1).getListView();
        int[] iArr = new int[2];
        listView.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.Ia.getWindowVisibleDisplayFrame(rect);
        if (this.mLastPosition == 1) {
            return (listView.getWidth() + iArr[0]) + i > rect.right ? 0 : 1;
        }
        return iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // android.support.v7.view.menu.e
    public void c(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            d(menuBuilder);
        } else {
            this.HU.add(menuBuilder);
        }
    }

    private void d(MenuBuilder menuBuilder) {
        View view;
        a aVar;
        int i;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.HR);
        if (!isShowing() && this.Ie) {
            menuAdapter.setForceShowIcon(true);
        } else if (isShowing()) {
            menuAdapter.setForceShowIcon(e.f(menuBuilder));
        }
        int a2 = a(menuAdapter, null, this.mContext, this.HO);
        MenuPopupWindow eP = eP();
        eP.setAdapter(menuAdapter);
        eP.setContentWidth(a2);
        eP.setDropDownGravity(this.HZ);
        if (this.HV.size() > 0) {
            a aVar2 = this.HV.get(this.HV.size() - 1);
            view = a(aVar2, menuBuilder);
            aVar = aVar2;
        } else {
            view = null;
            aVar = null;
        }
        if (view != null) {
            eP.setTouchModal(false);
            eP.setEnterTransition(null);
            int aR = aR(a2);
            boolean z = aR == 1;
            this.mLastPosition = aR;
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int horizontalOffset = aVar.Ip.getHorizontalOffset() + iArr[0];
            int verticalOffset = iArr[1] + aVar.Ip.getVerticalOffset();
            if ((this.HZ & 5) == 5) {
                if (z) {
                    i = horizontalOffset + a2;
                } else {
                    i = horizontalOffset - view.getWidth();
                }
            } else if (z) {
                i = view.getWidth() + horizontalOffset;
            } else {
                i = horizontalOffset - a2;
            }
            eP.setHorizontalOffset(i);
            eP.setVerticalOffset(verticalOffset);
        } else {
            if (this.Ib) {
                eP.setHorizontalOffset(this.Id);
            }
            if (this.Ic) {
                eP.setVerticalOffset(this.mYOffset);
            }
            eP.setEpicenterBounds(fb());
        }
        this.HV.add(new a(eP, menuBuilder, this.mLastPosition));
        eP.show();
        if (aVar == null && this.If && menuBuilder.getHeaderTitle() != null) {
            ListView listView = eP.getListView();
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.getHeaderTitle());
            listView.addHeaderView(frameLayout, null, false);
            eP.show();
        }
    }

    private MenuItem a(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, MenuBuilder menuBuilder) {
        MenuAdapter menuAdapter;
        int i;
        int i2;
        int i3 = 0;
        MenuItem a2 = a(aVar.Dw, menuBuilder);
        if (a2 == null) {
            return null;
        }
        ListView listView = aVar.getListView();
        ListAdapter adapter = listView.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i3 >= count) {
                i2 = -1;
                break;
            } else if (a2 == menuAdapter.getItem(i3)) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 == -1) {
            return null;
        }
        int firstVisiblePosition = (i2 + i) - listView.getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= listView.getChildCount()) {
            return null;
        }
        return listView.getChildAt(firstVisiblePosition);
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.HV.size() > 0 && this.HV.get(0).Ip.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.HV.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.HV.get(i);
            if (!aVar.Ip.isShowing()) {
                break;
            }
            i++;
        }
        if (aVar != null) {
            aVar.Dw.close(false);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        for (a aVar : this.HV) {
            a(aVar.getListView().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.Ig = callback;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        for (a aVar : this.HV) {
            if (subMenuBuilder == aVar.Dw) {
                aVar.getListView().requestFocus();
                return true;
            }
        }
        if (subMenuBuilder.hasVisibleItems()) {
            c(subMenuBuilder);
            if (this.Ig != null) {
                this.Ig.onOpenSubMenu(subMenuBuilder);
            }
            return true;
        }
        return false;
    }

    private int e(MenuBuilder menuBuilder) {
        int size = this.HV.size();
        for (int i = 0; i < size; i++) {
            if (menuBuilder == this.HV.get(i).Dw) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int e = e(menuBuilder);
        if (e >= 0) {
            int i = e + 1;
            if (i < this.HV.size()) {
                this.HV.get(i).Dw.close(false);
            }
            a remove = this.HV.remove(e);
            remove.Dw.removeMenuPresenter(this);
            if (this.Ij) {
                remove.Ip.setExitTransition(null);
                remove.Ip.setAnimationStyle(0);
            }
            remove.Ip.dismiss();
            int size = this.HV.size();
            if (size > 0) {
                this.mLastPosition = this.HV.get(size - 1).position;
            } else {
                this.mLastPosition = eQ();
            }
            if (size == 0) {
                dismiss();
                if (this.Ig != null) {
                    this.Ig.onCloseMenu(menuBuilder, true);
                }
                if (this.Ih != null) {
                    if (this.Ih.isAlive()) {
                        this.Ih.removeGlobalOnLayoutListener(this.HW);
                    }
                    this.Ih = null;
                }
                this.Ii.onDismiss();
            } else if (z) {
                this.HV.get(0).Dw.close(false);
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
    public void setGravity(int i) {
        if (this.HY != i) {
            this.HY = i;
            this.HZ = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this.oa));
        }
    }

    @Override // android.support.v7.view.menu.e
    public void setAnchorView(View view) {
        if (this.oa != view) {
            this.oa = view;
            this.HZ = GravityCompat.getAbsoluteGravity(this.HY, ViewCompat.getLayoutDirection(this.oa));
        }
    }

    @Override // android.support.v7.view.menu.e
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.Ii = onDismissListener;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.HV.isEmpty()) {
            return null;
        }
        return this.HV.get(this.HV.size() - 1).getListView();
    }

    @Override // android.support.v7.view.menu.e
    public void setHorizontalOffset(int i) {
        this.Ib = true;
        this.Id = i;
    }

    @Override // android.support.v7.view.menu.e
    public void setVerticalOffset(int i) {
        this.Ic = true;
        this.mYOffset = i;
    }

    @Override // android.support.v7.view.menu.e
    public void setShowTitle(boolean z) {
        this.If = z;
    }

    @Override // android.support.v7.view.menu.e
    protected boolean eR() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        public final MenuBuilder Dw;
        public final MenuPopupWindow Ip;
        public final int position;

        public a(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.Ip = menuPopupWindow;
            this.Dw = menuBuilder;
            this.position = i;
        }

        public ListView getListView() {
            return this.Ip.getListView();
        }
    }
}
