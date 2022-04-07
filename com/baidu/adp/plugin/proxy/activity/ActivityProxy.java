package com.baidu.adp.plugin.proxy.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.c9;
import com.repackage.d9;
import com.repackage.e9;
import com.repackage.vm;
import com.repackage.w8;
import com.repackage.xl;
import com.repackage.xo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class ActivityProxy extends Activity implements xl, e9, Handler.Callback, c9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PluginBaseActivity mEntity;

    public ActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEntity = null;
    }

    @Override // android.app.Activity
    public void addContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, layoutParams) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.addContentView(view2, layoutParams);
            } else {
                super.addContentView(view2, layoutParams);
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, serviceConnection, i)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.bindService(intent, serviceConnection, i);
            }
            return super.bindService(intent, serviceConnection, i);
        }
        return invokeLLI.booleanValue;
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.closeContextMenu();
            } else {
                super.closeContextMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.closeOptionsMenu();
            } else {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i, Intent intent, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), intent, Integer.valueOf(i2)})) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.createPendingResult(i, intent, i2);
            }
            return super.createPendingResult(i, intent, i2);
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.dispatchGenericMotionEvent(motionEvent);
            }
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, keyEvent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, keyEvent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.dispatchKeyShortcutEvent(keyEvent);
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent);
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.dispatchTouchEvent(motionEvent);
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.dispatchTrackballEvent(motionEvent);
            }
            return super.dispatchTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.findViewById(i);
            }
            return super.findViewById(i);
        }
        return (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.finish();
            } else {
                super.finish();
            }
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.finishActivity(i);
            } else {
                super.finishActivity(i);
            }
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, activity, i) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.finishActivityFromChild(activity, i);
            } else {
                super.finishActivityFromChild(activity, i);
            }
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, activity) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.finishFromChild(activity);
            } else {
                super.finishFromChild(activity);
            }
        }
    }

    @Override // com.repackage.xl
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getApplicationContext();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getAssets();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getCallingActivity();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getCallingPackage();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getClassLoader();
            }
            return super.getClassLoader();
        }
        return (ClassLoader) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? ContentResolverProxy.getContentResolver() : (ContentResolver) invokeV.objValue;
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getCurrentFocus();
            }
            return super.getCurrentFocus();
        }
        return (View) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getIntent();
            }
            return super.getIntent();
        }
        return (Intent) invokeV.objValue;
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getLayoutInflater();
            }
            return super.getLayoutInflater();
        }
        return (LayoutInflater) invokeV.objValue;
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getLocalClassName();
            }
            return super.getLocalClassName();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getMenuInflater();
            }
            return super.getMenuInflater();
        }
        return (MenuInflater) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getPackageManager();
            }
            return super.getPackageManager();
        }
        return (PackageManager) invokeV.objValue;
    }

    @Override // com.repackage.c9
    public b9 getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity == null || !(pluginBaseActivity instanceof c9)) {
                return null;
            }
            return pluginBaseActivity.getPageContext();
        }
        return (b9) invokeV.objValue;
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getPreferences(i);
            }
            return super.getPreferences(i);
        }
        return (SharedPreferences) invokeI.objValue;
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getRequestedOrientation();
            }
            return super.getRequestedOrientation();
        }
        return invokeV.intValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                PluginBaseActivity pluginBaseActivity = this.mEntity;
                if (pluginBaseActivity != null) {
                    return pluginBaseActivity.getResources();
                }
            } else {
                Resources resources = d9.a().getResources();
                if (resources != null) {
                    return resources;
                }
            }
            return super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048611, this, str, i)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getSharedPreferences(str, i);
            }
            return super.getSharedPreferences(str, i);
        }
        return (SharedPreferences) invokeLI.objValue;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getSystemService(str);
            }
            return super.getSystemService(str);
        }
        return invokeL.objValue;
    }

    @Override // com.repackage.xl
    public PluginBaseActivity getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mEntity : (PluginBaseActivity) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getTaskId();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getTheme();
            }
            return super.getTheme();
        }
        return (Resources.Theme) invokeV.objValue;
    }

    @Override // com.repackage.e9
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getUniqueId();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getWallpaperDesiredMinimumHeight();
            }
            return super.getWallpaperDesiredMinimumHeight();
        }
        return invokeV.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getWallpaperDesiredMinimumWidth();
            }
            return super.getWallpaperDesiredMinimumWidth();
        }
        return invokeV.intValue;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getWindow();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getWindowManager();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.handleMessage(message);
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.hasWindowFocus();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.isFinishing();
            }
            return super.isFinishing();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.e9
    public boolean isScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.isScroll();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.isTaskRoot();
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
                    PluginBaseActivity pluginBaseActivity = (PluginBaseActivity) plugin2.getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseActivity.class).newInstance();
                    this.mEntity = pluginBaseActivity;
                    pluginBaseActivity.setActivityProxy(this);
                    this.mEntity.setPluginPackageName(stringExtra);
                    setTheme(plugin2.getActivityThemeResource());
                } else {
                    PluginBaseActivity pluginBaseActivity2 = (PluginBaseActivity) PluginCenter.getInstance().getPlugin(stringExtra).getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseActivity.class).newInstance();
                    this.mEntity = pluginBaseActivity2;
                    pluginBaseActivity2.setActivityProxy(this);
                    this.mEntity.setPluginPackageName(stringExtra);
                }
            } catch (ClassNotFoundException e) {
                BdLog.e(e);
            } catch (IllegalAccessException e2) {
                BdLog.e(e2);
            } catch (InstantiationException e3) {
                BdLog.e(e3);
            } catch (Exception e4) {
                BdLog.e(e4);
            }
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048627, this, z)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.moveTaskToBack(z);
            }
            return super.moveTaskToBack(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048628, this, i, i2, intent) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                Class cls = Integer.TYPE;
                vm.k(pluginBaseActivity, "onActivityResult", new Class[]{cls, cls, Intent.class}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
                return;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{theme, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onApplyThemeResource", new Class[]{Resources.Theme.class, Integer.TYPE, Boolean.TYPE}, new Object[]{theme, Integer.valueOf(i), Boolean.valueOf(z)});
            } else {
                super.onApplyThemeResource(theme, i, z);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onAttachedToWindow();
            } else {
                super.onAttachedToWindow();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onBackPressed();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, activity, charSequence) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onChildTitleChanged", new Class[]{Activity.class, CharSequence.class}, new Object[]{activity, charSequence});
            } else {
                super.onChildTitleChanged(activity, charSequence);
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, configuration) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onConfigurationChanged(configuration);
            } else {
                super.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onContentChanged();
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
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onContextItemSelected(menuItem);
            }
            return super.onContextItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, menu) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onContextMenuClosed(menu);
            } else {
                super.onContextMenuClosed(menu);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, bundle, persistableBundle) == null) {
            w8.b(this);
            super.onCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048639, this, contextMenu, view2, contextMenuInfo) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
            } else {
                super.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
            }
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onCreateDescription();
            }
            return super.onCreateDescription();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            return pluginBaseActivity != null ? (Dialog) vm.k(pluginBaseActivity, "onCreateDialog", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)}) : super.onCreateDialog(i);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048642, this, i, menu)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onCreatePanelMenu(i, menu);
            }
            return super.onCreatePanelMenu(i, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onCreatePanelView(i);
            }
            return super.onCreatePanelView(i);
        }
        return (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048644, this, bitmap, canvas)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onCreateThumbnail(bitmap, canvas);
            }
            return super.onCreateThumbnail(bitmap, canvas);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048645, this, view2, str, context, attributeSet)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onCreateView(view2, str, context, attributeSet);
            }
            return super.onCreateView(view2, str, context, attributeSet);
        }
        return (View) invokeLLLL.objValue;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, MissionEvent.MESSAGE_DESTROY, new Class[0], new Object[0]);
            } else {
                super.onDestroy();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onDetachedFromWindow();
            } else {
                super.onDetachedFromWindow();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048649, this, i, keyEvent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onKeyDown(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048650, this, i, keyEvent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onKeyLongPress(i, keyEvent);
            }
            return super.onKeyLongPress(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048651, this, i, i2, keyEvent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onKeyMultiple(i, i2, keyEvent);
            }
            return super.onKeyMultiple(i, i2, keyEvent);
        }
        return invokeIIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048652, this, i, keyEvent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onKeyUp(i, keyEvent);
            }
            return super.onKeyUp(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onLowMemory();
            } else {
                super.onLowMemory();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048654, this, i, menuItem)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onMenuItemSelected(i, menuItem);
            }
            return super.onMenuItemSelected(i, menuItem);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048655, this, i, menu)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onMenuOpened(i, menu);
            }
            return super.onMenuOpened(i, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, intent) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onNewIntent", new Class[]{Intent.class}, new Object[]{intent});
            } else {
                super.onNewIntent(intent);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, menuItem)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onOptionsItemSelected(menuItem);
            }
            return super.onOptionsItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, menu) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onOptionsMenuClosed(menu);
            } else {
                super.onOptionsMenuClosed(menu);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048659, this, i, menu) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onPanelClosed(i, menu);
            } else {
                super.onPanelClosed(i, menu);
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, MissionEvent.MESSAGE_PAUSE, new Class[0], new Object[0]);
            } else {
                super.onPause();
            }
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, bundle) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onPostCreate", new Class[]{Bundle.class}, new Object[]{bundle});
            } else {
                super.onPostCreate(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onPostResume", new Class[0], new Object[0]);
            } else {
                super.onPostResume();
            }
        }
    }

    @Override // com.repackage.e9
    public void onPreLoad(xo xoVar) {
        PluginBaseActivity pluginBaseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048663, this, xoVar) == null) || (pluginBaseActivity = this.mEntity) == null) {
            return;
        }
        pluginBaseActivity.onPreLoad(xoVar);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048664, this, i, dialog) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onPrepareDialog(i, dialog);
            } else {
                super.onPrepareDialog(i, dialog);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, menu)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onPrepareOptionsMenu(menu);
            }
            return super.onPrepareOptionsMenu(menu);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view2, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048666, this, i, view2, menu)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onPreparePanel(i, view2, menu);
            }
            return super.onPreparePanel(i, view2, menu);
        }
        return invokeILL.booleanValue;
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onRestart", new Class[0], new Object[0]);
            } else {
                super.onRestart();
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, bundle) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onRestoreInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
            } else {
                super.onRestoreInstanceState(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onResume", new Class[0], new Object[0]);
            } else {
                super.onResume();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, bundle) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onSaveInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
            } else {
                super.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onSearchRequested();
            }
            return super.onSearchRequested();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onStart", new Class[0], new Object[0]);
            } else {
                super.onStart();
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, MissionEvent.MESSAGE_STOP, new Class[0], new Object[0]);
            } else {
                super.onStop();
            }
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048674, this, charSequence, i) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onTitleChanged", new Class[]{CharSequence.class, Integer.TYPE}, new Object[]{charSequence, Integer.valueOf(i)});
            } else {
                super.onTitleChanged(charSequence, i);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048675, this, motionEvent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, motionEvent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onTrackballEvent(motionEvent);
            }
            return super.onTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onUserInteraction();
            } else {
                super.onUserInteraction();
            }
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            super.onUserLeaveHint();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, layoutParams) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onWindowAttributesChanged(layoutParams);
            } else {
                super.onWindowAttributesChanged(layoutParams);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048680, this, z) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.onWindowFocusChanged(z);
            } else {
                super.onWindowFocusChanged(z);
            }
        }
    }

    @Override // android.app.Activity
    public void openContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, view2) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.openContextMenu(view2);
            } else {
                super.openContextMenu(view2);
            }
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.openOptionsMenu();
            } else {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048683, this, i, i2) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.overridePendingTransition(i, i2);
            } else {
                super.overridePendingTransition(i, i2);
            }
        }
    }

    @Override // com.repackage.xl
    public void proxyAddContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048684, this, view2, layoutParams) == null) {
            super.addContentView(view2, layoutParams);
        }
    }

    @Override // com.repackage.xl
    public boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048685, this, intent, serviceConnection, i)) == null) ? super.bindService(intent, serviceConnection, i) : invokeLLI.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyCloseContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            super.closeContextMenu();
        }
    }

    @Override // com.repackage.xl
    public void proxyCloseOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            super.closeOptionsMenu();
        }
    }

    @Override // com.repackage.xl
    public PendingIntent proxyCreatePendingResult(int i, Intent intent, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048688, this, new Object[]{Integer.valueOf(i), intent, Integer.valueOf(i2)})) == null) ? super.createPendingResult(i, intent, i2) : (PendingIntent) invokeCommon.objValue;
    }

    @Override // com.repackage.xl
    public boolean proxyDispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, motionEvent)) == null) ? super.dispatchGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyDispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048690, this, keyEvent)) == null) ? super.dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048691, this, keyEvent)) == null) ? super.dispatchKeyShortcutEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048692, this, accessibilityEvent)) == null) ? super.dispatchPopulateAccessibilityEvent(accessibilityEvent) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyDispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, motionEvent)) == null) ? super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyDispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048694, this, motionEvent)) == null) ? super.dispatchTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public View proxyFindViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048695, this, i)) == null) ? super.findViewById(i) : (View) invokeI.objValue;
    }

    @Override // com.repackage.xl
    public void proxyFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            super.finish();
        }
    }

    @Override // com.repackage.xl
    public void proxyFinishActivity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048697, this, i) == null) {
            super.finishActivity(i);
        }
    }

    @Override // com.repackage.xl
    public void proxyFinishActivityFromChild(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048698, this, activity, i) == null) {
            super.finishActivityFromChild(activity, i);
        }
    }

    @Override // com.repackage.xl
    public void proxyFinishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, activity) == null) {
            super.finishFromChild(activity);
        }
    }

    @Override // com.repackage.xl
    public Context proxyGetApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? super.getApplicationContext() : (Context) invokeV.objValue;
    }

    @Override // com.repackage.xl
    public ComponentName proxyGetCallingActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return null;
        }
        return (ComponentName) invokeV.objValue;
    }

    @Override // com.repackage.xl
    public String proxyGetCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? super.getCallingPackage() : (String) invokeV.objValue;
    }

    @Override // com.repackage.xl
    public int proxyGetChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? super.getChangingConfigurations() : invokeV.intValue;
    }

    @Override // com.repackage.xl
    public View proxyGetCurrentFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? super.getCurrentFocus() : (View) invokeV.objValue;
    }

    @Override // com.repackage.xl
    public Intent proxyGetIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? super.getIntent() : (Intent) invokeV.objValue;
    }

    public Object proxyGetLastNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? super.getLastNonConfigurationInstance() : invokeV.objValue;
    }

    @Override // com.repackage.xl
    public LayoutInflater proxyGetLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? super.getLayoutInflater() : (LayoutInflater) invokeV.objValue;
    }

    @Override // com.repackage.xl
    public String proxyGetLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? super.getLocalClassName() : (String) invokeV.objValue;
    }

    @Override // com.repackage.xl
    public MenuInflater proxyGetMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) ? super.getMenuInflater() : (MenuInflater) invokeV.objValue;
    }

    @Override // com.repackage.xl
    public PackageManager proxyGetPackageManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? super.getPackageManager() : (PackageManager) invokeV.objValue;
    }

    @Override // com.repackage.xl
    public SharedPreferences proxyGetPreferences(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048711, this, i)) == null) ? super.getPreferences(i) : (SharedPreferences) invokeI.objValue;
    }

    @Override // com.repackage.xl
    public int proxyGetRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? super.getRequestedOrientation() : invokeV.intValue;
    }

    @Override // com.repackage.xl
    public SharedPreferences proxyGetSharedPreferences(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048713, this, str, i)) == null) ? super.getSharedPreferences(str, i) : (SharedPreferences) invokeLI.objValue;
    }

    @Override // com.repackage.xl
    public Object proxyGetSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048714, this, str)) == null) ? super.getSystemService(str) : invokeL.objValue;
    }

    @Override // com.repackage.xl
    public int proxyGetTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) ? super.getTaskId() : invokeV.intValue;
    }

    @Override // com.repackage.xl
    public int proxyGetWallpaperDesiredMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? super.getWallpaperDesiredMinimumHeight() : invokeV.intValue;
    }

    @Override // com.repackage.xl
    public int proxyGetWallpaperDesiredMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) ? super.getWallpaperDesiredMinimumWidth() : invokeV.intValue;
    }

    @Override // com.repackage.xl
    public Window proxyGetWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) ? super.getWindow() : (Window) invokeV.objValue;
    }

    @Override // com.repackage.xl
    public WindowManager proxyGetWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? super.getWindowManager() : (WindowManager) invokeV.objValue;
    }

    @Override // com.repackage.xl
    public boolean proxyHasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? super.hasWindowFocus() : invokeV.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyIsFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? super.isFinishing() : invokeV.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyIsTaskRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? super.isTaskRoot() : invokeV.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyMoveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048723, this, z)) == null) ? super.moveTaskToBack(z) : invokeZ.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyOnActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048724, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048725, this, new Object[]{theme, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.onApplyThemeResource(theme, i, z);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // com.repackage.xl
    public void proxyOnBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.repackage.xl
    public void proxyOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048728, this, activity, charSequence) == null) {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            super.onContentChanged();
        }
    }

    @Override // com.repackage.xl
    public boolean proxyOnContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048731, this, menuItem)) == null) ? super.onContextItemSelected(menuItem) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyOnContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, menu) == null) {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048734, this, contextMenu, view2, contextMenuInfo) == null) {
            super.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
        }
    }

    @Override // com.repackage.xl
    public boolean proxyOnCreatePanelMenu(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048735, this, i, menu)) == null) ? super.onCreatePanelMenu(i, menu) : invokeIL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048736, this, bitmap, canvas)) == null) ? super.onCreateThumbnail(bitmap, canvas) : invokeLL.booleanValue;
    }

    @Override // com.repackage.xl
    public View proxyOnCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048738, this, str, context, attributeSet)) == null) ? super.onCreateView(str, context, attributeSet) : (View) invokeLLL.objValue;
    }

    @Override // com.repackage.xl
    public void proxyOnDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.repackage.xl
    public void proxyOnDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // com.repackage.xl
    public boolean proxyOnKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048741, this, i, keyEvent)) == null) ? super.onKeyDown(i, keyEvent) : invokeIL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyOnKeyLongPress(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048742, this, i, keyEvent)) == null) ? super.onKeyLongPress(i, keyEvent) : invokeIL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyOnKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048743, this, i, i2, keyEvent)) == null) ? super.onKeyMultiple(i, i2, keyEvent) : invokeIIL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyOnKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048744, this, i, keyEvent)) == null) ? super.onKeyUp(i, keyEvent) : invokeIL.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyOnLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            super.onLowMemory();
        }
    }

    @Override // com.repackage.xl
    public boolean proxyOnMenuItemSelected(int i, MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048746, this, i, menuItem)) == null) ? super.onMenuItemSelected(i, menuItem) : invokeIL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyOnMenuOpened(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048747, this, i, menu)) == null) ? super.onMenuOpened(i, menu) : invokeIL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyOnOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048748, this, menuItem)) == null) ? super.onOptionsItemSelected(menuItem) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyOnOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, menu) == null) {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnPanelClosed(int i, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048750, this, i, menu) == null) {
            super.onPanelClosed(i, menu);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            super.onPause();
        }
    }

    @Override // com.repackage.xl
    public void proxyOnPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, bundle) == null) {
            super.onPostCreate(bundle);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            super.onPostResume();
        }
    }

    @Override // com.repackage.xl
    public void proxyOnPrepareDialog(int i, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048754, this, i, dialog) == null) {
            super.onPrepareDialog(i, dialog);
        }
    }

    @Override // com.repackage.xl
    public boolean proxyOnPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048755, this, menu)) == null) ? super.onPrepareOptionsMenu(menu) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyOnPreparePanel(int i, View view2, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048756, this, i, view2, menu)) == null) ? super.onPreparePanel(i, view2, menu) : invokeILL.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyOnRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            super.onRestart();
        }
    }

    @Override // com.repackage.xl
    public void proxyOnRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            super.onResume();
        }
    }

    @Override // com.repackage.xl
    public Object proxyOnRetainNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) ? super.onRetainNonConfigurationInstance() : invokeV.objValue;
    }

    @Override // com.repackage.xl
    public void proxyOnSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.repackage.xl
    public boolean proxyOnSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) ? super.onSearchRequested() : invokeV.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyOnStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            super.onStart();
        }
    }

    @Override // com.repackage.xl
    public void proxyOnStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048764, this) == null) {
            super.onStop();
        }
    }

    @Override // com.repackage.xl
    public void proxyOnTitleChanged(CharSequence charSequence, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048765, this, charSequence, i) == null) {
            super.onTitleChanged(charSequence, i);
        }
    }

    @Override // com.repackage.xl
    public boolean proxyOnTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048766, this, motionEvent)) == null) ? super.onTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public boolean proxyOnTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048767, this, motionEvent)) == null) ? super.onTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyOnUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048768, this) == null) {
            super.onUserInteraction();
        }
    }

    @Override // com.repackage.xl
    public void proxyOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048769, this, layoutParams) == null) {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // com.repackage.xl
    public void proxyOnWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048770, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // com.repackage.xl
    public void proxyOpenContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048771, this, view2) == null) {
            super.openContextMenu(view2);
        }
    }

    @Override // com.repackage.xl
    public void proxyOpenOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            super.openOptionsMenu();
        }
    }

    @Override // com.repackage.xl
    public void proxyOverridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048773, this, i, i2) == null) {
            super.overridePendingTransition(i, i2);
        }
    }

    @Override // com.repackage.xl
    public void proxyRegisterForContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048774, this, view2) == null) {
            super.registerForContextMenu(view2);
        }
    }

    @Override // com.repackage.xl
    public void proxySetContentView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048775, this, i) == null) {
            super.setContentView(i);
        }
    }

    @Override // com.repackage.xl
    public void proxySetIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, intent) == null) {
            super.setIntent(intent);
        }
    }

    @Override // com.repackage.xl
    public void proxySetRequestedOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048779, this, i) == null) {
            super.setRequestedOrientation(i);
        }
    }

    @Override // com.repackage.xl
    public void proxySetTitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048780, this, i) == null) {
            super.setTitle(i);
        }
    }

    @Override // com.repackage.xl
    public void proxySetTitleColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048782, this, i) == null) {
            super.setTitleColor(i);
        }
    }

    @Override // com.repackage.xl
    public void proxySetVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048783, this, z) == null) {
            super.setVisible(z);
        }
    }

    @Override // com.repackage.xl
    public void proxyStartActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048784, this, intent) == null) {
            super.startActivity(intent);
        }
    }

    @Override // com.repackage.xl
    public void proxyStartActivityForResult(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048785, this, intent, i) == null) {
            super.startActivityForResult(intent, i);
        }
    }

    @Override // com.repackage.xl
    public void proxyStartActivityFromChild(Activity activity, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048786, this, activity, intent, i) == null) {
            super.startActivityFromChild(activity, intent, i);
        }
    }

    @Override // com.repackage.xl
    public boolean proxyStartActivityIfNeeded(Intent intent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048787, this, intent, i)) == null) ? super.startActivityIfNeeded(intent, i) : invokeLI.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyStartIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048788, this, new Object[]{intentSender, intent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            super.startIntentSender(intentSender, intent, i, i2, i3);
        }
    }

    @Override // com.repackage.xl
    public void proxyStartIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048789, this, new Object[]{intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public void proxyStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048790, this, new Object[]{activity, intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
        }
    }

    @Override // com.repackage.xl
    public void proxyStartManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, cursor) == null) {
            super.startManagingCursor(cursor);
        }
    }

    @Override // com.repackage.xl
    public boolean proxyStartNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048792, this, intent)) == null) ? super.startNextMatchingActivity(intent) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyStartSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048793, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            super.startSearch(str, z, bundle, z2);
        }
    }

    @Override // com.repackage.xl
    public ComponentName proxyStartService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048794, this, intent)) == null) ? super.startService(intent) : (ComponentName) invokeL.objValue;
    }

    @Override // com.repackage.xl
    public void proxyStopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048795, this, cursor) == null) {
            super.stopManagingCursor(cursor);
        }
    }

    @Override // com.repackage.xl
    public boolean proxyStopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048796, this, intent)) == null) ? super.stopService(intent) : invokeL.booleanValue;
    }

    @Override // com.repackage.xl
    public void proxyTakeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048797, this, z) == null) {
            super.takeKeyEvents(z);
        }
    }

    @Override // com.repackage.xl
    public void proxyUnregisterForContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048798, this, view2) == null) {
            super.unregisterForContextMenu(view2);
        }
    }

    public void proxysetFinishOnTouchOutside(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048799, this, z) == null) {
            super.setFinishOnTouchOutside(z);
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048800, this, view2) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.registerForContextMenu(view2);
            } else {
                super.registerForContextMenu(view2);
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context, com.repackage.xl
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048801, this, broadcastReceiver, intentFilter)) == null) ? super.registerReceiver(broadcastReceiver, intentFilter) : (Intent) invokeLL.objValue;
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048802, this, i) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.setContentView(i);
            } else {
                super.setContentView(i);
            }
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048805, this, intent) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.setIntent(intent);
            } else {
                super.setIntent(intent);
            }
        }
    }

    @Override // com.repackage.e9
    public void setIsScroll(boolean z) {
        PluginBaseActivity pluginBaseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048806, this, z) == null) || (pluginBaseActivity = this.mEntity) == null) {
            return;
        }
        pluginBaseActivity.setIsScroll(z);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048807, this, i) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.setRequestedOrientation(i);
            } else {
                super.setRequestedOrientation(i);
            }
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048808, this, i) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.setTheme(i);
            } else {
                super.setTheme(i);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048809, this, i) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.setTitle(i);
            } else {
                super.setTitle(i);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048811, this, i) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.setTitleColor(i);
            } else {
                super.setTitleColor(i);
            }
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048812, this, z) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.setVisible(z);
            } else {
                super.setVisible(z);
            }
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, intent) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.startActivity(intent);
            } else {
                super.startActivity(intent);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048814, this, intent, i) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.startActivityForResult(intent, i);
            } else {
                super.startActivityForResult(intent, i);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048815, this, activity, intent, i) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.startActivityFromChild(activity, intent, i);
            } else {
                super.startActivityFromChild(activity, intent, i);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048816, this, intent, i)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.startActivityIfNeeded(intent, i);
            }
            return super.startActivityIfNeeded(intent, i);
        }
        return invokeLI.booleanValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048817, this, new Object[]{intentSender, intent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.startIntentSender(intentSender, intent, i, i2, i3);
            } else {
                super.startIntentSender(intentSender, intent, i, i2, i3);
            }
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048818, this, new Object[]{intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
            } else {
                super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
            }
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048819, this, cursor) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.startManagingCursor(cursor);
            } else {
                super.startManagingCursor(cursor);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048820, this, intent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.startNextMatchingActivity(intent);
            }
            return super.startNextMatchingActivity(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048821, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.startSearch(str, z, bundle, z2);
            } else {
                super.startSearch(str, z, bundle, z2);
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048822, this, intent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.startService(intent);
            }
            return super.startService(intent);
        }
        return (ComponentName) invokeL.objValue;
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048823, this, cursor) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.stopManagingCursor(cursor);
            } else {
                super.stopManagingCursor(cursor);
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048824, this, intent)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.stopService(intent);
            }
            return super.stopService(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048825, this, z) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.takeKeyEvents(z);
            } else {
                super.takeKeyEvents(z);
            }
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048826, this, view2) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.unregisterForContextMenu(view2);
            } else {
                super.unregisterForContextMenu(view2);
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context, com.repackage.xl
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048827, this, broadcastReceiver) == null) {
            super.unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // com.repackage.xl
    public View proxyOnCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048737, this, view2, str, context, attributeSet)) == null) ? super.onCreateView(view2, str, context, attributeSet) : (View) invokeLLLL.objValue;
    }

    @Override // com.repackage.xl
    public void proxySetContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048776, this, view2) == null) {
            super.setContentView(view2);
        }
    }

    @Override // com.repackage.xl
    public void proxySetTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048781, this, charSequence) == null) {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, bundle) == null) {
            requestWindowFeature(1);
            this.mEntity = null;
            loadEntityActivity();
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                vm.k(pluginBaseActivity, "onCreate", new Class[]{Bundle.class}, new Object[]{bundle});
            } else {
                super.onCreate(bundle);
            }
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // com.repackage.xl
    public void proxySetContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048777, this, view2, layoutParams) == null) {
            super.setContentView(view2, layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048646, this, str, context, attributeSet)) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.onCreateView(str, context, attributeSet);
            }
            return super.onCreateView(str, context, attributeSet);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.app.Activity
    public void setContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, view2) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.setContentView(view2);
            } else {
                super.setContentView(view2);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048810, this, charSequence) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.setTitle(charSequence);
            } else {
                super.setTitle(charSequence);
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048804, this, view2, layoutParams) == null) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                pluginBaseActivity.setContentView(view2, layoutParams);
            } else {
                super.setContentView(view2, layoutParams);
            }
        }
    }
}
