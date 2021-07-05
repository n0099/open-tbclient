package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class AppCompatDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;
    @Deprecated
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;
    @Deprecated
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    public static final String TAG = "AppCompatDelegate";
    public static final ArraySet<WeakReference<AppCompatDelegate>> sActivityDelegates;
    public static final Object sActivityDelegatesLock;
    public static int sDefaultNightMode = -100;
    public transient /* synthetic */ FieldHolder $fh;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface NightMode {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-943532633, "Landroidx/appcompat/app/AppCompatDelegate;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-943532633, "Landroidx/appcompat/app/AppCompatDelegate;");
                return;
            }
        }
        sActivityDelegates = new ArraySet<>();
        sActivityDelegatesLock = new Object();
    }

    public AppCompatDelegate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addActiveDelegate(@NonNull AppCompatDelegate appCompatDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, appCompatDelegate) == null) {
            synchronized (sActivityDelegatesLock) {
                removeDelegateFromActives(appCompatDelegate);
                sActivityDelegates.add(new WeakReference<>(appCompatDelegate));
            }
        }
    }

    public static void applyDayNightToActiveDelegates() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (sActivityDelegatesLock) {
                Iterator<WeakReference<AppCompatDelegate>> it = sActivityDelegates.iterator();
                while (it.hasNext()) {
                    AppCompatDelegate appCompatDelegate = it.next().get();
                    if (appCompatDelegate != null) {
                        appCompatDelegate.applyDayNight();
                    }
                }
            }
        }
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Activity activity, @Nullable AppCompatCallback appCompatCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, activity, appCompatCallback)) == null) ? new AppCompatDelegateImpl(activity, appCompatCallback) : (AppCompatDelegate) invokeLL.objValue;
    }

    public static int getDefaultNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? sDefaultNightMode : invokeV.intValue;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? VectorEnabledTintResources.isCompatVectorFromResourcesEnabled() : invokeV.booleanValue;
    }

    public static void removeActivityDelegate(@NonNull AppCompatDelegate appCompatDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, appCompatDelegate) == null) {
            synchronized (sActivityDelegatesLock) {
                removeDelegateFromActives(appCompatDelegate);
            }
        }
    }

    public static void removeDelegateFromActives(@NonNull AppCompatDelegate appCompatDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, appCompatDelegate) == null) {
            synchronized (sActivityDelegatesLock) {
                Iterator<WeakReference<AppCompatDelegate>> it = sActivityDelegates.iterator();
                while (it.hasNext()) {
                    AppCompatDelegate appCompatDelegate2 = it.next().get();
                    if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                        it.remove();
                    }
                }
            }
        }
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(z);
        }
    }

    public static void setDefaultNightMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i2) == null) {
            if (i2 != -1 && i2 != 0 && i2 != 1 && i2 != 2 && i2 != 3) {
                Log.d(TAG, "setDefaultNightMode() called with an unknown mode");
            } else if (sDefaultNightMode != i2) {
                sDefaultNightMode = i2;
                applyDayNightToActiveDelegates();
            }
        }
    }

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean applyDayNight();

    @Deprecated
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
        }
    }

    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            attachBaseContext(context);
            return context;
        }
        return (Context) invokeL.objValue;
    }

    public abstract View createView(@Nullable View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet);

    @Nullable
    public abstract <T extends View> T findViewById(@IdRes int i2);

    @Nullable
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return -100;
        }
        return invokeV.intValue;
    }

    public abstract MenuInflater getMenuInflater();

    @Nullable
    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int i2);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle bundle);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i2);

    public abstract void setContentView(@LayoutRes int i2);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setHandleNativeActionModesEnabled(boolean z);

    @RequiresApi(17)
    public abstract void setLocalNightMode(int i2);

    public abstract void setSupportActionBar(@Nullable Toolbar toolbar);

    public void setTheme(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
        }
    }

    public abstract void setTitle(@Nullable CharSequence charSequence);

    @Nullable
    public abstract ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback);

    @NonNull
    public static AppCompatDelegate create(@NonNull Dialog dialog, @Nullable AppCompatCallback appCompatCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, dialog, appCompatCallback)) == null) ? new AppCompatDelegateImpl(dialog, appCompatCallback) : (AppCompatDelegate) invokeLL.objValue;
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context context, @NonNull Window window, @Nullable AppCompatCallback appCompatCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, window, appCompatCallback)) == null) ? new AppCompatDelegateImpl(context, window, appCompatCallback) : (AppCompatDelegate) invokeLLL.objValue;
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context context, @NonNull Activity activity, @Nullable AppCompatCallback appCompatCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, activity, appCompatCallback)) == null) ? new AppCompatDelegateImpl(context, activity, appCompatCallback) : (AppCompatDelegate) invokeLLL.objValue;
    }
}
