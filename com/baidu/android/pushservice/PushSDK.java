package com.baidu.android.pushservice;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.pushservice.util.NoProGuard;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PushSDK implements NoProGuard {
    public static final String LOCAL_SOCKET_ADDRESS = "com.baidu.pushservice.singelinstance";
    private static Context mContext;
    private static Handler mHandler;
    private static LocalServerSocket mLocalSocket;
    public static e mPushConnection;
    private x mRegistrationService;
    private static String TAG = "PushSDK";
    private static PushSDK mPushSDK = null;
    private static int ALARM_TIMEOUT = 600000;
    private static Object mPushConnLock = new Object();
    private Boolean mIsAlive = false;
    private final BroadcastReceiver mScreenOnReceiver = new j(this);
    private Runnable mStartRunnable = new k(this);
    private Runnable mRegisterRunnable = new l(this);
    private Runnable mConnectRunnable = new m(this);

    private PushSDK(Context context) {
        mHandler = new Handler();
        mContext = context.getApplicationContext();
        PushSettings.f294a = context.getApplicationContext();
    }

    private void cancelAlarmRepeat() {
        Intent intent = new Intent();
        intent.putExtra("AlarmAlert", "OK");
        intent.setClass(mContext, PushService.class);
        ((AlarmManager) mContext.getSystemService("alarm")).cancel(PendingIntent.getService(mContext, 0, intent, 268435456));
    }

    public static void destory() {
        if (mPushSDK != null) {
            mPushSDK.doDestory();
        }
    }

    private void doDestory() {
        if (b.a()) {
            Log.d(TAG, "destory");
        }
        synchronized (this.mIsAlive) {
            try {
                if (mLocalSocket != null) {
                    mLocalSocket.close();
                    mLocalSocket = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (mPushConnection != null) {
                synchronized (mPushConnLock) {
                    mPushConnection.c();
                    mPushConnection = null;
                }
            }
            try {
                mContext.unregisterReceiver(this.mScreenOnReceiver);
            } catch (IllegalArgumentException e2) {
                if (b.a()) {
                    Log.i(TAG, e2.getMessage());
                }
            }
            com.baidu.android.pushservice.util.e.a();
            this.mIsAlive = false;
            mPushSDK = null;
        }
    }

    public static synchronized PushSDK getInstantce(Context context) {
        PushSDK pushSDK;
        synchronized (PushSDK.class) {
            if (mPushSDK == null) {
                mPushSDK = new PushSDK(context);
            }
            pushSDK = mPushSDK;
        }
        return pushSDK;
    }

    public static boolean isAlive() {
        if (mPushSDK != null) {
            return mPushSDK.mIsAlive.booleanValue();
        }
        return false;
    }

    private void newPushConnection() {
        synchronized (mPushConnLock) {
            mPushConnection = e.a(mContext);
        }
    }

    private void scheduleConnect() {
        mHandler.removeCallbacks(this.mConnectRunnable);
        mHandler.postDelayed(this.mConnectRunnable, 1000L);
    }

    private void scheduleRegister() {
        mHandler.removeCallbacks(this.mRegisterRunnable);
        mHandler.postDelayed(this.mRegisterRunnable, 500L);
    }

    private void setAlarmRepeat() {
        cancelAlarmRepeat();
        Intent intent = new Intent();
        intent.putExtra("AlarmAlert", "OK");
        intent.setClass(mContext, PushService.class);
        PendingIntent service = PendingIntent.getService(mContext.getApplicationContext(), 0, intent, 268435456);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService("alarm");
        alarmManager.cancel(service);
        alarmManager.setRepeating(0, elapsedRealtime, ALARM_TIMEOUT, service);
    }

    private boolean shouldReConnect(Context context) {
        SharedPreferences sharedPreferences;
        if (com.baidu.android.pushservice.util.n.n(context.getApplicationContext()).size() <= 1) {
            if (b.a()) {
                Log.i(TAG, "Only one push app : " + context.getPackageName());
            }
            return false;
        }
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(1000);
        ArrayList arrayList = new ArrayList();
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            if (PushService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                arrayList.add(runningServiceInfo.service.getPackageName());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!context.getPackageName().equals(str)) {
                try {
                    sharedPreferences = context.createPackageContext(str, 2).getSharedPreferences(str + ".push_sync", 1);
                } catch (PackageManager.NameNotFoundException e) {
                    if (b.a()) {
                        Log.e(TAG, e.getMessage());
                    }
                    sharedPreferences = null;
                }
                if (sharedPreferences == null) {
                    if (b.a()) {
                        Log.w(TAG, "App:" + str + " doesn't init Version!");
                    }
                } else if (sharedPreferences.getInt("version2", 0) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean shouldStopSelf(Context context) {
        boolean z;
        SharedPreferences sharedPreferences;
        List n = com.baidu.android.pushservice.util.n.n(context.getApplicationContext());
        if (n.size() <= 1) {
            if (b.a()) {
                Log.i(TAG, "Only one push app : " + context.getPackageName());
                return false;
            }
            return false;
        }
        long j = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1).getLong("priority2", 0L);
        Iterator it = n.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            String str = ((ResolveInfo) it.next()).activityInfo.packageName;
            if (!context.getPackageName().equals(str)) {
                try {
                    sharedPreferences = context.createPackageContext(str, 2).getSharedPreferences(str + ".push_sync", 1);
                } catch (PackageManager.NameNotFoundException e) {
                    if (b.a()) {
                        Log.e(TAG, e.getMessage());
                    }
                    sharedPreferences = null;
                }
                if (sharedPreferences != null) {
                    long j2 = sharedPreferences.getLong("priority2", 0L);
                    if (j2 > j) {
                        if (b.a()) {
                            Log.d(TAG, "shouldStopSelf-------localPriority = " + j + ";  other packageName = " + str + "--priority =" + j2);
                        }
                        z = true;
                    }
                } else if (b.a()) {
                    Log.w(TAG, "App:" + str + " doesn't init Version!");
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryConnect() {
        if (b.a() && mPushConnection != null) {
            Log.i(TAG, "tryConnect mPushConnection.isConnected() :" + mPushConnection.a());
        }
        boolean isNetworkConnected = ConnectManager.isNetworkConnected(mContext);
        if (b.a()) {
            Log.i(TAG, "tryConnect networkConnected :" + isNetworkConnected);
        }
        if (isNetworkConnected && mPushConnection != null) {
            if (!mPushConnection.a()) {
                if (y.a().d()) {
                    scheduleConnect();
                } else {
                    if (b.a()) {
                        Log.i(TAG, "host is not available, start NETWORK REGISTER SERVICE .");
                    }
                    scheduleRegister();
                }
            }
            return true;
        }
        return false;
    }

    public boolean handleOnStart(Intent intent) {
        if (b.a()) {
            Log.d(TAG, "handleOnStart intent action = " + (intent != null ? intent.getAction() : ""));
        }
        synchronized (this.mIsAlive) {
            if (this.mIsAlive.booleanValue()) {
                mHandler.removeCallbacks(this.mStartRunnable);
                if (b.a()) {
                    Log.i(TAG, "-- handleOnStart -- " + intent);
                }
                if (mLocalSocket == null) {
                    return false;
                }
                if (intent == null || !"com.baidu.pushservice.action.STOP".equals(intent.getAction())) {
                    if (intent != null) {
                        if ("pushservice_restart".equals(intent.getStringExtra(PushConstants.EXTRA_METHOD))) {
                            com.baidu.android.pushservice.util.n.a(mContext, 1000L);
                            return false;
                        } else if (this.mRegistrationService.a(intent)) {
                            if (b.a()) {
                                Log.i(TAG, "-- handleOnStart -- intent handled  by mRegistrationService ");
                            }
                            return true;
                        }
                    }
                    return tryConnect();
                }
                return false;
            }
            return false;
        }
    }

    public boolean initPushSDK() {
        if (b.a()) {
            Log.d(TAG, "Create PushSDK from : " + mContext.getPackageName());
        }
        com.baidu.android.pushservice.util.n.f(mContext.getApplicationContext());
        mContext.getApplicationContext().registerReceiver(this.mScreenOnReceiver, new IntentFilter("android.intent.action.SCREEN_ON"));
        if (com.baidu.android.pushservice.util.n.c(mContext.getApplicationContext()) || shouldStopSelf(mContext)) {
            if (b.a()) {
                Log.d(TAG, "onCreate shouldStopSelf");
                return false;
            }
            return false;
        }
        synchronized (this.mIsAlive) {
            if (mLocalSocket == null) {
                try {
                    mLocalSocket = new LocalServerSocket(com.baidu.android.pushservice.util.n.p(mContext));
                } catch (Exception e) {
                    if (b.a()) {
                        Log.d(TAG, "--- Socket Adress (" + com.baidu.android.pushservice.util.n.p(mContext) + ") in use --- @ " + mContext.getPackageName());
                    }
                }
            }
            if (mLocalSocket == null) {
                return false;
            }
            newPushConnection();
            this.mRegistrationService = new x(mContext);
            setAlarmRepeat();
            mHandler.postDelayed(this.mStartRunnable, 500L);
            this.mIsAlive = true;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendRequestTokenIntent() {
        if (b.a()) {
            Log.d(TAG, ">> sendRequestTokenIntent");
        }
        b.a(mContext, new Intent("com.baidu.pushservice.action.TOKEN"));
    }
}
