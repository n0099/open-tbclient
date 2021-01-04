package com.baidu.live.tbadk.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.live.adp.base.BdActivityStack;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.BdBaseService;
import com.baidu.live.adp.base.db.BdDatabaseHelper;
import com.baidu.live.adp.framework.CmdConvertManager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.socket.SocketConfig;
import com.baidu.live.adp.framework.client.socket.coder.CoderSecretManager;
import com.baidu.live.adp.framework.client.socket.link.ServiceOnCreateCallBack;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.NetMessage;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.adp.framework.settings.SocketTaskSetting;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.disk.DiskManager;
import com.baidu.live.adp.lib.image.loader.interfaces.GenerateImageAddressImpl;
import com.baidu.live.adp.lib.lbs.BdLocationMananger;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdBitmapHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdStringHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.GUIDTool;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbadkSettings;
import com.baidu.live.tbadk.TiebaDatabase;
import com.baidu.live.tbadk.TiebaIMConfig;
import com.baidu.live.tbadk.baidusim.CheckBaiduSimController;
import com.baidu.live.tbadk.core.account.AccountLoginCoreHelper;
import com.baidu.live.tbadk.core.atomdata.AlbumActivityConfig;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigHttp;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.frameworkdata.Tasks;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.PermissionUtil;
import com.baidu.live.tbadk.core.util.RegisterIntentConfigHelper;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.TiebaStaticHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.act.AccountCoreSetting;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.coreextra.data.ListItemsRule;
import com.baidu.live.tbadk.coreextra.model.LcsStrategy;
import com.baidu.live.tbadk.coreextra.websocketbase.LongConnectionAPIManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.rule.TbParamsHttpRule;
import com.baidu.live.tbadk.task.TbSocketMessageTask;
import com.baidu.live.tbadk.util.DaemonServiceManager;
import com.baidu.live.tbadk.util.NetworkChangedManager;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class TbadkCoreApplication extends BdBaseApplication implements BdActivityStack.OnAllActivityClosed {
    public static final String ACCOUNT_CHANGE_ACTION = "com.baidu.tieba.action.accountChange";
    private static final String ACTIVE_CLEAR_TAG = "active_clear";
    public static final int APP_ENTER_FORE_SWITCH = 5;
    public static final String APP_ID_HAOKAN = "haokan";
    public static final String APP_ID_MOBILE_BAIDU = "mobilebaidu";
    public static final String APP_ID_QUANMIN = "quanmin";
    public static final String APP_ID_TIEBA = "tieba";
    public static final String APP_ID_YINBO = "yinbo";
    protected static final String DEFAULT_IMEI = "000000000000000";
    public static final String SWITCH_PROCESS_NOTIFICATION_KEY = "com.tieba.baidu.notifyprocess";
    public static AlaLiveSwitchData sAlaLiveSwitchData;
    private Boolean _isMainProcess;
    private String checkUrl;
    public long currentAccountFlowerNum;
    public long currentAccountTdouNum;
    public Handler handler;
    private boolean isAudioRecorderExist;
    private boolean isImmersiveStickyCanUse;
    private boolean isImmersiveStickyPrefHasRead;
    protected AtomicBoolean isInBackground;
    private boolean isMeiZuCanUseImmersive;
    private boolean isMeiZuCanUseImmersiveHaveSet;
    private boolean isPhoneCalling;
    private boolean isRecAppExist;
    private boolean isUserChanged;
    private boolean isYuyinRoom;
    private int keyboardHeight;
    private ListItemsRule listItemRule;
    BdLocationMananger.LocationCallBack locationCallBack;
    private String mAlaMenuToast;
    private int mAlaToastShowType;
    private String mBigHeaderPhotoUrlPrefix;
    private boolean mCapableOfWebp;
    private Activity mCurrentActivity;
    private String mDefaultBubble;
    private int mDefaultBubbleEndTime;
    protected int mEnterForeCount;
    private HashMap<String, SoftReference<BdImage>> mFaces;
    private int mFontSize;
    private boolean mGpuOpen;
    private final Handler mHandler;
    private Hashtable<String, Integer> mHasLikeList;
    private Hashtable<String, Integer> mHasSignList;
    protected String mImei;
    private boolean mIsFromSubprocess;
    private boolean mIsLocationOn;
    private boolean mIsPageStayOpen;
    private boolean mLikeChanged;
    private boolean mNeedUploadMultidexError;
    private boolean mPromotedMessageOn;
    protected int mResumeNum;
    private Hashtable<String, Integer> mSignLevelUpList;
    private int mSkinType;
    private String mSmallHeaderPhotoUrlPrefix;
    protected long mStartTime;
    private boolean mUseHttpAutoSwitch;
    private boolean mUseHttpClient;
    public int mViewImageQuality;
    private int mVoiceHeadsetMode;
    private int mWebviewCrashCount;
    public long processCreateTime;
    private int useNewResign;
    private long useTimeInterval;
    private static AccountData mAccount = null;
    private static boolean isChangeAccount = false;
    private static volatile TbadkCoreApplication sApp = null;
    public static boolean IS_SDK = false;
    public static boolean IS_SUPPORT_SWIPEBACK = true;
    private static boolean IS_APP_RUNNING = false;
    protected static String mUniqueId = null;
    private static Intent intent = null;
    public static Boolean isShownNetChangeDialog = false;

    public static void setIntent(Intent intent2) {
        intent = intent2;
    }

    public static Intent getIntent() {
        return intent;
    }

    public boolean isWalletShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(SharedPrefConfig.WAllET_CRASH_COUNT).append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit();
    }

    public boolean canSendForegroundMessage() {
        if (isMainProcess(false)) {
            if (this.mIsFromSubprocess) {
                Intent intent2 = new Intent("com.tieba.baidu.notifyprocess");
                intent2.setPackage(getPackageName());
                intent2.putExtra("message", true);
                sendBroadcast(intent2);
                return false;
            }
            return true;
        }
        Intent intent3 = new Intent("com.tieba.baidu.notifyprocess");
        intent3.setPackage(getPackageName());
        intent3.putExtra("message", false);
        sendBroadcast(intent3);
        return false;
    }

    public Activity getCurrentActivity() {
        return this.mCurrentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        this.mCurrentActivity = activity;
    }

    public boolean getIsYuyinRoom() {
        return this.isYuyinRoom;
    }

    public void setIsYuyinRoom(boolean z) {
        this.isYuyinRoom = z;
    }

    public boolean isPageStayOpen() {
        return this.mIsPageStayOpen;
    }

    public void notifyAppEnterForehead() {
        if (this.isInBackground == null) {
            this.isInBackground = new AtomicBoolean(true);
        }
        if (this.isInBackground.get()) {
            this.isInBackground.set(false);
            this.mEnterForeCount++;
            if (isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(false));
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
                fixOppoTimeout();
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(true));
                TiebaStaticHelper.setCurrentActivity(null);
                TiebaInitialize.save();
            }
        }
    }

    public static TbadkCoreApplication getInst() {
        if (sApp == null) {
            synchronized (TbadkCoreApplication.class) {
                if (sApp == null) {
                    sApp = new TbadkCoreApplication();
                }
            }
        }
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
        if (isMainProcess(true) && this.mStartTime == 0 && this.mResumeNum > 0) {
            this.mStartTime = System.nanoTime();
        }
        this.handler.removeMessages(5);
        if (this.mResumeNum == 0) {
            sendMessageForEnterBackground();
        } else if (this.isInBackground == null || this.isInBackground.get()) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(5, Boolean.FALSE), 1000L);
        }
    }

    public void sendMessageForEnterBackground() {
        this.handler.sendMessageDelayed(this.handler.obtainMessage(5, Boolean.TRUE), 1000L);
    }

    public TbadkCoreApplication() {
        super(null);
        this.mSkinType = 0;
        this.mCapableOfWebp = true;
        this.mIsLocationOn = true;
        this.mVoiceHeadsetMode = 0;
        this.isYuyinRoom = false;
        this.mResumeNum = 0;
        this.mStartTime = 0L;
        this.mImei = null;
        this.mEnterForeCount = 0;
        this.mHandler = new Handler();
        this.isUserChanged = true;
        this.isImmersiveStickyCanUse = true;
        this.isImmersiveStickyPrefHasRead = false;
        this.currentAccountFlowerNum = 0L;
        this.currentAccountTdouNum = 0L;
        this.mNeedUploadMultidexError = false;
        this.mIsPageStayOpen = false;
        this.isMeiZuCanUseImmersiveHaveSet = false;
        this.isMeiZuCanUseImmersive = true;
        this.handler = new Handler(new Handler.Callback() { // from class: com.baidu.live.tbadk.core.TbadkCoreApplication.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 5:
                        if (Boolean.TRUE.equals(message.obj)) {
                            TbadkCoreApplication.this.notifyAppEnterBackground();
                            return false;
                        }
                        TbadkCoreApplication.this.notifyAppEnterForehead();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.mIsFromSubprocess = false;
        this.isInBackground = null;
        this.locationCallBack = new BdLocationMananger.LocationCallBack() { // from class: com.baidu.live.tbadk.core.TbadkCoreApplication.5
            @Override // com.baidu.live.adp.lib.lbs.BdLocationMananger.LocationCallBack
            public void onLocationGeted(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    try {
                        String valueOf = String.valueOf(address.getLatitude());
                        String valueOf2 = String.valueOf(address.getLongitude());
                        if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                            TbadkCoreApplication.this.setLocationLat(valueOf);
                            TbadkCoreApplication.this.setLocationLng(valueOf2);
                            TbadkCoreApplication.this.setLocationPos(address.getAddressLine(0));
                        }
                    } catch (IllegalStateException e) {
                        BdLog.e(e.getMessage());
                    }
                }
            }
        };
        this.mWebviewCrashCount = 0;
        this.mGpuOpen = false;
        this.mPromotedMessageOn = true;
        this.mUseHttpClient = true;
        this.mUseHttpAutoSwitch = true;
        this.mDefaultBubble = null;
        this.mDefaultBubbleEndTime = 0;
        this.mFontSize = 3;
        this.mFaces = null;
        this.mViewImageQuality = 0;
        this.isPhoneCalling = false;
        this.mHasLikeList = null;
        this.mHasSignList = null;
        this.mSignLevelUpList = null;
        this.mLikeChanged = false;
        this.isRecAppExist = false;
        this.isAudioRecorderExist = false;
        this.checkUrl = null;
        this.useNewResign = 0;
        this.mAlaToastShowType = -1;
    }

    public int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    public void setKeyboardHeight(int i) {
        this.keyboardHeight = i;
    }

    public boolean isKeyboardHeightCanSet(int i) {
        return i > getResources().getDimensionPixelSize(a.d.sdk_ds460);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        fixOppoTimeout();
    }

    @Override // com.baidu.live.adp.base.BdBaseApplication
    public void onCreate(Application application) {
        if (getApp() == null) {
            this.processCreateTime = System.currentTimeMillis();
            if (sApp == null) {
                sApp = this;
            }
            sApp.attachBaseContext(application);
            super.onCreate(application);
            initCmdConvertManager();
            BdBaseService.setServiceOnCreateCallBack(new ServiceOnCreateCallBack() { // from class: com.baidu.live.tbadk.core.TbadkCoreApplication.2
                @Override // com.baidu.live.adp.framework.client.socket.link.ServiceOnCreateCallBack
                public void onServiceCreate() {
                    DaemonServiceManager.getInstance().checkCrashNumOverLimit(new DaemonServiceManager.CheckCrashNumCallBack() { // from class: com.baidu.live.tbadk.core.TbadkCoreApplication.2.1
                        @Override // com.baidu.live.tbadk.util.DaemonServiceManager.CheckCrashNumCallBack
                        public void onResult(boolean z) {
                            if (z) {
                                BdBaseService.serviceStartFlag = 2;
                            } else {
                                BdBaseService.serviceStartFlag = 1;
                            }
                        }
                    });
                }
            });
            DiskManager.getInstance().initial(TbConfig.getTempDirName());
            boolean isMainProcess = isMainProcess(false);
            init(getContext());
            if (isMainProcess) {
                BdActivityStack.getInst().setOnActivityAllClosed(this);
            }
            initTasks();
            AccountLoginCoreHelper.init();
            AccountCoreSetting.init();
            initLocationSetting();
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_GO_ACTION, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.live.tbadk.core.TbadkCoreApplication.3
                @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
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
                        TiebaInitialize.log(new StatisticItem("inter_config_disappear").param("obj_param1", RegisterIntentConfigHelper.getInst().getConfigSize()));
                    }
                    if (intentClass != null) {
                        data.setComponentClass(intentClass);
                        data.run();
                    }
                    return new CustomResponsedMessage<>(customMessage.getCmd(), data);
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            registerPhoneListener();
            System.currentTimeMillis();
        }
    }

    private void fixOppoTimeout() {
        try {
            Class<?> cls = Class.forName("java.lang.Daemons$FinalizerWatchdogDaemon");
            Method declaredMethod = cls.getSuperclass().getDeclaredMethod("stop", new Class[0]);
            declaredMethod.setAccessible(true);
            Field declaredField = cls.getDeclaredField("INSTANCE");
            declaredField.setAccessible(true);
            declaredMethod.invoke(declaredField.get(null), new Object[0]);
        } catch (ClassNotFoundException e) {
            BdLog.e(e);
        } catch (IllegalAccessException e2) {
            BdLog.e(e2);
        } catch (NoSuchFieldException e3) {
            BdLog.e(e3);
        } catch (NoSuchMethodException e4) {
            BdLog.e(e4);
        } catch (InvocationTargetException e5) {
            BdLog.e(e5);
        }
    }

    private void initCmdConvertManager() {
        if (isDebugMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(CmdConfigSocket.class.getName());
            arrayList.add(CmdConfigCustom.class.getName());
            arrayList.add(CmdConfigHttp.class.getName());
            CmdConvertManager.getInstance().init(arrayList);
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
        System.currentTimeMillis();
        Tasks.initial();
    }

    private void initLocationSetting() {
        System.currentTimeMillis();
        if (isMainProcess(true) && mAccount == null) {
            tryLbs();
        }
    }

    public boolean isRegistedIntent(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        RegisterIntentConfigHelper.getInst().RegisterIntent(cls, cls2);
    }

    public Class<?> getIntentClass(Class<?> cls) {
        return RegisterIntentConfigHelper.getInst().getIntentClass(cls);
    }

    public static String getFrom() {
        return TbConfig.getFrom();
    }

    private void init(Context context) {
        initImei();
        InitFrom();
        initSetting();
        initWebsocketBase(context);
        this.mFontSize = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_FONT_SIZE, 2);
        try {
            BdLocationMananger.getInstance().initial();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            NetworkChangedManager.getInstance().registerNetworkChangedListener();
            if (isMainProcess(false)) {
                CheckBaiduSimController.getInstance().registerNetworkChangedListener();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        loadLcsSwitchStratgy();
        this.mFaces = new HashMap<>();
        initSdcardDatabaseCallback();
        MessageManager.getInstance().addMessageRule(new TbParamsHttpRule(0));
        initAppSettings();
        TiebaInitialize.init(getContext(), isMainProcess(false));
        if (isMainProcess(true)) {
            sendMessageForEnterBackground();
        }
        NetMessage.setGlobalSwitchToHttpStrategy(new NetMessage.SwitchToHttpStrategy() { // from class: com.baidu.live.tbadk.core.TbadkCoreApplication.4
            @Override // com.baidu.live.adp.framework.message.NetMessage.SwitchToHttpStrategy
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                return socketResponsedMessage != null && (socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005);
            }
        });
    }

    public void tryLbs() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.tbadk.core.TbadkCoreApplication.6
            @Override // java.lang.Runnable
            public void run() {
                BdLocationMananger.getInstance().getAddress(true, TbadkCoreApplication.this.locationCallBack);
            }
        }, 5000L);
    }

    private static void initSdcardDatabaseCallback() {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().setOnCreateCallback(new BdDatabaseHelper.OnDatabaseCreatedCallback() { // from class: com.baidu.live.tbadk.core.TbadkCoreApplication.7
            @Override // com.baidu.live.adp.base.db.BdDatabaseHelper.OnDatabaseCreatedCallback
            public void onDatabaseCreated(SQLiteDatabase sQLiteDatabase) {
                TbadkCoreApplication.resetTDatabaseCreateTime();
            }
        });
    }

    public static void resetTDatabaseCreateTime() {
        TbadkSettings.getInst().saveLong(SharedPrefConfig.TDATABASECREATETIME, new Date().getTime());
    }

    private void initAppSettings() {
        TbImgSetting.getInstance().initSetting();
    }

    public static String getClientId() {
        return getInst().getCuid();
    }

    public String getCuid() {
        IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
        return buildParamsExtra != null ? buildParamsExtra.getCuid() : "";
    }

    protected void saveString(String str, String str2) {
        SharedPrefHelper.getInstance().putString(str, str2);
    }

    protected String loadString(String str, String str2) {
        return SharedPrefHelper.getInstance().getString(str, str2);
    }

    protected int loadInt(String str, int i) {
        return SharedPrefHelper.getInstance().getInt(str, i);
    }

    protected void saveInt(String str, int i) {
        SharedPrefHelper.getInstance().putInt(str, i);
    }

    protected void initImei() {
        TelephonyManager telephonyManager;
        try {
            if (PermissionUtil.checkReadPhoneState(getContext()) && (telephonyManager = (TelephonyManager) getContext().getSystemService("phone")) != null) {
                this.mImei = telephonyManager.getDeviceId();
            }
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
        if (this.mImei == null) {
            this.mImei = "000000000000000";
        }
    }

    public String getImei() {
        if (BdStringHelper.isEmpty(this.mImei)) {
            initImei();
        }
        return this.mImei;
    }

    private String getFromByShare() {
        return loadString(SharedPrefConfig.FROM_ID, null);
    }

    private void saveFromToShare(String str) {
        if (str != null && str.length() > 0 && isMainProcess(true)) {
            saveString(SharedPrefConfig.FROM_ID, str);
        }
    }

    private String getFromByFile() {
        String str = null;
        try {
            File GetFile = FileHelper.GetFile("from.dat");
            if (GetFile != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(GetFile));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaInitialize.file(e, "TiebaApplication.getFromByFile");
        }
        return str;
    }

    private void saveFromToFile(String str) {
        if (str != null && str.length() > 0) {
            try {
                File CreateFile = FileHelper.CreateFile("from.dat");
                if (CreateFile != null) {
                    FileWriter fileWriter = new FileWriter(CreateFile);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaInitialize.file(e, "TiebaApplication.saveFromToFile");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void InitFrom() {
        BufferedReader bufferedReader;
        if (!IS_SDK) {
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
    }

    protected String createRandomString(String str, int i) {
        StringBuilder sb = new StringBuilder(i);
        if (str != null) {
            sb.append(str);
        }
        sb.append(GUIDTool.guid());
        if (sb.length() > i) {
            sb.setLength(i);
        }
        return sb.toString();
    }

    protected void initSetting() {
        this.mGpuOpen = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GPU_OPEN, shouldGPUOn());
        this.mUseHttpClient = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.USE_HTTPCLIENT, true);
        this.mPromotedMessageOn = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.PERMOTED_MESSAGE, true);
        this.mIsLocationOn = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.LOCATION_ON, true);
        getInst().setIsLocationON(this.mIsLocationOn);
    }

    public void setGpuOpen(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GPU_OPEN, z);
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
            if (i >= length) {
                z = true;
                break;
            } else if (strArr[i].equalsIgnoreCase(trim)) {
                break;
            } else {
                i++;
            }
        }
        return z;
    }

    public static void setIsAppRunning(boolean z) {
        IS_APP_RUNNING = z;
    }

    public boolean isMainProcess(boolean z) {
        if (this._isMainProcess != null) {
            return this._isMainProcess.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager != null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    String packageName = getInst().getPackageName();
                    int myPid = Process.myPid();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < runningAppProcesses.size()) {
                            if (runningAppProcesses.get(i2).pid != myPid) {
                                i = i2 + 1;
                            } else {
                                String str = runningAppProcesses.get(i2).processName;
                                if (str != null && str.equalsIgnoreCase(packageName)) {
                                    this._isMainProcess = Boolean.TRUE;
                                    return true;
                                }
                                return z;
                            }
                        } else {
                            return z;
                        }
                    }
                } else {
                    return z;
                }
            } catch (Throwable th) {
                BdLog.e(th);
                return z;
            }
        } else {
            return z;
        }
    }

    public static String getCurrentAccount() {
        if (mAccount != null) {
            return mAccount.getID();
        }
        return null;
    }

    public static long getCurrentAccountId() {
        if (mAccount != null) {
            return JavaTypesHelper.toLong(mAccount.getID(), 0L);
        }
        return 0L;
    }

    public static AccountData getCurrentAccountInfo() {
        return mAccount;
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

    public static void setCurrentAccount(final AccountData accountData, final Context context) {
        if (BdUtilHelper.isMainThread()) {
            setCurrentAccountInUI(accountData, context);
        } else {
            getInst().handler.post(new Runnable() { // from class: com.baidu.live.tbadk.core.TbadkCoreApplication.8
                @Override // java.lang.Runnable
                public void run() {
                    TbadkCoreApplication.setCurrentAccountInUI(AccountData.this, context);
                }
            });
        }
    }

    public static void setCurrentAccountInUI(AccountData accountData, Context context) {
        if (accountData == null && mAccount != null) {
            isChangeAccount = true;
        } else if (mAccount == null && accountData != null) {
            isChangeAccount = true;
        } else if (mAccount != null && accountData != null && !TextUtils.equals(mAccount.getAccount(), accountData.getAccount())) {
            isChangeAccount = true;
        } else {
            isChangeAccount = false;
        }
        mAccount = accountData;
        if (isChangeAccount) {
            getInst().onAccountChanged(accountData, getInst().getApp());
        }
        MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
        if (BdNetTypeUtil.isWifiNet() && accountData != null) {
            MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD, (Class) null);
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

    public static AccountData getCurrentAccountObj() {
        return mAccount;
    }

    public static String getCurrentAccountName() {
        if (mAccount != null) {
            return mAccount.getAccount();
        }
        return null;
    }

    protected void onAccountChanged(AccountData accountData, Application application) {
        BdLog.e("账号切换");
        tryLbs();
        this.isUserChanged = true;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.METHOD_INVOKE_ACCOUNT_CHANGE, accountData));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, accountData));
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_STICKY, accountData);
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_STICKY);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public static boolean isLogin() {
        String currentAccount = getCurrentAccount();
        return currentAccount != null && currentAccount.length() > 0;
    }

    public int getSkinType() {
        return this.mSkinType;
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

    protected void saveBoolean(String str, boolean z) {
        SharedPrefHelper.getInstance().putBoolean(str, z);
    }

    protected boolean loadBoolean(String str, boolean z) {
        return SharedPrefHelper.getInstance().getBoolean(str, z);
    }

    public boolean getLocationShared() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.LOCATION_SHARED + getCurrentAccount(), true);
    }

    public void setLocationShared(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.LOCATION_SHARED + getCurrentAccount(), z);
        if (z) {
            tryLbs();
        }
    }

    public void setIsLocationON(boolean z) {
        this.mIsLocationOn = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.LOCATION_ON, z);
    }

    public int getFeatureCrashAutoCloseLimit() {
        return Math.max(TbadkSettings.getInst().loadInt(SharedPrefConfig.FEATURE_CRASH_AUTO_CLOSE_LIMIT, 3), 3);
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

    private void initWebsocketBase(Context context) {
        int[] imTimeOut = getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            SocketTaskSetting.getInstance().setTimeOutData(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            SocketConfig.setReConnectInterval(socketReconnStratgy);
        }
        try {
            CoderSecretManager.getInstance().initial(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static synchronized String getUniqueIdentifier() {
        String str;
        synchronized (TbadkCoreApplication.class) {
            if (mUniqueId == null) {
                String cuid = getInst().getCuid();
                String packageName = getInst().getApp().getPackageName();
                mUniqueId = cuid + "|" + packageName + TbConfig.getVersion();
            }
            str = mUniqueId;
        }
        return str;
    }

    private static TbSocketMessageTask registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        TbSocketMessageTask tbSocketMessageTask = new TbSocketMessageTask(i);
        tbSocketMessageTask.setResponsedClass(cls);
        tbSocketMessageTask.setNeedCompress(z);
        tbSocketMessageTask.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(tbSocketMessageTask);
        return tbSocketMessageTask;
    }

    public int[] getSocketReconnStratgy() {
        int[] iArr = new int[0];
        try {
            String loadString = TbadkSettings.getInst().loadString(SharedPrefConfig.SOCKET_RECONN_STRATEGY, "");
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
        String loadString = TbadkSettings.getInst().loadString(SharedPrefConfig.LCS_SWITCH_STRATEGY, null);
        if (!TextUtils.isEmpty(loadString)) {
            LcsStrategy lcsStrategy = new LcsStrategy();
            lcsStrategy.parserJson(loadString);
            LongConnectionAPIManager longConnectionAPIManager = LongConnectionAPIManager.getInstance();
            longConnectionAPIManager.setCloseLongConnectionAPI(lcsStrategy.getConnConf() == 1);
            longConnectionAPIManager.setMaxErrorCount(lcsStrategy.getContinuousFailCount());
            longConnectionAPIManager.setRetryTimeInMills(lcsStrategy.getRestartTimeInterval() * 1000);
            if (lcsStrategy.getBlackCmds() != null) {
                longConnectionAPIManager.setUnAvailableAPIS(lcsStrategy.getBlackCmds());
            }
        }
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
        this.mVoiceHeadsetMode = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_HEADSET_MODE, 0);
        if (TbadkSettings.getInst().loadInt(SharedPrefConfig.WEBP_FAILURE_COUNT, -1) == -1) {
            if (Build.VERSION.SDK_INT >= 14 && (assets = getInst().getContext().getAssets()) != null) {
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
                    TbadkSettings.getInst().saveInt(SharedPrefConfig.WEBP_FAILURE_COUNT, i);
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.CAPABLE_OF_WEBP_FORMAT, this.mCapableOfWebp);
                    return;
                }
            }
            z = false;
            if (z) {
            }
            TbadkSettings.getInst().saveInt(SharedPrefConfig.WEBP_FAILURE_COUNT, i);
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.CAPABLE_OF_WEBP_FORMAT, this.mCapableOfWebp);
            return;
        }
        this.mCapableOfWebp = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.CAPABLE_OF_WEBP_FORMAT, false);
    }

    public int[] getImTimeOut() {
        String[] split;
        String loadString = TbadkSettings.getInst().loadString(SharedPrefConfig.SOCKET_TIME_OUT, null);
        if (loadString == null || (split = loadString.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR)) == null || split.length != 3) {
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
        return str.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI);
    }

    public boolean isHeadsetModeOn() {
        return this.mVoiceHeadsetMode == 1;
    }

    public void setHeadsetModeOn(boolean z) {
        int i = z ? 1 : 0;
        if (this.mVoiceHeadsetMode != i) {
            this.mVoiceHeadsetMode = i;
            TbadkSettings.getInst().saveInt(SharedPrefConfig.PREFS_HEADSET_MODE, i);
        }
    }

    public void incWebpFailureCount() {
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.WEBP_FAILURE_COUNT, 0) + 1;
        if (loadInt > 5) {
            this.mCapableOfWebp = false;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.CAPABLE_OF_WEBP_FORMAT, false);
            return;
        }
        TbadkSettings.getInst().saveInt(SharedPrefConfig.WEBP_FAILURE_COUNT, loadInt);
    }

    public int getKeepaliveWifi() {
        return loadInt(SharedPrefConfig.KEEPALIVE_WIFI, 1);
    }

    public void setKeepaliveWifi(int i) {
        saveInt(SharedPrefConfig.KEEPALIVE_WIFI, i);
    }

    public int getKeepaliveNonWifi() {
        return loadInt(SharedPrefConfig.KEEPALIVE_NONWIFI, 1);
    }

    public void setKeepaliveNonWifi(int i) {
        saveInt(SharedPrefConfig.KEEPALIVE_NONWIFI, i);
    }

    public boolean getIsPhoneCalling() {
        return this.isPhoneCalling;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class MyPhoneStateListener extends PhoneStateListener {
        private MyPhoneStateListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 0:
                    TbadkCoreApplication.this.isPhoneCalling = false;
                    break;
                case 1:
                case 2:
                    TbadkCoreApplication.this.isPhoneCalling = true;
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    }

    private void registerPhoneListener() {
        if (PermissionUtil.checkReadPhoneState(getContext())) {
            try {
                ((TelephonyManager) getInst().getApp().getSystemService("phone")).listen(new MyPhoneStateListener(), 32);
            } catch (SecurityException e) {
            } catch (Exception e2) {
            }
        }
    }

    public void onUserChanged() {
        if (!BdUtilHelper.isNetOk()) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_INFO_CHANGED));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_INVOKE_USER_CHANGE));
    }

    public void incPassportV6CrashCount() {
        String str = SharedPrefConfig.PASSPORT_CRASH_COUNT + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void setActiveVersion(String str) {
        if (!StringHelper.isEmpty(str) && !"null".equals(str)) {
            FileHelper.DataDir.cleanDirectory(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR);
            FileHelper.DataDir.createFile("/package.last/" + str);
        }
    }

    public boolean getIsFirstUse() {
        if (FileHelper.DataDir.checkFile("/package.cur/" + TbConfig.getVersion())) {
            return false;
        }
        setActiveVersion(FileHelper.DataDir.getLatestFileName(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR));
        return true;
    }

    public int[] getSocketHeartBeatStratgy() {
        int[] iArr = new int[0];
        try {
            String loadString = TbadkSettings.getInst().loadString(SharedPrefConfig.SOCKET_HEARTBEAT_STRATEGY, "");
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
        TbadkSettings.getInst().saveString(SharedPrefConfig.LOCATION_POS, str);
    }

    public boolean hasSignedForum(String str) {
        if (this.mHasSignList == null || str == null) {
            return false;
        }
        return this.mHasSignList.containsKey(str);
    }

    public static void resetCacheData() {
        SharedPrefHelper.getInstance().putLong(SharedPrefConfig.APP_PULL_TIME, System.currentTimeMillis());
    }

    public static String getCurrentPortrait() {
        AccountData currentAccountObj = getCurrentAccountObj();
        if (currentAccountObj == null) {
            return null;
        }
        return currentAccountObj.getPortrait();
    }

    public String getLocationLat() {
        return TbadkSettings.getInst().loadString(SharedPrefConfig.LOCATION_LAT, "");
    }

    public void setLocationLng(String str) {
        TbadkSettings.getInst().saveString(SharedPrefConfig.LOCATION_LNG, str);
    }

    public String getLocationLng() {
        return TbadkSettings.getInst().loadString(SharedPrefConfig.LOCATION_LNG, "");
    }

    public void setUseNewResign(int i) {
        this.useNewResign = i;
    }

    public void setAlaMenuToast(String str) {
        this.mAlaMenuToast = str;
    }

    public void setAlaToastShowType(int i) {
        this.mAlaToastShowType = i;
    }

    public void setBigHeaderPhotoUrlPrefix(String str) {
        if (StringUtils.isNull(str)) {
            this.mBigHeaderPhotoUrlPrefix = TbConfig.PHOTO_BIG_ADDRESS;
            return;
        }
        this.mBigHeaderPhotoUrlPrefix = str;
        GenerateImageAddressImpl.sBigHeaderPhotoUrlPrefix = this.mBigHeaderPhotoUrlPrefix;
    }

    public String getBigHeaderPhotoUrlPrefix() {
        return this.mBigHeaderPhotoUrlPrefix;
    }

    public void setSmallHeaderPhotoUrlPrefix(String str) {
        if (StringUtils.isNull(str)) {
            this.mBigHeaderPhotoUrlPrefix = TbConfig.PHOTO_SMALL_ADDRESS;
            return;
        }
        this.mSmallHeaderPhotoUrlPrefix = str;
        GenerateImageAddressImpl.sSmallHeaderPhotoUrlPrefix = this.mSmallHeaderPhotoUrlPrefix;
    }

    public String getSmallHeaderPhotoUrlPrefix() {
        return this.mSmallHeaderPhotoUrlPrefix;
    }

    public String getActiveVersion() {
        String latestFileName;
        if (!FileHelper.DataDir.checkFile(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR)) {
            latestFileName = TbadkSettings.getInst().loadString(SharedPrefConfig.ACTIVE_VERSION, "");
        } else {
            latestFileName = FileHelper.DataDir.getLatestFileName(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR);
        }
        if (ACTIVE_CLEAR_TAG.equals(latestFileName)) {
            return null;
        }
        return latestFileName;
    }

    public void clearActiveVersion() {
        setActiveVersion(ACTIVE_CLEAR_TAG);
    }

    public void setLocationLat(String str) {
        TbadkSettings.getInst().saveString(SharedPrefConfig.LOCATION_LAT, str);
    }

    public boolean appResponseToCmd(int i) {
        return MessageManager.getInstance().findTask(i) != null;
    }

    public boolean isMobileBaidu() {
        return APP_ID_MOBILE_BAIDU.equals(TbConfig.getSubappType());
    }

    public boolean isNotMobileBaidu() {
        return !APP_ID_MOBILE_BAIDU.equals(TbConfig.getSubappType());
    }

    public boolean isBaidu() {
        return APP_ID_MOBILE_BAIDU.equals(TbConfig.getSubappType());
    }

    public boolean isHaokan() {
        return "haokan".equals(TbConfig.getSubappType());
    }

    public boolean isQuanmin() {
        return APP_ID_QUANMIN.equals(TbConfig.getSubappType());
    }

    public boolean isYinbo() {
        return APP_ID_YINBO.equals(TbConfig.getSubappType());
    }

    public boolean isTieba() {
        return "tieba".equals(TbConfig.getSubappType());
    }

    public boolean isOther() {
        return ("tieba".equals(TbConfig.getSubappType()) || APP_ID_QUANMIN.equals(TbConfig.getSubappType()) || "haokan".equals(TbConfig.getSubappType()) || APP_ID_MOBILE_BAIDU.equals(TbConfig.getSubappType()) || APP_ID_YINBO.equals(TbConfig.getSubappType())) ? false : true;
    }

    public void onLowMemory() {
        onAppMemoryLow();
    }

    public boolean isImmersiveStickyCanUse() {
        if (!this.isImmersiveStickyPrefHasRead) {
            this.isImmersiveStickyCanUse = SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.SWITCH_IMMERSIVE_STICKY_STATUS, true);
            this.isImmersiveStickyPrefHasRead = true;
        }
        return this.isImmersiveStickyCanUse;
    }

    public boolean isMeiZuCanUseImmersive() {
        if (!this.isMeiZuCanUseImmersiveHaveSet) {
            this.isMeiZuCanUseImmersiveHaveSet = true;
            String str = Build.BRAND;
            String str2 = Build.MODEL;
            if ("Meizu".equalsIgnoreCase(str) && UtilHelper.isFlymeOsOver51()) {
                this.isMeiZuCanUseImmersive = false;
                return this.isMeiZuCanUseImmersive;
            }
        }
        return this.isMeiZuCanUseImmersive;
    }

    public void resetIsImmersiveStickyPrefHasRead(boolean z) {
        this.isImmersiveStickyPrefHasRead = z;
    }

    @Override // com.baidu.live.adp.base.BdBaseApplication
    public void onAppMemoryLow() {
        BitmapHelper.clearCashBitmap();
        BdBitmapHelper.getInstance().clearCashBitmap();
    }

    public ListItemsRule getListItemRule() {
        if (this.listItemRule == null) {
            this.listItemRule = new ListItemsRule();
        }
        return this.listItemRule;
    }

    @Override // com.baidu.live.adp.base.BdActivityStack.OnAllActivityClosed
    public void onActivityClosed() {
        getInst().onLowMemory();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CLOSE_ALL_ACTIVITY));
    }

    public void setUseTimeInterval(long j) {
        SharedPrefHelper.getInstance().putLong(SharedPrefConfig.USE_TIME_INTERVAL, j);
        this.useTimeInterval = j;
    }

    public long getUseTimeInterval() {
        return this.useTimeInterval;
    }
}
