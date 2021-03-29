package com.baidu.android.imsdk.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import d.b.r.a;
/* loaded from: classes.dex */
public class Heartbeat {
    public static int ALARM_TIMEOUT = 60000;
    public static final int HEARTBEAT_TYPE_NORMAL = 0;
    public static final int HEARTBEAT_TYPE_NO_ALAMRMANAGER = 1;
    public static Heartbeat mInstance;
    public Context mContext;
    public Handler mHandler;
    public HeartbeatOpearation mOperator;

    /* loaded from: classes.dex */
    public class BoxHeartbeat implements HeartbeatOpearation {
        public Runnable startIMServiceTask = new Runnable() { // from class: com.baidu.android.imsdk.internal.Heartbeat.BoxHeartbeat.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TaskManager.getInstance(Heartbeat.this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.internal.Heartbeat.BoxHeartbeat.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Intent intent = new Intent(Heartbeat.this.mContext, a.class);
                            intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                            intent.setPackage(Heartbeat.this.mContext.getPackageName());
                            a.e(Heartbeat.this.mContext).d(Heartbeat.this.mContext, intent);
                            Heartbeat.this.mHandler.postDelayed(BoxHeartbeat.this.startIMServiceTask, Heartbeat.ALARM_TIMEOUT);
                        }
                    });
                } catch (Exception e2) {
                    if (e2 instanceof SecurityException) {
                        LogUtils.e("BoxHeartbeat", "box SecurityException!!", e2);
                    }
                }
            }
        };

        public BoxHeartbeat() {
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void cancelHearbeat() {
            try {
                Heartbeat.this.mHandler.removeCallbacks(this.startIMServiceTask);
            } catch (Exception e2) {
                LogUtils.e("Heartbeat", e2.getMessage());
            }
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void startHeartbeat() {
            try {
                Heartbeat.this.mHandler.removeCallbacks(this.startIMServiceTask);
                Heartbeat.this.mHandler.postDelayed(this.startIMServiceTask, Heartbeat.ALARM_TIMEOUT);
            } catch (Exception e2) {
                LogUtils.e("Heartbeat", e2.getMessage());
            }
        }
    }

    /* loaded from: classes.dex */
    public class NormalHeartbeat implements HeartbeatOpearation {
        public NormalHeartbeat() {
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void cancelHearbeat() {
            Intent intent = new Intent();
            intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
            intent.setClass(Heartbeat.this.mContext, a.class);
            intent.setAction(Constants.ACTION_SERVICE);
            ((AlarmManager) Heartbeat.this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getService(Heartbeat.this.mContext, 0, intent, 268435456));
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void startHeartbeat() {
            cancelHearbeat();
            Intent intent = new Intent();
            intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
            intent.setClass(Heartbeat.this.mContext, a.class);
            intent.setAction(Constants.ACTION_SERVICE);
            PendingIntent service = PendingIntent.getService(Heartbeat.this.mContext.getApplicationContext(), 0, intent, 268435456);
            ((AlarmManager) Heartbeat.this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, System.currentTimeMillis() + Heartbeat.ALARM_TIMEOUT, Heartbeat.ALARM_TIMEOUT, service);
        }
    }

    public Heartbeat(Context context, Handler handler) {
        ALARM_TIMEOUT = 60000;
        this.mHandler = handler;
        this.mContext = context;
        this.mOperator = new BoxHeartbeat();
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

    public void cancelHearbeat() {
        this.mOperator.cancelHearbeat();
    }

    public void startHeartbeat() {
        this.mOperator.startHeartbeat();
    }
}
