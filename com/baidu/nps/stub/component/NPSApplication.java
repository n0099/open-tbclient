package com.baidu.nps.stub.component;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
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
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.LayoutInflater;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.runtime.resources.ResourcesHookUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class NPSApplication extends Application {
    public LayoutInflater mInflater;
    public Application mOriginalApplication;
    public String mPackageName;

    public NPSApplication(Application application, String str) {
        this.mOriginalApplication = application;
        this.mPackageName = str;
        attachBaseContext(application.getBaseContext());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(29)
    public boolean bindIsolatedService(Intent intent, int i2, String str, Executor executor, ServiceConnection serviceConnection) {
        return this.mOriginalApplication.bindIsolatedService(intent, i2, str, executor, serviceConnection);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        return this.mOriginalApplication.bindService(intent, serviceConnection, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingOrSelfPermission(String str) {
        return this.mOriginalApplication.checkCallingOrSelfPermission(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingOrSelfUriPermission(Uri uri, int i2) {
        return this.mOriginalApplication.checkCallingOrSelfUriPermission(uri, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingPermission(String str) {
        return this.mOriginalApplication.checkCallingPermission(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingUriPermission(Uri uri, int i2) {
        return this.mOriginalApplication.checkCallingUriPermission(uri, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkPermission(String str, int i2, int i3) {
        return this.mOriginalApplication.checkPermission(str, i2, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(23)
    public int checkSelfPermission(String str) {
        return this.mOriginalApplication.checkSelfPermission(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkUriPermission(Uri uri, int i2, int i3, int i4) {
        return this.mOriginalApplication.checkUriPermission(uri, i2, i3, i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void clearWallpaper() throws IOException {
        this.mOriginalApplication.clearWallpaper();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        return this.mOriginalApplication.createConfigurationContext(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(26)
    public Context createContextForSplit(String str) throws PackageManager.NameNotFoundException {
        return this.mOriginalApplication.createContextForSplit(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(24)
    public Context createDeviceProtectedStorageContext() {
        return this.mOriginalApplication.createDeviceProtectedStorageContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createDisplayContext(Display display) {
        return this.mOriginalApplication.createDisplayContext(display);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createPackageContext(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.mOriginalApplication.createPackageContext(str, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        return this.mOriginalApplication.databaseList();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        return this.mOriginalApplication.deleteDatabase(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return this.mOriginalApplication.deleteFile(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingOrSelfPermission(String str, String str2) {
        this.mOriginalApplication.enforceCallingOrSelfPermission(str, str2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingOrSelfUriPermission(Uri uri, int i2, String str) {
        this.mOriginalApplication.enforceCallingOrSelfUriPermission(uri, i2, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingPermission(String str, String str2) {
        this.mOriginalApplication.enforceCallingPermission(str, str2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingUriPermission(Uri uri, int i2, String str) {
        this.mOriginalApplication.enforceCallingUriPermission(uri, i2, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforcePermission(String str, int i2, int i3, String str2) {
        this.mOriginalApplication.enforcePermission(str, i2, i3, str2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceUriPermission(Uri uri, int i2, int i3, int i4, String str) {
        this.mOriginalApplication.enforceUriPermission(uri, i2, i3, i4, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] fileList() {
        return this.mOriginalApplication.fileList();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this.mOriginalApplication.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.mOriginalApplication.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        ResourcesHookUtil.ensureResourcesReadyForNPS(this.mOriginalApplication.getBaseContext().getResources());
        return this.mOriginalApplication.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        return this.mOriginalApplication.getCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return NPSManager.getInstance().getBundle(this.mPackageName).getClassloader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(21)
    public File getCodeCacheDir() {
        return this.mOriginalApplication.getCodeCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return this.mOriginalApplication.getContentResolver();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(24)
    public File getDataDir() {
        return this.mOriginalApplication.getDataDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        return this.mOriginalApplication.getDatabasePath(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i2) {
        return this.mOriginalApplication.getDir(str, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        return this.mOriginalApplication.getExternalCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        return this.mOriginalApplication.getExternalCacheDirs();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        return this.mOriginalApplication.getExternalFilesDir(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        return this.mOriginalApplication.getExternalFilesDirs(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(21)
    public File[] getExternalMediaDirs() {
        return this.mOriginalApplication.getExternalMediaDirs();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        return this.mOriginalApplication.getFileStreamPath(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        return this.mOriginalApplication.getFilesDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(28)
    public Executor getMainExecutor() {
        return this.mOriginalApplication.getMainExecutor();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Looper getMainLooper() {
        return this.mOriginalApplication.getMainLooper();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(21)
    public File getNoBackupFilesDir() {
        return this.mOriginalApplication.getNoBackupFilesDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        return this.mOriginalApplication.getObbDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        return this.mOriginalApplication.getObbDirs();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(29)
    public String getOpPackageName() {
        return this.mOriginalApplication.getOpPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        return this.mOriginalApplication.getPackageCodePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return this.mOriginalApplication.getPackageManager();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return this.mOriginalApplication.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageResourcePath() {
        return this.mOriginalApplication.getPackageResourcePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return NPSManager.getInstance().getBundle(this.mPackageName).getResources(this.mOriginalApplication.getResources());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        return this.mOriginalApplication.getSharedPreferences(str, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.mInflater;
        }
        return this.mOriginalApplication.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(23)
    public String getSystemServiceName(Class<?> cls) {
        return this.mOriginalApplication.getSystemServiceName(cls);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        ResourcesHookUtil.ensureResourcesReadyForNPS(this.mOriginalApplication.getBaseContext().getResources());
        return this.mOriginalApplication.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Drawable getWallpaper() {
        return this.mOriginalApplication.getWallpaper();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        return this.mOriginalApplication.getWallpaperDesiredMinimumHeight();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        return this.mOriginalApplication.getWallpaperDesiredMinimumWidth();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void grantUriPermission(String str, Uri uri, int i2) {
        this.mOriginalApplication.grantUriPermission(str, uri, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(24)
    public boolean isDeviceProtectedStorage() {
        return this.mOriginalApplication.isDeviceProtectedStorage();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean isRestricted() {
        return this.mOriginalApplication.isRestricted();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(24)
    public boolean moveDatabaseFrom(Context context, String str) {
        return this.mOriginalApplication.moveDatabaseFrom(context, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        return this.mOriginalApplication.openFileInput(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i2) throws FileNotFoundException {
        return this.mOriginalApplication.openFileOutput(str, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        return this.mOriginalApplication.openOrCreateDatabase(str, i2, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Drawable peekWallpaper() {
        return this.mOriginalApplication.peekWallpaper();
    }

    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginalApplication.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Application, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mOriginalApplication.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.app.Application
    public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.mOriginalApplication.registerOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return this.mOriginalApplication.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void revokeUriPermission(Uri uri, int i2) {
        this.mOriginalApplication.revokeUriPermission(uri, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        this.mOriginalApplication.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        this.mOriginalApplication.sendOrderedBroadcast(intent, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        this.mOriginalApplication.setTheme(i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setWallpaper(Bitmap bitmap) throws IOException {
        this.mOriginalApplication.setWallpaper(bitmap);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        this.mOriginalApplication.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        this.mOriginalApplication.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(26)
    public ComponentName startForegroundService(Intent intent) {
        return this.mOriginalApplication.startForegroundService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        return this.mOriginalApplication.startInstrumentation(componentName, str, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        this.mOriginalApplication.startIntentSender(intentSender, intent, i2, i3, i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return this.mOriginalApplication.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        return this.mOriginalApplication.stopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        this.mOriginalApplication.unbindService(serviceConnection);
    }

    @Override // android.app.Application
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginalApplication.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Application, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mOriginalApplication.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // android.app.Application
    public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.mOriginalApplication.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.mOriginalApplication.unregisterReceiver(broadcastReceiver);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(29)
    public void updateServiceGroup(ServiceConnection serviceConnection, int i2, int i3) {
        this.mOriginalApplication.updateServiceGroup(serviceConnection, i2, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(29)
    public boolean bindService(Intent intent, int i2, Executor executor, ServiceConnection serviceConnection) {
        return this.mOriginalApplication.bindService(intent, i2, executor, serviceConnection);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkUriPermission(Uri uri, String str, String str2, int i2, int i3, int i4) {
        return this.mOriginalApplication.checkUriPermission(uri, str, str2, i2, i3, i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceUriPermission(Uri uri, String str, String str2, int i2, int i3, int i4, String str3) {
        this.mOriginalApplication.enforceUriPermission(uri, str, str2, i2, i3, i4, str3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return this.mOriginalApplication.openOrCreateDatabase(str, i2, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(26)
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i2) {
        return this.mOriginalApplication.registerReceiver(broadcastReceiver, intentFilter, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(26)
    public void revokeUriPermission(String str, Uri uri, int i2) {
        this.mOriginalApplication.revokeUriPermission(str, uri, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        this.mOriginalApplication.sendBroadcast(intent, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i2, String str2, Bundle bundle) {
        this.mOriginalApplication.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i2, str2, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setWallpaper(InputStream inputStream) throws IOException {
        this.mOriginalApplication.setWallpaper(inputStream);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mOriginalApplication.startActivities(intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        this.mOriginalApplication.startActivity(intent, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return this.mOriginalApplication.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.mOriginalApplication.startIntentSender(intentSender, intent, i2, i3, i4, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(26)
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i2) {
        return this.mOriginalApplication.registerReceiver(broadcastReceiver, intentFilter, str, handler, i2);
    }
}
