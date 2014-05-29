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
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.android.common.util.CommonParam;
import com.baidu.bdcvf.CertVerifier;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.tbadk.core.atomData.x;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.util.LimitList;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.d.m;
import com.baidu.tbadk.coreExtra.d.p;
import com.baidu.tbadk.coreExtra.d.q;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
import com.baidu.tbadk.editortool.ac;
import com.baidu.tbadk.editortool.w;
import com.baidu.tbadk.imageManager.TbFaceManager;
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
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class TbadkApplication extends BdBaseApplication {
    public static final int APP_ENTER_FORE_SEND_PV_INTERNAL = 3600000;
    public static final int APP_ENTER_FORE_SWITCH = 5;
    public static final int APP_EVENT_LOGIN = 1;
    public static final int APP_PV_STAT = 4;
    private static final String CUSTOM_THEME_URL = "file:///android_asset/sapi_theme/style.css";
    protected static final String DEFAULT_IMEI = "000000000000000";
    public static final int MEMORY_FOURM_COUNT = 50;
    protected Boolean _isMainProcess;
    public SharedPreferences sp;
    private String tShopUrl;
    protected static TbadkApplication sApp = null;
    protected static boolean IS_APP_RUNNING = false;
    protected static String mUniqueId = null;
    protected static AccountData mAccount = null;
    protected static String clientId = null;
    private static Intent intent = null;
    private static String mForumName = "armcv";
    protected int mSkinType = 0;
    protected int mResumeNum = 0;
    protected long mStartTime = 0;
    protected AtomicBoolean isInBackground = null;
    protected LimitList mHasShowAppForums = null;
    protected boolean mIsUseBaiduStatOn = true;
    protected int mEnterForeCount = 0;
    protected long mLastSendEnterForePvTime = 0;
    protected String mCuid = null;
    protected String mImei = null;
    protected boolean mIsOfficial = true;
    private int mFontSize = 3;
    private final HashMap<Class<?>, Class<?>> mActicyConfig = new HashMap<>();
    public ArrayList<BaseActivity> mRemoteActivity = null;
    private Hashtable<String, Integer> mFrsImageForums = null;
    public boolean mMsgChatOn = true;
    public int mMsgFrequency = 0;
    public boolean mMsgFansOn = true;
    public boolean mMsgAtmeOn = true;
    public boolean mMsgReplymeOn = true;
    public boolean mMsgZanOn = true;
    public int mViewImageQuality = 0;
    public boolean mRemindVibrateOn = false;
    public boolean mRemindToneOn = true;
    public boolean mNoDisturbOn = false;
    public String mNoDisturbStartTime = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String mNoDisturbEndTime = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;
    private boolean mGpuOpen = false;
    private boolean mPromotedMessageOn = true;
    private int mWebviewCrashCount = 0;
    private long mLaunchTime = -1;
    private int mIsAbstractOn = 1;
    private int mVoiceHeadsetMode = 0;
    private final Handler mHandler = new Handler();
    protected boolean mCapableOfWebp = false;
    public Handler handler = new Handler(new a(this));
    private ExecutorService imagePvThread = null;
    private boolean isFirstGoFrs = false;
    private boolean isFirstGoMaintab = false;
    private boolean isFaceShopNew = false;
    private int mFaceShopVersion = -1;
    private int mTempFaceShopVersion = -1;
    private String mDefaultBubble = null;
    private boolean mNeedShowNewVersion = false;

    public void markLauchTime() {
        this.mLaunchTime = System.currentTimeMillis();
    }

    public void delLauchTime() {
        this.mLaunchTime = -1L;
    }

    public void sendLaunchTime() {
        if (this.mLaunchTime > 0) {
            this.mLaunchTime = System.currentTimeMillis() - this.mLaunchTime;
            if (this.mLaunchTime > 0) {
                new az("startup_time", String.valueOf(this.mLaunchTime));
            }
            BdLog.i(getClass().getName(), "sendLaunchTime=", String.valueOf(this.mLaunchTime));
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
                    BdLog.e(getClass().getName(), "addRemoteActivity", e.getMessage());
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
    public static TbadkApplication m252getInst() {
        return sApp;
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        com.baidu.adp.lib.Disk.d.a().a(TbConfig.getTempDirName());
        com.baidu.tbadk.core.util.h.a();
        init(this);
        com.baidu.tbadk.core.frameworkData.e.a();
        initSapi();
        initAccount();
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new b(this));
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().sendMessage(new CustomMessage(2007003, new x(m252getInst())));
        MessageManager.getInstance().sendMessage(new CustomMessage(2007005, new x(m252getInst())));
    }

    private void initSapi() {
        SapiAccountManager.getInstance().init(new SapiConfiguration.Builder(this).setProductLineInfo("tb", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK, "6e93e7659ae637845c7f83abee68a740").setRuntimeEnvironment(TbConfig.PASS_LOGIN_ADDRESS).registMode(RegistMode.FAST).loginShareStrategy(LoginShareStrategy.CHOICE).skin(CUSTOM_THEME_URL).fastRegConfirm(isNeedConfirm()).fastRegConfirmMsg(getString(y.register_tip)).build());
    }

    public boolean isNeedConfirm() {
        String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
        boolean z = systemProperty != null && "V5".equals(systemProperty);
        String from = getFrom();
        return z || (from != null && from.equalsIgnoreCase(TbConfig.DIALOG_FROM));
    }

    private void initAccount() {
        AccountData c;
        if (isMainProcess(true)) {
            try {
                if (m252getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists() && (c = com.baidu.tbadk.core.account.a.c()) != null) {
                    setCurrentAccount(c, m252getInst());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setIsAbstractOn(int i) {
        this.mIsAbstractOn = i;
        f.a().b("new_abstract_state", i);
    }

    public int getIsAbstractStatus() {
        return this.mIsAbstractOn;
    }

    public boolean getIsAbstract() {
        if (this.mIsAbstractOn == 0) {
            if (bf.a().c()) {
                return true;
            }
        } else if (this.mIsAbstractOn == 1) {
            return true;
        }
        return false;
    }

    public void init(Context context) {
        sApp = this;
        if (!isDebugMode()) {
            CertVerifier.getInstance().verify(this, new c(this));
        }
        this.mHasShowAppForums = new LimitList(50);
        initCuid();
        TbConfig.initBigImageMaxUsedMemory(this);
        clientId = readClientId(this);
        initImei();
        InitVersion();
        InitFrom();
        initSetting();
        initWebsocketBase(context);
        TbFaceManager.a().a(this, new w());
        this.mFontSize = f.a().a("font_size", 2);
        try {
            com.baidu.adp.lib.c.a.a().a(m252getInst(), "tieba");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isMainProcess(true)) {
            try {
                registerReceiver(new NetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        initSettings();
    }

    private void initWebsocketBase(Context context) {
        m.a().d();
        q.a().b();
        initSocket();
    }

    private static void initSocket() {
        com.baidu.tbadk.task.b registerScoketTask = registerScoketTask(MessageTypes.CMD_UPDATE_CLIENT_INFO, ResponseOnlineMessage.class, false);
        registerScoketTask.c(true);
        registerScoketTask.d(false);
        registerScoketTask.a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        registerScoketTask.setPriority(-3);
        com.baidu.tbadk.task.b registerScoketTask2 = registerScoketTask(MessageTypes.CMD_PING, ResponsedPingMessage.class, false);
        registerScoketTask2.c(true);
        registerScoketTask2.d(false);
        registerScoketTask2.a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        registerScoketTask2.setPriority(-3);
        com.baidu.tbadk.message.websockt.c.b().a(MessageTypes.CMD_UPDATE_CLIENT_INFO);
        MessageManager.getInstance().addResponsedMessageRule(new p());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", getUniqueIdentifier()));
        com.baidu.adp.framework.c.c.a().a(h.a);
        com.baidu.adp.framework.c.c.a().b("im_version=2.1");
        com.baidu.adp.framework.c.c.a().a(arrayList);
        com.baidu.adp.framework.c.c.a().a(new com.baidu.tbadk.a.d());
        com.baidu.adp.framework.c.c.a().a(new com.baidu.tbadk.a.e());
        com.baidu.adp.framework.c.c.a().a(new com.baidu.tbadk.a.c());
        com.baidu.adp.framework.c.c.a().a(new com.baidu.tbadk.a.b());
        com.baidu.adp.framework.c.c.a().h();
        com.baidu.adp.framework.c.c.a().a(false, "TiebaImApplication init");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        onAppMemoryLow();
        super.onLowMemory();
    }

    @Override // com.baidu.adp.base.BdBaseApplication
    public void onAppMemoryLow() {
        int b = com.baidu.tbadk.imageManager.e.a().b();
        int max = (int) Math.max(b * 0.8d, TbConfig.getBigImageMaxUsedMemory());
        if (max < b) {
            if (BdLog.isDebugMode()) {
                BdLog.w(TbadkApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.imageManager.e.a().b(max);
        }
    }

    private static com.baidu.tbadk.task.b registerScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.a(cls);
        bVar.b(z);
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initSettings() {
        boolean z;
        int i;
        AssetManager assets;
        InputStream inputStream;
        this.mVoiceHeadsetMode = f.a().a("voice_headset_mode", 0);
        if (f.a().a("webp_failure_count", -1) == -1) {
            if (Build.VERSION.SDK_INT >= 14 && (assets = m252getInst().getContext().getAssets()) != null) {
                try {
                    inputStream = assets.open("webp_test/test.webp");
                } catch (IOException e) {
                    e.printStackTrace();
                    inputStream = null;
                }
                if (inputStream != null) {
                    if (BitmapFactory.decodeStream(inputStream) == null) {
                        BdLog.e("Failed to decode the webp.");
                        z = false;
                    } else {
                        BdLog.e("Decoded the webp.");
                        z = true;
                    }
                    if (z) {
                        BdLog.i("I'm not capable of webp.");
                        i = 6;
                        this.mCapableOfWebp = false;
                    } else {
                        BdLog.i("Proudly I'm capable of webp.");
                        this.mCapableOfWebp = true;
                        i = 0;
                    }
                    f.a().b("webp_failure_count", i);
                    f.a().b("capable_of_webp_format", this.mCapableOfWebp);
                    return;
                }
            }
            z = false;
            if (z) {
            }
            f.a().b("webp_failure_count", i);
            f.a().b("capable_of_webp_format", this.mCapableOfWebp);
            return;
        }
        this.mCapableOfWebp = f.a().a("capable_of_webp_format", false);
    }

    private void initSetting() {
        this.mFaceShopVersion = f.a().a("faceshop_version", -1);
        this.mIsAbstractOn = f.a().a("new_abstract_state", 0);
        this.mGpuOpen = f.a().a("gpu_open", shouldGPUOn());
        this.mPromotedMessageOn = f.a().a("permoted_message", true);
        this.mWebviewCrashCount = f.a().a("webview_crash_count", 0);
    }

    protected void InitVersion() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
            TbConfig.setVersionType(com.baidu.adp.lib.f.b.a(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
        } catch (Exception e) {
            TbConfig.setVersionType(3);
            BdLog.e(getClass().getName(), "InitVersion", e.getMessage());
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
            BdLog.e(getClass().getName(), "InitVersion", e2.getMessage());
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
            String[] strArr = {String.valueOf(packageName) + ":remote", String.valueOf(packageName) + ":hao123_float", String.valueOf(packageName) + ":bdservice_v1", String.valueOf(packageName) + ":live"};
            int myPid = Process.myPid();
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                if (runningAppProcesses.get(i).pid == myPid) {
                    String str = runningAppProcesses.get(i).processName;
                    if (str != null) {
                        if (str.equalsIgnoreCase(packageName)) {
                            this._isMainProcess = Boolean.TRUE;
                            return true;
                        }
                        for (String str2 : strArr) {
                            if (str.equalsIgnoreCase(str2)) {
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
                this.mStartTime = System.nanoTime();
            }
            BdLog.i(getClass().getName(), "mResumeNum = ", String.valueOf(this.mResumeNum));
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
            bg.a(null);
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
                new v().start();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(false));
        }
    }

    public LimitList getHasShowAppForums() {
        return this.mHasShowAppForums;
    }

    public void clearHasShowAppForums() {
        if (this.mHasShowAppForums != null) {
            this.mHasShowAppForums.clear();
        }
    }

    public boolean getIsUseBaiduStatOn() {
        if (f.a().a("mostat_crash_count_" + TbConfig.getVersion(), 0) > getFeatureCrashAutoCloseLimit()) {
            return false;
        }
        return this.mIsUseBaiduStatOn;
    }

    public void setIsUseBaiduStatOn(boolean z) {
        this.mIsUseBaiduStatOn = z;
    }

    public static synchronized String getUniqueIdentifier() {
        String str;
        synchronized (TbadkApplication.class) {
            if (mUniqueId == null) {
                String cuid = m252getInst().getCuid();
                String packageName = m252getInst().getApp().getPackageName();
                mUniqueId = String.valueOf(cuid) + "|" + packageName + TbConfig.getVersion();
            }
            str = mUniqueId;
        }
        return str;
    }

    protected void initCuid() {
        this.mCuid = loadString("cuid", null);
        if (this.mCuid == null || this.mCuid.length() < 0) {
            this.mCuid = CommonParam.getCUID(this);
            BdLog.i("----cuid:" + this.mCuid);
            saveString("cuid", this.mCuid);
        }
    }

    public String getCuid() {
        return this.mCuid;
    }

    protected void saveString(String str, String str2) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, str2);
    }

    protected String loadString(String str, String str2) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, str2);
    }

    protected boolean loadBoolean(String str, boolean z) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, z);
    }

    protected void saveBoolean(String str, boolean z) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, z);
    }

    protected int loadInt(String str, int i) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, i);
    }

    protected void saveInt(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, i);
    }

    protected long loadLong(String str, long j) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, j);
    }

    protected void saveLong(String str, long j) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, j);
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
        String str = null;
        String loadString = loadString("client_id", null);
        if (loadString != null) {
            int indexOf = loadString.indexOf("\t");
            if (indexOf != -1) {
                if (TbConfig.getVersion().equals(loadString.substring(0, indexOf))) {
                    str = loadString.substring(indexOf + 1);
                } else {
                    removeClientId(this);
                }
            } else {
                removeClientId(this);
            }
        } else {
            str = loadString;
        }
        BdLog.i("TiebaApplication", "readClientId", str);
        return str;
    }

    public static String getClientId() {
        return clientId;
    }

    public void removeClientId(Context context) {
        com.baidu.tbadk.core.sharedPref.b.a().a("client_id");
    }

    public static void saveClientId(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.core.sharedPref.b.a().b("client_id", String.valueOf(TbConfig.getVersion()) + "\t" + str);
        }
    }

    public static void setClientId(String str) {
        clientId = str;
    }

    protected void initImei() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.mImei = telephonyManager.getDeviceId();
        }
        if (this.mImei == null) {
            this.mImei = DEFAULT_IMEI;
        }
    }

    public String getImei() {
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
            File d = com.baidu.tbadk.core.util.x.d(TbConfig.FROM_FILE);
            if (d != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(d));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "getFromByFile", e.getMessage());
            TiebaStatic.file(e, "TiebaApplication.getFromByFile");
        }
        return str;
    }

    private void saveFromToFile(String str) {
        if (str != null && str.length() > 0) {
            try {
                File f = com.baidu.tbadk.core.util.x.f(TbConfig.FROM_FILE);
                if (f != null) {
                    FileWriter fileWriter = new FileWriter(f);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "saveFromToFile", e.getMessage());
                TiebaStatic.file(e, "TiebaApplication.saveFromToFile");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                    BdLog.e(getClass().getName(), "InitFrom", e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    BdLog.i(getClass().getName(), "InitFrom", "from = " + TbConfig.getFrom());
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
        BdLog.i(getClass().getName(), "InitFrom", "from = " + TbConfig.getFrom());
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
                m252getInst().onAccountChanged(mAccount, m252getInst());
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
        aq.a(i);
        saveInt("networkcore_type", i);
    }

    public static String getFrom() {
        return TbConfig.getFrom();
    }

    public void loginShareRemove() {
        com.baidu.tbadk.core.sharedPref.b.a().a("account_share");
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
            f.a().b("font_size", i);
        }
    }

    public static void setCurrentAccount(AccountData accountData, Context context) {
        if (k.c()) {
            setCurrentAccountInUI(accountData, context);
        } else {
            m252getInst().handler.post(new d(accountData, context));
        }
    }

    public static void setCurrentAccountInUI(AccountData accountData, Context context) {
        boolean z = true;
        if ((accountData != null || mAccount == null) && ((mAccount != null || accountData == null) && (mAccount == null || accountData == null || TextUtils.equals(mAccount.getAccount(), accountData.getAccount())))) {
            z = false;
        }
        mAccount = accountData;
        if (context != null) {
            if (m252getInst().isPushServiceOpen()) {
                UtilHelper.startPushService(context);
            } else {
                UtilHelper.stopPushService(context);
            }
            if (m252getInst().isMoPlusOpen()) {
                UtilHelper.startMoPlusService(context);
            }
        }
        sendAccountChangedBroadcast(accountData);
        if (z) {
            m252getInst().onAccountChanged(accountData, m252getInst());
        }
        ac.a().b();
        LivePlayingStatusMgr.a().a(0, LivePlayingStatusMgr.LivePlayingStatus.IDEL);
    }

    protected void onAccountChanged(AccountData accountData, Application application) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2007006, accountData));
    }

    public void onUserChanged() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2007007));
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
        m252getInst().getApp().sendStickyBroadcast(intent2);
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
        if (com.baidu.tbadk.core.util.y.a("/package.cur/" + TbConfig.getVersion())) {
            return false;
        }
        setActiveVersion(com.baidu.tbadk.core.util.y.d("/package.cur"));
        return true;
    }

    public void setUsed() {
        com.baidu.tbadk.core.util.y.c("/package.cur");
        com.baidu.tbadk.core.util.y.b("/package.cur/" + TbConfig.getVersion());
    }

    public void setActiveVersion(String str) {
        if (!be.c(str) && !"null".equals(str)) {
            com.baidu.tbadk.core.util.y.c("/package.last");
            com.baidu.tbadk.core.util.y.b("/package.last/" + str);
        }
    }

    public void setFrom(String str) {
        TbConfig.setFrom(str);
    }

    public void sendImagePv(int i, int i2, String str) {
        if (this.imagePvThread == null) {
            this.imagePvThread = Executors.newSingleThreadExecutor();
        }
        BdLog.i(getClass().getName(), "pv_addImagePv", "img_num=" + i + " img_total" + i2);
        com.baidu.tbadk.c.d dVar = new com.baidu.tbadk.c.d(i, i2);
        dVar.a(str);
        this.imagePvThread.execute(dVar);
    }

    public boolean isHeadsetModeOn() {
        return this.mVoiceHeadsetMode == 1;
    }

    public void setHeadsetModeOn(boolean z) {
        int i = z ? 1 : 0;
        if (this.mVoiceHeadsetMode != i) {
            this.mVoiceHeadsetMode = i;
            f.a().b("voice_headset_mode", i);
        }
    }

    public void setLocationLat(String str) {
        f.a().a("location_lat", str);
    }

    public String getLocationLat() {
        return f.a().b("location_lat", "");
    }

    public void setLocationLng(String str) {
        f.a().a("location_lng", str);
    }

    public boolean getLocationShared() {
        return f.a().a("location_shared", false);
    }

    public void setLocationShared(boolean z) {
        f.a().b("location_shared", z);
    }

    public boolean isTiebaHelperOpen() {
        return f.a().a("tieba_helper_open", false);
    }

    public void setTiebaHelperOpen(boolean z) {
        f.a().b("tieba_helper_open", z);
    }

    public String getLocationLng() {
        return f.a().b("location_lng", "");
    }

    public void setLocationPos(String str) {
        f.a().a("location_pos", str);
    }

    public String getLocationPos() {
        return f.a().b("location_pos", "");
    }

    public int[] getSocketHeartBeatStratgy() {
        int[] iArr = new int[0];
        try {
            String b = f.a().b("socket_heartbeat_strategy", "");
            if (b != null && !TextUtils.isEmpty(b)) {
                String[] split = b.split(",");
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
            String b = f.a().b("socket_getmsg_strategy", "");
            if (b != null && !TextUtils.isEmpty(b)) {
                String[] split = b.split(",");
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
        String b = f.a().b("socket_time_out", (String) null);
        if (b == null || (split = b.split("\\|")) == null || split.length != 3) {
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
            String b = f.a().b("socket_reconn_strategy", "");
            if (b != null && !TextUtils.isEmpty(b)) {
                String[] split = b.split(",");
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
        this.mHandler.post(new e(this, z));
    }

    public boolean isGroupMsgOn() {
        return f.a().a("group_notify", true);
    }

    public boolean isMsgChatOn() {
        return this.mMsgChatOn;
    }

    public void setGroupMsgOn(boolean z) {
        f.a().b("group_notify", z);
    }

    public void setForumName(String str) {
        mForumName = str;
    }

    public String getForumName() {
        return mForumName;
    }

    public boolean isFrsImageForum(String str) {
        return (this.mFrsImageForums == null || str == null || !this.mFrsImageForums.containsKey(str)) ? false : true;
    }

    public void addFrsImageForum(String str) {
        if (!isFrsImageForum(str) && this.mFrsImageForums != null && str != null) {
            this.mFrsImageForums.put(str, 1);
            new com.baidu.tbadk.coreExtra.c.b(1, str).start();
        }
    }

    public void delFrsImageForum(String str) {
        if (isFrsImageForum(str) && this.mFrsImageForums != null && str != null) {
            this.mFrsImageForums.remove(str);
            new com.baidu.tbadk.coreExtra.c.b(2, str).start();
        }
    }

    public int getMsgFrequency() {
        return this.mMsgFrequency;
    }

    public boolean isMsgAtmeOn() {
        return this.mMsgAtmeOn;
    }

    public boolean isMsgReplymeOn() {
        return this.mMsgReplymeOn;
    }

    public boolean isMsgZanOn() {
        return this.mMsgZanOn;
    }

    public boolean isMsgFansOn() {
        return this.mMsgFansOn;
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void initFrsImageForums() {
        this.mFrsImageForums = new Hashtable<>();
        new com.baidu.tbadk.coreExtra.c.b(this.mFrsImageForums).start();
    }

    public int getFaceShopVersion() {
        return this.mFaceShopVersion;
    }

    public void setFaceShopVersion(int i) {
        this.mFaceShopVersion = i;
        f.a().b("faceshop_version", this.mFaceShopVersion);
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
        int a = f.a().a("webp_failure_count", 0) + 1;
        if (a > 5) {
            this.mCapableOfWebp = false;
            f.a().b("capable_of_webp_format", false);
            return;
        }
        f.a().b("webp_failure_count", a);
    }

    public void setInstallOtherApp(String str) {
        f.a().a("install_other_app_file_name", str);
    }

    public String getInstallOtherApp() {
        return f.a().b("install_other_app_file_name", (String) null);
    }

    public void setGpuOpen(boolean z) {
        f.a().b("gpu_open", z);
        this.mGpuOpen = z;
    }

    public boolean isGpuOpen() {
        return this.mGpuOpen;
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
        if (BdLog.isDebugMode()) {
            BdLog.i("device:[" + trim + "], default GPU on:" + z);
        }
        return z;
    }

    public void setUpdateNotifyTime(long j) {
        f.a().b("update_notify_time", j);
    }

    public long getUpdateNotifyTime() {
        return f.a().a("update_notify_time", 0L);
    }

    public static boolean checkNeedShowNewVersion() {
        if (m252getInst().checkNeedShowNewVersionFlag()) {
            Long valueOf = Long.valueOf(m252getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            m252getInst().setUpdateNotifyTime(valueOf2.longValue());
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

    public boolean checkNeedShowNewVersionFlag() {
        return this.mNeedShowNewVersion;
    }

    public void refreshNewVersion(boolean z) {
        this.mNeedShowNewVersion = z;
        m252getInst().sendBroadcast(new Intent(TbConfig.getBroadcastActionNewVersion()));
    }

    public long getLastNotifyTime() {
        return f.a().a("last_notify_sound_time", 0L);
    }

    public void setLastNotifyTime(long j) {
        f.a().b("last_notify_sound_time", j);
    }

    public void setPromotedMessage(boolean z) {
        this.mPromotedMessageOn = z;
        f.a().b("permoted_message", z);
    }

    public boolean isPromotedMessageOn() {
        return this.mPromotedMessageOn;
    }

    public int getWebviewCrashCount() {
        return this.mWebviewCrashCount;
    }

    public void setWebviewCrashCount(int i) {
        this.mWebviewCrashCount = i;
        f.a().b("webview_crash_count", i);
    }

    public boolean isMsgRemindOn() {
        return m252getInst().mMsgFrequency > 0;
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
        f.a().b("moplus_service", z);
    }

    public boolean getIsMoPlusOpen() {
        if (f.a().a("moplus_crash_count_" + TbConfig.getVersion(), 0) > getFeatureCrashAutoCloseLimit()) {
            return false;
        }
        return f.a().a("moplus_service", true);
    }

    public boolean isMobStatShouldOpen() {
        return f.a().a(new StringBuilder("mostat_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit();
    }

    public void incMoPlusCrashCount() {
        String str = "moplus_crash_count_" + TbConfig.getVersion();
        f.a().b(str, f.a().a(str, 0) + 1);
    }

    public void incLiveSdkCrashCount() {
        String str = "live_sdk_crash_count_" + TbConfig.getVersion();
        f.a().b(str, f.a().a(str, 0) + 1);
    }

    public void incMobstatCrashCount() {
        String str = "mostat_crash_count_" + TbConfig.getVersion();
        f.a().b(str, f.a().a(str, 0) + 1);
    }

    public void incPassportV6CrashCount() {
        String str = "passport_crash_count_" + TbConfig.getVersion();
        f.a().b(str, f.a().a(str, 0) + 1);
    }

    public boolean isPassportV6ShouldOpen() {
        return f.a().a(new StringBuilder("passport_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.a.f.a().b("switch_login_passv6") != 1;
    }

    public void incHao123HelperCrashCount() {
        String str = "hao123_helper_crash_count" + TbConfig.getVersion();
        f.a().b(str, f.a().a(str, 0) + 1);
    }

    public boolean isHao123HelperShouldOpen() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str) || !str.startsWith("MI")) {
            return f.a().a(new StringBuilder("hao123_helper_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.a.f.a().b("switch_hao123_helper") != 1;
        }
        return false;
    }

    public void incDQCrashCount() {
        String str = "dq_crash_count" + TbConfig.getVersion();
        f.a().b(str, f.a().a(str, 0) + 1);
    }

    public boolean isDQShouldOpen() {
        return f.a().a(new StringBuilder("dq_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit();
    }

    public boolean isLiveRecordOpen() {
        return f.a().a(new StringBuilder("live_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.a.f.a().b("switch_live_record") == 0;
    }

    public void setFeatureCrashAutoCloseLimit(int i) {
        f.a().b("feature_crash_auto_close_limit", i);
    }

    public int getFeatureCrashAutoCloseLimit() {
        return Math.max(f.a().a("feature_crash_auto_close_limit", 3), 3);
    }

    public String gettShopUrl() {
        return this.tShopUrl;
    }

    public void settShopUrl(String str) {
        this.tShopUrl = str;
    }
}
