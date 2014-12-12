package com.baidu.adp.base;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.megapp.ma.MAApplication;
/* loaded from: classes.dex */
public class BdBaseApplication extends MAApplication {
    public static final int RESOURCE_LOAD_MAX_TRY_COUNT = 3;
    private static BdBaseApplication sApp = null;
    private boolean mIsDebugMode = false;
    private Application mContext = null;
    private long lastGcTime = 0;

    public void onCreate(Application application) {
        initBdBaseApp(application);
        super.onCreate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
    }

    public void initBdBaseApp(Application application) {
        sApp = this;
        this.mContext = application;
        com.baidu.adp.lib.util.l.L(application);
        initWorkMode();
        initBitmapHelper();
        initHttpManager();
        initPlugin();
    }

    private void initPlugin() {
        com.baidu.adp.plugin.c.a.hW().init();
    }

    private void initHttpManager() {
        com.baidu.adp.lib.network.willdelete.e.dX().init(this.mContext, false);
    }

    public static BdBaseApplication getInst() {
        return sApp;
    }

    public Application getApp() {
        return this.mContext;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return super.getPackageManager();
    }

    private void initWorkMode() {
        if ((this.mContext.getApplicationInfo().flags & 2) == 0) {
            this.mIsDebugMode = false;
        } else {
            this.mIsDebugMode = true;
        }
    }

    public boolean isDebugMode() {
        return this.mIsDebugMode;
    }

    public void setDebugMode(boolean z) {
        this.mIsDebugMode = z;
    }

    private void initBitmapHelper() {
        com.baidu.adp.lib.util.c.eS().K(this.mContext);
    }

    public void onAppMemoryLow() {
        a.ah().ai();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastGcTime > 30000) {
            this.lastGcTime = currentTimeMillis;
            System.gc();
        }
    }

    public void setActivityStackMaxSize(int i) {
        a.ah().setActivityStackMaxSize(i);
    }

    public int getActivityStackMaxSize() {
        return a.ah().getActivityStackMaxSize();
    }
}
