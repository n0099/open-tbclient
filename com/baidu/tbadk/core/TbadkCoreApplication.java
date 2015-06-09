package com.baidu.tbadk.core;

import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketDaemonService;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.core.util.bt;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.websocketBase.PingManager;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.performanceLog.ai;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.SDCardChangeReceiver;
import com.baidu.tieba.service.SyncLoginService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class TbadkCoreApplication extends BdBaseApplication implements com.baidu.adp.base.b {
    public static final String ACCOUNT_CHANGE_ACTION = "com.baidu.tieba.action.accountChange";
    private static final String ACTIVE_CLEAR_TAG = "active_clear";
    public static final int APP_ENTER_FORE_SEND_PV_INTERNAL = 3600000;
    public static final int APP_ENTER_FORE_SWITCH = 5;
    public static final int APP_EVENT_LOGIN = 1;
    public static final int APP_PV_STAT = 4;
    protected static final String DEFAULT_IMEI = "000000000000000";
    public static final int MEMORY_FOURM_COUNT = 50;
    public static final String isMem = "IsMem_";
    private Boolean _isMainProcess;
    private com.baidu.tbadk.a.a alarm;
    private boolean isBackground;
    protected Boolean isCdnTachometerProcess;
    private boolean isFriendFeedNew;
    protected boolean isRemoteProcess;
    private int keyboardHeight;
    private int lcsTimeout2G;
    private int lcsTimeout3G;
    private int lcsTimeoutwifi;
    private com.baidu.tbadk.coreExtra.data.g listItemRule;
    private String mConfigVersion;
    private j mCustomizedFilter;
    private PersonChangeData mPersonChangeData;
    private String mYijianfankuiFname;
    public long processCreateTime;
    private SharedPreferences sp;
    public static boolean isSDKLogin = false;
    private static AccountData mAccount = null;
    private static boolean isChangeAccount = false;
    private static TbadkCoreApplication sApp = null;
    private static boolean IS_APP_RUNNING = false;
    protected static String mUniqueId = null;
    protected static String clientId = null;
    private static Intent intent = null;
    protected static HashMap<String, Integer> motuFilterImageMap = new HashMap<>();
    private static boolean isNeedRefreshOnResume = false;
    private int mSkinType = 0;
    private boolean mCapableOfWebp = false;
    private int mNewVcodeWebviewCrashCount = 0;
    private boolean mIsLocationOn = true;
    private int mVoiceHeadsetMode = 0;
    protected boolean isDaemonProcess = false;
    private boolean mIsExitAppCloseWebSocket = false;
    protected int mResumeNum = 0;
    protected long mStartTime = 0;
    protected String mCuid = null;
    protected String mImei = null;
    protected boolean mIsOfficial = true;
    protected int mEnterForeCount = 0;
    protected long mLastSendEnterForePvTime = 0;
    private int mFaceShopVersion = -1;
    private int mPerformSampleCount = 10;
    private VersionData mVersionData = null;
    private long mInitTime = 0;
    private int mIsAbstractOn = 1;
    private final Handler mHandler = new Handler();
    public Handler handler = new Handler(new o(this));
    protected AtomicBoolean isInBackground = null;
    private final HashMap<Class<?>, Class<?>> mActicyConfig = new HashMap<>();
    com.baidu.adp.lib.d.d locationCallBack = new u(this);
    private int mWebviewCrashCount = 0;
    private boolean mGpuOpen = false;
    private boolean mPromotedMessageOn = true;
    private boolean mUseHttpClient = true;
    private boolean mIsAppOn = false;
    private String mDefaultBubble = null;
    private int mDefaultBubbleEndTime = 0;
    private boolean mHasNewVersion = false;
    private CombineDownload mCombineDownload = null;
    public ArrayList<BaseActivity<?>> mRemoteActivity = null;
    private int mFontSize = 3;
    private HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> mFaces = null;
    public int mViewImageQuality = 0;
    private boolean isPhoneCalling = false;
    private ExecutorService imagePvThread = null;
    private Hashtable<String, Integer> mHasLikeList = null;
    private Hashtable<String, Integer> mHasSignList = null;
    private Hashtable<String, Integer> mSignLevelUpList = null;
    private boolean mLikeChanged = false;
    private boolean isFaceShopNew = false;
    private int mTempFaceShopVersion = -1;
    private boolean isRecAppExist = false;
    private String checkUrl = null;
    private boolean mNeedShowNewVersion = false;
    private boolean mIsNewRegUser = false;
    private com.baidu.tieba.tbadkCore.util.l mReadThreadHistory = null;
    private boolean isFirstGoFrs = false;
    private boolean isFirstGoMaintab = false;
    private com.baidu.adp.lib.util.q mToast = null;

    public static HashMap<String, Integer> getMotuFilterImageMap() {
        return motuFilterImageMap;
    }

    public static void setIntent(Intent intent2) {
        intent = intent2;
    }

    public static Intent getIntent() {
        return intent;
    }

    public long getInitTime() {
        return this.mInitTime;
    }

    public void setPluginResourceSwitch(boolean z) {
        super.setIsPluginResourceOpen(z);
    }

    private void initPluginResourceSwitch() {
        boolean z = true;
        super.setIsPluginResourceOpen((com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("is_plugin_resource_open_net", true) && com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("is_plugin_resource_open_local", true)) ? false : false);
    }

    public boolean isFriendFeedNew() {
        return this.isFriendFeedNew;
    }

    public void setFriendFeedNew(boolean z) {
        this.isFriendFeedNew = z;
        this.mHandler.post(new v(this, z));
    }

    public boolean isAppUploadOpen() {
        return com.baidu.adp.lib.b.f.gD().ai("upload_app_lists") == 1;
    }

    public static boolean checkNeedShowNewVersion() {
        if (m411getInst().checkNeedShowNewVersionFlag()) {
            Long valueOf = Long.valueOf(m411getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            m411getInst().setUpdateNotifyTime(valueOf2.longValue());
            return valueOf2.longValue() - valueOf.longValue() > 86400000;
        }
        return false;
    }

    public boolean isExitAppCloseWebSocket() {
        return this.mIsExitAppCloseWebSocket;
    }

    public void login(TbPageContext<?> tbPageContext, CustomMessage<LoginActivityConfig> customMessage) {
        if (customMessage != null) {
            if (tbPageContext != null) {
                tbPageContext.sendMessage(customMessage);
            } else {
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void notifyAppEnterForehead() {
        if (this.isInBackground == null) {
            this.isInBackground = new AtomicBoolean(true);
        }
        if (this.isInBackground.get()) {
            this.isInBackground.set(false);
            this.mEnterForeCount++;
            if (isMainProcess(true)) {
                if (System.currentTimeMillis() - this.mLastSendEnterForePvTime > 3600000 || this.mLastSendEnterForePvTime == 0) {
                    this.mLastSendEnterForePvTime = System.currentTimeMillis();
                    new com.baidu.tbadk.core.util.m().start();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(false));
                com.baidu.adp.lib.g.j.h(getContext(), new Intent(TbConfig.getBroadcastActionOtherProcessSwitchFrontBackground()));
            }
        }
    }

    public void notifyAppEnterBackground() {
        if (this.isInBackground == null) {
            this.isInBackground = new AtomicBoolean(false);
        }
        if (!this.isInBackground.get()) {
            this.isInBackground.set(true);
            if (isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(true));
                bg.dc(null);
                TiebaStatic.save();
                com.baidu.adp.lib.g.j.h(getContext(), new Intent(TbConfig.getBroadcastActionOtherProcessSwitchFrontBackground()));
            }
        }
    }

    /* renamed from: getInst */
    public static TbadkCoreApplication m411getInst() {
        return sApp;
    }

    public void AddResumeNum() {
        this.mResumeNum++;
        processResumeNum();
    }

    public void DelResumeNum() {
        this.mResumeNum--;
        processResumeNum();
    }

    public int getResumeNum() {
        return this.mResumeNum;
    }

    protected void processResumeNum() {
        if (this.mResumeNum < 0) {
            this.mResumeNum = 0;
        }
        if (isMainProcess(true)) {
            if (this.mStartTime == 0 && this.mResumeNum > 0) {
                this.mStartTime = System.nanoTime();
            }
            this.handler.removeMessages(4);
            if (this.mResumeNum == 0 && this.mStartTime > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(4), TbConfig.USE_TIME_INTERVAL);
            }
        }
        this.handler.removeMessages(5);
        if (this.mResumeNum == 0) {
            sendMessageForEnterBackground();
        } else if (this.isInBackground == null || this.isInBackground.get()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(5, Boolean.FALSE), 1000L);
        }
    }

    public boolean isInBackground() {
        if (this.isInBackground == null) {
            return true;
        }
        return this.isInBackground.get();
    }

    public void sendMessageForEnterBackground() {
        this.handler.sendMessageDelayed(this.handler.obtainMessage(5, Boolean.TRUE), 1000L);
    }

    public boolean isKeyboardHeightCanUsed() {
        return this.keyboardHeight > getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_editor_faceview_height);
    }

    public int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    public void setKeyboardHeight(int i) {
        this.keyboardHeight = i;
    }

    public boolean isKeyboardHeightCanSet(int i) {
        return i > getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_editor_faceview_height);
    }

    @Override // android.app.Application
    public void onCreate() {
        sApp = this;
        if (isMainProcess(true)) {
            bt.af(getApplicationContext());
        }
        recordMemoryAtBegin();
        initPluginResourceSwitch();
        super.onCreate(this);
        initCustomToastView();
        initCmdConvertManager();
        BdBaseService.setServiceOnCreateCallBack(new w(this));
        TbFaceManager.Al().a(sApp, new com.baidu.tbadk.editortool.t());
        this.processCreateTime = System.currentTimeMillis();
        ai.DI().y(System.currentTimeMillis());
        isMainProcess(true);
        this.alarm = new com.baidu.tbadk.a.a(this);
        com.baidu.adp.lib.Disk.d.fp().P(TbConfig.getTempDirName());
        init(getContext());
        if (isMainProcess(false)) {
            com.baidu.tbadk.distribute.a.yY().zb();
            this.mReadThreadHistory = new com.baidu.tieba.tbadkCore.util.l(300);
            com.baidu.adp.base.a.dF().a(this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        initTasks();
        com.baidu.tbadk.core.a.a.init();
        com.baidu.tbadk.coreExtra.act.a.init();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis() - System.currentTimeMillis();
        long currentTimeMillis4 = System.currentTimeMillis();
        initAccount();
        long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis4;
        CustomMessageTask customMessageTask = new CustomMessageTask(2002001, new y(this));
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        if (isMainProcess(false)) {
            initLikeForum();
            initSignedForum();
        }
        registerPhoneListener();
        long currentTimeMillis6 = System.currentTimeMillis();
        com.baidu.tbadk.core.util.r.getInstance();
        com.baidu.tbadk.core.util.httpNet.e.getInstance();
        if (isMainProcess(true) && com.baidu.tbadk.core.util.httpNet.e.getInstance() != null) {
            com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
        }
        if (isMainProcess(true)) {
            com.baidu.tieba.tbadkCore.l.a.apu();
        }
        com.baidu.tieba.im.a.init();
        ai.DI().a(currentTimeMillis2, currentTimeMillis3, currentTimeMillis5, System.currentTimeMillis() - currentTimeMillis6);
        ai.DI().z(System.currentTimeMillis());
        if (isMainProcess(true)) {
            com.baidu.tbadk.coreExtra.messageCenter.c.wg().initSetting();
        }
    }

    private void initCmdConvertManager() {
        if (isDebugMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(com.baidu.tbadk.core.frameworkData.b.class.getName());
            arrayList.add(com.baidu.tbadk.core.frameworkData.a.class.getName());
            arrayList.add(CmdConfigHttp.class.getName());
            com.baidu.adp.framework.a.dS().c(arrayList);
        }
    }

    @Deprecated
    private void loadNativeCrashCollectLib() {
        try {
            System.loadLibrary("google_breakpad");
        } catch (Throwable th) {
        }
    }

    private void recordMemoryAtBegin() {
        try {
            Class.forName("com.baidu.tieba.RecordMemoryAtBegin");
        } catch (Exception e) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            return super.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th) {
            return new Intent();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        try {
            return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (Throwable th) {
            return new Intent();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
    }

    protected void initTasks() {
        com.baidu.tbadk.core.frameworkData.g.initial();
    }

    protected void initAccount() {
        AccountData qm;
        if (isMainProcess(true)) {
            try {
                if (m411getInst().getContext().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists() && (qm = com.baidu.tbadk.core.a.d.qm()) != null) {
                    setCurrentAccount(qm, m411getInst().getContext());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        this.mActicyConfig.put(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        if (!this.mActicyConfig.containsKey(cls)) {
            this.mActicyConfig.put(cls, cls2);
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public Class<?> getIntentClass(Class<?> cls) {
        if (this.mActicyConfig != null) {
            return this.mActicyConfig.get(cls);
        }
        return null;
    }

    public boolean isNeedConfirm() {
        String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
        boolean z = systemProperty != null && "V5".equals(systemProperty);
        String from = getFrom();
        return z || (from != null && from.equalsIgnoreCase(TbConfig.DIALOG_FROM));
    }

    public static String getFrom() {
        return TbConfig.getFrom();
    }

    private void init(Context context) {
        if (!isDebugMode() && TbConfig.IS_CHECK_OFFICAL_APPLICATION) {
            this.mIsOfficial = com.baidu.tbadk.core.util.d.Z(context);
        }
        initCuid();
        TbConfig.initBigImageMaxUsedMemory(getContext());
        clientId = readClientId(getContext());
        initImei();
        InitVersion();
        InitFrom();
        initSetting();
        initWebsocketBase(context);
        this.mFontSize = TbadkSettings.getInst().loadInt("font_size", 2);
        try {
            com.baidu.adp.lib.d.a.gK().s(m411getInst().getContext(), "tieba");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (isMainProcess(true)) {
            com.baidu.tbadk.imageManager.e.Am().x(50, TbConfig.getBigImageMaxUsedMemory());
            try {
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.setPriority(-1);
                getContext().registerReceiver(new NetworkChangeReceiver(), intentFilter);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        } else {
            com.baidu.tbadk.imageManager.e.Am().x(0, TbConfig.getBigImageMaxUsedMemoryForRemoteProcess());
        }
        loadLcsSwitchStratgy();
        initSettings();
        this.mFaces = new HashMap<>();
        initSdcardDatabaseCallback();
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.addMessageRule(new com.baidu.tbadk.e.d(0));
        messageManager.addMessageRule(new com.baidu.tbadk.e.a(0));
        messageManager.addResponsedMessageRule(new com.baidu.tbadk.e.c(0));
        messageManager.addRemovedMessageRule(new com.baidu.tbadk.e.b(0));
        if (isMainProcess(true)) {
            com.baidu.tbadk.core.sharedPref.b.sl().sm();
        }
        initAppSettings();
        bq.ab(getContext());
        TbConfig.initBigImageWidth(getContext());
        TbConfig.initFriendPhotoConfig(getContext());
        try {
            Thread.setDefaultUncaughtExceptionHandler(new com.baidu.tbadk.util.m());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        boolean isMainProcess = isMainProcess(false);
        TiebaStatic.init(getContext(), isMainProcess);
        if (isMainProcess) {
            if (getIsFirstUse()) {
                com.baidu.adp.lib.b.f.gD().clear();
                if (!getCapabilityOfWebp()) {
                    TiebaStatic.eventStat(getApp(), "LocalWebpUnSupport", "");
                } else {
                    TiebaStatic.eventStat(getApp(), "LocalWebpSupport", "");
                }
            }
            loadLcsSwitchStratgy();
            try {
                SDCardChangeReceiver sDCardChangeReceiver = new SDCardChangeReceiver();
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addAction("android.intent.action.MEDIA_EJECT");
                getContext().registerReceiver(sDCardChangeReceiver, intentFilter2);
            } catch (Exception e3) {
            }
        } else {
            m411getInst().mRemoteActivity = new ArrayList<>();
        }
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2012000, new z(this));
        aVar.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        dealYYNotification();
        if (isMainProcess(true)) {
            sendMessageForEnterBackground();
            tryLbs();
        }
    }

    private int getCrashLimitCount() {
        try {
            int i = com.baidu.tbadk.core.sharedPref.b.sl().getInt("crash_limit_count", 100);
            if (i < 10) {
                return 10;
            }
            return i;
        } catch (Throwable th) {
            return 100;
        }
    }

    public void tryLbs() {
        com.baidu.adp.lib.d.a.gK().a(true, this.locationCallBack);
    }

    private static void initSdcardDatabaseCallback() {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().a(new aa());
    }

    public static void resetTDatabaseCreateTime() {
        TbadkSettings.getInst().saveLong("tdatabasecreatetime", new Date().getTime());
    }

    private void initAppSettings() {
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        com.baidu.adp.lib.d.a.gK().y(loadBoolean);
        n.qc().initSetting();
    }

    private void dealYYNotification() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2012100, new ab(this));
        aVar.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
    }

    public String getCuid() {
        if (com.baidu.adp.lib.util.m.isEmpty(this.mCuid)) {
            initCuid();
        }
        return this.mCuid;
    }

    protected void InitVersion() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
            TbConfig.setVersionType(com.baidu.adp.lib.g.c.toInt(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
        } catch (Exception e) {
            TbConfig.setVersionType(3);
            BdLog.e(e.getMessage());
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
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void saveString(String str, String str2) {
        com.baidu.tbadk.core.sharedPref.b.sl().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return com.baidu.tbadk.core.sharedPref.b.sl().getString(str, str2);
    }

    protected int loadInt(String str, int i) {
        return com.baidu.tbadk.core.sharedPref.b.sl().getInt(str, i);
    }

    protected void saveInt(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.sl().putInt(str, i);
    }

    protected long loadLong(String str, long j) {
        return com.baidu.tbadk.core.sharedPref.b.sl().getLong(str, j);
    }

    protected void saveLong(String str, long j) {
        com.baidu.tbadk.core.sharedPref.b.sl().putLong(str, j);
    }

    public static String getClientId() {
        return clientId;
    }

    public void removeClientId(Context context) {
        com.baidu.tbadk.core.sharedPref.b.sl().remove("client_id");
    }

    public static void saveClientId(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.core.sharedPref.b.sl().putString("client_id", String.valueOf(TbConfig.getVersion()) + "\t" + str);
        }
    }

    public static void setClientId(String str) {
        clientId = str;
    }

    protected void initImei() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService("phone");
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
        if (com.baidu.adp.lib.util.m.isEmpty(this.mImei)) {
            initImei();
        }
        return this.mImei;
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
            File cB = com.baidu.tbadk.core.util.o.cB(TbConfig.FROM_FILE);
            if (cB != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(cB));
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
                File cD = com.baidu.tbadk.core.util.o.cD(TbConfig.FROM_FILE);
                if (cD != null) {
                    FileWriter fileWriter = new FileWriter(cD);
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

    /* JADX WARN: Removed duplicated region for block: B:94:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
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

    public String readClientId(Context context) {
        String loadString = loadString("client_id", null);
        if (loadString != null) {
            int indexOf = loadString.indexOf("\t");
            if (indexOf != -1) {
                if (TbConfig.getVersion().equals(loadString.substring(0, indexOf))) {
                    return loadString.substring(indexOf + 1);
                }
                removeClientId(getContext());
                return null;
            }
            removeClientId(getContext());
            return null;
        }
        return loadString;
    }

    protected String createRandomString(String str, int i) {
        StringBuilder sb = new StringBuilder(i);
        if (str != null) {
            sb.append(str);
        }
        sb.append(com.baidu.adp.lib.util.z.ju());
        if (sb.length() > i) {
            sb.setLength(i);
        }
        return sb.toString();
    }

    protected void initCuid() {
        this.mCuid = loadString("cuid", null);
        if (this.mCuid == null || this.mCuid.length() <= 0) {
            this.mCuid = CommonParam.getCUID(getContext());
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

    public void initSetting() {
        this.mGpuOpen = TbadkSettings.getInst().loadBoolean("gpu_open", shouldGPUOn());
        this.mUseHttpClient = TbadkSettings.getInst().loadBoolean("httpclient", true);
        this.mPromotedMessageOn = TbadkSettings.getInst().loadBoolean("permoted_message", true);
        this.mWebviewCrashCount = TbadkSettings.getInst().loadInt("webview_crash_count", 0);
        this.mIsAppOn = TbadkSettings.getInst().loadBoolean("app_switcher", false);
        this.mNewVcodeWebviewCrashCount = TbadkSettings.getInst().loadInt("new_vcode_webview_crash_count", 0);
        this.mIsLocationOn = TbadkSettings.getInst().loadBoolean("location_on", true);
        m411getInst().setIsLocationON(this.mIsLocationOn);
        this.mIsExitAppCloseWebSocket = TbadkSettings.getInst().loadBoolean("is_exit_app_not_start_websocket", false);
        this.mFaceShopVersion = TbadkSettings.getInst().loadInt("faceshop_version", -1);
    }

    public boolean isPromotedMessageOn() {
        return this.mPromotedMessageOn;
    }

    public int getWebviewCrashCount() {
        return this.mWebviewCrashCount;
    }

    public void addBDLocCrashCount() {
        int loadInt = TbadkSettings.getInst().loadInt("bd_loc_crash_count", 0) + 1;
        TbadkSettings.getInst().saveInt("bd_loc_crash_count", loadInt);
        if (loadInt > 3) {
            setBDLocON(false);
        }
    }

    public void setBDLocON(boolean z) {
        com.baidu.adp.lib.d.a.gK().y(z);
        TbadkSettings.getInst().saveBoolean("bd_loc_switcher", z);
    }

    public void incMoPlusCrashCount() {
        String str = "moplus_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incLiveSdkCrashCount() {
        String str = "live_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incBaobaoCrashCount() {
        String str = "baobao_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incDQCrashCount() {
        String str = "dq_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void setIsAppOn(boolean z) {
        TbadkSettings.getInst().saveBoolean("app_switcher", z);
        this.mIsAppOn = z;
    }

    public boolean getIsAppOn() {
        return this.mIsAppOn;
    }

    public void setWebviewCrashCount(int i) {
        this.mWebviewCrashCount = i;
        TbadkSettings.getInst().saveInt("webview_crash_count", i);
    }

    public void setPromotedMessage(boolean z) {
        this.mPromotedMessageOn = z;
        TbadkSettings.getInst().saveBoolean("permoted_message", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
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
        ActivityManager activityManager = (ActivityManager) m411getInst().getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            String packageName = m411getInst().getPackageName();
            String str = String.valueOf(packageName) + ":cdnTachometer";
            String str2 = String.valueOf(packageName) + ":daemon";
            String str3 = String.valueOf(packageName) + ":remote";
            String[] strArr = {str3, str, String.valueOf(packageName) + ":bdservice_v1", String.valueOf(packageName) + ":live", String.valueOf(packageName) + ":cdnTachometer", str2};
            int myPid = Process.myPid();
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                if (runningAppProcesses.get(i).pid == myPid) {
                    String str4 = runningAppProcesses.get(i).processName;
                    if (str4 != null) {
                        if (str4.equalsIgnoreCase(str2)) {
                            this.isDaemonProcess = true;
                        }
                        if (str4.equalsIgnoreCase(packageName)) {
                            this._isMainProcess = Boolean.TRUE;
                            return true;
                        }
                        if (str4.equalsIgnoreCase(str)) {
                            this.isCdnTachometerProcess = Boolean.TRUE;
                        }
                        if (str4.equalsIgnoreCase(str3)) {
                            this.isRemoteProcess = true;
                        }
                        for (String str5 : strArr) {
                            if (str4.equalsIgnoreCase(str5)) {
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

    public com.baidu.tbadk.a.a getAlarmManager() {
        return this.alarm;
    }

    public static String getCurrentAccount() {
        if (mAccount != null) {
            return mAccount.getID();
        }
        return null;
    }

    public static String getCurrentBduss() {
        if (mAccount != null) {
            return mAccount.getBDUSS();
        }
        return null;
    }

    public static String getCurrentTbs() {
        if (mAccount != null) {
            return mAccount.getTbs();
        }
        return null;
    }

    public static void setCurrentAccount(AccountData accountData, Context context) {
        if (com.baidu.adp.lib.util.n.jl()) {
            setCurrentAccountInUI(accountData, context);
        } else {
            m411getInst().handler.post(new ac(accountData, context));
        }
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
            if (m411getInst().isPushServiceOpen()) {
                UtilHelper.startPushService(context);
            } else {
                UtilHelper.stopPushService(context);
            }
            if (m411getInst().isMoPlusOpen()) {
                UtilHelper.startMoPlusService(context);
            }
        }
        sendAccountChangedBroadcast(accountData);
        if (isChangeAccount) {
            m411getInst().onAccountChanged(accountData, m411getInst().getApp());
            BdSocketLinkService.setHasAbsoluteClose(false);
            BdSocketLinkService.setAvailable(true);
            BdSocketLinkService.startService(true, "account changed");
        }
        com.baidu.tbadk.editortool.aa.zF().zG();
        if (accountData != null && !TextUtils.isEmpty(accountData.getID())) {
            sendLiveSync(accountData.getID());
        }
    }

    private static void sendLiveSync(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2016205, str));
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
        com.baidu.adp.lib.stats.f.hz().f(str2, str, str3);
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
        intent2.setAction("adp.bdstatisticsmanager.account_changed");
        intent2.putExtra("intent_data_userid", str);
        intent2.putExtra("intent_data_username", str2);
        intent2.putExtra("intent_data_bduss", getCurrentBduss());
        try {
            m411getInst().getApp().sendStickyBroadcast(intent2);
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
        Intent intent3 = new Intent();
        intent3.setAction(ACCOUNT_CHANGE_ACTION);
        m411getInst().getApp().sendBroadcast(intent3);
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

    public static void setCurrentBduss(String str) {
        boolean z = true;
        if (mAccount != null) {
            if (str != null ? str.equals(mAccount.getBDUSS()) : mAccount.getBDUSS() == null) {
                z = false;
            }
            mAccount.setBDUSS(str);
            if (z) {
                m411getInst().onAccountChanged(mAccount, m411getInst().getApp());
            }
        }
    }

    public static void reportLocation() {
        long loadLong = TbadkSettings.getInst().loadLong("last_enter_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (loadLong == 0 || currentTimeMillis - loadLong >= 600000) {
            m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Nz, 1, System.currentTimeMillis(), 3600000L);
            BdLog.e("last enter:" + loadLong + "大于10分钟，立刻上报");
        } else {
            BdLog.e("last enter:" + loadLong + "小于10分钟，10分钟后上报");
            m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Nz, 1, System.currentTimeMillis() + 600000, 600000L);
        }
        TbadkSettings.getInst().saveLong("last_enter_time", currentTimeMillis);
    }

    protected void onAccountChanged(AccountData accountData, Application application) {
        BdLog.e("账号切换");
        reportLocation();
        MessageManager.getInstance().sendMessage(new CustomMessage(2005006, accountData));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005016, accountData));
    }

    public static boolean isLogin() {
        String currentAccount = getCurrentAccount();
        return currentAccount != null && currentAccount.length() > 0;
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    public void setSkinTypeValue(int i) {
        this.mSkinType = i;
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

    public void setIsPushServiceOpen(boolean z) {
        saveBoolean("push_service", z);
    }

    public boolean isPushServiceOpen() {
        return loadBoolean("push_service", true);
    }

    public boolean isMoPlusOpen() {
        return loadBoolean("moplus_service", true);
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

    protected boolean loadBoolean(String str, boolean z) {
        return com.baidu.tbadk.core.sharedPref.b.sl().getBoolean(str, z);
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

    public boolean getLocationShared() {
        return TbadkSettings.getInst().loadBoolean("location_shared_" + getCurrentAccount(), true);
    }

    public void setLocationShared(boolean z) {
        TbadkSettings.getInst().saveBoolean("location_shared_" + getCurrentAccount(), z);
        if (z) {
            m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Nz, 1, System.currentTimeMillis(), m411getInst().getAlarmManager().po());
        } else {
            m411getInst().getAlarmManager().cancel();
        }
    }

    public boolean isVoiceLoginOn(String str) {
        return TbadkSettings.getInst().loadBoolean("voice_login_switch" + str, false);
    }

    public void setVoiceLoginOn(boolean z) {
        TbadkSettings.getInst().saveBoolean("voice_login_switch" + getCurrentAccountName(), z);
    }

    public int getNewVcodeWebviewCrashCount() {
        return this.mNewVcodeWebviewCrashCount;
    }

    public void setNewVcodeWebviewCrashCount(int i) {
        this.mNewVcodeWebviewCrashCount = i;
    }

    public void setIsLocationON(boolean z) {
        this.mIsLocationOn = z;
        TbadkSettings.getInst().saveBoolean("location_on", z);
    }

    public boolean getIsLocationOn() {
        return this.mIsLocationOn;
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

    public void setHasNewVersion(boolean z) {
        this.mHasNewVersion = z;
    }

    public boolean getHasNewVersion() {
        return this.mHasNewVersion;
    }

    public void setCombineDownload(CombineDownload combineDownload) {
        this.mCombineDownload = combineDownload;
    }

    public CombineDownload getCombineDownload() {
        return this.mCombineDownload;
    }

    public boolean isPassportV6ShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("passport_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.f.gD().ai("switch_login_passv6") != 1;
    }

    public int getFeatureCrashAutoCloseLimit() {
        return Math.max(TbadkSettings.getInst().loadInt("feature_crash_auto_close_limit", 3), 3);
    }

    public void setFeatureCrashAutoCloseLimit(int i) {
        TbadkSettings.getInst().saveInt("feature_crash_auto_close_limit", i);
    }

    public void addRemoteActivity(BaseActivity<?> baseActivity) {
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

    public void delRemoteActivity(BaseActivity<?> baseActivity) {
        if (this.mRemoteActivity != null) {
            this.mRemoteActivity.remove(baseActivity);
        }
    }

    public String getVersionName() {
        try {
            if (getContext().getPackageManager() == null || getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0) == null) {
                return null;
            }
            return getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public int getVersionCode() {
        try {
            if (getContext().getPackageManager() == null || getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0) == null) {
                return 0;
            }
            return getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
            return 0;
        }
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

    private void initWebsocketBase(Context context) {
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new p(this));
        int[] imTimeOut = getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            com.baidu.adp.framework.c.c.eX().e(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            com.baidu.adp.framework.client.socket.l.a(socketReconnStratgy);
        }
        PingManager.yt().initial();
        MessageManager.getInstance().getSocketClient().a(PingManager.yt());
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tbadk.coreExtra.websocketBase.y());
        try {
            com.baidu.adp.framework.client.socket.coder.d.eL().i(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        com.baidu.tbadk.coreExtra.websocketBase.v.yB().init();
        com.baidu.tbadk.coreExtra.websocketBase.q.yx().init();
        initSocket();
    }

    public com.baidu.adp.widget.a.a getFace(String str) {
        SoftReference<com.baidu.adp.widget.a.a> softReference = this.mFaces.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.a.a eG = TbFaceManager.Al().eG(str);
        if (eG != null) {
            this.mFaces.put(str, new SoftReference<>(eG));
            return eG;
        }
        return eG;
    }

    private static void initSocket() {
        com.baidu.tbadk.task.b registerImScoketTask = registerImScoketTask(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.k(false);
        registerImScoketTask.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", getUniqueIdentifier()));
        String yh = com.baidu.tbadk.coreExtra.websocketBase.a.yf().yh();
        if (TextUtils.isEmpty(yh)) {
            com.baidu.adp.framework.client.socket.l.setUrl(TiebaIMConfig.url);
        } else {
            com.baidu.adp.framework.client.socket.l.setUrl(yh);
        }
        com.baidu.adp.framework.client.socket.l.K(TiebaIMConfig.wsExtensions);
        com.baidu.adp.framework.client.socket.l.e(arrayList);
        BdSocketDaemonService.setLinkServiceDisconnectCallBack(new q());
        BdSocketLinkService.init();
        BdSocketLinkService.startService(false, "TiebaImApplication init");
    }

    public static synchronized String getUniqueIdentifier() {
        String str;
        synchronized (TbadkCoreApplication.class) {
            if (mUniqueId == null) {
                String cuid = m411getInst().getCuid();
                String packageName = m411getInst().getApp().getPackageName();
                mUniqueId = String.valueOf(cuid) + "|" + packageName + TbConfig.getVersion();
            }
            str = mUniqueId;
        }
        return str;
    }

    private static com.baidu.tbadk.task.b registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.setResponsedClass(cls);
        bVar.j(z);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
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

    public void loadLcsSwitchStratgy() {
        String loadString = TbadkSettings.getInst().loadString("lcs_switch_strategy", null);
        if (!TextUtils.isEmpty(loadString)) {
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.parserJson(loadString);
            com.baidu.tbadk.coreExtra.websocketBase.h yq = com.baidu.tbadk.coreExtra.websocketBase.h.yq();
            yq.aP(eVar.wE() == 1);
            yq.dr(eVar.wF());
            yq.v(eVar.wG() * 1000);
            this.lcsTimeout2G = eVar.getLcsTimeout2G();
            this.lcsTimeout3G = eVar.getLcsTimeout3G();
            this.lcsTimeoutwifi = eVar.getLcsTimeoutwifi();
            if (eVar.wH() != null) {
                yq.b(eVar.wH());
            }
        }
    }

    public int getLcsTimeout2G() {
        return this.lcsTimeout2G;
    }

    public int getLcsTimeout3G() {
        return this.lcsTimeout3G;
    }

    public int getLcsTimeoutwifi() {
        return this.lcsTimeoutwifi;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005f  */
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
            if (Build.VERSION.SDK_INT >= 14 && (assets = m411getInst().getContext().getAssets()) != null) {
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

    public boolean getCapabilityOfWebp() {
        return this.mCapableOfWebp;
    }

    public boolean isMIUIRom() {
        String str = Build.MANUFACTURER;
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.equalsIgnoreCase("xiaomi");
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

    public void incWebpFailureCount() {
        int loadInt = TbadkSettings.getInst().loadInt("webp_failure_count", 0) + 1;
        if (loadInt > 5) {
            this.mCapableOfWebp = false;
            TbadkSettings.getInst().saveBoolean("capable_of_webp_format", false);
            return;
        }
        TbadkSettings.getInst().saveInt("webp_failure_count", loadInt);
    }

    public boolean isOfficial() {
        return this.mIsOfficial;
    }

    public int getNetWorkCoreType() {
        return loadInt("networkcore_type", 1);
    }

    public void setNetWorkCoreType(int i) {
        ae.bY(i);
        saveInt("networkcore_type", i);
    }

    public long getLastNotifyTime() {
        return TbadkSettings.getInst().loadLong("last_notify_sound_time", 0L);
    }

    public void setLastNotifyTime(long j) {
        TbadkSettings.getInst().saveLong("last_notify_sound_time", j);
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

    public boolean isDQShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("dq_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit();
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

    public boolean getIsPhoneCalling() {
        return this.isPhoneCalling;
    }

    private void registerPhoneListener() {
        try {
            ((TelephonyManager) m411getInst().getApp().getSystemService("phone")).listen(new ad(this, null), 32);
        } catch (SecurityException e) {
        }
    }

    public void sendImagePv(int i, int i2, String str) {
        if (this.imagePvThread == null) {
            this.imagePvThread = Executors.newSingleThreadExecutor();
        }
        com.baidu.tbadk.util.k kVar = new com.baidu.tbadk.util.k(i, i2);
        kVar.setType(str);
        this.imagePvThread.execute(kVar);
        TiebaStatic.eventStat(m411getInst().getApp(), "img_browse", null, 1, "img_num", Integer.valueOf(i), "img_total", Integer.valueOf(i2), "img_type", str);
    }

    public void onUserChanged() {
        if (!com.baidu.adp.lib.util.n.isNetOk()) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001253));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2005007));
        com.baidu.tbadk.coreExtra.messageCenter.a.vJ().av(true);
        com.baidu.tieba.tbadkCore.util.j.apC();
    }

    public void incPassportV6CrashCount() {
        String str = "passport_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void setActiveVersion(String str) {
        if (!bb.isEmpty(str) && !"null".equals(str)) {
            com.baidu.tbadk.core.util.p.cM("/package.last");
            com.baidu.tbadk.core.util.p.cL("/package.last/" + str);
        }
    }

    public boolean getIsFirstUse() {
        if (com.baidu.tbadk.core.util.p.cK("/package.cur/" + TbConfig.getVersion())) {
            return false;
        }
        setActiveVersion(com.baidu.tbadk.core.util.p.cN("/package.cur"));
        return true;
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

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void setLocationPos(String str) {
        TbadkSettings.getInst().saveString("location_pos", str);
    }

    public String getLocationPos() {
        return TbadkSettings.getInst().loadString("location_pos", "");
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

    public int getEnterForeCount() {
        return this.mEnterForeCount;
    }

    public void clearEnterForeCount() {
        this.mEnterForeCount = 0;
    }

    public void clearLikeForum() {
        if (this.mHasLikeList != null) {
            this.mHasLikeList.clear();
        }
    }

    public void delLikeForum(String str) {
        if (this.mHasLikeList != null && str != null) {
            this.mHasLikeList.put(str, -1);
            setLikeBarChanged(true);
            if (this.mHasLikeList.size() > 200) {
                this.mHasLikeList.clear();
            }
        }
    }

    public void initLikeForum() {
        if (this.mHasLikeList == null) {
            this.mHasLikeList = new Hashtable<>();
        }
    }

    public int hasLikeForum(String str) {
        if (this.mHasLikeList == null || str == null || !this.mHasLikeList.containsKey(str)) {
            return 0;
        }
        return this.mHasLikeList.get(str).intValue();
    }

    public void addLikeForum(String str) {
        if (this.mHasLikeList != null && str != null) {
            this.mHasLikeList.put(str, 1);
            setLikeBarChanged(true);
            if (this.mHasLikeList.size() > 200) {
                this.mHasLikeList.clear();
            }
        }
    }

    public void setLikeBarChanged(boolean z) {
        this.mLikeChanged = z;
    }

    public boolean getLikeBarChanged() {
        return this.mLikeChanged;
    }

    public boolean hasSignedForum(String str) {
        return (this.mHasSignList == null || str == null || !this.mHasSignList.containsKey(str)) ? false : true;
    }

    public void addSignedForum(String str, int i, int i2) {
        if (!hasSignedForum(str) && this.mHasSignList != null && str != null) {
            if (this.mHasSignList.size() > 100) {
                this.mHasSignList.clear();
                this.mSignLevelUpList.clear();
            }
            this.mHasSignList.put(str, Integer.valueOf(i));
            this.mSignLevelUpList.put(str, Integer.valueOf(i2));
        }
    }

    public void clearSignedForum() {
        if (this.mHasSignList != null) {
            this.mHasSignList.clear();
        }
        if (this.mSignLevelUpList != null) {
            this.mSignLevelUpList.clear();
        }
    }

    public int getSignedForumIncreaseCount(String str) {
        if (hasSignedForum(str)) {
            return this.mHasSignList.get(str).intValue();
        }
        return 0;
    }

    public int getSignLevelUpValue(String str) {
        if (hasSignedForum(str)) {
            return this.mSignLevelUpList.get(str).intValue();
        }
        return -1;
    }

    public int signedForumCount() {
        if (this.mHasSignList != null) {
            return this.mHasSignList.size();
        }
        return 0;
    }

    public int likeForumCount() {
        if (this.mHasSignList != null) {
            return this.mHasSignList.size();
        }
        return 0;
    }

    public void delSignedForum(String str) {
        if (hasSignedForum(str) && this.mHasSignList != null && str != null) {
            this.mHasSignList.remove(str);
            this.mSignLevelUpList.remove(str);
        }
    }

    public void initSignedForum() {
        if (this.mHasSignList == null) {
            this.mHasSignList = new Hashtable<>();
        }
        if (this.mSignLevelUpList == null) {
            this.mSignLevelUpList = new Hashtable<>();
        }
    }

    public void setSkinType(int i) {
        resetCacheData();
        m411getInst().setSkinTypeValue(i);
        TbadkSettings.getInst().saveInt("skin", i);
        SendSkinTypeBroadcast(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001311, Integer.valueOf(i)));
    }

    private void SendSkinTypeBroadcast(int i) {
        Intent intent2 = new Intent();
        intent2.setAction(com.baidu.tbadk.data.b.getBroadcastActionChangeSkin());
        intent2.putExtra(TbConfig.BROADCAST_FIELD_SKIN_TYPE, i);
        m411getInst().getContext().sendBroadcast(intent2);
    }

    public static void resetCacheData() {
        com.baidu.adp.lib.g.l.ht().c(new s());
        com.baidu.tbadk.core.sharedPref.b.sl().putLong("app_inverval", System.currentTimeMillis());
    }

    public static String getCurrentPortrait() {
        AccountData currentAccountObj = getCurrentAccountObj();
        if (currentAccountObj == null) {
            return null;
        }
        return currentAccountObj.getPortrait();
    }

    public String getLocationLat() {
        return TbadkSettings.getInst().loadString("location_lat", "");
    }

    public void setLocationLng(String str) {
        TbadkSettings.getInst().saveString("location_lng", str);
    }

    public boolean isBaobaoShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("baobao_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.f.gD().ai("switch_baobao") == 1;
    }

    public boolean isFaceShopNew() {
        return this.isFaceShopNew;
    }

    public void setFaceShopNew(boolean z) {
        this.isFaceShopNew = z;
    }

    public String getLocationLng() {
        return TbadkSettings.getInst().loadString("location_lng", "");
    }

    public boolean isProcessBackground() {
        return this.isBackground;
    }

    public void setProcesBackground(boolean z) {
        this.isBackground = z;
    }

    public void setTempFaceShopVersion(int i) {
        this.mTempFaceShopVersion = i;
    }

    public int getTempFaceShopVersion() {
        return this.mTempFaceShopVersion;
    }

    public int getFaceShopVersion() {
        return this.mFaceShopVersion;
    }

    public void setFaceShopVersion(int i) {
        this.mFaceShopVersion = i;
        TbadkSettings.getInst().saveInt("faceshop_version", this.mFaceShopVersion);
    }

    public boolean isRecAppExist() {
        return this.isRecAppExist;
    }

    public void setRecAppExist(boolean z) {
        this.isRecAppExist = z;
    }

    public boolean isLbsWebViewSwitchOn() {
        return com.baidu.adp.lib.b.f.gD().ai("android_lbs_webview_open") != 0;
    }

    public String getCheckUrl() {
        return this.checkUrl;
    }

    public void setCheckUrl(String str) {
        this.checkUrl = str;
    }

    public String getActiveVersion() {
        String cN;
        if (!com.baidu.tbadk.core.util.p.cK("/package.last")) {
            cN = TbadkSettings.getInst().loadString("active_version", "");
        } else {
            cN = com.baidu.tbadk.core.util.p.cN("/package.last");
        }
        if (ACTIVE_CLEAR_TAG.equals(cN)) {
            return null;
        }
        return cN;
    }

    public void clearActiveVersion() {
        setActiveVersion(ACTIVE_CLEAR_TAG);
    }

    public String getConfigVersion() {
        return this.mConfigVersion;
    }

    public void setConfigVersion(String str) {
        this.mConfigVersion = str;
    }

    public void startClearTempService() {
        try {
            getContext().startService(new Intent(getContext(), ClearTempService.class));
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public int getPerformSampleCount() {
        return this.mPerformSampleCount;
    }

    public void setPerformSampleCount(int i) {
        this.mPerformSampleCount = i;
        TbadkSettings.getInst().saveInt("perform_sample_count", i);
    }

    public VersionData getVersionData() {
        return this.mVersionData;
    }

    public void setVersionData(VersionData versionData) {
        this.mVersionData = versionData;
    }

    public boolean isGiftSwitchOn() {
        return com.baidu.adp.lib.b.f.gD().ai("offline_gift") != 1;
    }

    public void setInstallOtherApp(String str) {
        TbadkSettings.getInst().saveString("install_other_app_file_name", str);
    }

    public String getInstallOtherApp() {
        return TbadkSettings.getInst().loadString("install_other_app_file_name", null);
    }

    public void setUpdateNotifyTime(long j) {
        TbadkSettings.getInst().saveLong("update_notify_time", j);
    }

    public long getUpdateNotifyTime() {
        return TbadkSettings.getInst().loadLong("update_notify_time", 0L);
    }

    public void startSyncService() {
        getContext().startService(new Intent(getContext(), TiebaSyncService.class));
    }

    public void stopSyncService() {
        getContext().stopService(new Intent(getContext(), TiebaSyncService.class));
    }

    public void startSyncLoginService() {
        getContext().startService(new Intent(getContext(), SyncLoginService.class));
    }

    public void startActiveService() {
        getContext().startService(new Intent(getContext(), TiebaActiveService.class));
    }

    public void stopActiveServide() {
        getContext().stopService(new Intent(getContext(), TiebaActiveService.class));
    }

    public void setLcsSwitchStratgy(String str) {
        if (str == null) {
            str = "";
        }
        TbadkSettings.getInst().saveString("lcs_switch_strategy", str);
    }

    public void upgradeAbstractOnInMemory(int i) {
        this.mIsAbstractOn = i;
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
            if (com.baidu.adp.lib.util.k.iY()) {
                return true;
            }
        } else if (this.mIsAbstractOn == 1) {
            return true;
        }
        return false;
    }

    public void setFirstSyncImageQuality(boolean z) {
    }

    public void setSocketReconnStratgy(String str) {
        TbadkSettings.getInst().saveString("socket_reconn_strategy", str);
    }

    public void setSocketHeartBeatStratgy(String str) {
        TbadkSettings.getInst().saveString("socket_heartbeat_strategy", str);
    }

    public void setSocketGetMsgStratgy(String str) {
        TbadkSettings.getInst().saveString("socket_getmsg_strategy", str);
    }

    public void setImTimeOut(int[] iArr) {
        if (iArr != null && iArr.length == 3) {
            StringBuilder sb = new StringBuilder(20);
            for (int i : iArr) {
                sb.append(i);
                sb.append("|");
            }
            TbadkSettings.getInst().saveString("socket_time_out", sb.toString());
            com.baidu.adp.framework.c.c.eX().e(iArr[0], iArr[1], iArr[2]);
        }
    }

    public String getYijianfankuiFname() {
        return this.mYijianfankuiFname;
    }

    public void setYijianfankuiFname(String str) {
        this.mYijianfankuiFname = str;
    }

    public boolean getFirstSyncImageQuality() {
        return TbadkSettings.getInst().loadBoolean("first_sync_image_quality", true);
    }

    public boolean isFloatingWindowOpened() {
        return com.baidu.adp.lib.b.f.gD().ai("android_im_bubble_open") == 1;
    }

    public void setLocationLat(String str) {
        TbadkSettings.getInst().saveString("location_lat", str);
    }

    public long getReporyUserInfoLastTime() {
        return TbadkSettings.getInst().loadLong("report_user_info_time_key" + getCurrentAccount(), 0L);
    }

    public void setReporyUserInfoCurrentTime() {
        TbadkSettings.getInst().saveLong("report_user_info_time_key" + getCurrentAccount(), System.currentTimeMillis());
    }

    public boolean checkNeedShowNewVersionFlag() {
        return this.mNeedShowNewVersion;
    }

    public void refreshNewVersion(boolean z) {
        this.mNeedShowNewVersion = z;
        getApp().sendBroadcast(new Intent(TbConfig.getBroadcastActionNewVersion()));
    }

    public static void setRefreshFlag(boolean z) {
        isNeedRefreshOnResume = z;
    }

    public static boolean getRefreshFlag() {
        return isNeedRefreshOnResume;
    }

    public void setIsNewRegUser(boolean z) {
        this.mIsNewRegUser = z;
    }

    public boolean getIsNewRegUser() {
        return this.mIsNewRegUser;
    }

    public void setUsed() {
        com.baidu.tbadk.core.util.p.cM("/package.cur");
        com.baidu.tbadk.core.util.p.cL("/package.cur/" + TbConfig.getVersion());
    }

    public com.baidu.tieba.tbadkCore.util.l getReadThreadHistory() {
        return this.mReadThreadHistory;
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

    public boolean isShowSwipeBackGuide() {
        return TbadkSettings.getInst().loadBoolean("show_swipe_back_key", true);
    }

    public void setShowSwipeBackGuide(boolean z) {
        TbadkSettings.getInst().saveBoolean("show_swipe_back_key", z);
    }

    public void setPersonChangeData(PersonChangeData personChangeData) {
        this.mPersonChangeData = personChangeData;
    }

    public PersonChangeData getPersonChangeData() {
        return this.mPersonChangeData;
    }

    public boolean cashNoAccountData(String str, int i) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.a("delete from cash_data where type=?", new String[]{String.valueOf(i)});
        return mainDBDatabaseManager.a("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
    }

    public void deleteAccountAllInfo(String str) {
        if (str != null) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.a("delete from cash_data where account=?", new String[]{str});
            mainDBDatabaseManager.a("delete from mark_data where account=?", new String[]{str});
            mainDBDatabaseManager.a("delete from draft_box where account=?", new Object[]{str});
            mainDBDatabaseManager.a("delete from account_data where id=?", new Object[]{str});
            mainDBDatabaseManager.a("delete from setting where account=?", new Object[]{str});
        }
    }

    public String getNoAccountData(int i) {
        Cursor cursor;
        Throwable th;
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from cash_data where type=? ", new String[]{String.valueOf(i)});
            try {
                try {
                    r0 = cursor.moveToFirst() ? cursor.getString(2) : null;
                    com.baidu.adp.lib.g.a.b(cursor);
                } catch (Exception e) {
                    e = e;
                    mainDBDatabaseManager.a(e, "getNoAccountData");
                    com.baidu.adp.lib.g.a.b(cursor);
                    return r0;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.b(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.g.a.b(cursor);
            throw th;
        }
        return r0;
    }

    public void incCrabSdkCrashCount() {
        String str = "crab_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isCrabSdkShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("crab_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.f.gD().ai("switch_crab_sdk") == 1;
    }

    private boolean isCrabSdkCrashUp2Limit() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("crab_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) > getFeatureCrashAutoCloseLimit();
    }

    public void incXiaomiPushSdkCrashCount() {
        String str = "xiaomi_push_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isXiaomiPushSdkShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("xiaomi_push_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.f.gD().ai("switch_xiaomipush_sdk") != 0;
    }

    public boolean appResponseToCmd(int i) {
        return MessageManager.getInstance().findTask(i) != null;
    }

    public j getCustomizedFilter() {
        return this.mCustomizedFilter;
    }

    public void setCustomizedFilter(j jVar) {
        if (this.mCustomizedFilter != null) {
            BdLog.e("you cannot set CustomizedFilter again");
        }
        if (jVar != null) {
            if (jVar.be(2) && !jVar.be(-1)) {
                BdLog.e("you should add CustomGroupType.PERSONAL_GROUP in the filter");
            }
            if (jVar.be(4) && !jVar.be(-9)) {
                BdLog.e("you should add CustomGroupType.OFFICIAL_GROUP in the filter");
            }
        }
        this.mCustomizedFilter = jVar;
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        onAppMemoryLow();
        super.onLowMemory();
    }

    public boolean isVoiceLoginCanUse() {
        return false;
    }

    public boolean isImmersiveStickyCanUse() {
        return com.baidu.adp.lib.b.f.gD().ai("android_chenjinshi_switch") != 0;
    }

    @Override // com.baidu.adp.base.BdBaseApplication
    public void onAppMemoryLow() {
        int An = com.baidu.tbadk.imageManager.e.Am().An();
        int max = (int) Math.max(An * 0.8d, TbConfig.getBigImageMaxUsedMemory());
        if (max < An) {
            BdLog.isDebugMode();
            com.baidu.tbadk.imageManager.e.Am().dM(max);
        }
        com.baidu.tbadk.core.util.c.iL();
        com.baidu.adp.lib.util.e.iK().iL();
    }

    public com.baidu.tbadk.coreExtra.data.g getListItemRule() {
        if (this.listItemRule == null) {
            this.listItemRule = new com.baidu.tbadk.coreExtra.data.g();
        }
        return this.listItemRule;
    }

    public boolean isRunInFrontend() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) m411getInst().getApp().getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() == 0) {
            return false;
        }
        return runningTasks.get(0).baseActivity.getPackageName().equals(getPackageName());
    }

    @Override // com.baidu.adp.base.b
    public void onActivityClosed() {
        m411getInst().onLowMemory();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2002014));
    }

    private void initCustomToastView() {
        if (this.mToast == null && com.baidu.adp.lib.util.n.jq() == null) {
            this.mToast = new t(this, com.baidu.adp.lib.g.b.hr().inflate(getApplicationContext(), com.baidu.tieba.r.custom_toast_textview, null));
            com.baidu.adp.lib.util.n.a(this.mToast);
        }
    }
}
