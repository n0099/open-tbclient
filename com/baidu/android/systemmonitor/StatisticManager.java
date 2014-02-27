package com.baidu.android.systemmonitor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.a.j;
import com.baidu.android.a.l;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.util.Util;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.android.nebula.util.BDLocationManager;
import com.baidu.android.systemmonitor.devicestatistic.StatisticReceiver;
import com.baidu.android.systemmonitor.devicestatistic.i;
import com.baidu.android.systemmonitor.localapp.AppManager;
/* loaded from: classes.dex */
public final class StatisticManager implements NoProGuard {
    private static final boolean DEBUG = false;
    private static final int NETFLOW_DELAYTIME = 5000;
    private static final String TAG = "StatisticManager";
    private static StatisticManager mInstance = null;
    private static LocalServerSocket sLock = null;
    private Context mContext;
    private Handler mHandler;
    private StatisticReceiver mConnectReceiver = null;
    private long mStartStamp = 0;
    private long mStopStamp = 0;
    private Runnable mUploadRunnable = null;
    private Runnable mGetStoreInfoRunnable = null;
    private Runnable mNetFlowTjRunnable = null;
    private Runnable mRequestLocationRunnable = null;

    private StatisticManager(Context context) {
        this.mContext = null;
        this.mHandler = null;
        this.mContext = context.getApplicationContext();
        if (this.mHandler == null) {
            this.mHandler = new Handler(this.mContext.getMainLooper());
        }
        init();
    }

    public static synchronized void destroy() {
        synchronized (StatisticManager.class) {
            if (mInstance != null) {
                mInstance.release();
                mInstance = null;
            }
            if (sLock != null) {
                try {
                    sLock.close();
                } catch (Exception e) {
                    Log.d(TAG, "--- Release lock fail!");
                }
            }
        }
    }

    public static synchronized StatisticManager getInstance(Context context) {
        StatisticManager statisticManager;
        synchronized (StatisticManager.class) {
            if (mInstance == null) {
                mInstance = new StatisticManager(context);
            }
            statisticManager = mInstance;
        }
        return statisticManager;
    }

    public static synchronized LocalServerSocket getLock(Context context) {
        LocalServerSocket localServerSocket;
        synchronized (StatisticManager.class) {
            if (sLock != null) {
                localServerSocket = sLock;
            } else {
                try {
                    sLock = new LocalServerSocket(Util.toMd5(("Statistic_" + ((int) com.baidu.android.systemmonitor.c.b.a)).getBytes(), DEBUG));
                } catch (Exception e) {
                }
                localServerSocket = sLock;
            }
        }
        return localServerSocket;
    }

    public static int getPriority(Context context) {
        int m = ((((com.baidu.android.systemmonitor.c.b.a << 1) + com.baidu.android.systemmonitor.c.d.m(context)) << 1) + com.baidu.android.systemmonitor.c.d.t(context)) << 1;
        return ((((((com.baidu.android.systemmonitor.c.d.n(context) == 1 ? (((m + 1) << 1) + com.baidu.android.systemmonitor.c.d.o(context)) << 1 : m << 2) + com.baidu.android.systemmonitor.c.d.q(context)) << 1) + com.baidu.android.systemmonitor.c.d.s(context)) << 1) + com.baidu.android.systemmonitor.c.d.r(context)) << 1;
    }

    public static short getVersion(Context context) {
        return com.baidu.android.systemmonitor.c.b.a;
    }

    private void handleBootCompletedAction() {
        if (j.a(this.mContext).a()) {
            if (com.baidu.android.systemmonitor.c.d.t(this.mContext) == 1) {
                this.mStartStamp = com.baidu.android.systemmonitor.c.b.a(this.mContext, true);
                this.mStopStamp = com.baidu.android.systemmonitor.c.b.a(this.mContext, (boolean) DEBUG);
                com.baidu.android.systemmonitor.c.b.a(this.mContext, System.currentTimeMillis(), true);
                com.baidu.android.systemmonitor.c.b.a(this.mContext, 0L, DEBUG);
                if (this.mStartStamp != 0 && this.mStopStamp != 0 && this.mStartStamp < this.mStopStamp) {
                    com.baidu.android.systemmonitor.devicestatistic.a.c cVar = new com.baidu.android.systemmonitor.devicestatistic.a.c(this.mStartStamp);
                    cVar.a = this.mStopStamp;
                    com.baidu.android.systemmonitor.devicestatistic.d.a(this.mContext).a(cVar);
                }
            }
            this.mHandler.postDelayed(this.mGetStoreInfoRunnable, 5000L);
        }
    }

    private void handleConnectionChangeAction() {
        if (j.a(this.mContext).a()) {
            this.mHandler.postDelayed(this.mGetStoreInfoRunnable, 5000L);
            this.mHandler.removeCallbacks(this.mNetFlowTjRunnable);
            this.mHandler.postDelayed(this.mNetFlowTjRunnable, 5000L);
        }
        this.mHandler.removeCallbacks(this.mUploadRunnable);
        this.mHandler.postDelayed(this.mUploadRunnable, 5000L);
        if (com.baidu.android.systemmonitor.c.d.n(this.mContext) == 1) {
            this.mHandler.removeCallbacks(this.mRequestLocationRunnable);
            this.mHandler.postDelayed(this.mRequestLocationRunnable, 5000L);
        }
    }

    private void handleGetStoreinfoAction() {
        if (j.a(this.mContext).a()) {
            this.mHandler.postDelayed(this.mGetStoreInfoRunnable, 5000L);
        } else if (this.mHandler == null || this.mGetStoreInfoRunnable == null) {
        } else {
            this.mHandler.removeCallbacks(this.mGetStoreInfoRunnable);
        }
    }

    public static void handleOnStart(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        getInstance(context).handleAction(intent.getAction());
    }

    private void handlePowerConnectAction(boolean z) {
        if (j.a(this.mContext).a()) {
            if (z) {
                com.baidu.android.systemmonitor.devicestatistic.f.a(this.mContext).a();
            } else {
                com.baidu.android.systemmonitor.devicestatistic.f.a(this.mContext).b();
            }
        }
    }

    private void init() {
        this.mNetFlowTjRunnable = new a(this);
        this.mRequestLocationRunnable = new b(this);
        this.mGetStoreInfoRunnable = new c(this);
        this.mUploadRunnable = new d(this);
        this.mConnectReceiver = new StatisticReceiver();
        registerStatisticReceivers();
        if (com.baidu.android.systemmonitor.c.d.p(this.mContext) == 1 && j.a(this.mContext).a()) {
            com.baidu.android.systemmonitor.freqstatistic.c.a(this.mContext);
        }
        com.baidu.android.systemmonitor.devicestatistic.a.a(this.mContext).b();
        this.mHandler.postDelayed(new e(this), 300000L);
    }

    public static boolean isActive() {
        if (sLock != null) {
            return true;
        }
        return DEBUG;
    }

    private void registerStatisticReceivers() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.ACTION_SHUTDOWN");
        intentFilter2.addAction("com.baidu.systemmonitor.getstoreinfo");
        if (this.mConnectReceiver != null) {
            this.mContext.registerReceiver(this.mConnectReceiver, intentFilter);
            this.mContext.registerReceiver(this.mConnectReceiver, intentFilter2);
        }
    }

    private void release() {
        unregisterStatisticReceivers();
        AppManager.c();
        com.baidu.android.systemmonitor.freqstatistic.e.a();
        com.baidu.android.systemmonitor.devicestatistic.d.b();
        BDLocationManager.a();
        i.c();
        com.baidu.android.systemmonitor.devicestatistic.f.f();
        com.baidu.android.systemmonitor.a.a.g();
        j.k();
        l.b();
        com.baidu.android.a.i.c();
        com.baidu.android.systemmonitor.freqstatistic.c.d();
        com.baidu.android.systemmonitor.devicestatistic.a.a();
        com.baidu.android.defense.push.d.e();
    }

    private void unregisterStatisticReceivers() {
        if (this.mConnectReceiver != null) {
            this.mContext.unregisterReceiver(this.mConnectReceiver);
        }
    }

    public final void handleAction(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("android.intent.action.BOOT_COMPLETED".equals(str)) {
            handleBootCompletedAction();
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str)) {
            handleConnectionChangeAction();
        } else if ("android.intent.action.ACTION_POWER_CONNECTED".equals(str)) {
            handlePowerConnectAction(true);
        } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(str)) {
            handlePowerConnectAction(DEBUG);
        } else if ("com.baidu.systemmonitor.getstoreinfo".equals(str)) {
            handleGetStoreinfoAction();
        }
    }
}
