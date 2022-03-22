package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class MenuItemCompat {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;
    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    public static final String TAG = "MenuItemCompat";
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    public MenuItemCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, menuItem)) == null) ? menuItem.collapseActionView() : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean expandActionView(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, menuItem)) == null) ? menuItem.expandActionView() : invokeL.booleanValue;
    }

    public static ActionProvider getActionProvider(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, menuItem)) == null) {
            if (menuItem instanceof SupportMenuItem) {
                return ((SupportMenuItem) menuItem).getSupportActionProvider();
            }
            Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
            return null;
        }
        return (ActionProvider) invokeL.objValue;
    }

    @Deprecated
    public static View getActionView(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, menuItem)) == null) ? menuItem.getActionView() : (View) invokeL.objValue;
    }

    public static int getAlphabeticModifiers(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, menuItem)) == null) {
            if (menuItem instanceof SupportMenuItem) {
                return ((SupportMenuItem) menuItem).getAlphabeticModifiers();
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return menuItem.getAlphabeticModifiers();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static CharSequence getContentDescription(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, menuItem)) == null) {
            if (menuItem instanceof SupportMenuItem) {
                return ((SupportMenuItem) menuItem).getContentDescription();
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return menuItem.getContentDescription();
            }
            return null;
        }
        return (CharSequence) invokeL.objValue;
    }

    public static ColorStateList getIconTintList(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, menuItem)) == null) {
            if (menuItem instanceof SupportMenuItem) {
                return ((SupportMenuItem) menuItem).getIconTintList();
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return menuItem.getIconTintList();
            }
            return null;
        }
        return (ColorStateList) invokeL.objValue;
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, menuItem)) == null) {
            if (menuItem instanceof SupportMenuItem) {
                return ((SupportMenuItem) menuItem).getIconTintMode();
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return menuItem.getIconTintMode();
            }
            return null;
        }
        return (PorterDuff.Mode) invokeL.objValue;
    }

    public static int getNumericModifiers(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, menuItem)) == null) {
            if (menuItem instanceof SupportMenuItem) {
                return ((SupportMenuItem) menuItem).getNumericModifiers();
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return menuItem.getNumericModifiers();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static CharSequence getTooltipText(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, menuItem)) == null) {
            if (menuItem instanceof SupportMenuItem) {
                return ((SupportMenuItem) menuItem).getTooltipText();
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return menuItem.getTooltipText();
            }
            return null;
        }
        return (CharSequence) invokeL.objValue;
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, menuItem)) == null) ? menuItem.isActionViewExpanded() : invokeL.booleanValue;
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, menuItem, actionProvider)) == null) {
            if (menuItem instanceof SupportMenuItem) {
                return ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
            }
            Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
            return menuItem;
        }
        return (MenuItem) invokeLL.objValue;
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, menuItem, view)) == null) ? menuItem.setActionView(view) : (MenuItem) invokeLL.objValue;
    }

    public static void setAlphabeticShortcut(MenuItem menuItem, char c2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{menuItem, Character.valueOf(c2), Integer.valueOf(i)}) == null) {
            if (menuItem instanceof SupportMenuItem) {
                ((SupportMenuItem) menuItem).setAlphabeticShortcut(c2, i);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c2, i);
            }
        }
    }

    public static void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, menuItem, charSequence) == null) {
            if (menuItem instanceof SupportMenuItem) {
                ((SupportMenuItem) menuItem).setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
        }
    }

    public static void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, menuItem, colorStateList) == null) {
            if (menuItem instanceof SupportMenuItem) {
                ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintList(colorStateList);
            }
        }
    }

    public static void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, menuItem, mode) == null) {
            if (menuItem instanceof SupportMenuItem) {
                ((SupportMenuItem) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintMode(mode);
            }
        }
    }

    public static void setNumericShortcut(MenuItem menuItem, char c2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{menuItem, Character.valueOf(c2), Integer.valueOf(i)}) == null) {
            if (menuItem instanceof SupportMenuItem) {
                ((SupportMenuItem) menuItem).setNumericShortcut(c2, i);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c2, i);
            }
        }
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, menuItem, onActionExpandListener)) == null) ? menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener(onActionExpandListener) { // from class: androidx.core.view.MenuItemCompat.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ OnActionExpandListener val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {onActionExpandListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$listener = onActionExpandListener;
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionCollapse(MenuItem menuItem2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, menuItem2)) == null) ? this.val$listener.onMenuItemActionCollapse(menuItem2) : invokeL.booleanValue;
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionExpand(MenuItem menuItem2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuItem2)) == null) ? this.val$listener.onMenuItemActionExpand(menuItem2) : invokeL.booleanValue;
            }
        }) : (MenuItem) invokeLL.objValue;
    }

    public static void setShortcut(MenuItem menuItem, char c2, char c3, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{menuItem, Character.valueOf(c2), Character.valueOf(c3), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (menuItem instanceof SupportMenuItem) {
                ((SupportMenuItem) menuItem).setShortcut(c2, c3, i, i2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setShortcut(c2, c3, i, i2);
            }
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65558, null, menuItem, i) == null) {
            menuItem.setShowAsAction(i);
        }
    }

    public static void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, menuItem, charSequence) == null) {
            if (menuItem instanceof SupportMenuItem) {
                ((SupportMenuItem) menuItem).setTooltipText(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence);
            }
        }
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, menuItem, i)) == null) ? menuItem.setActionView(i) : (MenuItem) invokeLI.objValue;
    }
}
