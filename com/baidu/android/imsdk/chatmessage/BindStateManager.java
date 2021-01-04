package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.request.IMUnBindPushRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.i.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class BindStateManager {
    private static final int DefaultValue = -1;
    private static final String KEY_BIND_PUSH = "bindpush";
    public static final String KEY_UNBIND_PUSH_BDUSS = "unbind_push_bduss";
    public static final String KEY_UNBIND_PUSH_DEVICEID = "unbind_push_deviceid";
    public static final String KEY_UNBIND_UK = "unbind_uk";
    private static final long SPACE_TIME = 86400000;
    private static final String TAG = BindStateManager.class.getSimpleName();
    private static final List<IOnRegisterNotifyListener> listeners = new ArrayList();
    private static Timer timer = null;
    private static MyTimeTask task = null;
    private static BindState mIsBind = null;
    private static SetUnBindRunable runable = new SetUnBindRunable();
    private static Object mTinerSync = new Object();

    /* loaded from: classes4.dex */
    public enum BindState {
        NOTBIND,
        BINDED,
        BINDING
    }

    public static void setBindPushSuc(Context context) {
        mIsBind = BindState.BINDED;
        setBindPush(context, 1);
    }

    public static synchronized void setunBindPush(Context context) {
        synchronized (BindStateManager.class) {
            mIsBind = BindState.NOTBIND;
            setBindPush(context, -1);
        }
    }

    public static BindState getCurrentState(Context context) {
        if (mIsBind == null) {
            if (getBindPush(context) == -1) {
                mIsBind = BindState.NOTBIND;
            } else {
                mIsBind = BindState.BINDED;
            }
        }
        return mIsBind;
    }

    public static boolean startBindPush(Context context, String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        LogUtils.d(TAG, "bind > startBindPush...");
        if (AccountManager.isCuidLogin(context)) {
            activeUnBind(context);
            syncPushInfo(context, str, str2, str3);
            return false;
        } else if (getCurrentState(context).equals(BindState.BINDED)) {
            LogUtils.d(TAG, "bind > already binded!");
            if (iOnRegisterNotifyListener != null) {
                iOnRegisterNotifyListener.onRegisterNotifyResult(0, "bind sucess\n");
            }
            syncPushInfo(context, str, str2, str3);
            return true;
        } else {
            if (iOnRegisterNotifyListener != null) {
                synchronized (listeners) {
                    listeners.add(iOnRegisterNotifyListener);
                }
            }
            activeUnBind(context);
            if (getCurrentState(context).equals(BindState.BINDING)) {
                LogUtils.d(TAG, "bind > already binding!");
                return true;
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                str = Utility.getPushChannelId(context);
                str2 = Utility.getPushUserId(context);
                str3 = Utility.getPushAppId(context);
            }
            LogUtils.d(TAG, "bind > will bind!");
            runable.setContext(context.getApplicationContext());
            synchronized (mTinerSync) {
                if (timer != null) {
                    timer.cancel();
                    timer.purge();
                    timer = null;
                }
                timer = new Timer();
                task = new MyTimeTask();
                task.setContext(context);
                timer.schedule(task, 180000L);
            }
            LogUtils.d(TAG, "bind > start binding!");
            if (!TextUtils.isEmpty(str)) {
                mIsBind = BindState.BINDING;
            }
            return registerNotify(context, str, str2, str3, iOnRegisterNotifyListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SetUnBindRunable implements Runnable {
        Context context = null;

        SetUnBindRunable() {
        }

        public void setContext(Context context) {
            this.context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            BindStateManager.setunBindPush(this.context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class MyTimeTask extends TimerTask {
        Context context = null;

        MyTimeTask() {
        }

        public void setContext(Context context) {
            this.context = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BindStateManager.setunBindPush(this.context);
        }
    }

    public static boolean registerNotify(Context context, String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        String addListener = ListenerManager.getInstance().addListener(iOnRegisterNotifyListener);
        boolean savePushCUID = Utility.savePushCUID(context, str, str2, str3);
        if (AccountManager.isLogin(context)) {
            if (RequsetNetworkUtils.isNetworkAvailable(context)) {
                LogUtils.d(TAG, "bind > registerNotify!");
                Intent creatMethodIntent = Utility.creatMethodIntent(context, 90);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra("push_channel_id", str);
                creatMethodIntent.putExtra(Constants.EXTRA_PUSH_USER_ID, str2);
                creatMethodIntent.putExtra(Constants.EXTRA_PUSH_APP_ID, str3);
                try {
                    a.ap(context).e(context, creatMethodIntent);
                } catch (Exception e) {
                    ListenerManager.getInstance().removeListener(addListener);
                    onRegisterNotifyResult(context, addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, false);
                    LogUtils.e(TAG, "Exception", e);
                }
                syncPushInfo(context, str, str2, str3);
            } else {
                onRegisterNotifyResult(context, addListener, 1001, Constants.ERROR_MSG_NETWORK_ERROR, false);
            }
        } else {
            onRegisterNotifyResult(context, addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, false);
        }
        return savePushCUID;
    }

    private static void syncPushInfo(Context context, String str, String str2, String str3) {
        if (!LoginManager.getInstance(context).isIMLogined() || AccountManager.isCuidLogin(context)) {
            LogUtils.d(TAG, "syncPushInfo methodId :190 by intercept because unlogin ");
            return;
        }
        if (System.currentTimeMillis() - Utility.getLastSyncPushTime(context) > 86400000) {
            Intent creatMethodIntent = Utility.creatMethodIntent(context, 190);
            creatMethodIntent.putExtra("push_channel_id", str);
            creatMethodIntent.putExtra(Constants.EXTRA_PUSH_USER_ID, str2);
            creatMethodIntent.putExtra(Constants.EXTRA_PUSH_APP_ID, str3);
            try {
                a.ap(context).e(context, creatMethodIntent);
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    public static void onRegisterNotifyResult(Context context, String str, int i, String str2, boolean z) {
        LogUtils.d(TAG, "bind > onRegisterNotifyResult----errorCode: " + i + " msg: " + str2);
        synchronized (mTinerSync) {
            if (timer != null) {
                timer.cancel();
                timer.purge();
                timer = null;
            }
        }
        if (z) {
            LogUtils.d(TAG, "bind > channelIdEmpty, return!");
            return;
        }
        if (i == 0) {
            LogUtils.d(TAG, "bind > sucess!");
            setBindPushSuc(context);
        } else {
            LogUtils.d(TAG, "bind > failed!");
            setunBindPush(context);
        }
        IOnRegisterNotifyListener iOnRegisterNotifyListener = (IOnRegisterNotifyListener) ListenerManager.getInstance().removeListener(str);
        synchronized (listeners) {
            Iterator<IOnRegisterNotifyListener> it = listeners.iterator();
            while (it.hasNext()) {
                IOnRegisterNotifyListener next = it.next();
                if (next != null) {
                    next.onRegisterNotifyResult(i, str2);
                }
                it.remove();
            }
        }
        if (iOnRegisterNotifyListener != null) {
            iOnRegisterNotifyListener.onRegisterNotifyResult(i, str2);
        }
    }

    public synchronized void unBindPush(Context context) {
        saveUnBindInfo(context, AccountManager.getToken(context), Utility.getIMDeviceId(context), Long.valueOf(AccountManager.getUK(context)));
        ChatMsgManagerImpl.getInstance(context).unRegisterNotify(null);
        removeBindPush(context);
    }

    public static synchronized void setBindPush(Context context, int i) {
        synchronized (BindStateManager.class) {
            Utility.writeIntData(context, AccountManager.getUK(context) + KEY_BIND_PUSH, i);
        }
    }

    public static synchronized int getBindPush(Context context) {
        int readIntData;
        synchronized (BindStateManager.class) {
            readIntData = Utility.readIntData(context, AccountManager.getUK(context) + KEY_BIND_PUSH, -1);
        }
        return readIntData;
    }

    public static synchronized void removeBindPush(Context context) {
        synchronized (BindStateManager.class) {
            Utility.removeKey(context, AccountManager.getUK(context) + KEY_BIND_PUSH);
        }
    }

    public static boolean activeUnBind(Context context) {
        LogUtils.d(TAG, "bind > activeUnBind...");
        String str = getunBindBduss(context);
        String str2 = getunBindDeviceId(context);
        Long l = getunBindUk(context);
        if (str == null || "".equals(str.trim())) {
            LogUtils.d(TAG, "bind > activeUnBind return...");
            return false;
        } else if (l.longValue() == 0) {
            LogUtils.d(TAG, "bind > activeUnBind return uk=0...");
            return false;
        } else {
            String token = AccountManager.getToken(context);
            if (token != null && token.equals(str)) {
                LogUtils.d(TAG, "bind > activeUnBind return, same token...");
                clearUnBindInfo(context);
                return false;
            }
            IMUnBindPushRequest iMUnBindPushRequest = new IMUnBindPushRequest(context, AccountManager.getAppid(context), str, str2, l);
            HttpHelper.executor(context, iMUnBindPushRequest, iMUnBindPushRequest);
            return true;
        }
    }

    public static void saveUnBindInfo(Context context, String str, String str2, Long l) {
        setunBindBduss(context, str);
        setunBindDeviceId(context, str2);
        setunBindUk(context, l);
    }

    public static void clearUnBindInfo(Context context) {
        setunBindBduss(context, "");
        setunBindDeviceId(context, "");
        setunBindUk(context, 0L);
    }

    public static void setunBindUk(Context context, Long l) {
        Utility.writeLongData(context, KEY_UNBIND_UK, l.longValue());
    }

    public static Long getunBindUk(Context context) {
        return Long.valueOf(Utility.readLongData(context, KEY_UNBIND_UK, 0L));
    }

    public static void setunBindBduss(Context context, String str) {
        Utility.writeStringData(context, KEY_UNBIND_PUSH_BDUSS, str);
    }

    public static void setunBindDeviceId(Context context, String str) {
        Utility.writeStringData(context, KEY_UNBIND_PUSH_DEVICEID, str);
    }

    public static String getunBindBduss(Context context) {
        return Utility.readStringData(context, KEY_UNBIND_PUSH_BDUSS, "");
    }

    public static String getunBindDeviceId(Context context) {
        return Utility.readStringData(context, KEY_UNBIND_PUSH_DEVICEID, "");
    }
}
