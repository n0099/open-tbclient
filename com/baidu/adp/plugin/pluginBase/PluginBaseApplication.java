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
import com.baidu.adp.plugin.PluginCenter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class PluginBaseApplication extends Application {
    private Application EM = null;
    private String EN = null;
    private com.baidu.adp.plugin.proxy.a EO = null;

    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Application application) {
        Context context;
        Class<?> cls;
        this.EM = application;
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

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(this.EN);
        return plugin2.kt() != null ? plugin2.kt() : this.EM.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        PackageManager packageManager = this.EM.getPackageManager();
        if (this.EO == null && packageManager != null) {
            this.EO = new com.baidu.adp.plugin.proxy.a(packageManager);
            this.EO.setPackageName(getPackageName());
            this.EO.setPluginPackageName(this.EN);
        }
        return this.EO;
    }

    public void setPluginPackageName(String str) {
        this.EN = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return this.EM.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return super.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return this.EM.getSharedPreferences(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.EM.bindService(intent, serviceConnection, i);
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
        return this.EM.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return this.EM.getContentResolver();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Looper getMainLooper() {
        return this.EM.getMainLooper();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        this.EM.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.EM.getClassLoader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.EM.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageResourcePath() {
        return this.EM.getPackageResourcePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        return this.EM.getPackageCodePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) {
        return this.EM.openFileInput(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) {
        return this.EM.openFileOutput(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return this.EM.deleteFile(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        return this.EM.getFileStreamPath(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] fileList() {
        return this.EM.fileList();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        return this.EM.getFilesDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        return this.EM.getCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        return this.EM.getDir(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return this.EM.openOrCreateDatabase(str, i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(this.EN);
        if (plugin2 != null && plugin2.D(intent)) {
            this.EM.startActivity(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        this.EM.startIntentSender(intentSender, intent, i, i2, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        this.EM.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        this.EM.sendBroadcast(intent, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        this.EM.sendOrderedBroadcast(intent, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        this.EM.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i, str2, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcast(Intent intent) {
        this.EM.sendStickyBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        this.EM.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i, str, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void removeStickyBroadcast(Intent intent) {
        this.EM.removeStickyBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        super.unregisterReceiver(broadcastReceiver);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(this.EN);
        if (plugin2 != null && plugin2.C(intent)) {
            return this.EM.startService(intent);
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(this.EN);
        if (plugin2 != null && plugin2.C(intent)) {
            return this.EM.stopService(intent);
        }
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        this.EM.unbindService(serviceConnection);
    }
}
