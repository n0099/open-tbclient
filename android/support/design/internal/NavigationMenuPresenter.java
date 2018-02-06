package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
@RestrictTo
/* loaded from: classes2.dex */
public class NavigationMenuPresenter implements MenuPresenter {
    ColorStateList jX;
    private NavigationMenuView kd;
    LinearLayout ke;
    private MenuPresenter.Callback kf;
    b kg;
    LayoutInflater kh;
    int ki;
    boolean kj;
    ColorStateList kk;
    Drawable kl;
    private int km;
    int kn;
    private int mId;
    MenuBuilder mMenu;
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: android.support.design.internal.NavigationMenuPresenter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            boolean performItemAction = NavigationMenuPresenter.this.mMenu.performItemAction(itemData, NavigationMenuPresenter.this, 0);
            if (itemData != null && itemData.isCheckable() && performItemAction) {
                NavigationMenuPresenter.this.kg.setCheckedItem(itemData);
            }
            NavigationMenuPresenter.this.setUpdateSuspended(false);
            NavigationMenuPresenter.this.updateMenuView(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface d {
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.kh = LayoutInflater.from(context);
        this.mMenu = menuBuilder;
        this.kn = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.kd == null) {
            this.kd = (NavigationMenuView) this.kh.inflate(R.layout.design_navigation_menu, viewGroup, false);
            if (this.kg == null) {
                this.kg = new b();
            }
            this.ke = (LinearLayout) this.kh.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.kd, false);
            this.kd.setAdapter(this.kg);
        }
        return this.kd;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        if (this.kg != null) {
            this.kg.update();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.kf = callback;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.kf != null) {
            this.kf.onCloseMenu(menuBuilder, z);
        }
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

    @Override // android.support.v7.view.menu.MenuPresenter
    public int getId() {
        return this.mId;
    }

    public void setId(int i2) {
        this.mId = i2;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (Build.VERSION.SDK_INT >= 11) {
            Bundle bundle = new Bundle();
            if (this.kd != null) {
                SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
                this.kd.saveHierarchyState(sparseArray);
                bundle.putSparseParcelableArray(ListMenuPresenter.VIEWS_TAG, sparseArray);
            }
            if (this.kg != null) {
                bundle.putBundle("android:menu:adapter", this.kg.aQ());
                return bundle;
            }
            return bundle;
        }
        return null;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(ListMenuPresenter.VIEWS_TAG);
            if (sparseParcelableArray != null) {
                this.kd.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.kg.f(bundle2);
            }
        }
    }

    public void setCheckedItem(MenuItemImpl menuItemImpl) {
        this.kg.setCheckedItem(menuItemImpl);
    }

    public View inflateHeaderView(int i2) {
        View inflate = this.kh.inflate(i2, (ViewGroup) this.ke, false);
        addHeaderView(inflate);
        return inflate;
    }

    public void addHeaderView(View view) {
        this.ke.addView(view);
        this.kd.setPadding(0, 0, 0, this.kd.getPaddingBottom());
    }

    public void removeHeaderView(View view) {
        this.ke.removeView(view);
        if (this.ke.getChildCount() == 0) {
            this.kd.setPadding(0, this.km, 0, this.kd.getPaddingBottom());
        }
    }

    public int getHeaderCount() {
        return this.ke.getChildCount();
    }

    public View getHeaderView(int i2) {
        return this.ke.getChildAt(i2);
    }

    public ColorStateList getItemTintList() {
        return this.jX;
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.jX = colorStateList;
        updateMenuView(false);
    }

    public ColorStateList getItemTextColor() {
        return this.kk;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.kk = colorStateList;
        updateMenuView(false);
    }

    public void setItemTextAppearance(int i2) {
        this.ki = i2;
        this.kj = true;
        updateMenuView(false);
    }

    public Drawable getItemBackground() {
        return this.kl;
    }

    public void setItemBackground(Drawable drawable) {
        this.kl = drawable;
        updateMenuView(false);
    }

    public void setUpdateSuspended(boolean z) {
        if (this.kg != null) {
            this.kg.setUpdateSuspended(z);
        }
    }

    public void dispatchApplyWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.km != systemWindowInsetTop) {
            this.km = systemWindowInsetTop;
            if (this.ke.getChildCount() == 0) {
                this.kd.setPadding(0, this.km, 0, this.kd.getPaddingBottom());
            }
        }
        ViewCompat.dispatchApplyWindowInsets(this.ke, windowInsetsCompat);
    }

    /* loaded from: classes2.dex */
    private static abstract class j extends RecyclerView.ViewHolder {
        public j(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.Adapter<j> {
        private boolean jM;
        private MenuItemImpl kp;
        private final ArrayList<d> mItems = new ArrayList<>();

        b() {
            aP();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mItems.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            d dVar = this.mItems.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                if (((f) dVar).aR().hasSubMenu()) {
                    return 1;
                }
                return 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public j onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new g(NavigationMenuPresenter.this.kh, viewGroup, NavigationMenuPresenter.this.mOnClickListener);
                case 1:
                    return new i(NavigationMenuPresenter.this.kh, viewGroup);
                case 2:
                    return new h(NavigationMenuPresenter.this.kh, viewGroup);
                case 3:
                    return new a(NavigationMenuPresenter.this.ke);
                default:
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(j jVar, int i) {
            switch (getItemViewType(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.itemView;
                    navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.jX);
                    if (NavigationMenuPresenter.this.kj) {
                        navigationMenuItemView.setTextAppearance(NavigationMenuPresenter.this.ki);
                    }
                    if (NavigationMenuPresenter.this.kk != null) {
                        navigationMenuItemView.setTextColor(NavigationMenuPresenter.this.kk);
                    }
                    ViewCompat.setBackground(navigationMenuItemView, NavigationMenuPresenter.this.kl != null ? NavigationMenuPresenter.this.kl.getConstantState().newDrawable() : null);
                    f fVar = (f) this.mItems.get(i);
                    navigationMenuItemView.setNeedsEmptyIcon(fVar.kt);
                    navigationMenuItemView.initialize(fVar.aR(), 0);
                    return;
                case 1:
                    ((TextView) jVar.itemView).setText(((f) this.mItems.get(i)).aR().getTitle());
                    return;
                case 2:
                    e eVar = (e) this.mItems.get(i);
                    jVar.itemView.setPadding(0, eVar.getPaddingTop(), 0, eVar.getPaddingBottom());
                    return;
                default:
                    return;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onViewRecycled(j jVar) {
            if (jVar instanceof g) {
                ((NavigationMenuItemView) jVar.itemView).recycle();
            }
        }

        public void update() {
            aP();
            notifyDataSetChanged();
        }

        private void aP() {
            boolean z;
            int i;
            int i2;
            if (!this.jM) {
                this.jM = true;
                this.mItems.clear();
                this.mItems.add(new c());
                int i3 = -1;
                int i4 = 0;
                boolean z2 = false;
                int size = NavigationMenuPresenter.this.mMenu.getVisibleItems().size();
                int i5 = 0;
                while (i5 < size) {
                    MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.mMenu.getVisibleItems().get(i5);
                    if (menuItemImpl.isChecked()) {
                        setCheckedItem(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.setExclusiveCheckable(false);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenu subMenu = menuItemImpl.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i5 != 0) {
                                this.mItems.add(new e(NavigationMenuPresenter.this.kn, 0));
                            }
                            this.mItems.add(new f(menuItemImpl));
                            boolean z3 = false;
                            int size2 = this.mItems.size();
                            int size3 = subMenu.size();
                            for (int i6 = 0; i6 < size3; i6++) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i6);
                                if (menuItemImpl2.isVisible()) {
                                    if (!z3 && menuItemImpl2.getIcon() != null) {
                                        z3 = true;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.setExclusiveCheckable(false);
                                    }
                                    if (menuItemImpl.isChecked()) {
                                        setCheckedItem(menuItemImpl);
                                    }
                                    this.mItems.add(new f(menuItemImpl2));
                                }
                            }
                            if (z3) {
                                k(size2, this.mItems.size());
                            }
                        }
                        i2 = i3;
                    } else {
                        int groupId = menuItemImpl.getGroupId();
                        if (groupId != i3) {
                            i = this.mItems.size();
                            z = menuItemImpl.getIcon() != null;
                            if (i5 != 0) {
                                i++;
                                this.mItems.add(new e(NavigationMenuPresenter.this.kn, NavigationMenuPresenter.this.kn));
                            }
                        } else if (z2 || menuItemImpl.getIcon() == null) {
                            z = z2;
                            i = i4;
                        } else {
                            z = true;
                            k(i4, this.mItems.size());
                            i = i4;
                        }
                        f fVar = new f(menuItemImpl);
                        fVar.kt = z;
                        this.mItems.add(fVar);
                        z2 = z;
                        i4 = i;
                        i2 = groupId;
                    }
                    i5++;
                    i3 = i2;
                }
                this.jM = false;
            }
        }

        private void k(int i, int i2) {
            while (i < i2) {
                ((f) this.mItems.get(i)).kt = true;
                i++;
            }
        }

        public void setCheckedItem(MenuItemImpl menuItemImpl) {
            if (this.kp != menuItemImpl && menuItemImpl.isCheckable()) {
                if (this.kp != null) {
                    this.kp.setChecked(false);
                }
                this.kp = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        public Bundle aQ() {
            Bundle bundle = new Bundle();
            if (this.kp != null) {
                bundle.putInt("android:menu:checked", this.kp.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            Iterator<d> it = this.mItems.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof f) {
                    MenuItemImpl aR = ((f) next).aR();
                    View actionView = aR != null ? aR.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(aR.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public void f(Bundle bundle) {
            MenuItemImpl aR;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.jM = true;
                Iterator<d> it = this.mItems.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d next = it.next();
                    if ((next instanceof f) && (aR = ((f) next).aR()) != null && aR.getItemId() == i) {
                        setCheckedItem(aR);
                        break;
                    }
                }
                this.jM = false;
                aP();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            Iterator<d> it2 = this.mItems.iterator();
            while (it2.hasNext()) {
                d next2 = it2.next();
                if (next2 instanceof f) {
                    MenuItemImpl aR2 = ((f) next2).aR();
                    View actionView = aR2 != null ? aR2.getActionView() : null;
                    if (actionView != null) {
                        actionView.restoreHierarchyState((SparseArray) sparseParcelableArray.get(aR2.getItemId()));
                    }
                }
            }
        }

        public void setUpdateSuspended(boolean z) {
            this.jM = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f implements d {
        private final MenuItemImpl ks;
        boolean kt;

        f(MenuItemImpl menuItemImpl) {
            this.ks = menuItemImpl;
        }

        public MenuItemImpl aR() {
            return this.ks;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e implements d {
        private final int kq;
        private final int kr;

        public e(int i, int i2) {
            this.kq = i;
            this.kr = i2;
        }

        public int getPaddingTop() {
            return this.kq;
        }

        public int getPaddingBottom() {
            return this.kr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c implements d {
        c() {
        }
    }
}
