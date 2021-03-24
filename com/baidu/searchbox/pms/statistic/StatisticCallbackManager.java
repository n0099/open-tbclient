package com.baidu.searchbox.pms.statistic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.baidu.searchbox.pms.IPmsContext;
import com.baidu.searchbox.pms.PmsRuntime;
/* loaded from: classes3.dex */
public class StatisticCallbackManager {
    public static volatile ApplicationInfo sAppInfo;
    public static StatisticCallbackManager sInstance;
    public Context mAppContext;
    public StatisticCallback mStatisticCallback;

    public StatisticCallbackManager(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public static synchronized StatisticCallbackManager getInstance(Context context) {
        StatisticCallbackManager statisticCallbackManager;
        synchronized (StatisticCallbackManager.class) {
            if (sInstance == null) {
                sInstance = new StatisticCallbackManager(context);
            }
            statisticCallbackManager = sInstance;
        }
        return statisticCallbackManager;
    }

    public synchronized StatisticCallback getStatisticCallback() {
        IPmsContext pmsContext;
        if (this.mStatisticCallback == null && (pmsContext = PmsRuntime.getPmsContext()) != null) {
            this.mStatisticCallback = pmsContext.getStatisticCallback();
        }
        if (this.mStatisticCallback == null) {
            this.mStatisticCallback = new StatisticCallbackImpl();
        }
        return this.mStatisticCallback;
    }
}
