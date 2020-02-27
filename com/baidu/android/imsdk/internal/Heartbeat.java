package com.baidu.android.imsdk.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.imsdk.IMService;
/* loaded from: classes3.dex */
public class Heartbeat {
    public static int ALARM_TIMEOUT = 60000;
    public static final int HEARTBEAT_TYPE_NORMAL = 0;
    public static final int HEARTBEAT_TYPE_NO_ALAMRMANAGER = 1;
    private static Heartbeat mInstance;
    private Context mContext;
    private Handler mHandler;
    private HeartbeatOpearation mOperator;

    private Heartbeat(Context context, Handler handler) {
        ALARM_TIMEOUT = 60000;
        this.mHandler = handler;
        this.mContext = context;
        switch (IMConfigInternal.getInstance().getIMConfig(context).getHeartBeatType()) {
            case 0:
                this.mOperator = new NormalHeartbeat();
                return;
            case 1:
                this.mOperator = new BoxHeartbeat();
                return;
            default:
                this.mOperator = new NormalHeartbeat();
                return;
        }
    }

    public static Heartbeat getInstance(Context context, Handler handler) {
        Heartbeat heartbeat;
        synchronized (Heartbeat.class) {
            if (mInstance == null) {
                mInstance = new Heartbeat(context, handler);
            }
            heartbeat = mInstance;
        }
        return heartbeat;
    }

    public void startHeartbeat() {
        this.mOperator.startHeartbeat();
    }

    public void cancelHearbeat() {
        this.mOperator.cancelHearbeat();
    }

    /* loaded from: classes3.dex */
    public class BoxHeartbeat implements HeartbeatOpearation {
        private Runnable startIMServiceTask = new Runnable() { // from class: com.baidu.android.imsdk.internal.Heartbeat.BoxHeartbeat.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TaskManager.getInstance(Heartbeat.this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.internal.Heartbeat.BoxHeartbeat.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Intent intent = new Intent(Heartbeat.this.mContext, IMService.class);
                            intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                            intent.setPackage(Heartbeat.this.mContext.getPackageName());
                            Heartbeat.this.mContext.startService(intent);
                            Heartbeat.this.mHandler.postDelayed(BoxHeartbeat.this.startIMServiceTask, Heartbeat.ALARM_TIMEOUT);
                        }
                    });
                } catch (Exception e) {
                    if (e instanceof SecurityException) {
                        LogUtils.e("BoxHeartbeat", "box SecurityException!!", e);
                    }
                }
            }
        };

        public BoxHeartbeat() {
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void startHeartbeat() {
            try {
                Heartbeat.this.mHandler.removeCallbacks(this.startIMServiceTask);
                Heartbeat.this.mHandler.postDelayed(this.startIMServiceTask, Heartbeat.ALARM_TIMEOUT);
            } catch (Exception e) {
                LogUtils.e("Heartbeat", e.getMessage());
            }
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void cancelHearbeat() {
            try {
                Heartbeat.this.mHandler.removeCallbacks(this.startIMServiceTask);
            } catch (Exception e) {
                LogUtils.e("Heartbeat", e.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class NormalHeartbeat implements HeartbeatOpearation {
        public NormalHeartbeat() {
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void startHeartbeat() {
            cancelHearbeat();
            Intent intent = new Intent();
            intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
            intent.setClass(Heartbeat.this.mContext, IMService.class);
            intent.setAction(Constants.ACTION_SERVICE);
            PendingIntent service = PendingIntent.getService(Heartbeat.this.mContext.getApplicationContext(), 0, intent, 268435456);
            ((AlarmManager) Heartbeat.this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, System.currentTimeMillis() + Heartbeat.ALARM_TIMEOUT, Heartbeat.ALARM_TIMEOUT, service);
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void cancelHearbeat() {
            Intent intent = new Intent();
            intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
            intent.setClass(Heartbeat.this.mContext, IMService.class);
            intent.setAction(Constants.ACTION_SERVICE);
            ((AlarmManager) Heartbeat.this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getService(Heartbeat.this.mContext, 0, intent, 268435456));
        }
    }
}
