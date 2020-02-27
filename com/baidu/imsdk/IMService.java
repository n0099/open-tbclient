package com.baidu.imsdk;

import android.app.Service;
import android.content.Context;
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
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class IMService extends Service {
    private static final int SERVICE_STOPPED_DELAY = 1000;
    private static final String TAG = "IMService";
    public static Handler mHandler;
    public static volatile boolean isSmallFlow = false;
    private static volatile Map<Long, Message> msgList = new LinkedHashMap();
    public boolean registerLcp = false;
    private Runnable mDestroyRunnable = new Runnable() { // from class: com.baidu.imsdk.IMService.1
        @Override // java.lang.Runnable
        public void run() {
            LogUtils.d(IMService.TAG, "call stopSelf");
            IMService.this.stopSelf();
        }
    };

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler(getMainLooper());
        isSmallFlow = false;
        initService();
    }

    private void initService() {
        try {
            LogUtils.d(TAG, "onCreate from : " + getPackageName() + ", isSmallFlow :" + isSmallFlow);
            IMManager.init(getApplicationContext(), IMConfigInternal.getInstance().getProductLine(getApplicationContext()));
            if (isSmallFlow) {
                registerLcpNotify();
            } else if (!IMSDK.getInstance(getApplicationContext()).init()) {
                stopSelf(true);
            }
        } catch (Exception e) {
        }
    }

    private void registerLcpNotify() {
        for (int i : new int[]{96, 196}) {
            registerNotify(2, Integer.valueOf(i).intValue());
        }
        registerNotify(3, 196);
        this.registerLcp = true;
    }

    private void registerNotify(int i, int i2) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (!isSmallFlow) {
            IMSDK.getInstance(getApplicationContext()).destory(false, null);
        }
        this.registerLcp = false;
    }

    @Override // android.app.Service
    public synchronized int onStartCommand(Intent intent, int i, int i2) {
        LogUtils.d(TAG, "-- onStartCommand -- " + intent + ", isSmallFlow :" + isSmallFlow);
        if (intent == null) {
            intent = new Intent();
            LogUtils.i(TAG, "--- onStart by null intent!");
        }
        try {
            mHandler.removeCallbacks(this.mDestroyRunnable);
            if (!IMSDK.getInstance(getApplicationContext()).handleOnStart(intent)) {
                stopSelf(false);
            }
        } catch (Exception e) {
            LogUtils.e(LogUtils.TAG, "onStartCommand", e);
            if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                if (removeListener instanceof ILoginListener) {
                    ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(this));
                }
            } else if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
        }
        return 2;
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
        } else {
            mHandler.removeCallbacks(this.mDestroyRunnable);
            mHandler.postDelayed(this.mDestroyRunnable, 1000L);
        }
        this.registerLcp = false;
    }

    public static void clearMsgListByLcp(Context context) {
        synchronized (msgList) {
            if (msgList != null) {
                for (Message message : msgList.values()) {
                    if (message != null) {
                        message.handleMessageResult(context, null, -1, "");
                    }
                }
            }
        }
    }
}
