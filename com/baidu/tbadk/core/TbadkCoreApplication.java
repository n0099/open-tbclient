package com.baidu.tbadk.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.StartupCountStatsController;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.Loki;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ruka.Ruka;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.sofire.ac.FH;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
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
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.FileHelper;
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
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.tieba.keepLive.nativekeepalive.ClientGuard;
import com.baidu.tieba.keepLive.nativekeepalive.GuardConfigurations;
import com.baidu.tieba.keepLive.nativekeepalive.GuardReceiverObserver;
import com.baidu.tieba.keepLive.nativekeepalive.GuardReceiverWatcher;
import com.baidu.tieba.keepLive.nativekeepalive.GuardServiceObserver;
import com.baidu.tieba.keepLive.nativekeepalive.GuardServiceWatcher;
import com.baidu.tieba.play.cyberPlayer.CyberRemotePlayerService;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.ubc.UBCIPCManager;
import d.a.c.a.b;
import d.a.c.a.k.a;
import d.a.c.e.i.a;
import d.a.c.e.p.l;
import d.a.j0.r.q.x0;
import d.a.j0.s.c.c0;
import d.a.j0.s.c.z;
import d.a.j0.y0.a;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.j0.z0.k;
import d.a.j0.z0.x;
import d.a.k0.u1.c;
import d.a.q.f.a.b;
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
/* loaded from: classes3.dex */
public class TbadkCoreApplication extends BdBaseApplication implements b.a, c.InterfaceC1674c {
    public static final long ACTION_TEST = 1;
    public static final String ACTIVE_CLEAR_TAG = "active_clear";
    public static final int APP_EVENT_LOGIN = 1;
    public static final String DEFAULT_IMEI = "000000000000000";
    public static boolean IS_APP_RUNNING = false;
    public static boolean IS_SUPPORT_EXCEPTION_HANDLER = true;
    public static boolean IS_SUPPORT_SWIPEBACK = true;
    public static final String KEEPLIVESWITCH = "tbKeepLiveSwtich";
    public static final String KEEPLIVESWITCHFILE = "tbKeepLiveSwtichFile";
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
    public static boolean isMyLive = false;
    public static boolean isNeedRefreshOnResume = false;
    public static boolean isSDKLogin = false;
    public static String mUniqueId;
    public static TbadkCoreApplication sApp;
    public Boolean _isMainProcess;
    public d.a.j0.s.c.b activityPrizeData;
    public String framework_ver;
    public boolean hasInit;
    public String infoIconUrl;
    public String infoTargetUrl;
    public long infoTimeStamp;
    public boolean isBackground;
    public Boolean isCdnTachometerProcess;
    public boolean isFriendFeedNew;
    public boolean isRemoteProcess;
    public int keyboardHeight;
    public z listItemRule;
    public d.a.j0.s.c.c mActivitySwitch;
    public d.a.j0.s.c.d mAdAdSense;
    public ClientGuard mClientGuard;
    public String mConfigVersion;
    public d.a.j0.r.j mCoreActivityLifecycleCallbacks;
    public String mCurAiAppid;
    public WeakReference<Activity> mCurrentActivityRef;
    public d.a.j0.r.f mCustomizedFilter;
    public String mInstallAppIds;
    public long mInterviewLivePollingInterval;
    public boolean mIsFirstTimeMotivate;
    public boolean mIsNeedNewUserLead;
    public long mLastSyncFinishTime;
    public int mPicReqSwitchType;
    public c0 mProfileData;
    public ShareItem mShareItem;
    public d.a.k0.u1.c mSplash;
    public SparseArray<Integer> mWaitDownloadTheme;
    public String mYijianfankuiFname;
    public PayMemberInfoData payInfo;
    public long processCreateTime;
    public String proxyIp;
    public String proxyPort;
    public String sdk_ver;
    public String swan_game_ver;
    public String task_id;
    public String uegVoiceWarning;
    public String urlText;
    public long useTimeInterval;
    public d.a.j0.s.c.u mConsumePathData = null;
    public int hybridBridgeTimeout = 1000;
    public boolean mThemeWebviewOpened = false;
    public boolean mCapableOfWebp = false;
    public int mNewVcodeWebviewCrashCount = 0;
    public boolean mIsLocationOn = true;
    public boolean isThirdProcess = false;
    public boolean isAiAppsProcess = false;
    public boolean isPluginInstallProcess = false;
    public int mVoiceHeadsetMode = 0;
    public boolean isDaemonProcess = false;
    public boolean isYunPushProcess = false;
    public boolean mIsExitAppCloseWebSocket = false;
    public boolean mIsToLogo = false;
    public boolean mPluginIsInited = false;
    public final Object mPluginNotify = new Object();
    public String mCuid = null;
    public String cuid_galaxy2 = "";
    public String cuid_galaxy3 = "";
    public String cuid_gid = "";
    public String mAndroidId = "";
    public String mImei = null;
    public boolean mIsOfficial = true;
    public int mFaceShopVersion = -1;
    public int mPerformSampleCount = 10;
    public VersionData mVersionData = null;
    public long mInitTime = 0;
    public int mIsAbstractOn = 1;
    public final Handler mHandler = new Handler();
    public boolean isImmersiveStickyCanUse = true;
    public boolean isImmersiveStickyPrefHasRead = false;
    public View mCustomToastView = null;
    public int mVideoAutoPlayConfig = -1;
    public long currentAccountFlowerNum = 0;
    public long currentAccountTdouNum = 0;
    public String mMultidexError = "";
    public boolean mNeedUploadMultidexError = false;
    public boolean mIsNoInterestTag = false;
    public boolean syncHasFinish = false;
    public boolean isKeepLiveProcess = false;
    public int startType = 2;
    public int canShowHotSplash = 2;
    public SparseArray<FrsNetModel> mFrsModelArray = new SparseArray<>();
    public CustomMessageListener mDescriptionTableFixListener = new j(2921510);
    public boolean mIsPageStayOpen = false;
    public boolean isMeiZuCanUseImmersiveHaveSet = false;
    public boolean isMeiZuCanUseImmersive = true;
    public Handler handler = new Handler(new n());
    public boolean isReadMenuDialogTop = false;
    public a.c locationCallBack = new c();
    public int mWebviewCrashCount = 0;
    public boolean mGpuOpen = false;
    public boolean mPromotedMessageOn = true;
    public boolean mUseHttpClient = true;
    public boolean mUseHttpAutoSwitch = true;
    public boolean mIsAppOn = false;
    public String mDefaultBubble = null;
    public int mDefaultBubbleEndTime = 0;
    public boolean mHasNewVersion = false;
    public CombineDownload mCombineDownload = null;
    public ArrayList<BaseActivity<?>> mRemoteActivity = null;
    public int mFontSize = 3;
    public HashMap<String, SoftReference<d.a.c.j.d.a>> mFaces = null;
    public boolean isPhoneCalling = false;
    public ExecutorService imagePvThread = null;
    public Hashtable<String, Integer> mHasLikeList = null;
    public Hashtable<String, Integer> mHasSignList = null;
    public Hashtable<String, Integer> mSignLevelUpList = null;
    public boolean mLikeChanged = false;
    public boolean isFaceShopNew = false;
    public int mTempFaceShopVersion = -1;
    public boolean isRecAppExist = false;
    public boolean isAudioRecorderExist = false;
    public String checkUrl = null;
    public int useNewResign = 0;
    public long lastUpdateThemeTime = 0;
    public long lastUpdateMemberCenterTime = 0;
    public boolean showPayInfoRedTip = true;
    public boolean mNeedShowNewVersion = false;
    public boolean mIsNewRegUser = false;
    public d.a.k0.d3.n0.d mReadThreadHistory = null;
    public d.a.k0.d3.n0.c mPhotoLiveReadHistory = null;
    public l.c mToast = null;
    public int mReadThreadPlayerScreenMaxHeight = 0;
    public String mChannelId = "";
    public int cardShowType = 0;
    public int homeBarShowType = 1;
    public boolean needCheckUserNameDialog = true;

    /* loaded from: classes3.dex */
    public class a implements d.a.j0.z0.n<Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            if (bool != null) {
                TbadkCoreApplication.this.mIsOfficial = bool.booleanValue();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CustomMessageTask.CustomRunnable<Intent> {
        public b() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
            UtilHelper.commenDealIntent(d.a.c.a.b.f().b() == null ? TbadkCoreApplication.this.getApp() : d.a.c.a.b.f().b(), customMessage.getData());
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.c {
        public c() {
        }

        @Override // d.a.c.e.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            if (i2 != 0 || address == null) {
                return;
            }
            try {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(valueOf2)) {
                    return;
                }
                TbadkCoreApplication.this.setLocationLat(valueOf);
                TbadkCoreApplication.this.setLocationLng(valueOf2);
                TbadkCoreApplication.this.setLocationPos(address.getAddressLine(0));
                d.a.k0.s2.g0.a.e().i(valueOf);
                d.a.k0.s2.g0.a.e().j(valueOf2);
                d.a.k0.s2.g0.a.e().k(System.currentTimeMillis());
            } catch (IllegalStateException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.e.i.a.l().i(true, TbadkCoreApplication.this.locationCallBack);
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements a.InterfaceC0494a {
        @Override // d.a.c.a.k.a.InterfaceC0494a
        public void a(SQLiteDatabase sQLiteDatabase) {
            TbadkCoreApplication.resetTDatabaseCreateTime();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements CustomMessageTask.CustomRunnable<x0> {
        public f() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<x0> customMessage) {
            UtilHelper.showYYNotification(TbadkCoreApplication.this.getContext(), customMessage.getData(), 13);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.c.c.e.c.k.b {
        public g() {
        }

        @Override // d.a.c.c.e.c.k.b
        public boolean a() {
            return !TbadkCoreApplication.this.isExitAppCloseWebSocket();
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements d.a.c.c.e.c.k.c {

        /* loaded from: classes3.dex */
        public class a implements k.b {
            public a(h hVar) {
            }

            @Override // d.a.j0.z0.k.b
            public void onResult(boolean z) {
                if (z) {
                    return;
                }
                d.a.j0.c0.a.b(0, 0, 0, 1, 8);
                BdSocketLinkService.startService(false, "restart");
            }
        }

        @Override // d.a.c.c.e.c.k.c
        public void a() {
            d.a.j0.z0.k.e().c(new a(this));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements a.b {
        public i() {
        }

        @Override // d.a.j0.y0.a.b
        public void a(boolean z, boolean z2) {
            d.a.c.e.n.f.h(z2);
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.k0.d3.l0.d.d)) {
                return;
            }
            d.a.k0.d3.l0.d.d dVar = (d.a.k0.d3.l0.d.d) customResponsedMessage.getData();
            DescriptionTableInfo.setModuleSet(dVar.f53913a);
            DescriptionTableInfo.setDescriptionTable(dVar.f53914b);
        }
    }

    /* loaded from: classes3.dex */
    public class k extends f0<Object> {
        public k() {
        }

        @Override // d.a.j0.z0.f0
        public Object doInBackground() {
            if ("12.1.0.1".equals(FileHelper.DataDir.getLatestVersion())) {
                FileHelper.DataDir.cleanDirectory("/newStat");
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements l.c {
        public l() {
        }

        @Override // d.a.c.e.p.l.c
        public void a() {
            TbadkCoreApplication.this.mCustomToastView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.custom_toast_textview, (ViewGroup) null);
        }

        @Override // d.a.c.e.p.l.c
        public void b(String str) {
            if (c() instanceof TextView) {
                ((TextView) c()).setText(str);
            }
        }

        @Override // d.a.c.e.p.l.c
        public View c() {
            return TbadkCoreApplication.this.mCustomToastView;
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f12108e;

        public m(boolean z) {
            this.f12108e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new d.a.j0.e0.a(this.f12108e)));
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Handler.Callback {
        public n() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                d.a.j0.r.z.a.a("account", -1L, 0, "application_clear_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.this.getContext());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(TbadkCoreApplication.this.getContext(), true)));
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BDHttpDns f12111e;

        public o(BDHttpDns bDHttpDns) {
            this.f12111e = bDHttpDns;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12111e.p(PrefetchEvent.MODULE);
        }
    }

    /* loaded from: classes3.dex */
    public class p implements d.a.c.c.e.c.k.e {

        /* loaded from: classes3.dex */
        public class a implements k.b {
            public a(p pVar) {
            }

            @Override // d.a.j0.z0.k.b
            public void onResult(boolean z) {
                if (z) {
                    BdBaseService.serviceStartFlag = 2;
                } else {
                    BdBaseService.serviceStartFlag = 1;
                }
            }
        }

        public p() {
        }

        @Override // d.a.c.c.e.c.k.e
        public void a() {
            d.a.j0.z0.k.e().c(new a(this));
        }
    }

    /* loaded from: classes3.dex */
    public class q extends d.a.c.c.f.d {
        public q(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.c.f.f
        /* renamed from: a */
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (TbadkCoreApplication.this.checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(httpMessage.getCmd()))) {
                return null;
            }
            return httpMessage;
        }
    }

    /* loaded from: classes3.dex */
    public class r extends d.a.c.c.f.k {
        public r(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.c.f.f
        /* renamed from: a */
        public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
            if (TbadkCoreApplication.this.checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(socketMessage.getCmd()))) {
                return null;
            }
            return socketMessage;
        }
    }

    /* loaded from: classes3.dex */
    public class s implements CustomMessageTask.CustomRunnable<IntentConfig> {
        public s() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<IntentConfig> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage == null || customMessage.getData() == null) {
                return null;
            }
            IntentConfig data = customMessage.getData();
            if (data.asynStart()) {
                return new CustomResponsedMessage<>(customMessage.getCmd(), data);
            }
            Class<?> intentClass = TbadkCoreApplication.this.getIntentClass(data.getClass());
            if (TbadkCoreApplication.this.getIntentClass(AlbumActivityConfig.class) == null) {
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
    }

    /* loaded from: classes3.dex */
    public class t extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12117a;

        public t(Context context) {
            this.f12117a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.j0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(CertVerifyHelper.isOfficial(this.f12117a));
        }
    }

    /* loaded from: classes3.dex */
    public class u extends PhoneStateListener {
        public u() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            if (i2 == 0) {
                TbadkCoreApplication.this.isPhoneCalling = false;
            } else if (i2 == 1 || i2 == 2) {
                TbadkCoreApplication.this.isPhoneCalling = true;
            }
            super.onCallStateChanged(i2, str);
        }

        public /* synthetic */ u(TbadkCoreApplication tbadkCoreApplication, j jVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class v implements GuardConfigurations.DaemonListener {
        public v() {
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.GuardConfigurations.DaemonListener
        public void onDaemonAssistantStart(Context context) {
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.GuardConfigurations.DaemonListener
        public void onPersistentStart(Context context) {
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.GuardConfigurations.DaemonListener
        public void onWatchDaemonDaed() {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x006b -> B:38:0x006e). Please submit an issue!!! */
    private void InitFrom() {
        BufferedReader bufferedReader;
        Exception e2;
        String fromByShare;
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

    public static boolean checkNeedShowNewVersion() {
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

    private void cleanDirectoryNewStatIfNeed() {
        if (isMainProcess(true) && getInst().getIsFirstUse()) {
            h0.b(new k(), null);
        }
    }

    private GuardConfigurations createDaemonConfigurations() {
        return new GuardConfigurations(new GuardConfigurations.DaemonConfiguration("com.baidu.tieba:guardService", GuardServiceObserver.class.getCanonicalName(), GuardReceiverObserver.class.getCanonicalName()), new GuardConfigurations.DaemonConfiguration("com.baidu.tieba:warkup", GuardServiceWatcher.class.getCanonicalName(), GuardReceiverWatcher.class.getCanonicalName()), new v());
    }

    private void dealYYNotification() {
        d.a.j0.v0.a aVar = new d.a.j0.v0.a(2012100, new f());
        aVar.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
    }

    public static String getClientId() {
        return clientId;
    }

    private int getCrashLimitCount() {
        try {
            int k2 = d.a.j0.r.d0.b.j().k("crash_limit_count", 100);
            if (k2 < 10) {
                return 10;
            }
            return k2;
        } catch (Throwable unused) {
            return 100;
        }
    }

    public static String getCurrentAccount() {
        return d.a.j0.r.l.b.s().g();
    }

    public static String getCurrentAccountForEmotion() {
        return d.a.j0.r.l.b.s().h();
    }

    public static long getCurrentAccountId() {
        return d.a.j0.r.l.b.s().i();
    }

    public static AccountData getCurrentAccountInfo() {
        return d.a.j0.r.l.b.s().j();
    }

    public static String getCurrentAccountName() {
        return d.a.j0.r.l.b.s().k();
    }

    public static String getCurrentAccountNameShow() {
        return d.a.j0.r.l.b.s().l();
    }

    public static AccountData getCurrentAccountObj() {
        return d.a.j0.r.l.b.s().m();
    }

    public static String getCurrentAvatar() {
        return d.a.j0.r.l.b.s().n();
    }

    public static String getCurrentBduss() {
        return d.a.j0.r.l.b.s().o();
    }

    public static int getCurrentMemberType() {
        return d.a.j0.r.l.b.s().p();
    }

    public static String getCurrentPortrait() {
        return d.a.j0.r.l.b.s().q();
    }

    public static String getCurrentTbs() {
        return d.a.j0.r.l.b.s().o();
    }

    public static String getCurrentVerson(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int getCurrentVipLevel() {
        return d.a.j0.r.l.b.s().r();
    }

    public static String getFrom() {
        return TbConfig.getFrom();
    }

    private String getFromByFile() {
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

    private String getFromByShare() {
        return loadString("from_id", null);
    }

    public static TbadkCoreApplication getInst() {
        return sApp;
    }

    public static Intent getIntent() {
        return intent;
    }

    public static boolean getIsAppRunning() {
        return IS_APP_RUNNING;
    }

    public static boolean getKeepLiveSwitch(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences(KEEPLIVESWITCHFILE, 0)) == null) {
            return true;
        }
        return sharedPreferences.getBoolean(KEEPLIVESWITCH, true);
    }

    public static boolean getRefreshFlag() {
        return isNeedRefreshOnResume;
    }

    public static synchronized String getUniqueIdentifier() {
        String str;
        synchronized (TbadkCoreApplication.class) {
            if (mUniqueId == null) {
                String cuid = getInst().getCuid();
                String packageName = getInst().getApp().getPackageName();
                String version = TbConfig.getVersion();
                mUniqueId = cuid + FieldBuilder.SE + packageName + version;
            }
            str = mUniqueId;
        }
        return str;
    }

    private void init(Context context) {
        if (!isDebugMode() && TbConfig.IS_CHECK_OFFICAL_APPLICATION) {
            h0.b(new t(context), new a());
        }
        initCuid();
        initCuidGalaxy2();
        initCuidGalaxy3();
        TbConfig.initBigImageMaxUsedMemory(getContext());
        clientId = readClientId(getContext());
        initImei();
        InitFrom();
        initSetting();
        initWebsocketBase(context);
        this.mFontSize = TbadkSettings.getInst().loadInt("font_size", 2);
        this.mVideoAutoPlayConfig = TbadkSettings.getInst().loadInt("video_auto_play_new", -1);
        try {
            d.a.c.e.i.a.l().o();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            x.b().e();
            if (isMainProcess(false)) {
                d.a.j0.f.a.d().f();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (isMainProcess(true)) {
            d.a.j0.a0.c.k().q(TbConfig.getMaxPhotoMemoryCache(), TbConfig.getBigImageMaxUsedMemory());
        } else {
            d.a.j0.a0.c.k().q(TbConfig.getMaxPhotoMemoryCacheForRemoteProcess(), TbConfig.getBigImageMaxUsedMemoryForRemoteProcess());
        }
        loadLcsSwitchStratgy();
        initSettings();
        this.mFaces = new HashMap<>();
        initSdcardDatabaseCallback();
        ReloginManager.g().k();
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.addMessageRule(new d.a.j0.r0.f(0));
        messageManager.addMessageRule(new d.a.j0.r0.c(0));
        messageManager.addResponsedMessageRule(new d.a.j0.r0.e(0));
        messageManager.addRemovedMessageRule(new d.a.j0.r0.d(0));
        messageManager.addResponsedMessageRule(new d.a.k0.x0.c());
        messageManager.addResponsedMessageRule(new d.a.k0.x0.b());
        messageManager.addResponsedMessageRule(new d.a.j0.r0.a());
        messageManager.addResponsedMessageRule(new d.a.j0.r0.b());
        messageManager.addResponsedMessageRule(new d.a.k0.n3.c.a());
        initAppSettings();
        ViewHelper.initSkinDataOnStartup(getContext());
        TbConfig.initBigImageWidth(getContext());
        TbConfig.initFriendPhotoConfig(getContext());
        if (IS_SUPPORT_EXCEPTION_HANDLER) {
            d.a.k0.i3.d.a();
        }
        d.a.k0.q3.f.d();
        boolean isMainProcess = isMainProcess(false);
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.init(getContext(), isMainProcess);
        d.a.j0.m0.l.b().K(System.currentTimeMillis() - currentTimeMillis);
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
        d.a.j0.v0.a aVar = new d.a.j0.v0.a(2012000, new b());
        aVar.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        dealYYNotification();
        if (isMainProcess(true)) {
            sendMessageForEnterBackground();
        }
        NetMessage.setGlobalSwitchToHttpStrategy(new NetMessage.a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.12
            @Override // com.baidu.adp.framework.message.NetMessage.a
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    return socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005;
                }
                return false;
            }
        });
        d.a.j0.r.j jVar = new d.a.j0.r.j();
        this.mCoreActivityLifecycleCallbacks = jVar;
        registerActivityLifecycleCallbacks(jVar);
        InputMethodManagerLeaksFixer.fixFocusedViewLeak(this);
        if (isMainProcess) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921301));
        }
    }

    private void initAppSettings() {
        d.a.j0.r.k.c().f();
    }

    private void initBearSdk() {
        if (isMainProcess(false) && isNeedBearAd(d.a.j0.r.d0.b.j().k("splash_ad_strategy_key", 0))) {
            d.a.k0.r0.a.h().j();
        }
    }

    private void initChangeSkinReceiver() {
        d.a.j0.r.l.b.s().B();
    }

    private void initCmdConvertManager() {
        if (isDebugMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(d.a.j0.r.x.b.class.getName());
            arrayList.add(d.a.j0.r.x.a.class.getName());
            arrayList.add(CmdConfigHttp.class.getName());
            d.a.c.c.a.a().c(arrayList);
        }
    }

    private void initCustomToastView() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mToast == null && d.a.c.e.p.l.u() == null) {
            l lVar = new l();
            this.mToast = lVar;
            d.a.c.e.p.l.H(lVar);
            d.a.j0.m0.l.b().L(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void initDimenAdapt() {
        TbDimenManager.getInstance().init(this);
    }

    private void initICDN() {
        d.a.c.e.j.a.c.f38951f = UseHttpdnsSdkSwitch.isOn();
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
                this.mHandler.postDelayed(new o(j2), 1000L);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ICDNProblemUploader.getInstance();
        ICDNIPDirectConnect.getInstance();
        if (isMainProcess(true) && ICDNIPDirectConnect.getInstance() != null) {
            ICDNIPDirectConnect.getInstance().init();
        }
        d.a.j0.m0.l.b().n(System.currentTimeMillis() - currentTimeMillis);
    }

    private void initIM() {
        long currentTimeMillis = System.currentTimeMillis();
        d.a.k0.e1.a.a();
        d.a.j0.m0.l.b().p(System.currentTimeMillis() - currentTimeMillis);
    }

    private void initInterruptRule() {
        MessageManager.getInstance().addMessageRule(new q(0));
        MessageManager.getInstance().addMessageRule(new r(0));
    }

    private void initJpusbSdk() {
        if (isMainProcess(true)) {
            d.a.k0.i3.b.b().d(this);
        }
    }

    private void initLocationSetting() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isMainProcess(true) && d.a.j0.r.l.b.s().g() == null) {
            tryLbs();
        }
        d.a.j0.m0.l.b().v(System.currentTimeMillis() - currentTimeMillis);
    }

    private void initLoki() {
        if (Loki.isLokiService(d.a.c0.b.a.a.b())) {
            Loki.initService();
            return;
        }
        Loki.init(this);
        Loki.initNative(this);
    }

    private void initPluginSettings() {
        if (Build.VERSION.SDK_INT >= 24 && (!this.isRemoteProcess || XiaomiWebViewInitSwitch.isOn())) {
            try {
                new WebView(this);
            } catch (Throwable unused) {
            }
        }
        PluginPackageManager.O().U(TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER, isMainProcess(false), this.isThirdProcess, this.isRemoteProcess);
        PluginCenter.getInstance().launch("com.baidu.tieba.pluginFlutter", false);
    }

    private void initQuickWebViewManager() {
        if (isMainProcess(true)) {
            d.a.k0.q2.b.q().u();
            long currentTimeMillis = System.currentTimeMillis();
            d.a.j0.s.d.d.d().m();
            d.a.j0.m0.l.b().z(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void initRuka() {
        if (isMainProcess(false)) {
            Ruka.startAnrMonitor(this);
            Ruka.startLooperMonitor(this);
        }
    }

    public static void initSdcardDatabaseCallback() {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().k(new e());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initSettings() {
        boolean z;
        AssetManager assets;
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
        d.a.j0.m0.l.b().r(System.currentTimeMillis() - currentTimeMillis);
    }

    public static void initSocket() {
        d.a.j0.v0.b registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.e(false);
        registerImScoketTask.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", getUniqueIdentifier()));
        new UseHttpdnsSdkSwitch();
        if (UseHttpdnsSdkSwitch.isOn()) {
            d.a.c.c.e.c.h.h(TiebaIMConfig.url);
        } else {
            String h2 = d.a.j0.s.j.a.f().h();
            if (TextUtils.isEmpty(h2)) {
                d.a.c.c.e.c.h.h(TiebaIMConfig.url);
            } else {
                d.a.c.c.e.c.h.h(h2);
            }
        }
        d.a.c.c.e.c.h.e(TiebaIMConfig.wsExtensions);
        d.a.c.c.e.c.h.f(arrayList);
        BdSocketDaemonService.setLinkServiceDisconnectCallBack(new h());
        BdSocketLinkService.init();
        d.a.j0.c0.a.b(0, 0, 0, 1, 9);
        BdSocketLinkService.startService(false, "TiebaImApplication init");
    }

    private void initStatSdk() {
        if (isMainProcess(true)) {
            d.a.k0.i3.c.b().a(this);
            d.a.k0.i3.c.b().e(this, getFrom(), true);
        }
    }

    private void initSwanData() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2921512));
    }

    private void initUETool() {
        if (isDebugMode() && isMainProcess(false) && d.a.j0.r.d0.b.j().g("key_ue_tool_switch", false)) {
            MessageManager.getInstance().runTask(2921513, null, null);
        }
    }

    private void initWebsocketBase(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new g());
        int[] imTimeOut = getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            d.a.c.c.j.c.c().d(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            d.a.c.c.e.c.h.g(socketReconnStratgy);
        }
        d.a.j0.s.j.e.j().k();
        MessageManager.getInstance().getSocketClient().H(d.a.j0.s.j.e.j());
        MessageManager.getInstance().addResponsedMessageRule(new d.a.j0.s.j.i());
        try {
            d.a.c.c.e.c.j.d.a().d(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        d.a.j0.s.j.h.j().k();
        d.a.j0.s.j.g.y().z();
        initSocket();
        d.a.j0.m0.l.b().s(System.currentTimeMillis() - currentTimeMillis);
    }

    private void intReadThreadHistory(boolean z) {
        if (z) {
            this.mReadThreadHistory = new d.a.k0.d3.n0.d(300);
            this.mPhotoLiveReadHistory = new d.a.k0.d3.n0.c(300);
            d.a.c.a.b.f().r(this);
        }
    }

    private boolean isCrabSdkCrashUp2Limit() {
        StringBuilder sb = new StringBuilder();
        sb.append("crab_sdk_crash_count_");
        sb.append(TbConfig.getVersion());
        return TbadkSettings.getInst().loadInt(sb.toString(), 0) > getFeatureCrashAutoCloseLimit();
    }

    private boolean isGifAutoPlayFromSetting() {
        int i2 = this.mVideoAutoPlayConfig;
        if (i2 == -1) {
            i2 = 0;
        }
        if ((i2 != 0 || (!d.a.c.e.p.j.H() && d.a.c.e.p.j.z())) && i2 != 2) {
            if (i2 == 1) {
            }
            return false;
        }
        return true;
    }

    public static boolean isLogin() {
        String currentAccount = getCurrentAccount();
        return currentAccount != null && currentAccount.length() > 0;
    }

    private void isToLogo() {
        Boolean bool = this.isCdnTachometerProcess;
        if ((bool != null && bool.booleanValue()) || this.isPluginInstallProcess) {
            this.mPluginIsInited = true;
            return;
        }
        if (isMainProcess(false)) {
            if (!UseNewMethodCheckLogoSwitch.isOn()) {
                this.mIsToLogo = d.a.j0.z0.u.b();
            } else {
                boolean b2 = d.a.j0.z0.u.b();
                this.mIsToLogo = b2;
                if (b2) {
                    TiebaStatic.log("isTologo_not_match");
                }
            }
        }
        boolean z = isMainProcess(false) && PluginClassChangeSwitch.isOn();
        if (this.mIsToLogo || !z || d.a.j0.z0.u.a(false)) {
            return;
        }
        this.mPluginIsInited = true;
        PluginPackageManager.O().i0(d.a.j0.o0.c.n(), new d.a.j0.o0.d(), true, this.mPluginNotify);
        synchronized (this.mPluginNotify) {
            try {
                long j2 = 850;
                long l2 = d.a.j0.r.d0.b.j().l("plugin_wait_time", 850L);
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
        d.a.j0.z0.u.a(true);
    }

    @Deprecated
    private void loadNativeCrashCollectLib() {
        try {
            System.loadLibrary("google_breakpad");
        } catch (Throwable unused) {
        }
    }

    private void registerGoActionTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002001, new s());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static d.a.j0.v0.b registerImScoketTask(int i2, Class<? extends SocketResponsedMessage> cls, boolean z) {
        d.a.j0.v0.b bVar = new d.a.j0.v0.b(i2);
        bVar.setResponsedClass(cls);
        bVar.h(z);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }

    public static void resetTDatabaseCreateTime() {
        TbadkSettings.getInst().saveLong("tdatabasecreatetime", new Date().getTime());
    }

    public static void saveClientId(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        d.a.j0.r.d0.b.j().x("client_id", TbConfig.getVersion() + TrackUI.SEPERATOR + str);
    }

    private void saveFromToFile(String str) {
        if (str == null || str.length() <= 0) {
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
        if (str == null || str.length() <= 0 || !isMainProcess(true)) {
            return;
        }
        saveString("from_id", str);
    }

    public static void setBdussAndTbsFromBackgroundInRelogin(AccountData accountData, String str, String str2) {
        d.a.j0.r.l.b.s().J(accountData, str, str2);
    }

    public static void setClientId(String str) {
        clientId = str;
    }

    public static void setCurrentAccount(AccountData accountData, Context context) {
        d.a.j0.r.l.b.s().K(accountData, context);
    }

    public static void setCurrentAccountFromRemoteProcessInUIThread(AccountData accountData, Context context) {
        d.a.j0.r.l.b.s().L(accountData, context);
    }

    public static void setCurrentMemberType(int i2) {
        d.a.j0.r.l.b.s().N(i2);
    }

    public static void setIntent(Intent intent2) {
        intent = intent2;
    }

    public static void setIsAppRunning(boolean z) {
        IS_APP_RUNNING = z;
    }

    public static void setRefreshFlag(boolean z) {
        isNeedRefreshOnResume = z;
    }

    private void setServiceOnCreateCallBack() {
        BdBaseService.setServiceOnCreateCallBack(new p());
    }

    private void setWebViewDataDirectorySuffix() {
        if (Build.VERSION.SDK_INT >= 28) {
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
    }

    public void AddResumeNum() {
        d.a.j0.z0.m.g().a();
    }

    public void DelResumeNum() {
        d.a.j0.z0.m.g().b();
    }

    public void InitVersion() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
            TbConfig.setVersionType(d.a.c.e.m.b.d(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
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

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        RegisterIntentConfigHelper.getInst().RegisterIntent(cls, cls2);
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        RegisterIntentConfigHelper.getInst().RegisterOrUpdateIntent(cls, cls2);
    }

    public void SendSkinTypeBroadcast(int i2) {
        d.a.j0.r.l.b.s().a(i2);
    }

    public void addBDLocCrashCount() {
        int loadInt = TbadkSettings.getInst().loadInt("bd_loc_crash_count", 0) + 1;
        TbadkSettings.getInst().saveInt("bd_loc_crash_count", loadInt);
        if (loadInt > 3) {
            setBDLocON(false);
        }
    }

    public void addLikeForum(String str) {
        Hashtable<String, Integer> hashtable = this.mHasLikeList;
        if (hashtable == null || str == null) {
            return;
        }
        hashtable.put(str, 1);
        setLikeBarChanged(true);
        if (this.mHasLikeList.size() > 200) {
            this.mHasLikeList.clear();
        }
    }

    public void addRemoteActivity(BaseActivity<?> baseActivity) {
        ArrayList<BaseActivity<?>> arrayList = this.mRemoteActivity;
        if (arrayList != null) {
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
    }

    public void addSignedForum(String str, int i2, int i3) {
        if (TextUtils.isEmpty(str) || this.mHasSignList == null || this.mSignLevelUpList == null || hasSignedForum(str)) {
            return;
        }
        this.mHasSignList.put(str, Integer.valueOf(i2));
        this.mSignLevelUpList.put(str, Integer.valueOf(i3));
    }

    @SuppressLint({"UseSparseArrays"})
    public void addThemeToWaitDownloadQuene(int i2) {
        if (this.mWaitDownloadTheme == null) {
            this.mWaitDownloadTheme = new SparseArray<>();
        }
        this.mWaitDownloadTheme.put(i2, 1);
    }

    public boolean appResponseToCmd(int i2) {
        return MessageManager.getInstance().findTask(i2) != null;
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return RegisterIntentConfigHelper.getInst().appResponseToIntentClass(cls);
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        fixOppoTimeout();
        try {
            d.a.k0.u1.a.j(this);
        } catch (Throwable th) {
            if (th.getMessage() != null) {
                this.mMultidexError = th.getMessage();
            }
            this.mNeedUploadMultidexError = true;
        }
        if (getKeepLiveSwitch(context) && Build.VERSION.SDK_INT < 23) {
            ClientGuard clientGuard = new ClientGuard(createDaemonConfigurations());
            this.mClientGuard = clientGuard;
            clientGuard.onAttachBaseContext(context);
        }
        AppRuntimeInit.onApplicationattachBaseContext(this);
        d.a.c0.b.a.e.b(this);
    }

    public boolean canSendForegroundMessage() {
        return d.a.j0.z0.m.g().d();
    }

    public boolean cashNoAccountData(String str, int i2) {
        return d.a.j0.r.l.b.s().d(str, i2);
    }

    public boolean checkNeedShowNewVersionFlag() {
        return this.mNeedShowNewVersion;
    }

    public void clearActiveVersion() {
        setActiveVersion(ACTIVE_CLEAR_TAG);
    }

    public void clearEnterForeCount() {
        d.a.j0.z0.m.g().e();
    }

    public void clearLikeForum() {
        Hashtable<String, Integer> hashtable = this.mHasLikeList;
        if (hashtable != null) {
            hashtable.clear();
        }
    }

    public void clearSignedForum() {
        Hashtable<String, Integer> hashtable = this.mHasSignList;
        if (hashtable != null) {
            hashtable.clear();
        }
        Hashtable<String, Integer> hashtable2 = this.mSignLevelUpList;
        if (hashtable2 != null) {
            hashtable2.clear();
        }
    }

    public String createRandomString(String str, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        if (str != null) {
            sb.append(str);
        }
        sb.append(d.a.c.e.p.o.a());
        if (sb.length() > i2) {
            sb.setLength(i2);
        }
        return sb.toString();
    }

    public void delLikeForum(String str) {
        Hashtable<String, Integer> hashtable = this.mHasLikeList;
        if (hashtable == null || str == null) {
            return;
        }
        hashtable.put(str, -1);
        setLikeBarChanged(true);
        if (this.mHasLikeList.size() > 200) {
            this.mHasLikeList.clear();
        }
    }

    public void delRemoteActivity(BaseActivity<?> baseActivity) {
        ArrayList<BaseActivity<?>> arrayList = this.mRemoteActivity;
        if (arrayList != null) {
            arrayList.remove(baseActivity);
        }
    }

    public void delSignedForum(String str) {
        Hashtable<String, Integer> hashtable;
        if (!hasSignedForum(str) || (hashtable = this.mHasSignList) == null || str == null) {
            return;
        }
        hashtable.remove(str);
        this.mSignLevelUpList.remove(str);
    }

    public void deleteAccountAllInfo(String str) {
        d.a.j0.r.l.b.s().f(str);
    }

    public void deleteThemeFromWaitDownloadQuene(int i2) {
        SparseArray<Integer> sparseArray = this.mWaitDownloadTheme;
        if (sparseArray == null) {
            return;
        }
        sparseArray.remove(i2);
    }

    public void fixOppoTimeout() {
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

    public String getActiveVersion() {
        String latestFileName;
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

    public d.a.j0.s.c.b getActivityPrizeData() {
        if (this.activityPrizeData == null) {
            this.activityPrizeData = new d.a.j0.s.c.b();
            d.a.j0.r.d0.b j2 = d.a.j0.r.d0.b.j();
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

    public d.a.j0.s.c.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public d.a.j0.s.c.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int getAdVideoPageStyle() {
        return d.a.j0.r.d0.b.j().k("video_page_style", 3);
    }

    public String getAndroidId() {
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

    public int getCanShowSplash() {
        if (this.startType == 2) {
            return 2;
        }
        return this.canShowHotSplash;
    }

    public boolean getCapabilityOfWebp() {
        return this.mCapableOfWebp;
    }

    public int getCardShowType() {
        if (!this.hasInit) {
            this.cardShowType = d.a.j0.r.d0.b.j().k("key_card_show_type", 0);
        }
        return this.cardShowType;
    }

    public String getCheckUrl() {
        return this.checkUrl;
    }

    public CombineDownload getCombineDownload() {
        return this.mCombineDownload;
    }

    public String getConfigVersion() {
        return this.mConfigVersion;
    }

    public d.a.j0.s.c.u getConsumePathData() {
        return this.mConsumePathData;
    }

    public String getCuid() {
        if (d.a.c.e.p.k.isEmpty(this.mCuid)) {
            initCuid();
        }
        return this.mCuid;
    }

    public String getCuidGalaxy2() {
        if (d.a.c.e.p.k.isEmpty(this.cuid_galaxy2)) {
            initCuidGalaxy2();
        }
        return this.cuid_galaxy2;
    }

    public String getCuidGalaxy3() {
        if (d.a.c.e.p.k.isEmpty(this.cuid_galaxy3)) {
            initCuidGalaxy3();
        }
        return this.cuid_galaxy3;
    }

    public String getCuidGid() {
        return this.cuid_gid;
    }

    public String getCurAiAppid() {
        return this.mCurAiAppid;
    }

    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.mCurrentActivityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public d.a.j0.r.f getCustomizedFilter() {
        return this.mCustomizedFilter;
    }

    public String getDefaultBubble() {
        return this.mDefaultBubble;
    }

    public int getDefaultBubbleEndTime() {
        return this.mDefaultBubbleEndTime;
    }

    public int getEnterForeCount() {
        return d.a.j0.z0.m.g().f();
    }

    public d.a.c.j.d.a getFace(String str) {
        SoftReference<d.a.c.j.d.a> softReference = this.mFaces.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        d.a.c.j.d.a a2 = TbFaceManager.e().a(str);
        if (a2 != null) {
            this.mFaces.put(str, new SoftReference<>(a2));
        }
        return a2;
    }

    public int getFaceShopVersion() {
        return this.mFaceShopVersion;
    }

    public int getFeatureCrashAutoCloseLimit() {
        return Math.max(TbadkSettings.getInst().loadInt("feature_crash_auto_close_limit", 3), 3);
    }

    public boolean getFirstSyncImageQuality() {
        return TbadkSettings.getInst().loadBoolean("first_sync_image_quality", true);
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    public String getFramework_ver() {
        return this.framework_ver;
    }

    public int getFrsAutoPlay() {
        int i2;
        if (TbConfig.FORCE_UPDATE || (i2 = this.mVideoAutoPlayConfig) == -1) {
            boolean z = d.a.j0.r.d0.b.j().k("auto_play_video_frs", 0) == 1;
            if (d.a.j0.r.d0.b.j().k("auto_play_video_frs_have_4g", 0) == 1) {
                return 2;
            }
            return z ? 0 : 1;
        }
        return i2;
    }

    public SparseArray<FrsNetModel> getFrsModeArray() {
        return this.mFrsModelArray;
    }

    public String getGameInfoIconUrl() {
        return this.infoIconUrl;
    }

    public String getGameInfoTargetUrl() {
        return this.infoTargetUrl;
    }

    public long getGameInfoTimeStamp() {
        return this.infoTimeStamp;
    }

    public Hashtable<String, Integer> getHasLikeList() {
        return this.mHasLikeList;
    }

    public boolean getHasNewVersion() {
        return this.mHasNewVersion;
    }

    public int getHomeBarShowType() {
        return this.homeBarShowType;
    }

    public int getHomePageAutoPlay() {
        int i2;
        if (TbConfig.FORCE_UPDATE || (i2 = this.mVideoAutoPlayConfig) == -1) {
            boolean z = d.a.j0.r.d0.b.j().k("auto_play_video_homepage", 0) == 1;
            if (d.a.j0.r.d0.b.j().k("auto_play_video_homepage_have_4g", 0) == 1) {
                return 2;
            }
            return z ? 0 : 1;
        }
        return i2;
    }

    public int getHybridBridgeTimeout() {
        return this.hybridBridgeTimeout;
    }

    public String getIMsi() {
        TelephonyManager telephonyManager;
        try {
            Context context = getInst().getContext();
            return (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadPhoneState(context) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) ? telephonyManager.getSubscriberId() : "";
        } catch (Exception e2) {
            BdLog.e(e2);
            return "";
        }
    }

    public int[] getImTimeOut() {
        String[] split;
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

    public String getImei() {
        if (d.a.c.e.p.k.isEmpty(this.mImei)) {
            initImei();
        }
        return this.mImei;
    }

    public long getInitTime() {
        return this.mInitTime;
    }

    public String getInstallOtherApp() {
        return TbadkSettings.getInst().loadString("install_other_app_file_name", null);
    }

    public String getInstalledAppIds() {
        return this.mInstallAppIds;
    }

    public Class<?> getIntentClass(Class<?> cls) {
        return RegisterIntentConfigHelper.getInst().getIntentClass(cls);
    }

    public long getInterviewLivePollingInterval() {
        return this.mInterviewLivePollingInterval;
    }

    public boolean getIsAbstract() {
        int i2 = this.mIsAbstractOn;
        if (i2 == 0) {
            if (d.a.c.e.p.j.H()) {
                return true;
            }
        } else if (i2 == 1) {
            return true;
        }
        return false;
    }

    public int getIsAbstractStatus() {
        return this.mIsAbstractOn;
    }

    public boolean getIsAppOn() {
        return this.mIsAppOn;
    }

    public boolean getIsFirstUse() {
        if (FileHelper.DataDir.checkFile("/package.cur/" + TbConfig.getVersion())) {
            return false;
        }
        setActiveVersion(FileHelper.DataDir.getLatestFileName(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR));
        return true;
    }

    public boolean getIsLocationOn() {
        return this.mIsLocationOn;
    }

    public boolean getIsNewRegUser() {
        return this.mIsNewRegUser;
    }

    public boolean getIsPhoneCalling() {
        return this.isPhoneCalling;
    }

    public int getKeepaliveNonWifi() {
        return loadInt("keepalive_nonwifi", 1);
    }

    public int getKeepaliveWifi() {
        return loadInt("keepalive_wifi", 1);
    }

    public int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    public long getLastNotifyTime() {
        return TbadkSettings.getInst().loadLong("last_notify_sound_time", 0L);
    }

    public long getLastSyncFinishTime() {
        return this.mLastSyncFinishTime;
    }

    public long getLastUpdateMemberCenterTime() {
        return this.lastUpdateMemberCenterTime;
    }

    public long getLastUpdateThemeTime() {
        return this.lastUpdateThemeTime;
    }

    public boolean getLikeBarChanged() {
        return this.mLikeChanged;
    }

    public z getListItemRule() {
        if (this.listItemRule == null) {
            this.listItemRule = new z();
        }
        return this.listItemRule;
    }

    public String getLocationLat() {
        return TbadkSettings.getInst().loadString("location_lat", "");
    }

    public String getLocationLng() {
        return TbadkSettings.getInst().loadString("location_lng", "");
    }

    public String getLocationPos() {
        return TbadkSettings.getInst().loadString("location_pos", "");
    }

    public boolean getLocationShared() {
        return true;
    }

    public final int getMainTabBottomBarHeight() {
        if (DeviceInfoUtil.isfullScreen()) {
            return d.a.c.e.p.l.g(this, R.dimen.tbds162);
        }
        return d.a.c.e.p.l.g(this, R.dimen.tbds152);
    }

    public final int getMainTabBottomBarHeightId() {
        if (DeviceInfoUtil.isfullScreen()) {
            return R.dimen.ds100;
        }
        return R.dimen.ds90;
    }

    public int getNetWorkCoreType() {
        return loadInt("networkcore_type", 1);
    }

    public int getNewVcodeWebviewCrashCount() {
        return this.mNewVcodeWebviewCrashCount;
    }

    public String getNoAccountData(int i2) {
        return d.a.j0.r.l.b.s().t(i2);
    }

    public int getOldSkinType() {
        return d.a.j0.r.l.b.s().u();
    }

    public PayMemberInfoData getPaymemberInfo() {
        return this.payInfo;
    }

    public int getPerformSampleCount() {
        return this.mPerformSampleCount;
    }

    public d.a.k0.d3.n0.c getPhotoLiveReadThreadHistory() {
        return this.mPhotoLiveReadHistory;
    }

    public c0 getProfileData() {
        return this.mProfileData;
    }

    @Modify(description = "flutter代理ip")
    public String getProxyIp() {
        return this.proxyIp;
    }

    @Modify(description = "flutter代理端口")
    public String getProxyPort() {
        return this.proxyPort;
    }

    public String getPushChannelId() {
        return loadString(Constants.EXTRA_PUSH_CHANNEL_ID, "");
    }

    public String getPushChannelUserId() {
        return loadString("push_channel_userId", "");
    }

    public d.a.k0.d3.n0.d getReadThreadHistory() {
        return this.mReadThreadHistory;
    }

    public int getReadThreadPlayerScreenMaxHeight() {
        return this.mReadThreadPlayerScreenMaxHeight;
    }

    public long getReporyUserInfoLastTime() {
        return TbadkSettings.getInst().loadLong("report_user_info_time_key" + getCurrentAccount(), 0L);
    }

    public int getResumeNum() {
        return d.a.j0.z0.m.g().h();
    }

    public String getSdk_ver() {
        return this.sdk_ver;
    }

    public ShareItem getShareItem() {
        return this.mShareItem;
    }

    public boolean getShowPayInfoRedTip() {
        return this.showPayInfoRedTip;
    }

    public int getSignLevelUpValue(String str) {
        if (hasSignedForum(str)) {
            return this.mSignLevelUpList.get(str).intValue();
        }
        return -1;
    }

    public int getSignedForumIncreaseCount(String str) {
        if (hasSignedForum(str)) {
            return this.mHasSignList.get(str).intValue();
        }
        return 0;
    }

    public int getSkinType() {
        return d.a.j0.r.l.b.s().v();
    }

    public int[] getSocketGetMsgStratgy() {
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

    public int[] getSocketHeartBeatStratgy() {
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

    public int[] getSocketReconnStratgy() {
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

    @Override // d.a.k0.u1.c.InterfaceC1674c
    public d.a.k0.u1.c getSplash() {
        if (this.mSplash == null) {
            this.mSplash = new d.a.k0.u1.c(this);
        }
        return this.mSplash;
    }

    public int getStartType() {
        return this.startType;
    }

    public String getSwan_game_ver() {
        return this.swan_game_ver;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public String getTbs() {
        return d.a.j0.r.l.b.s().w();
    }

    public int getTempFaceShopVersion() {
        return this.mTempFaceShopVersion;
    }

    public int getThemeFromWaitDownloadQuene(int i2) {
        SparseArray<Integer> sparseArray = this.mWaitDownloadTheme;
        if (sparseArray == null) {
            return 0;
        }
        return sparseArray.get(i2, 0).intValue();
    }

    public boolean getThemeWebviewOpen() {
        return this.mThemeWebviewOpened;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public long getUpdateNotifyTime() {
        return TbadkSettings.getInst().loadLong("update_notify_time", 0L);
    }

    public String getUrlText() {
        return this.urlText;
    }

    public int getUseNewResign() {
        return this.useNewResign;
    }

    public long getUseTimeInterval() {
        return this.useTimeInterval;
    }

    public int getUsedThemeColor() {
        return d.a.j0.r.l.b.s().x();
    }

    public int getUsedThemeId() {
        return d.a.j0.r.l.b.s().y();
    }

    public int getVersionCode() {
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

    public VersionData getVersionData() {
        return this.mVersionData;
    }

    public String getVersionName() {
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

    public int getVideoAutoPlay() {
        int i2;
        if (TbConfig.FORCE_UPDATE || (i2 = this.mVideoAutoPlayConfig) == -1) {
            boolean z = d.a.j0.r.d0.b.j().k("auto_play_video_homepage", 0) == 1;
            boolean z2 = d.a.j0.r.d0.b.j().k("auto_play_video_frs", 0) == 1;
            boolean z3 = d.a.j0.r.d0.b.j().k("auto_play_video_homepage_have_4g", 0) == 1;
            boolean z4 = d.a.j0.r.d0.b.j().k("auto_play_video_frs_have_4g", 0) == 1;
            if (z3 || z4) {
                return 2;
            }
            return (z || z2) ? 0 : 1;
        }
        return i2;
    }

    public int getVideoAutoPlayReal() {
        return this.mVideoAutoPlayConfig;
    }

    public SparseArray<Integer> getWaitDownloadTheme() {
        return this.mWaitDownloadTheme;
    }

    public int getWebviewCrashCount() {
        return this.mWebviewCrashCount;
    }

    public String getYijianfankuiFname() {
        return this.mYijianfankuiFname;
    }

    public String getYunpushChannelId() {
        if (TextUtils.isEmpty(this.mChannelId)) {
            this.mChannelId = d.a.j0.r.d0.b.j().p("yunpush_channel_id", "");
        }
        return this.mChannelId;
    }

    public String getZid() {
        return PermissionUtil.isAgreePrivacyPolicy() ? FH.gz(sApp) : "000";
    }

    @Override // com.baidu.adp.base.BdBaseApplication
    public void handleInitMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            loadPatchs();
            initCustomToastView();
            setServiceOnCreateCallBack();
            this.mAppInitHandler.sendEmptyMessage(2);
        } else if (i2 == 2) {
            d.a.c.e.a.d.g().h(TbConfig.getTempDirName());
            d.a.k0.r2.a.g().j();
            boolean isMainProcess = isMainProcess(false);
            d.a.j0.u.a.k().n(isMainProcess);
            intReadThreadHistory(isMainProcess);
            this.mAppInitHandler.sendEmptyMessage(3);
        } else if (i2 == 3) {
            d.a.j0.s.a.a.c();
            initChangeSkinReceiver();
            this.mAppInitHandler.sendEmptyMessage(4);
        } else if (i2 == 4) {
            d.a.j0.z0.e.m().t(this);
            initCyberPlayer();
            initCrabSdk();
            this.mAppInitHandler.sendEmptyMessage(5);
        } else if (i2 != 5) {
        } else {
            registerPhoneListener();
            initICDN();
            initIM();
            initQuickWebViewManager();
            initStatSdk();
            initJpusbSdk();
            if (this.mNeedUploadMultidexError) {
                d.a.j0.r.z.a.a("MultiDex", -1L, -1, "installMultidex", -1, this.mMultidexError, new Object[0]);
            }
            Boolean bool = this.isCdnTachometerProcess;
            if ((bool != null && bool.booleanValue()) || this.isPluginInstallProcess) {
                d.a.c.h.h.b.e("TbadkApplication_onCreate", "cdn_process");
                this.mAppInitHandler.sendEmptyMessage(7);
                return;
            }
            this.mAppInitHandler.sendEmptyMessage(6);
        }
    }

    public int hasLikeForum(String str) {
        Hashtable<String, Integer> hashtable = this.mHasLikeList;
        if (hashtable == null || str == null || !hashtable.containsKey(str)) {
            return 0;
        }
        return this.mHasLikeList.get(str).intValue();
    }

    public boolean hasSignedForum(String str) {
        Hashtable<String, Integer> hashtable = this.mHasSignList;
        return (hashtable == null || str == null || !hashtable.containsKey(str)) ? false : true;
    }

    public void incBaiduYunPushCrashCount() {
        String str = "baidu_yun_push_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incBaobaoCrashCount() {
        String str = "baobao_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incCrabSdkCrashCount() {
        String str = "crab_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incDQCrashCount() {
        String str = "dq_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incLiveSdkCrashCount() {
        String str = "live_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incPassportV6CrashCount() {
        String str = "passport_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incWalletSdkCrashCount() {
        String str = "wallet_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incWebpFailureCount() {
        int loadInt = TbadkSettings.getInst().loadInt("webp_failure_count", 0) + 1;
        if (loadInt > 5) {
            this.mCapableOfWebp = false;
            TbadkSettings.getInst().saveBoolean("capable_of_webp_format", false);
            return;
        }
        TbadkSettings.getInst().saveInt("webp_failure_count", loadInt);
    }

    public void incXiaomiPushSdkCrashCount() {
        String str = "xiaomi_push_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incXiaoyingCrashCount() {
        TbadkSettings.getInst().saveInt("xiaoying_crash_count", TbadkSettings.getInst().loadInt("xiaoying_crash_count", 0) + 1);
    }

    public void initAccount() {
        d.a.j0.r.l.b.s().z();
    }

    public void initAxeSdk() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            b.C1783b.c(getApplicationContext()).b().t();
        }
    }

    public void initCrabSdk() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            d.a.k0.i3.a.getInstance().initSdk(this);
        }
    }

    public void initCuid() {
        String loadString = loadString("cuid", null);
        if (loadString != null && loadString.startsWith("baidutiebaapp")) {
            saveString("new_cuid", loadString);
            d.a.j0.r.d0.b.j().C("cuid");
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

    public void initCuidGalaxy2() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
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
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            String loadString = loadString("new_cuid_galaxy3", null);
            this.cuid_galaxy3 = loadString;
            if (loadString == null || loadString.length() <= 0) {
                String a2 = d.a.q.b.d(getContext()).a();
                this.cuid_galaxy3 = a2;
                saveString("new_cuid_galaxy3", a2);
            }
        }
    }

    public void initCyberPlayer() {
        if (PermissionUtil.isAgreePrivacyPolicy() && !CyberPlayerManager.isCoreLoaded(1)) {
            try {
                CyberPlayerManager.install(getInst().getContext(), getInst().getCuidGalaxy2(), null, 3, CyberRemotePlayerService.class, null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void initImei() {
        TelephonyManager telephonyManager;
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

    public void initLikeForum() {
        if (this.mHasLikeList == null) {
            this.mHasLikeList = new Hashtable<>();
        }
    }

    public void initSapiTask() {
        if (isMainProcess(true)) {
            MessageManager.getInstance().runTask(2921328, null, getContext());
        }
    }

    public void initSetting() {
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
        this.useTimeInterval = d.a.j0.r.d0.b.j().l("use_time_interval", TbConfig.DEFALT_USE_TIME_INTERVAL);
    }

    public void initSignedForum() {
        if (this.mHasSignList == null) {
            this.mHasSignList = new Hashtable<>();
        }
        if (this.mSignLevelUpList == null) {
            this.mSignLevelUpList = new Hashtable<>();
        }
    }

    public void initTasks() {
        long currentTimeMillis = System.currentTimeMillis();
        d.a.j0.r.x.d.a();
        d.a.j0.m0.l.b().u(System.currentTimeMillis() - currentTimeMillis);
    }

    public void initTrackConfig() {
        d.a.c.e.n.f.h(TbSingleton.getInstance().isIsOpenTrack());
    }

    public void initUBC() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            d.a.l.b.a.b().c("tieba");
            AppConfig.init(false, false, false, false);
            if (d.a.c0.b.a.a.g()) {
                UBCIPCManager.b();
                CloudControlManager.getInstance().requestCloudControl("0");
            }
        }
    }

    public void initYunPushProcess() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            initLoki();
            StartupCountStatsController.init();
            initUBC();
            initRuka();
        }
    }

    public boolean isAccountsDataFromPass() {
        StringBuilder sb = new StringBuilder();
        sb.append("passport_crash_count_");
        sb.append(TbConfig.getVersion());
        return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(AccountsDataFromPassSwitch.ACCOUNT_DATA_FROM_PASS) != 1;
    }

    public boolean isAppUploadOpen() {
        return SwitchManager.getInstance().findType(AppUploadSwitch.KEY) == 1;
    }

    public boolean isAudioRecorderExist() {
        return this.isAudioRecorderExist;
    }

    public boolean isAudioRecorderOpen() {
        return SwitchManager.getInstance().findType(AudioRecorderSwitch.KEY_AUDIO_RECORDER_SWITCH) != 0;
    }

    public boolean isBaiduYunPushAvailable() {
        StringBuilder sb = new StringBuilder();
        sb.append("baidu_yun_push_sdk_crash_count_");
        sb.append(TbConfig.getVersion());
        return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(BaiduYunPushSdkSwitch.BAIDU_YUN_PUSH_SDK_KEY) == 1;
    }

    public boolean isCrabSdkShouldOpen() {
        StringBuilder sb = new StringBuilder();
        sb.append("crab_sdk_crash_count_");
        sb.append(TbConfig.getVersion());
        return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(CrabSdkSwitch.CRAB_SDK_KEY) == 1;
    }

    public boolean isDQShouldOpen() {
        StringBuilder sb = new StringBuilder();
        sb.append("dq_crash_count");
        sb.append(TbConfig.getVersion());
        return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit();
    }

    public boolean isExitAppCloseWebSocket() {
        return this.mIsExitAppCloseWebSocket;
    }

    public boolean isFaceShopNew() {
        return this.isFaceShopNew;
    }

    public boolean isFirstTimeMotivate() {
        return this.mIsFirstTimeMotivate;
    }

    public boolean isGifAutoPlay() {
        return RichTextGifViewSwitch.isOn() && isGifAutoPlayFromSetting();
    }

    public boolean isGiftSwitchOn() {
        return SwitchManager.getInstance().findType(GiftSwitch.GIFT_SWITCH_KEY) != 1;
    }

    public boolean isGpuOpen() {
        return this.mGpuOpen;
    }

    public boolean isHeadsetModeOn() {
        return this.mVoiceHeadsetMode == 1;
    }

    public boolean isHttpAutoSwitch() {
        return this.mUseHttpAutoSwitch;
    }

    public boolean isHttpClientOpen() {
        return this.mUseHttpClient;
    }

    public boolean isHybridBridgeEnabled() {
        return SwitchManager.getInstance().findType(HybridBridgeSwitch.KEY) == 1;
    }

    public boolean isImmersiveStickyCanUse() {
        if (!this.isImmersiveStickyPrefHasRead) {
            this.isImmersiveStickyCanUse = d.a.j0.r.d0.b.j().g("switch_immersive_sticky_status", true);
            this.isImmersiveStickyPrefHasRead = true;
        }
        return this.isImmersiveStickyCanUse;
    }

    public boolean isInBackground() {
        return d.a.j0.z0.m.g().i();
    }

    public boolean isKeyboardHeightCanSet(int i2) {
        return i2 > getResources().getDimensionPixelSize(R.dimen.ds460);
    }

    public boolean isKeyboardHeightCanUsed() {
        return this.keyboardHeight > getResources().getDimensionPixelSize(R.dimen.ds460);
    }

    public boolean isLbsWebViewSwitchOn() {
        return SwitchManager.getInstance().findType(LbsWebViewSwitch.LBS_WEBVIEW_SWITCH_KEY) != 0;
    }

    public boolean isLowVersionPassV6ShouldOpen() {
        StringBuilder sb = new StringBuilder();
        sb.append("passport_crash_count_");
        sb.append(TbConfig.getVersion());
        return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(LowVersionLoginPassV6Switch.KEY) != 1;
    }

    public boolean isMIUIRom() {
        String str = Build.MANUFACTURER;
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI);
    }

    public boolean isMainProcess(boolean z) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Boolean bool = this._isMainProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) getInst().getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return z;
        }
        String packageName = getInst().getPackageName();
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

    public boolean isMeiZuCanUseImmersive() {
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

    public boolean isNeedBearAd(int i2) {
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

    public boolean isNeedNewUserLead() {
        return this.mIsNeedNewUserLead;
    }

    public boolean isNoInterestTag() {
        return this.mIsNoInterestTag;
    }

    public boolean isOfficial() {
        return this.mIsOfficial;
    }

    public boolean isPageStayOpen() {
        return this.mIsPageStayOpen;
    }

    public boolean isPassportV6ShouldOpen() {
        StringBuilder sb = new StringBuilder();
        sb.append("passport_crash_count_");
        sb.append(TbConfig.getVersion());
        return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(LoginPassV6Switch.KEY) != 1;
    }

    public boolean isPicReqSwitchOn() {
        return this.mPicReqSwitchType == 1;
    }

    public boolean isProcessBackground() {
        return this.isBackground;
    }

    public boolean isPromotedMessageOn(String str) {
        String str2 = "permoted_message_" + str;
        if (TbadkSettings.getInst().isContains(str2)) {
            return TbadkSettings.getInst().loadBoolean(str2, true);
        }
        return this.mPromotedMessageOn;
    }

    public boolean isPushServiceOpen() {
        return loadBoolean("push_service", true);
    }

    public boolean isReadMenuDialogOnTop() {
        return this.isReadMenuDialogTop;
    }

    public boolean isRecAppExist() {
        return this.isRecAppExist;
    }

    public boolean isRegistedIntent(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public boolean isRemoteProcess() {
        return this.isRemoteProcess;
    }

    public boolean isRunInFrontend() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) getInst().getApp().getSystemService("activity")).getRunningTasks(1);
        return (runningTasks == null || runningTasks.size() == 0 || !runningTasks.get(0).baseActivity.getPackageName().equals(getPackageName())) ? false : true;
    }

    public boolean isShowSwipeBackGuide() {
        return TbadkSettings.getInst().loadBoolean("show_swipe_back_key", true);
    }

    public boolean isThemeIconCover() {
        return d.a.j0.r.l.b.s().F();
    }

    public boolean isWalletShouldOpen() {
        StringBuilder sb = new StringBuilder();
        sb.append("wallet_crash_count");
        sb.append(TbConfig.getVersion());
        return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(WalletSwitch.WALLET_ENABLE) != 0;
    }

    public boolean isXiaomiPushSdkShouldOpen() {
        StringBuilder sb = new StringBuilder();
        sb.append("xiaomi_push_sdk_crash_count_");
        sb.append(TbConfig.getVersion());
        return TbadkSettings.getInst().loadInt(sb.toString(), 0) <= getFeatureCrashAutoCloseLimit() && SwitchManager.getInstance().findType(XiaomiPushSdkSwitch.XIAOMIPUSH_SDK_KEY) != 0;
    }

    public boolean isXiaoyingAvaliable() {
        return TbadkSettings.getInst().loadInt("xiaoying_crash_count", 0) <= getFeatureCrashAutoCloseLimit();
    }

    public boolean isYunPushProcess() {
        return this.isYunPushProcess;
    }

    public int likeForumCount() {
        Hashtable<String, Integer> hashtable = this.mHasSignList;
        if (hashtable != null) {
            return hashtable.size();
        }
        return 0;
    }

    public boolean loadBoolean(String str, boolean z) {
        return d.a.j0.r.d0.b.j().g(str, z);
    }

    public int loadInt(String str, int i2) {
        return d.a.j0.r.d0.b.j().k(str, i2);
    }

    public void loadLcsSwitchStratgy() {
        String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
        if (TextUtils.isEmpty(loadString)) {
            return;
        }
        d.a.j0.s.e.d dVar = new d.a.j0.s.e.d();
        dVar.e(loadString);
        d.a.j0.s.j.c a2 = d.a.j0.s.j.c.a();
        a2.g(dVar.b() == 1);
        a2.h(dVar.c());
        a2.i(dVar.d() * 1000);
        if (dVar.a() != null) {
            a2.j(dVar.a());
        }
    }

    public long loadLong(String str, long j2) {
        return d.a.j0.r.d0.b.j().l(str, j2);
    }

    public void loadPatchs() {
    }

    public String loadString(String str, String str2) {
        return d.a.j0.r.d0.b.j().p(str, str2);
    }

    public void login(TbPageContext<?> tbPageContext, CustomMessage<LoginActivityConfig> customMessage) {
        if (customMessage == null) {
            return;
        }
        if (tbPageContext != null) {
            tbPageContext.sendMessage(customMessage);
        } else {
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void notifyAppEnterBackground() {
        d.a.j0.z0.m.g().k();
    }

    public void notifySwitchProcess(boolean z) {
        d.a.j0.z0.m.g().m(z);
    }

    @Override // d.a.c.a.b.a
    public void onActivityClosed() {
        getInst().onLowMemory();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2002014));
    }

    @Override // com.baidu.adp.base.BdBaseApplication
    public void onAppMemoryLow() {
        int n2 = d.a.j0.a0.c.k().n();
        int max = (int) Math.max(n2 * 0.8d, TbConfig.getBigImageMaxUsedMemory());
        if (max < n2) {
            BdLog.isDebugMode();
            d.a.j0.a0.c.k().u(max);
        }
        BitmapHelper.clearCashBitmap();
        d.a.c.e.p.d.d().b();
    }

    @Override // android.app.Application
    public void onCreate() {
        this.processCreateTime = System.currentTimeMillis();
        sApp = this;
        d.a.j0.r.l.b.s().A();
        super.onCreate(this);
        isMainProcess(false);
        PermissionUtil.syncAgreeStatus(isMainProcess(false));
        d.a.j0.f0.h.f().g(this);
        PermissionUtil.registerMutiProcessPrivacyPolicy();
        if (this.isYunPushProcess) {
            InitVersion();
            initYunPushProcess();
            return;
        }
        initDimenAdapt();
        cleanDirectoryNewStatIfNeed();
        this.mPicReqSwitchType = d.a.j0.r.d0.b.j().k("key_pic_req_switch", 0);
        if (d.a.j0.r.d0.b.j().k("static_opt_open", 0) > 0) {
            CmdRouter.init(this);
        }
        setWebViewDataDirectorySuffix();
        getSharedPreferences("adp_feature_switch", 0);
        initCmdConvertManager();
        InitVersion();
        init(getContext());
        TbFaceManager.e().i(sApp, new d.a.j0.w.p.b());
        initTasks();
        registerGoActionTask();
        d.a.j0.r.l.a.c();
        initAccount();
        initInterruptRule();
        initSapiTask();
        initPluginSettings();
        initSwanData();
        initBearSdk();
        isToLogo();
        initLoki();
        StartupCountStatsController.init();
        initUBC();
        initRuka();
        initAxeSdk();
        MessageManager.getInstance().registerListener(this.mDescriptionTableFixListener);
        initUETool();
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.mAppInitHandler.sendMessageAtFrontOfQueue(obtain);
        d.a.j0.m0.l.b().J(System.currentTimeMillis());
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        onAppMemoryLow();
        super.onLowMemory();
    }

    public void onUserChanged() {
        if (!d.a.c.e.p.l.D()) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2005007));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921410));
        d.a.j0.s.d.b.g0().X(true);
        NotificationHelper.cancelAllNotification(this);
        d.a.k0.d3.n0.a.n();
    }

    public String readClientId(Context context) {
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

    public void refreshNewVersion(boolean z) {
        this.mNeedShowNewVersion = z;
        Intent intent2 = new Intent(TbConfig.getBroadcastActionNewVersion());
        intent2.setPackage(getInst().getPackageName());
        getApp().sendBroadcast(intent2);
    }

    public void registerPhoneListener() {
        if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadPhoneState(getContext())) {
            try {
                ((TelephonyManager) getInst().getApp().getSystemService("phone")).listen(new u(this, null), 32);
            } catch (SecurityException | Exception unused) {
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            return super.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable unused) {
            return new Intent();
        }
    }

    public void removeClientId(Context context) {
        d.a.j0.r.d0.b.j().C("client_id");
    }

    public void resetIsImmersiveStickyPrefHasRead(boolean z) {
        this.isImmersiveStickyPrefHasRead = z;
    }

    public void saveBoolean(String str, boolean z) {
        d.a.j0.r.d0.b.j().t(str, z);
    }

    public void saveInt(String str, int i2) {
        d.a.j0.r.d0.b.j().v(str, i2);
    }

    public void saveKeepLiveSwitch(boolean z) {
        EditorHelper.putBoolean(getSharedPreferences(KEEPLIVESWITCHFILE, 0), KEEPLIVESWITCH, z);
    }

    public void saveLong(String str, long j2) {
        d.a.j0.r.d0.b.j().w(str, j2);
    }

    public void saveString(String str, String str2) {
        d.a.j0.r.d0.b.j().x(str, str2);
    }

    public void sendImagePv(int i2, int i3, String str) {
        sendImagePv(i2, i3, str, 0, 0);
    }

    public void sendMessageForEnterBackground() {
        d.a.j0.z0.m.g().p();
    }

    public void setActiveVersion(String str) {
        if (d.a.c.e.p.k.isEmpty(str) || StringUtil.NULL_STRING.equals(str)) {
            return;
        }
        FileHelper.DataDir.cleanDirectory(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR);
        FileHelper.DataDir.createFile("/package.last/" + str);
    }

    public void setActivityPrizeData(d.a.j0.s.c.b bVar) {
        this.activityPrizeData = bVar;
    }

    public void setActivitySwitch(d.a.j0.s.c.c cVar) {
        this.mActivitySwitch = cVar;
    }

    public void setAdAdSense(d.a.j0.s.c.d dVar) {
        this.mAdAdSense = dVar;
        if (dVar == null || dVar.a() == null) {
            return;
        }
        d.a.j0.s.c.j a2 = this.mAdAdSense.a();
        MessageManager.getInstance().registerStickyMode(2001434);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001434, a2));
    }

    public void setAudioRecorderExist(boolean z) {
        this.isAudioRecorderExist = z;
    }

    public void setBDLocON(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001330, Boolean.valueOf(z)));
        TbadkSettings.getInst().saveBoolean("bd_loc_switcher", z);
    }

    public void setCanShowHotSplash(int i2) {
        this.canShowHotSplash = i2;
    }

    public void setCardShowType(int i2) {
        this.hasInit = true;
        this.cardShowType = i2;
    }

    public void setCheckUrl(String str) {
        this.checkUrl = str;
    }

    public void setCombineDownload(CombineDownload combineDownload) {
        this.mCombineDownload = combineDownload;
    }

    public void setConfigVersion(String str) {
        this.mConfigVersion = str;
    }

    public void setConsumePathData(d.a.j0.s.c.u uVar) {
        this.mConsumePathData = uVar;
    }

    public void setCurAiAppid(String str) {
        this.mCurAiAppid = str;
    }

    public void setCurrentActivity(Activity activity) {
        WeakReference<Activity> weakReference = this.mCurrentActivityRef;
        if (weakReference != null) {
            weakReference.clear();
            this.mCurrentActivityRef = null;
        }
        if (activity != null) {
            this.mCurrentActivityRef = new WeakReference<>(activity);
        }
    }

    public void setCustomizedFilter(d.a.j0.r.f fVar) {
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

    public void setDefaultBubble(String str) {
        this.mDefaultBubble = str;
    }

    public void setDefaultBubbleEndTime(int i2) {
        this.mDefaultBubbleEndTime = i2;
    }

    public void setExitAppCloseWebSocket(boolean z) {
        this.mIsExitAppCloseWebSocket = z;
    }

    public void setFaceShopNew(boolean z) {
        this.isFaceShopNew = z;
    }

    public void setFaceShopVersion(int i2) {
        this.mFaceShopVersion = i2;
        TbadkSettings.getInst().saveInt("faceshop_version", this.mFaceShopVersion);
    }

    public void setFeatureCrashAutoCloseLimit(int i2) {
        TbadkSettings.getInst().saveInt("feature_crash_auto_close_limit", i2);
    }

    public void setFirstSyncImageQuality(boolean z) {
    }

    public void setFontSize(int i2) {
        if (this.mFontSize == i2) {
            return;
        }
        this.mFontSize = i2;
        TbadkSettings.getInst().saveInt("font_size", i2);
    }

    public void setFramework_ver(String str) {
        this.framework_ver = str;
    }

    public void setFriendFeedNew(boolean z) {
        this.isFriendFeedNew = z;
        this.mHandler.post(new m(z));
    }

    public void setGameInfoData(String str, long j2, String str2) {
        this.infoIconUrl = str;
        this.infoTimeStamp = j2;
        this.infoTargetUrl = str2;
    }

    public void setGpuOpen(boolean z) {
        TbadkSettings.getInst().saveBoolean("gpu_open", z);
        this.mGpuOpen = z;
    }

    public void setHasNewVersion(boolean z) {
        this.mHasNewVersion = z;
    }

    public void setHeadsetModeOn(boolean z) {
        if (this.mVoiceHeadsetMode == z) {
            return;
        }
        this.mVoiceHeadsetMode = z ? 1 : 0;
        TbadkSettings.getInst().saveInt("voice_headset_mode", z ? 1 : 0);
    }

    public void setHomeBarShowType(int i2) {
        this.homeBarShowType = i2;
    }

    public void setHttpAutoSwitch(boolean z) {
        TbadkSettings.getInst().saveBoolean("httpclient_autoswitch", z);
        this.mUseHttpAutoSwitch = z;
    }

    public void setHttpClientOpen(boolean z) {
        TbadkSettings.getInst().saveBoolean("httpclient", z);
        this.mUseHttpClient = z;
    }

    public void setHybridBridgeTimeout(int i2) {
        this.hybridBridgeTimeout = (i2 <= 10 || i2 >= 5000) ? 1000 : 1000;
    }

    public void setImTimeOut(int[] iArr) {
        if (iArr == null || iArr.length != 3) {
            return;
        }
        StringBuilder sb = new StringBuilder(20);
        for (int i2 : iArr) {
            sb.append(i2);
            sb.append(FieldBuilder.SE);
        }
        TbadkSettings.getInst().saveString("socket_time_out", sb.toString());
        d.a.c.c.j.c.c().d(iArr[0], iArr[1], iArr[2]);
    }

    public void setInstallOtherApp(String str) {
        TbadkSettings.getInst().saveString("install_other_app_file_name", str);
    }

    public void setInstalledAppIds(String str) {
        this.mInstallAppIds = str;
    }

    public void setInterviewLivePollingInterval(long j2) {
        this.mInterviewLivePollingInterval = j2;
    }

    public void setIsAbstractOn(int i2) {
        this.mIsAbstractOn = i2;
        TbadkSettings.getInst().saveInt("new_abstract_state", i2);
    }

    public void setIsAppOn(boolean z) {
        TbadkSettings.getInst().saveBoolean("app_switcher", z);
        this.mIsAppOn = z;
    }

    public void setIsFirstTimeMotivate(boolean z) {
        this.mIsFirstTimeMotivate = z;
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921029));
        }
    }

    public void setIsLocationON(boolean z) {
        this.mIsLocationOn = z;
        TbadkSettings.getInst().saveBoolean("location_on", z);
    }

    public void setIsMeiZuCanUseImmersive(boolean z) {
        this.isMeiZuCanUseImmersiveHaveSet = true;
        this.isMeiZuCanUseImmersive = z;
    }

    public void setIsNeedNewUserLead(int i2) {
        this.mIsNeedNewUserLead = i2 == 1;
    }

    public void setIsNewRegUser(boolean z) {
        this.mIsNewRegUser = z;
    }

    public void setIsNoInterestTag(boolean z) {
        this.mIsNoInterestTag = z;
    }

    public void setIsPushServiceOpen(boolean z) {
        saveBoolean("push_service", z);
    }

    public void setKeepaliveNonWifi(int i2) {
        saveInt("keepalive_nonwifi", i2);
    }

    public void setKeepaliveWifi(int i2) {
        saveInt("keepalive_wifi", i2);
    }

    public void setKeyboardHeight(int i2) {
        this.keyboardHeight = i2;
    }

    public void setLastNotifyTime(long j2) {
        TbadkSettings.getInst().saveLong("last_notify_sound_time", j2);
    }

    public void setLastSyncFinishTime(long j2) {
        this.mLastSyncFinishTime = j2;
    }

    public void setLastUpdateMemberCenterTime(long j2) {
        this.lastUpdateMemberCenterTime = j2;
    }

    public void setLastUpdateThemeTime(long j2) {
        this.lastUpdateThemeTime = j2;
    }

    public void setLcsSwitchStratgy(String str) {
        if (str == null) {
            str = "";
        }
        TbadkSettings.getInst().saveString("lcs_switch_strategy", str);
    }

    public void setLikeBarChanged(boolean z) {
        this.mLikeChanged = z;
    }

    public void setLocationLat(String str) {
        TbadkSettings.getInst().saveString("location_lat", str);
    }

    public void setLocationLng(String str) {
        TbadkSettings.getInst().saveString("location_lng", str);
    }

    public void setLocationPos(String str) {
        TbadkSettings.getInst().saveString("location_pos", str);
    }

    public void setLocationShared(boolean z) {
        TbadkSettings inst = TbadkSettings.getInst();
        inst.saveBoolean("location_shared_" + getCurrentAccount(), z);
        if (z) {
            tryLbs();
        }
    }

    public void setNeedCheckUserNameDialog(boolean z) {
        this.needCheckUserNameDialog = z;
    }

    public void setNetWorkCoreType(int i2) {
        NetWorkCoreFacotry.setNetType(i2);
        saveInt("networkcore_type", i2);
    }

    public void setNewVcodeWebviewCrashCount(int i2) {
        this.mNewVcodeWebviewCrashCount = i2;
    }

    public void setPageStayOpen(boolean z) {
        this.mIsPageStayOpen = z;
    }

    public void setPaymemberInfo(PayMemberInfoData payMemberInfoData) {
        this.payInfo = payMemberInfoData;
    }

    public void setPerformSampleCount(int i2) {
        this.mPerformSampleCount = i2;
        TbadkSettings.getInst().saveInt("perform_sample_count", i2);
    }

    public void setProcesBackground(boolean z) {
        this.isBackground = z;
    }

    public void setProfileData(c0 c0Var) {
        this.mProfileData = c0Var;
    }

    public void setPromotedMessage(String str, boolean z) {
        TbadkSettings.getInst().saveBoolean("permoted_message_" + str, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void setProxyIp(String str) {
        this.proxyIp = str;
    }

    public void setProxyPort(String str) {
        this.proxyPort = str;
    }

    public void setPushChannelId(String str) {
        saveString(Constants.EXTRA_PUSH_CHANNEL_ID, str);
    }

    public void setPushChannelUserId(String str) {
        saveString("push_channel_userId", str);
    }

    public void setReadMenuDialogTop(boolean z) {
        this.isReadMenuDialogTop = z;
    }

    public void setReadThreadPlayerScreenMaxHeight(int i2) {
        this.mReadThreadPlayerScreenMaxHeight = i2;
    }

    public void setRecAppExist(boolean z) {
        this.isRecAppExist = z;
    }

    public void setReporyUserInfoCurrentTime() {
        TbadkSettings.getInst().saveLong("report_user_info_time_key" + getCurrentAccount(), System.currentTimeMillis());
    }

    public void setSdk_ver(String str) {
        this.sdk_ver = str;
    }

    public void setShareItem(ShareItem shareItem) {
        this.mShareItem = shareItem;
    }

    public void setShowPayInfoRedTip(boolean z) {
        this.showPayInfoRedTip = z;
    }

    public void setShowSwipeBackGuide(boolean z) {
        TbadkSettings.getInst().saveBoolean("show_swipe_back_key", z);
    }

    public void setSkinType(int i2) {
        d.a.j0.r.l.b.s().O(i2);
    }

    public void setSkinTypeValue(int i2) {
        d.a.j0.r.l.b.s().P(i2);
    }

    public void setSocketGetMsgStratgy(String str) {
        TbadkSettings.getInst().saveString("socket_getmsg_strategy", str);
    }

    public void setSocketHeartBeatStratgy(String str) {
        TbadkSettings.getInst().saveString("socket_heartbeat_strategy", str);
    }

    public void setSocketReconnStratgy(String str) {
        TbadkSettings.getInst().saveString("socket_reconn_strategy", str);
    }

    public void setStartType(int i2) {
        this.startType = i2;
    }

    public void setSwan_game_ver(String str) {
        this.swan_game_ver = str;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public void setTbs(String str) {
        d.a.j0.r.l.b.s().Q(str);
    }

    public void setTempFaceShopVersion(int i2) {
        this.mTempFaceShopVersion = i2;
    }

    public void setThemeIconCover(boolean z) {
        d.a.j0.r.l.b.s().R(z);
    }

    public void setThemeWebviewOpen(boolean z) {
        this.mThemeWebviewOpened = z;
    }

    public void setUegVoiceWarning(String str) {
        this.uegVoiceWarning = str;
    }

    public void setUpdateNotifyTime(long j2) {
        TbadkSettings.getInst().saveLong("update_notify_time", j2);
    }

    public void setUrlText(String str) {
        this.urlText = str;
    }

    public void setUseNewResign(int i2) {
        this.useNewResign = i2;
    }

    public void setUseTimeInterval(long j2) {
        d.a.j0.r.d0.b.j().w("use_time_interval", j2);
        this.useTimeInterval = j2;
    }

    public void setUsed() {
        FileHelper.DataDir.cleanDirectory(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR);
        FileHelper.DataDir.createFile("/package.cur/" + TbConfig.getVersion());
    }

    public void setUsedThemeColor(int i2) {
        d.a.j0.r.l.b.s().U(i2);
    }

    public void setVersionData(VersionData versionData) {
        this.mVersionData = versionData;
    }

    public void setVideoAutoPlay(int i2) {
        if (this.mVideoAutoPlayConfig == i2) {
            return;
        }
        this.mVideoAutoPlayConfig = i2;
        TbadkSettings.getInst().saveInt("video_auto_play_new", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921511, ""));
    }

    public void setWebviewCrashCount(int i2) {
        this.mWebviewCrashCount = i2;
        TbadkSettings.getInst().saveInt("webview_crash_count", i2);
    }

    public void setYijianfankuiFname(String str) {
        this.mYijianfankuiFname = str;
    }

    public void setYunpushChannelId(String str) {
        d.a.j0.r.d0.b.j().x("yunpush_channel_id", str);
    }

    public boolean shouldGPUOn() {
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

    public boolean shouldNeedCheckUserNameDialog() {
        return this.needCheckUserNameDialog;
    }

    public int signedForumCount() {
        Hashtable<String, Integer> hashtable = this.mHasSignList;
        if (hashtable != null) {
            return hashtable.size();
        }
        return 0;
    }

    public void startActiveService() {
        getContext().startService(new Intent(getContext(), TiebaActiveService.class));
    }

    public void startClearTempService() {
        try {
            getContext().startService(new Intent(getContext(), ClearTempService.class));
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public void startSyncLoginService() {
    }

    public void startSyncService() {
        getContext().startService(new Intent(getContext(), TiebaSyncService.class));
    }

    public void startTrackConfigRequest() {
        d.a.j0.y0.a aVar = new d.a.j0.y0.a();
        aVar.c();
        aVar.b(new i());
    }

    public void stopActiveServide() {
        getContext().stopService(new Intent(getContext(), TiebaActiveService.class));
    }

    public void stopSyncService() {
        getContext().stopService(new Intent(getContext(), TiebaSyncService.class));
    }

    public void tryLbs() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            this.mHandler.postDelayed(new d(), 5000L);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused) {
        }
    }

    public void upgradeAbstractOnInMemory(int i2) {
        this.mIsAbstractOn = i2;
    }

    public String getZid(Context context, String str, int i2, String str2) {
        return PermissionUtil.isAgreePrivacyPolicy() ? FH.gzfi(context, str, i2, str2) : "000";
    }

    public void sendImagePv(int i2, int i3, String str, int i4, int i5) {
        if (this.imagePvThread == null) {
            this.imagePvThread = Executors.newSingleThreadExecutor();
        }
        d.a.j0.z0.z zVar = new d.a.j0.z0.z(i2, i3);
        zVar.a(str);
        this.imagePvThread.execute(zVar);
        TiebaStatic.eventStat(getInst().getApp(), "img_browse", null, 1, "img_num", Integer.valueOf(i2), "img_total", Integer.valueOf(i3), "img_type", str, "img_begin", Integer.valueOf(i4), "img_end", Integer.valueOf(i5));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        try {
            return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (Throwable unused) {
            return new Intent();
        }
    }

    public void onUserChanged(Intent intent2) {
        if (intent2 != null) {
            String stringExtra = intent2.getStringExtra(LoginActivityConfig.USER_INFO_CHANGED);
            if (!TextUtils.isEmpty(stringExtra)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016494, stringExtra));
            }
        }
        onUserChanged();
    }
}
