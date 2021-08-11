package com.baidu.adp.plugin.pluginBase;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import c.a.e.h.j.g.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
import com.baidu.adp.plugin.proxy.PackageMangerProxy;
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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class PluginBaseApplication extends Application {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Application mApplicationProxy;
    public String mPluginPacakgeName;
    public PackageMangerProxy mProxyPm;

    public PluginBaseApplication() {
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
        this.mApplicationProxy = null;
        this.mPluginPacakgeName = null;
        this.mProxyPm = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, intent, serviceConnection, i2)) == null) ? this.mApplicationProxy.bindService(intent, serviceConnection, i2) : invokeLLI.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Application application = this.mApplicationProxy;
                return application.deleteFile(pluginPackageName + str);
            }
            return this.mApplicationProxy.deleteFile(str);
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] fileList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                String[] list = getFilesDir().list();
                return list != null ? list : new String[0];
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String[]) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mApplicationProxy.getApplicationInfo() : (ApplicationInfo) invokeV.objValue;
    }

    public Application getApplicationProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mApplicationProxy : (Application) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getResources().getAssets() : (AssetManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mApplicationProxy.getBaseContext() : (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            File cacheDir = this.mApplicationProxy.getCacheDir();
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
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mApplicationProxy.getClassLoader() : (ClassLoader) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ContentResolverProxy.getContentResolver() : (ContentResolver) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, str, i2)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Application application = this.mApplicationProxy;
                return application.getDir(pluginPackageName + str, i2);
            }
            return this.mApplicationProxy.getDir(str, i2);
        }
        return (File) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Application application = this.mApplicationProxy;
                return application.getFileStreamPath(pluginPackageName + str);
            }
            return this.mApplicationProxy.getFileStreamPath(str);
        }
        return (File) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            File filesDir = this.mApplicationProxy.getFilesDir();
            if (filesDir == null) {
                return null;
            }
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 == null || !h2.isThird) {
                return filesDir;
            }
            try {
                File file = new File(filesDir, pluginPackageName);
                if (!file.isDirectory() || !file.exists()) {
                    file.mkdir();
                }
                return file;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Looper getMainLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mApplicationProxy.getMainLooper() : (Looper) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getPackageResourcePath() : (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PackageManager packageManager = this.mApplicationProxy.getPackageManager();
            if (this.mProxyPm == null && packageManager != null) {
                PackageMangerProxy packageMangerProxy = new PackageMangerProxy(packageManager);
                this.mProxyPm = packageMangerProxy;
                packageMangerProxy.setPackageName(getPackageName());
                this.mProxyPm.setPluginPackageName(this.mPluginPacakgeName);
            }
            return this.mProxyPm;
        }
        return (PackageManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mApplicationProxy.getPackageName() : (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageResourcePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName);
                if (plugin2 == null) {
                    return null;
                }
                return plugin2.getPluginApkFilePath();
            }
            return this.mApplicationProxy.getPackageResourcePath();
        }
        return (String) invokeV.objValue;
    }

    public String getPluginPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mPluginPacakgeName : (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPacakgeName);
            if (plugin2.getPluginResources() != null) {
                return plugin2.getPluginResources();
            }
            return this.mApplicationProxy.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, str, i2)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Application application = this.mApplicationProxy;
                return application.getSharedPreferences(pluginPackageName + str, i2);
            }
            return this.mApplicationProxy.getSharedPreferences(str, i2);
        }
        return (SharedPreferences) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? super.getSystemService(str) : invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Application application = this.mApplicationProxy;
                return application.openFileInput(pluginPackageName + str);
            }
            return this.mApplicationProxy.openFileInput(str);
        }
        return (FileInputStream) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i2) throws FileNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, str, i2)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Application application = this.mApplicationProxy;
                return application.openFileOutput(pluginPackageName + str, i2);
            }
            return this.mApplicationProxy.openFileOutput(str, i2);
        }
        return (FileOutputStream) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048601, this, str, i2, cursorFactory)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = d.k().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Application application = this.mApplicationProxy;
                return application.openOrCreateDatabase(pluginPackageName + str, i2, cursorFactory);
            }
            return this.mApplicationProxy.openOrCreateDatabase(str, i2, cursorFactory);
        }
        return (SQLiteDatabase) invokeLIL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, broadcastReceiver, intentFilter)) == null) ? super.registerReceiver(broadcastReceiver, intentFilter) : (Intent) invokeLL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void removeStickyBroadcast(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, intent) == null) {
            this.mApplicationProxy.removeStickyBroadcast(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, intent) == null) {
            this.mApplicationProxy.sendBroadcast(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, intent, str) == null) {
            this.mApplicationProxy.sendOrderedBroadcast(intent, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcast(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, intent) == null) {
            this.mApplicationProxy.sendStickyBroadcast(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i2, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{intent, broadcastReceiver, handler, Integer.valueOf(i2), str, bundle}) == null) {
            this.mApplicationProxy.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i2, str, bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setApplicationProxy(Application application) {
        Context context;
        Exception e2;
        InvocationTargetException e3;
        NoSuchMethodException e4;
        InstantiationException e5;
        IllegalArgumentException e6;
        IllegalAccessException e7;
        ClassNotFoundException e8;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048611, this, application) != null) {
            return;
        }
        this.mApplicationProxy = application;
        if (application == null) {
            return;
        }
        try {
            cls = Class.forName("android.app.ContextImpl");
            Constructor<?> constructor = cls.getConstructor(cls);
            constructor.setAccessible(true);
            context = (Context) constructor.newInstance(application.getBaseContext());
        } catch (ClassNotFoundException e9) {
            context = null;
            e8 = e9;
        } catch (IllegalAccessException e10) {
            context = null;
            e7 = e10;
        } catch (IllegalArgumentException e11) {
            context = null;
            e6 = e11;
        } catch (InstantiationException e12) {
            context = null;
            e5 = e12;
        } catch (NoSuchMethodException e13) {
            context = null;
            e4 = e13;
        } catch (InvocationTargetException e14) {
            context = null;
            e3 = e14;
        } catch (Exception e15) {
            context = null;
            e2 = e15;
        }
        try {
            try {
                Method declaredMethod = cls.getDeclaredMethod("setOuterContext", Context.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(context, this);
            } catch (ClassNotFoundException e16) {
                e8 = e16;
                BdLog.e(e8);
                if (context == null) {
                }
                attachBaseContext(context);
                Field field = application.getClass().getField("mLoadedApk");
                field.set(this, field.get(application));
                return;
            } catch (IllegalAccessException e17) {
                e7 = e17;
                BdLog.e(e7);
                if (context == null) {
                }
                attachBaseContext(context);
                Field field2 = application.getClass().getField("mLoadedApk");
                field2.set(this, field2.get(application));
                return;
            } catch (IllegalArgumentException e18) {
                e6 = e18;
                BdLog.e(e6);
                if (context == null) {
                }
                attachBaseContext(context);
                Field field22 = application.getClass().getField("mLoadedApk");
                field22.set(this, field22.get(application));
                return;
            } catch (InstantiationException e19) {
                e5 = e19;
                BdLog.e(e5);
                if (context == null) {
                }
                attachBaseContext(context);
                Field field222 = application.getClass().getField("mLoadedApk");
                field222.set(this, field222.get(application));
                return;
            } catch (NoSuchMethodException e20) {
                e4 = e20;
                BdLog.e(e4);
                if (context == null) {
                }
                attachBaseContext(context);
                Field field2222 = application.getClass().getField("mLoadedApk");
                field2222.set(this, field2222.get(application));
                return;
            } catch (InvocationTargetException e21) {
                e3 = e21;
                BdLog.e(e3);
                if (context == null) {
                }
                attachBaseContext(context);
                Field field22222 = application.getClass().getField("mLoadedApk");
                field22222.set(this, field22222.get(application));
                return;
            } catch (Exception e22) {
                e2 = e22;
                BdLog.e(e2);
                if (context == null) {
                }
                attachBaseContext(context);
                Field field222222 = application.getClass().getField("mLoadedApk");
                field222222.set(this, field222222.get(application));
                return;
            }
            Field field2222222 = application.getClass().getField("mLoadedApk");
            field2222222.set(this, field2222222.get(application));
            return;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | Exception unused) {
            return;
        }
        if (context == null) {
            context = application.getBaseContext();
        }
        attachBaseContext(context);
    }

    public void setPluginPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.mPluginPacakgeName = str;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.mApplicationProxy.setTheme(i2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, intent) == null) && (plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPacakgeName)) != null && plugin2.remapStartActivityIntent(intent)) {
            if (intent != null) {
                intent.addFlags(268435456);
            }
            this.mApplicationProxy.startActivity(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mApplicationProxy.startIntentSender(intentSender, intent, i2, i3, i4);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, intent)) == null) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPacakgeName);
            if (plugin2 != null && plugin2.remapStartServiceIntent(intent)) {
                return this.mApplicationProxy.startService(intent);
            }
            return null;
        }
        return (ComponentName) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, intent)) == null) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPacakgeName);
            if (plugin2 != null && plugin2.remapStartServiceIntent(intent)) {
                return this.mApplicationProxy.stopService(intent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, serviceConnection) == null) {
            this.mApplicationProxy.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, broadcastReceiver) == null) {
            super.unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048603, this, broadcastReceiver, intentFilter, str, handler)) == null) ? super.registerReceiver(broadcastReceiver, intentFilter, str, handler) : (Intent) invokeLLLL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, intent, str) == null) {
            this.mApplicationProxy.sendBroadcast(intent, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i2, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{intent, str, broadcastReceiver, handler, Integer.valueOf(i2), str2, bundle}) == null) {
            this.mApplicationProxy.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i2, str2, bundle);
        }
    }
}
