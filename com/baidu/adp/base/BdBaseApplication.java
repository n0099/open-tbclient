package com.baidu.adp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.nps.NPSHookManager;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.a.c.a.b;
import d.a.c.a.h;
import d.a.c.e.p.d;
import d.a.c.g.c;
import java.util.Calendar;
/* loaded from: classes.dex */
public class BdBaseApplication extends Application {
    public static final int RESOURCE_LOAD_MAX_TRY_COUNT = 3;
    public static BdBaseApplication instance;
    public static BdBaseApplication sApp;
    public Handler mAppInitHandler;
    public boolean mHasCheckedNewUserStatus;
    public boolean mIsNewUser;
    public boolean mIsSmallFlow;
    public long mSmallFlowInterval;
    public long mStartSmallFlowTime;
    public boolean mIsDebugMode = false;
    public Application mContext = null;
    public boolean mIsPluginResourceOpen = true;
    public long lastGcTime = 0;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BdBaseApplication.this.handleInitMessage(message);
        }
    }

    public BdBaseApplication() {
        sApp = this;
    }

    public static BdBaseApplication getInst() {
        return sApp;
    }

    private void initBdBaseApp(Application application) {
        this.mContext = application;
        initWorkMode();
        initBitmapHelper();
        initPlugin();
    }

    private void initBitmapHelper() {
        d.d().f(this.mContext);
    }

    private void initPlugin() {
        d.a.c.h.i.a.d().e();
    }

    private void initWorkMode() {
        if ((this.mContext.getApplicationInfo().flags & 2) == 0) {
            this.mIsDebugMode = false;
        } else {
            this.mIsDebugMode = true;
        }
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        NPSHookManager.init(this);
        c.d().h(this);
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

    public boolean checkInterrupt() {
        return checkInterrupt(System.currentTimeMillis());
    }

    public boolean checkNewUser() {
        if (this.mHasCheckedNewUserStatus) {
            return this.mIsNewUser;
        }
        try {
            this.mIsNewUser = checkInterrupt(getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0).firstInstallTime);
            this.mHasCheckedNewUserStatus = true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        return this.mIsNewUser;
    }

    public int getActivityStackMaxSize() {
        return b.f().d();
    }

    public Application getApp() {
        return this.mContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        AssetManager assets = getResources().getAssets();
        return assets != null ? assets : super.getAssets();
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean getIsPluginResourcOpen() {
        return this.mIsPluginResourceOpen;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources b2 = h.a().b();
        return (b2 == null || !this.mIsPluginResourceOpen) ? super.getResources() : b2;
    }

    public long getSmallFlowInterval() {
        return this.mSmallFlowInterval;
    }

    public long getStartSmallFlowTime() {
        return this.mStartSmallFlowTime;
    }

    public void handleInitMessage(Message message) {
    }

    public boolean isDebugMode() {
        return this.mIsDebugMode;
    }

    public boolean isSmallFlow() {
        if (!this.mIsSmallFlow || (System.currentTimeMillis() - this.mStartSmallFlowTime) / 1000 <= this.mSmallFlowInterval) {
            return this.mIsSmallFlow;
        }
        return false;
    }

    public void onAppMemoryLow() {
        b.f().p();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastGcTime > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
            this.lastGcTime = currentTimeMillis;
            System.gc();
        }
    }

    public void onCreate(Application application) {
        this.mAppInitHandler = new a(Looper.getMainLooper());
        h.a().d(super.getResources());
        initBdBaseApp(application);
        super.onCreate();
    }

    public void setActivityStackMaxSize(int i2) {
        b.f().q(i2);
    }

    public void setDebugMode(boolean z) {
        this.mIsDebugMode = z;
    }

    public void setIsPluginResourceOpen(boolean z) {
        this.mIsPluginResourceOpen = true;
    }

    public void setIsSmallFlow(boolean z) {
        this.mIsSmallFlow = z;
    }

    public void setSmallFlowInterval(long j) {
        this.mSmallFlowInterval = j;
    }

    public void setStartSmallFlowTime(long j) {
        this.mStartSmallFlowTime = j;
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
}
