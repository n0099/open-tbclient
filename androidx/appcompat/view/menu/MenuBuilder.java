package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    public static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    public static final String PRESENTER_KEY = "android:menu:presenters";
    public static final String TAG = "MenuBuilder";
    public static final int[] sCategoryToOrder;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<MenuItemImpl> mActionItems;
    public Callback mCallback;
    public final Context mContext;
    public ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    public int mDefaultShowAsAction;
    public MenuItemImpl mExpandedItem;
    public boolean mGroupDividerEnabled;
    public Drawable mHeaderIcon;
    public CharSequence mHeaderTitle;
    public View mHeaderView;
    public boolean mIsActionItemsStale;
    public boolean mIsClosing;
    public boolean mIsVisibleItemsStale;
    public ArrayList<MenuItemImpl> mItems;
    public boolean mItemsChangedWhileDispatchPrevented;
    public ArrayList<MenuItemImpl> mNonActionItems;
    public boolean mOptionalIconsVisible;
    public boolean mOverrideVisibleItems;
    public CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters;
    public boolean mPreventDispatchingItemsChanged;
    public boolean mQwertyMode;
    public final Resources mResources;
    public boolean mShortcutsVisible;
    public boolean mStructureChangedWhileDispatchPrevented;
    public ArrayList<MenuItemImpl> mTempShortcutItemList;
    public ArrayList<MenuItemImpl> mVisibleItems;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface Callback {
        boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

        void onMenuModeChange(@NonNull MenuBuilder menuBuilder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(593847723, "Landroidx/appcompat/view/menu/MenuBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(593847723, "Landroidx/appcompat/view/menu/MenuBuilder;");
                return;
            }
        }
        sCategoryToOrder = new int[]{1, 4, 5, 3, 2, 0};
    }

    public MenuBuilder(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDefaultShowAsAction = 0;
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        this.mOptionalIconsVisible = false;
        this.mIsClosing = false;
        this.mTempShortcutItemList = new ArrayList<>();
        this.mPresenters = new CopyOnWriteArrayList<>();
        this.mGroupDividerEnabled = false;
        this.mContext = context;
        this.mResources = context.getResources();
        this.mItems = new ArrayList<>();
        this.mVisibleItems = new ArrayList<>();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList<>();
        this.mNonActionItems = new ArrayList<>();
        this.mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
    }

    private MenuItemImpl createNewMenuItem(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), charSequence, Integer.valueOf(i5)})) == null) ? new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5) : (MenuItemImpl) invokeCommon.objValue;
    }

    private void dispatchPresenterUpdate(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65539, this, z) == null) || this.mPresenters.isEmpty()) {
            return;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                menuPresenter.updateMenuView(z);
            }
        }
        startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        SparseArray sparseParcelableArray;
        Parcelable parcelable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bundle) == null) || (sparseParcelableArray = bundle.getSparseParcelableArray(PRESENTER_KEY)) == null || this.mPresenters.isEmpty()) {
            return;
        }
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    menuPresenter.onRestoreInstanceState(parcelable);
                }
            }
        }
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable onSaveInstanceState;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, bundle) == null) || this.mPresenters.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                    sparseArray.put(id, onSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray(PRESENTER_KEY, sparseArray);
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, subMenuBuilder, menuPresenter)) == null) {
            if (this.mPresenters.isEmpty()) {
                return false;
            }
            boolean onSubMenuSelected = menuPresenter != null ? menuPresenter.onSubMenuSelected(subMenuBuilder) : false;
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter2 = next.get();
                if (menuPresenter2 == null) {
                    this.mPresenters.remove(next);
                } else if (!onSubMenuSelected) {
                    onSubMenuSelected = menuPresenter2.onSubMenuSelected(subMenuBuilder);
                }
            }
            return onSubMenuSelected;
        }
        return invokeLL.booleanValue;
    }

    public static int findInsertIndex(ArrayList<MenuItemImpl> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, arrayList, i)) == null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).getOrdering() <= i) {
                    return size + 1;
                }
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public static int getOrdering(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            int i2 = ((-65536) & i) >> 16;
            if (i2 >= 0) {
                int[] iArr = sCategoryToOrder;
                if (i2 < iArr.length) {
                    return (i & 65535) | (iArr[i2] << 16);
                }
            }
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return invokeI.intValue;
    }

    private void removeItemAtInt(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || i < 0 || i >= this.mItems.size()) {
            return;
        }
        this.mItems.remove(i);
        if (z) {
            onItemsChanged(true);
        }
    }

    private void setHeaderInternal(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Integer.valueOf(i), charSequence, Integer.valueOf(i2), drawable, view}) == null) {
            Resources resources = getResources();
            if (view != null) {
                this.mHeaderView = view;
                this.mHeaderTitle = null;
                this.mHeaderIcon = null;
            } else {
                if (i > 0) {
                    this.mHeaderTitle = resources.getText(i);
                } else if (charSequence != null) {
                    this.mHeaderTitle = charSequence;
                }
                if (i2 > 0) {
                    this.mHeaderIcon = ContextCompat.getDrawable(getContext(), i2);
                } else if (drawable != null) {
                    this.mHeaderIcon = drawable;
                }
                this.mHeaderView = null;
            }
            onItemsChanged(false);
        }
    }

    private void setShortcutsVisibleInner(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            boolean z2 = true;
            this.mShortcutsVisible = (z && this.mResources.getConfiguration().keyboard != 1 && ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.mContext), this.mContext)) ? false : false;
        }
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequence)) == null) ? addInternal(0, 0, 0, charSequence) : (MenuItem) invokeL.objValue;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), componentName, intentArr, intent, Integer.valueOf(i4), menuItemArr})) == null) {
            PackageManager packageManager = this.mContext.getPackageManager();
            List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
            int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
            if ((i4 & 1) == 0) {
                removeGroup(i);
            }
            for (int i6 = 0; i6 < size; i6++) {
                ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
                int i7 = resolveInfo.specificIndex;
                Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
                MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
                if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                    menuItemArr[i5] = intent3;
                }
            }
            return size;
        }
        return invokeCommon.intValue;
    }

    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), charSequence})) == null) {
            int ordering = getOrdering(i3);
            MenuItemImpl createNewMenuItem = createNewMenuItem(i, i2, i3, ordering, charSequence, this.mDefaultShowAsAction);
            ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
            if (contextMenuInfo != null) {
                createNewMenuItem.setMenuInfo(contextMenuInfo);
            }
            ArrayList<MenuItemImpl> arrayList = this.mItems;
            arrayList.add(findInsertIndex(arrayList, ordering), createNewMenuItem);
            onItemsChanged(true);
            return createNewMenuItem;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, menuPresenter) == null) {
            addMenuPresenter(menuPresenter, this.mContext);
        }
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, charSequence)) == null) ? addSubMenu(0, 0, 0, charSequence) : (SubMenu) invokeL.objValue;
    }

    public void changeMenuMode() {
        Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (callback = this.mCallback) == null) {
            return;
        }
        callback.onMenuModeChange(this);
    }

    @Override // android.view.Menu
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MenuItemImpl menuItemImpl = this.mExpandedItem;
            if (menuItemImpl != null) {
                collapseItemActionView(menuItemImpl);
            }
            this.mItems.clear();
            onItemsChanged(true);
        }
    }

    public void clearAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mPreventDispatchingItemsChanged = true;
            clear();
            clearHeader();
            this.mPresenters.clear();
            this.mPreventDispatchingItemsChanged = false;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
            onItemsChanged(true);
        }
    }

    public void clearHeader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mHeaderIcon = null;
            this.mHeaderTitle = null;
            this.mHeaderView = null;
            onItemsChanged(false);
        }
    }

    public final void close(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.mIsClosing) {
            return;
        }
        this.mIsClosing = true;
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                menuPresenter.onCloseMenu(this, z);
            }
        }
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, menuItemImpl)) == null) {
            boolean z = false;
            if (!this.mPresenters.isEmpty() && this.mExpandedItem == menuItemImpl) {
                stopDispatchingItemsChanged();
                Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
                while (it.hasNext()) {
                    WeakReference<MenuPresenter> next = it.next();
                    MenuPresenter menuPresenter = next.get();
                    if (menuPresenter == null) {
                        this.mPresenters.remove(next);
                    } else {
                        z = menuPresenter.collapseItemActionView(this, menuItemImpl);
                        if (z) {
                            break;
                        }
                    }
                }
                startDispatchingItemsChanged();
                if (z) {
                    this.mExpandedItem = null;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean dispatchMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, menuBuilder, menuItem)) == null) {
            Callback callback = this.mCallback;
            return callback != null && callback.onMenuItemSelected(menuBuilder, menuItem);
        }
        return invokeLL.booleanValue;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, menuItemImpl)) == null) {
            boolean z = false;
            if (this.mPresenters.isEmpty()) {
                return false;
            }
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    z = menuPresenter.expandItemActionView(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.mExpandedItem = menuItemImpl;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public int findGroupIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) ? findGroupIndex(i, 0) : invokeI.intValue;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        InterceptResult invokeI;
        MenuItem findItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.mItems.get(i2);
                if (menuItemImpl.getItemId() == i) {
                    return menuItemImpl;
                }
                if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i)) != null) {
                    return findItem;
                }
            }
            return null;
        }
        return (MenuItem) invokeI.objValue;
    }

    public int findItemIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.mItems.get(i2).getItemId() == i) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public MenuItemImpl findItemWithShortcutForKey(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        char numericShortcut;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i, keyEvent)) == null) {
            ArrayList<MenuItemImpl> arrayList = this.mTempShortcutItemList;
            arrayList.clear();
            findItemsWithShortcutForKey(arrayList, i, keyEvent);
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
                if (isQwertyMode) {
                    numericShortcut = menuItemImpl.getAlphabeticShortcut();
                } else {
                    numericShortcut = menuItemImpl.getNumericShortcut();
                }
                if ((numericShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((numericShortcut == keyData.meta[2] && (metaState & 2) != 0) || (isQwertyMode && numericShortcut == '\b' && i == 67))) {
                    return menuItemImpl;
                }
            }
            return null;
        }
        return (MenuItemImpl) invokeIL.objValue;
    }

    public void findItemsWithShortcutForKey(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048602, this, list, i, keyEvent) == null) {
            boolean isQwertyMode = isQwertyMode();
            int modifiers = keyEvent.getModifiers();
            KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
            if (keyEvent.getKeyData(keyData) || i == 67) {
                int size = this.mItems.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MenuItemImpl menuItemImpl = this.mItems.get(i2);
                    if (menuItemImpl.hasSubMenu()) {
                        ((MenuBuilder) menuItemImpl.getSubMenu()).findItemsWithShortcutForKey(list, i, keyEvent);
                    }
                    char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                    if (((modifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) == ((isQwertyMode ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & SupportMenu.SUPPORTED_MODIFIERS_MASK)) && alphabeticShortcut != 0) {
                        char[] cArr = keyData.meta;
                        if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (isQwertyMode && alphabeticShortcut == '\b' && i == 67)) && menuItemImpl.isEnabled()) {
                            list.add(menuItemImpl);
                        }
                    }
                }
            }
        }
    }

    public void flagActionItems() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
            if (this.mIsActionItemsStale) {
                Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    WeakReference<MenuPresenter> next = it.next();
                    MenuPresenter menuPresenter = next.get();
                    if (menuPresenter == null) {
                        this.mPresenters.remove(next);
                    } else {
                        z |= menuPresenter.flagActionItems();
                    }
                }
                if (z) {
                    this.mActionItems.clear();
                    this.mNonActionItems.clear();
                    int size = visibleItems.size();
                    for (int i = 0; i < size; i++) {
                        MenuItemImpl menuItemImpl = visibleItems.get(i);
                        if (menuItemImpl.isActionButton()) {
                            this.mActionItems.add(menuItemImpl);
                        } else {
                            this.mNonActionItems.add(menuItemImpl);
                        }
                    }
                } else {
                    this.mActionItems.clear();
                    this.mNonActionItems.clear();
                    this.mNonActionItems.addAll(getVisibleItems());
                }
                this.mIsActionItemsStale = false;
            }
        }
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            flagActionItems();
            return this.mActionItems;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getActionViewStatesKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? ACTION_VIEW_STATES_KEY : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public MenuItemImpl getExpandedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mExpandedItem : (MenuItemImpl) invokeV.objValue;
    }

    public Drawable getHeaderIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mHeaderIcon : (Drawable) invokeV.objValue;
    }

    public CharSequence getHeaderTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mHeaderTitle : (CharSequence) invokeV.objValue;
    }

    public View getHeaderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mHeaderView : (View) invokeV.objValue;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) ? this.mItems.get(i) : (MenuItem) invokeI.objValue;
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            flagActionItems();
            return this.mNonActionItems;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean getOptionalIconsVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mOptionalIconsVisible : invokeV.booleanValue;
    }

    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mResources : (Resources) invokeV.objValue;
    }

    public MenuBuilder getRootMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this : (MenuBuilder) invokeV.objValue;
    }

    @NonNull
    public ArrayList<MenuItemImpl> getVisibleItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.mIsVisibleItemsStale) {
                this.mVisibleItems.clear();
                int size = this.mItems.size();
                for (int i = 0; i < size; i++) {
                    MenuItemImpl menuItemImpl = this.mItems.get(i);
                    if (menuItemImpl.isVisible()) {
                        this.mVisibleItems.add(menuItemImpl);
                    }
                }
                this.mIsVisibleItemsStale = false;
                this.mIsActionItemsStale = true;
                return this.mVisibleItems;
            }
            return this.mVisibleItems;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.mOverrideVisibleItems) {
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
        return invokeV.booleanValue;
    }

    public boolean isGroupDividerEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mGroupDividerEnabled : invokeV.booleanValue;
    }

    public boolean isQwertyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mQwertyMode : invokeV.booleanValue;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048620, this, i, keyEvent)) == null) ? findItemWithShortcutForKey(i, keyEvent) != null : invokeIL.booleanValue;
    }

    public boolean isShortcutsVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mShortcutsVisible : invokeV.booleanValue;
    }

    public void onItemActionRequestChanged(MenuItemImpl menuItemImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, menuItemImpl) == null) {
            this.mIsActionItemsStale = true;
            onItemsChanged(true);
        }
    }

    public void onItemVisibleChanged(MenuItemImpl menuItemImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, menuItemImpl) == null) {
            this.mIsVisibleItemsStale = true;
            onItemsChanged(true);
        }
    }

    public void onItemsChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            if (!this.mPreventDispatchingItemsChanged) {
                if (z) {
                    this.mIsVisibleItemsStale = true;
                    this.mIsActionItemsStale = true;
                }
                dispatchPresenterUpdate(z);
                return;
            }
            this.mItemsChangedWhileDispatchPrevented = true;
            if (z) {
                this.mStructureChangedWhileDispatchPrevented = true;
            }
        }
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048625, this, i, i2)) == null) ? performItemAction(findItem(i), i2) : invokeII.booleanValue;
    }

    public boolean performItemAction(MenuItem menuItem, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048626, this, menuItem, i)) == null) ? performItemAction(menuItem, null, i) : invokeLI.booleanValue;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i), keyEvent, Integer.valueOf(i2)})) == null) {
            MenuItemImpl findItemWithShortcutForKey = findItemWithShortcutForKey(i, keyEvent);
            boolean performItemAction = findItemWithShortcutForKey != null ? performItemAction(findItemWithShortcutForKey, i2) : false;
            if ((i2 & 2) != 0) {
                close(true);
            }
            return performItemAction;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int findGroupIndex;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048629, this, i) == null) || (findGroupIndex = findGroupIndex(i)) < 0) {
            return;
        }
        int size = this.mItems.size() - findGroupIndex;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= size || this.mItems.get(findGroupIndex).getGroupId() != i) {
                break;
            }
            removeItemAtInt(findGroupIndex, false);
            i2 = i3;
        }
        onItemsChanged(true);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            removeItemAtInt(findItemIndex(i), true);
        }
    }

    public void removeItemAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            removeItemAtInt(i, true);
        }
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, menuPresenter) == null) {
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter2 = next.get();
                if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                    this.mPresenters.remove(next);
                }
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, bundle) == null) || bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int i2 = bundle.getInt(EXPANDED_ACTION_VIEW_ID);
        if (i2 <= 0 || (findItem = findItem(i2)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void restorePresenterStates(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, bundle) == null) {
            dispatchRestoreInstanceState(bundle);
        }
    }

    public void saveActionViewStates(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, bundle) == null) {
            int size = size();
            SparseArray<? extends Parcelable> sparseArray = null;
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (actionView != null && actionView.getId() != -1) {
                    if (sparseArray == null) {
                        sparseArray = new SparseArray<>();
                    }
                    actionView.saveHierarchyState(sparseArray);
                    if (item.isActionViewExpanded()) {
                        bundle.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                    }
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
                }
            }
            if (sparseArray != null) {
                bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
            }
        }
    }

    public void savePresenterStates(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bundle) == null) {
            dispatchSaveInstanceState(bundle);
        }
    }

    public void setCallback(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, callback) == null) {
            this.mCallback = callback;
        }
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, contextMenuInfo) == null) {
            this.mCurrentMenuInfo = contextMenuInfo;
        }
    }

    public MenuBuilder setDefaultShowAsAction(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i)) == null) {
            this.mDefaultShowAsAction = i;
            return this;
        }
        return (MenuBuilder) invokeI.objValue;
    }

    public void setExclusiveItemChecked(MenuItem menuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, menuItem) == null) {
            int groupId = menuItem.getGroupId();
            int size = this.mItems.size();
            stopDispatchingItemsChanged();
            for (int i = 0; i < size; i++) {
                MenuItemImpl menuItemImpl = this.mItems.get(i);
                if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                    menuItemImpl.setCheckedInt(menuItemImpl == menuItem);
                }
            }
            startDispatchingItemsChanged();
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            int size = this.mItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.mItems.get(i2);
                if (menuItemImpl.getGroupId() == i) {
                    menuItemImpl.setExclusiveCheckable(z2);
                    menuItemImpl.setCheckable(z);
                }
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.mGroupDividerEnabled = z;
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int size = this.mItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.mItems.get(i2);
                if (menuItemImpl.getGroupId() == i) {
                    menuItemImpl.setEnabled(z);
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int size = this.mItems.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.mItems.get(i2);
                if (menuItemImpl.getGroupId() == i && menuItemImpl.setVisibleInt(z)) {
                    z2 = true;
                }
            }
            if (z2) {
                onItemsChanged(true);
            }
        }
    }

    public MenuBuilder setHeaderIconInt(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, drawable)) == null) {
            setHeaderInternal(0, null, 0, drawable, null);
            return this;
        }
        return (MenuBuilder) invokeL.objValue;
    }

    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, charSequence)) == null) {
            setHeaderInternal(0, charSequence, 0, null, null);
            return this;
        }
        return (MenuBuilder) invokeL.objValue;
    }

    public MenuBuilder setHeaderViewInt(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, view)) == null) {
            setHeaderInternal(0, null, 0, null, view);
            return this;
        }
        return (MenuBuilder) invokeL.objValue;
    }

    public void setOptionalIconsVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            this.mOptionalIconsVisible = z;
        }
    }

    public void setOverrideVisibleItems(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
            this.mOverrideVisibleItems = z;
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            this.mQwertyMode = z;
            onItemsChanged(false);
        }
    }

    public void setShortcutsVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048653, this, z) == null) || this.mShortcutsVisible == z) {
            return;
        }
        setShortcutsVisibleInner(z);
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.mItems.size() : invokeV.intValue;
    }

    public void startDispatchingItemsChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.mPreventDispatchingItemsChanged = false;
            if (this.mItemsChangedWhileDispatchPrevented) {
                this.mItemsChangedWhileDispatchPrevented = false;
                onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
            }
        }
    }

    public void stopDispatchingItemsChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048656, this) == null) || this.mPreventDispatchingItemsChanged) {
            return;
        }
        this.mPreventDispatchingItemsChanged = true;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? addInternal(0, 0, 0, this.mResources.getString(i)) : (MenuItem) invokeI.objValue;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, menuPresenter, context) == null) {
            this.mPresenters.add(new WeakReference<>(menuPresenter));
            menuPresenter.initForMenu(context, this);
            this.mIsActionItemsStale = true;
        }
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? addSubMenu(0, 0, 0, this.mResources.getString(i)) : (SubMenu) invokeI.objValue;
    }

    public int findGroupIndex(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i, i2)) == null) {
            int size = size();
            if (i2 < 0) {
                i2 = 0;
            }
            while (i2 < size) {
                if (this.mItems.get(i2).getGroupId() == i) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeII.intValue;
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048627, this, menuItem, menuPresenter, i)) == null) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
            if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
                return false;
            }
            boolean invoke = menuItemImpl.invoke();
            ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
            boolean z = supportActionProvider != null && supportActionProvider.hasSubMenu();
            if (menuItemImpl.hasCollapsibleActionView()) {
                invoke |= menuItemImpl.expandActionView();
                if (invoke) {
                    close(true);
                }
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
                invoke |= dispatchSubMenuSelected(subMenuBuilder, menuPresenter);
                if (!invoke) {
                    close(true);
                }
            } else if ((i & 1) == 0) {
                close(true);
            }
            return invoke;
        }
        return invokeLLI.booleanValue;
    }

    public MenuBuilder setHeaderIconInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048645, this, i)) == null) {
            setHeaderInternal(0, null, i, null, null);
            return this;
        }
        return (MenuBuilder) invokeI.objValue;
    }

    public MenuBuilder setHeaderTitleInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048647, this, i)) == null) {
            setHeaderInternal(i, null, 0, null, null);
            return this;
        }
        return (MenuBuilder) invokeI.objValue;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), charSequence})) == null) ? addInternal(i, i2, i3, charSequence) : (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), charSequence})) == null) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i, i2, i3, charSequence);
            SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.mContext, this, menuItemImpl);
            menuItemImpl.setSubMenu(subMenuBuilder);
            return subMenuBuilder;
        }
        return (SubMenu) invokeCommon.objValue;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4)) == null) ? addInternal(i, i2, i3, this.mResources.getString(i4)) : (MenuItem) invokeIIII.objValue;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048585, this, i, i2, i3, i4)) == null) ? addSubMenu(i, i2, i3, this.mResources.getString(i4)) : (SubMenu) invokeIIII.objValue;
    }

    @Override // android.view.Menu
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            close(true);
        }
    }
}
