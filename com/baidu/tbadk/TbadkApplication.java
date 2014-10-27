package com.baidu.tbadk;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.c.c;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.client.socket.link.h;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.g.d;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.m;
import com.baidu.adp.lib.util.r;
import com.baidu.android.common.util.CommonParam;
import com.baidu.bdcvf.CertVerifier;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.a.a;
import com.baidu.tbadk.core.atomData.InvokeOnCreateOnMainThreadMessageConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
import com.baidu.tbadk.coreExtra.websocketBase.PingManager;
import com.baidu.tbadk.coreExtra.websocketBase.q;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tbadk.editortool.v;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.performanceLog.w;
import com.baidu.tbadk.pluginArch.receiver.RemoteAccountChangeReceiver;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class TbadkApplication extends BdBaseApplication {
    public static final String ACCOUNT_CHANGE_ACTION = "com.baidu.tieba.action.accountChange";
    public static final int APP_ENTER_FORE_SEND_PV_INTERNAL = 3600000;
    public static final int APP_ENTER_FORE_SWITCH = 5;
    public static final int APP_EVENT_LOGIN = 1;
    public static final int APP_PV_STAT = 4;
    private static final String CUSTOM_THEME_URL = "file:///android_asset/sapi_theme/style.css";
    protected static final String DEFAULT_IMEI = "000000000000000";
    public static final int MEMORY_FOURM_COUNT = 50;
    public static final String isMem = "IsMem_";
    protected Boolean _isMainProcess;
    private a alarm;
    private Boolean isCdnTachometerProcess;
    private boolean isFriendFeedNew;
    private boolean isRemoteProcess;
    private boolean isXiubaProcess;
    private int keyboardHeight;
    public long mainProcessCreateTime;
    private d resourcesWrapper;
    public SharedPreferences sp;
    private String tShopUrl;
    protected static TbadkApplication sApp = null;
    protected static boolean IS_APP_RUNNING = false;
    protected static String mUniqueId = null;
    protected static AccountData mAccount = null;
    protected static String clientId = null;
    private static Intent intent = null;
    private static boolean isChangeAccount = false;
    public static boolean isSDKLogin = false;
    private static String mForumName = "armcv";
    protected int mSkinType = 0;
    protected int mResumeNum = 0;
    protected long mStartTime = 0;
    protected AtomicBoolean isInBackground = null;
    protected int mEnterForeCount = 0;
    protected long mLastSendEnterForePvTime = 0;
    protected String mCuid = null;
    protected String mImei = null;
    protected boolean mIsOfficial = true;
    private int mFontSize = 3;
    private final HashMap<Class<?>, Class<?>> mActicyConfig = new HashMap<>();
    public ArrayList<BaseActivity> mRemoteActivity = null;
    public boolean mMsgChatOn = true;
    public int mMsgFrequency = 0;
    public boolean mMsgAtmeOn = true;
    public boolean mMsgReplymeOn = true;
    public boolean mMsgNewFansOn = true;
    public int mViewImageQuality = 0;
    public boolean mRemindVibrateOn = false;
    public boolean mRemindToneOn = true;
    public boolean mRemindLightOn = true;
    public boolean mNoDisturbOn = false;
    public String mNoDisturbStartTime = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String mNoDisturbEndTime = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;
    private boolean mGpuOpen = false;
    private boolean mPromotedMessageOn = true;
    private boolean mIsExitAppCloseWebSocket = false;
    private boolean mUseHttpClient = true;
    private int mWebviewCrashCount = 0;
    private long mLaunchTime = -1;
    private int mIsAbstractOn = 1;
    private int mVoiceHeadsetMode = 0;
    private final Handler mHandler = new Handler();
    protected boolean mCapableOfWebp = false;
    private boolean isDaemonProcess = false;
    CustomMessageListener mMemListener = new CustomMessageListener(2001200) { // from class: com.baidu.tbadk.TbadkApplication.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
                if (num.intValue() != 0) {
                    TbadkSettings.getInst().saveBoolean(TbadkApplication.isMem + TbadkApplication.getCurrentAccount(), true);
                } else {
                    TbadkSettings.getInst().saveBoolean(TbadkApplication.isMem + TbadkApplication.getCurrentAccount(), false);
                }
            }
        }
    };
    public Handler handler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.TbadkApplication.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    TbadkApplication.setCurrentAccount(null, TbadkApplication.this.getContext());
                    String string = message.getData().getString(LoginActivityConfig.ACCOUNT);
                    if (string == null) {
                        string = "";
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkApplication.this, string, false, true)));
                    break;
                case 4:
                    long currentTimeMillis = (((System.currentTimeMillis() - TbadkApplication.this.mStartTime) / 1000000) - TbConfig.USE_TIME_INTERVAL) / 1000;
                    if (currentTimeMillis > 0) {
                        new au(TbConfig.ST_TYPE_USE, String.valueOf(currentTimeMillis)).start();
                        TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(currentTimeMillis));
                    }
                    TbadkApplication.this.mStartTime = 0L;
                    break;
                case 5:
                    if (Boolean.TRUE.equals(message.obj)) {
                        TbadkApplication.this.notifyAppEnterBackground();
                        break;
                    } else {
                        TbadkApplication.this.notifyAppEnterForehead();
                        break;
                    }
            }
            return false;
        }
    });
    private ExecutorService imagePvThread = null;
    private boolean isFirstGoFrs = false;
    private boolean isFirstGoMaintab = false;
    private boolean isFaceShopNew = false;
    private int mFaceShopVersion = -1;
    private int mTempFaceShopVersion = -1;
    private String mDefaultBubble = null;
    private int mDefaultBubbleEndTime = 0;
    private boolean mNeedShowNewVersion = false;
    private boolean isPhoneCalling = false;

    public void markLauchTime() {
        this.mLaunchTime = System.currentTimeMillis();
    }

    public void delLauchTime() {
        this.mLaunchTime = -1L;
    }

    public void sendLaunchTime() {
        if (this.mLaunchTime > 0) {
            this.mLaunchTime = System.currentTimeMillis() - this.mLaunchTime;
        }
        this.mLaunchTime = -1L;
    }

    public static void setIntent(Intent intent2) {
        intent = intent2;
    }

    public static Intent getIntent() {
        return intent;
    }

    public void addRemoteActivity(BaseActivity baseActivity) {
        if (this.mRemoteActivity != null) {
            int size = this.mRemoteActivity.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.mRemoteActivity.get(i).releaseResouce();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (baseActivity != null) {
                this.mRemoteActivity.add(baseActivity);
            }
        }
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.mActicyConfig.containsKey(cls)) {
            this.mActicyConfig.put(cls, cls2);
        }
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.mActicyConfig != null) {
            return this.mActicyConfig.get(cls);
        }
        return null;
    }

    public void delRemoteActivity(BaseActivity baseActivity) {
        if (this.mRemoteActivity != null) {
            this.mRemoteActivity.remove(baseActivity);
        }
    }

    /* renamed from: getInst  reason: collision with other method in class */
    public static TbadkApplication m251getInst() {
        return sApp;
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        if (isMainProcess(true)) {
            this.mainProcessCreateTime = System.currentTimeMillis();
        }
        long j = 0;
        if (this.isRemoteProcess) {
            j = System.currentTimeMillis();
        }
        this.alarm = new a(this);
        com.baidu.adp.lib.Disk.d.bn().q(TbConfig.getTempDirName());
        e.lq();
        init(this);
        com.baidu.tbadk.core.frameworkData.e.initial();
        initSapi();
        initAccount();
        CustomMessageTask customMessageTask = new CustomMessageTask(2002001, new CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.frameworkData.a>() { // from class: com.baidu.tbadk.TbadkApplication.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.core.frameworkData.a> run(CustomMessage<com.baidu.tbadk.core.frameworkData.a> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    com.baidu.tbadk.core.frameworkData.a data = customMessage.getData();
                    Class<?> cls = (Class) TbadkApplication.this.mActicyConfig.get(data.getClass());
                    if (cls != null) {
                        data.getIntent().setClass(customMessage.getData().getContext(), cls);
                        data.run();
                    }
                }
                return null;
            }
        });
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().sendMessage(new CustomMessage(2005003, new InvokeOnCreateOnMainThreadMessageConfig(m251getInst())));
        MessageManager.getInstance().sendMessage(new CustomMessage(2005005, new InvokeOnCreateOnMainThreadMessageConfig(m251getInst())));
        setActivityStackMaxSize(20);
        MessageManager.getInstance().registerListener(this.mMemListener);
        if (isMainProcess(true)) {
            com.baidu.tbadk.distribute.a.ra().rd();
            UninstallInquirer.getInstance().startProcessBySwitch();
        }
        registerPhoneListener();
        if (this.isRemoteProcess) {
            w.t(System.currentTimeMillis() - j);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.resourcesWrapper == null && super.getResources() != null) {
            this.resourcesWrapper = new d(super.getResources());
        }
        return this.resourcesWrapper;
    }

    private void initSapi() {
        String string;
        Resources resources = getResources();
        if (resources == null) {
            string = "";
        } else {
            string = resources.getString(y.register_tip);
        }
        SapiAccountManager.getInstance().init(new SapiConfiguration.Builder(this).setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).setRuntimeEnvironment(TbConfig.PASS_LOGIN_ADDRESS).registMode(RegistMode.FAST).initialShareStrategy(LoginShareStrategy.CHOICE).skin(CUSTOM_THEME_URL).fastRegConfirm(isNeedConfirm()).fastRegConfirmMsg(string).build());
    }

    public boolean isNeedConfirm() {
        String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
        boolean z = systemProperty != null && "V5".equals(systemProperty);
        String from = getFrom();
        return z || (from != null && from.equalsIgnoreCase(TbConfig.DIALOG_FROM));
    }

    private void initAccount() {
        AccountData jA;
        if (isMainProcess(true)) {
            try {
                if (m251getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists() && (jA = com.baidu.tbadk.core.account.a.jA()) != null) {
                    setCurrentAccount(jA, m251getInst());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setIsAbstractOn(int i) {
        this.mIsAbstractOn = i;
        TbadkSettings.getInst().saveInt("new_abstract_state", i);
    }

    public int getIsAbstractStatus() {
        return this.mIsAbstractOn;
    }

    public boolean getIsAbstract() {
        if (this.mIsAbstractOn == 0) {
            if (j.fi()) {
                return true;
            }
        } else if (this.mIsAbstractOn == 1) {
            return true;
        }
        return false;
    }

    public a getAlarmManager() {
        return this.alarm;
    }

    public void init(Context context) {
        sApp = this;
        if (!isDebugMode()) {
            CertVerifier.getInstance().verify(this, new CertVerifier.ResultListener() { // from class: com.baidu.tbadk.TbadkApplication.4
                @Override // com.baidu.bdcvf.CertVerifier.ResultListener
                public void onVerifyOK() {
                    TbadkApplication.this.mIsOfficial = true;
                }

                @Override // com.baidu.bdcvf.CertVerifier.ResultListener
                public void onVerifyFail(int i) {
                    TbadkApplication.this.mIsOfficial = false;
                }
            });
        }
        initCuid();
        TbConfig.initBigImageMaxUsedMemory(this);
        clientId = readClientId(this);
        initImei();
        InitVersion();
        InitFrom();
        initSetting();
        this.mIsExitAppCloseWebSocket = TbadkSettings.getInst().loadBoolean("is_exit_app_not_start_websocket", false);
        initWebsocketBase(context);
        TbFaceManager.sf().a(this, new v());
        this.mFontSize = TbadkSettings.getInst().loadInt("font_size", 2);
        try {
            com.baidu.adp.lib.d.a.dE().initial(m251getInst(), "tieba");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isMainProcess(true)) {
            com.baidu.tbadk.core.util.httpNet.a.mT();
            com.baidu.tbadk.imageManager.e.sg().v(50, TbConfig.getBigImageMaxUsedMemory());
            try {
                registerReceiver(new NetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        } else {
            com.baidu.tbadk.imageManager.e.sg().v(0, TbConfig.getBigImageMaxUsedMemoryForRemoteProcess());
            try {
                registerReceiver(new RemoteAccountChangeReceiver(), new IntentFilter("adp.bdstatisticsmanager2.account_changed"));
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
        initSettings();
    }

    private void initWebsocketBase(Context context) {
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new h() { // from class: com.baidu.tbadk.TbadkApplication.5
            @Override // com.baidu.adp.framework.client.socket.link.h
            public boolean canOpenWebSocket() {
                return !TbadkApplication.this.isExitAppCloseWebSocket();
            }
        });
        int[] imTimeOut = getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            c.aX().c(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            l.a(socketReconnStratgy);
        }
        PingManager.qC().initial();
        MessageManager.getInstance().getSocketClient().a(PingManager.qC());
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tbadk.coreExtra.websocketBase.y());
        try {
            com.baidu.adp.framework.client.socket.coder.d.aL().g(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        com.baidu.tbadk.coreExtra.websocketBase.v.qL().init();
        q.qH().init();
        initSocket();
    }

    private static void initSocket() {
        b registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.g(false);
        registerImScoketTask.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", getUniqueIdentifier()));
        String qq = com.baidu.tbadk.coreExtra.websocketBase.a.qo().qq();
        if (TextUtils.isEmpty(qq)) {
            l.setUrl(TiebaIMConfig.url);
        } else {
            l.setUrl(qq);
        }
        l.k(TiebaIMConfig.wsExtensions);
        l.b(arrayList);
        BdSocketLinkService.init();
        BdSocketLinkService.startService(false, "TiebaImApplication init");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        onAppMemoryLow();
        super.onLowMemory();
    }

    @Override // com.baidu.adp.base.BdBaseApplication
    public void onAppMemoryLow() {
        super.onAppMemoryLow();
        int sh = com.baidu.tbadk.imageManager.e.sg().sh();
        int max = (int) Math.max(sh * 0.8d, TbConfig.getBigImageMaxUsedMemory());
        if (max < sh) {
            BdLog.isDebugMode();
            com.baidu.tbadk.imageManager.e.sg().cQ(max);
        }
        com.baidu.tbadk.core.util.d.lp();
    }

    private static b registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        b bVar = new b(i);
        bVar.setResponsedClass(cls);
        bVar.f(z);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initSettings() {
        boolean z;
        int i;
        AssetManager assets;
        InputStream inputStream;
        this.mVoiceHeadsetMode = TbadkSettings.getInst().loadInt("voice_headset_mode", 0);
        if (TbadkSettings.getInst().loadInt("webp_failure_count", -1) == -1) {
            if (Build.VERSION.SDK_INT >= 14 && (assets = m251getInst().getContext().getAssets()) != null) {
                try {
                    inputStream = assets.open("webp_test/test.webp");
                } catch (IOException e) {
                    e.printStackTrace();
                    inputStream = null;
                }
                if (inputStream != null && BitmapFactory.decodeStream(inputStream) != null) {
                    z = true;
                    if (z) {
                        i = 6;
                        this.mCapableOfWebp = false;
                    } else {
                        this.mCapableOfWebp = true;
                        i = 0;
                    }
                    TbadkSettings.getInst().saveInt("webp_failure_count", i);
                    TbadkSettings.getInst().saveBoolean("capable_of_webp_format", this.mCapableOfWebp);
                    return;
                }
            }
            z = false;
            if (z) {
            }
            TbadkSettings.getInst().saveInt("webp_failure_count", i);
            TbadkSettings.getInst().saveBoolean("capable_of_webp_format", this.mCapableOfWebp);
            return;
        }
        this.mCapableOfWebp = TbadkSettings.getInst().loadBoolean("capable_of_webp_format", false);
    }

    private void initSetting() {
        this.mFaceShopVersion = TbadkSettings.getInst().loadInt("faceshop_version", -1);
        this.mIsAbstractOn = TbadkSettings.getInst().loadInt("new_abstract_state", 0);
        this.mGpuOpen = TbadkSettings.getInst().loadBoolean("gpu_open", shouldGPUOn());
        this.mUseHttpClient = TbadkSettings.getInst().loadBoolean("httpclient", true);
        this.mPromotedMessageOn = TbadkSettings.getInst().loadBoolean("permoted_message", true);
        this.mWebviewCrashCount = TbadkSettings.getInst().loadInt("webview_crash_count", 0);
    }

    protected void InitVersion() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
            TbConfig.setVersionType(com.baidu.adp.lib.g.c.f(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
        } catch (Exception e) {
            TbConfig.setVersionType(3);
            BdLog.e(e.getMessage());
        }
        try {
            if (TbConfig.getVersionType() == 2) {
                TbConfig.setVersion(String.valueOf(applicationInfo.metaData.get("grayVersion")));
                return;
            }
            TbConfig.setVersion(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            if (TbConfig.getVersionType() == 1) {
                TbConfig.setSubVersion(String.valueOf(applicationInfo.metaData.get("subVersion")));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    public void setSkinTypeValue(int i) {
        this.mSkinType = i;
    }

    public static boolean getIsAppRunning() {
        return IS_APP_RUNNING;
    }

    public static void setIsAppRunning(boolean z) {
        IS_APP_RUNNING = z;
    }

    public boolean isMainProcess(boolean z) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (this._isMainProcess != null) {
            return this._isMainProcess.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            String packageName = getPackageName();
            String str = String.valueOf(packageName) + ":cdnTachometer";
            String str2 = String.valueOf(packageName) + ":daemon";
            String str3 = String.valueOf(packageName) + ":remote";
            String str4 = String.valueOf(packageName) + ":xiuba";
            String[] strArr = {str3, str, String.valueOf(packageName) + ":hao123_float", String.valueOf(packageName) + ":bdservice_v1", String.valueOf(packageName) + ":live", String.valueOf(packageName) + ":cdnTachometer", str2, str4};
            int myPid = Process.myPid();
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                if (runningAppProcesses.get(i).pid == myPid) {
                    String str5 = runningAppProcesses.get(i).processName;
                    if (str5 != null) {
                        if (str5.equalsIgnoreCase(str2)) {
                            this.isDaemonProcess = true;
                        }
                        if (str5.equalsIgnoreCase(str4)) {
                            this.isXiubaProcess = true;
                        }
                        if (str5.equalsIgnoreCase(packageName)) {
                            this._isMainProcess = Boolean.TRUE;
                            return true;
                        }
                        if (str5.equalsIgnoreCase(str)) {
                            this.isCdnTachometerProcess = Boolean.TRUE;
                        }
                        if (str5.equalsIgnoreCase(str3)) {
                            this.isRemoteProcess = true;
                        }
                        for (String str6 : strArr) {
                            if (str5.equalsIgnoreCase(str6)) {
                                this._isMainProcess = Boolean.FALSE;
                                return false;
                            }
                        }
                        return z;
                    }
                    return z;
                }
            }
            return z;
        }
        return z;
    }

    public boolean isDaemonProcess() {
        return this.isDaemonProcess;
    }

    public boolean isXiubaProcess() {
        return this.isXiubaProcess;
    }

    public boolean isTbCDNTachometerProcess() {
        if (this.isCdnTachometerProcess == null) {
            return false;
        }
        return this.isCdnTachometerProcess.booleanValue();
    }

    public void AddResumeNum() {
        this.mResumeNum++;
        processResumeNum();
    }

    public void DelResumeNum() {
        this.mResumeNum--;
        processResumeNum();
    }

    protected void processResumeNum() {
        if (isMainProcess(true)) {
            if (this.mResumeNum < 0) {
                this.mResumeNum = 0;
            }
            if (this.mStartTime == 0 && this.mResumeNum > 0) {
                this.mStartTime = System.currentTimeMillis();
            }
            this.handler.removeMessages(4);
            if (this.mResumeNum == 0 && this.mStartTime > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(4), TbConfig.USE_TIME_INTERVAL);
            }
            this.handler.removeMessages(5);
            if (this.mResumeNum == 0) {
                sendMessageForEnterBackground();
            } else if (this.isInBackground == null || this.isInBackground.get()) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(5, Boolean.FALSE), 1000L);
            }
        }
    }

    public void sendMessageForEnterBackground() {
        this.handler.sendMessageDelayed(this.handler.obtainMessage(5, Boolean.TRUE), 1000L);
    }

    public boolean isInBackground() {
        if (this.isInBackground == null) {
            return true;
        }
        return this.isInBackground.get();
    }

    public void notifyAppEnterBackground() {
        if (this.isInBackground == null) {
            this.isInBackground = new AtomicBoolean(false);
        }
        if (!this.isInBackground.get()) {
            this.isInBackground.set(true);
            MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(true));
            bd.bR(null);
            TiebaStatic.save();
        }
    }

    public int getEnterForeCount() {
        return this.mEnterForeCount;
    }

    public void clearEnterForeCount() {
        this.mEnterForeCount = 0;
    }

    public void notifyAppEnterForehead() {
        if (this.isInBackground == null) {
            this.isInBackground = new AtomicBoolean(true);
        }
        if (this.isInBackground.get()) {
            this.isInBackground.set(false);
            this.mEnterForeCount++;
            if (System.currentTimeMillis() - this.mLastSendEnterForePvTime > 3600000 || this.mLastSendEnterForePvTime == 0) {
                this.mLastSendEnterForePvTime = System.currentTimeMillis();
                new com.baidu.tbadk.core.util.q().start();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(false));
        }
    }

    public static synchronized String getUniqueIdentifier() {
        String str;
        synchronized (TbadkApplication.class) {
            if (mUniqueId == null) {
                String cuid = m251getInst().getCuid();
                String packageName = m251getInst().getApp().getPackageName();
                mUniqueId = String.valueOf(cuid) + "|" + packageName + TbConfig.getVersion();
            }
            str = mUniqueId;
        }
        return str;
    }

    protected void initCuid() {
        this.mCuid = loadString("cuid", null);
        if (this.mCuid == null || this.mCuid.length() <= 0) {
            this.mCuid = CommonParam.getCUID(this);
            if (this.mCuid == null || this.mCuid.length() <= 0) {
                this.mCuid = createRandomString("baidutiebaapp", 50);
            }
            if (this.mCuid.indexOf(0) != -1) {
                char[] charArray = this.mCuid.toCharArray();
                StringBuilder sb = new StringBuilder(charArray.length);
                for (int i = 0; i < charArray.length; i++) {
                    if (charArray[i] != 0) {
                        sb.append(charArray[i]);
                    }
                }
                this.mCuid = sb.toString();
            }
            saveString("cuid", this.mCuid);
        }
    }

    protected String createRandomString(String str, int i) {
        StringBuilder sb = new StringBuilder(i);
        if (str != null) {
            sb.append(str);
        }
        sb.append(r.fz());
        if (sb.length() > i) {
            sb.setLength(i);
        }
        return sb.toString();
    }

    public String getCuid() {
        if (com.baidu.adp.lib.util.l.aA(this.mCuid)) {
            initCuid();
        }
        return this.mCuid;
    }

    protected void saveString(String str, String str2) {
        com.baidu.tbadk.core.sharedPref.b.lk().putString(str, str2);
    }

    protected String loadString(String str, String str2) {
        return com.baidu.tbadk.core.sharedPref.b.lk().getString(str, str2);
    }

    protected boolean loadBoolean(String str, boolean z) {
        return com.baidu.tbadk.core.sharedPref.b.lk().getBoolean(str, z);
    }

    protected void saveBoolean(String str, boolean z) {
        if (this.sp != null) {
            try {
                SharedPreferences.Editor edit = this.sp.edit();
                edit.putBoolean(str, z);
                edit.commit();
            } catch (Throwable th) {
                BdLog.isDebugMode();
            }
        }
    }

    protected int loadInt(String str, int i) {
        return com.baidu.tbadk.core.sharedPref.b.lk().getInt(str, i);
    }

    protected void saveInt(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.lk().putInt(str, i);
    }

    protected long loadLong(String str, long j) {
        return com.baidu.tbadk.core.sharedPref.b.lk().getLong(str, j);
    }

    protected void saveLong(String str, long j) {
        com.baidu.tbadk.core.sharedPref.b.lk().putLong(str, j);
    }

    public void setTbs(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (mAccount != null) {
                    mAccount.setTbs(str);
                }
            }
        }
    }

    public String getTbs() {
        if (mAccount != null) {
            return mAccount.getTbs();
        }
        return null;
    }

    public String readClientId(Context context) {
        String loadString = loadString("client_id", null);
        if (loadString != null) {
            int indexOf = loadString.indexOf("\t");
            if (indexOf != -1) {
                if (TbConfig.getVersion().equals(loadString.substring(0, indexOf))) {
                    return loadString.substring(indexOf + 1);
                }
                removeClientId(this);
                return null;
            }
            removeClientId(this);
            return null;
        }
        return loadString;
    }

    public static String getClientId() {
        return clientId;
    }

    public void removeClientId(Context context) {
        com.baidu.tbadk.core.sharedPref.b.lk().remove("client_id");
    }

    public static void saveClientId(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.core.sharedPref.b.lk().putString("client_id", String.valueOf(TbConfig.getVersion()) + "\t" + str);
        }
    }

    public static void setClientId(String str) {
        clientId = str;
    }

    protected void initImei() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
            if (telephonyManager != null) {
                this.mImei = telephonyManager.getDeviceId();
            }
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
        if (this.mImei == null) {
            this.mImei = DEFAULT_IMEI;
        }
    }

    public String getImei() {
        if (com.baidu.adp.lib.util.l.aA(this.mImei)) {
            initImei();
        }
        return this.mImei;
    }

    public static String getCurrentBduss() {
        if (mAccount != null) {
            return mAccount.getBDUSS();
        }
        return null;
    }

    private String getFromByShare() {
        return loadString("from_id", null);
    }

    private void saveFromToShare(String str) {
        if (str != null && str.length() > 0 && isMainProcess(true)) {
            saveString("from_id", str);
        }
    }

    private String getFromByFile() {
        String str = null;
        try {
            File br = s.br(TbConfig.FROM_FILE);
            if (br != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(br));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "TiebaApplication.getFromByFile");
        }
        return str;
    }

    private void saveFromToFile(String str) {
        if (str != null && str.length() > 0) {
            try {
                File bt = s.bt(TbConfig.FROM_FILE);
                if (bt != null) {
                    FileWriter fileWriter = new FileWriter(bt);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "TiebaApplication.saveFromToFile");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void InitFrom() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String fromByShare = getFromByShare();
                bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
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
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
    }

    public static String getCurrentTbs() {
        if (mAccount != null) {
            return mAccount.getTbs();
        }
        return null;
    }

    public static void setCurrentBduss(String str) {
        boolean z = true;
        if (mAccount != null) {
            if (str != null ? str.equals(mAccount.getBDUSS()) : mAccount.getBDUSS() == null) {
                z = false;
            }
            mAccount.setBDUSS(str);
            if (z) {
                m251getInst().onAccountChanged(mAccount, m251getInst());
            }
        }
    }

    public static String getCurrentAccount() {
        if (mAccount != null) {
            return mAccount.getID();
        }
        return null;
    }

    public static boolean isLogin() {
        String currentAccount = getCurrentAccount();
        return currentAccount != null && currentAccount.length() > 0;
    }

    public boolean isOfficial() {
        return this.mIsOfficial;
    }

    public int getNetWorkCoreType() {
        return loadInt("networkcore_type", 1);
    }

    public void setNetWorkCoreType(int i) {
        aj.bs(i);
        saveInt("networkcore_type", i);
    }

    public static String getFrom() {
        return TbConfig.getFrom();
    }

    public void loginShareRemove() {
        com.baidu.tbadk.core.sharedPref.b.lk().remove("account_share");
    }

    public String loginShareRead() {
        return loadString("account_share", null);
    }

    public void loginShareSave(String str) {
        saveString("account_share", str);
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    public void setFontSize(int i) {
        if (this.mFontSize != i) {
            this.mFontSize = i;
            TbadkSettings.getInst().saveInt("font_size", i);
        }
    }

    public static void setCurrentAccount(final AccountData accountData, final Context context) {
        if (m.fu()) {
            setCurrentAccountInUI(accountData, context);
        } else {
            m251getInst().handler.post(new Runnable() { // from class: com.baidu.tbadk.TbadkApplication.6
                @Override // java.lang.Runnable
                public void run() {
                    TbadkApplication.setCurrentAccountInUI(AccountData.this, context);
                }
            });
        }
    }

    public static void setBdussAndTbsFromBackgroundInRelogin(AccountData accountData, String str, String str2) {
        if (accountData == null && mAccount != null) {
            isChangeAccount = true;
        } else if (mAccount == null && accountData != null) {
            isChangeAccount = true;
        } else if (mAccount != null && accountData != null && !TextUtils.equals(mAccount.getAccount(), accountData.getAccount())) {
            isChangeAccount = true;
        }
        if (mAccount == null && accountData != null) {
            mAccount = accountData;
        }
        if (mAccount != null) {
            if (!TextUtils.isEmpty(str)) {
                mAccount.setBDUSS(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                mAccount.setTbs(str2);
            }
        }
    }

    public static void setCurrentAccountFromRemoteProcessInUIThread(AccountData accountData, Context context) {
        String str;
        String str2;
        String str3 = null;
        mAccount = accountData;
        if (accountData != null) {
            str2 = accountData.getID();
            str = accountData.getAccount();
            str3 = accountData.getBDUSS();
        } else {
            str = null;
            str2 = null;
        }
        f.er().b(str2, str, str3);
    }

    public static void setCurrentAccountInUI(AccountData accountData, Context context) {
        if (!isChangeAccount) {
            if (accountData == null && mAccount != null) {
                isChangeAccount = true;
            } else if (mAccount == null && accountData != null) {
                isChangeAccount = true;
            } else if (mAccount != null && accountData != null && !TextUtils.equals(mAccount.getAccount(), accountData.getAccount())) {
                isChangeAccount = true;
            }
        }
        mAccount = accountData;
        if (context != null) {
            if (m251getInst().isPushServiceOpen()) {
                UtilHelper.startPushService(context);
            } else {
                UtilHelper.stopPushService(context);
            }
            if (m251getInst().isMoPlusOpen()) {
                UtilHelper.startMoPlusService(context);
            }
        }
        sendAccountChangedBroadcast(accountData);
        if (isChangeAccount) {
            m251getInst().onAccountChanged(accountData, m251getInst());
            BdSocketLinkService.setAvailable(true);
            BdSocketLinkService.startService(true, "account changed");
        }
        aa.rz().rA();
        LivePlayingStatusMgr.qe().a(0, LivePlayingStatusMgr.LivePlayingStatus.IDEL);
    }

    public static void reportLocation() {
        long loadLong = TbadkSettings.getInst().loadLong("last_enter_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (loadLong == 0 || currentTimeMillis - loadLong >= 600000) {
            m251getInst().getAlarmManager().a(a.xu, 1, System.currentTimeMillis(), 3600000L);
            BdLog.e("last enter:" + loadLong + "大于10分钟，立刻上报");
        } else {
            BdLog.e("last enter:" + loadLong + "小于10分钟，10分钟后上报");
            m251getInst().getAlarmManager().a(a.xu, 1, System.currentTimeMillis() + 600000, 600000L);
        }
        TbadkSettings.getInst().saveLong("last_enter_time", currentTimeMillis);
    }

    protected void onAccountChanged(AccountData accountData, Application application) {
        BdLog.e("账号切换");
        reportLocation();
        MessageManager.getInstance().sendMessage(new CustomMessage(2005006, accountData));
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2005016, accountData));
    }

    public void onUserChanged() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2005007));
    }

    protected static void sendAccountChangedBroadcast(AccountData accountData) {
        String str;
        String str2 = null;
        if (accountData != null) {
            str = accountData.getID();
            str2 = accountData.getAccount();
        } else {
            str = null;
        }
        Intent intent2 = new Intent();
        intent2.setAction("adp.bdstatisticsmanager2.account_changed");
        intent2.putExtra("intent_data_userid", str);
        intent2.putExtra("intent_data_username", str2);
        intent2.putExtra("intent_data_bduss", getCurrentBduss());
        try {
            m251getInst().getApp().sendStickyBroadcast(intent2);
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
        Intent intent3 = new Intent();
        intent3.setAction(ACCOUNT_CHANGE_ACTION);
        m251getInst().getApp().sendBroadcast(intent3);
    }

    public void setIsPushServiceOpen(boolean z) {
        saveBoolean("push_service", z);
    }

    public boolean isPushServiceOpen() {
        return loadBoolean("push_service", true);
    }

    public boolean isMoPlusOpen() {
        return loadBoolean("moplus_service", true);
    }

    public static void setCurrentAccountName(String str) {
        if (mAccount != null) {
            mAccount.setAccount(str);
        }
    }

    public static void delCurrentBduss() {
        if (mAccount != null) {
            mAccount.setBDUSS("");
        }
    }

    public static AccountData getCurrentAccountObj() {
        return mAccount;
    }

    public static String getCurrentAccountName() {
        if (mAccount != null) {
            return mAccount.getAccount();
        }
        return null;
    }

    public int getKeepaliveWifi() {
        return loadInt("keepalive_wifi", 1);
    }

    public void setKeepaliveWifi(int i) {
        saveInt("keepalive_wifi", i);
    }

    public int getKeepaliveNonWifi() {
        return loadInt("keepalive_nonwifi", 1);
    }

    public void setKeepaliveNonWifi(int i) {
        saveInt("keepalive_nonwifi", i);
    }

    public void setPushChannelId(String str) {
        saveString("push_channel_id", str);
    }

    public String getPushChannelUserId() {
        return loadString("push_channel_userId", "");
    }

    public void setPushChannelUserId(String str) {
        saveString("push_channel_userId", str);
    }

    public String getPushChannelId() {
        return loadString("push_channel_id", "");
    }

    public boolean getIsFirstUse() {
        if (t.bz("/package.cur/" + TbConfig.getVersion())) {
            return false;
        }
        setActiveVersion(t.bC("/package.cur"));
        return true;
    }

    public void setUsed() {
        t.bB("/package.cur");
        t.bA("/package.cur/" + TbConfig.getVersion());
    }

    public void setActiveVersion(String str) {
        if (!ay.aA(str) && !"null".equals(str)) {
            t.bB("/package.last");
            t.bA("/package.last/" + str);
        }
    }

    public void setFrom(String str) {
        TbConfig.setFrom(str);
    }

    public void sendImagePv(int i, int i2, String str) {
        if (this.imagePvThread == null) {
            this.imagePvThread = Executors.newSingleThreadExecutor();
        }
        com.baidu.tbadk.util.h hVar = new com.baidu.tbadk.util.h(i, i2);
        hVar.setType(str);
        this.imagePvThread.execute(hVar);
        TiebaStatic.eventStat(m251getInst().getApp(), "img_browse", null, 1, "img_num", Integer.valueOf(i), "img_total", Integer.valueOf(i2), "img_type", str);
    }

    public boolean isHeadsetModeOn() {
        return this.mVoiceHeadsetMode == 1;
    }

    public void setHeadsetModeOn(boolean z) {
        int i = z ? 1 : 0;
        if (this.mVoiceHeadsetMode != i) {
            this.mVoiceHeadsetMode = i;
            TbadkSettings.getInst().saveInt("voice_headset_mode", i);
        }
    }

    public void setLocationLat(String str) {
        TbadkSettings.getInst().saveString("location_lat", str);
    }

    public String getLocationLat() {
        return TbadkSettings.getInst().loadString("location_lat", "");
    }

    public void setLocationLng(String str) {
        TbadkSettings.getInst().saveString("location_lng", str);
    }

    public boolean getLocationShared() {
        return TbadkSettings.getInst().loadBoolean("location_shared_" + getCurrentAccount(), true);
    }

    public void setLocationShared(boolean z) {
        TbadkSettings.getInst().saveBoolean("location_shared_" + getCurrentAccount(), z);
        if (z) {
            m251getInst().getAlarmManager().a(a.xu, 1, System.currentTimeMillis(), m251getInst().getAlarmManager().iQ());
        } else {
            m251getInst().getAlarmManager().cancel();
        }
    }

    public boolean isTiebaHelperOpen() {
        return TbadkSettings.getInst().loadBoolean("tieba_helper_open", false);
    }

    public void setTiebaHelperOpen(boolean z) {
        TbadkSettings.getInst().saveBoolean("tieba_helper_open", z);
    }

    public String getLocationLng() {
        return TbadkSettings.getInst().loadString("location_lng", "");
    }

    public void setLocationPos(String str) {
        TbadkSettings.getInst().saveString("location_pos", str);
    }

    public String getLocationPos() {
        return TbadkSettings.getInst().loadString("location_pos", "");
    }

    public int[] getSocketHeartBeatStratgy() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public int[] getSocketGetMsgStratgy() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public int[] getImTimeOut() {
        String[] split;
        String loadString = TbadkSettings.getInst().loadString("socket_time_out", null);
        if (loadString == null || (split = loadString.split("\\|")) == null || split.length != 3) {
            return null;
        }
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = 0;
            try {
                iArr[i] = Integer.valueOf(split[i]).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
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
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public boolean isFirstGoFrs() {
        return this.isFirstGoFrs;
    }

    public boolean isFirstGoMaintab() {
        return this.isFirstGoMaintab;
    }

    public void setFirstGoFrs(boolean z) {
        this.isFirstGoFrs = z;
    }

    public void setFirstGoMaintab(boolean z) {
        this.isFirstGoMaintab = z;
    }

    public boolean isFaceShopNew() {
        return this.isFaceShopNew;
    }

    public void setFaceShopNew(boolean z) {
        this.isFaceShopNew = z;
    }

    public boolean isFriendFeedNew() {
        return this.isFriendFeedNew;
    }

    public void setFriendFeedNew(final boolean z) {
        this.isFriendFeedNew = z;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.TbadkApplication.7
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(z)));
            }
        });
    }

    public boolean isGroupMsgOn() {
        return TbadkSettings.getInst().loadBoolean("group_notify", true);
    }

    public boolean isMsgChatOn() {
        return this.mMsgChatOn;
    }

    public void setGroupMsgOn(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public void setForumName(String str) {
        mForumName = str;
    }

    public String getForumName() {
        return mForumName;
    }

    public int getMsgFrequency() {
        return this.mMsgFrequency;
    }

    public boolean isMsgAtmeOn() {
        return this.mMsgAtmeOn;
    }

    public boolean isMsgNewFansOn() {
        return this.mMsgNewFansOn;
    }

    public boolean isMsgReplymeOn() {
        return this.mMsgReplymeOn;
    }

    public boolean isMsgZanOn() {
        return TbadkSettings.getInst().loadBoolean("zan_disjunctor_setting", true);
    }

    public void setMsgZanOn(boolean z) {
        TbadkSettings.getInst().saveBoolean("zan_disjunctor_setting", z);
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public int getFaceShopVersion() {
        return this.mFaceShopVersion;
    }

    public void setFaceShopVersion(int i) {
        this.mFaceShopVersion = i;
        TbadkSettings.getInst().saveInt("faceshop_version", this.mFaceShopVersion);
    }

    public void setTempFaceShopVersion(int i) {
        this.mTempFaceShopVersion = i;
    }

    public boolean isMsgVibrateOn() {
        return this.mRemindVibrateOn;
    }

    public boolean isMsgToneOn() {
        return this.mRemindToneOn;
    }

    public boolean isMsgLightOn() {
        return this.mRemindLightOn;
    }

    public boolean isNoDisturbOn() {
        return this.mNoDisturbOn;
    }

    public String getNoDisturbStartTime() {
        return this.mNoDisturbStartTime;
    }

    public String getNoDisturbEndTime() {
        return this.mNoDisturbEndTime;
    }

    public int getTempFaceShopVersion() {
        return this.mTempFaceShopVersion;
    }

    public boolean getCapabilityOfWebp() {
        return this.mCapableOfWebp;
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

    public void setInstallOtherApp(String str) {
        TbadkSettings.getInst().saveString("install_other_app_file_name", str);
    }

    public String getInstallOtherApp() {
        return TbadkSettings.getInst().loadString("install_other_app_file_name", null);
    }

    public void setGpuOpen(boolean z) {
        TbadkSettings.getInst().saveBoolean("gpu_open", z);
        this.mGpuOpen = z;
    }

    public boolean isGpuOpen() {
        return this.mGpuOpen;
    }

    public void setHttpClientOpen(boolean z) {
        TbadkSettings.getInst().saveBoolean("httpclient", z);
        this.mUseHttpClient = z;
    }

    public boolean isHttpClientOpen() {
        return this.mUseHttpClient;
    }

    public boolean shouldGPUOn() {
        boolean z = false;
        String trim = Build.MODEL.trim();
        if (trim == null) {
            return true;
        }
        String[] strArr = {"M040", "M032", "M031", "M030", "HUAWEI C8813", "ZTE U970", "MediaPad 10 FHD", "GT-I9000", "DOEASY E930", "H8205", "GT-N7108", "GT-N7102", "GT-N719", "GT-N7100", "galaxy nexus", " ZTE U808", "UMI_X1", "nexus s", "AMOI N820", "JY-G", "XT885", "U701T", "Lenovo A750", "ZTE U807", "vivo S11t", "Droid Bionic", "MORAL_N01", "XT910", "GT-S7562", "Lenovo A798t", "vivo E5", "U705T", "HUAWEI T8951", "ME865", "HUAWEI P1XL", "KPT A9PLUS", "vivo Y11", "T9200", "XT928", "HUAWEI Y500-T00", "BBK Y3t", "Lenovo K860", "vivo X1", "HUAWEI T8833", "Lenovo A789", "ZTE U960E"};
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (strArr[i].equalsIgnoreCase(trim)) {
                    break;
                }
                i++;
            } else {
                z = true;
                break;
            }
        }
        BdLog.isDebugMode();
        return z;
    }

    public void setUpdateNotifyTime(long j) {
        TbadkSettings.getInst().saveLong("update_notify_time", j);
    }

    public long getUpdateNotifyTime() {
        return TbadkSettings.getInst().loadLong("update_notify_time", 0L);
    }

    public static boolean checkNeedShowNewVersion() {
        if (m251getInst().checkNeedShowNewVersionFlag()) {
            Long valueOf = Long.valueOf(m251getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            m251getInst().setUpdateNotifyTime(valueOf2.longValue());
            return valueOf2.longValue() - valueOf.longValue() > 86400000;
        }
        return false;
    }

    public void setDefaultBubble(String str) {
        this.mDefaultBubble = str;
    }

    public String getDefaultBubble() {
        return this.mDefaultBubble;
    }

    public int getDefaultBubbleEndTime() {
        return this.mDefaultBubbleEndTime;
    }

    public void setDefaultBubbleEndTime(int i) {
        this.mDefaultBubbleEndTime = i;
    }

    public boolean checkNeedShowNewVersionFlag() {
        return this.mNeedShowNewVersion;
    }

    public void refreshNewVersion(boolean z) {
        this.mNeedShowNewVersion = z;
        m251getInst().sendBroadcast(new Intent(TbConfig.getBroadcastActionNewVersion()));
    }

    public long getLastNotifyTime() {
        return TbadkSettings.getInst().loadLong("last_notify_sound_time", 0L);
    }

    public void setLastNotifyTime(long j) {
        TbadkSettings.getInst().saveLong("last_notify_sound_time", j);
    }

    public void setPromotedMessage(boolean z) {
        this.mPromotedMessageOn = z;
        TbadkSettings.getInst().saveBoolean("permoted_message", z);
    }

    public boolean isPromotedMessageOn() {
        return this.mPromotedMessageOn;
    }

    public int getWebviewCrashCount() {
        return this.mWebviewCrashCount;
    }

    public void setWebviewCrashCount(int i) {
        this.mWebviewCrashCount = i;
        TbadkSettings.getInst().saveInt("webview_crash_count", i);
    }

    public boolean isMsgRemindOn() {
        return m251getInst().mMsgFrequency > 0;
    }

    public String getVersionName() {
        try {
            if (getPackageManager() == null || getPackageManager().getPackageInfo(getPackageName(), 0) == null) {
                return null;
            }
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public int getVersionCode() {
        try {
            if (getPackageManager() == null || getPackageManager().getPackageInfo(getPackageName(), 0) == null) {
                return 0;
            }
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
            return 0;
        }
    }

    public void setIsMoPlusOpen(boolean z) {
        TbadkSettings.getInst().saveBoolean("moplus_service", z);
    }

    public boolean getIsMoPlusOpen() {
        if (TbadkSettings.getInst().loadInt("moplus_crash_count_" + TbConfig.getVersion(), 0) > getFeatureCrashAutoCloseLimit()) {
            return false;
        }
        return TbadkSettings.getInst().loadBoolean("moplus_service", true);
    }

    public void incMoPlusCrashCount() {
        String str = "moplus_crash_count_" + TbConfig.getVersion();
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

    public boolean isPassportV6ShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("passport_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.f.db().U("switch_login_passv6") != 1;
    }

    public void incHao123HelperCrashCount() {
        String str = "hao123_helper_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isHao123HelperShouldOpen() {
        String str = Build.MANUFACTURER;
        if ((TextUtils.isEmpty(str) || !(str.equalsIgnoreCase("Xiaomi") || str.equalsIgnoreCase("alps"))) && Build.VERSION.SDK_INT >= 9) {
            return TbadkSettings.getInst().loadInt(new StringBuilder("hao123_helper_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.f.db().U("switch_hao123_helper") != 1;
        }
        return false;
    }

    public long getReporyUserInfoLastTime() {
        return TbadkSettings.getInst().loadLong("report_user_info_time_key" + getCurrentAccount(), 0L);
    }

    public void setReporyUserInfoCurrentTime() {
        TbadkSettings.getInst().saveLong("report_user_info_time_key" + getCurrentAccount(), System.currentTimeMillis());
    }

    public void incBaobaoCrashCount() {
        String str = "baobao_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isNearByGroupOpen() {
        return com.baidu.adp.lib.b.f.db().U("offline_nearby_group") == 0;
    }

    public boolean isGiftSwitchOn() {
        return com.baidu.adp.lib.b.f.db().U("offline_gift") != 1;
    }

    public boolean isBaobaoShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("baobao_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.f.db().U("switch_baobao") == 1;
    }

    public void incDQCrashCount() {
        String str = "dq_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isDQShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("dq_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit();
    }

    public boolean isLiveRecordOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("live_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.f.db().U("switch_live_record") == 0;
    }

    public void setFeatureCrashAutoCloseLimit(int i) {
        TbadkSettings.getInst().saveInt("feature_crash_auto_close_limit", i);
    }

    public int getFeatureCrashAutoCloseLimit() {
        return Math.max(TbadkSettings.getInst().loadInt("feature_crash_auto_close_limit", 3), 3);
    }

    public String gettShopUrl() {
        return this.tShopUrl;
    }

    public void settShopUrl(String str) {
        this.tShopUrl = str;
    }

    public void setAppUploadDate(long j) {
        TbadkSettings.getInst().saveLong("app_upload_time", j);
    }

    public long getAppUploadDate() {
        return TbadkSettings.getInst().loadLong("app_upload_time", 0L);
    }

    public void setAppUploadMd5(String str) {
        TbadkSettings.getInst().saveString("app_upload_md5", str);
    }

    public String getAppUploadMd5() {
        return TbadkSettings.getInst().loadString("app_upload_md5", null);
    }

    public boolean isAppUploadOpen() {
        return com.baidu.adp.lib.b.f.db().U("upload_app_lists") == 1;
    }

    public boolean isLiveSDKOpen() {
        return com.baidu.adp.lib.b.f.db().U("live_sdk") == 0;
    }

    public boolean isKeyboardHeightCanUsed() {
        return this.keyboardHeight > getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_editor_faceview_height);
    }

    public boolean isKeyboardHeightCanSet(int i) {
        return i > getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_editor_faceview_height);
    }

    public int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    public void setKeyboardHeight(int i) {
        this.keyboardHeight = i;
    }

    public boolean getIsPhoneCalling() {
        return this.isPhoneCalling;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MyPhoneStateListener extends PhoneStateListener {
        private MyPhoneStateListener() {
        }

        /* synthetic */ MyPhoneStateListener(TbadkApplication tbadkApplication, MyPhoneStateListener myPhoneStateListener) {
            this();
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 0:
                    TbadkApplication.this.isPhoneCalling = false;
                    break;
                case 1:
                case 2:
                    TbadkApplication.this.isPhoneCalling = true;
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    }

    private void registerPhoneListener() {
        try {
            ((TelephonyManager) m251getInst().getApp().getSystemService("phone")).listen(new MyPhoneStateListener(this, null), 32);
        } catch (SecurityException e) {
        }
    }

    public boolean isExitAppCloseWebSocket() {
        return this.mIsExitAppCloseWebSocket;
    }
}
