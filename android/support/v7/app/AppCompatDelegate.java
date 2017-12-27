package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public abstract class AppCompatDelegate {
    private static int Co = -1;
    private static boolean Cp = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_YES = 2;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface NightMode {
    }

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean applyDayNight();

    public abstract View createView(View view, String str, Context context, AttributeSet attributeSet);

    public abstract View findViewById(int i);

    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int i);

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

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setHandleNativeActionModesEnabled(boolean z);

    public abstract void setLocalNightMode(int i);

    public abstract void setSupportActionBar(Toolbar toolbar);

    public abstract void setTitle(CharSequence charSequence);

    public abstract ActionMode startSupportActionMode(ActionMode.Callback callback);

    public static AppCompatDelegate create(Activity activity, AppCompatCallback appCompatCallback) {
        return a(activity, activity.getWindow(), appCompatCallback);
    }

    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback appCompatCallback) {
        return a(dialog.getContext(), dialog.getWindow(), appCompatCallback);
    }

    private static AppCompatDelegate a(Context context, Window window, AppCompatCallback appCompatCallback) {
        int i = Build.VERSION.SDK_INT;
        if (BuildCompat.isAtLeastN()) {
            return new c(context, window, appCompatCallback);
        }
        if (i >= 23) {
            return new f(context, window, appCompatCallback);
        }
        if (i >= 14) {
            return new e(context, window, appCompatCallback);
        }
        if (i >= 11) {
            return new d(context, window, appCompatCallback);
        }
        return new AppCompatDelegateImplV9(context, window, appCompatCallback);
    }

    public static void setDefaultNightMode(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
                Co = i;
                return;
            default:
                Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
                return;
        }
    }

    public static int getDefaultNightMode() {
        return Co;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        Cp = z;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return Cp;
    }
}
