package com.baidu.adp.base;

import android.app.Application;
import android.content.Context;
import com.baidu.adp.lib.util.m;
/* loaded from: classes.dex */
public class BdBaseApplication extends Application {
    public static final int RESOURCE_LOAD_MAX_TRY_COUNT = 3;
    private static BdBaseApplication sApp = null;
    private boolean mIsDebugMode = false;
    private Application mContext = null;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        initBdBaseApp(this);
    }

    public void initBdBaseApp(Application application) {
        sApp = this;
        this.mContext = application;
        m.m(application);
        initWorkMode();
        initBitmapHelper();
        initHttpManager();
        initPlugin();
    }

    private void initPlugin() {
    }

    private void initHttpManager() {
        com.baidu.adp.lib.network.willdelete.e.dY().init(this.mContext, false);
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
        com.baidu.adp.lib.util.c.eS().l(this.mContext);
    }

    public void onAppMemoryLow() {
        a.M().N();
        System.gc();
    }

    public void setActivityStackMaxSize(int i) {
        a.M().setActivityStackMaxSize(i);
    }

    public int getActivityStackMaxSize() {
        return a.M().getActivityStackMaxSize();
    }
}
