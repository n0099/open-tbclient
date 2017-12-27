package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@RestrictTo
/* loaded from: classes2.dex */
public class MenuBuilder implements SupportMenu {
    private static final int[] IL = {1, 4, 5, 3, 2, 0};
    private boolean IM;
    private boolean IN;
    private Callback IO;
    private ContextMenu.ContextMenuInfo IW;
    CharSequence IX;
    Drawable IY;
    View IZ;
    private MenuItemImpl Jg;
    private boolean Jh;
    private final Context mContext;
    private final Resources mResources;
    private int IU = 0;
    private boolean Ja = false;
    private boolean Jb = false;
    private boolean Jc = false;
    private boolean Jd = false;
    private ArrayList<MenuItemImpl> Je = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> Jf = new CopyOnWriteArrayList<>();
    private ArrayList<MenuItemImpl> mItems = new ArrayList<>();
    private ArrayList<MenuItemImpl> IP = new ArrayList<>();
    private boolean IQ = true;
    private ArrayList<MenuItemImpl> IR = new ArrayList<>();
    private ArrayList<MenuItemImpl> IS = new ArrayList<>();
    private boolean IT = true;

    @RestrictTo
    /* loaded from: classes2.dex */
    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder menuBuilder);
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        A(true);
    }

    public MenuBuilder setDefaultShowAsAction(int i) {
        this.IU = i;
        return this;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.mContext);
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.Jf.add(new WeakReference<>(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.IT = true;
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.Jf.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.Jf.remove(next);
            }
        }
    }

    private void z(boolean z) {
        if (!this.Jf.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.Jf.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.Jf.remove(next);
                } else {
                    menuPresenter.updateMenuView(z);
                }
            }
            startDispatchingItemsChanged();
        }
    }

    private boolean a(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        if (this.Jf.isEmpty()) {
            return false;
        }
        boolean onSubMenuSelected = menuPresenter != null ? menuPresenter.onSubMenuSelected(subMenuBuilder) : false;
        Iterator<WeakReference<MenuPresenter>> it = this.Jf.iterator();
        while (true) {
            boolean z = onSubMenuSelected;
            if (!it.hasNext()) {
                return z;
            }
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null) {
                this.Jf.remove(next);
            } else if (!z) {
                z = menuPresenter2.onSubMenuSelected(subMenuBuilder);
            }
            onSubMenuSelected = z;
        }
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.Jf.isEmpty()) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            Iterator<WeakReference<MenuPresenter>> it = this.Jf.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.Jf.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                        sparseArray.put(id, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.Jf.isEmpty()) {
            Iterator<WeakReference<MenuPresenter>> it = this.Jf.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.Jf.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        menuPresenter.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    public void savePresenterStates(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void restorePresenterStates(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray<Parcelable> sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View actionView = MenuItemCompat.getActionView(item);
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (MenuItemCompat.isActionViewExpanded(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray<Parcelable> sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = MenuItemCompat.getActionView(item);
                if (actionView != null && actionView.getId() != -1) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                MenuItemCompat.expandActionView(findItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    public void setCallback(Callback callback) {
        this.IO = callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        int aS = aS(i3);
        MenuItemImpl a = a(i, i2, i3, aS, charSequence, this.IU);
        if (this.IW != null) {
            a.a(this.IW);
        }
        this.mItems.add(a(this.mItems, aS), a);
        onItemsChanged(true);
        return a;
    }

    private MenuItemImpl a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return addInternal(0, 0, 0, this.mResources.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return addInternal(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return addInternal(i, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.mContext, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        i(findItemIndex(i), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int findGroupIndex = findGroupIndex(i);
        if (findGroupIndex >= 0) {
            int size = this.mItems.size() - findGroupIndex;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.mItems.get(findGroupIndex).getGroupId() != i) {
                    break;
                }
                i(findGroupIndex, false);
                i2 = i3;
            }
            onItemsChanged(true);
        }
    }

    private void i(int i, boolean z) {
        if (i >= 0 && i < this.mItems.size()) {
            this.mItems.remove(i);
            if (z) {
                onItemsChanged(true);
            }
        }
    }

    public void removeItemAt(int i) {
        i(i, true);
    }

    public void clearAll() {
        this.Ja = true;
        clear();
        clearHeader();
        this.Ja = false;
        this.Jb = false;
        onItemsChanged(true);
    }

    @Override // android.view.Menu
    public void clear() {
        if (this.Jg != null) {
            collapseItemActionView(this.Jg);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                menuItemImpl.B(menuItemImpl == menuItem);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setExclusiveCheckable(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.mItems.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            MenuItemImpl menuItemImpl = this.mItems.get(i2);
            i2++;
            z2 = (menuItemImpl.getGroupId() == i && menuItemImpl.C(z)) ? true : z2;
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.Jh) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.mItems.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i2);
            if (menuItemImpl.getItemId() != i) {
                if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i)) != null) {
                    return findItem;
                }
            } else {
                return menuItemImpl;
            }
        }
        return null;
    }

    public int findItemIndex(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mItems.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int findGroupIndex(int i) {
        return findGroupIndex(i, 0);
    }

    public int findGroupIndex(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (this.mItems.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public int size() {
        return this.mItems.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.mItems.get(i);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return d(i, keyEvent) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.IM = z;
        onItemsChanged(false);
    }

    private static int aS(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= IL.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (IL[i2] << 16) | (65535 & i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isQwertyMode() {
        return this.IM;
    }

    public void setShortcutsVisible(boolean z) {
        if (this.IN != z) {
            A(z);
            onItemsChanged(false);
        }
    }

    private void A(boolean z) {
        boolean z2 = true;
        this.IN = (z && this.mResources.getConfiguration().keyboard != 1 && this.mResources.getBoolean(R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent)) ? false : false;
    }

    public boolean isShortcutsVisible() {
        return this.IN;
    }

    Resources getResources() {
        return this.mResources;
    }

    public Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.IO != null && this.IO.onMenuItemSelected(menuBuilder, menuItem);
    }

    public void changeMenuMode() {
        if (this.IO != null) {
            this.IO.onMenuModeChange(this);
        }
    }

    private static int a(ArrayList<MenuItemImpl> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getOrdering() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItemImpl d = d(i, keyEvent);
        boolean z = false;
        if (d != null) {
            z = performItemAction(d, i2);
        }
        if ((i2 & 2) != 0) {
            close(true);
        }
        return z;
    }

    void a(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean isQwertyMode = isQwertyMode();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.mItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.mItems.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (isQwertyMode && alphabeticShortcut == '\b' && i == 67)) && menuItemImpl.isEnabled())) {
                    list.add(menuItemImpl);
                }
            }
        }
    }

    MenuItemImpl d(int i, KeyEvent keyEvent) {
        ArrayList<MenuItemImpl> arrayList = this.Je;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = arrayList.get(i2);
            char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return menuItemImpl;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return menuItemImpl;
            }
            if (isQwertyMode && alphabeticShortcut == '\b' && i == 67) {
                return menuItemImpl;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return performItemAction(findItem(i), i2);
    }

    public boolean performItemAction(MenuItem menuItem, int i) {
        return performItemAction(menuItem, null, i);
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.hasCollapsibleActionView()) {
            boolean expandActionView = menuItemImpl.expandActionView() | invoke;
            if (expandActionView) {
                close(true);
                return expandActionView;
            }
            return expandActionView;
        } else if (menuItemImpl.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                close(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            boolean a = a(subMenuBuilder, menuPresenter) | invoke;
            if (!a) {
                close(true);
                return a;
            }
            return a;
        } else {
            if ((i & 1) == 0) {
                close(true);
            }
            return invoke;
        }
    }

    public final void close(boolean z) {
        if (!this.Jd) {
            this.Jd = true;
            Iterator<WeakReference<MenuPresenter>> it = this.Jf.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.Jf.remove(next);
                } else {
                    menuPresenter.onCloseMenu(this, z);
                }
            }
            this.Jd = false;
        }
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }

    public void onItemsChanged(boolean z) {
        if (!this.Ja) {
            if (z) {
                this.IQ = true;
                this.IT = true;
            }
            z(z);
            return;
        }
        this.Jb = true;
    }

    public void stopDispatchingItemsChanged() {
        if (!this.Ja) {
            this.Ja = true;
            this.Jb = false;
        }
    }

    public void startDispatchingItemsChanged() {
        this.Ja = false;
        if (this.Jb) {
            this.Jb = false;
            onItemsChanged(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MenuItemImpl menuItemImpl) {
        this.IQ = true;
        onItemsChanged(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(MenuItemImpl menuItemImpl) {
        this.IT = true;
        onItemsChanged(true);
    }

    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (this.IQ) {
            this.IP.clear();
            int size = this.mItems.size();
            for (int i = 0; i < size; i++) {
                MenuItemImpl menuItemImpl = this.mItems.get(i);
                if (menuItemImpl.isVisible()) {
                    this.IP.add(menuItemImpl);
                }
            }
            this.IQ = false;
            this.IT = true;
            return this.IP;
        }
        return this.IP;
    }

    public void flagActionItems() {
        boolean flagActionItems;
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (this.IT) {
            Iterator<WeakReference<MenuPresenter>> it = this.Jf.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.Jf.remove(next);
                    flagActionItems = z;
                } else {
                    flagActionItems = menuPresenter.flagActionItems() | z;
                }
                z = flagActionItems;
            }
            if (z) {
                this.IR.clear();
                this.IS.clear();
                int size = visibleItems.size();
                for (int i = 0; i < size; i++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i);
                    if (menuItemImpl.isActionButton()) {
                        this.IR.add(menuItemImpl);
                    } else {
                        this.IS.add(menuItemImpl);
                    }
                }
            } else {
                this.IR.clear();
                this.IS.clear();
                this.IS.addAll(getVisibleItems());
            }
            this.IT = false;
        }
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.IR;
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.IS;
    }

    public void clearHeader() {
        this.IY = null;
        this.IX = null;
        this.IZ = null;
        onItemsChanged(false);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.IZ = view;
            this.IX = null;
            this.IY = null;
        } else {
            if (i > 0) {
                this.IX = resources.getText(i);
            } else if (charSequence != null) {
                this.IX = charSequence;
            }
            if (i2 > 0) {
                this.IY = ContextCompat.getDrawable(getContext(), i2);
            } else if (drawable != null) {
                this.IY = drawable;
            }
            this.IZ = null;
        }
        onItemsChanged(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(int i) {
        a(0, null, i, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder setHeaderViewInt(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public CharSequence getHeaderTitle() {
        return this.IX;
    }

    public Drawable getHeaderIcon() {
        return this.IY;
    }

    public View getHeaderView() {
        return this.IZ;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.IW = contextMenuInfo;
    }

    public void setOptionalIconsVisible(boolean z) {
        this.Jc = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eW() {
        return this.Jc;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.Jf.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.Jf.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.Jf.remove(next);
                    z = z2;
                } else {
                    z = menuPresenter.expandItemActionView(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.Jg = menuItemImpl;
            }
        }
        return z;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.Jf.isEmpty() && this.Jg == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.Jf.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.Jf.remove(next);
                    z = z2;
                } else {
                    z = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.Jg = null;
            }
        }
        return z;
    }

    public MenuItemImpl getExpandedItem() {
        return this.Jg;
    }

    public void setOverrideVisibleItems(boolean z) {
        this.Jh = z;
    }
}
