package com.baidu.imsdk;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.IMManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes18.dex */
public class a {
    private static volatile a azD;
    private static Context mContext;
    public static Handler mHandler;
    public boolean azC = false;
    private AtomicInteger azE = new AtomicInteger();
    public static volatile boolean azB = false;
    private static volatile Map<Long, Message> msgList = new LinkedHashMap();

    public static a ao(Context context) {
        if (azD == null) {
            synchronized (a.class) {
                if (azD == null) {
                    mContext = context.getApplicationContext();
                    azD = new a();
                }
            }
        }
        return azD;
    }

    public void e(Context context, final Intent intent) {
        LogUtils.e("IMServiceImpl", "IMServiceImpl.getInstance(context).enqueueWork");
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.imsdk.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.onHandleWork(intent);
            }
        });
    }

    private a() {
        mHandler = new Handler(mContext.getMainLooper());
        azB = false;
        AW();
    }

    private void AW() {
        try {
            LogUtils.d("IMServiceImpl", "isSmallFlow :" + azB);
            IMManager.init(mContext.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(mContext.getApplicationContext()));
            if (azB) {
                AX();
            } else if (!IMSDK.getInstance(mContext.getApplicationContext()).init()) {
                IMConnection.getInstance(mContext).disconnectedByPeer();
            }
        } catch (Exception e) {
        }
    }

    private void AX() {
        for (int i : new int[]{96, Constants.METHOD_MEDIA_NOTIFY, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 231}) {
            r(2, Integer.valueOf(i).intValue());
        }
        r(3, 196);
        this.azC = true;
    }

    private void r(int i, int i2) {
    }

    public void onHandleWork(@NonNull Intent intent) {
        LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + azB);
        if (intent == null) {
            intent = new Intent();
            LogUtils.i("IMServiceImpl", "--- onStart by null intent!");
        }
        try {
            if (!IMSDK.getInstance(mContext.getApplicationContext()).handleOnStart(intent)) {
                IMConnection.getInstance(mContext).disconnectedByPeer();
            }
        } catch (Exception e) {
            LogUtils.e(LogUtils.TAG, "onStartCommand", e);
            if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                if (removeListener instanceof ILoginListener) {
                    ((ILoginListener) removeListener).onLogoutResult(6, "IMService onStartCommand Exception", BIMManager.getLoginType(mContext));
                }
            } else if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
        }
    }

    public static void ap(Context context) {
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
