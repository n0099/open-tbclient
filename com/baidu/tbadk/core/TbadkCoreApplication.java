package com.baidu.tbadk.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.Cursor;
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
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.base.a;
import com.baidu.adp.base.a.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketDaemonService;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.service.AsyncService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.android.common.util.CommonParam;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.p.n;
import com.baidu.tbadk.t.bd;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.keepLive.nativekeepalive.ClientGuard;
import com.baidu.tieba.keepLive.nativekeepalive.GuardConfigurations;
import com.baidu.tieba.keepLive.nativekeepalive.GuardReceiverObserver;
import com.baidu.tieba.keepLive.nativekeepalive.GuardReceiverWatcher;
import com.baidu.tieba.keepLive.nativekeepalive.GuardServiceObserver;
import com.baidu.tieba.keepLive.nativekeepalive.GuardServiceWatcher;
import com.baidu.tieba.l.c;
import com.baidu.tieba.service.ChangeSkinReceiver;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.ubc.UBC;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MIPushNotificationHelper4Hybrid;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbadkCoreApplication extends BdBaseApplication implements a.InterfaceC0011a, c.a {
    public static final String ACCOUNT_CHANGE_ACTION = "com.baidu.tieba.action.accountChange";
    public static final String ACCOUNT_DATA = "intent_data_accountData";
    private static final String ACTIVE_CLEAR_TAG = "active_clear";
    public static final int APP_ENTER_FORE_SEND_PV_INTERNAL = 3600000;
    public static final int APP_ENTER_FORE_SWITCH = 5;
    public static final int APP_EVENT_LOGIN = 1;
    protected static final String DEFAULT_IMEI = "000000000000000";
    public static final String KEEPLIVESWITCH = "tbKeepLiveSwtich";
    public static final String KEEPLIVESWITCHFILE = "tbKeepLiveSwtichFile";
    protected static final int LOAD_INIT_EIGHT = 8;
    protected static final int LOAD_INIT_FIVE = 5;
    protected static final int LOAD_INIT_FOUR = 4;
    protected static final int LOAD_INIT_NINE = 9;
    protected static final int LOAD_INIT_ONE = 1;
    protected static final int LOAD_INIT_SEVEN = 7;
    protected static final int LOAD_INIT_SIX = 6;
    protected static final int LOAD_INIT_TEN = 10;
    protected static final int LOAD_INIT_THREE = 3;
    protected static final int LOAD_INIT_TWO = 2;
    public static final String SWITCH_PROCESS_NOTIFICATION_KEY = "com.tieba.baidu.notifyprocess";
    public static final String isMem = "IsMem_";
    private Boolean _isMainProcess;
    private com.baidu.tbadk.coreExtra.data.b activityPrizeData;
    private boolean hasInit;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private boolean isBackground;
    protected Boolean isCdnTachometerProcess;
    private boolean isFriendFeedNew;
    protected boolean isRemoteProcess;
    private int keyboardHeight;
    private q listItemRule;
    private a mAccountChangeReceiver;
    private com.baidu.tbadk.coreExtra.data.c mActivitySwitch;
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense;
    private String mAlaMenuToast;
    private ChangeSkinReceiver mChangeSkinReceiver;
    private ClientGuard mClientGuard;
    private String mConfigVersion;
    private Activity mCurrentActivity;
    private f mCustomizedFilter;
    private String mInstallAppIds;
    private long mInterviewLivePollingInterval;
    private boolean mIsFirstTimeMotivate;
    private int mOldSkinType;
    private PersonChangeData mPersonChangeData;
    private t mProfileData;
    private com.baidu.tbadk.coreExtra.c.e mShareItem;
    private com.baidu.tieba.l.c mSplash;
    private SparseArray<Integer> mWaitDownloadTheme;
    private String mYijianfankuiFname;
    private PayMemberInfoData payInfo;
    public long processCreateTime;
    private String task_id;
    private String uegVoiceWarning;
    private String urlText;
    private long useTimeInterval;
    public static boolean isSDKLogin = false;
    private static AccountData mAccount = null;
    private static boolean isChangeAccount = false;
    private static TbadkCoreApplication sApp = null;
    public static boolean IS_SUPPORT_EXCEPTION_HANDLER = true;
    public static boolean IS_SUPPORT_SWIPEBACK = true;
    public static boolean isMyLive = false;
    private static boolean IS_APP_RUNNING = false;
    protected static String mUniqueId = null;
    protected static String clientId = null;
    private static Intent intent = null;
    public static boolean mSquareVideoCanPlayNotWifi = false;
    private static boolean isNeedRefreshOnResume = false;
    private o mConsumePathData = null;
    private int hybridBridgeTimeout = 1000;
    private boolean mThemeWebviewOpened = false;
    private int mSkinType = 0;
    private int mUsedThemeId = 0;
    private int mUsedThemePermissionType = 0;
    private int mUsedThemeColor = 0;
    private boolean isThemeIconCover = true;
    private boolean mCapableOfWebp = false;
    private int mNewVcodeWebviewCrashCount = 0;
    private boolean mIsLocationOn = true;
    protected boolean isThirdProcess = false;
    protected boolean isAiAppsProcess = false;
    protected boolean isPluginInstallProcess = false;
    private int mVoiceHeadsetMode = 0;
    protected boolean isDaemonProcess = false;
    private boolean mIsExitAppCloseWebSocket = false;
    protected int mResumeNum = 0;
    protected long mStartTime = 0;
    protected String mCuid = null;
    private String cuid_galaxy2 = "";
    private String cuid_gid = "";
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
    private boolean isUsedThemeChanged = true;
    private boolean isUserChanged = true;
    private boolean isImmersiveStickyCanUse = true;
    private boolean isImmersiveStickyPrefHasRead = false;
    private View mCustomToastView = null;
    private int mVideoAutoPlayConfig = -1;
    public long currentAccountFlowerNum = 0;
    public long currentAccountTdouNum = 0;
    private String mMultidexError = "";
    private boolean mNeedUploadMultidexError = false;
    private boolean mIsNoInterestTag = false;
    protected boolean isKeepLiveProcess = false;
    private boolean mIsPageStayOpen = false;
    private boolean isMeiZuCanUseImmersiveHaveSet = false;
    private boolean isMeiZuCanUseImmersive = true;
    public Handler handler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.this.getContext());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(TbadkCoreApplication.this.getContext(), true)));
                    return false;
                case 5:
                    if (Boolean.TRUE.equals(message.obj)) {
                        TbadkCoreApplication.this.processUseDuration();
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
    private boolean mIsFromSubprocess = false;
    private Runnable mNotifyBackgroundRunnable = new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.14
        @Override // java.lang.Runnable
        public void run() {
            if (TbadkCoreApplication.this.isInBackground == null) {
                TbadkCoreApplication.this.isInBackground = new AtomicBoolean(false);
            }
            if (!TbadkCoreApplication.this.isInBackground.get()) {
                TbadkCoreApplication.this.isInBackground.set(true);
                if (TbadkCoreApplication.this.isMainProcess(true)) {
                    TbadkCoreApplication.this.fixOppoTimeout();
                    MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(true));
                    ay.nU(null);
                    TiebaStatic.save();
                }
            }
        }
    };
    private boolean isReadMenuDialogTop = false;
    protected AtomicBoolean isInBackground = null;
    a.InterfaceC0015a locationCallBack = new a.InterfaceC0015a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.2
        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                try {
                    String valueOf = String.valueOf(address.getLatitude());
                    String valueOf2 = String.valueOf(address.getLongitude());
                    if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                        TbadkCoreApplication.this.setLocationLat(valueOf);
                        TbadkCoreApplication.this.setLocationLng(valueOf2);
                        TbadkCoreApplication.this.setLocationPos(address.getAddressLine(0));
                        com.baidu.tieba.recapp.d.a.cfz().xQ(valueOf);
                        com.baidu.tieba.recapp.d.a.cfz().xP(valueOf2);
                        com.baidu.tieba.recapp.d.a.cfz().ej(System.currentTimeMillis());
                    }
                } catch (IllegalStateException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    };
    private int mWebviewCrashCount = 0;
    private boolean mGpuOpen = false;
    private boolean mPromotedMessageOn = true;
    private boolean mUseHttpClient = true;
    private boolean mUseHttpAutoSwitch = true;
    private boolean mIsAppOn = false;
    private String mDefaultBubble = null;
    private int mDefaultBubbleEndTime = 0;
    private boolean mHasNewVersion = false;
    private CombineDownload mCombineDownload = null;
    public ArrayList<BaseActivity<?>> mRemoteActivity = null;
    private int mFontSize = 3;
    private HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.a>> mFaces = null;
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
    private boolean isAudioRecorderExist = false;
    private String checkUrl = null;
    private int useNewResign = 0;
    private int mAlaToastShowType = -1;
    private long lastUpdateThemeTime = 0;
    private long lastUpdateMemberCenterTime = 0;
    private boolean showPayInfoRedTip = true;
    private boolean mNeedShowNewVersion = false;
    private boolean mIsNewRegUser = false;
    private com.baidu.tieba.tbadkCore.util.d mReadThreadHistory = null;
    private com.baidu.tieba.tbadkCore.util.c mPhotoLiveReadHistory = null;
    private l.a mToast = null;
    private int mReadThreadPlayerScreenMaxHeight = 0;
    private String mChannelId = "";
    private int cardShowType = 0;
    private int homeBarShowType = 1;
    private boolean needCheckUserNameDialog = true;

    public o getConsumePathData() {
        return this.mConsumePathData;
    }

    public void setConsumePathData(o oVar) {
        this.mConsumePathData = oVar;
    }

    public long getInterviewLivePollingInterval() {
        return this.mInterviewLivePollingInterval;
    }

    public void setInterviewLivePollingInterval(long j) {
        this.mInterviewLivePollingInterval = j;
    }

    public void setVideoAutoPlay(int i) {
        if (this.mVideoAutoPlayConfig != i) {
            this.mVideoAutoPlayConfig = i;
            TbadkSettings.getInst().saveInt("video_auto_play_new", i);
        }
    }

    public int getVideoAutoPlay() {
        if (this.mVideoAutoPlayConfig == -1) {
            return ((com.baidu.tbadk.core.sharedPref.b.agM().getInt("auto_play_video_homepage", 0) == 1) || (com.baidu.tbadk.core.sharedPref.b.agM().getInt("auto_play_video_frs", 0) == 1)) ? 0 : 1;
        }
        return this.mVideoAutoPlayConfig;
    }

    private boolean isGifAutoPlayFromSetting() {
        int i = this.mVideoAutoPlayConfig;
        if (this.mVideoAutoPlayConfig == -1) {
            i = 0;
        }
        if ((i != 0 || (!j.jT() && j.jS())) && i != 2) {
            return i == 1 ? false : false;
        }
        return true;
    }

    public boolean isGifAutoPlay() {
        return bd.iE() && isGifAutoPlayFromSetting();
    }

    public int getVideoAutoPlayReal() {
        return this.mVideoAutoPlayConfig;
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

    public void setFriendFeedNew(final boolean z) {
        this.isFriendFeedNew = z;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(z)));
            }
        });
    }

    public boolean isAppUploadOpen() {
        return com.baidu.adp.lib.b.d.hI().ay("upload_app_lists") == 1;
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

    public boolean isExitAppCloseWebSocket() {
        return this.mIsExitAppCloseWebSocket;
    }

    public void setExitAppCloseWebSocket(boolean z) {
        this.mIsExitAppCloseWebSocket = z;
    }

    public void notifySwitchProcess(boolean z) {
        this.mIsFromSubprocess = !z;
    }

    public boolean canSendForegroundMessage() {
        if (isMainProcess(false)) {
            if (this.mIsFromSubprocess) {
                Intent intent2 = new Intent(SWITCH_PROCESS_NOTIFICATION_KEY);
                intent2.setPackage(getPackageName());
                intent2.putExtra("message", true);
                sendBroadcast(intent2);
                return false;
            }
            return true;
        }
        Intent intent3 = new Intent(SWITCH_PROCESS_NOTIFICATION_KEY);
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

    public boolean isPageStayOpen() {
        return this.mIsPageStayOpen;
    }

    public void setPageStayOpen(boolean z) {
        this.mIsPageStayOpen = z;
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
        AsyncService.INSTANCE.removeRunnable(this.mNotifyBackgroundRunnable);
        if (this.isInBackground == null) {
            this.isInBackground = new AtomicBoolean(true);
        }
        if (this.isInBackground.get()) {
            this.isInBackground.set(false);
            this.mEnterForeCount++;
            if (isMainProcess(true)) {
                if (System.currentTimeMillis() - this.mLastSendEnterForePvTime > 3600000 || this.mLastSendEnterForePvTime == 0) {
                    this.mLastSendEnterForePvTime = System.currentTimeMillis();
                    new k().start();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(false));
            }
        }
    }

    public void notifyAppEnterBackground() {
        AsyncService.INSTANCE.sendRunnable(this.mNotifyBackgroundRunnable);
    }

    public static TbadkCoreApplication getInst() {
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

    public boolean isReadMenuDialogOnTop() {
        return this.isReadMenuDialogTop;
    }

    public void setReadMenuDialogTop(boolean z) {
        this.isReadMenuDialogTop = z;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void processUseDuration() {
        if (this.mResumeNum == 0 && this.mStartTime > 0) {
            long nanoTime = ((System.nanoTime() - this.mStartTime) / 1000000) / 1000;
            if (nanoTime >= getUseTimeInterval()) {
                new ag(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
                TiebaStatic.eventStat(getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(nanoTime));
            }
            this.mStartTime = 0L;
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
        return this.keyboardHeight > getResources().getDimensionPixelSize(R.dimen.ds460);
    }

    public int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    public void setKeyboardHeight(int i) {
        this.keyboardHeight = i;
    }

    public boolean isKeyboardHeightCanSet(int i) {
        return i > getResources().getDimensionPixelSize(R.dimen.ds460);
    }

    private GuardConfigurations createDaemonConfigurations() {
        return new GuardConfigurations(new GuardConfigurations.DaemonConfiguration("com.baidu.tieba:guardService", GuardServiceObserver.class.getCanonicalName(), GuardReceiverObserver.class.getCanonicalName()), new GuardConfigurations.DaemonConfiguration("com.baidu.tieba:warkup", GuardServiceWatcher.class.getCanonicalName(), GuardReceiverWatcher.class.getCanonicalName()), new c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements GuardConfigurations.DaemonListener {
        c() {
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.GuardConfigurations.DaemonListener
        public void onPersistentStart(Context context) {
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.GuardConfigurations.DaemonListener
        public void onDaemonAssistantStart(Context context) {
        }

        @Override // com.baidu.tieba.keepLive.nativekeepalive.GuardConfigurations.DaemonListener
        public void onWatchDaemonDaed() {
        }
    }

    public void saveKeepLiveSwitch(boolean z) {
        EditorHelper.putBoolean(getSharedPreferences(KEEPLIVESWITCHFILE, 0), KEEPLIVESWITCH, z);
    }

    public static boolean getKeepLiveSwitch(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences(KEEPLIVESWITCHFILE, 0)) == null) {
            return true;
        }
        return sharedPreferences.getBoolean(KEEPLIVESWITCH, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        fixOppoTimeout();
        try {
            com.baidu.tieba.l.a.dT(this);
        } catch (Throwable th) {
            if (th != null && th.getMessage() != null) {
                this.mMultidexError = th.getMessage();
            }
            this.mNeedUploadMultidexError = true;
        }
        if (getKeepLiveSwitch(context) && Build.VERSION.SDK_INT < 23) {
            this.mClientGuard = new ClientGuard(createDaemonConfigurations());
            this.mClientGuard.onAttachBaseContext(context);
        }
        AppRuntimeInit.onApplicationattachBaseContext(this);
        com.baidu.pyramid.runtime.multiprocess.e.b(this);
    }

    @Override // com.baidu.tieba.l.c.a
    public com.baidu.tieba.l.c getSplash() {
        if (this.mSplash == null) {
            this.mSplash = new com.baidu.tieba.l.c(this);
        }
        return this.mSplash;
    }

    public final int getMainTabBottomBarHeight() {
        return com.baidu.tbadk.core.util.g.agV() ? l.g(this, R.dimen.ds100) : l.g(this, R.dimen.ds90);
    }

    public final int getMainTabBottomBarHeightId() {
        return com.baidu.tbadk.core.util.g.agV() ? R.dimen.ds100 : R.dimen.ds90;
    }

    @Override // android.app.Application
    public void onCreate() {
        this.processCreateTime = System.currentTimeMillis();
        sApp = this;
        super.onCreate(this);
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.mAppInitHandler.sendMessageAtFrontOfQueue(obtain);
        n.auq().bl(System.currentTimeMillis());
    }

    private void initSapiTask() {
        if (isMainProcess(true)) {
            MessageManager.getInstance().runTask(2921328, null, getContext());
        }
    }

    private void initICDN() {
        long currentTimeMillis = System.currentTimeMillis();
        p.getInstance();
        com.baidu.tbadk.core.util.a.e.getInstance();
        if (isMainProcess(true) && com.baidu.tbadk.core.util.a.e.getInstance() != null) {
            com.baidu.tbadk.core.util.a.e.getInstance().init();
        }
        n.auq().bE(System.currentTimeMillis() - currentTimeMillis);
    }

    private void initJpusbSdk() {
        if (isMainProcess(true)) {
            com.baidu.tieba.r.b.cpo().f(this);
        }
    }

    private void initStatSdk() {
        if (isMainProcess(true)) {
            com.baidu.tieba.r.c.cpr().autoTrace(this);
            com.baidu.tieba.r.c.cpr().setAppChannel(this, getFrom(), true);
        }
    }

    private void initQuickWebViewManager() {
        if (isMainProcess(true)) {
            com.baidu.tieba.quickWebView.c.cek().init();
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.tbadk.coreExtra.messageCenter.d.anf().initSetting();
            n.auq().bF(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void intReadThreadHistory(boolean z) {
        if (z) {
            this.mReadThreadHistory = new com.baidu.tieba.tbadkCore.util.d(300);
            this.mPhotoLiveReadHistory = new com.baidu.tieba.tbadkCore.util.c(300);
            com.baidu.adp.base.a.eM().a(this);
        }
    }

    private void setServiceOnCreateCallBack() {
        BdBaseService.setServiceOnCreateCallBack(new com.baidu.adp.framework.client.socket.link.e() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.15
            @Override // com.baidu.adp.framework.client.socket.link.e
            public void ga() {
                com.baidu.tbadk.util.h.auV().a(new h.a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.15.1
                    @Override // com.baidu.tbadk.util.h.a
                    public void bB(boolean z) {
                        if (z) {
                            BdBaseService.serviceStartFlag = 2;
                        } else {
                            BdBaseService.serviceStartFlag = 1;
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseApplication
    public void handleInitMessage(Message message) {
        switch (message.what) {
            case 1:
                getSharedPreferences("adp_feature_switch", 0);
                initCmdConvertManager();
                InitVersion();
                init(getContext());
                TbFaceManager.aso().a(sApp, new com.baidu.tbadk.editortools.emotiontool.b());
                initTasks();
                registerGoActionTask();
                com.baidu.tbadk.core.a.a.init();
                this.mAppInitHandler.sendEmptyMessage(2);
                return;
            case 2:
                loadPatchs();
                initCustomToastView();
                setServiceOnCreateCallBack();
                this.mAppInitHandler.sendEmptyMessage(3);
                return;
            case 3:
                com.baidu.adp.lib.Disk.d.gt().aa(TbConfig.getTempDirName());
                initAccountChangeReceiver();
                com.baidu.tieba.n.a.cer().init();
                boolean isMainProcess = isMainProcess(false);
                com.baidu.tbadk.distribute.a.aqF().eY(isMainProcess);
                intReadThreadHistory(isMainProcess);
                this.mAppInitHandler.sendEmptyMessage(4);
                return;
            case 4:
                com.baidu.tbadk.coreExtra.a.a.init();
                initSapiTask();
                initChangeSkinReceiver();
                initAccount();
                this.mAppInitHandler.sendEmptyMessage(5);
                return;
            case 5:
                com.baidu.tbadk.n.b.asU().c(this);
                com.baidu.tieba.r.a.cpl().f(this);
                this.mAppInitHandler.sendEmptyMessage(6);
                return;
            case 6:
                registerPhoneListener();
                initICDN();
                initIM();
                initQuickWebViewManager();
                initStatSdk();
                initJpusbSdk();
                if (this.mNeedUploadMultidexError) {
                    com.baidu.tbadk.core.d.a.a("MultiDex", -1L, -1, "installMultidex", -1, this.mMultidexError, new Object[0]);
                }
                if ((this.isCdnTachometerProcess != null && this.isCdnTachometerProcess.booleanValue()) || this.isPluginInstallProcess) {
                    com.baidu.adp.plugin.b.b.C("TbadkApplication_onCreate", "cdn_process");
                    this.mAppInitHandler.sendEmptyMessage(8);
                    return;
                }
                this.mAppInitHandler.sendEmptyMessage(7);
                return;
            default:
                return;
        }
    }

    private void registerGoActionTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002001, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.16
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
                    TiebaStatic.log(new am("inter_config_disappear").P("obj_param1", ah.ahZ().aia()));
                } else if ((data instanceof LoginActivityConfig) && !LoginActivityConfig.canStartActivity()) {
                    return null;
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
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        } catch (ClassNotFoundException e) {
            BdLog.e(e);
        } catch (IllegalAccessException e2) {
            BdLog.e(e2);
        } catch (InterruptedException e3) {
            BdLog.e(e3);
        } catch (NoSuchFieldException e4) {
            BdLog.e(e4);
        }
    }

    private void initIM() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.tieba.im.a.init();
        n.auq().br(System.currentTimeMillis() - currentTimeMillis);
    }

    private void initCmdConvertManager() {
        if (isDebugMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(com.baidu.tbadk.core.frameworkData.b.class.getName());
            arrayList.add(com.baidu.tbadk.core.frameworkData.a.class.getName());
            arrayList.add(CmdConfigHttp.class.getName());
            com.baidu.adp.framework.a.fb().i(arrayList);
        }
    }

    @Deprecated
    private void loadNativeCrashCollectLib() {
        try {
            System.loadLibrary("google_breakpad");
        } catch (Throwable th) {
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
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.tbadk.core.frameworkData.e.initial();
        n.auq().bm(System.currentTimeMillis() - currentTimeMillis);
    }

    private void initLocationSetting() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isMainProcess(true) && mAccount == null) {
            tryLbs();
        }
        n.auq().bD(System.currentTimeMillis() - currentTimeMillis);
    }

    private void initChangeSkinReceiver() {
        if (this.isRemoteProcess) {
            this.mChangeSkinReceiver = new ChangeSkinReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tbadk.data.d.getBroadcastActionChangeSkin());
            registerReceiver(this.mChangeSkinReceiver, intentFilter);
        }
    }

    protected void initAccount() {
        AccountData abk;
        long currentTimeMillis = System.currentTimeMillis();
        if (isMainProcess(true)) {
            try {
                if (getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists() && (abk = com.baidu.tbadk.core.a.b.abk()) != null) {
                    setCurrentAccount(abk, getInst());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            n.auq().bq(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public boolean isRegistedIntent(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        ah.ahZ().RegisterOrUpdateIntent(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        ah.ahZ().RegisterIntent(cls, cls2);
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return ah.ahZ().appResponseToIntentClass(cls);
    }

    public Class<?> getIntentClass(Class<?> cls) {
        return ah.ahZ().getIntentClass(cls);
    }

    public static String getFrom() {
        return TbConfig.getFrom();
    }

    private void init(final Context context) {
        if (!isDebugMode() && TbConfig.IS_CHECK_OFFICAL_APPLICATION) {
            aa.a(new z<Boolean>() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.17
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tbadk.core.util.b.cs(context));
                }
            }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        TbadkCoreApplication.this.mIsOfficial = bool.booleanValue();
                    }
                }
            });
        }
        initCuid();
        initCuidGalaxy2();
        TbConfig.initBigImageMaxUsedMemory(getContext());
        clientId = readClientId(getContext());
        initImei();
        InitFrom();
        initSetting();
        initWebsocketBase(context);
        this.mFontSize = TbadkSettings.getInst().loadInt("font_size", 2);
        this.mVideoAutoPlayConfig = TbadkSettings.getInst().loadInt("video_auto_play_new", -1);
        try {
            com.baidu.adp.lib.d.a.hO().initial();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            com.baidu.tbadk.util.t.avg().Zy();
            if (isMainProcess(false)) {
                com.baidu.tbadk.c.a.Zx().Zy();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        com.baidu.tieba.video.g.cqQ();
        if (isMainProcess(true)) {
            com.baidu.tbadk.imageManager.c.asp().ah(TbConfig.getMaxPhotoMemoryCache(), TbConfig.getBigImageMaxUsedMemory());
        } else {
            com.baidu.tbadk.imageManager.c.asp().ah(0, TbConfig.getBigImageMaxUsedMemoryForRemoteProcess());
        }
        loadLcsSwitchStratgy();
        initSettings();
        this.mFaces = new HashMap<>();
        initSdcardDatabaseCallback();
        ReloginManager.agF().registerTask();
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.addMessageRule(new com.baidu.tbadk.r.f(0));
        messageManager.addMessageRule(new com.baidu.tbadk.r.c(0));
        messageManager.addResponsedMessageRule(new com.baidu.tbadk.r.e(0));
        messageManager.addRemovedMessageRule(new com.baidu.tbadk.r.d(0));
        messageManager.addResponsedMessageRule(new com.baidu.tieba.i.c());
        messageManager.addResponsedMessageRule(new com.baidu.tieba.i.b());
        messageManager.addResponsedMessageRule(new com.baidu.tbadk.r.a());
        messageManager.addResponsedMessageRule(new com.baidu.tbadk.r.b());
        initAppSettings();
        bc.cB(getContext());
        TbConfig.initBigImageWidth(getContext());
        TbConfig.initFriendPhotoConfig(getContext());
        if (IS_SUPPORT_EXCEPTION_HANDLER) {
            com.baidu.tieba.r.d.cps();
        }
        boolean isMainProcess = isMainProcess(false);
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.init(getContext(), isMainProcess);
        n.auq().bC(System.currentTimeMillis() - currentTimeMillis);
        if (isMainProcess) {
            if (getIsFirstUse()) {
                com.baidu.adp.lib.b.d.hI().clear();
                if (!getCapabilityOfWebp()) {
                    TiebaStatic.eventStat(getApp(), "LocalWebpUnSupport", "");
                }
            }
        } else {
            getInst().mRemoteActivity = new ArrayList<>();
        }
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2012000, new CustomMessageTask.CustomRunnable<Intent>() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.19
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
                UtilHelper.commenDealIntent(com.baidu.adp.base.a.eM().eN() == null ? TbadkCoreApplication.this.getApp() : com.baidu.adp.base.a.eM().eN(), customMessage.getData());
                return null;
            }
        });
        aVar.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        dealYYNotification();
        if (isMainProcess(true)) {
            sendMessageForEnterBackground();
        }
        NetMessage.setGlobalSwitchToHttpStrategy(new NetMessage.a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.9
            @Override // com.baidu.adp.framework.message.NetMessage.a
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                return socketResponsedMessage != null && (socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005);
            }
        });
        if (isMainProcess) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921301));
        }
    }

    private int getCrashLimitCount() {
        try {
            int i = com.baidu.tbadk.core.sharedPref.b.agM().getInt("crash_limit_count", 100);
            if (i < 10) {
                return 10;
            }
            return i;
        } catch (Throwable th) {
            return 100;
        }
    }

    public void tryLbs() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.d.a.hO().a(true, TbadkCoreApplication.this.locationCallBack);
            }
        }, 5000L);
    }

    private static void initSdcardDatabaseCallback() {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().a(new a.InterfaceC0012a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.4
            @Override // com.baidu.adp.base.a.a.InterfaceC0012a
            public void c(SQLiteDatabase sQLiteDatabase) {
                TbadkCoreApplication.resetTDatabaseCreateTime();
            }
        });
    }

    public static void resetTDatabaseCreateTime() {
        TbadkSettings.getInst().saveLong("tdatabasecreatetime", new Date().getTime());
    }

    private void initAppSettings() {
        i.abb().initSetting();
    }

    private void dealYYNotification() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2012100, new CustomMessageTask.CustomRunnable<al>() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<al> customMessage) {
                UtilHelper.showYYNotification(TbadkCoreApplication.this.getContext(), customMessage.getData(), 13);
                return null;
            }
        });
        aVar.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
    }

    public String getCuid() {
        if (com.baidu.adp.lib.util.k.isEmpty(this.mCuid)) {
            initCuid();
        }
        return this.mCuid;
    }

    public String getCuidGalaxy2() {
        if (com.baidu.adp.lib.util.k.isEmpty(this.cuid_galaxy2)) {
            initCuidGalaxy2();
        }
        return this.cuid_galaxy2;
    }

    public String getCuidGid() {
        return this.cuid_gid;
    }

    public static void showYYNotification(Context context, al alVar, int i) {
        Intent yYNotificationIntent;
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours < 0 || hours > 7) && hours < 23) {
            String content = alVar.getContent();
            String link = alVar.getLink();
            if (link != null && link.length() > 0 && (yYNotificationIntent = getYYNotificationIntent(context, alVar, link)) != null) {
                NotificationHelper.showNotification(context, i, null, content, content, PendingIntent.getService(context, 0, yYNotificationIntent, 134217728), false);
            }
        }
    }

    public static final Intent getYYNotificationIntent(Context context, al alVar, String str) {
        if (context == null || alVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent2 = new Intent(context, DealIntentService.class);
        if (str.startsWith("http:")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            intent2.putExtra(DealIntentService.KEY_CLASS, 1);
            intent2.putExtra("key_start_from", 7);
            intent2.putExtra("id", substring);
            intent2.putExtra("is_message_pv", true);
        } else if (str.equals("tab://1")) {
            intent2.putExtra(DealIntentService.KEY_CLASS, 3);
            intent2.putExtra("is_message_pv", true);
            intent2.putExtra(FrsActivityConfig.KEY_REFRESH, true);
            intent2.putExtra("close_dialog", true);
            intent2.putExtra("locate_type", 0);
            intent2.setFlags(603979776);
            getInst().setWebviewCrashCount(0);
        } else if (str.startsWith("web:")) {
            if (!str.contains("ftid=")) {
                return null;
            }
            intent2.putExtra(DealIntentService.KEY_CLASS, 29);
            intent2.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
            TiebaStatic.log("c10146");
        } else if (str.startsWith("opfeature:")) {
            try {
                intent2.putExtra(DealIntentService.KEY_CLASS, 0);
                str = str.replaceFirst("opfeature:", "http://");
                intent2.putExtra("url", str);
                intent2.putExtra("is_message_pv", true);
            } catch (Exception e) {
                BdLog.e(e.toString());
                return null;
            }
        } else if (str.startsWith("pk_before:")) {
            intent2.putExtra(DealIntentService.KEY_CLASS, 6);
            intent2.putExtra(UBC.CONTENT_KEY_VALUE, str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("pk_after:")) {
            intent2.putExtra(DealIntentService.KEY_CLASS, 7);
            intent2.putExtra(UBC.CONTENT_KEY_VALUE, str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("vote")) {
            intent2.putExtra(DealIntentService.KEY_CLASS, 8);
        } else if (!str.startsWith("twzb:")) {
            return null;
        } else {
            intent2.putExtra(DealIntentService.KEY_CLASS, 31);
            String substring2 = str.substring(str.lastIndexOf("twzb:") + 5);
            String str2 = "";
            if (substring2.startsWith("pid=")) {
                str2 = substring2.substring(substring2.lastIndexOf("pid=") + 4);
            } else if (substring2.startsWith("http://")) {
                str2 = substring2.substring(substring2.lastIndexOf("p/") + 2);
            }
            if (StringUtils.isNull(str2)) {
                return null;
            }
            intent2.putExtra("tid", str2);
        }
        intent2.putExtra("is_notify", true);
        intent2.putExtra(SelectForumActivityConfig.KEY_SHARE_LINK, str);
        intent2.putExtra(MIPushNotificationHelper4Hybrid.KEY_MESSAGE_ID, alVar.aci());
        intent2.putExtra("task_id", alVar.getTaskId());
        if (!TextUtils.isEmpty(alVar.getStat())) {
            intent2.putExtra("stat", alVar.getStat());
        }
        return intent2;
    }

    public static String getCurrentVerson(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void InitVersion() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
            TbConfig.setVersionType(com.baidu.adp.lib.g.b.f(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void saveString(String str, String str2) {
        com.baidu.tbadk.core.sharedPref.b.agM().putString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String loadString(String str, String str2) {
        return com.baidu.tbadk.core.sharedPref.b.agM().getString(str, str2);
    }

    protected int loadInt(String str, int i) {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt(str, i);
    }

    protected void saveInt(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt(str, i);
    }

    protected long loadLong(String str, long j) {
        return com.baidu.tbadk.core.sharedPref.b.agM().getLong(str, j);
    }

    protected void saveLong(String str, long j) {
        com.baidu.tbadk.core.sharedPref.b.agM().putLong(str, j);
    }

    public static String getClientId() {
        return clientId;
    }

    public void removeClientId(Context context) {
        com.baidu.tbadk.core.sharedPref.b.agM().remove("client_id");
    }

    public static void saveClientId(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.core.sharedPref.b.agM().putString("client_id", TbConfig.getVersion() + "\t" + str);
        }
    }

    public static void setClientId(String str) {
        clientId = str;
    }

    protected void initImei() {
        TelephonyManager telephonyManager;
        try {
            if (ab.cz(getContext()) && (telephonyManager = (TelephonyManager) getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)) != null) {
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
        if (com.baidu.adp.lib.util.k.isEmpty(this.mImei)) {
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
            File mZ = m.mZ(TbConfig.FROM_FILE);
            if (mZ != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(mZ));
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
                File nf = m.nf(TbConfig.FROM_FILE);
                if (nf != null) {
                    FileWriter fileWriter = new FileWriter(nf);
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

    /* JADX WARN: Removed duplicated region for block: B:40:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void InitFrom() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String fromByShare = getFromByShare();
                bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open(LogBuilder.KEY_CHANNEL), "gbk"));
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
        sb.append(com.baidu.adp.lib.util.q.ks());
        if (sb.length() > i) {
            sb.setLength(i);
        }
        return sb.toString();
    }

    protected void initCuid() {
        this.mCuid = loadString("cuid", null);
        if (this.mCuid == null || this.mCuid.length() <= 0) {
            if (ab.cz(getApplicationContext())) {
                this.mCuid = CommonParam.getCUID(getContext());
            }
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

    private void initCuidGalaxy2() {
        this.cuid_galaxy2 = loadString("cuid_galaxy2", null);
        if (this.cuid_galaxy2 == null || this.cuid_galaxy2.length() <= 0) {
            this.cuid_galaxy2 = CommonParam.getCUID(getContext());
            saveString("cuid_galaxy2", this.cuid_galaxy2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        this.useTimeInterval = com.baidu.tbadk.core.sharedPref.b.agM().getLong("use_time_interval", TbConfig.DEFALT_USE_TIME_INTERVAL);
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
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001330, Boolean.valueOf(z)));
        TbadkSettings.getInst().saveBoolean("bd_loc_switcher", z);
    }

    public void incLiveSdkCrashCount() {
        String str = "live_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incXiaoyingCrashCount() {
        TbadkSettings.getInst().saveInt("xiaoying_crash_count", TbadkSettings.getInst().loadInt("xiaoying_crash_count", 0) + 1);
    }

    public boolean isXiaoyingAvaliable() {
        return TbadkSettings.getInst().loadInt("xiaoying_crash_count", 0) <= getFeatureCrashAutoCloseLimit();
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

    public void setPromotedMessage(String str, boolean z) {
        TbadkSettings.getInst().saveBoolean("permoted_message_" + str, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public boolean isPromotedMessageOn(String str) {
        String str2 = "permoted_message_" + str;
        return TbadkSettings.getInst().isContains(str2) ? TbadkSettings.getInst().loadBoolean(str2, true) : this.mPromotedMessageOn;
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

    public void setHttpAutoSwitch(boolean z) {
        TbadkSettings.getInst().saveBoolean("httpclient_autoswitch", z);
        this.mUseHttpAutoSwitch = z;
    }

    public boolean isHttpAutoSwitch() {
        return this.mUseHttpAutoSwitch;
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
        if (BdLog.isDebugMode()) {
        }
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
        ActivityManager activityManager = (ActivityManager) getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            String packageName = getInst().getPackageName();
            String str = packageName + ":cdnTachometer";
            String str2 = packageName + ":daemon";
            String str3 = packageName + ":remote";
            String str4 = packageName + ":third";
            String str5 = packageName + ":pluginInstaller";
            String[] strArr = {str3, str, packageName + ":bdservice_v1", packageName + ":live", packageName + ":cdnTachometer", str2, packageName + ":xiaoying", str5};
            String str6 = packageName + ":guardService";
            String str7 = packageName + ":warkup";
            String str8 = packageName + ":swan";
            int myPid = Process.myPid();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < runningAppProcesses.size()) {
                    if (runningAppProcesses.get(i2).pid != myPid) {
                        i = i2 + 1;
                    } else {
                        String str9 = runningAppProcesses.get(i2).processName;
                        if (str9 != null) {
                            if (str9.equalsIgnoreCase(str2)) {
                                this.isDaemonProcess = true;
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
                            if (str9.equalsIgnoreCase(str5)) {
                                this.isPluginInstallProcess = true;
                            }
                            if (str9.equalsIgnoreCase(str6) || str9.equalsIgnoreCase(str7)) {
                                this.isKeepLiveProcess = true;
                                this._isMainProcess = false;
                                return false;
                            } else if (str9.contains(str8)) {
                                this.isAiAppsProcess = true;
                                this._isMainProcess = false;
                                return false;
                            } else {
                                for (String str10 : strArr) {
                                    if (str9.equalsIgnoreCase(str10)) {
                                        this._isMainProcess = Boolean.FALSE;
                                        return false;
                                    }
                                }
                                return z;
                            }
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
    }

    public static String getCurrentAccount() {
        if (mAccount != null) {
            return mAccount.getID();
        }
        return null;
    }

    public static long getCurrentAccountId() {
        if (mAccount != null) {
            return com.baidu.adp.lib.g.b.c(mAccount.getID(), 0L);
        }
        return 0L;
    }

    public static AccountData getCurrentAccountInfo() {
        return mAccount;
    }

    public static String getCurrentAccountNameShow() {
        if (mAccount != null) {
            return mAccount.getAccountNameShow();
        }
        return null;
    }

    public static String getCurrentBduss() {
        if (mAccount != null) {
            return mAccount.getBDUSS();
        }
        return null;
    }

    public static int getCurrentMemberType() {
        if (mAccount != null) {
            return mAccount.getMemberType();
        }
        return 0;
    }

    public static int getCurrentVipLevel() {
        if (mAccount == null || mAccount.getVipInfo() == null) {
            return 0;
        }
        return mAccount.getVipInfo().getVipLevel();
    }

    public static void setCurrentMemberType(int i) {
        if (mAccount != null) {
            mAccount.setMemberType(i);
        }
    }

    public static String getCurrentTbs() {
        if (mAccount != null) {
            return mAccount.getTbs();
        }
        return null;
    }

    public static void setCurrentAccount(final AccountData accountData, final Context context) {
        if (l.kh()) {
            setCurrentAccountInUI(accountData, context);
        } else {
            getInst().handler.post(new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.6
                @Override // java.lang.Runnable
                public void run() {
                    TbadkCoreApplication.setCurrentAccountInUI(AccountData.this, context);
                }
            });
        }
    }

    public boolean isRemoteProcess() {
        return this.isRemoteProcess;
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
            if (getInst().isPushServiceOpen()) {
                UtilHelper.startPushService(context);
            } else {
                UtilHelper.stopPushService(context);
            }
        }
        sendAccountChangedBroadcast(accountData);
        if (isChangeAccount) {
            getInst().onAccountChanged(accountData, getInst());
            BdSocketLinkService.setHasAbsoluteClose(false);
            BdSocketLinkService.setAvailable(true);
            com.baidu.tbadk.lcs.a.c(0, 0, 0, 1, 2);
            BdSocketLinkService.startService(true, "account changed");
        }
        MessageManager.getInstance().runTask(2004603, (Class) null);
        if (j.jT() && accountData != null) {
            MessageManager.getInstance().runTask(2004611, (Class) null);
        }
        getInst().setActivityPrizeData(null);
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
        BdStatisticsManager.getInstance().setUser(str2, str, str3);
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
        String currentBduss = getCurrentBduss();
        Intent intent2 = new Intent();
        intent2.setAction("adp.bdstatisticsmanager.account_changed");
        intent2.putExtra("intent_data_userid", str);
        intent2.putExtra("intent_data_username", str2);
        intent2.putExtra("intent_data_bduss", currentBduss);
        intent2.setPackage(getInst().getPackageName());
        try {
            getInst().sendStickyBroadcast(intent2);
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
        Intent intent3 = new Intent();
        intent3.setAction(ACCOUNT_CHANGE_ACTION);
        intent3.putExtra(ACCOUNT_DATA, accountData);
        intent3.setPackage(getInst().getPackageName());
        getInst().sendBroadcast(intent3);
        com.baidu.tbadk.n.a.fr(!TextUtils.isEmpty(str));
        if (accountData != null) {
            com.baidu.tbadk.n.a.qA(accountData.getBDUSS());
            com.baidu.tbadk.n.a.setTbs(accountData.getTbs());
            com.baidu.tbadk.n.a.setStoken(accountData.getStoken());
        }
    }

    private void initAccountChangeReceiver() {
        if (isRemoteProcess() && this.mAccountChangeReceiver == null) {
            this.mAccountChangeReceiver = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ACCOUNT_CHANGE_ACTION);
            registerReceiver(this.mAccountChangeReceiver, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TbadkCoreApplication.this.isRemoteProcess() && intent != null && TbadkCoreApplication.ACCOUNT_CHANGE_ACTION.equals(intent.getAction())) {
                Serializable serializableExtra = intent.getSerializableExtra(TbadkCoreApplication.ACCOUNT_DATA);
                if (serializableExtra instanceof AccountData) {
                    AccountData unused = TbadkCoreApplication.mAccount = (AccountData) serializableExtra;
                } else {
                    AccountData unused2 = TbadkCoreApplication.mAccount = null;
                }
                com.baidu.tbadk.n.a.fr(TbadkCoreApplication.isLogin());
                if (TbadkCoreApplication.mAccount != null) {
                    com.baidu.tbadk.n.a.qA(TbadkCoreApplication.mAccount.getBDUSS());
                    com.baidu.tbadk.n.a.setTbs(TbadkCoreApplication.mAccount.getTbs());
                    com.baidu.tbadk.n.a.setStoken(TbadkCoreApplication.mAccount.getStoken());
                }
            }
        }
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

    protected void onAccountChanged(AccountData accountData, Application application) {
        BdLog.e("账号切换");
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("current_used_theme_" + getCurrentAccount(), null);
        if (StringUtils.isNull(string)) {
            this.mUsedThemeId = 0;
            this.mUsedThemePermissionType = 0;
        } else {
            String[] split = string.split("/");
            if (split == null || split.length < 2) {
                this.mUsedThemeId = 0;
                this.mUsedThemePermissionType = 0;
            } else {
                this.mUsedThemeId = com.baidu.adp.lib.g.b.f(split[0], 0);
                this.mUsedThemePermissionType = com.baidu.adp.lib.g.b.f(split[1], 0);
            }
        }
        this.mSkinType = TbadkSettings.getInst().loadInt("skin_" + getCurrentAccount(), 0);
        this.isUserChanged = true;
        clearAccountResource();
        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.7
            @Override // java.lang.Runnable
            public void run() {
                TbadkCoreApplication.this.setThemeSkin();
            }
        }, 600L);
        MessageManager.getInstance().sendMessage(new CustomMessage(2005006, accountData));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005016, accountData));
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2005019, accountData);
        MessageManager.getInstance().registerStickyMode(2005019);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    private void clearAccountResource() {
        TbSingleton.getInstance().clearVideoRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThemeSkin() {
        if (this.mSkinType == 2 && this.mUsedThemeId > 0) {
            setUsedTheme(this.mUsedThemeId, this.mUsedThemePermissionType);
        } else if (this.mSkinType == 1) {
            setSkinType(this.mSkinType);
        } else {
            setSkinType(0);
        }
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

    public int getUsedThemeId() {
        return this.mUsedThemeId;
    }

    public void setUsedTheme(int i, int i2) {
        this.isUsedThemeChanged = false;
        if (i > 0) {
            if (this.isUserChanged || i != this.mUsedThemeId || this.mSkinType != 2) {
                this.isUsedThemeChanged = true;
                this.isUserChanged = false;
                String str = i + ".apk";
                try {
                    com.baidu.tbadk.core.util.al.nJ(str);
                    PackageInfo nd = m.nd(str);
                    if (nd == null || nd.applicationInfo == null || nd.applicationInfo.metaData == null) {
                        setSkinType(0);
                        this.mUsedThemeId = 0;
                    } else {
                        this.mUsedThemeColor = nd.applicationInfo.metaData.getInt("icon_color");
                        this.isThemeIconCover = nd.applicationInfo.metaData.getInt("icon_cover_maintab") != 1;
                        this.mUsedThemeId = i;
                        BitmapHelper.clearThemeCashBitmap();
                        com.baidu.tbadk.core.sharedPref.b.agM().putString("current_used_theme_" + getCurrentAccount(), i + "/" + this.mUsedThemePermissionType);
                        setSkinType(2);
                    }
                } catch (Throwable th) {
                    setSkinType(0);
                    BdLog.e(th);
                }
            }
        }
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

    protected void saveBoolean(String str, boolean z) {
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean(str, z);
    }

    protected boolean loadBoolean(String str, boolean z) {
        return com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(str, z);
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
        return true;
    }

    public void setLocationShared(boolean z) {
        TbadkSettings.getInst().saveBoolean("location_shared_" + getCurrentAccount(), z);
        if (z) {
            tryLbs();
        }
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
        return TbadkSettings.getInst().loadInt(new StringBuilder().append("passport_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.hI().ay("switch_login_passv6") != 1;
    }

    public boolean isAccountsDataFromPass() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append("passport_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.hI().ay("switch_account_data_from_pass") != 1;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public void setUegVoiceWarning(String str) {
        this.uegVoiceWarning = str;
    }

    public boolean isAudioRecorderOpen() {
        return com.baidu.adp.lib.b.d.hI().ay("android_ueg_voice") != 0;
    }

    public boolean isLowVersionPassV6ShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append("passport_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.hI().ay("switch_low_version_login_passv6") != 1;
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
        long currentTimeMillis = System.currentTimeMillis();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new com.baidu.adp.framework.client.socket.link.b() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.8
            @Override // com.baidu.adp.framework.client.socket.link.b
            public boolean fX() {
                return !TbadkCoreApplication.this.isExitAppCloseWebSocket();
            }
        });
        int[] imTimeOut = getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            com.baidu.adp.framework.c.c.gg().c(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            com.baidu.adp.framework.client.socket.h.d(socketReconnStratgy);
        }
        com.baidu.tbadk.coreExtra.e.e.apX().initial();
        MessageManager.getInstance().getSocketClient().a(com.baidu.tbadk.coreExtra.e.e.apX());
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tbadk.coreExtra.e.i());
        try {
            com.baidu.adp.framework.client.socket.coder.d.fV().h(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        com.baidu.tbadk.coreExtra.e.h.aqf().init();
        com.baidu.tbadk.coreExtra.e.g.aqb().init();
        initSocket();
        n.auq().bz(System.currentTimeMillis() - currentTimeMillis);
    }

    public com.baidu.adp.widget.ImageView.a getFace(String str) {
        SoftReference<com.baidu.adp.widget.ImageView.a> softReference = this.mFaces.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.ImageView.a ql = TbFaceManager.aso().ql(str);
        if (ql != null) {
            this.mFaces.put(str, new SoftReference<>(ql));
            return ql;
        }
        return ql;
    }

    private static void initSocket() {
        com.baidu.tbadk.task.b registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.F(false);
        registerImScoketTask.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", getUniqueIdentifier()));
        String apL = com.baidu.tbadk.coreExtra.e.a.apJ().apL();
        if (TextUtils.isEmpty(apL)) {
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
        } else {
            com.baidu.adp.framework.client.socket.h.setUrl(apL);
        }
        com.baidu.adp.framework.client.socket.h.T(TiebaIMConfig.wsExtensions);
        com.baidu.adp.framework.client.socket.h.d(arrayList);
        BdSocketDaemonService.setLinkServiceDisconnectCallBack(new com.baidu.adp.framework.client.socket.link.c() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.10
            @Override // com.baidu.adp.framework.client.socket.link.c
            public void fY() {
                com.baidu.tbadk.util.h.auV().a(new h.a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.10.1
                    @Override // com.baidu.tbadk.util.h.a
                    public void bB(boolean z) {
                        if (!z) {
                            com.baidu.tbadk.lcs.a.c(0, 0, 0, 1, 8);
                            BdSocketLinkService.startService(false, "restart");
                        }
                    }
                });
            }
        });
        BdSocketLinkService.init();
        com.baidu.tbadk.lcs.a.c(0, 0, 0, 1, 9);
        BdSocketLinkService.startService(false, "TiebaImApplication init");
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

    private static com.baidu.tbadk.task.b registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.setResponsedClass(cls);
        bVar.E(z);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }

    public int[] getSocketReconnStratgy() {
        int[] iArr = new int[0];
        try {
            String loadString = TbadkSettings.getInst().loadString("socket_reconn_strategy", "");
            if (loadString != null && !TextUtils.isEmpty(loadString)) {
                String[] split = loadString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
            com.baidu.tbadk.coreExtra.model.c cVar = new com.baidu.tbadk.coreExtra.model.c();
            cVar.parserJson(loadString);
            com.baidu.tbadk.coreExtra.e.c apU = com.baidu.tbadk.coreExtra.e.c.apU();
            apU.eS(cVar.anE() == 1);
            apU.jY(cVar.anF());
            apU.bf(cVar.anG() * 1000);
            if (cVar.anH() != null) {
                apU.i(cVar.anH());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initSettings() {
        boolean z;
        int i;
        AssetManager assets;
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        this.mVoiceHeadsetMode = TbadkSettings.getInst().loadInt("voice_headset_mode", 0);
        if (TbadkSettings.getInst().loadInt("webp_failure_count", -1) == -1) {
            if (Build.VERSION.SDK_INT >= 14 && (assets = getInst().getContext().getAssets()) != null) {
                try {
                    inputStream = assets.open("webp_test/test.webp");
                } catch (IOException e) {
                    e.printStackTrace();
                    inputStream = null;
                }
                if (inputStream != null) {
                    z = BitmapFactory.decodeStream(inputStream) != null;
                    if (z) {
                        i = 6;
                        this.mCapableOfWebp = false;
                    } else {
                        this.mCapableOfWebp = true;
                        i = 0;
                    }
                    TbadkSettings.getInst().saveInt("webp_failure_count", i);
                    TbadkSettings.getInst().saveBoolean("capable_of_webp_format", this.mCapableOfWebp);
                }
            }
            z = false;
            if (z) {
            }
            TbadkSettings.getInst().saveInt("webp_failure_count", i);
            TbadkSettings.getInst().saveBoolean("capable_of_webp_format", this.mCapableOfWebp);
        } else {
            this.mCapableOfWebp = TbadkSettings.getInst().loadBoolean("capable_of_webp_format", false);
        }
        n.auq().bB(System.currentTimeMillis() - currentTimeMillis);
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
        com.baidu.tbadk.core.util.z.hS(i);
        saveInt("networkcore_type", i);
    }

    public long getLastNotifyTime() {
        return TbadkSettings.getInst().loadLong("last_notify_sound_time", 0L);
    }

    public void setLastNotifyTime(long j) {
        TbadkSettings.getInst().saveLong("last_notify_sound_time", j);
    }

    public boolean isDQShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append("dq_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit();
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

    public void setHybridBridgeTimeout(int i) {
        this.hybridBridgeTimeout = (i <= 10 || i >= 5000) ? 1000 : 1000;
    }

    public int getHybridBridgeTimeout() {
        return this.hybridBridgeTimeout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends PhoneStateListener {
        private b() {
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
        if (ab.cz(getContext())) {
            try {
                ((TelephonyManager) getInst().getApp().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).listen(new b(), 32);
            } catch (SecurityException e) {
            } catch (Exception e2) {
            }
        }
    }

    public void sendImagePv(int i, int i2, String str) {
        sendImagePv(i, i2, str, 0, 0);
    }

    public void sendImagePv(int i, int i2, String str, int i3, int i4) {
        if (this.imagePvThread == null) {
            this.imagePvThread = Executors.newSingleThreadExecutor();
        }
        v vVar = new v(i, i2);
        vVar.setType(str);
        this.imagePvThread.execute(vVar);
        TiebaStatic.eventStat(getInst().getApp(), "img_browse", null, 1, "img_num", Integer.valueOf(i), "img_total", Integer.valueOf(i2), "img_type", str, "img_begin", Integer.valueOf(i3), "img_end", Integer.valueOf(i4));
    }

    public void onUserChanged() {
        if (!l.ki()) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2005007));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921410));
        com.baidu.tbadk.coreExtra.messageCenter.b.amy().ew(true);
        NotificationHelper.cancelAllNotification(this);
        com.baidu.tieba.tbadkCore.util.a.cno();
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

    public void incPassportV6CrashCount() {
        String str = "passport_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void setActiveVersion(String str) {
        if (!ap.isEmpty(str) && !"null".equals(str)) {
            m.a.nz("/package.last");
            m.a.ny("/package.last/" + str);
        }
    }

    public boolean getIsFirstUse() {
        if (m.a.fq("/package.cur/" + TbConfig.getVersion())) {
            return false;
        }
        setActiveVersion(m.a.nA("/package.cur"));
        return true;
    }

    public int[] getSocketHeartBeatStratgy() {
        int[] iArr = new int[0];
        try {
            String loadString = TbadkSettings.getInst().loadString("socket_heartbeat_strategy", "");
            if (loadString != null && !TextUtils.isEmpty(loadString)) {
                String[] split = loadString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                String[] split = loadString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        if (this.mHasSignList == null || str == null) {
            return false;
        }
        return this.mHasSignList.containsKey(str);
    }

    public void addSignedForum(String str, int i, int i2) {
        if (!TextUtils.isEmpty(str) && this.mHasSignList != null && this.mSignLevelUpList != null && !hasSignedForum(str)) {
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
        this.mOldSkinType = getInst().getSkinType();
        resetCacheData();
        getInst().setSkinTypeValue(i);
        TbadkSettings.getInst().saveInt("skin_" + getCurrentAccount(), i);
        SendSkinTypeBroadcast(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001304, Integer.valueOf(i)));
    }

    public int getOldSkinType() {
        return this.mOldSkinType;
    }

    public void SendSkinTypeBroadcast(int i) {
        Intent intent2 = new Intent();
        intent2.setAction(com.baidu.tbadk.data.d.getBroadcastActionChangeSkin());
        intent2.putExtra(TbConfig.BROADCAST_FIELD_SKIN_TYPE, i);
        getInst().getContext().sendBroadcast(intent2);
    }

    public static void resetCacheData() {
        com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.11
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.tbadkCore.util.a.cashNoAccountData("", 7);
            }
        });
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("app_inverval", System.currentTimeMillis());
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

    public boolean isAudioRecorderExist() {
        return this.isAudioRecorderExist;
    }

    public void setAudioRecorderExist(boolean z) {
        this.isAudioRecorderExist = z;
    }

    public boolean isLbsWebViewSwitchOn() {
        return com.baidu.adp.lib.b.d.hI().ay("android_lbs_webview_open") != 0;
    }

    public boolean isHybridBridgeEnabled() {
        return com.baidu.adp.lib.b.d.hI().ay("hybridSwitch") == 1;
    }

    public String getCheckUrl() {
        return this.checkUrl;
    }

    public void setCheckUrl(String str) {
        this.checkUrl = str;
    }

    public void setUseNewResign(int i) {
        this.useNewResign = i;
    }

    public int getUseNewResign() {
        return this.useNewResign;
    }

    public String getAlaMenuToast() {
        return this.mAlaMenuToast;
    }

    public void setAlaMenuToast(String str) {
        this.mAlaMenuToast = str;
    }

    public void setAlaToastShowType(int i) {
        this.mAlaToastShowType = i;
    }

    public int getAlaToastShowType() {
        return this.mAlaToastShowType;
    }

    public void setGameInfoData(String str, long j, String str2) {
        this.infoIconUrl = str;
        this.infoTimeStamp = j;
        this.infoTargetUrl = str2;
    }

    public String getGameInfoIconUrl() {
        return this.infoIconUrl;
    }

    public long getGameInfoTimeStamp() {
        return this.infoTimeStamp;
    }

    public String getGameInfoTargetUrl() {
        return this.infoTargetUrl;
    }

    public long getLastUpdateThemeTime() {
        return this.lastUpdateThemeTime;
    }

    public void setLastUpdateThemeTime(long j) {
        this.lastUpdateThemeTime = j;
    }

    public long getLastUpdateMemberCenterTime() {
        return this.lastUpdateMemberCenterTime;
    }

    public void setLastUpdateMemberCenterTime(long j) {
        this.lastUpdateMemberCenterTime = j;
    }

    public void setPaymemberInfo(PayMemberInfoData payMemberInfoData) {
        this.payInfo = payMemberInfoData;
    }

    public PayMemberInfoData getPaymemberInfo() {
        return this.payInfo;
    }

    public void setShowPayInfoRedTip(boolean z) {
        this.showPayInfoRedTip = z;
    }

    public boolean getShowPayInfoRedTip() {
        return this.showPayInfoRedTip;
    }

    public String getActiveVersion() {
        String nA;
        if (!m.a.fq("/package.last")) {
            nA = TbadkSettings.getInst().loadString("active_version", "");
        } else {
            nA = m.a.nA("/package.last");
        }
        if (ACTIVE_CLEAR_TAG.equals(nA)) {
            return null;
        }
        return nA;
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
        return com.baidu.adp.lib.b.d.hI().ay("offline_gift") != 1;
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
            if (j.jT()) {
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
            com.baidu.adp.framework.c.c.gg().c(iArr[0], iArr[1], iArr[2]);
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
        Intent intent2 = new Intent(TbConfig.getBroadcastActionNewVersion());
        intent2.setPackage(getInst().getPackageName());
        getApp().sendBroadcast(intent2);
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

    public String getInstalledAppIds() {
        return this.mInstallAppIds;
    }

    public void setInstalledAppIds(String str) {
        this.mInstallAppIds = str;
    }

    public void setAdAdSense(com.baidu.tbadk.coreExtra.data.d dVar) {
        this.mAdAdSense = dVar;
        if (this.mAdAdSense != null && this.mAdAdSense.akU() != null) {
            com.baidu.tbadk.coreExtra.data.g akU = this.mAdAdSense.akU();
            MessageManager.getInstance().registerStickyMode(2001434);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001434, akU));
        }
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public void setActivitySwitch(com.baidu.tbadk.coreExtra.data.c cVar) {
        this.mActivitySwitch = cVar;
    }

    public void setProfileData(t tVar) {
        this.mProfileData = tVar;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public void setUsed() {
        m.a.nz("/package.cur");
        m.a.ny("/package.cur/" + TbConfig.getVersion());
    }

    public com.baidu.tieba.tbadkCore.util.d getReadThreadHistory() {
        return this.mReadThreadHistory;
    }

    public com.baidu.tieba.tbadkCore.util.c getPhotoLiveReadThreadHistory() {
        return this.mPhotoLiveReadHistory;
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
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.f("delete from cash_data where type=?", new String[]{String.valueOf(i)});
        return mainDBDatabaseManager.f("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
    }

    public void deleteAccountAllInfo(String str) {
        if (str != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.f("delete from cash_data where account=?", new String[]{str});
            mainDBDatabaseManager.f("delete from mark_data where account=?", new String[]{str});
            mainDBDatabaseManager.f("delete from draft_box where account=?", new Object[]{str});
            mainDBDatabaseManager.f("delete from account_data where id=?", new Object[]{str});
            mainDBDatabaseManager.f("delete from setting where account=?", new Object[]{str});
        }
    }

    public String getNoAccountData(int i) {
        Cursor cursor;
        Throwable th;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from cash_data where type=? ", new String[]{String.valueOf(i)});
            try {
                try {
                    r0 = cursor.moveToFirst() ? cursor.getString(2) : null;
                    com.baidu.adp.lib.g.a.e(cursor);
                } catch (Exception e) {
                    e = e;
                    mainDBDatabaseManager.c(e, "getNoAccountData");
                    com.baidu.adp.lib.g.a.e(cursor);
                    return r0;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.e(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.g.a.e(cursor);
            throw th;
        }
        return r0;
    }

    public void incCrabSdkCrashCount() {
        String str = "crab_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isCrabSdkShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append("crab_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.hI().ay("android_crab_enable") == 1;
    }

    private boolean isCrabSdkCrashUp2Limit() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append("crab_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) > getFeatureCrashAutoCloseLimit();
    }

    public void incXiaomiPushSdkCrashCount() {
        String str = "xiaomi_push_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isXiaomiPushSdkShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append("xiaomi_push_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.hI().ay("switch_xiaomipush_sdk") != 0;
    }

    public void incWalletSdkCrashCount() {
        String str = "wallet_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isWalletShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append("wallet_crash_count").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.hI().ay("baidu_wallet_enable") != 0;
    }

    public boolean appResponseToCmd(int i) {
        return MessageManager.getInstance().findTask(i) != null;
    }

    public f getCustomizedFilter() {
        return this.mCustomizedFilter;
    }

    public void setCustomizedFilter(f fVar) {
        if (this.mCustomizedFilter != null) {
            BdLog.e("you cannot set CustomizedFilter again");
        }
        if (fVar != null) {
            if (fVar.gJ(2) && !fVar.gJ(-1)) {
                BdLog.e("you should add CustomGroupType.PERSONAL_GROUP in the filter");
            }
            if (fVar.gJ(4) && !fVar.gJ(-9)) {
                BdLog.e("you should add CustomGroupType.OFFICIAL_GROUP in the filter");
            }
        }
        this.mCustomizedFilter = fVar;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        onAppMemoryLow();
        super.onLowMemory();
    }

    public boolean isImmersiveStickyCanUse() {
        if (!this.isImmersiveStickyPrefHasRead) {
            this.isImmersiveStickyCanUse = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("switch_immersive_sticky_status", true);
            this.isImmersiveStickyPrefHasRead = true;
        }
        return this.isImmersiveStickyCanUse;
    }

    public boolean isMeiZuCanUseImmersive() {
        if (!this.isMeiZuCanUseImmersiveHaveSet) {
            this.isMeiZuCanUseImmersiveHaveSet = true;
            String str = Build.BRAND;
            String str2 = Build.MODEL;
            if (UtilHelper.isMeizuM355()) {
                this.isMeiZuCanUseImmersive = false;
                return this.isMeiZuCanUseImmersive;
            }
        }
        return this.isMeiZuCanUseImmersive;
    }

    public void setIsMeiZuCanUseImmersive(boolean z) {
        this.isMeiZuCanUseImmersiveHaveSet = true;
        this.isMeiZuCanUseImmersive = z;
    }

    public void resetIsImmersiveStickyPrefHasRead(boolean z) {
        this.isImmersiveStickyPrefHasRead = z;
    }

    @Override // com.baidu.adp.base.BdBaseApplication
    public void onAppMemoryLow() {
        int asr = com.baidu.tbadk.imageManager.c.asp().asr();
        int max = (int) Math.max(asr * 0.8d, TbConfig.getBigImageMaxUsedMemory());
        if (max < asr) {
            if (BdLog.isDebugMode()) {
            }
            com.baidu.tbadk.imageManager.c.asp().kx(max);
        }
        BitmapHelper.clearCashBitmap();
        com.baidu.adp.lib.util.d.jA().clearCashBitmap();
    }

    public q getListItemRule() {
        if (this.listItemRule == null) {
            this.listItemRule = new q();
        }
        return this.listItemRule;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivityPrizeData() {
        if (this.activityPrizeData == null) {
            this.activityPrizeData = new com.baidu.tbadk.coreExtra.data.b();
            String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("activity_prize_data" + getCurrentAccount(), "");
            if (!StringUtils.isNull(string)) {
                try {
                    this.activityPrizeData.parse(new JSONObject(string));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return this.activityPrizeData;
    }

    public void setActivityPrizeData(com.baidu.tbadk.coreExtra.data.b bVar) {
        this.activityPrizeData = bVar;
    }

    public boolean isRunInFrontend() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) getInst().getApp().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() == 0) {
            return false;
        }
        return runningTasks.get(0).baseActivity.getPackageName().equals(getPackageName());
    }

    @Override // com.baidu.adp.base.a.InterfaceC0011a
    public void onActivityClosed() {
        getInst().onLowMemory();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2002014));
    }

    private void initCustomToastView() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mToast == null && l.km() == null) {
            this.mToast = new l.a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.12
                @Override // com.baidu.adp.lib.util.l.a
                public void bl(String str) {
                    if (ko() instanceof TextView) {
                        ((TextView) ko()).setText(str);
                    }
                }

                @Override // com.baidu.adp.lib.util.l.a
                public View ko() {
                    if (TbadkCoreApplication.this.mCustomToastView == null) {
                        TbadkCoreApplication.this.mCustomToastView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.custom_toast_textview, (ViewGroup) null);
                    }
                    return TbadkCoreApplication.this.mCustomToastView;
                }
            };
            l.a(this.mToast);
            n.auq().bA(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public int getUsedThemeColor() {
        return this.mUsedThemeColor;
    }

    public void setUsedThemeColor(int i) {
        this.mUsedThemeColor = i;
    }

    public boolean isThemeIconCover() {
        return this.isThemeIconCover;
    }

    public void setThemeIconCover(boolean z) {
        this.isThemeIconCover = z;
    }

    public boolean isUsedThemeChanged() {
        return this.isUsedThemeChanged;
    }

    public boolean getThemeWebviewOpen() {
        return this.mThemeWebviewOpened;
    }

    public void setThemeWebviewOpen(boolean z) {
        this.mThemeWebviewOpened = z;
    }

    public SparseArray<Integer> getWaitDownloadTheme() {
        return this.mWaitDownloadTheme;
    }

    @SuppressLint({"UseSparseArrays"})
    public void addThemeToWaitDownloadQuene(int i) {
        if (this.mWaitDownloadTheme == null) {
            this.mWaitDownloadTheme = new SparseArray<>();
        }
        this.mWaitDownloadTheme.put(i, 1);
    }

    public void deleteThemeFromWaitDownloadQuene(int i) {
        if (this.mWaitDownloadTheme != null) {
            this.mWaitDownloadTheme.remove(i);
        }
    }

    public int getThemeFromWaitDownloadQuene(int i) {
        if (this.mWaitDownloadTheme == null) {
            return 0;
        }
        return this.mWaitDownloadTheme.get(i, 0).intValue();
    }

    public void setReadThreadPlayerScreenMaxHeight(int i) {
        this.mReadThreadPlayerScreenMaxHeight = i;
    }

    public int getReadThreadPlayerScreenMaxHeight() {
        return this.mReadThreadPlayerScreenMaxHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadPatchs() {
    }

    public void incBaiduYunPushCrashCount() {
        String str = "baidu_yun_push_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isBaiduYunPushAvailable() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append("baidu_yun_push_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.hI().ay("android_baiduyun_push") == 1;
    }

    public void setIsNoInterestTag(boolean z) {
        this.mIsNoInterestTag = z;
    }

    public boolean isNoInterestTag() {
        return this.mIsNoInterestTag;
    }

    public void setIsFirstTimeMotivate(boolean z) {
        this.mIsFirstTimeMotivate = z;
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_recommend_forums_window_", true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921029));
        }
    }

    public boolean isFirstTimeMotivate() {
        return this.mIsFirstTimeMotivate;
    }

    public void setUrlText(String str) {
        this.urlText = str;
    }

    public String getUrlText() {
        return this.urlText;
    }

    public String getYunpushChannelId() {
        if (TextUtils.isEmpty(this.mChannelId)) {
            this.mChannelId = com.baidu.tbadk.core.sharedPref.b.agM().getString("yunpush_channel_id", "");
        }
        return this.mChannelId;
    }

    public void setYunpushChannelId(String str) {
        com.baidu.tbadk.core.sharedPref.b.agM().putString("yunpush_channel_id", str);
    }

    public com.baidu.tbadk.coreExtra.c.e getShareItem() {
        return this.mShareItem;
    }

    public void setShareItem(com.baidu.tbadk.coreExtra.c.e eVar) {
        this.mShareItem = eVar;
    }

    public void setUseTimeInterval(long j) {
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("use_time_interval", j);
        this.useTimeInterval = j;
    }

    public long getUseTimeInterval() {
        return this.useTimeInterval;
    }

    public int getCardShowType() {
        if (!this.hasInit) {
            this.cardShowType = com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_card_show_type", 0);
        }
        return this.cardShowType;
    }

    public void setCardShowType(int i) {
        this.hasInit = true;
        this.cardShowType = i;
    }

    public void setHomeBarShowType(int i) {
        this.homeBarShowType = i;
    }

    public int getHomeBarShowType() {
        return this.homeBarShowType;
    }

    public void setNeedCheckUserNameDialog(boolean z) {
        this.needCheckUserNameDialog = z;
    }

    public boolean shouldNeedCheckUserNameDialog() {
        return this.needCheckUserNameDialog;
    }
}
