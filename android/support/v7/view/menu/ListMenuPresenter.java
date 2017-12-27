package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;
@RestrictTo
/* loaded from: classes2.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    public static final String VIEWS_TAG = "android:menu:list";
    int HL;
    ExpandedMenuView IC;
    int IE;
    int IF;
    a IG;
    private MenuPresenter.Callback kf;
    Context mContext;
    private int mId;
    LayoutInflater mInflater;
    MenuBuilder mMenu;

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    public ListMenuPresenter(int i, int i2) {
        this.HL = i;
        this.IF = i2;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.IF != 0) {
            this.mContext = new ContextThemeWrapper(context, this.IF);
            this.mInflater = LayoutInflater.from(this.mContext);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(this.mContext);
            }
        }
        this.mMenu = menuBuilder;
        if (this.IG != null) {
            this.IG.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.IC == null) {
            this.IC = (ExpandedMenuView) this.mInflater.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.IG == null) {
                this.IG = new a();
            }
            this.IC.setAdapter((ListAdapter) this.IG);
            this.IC.setOnItemClickListener(this);
        }
        return this.IC;
    }

    public ListAdapter getAdapter() {
        if (this.IG == null) {
            this.IG = new a();
        }
        return this.IG;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        if (this.IG != null) {
            this.IG.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.kf = callback;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            new c(subMenuBuilder).b(null);
            if (this.kf != null) {
                this.kf.onOpenSubMenu(subMenuBuilder);
            }
            return true;
        }
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.kf != null) {
            this.kf.onCloseMenu(menuBuilder, z);
        }
    }

    public void setItemIndexOffset(int i) {
        this.IE = i;
        if (this.IC != null) {
            updateMenuView(false);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mMenu.performItemAction(this.IG.getItem(i), this, 0);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        if (this.IC != null) {
            this.IC.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.IC.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void setId(int i) {
        this.mId = i;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public int getId() {
        return this.mId;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (this.IC == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private int IH = -1;

        public a() {
            eV();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ListMenuPresenter.this.mMenu.getNonActionItems().size() - ListMenuPresenter.this.IE;
            return this.IH < 0 ? size : size - 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.mMenu.getNonActionItems();
            int i2 = ListMenuPresenter.this.IE + i;
            if (this.IH >= 0 && i2 >= this.IH) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? ListMenuPresenter.this.mInflater.inflate(ListMenuPresenter.this.HL, viewGroup, false) : view;
            ((MenuView.ItemView) inflate).initialize(getItem(i), 0);
            return inflate;
        }

        void eV() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.mMenu.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.mMenu.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.IH = i;
                        return;
                    }
                }
            }
            this.IH = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            eV();
            super.notifyDataSetChanged();
        }
    }
}
