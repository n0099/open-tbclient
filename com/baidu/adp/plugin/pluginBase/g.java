package com.baidu.adp.plugin.pluginBase;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* loaded from: classes.dex */
public abstract class g extends i {
    private Service tO;
    private com.baidu.adp.plugin.a.b tP;

    public abstract IBinder onBind(Intent intent);

    public g() {
        super(null);
        this.tO = null;
        this.tP = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.tP.proxyBindService(intent, serviceConnection, i);
    }

    protected void finalize() {
        this.tP.proxyFinalize();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return this.tP.proxyGetPackageManager();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.tP.proxyOnConfigurationChanged(configuration);
    }

    public void onCreate() {
    }

    public void onDestroy() {
        this.tP.proxyOnDestroy();
    }

    public void onLowMemory() {
        this.tP.proxyOnLowMemory();
    }

    public void onStart(Intent intent, int i) {
        this.tP.proxyOnStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return this.tP.proxyOnStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return this.tP.proxyOnUnbind(intent);
    }

    public void a(com.baidu.adp.plugin.a.b bVar) {
        this.tO = bVar.getService();
        this.tP = bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        this.tP.proxyStartActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return this.tP.proxyStartService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        return this.tP.proxyStopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return this.tP.proxyGetSharedPreferences(str, i);
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
    public FileInputStream openFileInput(String str) {
        return this.tO.openFileInput(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) {
        return this.tO.openFileOutput(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return this.tO.openOrCreateDatabase(str, i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        return this.tO.getFileStreamPath(str);
    }
}
