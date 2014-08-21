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
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import com.baidu.android.common.util.CommonParam;
import com.baidu.bdcvf.CertVerifier;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.tbadk.core.atomData.ai;
import com.baidu.tbadk.core.atomData.bq;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.util.LimitList;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
import com.baidu.tbadk.coreExtra.websocketBase.PingManager;
import com.baidu.tbadk.coreExtra.websocketBase.q;
import com.baidu.tbadk.coreExtra.websocketBase.y;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tbadk.editortool.v;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.x;
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
    private boolean isFriendFeedNew;
    public SharedPreferences sp;
    private String tShopUrl;
    protected static TbadkApplication sApp = null;
    protected static boolean IS_APP_RUNNING = false;
    protected static String mUniqueId = null;
    protected static AccountData mAccount = null;
    protected static String clientId = null;
    private static Intent intent = null;
    private static boolean isChangeAccount = false;
    private static String mForumName = "armcv";
    protected int mSkinType = 0;
    protected int mResumeNum = 0;
    protected long mStartTime = 0;
    protected AtomicBoolean isInBackground = null;
    protected LimitList mHasShowAppForums = null;
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
    private boolean mUseHttpClient = true;
    private int mWebviewCrashCount = 0;
    private long mLaunchTime = -1;
    private int mIsAbstractOn = 1;
    private int mVoiceHeadsetMode = 0;
    private final Handler mHandler = new Handler();
    protected boolean mCapableOfWebp = false;
    CustomMessageListener mMemListener = new a(this, 2001200);
    public Handler handler = new Handler(new b(this));
    private ExecutorService imagePvThread = null;
    private boolean isFirstGoFrs = false;
    private boolean isFirstGoMaintab = false;
    private boolean isFaceShopNew = false;
    private int mFaceShopVersion = -1;
    private int mTempFaceShopVersion = -1;
    private String mDefaultBubble = null;
    private int mDefaultBubbleEndTime = 0;
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
    public static TbadkApplication m252getInst() {
        return sApp;
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        com.baidu.adp.lib.Disk.d.a().a(TbConfig.getTempDirName());
        com.baidu.tbadk.core.util.e.a();
        init(this);
        com.baidu.tbadk.core.frameworkData.e.a();
        initSapi();
        initAccount();
        CustomMessageTask customMessageTask = new CustomMessageTask(2002001, new c(this));
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().sendMessage(new CustomMessage(2005003, new ai(m252getInst())));
        MessageManager.getInstance().sendMessage(new CustomMessage(2005005, new ai(m252getInst())));
        setActivityStackMaxSize(20);
        MessageManager.getInstance().registerListener(this.mMemListener);
        com.baidu.tbadk.distribute.a.a().b();
    }

    private void initSapi() {
        String string;
        Resources resources = getResources();
        if (resources == null) {
            string = "";
        } else {
            string = resources.getString(x.register_tip);
        }
        SapiAccountManager.getInstance().init(new SapiConfiguration.Builder(this).setProductLineInfo("tb", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK, "6e93e7659ae637845c7f83abee68a740").setRuntimeEnvironment(TbConfig.PASS_LOGIN_ADDRESS).registMode(RegistMode.FAST).loginShareStrategy(LoginShareStrategy.CHOICE).skin(CUSTOM_THEME_URL).fastRegConfirm(isNeedConfirm()).fastRegConfirmMsg(string).build());
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
        h.a().b("new_abstract_state", i);
    }

    public int getIsAbstractStatus() {
        return this.mIsAbstractOn;
    }

    public boolean getIsAbstract() {
        if (this.mIsAbstractOn == 0) {
            if (bb.a().c()) {
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
            CertVerifier.getInstance().verify(this, new d(this));
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
        TbFaceManager.a().a(this, new v());
        this.mFontSize = h.a().a("font_size", 2);
        try {
            com.baidu.adp.lib.c.a.a().a(m252getInst(), "tieba");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isMainProcess(true)) {
            com.baidu.tbadk.core.util.httpNet.a.a();
            com.baidu.tbadk.imageManager.e.a().a(50, TbConfig.getBigImageMaxUsedMemory());
            try {
                registerReceiver(new NetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        } else {
            com.baidu.tbadk.imageManager.e.a().a(0, TbConfig.getBigImageMaxUsedMemoryForRemoteProcess());
        }
        initSettings();
    }

    private void initWebsocketBase(Context context) {
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new e(this));
        int[] imTimeOut = getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            com.baidu.adp.framework.c.c.a().a(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            l.a(socketReconnStratgy);
        }
        PingManager.d().e();
        MessageManager.getInstance().getSocketClient().a(PingManager.d());
        MessageManager.getInstance().addResponsedMessageRule(new y());
        try {
            com.baidu.adp.framework.client.socket.coder.d.a().a(k.a());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        com.baidu.tbadk.coreExtra.websocketBase.v.a().b();
        q.a().b();
        initSocket();
    }

    private static void initSocket() {
        com.baidu.tbadk.task.b registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.c(false);
        registerImScoketTask.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", getUniqueIdentifier()));
        String c = com.baidu.tbadk.coreExtra.websocketBase.a.a().c();
        if (TextUtils.isEmpty(c)) {
            l.a(k.b);
        } else {
            l.a(c);
        }
        l.b("im_version=2.1");
        l.a(arrayList);
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
        int b = com.baidu.tbadk.imageManager.e.a().b();
        int max = (int) Math.max(b * 0.8d, TbConfig.getBigImageMaxUsedMemory());
        if (max < b) {
            BdLog.isDebugMode();
            com.baidu.tbadk.imageManager.e.a().b(max);
        }
        com.baidu.tbadk.core.util.d.a();
    }

    private static com.baidu.tbadk.task.b registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.a(cls);
        bVar.b(z);
        bVar.setParallel(k.b());
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initSettings() {
        boolean z;
        int i;
        AssetManager assets;
        InputStream inputStream;
        this.mVoiceHeadsetMode = h.a().a("voice_headset_mode", 0);
        if (h.a().a("webp_failure_count", -1) == -1) {
            if (Build.VERSION.SDK_INT >= 14 && (assets = m252getInst().getContext().getAssets()) != null) {
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
                    h.a().b("webp_failure_count", i);
                    h.a().b("capable_of_webp_format", this.mCapableOfWebp);
                    return;
                }
            }
            z = false;
            if (z) {
            }
            h.a().b("webp_failure_count", i);
            h.a().b("capable_of_webp_format", this.mCapableOfWebp);
            return;
        }
        this.mCapableOfWebp = h.a().a("capable_of_webp_format", false);
    }

    private void initSetting() {
        this.mFaceShopVersion = h.a().a("faceshop_version", -1);
        this.mIsAbstractOn = h.a().a("new_abstract_state", 0);
        this.mGpuOpen = h.a().a("gpu_open", shouldGPUOn());
        this.mUseHttpClient = h.a().a("httpclient", true);
        this.mPromotedMessageOn = h.a().a("permoted_message", true);
        this.mWebviewCrashCount = h.a().a("webview_crash_count", 0);
    }

    protected void InitVersion() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
            TbConfig.setVersionType(com.baidu.adp.lib.e.c.a(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
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
            String[] strArr = {String.valueOf(packageName) + ":remote", String.valueOf(packageName) + ":hao123_float", String.valueOf(packageName) + ":bdservice_v1", String.valueOf(packageName) + ":live", String.valueOf(packageName) + ":cdnTachometer"};
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
            be.a(null);
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

    public LimitList getHasShowAppForums() {
        return this.mHasShowAppForums;
    }

    public void clearHasShowAppForums() {
        if (this.mHasShowAppForums != null) {
            this.mHasShowAppForums.clear();
        }
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
        sb.append(n.a());
        if (sb.length() > i) {
            sb.setLength(i);
        }
        return sb.toString();
    }

    public String getCuid() {
        if (com.baidu.adp.lib.util.i.c(this.mCuid)) {
            initCuid();
        }
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
        if (com.baidu.adp.lib.util.i.c(this.mImei)) {
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
            File d = s.d(TbConfig.FROM_FILE);
            if (d != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(d));
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
                File f = s.f(TbConfig.FROM_FILE);
                if (f != null) {
                    FileWriter fileWriter = new FileWriter(f);
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

    /* JADX WARN: Removed duplicated region for block: B:44:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        aj.a(i);
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
            h.a().b("font_size", i);
        }
    }

    public static void setCurrentAccount(AccountData accountData, Context context) {
        if (com.baidu.adp.lib.util.j.b()) {
            setCurrentAccountInUI(accountData, context);
        } else {
            m252getInst().handler.post(new f(accountData, context));
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
        com.baidu.adp.lib.stats.f.c().a(str2, str, str3);
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
        if (isChangeAccount) {
            m252getInst().onAccountChanged(accountData, m252getInst());
            BdSocketLinkService.startService(true, "account changed");
        }
        aa.a().b();
        LivePlayingStatusMgr.a().a(0, LivePlayingStatusMgr.LivePlayingStatus.IDEL);
        if (isChangeAccount) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bq(context)));
        }
    }

    protected void onAccountChanged(AccountData accountData, Application application) {
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
            m252getInst().getApp().sendStickyBroadcast(intent2);
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
        Intent intent3 = new Intent();
        intent3.setAction(ACCOUNT_CHANGE_ACTION);
        m252getInst().getApp().sendBroadcast(intent3);
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
        if (t.a("/package.cur/" + TbConfig.getVersion())) {
            return false;
        }
        setActiveVersion(t.d("/package.cur"));
        return true;
    }

    public void setUsed() {
        t.c("/package.cur");
        t.b("/package.cur/" + TbConfig.getVersion());
    }

    public void setActiveVersion(String str) {
        if (!ba.c(str) && !"null".equals(str)) {
            t.c("/package.last");
            t.b("/package.last/" + str);
        }
    }

    public void setFrom(String str) {
        TbConfig.setFrom(str);
    }

    public void sendImagePv(int i, int i2, String str) {
        if (this.imagePvThread == null) {
            this.imagePvThread = Executors.newSingleThreadExecutor();
        }
        com.baidu.tbadk.b.e eVar = new com.baidu.tbadk.b.e(i, i2);
        eVar.a(str);
        this.imagePvThread.execute(eVar);
        TiebaStatic.eventStat(m252getInst().getApp(), "img_browse", null, 1, "img_num", Integer.valueOf(i), "img_total", Integer.valueOf(i2), "img_type", str);
    }

    public boolean isHeadsetModeOn() {
        return this.mVoiceHeadsetMode == 1;
    }

    public void setHeadsetModeOn(boolean z) {
        int i = z ? 1 : 0;
        if (this.mVoiceHeadsetMode != i) {
            this.mVoiceHeadsetMode = i;
            h.a().b("voice_headset_mode", i);
        }
    }

    public void setLocationLat(String str) {
        h.a().a("location_lat", str);
    }

    public String getLocationLat() {
        return h.a().b("location_lat", "");
    }

    public void setLocationLng(String str) {
        h.a().a("location_lng", str);
    }

    public boolean getLocationShared() {
        return h.a().a("location_shared", false);
    }

    public void setLocationShared(boolean z) {
        h.a().b("location_shared", z);
    }

    public boolean isTiebaHelperOpen() {
        return h.a().a("tieba_helper_open", false);
    }

    public void setTiebaHelperOpen(boolean z) {
        h.a().b("tieba_helper_open", z);
    }

    public String getLocationLng() {
        return h.a().b("location_lng", "");
    }

    public void setLocationPos(String str) {
        h.a().a("location_pos", str);
    }

    public String getLocationPos() {
        return h.a().b("location_pos", "");
    }

    public int[] getSocketHeartBeatStratgy() {
        int[] iArr = new int[0];
        try {
            String b = h.a().b("socket_heartbeat_strategy", "");
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
            String b = h.a().b("socket_getmsg_strategy", "");
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
        String b = h.a().b("socket_time_out", (String) null);
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
            String b = h.a().b("socket_reconn_strategy", "");
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
    }

    public boolean isFriendFeedNew() {
        return this.isFriendFeedNew;
    }

    public void setFriendFeedNew(boolean z) {
        this.isFriendFeedNew = z;
        this.mHandler.post(new g(this, z));
    }

    public boolean isGroupMsgOn() {
        return h.a().a("group_notify", true);
    }

    public boolean isMsgChatOn() {
        return this.mMsgChatOn;
    }

    public void setGroupMsgOn(boolean z) {
        h.a().b("group_notify", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
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

    public boolean isMsgNewFansOn() {
        return this.mMsgNewFansOn;
    }

    public boolean isMsgReplymeOn() {
        return this.mMsgReplymeOn;
    }

    public boolean isMsgZanOn() {
        return h.a().a("zan_disjunctor_setting", true);
    }

    public void setMsgZanOn(boolean z) {
        h.a().b("zan_disjunctor_setting", z);
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
        h.a().b("faceshop_version", this.mFaceShopVersion);
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
        int a = h.a().a("webp_failure_count", 0) + 1;
        if (a > 5) {
            this.mCapableOfWebp = false;
            h.a().b("capable_of_webp_format", false);
            return;
        }
        h.a().b("webp_failure_count", a);
    }

    public void setInstallOtherApp(String str) {
        h.a().a("install_other_app_file_name", str);
    }

    public String getInstallOtherApp() {
        return h.a().b("install_other_app_file_name", (String) null);
    }

    public void setGpuOpen(boolean z) {
        h.a().b("gpu_open", z);
        this.mGpuOpen = z;
    }

    public boolean isGpuOpen() {
        return this.mGpuOpen;
    }

    public void setHttpClientOpen(boolean z) {
        h.a().b("httpclient", z);
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
        h.a().b("update_notify_time", j);
    }

    public long getUpdateNotifyTime() {
        return h.a().a("update_notify_time", 0L);
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
        m252getInst().sendBroadcast(new Intent(TbConfig.getBroadcastActionNewVersion()));
    }

    public long getLastNotifyTime() {
        return h.a().a("last_notify_sound_time", 0L);
    }

    public void setLastNotifyTime(long j) {
        h.a().b("last_notify_sound_time", j);
    }

    public void setPromotedMessage(boolean z) {
        this.mPromotedMessageOn = z;
        h.a().b("permoted_message", z);
    }

    public boolean isPromotedMessageOn() {
        return this.mPromotedMessageOn;
    }

    public int getWebviewCrashCount() {
        return this.mWebviewCrashCount;
    }

    public void setWebviewCrashCount(int i) {
        this.mWebviewCrashCount = i;
        h.a().b("webview_crash_count", i);
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
        h.a().b("moplus_service", z);
    }

    public boolean getIsMoPlusOpen() {
        if (h.a().a("moplus_crash_count_" + TbConfig.getVersion(), 0) > getFeatureCrashAutoCloseLimit()) {
            return false;
        }
        return h.a().a("moplus_service", true);
    }

    public void incMoPlusCrashCount() {
        String str = "moplus_crash_count_" + TbConfig.getVersion();
        h.a().b(str, h.a().a(str, 0) + 1);
    }

    public void incLiveSdkCrashCount() {
        String str = "live_sdk_crash_count_" + TbConfig.getVersion();
        h.a().b(str, h.a().a(str, 0) + 1);
    }

    public void incPassportV6CrashCount() {
        String str = "passport_crash_count_" + TbConfig.getVersion();
        h.a().b(str, h.a().a(str, 0) + 1);
    }

    public boolean isPassportV6ShouldOpen() {
        return h.a().a(new StringBuilder("passport_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.a.f.a().b("switch_login_passv6") != 1;
    }

    public void incHao123HelperCrashCount() {
        String str = "hao123_helper_crash_count" + TbConfig.getVersion();
        h.a().b(str, h.a().a(str, 0) + 1);
    }

    public boolean isHao123HelperShouldOpen() {
        String str = Build.MANUFACTURER;
        if ((TextUtils.isEmpty(str) || !(str.equalsIgnoreCase("Xiaomi") || str.equalsIgnoreCase("alps"))) && Build.VERSION.SDK_INT >= 9) {
            return h.a().a(new StringBuilder("hao123_helper_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.a.f.a().b("switch_hao123_helper") != 1;
        }
        return false;
    }

    public long getReporyUserInfoLastTime() {
        return h.a().a("report_user_info_time_key" + getCurrentAccount(), 0L);
    }

    public void setReporyUserInfoCurrentTime() {
        h.a().b("report_user_info_time_key" + getCurrentAccount(), System.currentTimeMillis());
    }

    public void incBaobaoCrashCount() {
        String str = "baobao_crash_count" + TbConfig.getVersion();
        h.a().b(str, h.a().a(str, 0) + 1);
    }

    public boolean isFrsImageActivityOpen() {
        return com.baidu.adp.lib.a.f.a().b("offline_waterfall_post") == 1;
    }

    public boolean isNearByGroupOpen() {
        return com.baidu.adp.lib.a.f.a().b("offline_nearby_group") == 0;
    }

    public boolean isBaobaoShouldOpen() {
        return h.a().a(new StringBuilder("baobao_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.a.f.a().b("switch_baobao") == 1;
    }

    public void incDQCrashCount() {
        String str = "dq_crash_count" + TbConfig.getVersion();
        h.a().b(str, h.a().a(str, 0) + 1);
    }

    public boolean isDQShouldOpen() {
        return h.a().a(new StringBuilder("dq_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit();
    }

    public boolean isLiveRecordOpen() {
        return h.a().a(new StringBuilder("live_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.a.f.a().b("switch_live_record") == 0;
    }

    public void setFeatureCrashAutoCloseLimit(int i) {
        h.a().b("feature_crash_auto_close_limit", i);
    }

    public int getFeatureCrashAutoCloseLimit() {
        return Math.max(h.a().a("feature_crash_auto_close_limit", 3), 3);
    }

    public String gettShopUrl() {
        return this.tShopUrl;
    }

    public void settShopUrl(String str) {
        this.tShopUrl = str;
    }

    public void setAppUploadDate(long j) {
        h.a().b("app_upload_time", j);
    }

    public long getAppUploadDate() {
        return h.a().a("app_upload_time", 0L);
    }

    public void setAppUploadMd5(String str) {
        h.a().a("app_upload_md5", str);
    }

    public String getAppUploadMd5() {
        return h.a().b("app_upload_md5", (String) null);
    }

    public boolean isAppUploadOpen() {
        return com.baidu.adp.lib.a.f.a().b("upload_app_lists") == 1;
    }
}
