package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    public static final boolean IS_PRE_LOLLIPOP;
    public static final boolean sCanApplyOverrideConfiguration;
    public static final boolean sCanReturnDifferentContext;
    public static boolean sInstalledExceptionHandler;
    public static final SimpleArrayMap<String, Integer> sLocalNightModes;
    public static final int[] sWindowBackgroundStyleable;
    public transient /* synthetic */ FieldHolder $fh;
    public ActionBar mActionBar;
    public ActionMenuPresenterCallback mActionMenuPresenterCallback;
    public ActionMode mActionMode;
    public PopupWindow mActionModePopup;
    public ActionBarContextView mActionModeView;
    public boolean mActivityHandlesUiMode;
    public boolean mActivityHandlesUiModeChecked;
    public final AppCompatCallback mAppCompatCallback;
    public AppCompatViewInflater mAppCompatViewInflater;
    public AppCompatWindowCallback mAppCompatWindowCallback;
    public AutoNightModeManager mAutoBatteryNightModeManager;
    public AutoNightModeManager mAutoTimeNightModeManager;
    public boolean mBaseContextAttached;
    public boolean mClosingActionMenu;
    public final Context mContext;
    public boolean mCreated;
    public DecorContentParent mDecorContentParent;
    public boolean mEnableDefaultActionBarUp;
    public ViewPropertyAnimatorCompat mFadeAnim;
    public boolean mFeatureIndeterminateProgress;
    public boolean mFeatureProgress;
    public boolean mHandleNativeActionModes;
    public boolean mHasActionBar;
    public final Object mHost;
    public int mInvalidatePanelMenuFeatures;
    public boolean mInvalidatePanelMenuPosted;
    public final Runnable mInvalidatePanelMenuRunnable;
    public boolean mIsDestroyed;
    public boolean mIsFloating;
    public int mLocalNightMode;
    public boolean mLongPressBackDown;
    public MenuInflater mMenuInflater;
    public boolean mOverlayActionBar;
    public boolean mOverlayActionMode;
    public PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    public PanelFeatureState[] mPanels;
    public PanelFeatureState mPreparedPanel;
    public Runnable mShowActionModePopup;
    public boolean mStarted;
    public View mStatusGuard;
    public ViewGroup mSubDecor;
    public boolean mSubDecorInstalled;
    public Rect mTempRect1;
    public Rect mTempRect2;
    public int mThemeResId;
    public CharSequence mTitle;
    public TextView mTitleView;
    public Window mWindow;
    public boolean mWindowNoTitle;

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
        }
    }

    public void onSubDecorInstalled(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, viewGroup) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static final class PanelFeatureState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int background;
        public View createdPanelView;
        public ViewGroup decorView;
        public int featureId;
        public Bundle frozenActionViewState;
        public Bundle frozenMenuState;
        public int gravity;
        public boolean isHandled;
        public boolean isOpen;
        public boolean isPrepared;
        public ListMenuPresenter listMenuPresenter;
        public Context listPresenterContext;
        public MenuBuilder menu;
        public boolean qwertyMode;
        public boolean refreshDecorView;
        public boolean refreshMenuContent;
        public View shownPanelView;
        public boolean wasLastOpen;
        public int windowAnimations;
        public int x;
        public int y;

        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class SavedState implements Parcelable {
            public static /* synthetic */ Interceptable $ic;
            public static final Parcelable.Creator<SavedState> CREATOR;
            public transient /* synthetic */ FieldHolder $fh;
            public int featureId;
            public boolean isOpen;
            public Bundle menuState;

            @Override // android.os.Parcelable
            public int describeContents() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-284527140, "Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState$SavedState;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-284527140, "Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState$SavedState;");
                        return;
                    }
                }
                CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.Parcelable.Creator
                    public SavedState createFromParcel(Parcel parcel) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                            return SavedState.readFromParcel(parcel, null);
                        }
                        return (SavedState) invokeL.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.Parcelable.Creator
                    public SavedState[] newArray(int i) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i)) == null) {
                            return new SavedState[i];
                        }
                        return (SavedState[]) invokeI.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.ClassLoaderCreator
                    public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) {
                            return SavedState.readFromParcel(parcel, classLoader);
                        }
                        return (SavedState) invokeLL.objValue;
                    }
                };
            }

            public SavedState() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, parcel, classLoader)) == null) {
                    SavedState savedState = new SavedState();
                    savedState.featureId = parcel.readInt();
                    boolean z = true;
                    if (parcel.readInt() != 1) {
                        z = false;
                    }
                    savedState.isOpen = z;
                    if (z) {
                        savedState.menuState = parcel.readBundle(classLoader);
                    }
                    return savedState;
                }
                return (SavedState) invokeLL.objValue;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                    parcel.writeInt(this.featureId);
                    parcel.writeInt(this.isOpen ? 1 : 0);
                    if (this.isOpen) {
                        parcel.writeBundle(this.menuState);
                    }
                }
            }
        }

        public PanelFeatureState(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.featureId = i;
            this.refreshDecorView = false;
        }

        public MenuView getListMenuView(MenuPresenter.Callback callback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, callback)) == null) {
                if (this.menu == null) {
                    return null;
                }
                if (this.listMenuPresenter == null) {
                    ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, (int) R.layout.obfuscated_res_0x7f0d0010);
                    this.listMenuPresenter = listMenuPresenter;
                    listMenuPresenter.setCallback(callback);
                    this.menu.addMenuPresenter(this.listMenuPresenter);
                }
                return this.listMenuPresenter.getMenuView(this.decorView);
            }
            return (MenuView) invokeL.objValue;
        }

        public void applyFrozenState() {
            MenuBuilder menuBuilder;
            Bundle bundle;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (menuBuilder = this.menu) != null && (bundle = this.frozenMenuState) != null) {
                menuBuilder.restorePresenterStates(bundle);
                this.frozenMenuState = null;
            }
        }

        public void clearMenuPresenters() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MenuBuilder menuBuilder = this.menu;
                if (menuBuilder != null) {
                    menuBuilder.removeMenuPresenter(this.listMenuPresenter);
                }
                this.listMenuPresenter = null;
            }
        }

        public boolean hasPanelItems() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.shownPanelView == null) {
                    return false;
                }
                if (this.createdPanelView == null && this.listMenuPresenter.getAdapter().getCount() <= 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public Parcelable onSaveInstanceState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                SavedState savedState = new SavedState();
                savedState.featureId = this.featureId;
                savedState.isOpen = this.isOpen;
                if (this.menu != null) {
                    Bundle bundle = new Bundle();
                    savedState.menuState = bundle;
                    this.menu.savePresenterStates(bundle);
                }
                return savedState;
            }
            return (Parcelable) invokeV.objValue;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, parcelable) == null) {
                SavedState savedState = (SavedState) parcelable;
                this.featureId = savedState.featureId;
                this.wasLastOpen = savedState.isOpen;
                this.frozenMenuState = savedState.menuState;
                this.shownPanelView = null;
                this.decorView = null;
            }
        }

        public void setMenu(MenuBuilder menuBuilder) {
            MenuBuilder menuBuilder2;
            ListMenuPresenter listMenuPresenter;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048582, this, menuBuilder) != null) || menuBuilder == (menuBuilder2 = this.menu)) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.removeMenuPresenter(this.listMenuPresenter);
            }
            this.menu = menuBuilder;
            if (menuBuilder != null && (listMenuPresenter = this.listMenuPresenter) != null) {
                menuBuilder.addMenuPresenter(listMenuPresenter);
            }
        }

        public void setStyle(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
                TypedValue typedValue = new TypedValue();
                Resources.Theme newTheme = context.getResources().newTheme();
                newTheme.setTo(context.getTheme());
                newTheme.resolveAttribute(R.attr.obfuscated_res_0x7f04004c, typedValue, true);
                int i = typedValue.resourceId;
                if (i != 0) {
                    newTheme.applyStyle(i, true);
                }
                newTheme.resolveAttribute(R.attr.obfuscated_res_0x7f040524, typedValue, true);
                int i2 = typedValue.resourceId;
                if (i2 != 0) {
                    newTheme.applyStyle(i2, true);
                } else {
                    newTheme.applyStyle(R.style.obfuscated_res_0x7f10021b, true);
                }
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(newTheme);
                this.listPresenterContext = contextThemeWrapper;
                TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
                this.background = obtainStyledAttributes.getResourceId(84, 0);
                this.windowAnimations = obtainStyledAttributes.getResourceId(1, 0);
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* loaded from: classes.dex */
    public class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionBarDrawableToggleImpl(AppCompatDelegateImpl appCompatDelegateImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatDelegateImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appCompatDelegateImpl;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            ActionBar supportActionBar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (supportActionBar = this.this$0.getSupportActionBar()) != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.this$0.getActionBarThemedContext();
            }
            return (Context) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.obfuscated_res_0x7f040323});
                Drawable drawable = obtainStyledAttributes.getDrawable(0);
                obtainStyledAttributes.recycle();
                return drawable;
            }
            return (Drawable) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ActionBar supportActionBar = this.this$0.getSupportActionBar();
                if (supportActionBar != null && (supportActionBar.getDisplayOptions() & 4) != 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar supportActionBar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048580, this, drawable, i) == null) && (supportActionBar = this.this$0.getSupportActionBar()) != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatDelegateImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appCompatDelegateImpl;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder)) == null) {
                Window.Callback windowCallback = this.this$0.getWindowCallback();
                if (windowCallback != null) {
                    windowCallback.onMenuOpened(108, menuBuilder);
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, menuBuilder, z) == null) {
                this.this$0.checkCloseActionMenu(menuBuilder);
            }
        }
    }

    /* loaded from: classes.dex */
    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ActionMode.Callback mWrapped;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionModeCallbackWrapperV9(AppCompatDelegateImpl appCompatDelegateImpl, ActionMode.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatDelegateImpl, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appCompatDelegateImpl;
            this.mWrapped = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, actionMode, menuItem)) == null) {
                return this.mWrapped.onActionItemClicked(actionMode, menuItem);
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, actionMode, menu)) == null) {
                return this.mWrapped.onCreateActionMode(actionMode, menu);
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, actionMode, menu)) == null) {
                ViewCompat.requestApplyInsets(this.this$0.mSubDecor);
                return this.mWrapped.onPrepareActionMode(actionMode, menu);
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, actionMode) == null) {
                this.mWrapped.onDestroyActionMode(actionMode);
                AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                if (appCompatDelegateImpl.mActionModePopup != null) {
                    appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
                }
                AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
                if (appCompatDelegateImpl2.mActionModeView != null) {
                    appCompatDelegateImpl2.endOnGoingFadeAnimation();
                    AppCompatDelegateImpl appCompatDelegateImpl3 = this.this$0;
                    appCompatDelegateImpl3.mFadeAnim = ViewCompat.animate(appCompatDelegateImpl3.mActionModeView).alpha(0.0f);
                    this.this$0.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter(this) { // from class: androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ActionModeCallbackWrapperV9 this$1;

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
                            this.this$1 = this;
                        }

                        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                        public void onAnimationEnd(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                this.this$1.this$0.mActionModeView.setVisibility(8);
                                AppCompatDelegateImpl appCompatDelegateImpl4 = this.this$1.this$0;
                                PopupWindow popupWindow = appCompatDelegateImpl4.mActionModePopup;
                                if (popupWindow != null) {
                                    popupWindow.dismiss();
                                } else if (appCompatDelegateImpl4.mActionModeView.getParent() instanceof View) {
                                    ViewCompat.requestApplyInsets((View) this.this$1.this$0.mActionModeView.getParent());
                                }
                                this.this$1.this$0.mActionModeView.removeAllViews();
                                this.this$1.this$0.mFadeAnim.setListener(null);
                                AppCompatDelegateImpl appCompatDelegateImpl5 = this.this$1.this$0;
                                appCompatDelegateImpl5.mFadeAnim = null;
                                ViewCompat.requestApplyInsets(appCompatDelegateImpl5.mSubDecor);
                            }
                        }
                    });
                }
                AppCompatDelegateImpl appCompatDelegateImpl4 = this.this$0;
                AppCompatCallback appCompatCallback = appCompatDelegateImpl4.mAppCompatCallback;
                if (appCompatCallback != null) {
                    appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.mActionMode);
                }
                AppCompatDelegateImpl appCompatDelegateImpl5 = this.this$0;
                appCompatDelegateImpl5.mActionMode = null;
                ViewCompat.requestApplyInsets(appCompatDelegateImpl5.mSubDecor);
            }
        }
    }

    /* loaded from: classes.dex */
    public class AppCompatWindowCallback extends WindowCallbackWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppCompatWindowCallback(AppCompatDelegateImpl appCompatDelegateImpl, Window.Callback callback) {
            super(callback);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatDelegateImpl, callback};
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
            this.this$0 = appCompatDelegateImpl;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
                if (!this.this$0.dispatchKeyEvent(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
                if (!super.dispatchKeyShortcutEvent(keyEvent) && !this.this$0.onKeyShortcut(keyEvent.getKeyCode(), keyEvent)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, callback)) == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    return null;
                }
                if (this.this$0.isHandleNativeActionModesEnabled()) {
                    return startAsSupportActionMode(callback);
                }
                return super.onWindowStartingActionMode(callback);
            }
            return (android.view.ActionMode) invokeL.objValue;
        }

        public final android.view.ActionMode startAsSupportActionMode(ActionMode.Callback callback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, callback)) == null) {
                SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(this.this$0.mContext, callback);
                androidx.appcompat.view.ActionMode startSupportActionMode = this.this$0.startSupportActionMode(callbackWrapper);
                if (startSupportActionMode != null) {
                    return callbackWrapper.getActionModeWrapper(startSupportActionMode);
                }
                return null;
            }
            return (android.view.ActionMode) invokeL.objValue;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, menu)) == null) {
                if (i == 0 && !(menu instanceof MenuBuilder)) {
                    return false;
                }
                return super.onCreatePanelMenu(i, menu);
            }
            return invokeIL.booleanValue;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, menu)) == null) {
                super.onMenuOpened(i, menu);
                this.this$0.onMenuOpened(i);
                return true;
            }
            return invokeIL.booleanValue;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, menu) == null) {
                super.onPanelClosed(i, menu);
                this.this$0.onPanelClosed(i);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(23)
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, callback, i)) == null) {
                if (this.this$0.isHandleNativeActionModesEnabled() && i == 0) {
                    return startAsSupportActionMode(callback);
                }
                return super.onWindowStartingActionMode(callback, i);
            }
            return (android.view.ActionMode) invokeLI.objValue;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view2, Menu menu) {
            InterceptResult invokeILL;
            MenuBuilder menuBuilder;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, menu)) == null) {
                if (menu instanceof MenuBuilder) {
                    menuBuilder = (MenuBuilder) menu;
                } else {
                    menuBuilder = null;
                }
                if (i == 0 && menuBuilder == null) {
                    return false;
                }
                if (menuBuilder != null) {
                    menuBuilder.setOverrideVisibleItems(true);
                }
                boolean onPreparePanel = super.onPreparePanel(i, view2, menu);
                if (menuBuilder != null) {
                    menuBuilder.setOverrideVisibleItems(false);
                }
                return onPreparePanel;
            }
            return invokeILL.booleanValue;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            MenuBuilder menuBuilder;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048583, this, list, menu, i) == null) {
                PanelFeatureState panelState = this.this$0.getPanelState(0, true);
                if (panelState != null && (menuBuilder = panelState.menu) != null) {
                    super.onProvideKeyboardShortcuts(list, menuBuilder, i);
                } else {
                    super.onProvideKeyboardShortcuts(list, menu, i);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class AutoBatteryNightModeManager extends AutoNightModeManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PowerManager mPowerManager;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoBatteryNightModeManager(@NonNull AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
            super(appCompatDelegateImpl);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatDelegateImpl, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AppCompatDelegateImpl) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appCompatDelegateImpl;
            this.mPowerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public IntentFilter createIntentFilterForBroadcastReceiver() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                    return intentFilter;
                }
                return null;
            }
            return (IntentFilter) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Build.VERSION.SDK_INT < 21 || !this.mPowerManager.isPowerSaveMode()) {
                    return 1;
                }
                return 2;
            }
            return invokeV.intValue;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.applyDayNight();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    /* loaded from: classes.dex */
    public abstract class AutoNightModeManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BroadcastReceiver mReceiver;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        @Nullable
        public abstract IntentFilter createIntentFilterForBroadcastReceiver();

        public abstract int getApplyableNightMode();

        public abstract void onChange();

        public AutoNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatDelegateImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appCompatDelegateImpl;
        }

        public void cleanup() {
            BroadcastReceiver broadcastReceiver;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (broadcastReceiver = this.mReceiver) != null) {
                try {
                    this.this$0.mContext.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.mReceiver = null;
            }
        }

        public boolean isListening() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.mReceiver != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void setup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                cleanup();
                IntentFilter createIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
                if (createIntentFilterForBroadcastReceiver != null && createIntentFilterForBroadcastReceiver.countActions() != 0) {
                    if (this.mReceiver == null) {
                        this.mReceiver = new BroadcastReceiver(this) { // from class: androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AutoNightModeManager this$1;

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
                                this.this$1 = this;
                            }

                            @Override // android.content.BroadcastReceiver
                            public void onReceive(Context context, Intent intent) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) {
                                    this.this$1.onChange();
                                }
                            }
                        };
                    }
                    this.this$0.mContext.registerReceiver(this.mReceiver, createIntentFilterForBroadcastReceiver);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class AutoTimeNightModeManager extends AutoNightModeManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TwilightManager mTwilightManager;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoTimeNightModeManager(@NonNull AppCompatDelegateImpl appCompatDelegateImpl, TwilightManager twilightManager) {
            super(appCompatDelegateImpl);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatDelegateImpl, twilightManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AppCompatDelegateImpl) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appCompatDelegateImpl;
            this.mTwilightManager = twilightManager;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public IntentFilter createIntentFilterForBroadcastReceiver() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.TIME_SET");
                intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter.addAction("android.intent.action.TIME_TICK");
                return intentFilter;
            }
            return (IntentFilter) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mTwilightManager.isNight()) {
                    return 2;
                }
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.applyDayNight();
            }
        }
    }

    @RequiresApi(17)
    /* loaded from: classes.dex */
    public static class ConfigurationImplApi17 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ConfigurationImplApi17() {
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

        public static void generateConfigDelta_densityDpi(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, configuration, configuration2, configuration3) == null) {
                int i = configuration.densityDpi;
                int i2 = configuration2.densityDpi;
                if (i != i2) {
                    configuration3.densityDpi = i2;
                }
            }
        }
    }

    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class ConfigurationImplApi24 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ConfigurationImplApi24() {
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

        public static void generateConfigDelta_locale(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, configuration, configuration2, configuration3) == null) {
                LocaleList locales = configuration.getLocales();
                LocaleList locales2 = configuration2.getLocales();
                if (!locales.equals(locales2)) {
                    configuration3.setLocales(locales2);
                    configuration3.locale = configuration2.locale;
                }
            }
        }
    }

    @RequiresApi(26)
    /* loaded from: classes.dex */
    public static class ConfigurationImplApi26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ConfigurationImplApi26() {
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

        public static void generateConfigDelta_colorMode(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, configuration, configuration2, configuration3) == null) {
                int i = configuration.colorMode & 3;
                int i2 = configuration2.colorMode;
                if (i != (i2 & 3)) {
                    configuration3.colorMode |= i2 & 3;
                }
                int i3 = configuration.colorMode & 12;
                int i4 = configuration2.colorMode;
                if (i3 != (i4 & 12)) {
                    configuration3.colorMode |= i4 & 12;
                }
            }
        }
    }

    @RequiresApi(17)
    /* loaded from: classes.dex */
    public static class ContextThemeWrapperCompatApi17Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ContextThemeWrapperCompatApi17Impl() {
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

        public static void applyOverrideConfiguration(android.view.ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, contextThemeWrapper, configuration) == null) {
                contextThemeWrapper.applyOverrideConfiguration(configuration);
            }
        }
    }

    /* loaded from: classes.dex */
    public class ListMenuDecorView extends ContentFrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ListMenuDecorView(AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatDelegateImpl, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appCompatDelegateImpl;
        }

        private boolean isOutOfBounds(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i, i2)) == null) {
                if (i >= -5 && i2 >= -5 && i <= getWidth() + 5 && i2 <= getHeight() + 5) {
                    return false;
                }
                return true;
            }
            return invokeII.booleanValue;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
                if (!this.this$0.dispatchKeyEvent(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i));
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (motionEvent.getAction() == 0 && isOutOfBounds((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.this$0.closePanel(0);
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        public PanelMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatDelegateImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appCompatDelegateImpl;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            InterceptResult invokeL;
            Window.Callback windowCallback;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder)) == null) {
                if (menuBuilder == menuBuilder.getRootMenu()) {
                    AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                    if (appCompatDelegateImpl.mHasActionBar && (windowCallback = appCompatDelegateImpl.getWindowCallback()) != null && !this.this$0.mIsDestroyed) {
                        windowCallback.onMenuOpened(108, menuBuilder);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, menuBuilder, z) == null) {
                MenuBuilder rootMenu = menuBuilder.getRootMenu();
                if (rootMenu != menuBuilder) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                if (z2) {
                    menuBuilder = rootMenu;
                }
                PanelFeatureState findMenuPanel = appCompatDelegateImpl.findMenuPanel(menuBuilder);
                if (findMenuPanel != null) {
                    if (z2) {
                        this.this$0.callOnPanelClosed(findMenuPanel.featureId, findMenuPanel, rootMenu);
                        this.this$0.closePanel(findMenuPanel, true);
                        return;
                    }
                    this.this$0.closePanel(findMenuPanel, z);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        boolean z;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-629526169, "Landroidx/appcompat/app/AppCompatDelegateImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-629526169, "Landroidx/appcompat/app/AppCompatDelegateImpl;");
                return;
            }
        }
        sLocalNightModes = new SimpleArrayMap<>();
        boolean z2 = false;
        if (Build.VERSION.SDK_INT < 21) {
            z = true;
        } else {
            z = false;
        }
        IS_PRE_LOLLIPOP = z;
        sWindowBackgroundStyleable = new int[]{16842836};
        sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
        if (Build.VERSION.SDK_INT >= 17) {
            z2 = true;
        }
        sCanApplyOverrideConfiguration = z2;
        if (IS_PRE_LOLLIPOP && !sInstalledExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()) { // from class: androidx.appcompat.app.AppCompatDelegateImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Thread.UncaughtExceptionHandler val$defHandler;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$defHandler = r6;
                }

                private boolean shouldWrapException(Throwable th) {
                    InterceptResult invokeL;
                    String message;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, th)) == null) {
                        if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                            return false;
                        }
                        if (!message.contains(ResourceManager.DRAWABLE) && !message.contains("Drawable")) {
                            return false;
                        }
                        return true;
                    }
                    return invokeL.booleanValue;
                }

                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, thread, th) == null) {
                        if (shouldWrapException(th)) {
                            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + AppCompatDelegateImpl.EXCEPTION_HANDLER_MESSAGE_SUFFIX);
                            notFoundException.initCause(th.getCause());
                            notFoundException.setStackTrace(th.getStackTrace());
                            this.val$defHandler.uncaughtException(thread, notFoundException);
                            return;
                        }
                        this.val$defHandler.uncaughtException(thread, th);
                    }
                }
            });
            sInstalledExceptionHandler = true;
        }
    }

    private void applyFixedSizeWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.mSubDecor.findViewById(16908290);
            View decorView = this.mWindow.getDecorView();
            contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
            obtainStyledAttributes.getValue(122, contentFrameLayout.getMinWidthMajor());
            obtainStyledAttributes.getValue(123, contentFrameLayout.getMinWidthMinor());
            if (obtainStyledAttributes.hasValue(120)) {
                obtainStyledAttributes.getValue(120, contentFrameLayout.getFixedWidthMajor());
            }
            if (obtainStyledAttributes.hasValue(121)) {
                obtainStyledAttributes.getValue(121, contentFrameLayout.getFixedWidthMinor());
            }
            if (obtainStyledAttributes.hasValue(118)) {
                obtainStyledAttributes.getValue(118, contentFrameLayout.getFixedHeightMajor());
            }
            if (obtainStyledAttributes.hasValue(119)) {
                obtainStyledAttributes.getValue(119, contentFrameLayout.getFixedHeightMinor());
            }
            obtainStyledAttributes.recycle();
            contentFrameLayout.requestLayout();
        }
    }

    private boolean isActivityManifestHandlingUiMode() {
        InterceptResult invokeV;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            if (!this.mActivityHandlesUiModeChecked && (this.mHost instanceof Activity)) {
                PackageManager packageManager = this.mContext.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 29) {
                        i = 269221888;
                    } else if (Build.VERSION.SDK_INT >= 24) {
                        i = 786432;
                    } else {
                        i = 0;
                    }
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.mContext, this.mHost.getClass()), i);
                    if (activityInfo != null && (activityInfo.configChanges & 512) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mActivityHandlesUiMode = z;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.d(AppCompatDelegate.TAG, "Exception while getting ActivityInfo", e);
                    this.mActivityHandlesUiMode = false;
                }
            }
            this.mActivityHandlesUiModeChecked = true;
            return this.mActivityHandlesUiMode;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDestroy() {
        ActionBar actionBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.mHost instanceof Activity) {
                AppCompatDelegate.removeActivityDelegate(this);
            }
            if (this.mInvalidatePanelMenuPosted) {
                this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
            }
            this.mStarted = false;
            this.mIsDestroyed = true;
            if (this.mLocalNightMode != -100) {
                Object obj = this.mHost;
                if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                    sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
                    actionBar = this.mActionBar;
                    if (actionBar != null) {
                        actionBar.onDestroy();
                    }
                    cleanupAutoManagers();
                }
            }
            sLocalNightModes.remove(this.mHost.getClass().getName());
            actionBar = this.mActionBar;
            if (actionBar != null) {
            }
            cleanupAutoManagers();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, null, appCompatCallback, activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, appCompatCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Window) objArr2[1], (AppCompatCallback) objArr2[2], objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void closePanel(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, panelFeatureState, z) == null) {
            if (z && panelFeatureState.featureId == 0 && (decorContentParent = this.mDecorContentParent) != null && decorContentParent.isOverflowMenuShowing()) {
                checkCloseActionMenu(panelFeatureState.menu);
                return;
            }
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (windowManager != null && panelFeatureState.isOpen && (viewGroup = panelFeatureState.decorView) != null) {
                windowManager.removeView(viewGroup);
                if (z) {
                    callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
                }
            }
            panelFeatureState.isPrepared = false;
            panelFeatureState.isHandled = false;
            panelFeatureState.isOpen = false;
            panelFeatureState.shownPanelView = null;
            panelFeatureState.refreshDecorView = true;
            if (this.mPreparedPanel == panelFeatureState) {
                this.mPreparedPanel = null;
            }
        }
    }

    public PanelFeatureState getPanelState(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            PanelFeatureState[] panelFeatureStateArr = this.mPanels;
            if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
                PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
                if (panelFeatureStateArr != null) {
                    System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
                }
                this.mPanels = panelFeatureStateArr2;
                panelFeatureStateArr = panelFeatureStateArr2;
            }
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState == null) {
                PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
                panelFeatureStateArr[i] = panelFeatureState2;
                return panelFeatureState2;
            }
            return panelFeatureState;
        }
        return (PanelFeatureState) invokeCommon.objValue;
    }

    public int mapNightMode(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, context, i)) == null) {
            if (i == -100) {
                return -1;
            }
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i == 3) {
                            return getAutoBatteryNightModeManager(context).getApplyableNightMode();
                        }
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                } else if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() == 0) {
                    return -1;
                } else {
                    return getAutoTimeNightModeManager(context).getApplyableNightMode();
                }
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048612, this, i, keyEvent)) == null) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
                return true;
            }
            PanelFeatureState panelFeatureState = this.mPreparedPanel;
            if (panelFeatureState != null && performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
                PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
                if (panelFeatureState2 != null) {
                    panelFeatureState2.isHandled = true;
                }
                return true;
            }
            if (this.mPreparedPanel == null) {
                PanelFeatureState panelState = getPanelState(0, true);
                preparePanel(panelState, keyEvent);
                boolean performPanelShortcut = performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent, 1);
                panelState.isPrepared = false;
                if (performPanelShortcut) {
                    return true;
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dialog, appCompatCallback};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Window) objArr2[1], (AppCompatCallback) objArr2[2], objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, null, appCompatCallback, activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, activity, appCompatCallback};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Window) objArr2[1], (AppCompatCallback) objArr2[2], objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, window, appCompatCallback};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Window) objArr2[1], (AppCompatCallback) objArr2[2], objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        Integer num;
        AppCompatActivity tryUnwrapContext;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, window, appCompatCallback, obj};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        this.mLocalNightMode = -100;
        this.mInvalidatePanelMenuRunnable = new Runnable(this) { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AppCompatDelegateImpl this$0;

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
                    AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                    if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
                        appCompatDelegateImpl.doInvalidatePanelMenu(0);
                    }
                    AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
                    if ((appCompatDelegateImpl2.mInvalidatePanelMenuFeatures & 4096) != 0) {
                        appCompatDelegateImpl2.doInvalidatePanelMenu(108);
                    }
                    AppCompatDelegateImpl appCompatDelegateImpl3 = this.this$0;
                    appCompatDelegateImpl3.mInvalidatePanelMenuPosted = false;
                    appCompatDelegateImpl3.mInvalidatePanelMenuFeatures = 0;
                }
            }
        };
        this.mContext = context;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = obj;
        if (this.mLocalNightMode == -100 && (obj instanceof Dialog) && (tryUnwrapContext = tryUnwrapContext()) != null) {
            this.mLocalNightMode = tryUnwrapContext.getDelegate().getLocalNightMode();
        }
        if (this.mLocalNightMode == -100 && (num = sLocalNightModes.get(this.mHost.getClass().getName())) != null) {
            this.mLocalNightMode = num.intValue();
            sLocalNightModes.remove(this.mHost.getClass().getName());
        }
        if (window != null) {
            attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(View view2, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, view2, str, context, attributeSet)) == null) {
            boolean z2 = false;
            if (this.mAppCompatViewInflater == null) {
                String string = this.mContext.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme).getString(114);
                if (string == null) {
                    this.mAppCompatViewInflater = new AppCompatViewInflater();
                } else {
                    try {
                        this.mAppCompatViewInflater = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Throwable th) {
                        Log.i(AppCompatDelegate.TAG, "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                        this.mAppCompatViewInflater = new AppCompatViewInflater();
                    }
                }
            }
            if (IS_PRE_LOLLIPOP) {
                if (attributeSet instanceof XmlPullParser) {
                    if (((XmlPullParser) attributeSet).getDepth() > 1) {
                        z2 = true;
                    }
                } else {
                    z2 = shouldInheritContext((ViewParent) view2);
                }
                z = z2;
            } else {
                z = false;
            }
            return this.mAppCompatViewInflater.createView(view2, str, context, attributeSet, z, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
        }
        return (View) invokeLLLL.objValue;
    }

    private boolean applyDayNight(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65542, this, z)) == null) {
            if (this.mIsDestroyed) {
                return false;
            }
            int calculateNightMode = calculateNightMode();
            boolean updateForNightMode = updateForNightMode(mapNightMode(this.mContext, calculateNightMode), z);
            if (calculateNightMode == 0) {
                getAutoTimeNightModeManager(this.mContext).setup();
            } else {
                AutoNightModeManager autoNightModeManager = this.mAutoTimeNightModeManager;
                if (autoNightModeManager != null) {
                    autoNightModeManager.cleanup();
                }
            }
            if (calculateNightMode == 3) {
                getAutoBatteryNightModeManager(this.mContext).setup();
            } else {
                AutoNightModeManager autoNightModeManager2 = this.mAutoBatteryNightModeManager;
                if (autoNightModeManager2 != null) {
                    autoNightModeManager2.cleanup();
                }
            }
            return updateForNightMode;
        }
        return invokeZ.booleanValue;
    }

    private void attachToWindow(@NonNull Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, window) == null) {
            if (this.mWindow == null) {
                Window.Callback callback = window.getCallback();
                if (!(callback instanceof AppCompatWindowCallback)) {
                    AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(this, callback);
                    this.mAppCompatWindowCallback = appCompatWindowCallback;
                    window.setCallback(appCompatWindowCallback);
                    TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mContext, (AttributeSet) null, sWindowBackgroundStyleable);
                    Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                    if (drawableIfKnown != null) {
                        window.setBackgroundDrawable(drawableIfKnown);
                    }
                    obtainStyledAttributes.recycle();
                    this.mWindow = window;
                    return;
                }
                throw new IllegalStateException("AppCompat has already installed itself into the Window");
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, keyEvent)) == null) {
            Object obj = this.mHost;
            boolean z = true;
            if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.mWindow.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
                return true;
            }
            if (keyEvent.getKeyCode() == 82 && this.mAppCompatWindowCallback.getWrapped().dispatchKeyEvent(keyEvent)) {
                return true;
            }
            int keyCode = keyEvent.getKeyCode();
            if (keyEvent.getAction() != 0) {
                z = false;
            }
            if (z) {
                return onKeyDown(keyCode, keyEvent);
            }
            return onKeyUp(keyCode, keyEvent);
        }
        return invokeL.booleanValue;
    }

    public void doInvalidatePanelMenu(int i) {
        PanelFeatureState panelState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            PanelFeatureState panelState2 = getPanelState(i, true);
            if (panelState2.menu != null) {
                Bundle bundle = new Bundle();
                panelState2.menu.saveActionViewStates(bundle);
                if (bundle.size() > 0) {
                    panelState2.frozenActionViewState = bundle;
                }
                panelState2.menu.stopDispatchingItemsChanged();
                panelState2.menu.clear();
            }
            panelState2.refreshMenuContent = true;
            panelState2.refreshDecorView = true;
            if ((i == 108 || i == 0) && this.mDecorContentParent != null && (panelState = getPanelState(0, false)) != null) {
                panelState.isPrepared = false;
                preparePanel(panelState, null);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            int sanitizeWindowFeatureId = sanitizeWindowFeatureId(i);
            if (sanitizeWindowFeatureId != 1) {
                if (sanitizeWindowFeatureId != 2) {
                    if (sanitizeWindowFeatureId != 5) {
                        if (sanitizeWindowFeatureId != 10) {
                            if (sanitizeWindowFeatureId != 108) {
                                if (sanitizeWindowFeatureId != 109) {
                                    z = false;
                                } else {
                                    z = this.mOverlayActionBar;
                                }
                            } else {
                                z = this.mHasActionBar;
                            }
                        } else {
                            z = this.mOverlayActionMode;
                        }
                    } else {
                        z = this.mFeatureIndeterminateProgress;
                    }
                } else {
                    z = this.mFeatureProgress;
                }
            } else {
                z = this.mWindowNoTitle;
            }
            if (z || this.mWindow.hasFeature(i)) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar toolbar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048631, this, toolbar) != null) || !(this.mHost instanceof Activity)) {
            return;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (!(supportActionBar instanceof WindowDecorActionBar)) {
            this.mMenuInflater = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, getTitle(), this.mAppCompatWindowCallback);
                this.mActionBar = toolbarActionBar;
                this.mWindow.setCallback(toolbarActionBar.getWrappedWindowCallback());
            } else {
                this.mActionBar = null;
                this.mWindow.setCallback(this.mAppCompatWindowCallback);
            }
            invalidateOptionsMenu();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public androidx.appcompat.view.ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        InterceptResult invokeL;
        AppCompatCallback appCompatCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, callback)) == null) {
            if (callback != null) {
                androidx.appcompat.view.ActionMode actionMode = this.mActionMode;
                if (actionMode != null) {
                    actionMode.finish();
                }
                ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(this, callback);
                ActionBar supportActionBar = getSupportActionBar();
                if (supportActionBar != null) {
                    androidx.appcompat.view.ActionMode startActionMode = supportActionBar.startActionMode(actionModeCallbackWrapperV9);
                    this.mActionMode = startActionMode;
                    if (startActionMode != null && (appCompatCallback = this.mAppCompatCallback) != null) {
                        appCompatCallback.onSupportActionModeStarted(startActionMode);
                    }
                }
                if (this.mActionMode == null) {
                    this.mActionMode = startSupportActionModeFromWindow(actionModeCallbackWrapperV9);
                }
                return this.mActionMode;
            }
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        return (androidx.appcompat.view.ActionMode) invokeL.objValue;
    }

    private int calculateNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int i = this.mLocalNightMode;
            if (i == -100) {
                return AppCompatDelegate.getDefaultNightMode();
            }
            return i;
        }
        return invokeV.intValue;
    }

    private void cleanupAutoManagers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            AutoNightModeManager autoNightModeManager = this.mAutoTimeNightModeManager;
            if (autoNightModeManager != null) {
                autoNightModeManager.cleanup();
            }
            AutoNightModeManager autoNightModeManager2 = this.mAutoBatteryNightModeManager;
            if (autoNightModeManager2 != null) {
                autoNightModeManager2.cleanup();
            }
        }
    }

    private void ensureWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (this.mWindow == null) {
                Object obj = this.mHost;
                if (obj instanceof Activity) {
                    attachToWindow(((Activity) obj).getWindow());
                }
            }
            if (this.mWindow != null) {
                return;
            }
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65568, this) != null) || !this.mSubDecorInstalled) {
            return;
        }
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    @Nullable
    private AppCompatActivity tryUnwrapContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            for (Context context = this.mContext; context != null; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof AppCompatActivity) {
                    return (AppCompatActivity) context;
                }
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
            }
            return null;
        }
        return (AppCompatActivity) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return applyDayNight(true);
        }
        return invokeV.booleanValue;
    }

    public void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (viewPropertyAnimatorCompat = this.mFadeAnim) != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public final Context getActionBarThemedContext() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                context = supportActionBar.getThemedContext();
            } else {
                context = null;
            }
            if (context == null) {
                return this.mContext;
            }
            return context;
        }
        return (Context) invokeV.objValue;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public final AutoNightModeManager getAutoTimeNightModeManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return getAutoTimeNightModeManager(this.mContext);
        }
        return (AutoNightModeManager) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return new ActionBarDrawableToggleImpl(this);
        }
        return (ActionBarDrawerToggle.Delegate) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int getLocalNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mLocalNightMode;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.mMenuInflater == null) {
                initWindowDecorActionBar();
                ActionBar actionBar = this.mActionBar;
                if (actionBar != null) {
                    context = actionBar.getThemedContext();
                } else {
                    context = this.mContext;
                }
                this.mMenuInflater = new SupportMenuInflater(context);
            }
            return this.mMenuInflater;
        }
        return (MenuInflater) invokeV.objValue;
    }

    public ViewGroup getSubDecor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mSubDecor;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            initWindowDecorActionBar();
            return this.mActionBar;
        }
        return (ActionBar) invokeV.objValue;
    }

    public final CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                return ((Activity) obj).getTitle();
            }
            return this.mTitle;
        }
        return (CharSequence) invokeV.objValue;
    }

    public final Window.Callback getWindowCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mWindow.getCallback();
        }
        return (Window.Callback) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            if (from.getFactory() == null) {
                LayoutInflaterCompat.setFactory2(from, this);
            } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
                Log.i(AppCompatDelegate.TAG, "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null && supportActionBar.invalidateOptionsMenu()) {
                return;
            }
            invalidatePanelMenu(0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mHandleNativeActionModes;
        }
        return invokeV.booleanValue;
    }

    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            androidx.appcompat.view.ActionMode actionMode = this.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
                return true;
            }
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null && supportActionBar.collapseActionView()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        ActionBar supportActionBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.mStarted = true;
            applyDayNight();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.mStarted = false;
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setShowHideAnimationEnabled(false);
            }
        }
    }

    public final ActionBar peekSupportActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mActionBar;
        }
        return (ActionBar) invokeV.objValue;
    }

    public final boolean shouldAnimateActionModeView() {
        InterceptResult invokeV;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (this.mSubDecorInstalled && (viewGroup = this.mSubDecor) != null && ViewCompat.isLaidOut(viewGroup)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    private Configuration createOverrideConfigurationForDayNight(@NonNull Context context, int i, @Nullable Configuration configuration) {
        InterceptResult invokeLIL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65547, this, context, i, configuration)) == null) {
            if (i != 1) {
                if (i != 2) {
                    i2 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
                } else {
                    i2 = 32;
                }
            } else {
                i2 = 16;
            }
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            if (configuration != null) {
                configuration2.setTo(configuration);
            }
            configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
            return configuration2;
        }
        return (Configuration) invokeLIL.objValue;
    }

    public void callOnPanelClosed(int i, PanelFeatureState panelFeatureState, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, panelFeatureState, menu) == null) {
            if (menu == null) {
                if (panelFeatureState == null && i >= 0) {
                    PanelFeatureState[] panelFeatureStateArr = this.mPanels;
                    if (i < panelFeatureStateArr.length) {
                        panelFeatureState = panelFeatureStateArr[i];
                    }
                }
                if (panelFeatureState != null) {
                    menu = panelFeatureState.menu;
                }
            }
            if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.mIsDestroyed) {
                this.mAppCompatWindowCallback.getWrapped().onPanelClosed(i, menu);
            }
        }
    }

    private ViewGroup createSubDecor() {
        InterceptResult invokeV;
        ViewGroup viewGroup;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(115)) {
                if (obtainStyledAttributes.getBoolean(124, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(115, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(116, false)) {
                    requestWindowFeature(109);
                }
                if (obtainStyledAttributes.getBoolean(117, false)) {
                    requestWindowFeature(10);
                }
                this.mIsFloating = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
                ensureWindow();
                this.mWindow.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.mContext);
                if (!this.mWindowNoTitle) {
                    if (this.mIsFloating) {
                        viewGroup = (ViewGroup) from.inflate(R.layout.obfuscated_res_0x7f0d000c, (ViewGroup) null);
                        this.mOverlayActionBar = false;
                        this.mHasActionBar = false;
                    } else if (this.mHasActionBar) {
                        TypedValue typedValue = new TypedValue();
                        this.mContext.getTheme().resolveAttribute(R.attr.obfuscated_res_0x7f040053, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            context = new ContextThemeWrapper(this.mContext, typedValue.resourceId);
                        } else {
                            context = this.mContext;
                        }
                        viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0017, (ViewGroup) null);
                        DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R.id.obfuscated_res_0x7f090792);
                        this.mDecorContentParent = decorContentParent;
                        decorContentParent.setWindowCallback(getWindowCallback());
                        if (this.mOverlayActionBar) {
                            this.mDecorContentParent.initFeature(109);
                        }
                        if (this.mFeatureProgress) {
                            this.mDecorContentParent.initFeature(2);
                        }
                        if (this.mFeatureIndeterminateProgress) {
                            this.mDecorContentParent.initFeature(5);
                        }
                    } else {
                        viewGroup = null;
                    }
                } else {
                    viewGroup = this.mOverlayActionMode ? (ViewGroup) from.inflate(R.layout.obfuscated_res_0x7f0d0016, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.obfuscated_res_0x7f0d0015, (ViewGroup) null);
                }
                if (viewGroup != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener(this) { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AppCompatDelegateImpl this$0;

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

                            @Override // androidx.core.view.OnApplyWindowInsetsListener
                            public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                                InterceptResult invokeLL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, windowInsetsCompat)) == null) {
                                    int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                                    int updateStatusGuard = this.this$0.updateStatusGuard(windowInsetsCompat, null);
                                    if (systemWindowInsetTop != updateStatusGuard) {
                                        windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), updateStatusGuard, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                                    }
                                    return ViewCompat.onApplyWindowInsets(view2, windowInsetsCompat);
                                }
                                return (WindowInsetsCompat) invokeLL.objValue;
                            }
                        });
                    } else if (viewGroup instanceof FitWindowsViewGroup) {
                        ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener(this) { // from class: androidx.appcompat.app.AppCompatDelegateImpl.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AppCompatDelegateImpl this$0;

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

                            @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
                            public void onFitSystemWindows(Rect rect) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, rect) == null) {
                                    rect.top = this.this$0.updateStatusGuard(null, rect);
                                }
                            }
                        });
                    }
                    if (this.mDecorContentParent == null) {
                        this.mTitleView = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092263);
                    }
                    ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09005c);
                    ViewGroup viewGroup2 = (ViewGroup) this.mWindow.findViewById(16908290);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(16908290);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.mWindow.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener(this) { // from class: androidx.appcompat.app.AppCompatDelegateImpl.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AppCompatDelegateImpl this$0;

                        @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
                        public void onAttachedFromWindow() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            }
                        }

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

                        @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
                        public void onDetachedFromWindow() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.this$0.dismissPopups();
                            }
                        }
                    });
                    return viewGroup;
                }
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        return (ViewGroup) invokeV.objValue;
    }

    private void ensureSubDecor() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && !this.mSubDecorInstalled) {
            this.mSubDecor = createSubDecor();
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                DecorContentParent decorContentParent = this.mDecorContentParent;
                if (decorContentParent != null) {
                    decorContentParent.setWindowTitle(title);
                } else if (peekSupportActionBar() != null) {
                    peekSupportActionBar().setWindowTitle(title);
                } else {
                    TextView textView = this.mTitleView;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
            applyFixedSizeWindow();
            onSubDecorInstalled(this.mSubDecor);
            this.mSubDecorInstalled = true;
            PanelFeatureState panelState = getPanelState(0, false);
            if (!this.mIsDestroyed) {
                if (panelState == null || panelState.menu == null) {
                    invalidatePanelMenu(108);
                }
            }
        }
    }

    private void initWindowDecorActionBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            ensureSubDecor();
            if (this.mHasActionBar && this.mActionBar == null) {
                Object obj = this.mHost;
                if (obj instanceof Activity) {
                    this.mActionBar = new WindowDecorActionBar((Activity) this.mHost, this.mOverlayActionBar);
                } else if (obj instanceof Dialog) {
                    this.mActionBar = new WindowDecorActionBar((Dialog) this.mHost);
                }
                ActionBar actionBar = this.mActionBar;
                if (actionBar != null) {
                    actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
                }
            }
        }
    }

    public void dismissPopups() {
        MenuBuilder menuBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            DecorContentParent decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null) {
                decorContentParent.dismissPopups();
            }
            if (this.mActionModePopup != null) {
                this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
                if (this.mActionModePopup.isShowing()) {
                    try {
                        this.mActionModePopup.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                this.mActionModePopup = null;
            }
            endOnGoingFadeAnimation();
            PanelFeatureState panelState = getPanelState(0, false);
            if (panelState != null && (menuBuilder = panelState.menu) != null) {
                menuBuilder.close();
            }
        }
    }

    @NonNull
    public static Configuration generateConfigDelta(@NonNull Configuration configuration, @Nullable Configuration configuration2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, configuration, configuration2)) == null) {
            Configuration configuration3 = new Configuration();
            configuration3.fontScale = 0.0f;
            if (configuration2 != null && configuration.diff(configuration2) != 0) {
                float f = configuration.fontScale;
                float f2 = configuration2.fontScale;
                if (f != f2) {
                    configuration3.fontScale = f2;
                }
                int i = configuration.mcc;
                int i2 = configuration2.mcc;
                if (i != i2) {
                    configuration3.mcc = i2;
                }
                int i3 = configuration.mnc;
                int i4 = configuration2.mnc;
                if (i3 != i4) {
                    configuration3.mnc = i4;
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    ConfigurationImplApi24.generateConfigDelta_locale(configuration, configuration2, configuration3);
                } else if (!ObjectsCompat.equals(configuration.locale, configuration2.locale)) {
                    configuration3.locale = configuration2.locale;
                }
                int i5 = configuration.touchscreen;
                int i6 = configuration2.touchscreen;
                if (i5 != i6) {
                    configuration3.touchscreen = i6;
                }
                int i7 = configuration.keyboard;
                int i8 = configuration2.keyboard;
                if (i7 != i8) {
                    configuration3.keyboard = i8;
                }
                int i9 = configuration.keyboardHidden;
                int i10 = configuration2.keyboardHidden;
                if (i9 != i10) {
                    configuration3.keyboardHidden = i10;
                }
                int i11 = configuration.navigation;
                int i12 = configuration2.navigation;
                if (i11 != i12) {
                    configuration3.navigation = i12;
                }
                int i13 = configuration.navigationHidden;
                int i14 = configuration2.navigationHidden;
                if (i13 != i14) {
                    configuration3.navigationHidden = i14;
                }
                int i15 = configuration.orientation;
                int i16 = configuration2.orientation;
                if (i15 != i16) {
                    configuration3.orientation = i16;
                }
                int i17 = configuration.screenLayout & 15;
                int i18 = configuration2.screenLayout;
                if (i17 != (i18 & 15)) {
                    configuration3.screenLayout |= i18 & 15;
                }
                int i19 = configuration.screenLayout & 192;
                int i20 = configuration2.screenLayout;
                if (i19 != (i20 & 192)) {
                    configuration3.screenLayout |= i20 & 192;
                }
                int i21 = configuration.screenLayout & 48;
                int i22 = configuration2.screenLayout;
                if (i21 != (i22 & 48)) {
                    configuration3.screenLayout |= i22 & 48;
                }
                int i23 = configuration.screenLayout & 768;
                int i24 = configuration2.screenLayout;
                if (i23 != (i24 & 768)) {
                    configuration3.screenLayout |= i24 & 768;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    ConfigurationImplApi26.generateConfigDelta_colorMode(configuration, configuration2, configuration3);
                }
                int i25 = configuration.uiMode & 15;
                int i26 = configuration2.uiMode;
                if (i25 != (i26 & 15)) {
                    configuration3.uiMode |= i26 & 15;
                }
                int i27 = configuration.uiMode & 48;
                int i28 = configuration2.uiMode;
                if (i27 != (i28 & 48)) {
                    configuration3.uiMode |= i28 & 48;
                }
                int i29 = configuration.screenWidthDp;
                int i30 = configuration2.screenWidthDp;
                if (i29 != i30) {
                    configuration3.screenWidthDp = i30;
                }
                int i31 = configuration.screenHeightDp;
                int i32 = configuration2.screenHeightDp;
                if (i31 != i32) {
                    configuration3.screenHeightDp = i32;
                }
                int i33 = configuration.smallestScreenWidthDp;
                int i34 = configuration2.smallestScreenWidthDp;
                if (i33 != i34) {
                    configuration3.smallestScreenWidthDp = i34;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    ConfigurationImplApi17.generateConfigDelta_densityDpi(configuration, configuration2, configuration3);
                }
            }
            return configuration3;
        }
        return (Configuration) invokeLL.objValue;
    }

    private void openPanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65562, this, panelFeatureState, keyEvent) == null) && !panelFeatureState.isOpen && !this.mIsDestroyed) {
            if (panelFeatureState.featureId == 0) {
                if ((this.mContext.getResources().getConfiguration().screenLayout & 15) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            Window.Callback windowCallback = getWindowCallback();
            if (windowCallback != null && !windowCallback.onMenuOpened(panelFeatureState.featureId, panelFeatureState.menu)) {
                closePanel(panelFeatureState, true);
                return;
            }
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (windowManager == null || !preparePanel(panelFeatureState, keyEvent)) {
                return;
            }
            if (panelFeatureState.decorView != null && !panelFeatureState.refreshDecorView) {
                View view2 = panelFeatureState.createdPanelView;
                if (view2 != null && (layoutParams = view2.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                    panelFeatureState.isHandled = false;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
                    layoutParams2.gravity = panelFeatureState.gravity;
                    layoutParams2.windowAnimations = panelFeatureState.windowAnimations;
                    windowManager.addView(panelFeatureState.decorView, layoutParams2);
                    panelFeatureState.isOpen = true;
                }
            } else {
                ViewGroup viewGroup = panelFeatureState.decorView;
                if (viewGroup == null) {
                    if (!initializePanelDecor(panelFeatureState) || panelFeatureState.decorView == null) {
                        return;
                    }
                } else if (panelFeatureState.refreshDecorView && viewGroup.getChildCount() > 0) {
                    panelFeatureState.decorView.removeAllViews();
                }
                if (initializePanelContent(panelFeatureState) && panelFeatureState.hasPanelItems()) {
                    ViewGroup.LayoutParams layoutParams3 = panelFeatureState.shownPanelView.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                    }
                    panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
                    ViewParent parent = panelFeatureState.shownPanelView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(panelFeatureState.shownPanelView);
                    }
                    panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, layoutParams3);
                    if (!panelFeatureState.shownPanelView.hasFocus()) {
                        panelFeatureState.shownPanelView.requestFocus();
                    }
                } else {
                    panelFeatureState.refreshDecorView = true;
                    return;
                }
            }
            i = -2;
            panelFeatureState.isHandled = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
            layoutParams22.gravity = panelFeatureState.gravity;
            layoutParams22.windowAnimations = panelFeatureState.windowAnimations;
            windowManager.addView(panelFeatureState.decorView, layoutParams22);
            panelFeatureState.isOpen = true;
        }
    }

    private boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        boolean z;
        DecorContentParent decorContentParent;
        int i;
        boolean z2;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, this, panelFeatureState, keyEvent)) == null) {
            if (this.mIsDestroyed) {
                return false;
            }
            if (panelFeatureState.isPrepared) {
                return true;
            }
            PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
            if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
                closePanel(panelFeatureState2, false);
            }
            Window.Callback windowCallback = getWindowCallback();
            if (windowCallback != null) {
                panelFeatureState.createdPanelView = windowCallback.onCreatePanelView(panelFeatureState.featureId);
            }
            int i2 = panelFeatureState.featureId;
            if (i2 != 0 && i2 != 108) {
                z = false;
            } else {
                z = true;
            }
            if (z && (decorContentParent3 = this.mDecorContentParent) != null) {
                decorContentParent3.setMenuPrepared();
            }
            if (panelFeatureState.createdPanelView == null && (!z || !(peekSupportActionBar() instanceof ToolbarActionBar))) {
                if (panelFeatureState.menu == null || panelFeatureState.refreshMenuContent) {
                    if (panelFeatureState.menu == null && (!initializePanelMenu(panelFeatureState) || panelFeatureState.menu == null)) {
                        return false;
                    }
                    if (z && this.mDecorContentParent != null) {
                        if (this.mActionMenuPresenterCallback == null) {
                            this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback(this);
                        }
                        this.mDecorContentParent.setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                    }
                    panelFeatureState.menu.stopDispatchingItemsChanged();
                    if (!windowCallback.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
                        panelFeatureState.setMenu(null);
                        if (z && (decorContentParent = this.mDecorContentParent) != null) {
                            decorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
                        }
                        return false;
                    }
                    panelFeatureState.refreshMenuContent = false;
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                Bundle bundle = panelFeatureState.frozenActionViewState;
                if (bundle != null) {
                    panelFeatureState.menu.restoreActionViewStates(bundle);
                    panelFeatureState.frozenActionViewState = null;
                }
                if (!windowCallback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                    if (z && (decorContentParent2 = this.mDecorContentParent) != null) {
                        decorContentParent2.setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    panelFeatureState.menu.startDispatchingItemsChanged();
                    return false;
                }
                if (keyEvent != null) {
                    i = keyEvent.getDeviceId();
                } else {
                    i = -1;
                }
                if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                panelFeatureState.qwertyMode = z2;
                panelFeatureState.menu.setQwertyMode(z2);
                panelFeatureState.menu.startDispatchingItemsChanged();
            }
            panelFeatureState.isPrepared = true;
            panelFeatureState.isHandled = false;
            this.mPreparedPanel = panelFeatureState;
            return true;
        }
        return invokeLL.booleanValue;
    }

    private AutoNightModeManager getAutoBatteryNightModeManager(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, context)) == null) {
            if (this.mAutoBatteryNightModeManager == null) {
                this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(this, context);
            }
            return this.mAutoBatteryNightModeManager;
        }
        return (AutoNightModeManager) invokeL.objValue;
    }

    private AutoNightModeManager getAutoTimeNightModeManager(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, context)) == null) {
            if (this.mAutoTimeNightModeManager == null) {
                this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(this, TwilightManager.getInstance(context));
            }
            return this.mAutoTimeNightModeManager;
        }
        return (AutoNightModeManager) invokeL.objValue;
    }

    private boolean initializePanelDecor(PanelFeatureState panelFeatureState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, panelFeatureState)) == null) {
            panelFeatureState.setStyle(getActionBarThemedContext());
            panelFeatureState.decorView = new ListMenuDecorView(this, panelFeatureState.listPresenterContext);
            panelFeatureState.gravity = 81;
            return true;
        }
        return invokeL.booleanValue;
    }

    private void invalidatePanelMenu(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, this, i) == null) {
            this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
            if (!this.mInvalidatePanelMenuPosted) {
                ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
                this.mInvalidatePanelMenuPosted = true;
            }
        }
    }

    private int sanitizeWindowFeatureId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, this, i)) == null) {
            if (i == 8) {
                Log.i(AppCompatDelegate.TAG, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
                return 108;
            } else if (i == 9) {
                Log.i(AppCompatDelegate.TAG, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
                return 109;
            } else {
                return i;
            }
        }
        return invokeI.intValue;
    }

    public void checkCloseActionMenu(@NonNull MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, menuBuilder) != null) || this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !this.mIsDestroyed) {
            windowCallback.onPanelClosed(108, menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    public void closePanel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            closePanel(getPanelState(i, true), true);
        }
    }

    public PanelFeatureState findMenuPanel(Menu menu) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, menu)) == null) {
            PanelFeatureState[] panelFeatureStateArr = this.mPanels;
            if (panelFeatureStateArr != null) {
                i = panelFeatureStateArr.length;
            } else {
                i = 0;
            }
            for (int i2 = 0; i2 < i; i2++) {
                PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
                if (panelFeatureState != null && panelFeatureState.menu == menu) {
                    return panelFeatureState;
                }
            }
            return null;
        }
        return (PanelFeatureState) invokeL.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public <T extends View> T findViewById(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            ensureSubDecor();
            return (T) this.mWindow.findViewById(i);
        }
        return (T) invokeI.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, configuration) == null) {
            if (this.mHasActionBar && this.mSubDecorInstalled && (supportActionBar = getSupportActionBar()) != null) {
                supportActionBar.onConfigurationChanged(configuration);
            }
            AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
            applyDayNight(false);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, menuBuilder) == null) {
            reopenMenu(true);
        }
    }

    public void onMenuOpened(int i) {
        ActionBar supportActionBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048616, this, i) == null) && i == 108 && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.dispatchMenuVisibilityChanged(true);
        }
    }

    public void onPanelClosed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            if (i == 108) {
                ActionBar supportActionBar = getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.dispatchMenuVisibilityChanged(false);
                }
            } else if (i == 0) {
                PanelFeatureState panelState = getPanelState(i, true);
                if (panelState.isOpen) {
                    closePanel(panelState, false);
                }
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            ensureSubDecor();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, view2) == null) {
            ensureSubDecor();
            ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
            viewGroup.removeAllViews();
            viewGroup.addView(view2);
            this.mAppCompatWindowCallback.getWrapped().onContentChanged();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.mHandleNativeActionModes = z;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @RequiresApi(17)
    public void setLocalNightMode(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048630, this, i) == null) && this.mLocalNightMode != i) {
            this.mLocalNightMode = i;
            if (this.mBaseContextAttached) {
                applyDayNight();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTheme(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.mThemeResId = i;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, charSequence) == null) {
            this.mTitle = charSequence;
            DecorContentParent decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null) {
                decorContentParent.setWindowTitle(charSequence);
            } else if (peekSupportActionBar() != null) {
                peekSupportActionBar().setWindowTitle(charSequence);
            } else {
                TextView textView = this.mTitleView;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
        }
    }

    private boolean initializePanelContent(PanelFeatureState panelFeatureState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, panelFeatureState)) == null) {
            View view2 = panelFeatureState.createdPanelView;
            if (view2 != null) {
                panelFeatureState.shownPanelView = view2;
                return true;
            } else if (panelFeatureState.menu == null) {
                return false;
            } else {
                if (this.mPanelMenuPresenterCallback == null) {
                    this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(this);
                }
                View view3 = (View) panelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback);
                panelFeatureState.shownPanelView = view3;
                if (view3 != null) {
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean shouldInheritContext(ViewParent viewParent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, this, viewParent)) == null) {
            if (viewParent == null) {
                return false;
            }
            View decorView = this.mWindow.getDecorView();
            while (viewParent != null) {
                if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                    return false;
                }
                viewParent = viewParent.getParent();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void updateStatusGuardColor(View view2) {
        boolean z;
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, view2) == null) {
            if ((ViewCompat.getWindowSystemUiVisibility(view2) & 8192) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                color = ContextCompat.getColor(this.mContext, R.color.obfuscated_res_0x7f06036a);
            } else {
                color = ContextCompat.getColor(this.mContext, R.color.obfuscated_res_0x7f060369);
            }
            view2.setBackgroundColor(color);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            this.mBaseContextAttached = true;
            applyDayNight(false);
            ensureWindow();
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                String str = null;
                try {
                    str = NavUtils.getParentActivityName((Activity) obj);
                } catch (IllegalArgumentException unused) {
                }
                if (str != null) {
                    ActionBar peekSupportActionBar = peekSupportActionBar();
                    if (peekSupportActionBar == null) {
                        this.mEnableDefaultActionBarUp = true;
                    } else {
                        peekSupportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
                    }
                }
                AppCompatDelegate.addActiveDelegate(this);
            }
            this.mCreated = true;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            ensureSubDecor();
            ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
            viewGroup.removeAllViews();
            LayoutInflater.from(this.mContext).inflate(i, viewGroup);
            this.mAppCompatWindowCallback.getWrapped().onContentChanged();
        }
    }

    private boolean initializePanelMenu(PanelFeatureState panelFeatureState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, panelFeatureState)) == null) {
            Context context = this.mContext;
            int i = panelFeatureState.featureId;
            if ((i == 0 || i == 108) && this.mDecorContentParent != null) {
                TypedValue typedValue = new TypedValue();
                Resources.Theme theme = context.getTheme();
                theme.resolveAttribute(R.attr.obfuscated_res_0x7f040053, typedValue, true);
                Resources.Theme theme2 = null;
                if (typedValue.resourceId != 0) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                    theme2.applyStyle(typedValue.resourceId, true);
                    theme2.resolveAttribute(R.attr.obfuscated_res_0x7f040054, typedValue, true);
                } else {
                    theme.resolveAttribute(R.attr.obfuscated_res_0x7f040054, typedValue, true);
                }
                if (typedValue.resourceId != 0) {
                    if (theme2 == null) {
                        theme2 = context.getResources().newTheme();
                        theme2.setTo(theme);
                    }
                    theme2.applyStyle(typedValue.resourceId, true);
                }
                if (theme2 != null) {
                    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                    contextThemeWrapper.getTheme().setTo(theme2);
                    context = contextThemeWrapper;
                }
            }
            MenuBuilder menuBuilder = new MenuBuilder(context);
            menuBuilder.setCallback(this);
            panelFeatureState.setMenu(menuBuilder);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i)) == null) {
            int sanitizeWindowFeatureId = sanitizeWindowFeatureId(i);
            if (this.mWindowNoTitle && sanitizeWindowFeatureId == 108) {
                return false;
            }
            if (this.mHasActionBar && sanitizeWindowFeatureId == 1) {
                this.mHasActionBar = false;
            }
            if (sanitizeWindowFeatureId != 1) {
                if (sanitizeWindowFeatureId != 2) {
                    if (sanitizeWindowFeatureId != 5) {
                        if (sanitizeWindowFeatureId != 10) {
                            if (sanitizeWindowFeatureId != 108) {
                                if (sanitizeWindowFeatureId != 109) {
                                    return this.mWindow.requestFeature(sanitizeWindowFeatureId);
                                }
                                throwFeatureRequestIfSubDecorInstalled();
                                this.mOverlayActionBar = true;
                                return true;
                            }
                            throwFeatureRequestIfSubDecorInstalled();
                            this.mHasActionBar = true;
                            return true;
                        }
                        throwFeatureRequestIfSubDecorInstalled();
                        this.mOverlayActionMode = true;
                        return true;
                    }
                    throwFeatureRequestIfSubDecorInstalled();
                    this.mFeatureIndeterminateProgress = true;
                    return true;
                }
                throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureProgress = true;
                return true;
            }
            throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        }
        return invokeI.booleanValue;
    }

    private boolean onKeyDownPanel(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65560, this, i, keyEvent)) == null) {
            if (keyEvent.getRepeatCount() == 0) {
                PanelFeatureState panelState = getPanelState(i, true);
                if (!panelState.isOpen) {
                    return preparePanel(panelState, keyEvent);
                }
                return false;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, layoutParams) == null) {
            ensureSubDecor();
            ((ViewGroup) this.mSubDecor.findViewById(16908290)).addView(view2, layoutParams);
            this.mAppCompatWindowCallback.getWrapped().onContentChanged();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048611, this, i, keyEvent)) == null) {
            boolean z = true;
            if (i != 4) {
                if (i == 82) {
                    onKeyDownPanel(0, keyEvent);
                    return true;
                }
            } else {
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.mLongPressBackDown = z;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        InterceptResult invokeLL;
        PanelFeatureState findMenuPanel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048614, this, menuBuilder, menuItem)) == null) {
            Window.Callback windowCallback = getWindowCallback();
            if (windowCallback != null && !this.mIsDestroyed && (findMenuPanel = findMenuPanel(menuBuilder.getRootMenu())) != null) {
                return windowCallback.onMenuItemSelected(findMenuPanel.featureId, menuItem);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, view2, layoutParams) == null) {
            ensureSubDecor();
            ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
            viewGroup.removeAllViews();
            viewGroup.addView(view2, layoutParams);
            this.mAppCompatWindowCallback.getWrapped().onContentChanged();
        }
    }

    private boolean onKeyUpPanel(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        boolean z;
        DecorContentParent decorContentParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65561, this, i, keyEvent)) == null) {
            if (this.mActionMode != null) {
                return false;
            }
            boolean z2 = true;
            PanelFeatureState panelState = getPanelState(i, true);
            if (i == 0 && (decorContentParent = this.mDecorContentParent) != null && decorContentParent.canShowOverflowMenu() && !ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
                if (!this.mDecorContentParent.isOverflowMenuShowing()) {
                    if (!this.mIsDestroyed && preparePanel(panelState, keyEvent)) {
                        z2 = this.mDecorContentParent.showOverflowMenu();
                    }
                    z2 = false;
                } else {
                    z2 = this.mDecorContentParent.hideOverflowMenu();
                }
            } else if (!panelState.isOpen && !panelState.isHandled) {
                if (panelState.isPrepared) {
                    if (panelState.refreshMenuContent) {
                        panelState.isPrepared = false;
                        z = preparePanel(panelState, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        openPanel(panelState, keyEvent);
                    }
                }
                z2 = false;
            } else {
                boolean z3 = panelState.isOpen;
                closePanel(panelState, true);
                z2 = z3;
            }
            if (z2) {
                AudioManager audioManager = (AudioManager) this.mContext.getApplicationContext().getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                } else {
                    Log.w(AppCompatDelegate.TAG, "Couldn't get audio manager");
                }
            }
            return z2;
        }
        return invokeIL.booleanValue;
    }

    private boolean performPanelShortcut(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        InterceptResult invokeCommon;
        MenuBuilder menuBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, this, new Object[]{panelFeatureState, Integer.valueOf(i), keyEvent, Integer.valueOf(i2)})) == null) {
            boolean z = false;
            if (keyEvent.isSystem()) {
                return false;
            }
            if ((panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.menu) != null) {
                z = menuBuilder.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.mDecorContentParent == null) {
                closePanel(panelFeatureState, true);
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    private void reopenMenu(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65565, this, z) == null) {
            DecorContentParent decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null && decorContentParent.canShowOverflowMenu() && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey() || this.mDecorContentParent.isOverflowMenuShowPending())) {
                Window.Callback windowCallback = getWindowCallback();
                if (this.mDecorContentParent.isOverflowMenuShowing() && z) {
                    this.mDecorContentParent.hideOverflowMenu();
                    if (!this.mIsDestroyed) {
                        windowCallback.onPanelClosed(108, getPanelState(0, true).menu);
                        return;
                    }
                    return;
                } else if (windowCallback != null && !this.mIsDestroyed) {
                    if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
                        this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
                        this.mInvalidatePanelMenuRunnable.run();
                    }
                    PanelFeatureState panelState = getPanelState(0, true);
                    MenuBuilder menuBuilder = panelState.menu;
                    if (menuBuilder != null && !panelState.refreshMenuContent && windowCallback.onPreparePanel(0, panelState.createdPanelView, menuBuilder)) {
                        windowCallback.onMenuOpened(108, panelState.menu);
                        this.mDecorContentParent.showOverflowMenu();
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            PanelFeatureState panelState2 = getPanelState(0, true);
            panelState2.refreshDecorView = true;
            closePanel(panelState2, false);
            openPanel(panelState2, null);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            boolean z = true;
            this.mBaseContextAttached = true;
            int mapNightMode = mapNightMode(context, calculateNightMode());
            Configuration configuration = null;
            if (sCanApplyOverrideConfiguration && (context instanceof android.view.ContextThemeWrapper)) {
                try {
                    ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((android.view.ContextThemeWrapper) context, createOverrideConfigurationForDayNight(context, mapNightMode, null));
                    return context;
                } catch (IllegalStateException unused) {
                }
            }
            if (context instanceof ContextThemeWrapper) {
                try {
                    ((ContextThemeWrapper) context).applyOverrideConfiguration(createOverrideConfigurationForDayNight(context, mapNightMode, null));
                    return context;
                } catch (IllegalStateException unused2) {
                }
            }
            if (!sCanReturnDifferentContext) {
                return super.attachBaseContext2(context);
            }
            try {
                Configuration configuration2 = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
                Configuration configuration3 = context.getResources().getConfiguration();
                if (!configuration2.equals(configuration3)) {
                    configuration = generateConfigDelta(configuration2, configuration3);
                }
                Configuration createOverrideConfigurationForDayNight = createOverrideConfigurationForDayNight(context, mapNightMode, configuration);
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, (int) R.style.obfuscated_res_0x7f100227);
                contextThemeWrapper.applyOverrideConfiguration(createOverrideConfigurationForDayNight);
                boolean z2 = false;
                try {
                    if (context.getTheme() == null) {
                        z = false;
                    }
                    z2 = z;
                } catch (NullPointerException unused3) {
                }
                if (z2) {
                    ResourcesCompat.ThemeCompat.rebase(contextThemeWrapper.getTheme());
                }
                return super.attachBaseContext2(contextThemeWrapper);
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("Application failed to obtain resources from itself", e);
            }
        }
        return (Context) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean updateForNightMode(int i, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65570, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Configuration createOverrideConfigurationForDayNight = createOverrideConfigurationForDayNight(this.mContext, i, null);
            boolean isActivityManifestHandlingUiMode = isActivityManifestHandlingUiMode();
            int i2 = this.mContext.getResources().getConfiguration().uiMode & 48;
            int i3 = createOverrideConfigurationForDayNight.uiMode & 48;
            boolean z3 = true;
            if (i2 != i3 && z && !isActivityManifestHandlingUiMode && this.mBaseContextAttached && (sCanReturnDifferentContext || this.mCreated)) {
                Object obj = this.mHost;
                if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                    ActivityCompat.recreate((Activity) this.mHost);
                    z2 = true;
                    if (z2 && i2 != i3) {
                        updateResourcesConfigurationForNightMode(i3, isActivityManifestHandlingUiMode, null);
                    } else {
                        z3 = z2;
                    }
                    if (z3) {
                        Object obj2 = this.mHost;
                        if (obj2 instanceof AppCompatActivity) {
                            ((AppCompatActivity) obj2).onNightModeChanged(i);
                        }
                    }
                    return z3;
                }
            }
            z2 = false;
            if (z2) {
            }
            z3 = z2;
            if (z3) {
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    private void updateResourcesConfigurationForNightMode(int i, boolean z, @Nullable Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), configuration}) == null) {
            Resources resources = this.mContext.getResources();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            if (configuration != null) {
                configuration2.updateFrom(configuration);
            }
            configuration2.uiMode = i | (resources.getConfiguration().uiMode & (-49));
            resources.updateConfiguration(configuration2, null);
            if (Build.VERSION.SDK_INT < 26) {
                ResourcesFlusher.flush(resources);
            }
            int i2 = this.mThemeResId;
            if (i2 != 0) {
                this.mContext.setTheme(i2);
                if (Build.VERSION.SDK_INT >= 23) {
                    this.mContext.getTheme().applyStyle(this.mThemeResId, true);
                }
            }
            if (z) {
                Object obj = this.mHost;
                if (obj instanceof Activity) {
                    Activity activity = (Activity) obj;
                    if (activity instanceof LifecycleOwner) {
                        if (((LifecycleOwner) activity).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                            activity.onConfigurationChanged(configuration2);
                        }
                    } else if (this.mStarted) {
                        activity.onConfigurationChanged(configuration2);
                    }
                }
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048608, this, view2, str, context, attributeSet)) == null) {
            return createView(view2, str, context, attributeSet);
        }
        return (View) invokeLLLL.objValue;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048609, this, str, context, attributeSet)) == null) {
            return onCreateView(null, str, context, attributeSet);
        }
        return (View) invokeLLL.objValue;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i, keyEvent)) == null) {
            if (i != 4) {
                if (i == 82) {
                    onKeyUpPanel(0, keyEvent);
                    return true;
                }
            } else {
                boolean z = this.mLongPressBackDown;
                this.mLongPressBackDown = false;
                PanelFeatureState panelState = getPanelState(0, false);
                if (panelState != null && panelState.isOpen) {
                    if (!z) {
                        closePanel(panelState, true);
                    }
                    return true;
                } else if (onBackPressed()) {
                    return true;
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public androidx.appcompat.view.ActionMode startSupportActionModeFromWindow(@NonNull ActionMode.Callback callback) {
        InterceptResult invokeL;
        androidx.appcompat.view.ActionMode actionMode;
        Context context;
        androidx.appcompat.view.ActionMode actionMode2;
        AppCompatCallback appCompatCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, callback)) == null) {
            endOnGoingFadeAnimation();
            androidx.appcompat.view.ActionMode actionMode3 = this.mActionMode;
            if (actionMode3 != null) {
                actionMode3.finish();
            }
            if (!(callback instanceof ActionModeCallbackWrapperV9)) {
                callback = new ActionModeCallbackWrapperV9(this, callback);
            }
            AppCompatCallback appCompatCallback2 = this.mAppCompatCallback;
            if (appCompatCallback2 != null && !this.mIsDestroyed) {
                try {
                    actionMode = appCompatCallback2.onWindowStartingSupportActionMode(callback);
                } catch (AbstractMethodError unused) {
                }
                if (actionMode == null) {
                    this.mActionMode = actionMode;
                } else {
                    boolean z = true;
                    if (this.mActionModeView == null) {
                        if (this.mIsFloating) {
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme theme = this.mContext.getTheme();
                            theme.resolveAttribute(R.attr.obfuscated_res_0x7f040053, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                Resources.Theme newTheme = this.mContext.getResources().newTheme();
                                newTheme.setTo(theme);
                                newTheme.applyStyle(typedValue.resourceId, true);
                                context = new ContextThemeWrapper(this.mContext, 0);
                                context.getTheme().setTo(newTheme);
                            } else {
                                context = this.mContext;
                            }
                            this.mActionModeView = new ActionBarContextView(context);
                            PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, (int) R.attr.obfuscated_res_0x7f040063);
                            this.mActionModePopup = popupWindow;
                            PopupWindowCompat.setWindowLayoutType(popupWindow, 2);
                            this.mActionModePopup.setContentView(this.mActionModeView);
                            this.mActionModePopup.setWidth(-1);
                            context.getTheme().resolveAttribute(R.attr.obfuscated_res_0x7f04004d, typedValue, true);
                            this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                            this.mActionModePopup.setHeight(-2);
                            this.mShowActionModePopup = new Runnable(this) { // from class: androidx.appcompat.app.AppCompatDelegateImpl.6
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AppCompatDelegateImpl this$0;

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

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                                        appCompatDelegateImpl.mActionModePopup.showAtLocation(appCompatDelegateImpl.mActionModeView, 55, 0, 0);
                                        this.this$0.endOnGoingFadeAnimation();
                                        if (this.this$0.shouldAnimateActionModeView()) {
                                            this.this$0.mActionModeView.setAlpha(0.0f);
                                            AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
                                            appCompatDelegateImpl2.mFadeAnim = ViewCompat.animate(appCompatDelegateImpl2.mActionModeView).alpha(1.0f);
                                            this.this$0.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter(this) { // from class: androidx.appcompat.app.AppCompatDelegateImpl.6.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass6 this$1;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i = newInitContext.flag;
                                                        if ((i & 1) != 0) {
                                                            int i2 = i & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$1 = this;
                                                }

                                                @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                                public void onAnimationEnd(View view2) {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, view2) == null) {
                                                        this.this$1.this$0.mActionModeView.setAlpha(1.0f);
                                                        this.this$1.this$0.mFadeAnim.setListener(null);
                                                        this.this$1.this$0.mFadeAnim = null;
                                                    }
                                                }

                                                @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                                public void onAnimationStart(View view2) {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                                                        this.this$1.this$0.mActionModeView.setVisibility(0);
                                                    }
                                                }
                                            });
                                            return;
                                        }
                                        this.this$0.mActionModeView.setAlpha(1.0f);
                                        this.this$0.mActionModeView.setVisibility(0);
                                    }
                                }
                            };
                        } else {
                            ViewStubCompat viewStubCompat = (ViewStubCompat) this.mSubDecor.findViewById(R.id.obfuscated_res_0x7f09006d);
                            if (viewStubCompat != null) {
                                viewStubCompat.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
                                this.mActionModeView = (ActionBarContextView) viewStubCompat.inflate();
                            }
                        }
                    }
                    if (this.mActionModeView != null) {
                        endOnGoingFadeAnimation();
                        this.mActionModeView.killMode();
                        Context context2 = this.mActionModeView.getContext();
                        ActionBarContextView actionBarContextView = this.mActionModeView;
                        if (this.mActionModePopup != null) {
                            z = false;
                        }
                        StandaloneActionMode standaloneActionMode = new StandaloneActionMode(context2, actionBarContextView, callback, z);
                        if (callback.onCreateActionMode(standaloneActionMode, standaloneActionMode.getMenu())) {
                            standaloneActionMode.invalidate();
                            this.mActionModeView.initForMode(standaloneActionMode);
                            this.mActionMode = standaloneActionMode;
                            if (shouldAnimateActionModeView()) {
                                this.mActionModeView.setAlpha(0.0f);
                                ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this.mActionModeView).alpha(1.0f);
                                this.mFadeAnim = alpha;
                                alpha.setListener(new ViewPropertyAnimatorListenerAdapter(this) { // from class: androidx.appcompat.app.AppCompatDelegateImpl.7
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AppCompatDelegateImpl this$0;

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

                                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                    public void onAnimationEnd(View view2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                            this.this$0.mActionModeView.setAlpha(1.0f);
                                            this.this$0.mFadeAnim.setListener(null);
                                            this.this$0.mFadeAnim = null;
                                        }
                                    }

                                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                    public void onAnimationStart(View view2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                                            this.this$0.mActionModeView.setVisibility(0);
                                            this.this$0.mActionModeView.sendAccessibilityEvent(32);
                                            if (this.this$0.mActionModeView.getParent() instanceof View) {
                                                ViewCompat.requestApplyInsets((View) this.this$0.mActionModeView.getParent());
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.mActionModeView.setAlpha(1.0f);
                                this.mActionModeView.setVisibility(0);
                                this.mActionModeView.sendAccessibilityEvent(32);
                                if (this.mActionModeView.getParent() instanceof View) {
                                    ViewCompat.requestApplyInsets((View) this.mActionModeView.getParent());
                                }
                            }
                            if (this.mActionModePopup != null) {
                                this.mWindow.getDecorView().post(this.mShowActionModePopup);
                            }
                        } else {
                            this.mActionMode = null;
                        }
                    }
                }
                actionMode2 = this.mActionMode;
                if (actionMode2 != null && (appCompatCallback = this.mAppCompatCallback) != null) {
                    appCompatCallback.onSupportActionModeStarted(actionMode2);
                }
                return this.mActionMode;
            }
            actionMode = null;
            if (actionMode == null) {
            }
            actionMode2 = this.mActionMode;
            if (actionMode2 != null) {
                appCompatCallback.onSupportActionModeStarted(actionMode2);
            }
            return this.mActionMode;
        }
        return (androidx.appcompat.view.ActionMode) invokeL.objValue;
    }

    public final int updateStatusGuard(@Nullable WindowInsetsCompat windowInsetsCompat, @Nullable Rect rect) {
        InterceptResult invokeLL;
        int i;
        boolean z;
        int systemWindowInsetLeft;
        int systemWindowInsetRight;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, windowInsetsCompat, rect)) == null) {
            int i2 = 0;
            if (windowInsetsCompat != null) {
                i = windowInsetsCompat.getSystemWindowInsetTop();
            } else if (rect != null) {
                i = rect.top;
            } else {
                i = 0;
            }
            ActionBarContextView actionBarContextView = this.mActionModeView;
            if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
                boolean z3 = true;
                if (this.mActionModeView.isShown()) {
                    if (this.mTempRect1 == null) {
                        this.mTempRect1 = new Rect();
                        this.mTempRect2 = new Rect();
                    }
                    Rect rect2 = this.mTempRect1;
                    Rect rect3 = this.mTempRect2;
                    if (windowInsetsCompat == null) {
                        rect2.set(rect);
                    } else {
                        rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    }
                    ViewUtils.computeFitSystemWindows(this.mSubDecor, rect2, rect3);
                    int i3 = rect2.top;
                    int i4 = rect2.left;
                    int i5 = rect2.right;
                    WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.mSubDecor);
                    if (rootWindowInsets == null) {
                        systemWindowInsetLeft = 0;
                    } else {
                        systemWindowInsetLeft = rootWindowInsets.getSystemWindowInsetLeft();
                    }
                    if (rootWindowInsets == null) {
                        systemWindowInsetRight = 0;
                    } else {
                        systemWindowInsetRight = rootWindowInsets.getSystemWindowInsetRight();
                    }
                    if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                        z2 = false;
                    } else {
                        marginLayoutParams.topMargin = i3;
                        marginLayoutParams.leftMargin = i4;
                        marginLayoutParams.rightMargin = i5;
                        z2 = true;
                    }
                    if (i3 > 0 && this.mStatusGuard == null) {
                        View view2 = new View(this.mContext);
                        this.mStatusGuard = view2;
                        view2.setVisibility(8);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                        layoutParams.leftMargin = systemWindowInsetLeft;
                        layoutParams.rightMargin = systemWindowInsetRight;
                        this.mSubDecor.addView(this.mStatusGuard, -1, layoutParams);
                    } else {
                        View view3 = this.mStatusGuard;
                        if (view3 != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                            if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                                marginLayoutParams2.height = marginLayoutParams.topMargin;
                                marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                                marginLayoutParams2.rightMargin = systemWindowInsetRight;
                                this.mStatusGuard.setLayoutParams(marginLayoutParams2);
                            }
                        }
                    }
                    if (this.mStatusGuard == null) {
                        z3 = false;
                    }
                    if (z3 && this.mStatusGuard.getVisibility() != 0) {
                        updateStatusGuardColor(this.mStatusGuard);
                    }
                    if (!this.mOverlayActionMode && z3) {
                        i = 0;
                    }
                    z = z3;
                    z3 = z2;
                } else if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z = false;
                } else {
                    z = false;
                    z3 = false;
                }
                if (z3) {
                    this.mActionModeView.setLayoutParams(marginLayoutParams);
                }
            } else {
                z = false;
            }
            View view4 = this.mStatusGuard;
            if (view4 != null) {
                if (!z) {
                    i2 = 8;
                }
                view4.setVisibility(i2);
            }
            return i;
        }
        return invokeLL.intValue;
    }
}
