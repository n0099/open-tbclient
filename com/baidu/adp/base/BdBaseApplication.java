package com.baidu.adp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.baidu.megapp.ma.MAApplication;
/* loaded from: classes.dex */
public class BdBaseApplication extends MAApplication {
    public static final int RESOURCE_LOAD_MAX_TRY_COUNT = 3;
    private static BdBaseApplication sApp = null;
    private boolean mIsDebugMode = false;
    private Application mContext = null;
    private boolean mIsPluginResourceOpen = true;
    private long lastGcTime = 0;

    public void onCreate(Application application) {
        j.dK().a(super.getResources());
        initBdBaseApp(application);
        super.onCreate();
    }

    private void initBdBaseApp(Application application) {
        sApp = this;
        this.mContext = application;
        com.baidu.adp.lib.util.k.J(application);
        initWorkMode();
        initBitmapHelper();
        initPlugin();
    }

    private void initPlugin() {
        com.baidu.adp.plugin.c.a.lJ().init();
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
        com.baidu.adp.lib.util.d.iv().I(this.mContext);
    }

    public void onAppMemoryLow() {
        a.dF().dH();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastGcTime > 30000) {
            this.lastGcTime = currentTimeMillis;
            System.gc();
        }
    }

    public void setActivityStackMaxSize(int i) {
        a.dF().setActivityStackMaxSize(i);
    }

    public int getActivityStackMaxSize() {
        return a.dF().getActivityStackMaxSize();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = j.dK().getResources();
        return (resources == null || !this.mIsPluginResourceOpen) ? super.getResources() : resources;
    }

    public void setIsPluginResourceOpen(boolean z) {
        this.mIsPluginResourceOpen = true;
    }

    public boolean getIsPluginResourcOpen() {
        return this.mIsPluginResourceOpen;
    }
}
