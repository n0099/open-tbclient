package com.baidu.tbadk.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Address;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CuidHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWorkCoreFacotry;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.RegisterIntentConfigHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.ActivityPrizeData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.switchs.AudioRecorderSwitch;
import com.baidu.tbadk.switchs.BaiduYunPushSdkSwitch;
import com.baidu.tbadk.switchs.GiftSwitch;
import com.baidu.tbadk.switchs.HybridBridgeSwitch;
import com.baidu.tbadk.switchs.LoginPassV6Switch;
import com.baidu.tbadk.switchs.LowVersionLoginPassV6Switch;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tbadk.switchs.WalletSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.an5;
import com.baidu.tieba.bd5;
import com.baidu.tieba.c95;
import com.baidu.tieba.cx5;
import com.baidu.tieba.d95;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.eg5;
import com.baidu.tieba.en5;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.g9;
import com.baidu.tieba.gn;
import com.baidu.tieba.hc5;
import com.baidu.tieba.hd5;
import com.baidu.tieba.hh;
import com.baidu.tieba.ic5;
import com.baidu.tieba.iz9;
import com.baidu.tieba.j30;
import com.baidu.tieba.jw5;
import com.baidu.tieba.k95;
import com.baidu.tieba.kd5;
import com.baidu.tieba.kz9;
import com.baidu.tieba.le5;
import com.baidu.tieba.lz9;
import com.baidu.tieba.md5;
import com.baidu.tieba.n95;
import com.baidu.tieba.oi;
import com.baidu.tieba.p05;
import com.baidu.tieba.pc5;
import com.baidu.tieba.pf;
import com.baidu.tieba.play.cyberPlayer.CyberRemotePlayerService;
import com.baidu.tieba.pv5;
import com.baidu.tieba.rdb;
import com.baidu.tieba.s35;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.tb;
import com.baidu.tieba.tn9;
import com.baidu.tieba.ue5;
import com.baidu.tieba.ui;
import com.baidu.tieba.vi;
import com.baidu.tieba.xi;
import com.baidu.tieba.yx8;
import com.baidu.tieba.zq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
@ModifyClass
/* loaded from: classes4.dex */
public class TbadkCoreApplication extends BdBaseApplication implements g9.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVE_CLEAR_TAG = "active_clear";
    public static final int APP_EVENT_LOGIN = 1;
    public static boolean IS_SUPPORT_SWIPEBACK = true;
    public static String clientId = null;
    public static Intent intent = null;
    public static final String isMem = "IsMem_";
    public static boolean isMyLive;
    public static String mUniqueId;
    public static TbadkCoreApplication sApp;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean _isMainProcess;
    public ActivityPrizeData activityPrizeData;
    public int canShowHotSplash;
    public int cardShowType;
    public String checkUrl;
    public String cuid_galaxy2;
    public String cuid_galaxy3;
    public String cuid_gid;
    public long currentAccountTdouNum;
    public DhcpInfo dhcpInfo;
    public String framework_ver;
    public Handler handler;
    public boolean hasInit;
    public int homeBarShowType;
    public ExecutorService imagePvThread;
    public boolean isAiAppsProcess;
    public Boolean isCdnTachometerProcess;
    public boolean isDaemonProcess;
    public boolean isFaceShopNew;
    public boolean isImmersiveStickyCanUse;
    public boolean isImmersiveStickyPrefHasRead;
    public boolean isKeepLiveProcess;
    public boolean isMeiZuCanUseImmersive;
    public boolean isMeiZuCanUseImmersiveHaveSet;
    public boolean isPhoneCalling;
    public boolean isRecAppExist;
    public boolean isRemoteProcess;
    public boolean isThirdProcess;
    public boolean isYunPushProcess;
    public int keyboardHeight;
    public long lastUpdateMemberCenterTime;
    public md5 listItemRule;
    public pf.c locationCallBack;
    public hc5 mActivitySwitch;
    public ic5 mAdAdSense;
    public String mAndroidId;
    public int mBdNetType;
    public boolean mCapableOfWebp;
    public String mChannelId;
    public String mConfigVersion;
    public bd5 mConsumePathData;
    public String mCuid;
    public String mCurAiAppid;
    public WeakReference<Activity> mCurGlobalActivityRef;
    public WeakReference<Activity> mCurrentActivityRef;
    public View mCustomToastView;
    public String mDefaultBubble;
    public String mDefaultBubbleDynamicRes;
    public int mDefaultBubbleEndTime;
    public int mFaceShopVersion;
    public HashMap<String, SoftReference<gn>> mFaces;
    public int mFontSize;
    public SparseArray<FrsNetModel> mFrsModelArray;
    public boolean mGpuOpen;
    public final Handler mHandler;
    public Hashtable<String, Integer> mHasLikeList;
    public Hashtable<String, Integer> mHasSignList;
    public hd5 mHttpsWhileData;
    public long mInitTime;
    public String mInstallAppIds;
    public kd5 mInterestBoardConfigData;
    public int mIsAbstractOn;
    public boolean mIsBottomBarDynamicHeightValid;
    public boolean mIsExitAppCloseWebSocket;
    public boolean mIsFirstTimeMotivate;
    public boolean mIsLocationOn;
    public boolean mIsNeedNewUserLead;
    public boolean mIsNewRegUser;
    public boolean mIsNoInterestTag;
    public boolean mIsOfficial;
    public boolean mIsPageStayOpen;
    public String mLibcrypto;
    public String mLibcyberVersion;
    public String mLibcyberffmpeg;
    public String mLibssl;
    public boolean mLikeChanged;
    public Activity mMainActivity;
    public boolean mNeedShowNewVersion;
    public int mNewVcodeWebviewCrashCount;
    public int mPerformSampleCount;
    public kz9 mPhotoLiveReadHistory;
    public boolean mPromotedMessageOn;
    public lz9 mReadThreadHistory;
    public ArrayList<Activity> mRemoteActivity;
    public ShareItem mShareItem;
    public Hashtable<String, Integer> mSignLevelUpList;
    public yx8 mSplash;
    public int mTempFaceShopVersion;
    public boolean mThemeWebviewOpened;
    public vi.d mToast;
    public VersionData mVersionData;
    public int mVideoAutoPlayConfig;
    public int mVoiceHeadsetMode;
    public int mWebviewCrashCount;
    public String naws_game_ver;
    public boolean needCheckUserNameDialog;
    public long processCreateTime;
    public String proxyIp;
    public String proxyPort;
    public String sdk_ver;
    public Map<Integer, Sensor> sensorMap;
    public int startType;
    public boolean syncHasFinish;
    public String task_id;
    public String uegVoiceWarning;
    public int useNewResign;
    public long useTimeInterval;
    public boolean userChatBlock;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(698775031, "Lcom/baidu/tbadk/core/TbadkCoreApplication;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(698775031, "Lcom/baidu/tbadk/core/TbadkCoreApplication;");
        }
    }

    public void doAfterSuperOnCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public void doBeforeSuperOnCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public boolean getLocationShared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbadkCoreApplication b;

        public a(TbadkCoreApplication tbadkCoreApplication, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbadkCoreApplication;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new an5(this.a)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbadkCoreApplication a;

        public b(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbadkCoreApplication;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1) {
                    c95.a(DI.ACCOUNT, -1L, 0, "application_clear_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(null, this.a.getContext());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.a.getContext(), true)));
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements pf.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbadkCoreApplication a;

        public c(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbadkCoreApplication;
        }

        @Override // com.baidu.tieba.pf.c
        public void a(int i, String str, Address address) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, address) == null) && i == 0 && address != null) {
                try {
                    String valueOf = String.valueOf(address.getLatitude());
                    String valueOf2 = String.valueOf(address.getLongitude());
                    if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                        this.a.setLocationLat(valueOf);
                        this.a.setLocationLng(valueOf2);
                        this.a.setLocationPos(address.getAddressLine(0));
                        tn9.e().i(valueOf);
                        tn9.e().j(valueOf2);
                        tn9.e().k(System.currentTimeMillis());
                    }
                } catch (IllegalStateException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbadkCoreApplication a;

        public d(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbadkCoreApplication;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pf.n().k(false, this.a.locationCallBack);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements CyberPlayerManager.InstallListener2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbadkCoreApplication a;

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        public e(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbadkCoreApplication;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
        public void onInstallInfo(int i, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj) != null) || !(obj instanceof String)) {
                return;
            }
            if (i == 100) {
                this.a.mLibcyberffmpeg = (String) obj;
            } else if (i == 101) {
                this.a.mLibssl = (String) obj;
            } else if (i == 102) {
                this.a.mLibcrypto = (String) obj;
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                this.a.mLibcyberVersion = str;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements pv5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbadkCoreApplication a;

        public f(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbadkCoreApplication;
        }

        @Override // com.baidu.tieba.pv5.b
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                hh.h(z2);
            }
        }
    }

    public TbadkCoreApplication() {
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
        this.mConsumePathData = null;
        this.mThemeWebviewOpened = false;
        this.mCapableOfWebp = false;
        this.mNewVcodeWebviewCrashCount = 0;
        this.mIsLocationOn = true;
        this.isThirdProcess = false;
        this.isAiAppsProcess = false;
        this.mVoiceHeadsetMode = 0;
        this.isDaemonProcess = false;
        this.isYunPushProcess = false;
        this.mIsExitAppCloseWebSocket = false;
        this.mCuid = null;
        this.cuid_galaxy2 = "";
        this.cuid_galaxy3 = "";
        this.cuid_gid = "";
        this.mAndroidId = "";
        this.mIsOfficial = true;
        this.mFaceShopVersion = -1;
        this.mPerformSampleCount = 10;
        this.mVersionData = null;
        this.mInitTime = 0L;
        this.mIsAbstractOn = 1;
        this.mHandler = new Handler();
        this.isImmersiveStickyCanUse = true;
        this.isImmersiveStickyPrefHasRead = false;
        this.mCustomToastView = null;
        this.mVideoAutoPlayConfig = -1;
        this.currentAccountTdouNum = 0L;
        this.mIsNoInterestTag = false;
        this.syncHasFinish = false;
        this.isKeepLiveProcess = false;
        this.startType = 2;
        this.canShowHotSplash = 2;
        this.mFrsModelArray = new SparseArray<>();
        this.mIsPageStayOpen = false;
        this.isMeiZuCanUseImmersiveHaveSet = false;
        this.isMeiZuCanUseImmersive = true;
        this.handler = new Handler(new b(this));
        this.locationCallBack = new c(this);
        this.mWebviewCrashCount = 0;
        this.mGpuOpen = false;
        this.mPromotedMessageOn = true;
        this.mDefaultBubble = null;
        this.mDefaultBubbleDynamicRes = null;
        this.mDefaultBubbleEndTime = 0;
        this.mRemoteActivity = null;
        this.mFontSize = 3;
        this.mFaces = new HashMap<>();
        this.isPhoneCalling = false;
        this.imagePvThread = null;
        this.mHasLikeList = null;
        this.mHasSignList = null;
        this.mSignLevelUpList = null;
        this.mLikeChanged = false;
        this.isFaceShopNew = false;
        this.mTempFaceShopVersion = -1;
        this.isRecAppExist = false;
        this.checkUrl = null;
        this.useNewResign = 0;
        this.lastUpdateMemberCenterTime = 0L;
        this.mNeedShowNewVersion = false;
        this.mIsNewRegUser = false;
        this.mInstallAppIds = "";
        this.mReadThreadHistory = null;
        this.mPhotoLiveReadHistory = null;
        this.mToast = null;
        this.mChannelId = "";
        this.cardShowType = 0;
        this.homeBarShowType = 1;
        this.needCheckUserNameDialog = true;
        sApp = this;
    }

    public static void setCurrentAccount(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, accountData, context) == null) {
            p05.t().K(accountData, context);
        }
    }

    public static void setCurrentAccountFromRemoteProcessInUIThread(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, accountData, context) == null) {
            p05.t().L(accountData, context);
        }
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2) == null) {
            RegisterIntentConfigHelper.getInst().RegisterIntent(cls, cls2);
        }
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cls, cls2) == null) {
            RegisterIntentConfigHelper.getInst().RegisterOrUpdateIntent(cls, cls2);
        }
    }

    public boolean loadBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048761, this, str, z)) == null) {
            return n95.m().i(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public int loadInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048762, this, str, i)) == null) {
            return n95.m().n(str, i);
        }
        return invokeLI.intValue;
    }

    public String loadString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048764, this, str, str2)) == null) {
            return n95.m().s(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public void login(TbPageContext<?> tbPageContext, CustomMessage<LoginActivityConfig> customMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048765, this, tbPageContext, customMessage) != null) || customMessage == null) {
            return;
        }
        if (tbPageContext != null) {
            tbPageContext.sendMessage(customMessage);
        } else {
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048778, this, broadcastReceiver, intentFilter)) == null) {
            try {
                return super.registerReceiver(broadcastReceiver, intentFilter);
            } catch (Throwable unused) {
                return new Intent();
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public void saveBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048783, this, str, z) == null) {
            n95.m().w(str, z);
        }
    }

    public void saveInt(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048784, this, str, i) == null) {
            n95.m().z(str, i);
        }
    }

    public void saveString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048785, this, str, str2) == null) {
            n95.m().B(str, str2);
        }
    }

    public static boolean checkNeedShowNewVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (!getInst().checkNeedShowNewVersionFlag()) {
                return false;
            }
            Long valueOf = Long.valueOf(getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            getInst().setUpdateNotifyTime(valueOf2.longValue());
            if (valueOf2.longValue() - valueOf.longValue() <= 86400000) {
                return false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001436));
            return true;
        }
        return invokeV.booleanValue;
    }

    public void initSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            this.mGpuOpen = TbadkSettings.getInst().loadBoolean("gpu_open", shouldGPUOn());
            this.mPromotedMessageOn = TbadkSettings.getInst().loadBoolean("permoted_message", true);
            this.mWebviewCrashCount = TbadkSettings.getInst().loadInt("webview_crash_count", 0);
            this.mNewVcodeWebviewCrashCount = TbadkSettings.getInst().loadInt("new_vcode_webview_crash_count", 0);
            this.mIsLocationOn = TbadkSettings.getInst().loadBoolean("location_on", true);
            getInst().setIsLocationON(this.mIsLocationOn);
            this.mIsExitAppCloseWebSocket = TbadkSettings.getInst().loadBoolean("is_exit_app_not_start_websocket", false);
            this.mFaceShopVersion = TbadkSettings.getInst().loadInt("faceshop_version", -1);
            this.useTimeInterval = n95.m().o("use_time_interval", TbConfig.DEFALT_USE_TIME_INTERVAL);
            BdLog.enableExceptionLog = n95.m().i("key_tieba_exception_log_enable", false);
        }
    }

    public static String getClientId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return clientId;
        }
        return (String) invokeV.objValue;
    }

    public static String getCurrentAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return p05.t().h();
        }
        return (String) invokeV.objValue;
    }

    public static String getCurrentAccountForEmotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return p05.t().i();
        }
        return (String) invokeV.objValue;
    }

    public static long getCurrentAccountId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return p05.t().j();
        }
        return invokeV.longValue;
    }

    public static AccountData getCurrentAccountInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return p05.t().k();
        }
        return (AccountData) invokeV.objValue;
    }

    public static String getCurrentAccountName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return p05.t().l();
        }
        return (String) invokeV.objValue;
    }

    public static String getCurrentAccountNameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return p05.t().m();
        }
        return (String) invokeV.objValue;
    }

    public static AccountData getCurrentAccountObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return p05.t().n();
        }
        return (AccountData) invokeV.objValue;
    }

    public static String getCurrentAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return p05.t().o();
        }
        return (String) invokeV.objValue;
    }

    public static String getCurrentBduss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return p05.t().p();
        }
        return (String) invokeV.objValue;
    }

    public static int getCurrentMemberType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return p05.t().q();
        }
        return invokeV.intValue;
    }

    public static String getCurrentPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return p05.t().r();
        }
        return (String) invokeV.objValue;
    }

    public static String getCurrentTbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return p05.t().p();
        }
        return (String) invokeV.objValue;
    }

    public static int getCurrentVipLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return p05.t().s();
        }
        return invokeV.intValue;
    }

    public static String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return TbConfig.getFrom();
        }
        return (String) invokeV.objValue;
    }

    public static TbadkCoreApplication getInst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return sApp;
        }
        return (TbadkCoreApplication) invokeV.objValue;
    }

    public static Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    private boolean isGifAutoPlayFromSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            int i = this.mVideoAutoPlayConfig;
            if (i == -1) {
                i = 1;
            }
            if ((i == 1 && (BdNetTypeUtil.isWifiNet() || !BdNetTypeUtil.isNetWorkAvailable())) || i == 2) {
                return true;
            }
            if (i == 3) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            String currentAccount = getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void AddResumeNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            jw5.g().a();
        }
    }

    public void DelResumeNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            jw5.g().b();
        }
    }

    public void addBDLocCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("bd_loc_crash_count", 0) + 1;
            TbadkSettings.getInst().saveInt("bd_loc_crash_count", loadInt);
            if (loadInt > 3) {
                setBDLocON(false);
            }
        }
    }

    public boolean canAutoPlaySwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int autoPlaySwitch = getInst().getAutoPlaySwitch();
            if ((autoPlaySwitch != 3 && BdNetTypeUtil.isWifiNet()) || (autoPlaySwitch == 2 && BdNetTypeUtil.isMobileNet())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean canSendForegroundMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return jw5.g().d();
        }
        return invokeV.booleanValue;
    }

    public boolean checkNeedShowNewVersionFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mNeedShowNewVersion;
        }
        return invokeV.booleanValue;
    }

    public void clearActiveVersion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            setActiveVersion(ACTIVE_CLEAR_TAG);
        }
    }

    public void clearEnterForeCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            jw5.g().e();
        }
    }

    public void clearSignedForum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Hashtable<String, Integer> hashtable = this.mHasSignList;
            if (hashtable != null) {
                hashtable.clear();
            }
            Hashtable<String, Integer> hashtable2 = this.mSignLevelUpList;
            if (hashtable2 != null) {
                hashtable2.clear();
            }
        }
    }

    public hc5 getActivitySwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mActivitySwitch;
        }
        return (hc5) invokeV.objValue;
    }

    public ic5 getAdAdSense() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mAdAdSense;
        }
        return (ic5) invokeV.objValue;
    }

    public int getAdVideoPageStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return n95.m().n("video_page_style", 3);
        }
        return invokeV.intValue;
    }

    public String getAndroidId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                return "000";
            }
            if (TextUtils.isEmpty(this.mAndroidId)) {
                this.mAndroidId = xi.a();
            }
            return this.mAndroidId;
        }
        return (String) invokeV.objValue;
    }

    public int getAutoPlaySwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            int i = this.mVideoAutoPlayConfig;
            if (i == -1) {
                int n = n95.m().n("auto_play_video_switch", 0);
                if (n == 1) {
                    return 1;
                }
                if (n == 2) {
                    return 2;
                }
                if (n != 3) {
                    return 1;
                }
                return 3;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public int getBdNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mBdNetType;
        }
        return invokeV.intValue;
    }

    public int getCanShowSplash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.startType == 2) {
                return 2;
            }
            return this.canShowHotSplash;
        }
        return invokeV.intValue;
    }

    public boolean getCapabilityOfWebp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mCapableOfWebp;
        }
        return invokeV.booleanValue;
    }

    public int getCardShowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (!this.hasInit) {
                this.cardShowType = n95.m().n("key_card_show_type", 0);
            }
            return this.cardShowType;
        }
        return invokeV.intValue;
    }

    public String getCheckUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.checkUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getConfigVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mConfigVersion;
        }
        return (String) invokeV.objValue;
    }

    public bd5 getConsumePathData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mConsumePathData;
        }
        return (bd5) invokeV.objValue;
    }

    @Modify(description = "贴吧原有CUID获取", type = 32)
    public String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (ui.isEmpty(this.mCuid)) {
                initCuid();
            }
            return this.mCuid;
        }
        return (String) invokeV.objValue;
    }

    public String getCuidGalaxy2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (ui.isEmpty(this.cuid_galaxy2)) {
                initCuidGalaxy2();
            }
            return this.cuid_galaxy2;
        }
        return (String) invokeV.objValue;
    }

    public String getCuidGalaxy3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (ui.isEmpty(this.cuid_galaxy3)) {
                initCuidGalaxy3();
            }
            return this.cuid_galaxy3;
        }
        return (String) invokeV.objValue;
    }

    public String getCuidGid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.cuid_gid;
        }
        return (String) invokeV.objValue;
    }

    public String getCurAiAppid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mCurAiAppid;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public Activity getCurGlobalActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            WeakReference<Activity> weakReference = this.mCurGlobalActivityRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Nullable
    public Activity getCurrentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            WeakReference<Activity> weakReference = this.mCurrentActivityRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public String getDefaultBubble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.mDefaultBubble;
        }
        return (String) invokeV.objValue;
    }

    public String getDefaultBubbleDynamicRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.mDefaultBubbleDynamicRes;
        }
        return (String) invokeV.objValue;
    }

    public int getDefaultBubbleEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.mDefaultBubbleEndTime;
        }
        return invokeV.intValue;
    }

    public int getEnterForeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return jw5.g().f();
        }
        return invokeV.intValue;
    }

    public int getFaceShopVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.mFaceShopVersion;
        }
        return invokeV.intValue;
    }

    public int getFeatureCrashAutoCloseLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return Math.max(TbadkSettings.getInst().loadInt("feature_crash_auto_close_limit", 3), 3);
        }
        return invokeV.intValue;
    }

    public boolean getFirstSyncImageQuality() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return TbadkSettings.getInst().loadBoolean("first_sync_image_quality", true);
        }
        return invokeV.booleanValue;
    }

    public int getFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.mFontSize;
        }
        return invokeV.intValue;
    }

    public String getFramework_ver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.framework_ver == null) {
                this.framework_ver = loadString("framework_ver", "");
            }
            return this.framework_ver;
        }
        return (String) invokeV.objValue;
    }

    public SparseArray<FrsNetModel> getFrsModeArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.mFrsModelArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public String getHdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                return rdb.a(sApp);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public int getHomeBarShowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.homeBarShowType;
        }
        return invokeV.intValue;
    }

    public hd5 getHttpsWhileData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.mHttpsWhileData;
        }
        return (hd5) invokeV.objValue;
    }

    public String getIMsi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return xi.c();
        }
        return (String) invokeV.objValue;
    }

    public String getImei() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return xi.b();
        }
        return (String) invokeV.objValue;
    }

    public long getInitTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.mInitTime;
        }
        return invokeV.longValue;
    }

    public String getInstallOtherApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return TbadkSettings.getInst().loadString("install_other_app_file_name", null);
        }
        return (String) invokeV.objValue;
    }

    public String getInstalledAppIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.mInstallAppIds;
        }
        return (String) invokeV.objValue;
    }

    public kd5 getInterestBoardConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.mInterestBoardConfigData;
        }
        return (kd5) invokeV.objValue;
    }

    public int getIsAbstractStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.mIsAbstractOn;
        }
        return invokeV.intValue;
    }

    public boolean getIsLocationOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.mIsLocationOn;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsNewRegUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.mIsNewRegUser;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsPhoneCalling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.isPhoneCalling;
        }
        return invokeV.booleanValue;
    }

    public int getKeepaliveNonWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return loadInt("keepalive_nonwifi", 1);
        }
        return invokeV.intValue;
    }

    public int getKeepaliveWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return loadInt("keepalive_wifi", 1);
        }
        return invokeV.intValue;
    }

    public int getKeyboardHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.keyboardHeight;
        }
        return invokeV.intValue;
    }

    public long getLastNotifyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return TbadkSettings.getInst().loadLong("last_notify_sound_time", 0L);
        }
        return invokeV.longValue;
    }

    public long getLastUpdateMemberCenterTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.lastUpdateMemberCenterTime;
        }
        return invokeV.longValue;
    }

    public String getLibcrypto() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.mLibcrypto;
        }
        return (String) invokeV.objValue;
    }

    public String getLibcyberffmpeg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.mLibcyberffmpeg;
        }
        return (String) invokeV.objValue;
    }

    public String getLibssl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.mLibssl;
        }
        return (String) invokeV.objValue;
    }

    public boolean getLikeBarChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.mLikeChanged;
        }
        return invokeV.booleanValue;
    }

    public md5 getListItemRule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if (this.listItemRule == null) {
                this.listItemRule = new md5();
            }
            return this.listItemRule;
        }
        return (md5) invokeV.objValue;
    }

    public String getLocationLat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return TbadkSettings.getInst().loadString("location_lat", "");
        }
        return (String) invokeV.objValue;
    }

    public String getLocationLng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return TbadkSettings.getInst().loadString("location_lng", "");
        }
        return (String) invokeV.objValue;
    }

    public Activity getMainActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.mMainActivity;
        }
        return (Activity) invokeV.objValue;
    }

    public final int getMainTabBottomBarDynamicStyleHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return vi.g(this, R.dimen.tbds187);
        }
        return invokeV.intValue;
    }

    public final int getMainTabBottomBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (isBottomBarDynamicHeightValid() && isMainTabActivity()) {
                return getMainTabBottomBarDynamicStyleHeight();
            }
            return getNormalMainTabBarHeight();
        }
        return invokeV.intValue;
    }

    public String getNaws_game_ver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.naws_game_ver == null) {
                this.naws_game_ver = loadString("naws_game_ver", "");
            }
            return this.naws_game_ver;
        }
        return (String) invokeV.objValue;
    }

    public int getNetWorkCoreType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return loadInt("networkcore_type", 1);
        }
        return invokeV.intValue;
    }

    public int getNewVcodeWebviewCrashCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.mNewVcodeWebviewCrashCount;
        }
        return invokeV.intValue;
    }

    public int getNormalMainTabBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (DeviceInfoUtil.isfullScreen()) {
                return vi.g(this, R.dimen.tbds162);
            }
            return vi.g(this, R.dimen.tbds152);
        }
        return invokeV.intValue;
    }

    public int getOldSkinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return p05.t().u();
        }
        return invokeV.intValue;
    }

    public int getPerformSampleCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.mPerformSampleCount;
        }
        return invokeV.intValue;
    }

    public s35 getPersonalizeViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return en5.e().f();
        }
        return (s35) invokeV.objValue;
    }

    public kz9 getPhotoLiveReadThreadHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.mPhotoLiveReadHistory;
        }
        return (kz9) invokeV.objValue;
    }

    @Modify(description = "flutter代理ip", type = Constants.SHORT_PING_CMD_TYPE)
    public String getProxyIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.proxyIp;
        }
        return (String) invokeV.objValue;
    }

    @Modify(description = "flutter代理端口", type = Constants.SHORT_PING_CMD_TYPE)
    public String getProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.proxyPort;
        }
        return (String) invokeV.objValue;
    }

    public String getPushChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return loadString(Constants.EXTRA_PUSH_CHANNEL_ID, "");
        }
        return (String) invokeV.objValue;
    }

    public String getPushChannelUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return loadString("push_channel_userId", "");
        }
        return (String) invokeV.objValue;
    }

    public lz9 getReadThreadHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.mReadThreadHistory;
        }
        return (lz9) invokeV.objValue;
    }

    public long getReporyUserInfoLastTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return TbadkSettings.getInst().loadLong("report_user_info_time_key" + getCurrentAccount(), 0L);
        }
        return invokeV.longValue;
    }

    public int getResumeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return jw5.g().h();
        }
        return invokeV.intValue;
    }

    public String getSdk_ver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.sdk_ver;
        }
        return (String) invokeV.objValue;
    }

    public ShareItem getShareItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.mShareItem;
        }
        return (ShareItem) invokeV.objValue;
    }

    public int getSkinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            if (p05.t().v() == 1) {
                p05.t().O(4);
            }
            return p05.t().v();
        }
        return invokeV.intValue;
    }

    public yx8 getSplash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            if (this.mSplash == null) {
                this.mSplash = new yx8(this);
            }
            return this.mSplash;
        }
        return (yx8) invokeV.objValue;
    }

    public int getStartType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.startType;
        }
        return invokeV.intValue;
    }

    public String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.task_id;
        }
        return (String) invokeV.objValue;
    }

    public String getTbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return p05.t().w();
        }
        return (String) invokeV.objValue;
    }

    public int getTempFaceShopVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.mTempFaceShopVersion;
        }
        return invokeV.intValue;
    }

    public boolean getThemeWebviewOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return this.mThemeWebviewOpened;
        }
        return invokeV.booleanValue;
    }

    public String getUegVoiceWarning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.uegVoiceWarning;
        }
        return (String) invokeV.objValue;
    }

    public long getUpdateNotifyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return TbadkSettings.getInst().loadLong("update_notify_time", 0L);
        }
        return invokeV.longValue;
    }

    public int getUseNewResign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.useNewResign;
        }
        return invokeV.intValue;
    }

    public long getUseTimeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return this.useTimeInterval;
        }
        return invokeV.longValue;
    }

    public int getUsedThemeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return p05.t().x();
        }
        return invokeV.intValue;
    }

    public int getUsedThemeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return p05.t().y();
        }
        return invokeV.intValue;
    }

    public VersionData getVersionData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            return this.mVersionData;
        }
        return (VersionData) invokeV.objValue;
    }

    public int getVideoAutoPlayReal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.mVideoAutoPlayConfig;
        }
        return invokeV.intValue;
    }

    public int getWebviewCrashCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return this.mWebviewCrashCount;
        }
        return invokeV.intValue;
    }

    public String getYunpushChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            if (TextUtils.isEmpty(this.mChannelId)) {
                this.mChannelId = n95.m().s("yunpush_channel_id", "");
            }
            return this.mChannelId;
        }
        return (String) invokeV.objValue;
    }

    public String getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                return FH.gz(sApp);
            }
            return "000";
        }
        return (String) invokeV.objValue;
    }

    public String getmLibcyberVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            return this.mLibcyberVersion;
        }
        return (String) invokeV.objValue;
    }

    public void initLikeForum() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048720, this) == null) && this.mHasLikeList == null) {
            this.mHasLikeList = new Hashtable<>();
        }
    }

    public void initSignedForum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            if (this.mHasSignList == null) {
                this.mHasSignList = new Hashtable<>();
            }
            if (this.mSignLevelUpList == null) {
                this.mSignLevelUpList = new Hashtable<>();
            }
        }
    }

    public void initSwanData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921512));
        }
    }

    public void initTrackConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            hh.h(TbSingleton.getInstance().isIsOpenTrack());
        }
    }

    public boolean isAudioRecorderOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            if (SwitchManager.getInstance().findType(AudioRecorderSwitch.KEY_AUDIO_RECORDER_SWITCH) == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isBottomBarDynamicHeightValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
            return this.mIsBottomBarDynamicHeightValid;
        }
        return invokeV.booleanValue;
    }

    public boolean isExitAppCloseWebSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            return this.mIsExitAppCloseWebSocket;
        }
        return invokeV.booleanValue;
    }

    public boolean isFaceShopNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return this.isFaceShopNew;
        }
        return invokeV.booleanValue;
    }

    public boolean isFirstTimeMotivate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.mIsFirstTimeMotivate;
        }
        return invokeV.booleanValue;
    }

    public boolean isGifAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            if (RichTextGifViewSwitch.isOn() && isGifAutoPlayFromSetting()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isGiftSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            if (SwitchManager.getInstance().findType(GiftSwitch.GIFT_SWITCH_KEY) != 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isGpuOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            return this.mGpuOpen;
        }
        return invokeV.booleanValue;
    }

    public boolean isHeadsetModeOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            if (this.mVoiceHeadsetMode == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isHybridBridgeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            if (SwitchManager.getInstance().findType(HybridBridgeSwitch.KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isImmersiveStickyCanUse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            if (!this.isImmersiveStickyPrefHasRead) {
                this.isImmersiveStickyCanUse = n95.m().i("switch_immersive_sticky_status", true);
                this.isImmersiveStickyPrefHasRead = true;
            }
            return this.isImmersiveStickyCanUse;
        }
        return invokeV.booleanValue;
    }

    public boolean isInBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            return jw5.g().j();
        }
        return invokeV.booleanValue;
    }

    public boolean isKeyboardHeightCanUsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            if (this.keyboardHeight > getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703dc)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isMIUIRom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            String f2 = xi.f();
            if (StringUtils.isNull(f2)) {
                return false;
            }
            return f2.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI);
        }
        return invokeV.booleanValue;
    }

    public boolean isMeiZuCanUseImmersive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            if (!this.isMeiZuCanUseImmersiveHaveSet) {
                this.isMeiZuCanUseImmersiveHaveSet = true;
                if (UtilHelper.isMeizuM355()) {
                    this.isMeiZuCanUseImmersive = false;
                    return false;
                }
            }
            return this.isMeiZuCanUseImmersive;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedNewUserLead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            return this.mIsNeedNewUserLead;
        }
        return invokeV.booleanValue;
    }

    public boolean isNoInterestTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            return this.mIsNoInterestTag;
        }
        return invokeV.booleanValue;
    }

    public boolean isOfficial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            return this.mIsOfficial;
        }
        return invokeV.booleanValue;
    }

    public boolean isPageStayOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            return this.mIsPageStayOpen;
        }
        return invokeV.booleanValue;
    }

    public boolean isPushServiceOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            return loadBoolean("push_service", true);
        }
        return invokeV.booleanValue;
    }

    public boolean isRecAppExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            return this.isRecAppExist;
        }
        return invokeV.booleanValue;
    }

    public boolean isRemoteProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            return this.isRemoteProcess;
        }
        return invokeV.booleanValue;
    }

    public boolean isThemeIconCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            return p05.t().F();
        }
        return invokeV.booleanValue;
    }

    public boolean isYunPushProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            return this.isYunPushProcess;
        }
        return invokeV.booleanValue;
    }

    public void notifyAppEnterBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048766, this) == null) {
            jw5.g().m();
        }
    }

    @Override // com.baidu.tieba.g9.a
    public void onActivityClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048769, this) == null) {
            getInst().onLowMemory();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2002014));
        }
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.app.Application
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048771, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            onAppMemoryLow();
            super.onLowMemory();
        }
    }

    public void resetFontSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048781, this) == null) {
            this.mFontSize = TbadkSettings.getInst().loadInt("font_size", 2);
        }
    }

    public void sendMessageForEnterBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048788, this) == null) {
            jw5.g().r();
        }
    }

    public void setReporyUserInfoCurrentTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048856, this) == null) {
            TbadkSettings.getInst().saveLong("report_user_info_time_key" + getCurrentAccount(), System.currentTimeMillis());
        }
    }

    public void setUsed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048874, this) == null) {
            FileHelper.DataDir.cleanDirectory(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR);
            FileHelper.DataDir.createFile("/package.cur/" + TbConfig.getVersion());
        }
    }

    public boolean shouldNeedCheckUserNameDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048880, this)) == null) {
            return this.needCheckUserNameDialog;
        }
        return invokeV.booleanValue;
    }

    public int signedForumCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048881, this)) == null) {
            Hashtable<String, Integer> hashtable = this.mHasSignList;
            if (hashtable != null) {
                return hashtable.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void startActiveService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048882, this) == null) {
            getContext().startService(new Intent(getContext(), TiebaActiveService.class));
        }
    }

    public void startClearTempService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048883, this) == null) {
            try {
                getContext().startService(new Intent(getContext(), ClearTempService.class));
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public void startSyncService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048884, this) == null) {
            getContext().startService(new Intent(getContext(), TiebaSyncService.class));
        }
    }

    public void startTrackConfigRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048885, this) == null) {
            pv5 pv5Var = new pv5();
            pv5Var.c();
            pv5Var.b(new f(this));
        }
    }

    public void stopActiveServide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048886, this) == null) {
            getContext().stopService(new Intent(getContext(), TiebaActiveService.class));
        }
    }

    public void stopSyncService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048887, this) == null) {
            getContext().stopService(new Intent(getContext(), TiebaSyncService.class));
        }
    }

    public void tryLbs() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048888, this) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        this.mHandler.postDelayed(new d(this), 5000L);
    }

    public static synchronized String getUniqueIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            synchronized (TbadkCoreApplication.class) {
                if (!PermissionUtil.isAgreePrivacyPolicy()) {
                    return null;
                }
                if (mUniqueId == null) {
                    String cuid = getInst().getCuid();
                    String packageName = getInst().getApp().getPackageName();
                    String version = TbConfig.getVersion();
                    mUniqueId = cuid + "|" + packageName + version;
                }
                return mUniqueId;
            }
        }
        return (String) invokeV.objValue;
    }

    public void fixOppoTimeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                Field declaredField = Class.forName("java.lang.Daemons$FinalizerWatchdogDaemon").getDeclaredField("INSTANCE");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(null);
                Field declaredField2 = obj.getClass().getSuperclass().getDeclaredField("thread");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                declaredField2.set(obj, null);
                if (obj2 instanceof Thread) {
                    ((Thread) obj2).interrupt();
                    ((Thread) obj2).join();
                }
            } catch (ClassNotFoundException e2) {
                BdLog.e(e2);
            } catch (IllegalAccessException e3) {
                BdLog.e(e3);
            } catch (InterruptedException e4) {
                BdLog.e(e4);
            } catch (NoSuchFieldException e5) {
                BdLog.e(e5);
            }
        }
    }

    public ActivityPrizeData getActivityPrizeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.activityPrizeData == null) {
                this.activityPrizeData = new ActivityPrizeData();
                n95 m = n95.m();
                String s = m.s("activity_prize_data" + getCurrentAccount(), "");
                if (!StringUtils.isNull(s)) {
                    try {
                        this.activityPrizeData.parse(new JSONObject(s));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return this.activityPrizeData;
        }
        return (ActivityPrizeData) invokeV.objValue;
    }

    public int[] getImTimeOut() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            String loadString = TbadkSettings.getInst().loadString("socket_time_out", null);
            if (loadString == null || (split = loadString.split(WebChromeClient.PARAM_SEPARATOR)) == null || split.length != 3) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                iArr[i] = 0;
                try {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public String getLatestRelatedFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            ArrayList<SoftReference<Activity>> c2 = g9.f().c();
            String str = null;
            if (c2 == null) {
                return null;
            }
            for (int size = c2.size() - 1; size >= 0; size--) {
                SoftReference<Activity> softReference = c2.get(size);
                if (softReference != null && softReference.get() != null) {
                    Activity activity = softReference.get();
                    if (activity instanceof d95) {
                        str = ((d95) activity).w0();
                        if (!ui.isEmpty(str)) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getLatestRelatedTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            ArrayList<SoftReference<Activity>> c2 = g9.f().c();
            String str = null;
            if (c2 == null) {
                return null;
            }
            for (int size = c2.size() - 1; size >= 0; size--) {
                SoftReference<Activity> softReference = c2.get(size);
                if (softReference != null && softReference.get() != null) {
                    Activity activity = softReference.get();
                    if (activity instanceof d95) {
                        str = ((d95) activity).r1();
                        if (!ui.isEmpty(str)) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public int[] getSocketGetMsgStratgy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            int[] iArr = new int[0];
            try {
                String loadString = TbadkSettings.getInst().loadString("socket_getmsg_strategy", "");
                if (loadString != null && !TextUtils.isEmpty(loadString)) {
                    String[] split = loadString.split(",");
                    iArr = new int[split.length];
                    for (int i = 0; i < split.length; i++) {
                        iArr[i] = Integer.valueOf(split[i]).intValue();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public int[] getSocketHeartBeatStratgy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            int[] iArr = new int[0];
            try {
                String loadString = TbadkSettings.getInst().loadString("socket_heartbeat_strategy", "");
                if (loadString != null && !TextUtils.isEmpty(loadString)) {
                    String[] split = loadString.split(",");
                    iArr = new int[split.length];
                    for (int i = 0; i < split.length; i++) {
                        iArr[i] = Integer.valueOf(split[i]).intValue();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public int[] getSocketReconnStratgy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            int[] iArr = new int[0];
            try {
                String loadString = TbadkSettings.getInst().loadString("socket_reconn_strategy", "");
                if (loadString != null && !TextUtils.isEmpty(loadString)) {
                    String[] split = loadString.split(",");
                    iArr = new int[split.length];
                    for (int i = 0; i < split.length; i++) {
                        iArr[i] = Integer.valueOf(split[i]).intValue();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            try {
                if (getContext().getPackageManager() == null || getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0) == null) {
                    return 0;
                }
                return getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                BdLog.detailException(e2);
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            try {
                if (getContext().getPackageManager() == null || getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0) == null) {
                    return null;
                }
                return getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public void initCuid() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048716, this) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        String loadString = loadString("cuid", null);
        if (loadString != null && loadString.length() > 0) {
            saveString("new_cuid", loadString);
            n95.m().H("cuid");
            this.mCuid = loadString;
            return;
        }
        String loadString2 = loadString("new_cuid", null);
        this.mCuid = loadString2;
        if (loadString2 == null || loadString2.length() <= 0 || hitBadCuidAndCleanCache(this.mCuid)) {
            String cuid = DeviceId.getCUID(getContext());
            this.mCuid = cuid;
            saveString("new_cuid", cuid);
        }
    }

    public void initCyberPlayer() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048719, this) != null) || !PermissionUtil.isAgreePrivacyPolicy() || !isMainProcess(false) || CyberPlayerManager.isCoreLoaded(1)) {
            return;
        }
        try {
            CyberPlayerManager.install(getInst().getContext(), getInst().getCuidGalaxy2(), (String) null, 3, (Class<?>) CyberRemotePlayerService.class, (Map<String, String>) null, (CyberPlayerManager.InstallListener2) new e(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void initSpeedInstallStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            String latestFileName = FileHelper.DataDir.getLatestFileName(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR);
            if (TextUtils.isEmpty(latestFileName)) {
                SpeedStats.getInstance().onAppProcessUpgrade(2);
            } else if (latestFileName.equals(TbConfig.getVersion())) {
                SpeedStats.getInstance().onAppProcessUpgrade(0);
            } else {
                SpeedStats.getInstance().onAppProcessUpgrade(1);
                if (getInst().isMainProcess(false)) {
                    k95.q().m();
                }
            }
        }
    }

    public boolean isLowVersionPassV6ShouldOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            if (TbadkSettings.getInst().loadInt("passport_crash_count_" + TbConfig.getVersion(), 0) > getFeatureCrashAutoCloseLimit() || SwitchManager.getInstance().findType(LowVersionLoginPassV6Switch.KEY) == 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void loadLcsSwitchStratgy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
            if (!TextUtils.isEmpty(loadString)) {
                ue5 ue5Var = new ue5();
                ue5Var.e(loadString);
                eg5 a2 = eg5.a();
                boolean z = true;
                if (ue5Var.b() != 1) {
                    z = false;
                }
                a2.i(z);
                a2.j(ue5Var.c());
                a2.k(ue5Var.d() * 1000);
                if (ue5Var.a() != null) {
                    a2.l(ue5Var.a());
                }
            }
        }
    }

    public void onUserChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048774, this) == null) {
            if (!vi.F()) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2005007));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921410));
            le5.h0().X(true);
            NotificationHelper.cancelAllNotification(this);
            iz9.n();
        }
    }

    private boolean hitBadCuidAndCleanCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, str)) == null) {
            if ("DED0AFDB1AD0CC4CA974D5EBA0165141|VMBZI57CW".equals(str)) {
                CuidHelper.cleanSdkCache(this);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void setClientId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, str) == null) {
            clientId = str;
        }
    }

    public static void setCurrentMemberType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65569, null, i) == null) {
            p05.t().N(i);
        }
    }

    public static void setIntent(Intent intent2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, intent2) == null) {
            intent = intent2;
        }
    }

    public void SendSkinTypeBroadcast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            p05.t().a(i);
        }
    }

    public void addLikeForum(String str) {
        Hashtable<String, Integer> hashtable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (hashtable = this.mHasLikeList) != null && str != null) {
            hashtable.put(str, 1);
            setLikeBarChanged(true);
            if (this.mHasLikeList.size() > 200) {
                this.mHasLikeList.clear();
            }
        }
    }

    public boolean appResponseToCmd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (MessageManager.getInstance().findTask(i) != null) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) {
            return RegisterIntentConfigHelper.getInst().appResponseToIntentClass(cls);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            super.attachBaseContext(context);
        }
    }

    public void delLikeForum(String str) {
        Hashtable<String, Integer> hashtable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && (hashtable = this.mHasLikeList) != null && str != null) {
            hashtable.put(str, -1);
            setLikeBarChanged(true);
            if (this.mHasLikeList.size() > 200) {
                this.mHasLikeList.clear();
            }
        }
    }

    public void delRemoteActivity(Activity activity) {
        ArrayList<Activity> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, activity) == null) && (arrayList = this.mRemoteActivity) != null) {
            arrayList.remove(activity);
        }
    }

    public TbPageContext getCurrentPageContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, context)) == null) {
            if (context instanceof TbPageContextSupport) {
                return ((TbPageContextSupport) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public Class<?> getIntentClass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, cls)) == null) {
            return RegisterIntentConfigHelper.getInst().getIntentClass(cls);
        }
        return (Class) invokeL.objValue;
    }

    public int getSignLevelUpValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, str)) == null) {
            if (hasSignedForum(str)) {
                return this.mSignLevelUpList.get(str).intValue();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int hasLikeForum(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048712, this, str)) == null) {
            Hashtable<String, Integer> hashtable = this.mHasLikeList;
            if (hashtable == null || str == null || !hashtable.containsKey(str)) {
                return 0;
            }
            return this.mHasLikeList.get(str).intValue();
        }
        return invokeL.intValue;
    }

    public boolean hasSignedForum(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048713, this, str)) == null) {
            Hashtable<String, Integer> hashtable = this.mHasSignList;
            if (hashtable == null || str == null || !hashtable.containsKey(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void initVideoAutoPlay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048726, this, i) == null) {
            this.mVideoAutoPlayConfig = i;
        }
    }

    public boolean isKeyboardHeightCanSet(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048740, this, i)) == null) {
            if (i > getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703dc)) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isMainProcess(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048744, this, z)) == null) {
            return isMainProcess(z, getApplicationContext());
        }
        return invokeZ.booleanValue;
    }

    public boolean isRegistedIntent(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048756, this, cls)) == null) {
            if (getIntentClass(cls) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void notifySwitchProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048768, this, z) == null) {
            jw5.g().o(z);
        }
    }

    public void onDeviceFirstLoginChanged(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, accountData) == null) {
            if (accountData.getGrowthSwitch().equals("1") || TbSingleton.getInstance().isUserGrowthOpen()) {
                saveString("key_device_is_first_login", "0");
            }
        }
    }

    public void onUserChanged(Intent intent2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048775, this, intent2) == null) {
            if (intent2 != null) {
                String stringExtra = intent2.getStringExtra(LoginActivityConfig.USER_INFO_CHANGED);
                if (!TextUtils.isEmpty(stringExtra)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016494, stringExtra));
                }
            }
            onUserChanged();
        }
    }

    public void refreshNewVersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048777, this, z) == null) {
            this.mNeedShowNewVersion = z;
            Intent intent2 = new Intent(TbConfig.getBroadcastActionNewVersion());
            intent2.setPackage(getInst().getPackageName());
            getApp().sendBroadcast(intent2);
        }
    }

    public void removeClientId(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048780, this, context) == null) {
            n95.m().H("client_id");
        }
    }

    public void resetIsImmersiveStickyPrefHasRead(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048782, this, z) == null) {
            this.isImmersiveStickyPrefHasRead = z;
        }
    }

    public void sendAppEnterMessage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048786, this, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(i, getInst()));
        }
    }

    public void setActivityPrizeData(ActivityPrizeData activityPrizeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048790, this, activityPrizeData) == null) {
            this.activityPrizeData = activityPrizeData;
        }
    }

    public void setActivitySwitch(hc5 hc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, hc5Var) == null) {
            this.mActivitySwitch = hc5Var;
        }
    }

    public void setBDLocON(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048793, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001330, Boolean.valueOf(z)));
            TbadkSettings.getInst().saveBoolean("bd_loc_switcher", z);
        }
    }

    public void setBdNetType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048794, this, i) == null) {
            this.mBdNetType = i;
        }
    }

    public void setBottomBarDynamicHeightValid(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048795, this, z) == null) {
            this.mIsBottomBarDynamicHeightValid = z;
        }
    }

    public void setCanShowHotSplash(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048796, this, i) == null) {
            this.canShowHotSplash = i;
        }
    }

    public void setCapableOfWebp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048797, this, z) == null) {
            this.mCapableOfWebp = z;
        }
    }

    public void setCardShowType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048798, this, i) == null) {
            this.hasInit = true;
            this.cardShowType = i;
        }
    }

    public void setCheckUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048799, this, str) == null) {
            this.checkUrl = str;
        }
    }

    public void setConfigVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048800, this, str) == null) {
            this.mConfigVersion = str;
        }
    }

    public void setConsumePathData(bd5 bd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048801, this, bd5Var) == null) {
            this.mConsumePathData = bd5Var;
        }
    }

    public void setCurAiAppid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048802, this, str) == null) {
            this.mCurAiAppid = str;
        }
    }

    public void setCurGlobalActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, activity) == null) {
            WeakReference<Activity> weakReference = this.mCurGlobalActivityRef;
            if (weakReference != null) {
                weakReference.clear();
                this.mCurGlobalActivityRef = null;
            }
            if (activity != null) {
                this.mCurGlobalActivityRef = new WeakReference<>(activity);
            }
        }
    }

    public void setCurrentActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048804, this, activity) == null) {
            WeakReference<Activity> weakReference = this.mCurrentActivityRef;
            if (weakReference != null) {
                weakReference.clear();
                this.mCurrentActivityRef = null;
            }
            if (activity != null) {
                this.mCurrentActivityRef = new WeakReference<>(activity);
            }
        }
    }

    public void setDefaultBubble(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048805, this, str) == null) {
            this.mDefaultBubble = str;
        }
    }

    public void setDefaultBubbleDynamicRes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, str) == null) {
            this.mDefaultBubbleDynamicRes = str;
        }
    }

    public void setDefaultBubbleEndTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048807, this, i) == null) {
            this.mDefaultBubbleEndTime = i;
        }
    }

    public void setExitAppCloseWebSocket(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048808, this, z) == null) {
            this.mIsExitAppCloseWebSocket = z;
        }
    }

    public void setFaceShopNew(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048809, this, z) == null) {
            this.isFaceShopNew = z;
        }
    }

    public void setFaceShopVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048810, this, i) == null) {
            this.mFaceShopVersion = i;
            TbadkSettings.getInst().saveInt("faceshop_version", this.mFaceShopVersion);
        }
    }

    public void setFeatureCrashAutoCloseLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048811, this, i) == null) {
            TbadkSettings.getInst().saveInt("feature_crash_auto_close_limit", i);
        }
    }

    public void setFontSize(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048812, this, i) != null) || this.mFontSize == i) {
            return;
        }
        this.mFontSize = i;
        TbadkSettings.getInst().saveInt("font_size", i);
    }

    public void setFramework_ver(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, str) == null) {
            saveString("framework_ver", str);
        }
    }

    public void setFriendFeedNew(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048814, this, z) == null) {
            this.mHandler.post(new a(this, z));
        }
    }

    public void setGpuOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048815, this, z) == null) {
            TbadkSettings.getInst().saveBoolean("gpu_open", z);
            this.mGpuOpen = z;
        }
    }

    public void setHeadsetModeOn(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048816, this, z) != null) || this.mVoiceHeadsetMode == z) {
            return;
        }
        this.mVoiceHeadsetMode = z ? 1 : 0;
        TbadkSettings.getInst().saveInt("voice_headset_mode", z ? 1 : 0);
    }

    public void setHomeBarShowType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048817, this, i) == null) {
            this.homeBarShowType = i;
        }
    }

    public void setHttpsWhileData(hd5 hd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048818, this, hd5Var) == null) {
            this.mHttpsWhileData = hd5Var;
        }
    }

    public void setInstallOtherApp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048820, this, str) == null) {
            TbadkSettings.getInst().saveString("install_other_app_file_name", str);
        }
    }

    public void setInterestBoardConfigData(kd5 kd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048821, this, kd5Var) == null) {
            this.mInterestBoardConfigData = kd5Var;
        }
    }

    public void setIsAbstractOn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048822, this, i) == null) {
            this.mIsAbstractOn = i;
            TbadkSettings.getInst().saveInt("new_abstract_state", i);
        }
    }

    public void setIsAppOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048823, this, z) == null) {
            TbadkSettings.getInst().saveBoolean("app_switcher", z);
        }
    }

    public void setIsFirstTimeMotivate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048824, this, z) == null) {
            this.mIsFirstTimeMotivate = z;
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921029));
            }
        }
    }

    public void setIsLocationON(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048825, this, z) == null) {
            this.mIsLocationOn = z;
            TbadkSettings.getInst().saveBoolean("location_on", z);
        }
    }

    public void setIsNeedNewUserLead(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048826, this, i) == null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            this.mIsNeedNewUserLead = z;
            if (z) {
                n95.m().A("key_new_user_logon_time", System.currentTimeMillis());
            }
        }
    }

    public void setIsNewRegUser(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048827, this, z) == null) {
            this.mIsNewRegUser = z;
        }
    }

    public void setIsNoInterestTag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048828, this, z) == null) {
            this.mIsNoInterestTag = z;
        }
    }

    public void setIsPushServiceOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048829, this, z) == null) {
            saveBoolean("push_service", z);
        }
    }

    public void setKeepaliveNonWifi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048830, this, i) == null) {
            saveInt("keepalive_nonwifi", i);
        }
    }

    public void setKeepaliveWifi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048831, this, i) == null) {
            saveInt("keepalive_wifi", i);
        }
    }

    public void setKeyboardHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048832, this, i) == null) {
            this.keyboardHeight = i;
        }
    }

    public void setLastNotifyTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048833, this, j) == null) {
            TbadkSettings.getInst().saveLong("last_notify_sound_time", j);
        }
    }

    public void setLastUpdateMemberCenterTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048834, this, j) == null) {
            this.lastUpdateMemberCenterTime = j;
        }
    }

    public void setLcsSwitchStratgy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048835, this, str) == null) {
            if (str == null) {
                str = "";
            }
            TbadkSettings.getInst().saveString("lcs_switch_strategy", str);
        }
    }

    public void setLibcrypto(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048836, this, str) == null) {
            this.mLibcrypto = str;
        }
    }

    public void setLibcyberVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048837, this, str) == null) {
            this.mLibcyberVersion = str;
        }
    }

    public void setLibcyberffmpeg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048838, this, str) == null) {
            this.mLibcyberffmpeg = str;
        }
    }

    public void setLibssl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048839, this, str) == null) {
            this.mLibssl = str;
        }
    }

    public void setLikeBarChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048840, this, z) == null) {
            this.mLikeChanged = z;
        }
    }

    public void setLocationLat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048841, this, str) == null) {
            TbadkSettings.getInst().saveString("location_lat", str);
        }
    }

    public void setLocationLng(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048842, this, str) == null) {
            TbadkSettings.getInst().saveString("location_lng", str);
        }
    }

    public void setLocationPos(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048843, this, str) == null) {
            TbadkSettings.getInst().saveString("location_pos", str);
        }
    }

    public void setLocationShared(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048844, this, z) == null) {
            TbadkSettings inst = TbadkSettings.getInst();
            inst.saveBoolean("location_shared_" + getCurrentAccount(), z);
            if (z) {
                tryLbs();
            }
        }
    }

    public void setMainActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048845, this, activity) == null) {
            this.mMainActivity = activity;
        }
    }

    public void setNaws_game_ver(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048846, this, str) == null) {
            saveString("naws_game_ver", str);
        }
    }

    public void setNeedCheckUserNameDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048847, this, z) == null) {
            this.needCheckUserNameDialog = z;
        }
    }

    public void setNetWorkCoreType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048848, this, i) == null) {
            NetWorkCoreFacotry.setNetType(i);
            saveInt("networkcore_type", i);
        }
    }

    public void setNewVcodeWebviewCrashCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048849, this, i) == null) {
            this.mNewVcodeWebviewCrashCount = i;
        }
    }

    public void setPageStayOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048850, this, z) == null) {
            this.mIsPageStayOpen = z;
        }
    }

    public void setPerformSampleCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048851, this, i) == null) {
            this.mPerformSampleCount = i;
            TbadkSettings.getInst().saveInt("perform_sample_count", i);
        }
    }

    public void setProxyIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048853, this, str) == null) {
            this.proxyIp = str;
        }
    }

    public void setProxyPort(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048854, this, str) == null) {
            this.proxyPort = str;
        }
    }

    public void setRecAppExist(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048855, this, z) == null) {
            this.isRecAppExist = z;
        }
    }

    public void setSdk_ver(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048857, this, str) == null) {
            this.sdk_ver = str;
        }
    }

    public void setShareItem(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048858, this, shareItem) == null) {
            this.mShareItem = shareItem;
        }
    }

    public void setSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048859, this, i) == null) {
            p05.t().O(i);
        }
    }

    public void setSkinTypeValue(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048860, this, i) == null) {
            p05.t().P(i);
        }
    }

    public void setSocketGetMsgStratgy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048861, this, str) == null) {
            TbadkSettings.getInst().saveString("socket_getmsg_strategy", str);
        }
    }

    public void setSocketHeartBeatStratgy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048862, this, str) == null) {
            TbadkSettings.getInst().saveString("socket_heartbeat_strategy", str);
        }
    }

    public void setSocketReconnStratgy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048863, this, str) == null) {
            TbadkSettings.getInst().saveString("socket_reconn_strategy", str);
        }
    }

    public void setStartType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048864, this, i) == null) {
            this.startType = i;
        }
    }

    public void setTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048865, this, str) == null) {
            this.task_id = str;
        }
    }

    public void setTbs(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048866, this, str) == null) {
            p05.t().Q(str);
        }
    }

    public void setTempFaceShopVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048867, this, i) == null) {
            this.mTempFaceShopVersion = i;
        }
    }

    public void setTempFontSize(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048868, this, i) != null) || this.mFontSize == i) {
            return;
        }
        this.mFontSize = i;
    }

    public void setThemeWebviewOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048869, this, z) == null) {
            this.mThemeWebviewOpened = z;
        }
    }

    public void setUegVoiceWarning(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048870, this, str) == null) {
            this.uegVoiceWarning = str;
        }
    }

    public void setUpdateNotifyTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048871, this, j) == null) {
            TbadkSettings.getInst().saveLong("update_notify_time", j);
        }
    }

    public void setUseNewResign(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048872, this, i) == null) {
            this.useNewResign = i;
        }
    }

    public void setUseTimeInterval(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048873, this, j) == null) {
            n95.m().A("use_time_interval", j);
            this.useTimeInterval = j;
        }
    }

    public void setVersionData(VersionData versionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048875, this, versionData) == null) {
            this.mVersionData = versionData;
        }
    }

    public void setVideoAutoPlay(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048876, this, i) != null) || this.mVideoAutoPlayConfig == i) {
            return;
        }
        this.mVideoAutoPlayConfig = i;
        TbadkSettings.getInst().saveInt("video_auto_play_new", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921511, ""));
    }

    public void setWebviewCrashCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048877, this, i) == null) {
            this.mWebviewCrashCount = i;
            TbadkSettings.getInst().saveInt("webview_crash_count", i);
        }
    }

    public void setYunpushChannelId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048878, this, str) == null) {
            n95.m().B("yunpush_channel_id", str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048889, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    public void upgradeAbstractOnInMemory(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048890, this, i) == null) {
            this.mIsAbstractOn = i;
        }
    }

    public static void saveClientId(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65564, null, context, str) == null) && str != null && str.length() > 0) {
            n95.m().B("client_id", TbConfig.getVersion() + "\t" + str);
        }
    }

    public void setPromotedMessage(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048852, this, str, z) == null) {
            TbadkSettings.getInst().saveBoolean("permoted_message_" + str, z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
        }
    }

    public static void setBdussAndTbsFromBackgroundInRelogin(AccountData accountData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65565, null, accountData, str, str2) == null) {
            p05.t().J(accountData, str, str2);
        }
    }

    public void addRemoteActivity(Activity activity) {
        ArrayList<Activity> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, activity) == null) && (arrayList = this.mRemoteActivity) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                try {
                    Activity activity2 = this.mRemoteActivity.get(i);
                    if (activity2 instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) activity2).releaseResouce();
                    } else if (activity2 instanceof BaseActivity) {
                        ((BaseActivity) activity2).releaseResouce();
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            if (activity != null) {
                this.mRemoteActivity.add(activity);
            }
        }
    }

    public Sensor getDefaultSensor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i)) == null) {
            if (PermissionUtil.isBrowseMode()) {
                return null;
            }
            if (this.sensorMap == null) {
                this.sensorMap = new HashMap(5);
            }
            Sensor sensor = this.sensorMap.get(Integer.valueOf(i));
            if (sensor == null) {
                SensorManager sensorManager = (SensorManager) getInst().getSystemService("sensor");
                if (sensorManager == null) {
                    return null;
                }
                Sensor defaultSensor = sensorManager.getDefaultSensor(i);
                this.sensorMap.put(Integer.valueOf(i), defaultSensor);
                return defaultSensor;
            }
            return sensor;
        }
        return (Sensor) invokeI.objValue;
    }

    public String readClientId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048776, this, context)) == null) {
            String loadString = loadString("client_id", null);
            if (loadString != null) {
                int indexOf = loadString.indexOf("\t");
                if (indexOf != -1) {
                    if (TbConfig.getVersion().equals(loadString.substring(0, indexOf))) {
                        loadString = loadString.substring(indexOf + 1);
                    } else {
                        removeClientId(getContext());
                        return null;
                    }
                } else {
                    removeClientId(getContext());
                    return null;
                }
            }
            return loadString;
        }
        return (String) invokeL.objValue;
    }

    public void setImTimeOut(int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048819, this, iArr) == null) && iArr != null && iArr.length == 3) {
            StringBuilder sb = new StringBuilder(20);
            for (int i : iArr) {
                sb.append(i);
                sb.append("|");
            }
            TbadkSettings.getInst().saveString("socket_time_out", sb.toString());
            tb.c().d(iArr[0], iArr[1], iArr[2]);
        }
    }

    public void addSignedForum(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i, i2) == null) && !TextUtils.isEmpty(str) && this.mHasSignList != null && this.mSignLevelUpList != null && !hasSignedForum(str)) {
            this.mHasSignList.put(str, Integer.valueOf(i));
            this.mSignLevelUpList.put(str, Integer.valueOf(i2));
        }
    }

    public String getActiveVersion() {
        InterceptResult invokeV;
        String latestFileName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (!FileHelper.DataDir.checkFile(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR)) {
                latestFileName = TbadkSettings.getInst().loadString("active_version", "");
            } else {
                latestFileName = FileHelper.DataDir.getLatestFileName(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR);
            }
            if (ACTIVE_CLEAR_TAG.equals(latestFileName)) {
                return null;
            }
            return latestFileName;
        }
        return (String) invokeV.objValue;
    }

    public String getDeviceIsFirstLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            String loadString = loadString("key_device_is_first_login", "1");
            if (isLogin() && TbSingleton.getInstance().isUserGrowthOpen() && "1".equals(loadString)) {
                saveString("key_device_is_first_login", "0");
                return loadString("key_device_is_first_login", "0");
            }
            return loadString;
        }
        return (String) invokeV.objValue;
    }

    public DhcpInfo getDhcpInfo() {
        InterceptResult invokeV;
        DhcpInfo dhcpInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.dhcpInfo == null) {
                try {
                    if (PermissionUtil.isAgreePrivacyPolicy()) {
                        WifiManager wifiManager = (WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi");
                        if (wifiManager != null) {
                            dhcpInfo = wifiManager.getDhcpInfo();
                        } else {
                            dhcpInfo = null;
                        }
                        this.dhcpInfo = dhcpInfo;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.dhcpInfo;
        }
        return (DhcpInfo) invokeV.objValue;
    }

    public boolean getIsFirstUse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (FileHelper.DataDir.checkFile("/package.cur/" + TbConfig.getVersion())) {
                return false;
            }
            setActiveVersion(FileHelper.DataDir.getLatestFileName(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR));
            return true;
        }
        return invokeV.booleanValue;
    }

    public void incPassportV6CrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            String str = "passport_crash_count_" + TbConfig.getVersion();
            TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
        }
    }

    public void incWalletSdkCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            String str = "wallet_crash_count" + TbConfig.getVersion();
            TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
        }
    }

    public void initCuidGalaxy2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048717, this) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        String loadString = loadString("new_cuid_galaxy2", null);
        this.cuid_galaxy2 = loadString;
        if (loadString == null || loadString.length() <= 0 || hitBadCuidAndCleanCache(this.cuid_galaxy2)) {
            String cuid = DeviceId.getCUID(getContext());
            this.cuid_galaxy2 = cuid;
            saveString("new_cuid_galaxy2", cuid);
        }
    }

    public void initCuidGalaxy3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048718, this) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        String loadString = loadString("new_cuid_galaxy3", null);
        this.cuid_galaxy3 = loadString;
        if (loadString == null || loadString.length() <= 0) {
            String c2 = j30.f(getContext()).c();
            this.cuid_galaxy3 = c2;
            saveString("new_cuid_galaxy3", c2);
        }
    }

    public boolean isBaiduYunPushAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            if (TbadkSettings.getInst().loadInt("baidu_yun_push_sdk_crash_count_" + TbConfig.getVersion(), 0) > getFeatureCrashAutoCloseLimit() || SwitchManager.getInstance().findType(BaiduYunPushSdkSwitch.BAIDU_YUN_PUSH_SDK_KEY) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isMainTabActivity() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            Activity e2 = g9.f().e(g9.f().g() - 1);
            if (e2 != null) {
                str = e2.getLocalClassName();
            } else {
                str = "";
            }
            if (!StringUtils.isNull(str) && str.contains("MainTabActivity")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isPassportV6ShouldOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            if (TbadkSettings.getInst().loadInt("passport_crash_count_" + TbConfig.getVersion(), 0) > getFeatureCrashAutoCloseLimit()) {
                return false;
            }
            return !LoginPassV6Switch.isSwitchOld();
        }
        return invokeV.booleanValue;
    }

    public boolean isWalletShouldOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            if (TbadkSettings.getInst().loadInt("wallet_crash_count" + TbConfig.getVersion(), 0) > getFeatureCrashAutoCloseLimit()) {
                return false;
            }
            return WalletSwitch.isSwitchOn();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseApplication
    public void onAppMemoryLow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048770, this) == null) {
            int C = TbImageMemoryCache.u().C();
            int max = (int) Math.max(C * 0.8d, TbConfig.getBigImageMaxUsedMemory());
            if (max < C) {
                BdLog.isDebugMode();
                TbImageMemoryCache.u().L(max);
            }
            BitmapHelper.clearCashBitmap();
            oi.d().b();
        }
    }

    public gn getFace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
            SoftReference<gn> softReference = this.mFaces.get(str);
            if (softReference != null && softReference.get() != null) {
                return softReference.get();
            }
            gn a2 = TbFaceManager.i().a(str);
            if (a2 != null) {
                this.mFaces.put(str, new SoftReference<>(a2));
            }
            return a2;
        }
        return (gn) invokeL.objValue;
    }

    public boolean isPromotedMessageOn(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048753, this, str)) == null) {
            String str2 = "permoted_message_" + str;
            if (TbadkSettings.getInst().isContains(str2)) {
                return TbadkSettings.getInst().loadBoolean(str2, true);
            }
            return this.mPromotedMessageOn;
        }
        return invokeL.booleanValue;
    }

    public void setActiveVersion(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048789, this, str) == null) && !ui.isEmpty(str) && !StringUtil.NULL_STRING.equals(str)) {
            FileHelper.DataDir.cleanDirectory(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR);
            FileHelper.DataDir.createFile("/package.last/" + str);
        }
    }

    public void setAdAdSense(ic5 ic5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048792, this, ic5Var) == null) {
            this.mAdAdSense = ic5Var;
            if (ic5Var != null && ic5Var.a() != null) {
                pc5 a2 = this.mAdAdSense.a();
                MessageManager.getInstance().registerStickyMode(2001434);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001434, a2));
            }
        }
    }

    public String getZid(Context context, String str, int i, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048710, this, context, str, i, str2)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                return FH.gzfi(context, str, i, str2);
            }
            return "000";
        }
        return (String) invokeLLIL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048779, this, broadcastReceiver, intentFilter, str, handler)) == null) {
            try {
                return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
            } catch (Throwable unused) {
                return new Intent();
            }
        }
        return (Intent) invokeLLLL.objValue;
    }

    public boolean isMainProcess(boolean z, Context context) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048745, this, z, context)) == null) {
            Boolean bool = this._isMainProcess;
            if (bool != null) {
                return bool.booleanValue();
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return z;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return z;
            }
            String packageName = context.getPackageName();
            String str = packageName + ":cdnTachometer";
            String str2 = packageName + ":daemon";
            String str3 = packageName + ":remote";
            String str4 = packageName + ":third";
            String[] strArr = {str3, str, packageName + ":bdservice_v1", packageName + ":live", packageName + ":cdnTachometer", str2, packageName + ":media", packageName + ":kmyas__"};
            String str5 = packageName + ":guardService";
            String str6 = packageName + ":warkup";
            String str7 = packageName + ":swan";
            String str8 = packageName + ":bdservice_v1";
            int myPid = Process.myPid();
            int i = 0;
            while (true) {
                if (i >= runningAppProcesses.size()) {
                    break;
                } else if (runningAppProcesses.get(i).pid == myPid) {
                    String str9 = runningAppProcesses.get(i).processName;
                    if (str9 == null) {
                        return z;
                    }
                    if (str9.equalsIgnoreCase(str2)) {
                        this.isDaemonProcess = true;
                    }
                    if (str9.equalsIgnoreCase(str8)) {
                        this.isYunPushProcess = true;
                    }
                    if (str9.equalsIgnoreCase(packageName)) {
                        this._isMainProcess = Boolean.TRUE;
                        return true;
                    }
                    if (str9.equalsIgnoreCase(str)) {
                        this.isCdnTachometerProcess = Boolean.TRUE;
                    }
                    if (str9.equalsIgnoreCase(str3)) {
                        this.isRemoteProcess = true;
                    }
                    if (str9.equalsIgnoreCase(str4)) {
                        this.isThirdProcess = true;
                    }
                    if (!str9.equalsIgnoreCase(str5) && !str9.equalsIgnoreCase(str6)) {
                        if (str9.contains(str7)) {
                            this.isAiAppsProcess = true;
                            this._isMainProcess = Boolean.FALSE;
                            return false;
                        }
                        for (int i2 = 0; i2 < 8; i2++) {
                            if (str9.equalsIgnoreCase(strArr[i2])) {
                                this._isMainProcess = Boolean.FALSE;
                                return false;
                            }
                        }
                    } else {
                        this.isKeepLiveProcess = true;
                        this._isMainProcess = Boolean.FALSE;
                        return false;
                    }
                } else {
                    i++;
                }
            }
            return z;
        }
        return invokeZL.booleanValue;
    }

    public void notifyPageCountDelta(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048767, this, i, str) == null) {
            int pageCount = TbSingleton.getInstance().getPageCount();
            if (i > 0) {
                if (pageCount == 0) {
                    sendAppEnterMessage(2921809);
                    zq8 defaultLog = DefaultLog.getInstance();
                    defaultLog.c("PageCountBackground", "APP ENTER FOREGROUND activity " + str);
                }
                TbSingleton.getInstance().setPageCount(pageCount + i);
            } else if (i < 0) {
                int i2 = pageCount + i;
                if (i2 == 0) {
                    sendAppEnterMessage(2921810);
                    zq8 defaultLog2 = DefaultLog.getInstance();
                    defaultLog2.c("PageCountBackground", "APP ENTER BACKGROUND activity " + str);
                }
                TbSingleton.getInstance().setPageCount(i2);
            }
        }
    }

    public void sendImagePv(int i, int i2, String str, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048787, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.imagePvThread == null) {
                this.imagePvThread = Executors.newSingleThreadExecutor();
            }
            cx5 cx5Var = new cx5(i, i2);
            cx5Var.a(str);
            this.imagePvThread.execute(cx5Var);
            TiebaStatic.eventStat(getInst().getApp(), "img_browse", null, 1, "img_num", Integer.valueOf(i), "img_total", Integer.valueOf(i2), "img_type", str, "img_begin", Integer.valueOf(i3), "img_end", Integer.valueOf(i4));
        }
    }

    public boolean shouldGPUOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048879, this)) == null) {
            String trim = xi.g().trim();
            boolean z = true;
            if (trim == null) {
                return true;
            }
            String[] strArr = {"M040", "M032", "M031", "M030", "HUAWEI C8813", "ZTE U970", "MediaPad 10 FHD", "GT-I9000", "DOEASY E930", "H8205", "GT-N7108", "GT-N7102", "GT-N719", "GT-N7100", "galaxy nexus", " ZTE U808", "UMI_X1", "nexus s", "AMOI N820", "JY-G", "XT885", "U701T", "Lenovo A750", "ZTE U807", "vivo S11t", "Droid Bionic", "MORAL_N01", "XT910", "GT-S7562", "Lenovo A798t", "vivo E5", "U705T", "HUAWEI T8951", "ME865", "HUAWEI P1XL", "KPT A9PLUS", "vivo Y11", "T9200", "XT928", "HUAWEI Y500-T00", "BBK Y3t", "Lenovo K860", "vivo X1", "HUAWEI T8833", "Lenovo A789", "ZTE U960E"};
            int i = 0;
            while (true) {
                if (i >= 46) {
                    break;
                } else if (strArr[i].equalsIgnoreCase(trim)) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            BdLog.isDebugMode();
            return z;
        }
        return invokeV.booleanValue;
    }
}
