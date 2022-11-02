package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ToolbarActionBar extends ActionBar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DecorToolbar mDecorToolbar;
    public boolean mLastMenuVisibility;
    public boolean mMenuCallbackSet;
    public final Toolbar.OnMenuItemClickListener mMenuClicker;
    public final Runnable mMenuInvalidator;
    public ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners;
    public boolean mToolbarMenuPrepared;
    public Window.Callback mWindowCallback;

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getSelectedNavigationIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, drawable) == null) {
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, drawable) == null) {
        }
    }

    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mClosingActionMenu;
        public final /* synthetic */ ToolbarActionBar this$0;

        public ActionMenuPresenterCallback(ToolbarActionBar toolbarActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toolbarActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = toolbarActionBar;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder)) == null) {
                Window.Callback callback = this.this$0.mWindowCallback;
                if (callback != null) {
                    callback.onMenuOpened(108, menuBuilder);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, menuBuilder, z) != null) || this.mClosingActionMenu) {
                return;
            }
            this.mClosingActionMenu = true;
            this.this$0.mDecorToolbar.dismissPopupMenus();
            Window.Callback callback = this.this$0.mWindowCallback;
            if (callback != null) {
                callback.onPanelClosed(108, menuBuilder);
            }
            this.mClosingActionMenu = false;
        }
    }

    /* loaded from: classes.dex */
    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ToolbarActionBar this$0;

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, menuBuilder, menuItem)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public MenuBuilderCallback(ToolbarActionBar toolbarActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toolbarActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = toolbarActionBar;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder) == null) {
                ToolbarActionBar toolbarActionBar = this.this$0;
                if (toolbarActionBar.mWindowCallback != null) {
                    if (toolbarActionBar.mDecorToolbar.isOverflowMenuShowing()) {
                        this.this$0.mWindowCallback.onPanelClosed(108, menuBuilder);
                    } else if (this.this$0.mWindowCallback.onPreparePanel(0, null, menuBuilder)) {
                        this.this$0.mWindowCallback.onMenuOpened(108, menuBuilder);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class ToolbarCallbackWrapper extends WindowCallbackWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ToolbarActionBar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ToolbarCallbackWrapper(ToolbarActionBar toolbarActionBar, Window.Callback callback) {
            super(callback);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toolbarActionBar, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Window.Callback) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = toolbarActionBar;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (i == 0) {
                    return new View(this.this$0.mDecorToolbar.getContext());
                }
                return super.onCreatePanelView(i);
            }
            return (View) invokeI.objValue;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view2, Menu menu) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, view2, menu)) == null) {
                boolean onPreparePanel = super.onPreparePanel(i, view2, menu);
                if (onPreparePanel) {
                    ToolbarActionBar toolbarActionBar = this.this$0;
                    if (!toolbarActionBar.mToolbarMenuPrepared) {
                        toolbarActionBar.mDecorToolbar.setMenuPrepared();
                        this.this$0.mToolbarMenuPrepared = true;
                    }
                }
                return onPreparePanel;
            }
            return invokeILL.booleanValue;
        }
    }

    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {toolbar, charSequence, callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMenuVisibilityListeners = new ArrayList<>();
        this.mMenuInvalidator = new Runnable(this) { // from class: androidx.appcompat.app.ToolbarActionBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ToolbarActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.populateOptionsMenu();
                }
            }
        };
        this.mMenuClicker = new Toolbar.OnMenuItemClickListener(this) { // from class: androidx.appcompat.app.ToolbarActionBar.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ToolbarActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, menuItem)) == null) {
                    return this.this$0.mWindowCallback.onMenuItemSelected(0, menuItem);
                }
                return invokeL.booleanValue;
            }
        };
        this.mDecorToolbar = new ToolbarWidgetWrapper(toolbar, false);
        ToolbarCallbackWrapper toolbarCallbackWrapper = new ToolbarCallbackWrapper(this, callback);
        this.mWindowCallback = toolbarCallbackWrapper;
        this.mDecorToolbar.setWindowCallback(toolbarCallbackWrapper);
        toolbar.setOnMenuItemClickListener(this.mMenuClicker);
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    private Menu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (!this.mMenuCallbackSet) {
                this.mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(this), new MenuBuilderCallback(this));
                this.mMenuCallbackSet = true;
            }
            return this.mDecorToolbar.getMenu();
        }
        return (Menu) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean closeOptionsMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mDecorToolbar.hideOverflowMenu();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mDecorToolbar.hasExpandedActionView()) {
                this.mDecorToolbar.collapseActionView();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public View getCustomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mDecorToolbar.getCustomView();
        }
        return (View) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mDecorToolbar.getDisplayOptions();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ViewCompat.getElevation(this.mDecorToolbar.getViewGroup());
        }
        return invokeV.floatValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mDecorToolbar.getHeight();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
        return (ActionBar.Tab) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mDecorToolbar.getSubtitle();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mDecorToolbar.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mDecorToolbar.getTitle();
        }
        return (CharSequence) invokeV.objValue;
    }

    public Window.Callback getWrappedWindowCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mWindowCallback;
        }
        return (Window.Callback) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.mDecorToolbar.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean invalidateOptionsMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
            ViewCompat.postOnAnimation(this.mDecorToolbar.getViewGroup(), this.mMenuInvalidator);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.mDecorToolbar.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return super.isTitleTruncated();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
        return (ActionBar.Tab) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean openOptionsMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mDecorToolbar.showOverflowMenu();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
            if (viewGroup != null && !viewGroup.hasFocus()) {
                viewGroup.requestFocus();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.mDecorToolbar.setVisibility(0);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onMenuVisibilityListener) == null) {
            this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048583, this, z) != null) || z == this.mLastMenuVisibility) {
            return;
        }
        this.mLastMenuVisibility = z;
        int size = this.mMenuVisibilityListeners.size();
        for (int i = 0; i < size; i++) {
            this.mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
        return (ActionBar.Tab) invokeI.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, keyEvent)) == null) {
            if (keyEvent.getAction() == 1) {
                openOptionsMenu();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onMenuVisibilityListener) == null) {
            this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, tab) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, tab) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, drawable) == null) {
            this.mDecorToolbar.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            setCustomView(LayoutInflater.from(this.mDecorToolbar.getContext()).inflate(i, this.mDecorToolbar.getViewGroup(), false));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            if (z) {
                i = 4;
            } else {
                i = 0;
            }
            setDisplayOptions(i, 4);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    @SuppressLint({"WrongConstant"})
    public void setDisplayOptions(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            setDisplayOptions(i, -1);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
            setDisplayOptions(i, 16);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            if (z) {
                i = 2;
            } else {
                i = 0;
            }
            setDisplayOptions(i, 2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            setDisplayOptions(i, 8);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            setDisplayOptions(z ? 1 : 0, 1);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048627, this, f) == null) {
            ViewCompat.setElevation(this.mDecorToolbar.getViewGroup(), f);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            this.mDecorToolbar.setNavigationContentDescription(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.mDecorToolbar.setNavigationIcon(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            this.mDecorToolbar.setIcon(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.mDecorToolbar.setLogo(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            if (i != 2) {
                this.mDecorToolbar.setNavigationMode(i);
                return;
            }
            throw new IllegalArgumentException("Tabs not supported in this configuration");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            if (this.mDecorToolbar.getNavigationMode() == 1) {
                this.mDecorToolbar.setDropdownSelectedPosition(i);
                return;
            }
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int i) {
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i) == null) {
            DecorToolbar decorToolbar = this.mDecorToolbar;
            if (i != 0) {
                charSequence = decorToolbar.getContext().getText(i);
            } else {
                charSequence = null;
            }
            decorToolbar.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int i) {
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            DecorToolbar decorToolbar = this.mDecorToolbar;
            if (i != 0) {
                charSequence = decorToolbar.getContext().getText(i);
            } else {
                charSequence = null;
            }
            decorToolbar.setTitle(charSequence);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, charSequence) == null) {
            this.mDecorToolbar.setWindowTitle(charSequence);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tab, i) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view2, ActionBar.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, view2, layoutParams) == null) {
            if (view2 != null) {
                view2.setLayoutParams(layoutParams);
            }
            this.mDecorToolbar.setCustomView(view2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048622, this, i, i2) == null) {
            this.mDecorToolbar.setDisplayOptions((i & i2) | ((~i2) & this.mDecorToolbar.getDisplayOptions()));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, spinnerAdapter, onNavigationListener) == null) {
            this.mDecorToolbar.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tab, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, tab, z) == null) {
            throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i, keyEvent)) == null) {
            Menu menu = getMenu();
            if (menu == null) {
                return false;
            }
            if (keyEvent != null) {
                i2 = keyEvent.getDeviceId();
            } else {
                i2 = -1;
            }
            boolean z = true;
            if (KeyCharacterMap.load(i2).getKeyboardType() == 1) {
                z = false;
            }
            menu.setQwertyMode(z);
            return menu.performShortcut(i, keyEvent, 0);
        }
        return invokeIL.booleanValue;
    }

    public void populateOptionsMenu() {
        MenuBuilder menuBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            Menu menu = getMenu();
            if (menu instanceof MenuBuilder) {
                menuBuilder = (MenuBuilder) menu;
            } else {
                menuBuilder = null;
            }
            if (menuBuilder != null) {
                menuBuilder.stopDispatchingItemsChanged();
            }
            try {
                menu.clear();
                if (!this.mWindowCallback.onCreatePanelMenu(0, menu) || !this.mWindowCallback.onPreparePanel(0, null, menu)) {
                    menu.clear();
                }
            } finally {
                if (menuBuilder != null) {
                    menuBuilder.startDispatchingItemsChanged();
                }
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            setCustomView(view2, new ActionBar.LayoutParams(-2, -2));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, charSequence) == null) {
            this.mDecorToolbar.setNavigationContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, drawable) == null) {
            this.mDecorToolbar.setNavigationIcon(drawable);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, drawable) == null) {
            this.mDecorToolbar.setIcon(drawable);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, drawable) == null) {
            this.mDecorToolbar.setLogo(drawable);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, charSequence) == null) {
            this.mDecorToolbar.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, charSequence) == null) {
            this.mDecorToolbar.setTitle(charSequence);
        }
    }
}
