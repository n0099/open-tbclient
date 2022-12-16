package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHECKABLE = 1;
    public static final int CHECKED = 2;
    public static final int ENABLED = 16;
    public static final int EXCLUSIVE = 4;
    public static final int HIDDEN = 8;
    public static final int IS_ACTION = 32;
    public static final int NO_ICON = 0;
    public static final int SHOW_AS_ACTION_MASK = 3;
    public static final String TAG = "MenuItemImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public ActionProvider mActionProvider;
    public View mActionView;
    public final int mCategoryOrder;
    public MenuItem.OnMenuItemClickListener mClickListener;
    public CharSequence mContentDescription;
    public int mFlags;
    public final int mGroup;
    public boolean mHasIconTint;
    public boolean mHasIconTintMode;
    public Drawable mIconDrawable;
    public int mIconResId;
    public ColorStateList mIconTintList;
    public PorterDuff.Mode mIconTintMode;
    public final int mId;
    public Intent mIntent;
    public boolean mIsActionViewExpanded;
    public Runnable mItemCallback;
    public MenuBuilder mMenu;
    public ContextMenu.ContextMenuInfo mMenuInfo;
    public boolean mNeedToApplyIconTint;
    public MenuItem.OnActionExpandListener mOnActionExpandListener;
    public final int mOrdering;
    public char mShortcutAlphabeticChar;
    public int mShortcutAlphabeticModifiers;
    public char mShortcutNumericChar;
    public int mShortcutNumericModifiers;
    public int mShowAsAction;
    public SubMenuBuilder mSubMenu;
    public CharSequence mTitle;
    public CharSequence mTitleCondensed;
    public CharSequence mTooltipText;

    public MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {menuBuilder, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), charSequence, Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mShortcutNumericModifiers = 4096;
        this.mShortcutAlphabeticModifiers = 4096;
        this.mIconResId = 0;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mNeedToApplyIconTint = false;
        this.mFlags = 16;
        this.mShowAsAction = 0;
        this.mIsActionViewExpanded = false;
        this.mMenu = menuBuilder;
        this.mId = i2;
        this.mGroup = i;
        this.mCategoryOrder = i3;
        this.mOrdering = i4;
        this.mTitle = charSequence;
        this.mShowAsAction = i5;
    }

    public static void appendModifier(StringBuilder sb, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{sb, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) && (i & i2) == i2) {
            sb.append(str);
        }
    }

    private Drawable applyIconTintIfNecessary(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, drawable)) == null) {
            if (drawable != null && this.mNeedToApplyIconTint && (this.mHasIconTint || this.mHasIconTintMode)) {
                drawable = DrawableCompat.wrap(drawable).mutate();
                if (this.mHasIconTint) {
                    DrawableCompat.setTintList(drawable, this.mIconTintList);
                }
                if (this.mHasIconTintMode) {
                    DrawableCompat.setTintMode(drawable, this.mIconTintMode);
                }
                this.mNeedToApplyIconTint = false;
            }
            return drawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public void actionFormatChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mMenu.onItemActionRequestChanged(this);
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if ((this.mShowAsAction & 8) == 0) {
                return false;
            }
            if (this.mActionView == null) {
                return true;
            }
            MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
            if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
                return false;
            }
            return this.mMenu.collapseItemActionView(this);
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!hasCollapsibleActionView()) {
                return false;
            }
            MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
            if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand(this)) {
                return false;
            }
            return this.mMenu.expandItemActionView(this);
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
        }
        return (android.view.ActionProvider) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view2 = this.mActionView;
            if (view2 != null) {
                return view2;
            }
            ActionProvider actionProvider = this.mActionProvider;
            if (actionProvider != null) {
                View onCreateActionView = actionProvider.onCreateActionView(this);
                this.mActionView = onCreateActionView;
                return onCreateActionView;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mShortcutAlphabeticModifiers;
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mShortcutAlphabeticChar;
        }
        return invokeV.charValue;
    }

    public Runnable getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mItemCallback;
        }
        return (Runnable) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mContentDescription;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mGroup;
        }
        return invokeV.intValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mIconTintList;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mIconTintMode;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mIntent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mId;
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mMenuInfo;
        }
        return (ContextMenu.ContextMenuInfo) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mShortcutNumericModifiers;
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mShortcutNumericChar;
        }
        return invokeV.charValue;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mCategoryOrder;
        }
        return invokeV.intValue;
    }

    public int getOrdering() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mOrdering;
        }
        return invokeV.intValue;
    }

    public char getShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.mMenu.isQwertyMode()) {
                return this.mShortcutAlphabeticChar;
            }
            return this.mShortcutNumericChar;
        }
        return invokeV.charValue;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mSubMenu;
        }
        return (SubMenu) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mActionProvider;
        }
        return (ActionProvider) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mTitle;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            CharSequence charSequence = this.mTitleCondensed;
            if (charSequence == null) {
                charSequence = this.mTitle;
            }
            if (Build.VERSION.SDK_INT < 18 && charSequence != null && !(charSequence instanceof String)) {
                return charSequence.toString();
            }
            return charSequence;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mTooltipText;
        }
        return (CharSequence) invokeV.objValue;
    }

    public boolean hasCollapsibleActionView() {
        InterceptResult invokeV;
        ActionProvider actionProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if ((this.mShowAsAction & 8) == 0) {
                return false;
            }
            if (this.mActionView == null && (actionProvider = this.mActionProvider) != null) {
                this.mActionView = actionProvider.onCreateActionView(this);
            }
            if (this.mActionView == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.mSubMenu != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isActionButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if ((this.mFlags & 32) == 32) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mIsActionViewExpanded;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if ((this.mFlags & 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if ((this.mFlags & 2) == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if ((this.mFlags & 16) != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isExclusiveCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if ((this.mFlags & 4) != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean requestsActionButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if ((this.mShowAsAction & 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if ((this.mShowAsAction & 2) == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (!requiresActionButton() && !requestsActionButton()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean shouldShowIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.mMenu.getOptionalIconsVisible();
        }
        return invokeV.booleanValue;
    }

    public boolean shouldShowShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (this.mMenu.isShortcutsVisible() && getShortcut() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean showsTextAsAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if ((this.mShowAsAction & 4) == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            CharSequence charSequence = this.mTitle;
            if (charSequence != null) {
                return charSequence.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Drawable drawable = this.mIconDrawable;
            if (drawable != null) {
                return applyIconTintIfNecessary(drawable);
            }
            if (this.mIconResId != 0) {
                Drawable drawable2 = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
                this.mIconResId = 0;
                this.mIconDrawable = drawable2;
                return applyIconTintIfNecessary(drawable2);
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            ActionProvider actionProvider = this.mActionProvider;
            if (actionProvider != null && actionProvider.overridesItemVisibility()) {
                if ((this.mFlags & 8) == 0 && this.mActionProvider.isVisible()) {
                    return true;
                }
                return false;
            } else if ((this.mFlags & 8) == 0) {
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public String getShortcutLabel() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            char shortcut = getShortcut();
            if (shortcut == 0) {
                return "";
            }
            Resources resources = this.mMenu.getContext().getResources();
            StringBuilder sb = new StringBuilder();
            if (ViewConfiguration.get(this.mMenu.getContext()).hasPermanentMenuKey()) {
                sb.append(resources.getString(R.string.obfuscated_res_0x7f0f004a));
            }
            if (this.mMenu.isQwertyMode()) {
                i = this.mShortcutAlphabeticModifiers;
            } else {
                i = this.mShortcutNumericModifiers;
            }
            appendModifier(sb, i, 65536, resources.getString(R.string.obfuscated_res_0x7f0f0046));
            appendModifier(sb, i, 4096, resources.getString(R.string.obfuscated_res_0x7f0f0042));
            appendModifier(sb, i, 2, resources.getString(R.string.obfuscated_res_0x7f0f0041));
            appendModifier(sb, i, 1, resources.getString(R.string.obfuscated_res_0x7f0f0047));
            appendModifier(sb, i, 4, resources.getString(R.string.obfuscated_res_0x7f0f0049));
            appendModifier(sb, i, 8, resources.getString(R.string.obfuscated_res_0x7f0f0045));
            if (shortcut != '\b') {
                if (shortcut != '\n') {
                    if (shortcut != ' ') {
                        sb.append(shortcut);
                    } else {
                        sb.append(resources.getString(R.string.obfuscated_res_0x7f0f0048));
                    }
                } else {
                    sb.append(resources.getString(R.string.obfuscated_res_0x7f0f0044));
                }
            } else {
                sb.append(resources.getString(R.string.obfuscated_res_0x7f0f0043));
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, itemView)) == null) {
            if (itemView != null && itemView.prefersCondensedTitle()) {
                return getTitleCondensed();
            }
            return getTitle();
        }
        return (CharSequence) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, actionProvider)) == null) {
            throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
        }
        return (MenuItem) invokeL.objValue;
    }

    public void setActionViewExpanded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.mIsActionViewExpanded = z;
            this.mMenu.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{Character.valueOf(c)})) == null) {
            if (this.mShortcutAlphabeticChar == c) {
                return this;
            }
            this.mShortcutAlphabeticChar = Character.toLowerCase(c);
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    public MenuItem setCallback(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, runnable)) == null) {
            this.mItemCallback = runnable;
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048626, this, z)) == null) {
            int i = this.mFlags;
            int i2 = (z ? 1 : 0) | (i & (-2));
            this.mFlags = i2;
            if (i != i2) {
                this.mMenu.onItemsChanged(false);
            }
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048627, this, z)) == null) {
            if ((this.mFlags & 4) != 0) {
                this.mMenu.setExclusiveItemChecked(this);
            } else {
                setCheckedInt(z);
            }
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    public void setCheckedInt(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            int i2 = this.mFlags;
            int i3 = i2 & (-3);
            if (z) {
                i = 2;
            } else {
                i = 0;
            }
            int i4 = i | i3;
            this.mFlags = i4;
            if (i2 != i4) {
                this.mMenu.onItemsChanged(false);
            }
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048631, this, z)) == null) {
            if (z) {
                this.mFlags |= 16;
            } else {
                this.mFlags &= -17;
            }
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    public void setExclusiveCheckable(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            int i2 = this.mFlags & (-5);
            if (z) {
                i = 4;
            } else {
                i = 0;
            }
            this.mFlags = i | i2;
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i)) == null) {
            this.mIconDrawable = null;
            this.mIconResId = i;
            this.mNeedToApplyIconTint = true;
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeI.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, colorStateList)) == null) {
            this.mIconTintList = colorStateList;
            this.mHasIconTint = true;
            this.mNeedToApplyIconTint = true;
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, mode)) == null) {
            this.mIconTintMode = mode;
            this.mHasIconTintMode = true;
            this.mNeedToApplyIconTint = true;
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, intent)) == null) {
            this.mIntent = intent;
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    public void setIsActionButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            if (z) {
                this.mFlags |= 32;
            } else {
                this.mFlags &= -33;
            }
        }
    }

    public void setMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, contextMenuInfo) == null) {
            this.mMenuInfo = contextMenuInfo;
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048640, this, new Object[]{Character.valueOf(c)})) == null) {
            if (this.mShortcutNumericChar == c) {
                return this;
            }
            this.mShortcutNumericChar = c;
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, onActionExpandListener)) == null) {
            this.mOnActionExpandListener = onActionExpandListener;
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, onMenuItemClickListener)) == null) {
            this.mClickListener = onMenuItemClickListener;
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i) == null) {
            int i2 = i & 3;
            if (i2 != 0 && i2 != 1 && i2 != 2) {
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            }
            this.mShowAsAction = i;
            this.mMenu.onItemActionRequestChanged(this);
        }
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, subMenuBuilder) == null) {
            this.mSubMenu = subMenuBuilder;
            subMenuBuilder.setHeaderTitle(getTitle());
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, actionProvider)) == null) {
            ActionProvider actionProvider2 = this.mActionProvider;
            if (actionProvider2 != null) {
                actionProvider2.reset();
            }
            this.mActionView = null;
            this.mActionProvider = actionProvider;
            this.mMenu.onItemsChanged(true);
            ActionProvider actionProvider3 = this.mActionProvider;
            if (actionProvider3 != null) {
                actionProvider3.setVisibilityListener(new ActionProvider.VisibilityListener(this) { // from class: androidx.appcompat.view.menu.MenuItemImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MenuItemImpl this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.core.view.ActionProvider.VisibilityListener
                    public void onActionProviderVisibilityChanged(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            MenuItemImpl menuItemImpl = this.this$0;
                            menuItemImpl.mMenu.onItemVisibleChanged(menuItemImpl);
                        }
                    }
                });
            }
            return this;
        }
        return (SupportMenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048651, this, i)) == null) {
            return setTitle(this.mMenu.getContext().getString(i));
        }
        return (MenuItem) invokeI.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, charSequence)) == null) {
            this.mTitleCondensed = charSequence;
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048656, this, z)) == null) {
            if (setVisibleInt(z)) {
                this.mMenu.onItemVisibleChanged(this);
            }
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    public boolean setVisibleInt(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048657, this, z)) == null) {
            int i2 = this.mFlags;
            int i3 = i2 & (-9);
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            int i4 = i | i3;
            this.mFlags = i4;
            if (i2 == i4) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mClickListener;
            if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
                return true;
            }
            MenuBuilder menuBuilder = this.mMenu;
            if (menuBuilder.dispatchMenuItemSelected(menuBuilder, this)) {
                return true;
            }
            Runnable runnable = this.mItemCallback;
            if (runnable != null) {
                runnable.run();
                return true;
            }
            if (this.mIntent != null) {
                try {
                    this.mMenu.getContext().startActivity(this.mIntent);
                    return true;
                } catch (ActivityNotFoundException e) {
                    Log.e(TAG, "Can't find activity to handle intent; ignoring", e);
                }
            }
            ActionProvider actionProvider = this.mActionProvider;
            if (actionProvider != null && actionProvider.onPerformDefaultAction()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, charSequence)) == null) {
            this.mContentDescription = charSequence;
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (SupportMenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, drawable)) == null) {
            this.mIconResId = 0;
            this.mIconDrawable = drawable;
            this.mNeedToApplyIconTint = true;
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048648, this, i)) == null) {
            setShowAsAction(i);
            return this;
        }
        return (SupportMenuItem) invokeI.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, charSequence)) == null) {
            this.mTitle = charSequence;
            this.mMenu.onItemsChanged(false);
            SubMenuBuilder subMenuBuilder = this.mSubMenu;
            if (subMenuBuilder != null) {
                subMenuBuilder.setHeaderTitle(charSequence);
            }
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, charSequence)) == null) {
            this.mTooltipText = charSequence;
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (SupportMenuItem) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i)) == null) {
            Context context = this.mMenu.getContext();
            setActionView(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
            return this;
        }
        return (SupportMenuItem) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View view2) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, view2)) == null) {
            this.mActionView = view2;
            this.mActionProvider = null;
            if (view2 != null && view2.getId() == -1 && (i = this.mId) > 0) {
                view2.setId(i);
            }
            this.mMenu.onItemActionRequestChanged(this);
            return this;
        }
        return (SupportMenuItem) invokeL.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{Character.valueOf(c), Integer.valueOf(i)})) == null) {
            if (this.mShortcutAlphabeticChar == c && this.mShortcutAlphabeticModifiers == i) {
                return this;
            }
            this.mShortcutAlphabeticChar = Character.toLowerCase(c);
            this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i);
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048641, this, new Object[]{Character.valueOf(c), Integer.valueOf(i)})) == null) {
            if (this.mShortcutNumericChar == c && this.mShortcutNumericModifiers == i) {
                return this;
            }
            this.mShortcutNumericChar = c;
            this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i);
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048644, this, new Object[]{Character.valueOf(c), Character.valueOf(c2)})) == null) {
            this.mShortcutNumericChar = c;
            this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048645, this, new Object[]{Character.valueOf(c), Character.valueOf(c2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            this.mShortcutNumericChar = c;
            this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i);
            this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
            this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i2);
            this.mMenu.onItemsChanged(false);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }
}
