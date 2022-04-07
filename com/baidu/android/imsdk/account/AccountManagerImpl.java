package com.baidu.android.imsdk.account;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.request.IMGetMsgSettingSwitchRequest;
import com.baidu.android.imsdk.account.request.IMGetPaidByAppidRequest;
import com.baidu.android.imsdk.account.request.IMGetTokenByCuidRequest;
import com.baidu.android.imsdk.account.request.IMGetUidByUkRequest;
import com.baidu.android.imsdk.account.request.IMSetMsgSettingSwitchRequest;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.account.request.IMUserLogoutMsg;
import com.baidu.android.imsdk.account.request.IMUserQueryPrivacyRequest;
import com.baidu.android.imsdk.account.request.IMUserSetPrivacyRequest;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.android.pushservice.PushManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.p70;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AccountManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AccountManagerImpl";
    public static Context mContext;
    public static int mCuidTokenTryTimes;
    public static volatile AccountManagerImpl mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMediaRole;
    public String mAppVersion;
    public long mAppid;
    public String mCFrom;
    public String mCuid;
    public String mFrom;
    public ILoginStateChangedListener mILoginStateChangedListener;
    public IKickOutListener mKickOutListener;
    public int mLoginState;
    public int mLoginType;
    public int mOpenType;
    public Timer mTimer;
    public CopyOnWriteArrayList<TodoAfterLogin> mToDoListenersAfterLogin;
    public ArrayList<TodoBeforeLogout> mToDoListenersBeforeLogout;
    public String mToken;
    public String mUid;
    public String mVersionCode;
    public String mZid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1285212498, "Lcom/baidu/android/imsdk/account/AccountManagerImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1285212498, "Lcom/baidu/android/imsdk/account/AccountManagerImpl;");
        }
    }

    public AccountManagerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAppid = -1L;
        this.mUid = "";
        this.mToDoListenersAfterLogin = new CopyOnWriteArrayList<>();
        this.mToDoListenersBeforeLogout = new ArrayList<>();
        this.mLoginType = -1;
        this.mCuid = null;
        this.mFrom = "";
        this.mCFrom = "";
        this.mZid = "";
        this.mVersionCode = "";
        this.mLoginState = 0;
        this.mTimer = null;
        this.mOpenType = 0;
        this.isMediaRole = false;
        this.mAppid = Utility.getAppId(mContext);
        Class<?>[] clsArr = {IMUserLoginByTokenMsg.class, IMUserLogoutMsg.class};
        int[] iArr = {50, 52};
        for (int i3 = 0; i3 < 2; i3++) {
            MessageFactory.getInstance().addType(iArr[i3], clsArr[i3]);
        }
    }

    public static synchronized AccountManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        AccountManagerImpl accountManagerImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (AccountManagerImpl.class) {
                if (mInstance == null) {
                    mContext = context.getApplicationContext();
                    mInstance = new AccountManagerImpl();
                }
                accountManagerImpl = mInstance;
            }
            return accountManagerImpl;
        }
        return (AccountManagerImpl) invokeL.objValue;
    }

    private synchronized void noticeStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i) == null) {
            synchronized (this) {
                this.mLoginState = i;
                if (this.mILoginStateChangedListener != null) {
                    this.mILoginStateChangedListener.onLoginStateChanged(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoginService(int i, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, iLoginListener}) == null) {
            boolean loginInternal = LoginManager.getInstance(mContext).loginInternal(iLoginListener);
            String str5 = TAG;
            LogUtils.d(str5, "startLoginService isNeedLogin: " + loginInternal);
            Context context = mContext;
            Utility.writeLoginFlag(context, "6N", "startLoginService isNeedLogin :" + loginInternal);
            if (loginInternal) {
                noticeStateChanged(1);
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 50);
                creatMethodIntent.putExtra(Constants.EXTRA_INTERNAL_LOGIN, true);
                if (!TextUtils.isEmpty(str3)) {
                    this.mFrom = str3;
                    Utility.writeLoginFrom(mContext, str3);
                    creatMethodIntent.putExtra(Constants.EXTRA_LOGIN_FROM, str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    this.mCFrom = str4;
                    Utility.writeLoginCFrom(mContext, str4);
                    creatMethodIntent.putExtra(Constants.EXTRA_LOGIN_CFROM, str4);
                }
                if (i == 1 && !TextUtils.isEmpty(str)) {
                    setUid(str);
                }
                getInstance(mContext).setLoginType(i);
                this.mToken = str2;
                Utility.writeAccessToken(mContext, str2);
                try {
                    p70.g(mContext).f(mContext, creatMethodIntent);
                    Utility.writeLoginFlag(mContext, "6Y", "startLoginService");
                } catch (Exception e) {
                    Utility.writeLoginFlag(mContext, "6N_1", "startLoginService exception");
                    LogUtils.e(TAG, "startService", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startLoginServiceRunnable(int i, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, iLoginListener}) != null) {
            return;
        }
        LogUtils.d(TAG, "*** startLoginServiceRunnable will start ***");
        String token = getToken();
        if (i != 6 && !TextUtils.isEmpty(token)) {
            if (!str2.equals(token)) {
                z = true;
                Context context = mContext;
                Utility.writeLoginFlag(context, "5N", "startLoginServiceRunnable begin, loginType = " + i + "，needLogout :" + z);
                if (!z) {
                    LogUtils.d(TAG, "need logout before login");
                    if (p70.e) {
                        BIMManager.imLogoutByLcp(mContext);
                        startLoginService(i, str, str2, str3, str4, iLoginListener);
                        return;
                    }
                    LoginManager.getInstance(mContext).logoutInternal(null);
                    Utility.clearCache(mContext);
                    logout(0, new ILoginListener(this, i, str, str2, str3, str4, iLoginListener) { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AccountManagerImpl this$0;
                        public final /* synthetic */ String val$accessToken;
                        public final /* synthetic */ String val$cfrom;
                        public final /* synthetic */ String val$from;
                        public final /* synthetic */ ILoginListener val$listener;
                        public final /* synthetic */ int val$uLoginType;
                        public final /* synthetic */ String val$uid;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i), str, str2, str3, str4, iLoginListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$uLoginType = i;
                            this.val$uid = str;
                            this.val$accessToken = str2;
                            this.val$from = str3;
                            this.val$cfrom = str4;
                            this.val$listener = iLoginListener;
                        }

                        @Override // com.baidu.android.imsdk.account.ILoginListener
                        public void onLoginResult(int i2, String str5) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str5) == null) {
                            }
                        }

                        @Override // com.baidu.android.imsdk.account.ILoginListener
                        public void onLogoutResult(int i2, String str5, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str5, Integer.valueOf(i3)}) == null) {
                                LogUtils.d(AccountManagerImpl.TAG, "logout onLogoutResult");
                                this.this$0.disconnect(ListenerManager.getInstance().addListener(new ILoginListener(this) { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass3 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i4 = newInitContext.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // com.baidu.android.imsdk.account.ILoginListener
                                    public void onLoginResult(int i4, String str6) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i4, str6) == null) {
                                        }
                                    }

                                    @Override // com.baidu.android.imsdk.account.ILoginListener
                                    public void onLogoutResult(int i4, String str6, int i5) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i4), str6, Integer.valueOf(i5)}) == null) {
                                            LogUtils.d(AccountManagerImpl.TAG, "disconnect onLogoutResult");
                                            Utility.writeLoginFlag(AccountManagerImpl.mContext, "5Y", "Logout and disconnect success");
                                            AnonymousClass3 anonymousClass3 = this.this$1;
                                            anonymousClass3.this$0.startLoginService(anonymousClass3.val$uLoginType, anonymousClass3.val$uid, anonymousClass3.val$accessToken, anonymousClass3.val$from, anonymousClass3.val$cfrom, anonymousClass3.val$listener);
                                        }
                                    }
                                }));
                            }
                        }
                    });
                    return;
                }
                startLoginService(i, str, str2, str3, str4, iLoginListener);
                return;
            }
        }
        z = false;
        Context context2 = mContext;
        Utility.writeLoginFlag(context2, "5N", "startLoginServiceRunnable begin, loginType = " + i + "，needLogout :" + z);
        if (!z) {
        }
    }

    public static void tryConnection(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            try {
                Intent intent = new Intent(mContext, p70.class);
                intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                intent.setPackage(mContext.getPackageName());
                p70.g(context).f(mContext, intent);
            } catch (Exception unused) {
                LogUtils.e(TAG, "tryConnection failed......");
            }
        }
    }

    public void clearKillOutListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public boolean clearLoginParam(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (Utility.removeKey(mContext, Constants.EXTRA_LOGIN_FROM)) {
                this.mFrom = "";
            }
            if (Utility.removeKey(mContext, Constants.EXTRA_LOGIN_CFROM)) {
                this.mCFrom = "";
            }
            if (Utility.removeKey(mContext, Constants.KEY_ZID)) {
                this.mZid = "";
            }
            if (Utility.removeKey(mContext, Constants.KEY_VCODE)) {
                this.mVersionCode = "";
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean clearToken(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean clearAccessToken = Utility.clearAccessToken(mContext);
            if (clearAccessToken) {
                Utility.clearCache(mContext);
                this.mToken = null;
            }
            if (!p70.e) {
                clearLoginParam(mContext);
                clearUid(mContext);
                disconnect(str);
            } else if (!TextUtils.isEmpty(str)) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(str);
                if (removeListener instanceof ILoginListener) {
                    ILoginListener iLoginListener = (ILoginListener) removeListener;
                    LoginManager.getInstance(mContext).logoutInternal(iLoginListener);
                    iLoginListener.onLogoutResult(0, "logout success", getInstance(mContext).getLoginType());
                }
            }
            return clearAccessToken;
        }
        return invokeL.booleanValue;
    }

    public boolean clearUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            boolean removeKey = Utility.removeKey(mContext, Constants.KEY_PASSPORT_UID);
            if (removeKey) {
                this.mUid = "";
            }
            return removeKey;
        }
        return invokeL.booleanValue;
    }

    public void disconnect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                Intent intent = new Intent(mContext, p70.class);
                intent.putExtra(Constants.EXTRA_LISTENER_ID, str);
                intent.putExtra(Constants.EXTRA_DISCONNECT, "1");
                intent.setPackage(mContext.getPackageName());
                p70.g(mContext).f(mContext, intent);
            } catch (Exception e) {
                LogUtils.e(TAG, "disconnect", e);
                IMListener removeListener = ListenerManager.getInstance().removeListener(str);
                if (removeListener == null || !(removeListener instanceof ILoginListener)) {
                    return;
                }
                ((ILoginListener) removeListener).onLogoutResult(1003, Constants.ERROR_MSG_SERVICE_ERROR, BIMManager.getLoginType(mContext));
            }
        }
    }

    public int getAppOpenType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mOpenType : invokeV.intValue;
    }

    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.isEmpty(this.mAppVersion)) {
                return Utility.readStringData(mContext, Constants.KEY_PRODUCT_VERSION, "0");
            }
            return this.mAppVersion;
        }
        return (String) invokeV.objValue;
    }

    public long getAppid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long j = this.mAppid;
            return j == -1 ? Utility.readAppId(mContext) : j;
        }
        return invokeV.longValue;
    }

    public String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.mCuid;
            if (str != null) {
                return str;
            }
            String readCuid = Utility.readCuid(mContext);
            this.mCuid = readCuid;
            return readCuid;
        }
        return (String) invokeV.objValue;
    }

    public String getExtraSafeParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("zid", getZid());
                jSONObject.put("version_code", getVersionCode());
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String str = this.mFrom;
            return TextUtils.isEmpty(str) ? Utility.getLoginFrom(mContext) : str;
        }
        return (String) invokeV.objValue;
    }

    public int getLoginState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mLoginState : invokeV.intValue;
    }

    public int getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.mLoginType;
            if (i != -1) {
                return i;
            }
            int readLoginType = Utility.readLoginType(mContext);
            this.mLoginType = readLoginType;
            return readLoginType;
        }
        return invokeV.intValue;
    }

    public boolean getMediaRole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.isMediaRole : invokeV.booleanValue;
    }

    public void getMsgSettingSwitchStatus(IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, iGetMsgSettingSwitchListener) == null) || iGetMsgSettingSwitchListener == null) {
            return;
        }
        if (isLogin()) {
            IMGetMsgSettingSwitchRequest iMGetMsgSettingSwitchRequest = new IMGetMsgSettingSwitchRequest(mContext, iGetMsgSettingSwitchListener);
            HttpHelper.executor(mContext, iMGetMsgSettingSwitchRequest, iMGetMsgSettingSwitchRequest);
            return;
        }
        iGetMsgSettingSwitchListener.onGetMsgSettingSwitch(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, 0, 0);
    }

    public int getNotificationPrivacy(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) ? Utility.readPrivate(context) : invokeL.intValue;
    }

    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String str = this.mToken;
            return TextUtils.isEmpty(str) ? Utility.getAccessToken(mContext) : str;
        }
        return (String) invokeV.objValue;
    }

    public void getTokenByCuid(long j, String str, IGetTokenByCuidListener iGetTokenByCuidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j), str, iGetTokenByCuidListener}) == null) {
            if (TextUtils.isEmpty(str) || j == -1) {
                iGetTokenByCuidListener.onGetTokenByCuidResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
            String str2 = TAG;
            LogUtils.d(str2, "getTokenByCuid----appid: " + j + " cuid: " + str);
            String addListener = ListenerManager.getInstance().addListener(iGetTokenByCuidListener);
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
            }
            Timer timer2 = new Timer();
            this.mTimer = timer2;
            try {
                timer2.schedule(new TimerTask(this, j, str, addListener) { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AccountManagerImpl this$0;
                    public final /* synthetic */ long val$appid;
                    public final /* synthetic */ String val$cuid;
                    public final /* synthetic */ String val$key;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(j), str, addListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$appid = j;
                        this.val$cuid = str;
                        this.val$key = addListener;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.getTokenByCuid(this.val$appid, this.val$cuid, this.val$key);
                        }
                    }
                }, Utility.getPeakDelayTime());
            } catch (Exception e) {
                LogUtils.e(TAG, "getTokenByCuid Exception", e);
                getTokenByCuid(j, str, addListener);
            }
        }
    }

    public long getUK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (isLogin()) {
                return Utility.getUK(mContext);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            String str = this.mUid;
            if (TextUtils.isEmpty(str)) {
                String readUid = Utility.readUid(mContext);
                this.mUid = readUid;
                return readUid;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void getUidByUk(long[] jArr, IGetUidByUkListener iGetUidByUkListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, jArr, iGetUidByUkListener) == null) {
            if (jArr == null || jArr.length == 0) {
                iGetUidByUkListener.onGetUidByUkResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, jArr, null);
            }
            IMGetUidByUkRequest iMGetUidByUkRequest = new IMGetUidByUkRequest(mContext, jArr, ListenerManager.getInstance().addListener(iGetUidByUkListener));
            HttpHelper.executor(mContext, iMGetUidByUkRequest, iMGetUidByUkRequest);
        }
    }

    public String getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String str = this.mVersionCode;
            return TextUtils.isEmpty(str) ? Utility.readStringData(mContext, Constants.KEY_VCODE, "") : str;
        }
        return (String) invokeV.objValue;
    }

    public long getZhidaAppid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? Utility.getZhidaAppid(mContext) : invokeV.longValue;
    }

    public String getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            String str = this.mZid;
            return TextUtils.isEmpty(str) ? Utility.readStringData(mContext, Constants.KEY_ZID, "") : str;
        }
        return (String) invokeV.objValue;
    }

    public String getcFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String str = this.mCFrom;
            return TextUtils.isEmpty(str) ? Utility.getLoginCFrom(mContext) : str;
        }
        return (String) invokeV.objValue;
    }

    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? !TextUtils.isEmpty(getToken()) : invokeV.booleanValue;
    }

    public void login(int i, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, iLoginListener}) == null) {
            if (str2 == null) {
                onLoginResult("", 1005, Constants.ERROR_MSG_PARAMETER_ERROR, false);
                return;
            }
            LogUtils.d(TAG, "login type :" + i);
            LogUtils.d(TAG, "start login loginState:" + LoginManager.getInstance(mContext).getCurrentState());
            LogUtils.d(TAG, "current version:" + IMConfigInternal.getInstance().getSDKVersionValue(mContext) + " " + IMConfigInternal.getInstance().getSDKVersionValue(mContext));
            Utility.writeLoginFlag(mContext, "5N_1", "login begin");
            ConversationStudioManImpl.getInstance(mContext);
            ConversationStudioManImpl.resetHeartBeat(60000);
            if (Utility.isPeakTime()) {
                Timer timer = this.mTimer;
                if (timer != null) {
                    timer.cancel();
                    this.mTimer = null;
                }
                this.mTimer = new Timer();
                long nextInt = (new Random().nextInt(Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) + 10) * 1000;
                LogUtils.d(TAG, "*** peak time! login will delay " + nextInt + " ms ***");
                try {
                    this.mTimer.schedule(new TimerTask(this, i, str, str2, str3, str4, iLoginListener) { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AccountManagerImpl this$0;
                        public final /* synthetic */ String val$accessToken;
                        public final /* synthetic */ String val$cfrom;
                        public final /* synthetic */ String val$from;
                        public final /* synthetic */ ILoginListener val$listener;
                        public final /* synthetic */ int val$uLoginType;
                        public final /* synthetic */ String val$uid;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i), str, str2, str3, str4, iLoginListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$uLoginType = i;
                            this.val$uid = str;
                            this.val$accessToken = str2;
                            this.val$from = str3;
                            this.val$cfrom = str4;
                            this.val$listener = iLoginListener;
                        }

                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.startLoginServiceRunnable(this.val$uLoginType, this.val$uid, this.val$accessToken, this.val$from, this.val$cfrom, this.val$listener);
                            }
                        }
                    }, nextInt);
                    return;
                } catch (Exception e) {
                    LogUtils.e(TAG, "timer exception", e);
                    startLoginServiceRunnable(i, str, str2, str3, str4, iLoginListener);
                    return;
                }
            }
            Utility.writeLoginFlag(mContext, "5N_2", "startLoginServiceRunnable");
            if (TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, i, str, str2, str3, str4, iLoginListener) { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountManagerImpl this$0;
                public final /* synthetic */ String val$accessToken;
                public final /* synthetic */ String val$cfrom;
                public final /* synthetic */ String val$from;
                public final /* synthetic */ ILoginListener val$listener;
                public final /* synthetic */ int val$uLoginType;
                public final /* synthetic */ String val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), str, str2, str3, str4, iLoginListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uLoginType = i;
                    this.val$uid = str;
                    this.val$accessToken = str2;
                    this.val$from = str3;
                    this.val$cfrom = str4;
                    this.val$listener = iLoginListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.startLoginServiceRunnable(this.val$uLoginType, this.val$uid, this.val$accessToken, this.val$from, this.val$cfrom, this.val$listener);
                    }
                }
            })) {
                return;
            }
            startLoginServiceRunnable(i, str, str2, str3, str4, iLoginListener);
        }
    }

    public void logout(int i, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048603, this, i, iLoginListener) == null) {
            noticeStateChanged(4);
            BIMManager.connectStatusNotify(1);
            Iterator<TodoBeforeLogout> it = this.mToDoListenersBeforeLogout.iterator();
            while (it.hasNext()) {
                TodoBeforeLogout next = it.next();
                if (next != null) {
                    next.todo();
                }
            }
            String addListener = ListenerManager.getInstance().addListener(iLoginListener);
            if (isLogin()) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 52);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra(Constants.EXTRA_CLEAR_AFTER_LOGOUT, i);
                try {
                    p70.g(mContext).f(mContext, creatMethodIntent);
                    return;
                } catch (Exception e) {
                    LogUtils.e(TAG, "Exception ", e);
                    onLogoutResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, i);
                    return;
                }
            }
            onLogoutResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, i);
        }
    }

    public void onGetTokenByCuidResult(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048604, this, str, i, str2, str3) == null) {
            String str4 = TAG;
            LogUtils.d(str4, "onGetTokenByCuidResult----errorCode: " + i + " msg: " + str2);
            IGetTokenByCuidListener iGetTokenByCuidListener = (IGetTokenByCuidListener) ListenerManager.getInstance().removeListener(str);
            if (iGetTokenByCuidListener != null) {
                iGetTokenByCuidListener.onGetTokenByCuidResult(i, str2, str3);
                return;
            }
            Utility.writeLoginFlag(mContext, "3N", "onGetTokenByCuidResult listener is null");
            LogUtils.d(TAG, "onGetTokenByCuidResult> listener is null");
        }
    }

    public void onGetUidByUkResult(String str, int i, String str2, long[] jArr, Map<Long, Long> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{str, Integer.valueOf(i), str2, jArr, map}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onGetUidByUkResult----errorCode: " + i + " msg: " + str2);
            IGetUidByUkListener iGetUidByUkListener = (IGetUidByUkListener) ListenerManager.getInstance().removeListener(str);
            if (iGetUidByUkListener != null) {
                iGetUidByUkListener.onGetUidByUkResult(i, str2, jArr, map);
            } else {
                LogUtils.d(TAG, "onGetUidByUkResult is null");
            }
        }
    }

    public void onLoginResult(String str, int i, String str2, boolean z) {
        CopyOnWriteArrayList<TodoAfterLogin> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onLoginResult----errorCode: " + i + " msg: " + str2);
            LoginManager.getInstance(mContext).onLoginResultInternal(i, str2);
            if (i == 0) {
                ConversationStudioManImpl.getInstance(mContext).clear();
                ConversationStudioManImpl.getInstance(mContext).clearAckCastList();
                noticeStateChanged(3);
                BIMManager.connectStatusNotify(0);
                if (!p70.e) {
                    Utility.sendConnectionStateBroadCast(mContext, 0);
                }
            } else {
                noticeStateChanged(2);
            }
            if (i == 0 && (copyOnWriteArrayList = this.mToDoListenersAfterLogin) != null && copyOnWriteArrayList.size() > 0) {
                Iterator<TodoAfterLogin> it = this.mToDoListenersAfterLogin.iterator();
                while (it.hasNext()) {
                    it.next().todo(z);
                }
            }
            if (i == 0) {
                ConversationManagerImpl.getInstance(mContext).init(getUid());
            }
        }
    }

    public void onLogoutResult(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onLogoutResult----errorCode: " + i + " msg: " + str2);
            Context context = mContext;
            Utility.writeLoginFlag(context, "5Y", "onLogoutResult errCode = " + i + ", errMsg :" + str2);
            if (i == 0) {
                noticeStateChanged(6);
                Utility.sendConnectionStateBroadCast(mContext, 1);
                if (i2 == 1) {
                    Utility.clearAccessToken(mContext);
                    Utility.clearCache(mContext);
                }
                LoginManager.getInstance(mContext).onLogoutResultInternal(i, str2);
            } else {
                noticeStateChanged(5);
            }
            ILoginListener iLoginListener = (ILoginListener) ListenerManager.getInstance().removeListener(str);
            if (iLoginListener != null) {
                iLoginListener.onLogoutResult(i, str2, BIMManager.getLoginType(mContext));
                return;
            }
            Utility.writeLoginFlag(mContext, "5N", "onLogoutResult listener is null");
            String str4 = LogUtils.TAG;
            LogUtils.d(str4, TAG + "mLoginListener is null");
        }
    }

    public void onQueryPrivacyResult(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "onQueryPrivacyResult " + i + " " + str + " " + i2);
            if (i == 0) {
                Utility.writePrivate(mContext, i2);
                return;
            }
            String str3 = TAG;
            LogUtils.e(str3, "sync account privacy error " + i + " " + str);
        }
    }

    public void onSetPrivacyResult(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onSetPrivacyResult " + i + " " + str2 + " " + i2);
            ISetNotificationPrivacyListener iSetNotificationPrivacyListener = (ISetNotificationPrivacyListener) ListenerManager.getInstance().removeListener(str);
            if (iSetNotificationPrivacyListener != null) {
                iSetNotificationPrivacyListener.onResult(i, str2);
                if (i == 0) {
                    Utility.writePrivate(mContext, i2);
                    return;
                }
                return;
            }
            LogUtils.d(TAG, "ISetNotificationPrivacyListener is null");
        }
    }

    public void onSetZhidaAppidResult(String str, int i, String str2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            LogUtils.d(TAG, String.format("onSetZhidaAppidResult errorCode=%d,appid=%d,paid=%d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)));
            if (i == 0) {
                Context context = mContext;
                Utility.writeLongData(context, Constants.ZHIDA_SP_PRE + j, j2);
                Utility.setPaid(mContext, j2);
            }
            ISwitchZhidaListener iSwitchZhidaListener = (ISwitchZhidaListener) ListenerManager.getInstance().removeListener(str);
            if (iSwitchZhidaListener != null) {
                iSwitchZhidaListener.onSwitchZhidaResult(i, str2);
            } else {
                LogUtils.d(TAG, "onSetZhidaAppidResult is null");
            }
        }
    }

    public void pushReStartWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            LogUtils.d(TAG, "in pushReStartWork---");
            TaskManager.getInstance(mContext).submitForLocalOperation(new Runnable(this) { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountManagerImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LogUtils.d(AccountManagerImpl.TAG, "will do pushReStartWork---");
                        try {
                            PushManager.reStartWork(AccountManagerImpl.mContext);
                        } catch (Throwable th) {
                            String str = AccountManagerImpl.TAG;
                            LogUtils.d(str, "pushReStartWork---ERROR---" + th.getMessage());
                            new IMTrack.CrashBuilder(AccountManagerImpl.mContext).exception(Log.getStackTraceString(th)).build();
                        }
                    }
                }
            });
        }
    }

    public void registerKillOutListener(IKickOutListener iKickOutListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, iKickOutListener) == null) {
            this.mKickOutListener = iKickOutListener;
        }
    }

    public void registerToDoAfterLoginListener(TodoAfterLogin todoAfterLogin) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, todoAfterLogin) == null) || todoAfterLogin == null || this.mToDoListenersAfterLogin.contains(todoAfterLogin)) {
            return;
        }
        this.mToDoListenersAfterLogin.add(todoAfterLogin);
    }

    public void registerToDoBeforeLogoutListener(TodoBeforeLogout todoBeforeLogout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, todoBeforeLogout) == null) || todoBeforeLogout == null || this.mToDoListenersBeforeLogout.contains(todoBeforeLogout)) {
            return;
        }
        this.mToDoListenersBeforeLogout.add(todoBeforeLogout);
    }

    public void setAppOpenType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.mOpenType = i;
        }
    }

    public void setAppVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.mAppVersion = str;
            Utility.writeStringData(mContext, Constants.KEY_PRODUCT_VERSION, str);
        }
    }

    public boolean setAppid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048617, this, j)) == null) {
            this.mAppid = j;
            Utility.writeAppId(mContext, j);
            return true;
        }
        return invokeJ.booleanValue;
    }

    public void setCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.mCuid = str;
            Utility.writeCuid(mContext, str);
        }
    }

    public boolean setEnv(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048619, this, context, i)) == null) ? Constants.setEnv(context, i) : invokeLI.booleanValue;
    }

    public void setLogStateChangedListener(ILoginStateChangedListener iLoginStateChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, iLoginStateChangedListener) == null) {
            this.mILoginStateChangedListener = iLoginStateChangedListener;
        }
    }

    public void setLoginType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.mLoginType = i;
            Utility.writeLoginType(mContext, i);
        }
    }

    public void setMediaRole(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.isMediaRole = z;
        }
    }

    public void setMsgSettingSwitchStatus(int i, int i2, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048623, this, i, i2, iSetMsgSettingSwitchListener) == null) || iSetMsgSettingSwitchListener == null) {
            return;
        }
        if (isLogin()) {
            IMSetMsgSettingSwitchRequest iMSetMsgSettingSwitchRequest = new IMSetMsgSettingSwitchRequest(mContext, i, i2, iSetMsgSettingSwitchListener);
            HttpHelper.executor(mContext, iMSetMsgSettingSwitchRequest, iMSetMsgSettingSwitchRequest);
            return;
        }
        iSetMsgSettingSwitchListener.onSetMsgSettingSwitch(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
    }

    public void setNotificationPrivacy(int i, ISetNotificationPrivacyListener iSetNotificationPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048624, this, i, iSetNotificationPrivacyListener) == null) {
            IMUserSetPrivacyRequest iMUserSetPrivacyRequest = new IMUserSetPrivacyRequest(mContext, ListenerManager.getInstance().addListener(iSetNotificationPrivacyListener), AccountManager.getAppid(mContext), i);
            HttpHelper.executor(mContext, iMUserSetPrivacyRequest, iMUserSetPrivacyRequest);
        }
    }

    public void setNotifyPaid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048625, this, j) == null) {
            Utility.setNotifyPaid(mContext, j);
        }
    }

    public boolean setUid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) {
            if (str != null) {
                this.mUid = str;
                Utility.writeUid(mContext, str);
            }
            return str != null;
        }
        return invokeL.booleanValue;
    }

    public void setUpdateSwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            if (i == 1) {
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, false);
            } else if (i == 2) {
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, false);
            } else if (i != 3) {
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, true);
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, true);
            } else {
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, false);
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, false);
            }
        }
    }

    public void setVersionCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.mVersionCode = str;
            Utility.writeVersionCode(mContext, str);
        }
    }

    public void setZhidaAppid(long j, String str, ISwitchZhidaListener iSwitchZhidaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Long.valueOf(j), str, iSwitchZhidaListener}) == null) {
            Context context = mContext;
            long readLongData = Utility.readLongData(context, Constants.ZHIDA_SP_PRE + j, -1L);
            if (readLongData != -1) {
                Utility.setPaid(mContext, readLongData);
                iSwitchZhidaListener.onSwitchZhidaResult(0, Constants.ERROR_MSG_SUCCESS);
                return;
            }
            IMGetPaidByAppidRequest iMGetPaidByAppidRequest = new IMGetPaidByAppidRequest(mContext, j, str, ListenerManager.getInstance().addListener(iSwitchZhidaListener));
            HttpHelper.executor(mContext, iMGetPaidByAppidRequest, iMGetPaidByAppidRequest);
        }
    }

    public void setZid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.mZid = str;
            Utility.writeZid(mContext, str);
        }
    }

    public boolean stopService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            try {
                Intent intent = new Intent(mContext, p70.class);
                intent.setPackage(mContext.getPackageName());
                intent.setAction(Constants.ACTION_STOP);
                p70.g(mContext).f(mContext, intent);
                return true;
            } catch (Exception unused) {
                LogUtils.e(TAG, "Stop Service SecurityException");
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void syncPrivacy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            IMUserQueryPrivacyRequest iMUserQueryPrivacyRequest = new IMUserQueryPrivacyRequest(mContext, AccountManager.getAppid(mContext));
            HttpHelper.executor(mContext, iMUserQueryPrivacyRequest, iMUserQueryPrivacyRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTokenByCuid(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            IMGetTokenByCuidRequest iMGetTokenByCuidRequest = new IMGetTokenByCuidRequest(mContext, j, str, str2);
            HttpHelper.executor(mContext, iMGetTokenByCuidRequest, iMGetTokenByCuidRequest);
        }
    }
}
