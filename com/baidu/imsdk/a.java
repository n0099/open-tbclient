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
/* loaded from: classes9.dex */
public class a {
    public static volatile boolean ayR = false;
    private static volatile Map<Long, Message> ayT = new LinkedHashMap();
    private static volatile a ayU;
    private static Context mContext;
    public static Handler mHandler;
    public boolean ayS = false;

    public static a al(Context context) {
        if (ayU == null) {
            mContext = context.getApplicationContext();
            ayU = new a();
        }
        return ayU;
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
        ayR = false;
        AO();
    }

    private void AO() {
        try {
            LogUtils.d("IMServiceImpl", "isSmallFlow :" + ayR);
            IMManager.init(mContext.getApplicationContext(), IMConfigInternal.getInstance().getProductLine(mContext.getApplicationContext()));
            if (ayR) {
                AP();
            } else if (!IMSDK.getInstance(mContext.getApplicationContext()).init()) {
                IMConnection.getInstance(mContext).disconnectedByPeer();
            }
        } catch (Exception e) {
        }
    }

    private void AP() {
        for (int i : new int[]{96, Constants.METHOD_MEDIA_NOTIFY, 196, Constants.METHOD_IM_DELIVER_CONFIG_MSG}) {
            r(2, Integer.valueOf(i).intValue());
        }
        r(3, 196);
        this.ayS = true;
    }

    private void r(int i, int i2) {
    }

    public void onHandleWork(@NonNull Intent intent) {
        LogUtils.d("IMServiceImpl", "-- onHandleWork -- " + intent + ", isSmallFlow :" + ayR);
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

    public static void am(Context context) {
        synchronized (ayT) {
            if (ayT != null) {
                for (Message message : ayT.values()) {
                    if (message != null) {
                        message.handleMessageResult(context, null, -1, "");
                    }
                }
            }
        }
    }
}
