package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.GravityCompat;
import android.support.v7.appcompat.R;
import android.support.v7.transition.ActionBarTransition;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    d KK;
    private Drawable KL;
    private boolean KM;
    private boolean KN;
    private boolean KO;
    private int KP;
    private int KQ;
    private int KR;
    private boolean KS;
    private boolean KT;
    private boolean KU;
    private boolean KV;
    private int KW;
    private final SparseBooleanArray KX;
    private View KY;
    e KZ;
    a La;
    c Lb;
    private b Lc;
    final f Ld;
    int Le;

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.KX = new SparseBooleanArray();
        this.Ld = new f();
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.KO) {
            this.KN = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.KU) {
            this.KP = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.KS) {
            this.KR = actionBarPolicy.getMaxActionButtons();
        }
        int i = this.KP;
        if (this.KN) {
            if (this.KK == null) {
                this.KK = new d(this.mSystemContext);
                if (this.KM) {
                    this.KK.setImageDrawable(this.KL);
                    this.KL = null;
                    this.KM = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.KK.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.KK.getMeasuredWidth();
        } else {
            this.KK = null;
        }
        this.KQ = i;
        this.KW = (int) (56.0f * resources.getDisplayMetrics().density);
        this.KY = null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.KS) {
            this.KR = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
        }
        if (this.mMenu != null) {
            this.mMenu.onItemsChanged(true);
        }
    }

    public void F(boolean z) {
        this.KN = z;
        this.KO = true;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.KV = z;
    }

    public void setOverflowIcon(Drawable drawable) {
        if (this.KK != null) {
            this.KK.setImageDrawable(drawable);
            return;
        }
        this.KM = true;
        this.KL = drawable;
    }

    public Drawable getOverflowIcon() {
        if (this.KK != null) {
            return this.KK.getDrawable();
        }
        if (this.KM) {
            return this.KL;
        }
        return null;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.mMenuView;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.Lc == null) {
            this.Lc = new b();
        }
        actionMenuItemView.setPopupCallback(this.Lc);
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        boolean z2 = false;
        ViewGroup viewGroup = (ViewGroup) ((View) this.mMenuView).getParent();
        if (viewGroup != null) {
            ActionBarTransition.beginDelayedTransition(viewGroup);
        }
        super.updateMenuView(z);
        ((View) this.mMenuView).requestLayout();
        if (this.mMenu != null) {
            ArrayList<MenuItemImpl> actionItems = this.mMenu.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList<MenuItemImpl> nonActionItems = this.mMenu != null ? this.mMenu.getNonActionItems() : null;
        if (this.KN && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else {
                z2 = size2 > 0;
            }
        }
        if (z2) {
            if (this.KK == null) {
                this.KK = new d(this.mSystemContext);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.KK.getParent();
            if (viewGroup2 != this.mMenuView) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.KK);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.KK, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else if (this.KK != null && this.KK.getParent() == this.mMenuView) {
            ((ViewGroup) this.mMenuView).removeView(this.KK);
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.KN);
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.KK) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z;
        if (subMenuBuilder.hasVisibleItems()) {
            SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
            while (subMenuBuilder2.getParentMenu() != this.mMenu) {
                subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
            }
            View d2 = d(subMenuBuilder2.getItem());
            if (d2 != null) {
                this.Le = subMenuBuilder.getItem().getItemId();
                int size = subMenuBuilder.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = subMenuBuilder.getItem(i);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i++;
                }
                this.La = new a(this.mContext, subMenuBuilder, d2);
                this.La.setForceShowIcon(z);
                this.La.show();
                super.onSubMenuSelected(subMenuBuilder);
                return true;
            }
            return false;
        }
        return false;
    }

    private View d(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean showOverflowMenu() {
        if (!this.KN || isOverflowMenuShowing() || this.mMenu == null || this.mMenuView == null || this.Lb != null || this.mMenu.getNonActionItems().isEmpty()) {
            return false;
        }
        this.Lb = new c(new e(this.mContext, this.mMenu, this.KK, true));
        ((View) this.mMenuView).post(this.Lb);
        super.onSubMenuSelected(null);
        return true;
    }

    public boolean hideOverflowMenu() {
        if (this.Lb != null && this.mMenuView != null) {
            ((View) this.mMenuView).removeCallbacks(this.Lb);
            this.Lb = null;
            return true;
        }
        e eVar = this.KZ;
        if (eVar != null) {
            eVar.dismiss();
            return true;
        }
        return false;
    }

    public boolean fl() {
        return hideOverflowMenu() | fm();
    }

    public boolean fm() {
        if (this.La != null) {
            this.La.dismiss();
            return true;
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        return this.KZ != null && this.KZ.isShowing();
    }

    public boolean isOverflowMenuShowPending() {
        return this.Lb != null || isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        return this.KN;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public boolean flagActionItems() {
        int i;
        ArrayList<MenuItemImpl> arrayList;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        if (this.mMenu != null) {
            ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
            i = visibleItems.size();
            arrayList = visibleItems;
        } else {
            i = 0;
            arrayList = null;
        }
        int i10 = this.KR;
        int i11 = this.KQ;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        int i12 = 0;
        int i13 = 0;
        boolean z3 = false;
        int i14 = 0;
        while (i14 < i) {
            MenuItemImpl menuItemImpl = arrayList.get(i14);
            if (menuItemImpl.requiresActionButton()) {
                i12++;
            } else if (menuItemImpl.requestsActionButton()) {
                i13++;
            } else {
                z3 = true;
            }
            i14++;
            i10 = (this.KV && menuItemImpl.isActionViewExpanded()) ? 0 : i10;
        }
        if (this.KN && (z3 || i12 + i13 > i10)) {
            i10--;
        }
        int i15 = i10 - i12;
        SparseBooleanArray sparseBooleanArray = this.KX;
        sparseBooleanArray.clear();
        int i16 = 0;
        if (!this.KT) {
            i2 = 0;
        } else {
            i16 = i11 / this.KW;
            i2 = ((i11 % this.KW) / i16) + this.KW;
        }
        int i17 = 0;
        int i18 = 0;
        int i19 = i16;
        while (i17 < i) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i17);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = getItemView(menuItemImpl2, this.KY, viewGroup);
                if (this.KY == null) {
                    this.KY = itemView;
                }
                if (this.KT) {
                    i19 -= ActionMenuView.b(itemView, i2, i19, makeMeasureSpec, 0);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i3 = itemView.getMeasuredWidth();
                int i20 = i11 - i3;
                if (i18 != 0) {
                    i3 = i18;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                i4 = i20;
                i5 = i15;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i15 > 0 || z4) && i11 > 0 && (!this.KT || i19 > 0);
                if (z5) {
                    View itemView2 = getItemView(menuItemImpl2, this.KY, viewGroup);
                    if (this.KY == null) {
                        this.KY = itemView2;
                    }
                    if (this.KT) {
                        int b2 = ActionMenuView.b(itemView2, i2, i19, makeMeasureSpec, 0);
                        int i21 = i19 - b2;
                        z2 = b2 == 0 ? false : z5;
                        i9 = i21;
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z6 = z5;
                        i9 = i19;
                        z2 = z6;
                    }
                    int measuredWidth = itemView2.getMeasuredWidth();
                    i11 -= measuredWidth;
                    if (i18 == 0) {
                        i18 = measuredWidth;
                    }
                    if (this.KT) {
                        z = z2 & (i11 >= 0);
                        i6 = i18;
                        i7 = i9;
                    } else {
                        z = z2 & (i11 + i18 > 0);
                        i6 = i18;
                        i7 = i9;
                    }
                } else {
                    z = z5;
                    i6 = i18;
                    i7 = i19;
                }
                if (z && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                    i8 = i15;
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i22 = i15;
                    for (int i23 = 0; i23 < i17; i23++) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i23);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i22++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                    i8 = i22;
                } else {
                    i8 = i15;
                }
                if (z) {
                    i8--;
                }
                menuItemImpl2.setIsActionButton(z);
                i3 = i6;
                i4 = i11;
                int i24 = i7;
                i5 = i8;
                i19 = i24;
            } else {
                menuItemImpl2.setIsActionButton(false);
                i3 = i18;
                i4 = i11;
                i5 = i15;
            }
            i17++;
            i11 = i4;
            i15 = i5;
            i18 = i3;
        }
        return true;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        fl();
        super.onCloseMenu(menuBuilder, z);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.Lk = this.Le;
        return savedState;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.Lk > 0 && (findItem = this.mMenu.findItem(savedState.Lk)) != null) {
                onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
            }
        }
    }

    @Override // android.support.v4.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else if (this.mMenu != null) {
            this.mMenu.close(false);
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.ActionMenuPresenter.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: o */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: aT */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int Lk;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.Lk = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.Lk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        private final float[] Lh;

        public d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            this.Lh = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ForwardingListener(this) { // from class: android.support.v7.widget.ActionMenuPresenter.d.1
                @Override // android.support.v7.widget.ForwardingListener
                public ShowableListMenu getPopup() {
                    if (ActionMenuPresenter.this.KZ == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.KZ.getPopup();
                }

                @Override // android.support.v7.widget.ForwardingListener
                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                @Override // android.support.v7.widget.ForwardingListener
                public boolean onForwardingStopped() {
                    if (ActionMenuPresenter.this.Lb != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.hideOverflowMenu();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.showOverflowMenu();
            }
            return true;
        }

        @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends MenuPopupHelper {
        public e(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setPresenterCallback(ActionMenuPresenter.this.Ld);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v7.view.menu.MenuPopupHelper
        public void onDismiss() {
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.close();
            }
            ActionMenuPresenter.this.KZ = null;
            super.onDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends MenuPopupHelper {
        public a(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
            View view2;
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                if (ActionMenuPresenter.this.KK == null) {
                    view2 = (View) ActionMenuPresenter.this.mMenuView;
                } else {
                    view2 = ActionMenuPresenter.this.KK;
                }
                setAnchorView(view2);
            }
            setPresenterCallback(ActionMenuPresenter.this.Ld);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v7.view.menu.MenuPopupHelper
        public void onDismiss() {
            ActionMenuPresenter.this.La = null;
            ActionMenuPresenter.this.Le = 0;
            super.onDismiss();
        }
    }

    /* loaded from: classes2.dex */
    private class f implements MenuPresenter.Callback {
        f() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            ActionMenuPresenter.this.Le = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            return callback != null ? callback.onOpenSubMenu(menuBuilder) : false;
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        private e Lg;

        public c(e eVar) {
            this.Lg = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.mMenuView;
            if (view != null && view.getWindowToken() != null && this.Lg.tryShow()) {
                ActionMenuPresenter.this.KZ = this.Lg;
            }
            ActionMenuPresenter.this.Lb = null;
        }
    }

    /* loaded from: classes2.dex */
    private class b extends ActionMenuItemView.PopupCallback {
        b() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            if (ActionMenuPresenter.this.La != null) {
                return ActionMenuPresenter.this.La.getPopup();
            }
            return null;
        }
    }
}
