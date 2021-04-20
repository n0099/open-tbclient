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
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
import com.baidu.adp.plugin.proxy.PackageMangerProxy;
import d.b.c.h.j.g.d;
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
    public Application mApplicationProxy = null;
    public String mPluginPacakgeName = null;
    public PackageMangerProxy mProxyPm = null;

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.mApplicationProxy.bindService(intent, serviceConnection, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Application application = this.mApplicationProxy;
            return application.deleteFile(pluginPackageName + str);
        }
        return this.mApplicationProxy.deleteFile(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] fileList() {
        try {
            String[] list = getFilesDir().list();
            return list != null ? list : new String[0];
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.mApplicationProxy.getApplicationInfo();
    }

    public Application getApplicationProxy() {
        return this.mApplicationProxy;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return this.mApplicationProxy.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
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

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.mApplicationProxy.getClassLoader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return ContentResolverProxy.getContentResolver();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Application application = this.mApplicationProxy;
            return application.getDir(pluginPackageName + str, i);
        }
        return this.mApplicationProxy.getDir(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Application application = this.mApplicationProxy;
            return application.getFileStreamPath(pluginPackageName + str);
        }
        return this.mApplicationProxy.getFileStreamPath(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
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

    @Override // android.content.ContextWrapper, android.content.Context
    public Looper getMainLooper() {
        return this.mApplicationProxy.getMainLooper();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        return getPackageResourcePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        PackageManager packageManager = this.mApplicationProxy.getPackageManager();
        if (this.mProxyPm == null && packageManager != null) {
            PackageMangerProxy packageMangerProxy = new PackageMangerProxy(packageManager);
            this.mProxyPm = packageMangerProxy;
            packageMangerProxy.setPackageName(getPackageName());
            this.mProxyPm.setPluginPackageName(this.mPluginPacakgeName);
        }
        return this.mProxyPm;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return this.mApplicationProxy.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageResourcePath() {
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

    public String getPluginPackageName() {
        return this.mPluginPacakgeName;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPacakgeName);
        if (plugin2.getPluginResources() != null) {
            return plugin2.getPluginResources();
        }
        return this.mApplicationProxy.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Application application = this.mApplicationProxy;
            return application.getSharedPreferences(pluginPackageName + str, i);
        }
        return this.mApplicationProxy.getSharedPreferences(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return super.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Application application = this.mApplicationProxy;
            return application.openFileInput(pluginPackageName + str);
        }
        return this.mApplicationProxy.openFileInput(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Application application = this.mApplicationProxy;
            return application.openFileOutput(pluginPackageName + str, i);
        }
        return this.mApplicationProxy.openFileOutput(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Application application = this.mApplicationProxy;
            return application.openOrCreateDatabase(pluginPackageName + str, i, cursorFactory);
        }
        return this.mApplicationProxy.openOrCreateDatabase(str, i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return super.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void removeStickyBroadcast(Intent intent) {
        this.mApplicationProxy.removeStickyBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        this.mApplicationProxy.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        this.mApplicationProxy.sendOrderedBroadcast(intent, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcast(Intent intent) {
        this.mApplicationProxy.sendStickyBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        this.mApplicationProxy.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i, str, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
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
        this.mPluginPacakgeName = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        this.mApplicationProxy.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPacakgeName);
        if (plugin2 != null && plugin2.remapStartActivityIntent(intent)) {
            if (intent != null) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            this.mApplicationProxy.startActivity(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        this.mApplicationProxy.startIntentSender(intentSender, intent, i, i2, i3);
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

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        super.unregisterReceiver(broadcastReceiver);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        this.mApplicationProxy.sendBroadcast(intent, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        this.mApplicationProxy.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i, str2, bundle);
    }
}
