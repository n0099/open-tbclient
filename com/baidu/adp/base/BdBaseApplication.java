package com.baidu.adp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.megapp.ma.MAApplication;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes.dex */
public class BdBaseApplication extends MAApplication {
    public static final int RESOURCE_LOAD_MAX_TRY_COUNT = 3;
    private static BdBaseApplication sApp = null;
    protected Handler mAppInitHandler;
    private boolean mIsDebugMode = false;
    private Application mContext = null;
    private boolean mIsPluginResourceOpen = true;
    private long lastGcTime = 0;

    public void onCreate(Application application) {
        this.mAppInitHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.base.BdBaseApplication.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                BdBaseApplication.this.handleInitMessage(message);
            }
        };
        g.eS().a(super.getResources());
        initBdBaseApp(application);
        super.onCreate();
    }

    private void initBdBaseApp(Application application) {
        sApp = this;
        this.mContext = application;
        initWorkMode();
        initBitmapHelper();
        initPlugin();
    }

    private void initPlugin() {
        com.baidu.adp.plugin.c.a.lS().init();
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
        com.baidu.adp.lib.util.d.jA().ae(this.mContext);
    }

    public void onAppMemoryLow() {
        a.eM().eO();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastGcTime > StatisticConfig.MIN_UPLOAD_INTERVAL) {
            this.lastGcTime = currentTimeMillis;
            System.gc();
        }
    }

    protected void handleInitMessage(Message message) {
    }

    public void setActivityStackMaxSize(int i) {
        a.eM().setActivityStackMaxSize(i);
    }

    public int getActivityStackMaxSize() {
        return a.eM().getActivityStackMaxSize();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = g.eS().getResources();
        return (resources == null || !this.mIsPluginResourceOpen) ? super.getResources() : resources;
    }

    public boolean getIsPluginResourcOpen() {
        return this.mIsPluginResourceOpen;
    }
}
