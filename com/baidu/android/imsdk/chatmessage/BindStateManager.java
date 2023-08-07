package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.request.IMUnBindPushRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.v70;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class BindStateManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DefaultValue = -1;
    public static final String KEY_BIND_PUSH = "bindpush";
    public static final String KEY_UNBIND_PUSH_BDUSS = "unbind_push_bduss";
    public static final String KEY_UNBIND_PUSH_DEVICEID = "unbind_push_deviceid";
    public static final String KEY_UNBIND_UK = "unbind_uk";
    public static final long SPACE_TIME = 86400000;
    public static final String TAG = "BindStateManager";
    public static final List<IOnRegisterNotifyListener> listeners;
    public static BindState mIsBind;
    public static Object mTinerSync;
    public static SetUnBindRunable runable;
    public static MyTimeTask task;
    public static Timer timer;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class BindState {
        public static final /* synthetic */ BindState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BindState BINDED;
        public static final BindState BINDING;
        public static final BindState NOTBIND;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1701230485, "Lcom/baidu/android/imsdk/chatmessage/BindStateManager$BindState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1701230485, "Lcom/baidu/android/imsdk/chatmessage/BindStateManager$BindState;");
                    return;
                }
            }
            NOTBIND = new BindState("NOTBIND", 0);
            BINDED = new BindState("BINDED", 1);
            BindState bindState = new BindState("BINDING", 2);
            BINDING = bindState;
            $VALUES = new BindState[]{NOTBIND, BINDED, bindState};
        }

        public BindState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BindState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (BindState) Enum.valueOf(BindState.class, str);
            }
            return (BindState) invokeL.objValue;
        }

        public static BindState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (BindState[]) $VALUES.clone();
            }
            return (BindState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class MyTimeTask extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;

        public MyTimeTask() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = null;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BindStateManager.setunBindPush(this.context);
            }
        }

        public void setContext(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
                this.context = context;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SetUnBindRunable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;

        public SetUnBindRunable() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BindStateManager.setunBindPush(this.context);
            }
        }

        public void setContext(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
                this.context = context;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2120301819, "Lcom/baidu/android/imsdk/chatmessage/BindStateManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2120301819, "Lcom/baidu/android/imsdk/chatmessage/BindStateManager;");
                return;
            }
        }
        listeners = new ArrayList();
        timer = null;
        task = null;
        mIsBind = null;
        runable = new SetUnBindRunable();
        mTinerSync = new Object();
    }

    public BindStateManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean activeUnBind(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            LogUtils.d(TAG, "bind > activeUnBind...");
            String str = getunBindBduss(context);
            String str2 = getunBindDeviceId(context);
            Long l = getunBindUk(context);
            if (str != null && !"".equals(str.trim())) {
                if (l.longValue() == 0) {
                    LogUtils.d(TAG, "bind > activeUnBind return uk=0...");
                    return false;
                }
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
            LogUtils.d(TAG, "bind > activeUnBind return...");
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void clearUnBindInfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            setunBindBduss(context, "");
            setunBindDeviceId(context, "");
            setunBindUk(context, 0L);
        }
    }

    public static BindState getCurrentState(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (mIsBind == null) {
                if (getBindPush(context) == -1) {
                    mIsBind = BindState.NOTBIND;
                } else {
                    mIsBind = BindState.BINDED;
                }
            }
            return mIsBind;
        }
        return (BindState) invokeL.objValue;
    }

    public static String getunBindBduss(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return Utility.readStringData(context, KEY_UNBIND_PUSH_BDUSS, "");
        }
        return (String) invokeL.objValue;
    }

    public static String getunBindDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            return Utility.readStringData(context, KEY_UNBIND_PUSH_DEVICEID, "");
        }
        return (String) invokeL.objValue;
    }

    public static Long getunBindUk(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            return Long.valueOf(Utility.readLongData(context, KEY_UNBIND_UK, 0L));
        }
        return (Long) invokeL.objValue;
    }

    public static synchronized void removeBindPush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            synchronized (BindStateManager.class) {
                Utility.removeKey(context, AccountManager.getUK(context) + KEY_BIND_PUSH);
            }
        }
    }

    public static void setBindPushSuc(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            mIsBind = BindState.BINDED;
            setBindPush(context, 1);
        }
    }

    public static synchronized void setunBindPush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, context) == null) {
            synchronized (BindStateManager.class) {
                mIsBind = BindState.NOTBIND;
                setBindPush(context, -1);
            }
        }
    }

    public synchronized void unBindPush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            synchronized (this) {
                saveUnBindInfo(context, AccountManager.getToken(context), Utility.getIMDeviceId(context), Long.valueOf(AccountManager.getUK(context)));
                ChatMsgManagerImpl.getInstance(context).unRegisterNotify(null);
                removeBindPush(context);
            }
        }
    }

    public static synchronized int getBindPush(Context context) {
        InterceptResult invokeL;
        int readIntData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (BindStateManager.class) {
                readIntData = Utility.readIntData(context, AccountManager.getUK(context) + KEY_BIND_PUSH, -1);
            }
            return readIntData;
        }
        return invokeL.intValue;
    }

    public static void onRegisterNotifyResult(Context context, String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "bind > onRegisterNotifyResult----errorCode: " + i + " msg: " + str2);
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
    }

    public static boolean registerNotify(Context context, String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65546, null, context, str, str2, str3, iOnRegisterNotifyListener)) == null) {
            String addListener = ListenerManager.getInstance().addListener(iOnRegisterNotifyListener);
            boolean savePushCUID = Utility.savePushCUID(context, str, str2, str3);
            if (AccountManager.isLogin(context)) {
                if (RequsetNetworkUtils.isNetworkAvailable(context)) {
                    LogUtils.d(TAG, "bind > registerNotify!");
                    Intent creatMethodIntent = Utility.creatMethodIntent(context, 90);
                    creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                    creatMethodIntent.putExtra(Constants.EXTRA_PUSH_CHANNEL_ID, str);
                    creatMethodIntent.putExtra(Constants.EXTRA_PUSH_USER_ID, str2);
                    creatMethodIntent.putExtra(Constants.EXTRA_PUSH_APP_ID, str3);
                    try {
                        v70.e(context).d(context, creatMethodIntent);
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
        return invokeLLLLL.booleanValue;
    }

    public static void saveUnBindInfo(Context context, String str, String str2, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, str, str2, l) == null) {
            setunBindBduss(context, str);
            setunBindDeviceId(context, str2);
            setunBindUk(context, l);
        }
    }

    public static synchronized void setBindPush(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, context, i) == null) {
            synchronized (BindStateManager.class) {
                Utility.writeIntData(context, AccountManager.getUK(context) + KEY_BIND_PUSH, i);
            }
        }
    }

    public static void setunBindBduss(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, str) == null) {
            Utility.writeStringData(context, KEY_UNBIND_PUSH_BDUSS, str);
        }
    }

    public static void setunBindDeviceId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) {
            Utility.writeStringData(context, KEY_UNBIND_PUSH_DEVICEID, str);
        }
    }

    public static void setunBindUk(Context context, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, context, l) == null) {
            Utility.writeLongData(context, KEY_UNBIND_UK, l.longValue());
        }
    }

    public static boolean startBindPush(Context context, String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65555, null, context, str, str2, str3, iOnRegisterNotifyListener)) == null) {
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
                    MyTimeTask myTimeTask = new MyTimeTask();
                    task = myTimeTask;
                    myTimeTask.setContext(context);
                    timer.schedule(task, LiveFeedPageSdk.REFRESH_TIME);
                }
                LogUtils.d(TAG, "bind > start binding!");
                if (!TextUtils.isEmpty(str)) {
                    mIsBind = BindState.BINDING;
                }
                return registerNotify(context, str, str2, str3, iOnRegisterNotifyListener);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public static void syncPushInfo(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65556, null, context, str, str2, str3) == null) {
            if (LoginManager.getInstance(context).isIMLogined() && !AccountManager.isCuidLogin(context)) {
                if (System.currentTimeMillis() - Utility.getLastSyncPushTime(context) > 86400000) {
                    Intent creatMethodIntent = Utility.creatMethodIntent(context, 190);
                    creatMethodIntent.putExtra(Constants.EXTRA_PUSH_CHANNEL_ID, str);
                    creatMethodIntent.putExtra(Constants.EXTRA_PUSH_USER_ID, str2);
                    creatMethodIntent.putExtra(Constants.EXTRA_PUSH_APP_ID, str3);
                    try {
                        v70.e(context).d(context, creatMethodIntent);
                        return;
                    } catch (Exception e) {
                        LogUtils.e(TAG, "Exception ", e);
                        return;
                    }
                }
                return;
            }
            LogUtils.d(TAG, "syncPushInfo methodId :190 by intercept because unlogin ");
        }
    }
}
