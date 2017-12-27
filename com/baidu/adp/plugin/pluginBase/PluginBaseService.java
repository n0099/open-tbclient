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
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.a.c;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
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
    private Service mService;
    private c mServiceProxy;

    public abstract IBinder onBind(Intent intent);

    public PluginBaseService() {
        super(null);
        this.mService = null;
        this.mServiceProxy = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.mServiceProxy.proxyBindService(intent, serviceConnection, i);
    }

    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mServiceProxy.proxyDump(fileDescriptor, printWriter, strArr);
    }

    protected void finalize() throws Throwable {
        this.mServiceProxy.proxyFinalize();
        super.finalize();
    }

    public final Application getApplication() {
        return PluginCenter.getInstance().getPlugin(getPluginPackageName()).getApplication();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return this.mServiceProxy.proxyGetPackageManager();
    }

    public Service getService() {
        return this.mService;
    }

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

    public void onStart(Intent intent, int i) {
        this.mServiceProxy.proxyOnStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return this.mServiceProxy.proxyOnStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return this.mServiceProxy.proxyOnUnbind(intent);
    }

    public void setServiceProxy(c cVar) {
        this.mService = cVar.getService();
        this.mServiceProxy = cVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        this.mServiceProxy.proxyStartActivity(intent);
    }

    public final void startForeground(int i, Notification notification) {
        this.mService.startForeground(i, notification);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return this.mServiceProxy.proxyStartService(intent);
    }

    public final void stopSelf() {
        this.mService.stopSelf();
    }

    public final void stopSelf(int i) {
        this.mService.stopSelf(i);
    }

    public final boolean stopSelfResult(int i) {
        return this.mService.stopSelfResult(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        return this.mServiceProxy.proxyStopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.rt().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mServiceProxy.proxyGetSharedPreferences(str, i) : this.mServiceProxy.proxyGetSharedPreferences(pluginPackageName + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        super.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        super.sendBroadcast(intent, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.rt().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mService.openFileInput(str) : this.mService.openFileInput(pluginPackageName + str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.rt().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mService.openFileOutput(str, i) : this.mService.openFileOutput(pluginPackageName + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.rt().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mService.openOrCreateDatabase(str, i, cursorFactory) : this.mService.openOrCreateDatabase(pluginPackageName + str, i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.rt().findPluginSetting(pluginPackageName);
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mService.getFileStreamPath(str) : this.mService.getFileStreamPath(pluginPackageName + str);
    }
}
