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
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mActionModeContext;
        public ActionMode.Callback mCallback;
        public WeakReference<View> mCustomView;
        public final MenuBuilder mMenu;
        public final /* synthetic */ WindowDecorActionBar this$0;

        public ActionModeImpl(WindowDecorActionBar windowDecorActionBar, Context context, ActionMode.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowDecorActionBar, context, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMenu : (Menu) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public MenuInflater getMenuInflater() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new SupportMenuInflater(this.mActionModeContext) : (MenuInflater) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getSubtitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.this$0.mContextView.getSubtitle() : (CharSequence) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.this$0.mContextView.getTitle() : (CharSequence) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void invalidate() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.this$0.mActionMode == this) {
                this.mMenu.stopDispatchingItemsChanged();
                try {
                    this.mCallback.onPrepareActionMode(this, this.mMenu);
                } finally {
                    this.mMenu.startDispatchingItemsChanged();
                }
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public boolean isTitleOptional() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.this$0.mContextView.isTitleOptional() : invokeV.booleanValue;
        }

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

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
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
        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, menuBuilder) == null) || this.mCallback == null) {
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
                if (subMenuBuilder.hasVisibleItems()) {
                    new MenuPopupHelper(this.this$0.getThemedContext(), subMenuBuilder).show();
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setCustomView(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
                this.this$0.mContextView.setCustomView(view);
                this.mCustomView = new WeakReference<>(view);
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

        @Override // androidx.appcompat.view.ActionMode
        public void setTitleOptionalHint(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
                super.setTitleOptionalHint(z);
                this.this$0.mContextView.setTitleOptional(z);
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
                setSubtitle(this.this$0.mContext.getResources().getString(i2));
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
                setTitle(this.this$0.mContext.getResources().getString(i2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = windowDecorActionBar;
            this.mPosition = -1;
        }

        public ActionBar.TabListener getCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCallback : (ActionBar.TabListener) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getContentDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mContentDesc : (CharSequence) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public View getCustomView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCustomView : (View) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Drawable getIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIcon : (Drawable) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public int getPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPosition : invokeV.intValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Object getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTag : invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mText : (CharSequence) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public void select() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.this$0.selectTab(this);
            }
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? setContentDescription(this.this$0.mContext.getResources().getText(i2)) : (ActionBar.Tab) invokeI.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, view)) == null) {
                this.mCustomView = view;
                int i2 = this.mPosition;
                if (i2 >= 0) {
                    this.this$0.mTabScrollView.updateTab(i2);
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
                int i2 = this.mPosition;
                if (i2 >= 0) {
                    this.this$0.mTabScrollView.updateTab(i2);
                }
                return this;
            }
            return (ActionBar.Tab) invokeL.objValue;
        }

        public void setPosition(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
                this.mPosition = i2;
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
        public ActionBar.Tab setText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charSequence)) == null) {
                this.mText = charSequence;
                int i2 = this.mPosition;
                if (i2 >= 0) {
                    this.this$0.mTabScrollView.updateTab(i2);
                }
                return this;
            }
            return (ActionBar.Tab) invokeL.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, charSequence)) == null) {
                this.mContentDesc = charSequence;
                int i2 = this.mPosition;
                if (i2 >= 0) {
                    this.this$0.mTabScrollView.updateTab(i2);
                }
                return this;
            }
            return (ActionBar.Tab) invokeL.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(i2, (ViewGroup) null)) : (ActionBar.Tab) invokeI.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? setIcon(AppCompatResources.getDrawable(this.this$0.mContext, i2)) : (ActionBar.Tab) invokeI.objValue;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? setText(this.this$0.mContext.getResources().getText(i2)) : (ActionBar.Tab) invokeI.objValue;
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

    public WindowDecorActionBar(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                View view2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    WindowDecorActionBar windowDecorActionBar = this.this$0;
                    if (windowDecorActionBar.mContentAnimations && (view2 = windowDecorActionBar.mContentView) != null) {
                        view2.setTranslationY(0.0f);
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
            public void onAnimationUpdate(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    ((View) this.this$0.mContainerView.getParent()).invalidate();
                }
            }
        };
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (z) {
            return;
        }
        this.mContentView = decorView.findViewById(16908290);
    }

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

    private void configureTab(ActionBar.Tab tab, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLI(65542, this, tab, i2) != null) {
            return;
        }
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() != null) {
            tabImpl.setPosition(i2);
            this.mTabs.add(i2, tabImpl);
            int size = this.mTabs.size();
            while (true) {
                i2++;
                if (i2 >= size) {
                    return;
                }
                this.mTabs.get(i2).setPosition(i2);
            }
        } else {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
    }

    private void ensureTabsExist() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.mTabScrollView == null) {
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
    }

    private DecorToolbar getDecorToolbar(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, view)) == null) {
            if (view instanceof DecorToolbar) {
                return (DecorToolbar) view;
            }
            if (view instanceof Toolbar) {
                return ((Toolbar) view).getWrapper();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Can't make a decor toolbar out of ");
            sb.append(view != null ? view.getClass().getSimpleName() : StringUtil.NULL_STRING);
            throw new IllegalStateException(sb.toString());
        }
        return (DecorToolbar) invokeL.objValue;
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

    private void init(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, view) == null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
            this.mOverlayLayout = actionBarOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setActionBarVisibilityCallback(this);
            }
            this.mDecorToolbar = getDecorToolbar(view.findViewById(R.id.action_bar));
            this.mContextView = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
            ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
            this.mContainerView = actionBarContainer;
            DecorToolbar decorToolbar = this.mDecorToolbar;
            if (decorToolbar != null && this.mContextView != null && actionBarContainer != null) {
                this.mContext = decorToolbar.getContext();
                boolean z = (this.mDecorToolbar.getDisplayOptions() & 4) != 0;
                if (z) {
                    this.mDisplayHomeAsUpSet = true;
                }
                ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.mContext);
                setHomeButtonEnabled(actionBarPolicy.enableHomeButtonByDefault() || z);
                setHasEmbeddedTabs(actionBarPolicy.hasEmbeddedTabs());
                TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
                if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
                    setHideOnContentScrollEnabled(true);
                }
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
                if (dimensionPixelSize != 0) {
                    setElevation(dimensionPixelSize);
                }
                obtainStyledAttributes.recycle();
                return;
            }
            throw new IllegalStateException(WindowDecorActionBar.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
    }

    private void setHasEmbeddedTabs(boolean z) {
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
            boolean z2 = true;
            boolean z3 = getNavigationMode() == 2;
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (scrollingTabContainerView != null) {
                if (z3) {
                    scrollingTabContainerView.setVisibility(0);
                    ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                    if (actionBarOverlayLayout != null) {
                        ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
            }
            this.mDecorToolbar.setCollapsible(!this.mHasEmbeddedTabs && z3);
            this.mOverlayLayout.setHasNonEmbeddedTabs((this.mHasEmbeddedTabs || !z3) ? false : false);
        }
    }

    private boolean shouldAnimateContextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? ViewCompat.isLaidOut(this.mContainerView) : invokeV.booleanValue;
    }

    private void showForActionMode() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || this.mShowingForMode) {
            return;
        }
        this.mShowingForMode = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        updateVisibility(false);
    }

    private void updateVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, this, z) == null) {
            if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
                if (this.mNowShowing) {
                    return;
                }
                this.mNowShowing = true;
                doShow(z);
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
            if (!shouldAnimateContextView()) {
                if (z) {
                    this.mDecorToolbar.setVisibility(4);
                    this.mContextView.setVisibility(0);
                    return;
                }
                this.mDecorToolbar.setVisibility(0);
                this.mContextView.setVisibility(8);
                return;
            }
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
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            DecorToolbar decorToolbar = this.mDecorToolbar;
            if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
                return false;
            }
            this.mDecorToolbar.collapseActionView();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void completeDeferredDestroyActionMode() {
        ActionMode.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (callback = this.mDeferredModeDestroyCallback) == null) {
            return;
        }
        callback.onDestroyActionMode(this.mDeferredDestroyActionMode);
        this.mDeferredDestroyActionMode = null;
        this.mDeferredModeDestroyCallback = null;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || z == this.mLastMenuVisibility) {
            return;
        }
        this.mLastMenuVisibility = z;
        int size = this.mMenuVisibilityListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mMenuVisibilityListeners.get(i2).onMenuVisibilityChanged(z);
        }
    }

    public void doHide(boolean z) {
        View view;
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
                float f2 = -this.mContainerView.getHeight();
                if (z) {
                    this.mContainerView.getLocationInWindow(new int[]{0, 0});
                    f2 -= iArr[1];
                }
                ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.mContainerView).translationY(f2);
                translationY.setUpdateListener(this.mUpdateListener);
                viewPropertyAnimatorCompatSet2.play(translationY);
                if (this.mContentAnimations && (view = this.mContentView) != null) {
                    viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view).translationY(f2));
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

    public void doShow(boolean z) {
        View view;
        View view2;
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
                float f2 = -this.mContainerView.getHeight();
                if (z) {
                    this.mContainerView.getLocationInWindow(new int[]{0, 0});
                    f2 -= iArr[1];
                }
                this.mContainerView.setTranslationY(f2);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
                ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.mContainerView).translationY(0.0f);
                translationY.setUpdateListener(this.mUpdateListener);
                viewPropertyAnimatorCompatSet2.play(translationY);
                if (this.mContentAnimations && (view2 = this.mContentView) != null) {
                    view2.setTranslationY(f2);
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
                if (this.mContentAnimations && (view = this.mContentView) != null) {
                    view.setTranslationY(0.0f);
                }
                this.mShowListener.onAnimationEnd(null);
            }
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
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
    public View getCustomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mDecorToolbar.getCustomView() : (View) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mDecorToolbar.getDisplayOptions() : invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ViewCompat.getElevation(this.mContainerView) : invokeV.floatValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mContainerView.getHeight() : invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHideOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mOverlayLayout.getActionBarHideOffset() : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mDecorToolbar.getNavigationMode() : invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getSelectedNavigationIndex() {
        InterceptResult invokeV;
        TabImpl tabImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int navigationMode = this.mDecorToolbar.getNavigationMode();
            if (navigationMode != 1) {
                if (navigationMode == 2 && (tabImpl = this.mSelectedTab) != null) {
                    return tabImpl.getPosition();
                }
                return -1;
            }
            return this.mDecorToolbar.getDropdownSelectedPosition();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mSelectedTab : (ActionBar.Tab) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mDecorToolbar.getSubtitle() : (CharSequence) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? this.mTabs.get(i2) : (ActionBar.Tab) invokeI.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mTabs.size() : invokeV.intValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.mThemedContext == null) {
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                int i2 = typedValue.resourceId;
                if (i2 != 0) {
                    this.mThemedContext = new ContextThemeWrapper(this.mContext, i2);
                } else {
                    this.mThemedContext = this.mContext;
                }
            }
            return this.mThemedContext;
        }
        return (Context) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mDecorToolbar.getTitle() : (CharSequence) invokeV.objValue;
    }

    public boolean hasIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mDecorToolbar.hasIcon() : invokeV.booleanValue;
    }

    public boolean hasLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mDecorToolbar.hasLogo() : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || this.mHiddenByApp) {
            return;
        }
        this.mHiddenByApp = true;
        updateVisibility(false);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.mHiddenBySystem) {
            return;
        }
        this.mHiddenBySystem = true;
        updateVisibility(true);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mOverlayLayout.isHideOnContentScrollEnabled() : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            int height = getHeight();
            return this.mNowShowing && (height == 0 || getHideOffset() < height);
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            DecorToolbar decorToolbar = this.mDecorToolbar;
            return decorToolbar != null && decorToolbar.isTitleTruncated();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? new TabImpl(this) : (ActionBar.Tab) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, configuration) == null) {
            setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.cancel();
        this.mCurrentShowAnim = null;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Menu menu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i2, keyEvent)) == null) {
            ActionModeImpl actionModeImpl = this.mActionMode;
            if (actionModeImpl == null || (menu = actionModeImpl.getMenu()) == null) {
                return false;
            }
            menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return menu.performShortcut(i2, keyEvent, 0);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.mCurWindowVisibility = i2;
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
    public void removeTabAt(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i2) == null) || this.mTabScrollView == null) {
            return;
        }
        TabImpl tabImpl = this.mSelectedTab;
        int position = tabImpl != null ? tabImpl.getPosition() : this.mSavedTabPosition;
        this.mTabScrollView.removeTabAt(i2);
        TabImpl remove = this.mTabs.remove(i2);
        if (remove != null) {
            remove.setPosition(-1);
        }
        int size = this.mTabs.size();
        for (int i3 = i2; i3 < size; i3++) {
            this.mTabs.get(i3).setPosition(i3);
        }
        if (position == i2) {
            selectTab(this.mTabs.isEmpty() ? null : this.mTabs.get(Math.max(0, i2 - 1)));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
            if (viewGroup == null || viewGroup.hasFocus()) {
                return false;
            }
            viewGroup.requestFocus();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, tab) == null) {
            if (getNavigationMode() != 2) {
                this.mSavedTabPosition = tab != null ? tab.getPosition() : -1;
                return;
            }
            FragmentTransaction disallowAddToBackStack = (!(this.mActivity instanceof FragmentActivity) || this.mDecorToolbar.getViewGroup().isInEditMode()) ? null : ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            TabImpl tabImpl = this.mSelectedTab;
            if (tabImpl != tab) {
                this.mTabScrollView.setTabSelected(tab != null ? tab.getPosition() : -1);
                TabImpl tabImpl2 = this.mSelectedTab;
                if (tabImpl2 != null) {
                    tabImpl2.getCallback().onTabUnselected(this.mSelectedTab, disallowAddToBackStack);
                }
                TabImpl tabImpl3 = (TabImpl) tab;
                this.mSelectedTab = tabImpl3;
                if (tabImpl3 != null) {
                    tabImpl3.getCallback().onTabSelected(this.mSelectedTab, disallowAddToBackStack);
                }
            } else if (tabImpl != null) {
                tabImpl.getCallback().onTabReselected(this.mSelectedTab, disallowAddToBackStack);
                this.mTabScrollView.animateToTab(tab.getPosition());
            }
            if (disallowAddToBackStack == null || disallowAddToBackStack.isEmpty()) {
                return;
            }
            disallowAddToBackStack.commit();
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
    public void setCustomView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            setCustomView(LayoutInflater.from(getThemedContext()).inflate(i2, this.mDecorToolbar.getViewGroup(), false));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048625, this, z) == null) || this.mDisplayHomeAsUpSet) {
            return;
        }
        setDisplayHomeAsUpEnabled(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            setDisplayOptions(z ? 4 : 0, 4);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            if ((i2 & 4) != 0) {
                this.mDisplayHomeAsUpSet = true;
            }
            this.mDecorToolbar.setDisplayOptions(i2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            setDisplayOptions(z ? 16 : 0, 16);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            setDisplayOptions(z ? 2 : 0, 2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            setDisplayOptions(z ? 8 : 0, 8);
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
    public void setElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048633, this, f2) == null) {
            ViewCompat.setElevation(this.mContainerView, f2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            if (i2 != 0 && !this.mOverlayLayout.isInOverlayMode()) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
            }
            this.mOverlayLayout.setActionBarHideOffset(i2);
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
    public void setHomeButtonEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.mDecorToolbar.setHomeButtonEnabled(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            this.mDecorToolbar.setIcon(i2);
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
    public void setLogo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            this.mDecorToolbar.setLogo(i2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int i2) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            int navigationMode = this.mDecorToolbar.getNavigationMode();
            if (navigationMode == 2) {
                this.mSavedTabPosition = getSelectedNavigationIndex();
                selectTab(null);
                this.mTabScrollView.setVisibility(8);
            }
            if (navigationMode != i2 && !this.mHasEmbeddedTabs && (actionBarOverlayLayout = this.mOverlayLayout) != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
            this.mDecorToolbar.setNavigationMode(i2);
            boolean z = false;
            if (i2 == 2) {
                ensureTabsExist();
                this.mTabScrollView.setVisibility(0);
                int i3 = this.mSavedTabPosition;
                if (i3 != -1) {
                    setSelectedNavigationItem(i3);
                    this.mSavedTabPosition = -1;
                }
            }
            this.mDecorToolbar.setCollapsible(i2 == 2 && !this.mHasEmbeddedTabs);
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
            if (i2 == 2 && !this.mHasEmbeddedTabs) {
                z = true;
            }
            actionBarOverlayLayout2.setHasNonEmbeddedTabs(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            int navigationMode = this.mDecorToolbar.getNavigationMode();
            if (navigationMode == 1) {
                this.mDecorToolbar.setDropdownSelectedPosition(i2);
            } else if (navigationMode == 2) {
                selectTab(this.mTabs.get(i2));
            } else {
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.mShowHideAnimationEnabled = z;
            if (z || (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) == null) {
                return;
            }
            viewPropertyAnimatorCompatSet.cancel();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, drawable) == null) {
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
    public void setSubtitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            setSubtitle(this.mContext.getString(i2));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            setTitle(this.mContext.getString(i2));
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

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tab, i2) == null) {
            addTab(tab, i2, this.mTabs.isEmpty());
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            this.mDecorToolbar.setNavigationContentDescription(i2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.mDecorToolbar.setNavigationIcon(i2);
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
    public void setDisplayOptions(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i2, i3) == null) {
            int displayOptions = this.mDecorToolbar.getDisplayOptions();
            if ((i3 & 4) != 0) {
                this.mDisplayHomeAsUpSet = true;
            }
            this.mDecorToolbar.setDisplayOptions((i2 & i3) | ((~i3) & displayOptions));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view) == null) {
            this.mDecorToolbar.setCustomView(view);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, view, layoutParams) == null) {
            view.setLayoutParams(layoutParams);
            this.mDecorToolbar.setCustomView(view);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tab, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            ensureTabsExist();
            this.mTabScrollView.addTab(tab, i2, z);
            configureTab(tab, i2);
            if (z) {
                selectTab(tab);
            }
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dialog};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                View view2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    WindowDecorActionBar windowDecorActionBar = this.this$0;
                    if (windowDecorActionBar.mContentAnimations && (view2 = windowDecorActionBar.mContentView) != null) {
                        view2.setTranslationY(0.0f);
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
            public void onAnimationUpdate(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    ((View) this.this$0.mContainerView.getParent()).invalidate();
                }
            }
        };
        init(dialog.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view2) {
                View view22;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    WindowDecorActionBar windowDecorActionBar = this.this$0;
                    if (windowDecorActionBar.mContentAnimations && (view22 = windowDecorActionBar.mContentView) != null) {
                        view22.setTranslationY(0.0f);
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
        init(view);
    }
}
