package com.baidu.tbadk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.data.SmallTailThemeData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LightEmotionData;
import com.baidu.tbadk.data.UserGrowthTaskListData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.switchs.PbPreloadSwitch;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.a25;
import com.baidu.tieba.b25;
import com.baidu.tieba.b65;
import com.baidu.tieba.bh;
import com.baidu.tieba.c35;
import com.baidu.tieba.cz4;
import com.baidu.tieba.d45;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.tieba.g35;
import com.baidu.tieba.h45;
import com.baidu.tieba.i25;
import com.baidu.tieba.i35;
import com.baidu.tieba.j35;
import com.baidu.tieba.kp4;
import com.baidu.tieba.l35;
import com.baidu.tieba.lj9;
import com.baidu.tieba.lu4;
import com.baidu.tieba.o35;
import com.baidu.tieba.p35;
import com.baidu.tieba.r35;
import com.baidu.tieba.rk8;
import com.baidu.tieba.sm8;
import com.baidu.tieba.t25;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.u25;
import com.baidu.tieba.u55;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.tieba.xv8;
import com.baidu.tieba.y25;
import com.baidu.tieba.y55;
import com.baidu.tieba.yi;
import com.baidu.tieba.z15;
import com.baidu.tieba.z55;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.ItemInfo;
import tbclient.VideoRedIcon.RedIcon;
@ModifyClass
/* loaded from: classes3.dex */
public final class TbSingleton {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_ACCELERATOR_ITEM_ID = -1;
    public static final int DEFAULT_THREAD_HOLD = 200;
    public static final int FRS_PULL_REFRESH_COMPLETE_STATE = 2;
    public static final int FRS_PULL_REFRESH_DOING_STATE = 1;
    public static final int HOME_PAGE_STYLE_AB_TEST_001 = 1;
    public static final int LOGIN_FROM_DEFAULT = -1;
    public static final int LOGIN_FROM_VIDEO_ATTENTION = 1;
    public static final int PB_SUB_COMMENT_NUMBER = 4;
    public static final String TEMP_STRING_KEY_INTEREST_FORUM = "interest_forum";
    public static final int VIDEO_TAB_PB_SUB_COMMENT_NUMBER = 2;
    public static boolean isExceptInsertAdDiaShow = false;
    public static int loginFrom = -1;
    public static TbSingleton mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final long THREE_DAY_MILLISECOND;
    public PkgNameAndNodeInfoData acceleratorData;
    public long acceleratorItemId;
    public long activeTimeStamp;
    public z15 adFloatViewData;
    public long appFirstInstallTime;
    public long appLastUpdateTime;
    public String baiduIdForAnti;
    public Calendar calendar;
    public boolean canShowPermDlg;
    public long currentClickTime;
    public long duXiaoManActivityTimestamp;
    public boolean enableVideoVerticalPreload;
    public Uri firstOpenScheme;
    public String fromWhichSearchSource;
    public Map<String, ItemInfo> frsItemInfoCache;
    public boolean hasDownloadEmotion;
    public boolean hasPerformInterestPanelShow;
    public boolean hasPerformedFirstLoginTest;
    public boolean hasShowPermDlg;
    public u25 hotNotifyConfigData;
    public IconPopData iconPopData;
    public String invokeSource;
    public boolean isAddBanner;
    public boolean isBaiduidCookieSwitch;
    public boolean isBusinessAccount;
    public boolean isCanShowHotSplash;
    public boolean isChatTabPage;
    public boolean isDanmuSwitchOpen;
    public boolean isFirstEnterBigPicPage;
    public boolean isInFrs;
    public boolean isItemTabVisible;
    public boolean isMercatorRequestFromHomePageTabFeedFragment;
    public boolean isMyTabClicked;
    public boolean isNeedJoinChatRoom;
    public boolean isNewUser;
    public boolean isNewUserRedPackageShowed;
    public boolean isPushOrSchemeLog;
    public boolean isRecommendPage;
    public boolean isShowBackLabel;
    public boolean isShowConcernLiveSecondFloor;
    public boolean isShowRecommendLiveSecondFloor;
    public boolean isStartStatUploadImmediately;
    public String isSwitchActivity;
    public boolean isUserBan;
    public boolean isVideoChannelRelogin;
    public Boolean isYYLive;
    public long lastResumeTime;
    public LevePopData levePopData;
    public ArrayList<LightEmotionData> lightEmotionInfo;
    public List<AlaLiveInfo> liveFollowSecondFloor;
    public HashMap<Long, String> liveForumMap;
    public List<AlaLiveInfo> liveIndexSecondFloor;
    public final HashMap<String, String> mAcceleratorMap;
    public String mActivityId;
    public int mAdFloatTipsAppLimitCount;
    public int mAdFloatTipsDayLimitCount;
    public b25 mAdVertiSementConfigData;
    public int mAnimFpsSyncThreshold;
    public String mBannerText;
    public final String mBaseActivity;
    public final String mBaseFragmentActivity;
    public i25 mBearSidConfigData;
    public String mCallFansTid;
    public boolean mCanCallFans;
    public boolean mCanWebViewActivityShowProgress;
    public d45 mChannelConfigModel;
    public int mChatGroupThreadHold;
    public boolean mClipboardDelayTime;
    public HashMap<String, u55> mColourHeaderConfigs;
    public int mCpuFlopsDur;
    public int mCpuThreshold;
    public boolean mEnableBenchmark;
    public final String mFlutterPageActivity;
    public boolean mForceRefreshHomeRecommend;
    public boolean mFrsContentViewLoadingShow;
    public int mFrsCurTabType;
    public xv8 mFrsResponseData;
    public boolean mFrsRootViewLoadingShow;
    public boolean mHasAgreeToPlay;
    public Map<Long, Integer> mHasClickRedPot;
    public Map<String, Date> mHasShowFid;
    public Map<Long, Date> mHasShowRedPot;
    public final BroadcastReceiver mHeadSetStateReceiver;
    public t25 mHomeInsertAdData;
    public y55 mHomeOperateData;
    public List<z55> mHomePageLuckyConfigs;
    public int mHomePageStyleAbTest;
    public List<String> mHostWhiteList;
    public String mHotSearch;
    public boolean mIsAuditPackageSwitchOn;
    public int mIsCutoutScreen;
    public boolean mIsFlutterPluginLoadSuccess;
    public boolean mIsForceLayoutMaintab;
    public boolean mIsInNeedReuseVideoPlayer;
    public boolean mIsJumpFromVideoMiddleView;
    public boolean mIsNeedRemindLiveRoom;
    public String mIsNeedShowCommentThreadId;
    public int mIsNotchScreen;
    public boolean mIsOpenTrack;
    public boolean mIsOutNeedReuseVideoPlayer;
    public boolean mIsShowVoiceFloat;
    public boolean mIsSplashClick;
    public boolean mIsVideoCardMute;
    public boolean mIsVisitPreviewServer;
    public String mLFUser;
    public String mLFUserTaskId;
    public b65 mLiveActivityGuide;
    public int mLoopChatroomFrequency;
    public String mLoopRoomMsgId;
    public c35 mMainTabPopConfig;
    public MercatorModel.MercatorData mMercatorData;
    public String mMissionEntranceIcon;
    public String mMissionEntranceObjSource;
    public String mMissionEntranceUrl;
    public NewGodData mNewGodData;
    public NewUserRedPackageData mNewUserRedPackageData;
    public lu4 mPbToHomeUpdateData;
    public rk8 mPcdnConfigData;
    public String mProfileGameCenterKey;
    public String mPubEnvValue;
    public HashMap mRoomDraft;
    public String mSampleId;
    public int mSendMsgCountToRemindSubscribe;
    public i35 mShakeData;
    public j35 mSharePanelConfData;
    public String mSharePanelText;
    public boolean mShowCallFans;
    public boolean mShowHomeFloatRefreshButton;
    public boolean mShowShoubaiDynamicGuide;
    public boolean mShowVivoBadge;
    public SmallTailThemeData mSmallTailThemeData;
    public boolean mStartGameClicked;
    public TiebaPlusConfigData mTiebaPlusConfigData;
    public Map<String, Date> mTimeMap;
    public boolean mTipsAutoPlayInVideoChannel;
    public boolean mTipsAutoPlayInVideoMiddle;
    public JSONArray mUbsABTestJsonArray;
    public sm8 mUploadAndClearModule;
    public Bitmap mVideoCurrentFrame;
    public LinkedList<kp4> mVideoWatchTimeRecord;
    public String mWalletSignLink;
    public r35 mWlConfigData;
    public String mWorldCupSponsorFlag;
    public YYLiveConfig mYYLiveConfig;
    public lj9 mYYLiveTabConfig;
    public boolean needRefreshForumSquare;
    public JSONObject newGodDataJson;
    public boolean personalizedRecSwitchChanged;
    public long pushDialogLoopTime;
    public long pushDialogShowTime;
    public g35 pushStrategyConfig;
    public String pushTid;
    public Bundle reloginVideoMiddleBundle;
    public String schemaForStartOtherAppAfterSwanApp;
    public boolean shouldShowHomeLocalCompleteInfoCard;
    public boolean shouldShowLocalChannelPostAnim;
    public boolean showStampMissionDialog;
    public boolean showedInterestGuide;
    public h45 syncModel;
    public HashMap<String, String> tempStrings;
    public boolean triggerInterestPanelYDaysConfig;
    public l35 upgradePopWindowConfig;
    public UserGrowthTaskListData userGrowthTaskListData;
    public UserPendantData userPendantData;
    public RedIcon videoChannelAttentionRedIcon;
    public RedIcon videoChannelRecommendRedIcon;
    public o35 videoEventsConfig;
    public int videoRedIconInterval;
    public String videoTestType;
    @Nullable
    public p35 voiceRoomConfig;
    public int worksAddTopicMaxNum;
    public String yyCloudSwitch;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2074071359, "Lcom/baidu/tbadk/TbSingleton;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2074071359, "Lcom/baidu/tbadk/TbSingleton;");
        }
    }

    public boolean isDebugToolMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public TbSingleton() {
        boolean z;
        boolean z2;
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
        this.THREE_DAY_MILLISECOND = 259200000L;
        this.pushDialogLoopTime = 3600000L;
        this.pushDialogShowTime = 300000L;
        this.lastResumeTime = 0L;
        this.canShowPermDlg = false;
        this.hasShowPermDlg = false;
        this.isNewUser = false;
        this.mHasAgreeToPlay = false;
        this.mTipsAutoPlayInVideoChannel = false;
        this.mTipsAutoPlayInVideoMiddle = false;
        this.mShakeData = null;
        this.invokeSource = "";
        this.isBusinessAccount = false;
        this.mFrsRootViewLoadingShow = false;
        this.mFrsContentViewLoadingShow = false;
        this.mIsVideoCardMute = true;
        this.mEnableBenchmark = false;
        this.mCpuFlopsDur = -1;
        this.mCpuThreshold = Integer.MAX_VALUE;
        this.mAnimFpsSyncThreshold = 0;
        this.mIsNotchScreen = -1;
        this.mIsCutoutScreen = -1;
        this.mStartGameClicked = false;
        this.mIsVisitPreviewServer = false;
        this.hasDownloadEmotion = false;
        this.mHomePageStyleAbTest = 0;
        this.liveForumMap = new HashMap<>();
        this.mShowHomeFloatRefreshButton = false;
        this.mShowVivoBadge = false;
        this.mCanWebViewActivityShowProgress = true;
        this.isInFrs = false;
        this.appFirstInstallTime = 0L;
        this.appLastUpdateTime = 0L;
        this.activeTimeStamp = 0L;
        this.isAddBanner = false;
        this.mIsInNeedReuseVideoPlayer = false;
        this.mIsOutNeedReuseVideoPlayer = false;
        this.mVideoCurrentFrame = null;
        this.mIsJumpFromVideoMiddleView = false;
        this.mBaseActivity = com.sina.weibo.sdk.share.BaseActivity.TAG;
        this.mBaseFragmentActivity = "BaseFragmentActivity";
        this.mFlutterPageActivity = "FlutterPageActivity";
        this.isNewUserRedPackageShowed = false;
        this.hasPerformedFirstLoginTest = false;
        this.needRefreshForumSquare = false;
        this.worksAddTopicMaxNum = 3;
        this.showedInterestGuide = false;
        this.mUbsABTestJsonArray = null;
        this.enableVideoVerticalPreload = false;
        this.fromWhichSearchSource = "";
        this.isItemTabVisible = false;
        this.isDanmuSwitchOpen = true;
        this.isMercatorRequestFromHomePageTabFeedFragment = false;
        this.shouldShowHomeLocalCompleteInfoCard = true;
        this.mAcceleratorMap = new HashMap<>();
        this.isStartStatUploadImmediately = false;
        this.shouldShowLocalChannelPostAnim = true;
        this.acceleratorItemId = -1L;
        this.acceleratorData = null;
        this.mHomeInsertAdData = null;
        this.showStampMissionDialog = false;
        this.isCanShowHotSplash = false;
        this.triggerInterestPanelYDaysConfig = false;
        this.hasPerformInterestPanelShow = false;
        this.tempStrings = new HashMap<>();
        this.isBaiduidCookieSwitch = false;
        this.mIsFlutterPluginLoadSuccess = false;
        this.mIsNeedRemindLiveRoom = false;
        this.isUserBan = false;
        this.mIsForceLayoutMaintab = false;
        this.duXiaoManActivityTimestamp = 0L;
        this.levePopData = null;
        this.iconPopData = null;
        this.mHasShowFid = new HashMap();
        this.isPushOrSchemeLog = false;
        this.mHasShowRedPot = new HashMap();
        this.mHasClickRedPot = new HashMap();
        this.isChatTabPage = false;
        this.liveFollowSecondFloor = new ArrayList();
        this.liveIndexSecondFloor = new ArrayList();
        this.isShowRecommendLiveSecondFloor = true;
        this.isShowConcernLiveSecondFloor = true;
        this.lightEmotionInfo = new ArrayList<>();
        this.mFrsResponseData = null;
        this.isFirstEnterBigPicPage = true;
        this.frsItemInfoCache = new HashMap();
        this.mRoomDraft = new HashMap();
        this.isNeedJoinChatRoom = false;
        this.mTimeMap = new HashMap();
        this.mHeadSetStateReceiver = new BroadcastReceiver(this) { // from class: com.baidu.tbadk.TbSingleton.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbSingleton this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                    boolean z3 = false;
                    if (intent.getIntExtra("state", 0) != 0 && intent.getIntExtra("state", 0) == 1) {
                        z3 = true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921398, Boolean.valueOf(z3)));
                }
            }
        };
        this.personalizedRecSwitchChanged = false;
        setIsOpenTrack(cz4.l().i("key_is_open_track", false));
        setProfileGameCenterKey(cz4.l().r("profile_swan_app_key", ""));
        setHomePageStyleAbTest(cz4.l().m("index_activity_abtest_switch_json", 0));
        setMissionEntranceIcon(cz4.l().r("index_activity_abtest_icon_url", ""));
        setMissionEntranceUrl(cz4.l().r("index_activity_abtest_url", ""));
        setMissionEntranceObjSource(cz4.l().r("index_activity_abtest_obj_source", ""));
        setAuditPackageSwitch(cz4.l().i("audit_package_switch", false));
        setBaiduidCookieSwitch(cz4.l().i("key_baidu_id_cookie_switch", false));
        setUbsSampleId(cz4.l().r("key_ubs_sample_id", ""));
        if (cz4.l().m("key_is_show_shoubai_dynamic_guide", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        setShowShoubaiDynamicGuide(z);
        if (cz4.l().m("key_home_refresh_button_test", 0) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mShowHomeFloatRefreshButton = z2;
        setClipboardDelayTime(cz4.l().i("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", false));
        setDanmuSwitchOpen(cz4.l().i("key_video_danmu_switch", true));
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
        bh.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbSingleton this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.registerScreenSizeChangeTask();
                }
            }
        });
        this.mShowVivoBadge = cz4.l().i("key_show_vivo_badge", false);
        this.mChannelConfigModel = new d45();
        this.calendar = Calendar.getInstance();
        this.isNewUserRedPackageShowed = cz4.l().i("key_task_system_new_user_popup_show_number", false);
        this.hasPerformedFirstLoginTest = cz4.l().i("has_performed_first_login_test", false);
        this.yyCloudSwitch = cz4.l().r("key_yy_cloud_switch", null);
        this.isStartStatUploadImmediately = cz4.l().m("key_switch_immediately_upload", 0) == 1;
        SpeedStats.getInstance().setSid(this.mSampleId);
        setWorldCupSponsorFlag(cz4.l().r("world_cup_sponsor_flag", ""));
    }

    private String getAdStrWithLimit() {
        InterceptResult invokeV;
        b25 b25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (StringHelper.isTaday(cz4.l().n("key_pb_falling_ad_feedback_click_time", 0L)) || (b25Var = this.mAdVertiSementConfigData) == null) {
                return "";
            }
            return b25Var.c();
        }
        return (String) invokeV.objValue;
    }

    private void getAppInstallUpdateTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                PackageInfo packageInfo = TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getPackageName(), 0);
                this.appFirstInstallTime = packageInfo.firstInstallTime;
                this.appLastUpdateTime = packageInfo.lastUpdateTime;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean getExceptInsertAdDiaShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return isExceptInsertAdDiaShow;
        }
        return invokeV.booleanValue;
    }

    public static TbSingleton getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (mInstance == null) {
                synchronized (TbSingleton.class) {
                    if (mInstance == null) {
                        mInstance = new TbSingleton();
                    }
                }
            }
            return mInstance;
        }
        return (TbSingleton) invokeV.objValue;
    }

    private void getYYSwitchStatus() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.yyCloudSwitch == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, null));
            this.yyCloudSwitch = "";
        }
    }

    public void clearVideoRecord() {
        LinkedList<kp4> linkedList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (linkedList = this.mVideoWatchTimeRecord) != null) {
            linkedList.clear();
        }
    }

    public long getActiveTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.activeTimeStamp == 0) {
                this.activeTimeStamp = cz4.l().n("key_active_timestamp", 0L);
            }
            return this.activeTimeStamp;
        }
        return invokeV.longValue;
    }

    public String getActivityId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mActivityId;
        }
        return (String) invokeV.objValue;
    }

    public String getAdVertiComment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getAdStrWithLimit();
        }
        return (String) invokeV.objValue;
    }

    public b25 getAdVertiSementData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mAdVertiSementConfigData;
        }
        return (b25) invokeV.objValue;
    }

    public int getAnimFpsSyncThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mAnimFpsSyncThreshold;
        }
        return invokeV.intValue;
    }

    public long getAppFirstInstallTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.appFirstInstallTime == 0) {
                getAppInstallUpdateTime();
            }
            return this.appFirstInstallTime;
        }
        return invokeV.longValue;
    }

    public long getAppLastUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.appLastUpdateTime == 0) {
                getAppInstallUpdateTime();
            }
            return this.appLastUpdateTime;
        }
        return invokeV.longValue;
    }

    public String getBaiduIdForAnti() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.baiduIdForAnti == null) {
                this.baiduIdForAnti = cz4.l().r("key_baiduid_for_anti", null);
            }
            return this.baiduIdForAnti;
        }
        return (String) invokeV.objValue;
    }

    public boolean getBaiduidCookieSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.isBaiduidCookieSwitch;
        }
        return invokeV.booleanValue;
    }

    public String getBannerText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mBannerText;
        }
        return (String) invokeV.objValue;
    }

    public d45 getChannelConfigModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mChannelConfigModel;
        }
        return (d45) invokeV.objValue;
    }

    public int getChatGroupThreadHold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i = this.mChatGroupThreadHold;
            if (i <= 0) {
                return 200;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public boolean getClipboardDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mClipboardDelayTime;
        }
        return invokeV.booleanValue;
    }

    public HashMap<String, u55> getColourHeaderConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mColourHeaderConfigs;
        }
        return (HashMap) invokeV.objValue;
    }

    public int getCpuFlopsDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mCpuFlopsDur < 0) {
                this.mCpuFlopsDur = cz4.l().m("cpu_flops_dura", 0);
            }
            return this.mCpuFlopsDur;
        }
        return invokeV.intValue;
    }

    public int getCpuFlopsDurationSyncThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mCpuThreshold;
        }
        return invokeV.intValue;
    }

    public long getCurrentClickTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.currentClickTime;
        }
        return invokeV.longValue;
    }

    public long getDuXiaoManActivityTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.duXiaoManActivityTimestamp == 0) {
                this.duXiaoManActivityTimestamp = cz4.l().n("key_doxiaoman_activity_timestamp", 0L);
            }
            return this.duXiaoManActivityTimestamp;
        }
        return invokeV.longValue;
    }

    public Uri getFirstOpenScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.firstOpenScheme;
        }
        return (Uri) invokeV.objValue;
    }

    public boolean getForceRefreshHomeRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mForceRefreshHomeRecommend;
        }
        return invokeV.booleanValue;
    }

    public String getFromWhichSearchSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.fromWhichSearchSource;
        }
        return (String) invokeV.objValue;
    }

    public int getFrsCurTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mFrsCurTabType;
        }
        return invokeV.intValue;
    }

    public Map<String, ItemInfo> getFrsItemInfoCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.frsItemInfoCache;
        }
        return (Map) invokeV.objValue;
    }

    public xv8 getFrsResponseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mFrsResponseData;
        }
        return (xv8) invokeV.objValue;
    }

    public Map<Long, Integer> getHasClickRedPot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mHasClickRedPot;
        }
        return (Map) invokeV.objValue;
    }

    public Map<Long, Date> getHasShowRedPot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mHasShowRedPot;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, Date> getHasShowTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mHasShowFid;
        }
        return (Map) invokeV.objValue;
    }

    public a25 getHomeAdFloatViewItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            z15 z15Var = this.adFloatViewData;
            if (z15Var != null) {
                return z15Var.a();
            }
            return null;
        }
        return (a25) invokeV.objValue;
    }

    public t25 getHomeInsertAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mHomeInsertAdData;
        }
        return (t25) invokeV.objValue;
    }

    public y55 getHomeOperateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mHomeOperateData;
        }
        return (y55) invokeV.objValue;
    }

    public List<z55> getHomePageLuckyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mHomePageLuckyConfigs;
        }
        return (List) invokeV.objValue;
    }

    public int getHomePageStyleAbTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mHomePageStyleAbTest;
        }
        return invokeV.intValue;
    }

    public List<String> getHostWhiteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mHostWhiteList;
        }
        return (List) invokeV.objValue;
    }

    public u25 getHotNotifyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.hotNotifyConfigData;
        }
        return (u25) invokeV.objValue;
    }

    public String getHotSearch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.mHotSearch;
        }
        return (String) invokeV.objValue;
    }

    public String getInvokeSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.invokeSource;
        }
        return (String) invokeV.objValue;
    }

    public Boolean getIsJumpFromVideoMiddleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return Boolean.valueOf(this.mIsJumpFromVideoMiddleView);
        }
        return (Boolean) invokeV.objValue;
    }

    public boolean getIsNeedRemindLiveRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.mIsNeedRemindLiveRoom;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsNeedReuseVideoPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mIsInNeedReuseVideoPlayer;
        }
        return invokeV.booleanValue;
    }

    public String getIsNeedShowPbCommentThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.mIsNeedShowCommentThreadId;
        }
        return (String) invokeV.objValue;
    }

    public boolean getIsOutNeedReuseVideoPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.mIsOutNeedReuseVideoPlayer;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsPushOrSchemeLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.isPushOrSchemeLog;
        }
        return invokeV.booleanValue;
    }

    public String getLFUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.mLFUser;
        }
        return (String) invokeV.objValue;
    }

    public String getLFUserTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.mLFUserTaskId;
        }
        return (String) invokeV.objValue;
    }

    public long getLastResumeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (this.lastResumeTime == 0) {
                this.lastResumeTime = cz4.l().n("last_resume_time", 0L);
            }
            return this.lastResumeTime;
        }
        return invokeV.longValue;
    }

    public ArrayList<LightEmotionData> getLightEmotionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.lightEmotionInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<AlaLiveInfo> getLiveFollowSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.liveFollowSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    public List<AlaLiveInfo> getLiveIndexSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.liveIndexSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    public int getLoopChatroomFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.mLoopChatroomFrequency;
        }
        return invokeV.intValue;
    }

    public String getLoopMsgRoomMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.mLoopRoomMsgId;
        }
        return (String) invokeV.objValue;
    }

    public c35 getMainTabPopConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.mMainTabPopConfig;
        }
        return (c35) invokeV.objValue;
    }

    public MercatorModel.MercatorData getMercatorData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.mMercatorData;
        }
        return (MercatorModel.MercatorData) invokeV.objValue;
    }

    public String getMissionEntranceIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.mMissionEntranceIcon;
        }
        return (String) invokeV.objValue;
    }

    public String getMissionEntranceObjSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.mMissionEntranceObjSource;
        }
        return (String) invokeV.objValue;
    }

    public String getMissionEntranceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.mMissionEntranceUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getModName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            sm8 sm8Var = this.mUploadAndClearModule;
            if (sm8Var == null) {
                return null;
            }
            return sm8Var.a();
        }
        return (String) invokeV.objValue;
    }

    public NewGodData getNewGodData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.mNewGodData;
        }
        return (NewGodData) invokeV.objValue;
    }

    public JSONObject getNewGodDataJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.newGodDataJson;
        }
        return (JSONObject) invokeV.objValue;
    }

    public NewUserRedPackageData getNewUserRedPackageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.mNewUserRedPackageData;
        }
        return (NewUserRedPackageData) invokeV.objValue;
    }

    public a25 getPbAdFloatViewItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            z15 z15Var = this.adFloatViewData;
            if (z15Var != null) {
                return z15Var.b();
            }
            return null;
        }
        return (a25) invokeV.objValue;
    }

    public lu4 getPbToHomeUpdateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.mPbToHomeUpdateData;
        }
        return (lu4) invokeV.objValue;
    }

    public rk8 getPcdnConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.mPcdnConfigData;
        }
        return (rk8) invokeV.objValue;
    }

    public int getPersonalizedRecSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return cz4.l().m("key_personalized_rec_switch", 1);
        }
        return invokeV.intValue;
    }

    public String getProfileGameCenterKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.mProfileGameCenterKey;
        }
        return (String) invokeV.objValue;
    }

    @Modify(description = "配置预览机pub_env参数，1=沙盒环境，2=小流量环境", type = Constants.SHORT_PING_CMD_TYPE)
    public String getPubEnvValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.mPubEnvValue;
        }
        return (String) invokeV.objValue;
    }

    public long getPushDialogLoopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.pushDialogLoopTime;
        }
        return invokeV.longValue;
    }

    public long getPushDialogShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.pushDialogShowTime;
        }
        return invokeV.longValue;
    }

    public g35 getPushStrategyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            g35 g35Var = this.pushStrategyConfig;
            if (g35Var != null) {
                return g35Var;
            }
            return g35.d;
        }
        return (g35) invokeV.objValue;
    }

    public String getPushTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.pushTid;
        }
        return (String) invokeV.objValue;
    }

    public Bundle getReloginVideoMiddleBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.reloginVideoMiddleBundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public String getSampleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.mSampleId;
        }
        return (String) invokeV.objValue;
    }

    public String getSchemaForStartOtherAppAfterSwanApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.schemaForStartOtherAppAfterSwanApp;
        }
        return (String) invokeV.objValue;
    }

    public int getSendMsgNumToRemindSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.mSendMsgCountToRemindSubscribe;
        }
        return invokeV.intValue;
    }

    public i35 getShakeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.mShakeData;
        }
        return (i35) invokeV.objValue;
    }

    public j35 getSharePanelConfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.mSharePanelConfData;
        }
        return (j35) invokeV.objValue;
    }

    public String getSharePanelText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.mSharePanelText;
        }
        return (String) invokeV.objValue;
    }

    public boolean getShowedInterestGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.showedInterestGuide;
        }
        return invokeV.booleanValue;
    }

    public h45 getSyncModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.syncModel;
        }
        return (h45) invokeV.objValue;
    }

    public TiebaPlusConfigData getTiebaPlusConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.mTiebaPlusConfigData;
        }
        return (TiebaPlusConfigData) invokeV.objValue;
    }

    public Map<String, Date> getTimeMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.mTimeMap == null) {
                this.mTimeMap = new HashMap();
            }
            return this.mTimeMap;
        }
        return (Map) invokeV.objValue;
    }

    public JSONArray getUbsABTestJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.mUbsABTestJsonArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public l35 getUpgradePopWindowConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            l35 l35Var = this.upgradePopWindowConfig;
            if (l35Var != null) {
                return l35Var;
            }
            return l35.i;
        }
        return (l35) invokeV.objValue;
    }

    public UserGrowthTaskListData getUserGrowthTaskListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (this.userGrowthTaskListData == null) {
                int m = cz4.l().m("key_person_growth_switch", 0);
                UserGrowthTaskListData userGrowthTaskListData = new UserGrowthTaskListData();
                this.userGrowthTaskListData = userGrowthTaskListData;
                userGrowthTaskListData.setGrowthSwitch(m);
            }
            return this.userGrowthTaskListData;
        }
        return (UserGrowthTaskListData) invokeV.objValue;
    }

    @Nullable
    public UserPendantData getUserPendantData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.userPendantData;
        }
        return (UserPendantData) invokeV.objValue;
    }

    public SmallTailThemeData getUserSmallTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.mSmallTailThemeData;
        }
        return (SmallTailThemeData) invokeV.objValue;
    }

    public RedIcon getVideoChannelAttentionRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.videoChannelAttentionRedIcon;
        }
        return (RedIcon) invokeV.objValue;
    }

    public RedIcon getVideoChannelRecommendRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.videoChannelRecommendRedIcon;
        }
        return (RedIcon) invokeV.objValue;
    }

    public Bitmap getVideoCurrentFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.mVideoCurrentFrame;
        }
        return (Bitmap) invokeV.objValue;
    }

    public o35 getVideoEventsConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.videoEventsConfig;
        }
        return (o35) invokeV.objValue;
    }

    public LinkedList<kp4> getVideoRecordList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.mVideoWatchTimeRecord;
        }
        return (LinkedList) invokeV.objValue;
    }

    public int getVideoRedIconInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.videoRedIconInterval;
        }
        return invokeV.intValue;
    }

    public String getVideoTestType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.videoTestType;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public p35 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            p35 p35Var = this.voiceRoomConfig;
            if (p35Var != null) {
                return p35Var;
            }
            return p35.a;
        }
        return (p35) invokeV.objValue;
    }

    public String getWalletSignLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.mWalletSignLink;
        }
        return (String) invokeV.objValue;
    }

    public r35 getWlConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.mWlConfigData;
        }
        return (r35) invokeV.objValue;
    }

    public int getWorksAddTopicMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.worksAddTopicMaxNum;
        }
        return invokeV.intValue;
    }

    public String getWorldCupSponsorFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.mWorldCupSponsorFlag;
        }
        return (String) invokeV.objValue;
    }

    public YYLiveConfig getYYLiveConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            return this.mYYLiveConfig;
        }
        return (YYLiveConfig) invokeV.objValue;
    }

    public lj9 getYYLiveTabConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.mYYLiveTabConfig;
        }
        return (lj9) invokeV.objValue;
    }

    public boolean hasAgreeToPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.mHasAgreeToPlay;
        }
        return invokeV.booleanValue;
    }

    public boolean hasDownloadEmotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.hasDownloadEmotion;
        }
        return invokeV.booleanValue;
    }

    public boolean hasPerformedFirstLoginTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.hasPerformedFirstLoginTest;
        }
        return invokeV.booleanValue;
    }

    public boolean isAuditPackageSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return this.mIsAuditPackageSwitchOn;
        }
        return invokeV.booleanValue;
    }

    public boolean isBusinessAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.isBusinessAccount;
        }
        return invokeV.booleanValue;
    }

    public boolean isCanWebViewActivityShowProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.mCanWebViewActivityShowProgress;
        }
        return invokeV.booleanValue;
    }

    public boolean isChatTabPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.isChatTabPage;
        }
        return invokeV.booleanValue;
    }

    public boolean isClearOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            sm8 sm8Var = this.mUploadAndClearModule;
            if (sm8Var == null) {
                return false;
            }
            return sm8Var.b();
        }
        return invokeV.booleanValue;
    }

    public boolean isDanmuSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.isDanmuSwitchOpen;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableBenchmark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            return this.mEnableBenchmark;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableVideoVerticalPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            return this.enableVideoVerticalPreload;
        }
        return invokeV.booleanValue;
    }

    public boolean isFirstEnterBigPicPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.isFirstEnterBigPicPage;
        }
        return invokeV.booleanValue;
    }

    public boolean isFlutterPluginLoadSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return this.mIsFlutterPluginLoadSuccess;
        }
        return invokeV.booleanValue;
    }

    public boolean isFrsLoadingViewHided() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            if (!this.mFrsRootViewLoadingShow && !this.mFrsContentViewLoadingShow) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isIsOpenTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            return this.mIsOpenTrack;
        }
        return invokeV.booleanValue;
    }

    public boolean isMercatorRequestFromHomePageTabFeedFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            return this.isMercatorRequestFromHomePageTabFeedFragment;
        }
        return invokeV.booleanValue;
    }

    public boolean isMyTabClicked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            return this.isMyTabClicked;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedJoinChatRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.isNeedJoinChatRoom;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            return this.isNewUser;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewUserRedPackageShowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            return this.isNewUserRedPackageShowed;
        }
        return invokeV.booleanValue;
    }

    public boolean isPbPreloadSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            if (SwitchManager.getInstance().findType(PbPreloadSwitch.PB_PRELOAD_SWITCH_KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRecommendPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            return this.isRecommendPage;
        }
        return invokeV.booleanValue;
    }

    public boolean isShouldShowHomeLocalCompleteInfoCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            return this.shouldShowHomeLocalCompleteInfoCard;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowConcernLiveSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            return this.isShowConcernLiveSecondFloor;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowHomeFloatRefreshButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) {
            return this.mShowHomeFloatRefreshButton;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowRecommendLiveSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return this.isShowRecommendLiveSecondFloor;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowShoubaiDynamicGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            return this.mShowShoubaiDynamicGuide;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowStartLiveEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            getYYSwitchStatus();
            if (!StringHelper.equals(this.yyCloudSwitch, "yy") && getSyncYYSwitch()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowVivoBadge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            return this.mShowVivoBadge;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowVoiceFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            return this.mIsShowVoiceFloat;
        }
        return invokeV.booleanValue;
    }

    public boolean isSlideAnimLocalSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            return cz4.l().i("local_slide_animation__switch", false);
        }
        return invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
            return this.mTipsAutoPlayInVideoChannel;
        }
        return invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoMiddle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            return this.mTipsAutoPlayInVideoMiddle;
        }
        return invokeV.booleanValue;
    }

    public boolean isUploadOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            sm8 sm8Var = this.mUploadAndClearModule;
            if (sm8Var == null) {
                return false;
            }
            return sm8Var.c();
        }
        return invokeV.booleanValue;
    }

    public boolean isUserBan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.isUserBan;
        }
        return invokeV.booleanValue;
    }

    public boolean isUserGrowthOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            if (getUserGrowthTaskListData() == null || getUserGrowthTaskListData().getGrowthSwitch() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoCardMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            return this.mIsVideoCardMute;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoChannelRelogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            return this.isVideoChannelRelogin;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否访问预览机", type = Constants.SHORT_PING_CMD_TYPE)
    public boolean isVisitPreviewServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return this.mIsVisitPreviewServer;
        }
        return invokeV.booleanValue;
    }

    public boolean isYYSwitchStatusIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            getYYSwitchStatus();
            return StringHelper.equals(this.yyCloudSwitch, "yy");
        }
        return invokeV.booleanValue;
    }

    public boolean needUploadMoreLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void registerScreenSizeChangeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            bh.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TbSingleton this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        CustomMessageTask customMessageTask = new CustomMessageTask(2921414, new CustomMessageTask.CustomRunnable<Object>(this) { // from class: com.baidu.tbadk.TbSingleton.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                                InterceptResult invokeL;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || (invokeL = interceptable3.invokeL(1048576, this, customMessage)) == null) {
                                    return new CustomResponsedMessage<>(2921414);
                                }
                                return (CustomResponsedMessage) invokeL.objValue;
                            }
                        });
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                        MessageManager.getInstance().registerTask(customMessageTask);
                    }
                }
            });
        }
    }

    public void saveHomeRecommendItemClickTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            cz4.l().y("key_home_recommend_item_click_time", System.currentTimeMillis());
        }
    }

    public void setActiveTimeStamp() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048747, this) == null) && getActiveTimeStamp() == 0) {
            cz4.l().y("key_active_timestamp", System.currentTimeMillis());
        }
    }

    private UserGrowthTaskListData.UserGrowthTaskData getUserGrowthTaskData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (getUserGrowthTaskListData() == null) {
                return null;
            }
            if (getUserGrowthTaskListData().getNoviceTask() != null) {
                for (UserGrowthTaskListData.UserGrowthTaskData userGrowthTaskData : getUserGrowthTaskListData().getNoviceTask()) {
                    if (str.equals(userGrowthTaskData.getActType())) {
                        return userGrowthTaskData;
                    }
                }
            }
            if (getUserGrowthTaskListData().getDailyTask() != null) {
                for (UserGrowthTaskListData.UserGrowthTaskData userGrowthTaskData2 : getUserGrowthTaskListData().getDailyTask()) {
                    if (str.equals(userGrowthTaskData2.getActType())) {
                        return userGrowthTaskData2;
                    }
                }
            }
            if (getUserGrowthTaskListData().getIconTask() != null) {
                for (UserGrowthTaskListData.UserGrowthTaskData userGrowthTaskData3 : getUserGrowthTaskListData().getIconTask()) {
                    if (str.equals(userGrowthTaskData3.getActType())) {
                        return userGrowthTaskData3;
                    }
                }
            }
            return null;
        }
        return (UserGrowthTaskListData.UserGrowthTaskData) invokeL.objValue;
    }

    private void initBenchmarkData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                setCpuThreshold(Integer.MAX_VALUE);
                setAnimAverageFpsThreshold(0);
                setEnableBenchmark(true);
                setAnimComputedFps("anim_switch_trans_frs", -1);
                setAnimAvgFps("anim_switch_trans_frs", 0);
                setAnimAvgFpsCount("anim_switch_trans_frs", 0);
                setAnimComputedFps("anim_switch_sendthread_maintab", -1);
                setAnimAvgFps("anim_switch_sendthread_maintab", 0);
                setAnimAvgFpsCount("anim_switch_sendthread_maintab", 0);
                setAnimComputedFps("anim_switch_slide", -1);
                setAnimAvgFps("anim_switch_slide", 0);
                setAnimAvgFpsCount("anim_switch_slide", 0);
                return;
            }
            this.mEnableBenchmark = cz4.l().i("enable_benchmark", true);
            this.mCpuThreshold = cz4.l().m("cpu_flops_dura_threshold", Integer.MAX_VALUE);
            this.mAnimFpsSyncThreshold = cz4.l().m("anim_avg_fps_threshold", 0);
        }
    }

    public static void setExceptInsertAdDiaShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            isExceptInsertAdDiaShow = z;
        }
    }

    private void setUbsSampleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            this.mSampleId = str;
        }
    }

    public boolean checkLiveForumByFid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return !StringUtils.isNull(this.liveForumMap.get(Long.valueOf(j)));
        }
        return invokeJ.booleanValue;
    }

    public String getAcceleratorServer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.mAcceleratorMap.containsKey(str)) {
                return this.mAcceleratorMap.get(str);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public int getAnimComputedFps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (yi.isEmpty(str)) {
                return -1;
            }
            return cz4.l().m(str, -1);
        }
        return invokeL.intValue;
    }

    @Nullable
    public String getRoomDraft(Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, l)) == null) {
            HashMap hashMap = this.mRoomDraft;
            if (hashMap != null && (hashMap.get(l) instanceof String)) {
                return (String) this.mRoomDraft.get(l);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String getTempString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, str)) == null) {
            return this.tempStrings.get(str);
        }
        return (String) invokeL.objValue;
    }

    public String getUserGrowthWeight(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, str)) == null) {
            UserGrowthTaskListData.UserGrowthTaskData userGrowthTaskData = getUserGrowthTaskData(str);
            if (userGrowthTaskData != null) {
                return String.valueOf(userGrowthTaskData.getWeight());
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public boolean isAnimFpsComputed(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048695, this, str)) == null) {
            if (yi.isEmpty(str) || getAnimComputedFps(str) < 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean isCutoutScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048701, this, activity)) == null) {
            if (this.mIsCutoutScreen < 0) {
                this.mIsCutoutScreen = UtilHelper.isCutoutScreen(activity) ? 1 : 0;
            }
            if (this.mIsCutoutScreen == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isNotchScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048716, this, activity)) == null) {
            if (this.mIsNotchScreen < 0) {
                this.mIsNotchScreen = UtilHelper.isNotchScreen(activity) ? 1 : 0;
            }
            if (this.mIsNotchScreen == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isUserGrowthTaskCompleted(String str) {
        InterceptResult invokeL;
        UserGrowthTaskListData.UserGrowthTaskData userGrowthTaskData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048734, this, str)) == null) {
            if (StringUtils.isNull(str) || !isUserGrowthOpen() || (userGrowthTaskData = getUserGrowthTaskData(str)) == null || userGrowthTaskData.getDotaskStatus() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void removeAcceleratorServer(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048744, this, str) == null) && this.mAcceleratorMap.containsKey(str)) {
            this.mAcceleratorMap.remove(str);
        }
    }

    public void removeTempString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, str) == null) {
            this.tempStrings.remove(str);
        }
    }

    public void setActivityId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, str) == null) {
            this.mActivityId = str;
        }
    }

    public void setAdFloatViewData(z15 z15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, z15Var) == null) {
            this.adFloatViewData = z15Var;
        }
    }

    public void setAdVertiSementData(b25 b25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, b25Var) == null) {
            this.mAdVertiSementConfigData = b25Var;
        }
    }

    public void setAnimAverageFpsThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048751, this, i) == null) {
            this.mAnimFpsSyncThreshold = i;
            cz4.l().x("anim_avg_fps_threshold", i);
        }
    }

    public void setAuditPackageSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z) == null) {
            this.mIsAuditPackageSwitchOn = z;
        }
    }

    public void setBaiduIdForAnti(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048756, this, str) == null) && cz4.l().r("key_baiduid_for_anti", null) == null) {
            cz4.l().z("key_baiduid_for_anti", str);
            this.baiduIdForAnti = str;
        }
    }

    public void setBaiduidCookieSwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048757, this, i) == null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            this.isBaiduidCookieSwitch = z;
        }
    }

    public void setBannerText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, str) == null) {
            this.mBannerText = str;
        }
    }

    public void setBusinessAccount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048760, this, z) == null) {
            this.isBusinessAccount = z;
        }
    }

    public void setCanShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048761, this, z) == null) {
            this.canShowPermDlg = z;
        }
    }

    public void setCanWebViewActivityShowProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048762, this, z) == null) {
            this.mCanWebViewActivityShowProgress = z;
        }
    }

    public void setChannelConfigModel(d45 d45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, d45Var) == null) {
            this.mChannelConfigModel = d45Var;
        }
    }

    public void setChatGroupThreadHold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048764, this, i) == null) {
            this.mChatGroupThreadHold = i;
        }
    }

    public void setChatTabPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048765, this, z) == null) {
            this.isChatTabPage = z;
        }
    }

    public void setClipboardDelayTime(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048766, this, z) == null) {
            this.mClipboardDelayTime = z;
        }
    }

    public void setColourHeaderConfig(HashMap<String, u55> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048767, this, hashMap) == null) {
            this.mColourHeaderConfigs = hashMap;
        }
    }

    public void setCpuFlopsDuration(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048768, this, i) != null) || i < 0) {
            return;
        }
        this.mCpuFlopsDur = i;
        cz4.l().x("cpu_flops_dura", i);
    }

    public void setCpuThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048769, this, i) == null) {
            this.mCpuThreshold = i;
            cz4.l().x("cpu_flops_dura_threshold", i);
        }
    }

    public void setCurrentClickTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048770, this, j) == null) {
            this.currentClickTime = j;
        }
    }

    public void setDanmuSwitchOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048771, this, z) == null) {
            this.isDanmuSwitchOpen = z;
            cz4.l().v("key_video_danmu_switch", z);
        }
    }

    public void setDuXiaoManActivityTimestamp(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048772, this, j) == null) && j != this.duXiaoManActivityTimestamp) {
            this.duXiaoManActivityTimestamp = j;
            cz4.l().y("key_doxiaoman_activity_timestamp", j);
        }
    }

    public void setEnableBenchmark(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048773, this, z) == null) {
            this.mEnableBenchmark = z;
            cz4.l().v("enable_benchmark", z);
        }
    }

    public void setEnableVideoVerticalPreload(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048774, this, z) == null) {
            this.enableVideoVerticalPreload = z;
        }
    }

    public void setFirstEnterBigPicPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048775, this, z) == null) {
            this.isFirstEnterBigPicPage = z;
        }
    }

    public void setFirstOpenScheme(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048776, this, uri) == null) {
            this.firstOpenScheme = uri;
        }
    }

    public void setFlutterPluginLoadSuccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048777, this, z) == null) {
            this.mIsFlutterPluginLoadSuccess = z;
        }
    }

    public void setForceRefreshHomeRecommend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048778, this, z) == null) {
            this.mForceRefreshHomeRecommend = z;
        }
    }

    public void setFromWhichSearchSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048779, this, str) == null) {
            this.fromWhichSearchSource = str;
        }
    }

    public void setFrsContentViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048780, this, z) == null) {
            this.mFrsContentViewLoadingShow = z;
        }
    }

    public void setFrsCurTabType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048781, this, i) == null) {
            this.mFrsCurTabType = i;
        }
    }

    public void setFrsRootViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048783, this, z) == null) {
            this.mFrsRootViewLoadingShow = z;
        }
    }

    public void setHasAgreeToPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048784, this, z) == null) {
            this.mHasAgreeToPlay = z;
        }
    }

    public void setHasClickRedPot(Map<Long, Integer> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048785, this, map) == null) {
            this.mHasClickRedPot = map;
        }
    }

    public void setHasDownloadEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048786, this, z) == null) {
            this.hasDownloadEmotion = z;
        }
    }

    public void setHasPerformedFirstLoginTest(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048787, this, z) == null) {
            this.hasPerformedFirstLoginTest = z;
            cz4.l().v("has_performed_first_login_test", z);
        }
    }

    public void setHasShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048788, this, z) == null) {
            this.hasShowPermDlg = z;
        }
    }

    public void setHasShowRedPot(Map<Long, Date> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048789, this, map) == null) {
            this.mHasShowRedPot = map;
        }
    }

    public void setHasShowTip(Map<String, Date> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048790, this, map) == null) {
            this.mHasShowFid = map;
        }
    }

    public void setHomeInsertAdData(t25 t25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, t25Var) == null) {
            this.mHomeInsertAdData = t25Var;
        }
    }

    public void setHomeOperateData(y55 y55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048792, this, y55Var) == null) {
            this.mHomeOperateData = y55Var;
        }
    }

    public void setHomePageLuckyConfig(List<z55> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, list) == null) {
            this.mHomePageLuckyConfigs = list;
        }
    }

    public void setHomePageStyleAbTest(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048794, this, i) == null) {
            this.mHomePageStyleAbTest = i;
        }
    }

    public void setHostWhiteList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048795, this, list) == null) {
            this.mHostWhiteList = list;
        }
    }

    public void setHotNotifyConfig(u25 u25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048796, this, u25Var) == null) {
            this.hotNotifyConfigData = u25Var;
        }
    }

    public void setHotSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048797, this, str) == null) {
            this.mHotSearch = str;
        }
    }

    public void setIconPopData(IconPopData iconPopData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048798, this, iconPopData) == null) {
            this.iconPopData = iconPopData;
        }
    }

    public void setInvokeSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048799, this, str) == null) {
            this.invokeSource = str;
        }
    }

    public void setIsJumpFromVideoMiddleView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048800, this, z) == null) {
            this.mIsJumpFromVideoMiddleView = z;
        }
    }

    public void setIsNeedRemindLiveRoom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048801, this, z) == null) {
            this.mIsNeedRemindLiveRoom = z;
        }
    }

    public void setIsNeedReuseVideoPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048802, this, z) == null) {
            this.mIsInNeedReuseVideoPlayer = z;
        }
    }

    public void setIsNeedShowPbCommentThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, str) == null) {
            this.mIsNeedShowCommentThreadId = str;
        }
    }

    public void setIsOpenTrack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048804, this, z) == null) {
            this.mIsOpenTrack = z;
        }
    }

    public void setIsOutNeedReuseVideoPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048805, this, z) == null) {
            this.mIsOutNeedReuseVideoPlayer = z;
        }
    }

    public void setIsRecommendPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048806, this, z) == null) {
            this.isRecommendPage = z;
        }
    }

    public void setLFUser(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048807, this, str) == null) {
            this.mLFUser = str;
        }
    }

    public void setLFUserTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048808, this, str) == null) {
            this.mLFUserTaskId = str;
        }
    }

    public void setLastResumeTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048809, this, j) == null) {
            this.lastResumeTime = j;
        }
    }

    public void setLevePopData(LevePopData levePopData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048810, this, levePopData) == null) {
            this.levePopData = levePopData;
        }
    }

    public void setLightEmotionInfo(ArrayList<LightEmotionData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048811, this, arrayList) == null) {
            this.lightEmotionInfo.clear();
            this.lightEmotionInfo.addAll(arrayList);
        }
    }

    public void setLiveFollowSecondFloor(List<AlaLiveInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048812, this, list) == null) {
            this.liveFollowSecondFloor.clear();
            this.liveFollowSecondFloor.addAll(list);
        }
    }

    public void setLiveForumMap(HashMap<Long, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, hashMap) == null) {
            this.liveForumMap = hashMap;
        }
    }

    public void setLiveIndexSecondFloor(List<AlaLiveInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048814, this, list) == null) {
            this.liveIndexSecondFloor.clear();
            this.liveIndexSecondFloor.addAll(list);
        }
    }

    public void setLoopChatroomFrequency(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048815, this, i) == null) {
            this.mLoopChatroomFrequency = i;
        }
    }

    public void setLoopMsgRoomMsgId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048816, this, str) == null) {
            this.mLoopRoomMsgId = str;
        }
    }

    public void setMainTabPopConfig(c35 c35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048817, this, c35Var) == null) {
            this.mMainTabPopConfig = c35Var;
        }
    }

    public void setMercatorData(MercatorModel.MercatorData mercatorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048818, this, mercatorData) == null) {
            this.mMercatorData = mercatorData;
        }
    }

    public void setMercatorRequestFromHomePageTabFeedFragment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048819, this, z) == null) {
            this.isMercatorRequestFromHomePageTabFeedFragment = z;
        }
    }

    public void setMissionEntranceIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048820, this, str) == null) {
            this.mMissionEntranceIcon = str;
        }
    }

    public void setMissionEntranceObjSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048821, this, str) == null) {
            this.mMissionEntranceObjSource = str;
        }
    }

    public void setMissionEntranceUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048822, this, str) == null) {
            this.mMissionEntranceUrl = str;
        }
    }

    public void setMyTabClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048823, this, z) == null) {
            this.isMyTabClicked = z;
        }
    }

    public void setNeedJoinChatRoom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048824, this, z) == null) {
            this.isNeedJoinChatRoom = z;
        }
    }

    public void setNewGodData(NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048825, this, newGodData) == null) {
            this.mNewGodData = newGodData;
        }
    }

    public void setNewGodDataJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048826, this, jSONObject) == null) {
            this.newGodDataJson = jSONObject;
        }
    }

    public void setNewUser(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048827, this, z) == null) {
            this.isNewUser = z;
        }
    }

    public void setNewUserRedPackageData(NewUserRedPackageData newUserRedPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048828, this, newUserRedPackageData) == null) {
            this.mNewUserRedPackageData = newUserRedPackageData;
        }
    }

    public void setNewUserRedPackageShowed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048829, this, z) == null) {
            this.isNewUserRedPackageShowed = z;
            cz4.l().v("key_task_system_new_user_popup_show_number", z);
        }
    }

    public void setPbToHomeUpdateData(lu4 lu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048830, this, lu4Var) == null) {
            this.mPbToHomeUpdateData = lu4Var;
        }
    }

    public void setPcdnConfigData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048831, this, jSONObject) == null) {
            if (this.mPcdnConfigData == null) {
                this.mPcdnConfigData = new rk8();
            }
            this.mPcdnConfigData.d(jSONObject);
        }
    }

    public void setProfileGameCenterKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048832, this, str) == null) {
            this.mProfileGameCenterKey = str;
        }
    }

    public void setPubEnvValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048833, this, str) == null) {
            this.mPubEnvValue = str;
        }
    }

    public void setPushDialogLoopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048834, this, j) == null) {
            this.pushDialogLoopTime = j;
        }
    }

    public void setPushDialogShowTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048835, this, j) == null) {
            this.pushDialogShowTime = j;
        }
    }

    public void setPushOrSchemeLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048836, this, z) == null) {
            this.isPushOrSchemeLog = z;
        }
    }

    public void setPushStrategyConfig(g35 g35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048837, this, g35Var) == null) {
            this.pushStrategyConfig = g35Var;
        }
    }

    public void setPushTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048838, this, str) == null) {
            this.pushTid = str;
        }
    }

    public void setReloginVideoMiddleBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048839, this, bundle) == null) {
            this.reloginVideoMiddleBundle = bundle;
        }
    }

    public void setSampleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048841, this, str) == null) {
            this.mSampleId = str;
        }
    }

    public void setSchemaForStartOtherAppAfterSwanApp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048842, this, str) == null) {
            this.schemaForStartOtherAppAfterSwanApp = str;
        }
    }

    public void setSendMsgCountToRemindSubscribe(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048843, this, i) == null) {
            this.mSendMsgCountToRemindSubscribe = i;
        }
    }

    public void setShakeData(i35 i35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048844, this, i35Var) == null) {
            this.mShakeData = i35Var;
        }
    }

    public void setSharePanelConfData(j35 j35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048845, this, j35Var) == null) {
            this.mSharePanelConfData = j35Var;
        }
    }

    public void setSharePanelText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048846, this, str) == null) {
            this.mSharePanelText = str;
        }
    }

    public void setShouldShowHomeLocalCompleteInfoCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048847, this, z) == null) {
            this.shouldShowHomeLocalCompleteInfoCard = z;
        }
    }

    public void setShowConcernLiveSecondFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048848, this, z) == null) {
            this.isShowConcernLiveSecondFloor = z;
        }
    }

    public void setShowRecommendLiveSecondFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048849, this, z) == null) {
            this.isShowRecommendLiveSecondFloor = z;
        }
    }

    public void setShowShoubaiDynamicGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048850, this, z) == null) {
            this.mShowShoubaiDynamicGuide = z;
        }
    }

    public void setShowVoiceFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048851, this, z) == null) {
            this.mIsShowVoiceFloat = z;
        }
    }

    public void setShowedInterestGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048852, this, z) == null) {
            this.showedInterestGuide = z;
        }
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048853, this, z) == null) {
            cz4.l().v("local_slide_animation__switch", z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
        }
    }

    public void setSyncModel(h45 h45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048854, this, h45Var) == null) {
            this.syncModel = h45Var;
        }
    }

    public void setSyncYYSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048855, this, z) == null) {
            this.isYYLive = Boolean.valueOf(z);
            cz4 l = cz4.l();
            l.v("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), z);
        }
    }

    public void setTiebaPlusConfigData(TiebaPlusConfigData tiebaPlusConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048857, this, tiebaPlusConfigData) == null) {
            this.mTiebaPlusConfigData = tiebaPlusConfigData;
        }
    }

    public void setTimeMap(Map<String, Date> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048858, this, map) == null) {
            this.mTimeMap = map;
        }
    }

    public void setTipsAutoPlayInVideoChannel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048859, this, z) == null) {
            this.mTipsAutoPlayInVideoChannel = z;
        }
    }

    public void setTipsAutoPlayInVideoMiddle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048860, this, z) == null) {
            this.mTipsAutoPlayInVideoMiddle = z;
        }
    }

    public void setUbsABTestJsonArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048861, this, jSONArray) == null) {
            this.mUbsABTestJsonArray = jSONArray;
        }
    }

    public void setUpgradePopWindowConfig(l35 l35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048862, this, l35Var) == null) {
            this.upgradePopWindowConfig = l35Var;
        }
    }

    public void setUploadAndClearModule(sm8 sm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048863, this, sm8Var) == null) {
            this.mUploadAndClearModule = sm8Var;
        }
    }

    public void setUserBan(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048864, this, z) == null) {
            this.isUserBan = z;
        }
    }

    public void setUserPendantData(@NonNull UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048866, this, userPendantData) == null) {
            this.userPendantData = userPendantData;
        }
    }

    public void setUserSmallTheme(SmallTailThemeData smallTailThemeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048867, this, smallTailThemeData) == null) {
            this.mSmallTailThemeData = smallTailThemeData;
        }
    }

    public void setVideoCardMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048868, this, z) == null) {
            this.mIsVideoCardMute = z;
        }
    }

    public void setVideoChannelRelogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048871, this, z) == null) {
            this.isVideoChannelRelogin = z;
        }
    }

    public void setVideoCurrentFrame(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048872, this, bitmap) == null) {
            this.mVideoCurrentFrame = bitmap;
        }
    }

    public void setVideoEventsConfig(o35 o35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048873, this, o35Var) == null) {
            o35 o35Var2 = this.videoEventsConfig;
            if (o35Var2 == null) {
                this.videoEventsConfig = o35Var;
            } else if (!o35Var2.a(o35Var)) {
                this.videoEventsConfig = o35Var;
            }
        }
    }

    public void setVideoRedIconInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048874, this, i) == null) {
            this.videoRedIconInterval = i;
        }
    }

    public void setVideoTestType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048875, this, str) == null) {
            this.videoTestType = str;
        }
    }

    public void setVisitPreviewServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048876, this, z) == null) {
            this.mIsVisitPreviewServer = z;
        }
    }

    public void setVoiceRoomConfig(@Nullable p35 p35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048877, this, p35Var) == null) {
            this.voiceRoomConfig = p35Var;
        }
    }

    public void setWalletSignLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048878, this, str) == null) {
            this.mWalletSignLink = str;
        }
    }

    public void setWlConfigData(r35 r35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048879, this, r35Var) == null) {
            this.mWlConfigData = r35Var;
        }
    }

    public void setWorksAddTopicMaxNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048880, this, i) == null) {
            this.worksAddTopicMaxNum = i;
        }
    }

    public void setWorldCupSponsorFlag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048881, this, str) == null) {
            this.mWorldCupSponsorFlag = str;
        }
    }

    public void setYYLiveConfig(YYLiveConfig yYLiveConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048882, this, yYLiveConfig) == null) {
            this.mYYLiveConfig = yYLiveConfig;
        }
    }

    public void setYYLiveTabConfig(lj9 lj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048883, this, lj9Var) == null) {
            this.mYYLiveTabConfig = lj9Var;
        }
    }

    public void setYyCloudSwitch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048884, this, str) == null) {
            this.yyCloudSwitch = str;
            cz4.l().z("key_yy_cloud_switch", str);
        }
    }

    public boolean canShowPermDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long n = cz4.l().n("key_first_enter_app_timestamp", 0L);
            if (this.canShowPermDlg && !this.hasShowPermDlg && System.currentTimeMillis() - n > 259200000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int i = this.calendar.get(1);
            int i2 = this.calendar.get(5);
            sb.append(i);
            sb.append(this.calendar.get(2) + 1);
            sb.append(i2);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean getSyncYYSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            if (this.isYYLive == null) {
                cz4 l = cz4.l();
                this.isYYLive = Boolean.valueOf(l.i("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
            }
            return this.isYYLive.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean isSlideAnimEnable() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            boolean z2 = false;
            if (cz4.l().m("slide_local_switch_is_clicked", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (cz4.l().m("sync_slide_animation__switch", 0) == 1) {
                z2 = true;
            }
            boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
            if (z) {
                return isSlideAnimLocalSwitchOn;
            }
            if (z2 != isSlideAnimLocalSwitchOn) {
                cz4.l().v("local_slide_animation__switch", z2);
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public void onAccountChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            cz4 l = cz4.l();
            this.isYYLive = Boolean.valueOf(l.i("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
        }
    }

    @NonNull
    public String getAdVertiComment(boolean z, boolean z2, @NonNull String str) {
        InterceptResult invokeCommon;
        String adStrWithLimit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (z) {
                if (z2) {
                    adStrWithLimit = getAdStrWithLimit();
                    if (StringUtils.isNull(adStrWithLimit)) {
                        return str;
                    }
                } else {
                    return str;
                }
            } else {
                adStrWithLimit = getAdStrWithLimit();
                if (StringUtils.isNull(adStrWithLimit)) {
                    return str;
                }
            }
            return adStrWithLimit;
        }
        return (String) invokeCommon.objValue;
    }

    public Integer getAnimAvgFps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (yi.isEmpty(str)) {
                return 0;
            }
            cz4 l = cz4.l();
            return Integer.valueOf(l.m(str + "_anim_benchmark_avg_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public Integer getAnimAvgFpsCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (yi.isEmpty(str)) {
                return 0;
            }
            cz4 l = cz4.l();
            return Integer.valueOf(l.m(str + "_anim_benchmark_times_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public boolean isAnimEnable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048694, this, str)) == null) {
            if (!isEnableBenchmark()) {
                return true;
            }
            if (getCpuFlopsDuration() > getCpuFlopsDurationSyncThreshold()) {
                return false;
            }
            if (!isAnimFpsComputed(str) || getAnimComputedFps(str) >= getAnimFpsSyncThreshold()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setUserGrowthTaskListData(UserGrowthTaskListData userGrowthTaskListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048865, this, userGrowthTaskListData) == null) {
            this.userGrowthTaskListData = userGrowthTaskListData;
            if (userGrowthTaskListData != null) {
                cz4.l().x("key_person_growth_switch", userGrowthTaskListData.getGrowthSwitch());
            } else {
                cz4.l().E("key_person_growth_switch");
            }
            cz4.l().v("key_person_growth_share_switch", false);
        }
    }

    public void setVideoChannelRecommendRedIcon(RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048870, this, redIcon) == null) {
            this.videoChannelRecommendRedIcon = redIcon;
            if (redIcon != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, redIcon.text));
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, ""));
            }
        }
    }

    public IconPopData getIconPopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            cz4 l = cz4.l();
            String r = l.r("key_polling_icon_change" + TbadkCoreApplication.getCurrentAccountId(), "");
            if (!StringUtils.isNull(r)) {
                this.iconPopData = (IconPopData) DataExt.toEntity(r, IconPopData.class);
            }
            if (this.iconPopData == null) {
                this.iconPopData = new IconPopData();
            }
            return this.iconPopData;
        }
        return (IconPopData) invokeV.objValue;
    }

    public LevePopData getLevePopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            cz4 l = cz4.l();
            String r = l.r("key_polling_level_change" + TbadkCoreApplication.getCurrentAccountId(), "");
            if (!StringUtils.isNull(r)) {
                this.levePopData = (LevePopData) DataExt.toEntity(r, LevePopData.class);
            }
            if (this.levePopData == null) {
                this.levePopData = new LevePopData();
            }
            return this.levePopData;
        }
        return (LevePopData) invokeV.objValue;
    }

    public void startOneGame() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048885, this) != null) || !this.mStartGameClicked) {
            return;
        }
        this.mStartGameClicked = false;
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swangame/ikyQxumlFXoxbTw4eVaZDHCGU4vSVvLI/?_baiduboxapp=%7B%22from%22%3A%221191003700000000%22%7D&callback=_bdbox_js_275&upgrade=0"));
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", "15471320").param("obj_source", "game_lauch_screen").param("obj_name", "可口大冒险").param("obj_param1", 1));
    }

    public boolean interestGuideShowCountInLimit(String str, y25 y25Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048693, this, str, y25Var)) == null) {
            if (StringUtils.isNull(str)) {
                return true;
            }
            String[] split = str.split(",");
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            for (int length = split.length - 1; length >= 0; length--) {
                try {
                    i = (int) (((((currentTimeMillis - Long.parseLong(split[length])) / 1000) / 60) / 60) / 24);
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 0;
                }
                if (i <= y25Var.c) {
                    if (i2 >= y25Var.d - 1) {
                        return false;
                    }
                    i2++;
                } else if (i2 < y25Var.d) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean isNeedShowInterestGuide() {
        InterceptResult invokeV;
        long j;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            y25 interestBoardConfigData = TbadkCoreApplication.getInst().getInterestBoardConfigData();
            if (interestBoardConfigData == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long n = cz4.l().n("key_new_user_logon_time", 0L);
            long n2 = cz4.l().n("key_home_recommend_item_click_time", 0L);
            long n3 = cz4.l().n("key_select_interest_flag", 0L);
            long n4 = cz4.l().n("key_app_launch_time", 0L);
            String r = cz4.l().r("key_interest_guide_show", "");
            boolean isSameDay = TimeHelper.isSameDay(System.currentTimeMillis() - (interestBoardConfigData.a * 86400000), n);
            boolean isTargetTimeInTimeBlock = TimeHelper.isTargetTimeInTimeBlock(n2, n, System.currentTimeMillis());
            int i = (int) (((((currentTimeMillis - n4) / 1000) / 60) / 60) / 24);
            if (isSameDay && !isTargetTimeInTimeBlock) {
                j = 0;
                if (n3 == 0) {
                    z = true;
                    if (n4 == j && i >= interestBoardConfigData.b) {
                        this.triggerInterestPanelYDaysConfig = true;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if ((!z || z2) && interestGuideShowCountInLimit(r, interestBoardConfigData) && !getShowedInterestGuide()) {
                        return true;
                    }
                    return false;
                }
            } else {
                j = 0;
            }
            z = false;
            if (n4 == j) {
            }
            z2 = false;
            if (!z) {
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void putVideoRecord(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048741, this, str, i) != null) || yi.isEmpty(str)) {
            return;
        }
        if (this.mVideoWatchTimeRecord == null) {
            this.mVideoWatchTimeRecord = new LinkedList<>();
        }
        int size = this.mVideoWatchTimeRecord.size();
        boolean z = false;
        kp4 kp4Var = null;
        int i2 = size - 1;
        int i3 = i2;
        while (true) {
            if (i3 < 0) {
                break;
            }
            kp4 kp4Var2 = this.mVideoWatchTimeRecord.get(i3);
            if (str.equals(kp4Var2.a())) {
                if (kp4Var2.b() == i) {
                    return;
                }
                if (i3 == i2) {
                    z = true;
                }
                kp4Var = kp4Var2;
            } else {
                i3--;
            }
        }
        if (kp4Var != null) {
            kp4Var.c(i);
            if (!z) {
                this.mVideoWatchTimeRecord.remove(kp4Var);
                this.mVideoWatchTimeRecord.addLast(kp4Var);
                return;
            }
            return;
        }
        kp4 kp4Var3 = new kp4(str, i);
        if (size >= 10) {
            this.mVideoWatchTimeRecord.pollFirst();
            this.mVideoWatchTimeRecord.addLast(kp4Var3);
            return;
        }
        this.mVideoWatchTimeRecord.addLast(kp4Var3);
    }

    public void recordAcceleratorServer(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048742, this, str, str2) == null) {
            this.mAcceleratorMap.put(str, str2);
        }
    }

    public void setAnimAvgFps(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048752, this, str, i) == null) && !yi.isEmpty(str) && i >= 0) {
            cz4 l = cz4.l();
            l.x(str + "_anim_benchmark_avg_suffix", i);
        }
    }

    public void setAnimAvgFpsCount(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048753, this, str, i) == null) && !yi.isEmpty(str) && i >= 0) {
            cz4 l = cz4.l();
            l.x(str + "_anim_benchmark_times_suffix", i);
        }
    }

    public void setAnimComputedFps(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048754, this, str, i) != null) || yi.isEmpty(str)) {
            return;
        }
        cz4.l().x(str, i);
        if ("anim_switch_slide".equals(str) && !isAnimEnable(str)) {
            setSlideAnimLocalSwitch(false);
        }
    }

    public void setRoomDraft(Long l, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048840, this, l, str) == null) {
            if (this.mRoomDraft == null) {
                this.mRoomDraft = new HashMap();
            }
            this.mRoomDraft.put(l, str);
        }
    }

    public void setTempString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048856, this, str, str2) == null) {
            this.tempStrings.put(str, str2);
        }
    }

    public void setBaiduidCookieSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048758, this, z) == null) {
            this.isBaiduidCookieSwitch = z;
        }
    }

    public void setFrsResponseData(xv8 xv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048782, this, xv8Var) == null) {
            this.mFrsResponseData = xv8Var;
            if (xv8Var != null && xv8Var.getForum() != null && !TextUtils.isEmpty(xv8Var.getForum().getName())) {
                if (xv8Var.itemInfo != null) {
                    this.frsItemInfoCache.put(xv8Var.getForum().getName(), xv8Var.itemInfo);
                } else {
                    this.frsItemInfoCache.remove(xv8Var.getForum().getName());
                }
            }
        }
    }

    public void setVideoChannelAttentionRedIcon(RedIcon redIcon) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048869, this, redIcon) == null) {
            if (redIcon == null && this.videoChannelAttentionRedIcon == null) {
                z = false;
            } else {
                z = true;
            }
            this.videoChannelAttentionRedIcon = redIcon;
            if (z) {
                if (redIcon != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, redIcon.text));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921578, redIcon.text));
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, ""));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921578, ""));
            }
        }
    }
}
