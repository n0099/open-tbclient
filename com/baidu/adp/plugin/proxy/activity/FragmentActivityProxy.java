package com.baidu.adp.plugin.proxy.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import c.a.d.a.a;
import c.a.d.a.f;
import c.a.d.a.g;
import c.a.d.a.h;
import c.a.d.a.i;
import c.a.d.j.d;
import c.a.d.j.f.b;
import c.a.d.j.k.d;
import c.a.d.o.e.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseFragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes3.dex */
public class FragmentActivityProxy extends FragmentActivity implements b, i, Handler.Callback, g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PluginBaseFragmentActivity mEntity;

    public FragmentActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEntity = null;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, layoutParams) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.addContentView(view, layoutParams);
            } else {
                super.addContentView(view, layoutParams);
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, serviceConnection, i2)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.bindService(intent, serviceConnection, i2);
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.closeContextMenu();
            } else {
                super.closeContextMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.closeOptionsMenu();
            } else {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), intent, Integer.valueOf(i3)})) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.createPendingResult(i2, intent, i3);
            }
            return super.createPendingResult(i2, intent, i3);
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.dispatchGenericMotionEvent(motionEvent);
            }
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, keyEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, keyEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.dispatchKeyShortcutEvent(keyEvent);
            }
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, accessibilityEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.dispatchTrackballEvent(motionEvent);
            }
            return super.dispatchTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.findViewById(i2);
            }
            return super.findViewById(i2);
        }
        return (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.finish();
            } else {
                super.finish();
            }
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.finishActivity(i2);
            } else {
                super.finishActivity(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, activity, i2) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.finishActivityFromChild(activity, i2);
            } else {
                super.finishActivityFromChild(activity, i2);
            }
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, activity) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.finishFromChild(activity);
            } else {
                super.finishFromChild(activity);
            }
        }
    }

    @Override // c.a.d.j.f.a
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (Activity) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getApplicationContext();
            }
            return super.getApplicationContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getAssets();
            }
            return super.getAssets();
        }
        return (AssetManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getCallingActivity();
            }
            return super.getCallingActivity();
        }
        return (ComponentName) invokeV.objValue;
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getCallingPackage();
            }
            return super.getCallingPackage();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getClassLoader();
            }
            return null;
        }
        return (ClassLoader) invokeV.objValue;
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getCurrentFocus();
            }
            return super.getCurrentFocus();
        }
        return (View) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getIntent();
            }
            return super.getIntent();
        }
        return (Intent) invokeV.objValue;
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getLayoutInflater();
            }
            return super.getLayoutInflater();
        }
        return (LayoutInflater) invokeV.objValue;
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getLocalClassName();
            }
            return super.getLocalClassName();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getMenuInflater();
            }
            return super.getMenuInflater();
        }
        return (MenuInflater) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getPackageManager();
            }
            return null;
        }
        return (PackageManager) invokeV.objValue;
    }

    @Override // c.a.d.a.g
    public f getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity == null || !(pluginBaseFragmentActivity instanceof g)) {
                return null;
            }
            return pluginBaseFragmentActivity.getPageContext();
        }
        return (f) invokeV.objValue;
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getPreferences(i2);
            }
            return super.getPreferences(i2);
        }
        return (SharedPreferences) invokeI.objValue;
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getRequestedOrientation();
            }
            return super.getRequestedOrientation();
        }
        return invokeV.intValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
                if (pluginBaseFragmentActivity != null) {
                    return pluginBaseFragmentActivity.getResources();
                }
            } else {
                Resources resources = h.a().getResources();
                if (resources != null) {
                    return resources;
                }
            }
            return super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, str, i2)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getSharedPreferences(str, i2);
            }
            return null;
        }
        return (SharedPreferences) invokeLI.objValue;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getSystemService(str);
            }
            return super.getSystemService(str);
        }
        return invokeL.objValue;
    }

    @Override // android.app.Activity
    public int getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getTaskId();
            }
            return super.getTaskId();
        }
        return invokeV.intValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getTheme();
            }
            return null;
        }
        return (Resources.Theme) invokeV.objValue;
    }

    @Override // c.a.d.a.i
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getWallpaperDesiredMinimumHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getWallpaperDesiredMinimumWidth();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getWindow();
            }
            return super.getWindow();
        }
        return (Window) invokeV.objValue;
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getWindowManager();
            }
            return super.getWindowManager();
        }
        return (WindowManager) invokeV.objValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, message)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.handleMessage(message);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.hasWindowFocus();
            }
            return super.hasWindowFocus();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.isFinishing();
            }
            return super.isFinishing();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.d.a.i
    public boolean isScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.isScroll();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.isTaskRoot();
            }
            return super.isTaskRoot();
        }
        return invokeV.booleanValue;
    }

    public void loadEntityActivity() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && this.mEntity == null && !super.isFinishing()) {
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
            if (!PluginCenter.getInstance().isLoaded(stringExtra)) {
                finish();
                BdLog.e("plugin not loaded. pluginname is " + stringExtra);
                return;
            }
            try {
                String stringExtra2 = intent.getStringExtra(Plugin.INTENT_EXTRA_ACTIVITY);
                if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                    Plugin plugin2 = PluginCenter.getInstance().getPlugin(stringExtra);
                    PluginBaseFragmentActivity pluginBaseFragmentActivity = (PluginBaseFragmentActivity) plugin2.getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseFragmentActivity.class).newInstance();
                    this.mEntity = pluginBaseFragmentActivity;
                    pluginBaseFragmentActivity.setActivityProxy((b) this);
                    this.mEntity.setPluginPackageName(stringExtra);
                    setTheme(plugin2.getActivityThemeResource());
                } else {
                    PluginBaseFragmentActivity pluginBaseFragmentActivity2 = (PluginBaseFragmentActivity) PluginCenter.getInstance().getPlugin(stringExtra).getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseFragmentActivity.class).newInstance();
                    this.mEntity = pluginBaseFragmentActivity2;
                    pluginBaseFragmentActivity2.setActivityProxy((b) this);
                    this.mEntity.setPluginPackageName(stringExtra);
                }
            } catch (ClassNotFoundException e2) {
                BdLog.e(e2);
            } catch (IllegalAccessException e3) {
                BdLog.e(e3);
            } catch (InstantiationException e4) {
                BdLog.e(e4);
            } catch (Exception e5) {
                BdLog.e(e5);
            }
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048627, this, z)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.moveTaskToBack(z);
            }
            return super.moveTaskToBack(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048628, this, i2, i3, intent) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                Class cls = Integer.TYPE;
                d.k(pluginBaseFragmentActivity, "onActivityResult", new Class[]{cls, cls, Intent.class}, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent});
                return;
            }
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, "onApplyThemeResource", new Class[]{Resources.Theme.class, Integer.TYPE, Boolean.TYPE}, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)});
            } else {
                super.onApplyThemeResource(theme, i2, z);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onAttachedToWindow();
            } else {
                super.onAttachedToWindow();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onBackPressed();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, activity, charSequence) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, "onChildTitleChanged", new Class[]{Activity.class, CharSequence.class}, new Object[]{activity, charSequence});
            } else {
                super.onChildTitleChanged(activity, charSequence);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, configuration) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onConfigurationChanged(configuration);
            } else {
                super.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onContentChanged();
            } else {
                super.onContentChanged();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, menuItem)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onContextItemSelected(menuItem);
            }
            return super.onContextItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, menu) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onContextMenuClosed(menu);
            } else {
                super.onContextMenuClosed(menu);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, bundle, persistableBundle) == null) {
            a.b(this);
            super.onCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048639, this, contextMenu, view, contextMenuInfo) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            } else {
                super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            }
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onCreateDescription();
            }
            return super.onCreateDescription();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i2)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            return pluginBaseFragmentActivity != null ? (Dialog) d.k(pluginBaseFragmentActivity, "onCreateDialog", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i2)}) : super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048642, this, i2, menu)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onCreatePanelMenu(i2, menu);
            }
            return super.onCreatePanelMenu(i2, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i2)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onCreatePanelView(i2);
            }
            return super.onCreatePanelView(i2);
        }
        return (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048644, this, bitmap, canvas)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onCreateThumbnail(bitmap, canvas);
            }
            return super.onCreateThumbnail(bitmap, canvas);
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048645, this, str, context, attributeSet)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onCreateView(str, context, attributeSet);
            }
            return super.onCreateView(str, context, attributeSet);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, MissionEvent.MESSAGE_DESTROY, new Class[0], new Object[0]);
            } else {
                super.onDestroy();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onDetachedFromWindow();
            } else {
                super.onDetachedFromWindow();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048648, this, i2, keyEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onKeyDown(i2, keyEvent);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048649, this, i2, keyEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onKeyLongPress(i2, keyEvent);
            }
            return super.onKeyLongPress(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048650, this, i2, i3, keyEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onKeyMultiple(i2, i3, keyEvent);
            }
            return super.onKeyMultiple(i2, i3, keyEvent);
        }
        return invokeIIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048651, this, i2, keyEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onKeyUp(i2, keyEvent);
            }
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onLowMemory();
            } else {
                super.onLowMemory();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048653, this, i2, menuItem)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onMenuItemSelected(i2, menuItem);
            }
            return super.onMenuItemSelected(i2, menuItem);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048654, this, i2, menu)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onMenuOpened(i2, menu);
            }
            return super.onMenuOpened(i2, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, intent) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, "onNewIntent", new Class[]{Intent.class}, new Object[]{intent});
            } else {
                super.onNewIntent(intent);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, menuItem)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onOptionsItemSelected(menuItem);
            }
            return super.onOptionsItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, menu) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onOptionsMenuClosed(menu);
            } else {
                super.onOptionsMenuClosed(menu);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048658, this, i2, menu) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onPanelClosed(i2, menu);
            } else {
                super.onPanelClosed(i2, menu);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, MissionEvent.MESSAGE_PAUSE, new Class[0], new Object[0]);
            } else {
                super.onPause();
            }
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, bundle) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, "onPostCreate", new Class[]{Bundle.class}, new Object[]{bundle});
            } else {
                super.onPostCreate(bundle);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, "onPostResume", new Class[0], new Object[0]);
            } else {
                super.onPostResume();
            }
        }
    }

    @Override // c.a.d.a.i
    public void onPreLoad(q qVar) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, qVar) == null) || (pluginBaseFragmentActivity = this.mEntity) == null) {
            return;
        }
        pluginBaseFragmentActivity.onPreLoad(qVar);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048663, this, i2, dialog) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onPrepareDialog(i2, dialog);
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, menu)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onPrepareOptionsMenu(menu);
            }
            return super.onPrepareOptionsMenu(menu);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048665, this, i2, view, menu)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onPreparePanel(i2, view, menu);
            }
            return super.onPreparePanel(i2, view, menu);
        }
        return invokeILL.booleanValue;
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, "onRestart", new Class[0], new Object[0]);
            } else {
                super.onRestart();
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, bundle) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, "onRestoreInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
            } else {
                super.onRestoreInstanceState(bundle);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, "onResume", new Class[0], new Object[0]);
            } else {
                super.onResume();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, bundle) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, "onSaveInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
            } else {
                super.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onSearchRequested();
            }
            return super.onSearchRequested();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, "onStart", new Class[0], new Object[0]);
            } else {
                super.onStart();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                d.k(pluginBaseFragmentActivity, MissionEvent.MESSAGE_STOP, new Class[0], new Object[0]);
            } else {
                super.onStop();
            }
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048673, this, charSequence, i2) == null) || (pluginBaseFragmentActivity = this.mEntity) == null) {
            return;
        }
        d.k(pluginBaseFragmentActivity, "onTitleChanged", new Class[]{CharSequence.class, Integer.TYPE}, new Object[]{charSequence, Integer.valueOf(i2)});
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048674, this, motionEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048675, this, motionEvent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.onTrackballEvent(motionEvent);
            }
            return super.onTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onUserInteraction();
            } else {
                super.onUserInteraction();
            }
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            super.onUserLeaveHint();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, layoutParams) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onWindowAttributesChanged(layoutParams);
            } else {
                super.onWindowAttributesChanged(layoutParams);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.onWindowFocusChanged(z);
            } else {
                super.onWindowFocusChanged(z);
            }
        }
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, view) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.openContextMenu(view);
            } else {
                super.openContextMenu(view);
            }
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.openOptionsMenu();
            } else {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048682, this, i2, i3) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.overridePendingTransition(i2, i3);
            } else {
                super.overridePendingTransition(i2, i3);
            }
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyAddContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048683, this, view, layoutParams) == null) {
            super.addContentView(view, layoutParams);
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048684, this, intent, serviceConnection, i2)) == null) {
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyCloseContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            super.closeContextMenu();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyCloseOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            super.closeOptionsMenu();
        }
    }

    @Override // c.a.d.j.f.a
    public PendingIntent proxyCreatePendingResult(int i2, Intent intent, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048687, this, new Object[]{Integer.valueOf(i2), intent, Integer.valueOf(i3)})) == null) ? super.createPendingResult(i2, intent, i3) : (PendingIntent) invokeCommon.objValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyDispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048688, this, motionEvent)) == null) ? super.dispatchGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyDispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, keyEvent)) == null) ? super.dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048690, this, keyEvent)) == null) ? super.dispatchKeyShortcutEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048691, this, accessibilityEvent)) == null) ? super.dispatchPopulateAccessibilityEvent(accessibilityEvent) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyDispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048692, this, motionEvent)) == null) ? super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyDispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, motionEvent)) == null) ? super.dispatchTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public View proxyFindViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048694, this, i2)) == null) ? super.findViewById(i2) : (View) invokeI.objValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            super.finish();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyFinishActivity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i2) == null) {
            super.finishActivity(i2);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyFinishActivityFromChild(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048697, this, activity, i2) == null) {
            super.finishActivityFromChild(activity, i2);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyFinishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, activity) == null) {
            super.finishFromChild(activity);
        }
    }

    @Override // c.a.d.j.f.a
    public Context proxyGetApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? super.getApplicationContext() : (Context) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public ComponentName proxyGetCallingActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? super.getCallingActivity() : (ComponentName) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public String proxyGetCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? super.getCallingPackage() : (String) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public int proxyGetChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? super.getChangingConfigurations() : invokeV.intValue;
    }

    @Override // c.a.d.j.f.a
    public View proxyGetCurrentFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? super.getCurrentFocus() : (View) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public Intent proxyGetIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? super.getIntent() : (Intent) invokeV.objValue;
    }

    public Object proxyGetLastNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? super.getLastNonConfigurationInstance() : invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public LayoutInflater proxyGetLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? super.getLayoutInflater() : (LayoutInflater) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public String proxyGetLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? super.getLocalClassName() : (String) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public MenuInflater proxyGetMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? super.getMenuInflater() : (MenuInflater) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public PackageManager proxyGetPackageManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            return null;
        }
        return (PackageManager) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public SharedPreferences proxyGetPreferences(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048710, this, i2)) == null) ? super.getPreferences(i2) : (SharedPreferences) invokeI.objValue;
    }

    @Override // c.a.d.j.f.a
    public int proxyGetRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? super.getRequestedOrientation() : invokeV.intValue;
    }

    @Override // c.a.d.j.f.a
    public SharedPreferences proxyGetSharedPreferences(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048712, this, str, i2)) == null) {
            return null;
        }
        return (SharedPreferences) invokeLI.objValue;
    }

    @Override // c.a.d.j.f.b
    public FragmentManager proxyGetSupportFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? super.getSupportFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public Object proxyGetSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048714, this, str)) == null) ? super.getSystemService(str) : invokeL.objValue;
    }

    @Override // c.a.d.j.f.a
    public int proxyGetTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) ? super.getTaskId() : invokeV.intValue;
    }

    @Override // c.a.d.j.f.a
    public int proxyGetWallpaperDesiredMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.d.j.f.a
    public int proxyGetWallpaperDesiredMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.d.j.f.a
    public Window proxyGetWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) ? super.getWindow() : (Window) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public WindowManager proxyGetWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? super.getWindowManager() : (WindowManager) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyHasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? super.hasWindowFocus() : invokeV.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyIsFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? super.isFinishing() : invokeV.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyIsTaskRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? super.isTaskRoot() : invokeV.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyMoveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048723, this, z)) == null) ? super.moveTaskToBack(z) : invokeZ.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyOnActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048724, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048725, this, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.onApplyThemeResource(theme, i2, z);
        }
    }

    @Override // c.a.d.j.f.b
    public void proxyOnAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, fragment) == null) {
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048729, this, activity, charSequence) == null) {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            super.onContentChanged();
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048732, this, menuItem)) == null) ? super.onContextItemSelected(menuItem) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyOnContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, menu) == null) {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048735, this, contextMenu, view, contextMenuInfo) == null) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnCreatePanelMenu(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048736, this, i2, menu)) == null) ? super.onCreatePanelMenu(i2, menu) : invokeIL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048737, this, bitmap, canvas)) == null) ? super.onCreateThumbnail(bitmap, canvas) : invokeLL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public View proxyOnCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048739, this, str, context, attributeSet)) == null) ? super.onCreateView(str, context, attributeSet) : (View) invokeLLL.objValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyOnDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            super.onDestroy();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048742, this, i2, keyEvent)) == null) ? super.onKeyDown(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnKeyLongPress(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048743, this, i2, keyEvent)) == null) ? super.onKeyLongPress(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048744, this, i2, i3, keyEvent)) == null) ? super.onKeyMultiple(i2, i3, keyEvent) : invokeIIL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048745, this, i2, keyEvent)) == null) ? super.onKeyUp(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyOnLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            super.onLowMemory();
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnMenuItemSelected(int i2, MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048747, this, i2, menuItem)) == null) ? super.onMenuItemSelected(i2, menuItem) : invokeIL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnMenuOpened(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048748, this, i2, menu)) == null) ? super.onMenuOpened(i2, menu) : invokeIL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048749, this, menuItem)) == null) ? super.onOptionsItemSelected(menuItem) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyOnOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, menu) == null) {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnPanelClosed(int i2, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048751, this, i2, menu) == null) {
            super.onPanelClosed(i2, menu);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            super.onPause();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, bundle) == null) {
            super.onPostCreate(bundle);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            super.onPostResume();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048755, this, i2, dialog) == null) {
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048756, this, menu)) == null) ? super.onPrepareOptionsMenu(menu) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnPreparePanel(int i2, View view, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048757, this, i2, view, menu)) == null) ? super.onPreparePanel(i2, view, menu) : invokeILL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyOnRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            super.onRestart();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            super.onResume();
        }
    }

    @Override // c.a.d.j.f.a
    public Object proxyOnRetainNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) ? super.onRetainNonConfigurationInstance() : invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyOnSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? super.onSearchRequested() : invokeV.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyOnStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048764, this) == null) {
            super.onStart();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048765, this) == null) {
            super.onStop();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnTitleChanged(CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048766, this, charSequence, i2) == null) {
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048767, this, motionEvent)) == null) ? super.onTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public boolean proxyOnTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048768, this, motionEvent)) == null) ? super.onTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyOnUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048769, this) == null) {
            super.onUserInteraction();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, layoutParams) == null) {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOnWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048771, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOpenContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, view) == null) {
            super.openContextMenu(view);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOpenOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            super.openOptionsMenu();
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyOverridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048774, this, i2, i3) == null) {
            super.overridePendingTransition(i2, i3);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyRegisterForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048775, this, view) == null) {
            super.registerForContextMenu(view);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxySetContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048776, this, i2) == null) {
            super.setContentView(i2);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxySetIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048779, this, intent) == null) {
            super.setIntent(intent);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxySetRequestedOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048780, this, i2) == null) {
            super.setRequestedOrientation(i2);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxySetTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048781, this, i2) == null) {
            super.setTitle(i2);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxySetTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048783, this, i2) == null) {
            super.setTitleColor(i2);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxySetVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048784, this, z) == null) {
            super.setVisible(z);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyStartActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048785, this, intent) == null) {
            super.startActivity(intent);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyStartActivityForResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048786, this, intent, i2) == null) {
            super.startActivityForResult(intent, i2);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyStartActivityFromChild(Activity activity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048787, this, activity, intent, i2) == null) {
            super.startActivityFromChild(activity, intent, i2);
        }
    }

    @Override // c.a.d.j.f.b
    public void proxyStartActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048788, this, fragment, intent, i2) == null) {
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyStartActivityIfNeeded(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048789, this, intent, i2)) == null) ? super.startActivityIfNeeded(intent, i2) : invokeLI.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyStartIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048790, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.startIntentSender(intentSender, intent, i2, i3, i4);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyStartIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048791, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    public void proxyStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048792, this, new Object[]{activity, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyStartManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, cursor) == null) {
            super.startManagingCursor(cursor);
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyStartNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048794, this, intent)) == null) ? super.startNextMatchingActivity(intent) : invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyStartSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048795, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            super.startSearch(str, z, bundle, z2);
        }
    }

    @Override // c.a.d.j.f.a
    public ComponentName proxyStartService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048796, this, intent)) == null) {
            return null;
        }
        return (ComponentName) invokeL.objValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyStopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048797, this, cursor) == null) {
            super.stopManagingCursor(cursor);
        }
    }

    @Override // c.a.d.j.f.a
    public boolean proxyStopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048798, this, intent)) == null) {
            String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
            d.a c2 = stringExtra != null ? c.a.d.j.d.a().c(stringExtra) : null;
            if (c2 != null && c2.a != null) {
                if (c.a.d.j.d.a().b() == 1) {
                    c.a.d.j.d.a().e(stringExtra);
                    c2.a.stopSelf();
                    return true;
                }
                c2.a.onDestroy();
                c.a.d.j.d.a().e(stringExtra);
                return true;
            }
            BdLog.d("service stop error!" + intent.toString());
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.d.j.f.a
    public void proxyTakeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048799, this, z) == null) {
            super.takeKeyEvents(z);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxyUnregisterForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048800, this, view) == null) {
            super.unregisterForContextMenu(view);
        }
    }

    public void proxysetFinishOnTouchOutside(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048801, this, z) == null) {
            super.setFinishOnTouchOutside(z);
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048802, this, view) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.registerForContextMenu(view);
            } else {
                super.registerForContextMenu(view);
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048803, this, i2) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.setContentView(i2);
            } else {
                super.setContentView(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, intent) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.setIntent(intent);
            } else {
                super.setIntent(intent);
            }
        }
    }

    @Override // c.a.d.a.i
    public void setIsScroll(boolean z) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048807, this, z) == null) || (pluginBaseFragmentActivity = this.mEntity) == null) {
            return;
        }
        pluginBaseFragmentActivity.setIsScroll(z);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048808, this, i2) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.setRequestedOrientation(i2);
            } else if (a.d(this) && a.a(i2)) {
            } else {
                super.setRequestedOrientation(i2);
            }
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048809, this, i2) == null) || (pluginBaseFragmentActivity = this.mEntity) == null) {
            return;
        }
        pluginBaseFragmentActivity.setTheme(i2);
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048810, this, i2) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.setTitle(i2);
            } else {
                super.setTitle(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048812, this, i2) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.setTitleColor(i2);
            } else {
                super.setTitleColor(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048813, this, z) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.setVisible(z);
            } else {
                super.setVisible(z);
            }
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048814, this, intent) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.startActivity(intent);
            } else {
                super.startActivity(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048815, this, intent, i2) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.startActivityForResult(intent, i2);
            } else {
                super.startActivityForResult(intent, i2);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048816, this, activity, intent, i2) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.startActivityFromChild(activity, intent, i2);
            } else {
                super.startActivityFromChild(activity, intent, i2);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048817, this, intent, i2)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.startActivityIfNeeded(intent, i2);
            }
            return super.startActivityIfNeeded(intent, i2);
        }
        return invokeLI.booleanValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048818, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.startIntentSender(intentSender, intent, i2, i3, i4);
            } else {
                super.startIntentSender(intentSender, intent, i2, i3, i4);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048819, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
            } else {
                super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
            }
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048820, this, cursor) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.startManagingCursor(cursor);
            } else {
                super.startManagingCursor(cursor);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048821, this, intent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.startNextMatchingActivity(intent);
            }
            return super.startNextMatchingActivity(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048822, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.startSearch(str, z, bundle, z2);
            } else {
                super.startSearch(str, z, bundle, z2);
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048823, this, intent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.startService(intent);
            }
            return null;
        }
        return (ComponentName) invokeL.objValue;
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048824, this, cursor) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.stopManagingCursor(cursor);
            } else {
                super.stopManagingCursor(cursor);
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048825, this, intent)) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.stopService(intent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048826, this, z) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.takeKeyEvents(z);
            } else {
                super.takeKeyEvents(z);
            }
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048827, this, view) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.unregisterForContextMenu(view);
            } else {
                super.unregisterForContextMenu(view);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.j.f.a
    public PluginBaseFragmentActivity getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mEntity : (PluginBaseFragmentActivity) invokeV.objValue;
    }

    @Override // c.a.d.j.f.a
    public View proxyOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048738, this, view, str, context, attributeSet)) == null) ? super.onCreateView(view, str, context, attributeSet) : (View) invokeLLLL.objValue;
    }

    @Override // c.a.d.j.f.a
    public void proxySetContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048777, this, view) == null) {
            super.setContentView(view);
        }
    }

    @Override // c.a.d.j.f.a
    public void proxySetTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048782, this, charSequence) == null) {
            super.setTitle(charSequence);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, bundle) == null) {
            requestWindowFeature(1);
            this.mEntity = null;
            loadEntityActivity();
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                c.a.d.j.k.d.k(pluginBaseFragmentActivity, "onCreate", new Class[]{Bundle.class}, new Object[]{bundle});
            } else {
                super.onCreate(bundle);
            }
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // c.a.d.j.f.a
    public void proxySetContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048778, this, view, layoutParams) == null) {
            super.setContentView(view, layoutParams);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048804, this, view) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.setContentView(view);
            } else {
                super.setContentView(view);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048811, this, charSequence) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.setTitle(charSequence);
            } else {
                super.setTitle(charSequence);
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048805, this, view, layoutParams) == null) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                pluginBaseFragmentActivity.setContentView(view, layoutParams);
            } else {
                super.setContentView(view, layoutParams);
            }
        }
    }
}
