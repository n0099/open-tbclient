package com.baidu.android.imsdk.account;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.request.IMGetMsgSettingSwitchRequest;
import com.baidu.android.imsdk.account.request.IMGetTokenByCuidRequest;
import com.baidu.android.imsdk.account.request.IMGetUidByUkRequest;
import com.baidu.android.imsdk.account.request.IMLogoutRequest;
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
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.android.pushservice.PushManager;
import com.baidu.tieba.t70;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
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
    public long mBduid;
    public String mCFrom;
    public String mClientId;
    public String mCuid;
    public String mFrom;
    public ILoginStateChangedListener mILoginStateChangedListener;
    public boolean mIsLogoutUpload;
    public boolean mIsScreenStatis;
    public long mLoginId;
    public int mLoginState;
    public int mLoginType;
    public int mOpenType;
    public Timer mTimer;
    public CopyOnWriteArrayList<TodoAfterLogin> mToDoListenersAfterLogin;
    public ArrayList<TodoBeforeLogout> mToDoListenersBeforeLogout;
    public String mToken;
    public String mTplSToken;
    public long mUK;
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
        this.mUK = 0L;
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
        this.mTplSToken = "";
        this.mIsScreenStatis = false;
        this.mLoginId = 0L;
        this.mIsLogoutUpload = false;
        this.mAppid = Utility.getAppId(mContext);
        Class<?>[] clsArr = {IMUserLoginByTokenMsg.class, IMUserLogoutMsg.class};
        int[] iArr = {50, 52};
        for (int i3 = 0; i3 < 2; i3++) {
            MessageFactory.getInstance().addType(iArr[i3], clsArr[i3]);
        }
    }

    public int getAppOpenType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mOpenType;
        }
        return invokeV.intValue;
    }

    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long j = this.mAppid;
            if (j == -1) {
                return Utility.readAppId(mContext);
            }
            return j;
        }
        return invokeV.longValue;
    }

    public long getBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mBduid;
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

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String str = this.mFrom;
            if (TextUtils.isEmpty(str)) {
                return Utility.getLoginFrom(mContext);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public long getLoginId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mLoginId;
        }
        return invokeV.longValue;
    }

    public int getLoginState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mLoginState;
        }
        return invokeV.intValue;
    }

    public int getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!this.isMediaRole) {
                this.isMediaRole = Utility.readAccountMedia(mContext);
            }
            return this.isMediaRole;
        }
        return invokeV.booleanValue;
    }

    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            String str = this.mToken;
            if (TextUtils.isEmpty(str)) {
                return Utility.getAccessToken(mContext);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getTplSToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (TextUtils.isEmpty(this.mTplSToken)) {
                return Utility.getTplSToken(mContext);
            }
            return this.mTplSToken;
        }
        return (String) invokeV.objValue;
    }

    public long getUK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            long j = this.mUK;
            if (j == 0) {
                return Utility.getUK(mContext);
            }
            return j;
        }
        return invokeV.longValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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

    public String getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            String str = this.mVersionCode;
            if (TextUtils.isEmpty(str)) {
                return Utility.readStringData(mContext, Constants.KEY_VCODE, "");
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getXDClientId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mClientId;
        }
        return (String) invokeV.objValue;
    }

    public String getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            String str = this.mZid;
            if (TextUtils.isEmpty(str)) {
                return Utility.readStringData(mContext, Constants.KEY_ZID, "");
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getcFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            String str = this.mCFrom;
            if (TextUtils.isEmpty(str)) {
                return Utility.getLoginCFrom(mContext);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return !TextUtils.isEmpty(getToken());
        }
        return invokeV.booleanValue;
    }

    public boolean isLogoutUpload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mIsLogoutUpload;
        }
        return invokeV.booleanValue;
    }

    public boolean isScreenStatis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mIsScreenStatis;
        }
        return invokeV.booleanValue;
    }

    public void pushReStartWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            LogUtils.d(TAG, "in pushReStartWork---");
            TaskManager.getInstance(mContext).submitForLocalOperation(new Runnable(this) { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.4
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
                        }
                    }
                }
            });
        }
    }

    public void syncPrivacy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            IMUserQueryPrivacyRequest iMUserQueryPrivacyRequest = new IMUserQueryPrivacyRequest(mContext, AccountManager.getAppid(mContext));
            HttpHelper.executor(mContext, iMUserQueryPrivacyRequest, iMUserQueryPrivacyRequest);
        }
    }

    public static synchronized AccountManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        AccountManagerImpl accountManagerImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
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
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            synchronized (this) {
                this.mLoginState = i;
                if (this.mILoginStateChangedListener != null) {
                    this.mILoginStateChangedListener.onLoginStateChanged(i);
                }
            }
        }
    }

    public boolean clearUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            boolean removeKey = Utility.removeKey(mContext, Constants.KEY_PASSPORT_UID);
            if (removeKey) {
                this.mUid = "";
            }
            return removeKey;
        }
        return invokeL.booleanValue;
    }

    public void getMsgSettingSwitchStatus(IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, iGetMsgSettingSwitchListener) != null) || iGetMsgSettingSwitchListener == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, context)) == null) {
            return Utility.readPrivate(context);
        }
        return invokeL.intValue;
    }

    public void registerToDoAfterLoginListener(TodoAfterLogin todoAfterLogin) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, todoAfterLogin) == null) && todoAfterLogin != null && !this.mToDoListenersAfterLogin.contains(todoAfterLogin)) {
            this.mToDoListenersAfterLogin.add(todoAfterLogin);
        }
    }

    public void registerToDoBeforeLogoutListener(TodoBeforeLogout todoBeforeLogout) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, todoBeforeLogout) == null) && todoBeforeLogout != null && !this.mToDoListenersBeforeLogout.contains(todoBeforeLogout)) {
            this.mToDoListenersBeforeLogout.add(todoBeforeLogout);
        }
    }

    public void setAppOpenType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.mOpenType = i;
        }
    }

    public void setAppVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.mAppVersion = str;
            Utility.writeStringData(mContext, Constants.KEY_PRODUCT_VERSION, str);
        }
    }

    public boolean setAppid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048619, this, j)) == null) {
            this.mAppid = j;
            Utility.writeAppId(mContext, j);
            return true;
        }
        return invokeJ.booleanValue;
    }

    public void setBduid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j) == null) {
            this.mBduid = j;
        }
    }

    public void setCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.mCuid = str;
            Utility.writeCuid(mContext, str);
        }
    }

    public void setLogStateChangedListener(ILoginStateChangedListener iLoginStateChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, iLoginStateChangedListener) == null) {
            this.mILoginStateChangedListener = iLoginStateChangedListener;
        }
    }

    public void setLoginId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j) == null) {
            this.mLoginId = j;
        }
    }

    public void setLoginType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.mLoginType = i;
            Utility.writeLoginType(mContext, i);
        }
    }

    public void setLogoutUpload(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.mIsLogoutUpload = z;
        }
    }

    public void setMediaRole(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.isMediaRole = z;
            Utility.writeAccountMedia(mContext, z);
        }
    }

    public void setScreenStatis(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.mIsScreenStatis = z;
        }
    }

    public void setTplSToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.mTplSToken = str;
            if (!Utility.getTplSToken(mContext).equals(str)) {
                Utility.setTplSToken(mContext, str);
            }
        }
    }

    public void setUK(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048632, this, j) == null) {
            this.mUK = j;
            Utility.writeUK(mContext, j);
        }
    }

    public boolean setUid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            if (str != null) {
                this.mUid = str;
                Utility.writeUid(mContext, str);
            }
            if (str != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setVersionCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.mVersionCode = str;
            Utility.writeVersionCode(mContext, str);
        }
    }

    public void setXDClientId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.mClientId = str;
        }
    }

    public void setZid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.mZid = str;
            Utility.writeZid(mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTokenByCuid(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            IMGetTokenByCuidRequest iMGetTokenByCuidRequest = new IMGetTokenByCuidRequest(mContext, j, str, str2);
            HttpHelper.executor(mContext, iMGetTokenByCuidRequest, iMGetTokenByCuidRequest);
        }
    }

    private void startLoginService(int i, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, iLoginListener}) == null) {
            boolean loginInternal = LoginManager.getInstance(mContext).loginInternal(iLoginListener);
            String str5 = TAG;
            LogUtils.d(str5, "startLoginService isNeedLogin: " + loginInternal);
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
                    t70.e(mContext).d(mContext, creatMethodIntent);
                } catch (Exception e) {
                    LogUtils.e(TAG, "startService", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoginServiceRunnable(int i, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, iLoginListener}) == null) {
            LogUtils.d(TAG, "*** startLoginServiceRunnable will start ***");
            String token = getToken();
            if (i != 6 && !TextUtils.isEmpty(token) && !str2.equals(token)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                LogUtils.d(TAG, "need logout before login");
                BIMManager.imLogoutByLcp(mContext);
            }
            startLoginService(i, str, str2, str3, str4, iLoginListener);
        }
    }

    public static void tryConnection(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            try {
                Intent intent = new Intent(mContext, t70.class);
                intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                intent.setPackage(mContext.getPackageName());
                t70.e(context).d(mContext, intent);
            } catch (Exception unused) {
                LogUtils.e(TAG, "tryConnection failed......");
            }
        }
    }

    public boolean clearLoginParam(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
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

    public void setUpdateSwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, true);
                        Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, true);
                        return;
                    }
                    Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, false);
                    Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, false);
                    return;
                }
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, false);
                return;
            }
            Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, false);
        }
    }

    public boolean clearToken(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            boolean clearAccessToken = Utility.clearAccessToken(mContext);
            if (clearAccessToken) {
                Utility.clearCache(mContext);
                this.mToken = null;
            }
            if (!TextUtils.isEmpty(str)) {
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

    public void disconnect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                Intent intent = new Intent(mContext, t70.class);
                intent.putExtra(Constants.EXTRA_LISTENER_ID, str);
                intent.putExtra(Constants.EXTRA_DISCONNECT, "1");
                intent.setPackage(mContext.getPackageName());
                t70.e(mContext).d(mContext, intent);
            } catch (Exception e) {
                LogUtils.e(TAG, "disconnect", e);
                IMListener removeListener = ListenerManager.getInstance().removeListener(str);
                if (removeListener != null && (removeListener instanceof ILoginListener)) {
                    ((ILoginListener) removeListener).onLogoutResult(1003, Constants.ERROR_MSG_SERVICE_ERROR, BIMManager.getLoginType(mContext));
                }
            }
        }
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
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean stopService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            try {
                Intent intent = new Intent(mContext, t70.class);
                intent.setPackage(mContext.getPackageName());
                intent.setAction(Constants.ACTION_STOP);
                t70.e(mContext).d(mContext, intent);
                return true;
            } catch (Exception unused) {
                LogUtils.e(TAG, "Stop Service SecurityException");
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void getTokenByCuid(long j, String str, IGetTokenByCuidListener iGetTokenByCuidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), str, iGetTokenByCuidListener}) == null) {
            if (TextUtils.isEmpty(str) || j == -1) {
                iGetTokenByCuidListener.onGetTokenByCuidResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
            String addListener = ListenerManager.getInstance().addListener(iGetTokenByCuidListener);
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
            }
            Timer timer2 = new Timer();
            this.mTimer = timer2;
            try {
                timer2.schedule(new TimerTask(this, j, str, addListener) { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.3
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
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.getTokenByCuid(this.val$appid, this.val$cuid, this.val$key);
                    }
                }, Utility.getPeakDelayTime());
            } catch (Exception e) {
                LogUtils.e(TAG, "getTokenByCuid Exception", e);
                getTokenByCuid(j, str, addListener);
            }
        }
    }

    public void onQueryPrivacyResult(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
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

    public void getUidByUk(long[] jArr, IGetUidByUkListener iGetUidByUkListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, jArr, iGetUidByUkListener) == null) {
            if (jArr == null || jArr.length == 0) {
                iGetUidByUkListener.onGetUidByUkResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, jArr, null);
            }
            IMGetUidByUkRequest iMGetUidByUkRequest = new IMGetUidByUkRequest(mContext, jArr, ListenerManager.getInstance().addListener(iGetUidByUkListener));
            HttpHelper.executor(mContext, iMGetUidByUkRequest, iMGetUidByUkRequest);
        }
    }

    public boolean setEnv(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048622, this, context, i)) == null) {
            return Constants.setEnv(context, i);
        }
        return invokeLI.booleanValue;
    }

    public void setNotificationPrivacy(int i, ISetNotificationPrivacyListener iSetNotificationPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048629, this, i, iSetNotificationPrivacyListener) == null) {
            IMUserSetPrivacyRequest iMUserSetPrivacyRequest = new IMUserSetPrivacyRequest(mContext, ListenerManager.getInstance().addListener(iSetNotificationPrivacyListener), AccountManager.getAppid(mContext), i);
            HttpHelper.executor(mContext, iMUserSetPrivacyRequest, iMUserSetPrivacyRequest);
        }
    }

    public void login(int i, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, iLoginListener}) == null) {
            if (str2 == null) {
                onLoginResult("", 1005, Constants.ERROR_MSG_PARAMETER_ERROR, false);
                return;
            }
            LogUtils.d(TAG, "login type :" + i);
            LogUtils.d(TAG, "start login loginState:" + LoginManager.getInstance(mContext).getCurrentState());
            LogUtils.d(TAG, "current version:" + IMConfigInternal.getInstance().getSDKVersionValue(mContext) + " " + IMConfigInternal.getInstance().getSDKVersionValue(mContext));
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
                } catch (Exception e) {
                    LogUtils.e(TAG, "timer exception", e);
                    startLoginServiceRunnable(i, str, str2, str3, str4, iLoginListener);
                }
            } else if (!TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, i, str, str2, str3, str4, iLoginListener) { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.2
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
                startLoginServiceRunnable(i, str, str2, str3, str4, iLoginListener);
            }
        }
    }

    public void logout(int i, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048607, this, i, iLoginListener) == null) {
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
                JSONArray jSONArray = new JSONArray();
                Utility.addEventListMs(jSONArray, "CIMReqBegin");
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 52);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra(Constants.EXTRA_CLEAR_AFTER_LOGOUT, i);
                creatMethodIntent.putExtra("event_list", jSONArray.toString());
                try {
                    t70.e(mContext).d(mContext, creatMethodIntent);
                } catch (Exception e) {
                    LogUtils.e(TAG, "Exception ", e);
                    onLogoutResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, i);
                }
                IMLogoutRequest iMLogoutRequest = new IMLogoutRequest(mContext, jSONArray);
                HttpHelper.executor(mContext, iMLogoutRequest, iMLogoutRequest);
                return;
            }
            onLogoutResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, i);
        }
    }

    public void onGetTokenByCuidResult(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048608, this, str, i, str2, str3) == null) {
            String str4 = TAG;
            LogUtils.d(str4, "onGetTokenByCuidResult----errorCode: " + i + " msg: " + str2);
            IGetTokenByCuidListener iGetTokenByCuidListener = (IGetTokenByCuidListener) ListenerManager.getInstance().removeListener(str);
            if (iGetTokenByCuidListener != null) {
                iGetTokenByCuidListener.onGetTokenByCuidResult(i, str2, str3);
            } else {
                LogUtils.d(TAG, "onGetTokenByCuidResult> listener is null");
            }
        }
    }

    public void onGetUidByUkResult(String str, int i, String str2, long[] jArr, Map<Long, Long> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{str, Integer.valueOf(i), str2, jArr, map}) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onLoginResult----errorCode: " + i + " msg: " + str2);
            LoginManager.getInstance(mContext).onLoginResultInternal(i, str2);
            if (i == 0) {
                ConversationStudioManImpl.getInstance(mContext).clear();
                ConversationStudioManImpl.getInstance(mContext).clearAckCastList();
                noticeStateChanged(3);
                BIMManager.connectStatusNotify(0);
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
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onLogoutResult----errorCode: " + i + " msg: " + str2);
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
            String str4 = LogUtils.TAG;
            LogUtils.d(str4, TAG + "mLoginListener is null");
        }
    }

    public void onSetPrivacyResult(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
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

    public void setMsgSettingSwitchStatus(int i, int i2, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048628, this, i, i2, iSetMsgSettingSwitchListener) != null) || iSetMsgSettingSwitchListener == null) {
            return;
        }
        if (isLogin()) {
            IMSetMsgSettingSwitchRequest iMSetMsgSettingSwitchRequest = new IMSetMsgSettingSwitchRequest(mContext, i, i2, iSetMsgSettingSwitchListener);
            HttpHelper.executor(mContext, iMSetMsgSettingSwitchRequest, iMSetMsgSettingSwitchRequest);
            return;
        }
        iSetMsgSettingSwitchListener.onSetMsgSettingSwitch(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
    }
}
