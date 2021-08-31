package com.baidu.tbadk.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.b;
import c.a.e.a.k.a;
import c.a.e.e.i.a;
import c.a.e.e.p.l;
import c.a.p0.a1.a;
import c.a.p0.b1.a0;
import c.a.p0.b1.h0;
import c.a.p0.b1.k;
import c.a.p0.b1.k0;
import c.a.p0.b1.x;
import c.a.p0.s.q.z0;
import c.a.p0.t.c.b0;
import c.a.p0.t.c.e0;
import c.a.p0.t.c.z;
import c.a.r.f.a.b;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketDaemonService;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.cmdRouter.CmdRouter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.nps.NPSHookManager;
import com.baidu.searchbox.StartupCountStatsController;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.logsystem.basic.Loki;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.performance.speed.task.LaunchTaskSchedule;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ruka.Ruka;
import com.baidu.searchbox.taskmanager.ApplicationTaskPool;
import com.baidu.searchbox.taskmanager.IdleLaunchTaskManager;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.sofire.ac.FH;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CertVerifyHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.InputMethodManagerLeaksFixer;
import com.baidu.tbadk.core.util.NetWorkCoreFacotry;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.RegisterIntentConfigHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.switchs.AccountsDataFromPassSwitch;
import com.baidu.tbadk.switchs.AppUploadSwitch;
import com.baidu.tbadk.switchs.AudioRecorderSwitch;
import com.baidu.tbadk.switchs.BaiduYunPushSdkSwitch;
import com.baidu.tbadk.switchs.CrabSdkSwitch;
import com.baidu.tbadk.switchs.GiftSwitch;
import com.baidu.tbadk.switchs.HybridBridgeSwitch;
import com.baidu.tbadk.switchs.LaunchUpSpeedSwitch;
import com.baidu.tbadk.switchs.LbsWebViewSwitch;
import com.baidu.tbadk.switchs.LoginPassV6Switch;
import com.baidu.tbadk.switchs.LowVersionLoginPassV6Switch;
import com.baidu.tbadk.switchs.PluginClassChangeSwitch;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.tbadk.switchs.UseNewMethodCheckLogoSwitch;
import com.baidu.tbadk.switchs.WalletSwitch;
import com.baidu.tbadk.switchs.XiaomiPushSdkSwitch;
import com.baidu.tbadk.switchs.XiaomiWebViewInitSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.tieba.play.cyberPlayer.CyberRemotePlayerService;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.titan.sdk.initer.TitanIniter;
import com.baidu.titan.sdk.loader.LoaderManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCIPCManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
@ModifyClass
/* loaded from: classes6.dex */
public class TbadkCoreApplication extends BdBaseApplication implements b.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ACTION_TEST = 1;
    public static final String ACTIVE_CLEAR_TAG = "active_clear";
    public static final int APP_EVENT_LOGIN = 1;
    public static final String DEFAULT_IMEI = "000000000000000";
    public static boolean IS_APP_RUNNING = false;
    public static boolean IS_SUPPORT_EXCEPTION_HANDLER = true;
    public static boolean IS_SUPPORT_SWIPEBACK = true;
    public static final int LOAD_INIT_EIGHT = 8;
    public static final int LOAD_INIT_FIVE = 5;
    public static final int LOAD_INIT_FOUR = 4;
    public static final int LOAD_INIT_NINE = 9;
    public static final int LOAD_INIT_ONE = 1;
    public static final int LOAD_INIT_SEVEN = 7;
    public static final int LOAD_INIT_SIX = 6;
    public static final int LOAD_INIT_THREE = 3;
    public static final int LOAD_INIT_TWO = 2;
    public static String clientId = null;
    public static Intent intent = null;
    public static boolean isChushouInit = false;
    public static final String isMem = "IsMem_";
    public static boolean isMyLive;
    public static boolean isNeedRefreshOnResume;
    public static boolean isSDKLogin;
    public static String mUniqueId;
    public static TbadkCoreApplication sApp;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean _isMainProcess;
    public c.a.p0.t.c.b activityPrizeData;
    public ApplicationTaskPool applicationTaskPool;
    public int canShowHotSplash;
    public int cardShowType;
    public String checkUrl;
    public String cuid_galaxy2;
    public String cuid_galaxy3;
    public String cuid_gid;
    public long currentAccountFlowerNum;
    public long currentAccountTdouNum;
    public String framework_ver;
    public Handler handler;
    public boolean hasInit;
    public int homeBarShowType;
    public int hybridBridgeTimeout;
    public ExecutorService imagePvThread;
    public String infoIconUrl;
    public String infoTargetUrl;
    public long infoTimeStamp;
    public boolean isAiAppsProcess;
    public boolean isAudioRecorderExist;
    public boolean isBackground;
    public Boolean isCdnTachometerProcess;
    public boolean isDaemonProcess;
    public boolean isFaceShopNew;
    public boolean isFriendFeedNew;
    public boolean isImmersiveStickyCanUse;
    public boolean isImmersiveStickyPrefHasRead;
    public boolean isKeepLiveProcess;
    public boolean isMeiZuCanUseImmersive;
    public boolean isMeiZuCanUseImmersiveHaveSet;
    public boolean isPhoneCalling;
    public boolean isPluginInstallProcess;
    public boolean isReadMenuDialogTop;
    public boolean isRecAppExist;
    public boolean isRemoteProcess;
    public boolean isThirdProcess;
    public boolean isYunPushProcess;
    public int keyboardHeight;
    public long lastUpdateMemberCenterTime;
    public long lastUpdateThemeTime;
    public b0 listItemRule;
    public a.c locationCallBack;
    public c.a.p0.t.c.c mActivitySwitch;
    public c.a.p0.t.c.d mAdAdSense;
    public String mAndroidId;
    public boolean mCapableOfWebp;
    public String mChannelId;
    public CombineDownload mCombineDownload;
    public String mConfigVersion;
    public c.a.p0.t.c.u mConsumePathData;
    public c.a.p0.s.j mCoreActivityLifecycleCallbacks;
    public String mCuid;
    public String mCurAiAppid;
    public WeakReference<Activity> mCurrentActivityRef;
    public View mCustomToastView;
    public c.a.p0.s.f mCustomizedFilter;
    public String mDefaultBubble;
    public int mDefaultBubbleEndTime;
    public CustomMessageListener mDescriptionTableFixListener;
    public int mFaceShopVersion;
    public HashMap<String, SoftReference<c.a.e.l.d.a>> mFaces;
    public int mFontSize;
    public SparseArray<FrsNetModel> mFrsModelArray;
    public boolean mGpuOpen;
    public final Handler mHandler;
    public Hashtable<String, Integer> mHasLikeList;
    public boolean mHasNewVersion;
    public Hashtable<String, Integer> mHasSignList;
    public String mImei;
    public long mInitTime;
    public String mInstallAppIds;
    public z mInterestBoardConfigData;
    public long mInterviewLivePollingInterval;
    public int mIsAbstractOn;
    public boolean mIsAppOn;
    public boolean mIsExitAppCloseWebSocket;
    public boolean mIsFirstTimeMotivate;
    public boolean mIsLocationOn;
    public boolean mIsNeedNewUserLead;
    public boolean mIsNewRegUser;
    public boolean mIsNoInterestTag;
    public boolean mIsOfficial;
    public boolean mIsPageStayOpen;
    public boolean mIsToLogo;
    public long mLastSyncFinishTime;
    public boolean mLikeChanged;
    public String mMultidexError;
    public boolean mNeedShowNewVersion;
    public boolean mNeedUploadMultidexError;
    public int mNewVcodeWebviewCrashCount;
    public int mPerformSampleCount;
    public c.a.q0.i3.o0.c mPhotoLiveReadHistory;
    public int mPicReqSwitchType;
    public boolean mPluginIsInited;
    public final Object mPluginNotify;
    public e0 mProfileData;
    public boolean mPromotedMessageOn;
    public c.a.q0.i3.o0.d mReadThreadHistory;
    public int mReadThreadPlayerScreenMaxHeight;
    public ArrayList<BaseActivity<?>> mRemoteActivity;
    public ShareItem mShareItem;
    public Hashtable<String, Integer> mSignLevelUpList;
    public c.a.q0.z1.a mSplash;
    public int mTempFaceShopVersion;
    public boolean mThemeWebviewOpened;
    public l.c mToast;
    public boolean mUseHttpAutoSwitch;
    public boolean mUseHttpClient;
    public VersionData mVersionData;
    public int mVideoAutoPlayConfig;
    public int mVoiceHeadsetMode;
    public SparseArray<Integer> mWaitDownloadTheme;
    public int mWebviewCrashCount;
    public String mYijianfankuiFname;
    public boolean needCheckUserNameDialog;
    public PayMemberInfoData payInfo;
    public long processCreateTime;
    public String proxyIp;
    public String proxyPort;
    public String sdk_ver;
    public boolean showPayInfoRedTip;
    public int startType;
    public String swan_game_ver;
    public boolean syncHasFinish;
    public String task_id;
    public String uegVoiceWarning;
    public String urlText;
    public int useNewResign;
    public long useTimeInterval;

    /* loaded from: classes6.dex */
    public class a implements c.a.p0.b1.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47267a;

        public a(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47267a = tbadkCoreApplication;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null) {
                return;
            }
            this.f47267a.mIsOfficial = bool.booleanValue();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements CustomMessageTask.CustomRunnable<Intent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47268e;

        public b(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47268e = tbadkCoreApplication;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                UtilHelper.commenDealIntent(c.a.e.a.b.f().b() == null ? this.f47268e.getApp() : c.a.e.a.b.f().b(), customMessage.getData());
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47269a;

        public c(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47269a = tbadkCoreApplication;
        }

        @Override // c.a.e.e.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) && i2 == 0 && address != null) {
                try {
                    String valueOf = String.valueOf(address.getLatitude());
                    String valueOf2 = String.valueOf(address.getLongitude());
                    if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(valueOf2)) {
                        return;
                    }
                    this.f47269a.setLocationLat(valueOf);
                    this.f47269a.setLocationLng(valueOf2);
                    this.f47269a.setLocationPos(address.getAddressLine(0));
                    c.a.q0.x2.j0.a.e().i(valueOf);
                    c.a.q0.x2.j0.a.e().j(valueOf2);
                    c.a.q0.x2.j0.a.e().k(System.currentTimeMillis());
                } catch (IllegalStateException e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47270e;

        public d(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47270e = tbadkCoreApplication;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.e.e.i.a.l().i(true, this.f47270e.locationCallBack);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements a.InterfaceC0028a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.e.a.k.a.InterfaceC0028a
        public void a(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                TbadkCoreApplication.resetTDatabaseCreateTime();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements CustomMessageTask.CustomRunnable<z0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47271e;

        public f(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47271e = tbadkCoreApplication;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<z0> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                UtilHelper.showYYNotification(this.f47271e.getContext(), customMessage.getData(), 13);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements c.a.e.c.e.c.k.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47272a;

        public g(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47272a = tbadkCoreApplication;
        }

        @Override // c.a.e.c.e.c.k.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !this.f47272a.isExitAppCloseWebSocket() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements c.a.e.c.e.c.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements k.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.p0.b1.k.b
            public void onResult(boolean z) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z) {
                    return;
                }
                c.a.p0.e0.a.b(0, 0, 0, 1, 8);
                BdSocketLinkService.startService(false, "restart");
            }
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.e.c.e.c.k.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.b1.k.e().c(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47273a;

        public i(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47273a = tbadkCoreApplication;
        }

        @Override // c.a.p0.a1.a.b
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                c.a.e.e.n.g.h(z2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47274a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(TbadkCoreApplication tbadkCoreApplication, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47274a = tbadkCoreApplication;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.i3.m0.d.d)) {
                c.a.q0.i3.m0.d.d dVar = (c.a.q0.i3.m0.d.d) customResponsedMessage.getData();
                DescriptionTableInfo.setModuleSet(dVar.f20402a);
                DescriptionTableInfo.setDescriptionTable(dVar.f20403b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends h0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47275a;

        public k(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47275a = tbadkCoreApplication;
        }

        @Override // c.a.p0.b1.h0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if ("12.1.0.1".equals(FileHelper.DataDir.getLatestVersion())) {
                    FileHelper.DataDir.cleanDirectory("/newStat");
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47276a;

        public l(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47276a = tbadkCoreApplication;
        }

        @Override // c.a.e.e.p.l.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47276a.mCustomToastView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.custom_toast_textview, (ViewGroup) null);
            }
        }

        @Override // c.a.e.e.p.l.c
        public void b(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (c() instanceof TextView)) {
                ((TextView) c()).setText(str);
            }
        }

        @Override // c.a.e.e.p.l.c
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f47276a.mCustomToastView : (View) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47278f;

        public m(TbadkCoreApplication tbadkCoreApplication, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47278f = tbadkCoreApplication;
            this.f47277e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new c.a.p0.g0.a(this.f47277e)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47279e;

        public n(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47279e = tbadkCoreApplication;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1) {
                    c.a.p0.s.z.a.a("account", -1L, 0, "application_clear_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(null, this.f47279e.getContext());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.f47279e.getContext(), true)));
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BDHttpDns f47280e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47281f;

        public o(TbadkCoreApplication tbadkCoreApplication, BDHttpDns bDHttpDns) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication, bDHttpDns};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47281f = tbadkCoreApplication;
            this.f47280e = bDHttpDns;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47280e.p(PrefetchEvent.MODULE);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements c.a.e.c.e.c.k.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47282a;

        /* loaded from: classes6.dex */
        public class a implements k.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.p0.b1.k.b
            public void onResult(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if (z) {
                        BdBaseService.serviceStartFlag = 2;
                    } else {
                        BdBaseService.serviceStartFlag = 1;
                    }
                }
            }
        }

        public p(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47282a = tbadkCoreApplication;
        }

        @Override // c.a.e.c.e.c.k.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.b1.k.e().c(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends c.a.e.c.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47283a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(TbadkCoreApplication tbadkCoreApplication, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47283a = tbadkCoreApplication;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.c.f.f
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, httpMessage, httpMessageTask)) == null) {
                if (this.f47283a.checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(httpMessage.getCmd()))) {
                    return null;
                }
                return httpMessage;
            }
            return (HttpMessage) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class r extends c.a.e.c.f.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47284a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(TbadkCoreApplication tbadkCoreApplication, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47284a = tbadkCoreApplication;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.c.f.f
        public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketMessage, socketMessageTask)) == null) {
                if (this.f47284a.checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(socketMessage.getCmd()))) {
                    return null;
                }
                return socketMessage;
            }
            return (SocketMessage) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class s implements CustomMessageTask.CustomRunnable<IntentConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47285e;

        public s(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47285e = tbadkCoreApplication;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<IntentConfig> run(CustomMessage<IntentConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null) {
                    return null;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921565, Boolean.TRUE));
                IntentConfig data = customMessage.getData();
                if (data.asynStart()) {
                    return new CustomResponsedMessage<>(customMessage.getCmd(), data);
                }
                Class<?> intentClass = this.f47285e.getIntentClass(data.getClass());
                if (this.f47285e.getIntentClass(AlbumActivityConfig.class) == null) {
                    TiebaStatic.log(new StatisticItem("inter_config_disappear").param("obj_param1", RegisterIntentConfigHelper.getInst().getConfigSize()));
                } else if ((data instanceof LoginActivityConfig) && !LoginActivityConfig.canStartActivity()) {
                    return null;
                }
                if (intentClass != null) {
                    data.setComponentClass(intentClass);
                    data.run();
                }
                return new CustomResponsedMessage<>(customMessage.getCmd(), data);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class t extends h0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f47286a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47287b;

        public t(TbadkCoreApplication tbadkCoreApplication, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47287b = tbadkCoreApplication;
            this.f47286a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.p0.b1.h0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(CertVerifyHelper.isOfficial(this.f47286a)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class u extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbadkCoreApplication f47288a;

        public u(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47288a = tbadkCoreApplication;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (i2 == 0) {
                    this.f47288a.isPhoneCalling = false;
                } else if (i2 == 1 || i2 == 2) {
                    this.f47288a.isPhoneCalling = true;
                }
                super.onCallStateChanged(i2, str);
            }
        }

        public /* synthetic */ u(TbadkCoreApplication tbadkCoreApplication, j jVar) {
            this(tbadkCoreApplication);
        }
    }

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

    public TbadkCoreApplication() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mConsumePathData = null;
        this.hybridBridgeTimeout = 1000;
        this.mThemeWebviewOpened = false;
        this.mCapableOfWebp = false;
        this.mNewVcodeWebviewCrashCount = 0;
        this.mIsLocationOn = true;
        this.isThirdProcess = false;
        this.isAiAppsProcess = false;
        this.isPluginInstallProcess = false;
        this.mVoiceHeadsetMode = 0;
        this.isDaemonProcess = false;
        this.isYunPushProcess = false;
        this.mIsExitAppCloseWebSocket = false;
        this.mIsToLogo = false;
        this.mPluginIsInited = false;
        this.mPluginNotify = new Object();
        this.mCuid = null;
        this.cuid_galaxy2 = "";
        this.cuid_galaxy3 = "";
        this.cuid_gid = "";
        this.mAndroidId = "";
        this.mImei = null;
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
        this.currentAccountFlowerNum = 0L;
        this.currentAccountTdouNum = 0L;
        this.mMultidexError = "";
        this.mNeedUploadMultidexError = false;
        this.mIsNoInterestTag = false;
        this.syncHasFinish = false;
        this.isKeepLiveProcess = false;
        this.startType = 2;
        this.canShowHotSplash = 2;
        this.mFrsModelArray = new SparseArray<>();
        this.mDescriptionTableFixListener = new j(this, 2921510);
        this.mIsPageStayOpen = false;
        this.isMeiZuCanUseImmersiveHaveSet = false;
        this.isMeiZuCanUseImmersive = true;
        this.handler = new Handler(new n(this));
        this.isReadMenuDialogTop = false;
        this.locationCallBack = new c(this);
        this.mWebviewCrashCount = 0;
        this.mGpuOpen = false;
        this.mPromotedMessageOn = true;
        this.mUseHttpClient = true;
        this.mUseHttpAutoSwitch = true;
        this.mIsAppOn = false;
        this.mDefaultBubble = null;
        this.mDefaultBubbleEndTime = 0;
        this.mHasNewVersion = false;
        this.mCombineDownload = null;
        this.mRemoteActivity = null;
        this.mFontSize = 3;
        this.mFaces = null;
        this.isPhoneCalling = false;
        this.imagePvThread = null;
        this.mHasLikeList = null;
        this.mHasSignList = null;
        this.mSignLevelUpList = null;
        this.mLikeChanged = false;
        this.isFaceShopNew = false;
        this.mTempFaceShopVersion = -1;
        this.isRecAppExist = false;
        this.isAudioRecorderExist = false;
        this.checkUrl = null;
        this.useNewResign = 0;
        this.lastUpdateThemeTime = 0L;
        this.lastUpdateMemberCenterTime = 0L;
        this.showPayInfoRedTip = true;
        this.mNeedShowNewVersion = false;
        this.mIsNewRegUser = false;
        this.mReadThreadHistory = null;
        this.mPhotoLiveReadHistory = null;
        this.mToast = null;
        this.mReadThreadPlayerScreenMaxHeight = 0;
        this.mChannelId = "";
        this.cardShowType = 0;
        this.homeBarShowType = 1;
        this.needCheckUserNameDialog = true;
        sApp = this;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x006f -> B:43:0x0072). Please submit an issue!!! */
    private void InitFrom() {
        BufferedReader bufferedReader;
        Exception e2;
        String fromByShare;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            BufferedReader bufferedReader2 = null;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    fromByShare = getFromByShare();
                    bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    String readLine = bufferedReader.readLine();
                    TbConfig.setCurrentFrom(readLine);
                    if (fromByShare == null) {
                        String fromByFile = getFromByFile();
                        if (fromByFile != null && fromByFile.length() > 0) {
                            TbConfig.setFrom(fromByFile);
                            saveFromToShare(fromByFile);
                        } else if (readLine != null && readLine.length() > 0) {
                            TbConfig.setFrom(readLine);
                            saveFromToShare(readLine);
                            saveFromToFile(readLine);
                        }
                    } else {
                        TbConfig.setFrom(fromByShare);
                    }
                    bufferedReader.close();
                } catch (Exception e4) {
                    e2 = e4;
                    BdLog.e(e2.getMessage());
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                }
            } catch (Exception e5) {
                bufferedReader = null;
                e2 = e5;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static boolean checkNeedShowNewVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (getInst().checkNeedShowNewVersionFlag()) {
                Long valueOf = Long.valueOf(getInst().getUpdateNotifyTime());
                Long valueOf2 = Long.valueOf(new Date().getTime());
                getInst().setUpdateNotifyTime(valueOf2.longValue());
                if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001436));
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void cleanDirectoryNewStatIfNeed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && isMainProcess(true) && getInst().getIsFirstUse()) {
            k0.b(new k(this), null);
        }
    }

    private void dealYYNotification() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            c.a.p0.x0.a aVar = new c.a.p0.x0.a(2012100, new f(this));
            aVar.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(aVar);
        }
    }

    public static String getClientId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? clientId : (String) invokeV.objValue;
    }

    private int getCrashLimitCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            try {
                int k2 = c.a.p0.s.d0.b.j().k("crash_limit_count", 100);
                if (k2 < 10) {
                    return 10;
                }
                return k2;
            } catch (Throwable unused) {
                return 100;
            }
        }
        return invokeV.intValue;
    }

    public static String getCurrentAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? c.a.p0.s.l.b.s().g() : (String) invokeV.objValue;
    }

    public static String getCurrentAccountForEmotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c.a.p0.s.l.b.s().h() : (String) invokeV.objValue;
    }

    public static long getCurrentAccountId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? c.a.p0.s.l.b.s().i() : invokeV.longValue;
    }

    public static AccountData getCurrentAccountInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? c.a.p0.s.l.b.s().j() : (AccountData) invokeV.objValue;
    }

    public static String getCurrentAccountName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? c.a.p0.s.l.b.s().k() : (String) invokeV.objValue;
    }

    public static String getCurrentAccountNameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? c.a.p0.s.l.b.s().l() : (String) invokeV.objValue;
    }

    public static AccountData getCurrentAccountObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? c.a.p0.s.l.b.s().m() : (AccountData) invokeV.objValue;
    }

    public static String getCurrentAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? c.a.p0.s.l.b.s().n() : (String) invokeV.objValue;
    }

    public static String getCurrentBduss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? c.a.p0.s.l.b.s().o() : (String) invokeV.objValue;
    }

    public static int getCurrentMemberType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? c.a.p0.s.l.b.s().p() : invokeV.intValue;
    }

    public static String getCurrentPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? c.a.p0.s.l.b.s().q() : (String) invokeV.objValue;
    }

    public static String getCurrentTbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? c.a.p0.s.l.b.s().o() : (String) invokeV.objValue;
    }

    public static String getCurrentVerson(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            try {
                return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getCurrentVipLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? c.a.p0.s.l.b.s().r() : invokeV.intValue;
    }

    public static String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? TbConfig.getFrom() : (String) invokeV.objValue;
    }

    private String getFromByFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            String str = null;
            try {
                File GetFile = FileHelper.GetFile(TbConfig.FROM_FILE);
                if (GetFile != null) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(GetFile));
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                    return str;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "TiebaApplication.getFromByFile");
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    private String getFromByShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) ? loadString("from_id", null) : (String) invokeV.objValue;
    }

    public static TbadkCoreApplication getInst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? sApp : (TbadkCoreApplication) invokeV.objValue;
    }

    public static Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? intent : (Intent) invokeV.objValue;
    }

    public static boolean getIsAppRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? IS_APP_RUNNING : invokeV.booleanValue;
    }

    public static boolean getRefreshFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? isNeedRefreshOnResume : invokeV.booleanValue;
    }

    public static synchronized String getUniqueIdentifier() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            synchronized (TbadkCoreApplication.class) {
                if (mUniqueId == null) {
                    String cuid = getInst().getCuid();
                    String packageName = getInst().getApp().getPackageName();
                    String version = TbConfig.getVersion();
                    mUniqueId = cuid + "|" + packageName + version;
                }
                str = mUniqueId;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, context) == null) {
            boolean z = !LaunchUpSpeedSwitch.getIsOn();
            if (!isDebugMode() && TbConfig.IS_CHECK_OFFICAL_APPLICATION) {
                k0.b(new t(this, context), new a(this));
            }
            TbConfig.initBigImageMaxUsedMemory(getContext());
            clientId = readClientId(getContext());
            initImei();
            InitFrom();
            initSetting();
            initWebsocketBase(context);
            this.mFontSize = TbadkSettings.getInst().loadInt("font_size", 2);
            this.mVideoAutoPlayConfig = TbadkSettings.getInst().loadInt("video_auto_play_new", -1);
            if (z) {
                try {
                    c.a.e.e.i.a.l().o();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    x.b().e();
                    if (isMainProcess(false)) {
                        c.a.p0.g.a.d().f();
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            if (isMainProcess(true)) {
                c.a.p0.b0.c.k().q(TbConfig.getMaxPhotoMemoryCache(), TbConfig.getBigImageMaxUsedMemory());
            } else {
                c.a.p0.b0.c.k().q(TbConfig.getMaxPhotoMemoryCacheForRemoteProcess(), TbConfig.getBigImageMaxUsedMemoryForRemoteProcess());
            }
            if (z) {
                loadLcsSwitchStratgy();
            }
            initSettings();
            this.mFaces = new HashMap<>();
            if (z) {
                initSdcardDatabaseCallback();
            }
            ReloginManager.g().k();
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.addMessageRule(new c.a.p0.t0.f(0));
            messageManager.addMessageRule(new c.a.p0.t0.c(0));
            messageManager.addResponsedMessageRule(new c.a.p0.t0.e(0));
            messageManager.addRemovedMessageRule(new c.a.p0.t0.d(0));
            messageManager.addResponsedMessageRule(new c.a.q0.c1.c());
            messageManager.addResponsedMessageRule(new c.a.q0.c1.b());
            messageManager.addResponsedMessageRule(new c.a.p0.t0.a());
            messageManager.addResponsedMessageRule(new c.a.p0.t0.b());
            messageManager.addResponsedMessageRule(new c.a.q0.s3.c.a());
            if (z) {
                initAppSettings();
                ViewHelper.initSkinDataOnStartup(getContext());
                TbConfig.initBigImageWidth(getContext());
                TbConfig.initFriendPhotoConfig(getContext());
            }
            if (IS_SUPPORT_EXCEPTION_HANDLER) {
                c.a.q0.n3.d.a();
            }
            if (z) {
                c.a.q0.w3.h.d();
            }
            boolean isMainProcess = isMainProcess(false);
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.init(getContext(), isMainProcess);
            c.a.p0.o0.l.b().K(System.currentTimeMillis() - currentTimeMillis);
            if (isMainProcess) {
                if (getIsFirstUse()) {
                    SwitchManager.getInstance().clear();
                    if (!getCapabilityOfWebp()) {
                        TiebaStatic.eventStat(getApp(), "LocalWebpUnSupport", "");
                    }
                }
            } else {
                getInst().mRemoteActivity = new ArrayList<>();
            }
            c.a.p0.x0.a aVar = new c.a.p0.x0.a(2012000, new b(this));
            aVar.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(aVar);
            if (z) {
                dealYYNotification();
            }
            if (isMainProcess(true)) {
                sendMessageForEnterBackground();
            }
            NetMessage.setGlobalSwitchToHttpStrategy(new NetMessage.a(this) { // from class: com.baidu.tbadk.core.TbadkCoreApplication.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TbadkCoreApplication this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.baidu.adp.framework.message.NetMessage.a
                public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, socketResponsedMessage)) == null) {
                        if (socketResponsedMessage != null) {
                            return socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
            c.a.p0.s.j jVar = new c.a.p0.s.j();
            this.mCoreActivityLifecycleCallbacks = jVar;
            registerActivityLifecycleCallbacks(jVar);
            InputMethodManagerLeaksFixer.fixFocusedViewLeak(this);
        }
    }

    public static void initAR(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, context) == null) {
            c.a.a0.a.b.t(BdUploadHandler.MEDIA_SOURCE_KEY);
            c.a.a0.a.b.k(context);
            c.a.a0.a.b.w(false);
            c.a.p0.w.d.a();
        }
    }

    private void initAppSettings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            c.a.p0.s.k.c().f();
        }
    }

    private void initChangeSkinReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            c.a.p0.s.l.b.s().B();
        }
    }

    private void initCmdConvertManager() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65573, this) == null) && isDebugMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(c.a.p0.s.x.b.class.getName());
            arrayList.add(c.a.p0.s.x.a.class.getName());
            arrayList.add(CmdConfigHttp.class.getName());
            c.a.e.c.a.a().c(arrayList);
        }
    }

    private void initCustomToastView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mToast == null && c.a.e.e.p.l.u() == null) {
                l lVar = new l(this);
                this.mToast = lVar;
                c.a.e.e.p.l.H(lVar);
                c.a.p0.o0.l.b().L(System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    private void initDimenAdapt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            TbDimenManager.getInstance().init(this);
        }
    }

    private void initICDN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            c.a.e.e.j.a.c.f2300f = UseHttpdnsSdkSwitch.isOn();
            if (UseHttpdnsSdkSwitch.isOn()) {
                BDHttpDns j2 = BDHttpDns.j(getApplicationContext());
                j2.n(false);
                try {
                    j2.k("119799");
                    j2.q("87JNTZjGacgUzuMBYvid");
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                j2.m(true);
                j2.o(true, true);
                j2.l(BDHttpDns.CachePolicy.POLICY_TOLERANT);
                if (isMainProcess(true)) {
                    this.mHandler.postDelayed(new o(this, j2), 1000L);
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ICDNProblemUploader.getInstance();
            ICDNIPDirectConnect.getInstance();
            if (isMainProcess(true) && ICDNIPDirectConnect.getInstance() != null) {
                ICDNIPDirectConnect.getInstance().init();
            }
            c.a.p0.o0.l.b().n(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void initIM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.q0.j1.a.a();
            c.a.p0.o0.l.b().p(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void initInterruptRule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            MessageManager.getInstance().addMessageRule(new q(this, 0));
            MessageManager.getInstance().addMessageRule(new r(this, 0));
        }
    }

    private void initJpusbSdk() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65579, this) == null) && isMainProcess(true)) {
            c.a.q0.n3.b.b().d(this);
        }
    }

    private void initLeakCanary() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65580, this) == null) && isDebugMode()) {
            String cuid = getCuid();
            if (TextUtils.isEmpty(cuid)) {
                cuid = "";
            }
            c.a.v.a.a(this, "", "", cuid);
        }
    }

    private void initLocationSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (isMainProcess(true) && c.a.p0.s.l.b.s().g() == null) {
                tryLbs();
            }
            c.a.p0.o0.l.b().v(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void initLoki() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            if (Loki.isLokiService(c.a.h0.b.a.a.b())) {
                Loki.initService();
                return;
            }
            Loki.init(this);
            Loki.initNative(this);
        }
    }

    private void initPluginSettings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (Build.VERSION.SDK_INT >= 24 && (!this.isRemoteProcess || XiaomiWebViewInitSwitch.isOn())) {
                    try {
                        new WebView(this);
                    } catch (Throwable unused) {
                    }
                }
                PluginPackageManager.O().U(TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER, isMainProcess(false), this.isThirdProcess, this.isRemoteProcess);
                PluginCenter.getInstance().launch("com.baidu.tieba.pluginFlutter", false);
            } finally {
                TTIStats.record("TbadkCoreApplication.initPluginSettings", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    private void initQuickWebViewManager() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65584, this) == null) && isMainProcess(true)) {
            c.a.q0.v2.b.q().u();
            long currentTimeMillis = System.currentTimeMillis();
            c.a.p0.t.d.d.d().m();
            c.a.p0.o0.l.b().z(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void initRuka() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65585, this) == null) && isMainProcess(false)) {
            Ruka.startAnrMonitor(this);
            Ruka.startLooperMonitor(this);
        }
    }

    public static void initSdcardDatabaseCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, null) == null) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().k(new e());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initSettings() {
        boolean z;
        AssetManager assets;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            this.mVoiceHeadsetMode = TbadkSettings.getInst().loadInt("voice_headset_mode", 0);
            if (TbadkSettings.getInst().loadInt("webp_failure_count", -1) == -1) {
                if (Build.VERSION.SDK_INT >= 14 && (assets = getInst().getContext().getAssets()) != null) {
                    InputStream inputStream = null;
                    try {
                        inputStream = assets.open("webp_test/test.webp");
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    if (inputStream != null && BitmapFactory.decodeStream(inputStream) != null) {
                        z = true;
                        if (z) {
                            this.mCapableOfWebp = false;
                            i2 = 6;
                        } else {
                            this.mCapableOfWebp = true;
                        }
                        TbadkSettings.getInst().saveInt("webp_failure_count", i2);
                        TbadkSettings.getInst().saveBoolean("capable_of_webp_format", this.mCapableOfWebp);
                    }
                }
                z = false;
                if (z) {
                }
                TbadkSettings.getInst().saveInt("webp_failure_count", i2);
                TbadkSettings.getInst().saveBoolean("capable_of_webp_format", this.mCapableOfWebp);
            } else {
                this.mCapableOfWebp = TbadkSettings.getInst().loadBoolean("capable_of_webp_format", false);
            }
            c.a.p0.o0.l.b().r(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public static void initSocket() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65588, null) == null) {
            c.a.p0.x0.b registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
            registerImScoketTask.setPriority(-3);
            registerImScoketTask.e(false);
            registerImScoketTask.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
            registerImScoketTask.setNeedEncrypt(false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
            arrayList.add(new BasicNameValuePair("cuid", getUniqueIdentifier()));
            new UseHttpdnsSdkSwitch();
            if (UseHttpdnsSdkSwitch.isOn()) {
                c.a.e.c.e.c.h.h(TiebaIMConfig.url);
            } else {
                String h2 = c.a.p0.t.j.a.f().h();
                if (TextUtils.isEmpty(h2)) {
                    c.a.e.c.e.c.h.h(TiebaIMConfig.url);
                } else {
                    c.a.e.c.e.c.h.h(h2);
                }
            }
            c.a.e.c.e.c.h.e(TiebaIMConfig.wsExtensions);
            c.a.e.c.e.c.h.f(arrayList);
            BdSocketDaemonService.setLinkServiceDisconnectCallBack(new h());
            BdSocketLinkService.init();
            c.a.p0.e0.a.b(0, 0, 0, 1, 9);
            BdSocketLinkService.startService(false, "TiebaImApplication init");
        }
    }

    private void initStatSdk() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65589, this) == null) && isMainProcess(true)) {
            c.a.q0.n3.c.b().a(this);
            c.a.q0.n3.c.b().e(this, getFrom(), true);
        }
    }

    private void initSwanData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65590, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921512));
        }
    }

    private void initUETool() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65591, this) == null) && isDebugMode() && isMainProcess(false) && c.a.p0.s.d0.b.j().g("key_ue_tool_switch", false)) {
            MessageManager.getInstance().runTask(2921513, null, null);
        }
    }

    private void initWebsocketBase(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, this, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            BdSocketLinkService.setAvailable(true);
            BdSocketLinkService.setCanOpenWebSocket(new g(this));
            int[] imTimeOut = getImTimeOut();
            if (imTimeOut != null && imTimeOut.length == 3) {
                c.a.e.c.j.c.c().d(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
            }
            int[] socketReconnStratgy = getSocketReconnStratgy();
            if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
                c.a.e.c.e.c.h.g(socketReconnStratgy);
            }
            c.a.p0.t.j.e.j().k();
            MessageManager.getInstance().getSocketClient().H(c.a.p0.t.j.e.j());
            MessageManager.getInstance().addResponsedMessageRule(new c.a.p0.t.j.i());
            try {
                c.a.e.c.e.c.j.d.a().d(TiebaIMConfig.getRSAPublicKey());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            c.a.p0.t.j.h.j().k();
            c.a.p0.t.j.g.y().z();
            initSocket();
            c.a.p0.o0.l.b().s(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void intReadThreadHistory(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65593, this, z) == null) && z) {
            this.mReadThreadHistory = new c.a.q0.i3.o0.d(300);
            this.mPhotoLiveReadHistory = new c.a.q0.i3.o0.c(300);
            c.a.e.a.b.f().r(this);
        }
    }

    private boolean isCrabSdkCrashUp2Limit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("crab_sdk_crash_count_");
            sb.append(TbConfig.getVersion());
            return TbadkSettings.getInst().loadInt(sb.toString(), 0) > getFeatureCrashAutoCloseLimit();
        }
        return invokeV.booleanValue;
    }

    private boolean isGifAutoPlayFromSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, this)) == null) {
            int i2 = this.mVideoAutoPlayConfig;
            if (i2 == -1) {
                i2 = 0;
            }
            if ((i2 != 0 || (!c.a.e.e.p.j.H() && c.a.e.e.p.j.z())) && i2 != 2) {
                if (i2 == 1) {
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) {
            String currentAccount = getCurrentAccount();
            return currentAccount != null && currentAccount.length() > 0;
        }
        return invokeV.booleanValue;
    }

    private void isToLogo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65597, this) == null) {
            Boolean bool = this.isCdnTachometerProcess;
            if ((bool != null && bool.booleanValue()) || this.isPluginInstallProcess) {
                this.mPluginIsInited = true;
                return;
            }
            if (isMainProcess(false)) {
                if (!UseNewMethodCheckLogoSwitch.isOn()) {
                    this.mIsToLogo = c.a.p0.b1.u.b();
                } else {
                    boolean b2 = c.a.p0.b1.u.b();
                    this.mIsToLogo = b2;
                    if (b2) {
                        TiebaStatic.log("isTologo_not_match");
                    }
                }
            }
            boolean z = isMainProcess(false) && PluginClassChangeSwitch.isOn();
            if (this.mIsToLogo || !z || c.a.p0.b1.u.a(false)) {
                return;
            }
            this.mPluginIsInited = true;
            PluginPackageManager.O().i0(c.a.p0.q0.c.n(), new c.a.p0.q0.d(), true, this.mPluginNotify);
            synchronized (this.mPluginNotify) {
                try {
                    long j2 = 850;
                    long l2 = c.a.p0.s.d0.b.j().l("plugin_wait_time", 850L);
                    if (l2 > 0) {
                        j2 = l2;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    this.mPluginNotify.wait(j2);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 >= j2) {
                        TiebaStatic.log(new StatisticItem("plugin_load_time_large").param("obj_param1", currentTimeMillis2));
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            c.a.p0.b1.u.a(true);
        }
    }

    @Deprecated
    private void loadNativeCrashCollectLib() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            try {
                System.loadLibrary("google_breakpad");
            } catch (Throwable unused) {
            }
        }
    }

    private void registerGoActionTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65599, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2002001, new s(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static c.a.p0.x0.b registerImScoketTask(int i2, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65600, null, new Object[]{Integer.valueOf(i2), cls, Boolean.valueOf(z)})) == null) {
            c.a.p0.x0.b bVar = new c.a.p0.x0.b(i2);
            bVar.setResponsedClass(cls);
            bVar.h(z);
            bVar.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(bVar);
            return bVar;
        }
        return (c.a.p0.x0.b) invokeCommon.objValue;
    }

    public static void resetTDatabaseCreateTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65601, null) == null) {
            TbadkSettings.getInst().saveLong("tdatabasecreatetime", new Date().getTime());
        }
    }

    public static void saveClientId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65602, null, context, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        c.a.p0.s.d0.b.j().x("client_id", TbConfig.getVersion() + TrackUI.SEPERATOR + str);
    }

    private void saveFromToFile(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65603, this, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        try {
            File CreateFile = FileHelper.CreateFile(TbConfig.FROM_FILE);
            if (CreateFile != null) {
                FileWriter fileWriter = new FileWriter(CreateFile);
                fileWriter.append((CharSequence) str);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, "TiebaApplication.saveFromToFile");
        }
    }

    private void saveFromToShare(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65604, this, str) == null) || str == null || str.length() <= 0 || !isMainProcess(true)) {
            return;
        }
        saveString("from_id", str);
    }

    public static void setBdussAndTbsFromBackgroundInRelogin(AccountData accountData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65605, null, accountData, str, str2) == null) {
            c.a.p0.s.l.b.s().J(accountData, str, str2);
        }
    }

    public static void setClientId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65606, null, str) == null) {
            clientId = str;
        }
    }

    public static void setCurrentAccount(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65607, null, accountData, context) == null) {
            c.a.p0.s.l.b.s().K(accountData, context);
        }
    }

    public static void setCurrentAccountFromRemoteProcessInUIThread(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65608, null, accountData, context) == null) {
            c.a.p0.s.l.b.s().L(accountData, context);
        }
    }

    public static void setCurrentMemberType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65609, null, i2) == null) {
            c.a.p0.s.l.b.s().N(i2);
        }
    }

    public static void setIntent(Intent intent2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65610, null, intent2) == null) {
            intent = intent2;
        }
    }

    public static void setIsAppRunning(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65611, null, z) == null) {
            IS_APP_RUNNING = z;
        }
    }

    public static void setRefreshFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65612, null, z) == null) {
            isNeedRefreshOnResume = z;
        }
    }

    private void setServiceOnCreateCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65613, this) == null) {
            BdBaseService.setServiceOnCreateCallBack(new p(this));
        }
    }

    private void setWebViewDataDirectorySuffix() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65614, this) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("setDataDirectorySuffix", String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, ProcessUtils.getCurProcessName());
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public void AddResumeNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.p0.b1.m.g().a();
        }
    }

    public void DelResumeNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.b1.m.g().b();
        }
    }

    public void InitVersion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
                TbConfig.setVersionType(c.a.e.e.m.b.d(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
            } catch (Exception e2) {
                TbConfig.setVersionType(3);
                BdLog.e(e2.getMessage());
            }
            try {
                if (TbConfig.getVersionType() == 2) {
                    TbConfig.setVersion(String.valueOf(applicationInfo.metaData.get("grayVersion")));
                    return;
                }
                TbConfig.setVersion(getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName);
                if (TbConfig.getVersionType() == 1) {
                    TbConfig.setSubVersion(String.valueOf(applicationInfo.metaData.get("subVersion")));
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cls, cls2) == null) {
            RegisterIntentConfigHelper.getInst().RegisterIntent(cls, cls2);
        }
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cls, cls2) == null) {
            RegisterIntentConfigHelper.getInst().RegisterOrUpdateIntent(cls, cls2);
        }
    }

    public void SendSkinTypeBroadcast(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            c.a.p0.s.l.b.s().a(i2);
        }
    }

    public void addBDLocCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("bd_loc_crash_count", 0) + 1;
            TbadkSettings.getInst().saveInt("bd_loc_crash_count", loadInt);
            if (loadInt > 3) {
                setBDLocON(false);
            }
        }
    }

    public void addLikeForum(String str) {
        Hashtable<String, Integer> hashtable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (hashtable = this.mHasLikeList) == null || str == null) {
            return;
        }
        hashtable.put(str, 1);
        setLikeBarChanged(true);
        if (this.mHasLikeList.size() > 200) {
            this.mHasLikeList.clear();
        }
    }

    public void addRemoteActivity(BaseActivity<?> baseActivity) {
        ArrayList<BaseActivity<?>> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseActivity) == null) || (arrayList = this.mRemoteActivity) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRemoteActivity.get(i2).releaseResouce();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (baseActivity != null) {
            this.mRemoteActivity.add(baseActivity);
        }
    }

    public void addSignedForum(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048585, this, str, i2, i3) == null) || TextUtils.isEmpty(str) || this.mHasSignList == null || this.mSignLevelUpList == null || hasSignedForum(str)) {
            return;
        }
        this.mHasSignList.put(str, Integer.valueOf(i2));
        this.mSignLevelUpList.put(str, Integer.valueOf(i3));
    }

    @SuppressLint({"UseSparseArrays"})
    public void addThemeToWaitDownloadQuene(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.mWaitDownloadTheme == null) {
                this.mWaitDownloadTheme = new SparseArray<>();
            }
            this.mWaitDownloadTheme.put(i2, 1);
        }
    }

    public boolean appResponseToCmd(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? MessageManager.getInstance().findTask(i2) != null : invokeI.booleanValue;
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cls)) == null) ? RegisterIntentConfigHelper.getInst().appResponseToIntentClass(cls) : invokeL.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            SpeedStatsManager.getInstance().setMainProcessFlag(isMainProcess(false, context));
            SpeedStatsManager.getInstance().addStatsTimeStamp(1000);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1002);
            super.attachBaseContext(context);
            fixOppoTimeout();
            SpeedStatsManager.getInstance().addStatsTimeStamp(1003);
            AppRuntimeInit.onApplicationattachBaseContext(this);
            c.a.h0.b.a.e.b(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1004);
            NPSHookManager.init(this);
            c.a.e.g.c.d().h(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1011);
            TitanIniter.init(this);
            LoaderManager.getInstance().load();
            SpeedStatsManager.getInstance().addStatsTimeStamp(1012);
            SpeedStatsManager.getInstance().addStatsTimeStamp(1010);
        }
    }

    public boolean canSendForegroundMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? c.a.p0.b1.m.g().d() : invokeV.booleanValue;
    }

    public boolean cashNoAccountData(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i2)) == null) ? c.a.p0.s.l.b.s().d(str, i2) : invokeLI.booleanValue;
    }

    public boolean checkNeedShowNewVersionFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mNeedShowNewVersion : invokeV.booleanValue;
    }

    public void clearActiveVersion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            setActiveVersion(ACTIVE_CLEAR_TAG);
        }
    }

    public void clearEnterForeCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.p0.b1.m.g().e();
        }
    }

    public void clearLikeForum() {
        Hashtable<String, Integer> hashtable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (hashtable = this.mHasLikeList) == null) {
            return;
        }
        hashtable.clear();
    }

    public void clearSignedForum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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

    public String createRandomString(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, str, i2)) == null) {
            StringBuilder sb = new StringBuilder(i2);
            if (str != null) {
                sb.append(str);
            }
            sb.append(c.a.e.e.p.o.a());
            if (sb.length() > i2) {
                sb.setLength(i2);
            }
            return sb.toString();
        }
        return (String) invokeLI.objValue;
    }

    public void delLikeForum(String str) {
        Hashtable<String, Integer> hashtable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (hashtable = this.mHasLikeList) == null || str == null) {
            return;
        }
        hashtable.put(str, -1);
        setLikeBarChanged(true);
        if (this.mHasLikeList.size() > 200) {
            this.mHasLikeList.clear();
        }
    }

    public void delRemoteActivity(BaseActivity<?> baseActivity) {
        ArrayList<BaseActivity<?>> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, baseActivity) == null) || (arrayList = this.mRemoteActivity) == null) {
            return;
        }
        arrayList.remove(baseActivity);
    }

    public void delSignedForum(String str) {
        Hashtable<String, Integer> hashtable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || !hasSignedForum(str) || (hashtable = this.mHasSignList) == null || str == null) {
            return;
        }
        hashtable.remove(str);
        this.mSignLevelUpList.remove(str);
    }

    public void deleteAccountAllInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            c.a.p0.s.l.b.s().f(str);
        }
    }

    public void deleteThemeFromWaitDownloadQuene(int i2) {
        SparseArray<Integer> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (sparseArray = this.mWaitDownloadTheme) == null) {
            return;
        }
        sparseArray.remove(i2);
    }

    public void fixOppoTimeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
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

    public String getActiveVersion() {
        InterceptResult invokeV;
        String latestFileName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
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

    public c.a.p0.t.c.b getActivityPrizeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.activityPrizeData == null) {
                this.activityPrizeData = new c.a.p0.t.c.b();
                c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
                String p2 = j2.p("activity_prize_data" + getCurrentAccount(), "");
                if (!StringUtils.isNull(p2)) {
                    try {
                        this.activityPrizeData.i(new JSONObject(p2));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return this.activityPrizeData;
        }
        return (c.a.p0.t.c.b) invokeV.objValue;
    }

    public c.a.p0.t.c.c getActivitySwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mActivitySwitch : (c.a.p0.t.c.c) invokeV.objValue;
    }

    public c.a.p0.t.c.d getAdAdSense() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mAdAdSense : (c.a.p0.t.c.d) invokeV.objValue;
    }

    public int getAdVideoPageStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? c.a.p0.s.d0.b.j().k("video_page_style", 3) : invokeV.intValue;
    }

    public String getAndroidId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                if (TextUtils.isEmpty(this.mAndroidId)) {
                    try {
                        this.mAndroidId = Settings.System.getString(getInst().getContentResolver(), IAdRequestParam.ANDROID_ID);
                    } catch (Exception unused) {
                    }
                }
                return this.mAndroidId;
            }
            return "000";
        }
        return (String) invokeV.objValue;
    }

    public int getCanShowSplash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mCapableOfWebp : invokeV.booleanValue;
    }

    public int getCardShowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (!this.hasInit) {
                this.cardShowType = c.a.p0.s.d0.b.j().k("key_card_show_type", 0);
            }
            return this.cardShowType;
        }
        return invokeV.intValue;
    }

    public String getCheckUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.checkUrl : (String) invokeV.objValue;
    }

    public CombineDownload getCombineDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mCombineDownload : (CombineDownload) invokeV.objValue;
    }

    public String getConfigVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mConfigVersion : (String) invokeV.objValue;
    }

    public c.a.p0.t.c.u getConsumePathData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mConsumePathData : (c.a.p0.t.c.u) invokeV.objValue;
    }

    public String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (c.a.e.e.p.k.isEmpty(this.mCuid)) {
                initCuid();
            }
            return this.mCuid;
        }
        return (String) invokeV.objValue;
    }

    public String getCuidGalaxy2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (c.a.e.e.p.k.isEmpty(this.cuid_galaxy2)) {
                initCuidGalaxy2();
            }
            return this.cuid_galaxy2;
        }
        return (String) invokeV.objValue;
    }

    public String getCuidGalaxy3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (c.a.e.e.p.k.isEmpty(this.cuid_galaxy3)) {
                initCuidGalaxy3();
            }
            return this.cuid_galaxy3;
        }
        return (String) invokeV.objValue;
    }

    public String getCuidGid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.cuid_gid : (String) invokeV.objValue;
    }

    public String getCurAiAppid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mCurAiAppid : (String) invokeV.objValue;
    }

    public Activity getCurrentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            WeakReference<Activity> weakReference = this.mCurrentActivityRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public TbPageContext getCurrentPageContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public c.a.p0.s.f getCustomizedFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mCustomizedFilter : (c.a.p0.s.f) invokeV.objValue;
    }

    public String getDefaultBubble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mDefaultBubble : (String) invokeV.objValue;
    }

    public int getDefaultBubbleEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mDefaultBubbleEndTime : invokeV.intValue;
    }

    public int getEnterForeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? c.a.p0.b1.m.g().f() : invokeV.intValue;
    }

    public c.a.e.l.d.a getFace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
            SoftReference<c.a.e.l.d.a> softReference = this.mFaces.get(str);
            if (softReference != null && softReference.get() != null) {
                return softReference.get();
            }
            c.a.e.l.d.a a2 = TbFaceManager.e().a(str);
            if (a2 != null) {
                this.mFaces.put(str, new SoftReference<>(a2));
            }
            return a2;
        }
        return (c.a.e.l.d.a) invokeL.objValue;
    }

    public int getFaceShopVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mFaceShopVersion : invokeV.intValue;
    }

    public int getFeatureCrashAutoCloseLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? Math.max(TbadkSettings.getInst().loadInt("feature_crash_auto_close_limit", 3), 3) : invokeV.intValue;
    }

    public boolean getFirstSyncImageQuality() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? TbadkSettings.getInst().loadBoolean("first_sync_image_quality", true) : invokeV.booleanValue;
    }

    public int getFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.mFontSize : invokeV.intValue;
    }

    public String getFramework_ver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.framework_ver : (String) invokeV.objValue;
    }

    public int getFrsAutoPlay() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (TbConfig.FORCE_UPDATE || (i2 = this.mVideoAutoPlayConfig) == -1) {
                boolean z = c.a.p0.s.d0.b.j().k("auto_play_video_frs", 0) == 1;
                if (c.a.p0.s.d0.b.j().k("auto_play_video_frs_have_4g", 0) == 1) {
                    return 2;
                }
                return z ? 0 : 1;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public SparseArray<FrsNetModel> getFrsModeArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mFrsModelArray : (SparseArray) invokeV.objValue;
    }

    public String getGameInfoIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.infoIconUrl : (String) invokeV.objValue;
    }

    public String getGameInfoTargetUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.infoTargetUrl : (String) invokeV.objValue;
    }

    public long getGameInfoTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.infoTimeStamp : invokeV.longValue;
    }

    public Hashtable<String, Integer> getHasLikeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mHasLikeList : (Hashtable) invokeV.objValue;
    }

    public boolean getHasNewVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.mHasNewVersion : invokeV.booleanValue;
    }

    public String getHdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? PermissionUtil.isAgreePrivacyPolicy() ? c.s.a.a.a(sApp) : "" : (String) invokeV.objValue;
    }

    public int getHomeBarShowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.homeBarShowType : invokeV.intValue;
    }

    public int getHomePageAutoPlay() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (TbConfig.FORCE_UPDATE || (i2 = this.mVideoAutoPlayConfig) == -1) {
                boolean z = c.a.p0.s.d0.b.j().k("auto_play_video_homepage", 0) == 1;
                if (c.a.p0.s.d0.b.j().k("auto_play_video_homepage_have_4g", 0) == 1) {
                    return 2;
                }
                return z ? 0 : 1;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int getHybridBridgeTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.hybridBridgeTimeout : invokeV.intValue;
    }

    public String getIMsi() {
        TelephonyManager telephonyManager;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            try {
                Context context = getInst().getContext();
                return (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadPhoneState(context) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) ? telephonyManager.getSubscriberId() : "";
            } catch (Exception e2) {
                BdLog.e(e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public int[] getImTimeOut() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            String loadString = TbadkSettings.getInst().loadString("socket_time_out", null);
            if (loadString == null || (split = loadString.split("\\|")) == null || split.length != 3) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                iArr[i2] = 0;
                try {
                    iArr[i2] = Integer.valueOf(split[i2]).intValue();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public String getImei() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (c.a.e.e.p.k.isEmpty(this.mImei)) {
                initImei();
            }
            return this.mImei;
        }
        return (String) invokeV.objValue;
    }

    public long getInitTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.mInitTime : invokeV.longValue;
    }

    public String getInstallOtherApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? TbadkSettings.getInst().loadString("install_other_app_file_name", null) : (String) invokeV.objValue;
    }

    public String getInstalledAppIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mInstallAppIds : (String) invokeV.objValue;
    }

    public Class<?> getIntentClass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, cls)) == null) ? RegisterIntentConfigHelper.getInst().getIntentClass(cls) : (Class) invokeL.objValue;
    }

    public z getInterestBoardConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.mInterestBoardConfigData : (z) invokeV.objValue;
    }

    public long getInterviewLivePollingInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.mInterviewLivePollingInterval : invokeV.longValue;
    }

    public boolean getIsAbstract() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            int i2 = this.mIsAbstractOn;
            if (i2 == 0) {
                if (c.a.e.e.p.j.H()) {
                    return true;
                }
            } else if (i2 == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getIsAbstractStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.mIsAbstractOn : invokeV.intValue;
    }

    public boolean getIsAppOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.mIsAppOn : invokeV.booleanValue;
    }

    public boolean getIsFirstUse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (FileHelper.DataDir.checkFile("/package.cur/" + TbConfig.getVersion())) {
                return false;
            }
            setActiveVersion(FileHelper.DataDir.getLatestFileName(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR));
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsLocationOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.mIsLocationOn : invokeV.booleanValue;
    }

    public boolean getIsNewRegUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.mIsNewRegUser : invokeV.booleanValue;
    }

    public boolean getIsPhoneCalling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.isPhoneCalling : invokeV.booleanValue;
    }

    public int getKeepaliveNonWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? loadInt("keepalive_nonwifi", 1) : invokeV.intValue;
    }

    public int getKeepaliveWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? loadInt("keepalive_wifi", 1) : invokeV.intValue;
    }

    public int getKeyboardHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.keyboardHeight : invokeV.intValue;
    }

    public long getLastNotifyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? TbadkSettings.getInst().loadLong("last_notify_sound_time", 0L) : invokeV.longValue;
    }

    public long getLastSyncFinishTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.mLastSyncFinishTime : invokeV.longValue;
    }

    public long getLastUpdateMemberCenterTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.lastUpdateMemberCenterTime : invokeV.longValue;
    }

    public long getLastUpdateThemeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.lastUpdateThemeTime : invokeV.longValue;
    }

    public boolean getLikeBarChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.mLikeChanged : invokeV.booleanValue;
    }

    public b0 getListItemRule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.listItemRule == null) {
                this.listItemRule = new b0();
            }
            return this.listItemRule;
        }
        return (b0) invokeV.objValue;
    }

    public String getLocationLat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? TbadkSettings.getInst().loadString("location_lat", "") : (String) invokeV.objValue;
    }

    public String getLocationLng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? TbadkSettings.getInst().loadString("location_lng", "") : (String) invokeV.objValue;
    }

    public String getLocationPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? TbadkSettings.getInst().loadString("location_pos", "") : (String) invokeV.objValue;
    }

    public boolean getLocationShared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int getMainTabBottomBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            if (DeviceInfoUtil.isfullScreen()) {
                return c.a.e.e.p.l.g(this, R.dimen.tbds162);
            }
            return c.a.e.e.p.l.g(this, R.dimen.tbds152);
        }
        return invokeV.intValue;
    }

    public final int getMainTabBottomBarHeightId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (DeviceInfoUtil.isfullScreen()) {
                return R.dimen.ds100;
            }
            return R.dimen.ds90;
        }
        return invokeV.intValue;
    }

    public int getNetWorkCoreType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? loadInt("networkcore_type", 1) : invokeV.intValue;
    }

    public int getNewVcodeWebviewCrashCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.mNewVcodeWebviewCrashCount : invokeV.intValue;
    }

    public String getNoAccountData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048678, this, i2)) == null) ? c.a.p0.s.l.b.s().t(i2) : (String) invokeI.objValue;
    }

    public int getOldSkinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? c.a.p0.s.l.b.s().u() : invokeV.intValue;
    }

    public PayMemberInfoData getPaymemberInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.payInfo : (PayMemberInfoData) invokeV.objValue;
    }

    public int getPerformSampleCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.mPerformSampleCount : invokeV.intValue;
    }

    public c.a.q0.i3.o0.c getPhotoLiveReadThreadHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.mPhotoLiveReadHistory : (c.a.q0.i3.o0.c) invokeV.objValue;
    }

    public e0 getProfileData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.mProfileData : (e0) invokeV.objValue;
    }

    @Modify(description = "flutter代理ip")
    public String getProxyIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.proxyIp : (String) invokeV.objValue;
    }

    @Modify(description = "flutter代理端口")
    public String getProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.proxyPort : (String) invokeV.objValue;
    }

    public String getPushChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? loadString(Constants.EXTRA_PUSH_CHANNEL_ID, "") : (String) invokeV.objValue;
    }

    public String getPushChannelUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? loadString("push_channel_userId", "") : (String) invokeV.objValue;
    }

    public c.a.q0.i3.o0.d getReadThreadHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? this.mReadThreadHistory : (c.a.q0.i3.o0.d) invokeV.objValue;
    }

    public int getReadThreadPlayerScreenMaxHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.mReadThreadPlayerScreenMaxHeight : invokeV.intValue;
    }

    public long getReporyUserInfoLastTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return TbadkSettings.getInst().loadLong("report_user_info_time_key" + getCurrentAccount(), 0L);
        }
        return invokeV.longValue;
    }

    public int getResumeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? c.a.p0.b1.m.g().h() : invokeV.intValue;
    }

    public String getSdk_ver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.sdk_ver : (String) invokeV.objValue;
    }

    public ShareItem getShareItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? this.mShareItem : (ShareItem) invokeV.objValue;
    }

    public boolean getShowPayInfoRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) ? this.showPayInfoRedTip : invokeV.booleanValue;
    }

    public int getSignLevelUpValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048695, this, str)) == null) {
            if (hasSignedForum(str)) {
                return this.mSignLevelUpList.get(str).intValue();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int getSignedForumIncreaseCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048696, this, str)) == null) {
            if (hasSignedForum(str)) {
                return this.mHasSignList.get(str).intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public int getSkinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? c.a.p0.s.l.b.s().v() : invokeV.intValue;
    }

    public int[] getSocketGetMsgStratgy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            int[] iArr = new int[0];
            try {
                String loadString = TbadkSettings.getInst().loadString("socket_getmsg_strategy", "");
                if (loadString != null && !TextUtils.isEmpty(loadString)) {
                    String[] split = loadString.split(",");
                    iArr = new int[split.length];
                    for (int i2 = 0; i2 < split.length; i2++) {
                        iArr[i2] = Integer.valueOf(split[i2]).intValue();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            int[] iArr = new int[0];
            try {
                String loadString = TbadkSettings.getInst().loadString("socket_heartbeat_strategy", "");
                if (loadString != null && !TextUtils.isEmpty(loadString)) {
                    String[] split = loadString.split(",");
                    iArr = new int[split.length];
                    for (int i2 = 0; i2 < split.length; i2++) {
                        iArr[i2] = Integer.valueOf(split[i2]).intValue();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            int[] iArr = new int[0];
            try {
                String loadString = TbadkSettings.getInst().loadString("socket_reconn_strategy", "");
                if (loadString != null && !TextUtils.isEmpty(loadString)) {
                    String[] split = loadString.split(",");
                    iArr = new int[split.length];
                    for (int i2 = 0; i2 < split.length; i2++) {
                        iArr[i2] = Integer.valueOf(split[i2]).intValue();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public c.a.q0.z1.a getSplash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            if (this.mSplash == null) {
                this.mSplash = new c.a.q0.z1.a(this);
            }
            return this.mSplash;
        }
        return (c.a.q0.z1.a) invokeV.objValue;
    }

    public int getStartType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.startType : invokeV.intValue;
    }

    public String getSwan_game_ver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this.swan_game_ver : (String) invokeV.objValue;
    }

    public String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.task_id : (String) invokeV.objValue;
    }

    public String getTbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? c.a.p0.s.l.b.s().w() : (String) invokeV.objValue;
    }

    public int getTempFaceShopVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? this.mTempFaceShopVersion : invokeV.intValue;
    }

    public int getThemeFromWaitDownloadQuene(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048707, this, i2)) == null) {
            SparseArray<Integer> sparseArray = this.mWaitDownloadTheme;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.get(i2, 0).intValue();
        }
        return invokeI.intValue;
    }

    public boolean getThemeWebviewOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? this.mThemeWebviewOpened : invokeV.booleanValue;
    }

    public String getUegVoiceWarning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) ? this.uegVoiceWarning : (String) invokeV.objValue;
    }

    public long getUpdateNotifyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? TbadkSettings.getInst().loadLong("update_notify_time", 0L) : invokeV.longValue;
    }

    public String getUrlText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? this.urlText : (String) invokeV.objValue;
    }

    public int getUseNewResign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? this.useNewResign : invokeV.intValue;
    }

    public long getUseTimeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? this.useTimeInterval : invokeV.longValue;
    }

    public int getUsedThemeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? c.a.p0.s.l.b.s().x() : invokeV.intValue;
    }

    public int getUsedThemeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) ? c.a.p0.s.l.b.s().y() : invokeV.intValue;
    }

    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
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

    public VersionData getVersionData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) ? this.mVersionData : (VersionData) invokeV.objValue;
    }

    public String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
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

    public int getVideoAutoPlay() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            if (TbConfig.FORCE_UPDATE || (i2 = this.mVideoAutoPlayConfig) == -1) {
                boolean z = c.a.p0.s.d0.b.j().k("auto_play_video_homepage", 0) == 1;
                boolean z2 = c.a.p0.s.d0.b.j().k("auto_play_video_frs", 0) == 1;
                boolean z3 = c.a.p0.s.d0.b.j().k("auto_play_video_homepage_have_4g", 0) == 1;
                boolean z4 = c.a.p0.s.d0.b.j().k("auto_play_video_frs_have_4g", 0) == 1;
                if (z3 || z4) {
                    return 2;
                }
                return (z || z2) ? 0 : 1;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int getVideoAutoPlayReal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? this.mVideoAutoPlayConfig : invokeV.intValue;
    }

    public SparseArray<Integer> getWaitDownloadTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? this.mWaitDownloadTheme : (SparseArray) invokeV.objValue;
    }

    public int getWebviewCrashCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.mWebviewCrashCount : invokeV.intValue;
    }

    public String getYijianfankuiFname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) ? this.mYijianfankuiFname : (String) invokeV.objValue;
    }

    public String getYunpushChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            if (TextUtils.isEmpty(this.mChannelId)) {
                this.mChannelId = c.a.p0.s.d0.b.j().p("yunpush_channel_id", "");
            }
            return this.mChannelId;
        }
        return (String) invokeV.objValue;
    }

    public String getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) ? PermissionUtil.isAgreePrivacyPolicy() ? FH.gz(sApp) : "000" : (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseApplication
    public void handleInitMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, message) == null) {
            boolean z = !LaunchUpSpeedSwitch.getIsOn();
            int i2 = message.what;
            if (i2 == 1) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_ONE_START_STAMP_KEY);
                loadPatchs();
                initCustomToastView();
                setServiceOnCreateCallBack();
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_ONE_STAMP_KEY);
                if (z) {
                    this.mAppInitHandler.sendEmptyMessage(2);
                }
            } else if (i2 == 2) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_TWO_START_STAMP_KEY);
                c.a.e.e.a.d.g().h(TbConfig.getTempDirName());
                c.a.q0.w2.a.g().j();
                boolean isMainProcess = isMainProcess(false);
                c.a.p0.v.a.k().n(isMainProcess);
                intReadThreadHistory(isMainProcess);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_TWO_STAMP_KEY);
                if (z) {
                    this.mAppInitHandler.sendEmptyMessage(3);
                }
            } else if (i2 == 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_THREE_START_STAMP_KEY);
                c.a.p0.t.a.a.c();
                initChangeSkinReceiver();
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_THREE_STAMP_KEY);
                if (z) {
                    this.mAppInitHandler.sendEmptyMessage(4);
                }
            } else if (i2 == 4) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(2045);
                c.a.p0.b1.e.m().t(this);
                initCyberPlayer();
                initCrabSdk();
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_FOUR_STAMP_KEY);
                if (z) {
                    this.mAppInitHandler.sendEmptyMessage(5);
                }
            } else if (i2 != 5) {
            } else {
                SpeedStatsManager.getInstance().addStatsTimeStamp(2046);
                registerPhoneListener();
                initICDN();
                initQuickWebViewManager();
                initStatSdk();
                initJpusbSdk();
                if (this.mNeedUploadMultidexError) {
                    c.a.p0.s.z.a.a("MultiDex", -1L, -1, "installMultidex", -1, this.mMultidexError, new Object[0]);
                }
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_FIVE_STAMP_KEY);
                Boolean bool = this.isCdnTachometerProcess;
                if ((bool == null || !bool.booleanValue()) && !this.isPluginInstallProcess) {
                    if (z) {
                        this.mAppInitHandler.sendEmptyMessage(6);
                        return;
                    }
                    return;
                }
                c.a.e.h.h.b.e("TbadkApplication_onCreate", "cdn_process");
                if (z) {
                    this.mAppInitHandler.sendEmptyMessage(7);
                }
            }
        }
    }

    public int hasLikeForum(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048728, this, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048729, this, str)) == null) {
            Hashtable<String, Integer> hashtable = this.mHasSignList;
            return (hashtable == null || str == null || !hashtable.containsKey(str)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void incBaiduYunPushCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            String str = "baidu_yun_push_sdk_crash_count_" + TbConfig.getVersion();
            TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
        }
    }

    public void incBaobaoCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            String str = "baobao_crash_count" + TbConfig.getVersion();
            TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
        }
    }

    public void incCrabSdkCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            String str = "crab_sdk_crash_count_" + TbConfig.getVersion();
            TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
        }
    }

    public void incDQCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            String str = "dq_crash_count" + TbConfig.getVersion();
            TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
        }
    }

    public void incLiveSdkCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            String str = "live_sdk_crash_count_" + TbConfig.getVersion();
            TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
        }
    }

    public void incPassportV6CrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            String str = "passport_crash_count_" + TbConfig.getVersion();
            TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
        }
    }

    public void incWalletSdkCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            String str = "wallet_crash_count" + TbConfig.getVersion();
            TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
        }
    }

    public void incWebpFailureCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048737, this) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("webp_failure_count", 0) + 1;
            if (loadInt > 5) {
                this.mCapableOfWebp = false;
                TbadkSettings.getInst().saveBoolean("capable_of_webp_format", false);
                return;
            }
            TbadkSettings.getInst().saveInt("webp_failure_count", loadInt);
        }
    }

    public void incXiaomiPushSdkCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            String str = "xiaomi_push_sdk_crash_count_" + TbConfig.getVersion();
            TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
        }
    }

    public void incXiaoyingCrashCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
            TbadkSettings.getInst().saveInt("xiaoying_crash_count", TbadkSettings.getInst().loadInt("xiaoying_crash_count", 0) + 1);
        }
    }

    public void initAccount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            c.a.p0.s.l.b.s().z();
        }
    }

    public void initAxeSdk() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048741, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            b.C1377b.c(getApplicationContext()).b().t();
        }
    }

    public void initBearSdk() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && isMainProcess(false) && PermissionUtil.isAgreePrivacyPolicy() && isNeedBearAd(c.a.p0.s.d0.b.j().k("splash_ad_strategy_key", 0))) {
            c.a.q0.w0.a.i().l();
        }
    }

    public void initCountStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            StartupCountStatsController.resetDefaultUploadID();
            StartupCountStatsController.init();
        }
    }

    public void initCrabSdk() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048744, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            c.a.q0.n3.a.getInstance().initSdk(this);
        }
    }

    public void initCuid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            String loadString = loadString("cuid", null);
            if (loadString != null && loadString.startsWith("baidutiebaapp")) {
                saveString("new_cuid", loadString);
                c.a.p0.s.d0.b.j().C("cuid");
                this.mCuid = loadString;
                return;
            }
            if (this.mCuid == null) {
                this.mCuid = loadString("new_cuid", null);
            }
            String str = this.mCuid;
            if (str == null || str.length() <= 0) {
                if (PermissionUtil.checkReadPhoneState(getApplicationContext())) {
                    this.mCuid = DeviceId.getCUID(getContext());
                }
                String str2 = this.mCuid;
                if (str2 == null || str2.length() <= 0) {
                    this.mCuid = createRandomString("baidutiebaapp", 50);
                }
                if (this.mCuid.indexOf(0) != -1) {
                    char[] charArray = this.mCuid.toCharArray();
                    StringBuilder sb = new StringBuilder(charArray.length);
                    for (int i2 = 0; i2 < charArray.length; i2++) {
                        if (charArray[i2] != 0) {
                            sb.append(charArray[i2]);
                        }
                    }
                    this.mCuid = sb.toString();
                }
                saveString("new_cuid", this.mCuid);
            }
        }
    }

    public void initCuidGalaxy2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048746, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            String loadString = loadString("new_cuid_galaxy2", null);
            this.cuid_galaxy2 = loadString;
            if (loadString == null || loadString.length() <= 0) {
                String cuid = DeviceId.getCUID(getContext());
                this.cuid_galaxy2 = cuid;
                saveString("new_cuid_galaxy2", cuid);
            }
        }
    }

    public void initCuidGalaxy3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048747, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            String loadString = loadString("new_cuid_galaxy3", null);
            this.cuid_galaxy3 = loadString;
            if (loadString == null || loadString.length() <= 0) {
                String b2 = c.a.r.b.e(getContext()).b();
                this.cuid_galaxy3 = b2;
                saveString("new_cuid_galaxy3", b2);
            }
        }
    }

    public void initCyberPlayer() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048748, this) == null) && PermissionUtil.isAgreePrivacyPolicy() && !CyberPlayerManager.isCoreLoaded(1)) {
            try {
                CyberPlayerManager.install(getInst().getContext(), getInst().getCuidGalaxy2(), null, 3, CyberRemotePlayerService.class, null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void initGrowthSdk() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048749, this) == null) && isMainProcess(false)) {
            GrowthStatsUtil.statisticDeviceInfo();
            GrowthStatsUtil.statisticActivity();
        }
    }

    public void initImei() {
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            try {
                if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadPhoneState(getContext()) && (telephonyManager = (TelephonyManager) getContext().getSystemService("phone")) != null) {
                    this.mImei = telephonyManager.getDeviceId();
                }
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
            if (this.mImei == null) {
                this.mImei = "000000000000000";
            }
        }
    }

    public void initLikeForum() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048751, this) == null) && this.mHasLikeList == null) {
            this.mHasLikeList = new Hashtable<>();
        }
    }

    public void initSapiTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048752, this) == null) && isMainProcess(true)) {
            MessageManager.getInstance().runTask(2921328, null, getContext());
        }
    }

    public void initSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.mGpuOpen = TbadkSettings.getInst().loadBoolean("gpu_open", shouldGPUOn());
            this.mUseHttpClient = TbadkSettings.getInst().loadBoolean("httpclient", true);
            this.mPromotedMessageOn = TbadkSettings.getInst().loadBoolean("permoted_message", true);
            this.mWebviewCrashCount = TbadkSettings.getInst().loadInt("webview_crash_count", 0);
            this.mIsAppOn = TbadkSettings.getInst().loadBoolean("app_switcher", false);
            this.mNewVcodeWebviewCrashCount = TbadkSettings.getInst().loadInt("new_vcode_webview_crash_count", 0);
            this.mIsLocationOn = TbadkSettings.getInst().loadBoolean("location_on", true);
            getInst().setIsLocationON(this.mIsLocationOn);
            this.mIsExitAppCloseWebSocket = TbadkSettings.getInst().loadBoolean("is_exit_app_not_start_websocket", false);
            this.mFaceShopVersion = TbadkSettings.getInst().loadInt("faceshop_version", -1);
            this.useTimeInterval = c.a.p0.s.d0.b.j().l("use_time_interval", TbConfig.DEFALT_USE_TIME_INTERVAL);
        }
    }

    public void initSignedForum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            if (this.mHasSignList == null) {
                this.mHasSignList = new Hashtable<>();
            }
            if (this.mSignLevelUpList == null) {
                this.mSignLevelUpList = new Hashtable<>();
            }
        }
    }

    public void initSpeedInstallStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            String latestFileName = FileHelper.DataDir.getLatestFileName(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR);
            if (TextUtils.isEmpty(latestFileName)) {
                SpeedStats.getInstance().onAppProcessUpgrade(2);
            } else if (latestFileName.equals(TbConfig.getVersion())) {
                SpeedStats.getInstance().onAppProcessUpgrade(0);
            } else {
                SpeedStats.getInstance().onAppProcessUpgrade(1);
            }
        }
    }

    public void initTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                c.a.p0.s.x.d.a();
                c.a.p0.o0.l.b().u(System.currentTimeMillis() - currentTimeMillis2);
            } finally {
                TTIStats.record("TbadkCoreApplication.initTasks", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public void initTrackConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            c.a.e.e.n.g.h(TbSingleton.getInstance().isIsOpenTrack());
        }
    }

    public void initUBC() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048758, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            c.a.n.b.a.b().c("tieba");
            AppConfig.init(false, false, false, false);
            if (c.a.h0.b.a.a.g()) {
                UBCIPCManager.b();
                CloudControlManager.getInstance().requestCloudControl("0");
            }
        }
    }

    public void initYunPushProcess() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048759, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            initLoki();
            initCountStats();
            initUBC();
            initRuka();
        }
    }

    public boolean isAccountsDataFromPass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("passport_crash_count_");
            sb.append(TbConfig.getVersion());
            return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(AccountsDataFromPassSwitch.ACCOUNT_DATA_FROM_PASS) != 1;
        }
        return invokeV.booleanValue;
    }

    public boolean isAppUploadOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) ? SwitchManager.getInstance().findType(AppUploadSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public boolean isAudioRecorderExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) ? this.isAudioRecorderExist : invokeV.booleanValue;
    }

    public boolean isAudioRecorderOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? SwitchManager.getInstance().findType(AudioRecorderSwitch.KEY_AUDIO_RECORDER_SWITCH) != 0 : invokeV.booleanValue;
    }

    public boolean isBaiduYunPushAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("baidu_yun_push_sdk_crash_count_");
            sb.append(TbConfig.getVersion());
            return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(BaiduYunPushSdkSwitch.BAIDU_YUN_PUSH_SDK_KEY) == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean isCrabSdkShouldOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("crab_sdk_crash_count_");
            sb.append(TbConfig.getVersion());
            return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(CrabSdkSwitch.CRAB_SDK_KEY) == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean isDQShouldOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("dq_crash_count");
            sb.append(TbConfig.getVersion());
            return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit();
        }
        return invokeV.booleanValue;
    }

    public boolean isExitAppCloseWebSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) ? this.mIsExitAppCloseWebSocket : invokeV.booleanValue;
    }

    public boolean isFaceShopNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) ? this.isFaceShopNew : invokeV.booleanValue;
    }

    public boolean isFirstTimeMotivate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) ? this.mIsFirstTimeMotivate : invokeV.booleanValue;
    }

    public boolean isGifAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) ? RichTextGifViewSwitch.isOn() && isGifAutoPlayFromSetting() : invokeV.booleanValue;
    }

    public boolean isGiftSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) ? SwitchManager.getInstance().findType(GiftSwitch.GIFT_SWITCH_KEY) != 1 : invokeV.booleanValue;
    }

    public boolean isGpuOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) ? this.mGpuOpen : invokeV.booleanValue;
    }

    public boolean isHeadsetModeOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) ? this.mVoiceHeadsetMode == 1 : invokeV.booleanValue;
    }

    public boolean isHttpAutoSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) ? this.mUseHttpAutoSwitch : invokeV.booleanValue;
    }

    public boolean isHttpClientOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) ? this.mUseHttpClient : invokeV.booleanValue;
    }

    public boolean isHybridBridgeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? SwitchManager.getInstance().findType(HybridBridgeSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public boolean isImmersiveStickyCanUse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) {
            if (!this.isImmersiveStickyPrefHasRead) {
                this.isImmersiveStickyCanUse = c.a.p0.s.d0.b.j().g("switch_immersive_sticky_status", true);
                this.isImmersiveStickyPrefHasRead = true;
            }
            return this.isImmersiveStickyCanUse;
        }
        return invokeV.booleanValue;
    }

    public boolean isInBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) ? c.a.p0.b1.m.g().i() : invokeV.booleanValue;
    }

    public boolean isKeyboardHeightCanSet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048779, this, i2)) == null) ? i2 > getResources().getDimensionPixelSize(R.dimen.ds460) : invokeI.booleanValue;
    }

    public boolean isKeyboardHeightCanUsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) ? this.keyboardHeight > getResources().getDimensionPixelSize(R.dimen.ds460) : invokeV.booleanValue;
    }

    public boolean isLbsWebViewSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) ? SwitchManager.getInstance().findType(LbsWebViewSwitch.LBS_WEBVIEW_SWITCH_KEY) != 0 : invokeV.booleanValue;
    }

    public boolean isLowVersionPassV6ShouldOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("passport_crash_count_");
            sb.append(TbConfig.getVersion());
            return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(LowVersionLoginPassV6Switch.KEY) != 1;
        }
        return invokeV.booleanValue;
    }

    public boolean isMIUIRom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048783, this)) == null) {
            String str = Build.MANUFACTURER;
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI);
        }
        return invokeV.booleanValue;
    }

    public boolean isMainProcess(boolean z, Context context) {
        InterceptResult invokeZL;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048785, this, z, context)) == null) {
            Boolean bool = this._isMainProcess;
            if (bool != null) {
                return bool.booleanValue();
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return z;
            }
            String packageName = context.getPackageName();
            String str = packageName + ":cdnTachometer";
            String str2 = packageName + ":daemon";
            String str3 = packageName + ":remote";
            String str4 = packageName + ":third";
            String str5 = packageName + ":pluginInstaller";
            String[] strArr = {str3, str, packageName + ":bdservice_v1", packageName + ":live", packageName + ":cdnTachometer", str2, packageName + ":xiaoying", str5, packageName + ":media", packageName + ":kmyas__"};
            String str6 = packageName + ":guardService";
            String str7 = packageName + ":warkup";
            String str8 = packageName + ":swan";
            String str9 = packageName + ":bdservice_v1";
            int myPid = Process.myPid();
            int i2 = 0;
            while (true) {
                if (i2 >= runningAppProcesses.size()) {
                    break;
                } else if (runningAppProcesses.get(i2).pid == myPid) {
                    String str10 = runningAppProcesses.get(i2).processName;
                    if (str10 == null) {
                        return z;
                    }
                    if (str10.equalsIgnoreCase(str2)) {
                        z2 = true;
                        this.isDaemonProcess = true;
                    } else {
                        z2 = true;
                    }
                    if (str10.equalsIgnoreCase(str9)) {
                        this.isYunPushProcess = z2;
                    }
                    if (str10.equalsIgnoreCase(packageName)) {
                        Plugin.mProcessName = "mainProcess";
                        this._isMainProcess = Boolean.TRUE;
                        return z2;
                    }
                    if (str10.contains(packageName)) {
                        Plugin.mProcessName = str10.replace(packageName, "");
                    }
                    if (str10.equalsIgnoreCase(str)) {
                        this.isCdnTachometerProcess = Boolean.TRUE;
                    }
                    if (str10.equalsIgnoreCase(str3)) {
                        z3 = true;
                        this.isRemoteProcess = true;
                    } else {
                        z3 = true;
                    }
                    if (str10.equalsIgnoreCase(str4)) {
                        this.isThirdProcess = z3;
                    }
                    if (str10.equalsIgnoreCase(str5)) {
                        this.isPluginInstallProcess = z3;
                    }
                    if (str10.equalsIgnoreCase(str6)) {
                        z4 = false;
                        z5 = true;
                    } else if (str10.equalsIgnoreCase(str7)) {
                        z5 = true;
                        z4 = false;
                    } else if (str10.contains(str8)) {
                        this.isAiAppsProcess = z3;
                        this._isMainProcess = Boolean.FALSE;
                        return false;
                    } else {
                        for (int i3 = 0; i3 < 10; i3++) {
                            if (str10.equalsIgnoreCase(strArr[i3])) {
                                this._isMainProcess = Boolean.FALSE;
                                return false;
                            }
                        }
                    }
                    this.isKeepLiveProcess = z5;
                    this._isMainProcess = Boolean.FALSE;
                    return z4;
                } else {
                    i2++;
                }
            }
            return z;
        }
        return invokeZL.booleanValue;
    }

    public boolean isMeiZuCanUseImmersive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048786, this)) == null) {
            if (!this.isMeiZuCanUseImmersiveHaveSet) {
                this.isMeiZuCanUseImmersiveHaveSet = true;
                String str = Build.BRAND;
                String str2 = Build.MODEL;
                if (UtilHelper.isMeizuM355()) {
                    this.isMeiZuCanUseImmersive = false;
                    return false;
                }
            }
            return this.isMeiZuCanUseImmersive;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedBearAd(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048787, this, i2)) == null) {
            switch (i2) {
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public boolean isNeedNewUserLead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048788, this)) == null) ? this.mIsNeedNewUserLead : invokeV.booleanValue;
    }

    public boolean isNoInterestTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048789, this)) == null) ? this.mIsNoInterestTag : invokeV.booleanValue;
    }

    public boolean isOfficial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048790, this)) == null) ? this.mIsOfficial : invokeV.booleanValue;
    }

    public boolean isPageStayOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) ? this.mIsPageStayOpen : invokeV.booleanValue;
    }

    public boolean isPassportV6ShouldOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("passport_crash_count_");
            sb.append(TbConfig.getVersion());
            return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(LoginPassV6Switch.KEY) != 1;
        }
        return invokeV.booleanValue;
    }

    public boolean isPicReqSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048793, this)) == null) ? c.a.p0.s.d0.b.j().k("key_pic_req_switch", 0) == 1 : invokeV.booleanValue;
    }

    public boolean isProcessBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048794, this)) == null) ? this.isBackground : invokeV.booleanValue;
    }

    public boolean isPromotedMessageOn(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048795, this, str)) == null) {
            String str2 = "permoted_message_" + str;
            if (TbadkSettings.getInst().isContains(str2)) {
                return TbadkSettings.getInst().loadBoolean(str2, true);
            }
            return this.mPromotedMessageOn;
        }
        return invokeL.booleanValue;
    }

    public boolean isPushServiceOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) ? loadBoolean("push_service", true) : invokeV.booleanValue;
    }

    public boolean isReadMenuDialogOnTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) ? this.isReadMenuDialogTop : invokeV.booleanValue;
    }

    public boolean isRecAppExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048798, this)) == null) ? this.isRecAppExist : invokeV.booleanValue;
    }

    public boolean isRegistedIntent(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048799, this, cls)) == null) ? getIntentClass(cls) != null : invokeL.booleanValue;
    }

    public boolean isRemoteProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048800, this)) == null) ? this.isRemoteProcess : invokeV.booleanValue;
    }

    public boolean isRunInFrontend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048801, this)) == null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) getInst().getApp().getSystemService("activity")).getRunningTasks(1);
            return (runningTasks == null || runningTasks.size() == 0 || !runningTasks.get(0).baseActivity.getPackageName().equals(getPackageName())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowSwipeBackGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048802, this)) == null) ? TbadkSettings.getInst().loadBoolean("show_swipe_back_key", true) : invokeV.booleanValue;
    }

    public boolean isThemeIconCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048803, this)) == null) ? c.a.p0.s.l.b.s().F() : invokeV.booleanValue;
    }

    public boolean isWalletShouldOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("wallet_crash_count");
            sb.append(TbConfig.getVersion());
            return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(WalletSwitch.WALLET_ENABLE) != 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isXiaomiPushSdkShouldOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048805, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("xiaomi_push_sdk_crash_count_");
            sb.append(TbConfig.getVersion());
            return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(XiaomiPushSdkSwitch.XIAOMIPUSH_SDK_KEY) != 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isXiaoyingAvaliable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048806, this)) == null) ? TbadkSettings.getInst().loadInt("xiaoying_crash_count", 0) <= getFeatureCrashAutoCloseLimit() : invokeV.booleanValue;
    }

    public boolean isYunPushProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048807, this)) == null) ? this.isYunPushProcess : invokeV.booleanValue;
    }

    public int likeForumCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048808, this)) == null) {
            Hashtable<String, Integer> hashtable = this.mHasSignList;
            if (hashtable != null) {
                return hashtable.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean loadBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048809, this, str, z)) == null) ? c.a.p0.s.d0.b.j().g(str, z) : invokeLZ.booleanValue;
    }

    public int loadInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048810, this, str, i2)) == null) ? c.a.p0.s.d0.b.j().k(str, i2) : invokeLI.intValue;
    }

    public void loadLcsSwitchStratgy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048811, this) == null) {
            String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
            if (TextUtils.isEmpty(loadString)) {
                return;
            }
            c.a.p0.t.e.d dVar = new c.a.p0.t.e.d();
            dVar.e(loadString);
            c.a.p0.t.j.c a2 = c.a.p0.t.j.c.a();
            a2.g(dVar.b() == 1);
            a2.h(dVar.c());
            a2.i(dVar.d() * 1000);
            if (dVar.a() != null) {
                a2.j(dVar.a());
            }
        }
    }

    public long loadLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048812, this, str, j2)) == null) ? c.a.p0.s.d0.b.j().l(str, j2) : invokeLJ.longValue;
    }

    public void loadPatchs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048813, this) == null) {
        }
    }

    public String loadString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048814, this, str, str2)) == null) ? c.a.p0.s.d0.b.j().p(str, str2) : (String) invokeLL.objValue;
    }

    public void login(TbPageContext<?> tbPageContext, CustomMessage<LoginActivityConfig> customMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048815, this, tbPageContext, customMessage) == null) || customMessage == null) {
            return;
        }
        if (tbPageContext != null) {
            tbPageContext.sendMessage(customMessage);
        } else {
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void notifyAppEnterBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048816, this) == null) {
            c.a.p0.b1.m.g().k();
        }
    }

    public void notifySwitchProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048817, this, z) == null) {
            c.a.p0.b1.m.g().m(z);
        }
    }

    @Override // c.a.e.a.b.a
    public void onActivityClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048818, this) == null) {
            getInst().onLowMemory();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2002014));
        }
    }

    @Override // com.baidu.adp.base.BdBaseApplication
    public void onAppMemoryLow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048819, this) == null) {
            int n2 = c.a.p0.b0.c.k().n();
            int max = (int) Math.max(n2 * 0.8d, TbConfig.getBigImageMaxUsedMemory());
            if (max < n2) {
                BdLog.isDebugMode();
                c.a.p0.b0.c.k().u(max);
            }
            BitmapHelper.clearCashBitmap();
            c.a.e.e.p.d.d().b();
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048820, this) == null) {
            SpeedStats.getInstance().setContext(this);
            sApp = this;
            SpeedStatsManager.getInstance().addStatsTimeStamp(2000);
            this.processCreateTime = System.currentTimeMillis();
            new IdleLaunchTaskManager().addIdleLaunchTask(this);
            FH.init(this, "200033", "ea737e4f435b53786043369d2e5ace4f", 1, 100084);
            super.onCreate(this);
            boolean z = !LaunchUpSpeedSwitch.getIsOn();
            if (z) {
                c.a.p0.s.l.b.s().A();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(2007);
            TbFaceManager.e().i(sApp, new c.a.p0.x.p.b());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_FACE_STAMP_KEY);
            if (c.a.p0.s.d0.b.j().k("static_opt_open", 0) > 0) {
                CmdRouter.init(this);
            }
            initTasks();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TASKS_STAMP_KEY);
            LaunchTaskSchedule.getInstance().init(1, new ApplicationTaskPool());
            LaunchTaskSchedule.getInstance().start(1);
            isMainProcess(false);
            c.a.p0.h0.h.f().g(this);
            if (z) {
                PermissionUtil.syncAgreeStatus(isMainProcess(false));
                PermissionUtil.registerMutiProcessPrivacyPolicy();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(2008);
            if (this.isYunPushProcess) {
                InitVersion();
                initYunPushProcess();
                return;
            }
            if (z) {
                FullBrowseHelper.registerBrowseModeRule();
                initDimenAdapt();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(2009);
            cleanDirectoryNewStatIfNeed();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2010);
            this.mPicReqSwitchType = c.a.p0.s.d0.b.j().k("key_pic_req_switch", 0);
            getSharedPreferences("adp_feature_switch", 0);
            SpeedStatsManager.getInstance().addStatsTimeStamp(2011);
            SpeedStatsManager.getInstance().addStatsTimeStamp(2012);
            setWebViewDataDirectorySuffix();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2013);
            initCmdConvertManager();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2014);
            InitVersion();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_VERSION_STAMP_KEY);
            initSpeedInstallStatus();
            init(getContext());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_ALL_STAMP_KEY);
            registerGoActionTask();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY);
            c.a.p0.s.l.a.c();
            if (z) {
                initAccount();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(2020);
            initInterruptRule();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2021);
            if (z) {
                initSapiTask();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(2022);
            if (z) {
                initPluginSettings();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_PLUGIN_STAMP_KEY);
            initSwanData();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_SWAN_DATA_STAMP_KEY);
            initBearSdk();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2025);
            isToLogo();
            SpeedStatsManager.getInstance().addStatsTimeStamp(2026);
            initLoki();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_LOKI_STAMP_KEY);
            StartupCountStatsController.init();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COUNT_STATS_STAMP_KEY);
            initCountStats();
            initUBC();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_UBC_STAMP_KEY);
            initGrowthSdk();
            initRuka();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_RUKA_STAMP_KEY);
            initAxeSdk();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_AXE_STAMP_KEY);
            initIM();
            if (z) {
                initAR(this);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_AR_STAMP_KEY);
            MessageManager.getInstance().registerListener(this.mDescriptionTableFixListener);
            initUETool();
            initLeakCanary();
            File file = new File(getFilesDir(), "so_cache");
            if (!file.exists()) {
                file.mkdir();
            }
            c.a.e.j.g.a(getContext(), file.getAbsolutePath());
            if (z) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                this.mAppInitHandler.sendMessageAtFrontOfQueue(obtain);
            }
            c.a.p0.o0.l.b().J(System.currentTimeMillis());
            SpeedStatsManager.getInstance().addStatsTimeStamp(2006);
            SpeedStats.getInstance().onAppCreateEnd();
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048821, this) == null) {
            onAppMemoryLow();
            super.onLowMemory();
        }
    }

    public void onUserChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048822, this) == null) {
            if (!c.a.e.e.p.l.D()) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2005007));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921410));
            c.a.p0.t.d.b.g0().X(true);
            NotificationHelper.cancelAllNotification(this);
            c.a.q0.i3.o0.a.n();
        }
    }

    public String readClientId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048824, this, context)) == null) {
            String loadString = loadString("client_id", null);
            if (loadString != null) {
                int indexOf = loadString.indexOf(TrackUI.SEPERATOR);
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

    public void refreshNewVersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048825, this, z) == null) {
            this.mNeedShowNewVersion = z;
            Intent intent2 = new Intent(TbConfig.getBroadcastActionNewVersion());
            intent2.setPackage(getInst().getPackageName());
            getApp().sendBroadcast(intent2);
        }
    }

    public void registerPhoneListener() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048826, this) == null) && PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadPhoneState(getContext())) {
            try {
                ((TelephonyManager) getInst().getApp().getSystemService("phone")).listen(new u(this, null), 32);
            } catch (SecurityException | Exception unused) {
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048827, this, broadcastReceiver, intentFilter)) == null) {
            try {
                return super.registerReceiver(broadcastReceiver, intentFilter);
            } catch (Throwable unused) {
                return new Intent();
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public void removeClientId(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048829, this, context) == null) {
            c.a.p0.s.d0.b.j().C("client_id");
        }
    }

    public void resetFontSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048830, this) == null) {
            this.mFontSize = TbadkSettings.getInst().loadInt("font_size", 2);
        }
    }

    public void resetIsImmersiveStickyPrefHasRead(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048831, this, z) == null) {
            this.isImmersiveStickyPrefHasRead = z;
        }
    }

    public void saveBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048832, this, str, z) == null) {
            c.a.p0.s.d0.b.j().t(str, z);
        }
    }

    public void saveInt(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048833, this, str, i2) == null) {
            c.a.p0.s.d0.b.j().v(str, i2);
        }
    }

    public void saveLong(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048834, this, str, j2) == null) {
            c.a.p0.s.d0.b.j().w(str, j2);
        }
    }

    public void saveString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048835, this, str, str2) == null) {
            c.a.p0.s.d0.b.j().x(str, str2);
        }
    }

    public void sendImagePv(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048836, this, i2, i3, str) == null) {
            sendImagePv(i2, i3, str, 0, 0);
        }
    }

    public void sendMessageForEnterBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048838, this) == null) {
            c.a.p0.b1.m.g().p();
        }
    }

    public void setActiveVersion(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048839, this, str) == null) || c.a.e.e.p.k.isEmpty(str) || StringUtil.NULL_STRING.equals(str)) {
            return;
        }
        FileHelper.DataDir.cleanDirectory(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR);
        FileHelper.DataDir.createFile("/package.last/" + str);
    }

    public void setActivityPrizeData(c.a.p0.t.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048840, this, bVar) == null) {
            this.activityPrizeData = bVar;
        }
    }

    public void setActivitySwitch(c.a.p0.t.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048841, this, cVar) == null) {
            this.mActivitySwitch = cVar;
        }
    }

    public void setAdAdSense(c.a.p0.t.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048842, this, dVar) == null) {
            this.mAdAdSense = dVar;
            if (dVar == null || dVar.a() == null) {
                return;
            }
            c.a.p0.t.c.j a2 = this.mAdAdSense.a();
            MessageManager.getInstance().registerStickyMode(2001434);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001434, a2));
        }
    }

    public void setAudioRecorderExist(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048843, this, z) == null) {
            this.isAudioRecorderExist = z;
        }
    }

    public void setBDLocON(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048844, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001330, Boolean.valueOf(z)));
            TbadkSettings.getInst().saveBoolean("bd_loc_switcher", z);
        }
    }

    public void setCanShowHotSplash(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048845, this, i2) == null) {
            this.canShowHotSplash = i2;
        }
    }

    public void setCardShowType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048846, this, i2) == null) {
            this.hasInit = true;
            this.cardShowType = i2;
        }
    }

    public void setCheckUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048847, this, str) == null) {
            this.checkUrl = str;
        }
    }

    public void setCombineDownload(CombineDownload combineDownload) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048848, this, combineDownload) == null) {
            this.mCombineDownload = combineDownload;
        }
    }

    public void setConfigVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048849, this, str) == null) {
            this.mConfigVersion = str;
        }
    }

    public void setConsumePathData(c.a.p0.t.c.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048850, this, uVar) == null) {
            this.mConsumePathData = uVar;
        }
    }

    public void setCurAiAppid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048851, this, str) == null) {
            this.mCurAiAppid = str;
        }
    }

    public void setCurrentActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048852, this, activity) == null) {
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

    public void setCustomizedFilter(c.a.p0.s.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048853, this, fVar) == null) {
            if (this.mCustomizedFilter != null) {
                BdLog.e("you cannot set CustomizedFilter again");
            }
            if (fVar != null) {
                if (fVar.b(2) && !fVar.b(-1)) {
                    BdLog.e("you should add CustomGroupType.PERSONAL_GROUP in the filter");
                }
                if (fVar.b(4) && !fVar.b(-9)) {
                    BdLog.e("you should add CustomGroupType.OFFICIAL_GROUP in the filter");
                }
            }
            this.mCustomizedFilter = fVar;
        }
    }

    public void setDefaultBubble(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048854, this, str) == null) {
            this.mDefaultBubble = str;
        }
    }

    public void setDefaultBubbleEndTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048855, this, i2) == null) {
            this.mDefaultBubbleEndTime = i2;
        }
    }

    public void setExitAppCloseWebSocket(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048856, this, z) == null) {
            this.mIsExitAppCloseWebSocket = z;
        }
    }

    public void setFaceShopNew(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048857, this, z) == null) {
            this.isFaceShopNew = z;
        }
    }

    public void setFaceShopVersion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048858, this, i2) == null) {
            this.mFaceShopVersion = i2;
            TbadkSettings.getInst().saveInt("faceshop_version", this.mFaceShopVersion);
        }
    }

    public void setFeatureCrashAutoCloseLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048859, this, i2) == null) {
            TbadkSettings.getInst().saveInt("feature_crash_auto_close_limit", i2);
        }
    }

    public void setFirstSyncImageQuality(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048860, this, z) == null) {
        }
    }

    public void setFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048861, this, i2) == null) || this.mFontSize == i2) {
            return;
        }
        this.mFontSize = i2;
        TbadkSettings.getInst().saveInt("font_size", i2);
    }

    public void setFramework_ver(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048862, this, str) == null) {
            this.framework_ver = str;
        }
    }

    public void setFriendFeedNew(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048863, this, z) == null) {
            this.isFriendFeedNew = z;
            this.mHandler.post(new m(this, z));
        }
    }

    public void setGameInfoData(String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048864, this, new Object[]{str, Long.valueOf(j2), str2}) == null) {
            this.infoIconUrl = str;
            this.infoTimeStamp = j2;
            this.infoTargetUrl = str2;
        }
    }

    public void setGpuOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048865, this, z) == null) {
            TbadkSettings.getInst().saveBoolean("gpu_open", z);
            this.mGpuOpen = z;
        }
    }

    public void setHasNewVersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048866, this, z) == null) {
            this.mHasNewVersion = z;
        }
    }

    public void setHeadsetModeOn(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048867, this, z) == null) || this.mVoiceHeadsetMode == z) {
            return;
        }
        this.mVoiceHeadsetMode = z ? 1 : 0;
        TbadkSettings.getInst().saveInt("voice_headset_mode", z ? 1 : 0);
    }

    public void setHomeBarShowType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048868, this, i2) == null) {
            this.homeBarShowType = i2;
        }
    }

    public void setHttpAutoSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048869, this, z) == null) {
            TbadkSettings.getInst().saveBoolean("httpclient_autoswitch", z);
            this.mUseHttpAutoSwitch = z;
        }
    }

    public void setHttpClientOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048870, this, z) == null) {
            TbadkSettings.getInst().saveBoolean("httpclient", z);
            this.mUseHttpClient = z;
        }
    }

    public void setHybridBridgeTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048871, this, i2) == null) {
            this.hybridBridgeTimeout = (i2 <= 10 || i2 >= 5000) ? 1000 : 1000;
        }
    }

    public void setImTimeOut(int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048872, this, iArr) == null) && iArr != null && iArr.length == 3) {
            StringBuilder sb = new StringBuilder(20);
            for (int i2 : iArr) {
                sb.append(i2);
                sb.append("|");
            }
            TbadkSettings.getInst().saveString("socket_time_out", sb.toString());
            c.a.e.c.j.c.c().d(iArr[0], iArr[1], iArr[2]);
        }
    }

    public void setInstallOtherApp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048873, this, str) == null) {
            TbadkSettings.getInst().saveString("install_other_app_file_name", str);
        }
    }

    public void setInstalledAppIds(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048874, this, str) == null) {
            this.mInstallAppIds = str;
        }
    }

    public void setInterestBoardConfigData(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048875, this, zVar) == null) {
            this.mInterestBoardConfigData = zVar;
        }
    }

    public void setInterviewLivePollingInterval(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048876, this, j2) == null) {
            this.mInterviewLivePollingInterval = j2;
        }
    }

    public void setIsAbstractOn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048877, this, i2) == null) {
            this.mIsAbstractOn = i2;
            TbadkSettings.getInst().saveInt("new_abstract_state", i2);
        }
    }

    public void setIsAppOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048878, this, z) == null) {
            TbadkSettings.getInst().saveBoolean("app_switcher", z);
            this.mIsAppOn = z;
        }
    }

    public void setIsFirstTimeMotivate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048879, this, z) == null) {
            this.mIsFirstTimeMotivate = z;
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921029));
            }
        }
    }

    public void setIsLocationON(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048880, this, z) == null) {
            this.mIsLocationOn = z;
            TbadkSettings.getInst().saveBoolean("location_on", z);
        }
    }

    public void setIsMeiZuCanUseImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048881, this, z) == null) {
            this.isMeiZuCanUseImmersiveHaveSet = true;
            this.isMeiZuCanUseImmersive = z;
        }
    }

    public void setIsNeedNewUserLead(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048882, this, i2) == null) {
            boolean z = i2 == 1;
            this.mIsNeedNewUserLead = z;
            if (z) {
                c.a.p0.s.d0.b.j().w("key_new_user_logon_time", System.currentTimeMillis());
            }
        }
    }

    public void setIsNewRegUser(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048883, this, z) == null) {
            this.mIsNewRegUser = z;
        }
    }

    public void setIsNoInterestTag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048884, this, z) == null) {
            this.mIsNoInterestTag = z;
        }
    }

    public void setIsPushServiceOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048885, this, z) == null) {
            saveBoolean("push_service", z);
        }
    }

    public void setKeepaliveNonWifi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048886, this, i2) == null) {
            saveInt("keepalive_nonwifi", i2);
        }
    }

    public void setKeepaliveWifi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048887, this, i2) == null) {
            saveInt("keepalive_wifi", i2);
        }
    }

    public void setKeyboardHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048888, this, i2) == null) {
            this.keyboardHeight = i2;
        }
    }

    public void setLastNotifyTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048889, this, j2) == null) {
            TbadkSettings.getInst().saveLong("last_notify_sound_time", j2);
        }
    }

    public void setLastSyncFinishTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048890, this, j2) == null) {
            this.mLastSyncFinishTime = j2;
        }
    }

    public void setLastUpdateMemberCenterTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048891, this, j2) == null) {
            this.lastUpdateMemberCenterTime = j2;
        }
    }

    public void setLastUpdateThemeTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048892, this, j2) == null) {
            this.lastUpdateThemeTime = j2;
        }
    }

    public void setLcsSwitchStratgy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048893, this, str) == null) {
            if (str == null) {
                str = "";
            }
            TbadkSettings.getInst().saveString("lcs_switch_strategy", str);
        }
    }

    public void setLikeBarChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048894, this, z) == null) {
            this.mLikeChanged = z;
        }
    }

    public void setLocationLat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048895, this, str) == null) {
            TbadkSettings.getInst().saveString("location_lat", str);
        }
    }

    public void setLocationLng(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048896, this, str) == null) {
            TbadkSettings.getInst().saveString("location_lng", str);
        }
    }

    public void setLocationPos(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048897, this, str) == null) {
            TbadkSettings.getInst().saveString("location_pos", str);
        }
    }

    public void setLocationShared(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048898, this, z) == null) {
            TbadkSettings inst = TbadkSettings.getInst();
            inst.saveBoolean("location_shared_" + getCurrentAccount(), z);
            if (z) {
                tryLbs();
            }
        }
    }

    public void setNeedCheckUserNameDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048899, this, z) == null) {
            this.needCheckUserNameDialog = z;
        }
    }

    public void setNetWorkCoreType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048900, this, i2) == null) {
            NetWorkCoreFacotry.setNetType(i2);
            saveInt("networkcore_type", i2);
        }
    }

    public void setNewVcodeWebviewCrashCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048901, this, i2) == null) {
            this.mNewVcodeWebviewCrashCount = i2;
        }
    }

    public void setPageStayOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048902, this, z) == null) {
            this.mIsPageStayOpen = z;
        }
    }

    public void setPaymemberInfo(PayMemberInfoData payMemberInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048903, this, payMemberInfoData) == null) {
            this.payInfo = payMemberInfoData;
        }
    }

    public void setPerformSampleCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048904, this, i2) == null) {
            this.mPerformSampleCount = i2;
            TbadkSettings.getInst().saveInt("perform_sample_count", i2);
        }
    }

    public void setProcesBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048905, this, z) == null) {
            this.isBackground = z;
        }
    }

    public void setProfileData(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048906, this, e0Var) == null) {
            this.mProfileData = e0Var;
        }
    }

    public void setPromotedMessage(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048907, this, str, z) == null) {
            TbadkSettings.getInst().saveBoolean("permoted_message_" + str, z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
        }
    }

    public void setProxyIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048908, this, str) == null) {
            this.proxyIp = str;
        }
    }

    public void setProxyPort(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048909, this, str) == null) {
            this.proxyPort = str;
        }
    }

    public void setPushChannelId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048910, this, str) == null) {
            saveString(Constants.EXTRA_PUSH_CHANNEL_ID, str);
        }
    }

    public void setPushChannelUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048911, this, str) == null) {
            saveString("push_channel_userId", str);
        }
    }

    public void setReadMenuDialogTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048912, this, z) == null) {
            this.isReadMenuDialogTop = z;
        }
    }

    public void setReadThreadPlayerScreenMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048913, this, i2) == null) {
            this.mReadThreadPlayerScreenMaxHeight = i2;
        }
    }

    public void setRecAppExist(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048914, this, z) == null) {
            this.isRecAppExist = z;
        }
    }

    public void setReporyUserInfoCurrentTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048915, this) == null) {
            TbadkSettings.getInst().saveLong("report_user_info_time_key" + getCurrentAccount(), System.currentTimeMillis());
        }
    }

    public void setSdk_ver(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048916, this, str) == null) {
            this.sdk_ver = str;
        }
    }

    public void setShareItem(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048917, this, shareItem) == null) {
            this.mShareItem = shareItem;
        }
    }

    public void setShowPayInfoRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048918, this, z) == null) {
            this.showPayInfoRedTip = z;
        }
    }

    public void setShowSwipeBackGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048919, this, z) == null) {
            TbadkSettings.getInst().saveBoolean("show_swipe_back_key", z);
        }
    }

    public void setSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048920, this, i2) == null) {
            c.a.p0.s.l.b.s().O(i2);
        }
    }

    public void setSkinTypeValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048921, this, i2) == null) {
            c.a.p0.s.l.b.s().P(i2);
        }
    }

    public void setSocketGetMsgStratgy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048922, this, str) == null) {
            TbadkSettings.getInst().saveString("socket_getmsg_strategy", str);
        }
    }

    public void setSocketHeartBeatStratgy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048923, this, str) == null) {
            TbadkSettings.getInst().saveString("socket_heartbeat_strategy", str);
        }
    }

    public void setSocketReconnStratgy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048924, this, str) == null) {
            TbadkSettings.getInst().saveString("socket_reconn_strategy", str);
        }
    }

    public void setStartType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048925, this, i2) == null) {
            this.startType = i2;
        }
    }

    public void setSwan_game_ver(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048926, this, str) == null) {
            this.swan_game_ver = str;
        }
    }

    public void setTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048927, this, str) == null) {
            this.task_id = str;
        }
    }

    public void setTbs(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048928, this, str) == null) {
            c.a.p0.s.l.b.s().Q(str);
        }
    }

    public void setTempFaceShopVersion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048929, this, i2) == null) {
            this.mTempFaceShopVersion = i2;
        }
    }

    public void setTempFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048930, this, i2) == null) || this.mFontSize == i2) {
            return;
        }
        this.mFontSize = i2;
    }

    public void setThemeIconCover(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048931, this, z) == null) {
            c.a.p0.s.l.b.s().R(z);
        }
    }

    public void setThemeWebviewOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048932, this, z) == null) {
            this.mThemeWebviewOpened = z;
        }
    }

    public void setUegVoiceWarning(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048933, this, str) == null) {
            this.uegVoiceWarning = str;
        }
    }

    public void setUpdateNotifyTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048934, this, j2) == null) {
            TbadkSettings.getInst().saveLong("update_notify_time", j2);
        }
    }

    public void setUrlText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048935, this, str) == null) {
            this.urlText = str;
        }
    }

    public void setUseNewResign(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048936, this, i2) == null) {
            this.useNewResign = i2;
        }
    }

    public void setUseTimeInterval(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048937, this, j2) == null) {
            c.a.p0.s.d0.b.j().w("use_time_interval", j2);
            this.useTimeInterval = j2;
        }
    }

    public void setUsed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048938, this) == null) {
            FileHelper.DataDir.cleanDirectory(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR);
            FileHelper.DataDir.createFile("/package.cur/" + TbConfig.getVersion());
        }
    }

    public void setUsedThemeColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048939, this, i2) == null) {
            c.a.p0.s.l.b.s().S(i2);
        }
    }

    public void setVersionData(VersionData versionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048940, this, versionData) == null) {
            this.mVersionData = versionData;
        }
    }

    public void setVideoAutoPlay(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048941, this, i2) == null) || this.mVideoAutoPlayConfig == i2) {
            return;
        }
        this.mVideoAutoPlayConfig = i2;
        TbadkSettings.getInst().saveInt("video_auto_play_new", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921511, ""));
    }

    public void setWebviewCrashCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048942, this, i2) == null) {
            this.mWebviewCrashCount = i2;
            TbadkSettings.getInst().saveInt("webview_crash_count", i2);
        }
    }

    public void setYijianfankuiFname(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048943, this, str) == null) {
            this.mYijianfankuiFname = str;
        }
    }

    public void setYunpushChannelId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048944, this, str) == null) {
            c.a.p0.s.d0.b.j().x("yunpush_channel_id", str);
        }
    }

    public boolean shouldGPUOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048945, this)) == null) {
            String trim = Build.MODEL.trim();
            boolean z = true;
            if (trim == null) {
                return true;
            }
            String[] strArr = {"M040", "M032", "M031", "M030", "HUAWEI C8813", "ZTE U970", "MediaPad 10 FHD", "GT-I9000", "DOEASY E930", "H8205", "GT-N7108", "GT-N7102", "GT-N719", "GT-N7100", "galaxy nexus", " ZTE U808", "UMI_X1", "nexus s", "AMOI N820", "JY-G", "XT885", "U701T", "Lenovo A750", "ZTE U807", "vivo S11t", "Droid Bionic", "MORAL_N01", "XT910", "GT-S7562", "Lenovo A798t", "vivo E5", "U705T", "HUAWEI T8951", "ME865", "HUAWEI P1XL", "KPT A9PLUS", "vivo Y11", "T9200", "XT928", "HUAWEI Y500-T00", "BBK Y3t", "Lenovo K860", "vivo X1", "HUAWEI T8833", "Lenovo A789", "ZTE U960E"};
            int i2 = 0;
            while (true) {
                if (i2 >= 46) {
                    break;
                } else if (strArr[i2].equalsIgnoreCase(trim)) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            BdLog.isDebugMode();
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean shouldNeedCheckUserNameDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048946, this)) == null) ? this.needCheckUserNameDialog : invokeV.booleanValue;
    }

    public int signedForumCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048947, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048948, this) == null) {
            getContext().startService(new Intent(getContext(), TiebaActiveService.class));
        }
    }

    public void startClearTempService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048949, this) == null) {
            try {
                getContext().startService(new Intent(getContext(), ClearTempService.class));
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public void startSyncLoginService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048950, this) == null) {
        }
    }

    public void startSyncService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048951, this) == null) {
            getContext().startService(new Intent(getContext(), TiebaSyncService.class));
        }
    }

    public void startTrackConfigRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048952, this) == null) {
            c.a.p0.a1.a aVar = new c.a.p0.a1.a();
            aVar.c();
            aVar.b(new i(this));
        }
    }

    public void stopActiveServide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048953, this) == null) {
            getContext().stopService(new Intent(getContext(), TiebaActiveService.class));
        }
    }

    public void stopSyncService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048954, this) == null) {
            getContext().stopService(new Intent(getContext(), TiebaSyncService.class));
        }
    }

    public void tryLbs() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048955, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            this.mHandler.postDelayed(new d(this), 5000L);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048956, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    public void upgradeAbstractOnInMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048957, this, i2) == null) {
            this.mIsAbstractOn = i2;
        }
    }

    public String getZid(Context context, String str, int i2, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048726, this, context, str, i2, str2)) == null) ? PermissionUtil.isAgreePrivacyPolicy() ? FH.gzfi(context, str, i2, str2) : "000" : (String) invokeLLIL.objValue;
    }

    public void sendImagePv(int i2, int i3, String str, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048837, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (this.imagePvThread == null) {
                this.imagePvThread = Executors.newSingleThreadExecutor();
            }
            a0 a0Var = new a0(i2, i3);
            a0Var.a(str);
            this.imagePvThread.execute(a0Var);
            TiebaStatic.eventStat(getInst().getApp(), "img_browse", null, 1, "img_num", Integer.valueOf(i2), "img_total", Integer.valueOf(i3), "img_type", str, "img_begin", Integer.valueOf(i4), "img_end", Integer.valueOf(i5));
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048828, this, broadcastReceiver, intentFilter, str, handler)) == null) {
            try {
                return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
            } catch (Throwable unused) {
                return new Intent();
            }
        }
        return (Intent) invokeLLLL.objValue;
    }

    public void onUserChanged(Intent intent2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048823, this, intent2) == null) {
            if (intent2 != null) {
                String stringExtra = intent2.getStringExtra(LoginActivityConfig.USER_INFO_CHANGED);
                if (!TextUtils.isEmpty(stringExtra)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016494, stringExtra));
                }
            }
            onUserChanged();
        }
    }

    public boolean isMainProcess(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048784, this, z)) == null) ? isMainProcess(z, getApplicationContext()) : invokeZ.booleanValue;
    }
}
