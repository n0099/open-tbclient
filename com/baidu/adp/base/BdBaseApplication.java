package com.baidu.adp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.megapp.ma.MAApplication;
import java.util.Calendar;
/* loaded from: classes.dex */
public class BdBaseApplication extends MAApplication {
    public static final int RESOURCE_LOAD_MAX_TRY_COUNT = 3;
    private static BdBaseApplication sApp = null;
    protected Handler mAppInitHandler;
    private boolean mHasCheckedNewUserStatus;
    private boolean mIsNewUser;
    protected boolean mIsSmallFlow;
    protected long mSmallFlowInterval;
    protected long mStartSmallFlowTime;
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
        g.li().setHostResources(super.getResources());
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
        com.baidu.adp.plugin.c.a.pL().init();
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

    public void setIsSmallFlow(boolean z) {
        this.mIsSmallFlow = z;
    }

    public boolean isSmallFlow() {
        if (!this.mIsSmallFlow || (System.currentTimeMillis() - this.mStartSmallFlowTime) / 1000 <= this.mSmallFlowInterval) {
            return this.mIsSmallFlow;
        }
        return false;
    }

    public void setStartSmallFlowTime(long j) {
        this.mStartSmallFlowTime = j;
    }

    public long getStartSmallFlowTime() {
        return this.mStartSmallFlowTime;
    }

    public void setSmallFlowInterval(long j) {
        this.mSmallFlowInterval = j;
    }

    public long getSmallFlowInterval() {
        return this.mSmallFlowInterval;
    }

    public boolean isDebugMode() {
        return this.mIsDebugMode;
    }

    public void setDebugMode(boolean z) {
        this.mIsDebugMode = z;
    }

    private void initBitmapHelper() {
        com.baidu.adp.lib.util.d.oh().initial(this.mContext);
    }

    public void onAppMemoryLow() {
        a.lg().releaseAllPossibleAcitivities();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastGcTime > 30000) {
            this.lastGcTime = currentTimeMillis;
            System.gc();
        }
    }

    protected void handleInitMessage(Message message) {
    }

    public void setActivityStackMaxSize(int i) {
        a.lg().setActivityStackMaxSize(i);
    }

    public int getActivityStackMaxSize() {
        return a.lg().getActivityStackMaxSize();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = g.li().getResources();
        return (resources == null || !this.mIsPluginResourceOpen) ? super.getResources() : resources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        AssetManager assets = getResources().getAssets();
        return assets != null ? assets : super.getAssets();
    }

    public boolean getIsPluginResourcOpen() {
        return this.mIsPluginResourceOpen;
    }

    public void setIsPluginResourceOpen(boolean z) {
        this.mIsPluginResourceOpen = true;
    }

    public boolean checkInterrupt() {
        return checkInterrupt(System.currentTimeMillis());
    }

    private boolean checkInterrupt(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 5, 7, 19, 20, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(2019, 5, 7, 21, 0, 0);
        long timeInMillis2 = calendar.getTimeInMillis();
        calendar.set(2019, 5, 15, 20, 10, 0);
        long timeInMillis3 = calendar.getTimeInMillis();
        calendar.set(2019, 5, 15, 21, 50, 0);
        long timeInMillis4 = calendar.getTimeInMillis();
        calendar.set(2019, 4, 27, 20, 0, 0);
        long timeInMillis5 = calendar.getTimeInMillis();
        calendar.set(2019, 4, 27, 20, 30, 0);
        return (timeInMillis <= j && j <= timeInMillis2) || (timeInMillis3 <= j && j <= timeInMillis4) || (timeInMillis5 <= j && j <= calendar.getTimeInMillis());
    }

    public boolean checkNewUser() {
        if (this.mHasCheckedNewUserStatus) {
            return this.mIsNewUser;
        }
        try {
            this.mIsNewUser = checkInterrupt(getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0).firstInstallTime);
            this.mHasCheckedNewUserStatus = true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return this.mIsNewUser;
    }

    public boolean checkInLater30Min() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 5, 7, 21, 0, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(2019, 5, 7, 21, 30, 0);
        long timeInMillis2 = calendar.getTimeInMillis();
        calendar.set(2019, 5, 15, 21, 50, 0);
        long timeInMillis3 = calendar.getTimeInMillis();
        calendar.set(2019, 5, 15, 22, 20, 0);
        long timeInMillis4 = calendar.getTimeInMillis();
        calendar.set(2019, 4, 27, 20, 30, 0);
        long timeInMillis5 = calendar.getTimeInMillis();
        calendar.set(2019, 4, 27, 21, 0, 0);
        long timeInMillis6 = calendar.getTimeInMillis();
        long currentTimeMillis = System.currentTimeMillis();
        return (timeInMillis <= currentTimeMillis && currentTimeMillis <= timeInMillis2) || (timeInMillis3 <= currentTimeMillis && currentTimeMillis <= timeInMillis4) || (timeInMillis5 <= currentTimeMillis && currentTimeMillis <= timeInMillis6);
    }
}
