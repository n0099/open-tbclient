package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long FADE_IN_DURATION_MS = 200;
    public static final long FADE_OUT_DURATION_MS = 100;
    public static final int INVALID_POSITION = -1;
    public static final String TAG = "WindowDecorActionBar";
    public static final Interpolator sHideInterpolator;
    public static final Interpolator sShowInterpolator;
    public transient /* synthetic */ FieldHolder $fh;
    public ActionModeImpl mActionMode;
    public Activity mActivity;
    public ActionBarContainer mContainerView;
    public boolean mContentAnimations;
    public View mContentView;
    public Context mContext;
    public ActionBarContextView mContextView;
    public int mCurWindowVisibility;
    public ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    public DecorToolbar mDecorToolbar;
    public ActionMode mDeferredDestroyActionMode;
    public ActionMode.Callback mDeferredModeDestroyCallback;
    public boolean mDisplayHomeAsUpSet;
    public boolean mHasEmbeddedTabs;
    public boolean mHiddenByApp;
    public boolean mHiddenBySystem;
    public final ViewPropertyAnimatorListener mHideListener;
    public boolean mHideOnContentScroll;
    public boolean mLastMenuVisibility;
    public ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners;
    public boolean mNowShowing;
    public ActionBarOverlayLayout mOverlayLayout;
    public int mSavedTabPosition;
    public TabImpl mSelectedTab;
    public boolean mShowHideAnimationEnabled;
    public final ViewPropertyAnimatorListener mShowListener;
    public boolean mShowingForMode;
    public ScrollingTabContainerView mTabScrollView;
    public ArrayList<TabImpl> mTabs;
    public Context mThemedContext;
    public final ViewPropertyAnimatorUpdateListener mUpdateListener;

    public static boolean checkShowingFlags(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (z3) {
                return true;
            }
            return (z || z2) ? false : true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, drawable) == null) {
        }
    }

    /* loaded from: classes.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mActionModeContext;
        public ActionMode.Callback mCallback;
        public WeakReference<View> mCustomView;
        public final MenuBuilder mMenu;
        public final /* synthetic */ WindowDecorActionBar this$0;

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048585, this, menuBuilder, z) == null) {
            }
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, subMenuBuilder) == null) {
            }
        }

        public ActionModeImpl(WindowDecorActionBar windowDecorActionBar, Context context, ActionMode.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowDecorActionBar, context, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = windowDecorActionBar;
            this.mActionModeContext = context;
            this.mCallback = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.mMenu = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.mMenu.stopDispatchingItemsChanged();
                try {
                    return this.mCallback.onCreateActionMode(this, this.mMenu);
                } finally {
                    this.mMenu.startDispatchingItemsChanged();
                }
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public View getCustomView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                WeakReference<View> weakReference = this.mCustomView;
                if (weakReference != null) {
                    return weakReference.get();
                }
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public Menu getMenu() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mMenu;
            }
            return (Menu) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public MenuInflater getMenuInflater() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return new SupportMenuInflater(this.mActionModeContext);
            }
            return (MenuInflater) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getSubtitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.this$0.mContextView.getSubtitle();
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.this$0.mContextView.getTitle();
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void invalidate() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.this$0.mActionMode != this) {
                return;
            }
            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public boolean isTitleOptional() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.this$0.mContextView.isTitleOptional();
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void finish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                WindowDecorActionBar windowDecorActionBar = this.this$0;
                if (windowDecorActionBar.mActionMode != this) {
                    return;
                }
                if (!WindowDecorActionBar.checkShowingFlags(windowDecorActionBar.mHiddenByApp, windowDecorActionBar.mHiddenBySystem, false)) {
                    WindowDecorActionBar windowDecorActionBar2 = this.this$0;
                    windowDecorActionBar2.mDeferredDestroyActionMode = this;
                    windowDecorActionBar2.mDeferredModeDestroyCallback = this.mCallback;
                } else {
                    this.mCallback.onDestroyActionMode(this);
                }
                this.mCallback = null;
                this.this$0.animateToMode(false);
                this.this$0.mContextView.closeMode();
                this.this$0.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
                WindowDecorActionBar windowDecorActionBar3 = this.this$0;
                windowDecorActionBar3.mOverlayLayout.setHideOnContentScrollEnabled(windowDecorActionBar3.mHideOnContentScroll);
                this.this$0.mActionMode = null;
            }
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, menuBuilder, menuItem)) == null) {
                ActionMode.Callback callback = this.mCallback;
                if (callback != null) {
                    return callback.onActionItemClicked(this, menuItem);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, menuBuilder) != null) || this.mCallback == null) {
                return;
            }
            invalidate();
            this.this$0.mContextView.showOverflowMenu();
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, subMenuBuilder)) == null) {
                if (this.mCallback == null) {
                    return false;
                }
                if (!subMenuBuilder.hasVisibleItems()) {
                    return true;
                }
                new MenuPopupHelper(this.this$0.getThemedContext(), subMenuBuilder).show();
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setCustomView(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
                this.this$0.mContextView.setCustomView(view2);
                this.mCustomView = new WeakReference<>(view2);
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
                setSubtitle(this.this$0.mContext.getResources().getString(i));
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
                setTitle(this.this$0.mContext.getResources().getString(i));
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitleOptionalHint(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
                super.setTitleOptionalHint(z);
                this.this$0.mContextView.setTitleOptional(z);
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, charSequence) == null) {
                this.this$0.mContextView.setSubtitle(charSequence);
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, charSequence) == null) {
                this.this$0.mContextView.setTitle(charSequence);
            }
        }
    }

    /* loaded from: classes.dex */
    public class TabImpl extends ActionBar.Tab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ActionBar.TabListener mCallback;
        public CharSequence mContentDesc;
        public View mCustomView;
        public Drawable mIcon;
        public int mPosition;
        public Object mTag;
        public CharSequence mText;
        public final /* synthetic */ WindowDecorActionBar this$0;

        public TabImpl(WindowDecorActionBar windowDecorActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowDecorActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = windowDecorActionBar;
            this.mPosition = -1;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                return setContentDescription(this.this$0.mContext.getResources().getText(i));
            }
            return (ActionBar.Tab) invokeI.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                return setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(i, (ViewGroup) null));
            }
            return (ActionBar.Tab) invokeI.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                return setIcon(AppCompatResources.getDrawable(this.this$0.mContext, i));
            }
            return (ActionBar.Tab) invokeI.objValue;
        }

        public void setPosition(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
                this.mPosition = i;
            }
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, tabListener)) == null) {
                this.mCallback = tabListener;
                return this;
            }
            return (ActionBar.Tab) invokeL.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
                this.mTag = obj;
                return this;
            }
            return (ActionBar.Tab) invokeL.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
                return setText(this.this$0.mContext.getResources().getText(i));
            }
            return (ActionBar.Tab) invokeI.objValue;
        }

        public ActionBar.TabListener getCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mCallback;
            }
            return (ActionBar.TabListener) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getContentDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mContentDesc;
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public View getCustomView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mCustomView;
            }
            return (View) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Drawable getIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mIcon;
            }
            return (Drawable) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public int getPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mPosition;
            }
            return invokeV.intValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Object getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mTag;
            }
            return invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mText;
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public void select() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.this$0.selectTab(this);
            }
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, charSequence)) == null) {
                this.mContentDesc = charSequence;
                int i = this.mPosition;
                if (i >= 0) {
                    this.this$0.mTabScrollView.updateTab(i);
                }
                return this;
            }
            return (ActionBar.Tab) invokeL.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, view2)) == null) {
                this.mCustomView = view2;
                int i = this.mPosition;
                if (i >= 0) {
                    this.this$0.mTabScrollView.updateTab(i);
                }
                return this;
            }
            return (ActionBar.Tab) invokeL.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, drawable)) == null) {
                this.mIcon = drawable;
                int i = this.mPosition;
                if (i >= 0) {
                    this.this$0.mTabScrollView.updateTab(i);
                }
                return this;
            }
            return (ActionBar.Tab) invokeL.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charSequence)) == null) {
                this.mText = charSequence;
                int i = this.mPosition;
                if (i >= 0) {
                    this.this$0.mTabScrollView.updateTab(i);
                }
                return this;
            }
            return (ActionBar.Tab) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2092952961, "Landroidx/appcompat/app/WindowDecorActionBar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2092952961, "Landroidx/appcompat/app/WindowDecorActionBar;");
                return;
            }
        }
        sHideInterpolator = new AccelerateInterpolator();
        sShowInterpolator = new DecelerateInterpolator();
    }

    private void cleanupTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (this.mSelectedTab != null) {
                selectTab(null);
            }
            this.mTabs.clear();
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (scrollingTabContainerView != null) {
                scrollingTabContainerView.removeAllTabs();
            }
            this.mSavedTabPosition = -1;
        }
    }

    private void hideForActionMode() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
    }

    private boolean shouldAnimateContextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            return ViewCompat.isLaidOut(this.mContainerView);
        }
        return invokeV.booleanValue;
    }

    private void showForActionMode() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && !this.mShowingForMode) {
            this.mShowingForMode = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            updateVisibility(false);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            DecorToolbar decorToolbar = this.mDecorToolbar;
            if (decorToolbar != null && decorToolbar.hasExpandedActionView()) {
                this.mDecorToolbar.collapseActionView();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void completeDeferredDestroyActionMode() {
        ActionMode.Callback callback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (callback = this.mDeferredModeDestroyCallback) != null) {
            callback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public View getCustomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mDecorToolbar.getCustomView();
        }
        return (View) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mDecorToolbar.getDisplayOptions();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return ViewCompat.getElevation(this.mContainerView);
        }
        return invokeV.floatValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mContainerView.getHeight();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHideOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mOverlayLayout.getActionBarHideOffset();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int navigationMode = this.mDecorToolbar.getNavigationMode();
            if (navigationMode != 1) {
                if (navigationMode != 2) {
                    return 0;
                }
                return this.mTabs.size();
            }
            return this.mDecorToolbar.getDropdownItemCount();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mDecorToolbar.getNavigationMode();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getSelectedNavigationIndex() {
        InterceptResult invokeV;
        TabImpl tabImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int navigationMode = this.mDecorToolbar.getNavigationMode();
            if (navigationMode != 1) {
                if (navigationMode != 2 || (tabImpl = this.mSelectedTab) == null) {
                    return -1;
                }
                return tabImpl.getPosition();
            }
            return this.mDecorToolbar.getDropdownSelectedPosition();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mSelectedTab;
        }
        return (ActionBar.Tab) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mDecorToolbar.getSubtitle();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mTabs.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mDecorToolbar.getTitle();
        }
        return (CharSequence) invokeV.objValue;
    }

    public boolean hasIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mDecorToolbar.hasIcon();
        }
        return invokeV.booleanValue;
    }

    public boolean hasLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mDecorToolbar.hasLogo();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && !this.mHiddenByApp) {
            this.mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && !this.mHiddenBySystem) {
            this.mHiddenBySystem = true;
            updateVisibility(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mOverlayLayout.isHideOnContentScrollEnabled();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            int height = getHeight();
            if (this.mNowShowing && (height == 0 || getHideOffset() < height)) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            DecorToolbar decorToolbar = this.mDecorToolbar;
            if (decorToolbar != null && decorToolbar.isTitleTruncated()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return new TabImpl(this);
        }
        return (ActionBar.Tab) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) != null) {
            viewPropertyAnimatorCompatSet.cancel();
            this.mCurrentShowAnim = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            cleanupTabs();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && this.mHiddenByApp) {
            this.mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && this.mHiddenBySystem) {
            this.mHiddenBySystem = false;
            updateVisibility(true);
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTabs = new ArrayList<>();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList<>();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new ViewPropertyAnimatorListenerAdapter(this) { // from class: androidx.appcompat.app.WindowDecorActionBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WindowDecorActionBar this$0;

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

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view2) {
                View view3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    WindowDecorActionBar windowDecorActionBar = this.this$0;
                    if (windowDecorActionBar.mContentAnimations && (view3 = windowDecorActionBar.mContentView) != null) {
                        view3.setTranslationY(0.0f);
                        this.this$0.mContainerView.setTranslationY(0.0f);
                    }
                    this.this$0.mContainerView.setVisibility(8);
                    this.this$0.mContainerView.setTransitioning(false);
                    WindowDecorActionBar windowDecorActionBar2 = this.this$0;
                    windowDecorActionBar2.mCurrentShowAnim = null;
                    windowDecorActionBar2.completeDeferredDestroyActionMode();
                    ActionBarOverlayLayout actionBarOverlayLayout = this.this$0.mOverlayLayout;
                    if (actionBarOverlayLayout != null) {
                        ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    }
                }
            }
        };
        this.mShowListener = new ViewPropertyAnimatorListenerAdapter(this) { // from class: androidx.appcompat.app.WindowDecorActionBar.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WindowDecorActionBar this$0;

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

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    WindowDecorActionBar windowDecorActionBar = this.this$0;
                    windowDecorActionBar.mCurrentShowAnim = null;
                    windowDecorActionBar.mContainerView.requestLayout();
                }
            }
        };
        this.mUpdateListener = new ViewPropertyAnimatorUpdateListener(this) { // from class: androidx.appcompat.app.WindowDecorActionBar.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WindowDecorActionBar this$0;

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

            @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
            public void onAnimationUpdate(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ((View) this.this$0.mContainerView.getParent()).invalidate();
                }
            }
        };
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (!z) {
            this.mContentView = decorView.findViewById(16908290);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dialog};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mTabs = new ArrayList<>();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList<>();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new ViewPropertyAnimatorListenerAdapter(this) { // from class: androidx.appcompat.app.WindowDecorActionBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WindowDecorActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
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

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view2) {
                View view3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    WindowDecorActionBar windowDecorActionBar = this.this$0;
                    if (windowDecorActionBar.mContentAnimations && (view3 = windowDecorActionBar.mContentView) != null) {
                        view3.setTranslationY(0.0f);
                        this.this$0.mContainerView.setTranslationY(0.0f);
                    }
                    this.this$0.mContainerView.setVisibility(8);
                    this.this$0.mContainerView.setTransitioning(false);
                    WindowDecorActionBar windowDecorActionBar2 = this.this$0;
                    windowDecorActionBar2.mCurrentShowAnim = null;
                    windowDecorActionBar2.completeDeferredDestroyActionMode();
                    ActionBarOverlayLayout actionBarOverlayLayout = this.this$0.mOverlayLayout;
                    if (actionBarOverlayLayout != null) {
                        ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    }
                }
            }
        };
        this.mShowListener = new ViewPropertyAnimatorListenerAdapter(this) { // from class: androidx.appcompat.app.WindowDecorActionBar.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WindowDecorActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
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

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    WindowDecorActionBar windowDecorActionBar = this.this$0;
                    windowDecorActionBar.mCurrentShowAnim = null;
                    windowDecorActionBar.mContainerView.requestLayout();
                }
            }
        };
        this.mUpdateListener = new ViewPropertyAnimatorUpdateListener(this) { // from class: androidx.appcompat.app.WindowDecorActionBar.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WindowDecorActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
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

            @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
            public void onAnimationUpdate(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ((View) this.this$0.mContainerView.getParent()).invalidate();
                }
            }
        };
        init(dialog.getWindow().getDecorView());
    }

    private void setHasEmbeddedTabs(boolean z) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            this.mHasEmbeddedTabs = z;
            if (!z) {
                this.mDecorToolbar.setEmbeddedTabView(null);
                this.mContainerView.setTabContainer(this.mTabScrollView);
            } else {
                this.mContainerView.setTabContainer(null);
                this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
            }
            boolean z4 = true;
            if (getNavigationMode() == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (scrollingTabContainerView != null) {
                if (z2) {
                    scrollingTabContainerView.setVisibility(0);
                    ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                    if (actionBarOverlayLayout != null) {
                        ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
            }
            DecorToolbar decorToolbar = this.mDecorToolbar;
            if (!this.mHasEmbeddedTabs && z2) {
                z3 = true;
            } else {
                z3 = false;
            }
            decorToolbar.setCollapsible(z3);
            this.mOverlayLayout.setHasNonEmbeddedTabs((this.mHasEmbeddedTabs || !z2) ? false : false);
        }
    }

    public void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                showForActionMode();
            } else {
                hideForActionMode();
            }
            if (shouldAnimateContextView()) {
                if (z) {
                    viewPropertyAnimatorCompat2 = this.mDecorToolbar.setupAnimatorToVisibility(4, 100L);
                    viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(0, 200L);
                } else {
                    viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(0, 200L);
                    viewPropertyAnimatorCompat2 = this.mContextView.setupAnimatorToVisibility(8, 100L);
                }
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
                viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
                viewPropertyAnimatorCompatSet.start();
            } else if (z) {
                this.mDecorToolbar.setVisibility(4);
                this.mContextView.setVisibility(0);
            } else {
                this.mDecorToolbar.setVisibility(0);
                this.mContextView.setVisibility(8);
            }
        }
    }

    public void doHide(boolean z) {
        View view2;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
            if (viewPropertyAnimatorCompatSet != null) {
                viewPropertyAnimatorCompatSet.cancel();
            }
            if (this.mCurWindowVisibility == 0 && (this.mShowHideAnimationEnabled || z)) {
                this.mContainerView.setAlpha(1.0f);
                this.mContainerView.setTransitioning(true);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
                float f = -this.mContainerView.getHeight();
                if (z) {
                    this.mContainerView.getLocationInWindow(new int[]{0, 0});
                    f -= iArr[1];
                }
                ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.mContainerView).translationY(f);
                translationY.setUpdateListener(this.mUpdateListener);
                viewPropertyAnimatorCompatSet2.play(translationY);
                if (this.mContentAnimations && (view2 = this.mContentView) != null) {
                    viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view2).translationY(f));
                }
                viewPropertyAnimatorCompatSet2.setInterpolator(sHideInterpolator);
                viewPropertyAnimatorCompatSet2.setDuration(250L);
                viewPropertyAnimatorCompatSet2.setListener(this.mHideListener);
                this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
                viewPropertyAnimatorCompatSet2.start();
                return;
            }
            this.mHideListener.onAnimationEnd(null);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int i) {
        int i2;
        TabImpl tabImpl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048618, this, i) != null) || this.mTabScrollView == null) {
            return;
        }
        TabImpl tabImpl2 = this.mSelectedTab;
        if (tabImpl2 != null) {
            i2 = tabImpl2.getPosition();
        } else {
            i2 = this.mSavedTabPosition;
        }
        this.mTabScrollView.removeTabAt(i);
        TabImpl remove = this.mTabs.remove(i);
        if (remove != null) {
            remove.setPosition(-1);
        }
        int size = this.mTabs.size();
        for (int i3 = i; i3 < size; i3++) {
            this.mTabs.get(i3).setPosition(i3);
        }
        if (i2 == i) {
            if (this.mTabs.isEmpty()) {
                tabImpl = null;
            } else {
                tabImpl = this.mTabs.get(Math.max(0, i - 1));
            }
            selectTab(tabImpl);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        FragmentTransaction fragmentTransaction;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, tab) == null) {
            int i = -1;
            if (getNavigationMode() != 2) {
                if (tab != null) {
                    i = tab.getPosition();
                }
                this.mSavedTabPosition = i;
                return;
            }
            if ((this.mActivity instanceof FragmentActivity) && !this.mDecorToolbar.getViewGroup().isInEditMode()) {
                fragmentTransaction = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            } else {
                fragmentTransaction = null;
            }
            TabImpl tabImpl = this.mSelectedTab;
            if (tabImpl == tab) {
                if (tabImpl != null) {
                    tabImpl.getCallback().onTabReselected(this.mSelectedTab, fragmentTransaction);
                    this.mTabScrollView.animateToTab(tab.getPosition());
                }
            } else {
                ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
                if (tab != null) {
                    i = tab.getPosition();
                }
                scrollingTabContainerView.setTabSelected(i);
                TabImpl tabImpl2 = this.mSelectedTab;
                if (tabImpl2 != null) {
                    tabImpl2.getCallback().onTabUnselected(this.mSelectedTab, fragmentTransaction);
                }
                TabImpl tabImpl3 = (TabImpl) tab;
                this.mSelectedTab = tabImpl3;
                if (tabImpl3 != null) {
                    tabImpl3.getCallback().onTabSelected(this.mSelectedTab, fragmentTransaction);
                }
            }
            if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
                fragmentTransaction.commit();
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int i) {
        boolean z;
        ActionBarOverlayLayout actionBarOverlayLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i) == null) {
            int navigationMode = this.mDecorToolbar.getNavigationMode();
            if (navigationMode == 2) {
                this.mSavedTabPosition = getSelectedNavigationIndex();
                selectTab(null);
                this.mTabScrollView.setVisibility(8);
            }
            if (navigationMode != i && !this.mHasEmbeddedTabs && (actionBarOverlayLayout = this.mOverlayLayout) != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
            this.mDecorToolbar.setNavigationMode(i);
            boolean z2 = false;
            if (i == 2) {
                ensureTabsExist();
                this.mTabScrollView.setVisibility(0);
                int i2 = this.mSavedTabPosition;
                if (i2 != -1) {
                    setSelectedNavigationItem(i2);
                    this.mSavedTabPosition = -1;
                }
            }
            DecorToolbar decorToolbar = this.mDecorToolbar;
            if (i == 2 && !this.mHasEmbeddedTabs) {
                z = true;
            } else {
                z = false;
            }
            decorToolbar.setCollapsible(z);
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
            if (i == 2 && !this.mHasEmbeddedTabs) {
                z2 = true;
            }
            actionBarOverlayLayout2.setHasNonEmbeddedTabs(z2);
        }
    }

    public WindowDecorActionBar(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mTabs = new ArrayList<>();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList<>();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new ViewPropertyAnimatorListenerAdapter(this) { // from class: androidx.appcompat.app.WindowDecorActionBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WindowDecorActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
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

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view22) {
                View view3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view22) == null) {
                    WindowDecorActionBar windowDecorActionBar = this.this$0;
                    if (windowDecorActionBar.mContentAnimations && (view3 = windowDecorActionBar.mContentView) != null) {
                        view3.setTranslationY(0.0f);
                        this.this$0.mContainerView.setTranslationY(0.0f);
                    }
                    this.this$0.mContainerView.setVisibility(8);
                    this.this$0.mContainerView.setTransitioning(false);
                    WindowDecorActionBar windowDecorActionBar2 = this.this$0;
                    windowDecorActionBar2.mCurrentShowAnim = null;
                    windowDecorActionBar2.completeDeferredDestroyActionMode();
                    ActionBarOverlayLayout actionBarOverlayLayout = this.this$0.mOverlayLayout;
                    if (actionBarOverlayLayout != null) {
                        ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    }
                }
            }
        };
        this.mShowListener = new ViewPropertyAnimatorListenerAdapter(this) { // from class: androidx.appcompat.app.WindowDecorActionBar.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WindowDecorActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
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

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view22) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view22) == null) {
                    WindowDecorActionBar windowDecorActionBar = this.this$0;
                    windowDecorActionBar.mCurrentShowAnim = null;
                    windowDecorActionBar.mContainerView.requestLayout();
                }
            }
        };
        this.mUpdateListener = new ViewPropertyAnimatorUpdateListener(this) { // from class: androidx.appcompat.app.WindowDecorActionBar.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WindowDecorActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
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

            @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
            public void onAnimationUpdate(View view22) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view22) == null) {
                    ((View) this.this$0.mContainerView.getParent()).invalidate();
                }
            }
        };
        init(view2);
    }

    private DecorToolbar getDecorToolbar(View view2) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, view2)) == null) {
            if (view2 instanceof DecorToolbar) {
                return (DecorToolbar) view2;
            }
            if (view2 instanceof Toolbar) {
                return ((Toolbar) view2).getWrapper();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Can't make a decor toolbar out of ");
            if (view2 != null) {
                str = view2.getClass().getSimpleName();
            } else {
                str = StringUtil.NULL_STRING;
            }
            sb.append(str);
            throw new IllegalStateException(sb.toString());
        }
        return (DecorToolbar) invokeL.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, callback)) == null) {
            ActionModeImpl actionModeImpl = this.mActionMode;
            if (actionModeImpl != null) {
                actionModeImpl.finish();
            }
            this.mOverlayLayout.setHideOnContentScrollEnabled(false);
            this.mContextView.killMode();
            ActionModeImpl actionModeImpl2 = new ActionModeImpl(this, this.mContextView.getContext(), callback);
            if (actionModeImpl2.dispatchOnCreate()) {
                this.mActionMode = actionModeImpl2;
                actionModeImpl2.invalidate();
                this.mContextView.initForMode(actionModeImpl2);
                animateToMode(true);
                this.mContextView.sendAccessibilityEvent(32);
                return actionModeImpl2;
            }
            return null;
        }
        return (ActionMode) invokeL.objValue;
    }

    private void configureTab(ActionBar.Tab tab, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, this, tab, i) == null) {
            TabImpl tabImpl = (TabImpl) tab;
            if (tabImpl.getCallback() != null) {
                tabImpl.setPosition(i);
                this.mTabs.add(i, tabImpl);
                int size = this.mTabs.size();
                while (true) {
                    i++;
                    if (i < size) {
                        this.mTabs.get(i).setPosition(i);
                    } else {
                        return;
                    }
                }
            } else {
                throw new IllegalStateException("Action Bar Tab must have a Callback");
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Menu menu;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i, keyEvent)) == null) {
            ActionModeImpl actionModeImpl = this.mActionMode;
            if (actionModeImpl == null || (menu = actionModeImpl.getMenu()) == null) {
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

    private void ensureTabsExist() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, this) != null) || this.mTabScrollView != null) {
            return;
        }
        ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
        if (this.mHasEmbeddedTabs) {
            scrollingTabContainerView.setVisibility(0);
            this.mDecorToolbar.setEmbeddedTabView(scrollingTabContainerView);
        } else {
            if (getNavigationMode() == 2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
            this.mContainerView.setTabContainer(scrollingTabContainerView);
        }
        this.mTabScrollView = scrollingTabContainerView;
    }

    private void init(View view2) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, view2) == null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view2.findViewById(R.id.obfuscated_res_0x7f090783);
            this.mOverlayLayout = actionBarOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setActionBarVisibilityCallback(this);
            }
            this.mDecorToolbar = getDecorToolbar(view2.findViewById(R.id.obfuscated_res_0x7f09005b));
            this.mContextView = (ActionBarContextView) view2.findViewById(R.id.obfuscated_res_0x7f090064);
            ActionBarContainer actionBarContainer = (ActionBarContainer) view2.findViewById(R.id.obfuscated_res_0x7f09005d);
            this.mContainerView = actionBarContainer;
            DecorToolbar decorToolbar = this.mDecorToolbar;
            if (decorToolbar != null && this.mContextView != null && actionBarContainer != null) {
                this.mContext = decorToolbar.getContext();
                if ((this.mDecorToolbar.getDisplayOptions() & 4) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.mDisplayHomeAsUpSet = true;
                }
                ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.mContext);
                if (!actionBarPolicy.enableHomeButtonByDefault() && !z) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                setHomeButtonEnabled(z2);
                setHasEmbeddedTabs(actionBarPolicy.hasEmbeddedTabs());
                TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, R.attr.obfuscated_res_0x7f04004f, 0);
                if (obtainStyledAttributes.getBoolean(14, false)) {
                    setHideOnContentScrollEnabled(true);
                }
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
                if (dimensionPixelSize != 0) {
                    setElevation(dimensionPixelSize);
                }
                obtainStyledAttributes.recycle();
                return;
            }
            throw new IllegalStateException(WindowDecorActionBar.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
    }

    public void doShow(boolean z) {
        View view2;
        View view3;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
            if (viewPropertyAnimatorCompatSet != null) {
                viewPropertyAnimatorCompatSet.cancel();
            }
            this.mContainerView.setVisibility(0);
            if (this.mCurWindowVisibility == 0 && (this.mShowHideAnimationEnabled || z)) {
                this.mContainerView.setTranslationY(0.0f);
                float f = -this.mContainerView.getHeight();
                if (z) {
                    this.mContainerView.getLocationInWindow(new int[]{0, 0});
                    f -= iArr[1];
                }
                this.mContainerView.setTranslationY(f);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
                ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.mContainerView).translationY(0.0f);
                translationY.setUpdateListener(this.mUpdateListener);
                viewPropertyAnimatorCompatSet2.play(translationY);
                if (this.mContentAnimations && (view3 = this.mContentView) != null) {
                    view3.setTranslationY(f);
                    viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(this.mContentView).translationY(0.0f));
                }
                viewPropertyAnimatorCompatSet2.setInterpolator(sShowInterpolator);
                viewPropertyAnimatorCompatSet2.setDuration(250L);
                viewPropertyAnimatorCompatSet2.setListener(this.mShowListener);
                this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
                viewPropertyAnimatorCompatSet2.start();
            } else {
                this.mContainerView.setAlpha(1.0f);
                this.mContainerView.setTranslationY(0.0f);
                if (this.mContentAnimations && (view2 = this.mContentView) != null) {
                    view2.setTranslationY(0.0f);
                }
                this.mShowListener.onAnimationEnd(null);
            }
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    }

    private void updateVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, this, z) == null) {
            if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
                if (!this.mNowShowing) {
                    this.mNowShowing = true;
                    doShow(z);
                }
            } else if (this.mNowShowing) {
                this.mNowShowing = false;
                doHide(z);
            }
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
            addTab(tab, this.mTabs.isEmpty());
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) != null) || z == this.mLastMenuVisibility) {
            return;
        }
        this.mLastMenuVisibility = z;
        int size = this.mMenuVisibilityListeners.size();
        for (int i = 0; i < size; i++) {
            this.mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(z);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mContentAnimations = z;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return this.mTabs.get(i);
        }
        return (ActionBar.Tab) invokeI.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, configuration) == null) {
            setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.mCurWindowVisibility = i;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onMenuVisibilityListener) == null) {
            this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, tab) == null) {
            removeTabAt(tab.getPosition());
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, drawable) == null) {
            this.mContainerView.setPrimaryBackground(drawable);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.mDecorToolbar.getViewGroup(), false));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048625, this, z) == null) && !this.mDisplayHomeAsUpSet) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            if (z) {
                i = 4;
            } else {
                i = 0;
            }
            setDisplayOptions(i, 4);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            if ((i & 4) != 0) {
                this.mDisplayHomeAsUpSet = true;
            }
            this.mDecorToolbar.setDisplayOptions(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            setDisplayOptions(z ? 1 : 0, 1);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048633, this, f) == null) {
            ViewCompat.setElevation(this.mContainerView, f);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
            if (i != 0 && !this.mOverlayLayout.isInOverlayMode()) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
            }
            this.mOverlayLayout.setActionBarHideOffset(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (z && !this.mOverlayLayout.isInOverlayMode()) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.mHideOnContentScroll = z;
            this.mOverlayLayout.setHideOnContentScrollEnabled(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.mDecorToolbar.setNavigationContentDescription(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            this.mDecorToolbar.setNavigationIcon(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.mDecorToolbar.setHomeButtonEnabled(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            this.mDecorToolbar.setIcon(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            this.mDecorToolbar.setLogo(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.mShowHideAnimationEnabled = z;
            if (!z && (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) != null) {
                viewPropertyAnimatorCompatSet.cancel();
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, drawable) == null) {
            this.mContainerView.setStackedBackground(drawable);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            setSubtitle(this.mContext.getString(i));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i) == null) {
            setTitle(this.mContext.getString(i));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, charSequence) == null) {
            this.mDecorToolbar.setWindowTitle(charSequence);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tab, i) == null) {
            addTab(tab, i, this.mTabs.isEmpty());
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view2, ActionBar.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, view2, layoutParams) == null) {
            view2.setLayoutParams(layoutParams);
            this.mDecorToolbar.setCustomView(view2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i, i2) == null) {
            int displayOptions = this.mDecorToolbar.getDisplayOptions();
            if ((i2 & 4) != 0) {
                this.mDisplayHomeAsUpSet = true;
            }
            this.mDecorToolbar.setDisplayOptions((i & i2) | ((~i2) & displayOptions));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, spinnerAdapter, onNavigationListener) == null) {
            this.mDecorToolbar.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tab, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ensureTabsExist();
            this.mTabScrollView.addTab(tab, i, z);
            configureTab(tab, i);
            if (z) {
                selectTab(tab);
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, tab, z) == null) {
            ensureTabsExist();
            this.mTabScrollView.addTab(tab, z);
            configureTab(tab, this.mTabs.size());
            if (z) {
                selectTab(tab);
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.mThemedContext == null) {
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(R.attr.obfuscated_res_0x7f040054, typedValue, true);
                int i = typedValue.resourceId;
                if (i != 0) {
                    this.mThemedContext = new ContextThemeWrapper(this.mContext, i);
                } else {
                    this.mThemedContext = this.mContext;
                }
            }
            return this.mThemedContext;
        }
        return (Context) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view2) == null) {
            this.mDecorToolbar.setCustomView(view2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, charSequence) == null) {
            this.mDecorToolbar.setNavigationContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, drawable) == null) {
            this.mDecorToolbar.setNavigationIcon(drawable);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, drawable) == null) {
            this.mDecorToolbar.setIcon(drawable);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, drawable) == null) {
            this.mDecorToolbar.setLogo(drawable);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, charSequence) == null) {
            this.mDecorToolbar.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, charSequence) == null) {
            this.mDecorToolbar.setTitle(charSequence);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            int navigationMode = this.mDecorToolbar.getNavigationMode();
            if (navigationMode != 1) {
                if (navigationMode == 2) {
                    selectTab(this.mTabs.get(i));
                    return;
                }
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            }
            this.mDecorToolbar.setDropdownSelectedPosition(i);
        }
    }
}
