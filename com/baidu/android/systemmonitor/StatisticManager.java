package com.baidu.android.systemmonitor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.a.r;
import com.baidu.android.a.s;
import com.baidu.android.a.t;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.android.systemmonitor.devicestatistic.StatisticReceiver;
import com.baidu.android.systemmonitor.devicestatistic.g;
import com.baidu.android.systemmonitor.devicestatistic.h;
import com.baidu.android.systemmonitor.devicestatistic.j;
import com.baidu.android.systemmonitor.localapp.AppManager;
import com.baidu.tbadk.TbConfig;
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
                    sLock = new LocalServerSocket(com.baidu.android.nebula.a.f.a(("Statistic_" + ((int) com.baidu.android.systemmonitor.util.e.a)).getBytes(), false));
                } catch (Exception e) {
                }
                localServerSocket = sLock;
            }
        }
        return localServerSocket;
    }

    public static int getPriority(Context context) {
        int m = ((((com.baidu.android.systemmonitor.util.e.a << 1) + com.baidu.android.systemmonitor.util.b.m(context)) << 1) + com.baidu.android.systemmonitor.util.b.t(context)) << 1;
        return ((((((com.baidu.android.systemmonitor.util.b.n(context) == 1 ? (((m + 1) << 1) + com.baidu.android.systemmonitor.util.b.o(context)) << 1 : m << 2) + com.baidu.android.systemmonitor.util.b.q(context)) << 1) + com.baidu.android.systemmonitor.util.b.s(context)) << 1) + com.baidu.android.systemmonitor.util.b.r(context)) << 1;
    }

    public static short getVersion(Context context) {
        return com.baidu.android.systemmonitor.util.e.a;
    }

    private void handleBootCompletedAction() {
        if (s.a(this.mContext).a()) {
            if (com.baidu.android.systemmonitor.util.b.t(this.mContext) == 1) {
                this.mStartStamp = com.baidu.android.systemmonitor.util.e.a(this.mContext, true);
                this.mStopStamp = com.baidu.android.systemmonitor.util.e.a(this.mContext, false);
                com.baidu.android.systemmonitor.util.e.a(this.mContext, System.currentTimeMillis(), true);
                com.baidu.android.systemmonitor.util.e.a(this.mContext, 0L, false);
                if (this.mStartStamp != 0 && this.mStopStamp != 0 && this.mStartStamp < this.mStopStamp) {
                    com.baidu.android.systemmonitor.devicestatistic.a.b bVar = new com.baidu.android.systemmonitor.devicestatistic.a.b(this.mStartStamp);
                    bVar.a = this.mStopStamp;
                    g.a(this.mContext).a(bVar);
                }
            }
            this.mHandler.postDelayed(this.mGetStoreInfoRunnable, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    private void handleConnectionChangeAction() {
        if (s.a(this.mContext).a()) {
            this.mHandler.postDelayed(this.mGetStoreInfoRunnable, TbConfig.NOTIFY_SOUND_INTERVAL);
            this.mHandler.removeCallbacks(this.mNetFlowTjRunnable);
            this.mHandler.postDelayed(this.mNetFlowTjRunnable, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
        this.mHandler.removeCallbacks(this.mUploadRunnable);
        this.mHandler.postDelayed(this.mUploadRunnable, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (com.baidu.android.systemmonitor.util.b.n(this.mContext) == 1) {
            this.mHandler.removeCallbacks(this.mRequestLocationRunnable);
            this.mHandler.postDelayed(this.mRequestLocationRunnable, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    private void handleGetStoreinfoAction() {
        if (s.a(this.mContext).a()) {
            this.mHandler.postDelayed(this.mGetStoreInfoRunnable, TbConfig.NOTIFY_SOUND_INTERVAL);
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
        if (s.a(this.mContext).a()) {
            if (z) {
                h.a(this.mContext).a();
            } else {
                h.a(this.mContext).b();
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
        if (com.baidu.android.systemmonitor.util.b.p(this.mContext) == 1 && s.a(this.mContext).a()) {
            com.baidu.android.systemmonitor.freqstatistic.b.a(this.mContext);
        }
        com.baidu.android.systemmonitor.devicestatistic.e.a(this.mContext).b();
        this.mHandler.postDelayed(new e(this), 300000L);
    }

    public static boolean isActive() {
        return sLock != null;
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
        com.baidu.android.systemmonitor.freqstatistic.c.a();
        g.b();
        com.baidu.android.nebula.a.e.a();
        j.c();
        h.f();
        com.baidu.android.systemmonitor.a.a.g();
        s.n();
        t.b();
        r.c();
        com.baidu.android.systemmonitor.freqstatistic.b.c();
        com.baidu.android.systemmonitor.devicestatistic.e.a();
        com.baidu.android.defense.push.j.d();
    }

    private void unregisterStatisticReceivers() {
        if (this.mConnectReceiver != null) {
            this.mContext.unregisterReceiver(this.mConnectReceiver);
        }
    }

    public void handleAction(String str) {
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
            handlePowerConnectAction(false);
        } else if ("com.baidu.systemmonitor.getstoreinfo".equals(str)) {
            handleGetStoreinfoAction();
        }
    }
}
