package com.baidu.imsdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.IMManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes2.dex */
public class IMService extends Service {
    private static final int SERVICE_STOPPED_DELAY = 1000;
    private static final String TAG = "IMService";
    private Handler mHandler = new Handler();
    private Runnable mDestroyRunnable = new Runnable() { // from class: com.baidu.imsdk.IMService.1
        @Override // java.lang.Runnable
        public void run() {
            LogUtils.d(IMService.TAG, "call stopSelf");
            IMService.this.stopSelf();
        }
    };

    @Override // android.app.Service
    public void onCreate() {
        try {
            super.onCreate();
            LogUtils.d(TAG, "onCreate from : " + getPackageName());
            boolean init = IMSDK.getInstance(getApplicationContext()).init();
            IMManager.init(getApplicationContext(), IMConfigInternal.getInstance().getProductLine(getApplicationContext()));
            LogUtils.i(TAG, "init IMSDK: " + init);
            if (!init) {
                stopSelf(true);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        IMSDK.getInstance(getApplicationContext()).destory(false, null);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            LogUtils.d(TAG, "-- onStartCommand -- " + intent);
            if (intent == null) {
                Intent intent2 = new Intent();
                try {
                    LogUtils.i(TAG, "--- onStart by null intent!");
                    intent = intent2;
                } catch (Exception e) {
                    e = e;
                    intent = intent2;
                    LogUtils.e(LogUtils.TAG, "onStartCommand", e);
                    if (intent != null && intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                        IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                        if (removeListener != null && (removeListener instanceof ILoginListener)) {
                            ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(this));
                            return 2;
                        }
                        return 2;
                    } else if (intent != null && intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                        ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                        return 2;
                    } else {
                        return 2;
                    }
                }
            }
            this.mHandler.removeCallbacks(this.mDestroyRunnable);
            if (!IMSDK.getInstance(getApplicationContext()).handleOnStart(intent)) {
                stopSelf(false);
                return 2;
            }
            return 2;
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void stopSelf(boolean z) {
        LogUtils.d(TAG, "stopSelf : --- immediate=" + z);
        if (z) {
            LogUtils.d(TAG, "call stopSelf");
            stopSelf();
            return;
        }
        this.mHandler.removeCallbacks(this.mDestroyRunnable);
        this.mHandler.postDelayed(this.mDestroyRunnable, 1000L);
    }
}
