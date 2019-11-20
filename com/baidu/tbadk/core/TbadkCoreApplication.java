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
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.service.AsyncService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.util.q;
import com.baidu.android.common.util.DeviceId;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.p.n;
import com.baidu.tbadk.t.bd;
import com.baidu.tbadk.t.bo;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.y;
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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
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
    private r listItemRule;
    private a mAccountChangeReceiver;
    private com.baidu.tbadk.coreExtra.data.c mActivitySwitch;
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense;
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
    private u mProfileData;
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
    public Handler handler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.11
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    com.baidu.tbadk.core.e.a.a("account", -1L, 0, "application_clear_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.this.getContext());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TbadkCoreApplication.this.getContext(), true)));
                    break;
                case 5:
                    if (Boolean.TRUE.equals(message.obj)) {
                        TbadkCoreApplication.this.processUseDuration();
                        TbadkCoreApplication.this.notifyAppEnterBackground();
                        break;
                    } else {
                        TbadkCoreApplication.this.notifyAppEnterForehead();
                        break;
                    }
            }
            return false;
        }
    });
    private boolean mIsFromSubprocess = false;
    private Runnable mNotifyBackgroundRunnable = new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.16
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
                    ay.setCurrentActivity(null);
                    TiebaStatic.save();
                }
            }
        }
    };
    private boolean isReadMenuDialogTop = false;
    protected AtomicBoolean isInBackground = null;
    a.InterfaceC0015a locationCallBack = new a.InterfaceC0015a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.4
        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                try {
                    String valueOf = String.valueOf(address.getLatitude());
                    String valueOf2 = String.valueOf(address.getLongitude());
                    if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                        TbadkCoreApplication.this.setLocationLat(valueOf);
                        TbadkCoreApplication.this.setLocationLng(valueOf2);
                        TbadkCoreApplication.this.setLocationPos(address.getAddressLine(0));
                        com.baidu.tieba.recapp.d.a.cgB().xv(valueOf);
                        com.baidu.tieba.recapp.d.a.cgB().xu(valueOf2);
                        com.baidu.tieba.recapp.d.a.cgB().dQ(System.currentTimeMillis());
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
            TbadkSettings.getInst().saveInt(SharedPrefConfig.PREFS_VIDEO_AUTO_PLAY, i);
        }
    }

    public int getVideoAutoPlay() {
        if (this.mVideoAutoPlayConfig == -1) {
            return ((com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_HOMEPAGE, 0) == 1) || (com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1)) ? 0 : 1;
        }
        return this.mVideoAutoPlayConfig;
    }

    private boolean isGifAutoPlayFromSetting() {
        int i = this.mVideoAutoPlayConfig;
        if (this.mVideoAutoPlayConfig == -1) {
            i = 0;
        }
        if ((i != 0 || (!j.isWifiNet() && j.isNetWorkAvailable())) && i != 2) {
            return i == 1 ? false : false;
        }
        return true;
    }

    public boolean isGifAutoPlay() {
        return bd.isOn() && isGifAutoPlayFromSetting();
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_EMOTION, new com.baidu.tbadk.mainTab.a(z)));
            }
        });
    }

    public boolean isAppUploadOpen() {
        return com.baidu.adp.lib.b.d.ft().af("upload_app_lists") == 1;
    }

    public static boolean checkNeedShowNewVersion() {
        if (getInst().checkNeedShowNewVersionFlag()) {
            Long valueOf = Long.valueOf(getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            getInst().setUpdateNotifyTime(valueOf2.longValue());
            if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_VERSION_MSG));
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
                if (System.currentTimeMillis() - this.mLastSendEnterForePvTime > BdKVCache.MILLS_1Hour || this.mLastSendEnterForePvTime == 0) {
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
        com.baidu.tbadk.core.c.a.agD().agF();
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
                new ag("use", String.valueOf(nanoTime)).start();
                TiebaStatic.eventStat(getInst().getApp(), "use", null, 1, "st_param", String.valueOf(nanoTime));
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
            com.baidu.tieba.l.a.dJ(this);
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
        com.baidu.pyramid.runtime.multiprocess.e.c(this);
    }

    @Override // com.baidu.tieba.l.c.a
    public com.baidu.tieba.l.c getSplash() {
        if (this.mSplash == null) {
            this.mSplash = new com.baidu.tieba.l.c(this);
        }
        return this.mSplash;
    }

    public final int getMainTabBottomBarHeight() {
        return com.baidu.tbadk.core.util.g.alV() ? l.getDimens(this, R.dimen.ds100) : l.getDimens(this, R.dimen.ds90);
    }

    public final int getMainTabBottomBarHeightId() {
        return com.baidu.tbadk.core.util.g.alV() ? R.dimen.ds100 : R.dimen.ds90;
    }

    @Override // android.app.Application
    public void onCreate() {
        this.processCreateTime = System.currentTimeMillis();
        sApp = this;
        super.onCreate(this);
        getSharedPreferences("adp_feature_switch", 0);
        initCmdConvertManager();
        InitVersion();
        init(getContext());
        TbFaceManager.avr().a(sApp, new com.baidu.tbadk.editortools.emotiontool.b());
        initTasks();
        registerGoActionTask();
        com.baidu.tbadk.core.a.a.init();
        initAccount();
        initInterruptRule();
        initSapiTask();
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.mAppInitHandler.sendMessageAtFrontOfQueue(obtain);
        n.awQ().bd(System.currentTimeMillis());
    }

    private void initSapiTask() {
        if (isMainProcess(true)) {
            MessageManager.getInstance().runTask(CmdConfigCustom.CMD_SAPI_INIT, null, getContext());
        }
    }

    private void initICDN() {
        if (bo.isOn()) {
            final BDHttpDns ag = BDHttpDns.ag(getApplicationContext());
            ag.S(false);
            try {
                ag.bo("119799");
                ag.bp("87JNTZjGacgUzuMBYvid");
            } catch (Exception e) {
                BdLog.e(e);
            }
            ag.R(true);
            ag.d(true, true);
            ag.a(BDHttpDns.CachePolicy.POLICY_TOLERANT);
            if (isMainProcess(true)) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.17
                    @Override // java.lang.Runnable
                    public void run() {
                        ag.bn("prefetch");
                    }
                }, 1000L);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        p.getInstance();
        com.baidu.tbadk.core.util.a.e.getInstance();
        if (isMainProcess(true) && com.baidu.tbadk.core.util.a.e.getInstance() != null) {
            com.baidu.tbadk.core.util.a.e.getInstance().init();
        }
        n.awQ().bw(System.currentTimeMillis() - currentTimeMillis);
    }

    private void initJpusbSdk() {
        if (isMainProcess(true)) {
            com.baidu.tieba.r.b.cqX().g(this);
        }
    }

    private void initStatSdk() {
        if (isMainProcess(true)) {
            com.baidu.tieba.r.c.cra().autoTrace(this);
            com.baidu.tieba.r.c.cra().setAppChannel(this, getFrom(), true);
        }
    }

    private void initQuickWebViewManager() {
        if (isMainProcess(true)) {
            com.baidu.tieba.quickWebView.c.cfi().init();
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.tbadk.coreExtra.messageCenter.d.aqY().initSetting();
            n.awQ().bx(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void intReadThreadHistory(boolean z) {
        if (z) {
            this.mReadThreadHistory = new com.baidu.tieba.tbadkCore.util.d(300);
            this.mPhotoLiveReadHistory = new com.baidu.tieba.tbadkCore.util.c(300);
            com.baidu.adp.base.a.em().a(this);
        }
    }

    private void setServiceOnCreateCallBack() {
        BdBaseService.setServiceOnCreateCallBack(new com.baidu.adp.framework.client.socket.link.e() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.18
            @Override // com.baidu.adp.framework.client.socket.link.e
            public void onServiceCreate() {
                com.baidu.tbadk.util.h.axv().a(new h.a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.18.1
                    @Override // com.baidu.tbadk.util.h.a
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseApplication
    public void handleInitMessage(Message message) {
        switch (message.what) {
            case 1:
                loadPatchs();
                initCustomToastView();
                setServiceOnCreateCallBack();
                this.mAppInitHandler.sendEmptyMessage(2);
                return;
            case 2:
                com.baidu.adp.lib.Disk.d.eP().initial(TbConfig.getTempDirName());
                initAccountChangeReceiver();
                com.baidu.tieba.n.a.cfn().init();
                boolean isMainProcess = isMainProcess(false);
                com.baidu.tbadk.distribute.a.atL().eZ(isMainProcess);
                intReadThreadHistory(isMainProcess);
                this.mAppInitHandler.sendEmptyMessage(3);
                return;
            case 3:
                com.baidu.tbadk.coreExtra.a.a.init();
                initChangeSkinReceiver();
                this.mAppInitHandler.sendEmptyMessage(4);
                return;
            case 4:
                com.baidu.tbadk.n.b.avH().d(this);
                com.baidu.tieba.r.a.cqU().g(this);
                if (!CyberPlayerManager.isCoreLoaded(1)) {
                    CyberPlayerManager.install(getContext(), getCuid(), null, 1, null, null, null);
                }
                this.mAppInitHandler.sendEmptyMessage(5);
                return;
            case 5:
                registerPhoneListener();
                initICDN();
                initIM();
                initQuickWebViewManager();
                initStatSdk();
                initJpusbSdk();
                if (this.mNeedUploadMultidexError) {
                    com.baidu.tbadk.core.e.a.a("MultiDex", -1L, -1, "installMultidex", -1, this.mMultidexError, new Object[0]);
                }
                if ((this.isCdnTachometerProcess != null && this.isCdnTachometerProcess.booleanValue()) || this.isPluginInstallProcess) {
                    com.baidu.adp.plugin.b.b.r("TbadkApplication_onCreate", "cdn_process");
                    this.mAppInitHandler.sendEmptyMessage(7);
                    return;
                }
                this.mAppInitHandler.sendEmptyMessage(6);
                return;
            default:
                return;
        }
    }

    private void initInterruptRule() {
        MessageManager.getInstance().addMessageRule(new com.baidu.adp.framework.a.d(0) { // from class: com.baidu.tbadk.core.TbadkCoreApplication.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.a.f
            /* renamed from: d */
            public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
                if (TbadkCoreApplication.this.checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(httpMessage.getCmd()))) {
                    return null;
                }
                return httpMessage;
            }
        });
        MessageManager.getInstance().addMessageRule(new com.baidu.adp.framework.a.k(0) { // from class: com.baidu.tbadk.core.TbadkCoreApplication.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.a.f
            /* renamed from: d */
            public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
                if (TbadkCoreApplication.this.checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(socketMessage.getCmd()))) {
                    return null;
                }
                return socketMessage;
            }
        });
    }

    private void registerGoActionTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_GO_ACTION, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.21
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
                    TiebaStatic.log(new an("inter_config_disappear").O("obj_param1", ah.amz().getConfigSize()));
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
        n.awQ().bj(System.currentTimeMillis() - currentTimeMillis);
    }

    private void initCmdConvertManager() {
        if (isDebugMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(com.baidu.tbadk.core.frameworkData.b.class.getName());
            arrayList.add(com.baidu.tbadk.core.frameworkData.a.class.getName());
            arrayList.add(CmdConfigHttp.class.getName());
            com.baidu.adp.framework.a.eu().init(arrayList);
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
        n.awQ().be(System.currentTimeMillis() - currentTimeMillis);
    }

    private void initLocationSetting() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isMainProcess(true) && mAccount == null) {
            tryLbs();
        }
        n.awQ().bv(System.currentTimeMillis() - currentTimeMillis);
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
        AccountData ags;
        long currentTimeMillis = System.currentTimeMillis();
        if (isMainProcess(true)) {
            try {
                if (getInst().getDatabasePath("baidu_tieba.db").exists() && (ags = com.baidu.tbadk.core.a.b.ags()) != null) {
                    com.baidu.tbadk.core.e.a.a("account", -1L, 0, "application_init_account", 0, "", new Object[0]);
                    setCurrentAccount(ags, getInst());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            n.awQ().bi(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public boolean isRegistedIntent(Class<?> cls) {
        return getIntentClass(cls) != null;
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        ah.amz().RegisterOrUpdateIntent(cls, cls2);
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        ah.amz().RegisterIntent(cls, cls2);
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        return ah.amz().appResponseToIntentClass(cls);
    }

    public Class<?> getIntentClass(Class<?> cls) {
        return ah.amz().getIntentClass(cls);
    }

    public static String getFrom() {
        return TbConfig.getFrom();
    }

    private void init(final Context context) {
        if (!isDebugMode() && TbConfig.IS_CHECK_OFFICAL_APPLICATION) {
            z.a(new y<Boolean>() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.22
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.y
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tbadk.core.util.b.cp(context));
                }
            }, new com.baidu.tbadk.util.j<Boolean>() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
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
        this.mFontSize = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_FONT_SIZE, 2);
        this.mVideoAutoPlayConfig = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_VIDEO_AUTO_PLAY, -1);
        try {
            com.baidu.adp.lib.d.a.fw().initial();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            s.axF().registerNetworkChangedListener();
            if (isMainProcess(false)) {
                com.baidu.tbadk.c.a.afi().registerNetworkChangedListener();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (isMainProcess(true)) {
            com.baidu.tbadk.imageManager.c.avs().initial(TbConfig.getMaxPhotoMemoryCache(), TbConfig.getBigImageMaxUsedMemory());
        } else {
            com.baidu.tbadk.imageManager.c.avs().initial(0, TbConfig.getBigImageMaxUsedMemoryForRemoteProcess());
        }
        loadLcsSwitchStratgy();
        initSettings();
        this.mFaces = new HashMap<>();
        initSdcardDatabaseCallback();
        ReloginManager.alI().registerTask();
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
        bc.initSkinDataOnStartup(getContext());
        TbConfig.initBigImageWidth(getContext());
        TbConfig.initFriendPhotoConfig(getContext());
        if (IS_SUPPORT_EXCEPTION_HANDLER) {
            com.baidu.tieba.r.d.crb();
        }
        com.baidu.tieba.video.g.csB();
        boolean isMainProcess = isMainProcess(false);
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.init(getContext(), isMainProcess);
        n.awQ().bu(System.currentTimeMillis() - currentTimeMillis);
        if (isMainProcess) {
            if (getIsFirstUse()) {
                com.baidu.adp.lib.b.d.ft().clear();
                if (!getCapabilityOfWebp()) {
                    TiebaStatic.eventStat(getApp(), "LocalWebpUnSupport", "");
                }
            }
        } else {
            getInst().mRemoteActivity = new ArrayList<>();
        }
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.DEAL_INTENT, new CustomMessageTask.CustomRunnable<Intent>() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
                UtilHelper.commenDealIntent(com.baidu.adp.base.a.em().currentActivity() == null ? TbadkCoreApplication.this.getApp() : com.baidu.adp.base.a.em().currentActivity(), customMessage.getData());
                return null;
            }
        });
        aVar.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        dealYYNotification();
        if (isMainProcess(true)) {
            sendMessageForEnterBackground();
        }
        NetMessage.setGlobalSwitchToHttpStrategy(new NetMessage.a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.12
            @Override // com.baidu.adp.framework.message.NetMessage.a
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                return socketResponsedMessage != null && (socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005);
            }
        });
        if (isMainProcess) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KEEPLIVE_START_ACTIVITY));
        }
    }

    private int getCrashLimitCount() {
        try {
            int i = com.baidu.tbadk.core.sharedPref.b.alP().getInt("crash_limit_count", 100);
            if (i < 10) {
                return 10;
            }
            return i;
        } catch (Throwable th) {
            return 100;
        }
    }

    public void tryLbs() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.d.a.fw().a(true, TbadkCoreApplication.this.locationCallBack);
            }
        }, 5000L);
    }

    private static void initSdcardDatabaseCallback() {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().a(new a.InterfaceC0012a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.6
            @Override // com.baidu.adp.base.a.a.InterfaceC0012a
            public void onDatabaseCreated(SQLiteDatabase sQLiteDatabase) {
                TbadkCoreApplication.resetTDatabaseCreateTime();
            }
        });
    }

    public static void resetTDatabaseCreateTime() {
        TbadkSettings.getInst().saveLong(SharedPrefConfig.TDATABASECREATETIME, new Date().getTime());
    }

    private void initAppSettings() {
        i.ago().initSetting();
    }

    private void dealYYNotification() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.DEAL_YY_NOTIFICATION, new CustomMessageTask.CustomRunnable<al>() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.7
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
        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP)) {
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
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
            if (!str.contains("ftid=")) {
                return null;
            }
            intent2.putExtra(DealIntentService.KEY_CLASS, 29);
            intent2.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
            TiebaStatic.log(TbadkCoreStatisticKey.PUSH_RECOMMEND_PB_RECEIVE);
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE)) {
            try {
                intent2.putExtra(DealIntentService.KEY_CLASS, 0);
                str = str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE, "http://");
                intent2.putExtra("url", str);
                intent2.putExtra("is_message_pv", true);
            } catch (Exception e) {
                BdLog.e(e.toString());
                return null;
            }
        } else if (str.startsWith("pk_before:")) {
            intent2.putExtra(DealIntentService.KEY_CLASS, 6);
            intent2.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("pk_after:")) {
            intent2.putExtra(DealIntentService.KEY_CLASS, 7);
            intent2.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("vote")) {
            intent2.putExtra(DealIntentService.KEY_CLASS, 8);
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE)) {
            return null;
        } else {
            intent2.putExtra(DealIntentService.KEY_CLASS, 31);
            String substring2 = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE) + 5);
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
        intent2.putExtra("link", str);
        intent2.putExtra("message_id", alVar.getMessageID());
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
            TbConfig.setVersionType(com.baidu.adp.lib.g.b.toInt(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
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
        com.baidu.tbadk.core.sharedPref.b.alP().putString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String loadString(String str, String str2) {
        return com.baidu.tbadk.core.sharedPref.b.alP().getString(str, str2);
    }

    protected int loadInt(String str, int i) {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt(str, i);
    }

    protected void saveInt(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.alP().putInt(str, i);
    }

    protected long loadLong(String str, long j) {
        return com.baidu.tbadk.core.sharedPref.b.alP().getLong(str, j);
    }

    protected void saveLong(String str, long j) {
        com.baidu.tbadk.core.sharedPref.b.alP().putLong(str, j);
    }

    public static String getClientId() {
        return clientId;
    }

    public void removeClientId(Context context) {
        com.baidu.tbadk.core.sharedPref.b.alP().remove("client_id");
    }

    public static void saveClientId(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.core.sharedPref.b.alP().putString("client_id", TbConfig.getVersion() + "\t" + str);
        }
    }

    public static void setClientId(String str) {
        clientId = str;
    }

    protected void initImei() {
        TelephonyManager telephonyManager;
        try {
            if (ab.checkReadPhoneState(getContext()) && (telephonyManager = (TelephonyManager) getContext().getSystemService("phone")) != null) {
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
            File GetFile = m.GetFile("from.dat");
            if (GetFile != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(GetFile));
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
                File CreateFile = m.CreateFile("from.dat");
                if (CreateFile != null) {
                    FileWriter fileWriter = new FileWriter(CreateFile);
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
        sb.append(q.guid());
        if (sb.length() > i) {
            sb.setLength(i);
        }
        return sb.toString();
    }

    protected void initCuid() {
        String loadString = loadString("cuid", null);
        if (loadString != null && loadString.startsWith("baidutiebaapp")) {
            saveString("new_cuid", loadString);
            com.baidu.tbadk.core.sharedPref.b.alP().remove("cuid");
            this.mCuid = loadString;
            return;
        }
        if (this.mCuid == null) {
            this.mCuid = loadString("new_cuid", null);
        }
        if (this.mCuid == null || this.mCuid.length() <= 0) {
            if (ab.checkReadPhoneState(getApplicationContext())) {
                this.mCuid = DeviceId.getCUID(getContext());
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
            saveString("new_cuid", this.mCuid);
        }
    }

    private void initCuidGalaxy2() {
        this.cuid_galaxy2 = loadString("new_cuid_galaxy2", null);
        if (this.cuid_galaxy2 == null || this.cuid_galaxy2.length() <= 0) {
            this.cuid_galaxy2 = DeviceId.getCUID(getContext());
            saveString("new_cuid_galaxy2", this.cuid_galaxy2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initSetting() {
        this.mGpuOpen = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.GPU_OPEN, shouldGPUOn());
        this.mUseHttpClient = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.USE_HTTPCLIENT, true);
        this.mPromotedMessageOn = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.PERMOTED_MESSAGE, true);
        this.mWebviewCrashCount = TbadkSettings.getInst().loadInt(SharedPrefConfig.WEBVIEW_CRASH_COUNT, 0);
        this.mIsAppOn = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.APP_ON, false);
        this.mNewVcodeWebviewCrashCount = TbadkSettings.getInst().loadInt(SharedPrefConfig.NEW_VCODE_WEBVIEW_CRASH_COUNT, 0);
        this.mIsLocationOn = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.LOCATION_ON, true);
        getInst().setIsLocationON(this.mIsLocationOn);
        this.mIsExitAppCloseWebSocket = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.IS_EXIT_APP_NOT_START_WEBSOCKET, false);
        this.mFaceShopVersion = TbadkSettings.getInst().loadInt(SharedPrefConfig.FACESHAOP_VERSION, -1);
        this.useTimeInterval = com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.USE_TIME_INTERVAL, TbConfig.DEFALT_USE_TIME_INTERVAL);
    }

    public int getWebviewCrashCount() {
        return this.mWebviewCrashCount;
    }

    public void addBDLocCrashCount() {
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.BD_LOC_CRASH_COUNT, 0) + 1;
        TbadkSettings.getInst().saveInt(SharedPrefConfig.BD_LOC_CRASH_COUNT, loadInt);
        if (loadInt > 3) {
            setBDLocON(false);
        }
    }

    public void setBDLocON(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH, Boolean.valueOf(z)));
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.PREFS_BD_LOC_SWITCHER, z);
    }

    public void incLiveSdkCrashCount() {
        String str = SharedPrefConfig.LIVE_SDK_CRASH_COUNT + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incXiaoyingCrashCount() {
        TbadkSettings.getInst().saveInt(SharedPrefConfig.XIAOYING_CRASH_COUNT, TbadkSettings.getInst().loadInt(SharedPrefConfig.XIAOYING_CRASH_COUNT, 0) + 1);
    }

    public boolean isXiaoyingAvaliable() {
        return TbadkSettings.getInst().loadInt(SharedPrefConfig.XIAOYING_CRASH_COUNT, 0) <= getFeatureCrashAutoCloseLimit();
    }

    public void incBaobaoCrashCount() {
        String str = SharedPrefConfig.BAOBAO_CRASH_COUNT + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void incDQCrashCount() {
        String str = SharedPrefConfig.DQ_CRASH_COUNT + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void setIsAppOn(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.APP_ON, z);
        this.mIsAppOn = z;
    }

    public boolean getIsAppOn() {
        return this.mIsAppOn;
    }

    public void setWebviewCrashCount(int i) {
        this.mWebviewCrashCount = i;
        TbadkSettings.getInst().saveInt(SharedPrefConfig.WEBVIEW_CRASH_COUNT, i);
    }

    public void setPromotedMessage(String str, boolean z) {
        TbadkSettings.getInst().saveBoolean("permoted_message_" + str, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMORY_SWITCH_CHANGE));
    }

    public boolean isPromotedMessageOn(String str) {
        String str2 = "permoted_message_" + str;
        return TbadkSettings.getInst().isContains(str2) ? TbadkSettings.getInst().loadBoolean(str2, true) : this.mPromotedMessageOn;
    }

    public void setGpuOpen(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.GPU_OPEN, z);
        this.mGpuOpen = z;
    }

    public boolean isGpuOpen() {
        return this.mGpuOpen;
    }

    public void setHttpClientOpen(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.USE_HTTPCLIENT, z);
        this.mUseHttpClient = z;
    }

    public boolean isHttpClientOpen() {
        return this.mUseHttpClient;
    }

    public void setHttpAutoSwitch(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.USE_HTTPCLIENT_AUTO_SWITCH, z);
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
            return com.baidu.adp.lib.g.b.toLong(mAccount.getID(), 0L);
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
        String str = "set_application_account:";
        if (accountData == null) {
            str = "set_application_account:null";
        } else if (!StringUtils.isNull(accountData.getID()) && !StringUtils.isNull(accountData.getBDUSS())) {
            str = "set_application_account:valid_logined";
        } else if (!StringUtils.isNull(accountData.getBDUSS())) {
            str = "set_application_account:valid";
        } else if (!StringUtils.isNull(accountData.getID())) {
            str = "set_application_account:logined";
        }
        com.baidu.tbadk.core.e.a.a("account", -1L, 0, str, 0, "", new Object[0]);
        if (l.isMainThread()) {
            setCurrentAccountInUI(accountData, context);
        } else {
            getInst().handler.post(new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.8
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
            com.baidu.tbadk.lcs.a.d(0, 0, 0, 1, 2);
            BdSocketLinkService.startService(true, "account changed");
        }
        MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
        if (j.isWifiNet() && accountData != null) {
            MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD, (Class) null);
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
        intent2.setAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
        intent2.putExtra(BdStatsConstant.INTENT_DATA_USERID, str);
        intent2.putExtra(BdStatsConstant.INTENT_DATA_USERNAME, str2);
        intent2.putExtra(BdStatsConstant.INTENT_DATA_BDUSS, currentBduss);
        intent2.setPackage(getInst().getPackageName());
        try {
            getInst().sendStickyBroadcast(intent2);
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
        Intent intent3 = new Intent();
        intent3.setAction("com.baidu.tieba.action.accountChange");
        intent3.putExtra(ACCOUNT_DATA, accountData);
        intent3.setPackage(getInst().getPackageName());
        getInst().sendBroadcast(intent3);
        com.baidu.tbadk.n.a.fp(!TextUtils.isEmpty(str));
        if (accountData != null) {
            com.baidu.tbadk.n.a.dj(accountData.getBDUSS());
            com.baidu.tbadk.n.a.setTbs(accountData.getTbs());
            com.baidu.tbadk.n.a.setStoken(accountData.getStoken());
        }
    }

    private void initAccountChangeReceiver() {
        if (isRemoteProcess() && this.mAccountChangeReceiver == null) {
            this.mAccountChangeReceiver = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.action.accountChange");
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
            if (TbadkCoreApplication.this.isRemoteProcess() && intent != null && "com.baidu.tieba.action.accountChange".equals(intent.getAction())) {
                Serializable serializableExtra = intent.getSerializableExtra(TbadkCoreApplication.ACCOUNT_DATA);
                if (serializableExtra instanceof AccountData) {
                    AccountData unused = TbadkCoreApplication.mAccount = (AccountData) serializableExtra;
                } else {
                    AccountData unused2 = TbadkCoreApplication.mAccount = null;
                }
                com.baidu.tbadk.n.a.fp(TbadkCoreApplication.isLogin());
                if (TbadkCoreApplication.mAccount != null) {
                    com.baidu.tbadk.n.a.dj(TbadkCoreApplication.mAccount.getBDUSS());
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
        String string = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.CURRENT_USED_THEME + getCurrentAccount(), null);
        if (StringUtils.isNull(string)) {
            this.mUsedThemeId = 0;
            this.mUsedThemePermissionType = 0;
        } else {
            String[] split = string.split("/");
            if (split == null || split.length < 2) {
                this.mUsedThemeId = 0;
                this.mUsedThemePermissionType = 0;
            } else {
                this.mUsedThemeId = com.baidu.adp.lib.g.b.toInt(split[0], 0);
                this.mUsedThemePermissionType = com.baidu.adp.lib.g.b.toInt(split[1], 0);
            }
        }
        this.mSkinType = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
        this.isUserChanged = true;
        clearAccountResource();
        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.9
            @Override // java.lang.Runnable
            public void run() {
                TbadkCoreApplication.this.setThemeSkin();
            }
        }, 600L);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.METHOD_INVOKE_ACCOUNT_CHANGE, accountData));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, accountData));
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_STICKY, accountData);
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_STICKY);
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
            am.amF();
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
                    am.nP(str);
                    PackageInfo apkFileMetaData = m.getApkFileMetaData(str);
                    if (apkFileMetaData == null || apkFileMetaData.applicationInfo == null || apkFileMetaData.applicationInfo.metaData == null) {
                        setSkinType(0);
                        this.mUsedThemeId = 0;
                    } else {
                        this.mUsedThemeColor = apkFileMetaData.applicationInfo.metaData.getInt("icon_color");
                        this.isThemeIconCover = apkFileMetaData.applicationInfo.metaData.getInt("icon_cover_maintab") != 1;
                        this.mUsedThemeId = i;
                        BitmapHelper.clearThemeCashBitmap();
                        com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.CURRENT_USED_THEME + getCurrentAccount(), i + "/" + this.mUsedThemePermissionType);
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
        saveBoolean(SharedPrefConfig.PUSH_SERVICE_OPEN, z);
    }

    public boolean isPushServiceOpen() {
        return loadBoolean(SharedPrefConfig.PUSH_SERVICE_OPEN, true);
    }

    protected void saveBoolean(String str, boolean z) {
        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(str, z);
    }

    protected boolean loadBoolean(String str, boolean z) {
        return com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(str, z);
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
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.LOCATION_SHARED + getCurrentAccount(), z);
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
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.LOCATION_ON, z);
    }

    public boolean getIsLocationOn() {
        return this.mIsLocationOn;
    }

    public void setPushChannelId(String str) {
        saveString("push_channel_id", str);
    }

    public String getPushChannelUserId() {
        return loadString(SharedPrefConfig.PUSH_CHANNEL_UserId, "");
    }

    public void setPushChannelUserId(String str) {
        saveString(SharedPrefConfig.PUSH_CHANNEL_UserId, str);
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
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(SharedPrefConfig.PASSPORT_CRASH_COUNT).append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.ft().af("switch_login_passv6") != 1;
    }

    public boolean isAccountsDataFromPass() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(SharedPrefConfig.PASSPORT_CRASH_COUNT).append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.ft().af("switch_account_data_from_pass") != 1;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public void setUegVoiceWarning(String str) {
        this.uegVoiceWarning = str;
    }

    public boolean isAudioRecorderOpen() {
        return com.baidu.adp.lib.b.d.ft().af("android_ueg_voice") != 0;
    }

    public boolean isLowVersionPassV6ShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(SharedPrefConfig.PASSPORT_CRASH_COUNT).append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.ft().af("switch_low_version_login_passv6") != 1;
    }

    public int getFeatureCrashAutoCloseLimit() {
        return Math.max(TbadkSettings.getInst().loadInt(SharedPrefConfig.FEATURE_CRASH_AUTO_CLOSE_LIMIT, 3), 3);
    }

    public void setFeatureCrashAutoCloseLimit(int i) {
        TbadkSettings.getInst().saveInt(SharedPrefConfig.FEATURE_CRASH_AUTO_CLOSE_LIMIT, i);
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
            TbadkSettings.getInst().saveInt(SharedPrefConfig.PREFS_FONT_SIZE, i);
        }
    }

    private void initWebsocketBase(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new com.baidu.adp.framework.client.socket.link.b() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.10
            @Override // com.baidu.adp.framework.client.socket.link.b
            public boolean canOpenWebSocket() {
                return !TbadkCoreApplication.this.isExitAppCloseWebSocket();
            }
        });
        int[] imTimeOut = getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            com.baidu.adp.framework.c.c.eJ().setTimeOutData(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            com.baidu.adp.framework.client.socket.h.setReConnectInterval(socketReconnStratgy);
        }
        com.baidu.tbadk.coreExtra.e.e.atf().initial();
        MessageManager.getInstance().getSocketClient().a(com.baidu.tbadk.coreExtra.e.e.atf());
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tbadk.coreExtra.e.i());
        try {
            com.baidu.adp.framework.client.socket.coder.d.eE().initial(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        com.baidu.tbadk.coreExtra.e.h.atl().init();
        com.baidu.tbadk.coreExtra.e.g.ath().init();
        initSocket();
        n.awQ().br(System.currentTimeMillis() - currentTimeMillis);
    }

    public com.baidu.adp.widget.ImageView.a getFace(String str) {
        SoftReference<com.baidu.adp.widget.ImageView.a> softReference = this.mFaces.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.ImageView.a pU = TbFaceManager.avr().pU(str);
        if (pU != null) {
            this.mFaces.put(str, new SoftReference<>(pU));
            return pU;
        }
        return pU;
    }

    private static void initSocket() {
        com.baidu.tbadk.task.b registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.setCanRetry(false);
        registerImScoketTask.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", getUniqueIdentifier()));
        String asU = com.baidu.tbadk.coreExtra.e.a.asS().asU();
        if (TextUtils.isEmpty(asU)) {
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
        } else {
            com.baidu.adp.framework.client.socket.h.setUrl(asU);
        }
        com.baidu.adp.framework.client.socket.h.setExtensions("im_version=2.3");
        com.baidu.adp.framework.client.socket.h.setHeader(arrayList);
        BdSocketDaemonService.setLinkServiceDisconnectCallBack(new com.baidu.adp.framework.client.socket.link.c() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.13
            @Override // com.baidu.adp.framework.client.socket.link.c
            public void onLinkServiceDisconnect() {
                com.baidu.tbadk.util.h.axv().a(new h.a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.13.1
                    @Override // com.baidu.tbadk.util.h.a
                    public void onResult(boolean z) {
                        if (!z) {
                            com.baidu.tbadk.lcs.a.d(0, 0, 0, 1, 8);
                            BdSocketLinkService.startService(false, "restart");
                        }
                    }
                });
            }
        });
        BdSocketLinkService.init();
        com.baidu.tbadk.lcs.a.d(0, 0, 0, 1, 9);
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
        bVar.setNeedCompress(z);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }

    public int[] getSocketReconnStratgy() {
        int[] iArr = new int[0];
        try {
            String loadString = TbadkSettings.getInst().loadString(SharedPrefConfig.SOCKET_RECONN_STRATEGY, "");
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
        String loadString = TbadkSettings.getInst().loadString(SharedPrefConfig.LCS_SWITCH_STRATEGY, null);
        if (!TextUtils.isEmpty(loadString)) {
            com.baidu.tbadk.coreExtra.model.c cVar = new com.baidu.tbadk.coreExtra.model.c();
            cVar.parserJson(loadString);
            com.baidu.tbadk.coreExtra.e.c atd = com.baidu.tbadk.coreExtra.e.c.atd();
            atd.setCloseLongConnectionAPI(cVar.getConnConf() == 1);
            atd.setMaxErrorCount(cVar.getContinuousFailCount());
            atd.setRetryTimeInMills(cVar.getRestartTimeInterval() * 1000);
            if (cVar.getBlackCmds() != null) {
                atd.setUnAvailableAPIS(cVar.getBlackCmds());
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
        this.mVoiceHeadsetMode = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_HEADSET_MODE, 0);
        if (TbadkSettings.getInst().loadInt(SharedPrefConfig.WEBP_FAILURE_COUNT, -1) == -1) {
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
                    TbadkSettings.getInst().saveInt(SharedPrefConfig.WEBP_FAILURE_COUNT, i);
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.CAPABLE_OF_WEBP_FORMAT, this.mCapableOfWebp);
                }
            }
            z = false;
            if (z) {
            }
            TbadkSettings.getInst().saveInt(SharedPrefConfig.WEBP_FAILURE_COUNT, i);
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.CAPABLE_OF_WEBP_FORMAT, this.mCapableOfWebp);
        } else {
            this.mCapableOfWebp = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.CAPABLE_OF_WEBP_FORMAT, false);
        }
        n.awQ().bt(System.currentTimeMillis() - currentTimeMillis);
    }

    public int[] getImTimeOut() {
        String[] split;
        String loadString = TbadkSettings.getInst().loadString(SharedPrefConfig.SOCKET_TIME_OUT, null);
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

    public boolean isOfficial() {
        return this.mIsOfficial;
    }

    public int getNetWorkCoreType() {
        return loadInt(SharedPrefConfig.NETWORKCORE_TYPE, 1);
    }

    public void setNetWorkCoreType(int i) {
        com.baidu.tbadk.core.util.z.io(i);
        saveInt(SharedPrefConfig.NETWORKCORE_TYPE, i);
    }

    public long getLastNotifyTime() {
        return TbadkSettings.getInst().loadLong(SharedPrefConfig.LAST_NOTIFY_SOUND_TIME, 0L);
    }

    public void setLastNotifyTime(long j) {
        TbadkSettings.getInst().saveLong(SharedPrefConfig.LAST_NOTIFY_SOUND_TIME, j);
    }

    public boolean isDQShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(SharedPrefConfig.DQ_CRASH_COUNT).append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit();
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
        if (ab.checkReadPhoneState(getContext())) {
            try {
                ((TelephonyManager) getInst().getApp().getSystemService("phone")).listen(new b(), 32);
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
        com.baidu.tbadk.util.u uVar = new com.baidu.tbadk.util.u(i, i2);
        uVar.setType(str);
        this.imagePvThread.execute(uVar);
        TiebaStatic.eventStat(getInst().getApp(), "img_browse", null, 1, "img_num", Integer.valueOf(i), "img_total", Integer.valueOf(i2), "img_type", str, "img_begin", Integer.valueOf(i3), "img_end", Integer.valueOf(i4));
    }

    public void onUserChanged() {
        if (!l.isNetOk()) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_INFO_CHANGED));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_INVOKE_USER_CHANGE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921410));
        com.baidu.tbadk.coreExtra.messageCenter.b.aqr().ez(true);
        NotificationHelper.cancelAllNotification(this);
        com.baidu.tieba.tbadkCore.util.a.cpl();
    }

    public void onUserChanged(Intent intent2) {
        if (intent2 != null) {
            String stringExtra = intent2.getStringExtra(LoginActivityConfig.USER_INFO_CHANGED);
            if (!TextUtils.isEmpty(stringExtra)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_INFO_CHANGED, stringExtra));
            }
        }
        onUserChanged();
    }

    public void incPassportV6CrashCount() {
        String str = SharedPrefConfig.PASSPORT_CRASH_COUNT + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public void setActiveVersion(String str) {
        if (!aq.isEmpty(str) && !"null".equals(str)) {
            m.a.cleanDirectory(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR);
            m.a.createFile("/package.last/" + str);
        }
    }

    public boolean getIsFirstUse() {
        if (m.a.checkFile("/package.cur/" + TbConfig.getVersion())) {
            return false;
        }
        setActiveVersion(m.a.getLatestFileName(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR));
        return true;
    }

    public int[] getSocketHeartBeatStratgy() {
        int[] iArr = new int[0];
        try {
            String loadString = TbadkSettings.getInst().loadString(SharedPrefConfig.SOCKET_HEARTBEAT_STRATEGY, "");
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
        TbadkSettings.getInst().saveString(SharedPrefConfig.LOCATION_POS, str);
    }

    public String getLocationPos() {
        return TbadkSettings.getInst().loadString(SharedPrefConfig.LOCATION_POS, "");
    }

    public int[] getSocketGetMsgStratgy() {
        int[] iArr = new int[0];
        try {
            String loadString = TbadkSettings.getInst().loadString(SharedPrefConfig.SOCKET_GETMSG_STRATEGY, "");
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
        TbadkSettings.getInst().saveInt(SharedPrefConfig.PREFS_SKIN_TYPE, i);
        SendSkinTypeBroadcast(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE, Integer.valueOf(i)));
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
        com.baidu.adp.lib.g.h.ga().submitTask(new Runnable() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.14
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.tbadkCore.util.a.cashNoAccountData("", 7);
            }
        });
        com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.APP_PULL_TIME, System.currentTimeMillis());
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

    public boolean isFaceShopNew() {
        return this.isFaceShopNew;
    }

    public void setFaceShopNew(boolean z) {
        this.isFaceShopNew = z;
    }

    public String getLocationLng() {
        return TbadkSettings.getInst().loadString(SharedPrefConfig.LOCATION_LNG, "");
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
        TbadkSettings.getInst().saveInt(SharedPrefConfig.FACESHAOP_VERSION, this.mFaceShopVersion);
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
        return com.baidu.adp.lib.b.d.ft().af("android_lbs_webview_open") != 0;
    }

    public boolean isHybridBridgeEnabled() {
        return com.baidu.adp.lib.b.d.ft().af("hybridSwitch") == 1;
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
        String latestFileName;
        if (!m.a.checkFile(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR)) {
            latestFileName = TbadkSettings.getInst().loadString(SharedPrefConfig.ACTIVE_VERSION, "");
        } else {
            latestFileName = m.a.getLatestFileName(FileHelper.DataDir.PACKAGE_VERSION_LAST_DIR);
        }
        if (ACTIVE_CLEAR_TAG.equals(latestFileName)) {
            return null;
        }
        return latestFileName;
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
        TbadkSettings.getInst().saveInt(SharedPrefConfig.PERFORM_SAMPLE_COUNT, i);
    }

    public VersionData getVersionData() {
        return this.mVersionData;
    }

    public void setVersionData(VersionData versionData) {
        this.mVersionData = versionData;
    }

    public boolean isGiftSwitchOn() {
        return com.baidu.adp.lib.b.d.ft().af("offline_gift") != 1;
    }

    public void setInstallOtherApp(String str) {
        TbadkSettings.getInst().saveString(SharedPrefConfig.INSTALL_OTHER_APP_FILE_NAME, str);
    }

    public String getInstallOtherApp() {
        return TbadkSettings.getInst().loadString(SharedPrefConfig.INSTALL_OTHER_APP_FILE_NAME, null);
    }

    public void setUpdateNotifyTime(long j) {
        TbadkSettings.getInst().saveLong(SharedPrefConfig.UPDATE_NOTIFY_TIME, j);
    }

    public long getUpdateNotifyTime() {
        return TbadkSettings.getInst().loadLong(SharedPrefConfig.UPDATE_NOTIFY_TIME, 0L);
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
        TbadkSettings.getInst().saveString(SharedPrefConfig.LCS_SWITCH_STRATEGY, str);
    }

    public void upgradeAbstractOnInMemory(int i) {
        this.mIsAbstractOn = i;
    }

    public void setIsAbstractOn(int i) {
        this.mIsAbstractOn = i;
        TbadkSettings.getInst().saveInt(SharedPrefConfig.PREFS_ABSTRACT_STATE, i);
    }

    public int getIsAbstractStatus() {
        return this.mIsAbstractOn;
    }

    public boolean getIsAbstract() {
        if (this.mIsAbstractOn == 0) {
            if (j.isWifiNet()) {
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
        TbadkSettings.getInst().saveString(SharedPrefConfig.SOCKET_RECONN_STRATEGY, str);
    }

    public void setSocketHeartBeatStratgy(String str) {
        TbadkSettings.getInst().saveString(SharedPrefConfig.SOCKET_HEARTBEAT_STRATEGY, str);
    }

    public void setSocketGetMsgStratgy(String str) {
        TbadkSettings.getInst().saveString(SharedPrefConfig.SOCKET_GETMSG_STRATEGY, str);
    }

    public void setImTimeOut(int[] iArr) {
        if (iArr != null && iArr.length == 3) {
            StringBuilder sb = new StringBuilder(20);
            for (int i : iArr) {
                sb.append(i);
                sb.append("|");
            }
            TbadkSettings.getInst().saveString(SharedPrefConfig.SOCKET_TIME_OUT, sb.toString());
            com.baidu.adp.framework.c.c.eJ().setTimeOutData(iArr[0], iArr[1], iArr[2]);
        }
    }

    public String getYijianfankuiFname() {
        return this.mYijianfankuiFname;
    }

    public void setYijianfankuiFname(String str) {
        this.mYijianfankuiFname = str;
    }

    public boolean getFirstSyncImageQuality() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
    }

    public void setLocationLat(String str) {
        TbadkSettings.getInst().saveString(SharedPrefConfig.LOCATION_LAT, str);
    }

    public long getReporyUserInfoLastTime() {
        return TbadkSettings.getInst().loadLong(SharedPrefConfig.REPORT_USER_IFNO_TIME_KEY + getCurrentAccount(), 0L);
    }

    public void setReporyUserInfoCurrentTime() {
        TbadkSettings.getInst().saveLong(SharedPrefConfig.REPORT_USER_IFNO_TIME_KEY + getCurrentAccount(), System.currentTimeMillis());
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
        if (this.mAdAdSense != null && this.mAdAdSense.aoQ() != null) {
            com.baidu.tbadk.coreExtra.data.g aoQ = this.mAdAdSense.aoQ();
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_UPDATE_INSTALL_STATUS);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_INSTALL_STATUS, aoQ));
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

    public void setProfileData(u uVar) {
        this.mProfileData = uVar;
    }

    public u getProfileData() {
        return this.mProfileData;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public void setUsed() {
        m.a.cleanDirectory(FileHelper.DataDir.PACKAGE_VERSION_CUR_DIR);
        m.a.createFile("/package.cur/" + TbConfig.getVersion());
    }

    public com.baidu.tieba.tbadkCore.util.d getReadThreadHistory() {
        return this.mReadThreadHistory;
    }

    public com.baidu.tieba.tbadkCore.util.c getPhotoLiveReadThreadHistory() {
        return this.mPhotoLiveReadHistory;
    }

    public boolean isShowSwipeBackGuide() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SHOW_SWIPE_BACK_GUIDE_KEY, true);
    }

    public void setShowSwipeBackGuide(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SHOW_SWIPE_BACK_GUIDE_KEY, z);
    }

    public void setPersonChangeData(PersonChangeData personChangeData) {
        this.mPersonChangeData = personChangeData;
    }

    public PersonChangeData getPersonChangeData() {
        return this.mPersonChangeData;
    }

    public boolean cashNoAccountData(String str, int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.execSQLNoException("delete from cash_data where type=?", new String[]{String.valueOf(i)});
        return mainDBDatabaseManager.execSQLNoException("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
    }

    public void deleteAccountAllInfo(String str) {
        if (str != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.execSQLNoException("delete from cash_data where account=?", new String[]{str});
            mainDBDatabaseManager.execSQLNoException("delete from mark_data where account=?", new String[]{str});
            mainDBDatabaseManager.execSQLNoException("delete from draft_box where account=?", new Object[]{str});
            mainDBDatabaseManager.execSQLNoException("delete from account_data where id=?", new Object[]{str});
            mainDBDatabaseManager.execSQLNoException("delete from setting where account=?", new Object[]{str});
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
                    com.baidu.adp.lib.g.a.close(cursor);
                } catch (Exception e) {
                    e = e;
                    mainDBDatabaseManager.notifySQLException(e, "getNoAccountData");
                    com.baidu.adp.lib.g.a.close(cursor);
                    return r0;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.close(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.g.a.close(cursor);
            throw th;
        }
        return r0;
    }

    public void incCrabSdkCrashCount() {
        String str = SharedPrefConfig.CRAB_SDK_CRASH_COUNT + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isCrabSdkShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(SharedPrefConfig.CRAB_SDK_CRASH_COUNT).append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.ft().af("android_crab_enable") == 1;
    }

    private boolean isCrabSdkCrashUp2Limit() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(SharedPrefConfig.CRAB_SDK_CRASH_COUNT).append(TbConfig.getVersion()).toString(), 0) > getFeatureCrashAutoCloseLimit();
    }

    public void incXiaomiPushSdkCrashCount() {
        String str = SharedPrefConfig.XIAOMI_PUSH_SDK_CRASH_COUNT + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isXiaomiPushSdkShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(SharedPrefConfig.XIAOMI_PUSH_SDK_CRASH_COUNT).append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.ft().af("switch_xiaomipush_sdk") != 0;
    }

    public void incWalletSdkCrashCount() {
        String str = SharedPrefConfig.WAllET_CRASH_COUNT + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isWalletShouldOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(SharedPrefConfig.WAllET_CRASH_COUNT).append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.ft().af("baidu_wallet_enable") != 0;
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
            if (fVar.ho(2) && !fVar.ho(-1)) {
                BdLog.e("you should add CustomGroupType.PERSONAL_GROUP in the filter");
            }
            if (fVar.ho(4) && !fVar.ho(-9)) {
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
            this.isImmersiveStickyCanUse = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.SWITCH_IMMERSIVE_STICKY_STATUS, true);
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
        int picCacheSize = com.baidu.tbadk.imageManager.c.avs().getPicCacheSize();
        int max = (int) Math.max(picCacheSize * 0.8d, TbConfig.getBigImageMaxUsedMemory());
        if (max < picCacheSize) {
            if (BdLog.isDebugMode()) {
            }
            com.baidu.tbadk.imageManager.c.avs().setPicMaxSize(max);
        }
        BitmapHelper.clearCashBitmap();
        com.baidu.adp.lib.util.d.gW().clearCashBitmap();
    }

    public r getListItemRule() {
        if (this.listItemRule == null) {
            this.listItemRule = new r();
        }
        return this.listItemRule;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivityPrizeData() {
        if (this.activityPrizeData == null) {
            this.activityPrizeData = new com.baidu.tbadk.coreExtra.data.b();
            String string = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + getCurrentAccount(), "");
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
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CLOSE_ALL_ACTIVITY));
    }

    private void initCustomToastView() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mToast == null && l.hc() == null) {
            this.mToast = new l.a() { // from class: com.baidu.tbadk.core.TbadkCoreApplication.15
                @Override // com.baidu.adp.lib.util.l.a
                public void setToastString(String str) {
                    if (getToastContentView() instanceof TextView) {
                        ((TextView) getToastContentView()).setText(str);
                    }
                }

                @Override // com.baidu.adp.lib.util.l.a
                public View getToastContentView() {
                    if (TbadkCoreApplication.this.mCustomToastView == null) {
                        TbadkCoreApplication.this.mCustomToastView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.custom_toast_textview, (ViewGroup) null);
                    }
                    return TbadkCoreApplication.this.mCustomToastView;
                }
            };
            l.a(this.mToast);
            n.awQ().bs(System.currentTimeMillis() - currentTimeMillis);
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
        String str = SharedPrefConfig.BAIDU_YUN_PUSH_SDK_CRASH_COUNT + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isBaiduYunPushAvailable() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(SharedPrefConfig.BAIDU_YUN_PUSH_SDK_CRASH_COUNT).append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.d.ft().af("android_baiduyun_push") == 1;
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
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_RECOMMEND_LABEL));
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
            this.mChannelId = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.YUNPUSH_CHANNEL_ID, "");
        }
        return this.mChannelId;
    }

    public void setYunpushChannelId(String str) {
        com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.YUNPUSH_CHANNEL_ID, str);
    }

    public com.baidu.tbadk.coreExtra.c.e getShareItem() {
        return this.mShareItem;
    }

    public void setShareItem(com.baidu.tbadk.coreExtra.c.e eVar) {
        this.mShareItem = eVar;
    }

    public void setUseTimeInterval(long j) {
        com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.USE_TIME_INTERVAL, j);
        this.useTimeInterval = j;
    }

    public long getUseTimeInterval() {
        return this.useTimeInterval;
    }

    public int getCardShowType() {
        if (!this.hasInit) {
            this.cardShowType = com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_card_show_type", 0);
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
