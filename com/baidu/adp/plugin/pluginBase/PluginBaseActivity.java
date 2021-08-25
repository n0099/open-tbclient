package com.baidu.adp.plugin.pluginBase;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.a.g;
import c.a.e.a.i;
import c.a.e.h.f.a;
import c.a.e.h.j.g.d;
import c.a.e.l.e.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/* loaded from: classes4.dex */
public class PluginBaseActivity extends PluginContextWrapper implements LayoutInflater.Factory, KeyEvent.Callback, View.OnCreateContextMenuListener, ComponentCallbacks, i, Handler.Callback, g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_KEYS_DIALER = 1;
    public static final int DEFAULT_KEYS_DISABLE = 0;
    public static final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
    public static final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    public static final int DEFAULT_KEYS_SHORTCUT = 2;
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_FIRST_USER = 1;
    public static final int RESULT_OK = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean bOnCreateCalled;
    public Activity mActivity;
    public a mProxyActivity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginBaseActivity() {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivity = null;
        this.mProxyActivity = null;
        this.bOnCreateCalled = false;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, layoutParams) == null) {
            this.mProxyActivity.proxyAddContentView(view, layoutParams);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        InterceptResult invokeLLI;
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, serviceConnection, i2)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartServiceIntent(intent))) {
                return this.mProxyActivity.proxyBindService(intent, serviceConnection, i2);
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public void closeContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mProxyActivity.proxyCloseContextMenu();
        }
    }

    public void closeOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mProxyActivity.proxyCloseOptionsMenu();
        }
    }

    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), intent, Integer.valueOf(i3)})) == null) ? this.mProxyActivity.proxyCreatePendingResult(i2, intent, i3) : (PendingIntent) invokeCommon.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 != null && h2.isThird) {
                Activity activity = this.mActivity;
                return activity.deleteDatabase(getPluginPackageName() + str);
            }
            return this.mActivity.deleteDatabase(str);
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 != null && h2.isThird) {
                Activity activity = this.mActivity;
                return activity.deleteFile(getPluginPackageName() + str);
            }
            return this.mActivity.deleteFile(str);
        }
        return invokeL.booleanValue;
    }

    public final void dismissDialog(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mActivity.dismissDialog(i2);
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) ? this.mProxyActivity.proxyDispatchGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, keyEvent)) == null) ? this.mProxyActivity.proxyDispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, keyEvent)) == null) ? this.mProxyActivity.proxyDispatchKeyShortcutEvent(keyEvent) : invokeL.booleanValue;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, accessibilityEvent)) == null) ? this.mProxyActivity.proxyDispatchPopulateAccessibilityEvent(accessibilityEvent) : invokeL.booleanValue;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) ? this.mProxyActivity.proxyDispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) ? this.mProxyActivity.proxyDispatchTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    public View findViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? this.mProxyActivity.proxyFindViewById(i2) : (View) invokeI.objValue;
    }

    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mProxyActivity.proxyFinish();
        }
    }

    public void finishActivity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mProxyActivity.proxyFinishActivity(i2);
        }
    }

    public void finishActivityFromChild(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, activity, i2) == null) {
            this.mProxyActivity.proxyFinishActivityFromChild(activity, i2);
        }
    }

    public void finishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, activity) == null) {
            this.mProxyActivity.proxyFinishFromChild(activity);
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mActivity : (Activity) invokeV.objValue;
    }

    public final Application getApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? PluginCenter.getInstance().getPlugin(getPluginPackageName()).getApplication() : (Application) invokeV.objValue;
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginContextWrapper, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (!this.bOnCreateCalled && !PluginBaseActivity.class.getName().equals(getClass().getName())) {
                return this.mProxyActivity.proxyGetApplicationContext();
            }
            return super.getApplicationContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            File cacheDir = this.mActivity.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            try {
                PluginSetting h2 = d.k().h(getPluginPackageName());
                if (h2 == null || !h2.isThird) {
                    return cacheDir;
                }
                File file = new File(cacheDir.getPath() + File.separator + getPluginPackageName() + cacheDir.getName());
                if (!file.exists() || !file.isDirectory()) {
                    file.mkdir();
                }
                return file;
            } catch (Exception unused) {
                return null;
            }
        }
        return (File) invokeV.objValue;
    }

    public ComponentName getCallingActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mProxyActivity.proxyGetCallingActivity() : (ComponentName) invokeV.objValue;
    }

    public String getCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mProxyActivity.proxyGetCallingPackage() : (String) invokeV.objValue;
    }

    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mProxyActivity.proxyGetChangingConfigurations() : invokeV.intValue;
    }

    public ComponentName getComponentName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mActivity.getComponentName() : (ComponentName) invokeV.objValue;
    }

    public View getCurrentFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mProxyActivity.proxyGetCurrentFocus() : (View) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 != null && h2.isThird) {
                Activity activity = this.mActivity;
                return activity.getDatabasePath(getPluginPackageName() + str);
            }
            return this.mActivity.getDatabasePath(str);
        }
        return (File) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, str, i2)) == null) {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 != null && h2.isThird) {
                Activity activity = this.mActivity;
                return activity.getDir(getPluginPackageName() + str, i2);
            }
            return this.mActivity.getDir(str, i2);
        }
        return (File) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 != null && h2.isThird) {
                Activity activity = this.mActivity;
                return activity.getFileStreamPath(getPluginPackageName() + str);
            }
            return this.mActivity.getFileStreamPath(str);
        }
        return (File) invokeL.objValue;
    }

    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mProxyActivity.proxyGetIntent() : (Intent) invokeV.objValue;
    }

    public LayoutInflater getLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mProxyActivity.proxyGetLayoutInflater() : (LayoutInflater) invokeV.objValue;
    }

    public String getLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mProxyActivity.proxyGetLocalClassName() : (String) invokeV.objValue;
    }

    public MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mProxyActivity.proxyGetMenuInflater() : (MenuInflater) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? PluginCenter.getInstance().getPlugin(getPluginPackageName()).getPluginApkFilePath() : (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mProxyActivity.proxyGetPackageManager() : (PackageManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 != null && h2.isThird) {
                return getPluginPackageName();
            }
            return this.mActivity.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.e.a.g
    public f getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return null;
        }
        return (f) invokeV.objValue;
    }

    public final Activity getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mActivity.getParent() : (Activity) invokeV.objValue;
    }

    public final Context getParentEntity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            Activity parent = this.mActivity.getParent();
            if (parent == null || !(parent instanceof a)) {
                return null;
            }
            return ((a) parent).getTarget();
        }
        return (Context) invokeV.objValue;
    }

    public SharedPreferences getPreferences(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) ? this.mProxyActivity.proxyGetPreferences(i2) : (SharedPreferences) invokeI.objValue;
    }

    public int getRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mProxyActivity.proxyGetRequestedOrientation() : invokeV.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048619, this, str, i2)) == null) {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 != null && h2.isThird) {
                a aVar = this.mProxyActivity;
                return aVar.proxyGetSharedPreferences(getPluginPackageName() + str, i2);
            }
            return this.mProxyActivity.proxyGetSharedPreferences(str, i2);
        }
        return (SharedPreferences) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) ? this.mProxyActivity.proxyGetSystemService(str) : invokeL.objValue;
    }

    public int getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mProxyActivity.proxyGetTaskId() : invokeV.intValue;
    }

    public final CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mActivity.getTitle() : (CharSequence) invokeV.objValue;
    }

    public final int getTitleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mActivity.getTitleColor() : invokeV.intValue;
    }

    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final int getVolumeControlStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mActivity.getVolumeControlStream() : invokeV.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mProxyActivity.proxyGetWallpaperDesiredMinimumHeight() : invokeV.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mProxyActivity.proxyGetWallpaperDesiredMinimumWidth() : invokeV.intValue;
    }

    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mProxyActivity.proxyGetWindow() : (Window) invokeV.objValue;
    }

    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mProxyActivity.proxyGetWindowManager() : (WindowManager) invokeV.objValue;
    }

    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, message)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean hasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mProxyActivity.proxyHasWindowFocus() : invokeV.booleanValue;
    }

    public final boolean isChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.mActivity.isChild() : invokeV.booleanValue;
    }

    public boolean isFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mProxyActivity.proxyIsFinishing() : invokeV.booleanValue;
    }

    public boolean isScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isTaskRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mProxyActivity.proxyIsTaskRoot() : invokeV.booleanValue;
    }

    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048636, this, uri, strArr, str, strArr2, str2)) == null) ? this.mActivity.managedQuery(uri, strArr, str, strArr2, str2) : (Cursor) invokeLLLLL.objValue;
    }

    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048637, this, z)) == null) ? this.mProxyActivity.proxyMoveTaskToBack(z) : invokeZ.booleanValue;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048638, this, i2, i3, intent) == null) {
            this.mProxyActivity.proxyOnActivityResult(i2, i3, intent);
        }
    }

    public void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.mProxyActivity.proxyOnApplyThemeResource(theme, i2, z);
        }
    }

    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.mProxyActivity.proxyOnAttachedToWindow();
        }
    }

    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.mProxyActivity.proxyOnBackPressed();
        }
    }

    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, activity, charSequence) == null) {
            this.mProxyActivity.proxyOnChildTitleChanged(activity, charSequence);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, configuration) == null) {
            this.mProxyActivity.proxyOnConfigurationChanged(configuration);
        }
    }

    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            this.mProxyActivity.proxyOnContentChanged();
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, menuItem)) == null) ? this.mProxyActivity.proxyOnContextItemSelected(menuItem) : invokeL.booleanValue;
    }

    public void onContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, menu) == null) {
            this.mProxyActivity.proxyOnContextMenuClosed(menu);
        }
    }

    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, bundle) == null) {
            this.bOnCreateCalled = true;
            this.mProxyActivity.proxyOnCreate(bundle);
        }
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048648, this, contextMenu, view, contextMenuInfo) == null) {
            this.mProxyActivity.proxyOnCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    public CharSequence onCreateDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i2)) == null) {
            return null;
        }
        return (Dialog) invokeI.objValue;
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048651, this, i2, menu)) == null) ? this.mProxyActivity.proxyOnCreatePanelMenu(i2, menu) : invokeIL.booleanValue;
    }

    public View onCreatePanelView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048652, this, i2)) == null) {
            return null;
        }
        return (View) invokeI.objValue;
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048653, this, bitmap, canvas)) == null) ? this.mProxyActivity.proxyOnCreateThumbnail(bitmap, canvas) : invokeLL.booleanValue;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048655, this, str, context, attributeSet)) == null) ? this.mProxyActivity.proxyOnCreateView(str, context, attributeSet) : (View) invokeLLL.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.mProxyActivity.proxyOnDestroy();
        }
    }

    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            this.mProxyActivity.proxyOnDetachedFromWindow();
        }
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048658, this, i2, keyEvent)) == null) ? this.mProxyActivity.proxyOnKeyDown(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048659, this, i2, keyEvent)) == null) ? this.mProxyActivity.proxyOnKeyLongPress(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048660, this, i2, i3, keyEvent)) == null) ? this.mProxyActivity.proxyOnKeyMultiple(i2, i3, keyEvent) : invokeIIL.booleanValue;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048661, this, i2, keyEvent)) == null) ? this.mProxyActivity.proxyOnKeyUp(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            this.mProxyActivity.proxyOnLowMemory();
        }
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048663, this, i2, menuItem)) == null) ? this.mProxyActivity.proxyOnMenuItemSelected(i2, menuItem) : invokeIL.booleanValue;
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048664, this, i2, menu)) == null) ? this.mProxyActivity.proxyOnMenuOpened(i2, menu) : invokeIL.booleanValue;
    }

    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, intent) == null) {
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, menuItem)) == null) ? this.mProxyActivity.proxyOnOptionsItemSelected(menuItem) : invokeL.booleanValue;
    }

    public void onOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, menu) == null) {
            this.mProxyActivity.proxyOnOptionsMenuClosed(menu);
        }
    }

    public void onPanelClosed(int i2, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048668, this, i2, menu) == null) {
            this.mProxyActivity.proxyOnPanelClosed(i2, menu);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            this.mProxyActivity.proxyOnPause();
        }
    }

    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, bundle) == null) {
            this.mProxyActivity.proxyOnPostCreate(bundle);
        }
    }

    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            this.mProxyActivity.proxyOnPostResume();
        }
    }

    public void onPreLoad(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, qVar) == null) {
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048673, this, i2, dialog) == null) {
            this.mProxyActivity.proxyOnPrepareDialog(i2, dialog);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048674, this, menu)) == null) ? this.mProxyActivity.proxyOnPrepareOptionsMenu(menu) : invokeL.booleanValue;
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048675, this, i2, view, menu)) == null) ? this.mProxyActivity.proxyOnPreparePanel(i2, view, menu) : invokeILL.booleanValue;
    }

    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            this.mProxyActivity.proxyOnRestart();
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, bundle) == null) {
            this.mProxyActivity.proxyOnRestoreInstanceState(bundle);
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            this.mProxyActivity.proxyOnResume();
        }
    }

    public Object onRetainNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.mProxyActivity.proxyOnRetainNonConfigurationInstance() : invokeV.objValue;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, bundle) == null) {
            this.mProxyActivity.proxyOnSaveInstanceState(bundle);
        }
    }

    public boolean onSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.mProxyActivity.proxyOnSearchRequested() : invokeV.booleanValue;
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            this.mProxyActivity.proxyOnStart();
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            this.mProxyActivity.proxyOnStop();
        }
    }

    public void onTitleChanged(CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048684, this, charSequence, i2) == null) {
            this.mProxyActivity.proxyOnTitleChanged(charSequence, i2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048685, this, motionEvent)) == null) ? this.mProxyActivity.proxyOnTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, motionEvent)) == null) ? this.mProxyActivity.proxyOnTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    public void onUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            this.mProxyActivity.proxyOnUserInteraction();
        }
    }

    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
        }
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, layoutParams) == null) {
            this.mProxyActivity.proxyOnWindowAttributesChanged(layoutParams);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048690, this, z) == null) {
            this.mProxyActivity.proxyOnWindowFocusChanged(z);
        }
    }

    public void openContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, view) == null) {
            this.mProxyActivity.proxyOpenContextMenu(view);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048692, this, str)) == null) {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 != null && h2.isThird) {
                Activity activity = this.mActivity;
                return activity.openFileInput(getPluginPackageName() + str);
            }
            return this.mActivity.openFileInput(str);
        }
        return (FileInputStream) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i2) throws FileNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048693, this, str, i2)) == null) {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 != null && h2.isThird) {
                Activity activity = this.mActivity;
                return activity.openFileOutput(getPluginPackageName() + str, i2);
            }
            return this.mActivity.openFileOutput(str, i2);
        }
        return (FileOutputStream) invokeLI.objValue;
    }

    public void openOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.mProxyActivity.proxyOpenOptionsMenu();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048695, this, str, i2, cursorFactory)) == null) {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 != null && h2.isThird) {
                Activity activity = this.mActivity;
                return activity.openOrCreateDatabase(getPluginPackageName() + str, i2, cursorFactory);
            }
            return this.mActivity.openOrCreateDatabase(getPluginPackageName(), i2, cursorFactory);
        }
        return (SQLiteDatabase) invokeLIL.objValue;
    }

    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048696, this, i2, i3) == null) {
            this.mProxyActivity.proxyOverridePendingTransition(i2, i3);
        }
    }

    public void registerForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, view) == null) {
            this.mProxyActivity.proxyRegisterForContextMenu(view);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048698, this, broadcastReceiver, intentFilter)) == null) ? this.mProxyActivity.registerReceiver(broadcastReceiver, intentFilter) : (Intent) invokeLL.objValue;
    }

    public final void removeDialog(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048699, this, i2) == null) {
            this.mActivity.removeDialog(i2);
        }
    }

    public final boolean requestWindowFeature(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048700, this, i2)) == null) ? this.mActivity.requestWindowFeature(i2) : invokeI.booleanValue;
    }

    public final void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, runnable) == null) {
            this.mActivity.runOnUiThread(runnable);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, intent) == null) {
            sendBroadcast(intent, null);
        }
    }

    public void setActivityProxy(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, aVar) == null) {
            this.mActivity = aVar.getActivity();
            this.mProxyActivity = aVar;
        }
    }

    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048705, this, i2) == null) {
            this.mProxyActivity.proxySetContentView(i2);
        }
    }

    public final void setDefaultKeyMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048708, this, i2) == null) {
            this.mActivity.setDefaultKeyMode(i2);
        }
    }

    public final void setFeatureDrawable(int i2, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048709, this, i2, drawable) == null) {
            this.mActivity.setFeatureDrawable(i2, drawable);
        }
    }

    public final void setFeatureDrawableAlpha(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048710, this, i2, i3) == null) {
            this.mActivity.setFeatureDrawableAlpha(i2, i3);
        }
    }

    public final void setFeatureDrawableResource(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048711, this, i2, i3) == null) {
            this.mActivity.setFeatureDrawableResource(i2, i3);
        }
    }

    public final void setFeatureDrawableUri(int i2, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048712, this, i2, uri) == null) {
            this.mActivity.setFeatureDrawableUri(i2, uri);
        }
    }

    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, intent) == null) {
            this.mProxyActivity.proxySetIntent(intent);
        }
    }

    public void setIsScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048714, this, z) == null) {
        }
    }

    public final void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i2) == null) {
            this.mActivity.setProgress(i2);
        }
    }

    public final void setProgressBarIndeterminate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048716, this, z) == null) {
            this.mActivity.setProgressBarIndeterminate(z);
        }
    }

    public final void setProgressBarIndeterminateVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048717, this, z) == null) {
            this.mActivity.setProgressBarIndeterminateVisibility(z);
        }
    }

    public final void setProgressBarVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048718, this, z) == null) {
            this.mActivity.setProgressBarVisibility(z);
        }
    }

    public void setRequestedOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048719, this, i2) == null) {
            this.mProxyActivity.proxySetRequestedOrientation(i2);
        }
    }

    public final void setResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i2) == null) {
            this.mActivity.setResult(i2);
        }
    }

    public final void setSecondaryProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048722, this, i2) == null) {
            this.mActivity.setSecondaryProgress(i2);
        }
    }

    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048723, this, i2) == null) {
            this.mProxyActivity.proxySetTitle(i2);
        }
    }

    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048725, this, i2) == null) {
            this.mProxyActivity.proxySetTitleColor(i2);
        }
    }

    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z) == null) {
            this.mProxyActivity.proxySetVisible(z);
        }
    }

    public final void setVolumeControlStream(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048727, this, i2) == null) {
            this.mActivity.setVolumeControlStream(i2);
        }
    }

    public final void showDialog(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048728, this, i2) == null) {
            this.mActivity.showDialog(i2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, intent) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartActivityIntent(intent))) {
                this.mProxyActivity.proxyStartActivity(intent);
            }
        }
    }

    public void startActivityForResult(Intent intent, int i2) {
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048730, this, intent, i2) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartActivityIntent(intent))) {
                this.mProxyActivity.proxyStartActivityForResult(intent, i2);
            }
        }
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048731, this, activity, intent, i2) == null) {
            this.mProxyActivity.proxyStartActivityFromChild(activity, intent, i2);
        }
    }

    public boolean startActivityIfNeeded(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048732, this, intent, i2)) == null) ? this.mProxyActivity.proxyStartActivityIfNeeded(intent, i2) : invokeLI.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048733, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mProxyActivity.proxyStartIntentSender(intentSender, intent, i2, i3, i4);
        }
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048734, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mProxyActivity.proxyStartIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    public void startManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, cursor) == null) {
            this.mProxyActivity.proxyStartManagingCursor(cursor);
        }
    }

    public boolean startNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048736, this, intent)) == null) ? this.mProxyActivity.proxyStartNextMatchingActivity(intent) : invokeL.booleanValue;
    }

    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048737, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            this.mProxyActivity.proxyStartSearch(str, z, bundle, z2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        InterceptResult invokeL;
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048738, this, intent)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartServiceIntent(intent))) {
                return this.mProxyActivity.proxyStartService(intent);
            }
            return null;
        }
        return (ComponentName) invokeL.objValue;
    }

    public void stopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, cursor) == null) {
            this.mProxyActivity.proxyStopManagingCursor(cursor);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        InterceptResult invokeL;
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048740, this, intent)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartServiceIntent(intent))) {
                return this.mProxyActivity.proxyStopService(intent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void takeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048741, this, z) == null) {
            this.mProxyActivity.proxyTakeKeyEvents(z);
        }
    }

    public void unregisterForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, view) == null) {
            this.mProxyActivity.proxyUnregisterForContextMenu(view);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, broadcastReceiver) == null) {
            this.mProxyActivity.unregisterReceiver(broadcastReceiver);
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048654, this, view, str, context, attributeSet)) == null) ? this.mProxyActivity.proxyOnCreateView(view, str, context, attributeSet) : (View) invokeLLLL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048703, this, intent, str) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.isLoaded() && plugin2.remapBroadcastReceiver(intent))) {
                super.sendBroadcast(intent, str);
            }
        }
    }

    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, view) == null) {
            this.mProxyActivity.proxySetContentView(view);
        }
    }

    public final void setResult(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048721, this, i2, intent) == null) {
            this.mActivity.setResult(i2, intent);
        }
    }

    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, charSequence) == null) {
            this.mProxyActivity.proxySetTitle(charSequence);
        }
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048707, this, view, layoutParams) == null) {
            this.mProxyActivity.proxySetContentView(view, layoutParams);
        }
    }
}
