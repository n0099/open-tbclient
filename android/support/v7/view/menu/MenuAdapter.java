package android.support.v7.view.menu;

import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
@RestrictTo
/* loaded from: classes2.dex */
public class MenuAdapter extends BaseAdapter {
    static final int IC = R.layout.abc_popup_menu_item_layout;
    private final boolean HM;
    private boolean HZ;
    private int IA = -1;
    MenuBuilder IE;
    private final LayoutInflater mInflater;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z) {
        this.HM = z;
        this.mInflater = layoutInflater;
        this.IE = menuBuilder;
        eV();
    }

    public boolean getForceShowIcon() {
        return this.HZ;
    }

    public void setForceShowIcon(boolean z) {
        this.HZ = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> nonActionItems = this.HM ? this.IE.getNonActionItems() : this.IE.getVisibleItems();
        if (this.IA < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.IE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int i) {
        ArrayList<MenuItemImpl> nonActionItems = this.HM ? this.IE.getNonActionItems() : this.IE.getVisibleItems();
        if (this.IA >= 0 && i >= this.IA) {
            i++;
        }
        return nonActionItems.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.mInflater.inflate(IC, viewGroup, false) : view;
        MenuView.ItemView itemView = (MenuView.ItemView) inflate;
        if (this.HZ) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        itemView.initialize(getItem(i), 0);
        return inflate;
    }

    void eV() {
        MenuItemImpl expandedItem = this.IE.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = this.IE.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.IA = i;
                    return;
                }
            }
        }
        this.IA = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        eV();
        super.notifyDataSetChanged();
    }
}
