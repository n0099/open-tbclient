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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
import com.baidu.adp.plugin.proxy.PackageMangerProxy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class PluginBaseApplication extends Application {
    private Application mApplicationProxy = null;
    private String mPluginPacakgeName = null;
    private PackageMangerProxy mProxyPm = null;

    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setApplicationProxy(Application application) {
        Context context;
        Class<?> cls;
        this.mApplicationProxy = application;
        if (application != null) {
            Context context2 = null;
            try {
                cls = Class.forName("android.app.ContextImpl");
                Constructor<?> constructor = cls.getConstructor(cls);
                constructor.setAccessible(true);
                context = (Context) constructor.newInstance(application.getBaseContext());
            } catch (ClassNotFoundException e) {
                e = e;
            } catch (IllegalAccessException e2) {
                e = e2;
            } catch (IllegalArgumentException e3) {
                e = e3;
            } catch (InstantiationException e4) {
                e = e4;
            } catch (NoSuchMethodException e5) {
                e = e5;
            } catch (InvocationTargetException e6) {
                e = e6;
            } catch (Exception e7) {
                e = e7;
            }
            try {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setOuterContext", Context.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(context, this);
                } catch (ClassNotFoundException e8) {
                    context2 = context;
                    e = e8;
                    BdLog.e(e);
                    context = context2;
                    if (context == null) {
                    }
                    attachBaseContext(context);
                    Field field = application.getClass().getField("mLoadedApk");
                    field.set(this, field.get(application));
                    return;
                } catch (IllegalAccessException e9) {
                    context2 = context;
                    e = e9;
                    BdLog.e(e);
                    context = context2;
                    if (context == null) {
                    }
                    attachBaseContext(context);
                    Field field2 = application.getClass().getField("mLoadedApk");
                    field2.set(this, field2.get(application));
                    return;
                } catch (IllegalArgumentException e10) {
                    context2 = context;
                    e = e10;
                    BdLog.e(e);
                    context = context2;
                    if (context == null) {
                    }
                    attachBaseContext(context);
                    Field field22 = application.getClass().getField("mLoadedApk");
                    field22.set(this, field22.get(application));
                    return;
                } catch (InstantiationException e11) {
                    context2 = context;
                    e = e11;
                    BdLog.e(e);
                    context = context2;
                    if (context == null) {
                    }
                    attachBaseContext(context);
                    Field field222 = application.getClass().getField("mLoadedApk");
                    field222.set(this, field222.get(application));
                    return;
                } catch (NoSuchMethodException e12) {
                    context2 = context;
                    e = e12;
                    BdLog.e(e);
                    context = context2;
                    if (context == null) {
                    }
                    attachBaseContext(context);
                    Field field2222 = application.getClass().getField("mLoadedApk");
                    field2222.set(this, field2222.get(application));
                    return;
                } catch (InvocationTargetException e13) {
                    context2 = context;
                    e = e13;
                    BdLog.e(e);
                    context = context2;
                    if (context == null) {
                    }
                    attachBaseContext(context);
                    Field field22222 = application.getClass().getField("mLoadedApk");
                    field22222.set(this, field22222.get(application));
                    return;
                } catch (Exception e14) {
                    context2 = context;
                    e = e14;
                    BdLog.e(e);
                    context = context2;
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
            } catch (IllegalAccessException e15) {
                return;
            } catch (IllegalArgumentException e16) {
                return;
            } catch (NoSuchFieldException e17) {
                return;
            } catch (Exception e18) {
                return;
            }
            if (context == null) {
                context = application.getBaseContext();
            }
            attachBaseContext(context);
        }
    }

    public Application getApplicationProxy() {
        return this.mApplicationProxy;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPacakgeName);
        return plugin2.getPluginResources() != null ? plugin2.getPluginResources() : this.mApplicationProxy.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        PackageManager packageManager = this.mApplicationProxy.getPackageManager();
        if (this.mProxyPm == null && packageManager != null) {
            this.mProxyPm = new PackageMangerProxy(packageManager);
            this.mProxyPm.setPackageName(getPackageName());
            this.mProxyPm.setPluginPackageName(this.mPluginPacakgeName);
        }
        return this.mProxyPm;
    }

    public void setPluginPackageName(String str) {
        this.mPluginPacakgeName = str;
    }

    public String getPluginPackageName() {
        return this.mPluginPacakgeName;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return this.mApplicationProxy.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return super.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jW().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mApplicationProxy.getSharedPreferences(str, i) : this.mApplicationProxy.getSharedPreferences(String.valueOf(pluginPackageName) + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.mApplicationProxy.bindService(intent, serviceConnection, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return super.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return this.mApplicationProxy.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return ContentResolverProxy.getContentResolver();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Looper getMainLooper() {
        return this.mApplicationProxy.getMainLooper();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        this.mApplicationProxy.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.mApplicationProxy.getClassLoader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.mApplicationProxy.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageResourcePath() {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jW().findPluginSetting(pluginPackageName);
        if (findPluginSetting != null && findPluginSetting.isThird) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName);
            if (plugin2 == null) {
                return null;
            }
            return plugin2.getPluginApkFilePath();
        }
        return this.mApplicationProxy.getPackageResourcePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        return getPackageResourcePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jW().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mApplicationProxy.openFileInput(str) : this.mApplicationProxy.openFileInput(String.valueOf(pluginPackageName) + str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jW().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mApplicationProxy.openFileOutput(str, i) : this.mApplicationProxy.openFileOutput(String.valueOf(pluginPackageName) + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jW().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mApplicationProxy.deleteFile(str) : this.mApplicationProxy.deleteFile(String.valueOf(pluginPackageName) + str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jW().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mApplicationProxy.getFileStreamPath(str) : this.mApplicationProxy.getFileStreamPath(String.valueOf(pluginPackageName) + str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] fileList() {
        try {
            String[] list = getFilesDir().list();
            return list != null ? list : new String[0];
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File filesDir = this.mApplicationProxy.getFilesDir();
        if (filesDir == null) {
            return null;
        }
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jW().findPluginSetting(pluginPackageName);
        if (findPluginSetting == null || !findPluginSetting.isThird) {
            return filesDir;
        }
        try {
            File file = new File(filesDir, pluginPackageName);
            if (!file.isDirectory() || !file.exists()) {
                file.mkdir();
            }
            return file;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File cacheDir = this.mApplicationProxy.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        try {
            PluginSetting findPluginSetting = c.jW().findPluginSetting(getPluginPackageName());
            if (findPluginSetting == null || !findPluginSetting.isThird) {
                return cacheDir;
            }
            File file = new File(String.valueOf(cacheDir.getPath()) + File.separator + getPluginPackageName() + cacheDir.getName());
            if (!file.exists() || !file.isDirectory()) {
                file.mkdir();
            }
            return file;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jW().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mApplicationProxy.getDir(str, i) : this.mApplicationProxy.getDir(String.valueOf(pluginPackageName) + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jW().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mApplicationProxy.openOrCreateDatabase(str, i, cursorFactory) : this.mApplicationProxy.openOrCreateDatabase(String.valueOf(pluginPackageName) + str, i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPacakgeName);
        if (plugin2 != null && plugin2.remapStartActivityIntent(intent)) {
            this.mApplicationProxy.startActivity(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        this.mApplicationProxy.startIntentSender(intentSender, intent, i, i2, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        this.mApplicationProxy.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        this.mApplicationProxy.sendBroadcast(intent, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        this.mApplicationProxy.sendOrderedBroadcast(intent, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        this.mApplicationProxy.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i, str2, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcast(Intent intent) {
        this.mApplicationProxy.sendStickyBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        this.mApplicationProxy.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i, str, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void removeStickyBroadcast(Intent intent) {
        this.mApplicationProxy.removeStickyBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        super.unregisterReceiver(broadcastReceiver);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPacakgeName);
        if (plugin2 != null && plugin2.remapStartServiceIntent(intent)) {
            return this.mApplicationProxy.startService(intent);
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPacakgeName);
        if (plugin2 != null && plugin2.remapStartServiceIntent(intent)) {
            return this.mApplicationProxy.stopService(intent);
        }
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        this.mApplicationProxy.unbindService(serviceConnection);
    }
}
