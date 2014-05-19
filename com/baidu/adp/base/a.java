package com.baidu.adp.base;

import android.app.Application;
import android.content.Context;
/* loaded from: classes.dex */
public class a extends Application {
    private static a sApp = null;
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
        com.baidu.adp.lib.util.h.a(application);
        initWorkMode();
        initBitmapHelper();
        initHttpManager();
    }

    private void initHttpManager() {
        com.baidu.adp.lib.network.willdelete.e.a().a(this.mContext, false);
    }

    public static a getInst() {
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
        com.baidu.adp.lib.util.b.a().a(this.mContext);
    }

    public void onAppMemoryLow() {
    }
}
