package com.baidu.adp.plugin.pluginBase;

import android.app.Application;
import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import d.a.c.h.f.c;
import d.a.c.h.j.g.d;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class PluginBaseService extends PluginContextWrapper {
    public static final int START_CONTINUATION_MASK = 15;
    public static final int START_FLAG_REDELIVERY = 1;
    public static final int START_FLAG_RETRY = 2;
    public static final int START_NOT_STICKY = 2;
    public static final int START_REDELIVER_INTENT = 3;
    public static final int START_STICKY = 1;
    public Service mService;
    public c mServiceProxy;

    public PluginBaseService() {
        super(null);
        this.mService = null;
        this.mServiceProxy = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        return this.mServiceProxy.proxyBindService(intent, serviceConnection, i2);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mServiceProxy.proxyDump(fileDescriptor, printWriter, strArr);
    }

    public void finalize() throws Throwable {
        this.mServiceProxy.proxyFinalize();
        super.finalize();
    }

    public final Application getApplication() {
        return PluginCenter.getInstance().getPlugin(getPluginPackageName()).getApplication();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Service service = this.mService;
            return service.getFileStreamPath(pluginPackageName + str);
        }
        return this.mService.getFileStreamPath(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return this.mServiceProxy.proxyGetPackageManager();
    }

    public Service getService() {
        return this.mService;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            c cVar = this.mServiceProxy;
            return cVar.proxyGetSharedPreferences(pluginPackageName + str, i2);
        }
        return this.mServiceProxy.proxyGetSharedPreferences(str, i2);
    }

    public abstract IBinder onBind(Intent intent);

    public void onConfigurationChanged(Configuration configuration) {
        this.mServiceProxy.proxyOnConfigurationChanged(configuration);
    }

    public void onCreate() {
    }

    public void onDestroy() {
        this.mServiceProxy.proxyOnDestroy();
    }

    public void onLowMemory() {
        this.mServiceProxy.proxyOnLowMemory();
    }

    public void onRebind(Intent intent) {
        this.mServiceProxy.proxyOnRebind(intent);
    }

    public void onStart(Intent intent, int i2) {
        this.mServiceProxy.proxyOnStart(intent, i2);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return this.mServiceProxy.proxyOnStartCommand(intent, i2, i3);
    }

    public boolean onUnbind(Intent intent) {
        return this.mServiceProxy.proxyOnUnbind(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Service service = this.mService;
            return service.openFileInput(pluginPackageName + str);
        }
        return this.mService.openFileInput(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i2) throws FileNotFoundException {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Service service = this.mService;
            return service.openFileOutput(pluginPackageName + str, i2);
        }
        return this.mService.openFileOutput(str, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 != null && h2.isThird) {
            Service service = this.mService;
            return service.openOrCreateDatabase(pluginPackageName + str, i2, cursorFactory);
        }
        return this.mService.openOrCreateDatabase(str, i2, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        super.sendBroadcast(intent);
    }

    public void setServiceProxy(c cVar) {
        this.mService = cVar.getService();
        this.mServiceProxy = cVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (intent != null) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        this.mServiceProxy.proxyStartActivity(intent);
    }

    public final void startForeground(int i2, Notification notification) {
        this.mService.startForeground(i2, notification);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return this.mServiceProxy.proxyStartService(intent);
    }

    public final void stopSelf() {
        this.mService.stopSelf();
    }

    public final boolean stopSelfResult(int i2) {
        return this.mService.stopSelfResult(i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        return this.mServiceProxy.proxyStopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        super.sendBroadcast(intent, str);
    }

    public final void stopSelf(int i2) {
        this.mService.stopSelf(i2);
    }
}
