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
    private Service tL;
    private com.baidu.adp.plugin.a.b tM;

    public abstract IBinder onBind(Intent intent);

    public g() {
        super(null);
        this.tL = null;
        this.tM = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.tM.proxyBindService(intent, serviceConnection, i);
    }

    protected void finalize() {
        this.tM.proxyFinalize();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return this.tM.proxyGetPackageManager();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.tM.proxyOnConfigurationChanged(configuration);
    }

    public void onCreate() {
    }

    public void onDestroy() {
        this.tM.proxyOnDestroy();
    }

    public void onLowMemory() {
        this.tM.proxyOnLowMemory();
    }

    public void onStart(Intent intent, int i) {
        this.tM.proxyOnStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return this.tM.proxyOnStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return this.tM.proxyOnUnbind(intent);
    }

    public void a(com.baidu.adp.plugin.a.b bVar) {
        this.tL = bVar.getService();
        this.tM = bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        this.tM.proxyStartActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return this.tM.proxyStartService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        return this.tM.proxyStopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return this.tM.proxyGetSharedPreferences(str, i);
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
        return this.tL.openFileInput(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) {
        return this.tL.openFileOutput(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return this.tL.openOrCreateDatabase(str, i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        return this.tL.getFileStreamPath(str);
    }
}
