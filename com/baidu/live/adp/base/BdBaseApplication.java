package com.baidu.live.adp.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import com.baidu.live.adp.lib.util.BdBitmapHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public class BdBaseApplication extends ContextWrapper {
    public static final int RESOURCE_LOAD_MAX_TRY_COUNT = 3;
    private static BdBaseApplication sApp = null;
    private long lastGcTime;
    private Application mContext;
    private boolean mIsDebugMode;
    private boolean mIsPluginResourceOpen;

    public BdBaseApplication(Context context) {
        super(context);
        this.mIsDebugMode = false;
        this.mContext = null;
        this.mIsPluginResourceOpen = true;
        this.lastGcTime = 0L;
    }

    public void onCreate(Application application) {
        BdResources.getInstance().setHostResources(super.getResources());
        initBdBaseApp(application);
    }

    private void initBdBaseApp(Application application) {
        sApp = this;
        this.mContext = application;
        BdUtilHelper.initDeviceData(application);
        initWorkMode();
        initBitmapHelper();
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
        BdBitmapHelper.getInstance().initial(this.mContext);
    }

    public void onAppMemoryLow() {
        BdActivityStack.getInst().releaseAllPossibleAcitivities();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastGcTime > StatisticConfig.MIN_UPLOAD_INTERVAL) {
            this.lastGcTime = currentTimeMillis;
            System.gc();
        }
    }

    public void setActivityStackMaxSize(int i) {
        BdActivityStack.getInst().setActivityStackMaxSize(i);
    }

    public int getActivityStackMaxSize() {
        return BdActivityStack.getInst().getActivityStackMaxSize();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = BdResources.getInstance().getResources();
        return (resources == null || !this.mIsPluginResourceOpen) ? super.getResources() : resources;
    }

    public void setIsPluginResourceOpen(boolean z) {
        this.mIsPluginResourceOpen = true;
    }

    public boolean getIsPluginResourcOpen() {
        return this.mIsPluginResourceOpen;
    }
}
