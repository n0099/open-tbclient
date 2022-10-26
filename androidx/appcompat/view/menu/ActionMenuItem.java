package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ActionMenuItem implements SupportMenuItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHECKABLE = 1;
    public static final int CHECKED = 2;
    public static final int ENABLED = 16;
    public static final int EXCLUSIVE = 4;
    public static final int HIDDEN = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public MenuItem.OnMenuItemClickListener mClickListener;
    public CharSequence mContentDescription;
    public Context mContext;
    public int mFlags;
    public final int mGroup;
    public boolean mHasIconTint;
    public boolean mHasIconTintMode;
    public Drawable mIconDrawable;
    public ColorStateList mIconTintList;
    public PorterDuff.Mode mIconTintMode;
    public final int mId;
    public Intent mIntent;
    public final int mOrdering;
    public char mShortcutAlphabeticChar;
    public int mShortcutAlphabeticModifiers;
    public char mShortcutNumericChar;
    public int mShortcutNumericModifiers;
    public CharSequence mTitle;
    public CharSequence mTitleCondensed;
    public CharSequence mTooltipText;

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (ContextMenu.ContextMenuInfo) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (SubMenu) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (ActionProvider) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
        }
    }

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), charSequence};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mShortcutNumericModifiers = 4096;
        this.mShortcutAlphabeticModifiers = 4096;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mFlags = 16;
        this.mContext = context;
        this.mId = i2;
        this.mGroup = i;
        this.mOrdering = i4;
        this.mTitle = charSequence;
    }

    private void applyIconTint() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.mIconDrawable != null) {
            if (this.mHasIconTint || this.mHasIconTintMode) {
                Drawable wrap = DrawableCompat.wrap(this.mIconDrawable);
                this.mIconDrawable = wrap;
                Drawable mutate = wrap.mutate();
                this.mIconDrawable = mutate;
                if (this.mHasIconTint) {
                    DrawableCompat.setTintList(mutate, this.mIconTintList);
                }
                if (this.mHasIconTintMode) {
                    DrawableCompat.setTintMode(this.mIconDrawable, this.mIconTintMode);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (android.view.ActionProvider) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mShortcutAlphabeticModifiers;
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mShortcutAlphabeticChar;
        }
        return invokeV.charValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mContentDescription;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mGroup;
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mIconDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mIconTintList;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mIconTintMode;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mIntent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mId;
        }
        return invokeV.intValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mShortcutNumericModifiers;
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mShortcutNumericChar;
        }
        return invokeV.charValue;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mOrdering;
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mTitle;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            CharSequence charSequence = this.mTitleCondensed;
            if (charSequence == null) {
                return this.mTitle;
            }
            return charSequence;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mTooltipText;
        }
        return (CharSequence) invokeV.objValue;
    }

    public boolean invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mClickListener;
            if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
                return true;
            }
            Intent intent = this.mIntent;
            if (intent != null) {
                this.mContext.startActivity(intent);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if ((this.mFlags & 1) != 0) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if ((this.mFlags & 2) != 0) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if ((this.mFlags & 16) != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if ((this.mFlags & 8) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, actionProvider)) == null) {
            throw new UnsupportedOperationException();
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Character.valueOf(c)})) == null) {
            this.mShortcutAlphabeticChar = Character.toLowerCase(c);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048614, this, z)) == null) {
            this.mFlags = (z ? 1 : 0) | (this.mFlags & (-2));
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048615, this, z)) == null) {
            int i2 = this.mFlags & (-3);
            if (z) {
                i = 2;
            } else {
                i = 0;
            }
            this.mFlags = i | i2;
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
            int i2 = this.mFlags & (-17);
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
            this.mFlags = i | i2;
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    public ActionMenuItem setExclusiveCheckable(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
            int i2 = this.mFlags & (-5);
            if (z) {
                i = 4;
            } else {
                i = 0;
            }
            this.mFlags = i | i2;
            return this;
        }
        return (ActionMenuItem) invokeZ.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i)) == null) {
            this.mIconDrawable = ContextCompat.getDrawable(this.mContext, i);
            applyIconTint();
            return this;
        }
        return (MenuItem) invokeI.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, colorStateList)) == null) {
            this.mIconTintList = colorStateList;
            this.mHasIconTint = true;
            applyIconTint();
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, mode)) == null) {
            this.mIconTintMode = mode;
            this.mHasIconTintMode = true;
            applyIconTint();
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, intent)) == null) {
            this.mIntent = intent;
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048625, this, new Object[]{Character.valueOf(c)})) == null) {
            this.mShortcutNumericChar = c;
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, onActionExpandListener)) == null) {
            throw new UnsupportedOperationException();
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, onMenuItemClickListener)) == null) {
            this.mClickListener = onMenuItemClickListener;
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, actionProvider)) == null) {
            throw new UnsupportedOperationException();
        }
        return (SupportMenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i)) == null) {
            this.mTitle = this.mContext.getResources().getString(i);
            return this;
        }
        return (MenuItem) invokeI.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, charSequence)) == null) {
            this.mTitleCondensed = charSequence;
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048640, this, z)) == null) {
            int i = 8;
            int i2 = this.mFlags & 8;
            if (z) {
                i = 0;
            }
            this.mFlags = i2 | i;
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, charSequence)) == null) {
            this.mContentDescription = charSequence;
            return this;
        }
        return (SupportMenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, drawable)) == null) {
            this.mIconDrawable = drawable;
            applyIconTint();
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i)) == null) {
            setShowAsAction(i);
            return this;
        }
        return (SupportMenuItem) invokeI.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, charSequence)) == null) {
            this.mTitle = charSequence;
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, charSequence)) == null) {
            this.mTooltipText = charSequence;
            return this;
        }
        return (SupportMenuItem) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            throw new UnsupportedOperationException();
        }
        return (SupportMenuItem) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, view2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (SupportMenuItem) invokeL.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Character.valueOf(c), Integer.valueOf(i)})) == null) {
            this.mShortcutAlphabeticChar = Character.toLowerCase(c);
            this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Character.valueOf(c), Integer.valueOf(i)})) == null) {
            this.mShortcutNumericChar = c;
            this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048629, this, new Object[]{Character.valueOf(c), Character.valueOf(c2)})) == null) {
            this.mShortcutNumericChar = c;
            this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Character.valueOf(c), Character.valueOf(c2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            this.mShortcutNumericChar = c;
            this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i);
            this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
            this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i2);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }
}
